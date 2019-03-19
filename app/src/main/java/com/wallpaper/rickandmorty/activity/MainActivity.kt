package com.wallpaper.rickandmorty.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wallpaper.rickandmorty.Listener.RecyclerPostListener
import com.wallpaper.rickandmorty.Networking.CallService
import com.wallpaper.rickandmorty.Networking.RetrofitConfig
import com.wallpaper.rickandmorty.R
import com.wallpaper.rickandmorty.adapter.RecyclerAdapter
import com.wallpaper.rickandmorty.model.Post

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val posts : ArrayList<Post> by lazy{getPost()}
    private val api = RetrofitConfig.instanceClient().create<CallService>(CallService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        images_recycler.layoutManager =LinearLayoutManager(this)
        images_recycler.layoutManager=GridLayoutManager( this,2)

        images_recycler.adapter = RecyclerAdapter(posts , object : RecyclerPostListener{
            override fun onClick(post: Post, position: Int) {
                var intent = Intent(this@MainActivity ,DetailImageActivity::class.java)
                intent.putExtra("category",post.category)
                startActivity(intent)

            }

        })

        button_favorite.setOnClickListener {
            startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
        }
    }


    private fun getPost():ArrayList<Post>{
        return object :ArrayList<Post>(){
            init{
                api.getPost().enqueue(object : Callback<List<Post>> {
                    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                        for(item in response.body()!!){
                            add(Post(item.imageUrl,item.category))
                        }
                    }

                    override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                } )
            }
        }
    }

}

