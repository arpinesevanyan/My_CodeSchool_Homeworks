package com.example.mycodeschoolhomeworks.tictac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R

class TTTHome : AppCompatActivity(), View.OnClickListener {
    private lateinit var playButton: AppCompatButton
    private lateinit var helpButton: AppCompatButton
    private lateinit var quitButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ttthome)

        playButton = findViewById(R.id.playButton)
        helpButton = findViewById(R.id.helpButton)
        quitButton = findViewById(R.id.quitButton)

        playButton.setOnClickListener(this)
        helpButton.setOnClickListener(this)
        quitButton.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view?.id) {
            R.id.playButton -> startActivity(Intent(this, TTTRegistation::class.java))
        }
    }

    //private fun showNotImplemented
}