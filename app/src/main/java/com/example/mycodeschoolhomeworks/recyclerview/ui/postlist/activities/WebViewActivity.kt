package com.example.mycodeschoolhomeworks.recyclerview.ui.postlist.activities

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mycodeschoolhomeworks.databinding.ActivityWebViewBinding
import com.example.mycodeschoolhomeworks.recyclerview.ui.adapter.PostsAdapter

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra(PostsAdapter.URL_FOR_WEB_VIEW)

        binding.webView.apply {
            webViewClient = WebViewClient()
            if (url != null) {
                loadUrl(url)
            }
            settings.setSupportZoom(true)
        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack())
            binding.webView.goBack()
        else
            super.onBackPressed()
    }
}