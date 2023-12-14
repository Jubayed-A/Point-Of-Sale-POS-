package com.example.pointofsale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog

class MobileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile)

        // select mobile payment method code here
        // mobile payment text code here
        val payment = arrayOf(
            "bKash System", "Rocket System", "Nogod System"
        )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, payment)
        val mobilePaymentList = findViewById<AutoCompleteTextView>(R.id.mobileBankName)
        mobilePaymentList.setAdapter(arrayAdapter)

        mobilePaymentList.setOnItemClickListener { parent, view, position, id ->
            val selectedPayment = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "You Selected $selectedPayment", Toast.LENGTH_SHORT).show()

        }

        // variable declare
        val mobile = findViewById<EditText>(R.id.etPhone)
        val tranID = findViewById<EditText>(R.id.etTranId)
        val btnOkay = findViewById<Button>(R.id.btnBuy)

        // set mobile payment list
        val defaultValue = "Chose Mobile Banking"

        // btnOkay button code here
        btnOkay.setOnClickListener {
            val currentText = mobilePaymentList.text.toString()
            val mobileText = mobile.text.toString()
            val tranIdText = tranID.text.toString()

            if (mobileText.isNotEmpty() && tranIdText.isNotEmpty() && currentText != defaultValue) {
                Toast.makeText(this, "This Feature will develop Soon!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all the filed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}