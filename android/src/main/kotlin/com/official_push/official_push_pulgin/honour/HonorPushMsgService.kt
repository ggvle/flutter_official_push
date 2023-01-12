//package com.official_push.official_push_pulgin.honour
//
//import com.hihonor.push.sdk.HonorMessageService
//import com.hihonor.push.sdk.HonorPushCallback
//import com.hihonor.push.sdk.HonorPushClient
//import com.hihonor.push.sdk.HonorPushDataMsg
//import com.official_push.official_push_pulgin.PushManager
//import com.official_push.official_push_pulgin.config.Config
//import com.official_push.official_push_pulgin.model.PushCallBackModel
//import com.official_push.official_push_pulgin.util.PushLog
//
//
//class HonorPushMsgService : HonorMessageService() {
//    //Token发生变化时，会以onNewToken方法返回
//    override fun onNewToken(pushToken: String) {
//        val model= PushCallBackModel(Config.Type.HONOUR,pushToken,null)
//        PushManager.invokeListener(Config.Type.HONOUR,model.toJsonStr())
//        //查询通知栏消息状态
//        HonorPushClient.getInstance()
//            .getNotificationCenterStatus(object : HonorPushCallback<Boolean?> {
//                override fun onSuccess(aBoolean: Boolean?) {
//                    PushLog.d(HonourPushPlugin.logTag,"NotificationCenterStatus==$aBoolean")
//                    if(aBoolean == false){
//                        //打开通知栏消息状态
//                        HonorPushClient.getInstance()
//                            .turnOnNotificationCenter(object : HonorPushCallback<Void?> {
//                                override fun onSuccess(aVoid: Void?) {
//                                    PushLog.d(HonourPushPlugin.logTag,"turnOnNotificationCenter success!!!")
//                                }
//
//                                override fun onFailure(errorCode: Int, errorString: String) {
//
//                                }
//                            })
//                    }
//                }
//
//                override fun onFailure(errorCode: Int, errorString: String) {
//
//                }
//            })
//    }
//
//    override fun onMessageReceived(msg: HonorPushDataMsg) {
//        // TODO: 处理收到的透传消息。
//    }
//}