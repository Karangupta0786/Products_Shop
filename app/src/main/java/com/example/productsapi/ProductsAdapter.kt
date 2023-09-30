package com.example.productsapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class ProductsAdapter(val productList: List<Product>,val applicationContext:Context):RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val productImage:ImageView = itemView.findViewById(R.id.productImage)
        val productTitle:TextView = itemView.findViewById(R.id.productTitle)
        val productPrice:TextView = itemView.findViewById(R.id.productPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(applicationContext)
        val view = inflater.inflate(R.layout.item_product,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.productTitle.text = currentProduct.title
        holder.productPrice.text = "${currentProduct.price}Rs"
        // how to show the ImageView if the image is in form of URL.
        Picasso.get().load(currentProduct.thumbnail).into(holder.productImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(applicationContext,ProductActivity::class.java)
            intent.putExtra("product",Gson().toJson(productList[position]))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            applicationContext.startActivity(intent)
        }
    }
}