package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.database.ItemLocalDatasource
import com.example.ozlembasabakar.model.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ItemRepositoryImpl @Inject constructor(
    private val itemLocalDatasource: ItemLocalDatasource,
) : ItemRepository {

    override fun getAllItems(): Flow<List<Item>> {
        return itemLocalDatasource.getAllItems()
    }

    override suspend fun addItems(item: Item) {
        itemLocalDatasource.addItems(item)
    }
}