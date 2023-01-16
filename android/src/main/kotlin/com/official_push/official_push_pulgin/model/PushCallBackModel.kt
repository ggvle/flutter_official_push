package com.official_push.official_push_pulgin.model

import com.google.gson.Gson
import com.google.gson.annotations.Expose



data class PushCallBackModel(val type:String?, val regId:String?, val pushReceiverFunJsonStr:String?) {

    fun toJsonStr():String{
        return Gson().toJson(this)
    }
}