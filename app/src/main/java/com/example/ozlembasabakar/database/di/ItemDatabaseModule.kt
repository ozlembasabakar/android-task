package com.example.ozlembasabakar.database.di

import android.content.Context
import androidx.room.Room
import com.example.ozlembasabakar.database.database.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ItemDatabaseModule {
    @Provides
    @Singleton
    fun provideItemDatabase(@ApplicationContext appContext: Context): ItemDatabase {
        return Room.databaseBuilder(
            appContext,
            ItemDatabase::class.java,
            "ItemDatabase",
        )
            .build()
    }
}