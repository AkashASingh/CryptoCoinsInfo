package com.example.CryptoCoinsInfo.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.CryptoCoinsInfo.MainActivity
import com.example.CryptoCoinsInfo.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initiateSplashAnimation()
    }

    private fun initiateSplashAnimation() {
        val splashImageView = findViewById<ImageView>(R.id.animation_view)
        splashImageView.animate().setDuration(4000).alpha(1f).withEndAction {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
        finish()
    }
}