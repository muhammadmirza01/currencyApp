package com.farhanmirza.currencyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RateAdapter(private val ratesList: ArrayList<String>) :
    RecyclerView.Adapter<RateAdapter.RatesViewHolder>() {

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        val currentItem = ratesList[position]
        holder.rateText.text = currentItem
    }

    override fun getItemCount(): Int {
        return ratesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rate_list_item,parent,false)
        return RatesViewHolder(itemView)
    }


    class RatesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
           val rateText: TextView = itemView.findViewById(R.id.rate_value)
    }
}