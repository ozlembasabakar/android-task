package com.example.ozlembasabakar.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ozlembasabakar.database.dao.ItemDao
import com.example.ozlembasabakar.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}