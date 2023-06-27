package com.example.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aibuttonClick = findViewById<Button>(R.id.ai)
        aibuttonClick.setOnClickListener {
            finish()
            val intent = Intent(this, ai_mode::class.java)
            startActivity(intent)
        }

        val multiplayer_button = findViewById<Button>(R.id.multiplayer)
        multiplayer_button.setOnClickListener{
            finish()
            val intent = Intent(this, multiplayer_mode::class.java)
            startActivity(intent)
        }

        val creditsButton = findViewById<Button>(R.id.credits)
        creditsButton.setOnClickListener{
            finish()
            val intent = Intent(this, credits::class.java)
            startActivity(intent)
        }

        val exitButton = findViewById<Button>(R.id.exit)
        exitButton.setOnClickListener{
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
            alertDialog.setMessage("Do You Really Want To Exit?")
            alertDialog.setPositiveButton(
                "Yes"
            ) { _, _ ->
                finish()
            }
            alertDialog.setNegativeButton(
                "No"
            ) { _, _ -> }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()

        }
    }
}