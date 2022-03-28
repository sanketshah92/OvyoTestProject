package com.sanket.ovyotestproject.data.source

import com.sanket.ovyotestproject.data.models.VideoData

interface MovieDataSource {
    suspend fun getVideos(pageSize: Int): VideoData?
}