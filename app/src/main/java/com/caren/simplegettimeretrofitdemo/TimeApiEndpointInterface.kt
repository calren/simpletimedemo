package com.caren.simplegettimeretrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface TimeApiEndpointInterface {

    @GET("est/now")
    fun getTime(): Call<TimeResponse>
}