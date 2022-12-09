package com.example.namedeleteedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.namedeleteedit.repository.NameRepository
import com.example.namedeleteedit.room.NameEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NameViewModel @Inject constructor(private val nameRepository: NameRepository) : ViewModel() {
    var nameState by mutableStateOf(NameEntities(0, ""))
        private set
    var dialogState by mutableStateOf(false)
    var names = nameRepository.getNamesFromRoom()

    fun addName(nameEntities: NameEntities) {
        viewModelScope.launch(Dispatchers.IO) {
            nameRepository.addNameInRoom(nameEntities)
        }
    }

    fun deleteName(nameEntities: NameEntities) {
        viewModelScope.launch(Dispatchers.IO) {
            nameRepository.deleteNameFromRoom(nameEntities)
        }
    }

    fun getName(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            nameState = nameRepository.getNameFrom(id)
        }
    }

    fun updateName(){
        viewModelScope.launch(Dispatchers.IO){
            nameRepository.updateNameInRoom(nameState)
        }
    }

    fun openDialog() {
        dialogState = true
    }

    fun closeDialog() {
        dialogState = false
    }
    fun updateNameName(name:String){
        nameState = nameState.copy(name = name)
    }
}