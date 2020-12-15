package com.caren.simplegettimeretrofitdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // updates text view with time when response is received
        viewModel.time?.observe(this) { timeResponse ->
            Log.i("Caren", "live data updated")
            findViewById<TextView>(R.id.textView).text = timeResponse.currentDateTime
        }
    }
}