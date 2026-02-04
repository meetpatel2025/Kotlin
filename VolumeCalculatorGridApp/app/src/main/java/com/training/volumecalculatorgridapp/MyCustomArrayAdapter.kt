package com.training.volumecalculatorgridapp

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCustomArrayAdapter(context: Context, private val gridList:List<Shape>)
    : ArrayAdapter<Shape>(context, 0, gridList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        var holder: ViewHolder

        if(convertView == null){
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.custom_grid_layout, parent, false)

            holder = ViewHolder()
            holder.iamgeView = itemView.findViewById(R.id.imageView)
            holder.imageTitle = itemView.findViewById(R.id.imageTitle)

            itemView.tag = holder
        }else{
            holder = itemView?.tag as ViewHolder
        }

        val currentItem = gridList[position]
        holder.imageTitle.text = currentItem.shapeName
        holder.iamgeView.setImageResource(currentItem.shapeImg)

        return itemView!!
    }

    private class ViewHolder{
        lateinit var iamgeView: ImageView
        lateinit var imageTitle : TextView
    }
}