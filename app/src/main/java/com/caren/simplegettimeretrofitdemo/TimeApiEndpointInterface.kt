package com.caren.simplegettimeretrofitdemo

import retrofit2.http.GET

interface TimeApiEndpointInterface {

    @GET("est/now")
    suspend fun getTime(): TimeResponse
}