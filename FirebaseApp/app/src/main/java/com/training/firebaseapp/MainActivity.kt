package com.training.firebaseapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var goldPriceTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        database = Firebase.database.reference
        goldPriceTextView = findViewById(R.id.goldPrice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user1 = User("Meet", "admin@123")
        database.child("Users").setValue(user1)

        val pe = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 :User = snapshot.getValue(User::class.java) as User
                goldPriceTextView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        }
        database.child("Users").addValueEventListener(pe)
//        database = Firebase.database.reference
//        database.child("goldPrice").setValue("1652 $")
//
//        val postListener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val goldPrice = snapshot.value
//                goldPriceTextView.text = goldPrice.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                goldPriceTextView.text = "Error: ${error.message}"
//            }
//
//        }
//        database.child("goldPrice").addValueEventListener(postListener!!)
    }
}