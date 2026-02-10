package com.training.contactsmanagermvvmapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val contactID: Long,
    var contactName:String,
    var contactMailID: String
)
