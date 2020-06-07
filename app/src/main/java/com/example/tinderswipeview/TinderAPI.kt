package com.example.tinderswipeview

import com.example.tinderswipeview.model.Profile
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TinderAPI {

    @GET("profiles")
    suspend fun getProfiles(): Response<List<Profile>>

    companion object {
        operator fun invoke(): TinderAPI {
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/tinder/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TinderAPI::class.java)
        }
    }
}
