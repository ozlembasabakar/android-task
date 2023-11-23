package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.database.TaskLocalDatasource
import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import com.example.ozlembasabakar.network.TaskRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskLocalDatasource: TaskLocalDatasource,
    private val taskRemoteDataSource: TaskRemoteDataSource,
) : TaskRepository {

    override fun getAllTask(): Flow<List<Task>> {
        return taskLocalDatasource.getAllTask()
    }

    override suspend fun addTask(task: Task) {
        return taskLocalDatasource.addTask(task)
    }

    override suspend fun getAllTaskItem(): ArrayList<TasksItem> {
        return taskRemoteDataSource.getAllTaskItem()
    }
}