package com.denispotapov.dagger2test2022.data

import com.denispotapov.dagger2test2022.data.model.News
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

    @GET("news")
    suspend fun news(): List<News>

    @GET("news/{id}")
    suspend fun news(@Path("id") id: String): News
}
