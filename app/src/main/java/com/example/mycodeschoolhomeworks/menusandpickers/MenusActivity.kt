package com.example.mycodeschoolhomeworks.menusandpickers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.menusandpickers.activities.*

class MenusActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        Menu.values().forEach {
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
        when (p0?.tag as Menu) {
            Menu.CONTEXT_MENU -> startActivity(
                Intent(
                    this,
                    ContextMenuActivity::class.java
                )
            )
            Menu.DATE_PICKER -> startActivity(
                Intent(
                    this,
                    DataPickerActivity::class.java
                )
            )
            Menu.TIME_PICKER-> startActivity(
                Intent(
                    this,
                    TimePickerActivity::class.java
                )
            )
            Menu.OPTIONS_MENU-> startActivity(
                Intent(
                    this,
                    OptionsMenuActivity::class.java
                )
            )
        }
    }
}

enum class Menu {
    CONTEXT_MENU,
    DATE_PICKER,
    TIME_PICKER,
    OPTIONS_MENU
}