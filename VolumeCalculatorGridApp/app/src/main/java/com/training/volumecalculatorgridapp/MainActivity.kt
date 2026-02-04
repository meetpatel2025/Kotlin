package com.training.volumecalculatorgridapp

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val gridView: GridView = findViewById(R.id.gridView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var shape1: Shape = Shape(R.drawable.sphere, "Sphere")
        var shape2: Shape = Shape(R.drawable.cube, "Cube")
        var shape3: Shape = Shape(R.drawable.prism, "Prism")
        var shape4: Shape = Shape(R.drawable.cylinder, "Cylinder")

        val gridItems = ArrayList<Shape>()
        gridItems.add(shape1)
        gridItems.add(shape2)
        gridItems.add(shape3)
        gridItems.add(shape4)

        val customArrayAdapter = MyCustomArrayAdapter(this, gridItems)
        gridView.adapter = customArrayAdapter

        gridView.setOnItemClickListener { _,_,position,_ ->
            val clickedItem = customArrayAdapter.getItem(position)

            if(clickedItem?.shapeName.equals("Sphere")){
                val sphereScreen = Intent(this, SphereActivity::class.java )
                startActivity(sphereScreen)
            }
        }

    }
}