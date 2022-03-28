package com.sanket.ovyotestproject.domain

import com.sanket.ovyotestproject.data.models.VideoData

interface MovieRepository {
    suspend fun getMovies(pageSize:Int): VideoData?
}