package com.example.CryptoCoinsInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.CryptoCoinsInfo.models.coinsApiItem

class RecyclerViewAdapter(responseBody: List<coinsApiItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.CoinsViewHolder>() {
    private val crCoins: List<coinsApiItem> =responseBody
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        println("Yo Boi..!!")
        return CoinsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val currentItem = crCoins[position]
        holder.coinName.text = currentItem.name
        holder.coinRank.text = currentItem.rank.toString()
        holder.coinSymbol.text = currentItem.symbol
        holder.coinIsActive.setOnClickListener {
            Toast.makeText(it.context, "CoinsView", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return crCoins.size
    }
    class CoinsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var coinName: TextView = itemView.findViewById(R.id.coinNamesTextView)
        var coinRank: TextView = itemView.findViewById(R.id.serialTextView)
        var coinSymbol: TextView = itemView.findViewById(R.id.coinSymbolTV)
        var coinIsActive: TextView = itemView.findViewById(R.id.isActiveTextView)
    }
}