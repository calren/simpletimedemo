package com.caren.simplegettimeretrofitdemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class TimeResponse {
    @SerializedName("currentDateTime")
    @Expose
    var currentDateTime: String? = null

    @SerializedName("utcOffset")
    @Expose
    var utcOffset: String? = null

    @SerializedName("isDayLightSavingsTime")
    @Expose
    var isDayLightSavingsTime: Boolean? = null

    @SerializedName("dayOfTheWeek")
    @Expose
    var dayOfTheWeek: String? = null

    @SerializedName("timeZoneName")
    @Expose
    var timeZoneName: String? = null

    @SerializedName("ordinalDate")
    @Expose
    var ordinalDate: String? = null

    @SerializedName("serviceResponse")
    @Expose
    var serviceResponse: Any? = null
}