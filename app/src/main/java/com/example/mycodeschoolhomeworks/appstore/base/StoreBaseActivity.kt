package com.example.mycodeschoolhomeworks.appstore.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mycodeschoolhomeworks.R

open class StoreBaseActivity : AppCompatActivity() {
   fun replaceFragment(fragment: Fragment, resId: Int){
       supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
   }
}