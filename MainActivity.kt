package com.greenlaboratories.ordersheet

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ProductAdapter
    private lateinit var tvTotal: TextView
    private val productList = SampleData.productList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        tvTotal = findViewById(R.id.tvTotalPrice)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitOrder)

        // RecyclerView সেটআপ
        adapter = ProductAdapter(productList) {
            calculateTotal()
        }
        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = adapter

        // Submit বাটন অ্যাকশন
        btnSubmit.setOnClickListener {
            val orderedItems = productList.filter { it.quantity > 0 }
            if (orderedItems.isNotEmpty()) {
                val totalAmount = orderedItems.sumOf { it.price * it.quantity }
                Toast.makeText(this, "Order Submitted! Total: ৳$totalAmount", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please select at least one item", Toast.SHORT).show()
            }
        }
    }

    private fun calculateTotal() {
        val total = productList.sumOf { it.price * it.quantity }
        tvTotal.text = "Total: ৳$total"
    }
}
