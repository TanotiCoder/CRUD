package com.example.namedeleteedit.room

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.example.namedeleteedit.core.Common.Companion.tableName
import com.example.namedeleteedit.core.names
import kotlinx.coroutines.flow.Flow


@Dao
interface NameDao {
    @Query("SELECT * FROM $tableName ORDER BY id ASC")
    fun getNames(): Flow<names>

    @Query("SELECT * FROM $tableName WHERE id = :id")
    fun getName(id: Int): NameEntities

    @Delete()
    fun deleteName(nameEntities: NameEntities)

    @Insert(onConflict = IGNORE)
    fun addName(nameEntities: NameEntities)

    @Update
    fun updateName(nameEntities: NameEntities)
}