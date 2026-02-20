package com.training.libraryofalltopics.contacts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.training.libraryofalltopics.R
import com.training.libraryofalltopics.contacts.room.Contacts
import com.training.libraryofalltopics.databinding.ContactsCardItemBinding

class MyRecyclerViewAdapter(private val contactsList:List<Contacts>,
                            private val clickListener: (Contacts)-> Unit)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ContactsCardItemBinding = DataBindingUtil.
                inflate(layoutInflater,
                    R.layout.contacts_card_item,
                    parent,
                    false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind(contactsList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    class MyViewHolder(val binding: ContactsCardItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(contacts: Contacts, clickListener: (Contacts) -> Unit){

            binding.nameTextView.text=contacts.contactName
            binding.emailTextView.text=contacts.contactMailID

            binding.listItemLayout.setOnClickListener {
                clickListener(contacts)
            }
        }
    }
}