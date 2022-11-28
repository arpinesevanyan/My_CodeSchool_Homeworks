package com.example.mycodeschoolhomeworks.guardian.data.repository

import com.example.mycodeschoolhomeworks.guardian.data.model.ContentNews
import retrofit2.Call

interface NewsRepository {
    fun getContentNews(pageNumber: Int):Call<ContentNews>?
}