package com.example.changelanguage.repository

import com.example.changelanguage.model.Photo
import com.example.changelanguage.services.PhotoServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PhotoRepository {
    private val apiClient by lazy{
        PhotoServices.create()
    }
//    suspend fun getMusic():Flow<List<Music>>{
//        return flow {
//            emit(apiClient.getMusic())
//        }.flowOn(Dispatchers.IO)
//    }
     suspend fun getPhotos():Flow<List<Photo>>{
        return flow {
            emit(apiClient.getPhotos())
        }.flowOn(Dispatchers.IO)
    }

}