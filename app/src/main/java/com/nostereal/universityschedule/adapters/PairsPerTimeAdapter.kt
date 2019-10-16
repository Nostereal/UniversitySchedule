package com.nostereal.universityschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.data.Pair

class PairsPerTimeAdapter : RecyclerView.Adapter<PairsPerTimeAdapter.ViewHolder>() {

    private val pairsPerTimeList: ArrayList<Pair> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int = pairsPerTimeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pairsPerTimeList[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
                this(LayoutInflater.from(parent.context).inflate(R.layout.item_pairs_per_one_time, parent, false))

        fun bind(pair: Pair) {

        }
    }
}