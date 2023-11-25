package com.example.ozlembasabakar.network

import com.example.ozlembasabakar.BuildConfig
import com.example.ozlembasabakar.model.Login
import com.example.ozlembasabakar.model.TasksItem
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


const val END_POINT_ALL_TASKS = "dev/index.php/v1/tasks/select"
const val END_POINT_LOGIN = "index.php/login"

interface RetrofitNetworkApi {


    @POST(END_POINT_LOGIN)
    @Headers(
        "Authorization: ${BuildConfig.AUTHORIZATION}",
        "Content-Type: application/json"
    )
    suspend fun getAccessToken(
        @Body raw: JsonObject,
    ): Login


    @GET(END_POINT_ALL_TASKS)
    suspend fun getAllTaskItem(
        @Header("Authorization") authorization: String
    ): ArrayList<TasksItem>
}