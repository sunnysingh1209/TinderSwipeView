package com.example.tinderswipeview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tinderswipeview.Coroutines
import com.example.tinderswipeview.model.Profile
import com.example.tinderswipeview.repository.ProfileRepository
import kotlinx.coroutines.Job

class ProfileViewModel : ViewModel() {
    private lateinit var job: Job

    var mutableMovieList = MutableLiveData<List<Profile>>()
    var liveData: LiveData<List<Profile>>? = null
        get() = mutableMovieList

    fun getMovies() {
        job = Coroutines.ioThenMain({ ProfileRepository().getMovies() }, {
            mutableMovieList.value = it
        })
    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}