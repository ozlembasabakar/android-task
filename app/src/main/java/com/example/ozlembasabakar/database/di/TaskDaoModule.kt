package com.example.ozlembasabakar.database.di

import com.example.ozlembasabakar.database.dao.TaskDao
import com.example.ozlembasabakar.database.database.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class TaskDaoModule {
    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }
}