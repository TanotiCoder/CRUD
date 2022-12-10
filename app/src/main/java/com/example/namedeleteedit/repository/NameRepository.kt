package com.example.namedeleteedit.repository

import com.example.namedeleteedit.core.names
import com.example.namedeleteedit.room.NameEntities
import kotlinx.coroutines.flow.Flow

interface NameRepository {
    fun getNamesFromRoom(): Flow<names>
    fun getNameFrom(id: Int): NameEntities
    suspend fun addNameInRoom(nameEntities: NameEntities)
    suspend fun deleteNameFromRoom(nameEntities: NameEntities)
    suspend fun updateNameInRoom(nameEntities: NameEntities)
}