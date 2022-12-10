package com.example.namedeleteedit.repository

import com.example.namedeleteedit.core.names
import com.example.namedeleteedit.room.NameDao
import com.example.namedeleteedit.room.NameEntities
import kotlinx.coroutines.flow.Flow

class NameRepositoryImpl(private val nameDao: NameDao) : NameRepository {
    override fun getNamesFromRoom(): Flow<names> {
        return nameDao.getNames()
    }

    override fun getNameFrom(id: Int): NameEntities {
        return nameDao.getName(id)
    }

    override suspend fun addNameInRoom(nameEntities: NameEntities) {
        return nameDao.addName(nameEntities)
    }

    override suspend  fun deleteNameFromRoom(nameEntities: NameEntities) {
        return nameDao.deleteName(nameEntities)
    }

    override suspend  fun updateNameInRoom(nameEntities: NameEntities) {
        return nameDao.updateName(nameEntities)
    }
}