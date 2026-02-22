package com.training.libraryofalltopics.grocery

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.training.libraryofalltopics.R

class GroceryMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.grocery_activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val v1 = GroceryItem("Fruits", "Fresh Fruits from the garden", R.drawable.fruit)
        val v2 = GroceryItem("Vegetables", "Delicious Vegetables ", R.drawable.vegitables)
        val v3 = GroceryItem("Bakery", "Bread, Wheat and Beans", R.drawable.bread)
        val v4 = GroceryItem("Beverage", "Juice, Tea, Coffee and Soda", R.drawable.beverage)
        val v5 = GroceryItem("Milk", "Milk, SHakes and Yogurt", R.drawable.milk)
        val v6 = GroceryItem("Snacks", "Pop Corn, Donut and Drinks", R.drawable.popcorn)



        var listItems : ArrayList<GroceryItem> = ArrayList()
        listItems.add(v1)
        listItems.add(v2)
        listItems.add(v3)
        listItems.add(v4)
        listItems.add(v5)
        listItems.add(v6)

        val adapter = GroceryCustomItemAdapter(listItems)
        recyclerView.adapter = adapter
    }
}