package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.adapter.MainAdapter
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseFragment
import com.example.mycodeschoolhomeworks.appstore.data.FragmentTypeEnum
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppCategoriesListEnum
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppTopChartsTopFreeDTO
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppsTopChartsDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesCategoriesListEnum
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesTopChartsDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesTopChartsTopFreeDTO
import com.example.mycodeschoolhomeworks.databinding.FragmentTopChartsBinding

class TopChartsFragment(fragmentTypeEnum: FragmentTypeEnum) : StoreBaseFragment() {

    private lateinit var binding: FragmentTopChartsBinding
    private val adapter = MainAdapter()
    private var mFragmentTypeEnum = fragmentTypeEnum

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopChartsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        val bottomSheetTopChartsCategoriesFragment = BottomSheetFragmentDialog.newInstance(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppCategoriesListEnum.values().toMutableList()
                FragmentTypeEnum.GAMES -> GamesCategoriesListEnum.values().toMutableList()
            }
        )
        val bottomSheetTopChartsTopFreeFragment = BottomSheetFragmentDialog.newInstance(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppTopChartsTopFreeDTO.values().toMutableList()
                FragmentTypeEnum.GAMES -> GamesTopChartsTopFreeDTO.values().toMutableList()
            }
        )
        binding.topChartsButton.setOnClickListener {
            bottomSheetTopChartsCategoriesFragment.show(requireActivity().supportFragmentManager, bottomSheetTopChartsCategoriesFragment.tag)
        }
        binding.categoriesButton.setOnClickListener {
            bottomSheetTopChartsTopFreeFragment.show(requireActivity().supportFragmentManager, bottomSheetTopChartsCategoriesFragment.tag)
        }
    }

    private fun setupViews() {
        binding.topChartsRecyclerView.adapter = adapter
        adapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppsTopChartsDTO.values().toList()
                FragmentTypeEnum.GAMES -> GamesTopChartsDTO.values().toList()
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = TopChartsFragment(fragmentTypeEnum)
    }
}