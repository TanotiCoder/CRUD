package com.example.namedeleteedit.repository

import com.example.namedeleteedit.core.names
import com.example.namedeleteedit.room.NameEntities
import kotlinx.coroutines.flow.Flow

interface NameRepository {
    fun getNamesFromRoom(): Flow<names>
    fun getNameFrom(id: Int): NameEntities
    fun addNameInRoom(nameEntities: NameEntities)
    fun deleteNameFromRoom(nameEntities: NameEntities)
    fun updateNameInRoom(nameEntities: NameEntities)
}