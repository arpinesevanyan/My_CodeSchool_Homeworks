package com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum
import com.example.mycodeschoolhomeworks.recyclerview.ui.countryinfo.CountryInfoActivity
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.CountriesAdapter
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.CountriesAdapter.Companion.LONG_DESCRIPTION

class CountryListActivity : AppCompatActivity(), CountriesAdapter.OnCountryItemClickListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)

        createSimpleDialog()

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CountryListActivity)
            adapter = CountriesAdapter(this@CountryListActivity)
        }
    }

    override fun onCountryItemClicked(countryEnum: CountryEnum) {
        intent = Intent(this, CountryInfoActivity::class.java)
        intent.putExtra(LONG_DESCRIPTION, countryEnum.longDescription)
        startActivity(intent)
    }

    private fun createSimpleDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog")
        builder.setMessage("This is Alert Dialog")
        builder.setNeutralButton("Info") { dialogInterface, i ->

        }

        builder.setNegativeButton("No") { dialog, i ->

        }

        builder.setPositiveButton("Yes") { dialog, i ->

        }

        builder.show()
    }

//   private fun createSimpleMultiChoiceDialog() {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Which country do you like best?")
//        builder.setMessage("This is my first Alert Dialog")
//        builder.setMultiChoiceItems(R.layout.activity_country_list, null) { dialog, wich, choice ->
//            Log.d("my Log", "My choice is : " + wich + "/ Is :" + choice)
//        }
//        builder.setNeutralButton("info") { dialogInterface, i ->
//
//        }
//        builder.setNegativeButton("No") { dialog, i ->
//
//        }
//        builder.setPositiveButton("Yes") { dialog, i ->
//
//        }
//        builder.show()
//    }
}