package com.example.mycodeschoolhomeworks

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.box.BoxesActivity
import com.example.mycodeschoolhomeworks.calculator.CalculatorActivity
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.CountryListActivity
import com.example.mycodeschoolhomeworks.tictac.TTTRegistation

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        CodeSchoolHomeworks.values().forEach {
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
        when (p0?.tag as CodeSchoolHomeworks) {
            CodeSchoolHomeworks.CALCULATOR -> startActivity(
                Intent(
                    this,
                    CalculatorActivity::class.java
                )
            )
            CodeSchoolHomeworks.TIC_TAC -> startActivity(
                Intent(
                    this,
                    TTTRegistation::class.java
                )
            )
            CodeSchoolHomeworks.RADIO_GROUP -> startActivity(
                Intent(
                    this,
                    BoxesActivity::class.java
                )
            )
            CodeSchoolHomeworks.RECYCLER_VIEW -> startActivity(
                Intent(
                    this,
                    CountryListActivity::class.java
                )
            )
        }
    }
}

enum class CodeSchoolHomeworks {
    CALCULATOR,
    TIC_TAC,
    RADIO_GROUP,
    RECYCLER_VIEW
}