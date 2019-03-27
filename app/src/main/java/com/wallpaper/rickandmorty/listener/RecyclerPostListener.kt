package com.wallpaper.rickandmorty.listener

import com.wallpaper.rickandmorty.model.Post

interface RecyclerPostListener {
    fun onClick(post: Post , position: Int)
}