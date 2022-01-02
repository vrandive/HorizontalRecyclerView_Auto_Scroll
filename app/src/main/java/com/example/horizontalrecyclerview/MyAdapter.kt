package com.example.horizontalrecyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop

class GridAdapter(var context: Context, var arraylist: ArrayList<list_data>) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var view: View = View.inflate(context, R.layout.grid_data, null)
            var listItem: list_data = arraylist.get(position)

            val img: ImageView = view.findViewById(R.id.icon_image)
            img.setImageResource(listItem.image_data!!)
            img.scaleType = ImageView.ScaleType.FIT_XY
            //img.layoutParams = ViewGroup.LayoutParams(500, 400)

            val txt: TextView= view.findViewById(R.id.icon_text)
            txt.text = listItem.name
            txt.textAlignment = TextView.TEXT_ALIGNMENT_CENTER

            img.setOnClickListener {
                val intent = Intent(parent?.context, FullScreen::class.java)
                intent.putExtra("imgID", listItem.image_data )
                parent?.context?.startActivity(intent)
            }

        return view
    }

    override fun getItem(position: Int): Any {
        return arraylist.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arraylist.size
    }
}
