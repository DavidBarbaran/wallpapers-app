package com.wallpaper.rickandmorty.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wallpaper.rickandmorty.R
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        ibutton_back.setOnClickListener {
            finish()
        }
    }
}
