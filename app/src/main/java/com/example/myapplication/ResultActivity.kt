package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.Adapter.PhotoAdapter2
import com.example.myapplication.databinding.ActivityButtonTouchBinding
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding

    // Data Lists for RecyclerView
    val imageList = arrayListOf(R.drawable.imageee, R.drawable.imagee, R.drawable.iimage)
    val nameList = arrayListOf("GYM", "Infinity", "Scenery")
    val descList = arrayListOf("Where Fitness Becomes a Lifestyle", "Infinity is vast", "Best View")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize View Binding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle System Insets for Edge-to-Edge Layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Display User Data from Intent
        displayUserData()

        // Setup RecyclerView
        setupRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupRecyclerView() {
        // RecyclerView Adapter
        val adapter = PhotoAdapter2(this@ResultActivity, imageList, nameList, descList)

        // Setup RecyclerView with GridLayoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    private fun displayUserData() {
        // Get the data from the Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"
        val country = intent.getStringExtra("COUNTRY") ?: "N/A"
        val city = intent.getStringExtra("CITY") ?: "N/A"

        // Display the data in the UI
        binding.textViewFullName.text = "Full Name: $fullName"
        binding.textViewEmail.text = "Email: $email"
        binding.textViewGender.text = "Gender: $gender"
        binding.textViewCountry.text = "Country: $country"
        binding.textViewCity.text = "City: $city"
    }
}