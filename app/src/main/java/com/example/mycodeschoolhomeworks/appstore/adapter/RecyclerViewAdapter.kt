package com.example.mycodeschoolhomeworks.appstore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppsForYouDTO
import com.example.mycodeschoolhomeworks.appstore.data.apps_model.AppsKidsDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesForYouDTO
import com.example.mycodeschoolhomeworks.appstore.data.games_model.GamesKidsDTO
import com.example.mycodeschoolhomeworks.databinding.ItemScrollableRecyclerviewForuKidsBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.BaseViewHolder>(){
    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    private val items = mutableListOf<List<Any>>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        layoutInflater=LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = AppStoreViewHolder(
        ItemScrollableRecyclerviewForuKidsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =holder.bind(items[position])

    override fun getItemCount(): Int= items.size

    abstract class BaseViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        abstract fun bind(item: List<Any>)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<List<Any>>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private inner class AppStoreViewHolder(val binding: ItemScrollableRecyclerviewForuKidsBinding) : BaseViewHolder(binding.root){

        val adapter=MainAdapter()

        init {
            binding.scrollableForUAndKidsRecyclerView.adapter=adapter
        }

        override fun bind(item: List<Any>) {
           binding.titleTextview.text=when(item[absoluteAdapterPosition]){
               is GamesForYouDTO-> "Games For You"
               is AppsForYouDTO-> "Apps For You"
               is GamesKidsDTO-> "Games For Kids"
               is AppsKidsDTO-> "Apps For Kids"
               else -> "Other Programs"
           }
            adapter.updateData(item)
        }
    }
}