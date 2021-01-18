package com.example.webviewgeofilter

class Common {
    private val BASE_URL = "https://ipapi.co/"
    val retrofitServices: IpInfoService
        get() = RetrofitClient().getClient(BASE_URL).create(IpInfoService::class.java)
}