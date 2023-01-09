import 'dart:convert';
import 'package:flutter/services.dart';
import 'package:official_push_pulgin/config/config.dart';
import 'models/push_model.dart';

/// 监听器值模型
typedef ListenerPush = Function(PushModel? paramsJsonStr);

class PushListener {
  final ListenerPush? listener;

  PushListener(MethodChannel channel, {this.listener}) {
    // 绑定监听器
    channel.setMethodCallHandler((methodCall) async {
      // 解析参数

      switch (methodCall.method) {
        case Config.methodOnListener:
          Map<dynamic, dynamic>? arguments = methodCall.arguments;
          if (arguments != null) {
            var params = arguments["params"];
            if (params != null) {
              var jsonMap = json.decode(
                params,
              );
              var pushModel = PushModel.fromJson(jsonMap);
              pushModel.type=arguments["type"];
              if (listener != null) {
                listener!(pushModel);
              }
            }
          }
          break;
        default:
          throw MissingPluginException();
      }
    });
  }
}
