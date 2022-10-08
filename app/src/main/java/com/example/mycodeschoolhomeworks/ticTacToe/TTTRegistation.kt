package com.example.mycodeschoolhomeworks.ticTacToe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R

class TTTRegistation : AppCompatActivity(), View.OnClickListener {
    lateinit var playerOneName: EditText
    lateinit var playerTwoName: EditText
    lateinit var startGameButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tttregistation)

        playerOneName = findViewById(R.id.playerOneName)
        playerTwoName = findViewById(R.id.playerTwoName)
        startGameButton = findViewById(R.id.startGameButton)

        startGameButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val playerOneName = playerOneName.text.toString()
        val playerTwoName = playerTwoName.text.toString()

        when (playerOneName) {
            playerTwoName -> Toast.makeText(
                this,
                "Player One name must not be equals to player two name", Toast.LENGTH_SHORT
            )
            else -> {
                val intent = Intent(this, TTTGameActivity::class.java)
                intent.putExtra("PLAYER_ONE_NAME", playerOneName)
                intent.putExtra("PLAYER_TWO_NAME", playerTwoName)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val PLAYER_ONE_NAME = "player_one_name"
        const val PLAYER_TWO_NAME = "player_two_name"
    }
}
