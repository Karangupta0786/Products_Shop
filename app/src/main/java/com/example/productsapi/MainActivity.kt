package com.example.productsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//URL = https://dummyjson.com/products

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<ProgressBar>(R.id.progress_circular).isVisible = true
//        Handler().postDelayed(Runnable {
            getProducts()
//        },1000)

    }

    private fun getProducts() {
        val retrofitData = RetrofitBuilder.retrofit.getProductData()
        retrofitData.enqueue(object : Callback<GetProducts?> {
            override fun onResponse(call: Call<GetProducts?>, response: Response<GetProducts?>) {
                findViewById<ProgressBar>(R.id.progress_circular).isVisible = false
                val responseBody = response.body()!!
                val productList = responseBody.products
                if (response.isSuccessful){
                    Toast.makeText(applicationContext, "Mission succeed", Toast.LENGTH_SHORT).show()
//                    val stringBuilder = StringBuilder()
//                    for (i in responseBody.products){
//                        stringBuilder.append(i.title+"\n")
//                    }
//                    findViewById<TextView>(R.id.text).text = stringBuilder

                    val recyclerView:RecyclerView = findViewById(R.id.recycler_products)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.setHasFixedSize(true)

                    val productsAdapter = ProductsAdapter(productList,applicationContext)
                    recyclerView.adapter = productsAdapter
                    productsAdapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<GetProducts?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}