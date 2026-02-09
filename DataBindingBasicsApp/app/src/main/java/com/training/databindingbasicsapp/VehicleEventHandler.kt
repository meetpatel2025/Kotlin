package com.training.databindingbasicsapp

import android.content.Context
import android.view.View
import android.widget.Toast

class VehicleEventHandler(var context: Context) {

    fun displayToastMessage(view: View){
        Toast.makeText(context,
            "Button is clicked !!",
            Toast.LENGTH_SHORT
        ).show()
    }
}