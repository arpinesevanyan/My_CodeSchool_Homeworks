package com.example.mycodeschoolhomeworks.box.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.mycodeschoolhomeworks.R

class CustomCheckBoxActivity : AppCompatActivity() {
    var checkBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_check_box)

        checkBox = findViewById(R.id.checkBox)

    }

    fun disableCheckBox(view: View) {
        checkBox?.isEnabled = false
    }

    fun enableCheckBox(view: View) {
        checkBox?.isEnabled = true
    }
}