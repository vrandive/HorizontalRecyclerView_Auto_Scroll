package com.example.horizontalrecyclerview

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.view.marginTop

class GridAdapter(private val list: List<Int>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val img = ImageView(parent?.context)
        img.setImageResource(getItem(position))
        img.scaleType = ImageView.ScaleType.FIT_XY
        img.layoutParams = ViewGroup.LayoutParams(500,400)

        img.setOnClickListener {
            val intent = Intent(parent?.context, FullScreen::class.java)
            intent.putExtra("imgID" , getItem(position))
            parent?.context?.startActivity(intent)
        }

        return img
    }

    override fun getItem(position: Int): Int = list[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = list.size
}
