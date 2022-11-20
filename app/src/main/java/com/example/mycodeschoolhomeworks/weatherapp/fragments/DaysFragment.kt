package com.example.mycodeschoolhomeworks.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.databinding.FragmentDaysBinding
import com.example.mycodeschoolhomeworks.weatherapp.adapters.WeatherAdapter
import com.example.mycodeschoolhomeworks.weatherapp.adapters.WeatherModel
import com.example.mycodeschoolhomeworks.weatherapp.model.WeatherViewModel

class DaysFragment : Fragment(), WeatherAdapter.Listener {
    private lateinit var adapter: WeatherAdapter
    private lateinit var binding: FragmentDaysBinding
    private val model: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner) {
            adapter.submitList(it.subList(1, it.size))
        }
    }

    private fun init() = with(binding) {
        adapter = WeatherAdapter(this@DaysFragment)
        daysRV.layoutManager = LinearLayoutManager(activity)
        daysRV.adapter = adapter
    }

    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value = item
    }

}