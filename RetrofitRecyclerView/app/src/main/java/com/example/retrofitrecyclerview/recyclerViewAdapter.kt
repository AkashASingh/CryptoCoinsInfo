package com.example.retrofitrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.CoinsViewHolder>() {
    private val crCoins: ArrayList<CoinsApiItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return CoinsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val currentItem = crCoins[position]
        holder.coinName.text = currentItem.name
        holder.coinRank.text = currentItem.rank.toString()
        holder.coinSymbol.text = currentItem.symbol
        holder.coinIsActive.text = currentItem.is_active.toString()
    }

    override fun getItemCount(): Int {
        return crCoins.size
    }

    fun upDateCoins(updatedcoins: ArrayList<CoinsApiItem>) {
        crCoins.clear()
        crCoins.addAll(updatedcoins)
        notifyDataSetChanged()
    }


    class CoinsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var coinName = itemView.findViewById<TextView>(R.id.coinNamesTextView)
        var coinRank = itemView.findViewById<TextView>(R.id.serialTextView)
        var coinSymbol = itemView.findViewById<TextView>(R.id.coinSymbolTV)
        var coinIsActive = itemView.findViewById<TextView>(R.id.isActiveTextView)


    }
}