package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.TasksItem

interface TaskRepository {
    suspend fun insertTaskList()
    suspend fun getAllTaskItem(): ArrayList<TasksItem>
}