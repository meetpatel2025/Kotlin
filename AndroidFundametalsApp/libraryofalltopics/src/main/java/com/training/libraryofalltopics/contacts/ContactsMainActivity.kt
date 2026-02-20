package com.training.libraryofalltopics.contacts

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.libraryofalltopics.R
import com.training.libraryofalltopics.contacts.viewmodel.ContactViewModel
import com.training.libraryofalltopics.contacts.viewmodel.ViewModelFactory
import com.training.libraryofalltopics.databinding.ContactsActivityMainBinding
import com.training.libraryofalltopics.contacts.repository.ContactRepository
import com.training.libraryofalltopics.contacts.room.ContactDatabase
import com.training.libraryofalltopics.contacts.room.Contacts
import com.training.libraryofalltopics.contacts.view.MyRecyclerViewAdapter

class ContactsMainActivity : AppCompatActivity() {
    lateinit var binding: ContactsActivityMainBinding
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.contacts_activity_main)

        val dao = ContactDatabase.getInstance(applicationContext).contactDAO
        val repository = ContactRepository(dao)
        val factory = ViewModelFactory(repository)

        contactViewModel = ViewModelProvider(this, factory)[ContactViewModel::class.java]

        binding.contactViewModel = contactViewModel
        binding.lifecycleOwner = this

        initRecyclerView()   // REQUIRED
    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.DisplayUsersList()
    }

    private fun ContactsActivityMainBinding.DisplayUsersList() {
        this@ContactsMainActivity.contactViewModel.contacts.observe(this@ContactsMainActivity, Observer {
            recyclerView.adapter = MyRecyclerViewAdapter(
                it,
                { selectedItem: Contacts -> this@ContactsMainActivity.listItemClicked(selectedItem) }
            )
        })
    }

    private fun listItemClicked(selectedItem : Contacts){
        Toast.makeText(this,
            "Selected name is ${selectedItem.contactName}",
            Toast.LENGTH_SHORT).show()

        contactViewModel.initUpdateAndDelete(selectedItem)
    }
}

