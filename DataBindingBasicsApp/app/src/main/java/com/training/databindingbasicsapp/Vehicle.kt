package com.training.databindingbasicsapp

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Vehicle : BaseObservable() {

    var modalYear:String = ""
    @get:Bindable
    var modalName:String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.modalName)
        }
}