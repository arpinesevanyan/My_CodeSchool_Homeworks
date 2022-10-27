package com.example.mycodeschoolhomeworks.box.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.mycodeschoolhomeworks.R

class RadioGroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonSelect = findViewById<Button>(R.id.buttonSelect)

        buttonSelect.setOnClickListener(View.OnClickListener {
            val selectButton: Int = radioGroup!!.checkedRadioButtonId
            val buttonSelect = findViewById<RadioButton>(selectButton)
            Toast.makeText(this, buttonSelect.text, Toast.LENGTH_SHORT).show()

        })
    }
}