package com.sanket.ovyotestproject.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sanket.ovyotestproject.data.models.Video
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoData(
    @SerializedName("next_page")
    val nextPage: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("videos")
    val videos: List<Video>
) : Parcelable