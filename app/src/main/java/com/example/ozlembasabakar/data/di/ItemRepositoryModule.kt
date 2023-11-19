package com.example.ozlembasabakar.data.di

import com.example.ozlembasabakar.data.ItemRepository
import com.example.ozlembasabakar.data.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ItemRepositoryModule {

    @Binds
    abstract fun bindItemRepository(
        itemRepositoryImpl: ItemRepositoryImpl,
    ): ItemRepository
}