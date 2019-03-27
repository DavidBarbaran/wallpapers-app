package com.wallpaper.rickandmorty.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.drawee.backends.pipeline.Fresco
import com.wallpaper.rickandmorty.listener.RecyclerPostListener
import com.wallpaper.rickandmorty.networking.CallService
import com.wallpaper.rickandmorty.networking.RetrofitConfig
import com.wallpaper.rickandmorty.R
import com.wallpaper.rickandmorty.adapter.RecyclerAdapter
import com.wallpaper.rickandmorty.model.Post

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api = RetrofitConfig.instanceClient().create<CallService>(CallService::class.java)
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this);
        setContentView(R.layout.activity_main)
        initView()
        initService()
    }

    private fun initView() {
        images_recycler.layoutManager = LinearLayoutManager(this)
        images_recycler.layoutManager = GridLayoutManager(this, 2)
        adapter = RecyclerAdapter(object : RecyclerPostListener {
            override fun onClick(post: Post, position: Int) {
                var intent = Intent(this@MainActivity, DetailImageActivity::class.java)
                intent.putExtra("imageUrl", post.imageUrl)
                startActivity(intent)
            }
        })
        images_recycler.adapter = adapter

        button_favorite.setOnClickListener {
            startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
        }
    }

    private fun initService() {
        api.getPost().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    adapter.items = response.body()!!
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}