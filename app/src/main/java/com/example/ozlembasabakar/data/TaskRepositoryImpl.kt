package com.example.ozlembasabakar.data

import com.example.ozlembasabakar.database.TaskLocalDatasource
import com.example.ozlembasabakar.model.Login
import com.example.ozlembasabakar.model.Task
import com.example.ozlembasabakar.model.TasksItem
import com.example.ozlembasabakar.network.TaskRemoteDataSource
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskLocalDatasource: TaskLocalDatasource,
    private val taskRemoteDataSource: TaskRemoteDataSource,
) : TaskRepository {

    override suspend fun insertTaskList(): Result<Unit> {
        return try {
            val response = taskRemoteDataSource.getAllTaskItem().map {
                Task(
                    id = it.description?.length.toString(),
                    title = it.title.toString(),
                    task = it.task.toString(),
                    description = it.description.toString(),
                    colorCode = it.colorCode.toString()
                )
            }
            taskLocalDatasource.insertTaskList(response)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getAllTaskItem(authorization: String): ArrayList<TasksItem> {
        var taskList = arrayListOf<TasksItem>()
        CoroutineScope(Dispatchers.IO).launch {
            taskList = taskRemoteDataSource.getAllTaskItem()
        }
        return taskList
    }

    override fun getAllTaskFromDatabase(): Flow<List<Task>> {
        val taskList: Flow<List<Task>> = taskLocalDatasource.getAllTask()
        return taskList
    }

    override suspend fun getAccessToken(raw: JsonObject): Login {
        return taskRemoteDataSource.getAccessToken(raw)
    }
}