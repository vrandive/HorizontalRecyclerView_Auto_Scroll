package com.example.horizontalrecyclerview

import android.content.Context
import android.widget.ListAdapter

class list_data {

    var image_data: Int? = 0
    var name: String? = null

    constructor(image_data: Int?, name: String?){

        this.image_data = image_data
        this.name = name

    }

}