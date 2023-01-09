package com.official_push.official_push_pulgin.util

import android.util.Log

class PushLog {
    companion object {
        private const val logTag="Push-Plugin："
        fun d(tag:String,msg:String){
             Log.d(logTag,tag+msg)
        }
        fun e(tag:String,msg:String){
            Log.e(logTag,tag+msg)
        }
    }

}