package com.training.libraryofalltopics.bindingdata

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.training.libraryofalltopics.BR
import kotlinx.coroutines.channels.BroadcastChannel

class Vehicle : BaseObservable() {

    var modalYear:String = ""
    @get:Bindable
    var modalName:String = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.modalName)
            notifyPropertyChanged(BR._all)
        }
}