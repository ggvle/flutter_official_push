package com.official_push.official_push_pulgin.util

import android.util.Log

class PushLog {
    companion object {
        var logEnable=true;
        private const val logTag="Push-Plugin："
        fun d(tag:String,msg:String){
            if(logEnable){
                Log.d(logTag,tag+msg)
            }

        }
        fun e(tag:String,msg:String){
            if(logEnable){
                Log.e(logTag,tag+msg)
            }
        }
    }

}