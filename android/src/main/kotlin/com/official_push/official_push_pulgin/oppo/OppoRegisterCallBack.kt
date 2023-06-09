package com.official_push.official_push_pulgin.oppo

import com.heytap.msp.push.callback.ICallBackResultService
import com.official_push.official_push_pulgin.PushManager
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.model.PushCallBackModel
import com.official_push.official_push_pulgin.util.PushLog

class OppoRegisterCallBack : ICallBackResultService {
    override fun onRegister(code: Int, s: String) {
        if (code == 0) {
            val modelJsonStr = PushCallBackModel(Config.Type.OPPO,s,null,Config.Fun.METHOD_GET_REG_ID,code).toJsonStr()
            PushLog.d("注册成功", "modelJsonStr:$modelJsonStr")
            PushManager.invokeListener(Config.Type.OPPO,modelJsonStr);
        } else {
            PushLog.d("注册失败", "code=$code,msg=$s")
        }
    }

    override fun onUnRegister(code: Int) {
        if (code == 0) {
            val modelJsonStr = PushCallBackModel(Config.Type.OPPO,null,null,Config.Fun.METHOD_UN_REGISTER,code).toJsonStr()
            PushLog.d("注销成功", "modelJsonStr:$modelJsonStr")
            PushManager.invokeListener(Config.Type.OPPO,modelJsonStr);
        } else {
            PushLog.d("注销失败", "code=$code")
        }
    }

    override fun onGetPushStatus(code: Int, status: Int) {
        if (code == 0 && status == 0) {
            PushLog.d("Push状态正常", "code=$code,status=$status")
        } else {
            PushLog.d("Push状态错误", "code=$code,status=$status")
        }
    }

    override fun onGetNotificationStatus(code: Int, status: Int) {
        if (code == 0 && status == 0) {
            PushLog.d("通知状态正常", "code=$code,status=$status")
        } else {
            PushLog.d("通知状态错误", "code=$code,status=$status")
        }
    }

    override fun onError(i: Int, s: String) {
        PushLog.d("onError", "onError code : $i   message : $s")
    }

    override fun onSetPushTime(code: Int, s: String) {
        PushLog.d("SetPushTime", "code=$code,result:$s")
    }
}