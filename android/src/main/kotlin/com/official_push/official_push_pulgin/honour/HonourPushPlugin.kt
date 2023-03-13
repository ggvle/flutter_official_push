package com.official_push.official_push_pulgin.honour

import android.content.Context
import com.hihonor.push.sdk.HonorPushClient
import com.official_push.official_push_pulgin.AbsPushPlugin
import com.official_push.official_push_pulgin.util.CommonUtil
import com.official_push.official_push_pulgin.util.PushLog
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class HonourPushPlugin:AbsPushPlugin() {
    companion object {
        const val logTag="Honour---"
        private var instance: HonourPushPlugin? = null
            get() {
                if (field == null) {
                    field = HonourPushPlugin()
                }
                return field
            }
        @Synchronized
        fun get(): HonourPushPlugin {
            return instance!!
        }
    }
    override fun init(call: MethodCall, result: MethodChannel.Result, context: Context) {
        val initToken:Boolean? = CommonUtil.getParam(call, result, "initToken")
        HonorPushClient.getInstance().init(context, initToken?:true)
    }

    override fun getRegId(call: MethodCall, result: MethodChannel.Result, context: Context) {
        val callBackImp = HonourGetTokenCallBackImp()
        HonorPushClient.getInstance().getPushToken(callBackImp)
    }

    override fun clearAllNotification(context: Context) {

    }

    override fun unRegister(context: Context) {
        PushLog.d("honour---","unRegister not imp!!!")
    }
}