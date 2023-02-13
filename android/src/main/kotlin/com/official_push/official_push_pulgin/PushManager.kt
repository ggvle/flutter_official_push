package com.official_push.official_push_pulgin

import android.content.Context
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.honour.HonourPushPlugin
import com.official_push.official_push_pulgin.oppo.OppoPushPlugin
import com.official_push.official_push_pulgin.util.CommonUtil
import com.official_push.official_push_pulgin.util.PushLog
import com.official_push.official_push_pulgin.vivo.VivoPushPlugin
import com.official_push.official_push_pulgin.xiaomi.XiaomiPushPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class PushManager {

    companion object {
        private var instance: PushManager? = null
            get() {
                if (field == null) {
                    field = PushManager()
                }
                return field
            }
        @Synchronized
        fun get(): PushManager {
            return instance!!
        }
        lateinit var channel: MethodChannel
        /**
         * 调用监听器
         *
         * @param type   推送类型
         * @param params 推送参数json字符串
         */
        fun invokeListener(type: String, params: String?) {
            CommonUtil.runMainThread {
                channel.invokeMethod(
                    Config.Fun.METHOD_ON_LISTENER, mapOf(
                        "type" to type,
                        "params" to params
                    ))
            }
        }
    }

    fun init(type:String, call: MethodCall, result: MethodChannel.Result,context:Context) {
        val enableLog = CommonUtil.getParam<Boolean>(call, result, "enableLog")
        PushLog.d("","enableLog==$enableLog")
        if(enableLog!=null){
            PushLog.logEnable=enableLog
        }
        when(type){
            Config.Type.XIAO_MI->{
                XiaomiPushPlugin.get().init(call,result,context);
            }
            Config.Type.OPPO->{
                OppoPushPlugin.get().init(call,result,context)
            }
            Config.Type.VIVO->{
                VivoPushPlugin.get().init(call,result,context)
            }
            Config.Type.HONOUR->{
                HonourPushPlugin.get().init(call,result,context)
            }
        }
    }
    fun getRegId(type:String, call: MethodCall, result: MethodChannel.Result,context:Context) {
        when(type){
            Config.Type.XIAO_MI->{
                XiaomiPushPlugin.get().getRegId(call,result,context)
            }
            Config.Type.OPPO->{
                OppoPushPlugin.get().getRegId(call,result,context)
            }
            Config.Type.VIVO->{
                VivoPushPlugin.get().getRegId(call,result,context)
            }
            Config.Type.HONOUR->{
                HonourPushPlugin.get().getRegId(call,result,context)
            }
        }
    }
    fun clearAllNotification(type:String, context:Context) {
        when(type){
            Config.Type.XIAO_MI->{
                XiaomiPushPlugin.get().clearAllNotification(context)
            }
        }
    }
    fun enableLog(enableLog:Boolean) {
       PushLog.logEnable=enableLog
    }

}