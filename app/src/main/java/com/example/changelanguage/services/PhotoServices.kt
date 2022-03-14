package com.example.changelanguage.services

import com.example.changelanguage.model.Photo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotoServices {
    companion object {
//        private const val BASE_URL = "https://mp3.zing.vn"
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun create(): PhotoServices {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoServices::class.java)
        }
    }
//    @GET("/xhr/chart-realtime")
//    suspend fun getMusic(): List<Music>
    @GET("/photos")
    suspend fun getPhotos(): List<Photo>
}