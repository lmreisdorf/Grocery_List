package com.example.grocerylist

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView = itemView.findViewById<TextView>(R.id.itemName)
        val itemPriceTextView = itemView.findViewById<TextView>(R.id.itemPrice)
        val itemURLTextView = itemView.findViewById<TextView>(R.id.itemURL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_entry, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ItemAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val item: Item = items.get(position)
        // Set item views based on your views and data model
        val itemName = viewHolder.itemNameTextView
        itemName.setText(item.name)
        val itemPrice = viewHolder.itemPriceTextView
        itemPrice.setText(item.price)
        val itemURL =viewHolder.itemURLTextView
        itemURL.setText(item.url)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return items.size
    }
}