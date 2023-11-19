package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItems(): Flow<List<Item>>
    suspend fun addItems(item: Item)
}