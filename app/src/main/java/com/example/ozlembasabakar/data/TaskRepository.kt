package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTask(): Flow<List<Task>>
    suspend fun addTask(task: Task)
}