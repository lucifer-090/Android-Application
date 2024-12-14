package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.RecycleViewAdapter

class RecycleViewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList = ArrayList<Int>()
    val nameList = ArrayList<String>()
    val descList = ArrayList<String>()

    lateinit var adapter: RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        recyclerView = findViewById(R.id.recycleView)
        imageList.add(R.drawable.iimage)
        imageList.add(R.drawable.imagee)
        imageList.add(R.drawable.imageee)

        nameList.add("Beautiful View")
        nameList.add("Fictional Infinity")
        nameList.add("FitBeing Gym")

        descList.add("But Not From Earth")
        descList.add("Infinity is great")
        descList.add("Where Fitness Becomes a Lifestyle")

        adapter = RecycleViewAdapter(
            this@RecycleViewActivity,
            imageList, nameList, descList
        )

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this@RecycleViewActivity,
            LinearLayoutManager.HORIZONTAL, false)

        // Grid View
//        recyclerView.layoutManager = GridLayoutManager(this@RecycleViewActivity,2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}