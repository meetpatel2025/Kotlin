package com.training.volumecalculatorgridapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SphereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)

        val textView: TextView = findViewById(R.id.textView2)
        val result = findViewById<TextView>(R.id.textView3)
        val button = findViewById<Button>(R.id.btn1)
        val edtText = findViewById<EditText>(R.id.editText_Sphere)

        button.setOnClickListener {
            var radius = edtText.text.toString()
            var r = Integer.parseInt(radius)

            // V = (4/3) *pi * r^3
            var volume = (4/3) * 3.14159 * r*r*r
            result.text = "V = $volume m^3"

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}