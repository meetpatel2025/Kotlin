package com.training.libraryofalltopics.serviceNotification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Service", "Service Started")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // Not using binding
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "Service Destroyed")
    }
}