package com.training.widgetsapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerScreen : AppCompatActivity() {
    lateinit var spinnerDropDown : Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner_screen)
        spinnerDropDown = findViewById(R.id.spinnerDropDown)

        spinnerLanguages()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun spinnerLanguages(): Unit{
        val languages = listOf<String>("English", "Hindi", "Gujarati", "Bhojpuri", "Punjabi", "Tamil", "Kannada", "Malayalam", "Marathi", "Bangali", "French", "Spanish", "Urdu", "Sanskrit", "Russian")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        )
        spinnerDropDown.adapter =adapter
    }
}