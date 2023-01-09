package com.official_push.official_push_pulgin.xiaomi

import android.content.Context
import com.official_push.official_push_pulgin.util.CommonUtil
import com.xiaomi.mipush.sdk.MiPushClient
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class XiaomiPushPlugin() {
    companion object {
        private var instance: XiaomiPushPlugin? = null
            get() {
                if (field == null) {
                    field = XiaomiPushPlugin()
                }
                return field
            }
        @Synchronized
        fun get(): XiaomiPushPlugin {
            return instance!!
        }
    }

    /**
     * 初始化
     */
    fun init(call: MethodCall, result: MethodChannel.Result,context: Context) {
        // 获得参数
        val appId = CommonUtil.getParam<String>(call, result, "appId")
        val appKey = CommonUtil.getParam<String>(call, result, "appKey")

        MiPushClient.registerPush(context, appId, appKey)
        result.success(null)
    }

    /**
     * 获取客户端的 RegId
     */
    fun getRegId( call: MethodCall, result: MethodChannel.Result,context: Context) {
        result.success(MiPushClient.getRegId(context))
    }

    fun clearAllNotification(context: Context){
        MiPushClient.clearNotification(context)
    }
}