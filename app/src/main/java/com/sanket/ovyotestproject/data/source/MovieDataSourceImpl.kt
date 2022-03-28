package com.sanket.ovyotestproject.data.source

import com.sanket.ovyotestproject.data.VideoAPIService
import com.sanket.ovyotestproject.data.models.VideoData

class MovieDataSourceImpl(private val apiService: VideoAPIService): MovieDataSource {
    override suspend fun getVideos(pageSize: Int): VideoData? {
        return apiService.getVideos(pageSize).body()
    }
}