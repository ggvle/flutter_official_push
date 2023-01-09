package com.official_push.official_push_pulgin.model

import com.google.gson.Gson


class PushCallBackModel(type:String?,regId:String?,pushReceiverFunJsonStr:String?) {

    fun toJsonStr():String{
        return Gson().toJson(this)
    }
}