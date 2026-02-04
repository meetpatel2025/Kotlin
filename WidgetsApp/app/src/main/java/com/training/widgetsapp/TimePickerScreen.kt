package com.training.widgetsapp

import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TimePickerScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_time_picker_screen)
        val timePicker: TimePicker = findViewById(R.id.timePicker)
        timePicker.setOnTimeChangedListener { timePicker, hh, mm ->
            val selectedTime = String.format("%02d:%02d", hh, mm)
            Toast.makeText(this, "Your time is : $selectedTime",
                Toast.LENGTH_LONG)
                .show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}