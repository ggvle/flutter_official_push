package com.official_push.official_push_pulgin.oppo

import android.content.Context
import com.heytap.msp.push.service.DataMessageCallbackService
import com.heytap.msp.push.mode.DataMessage

/**
 * 接收应用注册信息
 */
class OppoAppPushMessageService : DataMessageCallbackService() {
    /**
     * 如果业务仅仅是获取Opush RegisterID则不需要添加逻辑，直接按照
     * super.processMessage(context.getApplicationContext(), message)
     * 即可
     *
     * @param context
     * @param message
     */
    override fun processMessage(context: Context, message: DataMessage) {
        super.processMessage(context, message)
        //        TestModeUtil.addLogString(PushMessageService.class.getSimpleName(), "Receive SptDataMessage:" + message.toString());
//        NotificationUtil.showNotification(context,message.getTitle(),message.getContent(), message.getNotifyID(), ConfigManager.getInstant().isRedBadge());
    }
}