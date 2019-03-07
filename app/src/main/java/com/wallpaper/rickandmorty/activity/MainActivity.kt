package com.wallpaper.rickandmorty.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wallpaper.rickandmorty.R
import com.wallpaper.rickandmorty.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        images_recycler.layoutManager =LinearLayoutManager(this)
        images_recycler.layoutManager=GridLayoutManager( this,2)
        images_recycler.adapter = RecyclerAdapter()

        button_favorite.setOnClickListener {
            startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
        }
    }
}
