package com.official_push.official_push_pulgin.vivo

import android.content.Context
import com.official_push.official_push_pulgin.AbsPushPlugin
import com.official_push.official_push_pulgin.PushManager
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.model.PushCallBackModel
import com.official_push.official_push_pulgin.util.PushLog
import com.vivo.push.PushClient
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel


class VivoPushPlugin:AbsPushPlugin() {
    companion object {
        private var instance: VivoPushPlugin? = null
            get() {
                if (field == null) {
                    field = VivoPushPlugin()
                }
                return field
            }
        @Synchronized
        fun get(): VivoPushPlugin {
            return instance!!
        }
    }

    override fun init(call: MethodCall, result: MethodChannel.Result, context: Context) {
        //初始化push
        PushClient.getInstance(context).initialize()

        // 打开push开关, 关闭为turnOffPush，详见api接入文档
        PushClient.getInstance(context).turnOnPush {
            // 开关状态处理， 0代表成功
            PushLog.d("vivo---","statues==$it")
            if(it==0){
                val regId = PushClient.getInstance(context).regId
                PushLog.d("vivo---","turnOnPush regId==$regId")
                val model =PushCallBackModel(Config.Type.VIVO,regId,null,Config.Fun.METHOD_GET_REG_ID,0)
                PushManager.invokeListener(Config.Type.VIVO,model.toJsonStr());
            }
        }
//        VUpsManager.getInstance().turnOnPush(context) { codeResult ->
//            if (codeResult.returnCode == 0) {
//                PushLog.d("vivo", " 统一联盟推送初始化成功")
//            } else {
//                PushLog.d("vivo", "统一联盟推送初始化失败")
//            }
//        }
//        VUpsManager.getInstance().registerToken(context, "XXX", "XXX", "XXX",
//            UPSRegisterCallback { tokenResult ->
//                if (tokenResult.returnCode === 0) {
//                    Log.d(TAG, "注册成功 regID = " + tokenResult.token)
//                } else {
//                    Log.d(TAG, "注册失败")
//                }
//            })
    }

    override fun getRegId(call: MethodCall, result: MethodChannel.Result, context: Context) {
        val regId = PushClient.getInstance(context).regId
        PushLog.d("vivo---","regId==$regId")
        result.success(regId)
    }

    override fun clearAllNotification(context: Context) {

    }

    override fun unRegister(context: Context) {
        PushLog.d("vivo---","unRegister not imp!!!")
    }

}