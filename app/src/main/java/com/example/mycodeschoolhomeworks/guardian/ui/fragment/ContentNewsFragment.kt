package com.example.mycodeschoolhomeworks.guardian.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycodeschoolhomeworks.databinding.FragmentContentNewsBinding
import com.example.mycodeschoolhomeworks.guardian.BaseFragment
import com.example.mycodeschoolhomeworks.guardian.ui.activity.NewsActivity
import com.example.mycodeschoolhomeworks.guardian.utils.Constants.QUERY_PAGE_SIZE
import com.example.mycodeschoolhomeworks.guardian.utils.Resource
import com.example.mycodeschoolhomeworks.guardian.viewmodel.NewsViewModel


class ContentNewsFragment : BaseFragment() {
    private lateinit var binding: FragmentContentNewsBinding
    lateinit var newsAdapter: ContentNewsAdapter
    var isLastPage = false
    var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.contentNewsCall()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentNewsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        observeLiveData()
        return binding.root
    }

    private fun observeLiveData() {
        viewModel.contentNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.updateData(newsResponse.response.results)
                        val totalPages = newsResponse.response.pageSize / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.contentNewsPage == totalPages
                        if (isLastPage) {
                            binding.contentNewsRecyclerView.setPadding(0, 0, 0, 0)
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        isLoading = true
    }

    private fun setupRecyclerView() {
        newsAdapter = ContentNewsAdapter()
        binding.contentNewsRecyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentNewsFragment()
    }
}