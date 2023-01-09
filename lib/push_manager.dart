import 'package:flutter/services.dart';
import 'package:official_push_pulgin/config/config.dart';


class PushManager{
  static const MethodChannel channel =
  MethodChannel(Config.methodName);

  /// 初始化小米push，如果没有appId或appKey，请登录小米开发者中心申请
  /// [appId] 应用appId
  /// [appKey] 应用appKey
  static Future<void> initXiaomiPush({
    required String appId,
    required String appKey,
  }) async {
    return await channel.invokeMethod(Config.methodInit, {"type":PushType.xiaomi,
      "appId": appId,
      "appKey": appKey,
    });
  }

  /// 初始化小米push，如果没有appId或appKey，请登录小米开发者中心申请
  /// [appKey] 应用appId
  /// [appSecret] 应用appKey
  static Future<void> initOppoPush({
    required String appKey,
    required String appSecret,
    required bool needLog,
  }) async {
    return await channel.invokeMethod(Config.methodInit, {"type":PushType.oppo,
      "appKey": appKey,
      "appSecret": appKey,
      "needLog": needLog,
    });
  }

  /// 获取客户端的 RegId
  static Future<String?> getRegId(String type) async {
    return await channel.invokeMethod(Config.methodGetRegId,{"type":type,});
  }

  /// 清楚推送所有通知
  static Future<String?> clearAllNotification(String type) async {
    return await channel.invokeMethod(Config.methodClearAllNotification,{"type":type,});
  }
}