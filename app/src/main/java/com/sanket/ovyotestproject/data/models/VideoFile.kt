package com.sanket.ovyotestproject.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoFile(
    @SerializedName("file_type")
    val fileType: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("quality")
    val quality: String,
    @SerializedName("width")
    val width: Int
) : Parcelable