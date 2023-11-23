package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.database.ItemLocalDatasource
import com.example.ozlembasabakar.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskLocalDatasource: ItemLocalDatasource,
) : TaskRepository {

    override fun getAllTask(): Flow<List<Task>> {
        return taskLocalDatasource.getAllTask()
    }

    override suspend fun addTask(task: Task) {
        return taskLocalDatasource.addTask(task)
    }
}