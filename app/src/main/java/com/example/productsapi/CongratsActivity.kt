package com.example.productsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView

class CongratsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)


        val text: TextView = findViewById(R.id.congrats)
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.up_to_down_animation)
        text.startAnimation(animation)

        val text2: TextView = findViewById(R.id.order_placed)
        val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.down_to_up_animation)
        text2.startAnimation(animation2)


    }
}