package com.training.livedatabasicsapp

import android.view.View
import androidx.lifecycle.ViewModel

class Eventhandler: ViewModel() {
    var counter = 0
    fun incrementCount(){
        counter++
    }

    fun getCount():Int{
        return counter
    }
}