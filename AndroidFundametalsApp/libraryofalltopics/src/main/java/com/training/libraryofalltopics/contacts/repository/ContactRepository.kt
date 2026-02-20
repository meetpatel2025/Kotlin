package com.training.libraryofalltopics.contacts.repository

import com.training.libraryofalltopics.contacts.room.ContactDAO
import com.training.libraryofalltopics.contacts.room.Contacts

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