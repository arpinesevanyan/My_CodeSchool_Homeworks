package com.example.mycodeschoolhomeworks.recyclerview.ui.postlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.box.activity.ReactionButtonGroupActivity
import com.example.mycodeschoolhomeworks.recyclerview.data.model.PostType
import com.example.mycodeschoolhomeworks.recyclerview.data.model.TextPost
import com.example.mycodeschoolhomeworks.recyclerview.data.model.VideoPost
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.PostsAdapter

class PostListActivity : AppCompatActivity(), PostsAdapter.OnPostItemClickListener {

    private lateinit var postRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)
        postRecyclerView = findViewById(R.id.postRecyclerView)

        val items = mutableListOf<PostType>()
        items.add(TextPost(1, "This is just a beginning"))
        items.add(TextPost(1, "Make love not war"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))
        items.add(VideoPost(2, "https://www.youtube.com/watch?v=31E2tSxE35I"))

        val postAdapter = PostsAdapter(this)

        postRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@PostListActivity)
            adapter = postAdapter
        }

        postAdapter.updateData(items)
    }

    override fun onPostItemClicked(postType: PostType) {
        intent = Intent(this, PostType::class.java)
        intent=Intent(this, ReactionButtonGroupActivity::class.java)
        startActivity(intent)
    }
}