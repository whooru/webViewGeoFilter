package com.example.webviewgeofilter

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
//https://ipapi.co/100.73.2.238/country_name
interface IpInfoService{
//    @GET("country")
//    fun getCountry(@Path("ip") ip: String): Call<String>

    @GET("json")
    fun getCountry(): Call<Country>

}