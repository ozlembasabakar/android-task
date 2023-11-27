package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTaskList(): Result<Unit>
    fun getAllTaskItem(): ArrayList<TasksItem>
    fun getAllTaskFromDatabase(): Flow<List<Task>>
}