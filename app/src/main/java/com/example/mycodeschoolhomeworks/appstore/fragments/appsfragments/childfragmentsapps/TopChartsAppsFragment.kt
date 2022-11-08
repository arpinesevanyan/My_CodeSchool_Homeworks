package com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.childfragmentsapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.AppsFragment

class TopChartsAppsFragment : AppsFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_charts_apps, container, false)
    }

}