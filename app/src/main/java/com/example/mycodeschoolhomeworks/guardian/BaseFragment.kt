package com.example.mycodeschoolhomeworks.guardian

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mycodeschoolhomeworks.guardian.BaseActivity
import com.example.mycodeschoolhomeworks.guardian.ui.activity.NewsActivity
import com.example.mycodeschoolhomeworks.guardian.viewmodel.NewsViewModel

open class BaseFragment : Fragment() {
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

    fun replaceFragment(activity: BaseActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }
}