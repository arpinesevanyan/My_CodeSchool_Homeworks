package com.example.mycodeschoolhomeworks.appstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.fragments.appsfragments.AppsFragment
import com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.GamesFragment
import com.example.mycodeschoolhomeworks.databinding.ActivityStoreBinding

class StoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(GamesFragment())

        binding.navigationBarBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.games -> replaceFragment(GamesFragment())
                R.id.apps -> replaceFragment(AppsFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.appsFragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}