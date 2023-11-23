package com.example.ozlembasabakar.network

import com.example.ozlembasabakar.model.TasksItem
import retrofit2.http.GET


const val END_POINT_ALL_TASKS = "dev/index.php/v1/tasks/select"

interface RetrofitNetworkApi {

    @GET(END_POINT_ALL_TASKS)
    suspend fun getAllTaskItem(): ArrayList<TasksItem>
}