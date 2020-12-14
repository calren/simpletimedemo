package com.caren.simplegettimeretrofitdemo

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val _time: MutableLiveData<TimeResponse> = MutableLiveData()
    val time: LiveData<TimeResponse> = _time

    init {
        val BASE_URL = "http://worldclockapi.com/api/json/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(TimeApiEndpointInterface::class.java)

        service.getTime().enqueue(object : Callback<TimeResponse> {
            override fun onFailure(call: Call<TimeResponse>, t: Throwable) {
                t.printStackTrace()
                Log.e("Caren", "error calling time api")
            }

            override fun onResponse(call: Call<TimeResponse>, response: Response<TimeResponse>) {
                val currentTime = response.body()?.currentDateTime
                _time.value = response.body()
                Log.i("Caren", "retrieved current time: " + currentTime)
            }

        })
    }

}