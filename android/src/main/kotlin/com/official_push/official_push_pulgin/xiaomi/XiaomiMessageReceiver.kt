package com.official_push.official_push_pulgin.xiaomi

import android.content.Context
import com.official_push.official_push_pulgin.model.PushCallBackModel
import com.official_push.official_push_pulgin.PushManager
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.util.PushLog
import com.xiaomi.mipush.sdk.MiPushCommandMessage
import com.xiaomi.mipush.sdk.MiPushMessage
import com.xiaomi.mipush.sdk.PushMessageReceiver

class XiaomiMessageReceiver: PushMessageReceiver() {
    override fun onReceivePassThroughMessage(ctx: Context?, message: MiPushMessage?) {
        super.onReceivePassThroughMessage(ctx, message)
        val content = message?.content
         PushLog.d("XiaomiPush:","---onReceivePassThroughMessage--- content=$content");
    }

    override fun onNotificationMessageClicked(ctx: Context?, message: MiPushMessage?) {
        super.onNotificationMessageClicked(ctx, message)
        
    }

    override fun onNotificationMessageArrived(ctx: Context?, message: MiPushMessage?) {
        super.onNotificationMessageArrived(ctx, message)
        val content = message?.content
         PushLog.d("XiaomiPush:","---onNotificationMessageArrived--- content=${content}")
    }


    override fun onReceiveRegisterResult(ctx: Context?, message: MiPushCommandMessage?) {
        super.onReceiveRegisterResult(ctx, message)
        val command = message?.command
        val commandArguments = message?.commandArguments
        if(commandArguments!=null&&commandArguments.size>0){
            val regId = commandArguments[0]
            PushLog.d("XiaomiPush:","---onReceiveRegisterResult--- regId=${regId}")
            val model = PushCallBackModel(Config.Type.XIAO_MI,regId,null,Config.Fun.METHOD_GET_REG_ID,0)
            PushManager.invokeListener(Config.Type.XIAO_MI,model.toJsonStr());
        }
//        if(commandArguments!=null&&commandArguments.size>1){
//            val cmdArg0 = commandArguments[0]
//
//        }
//
//        val cmdArg1 = commandArguments?.get(1)
//        if(command==MiPushClient.COMMAND_REGISTER){
//            if(message.resultCode==ErrorCode.SUCCESS.toLong()){
//                 PushLog.d("XiaomiPush:","---onReceiveRegisterResult--- regId=${cmdArg1}");
//            }
//        }
    }

    override fun onCommandResult(ctx: Context?, message: MiPushCommandMessage?) {
        super.onCommandResult(ctx, message)
    }

    override fun onRequirePermissions(ctx: Context?, message: Array<out String>?) {
        super.onRequirePermissions(ctx, message)
    }

}