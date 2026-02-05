package com.training.sportscardviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SportsAdapter(val sportsList: ArrayList<SportsModel>)
    : RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.sportsTitle.setText(sportsList[position].cardTitle)
        holder.sportsImg.setImageResource(sportsList[position].cardImg)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    inner class ViewHolder(sportsView : View)
        : RecyclerView.ViewHolder(sportsView){

            val sportsTitle: TextView
            val sportsImg: ImageView

            init {
                sportsTitle = sportsView.findViewById(R.id.cardTitle)
                sportsImg = sportsView.findViewById(R.id.cardImg)
                sportsView.setOnClickListener {
                    Toast.makeText(
                        sportsView.context,
                        "You Clicked: ${sportsList[position].cardTitle}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }
}