package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {
    lateinit var ListView: ListView
    val contacts = arrayOf(
        "Ram", "Shyam", "Hari", "Lucifer", "Aayush", "Sujal", "Gita", "Sita", "Lucifer", "Aayush", "Sujal","Ram", "Shyam", "Hari",
        "Aayush", "Sujal", "Gita", "Sita", "Lucifer", "Aayush", "Sujal","Ram", "Shyam", "Hari"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ListView = findViewById(R.id.listVieww)

        var adapter = ArrayAdapter(
            this@ListActivity,
            android.R.layout.simple_list_item_1, contacts
        )

        ListView.adapter = adapter

        ListView.setOnItemClickListener { adapterView, view, position, l ->

            if (adapterView != null){
                Toast.makeText(
                    this@ListActivity,
                    adapterView.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}