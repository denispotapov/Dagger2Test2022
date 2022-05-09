package com.denispotapov.news_list_module

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.denispotapov.dagger2test2022.api_module.NewsService
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

internal class ArticlesViewModel(private val newsService: NewsService) : ViewModel() {

    private companion object {

        private const val TAG = "ArticlesViewModel"
    }

    val articles = flow {
        try {
            emit(newsService.everything().articles)
        } catch (e: Exception) {
            Log.d(TAG, "Error", e)
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    class Factory @Inject constructor(
        private val newsService: Provider<NewsService>
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == ArticlesViewModel::class.java)
            return ArticlesViewModel(newsService.get()) as T
        }
    }
}
