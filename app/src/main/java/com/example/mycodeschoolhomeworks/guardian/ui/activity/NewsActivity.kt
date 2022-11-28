package com.example.mycodeschoolhomeworks.guardian.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.databinding.ActivityNewsBinding
import com.example.mycodeschoolhomeworks.guardian.BaseActivity
import com.example.mycodeschoolhomeworks.guardian.data.repository.NewsRepositoryImpl
import com.example.mycodeschoolhomeworks.guardian.viewmodel.NewsViewModelProviderFactory
import com.example.mycodeschoolhomeworks.guardian.ui.fragment.ContentNewsFragment
import com.example.mycodeschoolhomeworks.guardian.viewmodel.NewsViewModel

class NewsActivity : BaseActivity() {

    private lateinit var binding : ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository=NewsRepositoryImpl()
        val viewModelProviderFactory= NewsViewModelProviderFactory(application, newsRepository)
        viewModel=ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        replaceFragment(ContentNewsFragment.newInstance(), R.id.containerGuardian)
    }
}