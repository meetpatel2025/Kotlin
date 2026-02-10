package com.training.contactsmanagermvvmapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.training.contactsmanagermvvmapp.R
import com.training.contactsmanagermvvmapp.databinding.CardItemBinding
import com.training.contactsmanagermvvmapp.room.Contacts

class MyRecyclerViewAdapter(private val contactsList:List<Contacts>,
    private val clickListener: (Contacts)-> Unit)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : CardItemBinding = DataBindingUtil.
                inflate(layoutInflater,
                    R.layout.card_item,
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

    class MyViewHolder(val binding: CardItemBinding)
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