package com.wallpaper.rickandmorty.Networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    private lateinit var retrofit: Retrofit
    private val url:String= "https://wallpaper-app-9a22c.firebaseio.com/"

    fun instanceClient():Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}