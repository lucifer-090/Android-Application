package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var dateText: EditText

    val countries = arrayOf("Nepal","India", "China", "japan", "Canada")
    val cities = arrayOf("Kathmandu", "Bhaktapur", "lalitpur", "Kritipur", "Kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.selectCountry)
        textView = findViewById(R.id.selectText)
        autoCompleteTextView = findViewById(R.id.AutoCompleteText)
        dateText = findViewById(R.id.editTextDatee)

        dateText.isFocusable = false
        dateText.isClickable = true
        dateText.setOnClickListener{
            loadCalender()
        }

        var autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 1

        val adapter = ArrayAdapter(
             this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )

        spinner.adapter = adapter

        spinner.onItemSelectedListener=this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadCalender(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val days = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            dateText.setText("$day,${month+1},$year")
            },year,month,days
        )
        dialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0 != null){
            textView.text = p0.getItemAtPosition(p2).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}