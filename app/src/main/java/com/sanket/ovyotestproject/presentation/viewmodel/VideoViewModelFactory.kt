package com.sanket.ovyotestproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanket.ovyotestproject.domain.MovieUseCase

class VideoViewModelFactory(private val  useCase: MovieUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideoViewModel(useCase) as T
    }
}