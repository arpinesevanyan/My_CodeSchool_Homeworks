package com.example.mycodeschoolhomeworks.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.weatherapp.fragments.WeatherMainFragment

class WeatherMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.weatherFragmentsContainer, WeatherMainFragment()).commit()
    }
}



