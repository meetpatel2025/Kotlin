package com.training.contactsmanagermvvmapp.repository

import androidx.lifecycle.LiveData
import com.training.contactsmanagermvvmapp.room.ContactDAO
import com.training.contactsmanagermvvmapp.room.Contacts

class ContactRepository(private val contactDAO: ContactDAO) {

    val contacts = contactDAO.fetchAllContacts()

    suspend fun insert(contacts: Contacts):Long{
        return contactDAO.addContact(contacts)
    }

    suspend fun update(contacts: Contacts){
        return contactDAO.updateContact(contacts)
    }

    suspend fun delete(contacts: Contacts){
        return contactDAO.deleteContact(contacts)
    }

    suspend fun deleteAll(){
        return contactDAO.deleteAllContacts()
    }
}