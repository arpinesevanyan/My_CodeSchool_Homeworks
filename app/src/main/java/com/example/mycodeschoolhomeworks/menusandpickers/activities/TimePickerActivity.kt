package com.example.mycodeschoolhomeworks.menusandpickers.activities

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import java.util.Calendar

class TimePickerActivity : AppCompatActivity() {

    private lateinit var timeView: TextView
    private lateinit var timePickerButton: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        timeView = findViewById(R.id.timeView)
        timePickerButton = findViewById(R.id.timePickerButton)

        timePickerButton.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, { view, hourOfDay, minute ->
                timeView.setText("$hourOfDay:$minute")
            }, startHour, startMinute, false).show()
        }
    }
}