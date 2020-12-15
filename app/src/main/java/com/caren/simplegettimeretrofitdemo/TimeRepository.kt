package com.caren.simplegettimeretrofitdemo

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TimeRepository {
    val BASE_URL = "http://worldclockapi.com/api/json/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(TimeApiEndpointInterface::class.java)

    private val cache = TimeCache()

    @WorkerThread
    suspend fun getTime(): Flow<TimeResponse?> = flow {

        val cached = cache.getTime()

        if (cached != null) {
            Log.i("Caren", "emitting cached time:" + cached.currentDateTime)
            emit(cached)
        }

        val response = service.getTime()
        Log.i("Caren", "response: " + response.currentDateTime)

        cache.putTime(response)

        Log.i("Caren", "emitting fresh time: " + response.currentDateTime)
        emit(response)
    }
}