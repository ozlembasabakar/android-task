package com.example.ozlembasabakar.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()

        val request: Request = original.newBuilder()
            .header("Authorization", "Bearer 6873a3d2b3483e637aa4fe0502d6bccc6a7017dd")
            .header("Content-Type", "application/json")
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }
}