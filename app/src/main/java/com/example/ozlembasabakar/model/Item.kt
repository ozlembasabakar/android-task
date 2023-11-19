package com.example.ozlembasabakar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val task: String = "",
    val description: String = "",
    val colorCode: Int = 0,
)