package com.example.pointofsale

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OutputActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemArrayList: ArrayList<Item>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val name = intent.getStringArrayListExtra("itemList")
        val qty = intent.getStringArrayListExtra("itemQty")
        val price = intent.getStringArrayListExtra("itemPrice")
        val total = intent.getStringArrayListExtra("itemTotalPrice")
        val sum = intent.getDoubleExtra("sum", 0.0)


        val sumTotal = findViewById<TextView>(R.id.sumOutput)

        sumTotal.text = "Total Price is : $sum"

        recyclerView = findViewById<RecyclerView>(R.id.outputRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemArrayList = ArrayList()

        for (index in name?.indices!!) {
            val itemInfo = Item(name[index], qty?.get(index) ?:toString(),
                price!![index], total!![index])
            itemArrayList.add(itemInfo)
        }

        val myAdapter = MyAdapter(itemArrayList, this)
        recyclerView.adapter = myAdapter














    }
}