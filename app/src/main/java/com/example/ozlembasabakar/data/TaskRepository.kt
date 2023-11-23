package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTask(): Flow<List<Task>>
    suspend fun addTask(task: Task)

    suspend fun getAllTaskItem(): ArrayList<TasksItem>
}