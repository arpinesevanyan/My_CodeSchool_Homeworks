package com.example.mycodeschoolhomeworks.recyclerview.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycodeschoolhomeworks.databinding.ImageViewBinding
import com.example.mycodeschoolhomeworks.databinding.TextViewBinding
import com.example.mycodeschoolhomeworks.databinding.UrlViewBinding
import com.example.mycodeschoolhomeworks.databinding.VideoViewBinding
import com.example.mycodeschoolhomeworks.recyclerview.data.model.ImagePost
import com.example.mycodeschoolhomeworks.recyclerview.data.model.TextPost
import com.example.mycodeschoolhomeworks.recyclerview.data.model.UrlPost
import com.example.mycodeschoolhomeworks.recyclerview.data.model.VideoPost

class PostsAdapter(private val postItemClickListener: (PostActionEnum, Any) -> Unit) :
    RecyclerView.Adapter<PostsAdapter.BaseViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<Any> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_TEXT_POST -> TextViewHolder(
            TextViewBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        VIEW_TYPE_VIDEO_POST -> VideoViewHolder(
            VideoViewBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        VIEW_TYPE_IMAGE_POST -> ImageViewHolder(
            ImageViewBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        VIEW_TYPE_URL_POST -> UrlViewHolder(UrlViewBinding.inflate(layoutInflater, parent, false))
        else -> throw IllegalArgumentException("undefined viewType: $viewType in ${this::class.java.simpleName}")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is TextPost -> VIEW_TYPE_TEXT_POST
            is VideoPost -> VIEW_TYPE_VIDEO_POST
            is ImagePost -> VIEW_TYPE_IMAGE_POST
            is UrlPost -> VIEW_TYPE_URL_POST
            else -> UNDEFINED
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: MutableList<Any>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: Any)
    }

    inner class TextViewHolder(private val binding: TextViewBinding) :
        BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                binding.statusView.isVisible = true
                binding.itemTextView.text =
                    (items[absoluteAdapterPosition] as TextPost).text.substring(0, 100)
            }
            binding.statusView.setOnClickListener {
                binding.statusView.isVisible = false
                binding.itemTextView.text = (items[absoluteAdapterPosition] as TextPost).text
            }
        }

        override fun bind(item: Any) {
            binding.statusView.isVisible = true
            (item as TextPost).let {

//                val text = item.text.substring(0, 100)
                binding.itemTextView.text = item.text
            }
        }
    }

    inner class VideoViewHolder(private val binding: VideoViewBinding) :
        BaseViewHolder(binding.root) {

        override fun bind(item: Any) {
            (item as VideoPost).let {
//                binding.videoPostView.setVideoURI(Uri.parse(it.videoUrl))
//                binding.videoPostView.setMediaController(MediaController(context))
//                binding.videoPostView.start()
            }
        }
    }

    inner class UrlViewHolder(private val binding: UrlViewBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                postItemClickListener(
                    PostActionEnum.ACTION_URL_ITEM_CLICK,
                    items[absoluteAdapterPosition]
                )
            }
            binding.urlPostIncludedLayout.shareButton.setOnClickListener {
                postItemClickListener(
                    PostActionEnum.ACTION_SHARE_URL,
                    items[absoluteAdapterPosition]
                )
            }
        }

        override fun bind(item: Any) {
            (item as UrlPost).let {
                binding.urlTextView.text = item.url
                Glide.with(context).load(item.imageUrl).into(binding.urlImageView)
            }
        }
    }

    inner class ImageViewHolder(private val binding: ImageViewBinding) :
        BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                postItemClickListener(
                    PostActionEnum.ACTION_IMAGE_ITEM_CLICK,
                    items[absoluteAdapterPosition]
                )
            }
        }

        override fun bind(item: Any) {
            (item as ImagePost).let {
                Glide.with(context).load(item.imageUrl).into(binding.imagePostView)
            }
        }
    }

    enum class PostActionEnum {
        ACTION_URL_ITEM_CLICK,
        ACTION_IMAGE_ITEM_CLICK,
        ACTION_SHARE_IMAGE,
        ACTION_SHARE_TEXT,
        ACTION_SHARE_URL,
        ACTION_SHARE_VIDEO

    }

    companion object {
        private const val UNDEFINED = -1

        private const val VIEW_TYPE_TEXT_POST = 1
        private const val VIEW_TYPE_URL_POST = 2
        private const val VIEW_TYPE_VIDEO_POST = 3
        private const val VIEW_TYPE_IMAGE_POST = 4

        const val URL_FOR_WEB_VIEW = "url for web view"
        const val FULL_SCREEN_IMAGE = "full screen image"
    }
}