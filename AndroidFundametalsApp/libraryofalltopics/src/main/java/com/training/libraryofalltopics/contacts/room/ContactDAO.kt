package com.training.libraryofalltopics.contacts.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    @Insert
    suspend fun addContact(contacts: Contacts) : Long

    @Update
    suspend fun updateContact(contacts: Contacts)

    @Delete
    suspend fun deleteContact(contacts: Contacts)

    @Query("DELETE FROM contacts_table")
    suspend fun deleteAllContacts()

    @Query("SELECT * FROM contacts_table")
    fun fetchAllContacts() : LiveData<List<Contacts>>
}