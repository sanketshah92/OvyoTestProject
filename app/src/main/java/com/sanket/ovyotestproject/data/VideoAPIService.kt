package com.sanket.ovyotestproject.data

import com.sanket.ovyotestproject.data.models.VideoData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoAPIService {
    @GET("videos/popular")
    suspend fun getVideos(@Query("page") perPage: Int): Response<VideoData>
}