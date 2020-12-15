package com.caren.simplegettimeretrofitdemo

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val _time: MutableLiveData<TimeResponse> = MutableLiveData()
    val time: LiveData<TimeResponse>? = _time
    val repository = TimeRepository()

    init {
        viewModelScope.launch {
            repository.getTime().collect {
                Log.i("Caren", "emitted value from flow: " + it?.currentDateTime)
                _time.value = it
            }
        }
    }

}