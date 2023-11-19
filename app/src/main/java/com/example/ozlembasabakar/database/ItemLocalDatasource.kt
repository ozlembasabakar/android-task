package com.example.ozlembasabakar.database

import com.example.ozlembasabakar.database.dao.ItemDao
import com.example.ozlembasabakar.model.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemLocalDatasource @Inject constructor(
    private val itemDao: ItemDao
) {

    fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    suspend fun addItems(item: Item) {
        itemDao.addItems(item)
    }
}