package com.wallpaper.rickandmorty.Listener

import com.wallpaper.rickandmorty.model.Post

interface RecyclerPostListener {
    fun onClick(post: Post , position: Int)
}