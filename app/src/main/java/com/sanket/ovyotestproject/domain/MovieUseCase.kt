package com.sanket.ovyotestproject.domain

import com.sanket.ovyotestproject.domain.MovieRepository

class MovieUseCase(private val repository: MovieRepository) {
    suspend fun execute(pageSize: Int) = repository.getMovies(pageSize)
}