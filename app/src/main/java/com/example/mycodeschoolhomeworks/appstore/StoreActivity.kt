package com.example.mycodeschoolhomeworks.appstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.base.StoreBaseActivity
import com.example.mycodeschoolhomeworks.appstore.fragments.AppsMainTabFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.GamesMainTabFragment
import com.example.mycodeschoolhomeworks.databinding.ActivityStoreBinding

class StoreActivity : StoreBaseActivity() {

    private lateinit var binding: ActivityStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationBarBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.apps -> replaceFragment(
                    AppsMainTabFragment.newInstance(),
                    R.id.appsFragmentContainer
                )
                R.id.games -> replaceFragment(
                    GamesMainTabFragment.newInstance(),
                    R.id.appsFragmentContainer
                )
            }
            true
        }
        binding.navigationBarBottom.selectedItemId = R.id.games
    }

}