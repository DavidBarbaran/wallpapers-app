package com.wallpaper.rickandmorty.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.wallpaper.rickandmorty.activity.DetailImageActivity
import com.wallpaper.rickandmorty.model.Post
import com.wallpaper.rickandmorty.R


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var items:ArrayList<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) items.size else 20
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       init {
           itemView.setOnClickListener {
               val intent = Intent(itemView.context, DetailImageActivity::class.java)
               itemView.context.startActivity(intent)
           }
       }
    }
}