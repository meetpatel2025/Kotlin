package com.training.sportscardviewapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
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
            false)

        val sportsList = ArrayList<SportsModel>()

        val sports1 = SportsModel("Football", R.drawable.football)
        val sports2 = SportsModel("Tennis", R.drawable.tennis)
        val sports3 = SportsModel("Basketball", R.drawable.basketball)
        val sports4 = SportsModel("Volleyball", R.drawable.volley)
        val sports5 = SportsModel("Ping Pong", R.drawable.ping)

        sportsList.add(sports1)
        sportsList.add(sports2)
        sportsList.add(sports3)
        sportsList.add(sports4)
        sportsList.add(sports5)

        val adapter = SportsAdapter(sportsList)
        recyclerView.adapter = adapter

    }
}