package com.example.myapplication.networking.authentication

import android.util.Log
import com.example.myapplication.networking.authentication.responese.authResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationModel {
    private val authenticationApi: AuthenticationApi = RetrofitClient.createService()

    fun authentication(email:String, password:String){
        var requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .build()
        authenticationApi.authentication("1.0.0", requestBody)
            .enqueue(object : Callback<authResponse>{
                override fun onResponse(
                    call: Call<authResponse>,
                    response: Response<authResponse>
                ) {
                    Log.d("response", "response is - \n " +response.body())
                }

                override fun onFailure(call: Call<authResponse>, t: Throwable) {
                    Log.d("responseFailed", "response failed ")

                }

            })
    }
}