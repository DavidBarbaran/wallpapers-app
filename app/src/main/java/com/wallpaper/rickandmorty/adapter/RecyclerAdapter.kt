package com.wallpaper.rickandmorty.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView

import com.wallpaper.rickandmorty.Listener.RecyclerPostListener
import com.wallpaper.rickandmorty.model.Post
import com.wallpaper.rickandmorty.R
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter(private val listener: RecyclerPostListener):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var items:List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) items.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post ,listener: RecyclerPostListener) = with(itemView){
            val uri = Uri.parse(post.imageUrl)
            val draweeView = post_image as SimpleDraweeView
            draweeView.setImageURI(uri)

            //Click evento desde la Interfaz ( Listener )
            setOnClickListener{listener.onClick(post,adapterPosition)}
        }
    }
}