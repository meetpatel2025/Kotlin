package com.training.libraryofalltopics.livedata

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Eventhandler: ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }
    fun incrementCount(view: View){
        counter.value = (counter.value)?.plus(1)
    }

//    fun getCount():Int{
//        return counter.value
//    }
}