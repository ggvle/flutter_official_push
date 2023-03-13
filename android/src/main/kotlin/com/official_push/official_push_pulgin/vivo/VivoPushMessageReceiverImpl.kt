package com.official_push.official_push_pulgin.vivo

import android.content.Context
import com.official_push.official_push_pulgin.PushManager
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.model.PushCallBackModel
import com.official_push.official_push_pulgin.util.PushLog
import com.vivo.push.PushClient
import com.vivo.push.sdk.OpenClientPushMessageReceiver
import com.vivo.push.model.UnvarnishedMessage
import com.vivo.push.model.UPSNotificationMessage

class VivoPushMessageReceiverImpl : OpenClientPushMessageReceiver() {
    override fun onReceiveRegId(context: Context, s: String) {
        PushLog.d(" vivo onReceiveRegId", " onReceiveRegId= $s")
        val regId = PushClient.getInstance(context).regId
        PushLog.d("vivo---","turnOnPush regId==$regId")
        val model = PushCallBackModel(Config.Type.VIVO,regId,null, Config.Fun.METHOD_GET_REG_ID,0)
        PushManager.invokeListener(Config.Type.VIVO,model.toJsonStr());
    }

    override fun onTransmissionMessage(context: Context, unvarnishedMessage: UnvarnishedMessage) {
        super.onTransmissionMessage(context, unvarnishedMessage)
        PushLog.d(
            "vivo OpenClientPushMessageReceiverImpl",
            " onTransmissionMessage= " + unvarnishedMessage.message
        )
    }

    override fun onNotificationMessageClicked(
        context: Context,
        unvarnishedMessage: UPSNotificationMessage
    ) {
        super.onNotificationMessageClicked(context, unvarnishedMessage)
        PushLog.d("vivo OpenClientPushMessageReceiverImpl", " onTransmissionMessage= $unvarnishedMessage")
    }
}