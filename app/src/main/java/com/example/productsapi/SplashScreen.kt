package com.example.productsapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val t1 = findViewById<TextView>(R.id.text)

        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.l_to_r_animation)
        t1.startAnimation(animation)

        val t2 = findViewById<TextView>(R.id.text2)

        val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.r_to_l_animation)
        t2.startAnimation(animation2)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {

              val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },4000)

    }
}