package com.example.ozlembasabakar.network

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {

        val gson = GsonBuilder().create()
        val headerInterceptor = HeaderInterceptor()

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.baubuddy.de/")
            .client(httpClient.build())
    }

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): RetrofitNetworkApi {
        return builder
            .build()
            .create(RetrofitNetworkApi::class.java)
    }
}