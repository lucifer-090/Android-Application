package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var radioImagee : RadioButton
    lateinit var radioImageee : RadioButton
    lateinit var radioIimagee : RadioButton
    lateinit var imageViewRadio : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)
        radioImagee=findViewById(R.id.Buttonimagee)
        radioImageee=findViewById(R.id.Buttonimageee)
        radioIimagee=findViewById(R.id.Buttoniimage)
        imageViewRadio=findViewById(R.id.imageeview)

        radioImagee.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.imagee)
        }
        radioImageee.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.imageee)
        }
        radioIimagee.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.iimage)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.arrow)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}