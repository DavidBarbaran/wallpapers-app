package com.wallpaper.rickandmorty.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.wallpaper.rickandmorty.R
import com.wallpaper.rickandmorty.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_detail_image.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*


class DetailImageActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)

        var bottomsheetLayout = findViewById<LinearLayout>(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottomsheetLayout)


        ibutton_back.setOnClickListener {
                finish()
        }

        recycler_moreimages.layoutManager = LinearLayoutManager(this)
        recycler_moreimages.layoutManager= GridLayoutManager( this,2)
        recycler_moreimages.adapter = RecyclerAdapter()

    }
}
