package com.example.ozlembasabakar.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ozlembasabakar.database.dao.TaskDao
import com.example.ozlembasabakar.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}