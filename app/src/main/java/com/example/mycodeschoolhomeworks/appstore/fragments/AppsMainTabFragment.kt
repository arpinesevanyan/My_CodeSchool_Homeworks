package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseFragment
import com.example.mycodeschoolhomeworks.appstore.data.FragmentTypeEnum
import com.example.mycodeschoolhomeworks.databinding.FragmentAppsMainTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class AppsMainTabFragment : StoreBaseFragment() {

    private lateinit var binding: FragmentAppsMainTabBinding
    private val tabFragments = mutableListOf<StoreBaseFragment>(
        CategoriesFragment.newInstance(FragmentTypeEnum.APPS),
        ForYouFragment.newInstance(FragmentTypeEnum.APPS),
        KidsFragment.newInstance(FragmentTypeEnum.APPS),
        TopChartsFragment.newInstance(FragmentTypeEnum.APPS)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppsMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupStringResources()
    }

    private fun setupViews() {
        binding.viewPager.apply {
            adapter =
                object : FragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle) {
                    override fun createFragment(position: Int) = tabFragments[position]

                    override fun getItemCount(): Int = tabFragments.size
                }
            isUserInputEnabled = false
        }
    }

    private fun setupStringResources() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager, true) { tab, position ->
            when (tabFragments[position]) {
                is CategoriesFragment -> tab.text = getString(R.string.categories)
                is ForYouFragment -> tab.text = getString(R.string.for_you)
                is KidsFragment -> tab.text = getString(R.string.kids)
                is TopChartsFragment -> tab.text = getString(R.string.top_charts)
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AppsMainTabFragment()
    }
}