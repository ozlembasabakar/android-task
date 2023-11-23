package com.example.ozlembasabakar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey val id: Int = 0,
    val title: String,
    val task: String,
    val description: String,
    val colorCode: String,
)
