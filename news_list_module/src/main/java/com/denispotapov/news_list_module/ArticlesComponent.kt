@file:Suppress("unused")

package com.denispotapov.news_list_module

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import com.denispotapov.core_module.Feature
import com.denispotapov.dagger2test2022.api_module.NewsService
import dagger.Component
import kotlin.properties.Delegates.notNull

@[Feature Component(dependencies = [ArticlesDeps::class])]
internal interface ArticlesComponent {

    fun inject(fragment: ArticlesFragment)

    @Component.Builder
    interface Builder {

        fun deps(articlesDeps: ArticlesDeps): Builder

        fun build(): ArticlesComponent
    }
}

interface ArticlesDeps {

    val newsService: NewsService
}

interface ArticlesDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: ArticlesDeps

    companion object : ArticlesDepsProvider by ArticlesDepsStore
}

object ArticlesDepsStore : ArticlesDepsProvider {

    override var deps: ArticlesDeps by notNull()
}

internal class ArticlesComponentViewModel : ViewModel() {

    val newDetailsComponent =
        DaggerArticlesComponent.builder().deps(ArticlesDepsProvider.deps).build()
}
