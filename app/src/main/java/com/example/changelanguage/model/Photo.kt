package com.example.changelanguage.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("id")
    val id: Int
    )
