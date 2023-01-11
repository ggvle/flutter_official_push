package com.official_push.official_push_pulgin.oppo

import android.content.Context
import com.heytap.msp.push.HeytapPushManager
import com.heytap.msp.push.callback.ICallBackResultService
import com.official_push.official_push_pulgin.AbsPushPlugin
import com.official_push.official_push_pulgin.util.CommonUtil
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class OppoPushPlugin :AbsPushPlugin(){
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
    override fun init(call: MethodCall, result: MethodChannel.Result, context: Context){
        val appKey = CommonUtil.getParam<String>(call, result, "appKey")
        val appSecret = CommonUtil.getParam<String>(call, result, "appSecret")
        val needLog = CommonUtil.getParam<Boolean>(call, result, "needLog")
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

    override fun getRegId(call: MethodCall, result: MethodChannel.Result, context: Context) {
        HeytapPushManager.getRegister()

    }

    override fun clearAllNotification(context: Context) {
        TODO("Not yet implemented")
    }

}