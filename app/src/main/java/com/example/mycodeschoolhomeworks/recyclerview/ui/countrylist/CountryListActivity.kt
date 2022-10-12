package com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum
import com.example.mycodeschoolhomeworks.recyclerview.ui.countryinfo.CountryInfoActivity
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter.CountriesAdapter
import com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter.CountriesAdapter.Companion.LONG_DESCRIPTION

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
        intent = Intent(this, CountryInfoActivity::class.java)
        intent.putExtra(LONG_DESCRIPTION, countryEnum.longDescription)
        startActivity(intent)
    }
}