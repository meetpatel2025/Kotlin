package com.training.groceryrecyclerviewapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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

        val v1 = Item("Fruits", "Fresh Fruits from the garden", R.drawable.fruit)
        val v2 = Item("Vegetables", "Delicious Vegetables ", R.drawable.vegitables)
        val v3 = Item("Bakery","Bread, Wheat and Beans",R.drawable.bread)
        val v4 = Item("Beverage","Juice, Tea, Coffee and Soda",R.drawable.beverage)
        val v5 = Item("Milk","Milk, SHakes and Yogurt",R.drawable.milk)
        val v6 = Item("Snacks","Pop Corn, Donut and Drinks", R.drawable.popcorn)



        var listItems : ArrayList<Item> = ArrayList()
        listItems.add(v1)
        listItems.add(v2)
        listItems.add(v3)
        listItems.add(v4)
        listItems.add(v5)
        listItems.add(v6)

        val adapter = CustomItemAdapter(listItems)
        recyclerView.adapter = adapter
    }
}