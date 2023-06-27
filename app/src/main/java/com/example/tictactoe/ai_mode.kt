package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.max
import java.lang.Math.min


class ai_mode : AppCompatActivity() {

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

    fun minimax(board: ArrayList<Char>, ai_turn: Boolean): Int {

        if (no_moves(board)) {
            return terminal_state(board);
        } else {
            if (terminal_state(board) != 0) return terminal_state(board);
        }

        var best_move = -1
        if (ai_turn) {
            best_move = -100000;
            for (i in 0 until 9) {
                if (board[i] == ' ') {
                    board[i] = 'X';
                    var new_move: Int = minimax(board, false);
                    board[i] = ' ';
                    best_move = max(best_move, new_move);
                }
            }
        } else {
            best_move = 10000;
            for (i in 0 until 9) {
                if (board[i] == ' ') {
                    board[i] = 'O';
                    var new_move: Int = minimax(board, true);
                    board[i] = ' ';
                    best_move = min(best_move, new_move);
                }
            }
        }
        return best_move;
    }

    fun findBestMove(board: ArrayList<Char>): Int {
        var best_move: Int = -100000
        var cell = -1
        for (i in 0 until 9) {
            if (board[i] == ' ') {
                board[i] = 'X'
                var new_move: Int = minimax(board, false)
                if (new_move > best_move) {
                    best_move = new_move
                    cell = i
                }
                board[i] = ' '
            }
        }
        return cell
    }


    fun func(board: ArrayList<Char>) {

        if (terminal_state(board) == 1) {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ai_mode)
            alertDialog.setMessage("AI WINS!")
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
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ai_mode)
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

        val cell: Int = findBestMove(board)
        board[cell] = 'X'

        var pressed1 = findViewById<ImageView>(R.id.imageView)
        var pressed2 = findViewById<ImageView>(R.id.imageView2)
        var pressed3 = findViewById<ImageView>(R.id.imageView3)
        var pressed4 = findViewById<ImageView>(R.id.imageView4)
        var pressed5 = findViewById<ImageView>(R.id.imageView5)
        var pressed6 = findViewById<ImageView>(R.id.imageView6)
        var pressed7 = findViewById<ImageView>(R.id.imageView7)
        var pressed8 = findViewById<ImageView>(R.id.imageView8)
        var pressed9 = findViewById<ImageView>(R.id.imageView9)

        if(cell==0)pressed1.setImageResource(R.drawable.download)
        if(cell==1)pressed2.setImageResource(R.drawable.download)
        if(cell==2)pressed3.setImageResource(R.drawable.download)
        if(cell==3)pressed4.setImageResource(R.drawable.download)
        if(cell==4)pressed5.setImageResource(R.drawable.download)
        if(cell==5)pressed6.setImageResource(R.drawable.download)
        if(cell==6)pressed7.setImageResource(R.drawable.download)
        if(cell==7)pressed8.setImageResource(R.drawable.download)
        if(cell==8)pressed9.setImageResource(R.drawable.download)

        if (terminal_state(board) == 1) {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ai_mode)
            alertDialog.setMessage("AI WINS!")
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
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ai_mode)
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

        pressed1.setOnClickListener() {
            if(board[0]==' ') {
                board[0] = 'O'
                pressed1.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed2.setOnClickListener() {
            if(board[1]==' ') {
                board[1] = 'O'
                pressed2.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed3.setOnClickListener() {
            if(board[2]==' ') {
                board[2] = 'O'
                pressed3.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed4.setOnClickListener() {
            if(board[3]==' ') {
                board[3] = 'O'
                pressed4.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed5.setOnClickListener() {
            if(board[4]==' ') {
                board[4] = 'O'
                pressed5.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed6.setOnClickListener() {
            if(board[5]==' ') {
                board[5] = 'O'
                pressed6.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed7.setOnClickListener() {
            if(board[6]==' ') {
                board[6] = 'O'
                pressed7.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed8.setOnClickListener() {
            if(board[7]==' ') {
                board[7] = 'O'
                pressed8.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        pressed9.setOnClickListener() {
            if(board[8]==' ') {
                board[8] = 'O'
                pressed9.setImageResource(R.drawable.download__2_)
                func(board)
            }
        }
        return
    }

    fun first() {

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


        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@ai_mode)
        alertDialog.setMessage("Who Plays First?")
        alertDialog.setPositiveButton(
            "I Play First"
        ) { _, _ ->
            Toast.makeText(this@ai_mode, "You are Playing First.", Toast.LENGTH_LONG).show()
            var pressed1 = findViewById<ImageView>(R.id.imageView)
            var pressed2 = findViewById<ImageView>(R.id.imageView2)
            var pressed3 = findViewById<ImageView>(R.id.imageView3)
            var pressed4 = findViewById<ImageView>(R.id.imageView4)
            var pressed5 = findViewById<ImageView>(R.id.imageView5)
            var pressed6 = findViewById<ImageView>(R.id.imageView6)
            var pressed7 = findViewById<ImageView>(R.id.imageView7)
            var pressed8 = findViewById<ImageView>(R.id.imageView8)
            var pressed9 = findViewById<ImageView>(R.id.imageView9)

            pressed1.setOnClickListener() {
                if(board[0]==' ') {
                    board[0] = 'O'
                    pressed1.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed2.setOnClickListener() {
                if(board[1]==' ') {
                    board[1] = 'O'
                    pressed2.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed3.setOnClickListener() {
                if(board[2]==' ') {
                    board[2] = 'O'
                    pressed3.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed4.setOnClickListener() {
                if(board[3]==' ') {
                    board[3] = 'O'
                    pressed4.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed5.setOnClickListener() {
                if(board[4]==' ') {
                    board[4] = 'O'
                    pressed5.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed6.setOnClickListener() {
                if(board[5]==' ') {
                    board[5] = 'O'
                    pressed6.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed7.setOnClickListener() {
                if(board[6]==' ') {
                    board[6] = 'O'
                    pressed7.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed8.setOnClickListener() {
                if(board[7]==' ') {
                    board[7] = 'O'
                    pressed8.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
            pressed9.setOnClickListener() {
                if(board[8]==' ') {
                    board[8] = 'O'
                    pressed9.setImageResource(R.drawable.download__2_)
                    func(board)
                }
            }
        }
        alertDialog.setNegativeButton(
            "AI Plays First"
        ) { _, _ ->
            Toast.makeText(this@ai_mode, "AI is Playing First.", Toast.LENGTH_LONG).show()
            func(board)
        }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_mode)

        first()
        return
    }
}
