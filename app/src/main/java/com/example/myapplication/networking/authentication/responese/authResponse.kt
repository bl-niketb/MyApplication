package com.example.myapplication.networking.authentication.responese

data class authResponse(
    val allowed_dates: List<Any>,
    val apkName: String,
    val apkURl: String
)