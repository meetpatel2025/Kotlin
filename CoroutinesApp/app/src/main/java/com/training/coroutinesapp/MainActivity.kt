package com.training.coroutinesapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var counter: Int = 0
    lateinit var counterView: TextView
    lateinit var buttonID: Button

    lateinit var executeBtn: Button

    private val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        counterView = findViewById<TextView>(R.id.textView2)
        buttonID = findViewById<Button>(R.id.counterBtn)
        executeBtn = findViewById<Button>(R.id.executeBtn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        updateCount()
        executeLongRunnigTaask()

    }

    fun updateCount() {
        buttonID.setOnClickListener {
            counter++
            counterView.setText(counter.toString())
            Log.d(TAG, "Task running in Counter scope : $counter ")
        }
    }

    fun executeLongRunnigTaask() {
        executeBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                Log.d(TAG, "Task running in Coroutine Main scope : ${Thread.currentThread()} ")
            }

            GlobalScope.launch(Dispatchers.IO) {
                Log.d(TAG, "Task running in Global IO scope : ${Thread.currentThread()} ")
            }

            val scope = MainScope()

            scope.launch(Dispatchers.Default){
                Log.d(TAG, "Task running in Main scope : ${Thread.currentThread()} ")
            }

//            for (i in 1..100000L) {
//                Log.d(TAG, "Task running in coroutine - $i ")
//            }
        }
    }
}