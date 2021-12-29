package com.example.horizontalrecyclerview

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_layout.view.*


class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            // Instantiate XML to the View
            LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

       when(holder) {
           is PostViewHolder -> {
               holder.bind(items[position%items.size])  // Bond data to the View Holder
               Log.d(TAG, "Value= ${(position%items.size).toString()}")
           }
       }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE //Infinite display of Images
    }

   fun submitList(postlist: ArrayList<String>){
        items = postlist
    }

    //ViewHolder to decide what views would look like in the Recycler View
    class PostViewHolder  constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        private val postimage: ImageView = itemView.post_image

        fun bind(img: String){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context) //Glide used for loading images
                .applyDefaultRequestOptions(requestOptions)
                .load(img) //image url pointing at image
                .into(postimage) //where to load the image
        }
    }

}

