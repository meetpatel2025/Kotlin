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
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
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

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
            printFollowers()
        }
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

            scope.launch(Dispatchers.Default) {
                Log.d(TAG, "Task running in Main scope : ${Thread.currentThread()} ")
            }

//            for (i in 1..100000L) {
//                Log.d(TAG, "Task running in coroutine - $i ")
//            }

        }
    }

    suspend fun task1() {
        Log.d(TAG, "Task-1 Started")
        delay(1000)
        Log.d(TAG, "Task-1 Finished")
    }

    suspend fun task2() {
        Log.d(TAG, "Task-2 Started")
        delay(1000)
        Log.d(TAG, "Task-2 Finished")
    }

    private suspend fun printFollowers() {
        var totalFollowers = 0
        val job = CoroutineScope(Dispatchers.Main).async {
//            totalFollowers = getFollowers()
            getFollowers()
        }
//        job.join()
        Log.d(TAG, job.await().toString())
    }

    private suspend fun getFollowers(): Int {
        delay(1000)
        return 148
    }
}