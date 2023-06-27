package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import kotlinx.coroutines.delay

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        Handler(Looper.getMainLooper()).postDelayed(3000){
            startActivity(Intent(this,MainActivity::class.java))
        finish()
        }
    }
}