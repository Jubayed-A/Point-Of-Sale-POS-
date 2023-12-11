package com.example.pointofsale

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val itemArrayList: ArrayList<Item>, val context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iName = itemView.findViewById<TextView>(R.id.itemName)
        val iQty = itemView.findViewById<TextView>(R.id.itemQty)
        val iPrice = itemView.findViewById<TextView>(R.id.itemPrice)
        val iTotal = itemView.findViewById<TextView>(R.id.itemTotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.custom_item_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemArrayList[position]
        holder.iName.text = currentItem.name
        holder.iQty.text = currentItem.qty
        holder.iPrice.text = currentItem.price
        holder.iTotal.text = currentItem.total
    }

}