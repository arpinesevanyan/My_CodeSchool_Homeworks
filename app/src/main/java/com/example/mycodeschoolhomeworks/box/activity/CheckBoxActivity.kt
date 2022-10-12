package com.example.mycodeschoolhomeworks.box.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import com.example.mycodeschoolhomeworks.R

class CheckBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        //CheckBox
        val check1 = findViewById<AppCompatCheckBox>(R.id.checkBox1)
        val check2 = findViewById<AppCompatCheckBox>(R.id.checkBox2)
        val check3 = findViewById<AppCompatCheckBox>(R.id.checkBox3)
        val check4 = findViewById<AppCompatCheckBox>(R.id.checkBox4)
        val check5 = findViewById<AppCompatCheckBox>(R.id.checkBox5)

        val buttonCheck = findViewById<Button>(R.id.buttonCheck)

        buttonCheck.setOnClickListener(View.OnClickListener {
            if (check1.isChecked) {
                Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show()
            }
            if (check2.isChecked) {
                Toast.makeText(this, "Dark", Toast.LENGTH_SHORT).show()
            }
            if (check3.isChecked) {
                Toast.makeText(this, "C#", Toast.LENGTH_SHORT).show()
            }
            if (check4.isChecked) {
                Toast.makeText(this, "Java Script", Toast.LENGTH_SHORT).show()
            }
            if (check5.isChecked) {
                Toast.makeText(this, "Kotlin", Toast.LENGTH_SHORT).show()
            }
        })

        check1.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

        check2.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

        check3.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

        check4.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }

        check5.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}