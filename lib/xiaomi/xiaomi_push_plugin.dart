// import 'package:flutter/services.dart';
// import 'package:official_push_pulgin/config/config.dart';
//
// class XiaomiPushPlugin{
//   static const MethodChannel channel =
//   MethodChannel(Config.methodName);
//
//   /// 初始化，如果没有appId或appKey，请登录小米开发者中心申请
//   /// [appId] 应用appId
//   /// [appKey] 应用appKey
//   static Future<void> init({
//     required String appId,
//     required String appKey,
//   }) async {
//     return await channel.invokeMethod(Config.methodInit, {"type":PushType.xiaomi,
//       "appId": appId,
//       "appKey": appKey,
//     });
//   }
//
//   /// 获取客户端的 RegId
//   static Future<String?> getRegId() async {
//     return await channel.invokeMethod(Config.methodGetRegId,{"type":PushType.xiaomi,});
//   }
//
//   /// 清除小米推送弹出的所有通知
//   static  clearAllNotification() async {
//     return await channel.invokeMethod(Config.methodClearAllNotification,{"type":PushType.xiaomi,});
//   }
//
//
// }