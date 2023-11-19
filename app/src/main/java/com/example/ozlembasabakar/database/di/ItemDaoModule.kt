package com.example.ozlembasabakar.database.di

import com.example.ozlembasabakar.database.dao.ItemDao
import com.example.ozlembasabakar.database.database.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ItemDaoModule {
    @Provides
    fun provideItemDao(itemDatabase: ItemDatabase): ItemDao {
        return itemDatabase.itemDao()
    }
}