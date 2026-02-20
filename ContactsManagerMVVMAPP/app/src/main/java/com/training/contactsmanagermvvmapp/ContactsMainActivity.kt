package com.training.contactsmanagermvvmapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.contactsmanagermvvmapp.databinding.ActivityMainBinding
import com.training.contactsmanagermvvmapp.repository.ContactRepository
import com.training.contactsmanagermvvmapp.room.ContactDatabase
import com.training.contactsmanagermvvmapp.room.Contacts
import com.training.contactsmanagermvvmapp.view.MyRecyclerViewAdapter
import com.training.contactsmanagermvvmapp.viewmodel.ContactViewModel
import com.training.contactsmanagermvvmapp.viewmodel.ViewModelFactory

class ContactsMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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

    private fun ActivityMainBinding.DisplayUsersList() {
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

