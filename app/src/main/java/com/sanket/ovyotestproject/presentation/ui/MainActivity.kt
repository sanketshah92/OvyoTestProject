package com.sanket.ovyotestproject.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sanket.ovyotestproject.Application
import com.sanket.ovyotestproject.R
import com.sanket.ovyotestproject.data.VideoAPIService
import com.sanket.ovyotestproject.data.source.MovieDataSourceImpl
import com.sanket.ovyotestproject.data.source.MovieRepositoryImpl
import com.sanket.ovyotestproject.domain.MovieUseCase
import com.sanket.ovyotestproject.presentation.viewmodel.VideoViewModel
import com.sanket.ovyotestproject.presentation.viewmodel.VideoViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: VideoViewModel
    private lateinit var factory: VideoViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        factory = VideoViewModelFactory(
            MovieUseCase(
                MovieRepositoryImpl(
                    MovieDataSourceImpl(
                        Application.getRetrofitInstance().create(VideoAPIService::class.java)
                    )
                )
            )
        )
        viewModel = ViewModelProvider(this, factory)[VideoViewModel::class.java]
    }
}