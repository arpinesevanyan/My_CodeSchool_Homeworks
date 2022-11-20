package com.example.mycodeschoolhomeworks.appstore.base

import androidx.fragment.app.Fragment

open class StoreBaseFragment : Fragment() {
    fun replaceFragment(activity: StoreBaseActivity, resId: Int, fragment: Fragment) {
        activity.replaceFragment(fragment, resId)
    }
}