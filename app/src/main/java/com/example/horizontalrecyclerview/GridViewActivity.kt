package com.example.horizontalrecyclerview

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_grid_view.*


class GridViewActivity : AppCompatActivity() {
    var list = listOf(
        R.drawable.d1,
        R.drawable.d2,
        R.drawable.d3,
        R.drawable.d4,
        R.drawable.d5,
        R.drawable.d6,
        R.drawable.d7,
        R.drawable.d8,
        R.drawable.d9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        gridview.adapter= GridAdapter(list)
    }
}