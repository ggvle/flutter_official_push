package com.official_push.official_push_pulgin.honour

import com.hihonor.push.sdk.HonorPushCallback
import com.official_push.official_push_pulgin.PushManager
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.model.PushCallBackModel
import com.official_push.official_push_pulgin.util.PushLog

class HonourGetTokenCallBackImp : HonorPushCallback<String?> {
    override fun onSuccess(token: String?) {
        PushLog.d("HonourPushPlugin.logTag","HonourGetTokenCallBackImp onSuccess regId=$token")
        val model=PushCallBackModel(Config.Type.HONOUR,token,null)
        PushManager.invokeListener(Config.Type.HONOUR,model.toJsonStr())
    }
    override fun onFailure(code: Int, msg: String) {
        PushLog.d("HonourPushPlugin.logTag","HonourGetTokenCallBackImp onFailure code=$code msg=$msg")
    }
}