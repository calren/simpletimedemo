package com.caren.simplegettimeretrofitdemo

class TimeCache {

    var timeResponse: TimeResponse? = null

    fun getTime(): TimeResponse? {
        return timeResponse
    }

    fun putTime(time: TimeResponse) {
        timeResponse = time
    }
}
