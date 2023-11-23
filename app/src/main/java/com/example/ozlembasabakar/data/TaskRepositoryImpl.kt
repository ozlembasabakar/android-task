package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.database.TaskLocalDatasource
import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import com.example.ozlembasabakar.network.TaskRemoteDataSource
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskLocalDatasource: TaskLocalDatasource,
    private val taskRemoteDataSource: TaskRemoteDataSource,
) : TaskRepository {

    override suspend fun insertTaskList() {
        val response = taskRemoteDataSource.getAllTaskItem().take((0..30).random()).map{
            Task(
                id = it.description?.length.toString(),
                title = it.title.toString(),
                task = it.task.toString(),
                description = it.description.toString(),
                colorCode = it.colorCode.toString()
            )
        }
        taskLocalDatasource.insertTaskList(response as ArrayList<Task>)
    }

    override suspend fun getAllTaskItem(): ArrayList<TasksItem> {
        return taskRemoteDataSource.getAllTaskItem()
    }
}