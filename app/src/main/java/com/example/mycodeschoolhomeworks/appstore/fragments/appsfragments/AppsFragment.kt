package com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.adapter.FragmentAdapter
import com.example.mycodeschoolhomeworks.appstore.fragments.BaseFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.childfragmentsapps.CategoriesAppsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.childfragmentsapps.KidsAppsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.childfragmentsapps.TopChartsAppsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.KidsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.PremiumFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.TopChartsFragment
import com.google.android.material.tabs.TabLayout

open class AppsFragment : BaseFragment() {
    private lateinit var tableLayoutApps: TabLayout
    private lateinit var viewPagerApps: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apps, container, false)
        viewPagerApps = view.findViewById(R.id.viewPagerApps)
        tableLayoutApps = view.findViewById(R.id.tableLayoutApps)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fragmentAdapter = FragmentAdapter(requireActivity().supportFragmentManager)
        fragmentAdapter.addFragment(TopChartsAppsFragment(), "Top Charts")
        fragmentAdapter.addFragment(KidsAppsFragment(), "Kids")
        fragmentAdapter.addFragment(CategoriesAppsFragment(), "Categories")

//        viewPagerApps.adapter = fragmentAdapter
//        tableLayoutGames.setupWithViewPager(viewPagerGames)
    }
}