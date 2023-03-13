package com.official_push.official_push_pulgin

import android.content.Context
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

abstract class AbsPushPlugin {
    /**
     * 初始化及注册
     */
    abstract fun init(call: MethodCall, result: MethodChannel.Result, context: Context);

    /**
     * 获取客户端的 RegId
     */
    abstract fun getRegId(call: MethodCall, result: MethodChannel.Result, context: Context)
    /**
     * 清空通知
     */
    abstract fun clearAllNotification(context: Context)

    /**
     * 取消推送注册
     */
    abstract fun unRegister(context: Context)

}