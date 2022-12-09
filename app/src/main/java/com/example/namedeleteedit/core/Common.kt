package com.example.namedeleteedit.core

import com.example.namedeleteedit.room.NameEntities

class Common {
    companion object {
        const val tableName = "nameList"
        const val rename = "Rename"
        const val typeSomething = "Type Something...."
        const val addName = "Add Name"
        const val working = "Working"
        const val done = "Done"
        const val cancel = "Cancel"
        const val label = "CRUD Room Database example"
        const val label2 = "Create, Read, Update & Delete"
    }
}

typealias names = List<NameEntities>