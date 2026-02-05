package com.training.servicesandbroadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastSetting : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action != null && intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            var isAerplaneModeOn : Boolean = intent.getBooleanExtra("state", false)

            if(isAerplaneModeOn){
                Toast.makeText(
                    context,
                    "Aerplane mode is ON",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    context,
                    "Aerplane mode is OFF",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}