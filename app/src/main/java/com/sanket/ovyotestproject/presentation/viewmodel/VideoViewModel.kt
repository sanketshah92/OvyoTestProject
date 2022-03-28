package com.sanket.ovyotestproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.ovyotestproject.domain.MovieUseCase

class VideoViewModel(private val useCase: MovieUseCase) : ViewModel() {

    fun getMovies(page: Int) = liveData {
        val videoData = useCase.execute(page)
        emit(videoData)
    }
}