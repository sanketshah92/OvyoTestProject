package com.sanket.ovyotestproject.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoPicture(
    @SerializedName("id")
    val id: Int,
    @SerializedName("nr")
    val nr: Int,
    @SerializedName("picture")
    val picture: String
) : Parcelable