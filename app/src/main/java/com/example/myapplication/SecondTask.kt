package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonTouchBinding
import com.example.myapplication.databinding.ActivityResultBinding
import com.example.myapplication.databinding.ActivitySecondTaskBinding

class SecondTask : AppCompatActivity() {

    lateinit var binding: ActivitySecondTaskBinding

//    lateinit var spinner: Spinner
//    lateinit var textView: TextView
//    lateinit var autoCompleteTextView: AutoCompleteTextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf("Nepal","India", "United States", "Australia", "China", "japan", "Canada", "United Kingdom", "Korea", "Qatar",
            "Argentina")
        val cities = arrayOf("Kathmandu", "Bhaktapur", "lalitpur", "Kritipur", "Kanchanpur", "Pokhara", "Dharan", "Bharatpur", "Biratnagar",
            "Birjung", "Janakpur", "Itahari", "Besisahar", "Kapilvastu", "Kalaiya")


        binding.submitButton.setOnClickListener {
            val fullname : String = binding.fullName.text.toString()
            val email : String = binding.emallTextView.text.toString()
            val password : String = binding.passTextView.text.toString()

            if (fullname.isEmpty()){
                binding.fullName.error= "Username can not be empty"
            }
            else if (email.isEmpty()){
                binding.emallTextView.error= "email can not be empty"
            }else if (password.isEmpty()) {
                binding.passTextView.error = "Password can not be empty"
            }
            else {


                if (binding.termsCheck.isChecked) {
                    // Collect input and navigate to the next activity
                    val intent = Intent(this@SecondTask, ResultActivity::class.java).apply {
                        putExtra("FULL_NAME", binding.fullName.text.toString())
                        putExtra("EMAIL", binding.emallTextView.text.toString())
                        putExtra("GENDER", if (binding.radioMale.isChecked) "Male" else "Female")
                        putExtra("COUNTRY", binding.selectCountry.selectedItem.toString())
                        putExtra("CITY", binding.AutoCompleteText.text.toString())
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please agree to terms and conditions", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }


//        spinner = findViewById(R.id.selectCountry)
//        autoCompleteTextView = findViewById(R.id.AutoCompleteText)

        val cityAdapter = ArrayAdapter(
            this@SecondTask,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        binding.AutoCompleteText.setAdapter(cityAdapter)
        binding.AutoCompleteText.threshold=1
//        autoCompleteTextView.setAdapter(cityAdapter)
//        autoCompleteTextView.threshold = 1



        val adapter = ArrayAdapter(
            this@SecondTask,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )
        binding.selectCountry.adapter = adapter

//        spinner.adapter = adapter

//        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}