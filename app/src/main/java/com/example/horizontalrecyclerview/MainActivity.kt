package com.example.horizontalrecyclerview

//import GridViewActivity
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.activity_main.view.*
import androidx.recyclerview.widget.LinearSmoothScroller as LinearSmoothScroller



class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()



        val button = findViewById<Button>(R.id.btn1)
        button.setOnClickListener{
            val intent: Intent = Intent(this@MainActivity, GridViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.popup, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.changetheme->{
                chooseThemeDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("System default","Light","Dark")
        val checkedItem = MyPreferences(this).darkMode


        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    MyPreferences(this).darkMode = 0
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    MyPreferences(this).darkMode = 1
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    MyPreferences(this).darkMode = 2
                    delegate.applyDayNight()
                    dialog.dismiss()
                }


            }

        }

        val dialog = builder.create()
        dialog.show()
    }

    // Retrieve and Add data to the Recycler View
   private fun addDataSet(){
        val list = ArrayList<String>()
        list.add("https://www.dezerv.in/static/media/1)Ramakant.7bd04a87.png")
        list.add("https://www.dezerv.in/static/media/2)Kunal.1c2ab8e2.png")
        list.add("https://www.dezerv.in/static/media/3)Nitin.8dd1a8c9.png")
        list.add("https://www.dezerv.in/static/media/4)Anurag.40b3f5e9.png")
        list.add("https://www.dezerv.in/static/media/5)Ruchi.a7904178.png")
        list.add("https://www.dezerv.in/static/media/6)Asish.bec8cb70.png")
        list.add("https://www.dezerv.in/static/media/7)Vidit.d15364c2.png")
        list.add("https://www.dezerv.in/static/media/8)Sanjeev.2f99c190.png")
        list.add("https://www.dezerv.in/static/media/9)VarunDUa.029c0522.png")

        listAdapter.submitList(list)
    }

    // Setup Recycler View
    private fun initRecyclerView() {
        recycler_view.apply {

            layoutManager = llManager
            listAdapter = RecyclerViewAdapter()
            adapter = listAdapter
            setHasFixedSize(true)
        }
        handler.postDelayed(runnable, scroll.toLong())
    }

    private val llManager: LinearLayoutManager = object : LinearLayoutManager(this,
        HORIZONTAL, false) {
        override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State,
                                            position: Int) {
            val smoothScroller: LinearSmoothScroller =
                object : LinearSmoothScroller(this@MainActivity) {
                    private val SPEED = 3000f // Change this value (default=25f)
                    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                        return SPEED
                    }
                }
            smoothScroller.targetPosition = position
            startSmoothScroll(smoothScroller)
        }
    }

    private val handler = Handler()
    private val scroll = 0
    private val runnable = object : Runnable {
        var count = 0
        override fun run() {
            if (count == recycler_view.adapter?.itemCount) count = 0
            if (count < recycler_view.adapter?.itemCount?:-1) {
                recycler_view.smoothScrollToPosition(++count)
                handler.postDelayed(this, scroll.toLong())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, scroll.toLong())
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

}




















