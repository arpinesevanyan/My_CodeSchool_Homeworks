package com.example.mycodeschoolhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.country.CountryAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private var layoutManager:RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<CountryAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)

        layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

        adapter=CountryAdapter(this)
        recyclerView.adapter=adapter

    }
}