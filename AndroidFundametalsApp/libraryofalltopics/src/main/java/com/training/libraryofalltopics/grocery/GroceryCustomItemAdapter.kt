package com.training.libraryofalltopics.grocery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.training.libraryofalltopics.R

class GroceryCustomItemAdapter(val itemList: List<GroceryItem>) :
    RecyclerView.Adapter<GroceryCustomItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grocery_custom_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.itemTitle.setText(itemList[position].itemTxt)
        holder.itemDesc.setText(itemList[position].itemDesc)
        holder.itemImg.setImageResource(itemList[position].itemImg)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTitle: TextView
        var itemDesc: TextView
        var itemImg: ImageView

        init {
            itemTitle = view.findViewById(R.id.itemTitle)
            itemDesc = view.findViewById(R.id.itemDesc)
            itemImg = view.findViewById(R.id.itemImg)

        }

    }
}