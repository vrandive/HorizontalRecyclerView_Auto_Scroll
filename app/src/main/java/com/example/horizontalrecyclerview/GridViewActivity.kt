package com.example.horizontalrecyclerview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class GridViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
   private var arrayList: ArrayList<list_data>? = null
    private var gridView: GridView? = null
    private var listdata: GridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        gridView = findViewById(R.id.gridview)
        arrayList = ArrayList()
        arrayList = setDataList()
        listdata = GridAdapter(applicationContext, arrayList!!)
        gridView?.adapter = listdata
        gridView?.onItemClickListener = this

    }

    private fun setDataList(): ArrayList<list_data>{
        var arrayList: ArrayList<list_data> = ArrayList()
        arrayList.add(list_data(R.drawable.d1,"Vidit Aatrey "))
        arrayList.add(list_data(R.drawable.d2,"Rajat Kumar Kedia"))
        arrayList.add(list_data(R.drawable.d3, "Rajesh Begur"))
        arrayList.add(list_data(R.drawable.d4, "Neeraj Goneka"))
        arrayList.add(list_data(R.drawable.d5, "Anurag Sinha"))
        arrayList.add(list_data(R.drawable.d6,"Ashish Mohapatra"))
        arrayList.add(list_data(R.drawable.d7,"Varun Dua"))
        arrayList.add(list_data(R.drawable.d8,"Suhail Sameer"))
        arrayList.add(list_data(R.drawable.d9,"Revant Bhate"))

        return arrayList

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        var items: list_data = arrayList!!.get(p2)

    }
}
