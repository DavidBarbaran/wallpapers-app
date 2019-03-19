package com.wallpaper.rickandmorty.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wallpaper.rickandmorty.Listener.RecyclerPostListener
import com.wallpaper.rickandmorty.activity.DetailImageActivity
import com.wallpaper.rickandmorty.model.Post
import com.wallpaper.rickandmorty.R
import kotlinx.android.synthetic.main.item_recycler.view.*


class RecyclerAdapter(private val items:List<Post>,private val listener: RecyclerPostListener):
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post ,listener: RecyclerPostListener) = with(itemView){
            Picasso.get().load(post.imageUrl).into(post_image)

            //Click evento desde la Interfaz ( Listener )
            setOnClickListener{listener.onClick(post,adapterPosition)}
        }
    }
}