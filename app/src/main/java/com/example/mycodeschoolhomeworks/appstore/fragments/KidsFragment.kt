package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.adapter.RecyclerViewAdapter
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseFragment
import com.example.mycodeschoolhomeworks.appstore.data.FragmentTypeEnum
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppsKidsDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesKidsDTO
import com.example.mycodeschoolhomeworks.databinding.FragmentKidsBinding

class KidsFragment(fragmentTypeEnum: FragmentTypeEnum) : StoreBaseFragment() {

    private lateinit var binding: FragmentKidsBinding
    private val adapter = RecyclerViewAdapter()
    private var mFragmentTypeEnum = fragmentTypeEnum

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKidsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.kidsRecyclerView.adapter = adapter
        adapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.GAMES -> listOf(
                    AppsKidsDTO.values().toList(),
                )
                FragmentTypeEnum.APPS -> listOf(
                    GamesKidsDTO.values().toList(),
                )
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = KidsFragment(fragmentTypeEnum)
    }
}