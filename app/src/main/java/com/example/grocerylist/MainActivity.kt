package com.example.grocerylist

import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ArrayList()


        val RecyclerView = findViewById<View>(R.id.RecyclerView) as RecyclerView
        // Initialize contacts
        // Create adapter passing in the sample user data
        val adapter = ItemAdapter(items)
        // Attach the adapter to the recyclerview to populate items
        RecyclerView.adapter = adapter
        // Set layout manager to position the items
        RecyclerView.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.button).setOnClickListener { submitItem()
            adapter.notifyDataSetChanged()
        }
    }

    private fun submitItem() {
        val name = findViewById<EditText>(R.id.name)
        val price = findViewById<EditText>(R.id.price)
        val url = findViewById<EditText>(R.id.url)

        items.add(Item(name.text.toString(), price.text.toString(), url.text.toString()))
        name.text.clear()
        price.text.clear()
        url.text.clear()

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken,0)
        name.requestFocus()
    }
}