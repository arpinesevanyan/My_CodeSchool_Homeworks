package com.example.mycodeschoolhomeworks

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.appstore.StoreActivity
import com.example.mycodeschoolhomeworks.box.BoxesActivity
import com.example.mycodeschoolhomeworks.calculator.CalculatorActivity
import com.example.mycodeschoolhomeworks.authorization.activities.HomeActivity
import com.example.mycodeschoolhomeworks.datemefragment.GeneralActivity
import com.example.mycodeschoolhomeworks.guardian.ui.activity.NewsActivity
import com.example.mycodeschoolhomeworks.menusandpickers.MenusActivity
import com.example.mycodeschoolhomeworks.recyclerview.RecyclerViewActivity
import com.example.mycodeschoolhomeworks.tictac.TTTRegistation
import com.example.mycodeschoolhomeworks.weatherapp.WeatherMainActivity

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
                    RecyclerViewActivity::class.java
                )
            )
            CodeSchoolHomeworks.MENUS_PICKERS -> startActivity(
                Intent(
                    this,
                    MenusActivity::class.java
                )
            )
            CodeSchoolHomeworks.CONTRACT -> startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )
            CodeSchoolHomeworks.DATE_ME -> startActivity(
                Intent(
                    this,
                    GeneralActivity::class.java
                )
            )
            CodeSchoolHomeworks.APP_STORE -> startActivity(
                Intent(
                    this,
                    StoreActivity::class.java
                )
            )
            CodeSchoolHomeworks.WEATHER_APP -> startActivity(
                Intent(
                    this,
                    WeatherMainActivity::class.java
                )
            )
            CodeSchoolHomeworks.GUARDIAN -> startActivity(
                Intent(
                    this,
                    NewsActivity::class.java
                )
            )
        }
    }
}

enum class CodeSchoolHomeworks {
    CALCULATOR,
    TIC_TAC,
    RADIO_GROUP,
    RECYCLER_VIEW,
    MENUS_PICKERS,
    CONTRACT,
    DATE_ME,
    APP_STORE,
    WEATHER_APP,
    GUARDIAN
}