package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val localDatasource: LocalDatasource,
) {

    fun getAllItem(): List<Item> {
        return localDatasource.items
    }
}