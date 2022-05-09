package com.denispotapov.dagger2test2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private companion object {

        private const val TOP_NEWS_ID = "top"
        private const val FRAGMENT_NEWS_DETAILS = "newsDetails"
    }
}
