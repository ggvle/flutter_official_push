package com.official_push.official_push_pulgin.vivo

import android.content.Context
import com.official_push.official_push_pulgin.util.PushLog
import com.vivo.push.sdk.OpenClientPushMessageReceiver
import com.vivo.push.model.UnvarnishedMessage
import com.vivo.push.model.UPSNotificationMessage

class VivoPushMessageReceiverImpl : OpenClientPushMessageReceiver() {
    override fun onReceiveRegId(context: Context, s: String) {
        PushLog.d(" vivo onReceiveRegId", " onReceiveRegId= $s")
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