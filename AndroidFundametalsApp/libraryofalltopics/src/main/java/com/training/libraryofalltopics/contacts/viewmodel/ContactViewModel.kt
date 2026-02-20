package com.training.libraryofalltopics.contacts.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.libraryofalltopics.contacts.repository.ContactRepository
import com.training.libraryofalltopics.contacts.room.Contacts
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository)
    : ViewModel(), Observable{
    val contacts = repository.contacts
    private var isUpdateOrDeleted = false
    private lateinit var contactToUpdateOrDelete: Contacts

    val inputName = MutableLiveData<String?>()

    val inputEmail = MutableLiveData<String?>()

    val saveOrUpdateButtonText = MutableLiveData<String>()

    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init{
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    fun insert(contacts: Contacts) = viewModelScope.launch() {
        repository.insert(contacts)
    }

    fun delete(contacts: Contacts) = viewModelScope.launch() {
        repository.delete(contacts)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDeleted = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"

    }

    fun update(contacts: Contacts) = viewModelScope.launch() {
        repository.update(contacts)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDeleted = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"

    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun saveOrUpdate(){
        if(isUpdateOrDeleted){
            contactToUpdateOrDelete.contactName = inputName.value!!
            contactToUpdateOrDelete.contactMailID = inputEmail.value!!
            update(contactToUpdateOrDelete)

        }else{
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(Contacts(0, name, email))

            inputEmail.value = null
            inputName.value = null
        }
    }

    fun clearALlOrDeleted(){
        if(isUpdateOrDeleted){
            delete(contactToUpdateOrDelete)
        }else{
            clearAll()
        }
    }

    fun initUpdateAndDelete(contacts:Contacts){
        inputName.value = contacts.contactName
        inputEmail.value = contacts.contactMailID
        isUpdateOrDeleted = true
        contactToUpdateOrDelete = contacts
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}