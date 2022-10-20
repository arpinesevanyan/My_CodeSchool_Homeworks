package com.example.mycodeschoolhomeworks.recyclerview.ui.countryinfo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.CountriesAdapter.Companion.LONG_DESCRIPTION

class CountryInfoActivity : AppCompatActivity() {

    private lateinit var countryInfoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        countryInfoTextView = findViewById(R.id.countryInfoTextView)
        countryInfoTextView.text = intent.getStringExtra(LONG_DESCRIPTION)

    }
}

