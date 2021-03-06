package com.example.changelanguage.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.changelanguage.model.Photo
import com.example.changelanguage.repository.PhotoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoViewModel : ViewModel() {

    private val photoRepository by lazy {
        PhotoRepository()
    }

    val photoList by lazy {
        MutableLiveData<List<Photo>>()
    }

    var progressStatus: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getPhotos(
        onComplete: ((data: List<Photo>) -> Unit)? = null
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            photoRepository.getPhotos().collect { list ->
//                withContext(Dispatchers.Main){
//                    photoList.value = list
//                }
                photoList.postValue(list)
                val photos = arrayListOf<Photo>()
                list.map { item ->
                    photos.add(item)
                }
                progressStatus.postValue(true)
                onComplete?.invoke(photos)
            }
        }
    }
}