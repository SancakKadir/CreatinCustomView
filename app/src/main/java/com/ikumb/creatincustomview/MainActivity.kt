package com.ikumb.creatincustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ikumb.creatincustomview.customview.DcaHorizontalCategoryList
import com.ikumb.creatincustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.categoryList.setup(
            listOf(
                DcaHorizontalCategoryList.ItemEntity(
                    0,
                    "Most Selling",
                    "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"
                ),
                DcaHorizontalCategoryList.ItemEntity(
                    1,
                    "Starters",
                    "https://images.unsplash.com/photo-1478145046317-39f10e56b5e9?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"
                ),
                DcaHorizontalCategoryList.ItemEntity(
                    2,
                    "Most Selling",
                    "https://images.unsplash.com/photo-1532980400857-e8d9d275d858?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"
                )
            )
        )


    }
}