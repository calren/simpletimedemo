package com.caren.simplegettimeretrofitdemo

import android.util.Log
import androidx.annotation.WorkerThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TimeRepository {
    val BASE_URL = "http://worldclockapi.com/api/json/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(TimeApiEndpointInterface::class.java)

    @WorkerThread
    suspend fun getTime(): TimeResponse {
        val response = service.getTime()
        Log.i("Caren", "response: " + response.currentDateTime)
        return response
    }
}