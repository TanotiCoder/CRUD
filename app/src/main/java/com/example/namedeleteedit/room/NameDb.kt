package com.example.namedeleteedit.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NameEntities::class], version = 1, exportSchema = false)
abstract class NameDb : RoomDatabase() {
    abstract fun nameDao(): NameDao
}