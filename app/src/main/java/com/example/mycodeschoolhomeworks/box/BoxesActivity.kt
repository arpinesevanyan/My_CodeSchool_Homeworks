package com.example.mycodeschoolhomeworks.box

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.box.activity.CheckBoxActivity
import com.example.mycodeschoolhomeworks.box.activity.CustomCheckBoxActivity
import com.example.mycodeschoolhomeworks.box.activity.CustomRadioButtonActivity
import com.example.mycodeschoolhomeworks.box.activity.RadioGroupActivity

class BoxesActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boxes)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        Box.values().forEach {
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
        when (p0?.tag as Box) {
            Box.CHECK_BOX -> startActivity(
                Intent(
                    this,
                    CheckBoxActivity::class.java
                )
            )
            Box.CUSTOM_CHECK_BOX-> startActivity(
                Intent(
                    this,
                    CustomCheckBoxActivity::class.java
                )
            )
            Box.RADIO_GROUP -> startActivity(
                Intent(
                    this,
                    RadioGroupActivity::class.java
                )
            )
            Box.CUSTOM_RADIO_BUTTON-> startActivity(
                Intent(
                    this,
                    CustomRadioButtonActivity::class.java
                )
            )
        }
    }
}

enum class Box {
    RADIO_GROUP,
    CUSTOM_RADIO_BUTTON,
    CHECK_BOX,
    CUSTOM_CHECK_BOX
}