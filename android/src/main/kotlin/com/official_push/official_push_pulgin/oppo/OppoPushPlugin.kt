package com.official_push.official_push_pulgin.oppo

import android.content.Context
import com.heytap.msp.push.HeytapPushManager
import com.heytap.msp.push.callback.ICallBackResultService
import com.official_push.official_push_pulgin.config.Config

class OppoPushPlugin {
    companion object {
        private var instance: OppoPushPlugin? = null
            get() {
                if (field == null) {
                    field = OppoPushPlugin()
                }
                return field
            }
        @Synchronized
        fun get(): OppoPushPlugin {
            return instance!!
        }
    }
    var mPushCallback:ICallBackResultService? = null
    fun init(context: Context,needLog:Boolean,appKey:String,appSecret:String){
        Config.logEnable=needLog
        HeytapPushManager.init(context, needLog)
        if(this.mPushCallback!=null){
            this.mPushCallback=null
            this.mPushCallback= OppoRegisterCallBack()
        }else{
            this.mPushCallback= OppoRegisterCallBack()
        }
        HeytapPushManager.register(
            context,
            appKey,
            appSecret,
            mPushCallback
        ) //setPushCallback接口也可设置callback

        HeytapPushManager.requestNotificationPermission()
    }
    fun getRegister(){
        HeytapPushManager.getRegister()
    }
}