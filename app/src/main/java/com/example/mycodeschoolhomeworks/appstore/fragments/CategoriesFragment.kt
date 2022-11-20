package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.appstore.adapter.MainAdapter
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseFragment
import com.example.mycodeschoolhomeworks.appstore.data.FragmentTypeEnum
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppCategoriesListEnum
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesCategoriesListEnum
import com.example.mycodeschoolhomeworks.databinding.FragmentCategoriesBinding

class CategoriesFragment(fragmentTypeEnum: FragmentTypeEnum) : StoreBaseFragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val adapter = MainAdapter()
    private val mFragmentTypeEnum: FragmentTypeEnum = fragmentTypeEnum

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.categoriesRecyclerView.adapter = adapter

        adapter.updateData(
            when (mFragmentTypeEnum) {
                FragmentTypeEnum.APPS -> AppCategoriesListEnum.values().toList()
                FragmentTypeEnum.GAMES -> GamesCategoriesListEnum.values().toList()
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentTypeEnum: FragmentTypeEnum) = CategoriesFragment(fragmentTypeEnum)
    }
}