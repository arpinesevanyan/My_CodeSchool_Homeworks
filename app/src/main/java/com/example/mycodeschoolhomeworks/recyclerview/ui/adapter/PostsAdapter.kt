package com.example.mycodeschoolhomeworks.recyclerview.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.recyclerview.data.model.PostType

open class PostsAdapter(val postsItemClickListener: OnPostItemClickListener) :
    RecyclerView.Adapter<PostsAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater
    private val items: MutableList<PostType> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TEXT_POST -> TextViewHolder(layoutInflater.inflate(R.layout.text_view, parent, false))
        IMAGE_POST -> ImageViewHolder(layoutInflater.inflate(R.layout.image_view, parent, false))
        VIDEO_POST -> VideoViewHolder(layoutInflater.inflate(R.layout.video_view, parent, false))
        else -> throw java.lang.IllegalArgumentException("undefined viewType: $viewType in ${this::class.java.simpleName}")
    }

    override fun onBindViewHolder(holder: PostsAdapter.BaseViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].type

    fun updateData(items: MutableList<PostType>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface OnPostItemClickListener {
        fun onPostItemClicked(postType: PostType)
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: PostType)

    }

    inner class TextViewHolder(itemView: View) : BaseViewHolder(itemView) {

        override fun bind(item: PostType) {

        }
    }

    inner class ImageViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(item: PostType) {

        }
    }

    inner class VideoViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(item: PostType) {

        }
    }

    companion object {

        private const val UNDEFINED = -1

        private const val TEXT_POST = 1
        private const val IMAGE_POST = 2
        private const val VIDEO_POST = 3
    }
}
