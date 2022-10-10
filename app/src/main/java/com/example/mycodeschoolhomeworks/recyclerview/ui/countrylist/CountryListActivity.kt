package com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter.CountriesAdapter

class CountryListActivity : AppCompatActivity(), CountriesAdapter.OnCountryItemClickListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager =  LinearLayoutManager(this@CountryListActivity)
            adapter =  CountriesAdapter(this@CountryListActivity)
        }
    }

    override fun onCountryItemClicked(countryEnum: CountryEnum) {
        // TODO:   start activity and send country Enum with bundles
    }
}