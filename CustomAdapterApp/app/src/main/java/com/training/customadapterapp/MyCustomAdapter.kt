package com.training.customadapterapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MyCustomAdapter(val context: Context, val planetList: List<Planet>): BaseAdapter() {
    override fun getCount(): Int {
        return planetList.size
    }
    override fun getItem(position: Int): Any? {
        return planetList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val inflater = context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View

        if(convertView == null){
            view = inflater.inflate(R.layout.activity_custom_moon_list_layout,
                parent, false)
        }else{
            view = convertView
        }

        val item = getItem(position) as Planet

        val titleTextView = view.findViewById<TextView>(R.id.planetName)
        val moonCount = view.findViewById<TextView>(R.id.moonCount)
        val planetImage = view.findViewById<ImageView>(R.id.imageView)

        titleTextView.text = item.title
        moonCount.text = item.moonCount
        planetImage.setImageResource(item.imagePlanet)

        view.setOnClickListener {
            Toast.makeText(
                context,
                "You selected : ${planetList[position].title}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }
}