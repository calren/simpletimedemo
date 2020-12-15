package com.caren.simplegettimeretrofitdemo

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val _time: MutableLiveData<TimeResponse> = MutableLiveData()
    val time: LiveData<TimeResponse>? = _time
    val repository = TimeRepository()

    init {
        viewModelScope.launch {
            _time.value = repository.getTime()
        }
    }

}