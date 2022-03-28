package com.sanket.ovyotestproject.data.source

import com.sanket.ovyotestproject.data.models.VideoData
import com.sanket.ovyotestproject.domain.MovieRepository

class MovieRepositoryImpl(private val dataSourceImpl: MovieDataSourceImpl): MovieRepository {
    override suspend fun getMovies(pageSize: Int): VideoData? {
        return dataSourceImpl.getVideos(pageSize)
    }
}