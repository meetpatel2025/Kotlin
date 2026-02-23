package com.training.libraryofalltopics.broadcastservice

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.training.libraryofalltopics.R

class BroadcastMainActivity : AppCompatActivity() {
    lateinit var airplaneModeReciever : BroadcastSetting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.broadcast_activity_main)

        airplaneModeReciever = BroadcastSetting()
        var intetFilter : IntentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        registerReceiver(airplaneModeReciever, intetFilter)

        val startBtn = findViewById<Button>(R.id.playButton)
        val stopBtn =findViewById<Button>(R.id.stopButton)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startBtn.setOnClickListener {
            var startServiceIntent = Intent(
                this@BroadcastMainActivity,
                BroadcastMyService::class.java
            )

            startService(startServiceIntent)
        }

        stopBtn.setOnClickListener {
            var stopServiceIntent = Intent(
                this@BroadcastMainActivity,
                BroadcastMyService::class.java
            )

            stopService(stopServiceIntent)
        }

    }

    override fun onDestroy() {
        unregisterReceiver(airplaneModeReciever)
        super.onDestroy()
    }
}