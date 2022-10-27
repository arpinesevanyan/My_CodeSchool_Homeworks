package com.example.mycodeschoolhomeworks.recyclerview.ui.postlist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycodeschoolhomeworks.box.activity.Utils
import com.example.mycodeschoolhomeworks.databinding.ActivityPostListBinding
import com.example.mycodeschoolhomeworks.recyclerview.data.model.*
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.PostsAdapter
import com.example.mycodeschoolhomeworks.recyclerview.ui.postlist.activities.FullScreenImageActivity
import com.example.mycodeschoolhomeworks.recyclerview.ui.postlist.activities.WebViewActivity


class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostListBinding

    private val items = Post.getData()
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterClick()

        binding.postRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@PostListActivity)
            adapter = postsAdapter
        }
        postsAdapter.updateData(items)
    }

    @SuppressLint("SetTextI18n")
    private fun adapterClick() {
        postsAdapter = PostsAdapter { action, post ->
            when (action) {
                PostsAdapter.PostActionEnum.ACTION_URL_ITEM_CLICK -> {
                    post as UrlPost
                    val intent = Intent(this@PostListActivity, WebViewActivity::class.java)
                    intent.putExtra(PostsAdapter.URL_FOR_WEB_VIEW, post.url)
                    startActivity(intent)
                }
                PostsAdapter.PostActionEnum.ACTION_IMAGE_ITEM_CLICK -> {
                    post as ImagePost

                    val intent = Intent(this@PostListActivity, FullScreenImageActivity::class.java)
                    intent.putExtra(PostsAdapter.FULL_SCREEN_IMAGE, post.imageUrl)
                    startActivity(intent)
                }
                PostsAdapter.PostActionEnum.ACTION_SHARE_TEXT -> {
                    post as TextPost
                    Utils.share(this, post.text, "text/plain")
                }
                PostsAdapter.PostActionEnum.ACTION_SHARE_IMAGE -> {
                    post as ImagePost
                    Utils.share(this, post.imageUrl, "image/jpeg")
                }
                PostsAdapter.PostActionEnum.ACTION_SHARE_VIDEO -> {
                    post as VideoPost
                    Utils.share(this, post.videoUrl, "image/jpeg")
                }
                PostsAdapter.PostActionEnum.ACTION_SHARE_URL -> {
                    post as UrlPost
                    Utils.share(this, post.url, "image/jpeg")
                }
            }
        }
        postsAdapter.updateData(items)
    }
}