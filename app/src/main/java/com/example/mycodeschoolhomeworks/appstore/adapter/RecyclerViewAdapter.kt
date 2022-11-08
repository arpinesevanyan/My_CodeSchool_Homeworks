package com.example.mycodeschoolhomeworks.appstore.adapter

import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.appstore.data.TabItemEnum

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val items = TabItemEnum.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_top_charts, parent, false)
        )

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var viewPagerTopCharts: ViewPager2
        private var topChartsButton: AppCompatButton
        private var categoriesButton: AppCompatButton

        init {
            viewPagerTopCharts = itemView.findViewById(R.id.viewPagerTopCharts)
            topChartsButton = itemView.findViewById(R.id.topChartsButton)
            categoriesButton = itemView.findViewById(R.id.categoriesButton)

            topChartsButton.setOnClickListener {

            }
            categoriesButton.setOnClickListener {
                val clipboardManager =
                    itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                Toast.makeText(itemView.context, "", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}