package com.moviedb.networking

import retrofit2.Retrofit
import com.moviedb.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    companion object {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}