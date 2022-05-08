package com.denispotapov.dagger2test2022.data

import com.denispotapov.dagger2test2022.data.model.News
import javax.inject.Inject

interface NewsRepository {

    suspend fun getNews(newsId: String): News
}

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val analytics: Analytics,
) : NewsRepository {

    override suspend fun getNews(newsId: String): News {
        analytics.trackNewsRequest(newsId)
        return newsService.news(newsId)
    }
}
