package com.wallpaper.rickandmorty.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.wallpaper.rickandmorty.R
import com.wallpaper.rickandmorty.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_detail_image.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.item_recycler.view.*


class DetailImageActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_detail_image)
        initView()


        var bottomsheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottomsheetLayout)

        ibutton_back.setOnClickListener {
                finish()
        }

    }
    fun initView(){
        val image = intent.getStringExtra("imageUrl")
        var uri = Uri.parse(image)
        val draweeView = detail_layout as SimpleDraweeView
        draweeView.setImageURI(uri)


        //recycler_moreimages.layoutManager = LinearLayoutManager(this)
        //recycler_moreimages.layoutManager= GridLayoutManager( this,2)
        //recycler_moreimages.adapter = RecyclerAdapter()
    }
}
