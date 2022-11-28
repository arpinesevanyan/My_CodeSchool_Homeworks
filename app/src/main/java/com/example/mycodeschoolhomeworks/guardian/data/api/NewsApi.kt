package com.example.mycodeschoolhomeworks.guardian.data.api

import com.example.mycodeschoolhomeworks.guardian.data.model.ContentNews
import com.example.mycodeschoolhomeworks.guardian.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers("api-key:${Constants.API_KEY}")
    @GET("search?")
    fun getContent(
        @Query("page-size") pageNumber: Int = 30,
        @Query("show-fields") showFields: String
    ): Call<ContentNews>
}