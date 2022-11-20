package com.example.mycodeschoolhomeworks.weatherapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycodeschoolhomeworks.weatherapp.adapters.WeatherModel

class WeatherViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}