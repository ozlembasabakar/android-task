package com.example.ozlembasabakar.database

import com.example.ozlembasabakar.database.dao.TaskDao
import com.example.ozlembasabakar.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskLocalDatasource @Inject constructor(
    private val taskDao: TaskDao,
) {

    fun getAllTask(): Flow<List<Task>> {
        return taskDao.getAllTask()
    }

    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }
}