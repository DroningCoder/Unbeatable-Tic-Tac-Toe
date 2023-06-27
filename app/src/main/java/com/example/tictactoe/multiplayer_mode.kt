package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class multiplayer_mode : AppCompatActivity() {

    fun no_moves(board: ArrayList<Char>): Boolean {
        for (i in 0 until 9) {
            if (board[i] == ' ') return false
        }
        return true
    }

    fun terminal_state(board: ArrayList<Char>): Int {

        if (board[0] == board[1] && board[1] == board[2] && board[2] == 'X') return 1
        if (board[3] == board[4] && board[4] == board[5] && board[5] == 'X') return 1
        if (board[6] == board[7] && board[7] == board[8] && board[8] == 'X') return 1

        if (board[0] == board[3] && board[3] == board[6] && board[6] == 'X') return 1
        if (board[1] == board[4] && board[4] == board[7] && board[7] == 'X') return 1
        if (board[2] == board[5] && board[5] == board[8] && board[8] == 'X') return 1

        if (board[0] == board[4] && board[4] == board[8] && board[8] == 'X') return 1
        if (board[2] == board[4] && board[4] == board[6] && board[6] == 'X') return 1



        if (board[0] == board[1] && board[1] == board[2] && board[2] == 'O') return -1
        if (board[3] == board[4] && board[4] == board[5] && board[5] == 'O') return -1
        if (board[6] == board[7] && board[7] == board[8] && board[8] == 'O') return -1

        if (board[0] == board[3] && board[3] == board[6] && board[6] == 'O') return -1
        if (board[1] == board[4] && board[4] == board[7] && board[7] == 'O') return -1
        if (board[2] == board[5] && board[5] == board[8] && board[8] == 'O') return -1

        if (board[0] == board[4] && board[4] == board[8] && board[8] == 'O') return -1
        if (board[2] == board[4] && board[4] == board[6] && board[6] == 'O') return -1

        return 0
    }

    fun play(board : ArrayList<Char>, xTurn : Boolean){

        if (terminal_state(board) == 1) {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@multiplayer_mode)
            alertDialog.setMessage("X WINS!")
            alertDialog.setPositiveButton(
                "Play Again"
            ) { _, _ ->
                finish()
                val mIntent = intent
                startActivity(mIntent)
            }
            alertDialog.setNegativeButton(
                "Main Menu"
            ) { _, _ ->
                finish()
                val k = Intent(this, MainActivity::class.java)
                startActivity(k)
            }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()
            return
        }

        else if (terminal_state(board) == -1) {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@multiplayer_mode)
            alertDialog.setMessage("O WINS!")
            alertDialog.setPositiveButton(
                "Play Again"
            ) { _, _ ->
                finish()
                val mIntent = intent
                startActivity(mIntent)
            }
            alertDialog.setNegativeButton(
                "Main Menu"
            ) { _, _ ->
                finish()
                val k = Intent(this, MainActivity::class.java)
                startActivity(k)
            }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()
            return
        }

        else if (terminal_state(board) == 0 && no_moves(board)) {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@multiplayer_mode)
            alertDialog.setMessage("DRAW!")
            alertDialog.setPositiveButton(
                "Play Again"
            ) { _, _ ->
                finish()
                val mIntent = intent
                startActivity(mIntent)
            }
            alertDialog.setNegativeButton(
                "Main Menu"
            ) { _, _ ->
                finish()
                val k = Intent(this, MainActivity::class.java)
                startActivity(k)
            }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()
            return
        }

        var pressed1 = findViewById<ImageView>(R.id.imageView)
        var pressed2 = findViewById<ImageView>(R.id.imageView2)
        var pressed3 = findViewById<ImageView>(R.id.imageView3)
        var pressed4 = findViewById<ImageView>(R.id.imageView4)
        var pressed5 = findViewById<ImageView>(R.id.imageView5)
        var pressed6 = findViewById<ImageView>(R.id.imageView6)
        var pressed7 = findViewById<ImageView>(R.id.imageView7)
        var pressed8 = findViewById<ImageView>(R.id.imageView8)
        var pressed9 = findViewById<ImageView>(R.id.imageView9)

        var text1 = findViewById<TextView>(R.id.textView)

        if(xTurn){
            text1.text = "X's Turn"
            text1.setTextColor(Color.parseColor("#009CCC"))
            pressed1.setOnClickListener() {
                if(board[0]==' ') {
                    board[0] = 'X'
                    pressed1.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed2.setOnClickListener() {
                if(board[1]==' ') {
                    board[1] = 'X'
                    pressed2.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed3.setOnClickListener() {
                if(board[2]==' ') {
                    board[2] = 'X'
                    pressed3.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed4.setOnClickListener() {
                if(board[3]==' ') {
                    board[3] = 'X'
                    pressed4.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed5.setOnClickListener() {
                if(board[4]==' ') {
                    board[4] = 'X'
                    pressed5.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed6.setOnClickListener() {
                if(board[5]==' ') {
                    board[5] = 'X'
                    pressed6.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed7.setOnClickListener() {
                if(board[6]==' ') {
                    board[6] = 'X'
                    pressed7.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed8.setOnClickListener() {
                if(board[7]==' ') {
                    board[7] = 'X'
                    pressed8.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
            pressed9.setOnClickListener() {
                if(board[8]==' ') {
                    board[8] = 'X'
                    pressed9.setImageResource(R.drawable.download)
                    play(board, false)
                }
            }
        }

        else{
            text1.text = "O's Turn"
            text1.setTextColor(Color.parseColor("#ff1b1c"))
            pressed1.setOnClickListener() {
                if(board[0]==' ') {
                    board[0] = 'O'
                    pressed1.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed2.setOnClickListener() {
                if(board[1]==' ') {
                    board[1] = 'O'
                    pressed2.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed3.setOnClickListener() {
                if(board[2]==' ') {
                    board[2] = 'O'
                    pressed3.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed4.setOnClickListener() {
                if(board[3]==' ') {
                    board[3] = 'O'
                    pressed4.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed5.setOnClickListener() {
                if(board[4]==' ') {
                    board[4] = 'O'
                    pressed5.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed6.setOnClickListener() {
                if(board[5]==' ') {
                    board[5] = 'O'
                    pressed6.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed7.setOnClickListener() {
                if(board[6]==' ') {
                    board[6] = 'O'
                    pressed7.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed8.setOnClickListener() {
                if(board[7]==' ') {
                    board[7] = 'O'
                    pressed8.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
            pressed9.setOnClickListener() {
                if(board[8]==' ') {
                    board[8] = 'O'
                    pressed9.setImageResource(R.drawable.download__2_)
                    play(board, true)
                }
            }
        }
    }

    fun multiMode(){

        var board = ArrayList<Char>()
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')
        board.add(' ')

        play(board,true)

        return

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplayer_mode)

        multiMode()
    }
}