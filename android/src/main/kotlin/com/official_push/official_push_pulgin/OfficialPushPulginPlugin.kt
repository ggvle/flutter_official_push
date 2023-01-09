package com.official_push.official_push_pulgin

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import com.official_push.official_push_pulgin.config.Config
import com.official_push.official_push_pulgin.config.Config.Fun
import com.official_push.official_push_pulgin.util.CommonUtil
import com.official_push.official_push_pulgin.util.PushLog

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** OfficialPushPulginPlugin */
class OfficialPushPulginPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var applicationContext: Context

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    applicationContext=flutterPluginBinding.applicationContext
    PushManager.channel = MethodChannel(flutterPluginBinding.binaryMessenger, "official_push_pulgin")
    PushManager.channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
//    if (call.method == "getPlatformVersion") {
//      result.success("Android ${android.os.Build.VERSION.RELEASE}")
//    } else {
//      result.notImplemented()
//    }
    PushLog.d("onMethodCall", "call.method ="+call.method)
    val method = call.method
    val type = CommonUtil.getParam<String>(call, result, "type")
    if(method!=null){
      when (call.method) {
        Fun.METHOD_INIT ->{
          PushManager.get().init(type,call,result,applicationContext)
        }
        Fun.METHOD_GET_REG_ID ->{
          PushManager.get().getRegId(type,call,result,applicationContext)
        }
        Fun.METHOD_CLEAR_ALL_NOTIFICATION ->{
          PushManager.get().clearAllNotification(type,applicationContext)
        }
        Fun.METHOD_ENABLE_LOG ->{
          val arguments = call.arguments
          if(arguments is Boolean){
            PushManager.get().enableLog(arguments)
          }
        }
        else -> result.notImplemented()
      }
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    PushManager.channel.setMethodCallHandler(null)
  }
}
