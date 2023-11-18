package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val localDatasource: LocalDatasource,
) {

    fun getAllItem(): Flow<List<Item>> {
        return localDatasource.items
    }
}