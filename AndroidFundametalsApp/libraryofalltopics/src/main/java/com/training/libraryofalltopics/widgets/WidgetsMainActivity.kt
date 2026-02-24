package com.training.libraryofalltopics.widgets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.training.libraryofalltopics.R

class WidgetsMainActivity : AppCompatActivity() {
    lateinit var radioBtn: Button
    lateinit var chkBox: Button
    lateinit var dropDown: Button
    lateinit var timePicker: Button
    lateinit var datePickerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.widgets_activity_main)
        dropDown = findViewById(R.id.spinnerDropDownBtn)
        chkBox = findViewById(R.id.checkBox)
        radioBtn = findViewById(R.id.radioButton)
        timePicker = findViewById(R.id.timePickerBtn)
        datePickerBtn = findViewById(R.id.datePickerBtn)

        radioBtn.setOnClickListener {
            val radioBtnScreen = Intent(this, RadioButtonScreen::class.java)
            startActivity(radioBtnScreen)
        }

        chkBox.setOnClickListener {
            val checkBoxScreen = Intent(this, CheckBoxScreen::class.java)
            startActivity(checkBoxScreen)
        }

        dropDown.setOnClickListener {
            val spinnerPage = Intent(this, SpinnerScreen::class.java)
            startActivity(spinnerPage)
        }

        timePicker.setOnClickListener {
            val timePickerPage = Intent(this, TimePickerScreen::class.java)
            startActivity(timePickerPage)
        }
        datePickerBtn.setOnClickListener {
            val datePickerPage = Intent(this, DatePickerScreen::class.java)
            startActivity(datePickerPage)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}