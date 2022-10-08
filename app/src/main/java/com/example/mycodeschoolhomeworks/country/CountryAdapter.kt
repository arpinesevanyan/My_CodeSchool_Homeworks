package com.example.mycodeschoolhomeworks.country

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R

class CountryAdapter(val context: Context) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private val items = mutableListOf<Country>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.countries_recycler_view, parent))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCountry = items[position]
        holder.bind(currentCountry)
    }

    fun update(items: MutableList<Country>?) {
        items?.let {
            this.items.clear()
            this.items.addAll(it)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewFlag: ImageView
        var capital: TextView
        var independenceDay: TextView

        init {
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag)
            capital = itemView.findViewById(R.id.capital)
            independenceDay = itemView.findViewById(R.id.independenceDay)
        }

        fun bind(country: Country) {
            imageViewFlag.setImageResource(country.imageResource)
            capital.text = country.capitalResource.toString()
            independenceDay.text = country.independenceDayResource.toString()
        }
    }
}

data class Country(
    val imageViewFlag: CountryEnum,
    val capital: CountryEnum,
    val independenceDay: CountryEnum
)
{ @DrawableRes
    var imageResource = when (imageViewFlag) {
        CountryEnum.ARMENIA-> R.id.armenianFlag
        CountryEnum.RUSSIA -> R.id.russianFlag
        CountryEnum.FRANCE -> R.id.franceFlag
        CountryEnum.USA -> R.id.usaFlag
        CountryEnum.UK -> R.id.ukFlag
        CountryEnum.GERMANY -> R.id.germanyFlag
        CountryEnum.ITALY -> R.id.italyFlag
        CountryEnum.SPAIN -> R.id.spainFlag
        CountryEnum.INDIA -> R.id.indianFlag
        CountryEnum.IRAN -> R.id.iranianFlag
    }
    var capitalResource= when (capital){
        CountryEnum.ARMENIA->R.id.capital
        CountryEnum.RUSSIA -> R.id.capital
        CountryEnum.FRANCE -> R.id.capital
        CountryEnum.USA -> R.id.capital
        CountryEnum.UK -> R.id.capital
        CountryEnum.GERMANY -> R.id.capital
        CountryEnum.ITALY -> R.id.capital
        CountryEnum.SPAIN -> R.id.capital
        CountryEnum.INDIA -> R.id.capital
        CountryEnum.IRAN -> R.id.capital
    }
    var independenceDayResource=when(independenceDay){
        CountryEnum.ARMENIA->R.id.independenceDay
        CountryEnum.RUSSIA -> R.id.independenceDay
        CountryEnum.FRANCE -> R.id.independenceDay
        CountryEnum.USA -> R.id.independenceDay
        CountryEnum.UK -> R.id.independenceDay
        CountryEnum.GERMANY -> R.id.independenceDay
        CountryEnum.ITALY -> R.id.independenceDay
        CountryEnum.SPAIN -> R.id.independenceDay
        CountryEnum.INDIA -> R.id.independenceDay
        CountryEnum.IRAN -> R.id.independenceDay
    }
}


