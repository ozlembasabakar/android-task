package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.model.Login
import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTaskList(): Result<Unit>
    fun getAllTaskItem(authorization: String): ArrayList<TasksItem>
    fun getAllTaskFromDatabase(): Flow<List<Task>>
    suspend fun getAccessToken(raw: JsonObject): Login
}