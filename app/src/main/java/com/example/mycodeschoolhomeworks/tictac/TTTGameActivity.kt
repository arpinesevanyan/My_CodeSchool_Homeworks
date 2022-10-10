package com.example.mycodeschoolhomeworks.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.tictac.TTTRegistation.Companion.PLAYER_ONE_NAME
import com.example.mycodeschoolhomeworks.tictac.TTTRegistation.Companion.PLAYER_TWO_NAME

class TTTGameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: ImageView
    private lateinit var button2: ImageView
    private lateinit var button3: ImageView
    private lateinit var button4: ImageView
    private lateinit var button5: ImageView
    private lateinit var button6: ImageView
    private lateinit var button7: ImageView
    private lateinit var button8: ImageView
    private lateinit var button9: ImageView
    private lateinit var playerOneName: AppCompatButton
    private lateinit var playerTwoName: AppCompatButton
    private var table =
        arrayOf(arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '), arrayOf(' ', ' ', ' '))
    private var queue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tttgame)

        intent?.let {
            val playerOneName: String = it.getStringExtra(PLAYER_ONE_NAME) ?: "player 1"
            val playerTwoName: String = it.getStringExtra(PLAYER_TWO_NAME) ?: "player 2"
        }

        playerOneName = findViewById(R.id.playerOneName)
        playerTwoName = findViewById(R.id.playerTwoName)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        button9.setOnClickListener(this)
        button8.setOnClickListener(this)
        button7.setOnClickListener(this)
        button6.setOnClickListener(this)
        button5.setOnClickListener(this)
        button4.setOnClickListener(this)
        button3.setOnClickListener(this)
        button2.setOnClickListener(this)
        button1.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            button9 -> button9.setOnClickListener {
                if (!queue && table[0][2] == ' ') {
                    button9.setImageResource(R.drawable.icon_x_for_ttt)
                    table[0][2] = 'x'
                    queue = true
                } else if (queue && table[0][2] == ' ') {
                    button9.setImageResource(R.drawable.icon_0_for_ttt)
                    table[0][2] = 'o'
                    queue = false
                }
            }

            button8 -> button8.setOnClickListener {
                if (!queue && table[0][1] == ' ') {
                    button8.setImageResource(R.drawable.icon_x_for_ttt)
                    table[0][1] = 'x'
                    queue = true
                } else if (queue && table[0][1] == ' ') {
                    button8.setImageResource(R.drawable.icon_0_for_ttt)
                    table[0][1] = 'o'
                    queue = false
                }
            }

            button7 -> button7.setOnClickListener {
                if (!queue && table[0][0] == ' ') {
                    button7.setImageResource(R.drawable.icon_x_for_ttt)
                    table[0][0] = 'x'
                    queue = true
                } else if (queue && table[0][0] == ' ') {
                    button7.setImageResource(R.drawable.icon_0_for_ttt)
                    table[0][0] = 'o'
                    queue = false
                }
            }
            button6 -> button6.setOnClickListener {
                if (!queue && table[2][2] == ' ') {
                    button6.setImageResource(R.drawable.icon_x_for_ttt)
                    table[2][2] = 'x'
                    queue = true
                } else if (queue && table[2][2] == ' ') {
                    button6.setImageResource(R.drawable.icon_0_for_ttt)
                    table[2][2] = 'o'
                    queue = false
                }
            }

            button5 -> button5.setOnClickListener {
                if (!queue && table[1][1] == ' ') {
                    button5.setImageResource(R.drawable.icon_x_for_ttt)
                    table[1][1] = 'x'
                    queue = true
                } else if (queue && table[1][1] == ' ') {
                    button5.setImageResource(R.drawable.icon_0_for_ttt)
                    table[1][1] = 'o'
                    queue = false
                }
            }

            button4 -> button4.setOnClickListener {
                if (!queue && table[1][0] == ' ') {
                    button4.setImageResource(R.drawable.icon_x_for_ttt)
                    table[1][0] = 'x'
                    queue = true
                } else if (queue && table[1][0] == ' ') {
                    button4.setImageResource(R.drawable.icon_0_for_ttt)
                    table[1][0] = 'o'
                    queue = false
                }
            }
            button3 -> button3.setOnClickListener {
                if (!queue && table[2][2] == ' ') {
                    button3.setImageResource(R.drawable.icon_x_for_ttt)
                    table[2][2] = 'x'
                    queue = true
                } else if (queue && table[2][2] == ' ') {
                    button3.setImageResource(R.drawable.icon_0_for_ttt)
                    table[2][2] = 'o'
                    queue = false
                }
            }

            button2 -> button2.setOnClickListener {
                if (!queue && table[2][1] == ' ') {
                    button2.setImageResource(R.drawable.icon_x_for_ttt)
                    table[2][1] = 'x'
                    queue = true
                } else if (queue && table[2][1] == ' ') {
                    button2.setImageResource(R.drawable.icon_0_for_ttt)
                    table[2][1] = 'o'
                    queue = false
                }
            }

            button1 -> button1.setOnClickListener {
                if (!queue && table[2][0] == ' ') {
                    button1.setImageResource(R.drawable.icon_x_for_ttt)
                    table[2][0] = 'x'
                    queue = true
                } else if (queue && table[2][0] == ' ') {
                    button1.setImageResource(R.drawable.icon_0_for_ttt)
                    table[2][0] = 'o'
                    queue = false
                }
            }
        }
    }
}
