package com.training.libraryofalltopics.contacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.training.libraryofalltopics.contacts.repository.ContactRepository

class ViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(repository) as T
        }else{
            throw IllegalArgumentException("Unknown view model class")
        }
    }
}