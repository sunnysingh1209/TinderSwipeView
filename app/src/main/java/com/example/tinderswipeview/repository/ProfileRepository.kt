package com.example.tinderswipeview.repository

import com.example.tinderswipeview.SafeApiRequest
import com.example.tinderswipeview.TinderAPI

class ProfileRepository : SafeApiRequest() {
    suspend fun getMovies() = apiRequest {
        TinderAPI().getProfiles()
    }

}