package com.training.widgetsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var radioBtn: Button
    lateinit var chkBox: Button
    lateinit var dropDown: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        dropDown = findViewById(R.id.spinnerDropDownBtn)
        chkBox = findViewById(R.id.checkBox)
        radioBtn = findViewById(R.id.radioButton)

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}