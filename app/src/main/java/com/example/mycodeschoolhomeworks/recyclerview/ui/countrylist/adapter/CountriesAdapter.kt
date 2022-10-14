package com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum

class CountriesAdapter(val countryItemClickListener: OnCountryItemClickListener) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private val items = CountryEnum.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])
    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imageViewFlag: ImageView
        private var capital: TextView
        private var independenceDay: TextView

        init {
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag)
            capital = itemView.findViewById(R.id.capital)
            independenceDay = itemView.findViewById(R.id.independenceDay)

            itemView.setOnClickListener {
                val currentItem = items[absoluteAdapterPosition]
                countryItemClickListener.onCountryItemClicked(currentItem)
            }
            capital.setOnClickListener {
                    val clipboardManager = itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(LABEL, capital.text))
                    Toast.makeText(itemView.context, "Copied", Toast.LENGTH_SHORT).show()
                    false
            }
        }

        fun bind(country: CountryEnum) {
            Glide.with(itemView.context).load(country.imageUrl).into(imageViewFlag)
            capital.text = country.capital
            independenceDay.text = country.independenceDay
        }
    }

    interface OnCountryItemClickListener {
        fun onCountryItemClicked(countryEnum: CountryEnum)
    }
    companion object {
        const val LONG_DESCRIPTION = "long description"
        const val LABEL = "label"
    }
}