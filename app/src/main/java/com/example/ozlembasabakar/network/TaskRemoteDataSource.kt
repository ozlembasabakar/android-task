package com.example.ozlembasabakar.network

import com.example.ozlembasabakar.BuildConfig
import com.example.ozlembasabakar.model.Login
import com.example.ozlembasabakar.model.TasksItem
import com.google.gson.JsonObject
import javax.inject.Inject

class TaskRemoteDataSource @Inject constructor(
    private val retrofitNetworkApi: RetrofitNetworkApi,
) {

    suspend fun getAllTaskItem(): ArrayList<TasksItem> {
        return retrofitNetworkApi.getAllTaskItem(getAuthenticationCodeToGetAllTask())
    }

    suspend fun getAccessToken(raw: JsonObject): Login {
        return retrofitNetworkApi.getAccessToken(raw)
    }

    private suspend fun getAuthenticationCodeToGetAllTask(): String {
        val param = JsonObject().apply {
            addProperty("username", BuildConfig.username)
            addProperty("password", BuildConfig.password)
        }

        val tokenType = getAccessToken(param).oauth?.token_type
        val accessToken = getAccessToken(param).oauth?.access_token

        return "$tokenType $accessToken"
    }
}