package com.caren.simplegettimeretrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                findViewById<TextView>(R.id.textView).text = currentTime
                Log.i("Caren", "retrieved current time: " + currentTime)
            }

        })
    }
}