package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.appstore.adapter.RecyclerViewAdapter
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseFragment
import com.example.mycodeschoolhomeworks.appstore.data.FragmentTypeEnum
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppsForYouDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesForYouDTO
import com.example.mycodeschoolhomeworks.databinding.FragmentForYouBinding

class ForYouFragment(fragmentTypeEnum: FragmentTypeEnum) : StoreBaseFragment() {

    private lateinit var binding: FragmentForYouBinding
    private var mFragmentTypeEnum = fragmentTypeEnum

    private val adapter = RecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForYouBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.forYouRecyclerView.adapter = adapter
        adapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.GAMES -> listOf(
                    GamesForYouDTO.values().toList(),
                    GamesForYouDTO.values().toList(),
                    GamesForYouDTO.values().toList(),
                    GamesForYouDTO.values().toList()
                )
                FragmentTypeEnum.APPS -> listOf(
                    AppsForYouDTO.values().toList(),
                    AppsForYouDTO.values().toList(),
                    AppsForYouDTO.values().toList(),
                    AppsForYouDTO.values().toList()
                )
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = ForYouFragment(fragmentTypeEnum)
    }
}