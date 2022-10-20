package com.example.mycodeschoolhomeworks.box.activity

import android.content.Intent
import android.content.Intent.EXTRA_SUBJECT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.mycodeschoolhomeworks.R

class ReactionButtonGroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_button_group)

        val reactionLayout = findViewById<LinearLayoutCompat>(R.id.reactionLayout)
        val likeButton = findViewById<RadioButton>(R.id.likeButton)
        val commentButton = findViewById<RadioButton>(R.id.commentButton)
        val shareButton = findViewById<RadioButton>(R.id.shareButton)

        likeButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, likeButton.text, Toast.LENGTH_SHORT).show()
        })

        commentButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, commentButton.text, Toast.LENGTH_SHORT).show()
        })

        shareButton.setOnClickListener(View.OnClickListener {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.putExtra(EXTRA_SUBJECT, myIntent)
            startActivity(Intent.createChooser(myIntent, "Share your post"))
            Toast.makeText(this, shareButton.text, Toast.LENGTH_SHORT).show()
        })
    }
}