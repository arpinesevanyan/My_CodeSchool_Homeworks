package com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.adapter.FragmentAdapter
import com.example.mycodeschoolhomeworks.appstore.fragments.BaseFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.KidsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.PremiumFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames.TopChartsFragment
import com.google.android.material.tabs.TabLayout


open class GamesFragment : BaseFragment() {
    private lateinit var tableLayoutGames: TabLayout
    private lateinit var viewPagerGames: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_games, container, false)
        viewPagerGames = view.findViewById(R.id.viewPagerGames)
        tableLayoutGames = view.findViewById(R.id.tableLayoutGames)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fragmentAdapter = FragmentAdapter(requireActivity().supportFragmentManager)
        fragmentAdapter.addFragment(TopChartsFragment(), "Top Charts")
        fragmentAdapter.addFragment(KidsFragment(), "Kids")
        fragmentAdapter.addFragment(PremiumFragment(), "Premium")

//        viewPagerGames.adapter=fragmentAdapter
//        tableLayoutGames.setupWithViewPager(viewPagerGames)
    }
}
