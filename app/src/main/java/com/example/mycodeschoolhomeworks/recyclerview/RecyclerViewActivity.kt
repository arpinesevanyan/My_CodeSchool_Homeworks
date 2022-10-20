package com.example.mycodeschoolhomeworks.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.CountryListActivity
import com.example.mycodeschoolhomeworks.recyclerview.ui.postlist.PostListActivity

class RecyclerViewActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        RecyclerViews.values().forEach {
            val button = button(it.name)
            button.tag = it
            button.setOnClickListener(this)
            linearLayout.addView(button)
        }
    }

    private fun button(text: String): AppCompatButton {
        val button = AppCompatButton(this)
        button.text = text
        return button
    }

    override fun onClick(p0: View?) {
        when (p0?.tag as RecyclerViews) {
            RecyclerViews.COUNTRIES -> startActivity(
                Intent(
                    this,
                    CountryListActivity::class.java
                )
            )
            RecyclerViews.POSTS-> startActivity(
                Intent(
                    this,
                    PostListActivity::class.java
                )
            )
        }
    }
}
enum class RecyclerViews {
    COUNTRIES,
    POSTS
}