package com.example.myapplication.networking.authentication

import com.example.myapplication.networking.authentication.responese.authResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface AuthenticationApi {
    @POST("api/token/sourcing")
    fun authentication(
        @Header("X-LEADR-APKVERSION") version: String,
        @Body requestBody: RequestBody
    ): Call<authResponse>
}

/*
var requestBody: RequestBody = MultipartBody.Builder()
    .setType(MultipartBody.FORM)
    .addFormDataPart("param1", param1)
    .addFormDataPart("param2", param2)
    .build()*/
