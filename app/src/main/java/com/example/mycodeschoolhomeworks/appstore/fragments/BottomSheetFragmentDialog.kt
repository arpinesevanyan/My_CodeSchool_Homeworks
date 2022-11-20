package com.example.mycodeschoolhomeworks.appstore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mycodeschoolhomeworks.appstore.adapter.MainAdapter
import com.example.mycodeschoolhomeworks.databinding.FragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragmentDialog(dataList: MutableList<Any>) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetDialogBinding
    private val mainAdapter = MainAdapter()
    private var mDataList = dataList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomSheetDialogRecyclerView.apply {
            adapter = mainAdapter
            mainAdapter.updateData(mDataList)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(dataList: MutableList<Any>) = BottomSheetFragmentDialog(dataList)
    }
}