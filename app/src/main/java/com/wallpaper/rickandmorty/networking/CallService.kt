package com.wallpaper.rickandmorty.networking

import com.wallpaper.rickandmorty.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface CallService {

    @GET("wallpapers.json")
    fun getPost(): Call<List<Post>>
}