package com.example.mycodeschoolhomeworks.guardian.data.repository

import com.example.mycodeschoolhomeworks.guardian.data.api.RetrofitInstance


class NewsRepositoryImpl : NewsRepository {
    override fun getContentNews(pageNumber: Int) =
        RetrofitInstance.api?.getContent(pageNumber, "thumbnail")
}