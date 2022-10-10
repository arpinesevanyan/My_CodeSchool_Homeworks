package com.example.mycodeschoolhomeworks.recyclerview.ui.countrylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.CountryEnum

class CountriesAdapter(val countryItemClickListener: OnCountryItemClickListener) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private val items = CountryEnum.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent))

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
                val currentItem = items[adapterPosition]
                countryItemClickListener.onCountryItemClicked(currentItem)
            }
        }

        fun bind(country: CountryEnum) {
            // TODO: must use Glide
//            imageViewFlag.setImageResource(country.imageResource)
            capital.text = country.capital
            independenceDay.text = country.independenceDay
        }
    }

    interface OnCountryItemClickListener {
        fun onCountryItemClicked(countryEnum: CountryEnum)
    }
}