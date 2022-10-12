package com.example.mycodeschoolhomeworks.recyclerview.ui.countryinfo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter.CountriesAdapter.Companion.LONG_DESCRIPTION

class CountryInfoActivity : AppCompatActivity() {
    private lateinit var countryInfoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        countryInfoTextView = findViewById(R.id.countryInfoTextView)
        countryInfoTextView.text = intent.getStringExtra(LONG_DESCRIPTION)
    }
}

