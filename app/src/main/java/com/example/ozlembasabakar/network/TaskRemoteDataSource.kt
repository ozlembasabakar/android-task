package com.example.ozlembasabakar.network

import com.example.ozlembasabakar.model.TasksItem
import javax.inject.Inject

class TaskRemoteDataSource @Inject constructor(
    private val retrofitNetworkApi: RetrofitNetworkApi,
) {

    suspend fun getAllTaskItem(): ArrayList<TasksItem> {
        return retrofitNetworkApi.getAllTaskItem()
    }
}