package com.example.pointofsale

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog

class OutputActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemArrayList: ArrayList<Item>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        // select payment method code here

        // payment text code here
        val payment = arrayOf(
            "Bank System", "Cash On Delivery", "Mobile Banking"
        )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, payment)
        val paymentList = findViewById<AutoCompleteTextView>(R.id.autoItem)
        paymentList.setAdapter(arrayAdapter)

        paymentList.setOnItemClickListener { parent, view, position, id ->
            val selectedPayment = parent.getItemAtPosition(position).toString()
//            Toast.makeText(this, paymentList.text, Toast.LENGTH_SHORT).show()
            when (selectedPayment) {
                "Bank System" -> {
                    // bank activity create
                    val intentBank = Intent(this, BankActivity::class.java)
                    startActivity(intentBank)
                }

                "Cash On Delivery" -> {
                    // sweet custom alert box show
                    SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("You Order is Cash On Delivery")
                        .setContentText("Your Order is ready to payment with cash on delivery after the delivery your order is Successfully")
                        .show()

                }

                "Mobile Banking" -> {
                    val intentMobile = Intent(this, MobileActivity::class.java)
                    startActivity(intentMobile)
                }

                else -> {
                    Toast.makeText(this, "Selected payment: $selectedPayment", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }


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
            val itemInfo = Item(
                name[index], qty?.get(index) ?: toString(),
                price!![index], total!![index]
            )
            itemArrayList.add(itemInfo)
        }

        val myAdapter = MyAdapter(itemArrayList, this)
        recyclerView.adapter = myAdapter


    }
}