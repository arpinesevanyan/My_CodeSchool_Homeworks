package com.example.mycodeschoolhomeworks.appstore.fragments.gamesfragments.childfragmentsgames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycodeschoolhomeworks.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TopChartsFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_charts, container, false)
    }

//    fun newInstance(): {
//        val args = Bundle()
//
//        val fragment = ()
//        fragment.arguments = args
//        return fragment
//    }
}