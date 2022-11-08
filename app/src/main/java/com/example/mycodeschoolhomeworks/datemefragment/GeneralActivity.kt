package com.example.mycodeschoolhomeworks.datemefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.datemefragment.datamodel.DataModel
import com.example.mycodeschoolhomeworks.datemefragment.fragments.WelcomeFragment

class GeneralActivity : AppCompatActivity() {
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)

        openFragment(WelcomeFragment.newInstance(), R.id.fragmentContainer)

        dataModel.message.observe(this, {

        })
    }

    private fun openFragment(fragment: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }
}
