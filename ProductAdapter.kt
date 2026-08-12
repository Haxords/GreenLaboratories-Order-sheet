package com.greenlaboratories.ordersheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val onQuantityChanged: () -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val btnPlus: Button = itemView.findViewById(R.id.btnPlus)
        val btnMinus: Button = itemView.findViewById(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.tvName.text = product.name
        holder.tvCategory.text = product.category
        holder.tvPrice.text = "Price: ৳${product.price}"
        holder.tvQuantity.text = product.quantity.toString()

        holder.btnPlus.setOnClickListener {
            product.quantity++
            holder.tvQuantity.text = product.quantity.toString()
            onQuantityChanged()
        }

        holder.btnMinus.setOnClickListener {
            if (product.quantity > 0) {
                product.quantity--
                holder.tvQuantity.text = product.quantity.toString()
                onQuantityChanged()
            }
        }
    }

    override fun getItemCount(): Int = productList.size
}
