package com.training.imageviewerapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val nameTxt = findViewById<EditText>(R.id.editText)
        val image = findViewById<ImageView>(R.id.image)
        val dropDown = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.submitBtn)
        val languages = listOf<String>("Java", "Kotlin")
        val imageMap = mapOf(
            "Java" to R.drawable.java,
            "Kotlin" to R.drawable.kotlin
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        ).also { it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        dropDown.adapter = adapter
        dropDown.setSelection(0)
        image.setImageResource(imageMap[languages[0]] ?: 0)
        dropDown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selected = languages[position]
                Toast.makeText(this@MainActivity, "${nameTxt.text.toString()} is selected $selected",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        button.setOnClickListener {
            val pos = dropDown.selectedItemPosition
            if(pos != AdapterView.INVALID_POSITION)
            {
                val selected = languages[pos]
                imageMap[selected]?.let { resId ->
                    image.setImageResource(resId)
                    image.visibility = View.VISIBLE
                }?:run {
                    image.visibility = View.GONE
                    Toast.makeText(this, "No Image available for $selected",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}