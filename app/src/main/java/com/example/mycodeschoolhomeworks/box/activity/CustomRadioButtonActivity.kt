package com.example.mycodeschoolhomeworks.box.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import com.example.mycodeschoolhomeworks.R

class CustomRadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_radio_button)


        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        genderRadioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, chechedId ->
            when (chechedId) {
                R.id.male-> {
                    Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show()
                }
                R.id.female-> {
                    Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}