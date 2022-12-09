package com.example.namedeleteedit.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.namedeleteedit.core.Common.Companion.tableName

@Entity(tableName = tableName)
data class NameEntities(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String
)
