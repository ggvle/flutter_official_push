# official_push_pulgin

A new Flutter project.

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android.

For help getting started with Flutter development, view the
[online documentation](https://flutter.dev/docs), which offers tutorials,
samples, guidance on mobile development, and a full API reference.

该插件支持oppo、vivo、honour、xiaomi推送 先在只是把推送注册完成之后的regId(token)回调回来了，其它的功能未做*

# 使用方法及功能：
## 1.pubspec.yaml增加依赖 official_push_pulgin: ^xxxx

## 2.在flutter项目的android目录下的build中添加如下配置:

### 2.1 在buildscript中添加

        repositories {
            maven { url 'https://developer.hihonor.com/repo/' }
            maven { url 'https://raw.githubusercontent.com/ggvle/pushLib/tree/main/'}
        }

### 2.2 在allprojects中添加

        repositories {
            maven { url 'https://developer.hihonor.com/repo/' }
            maven { url 'https://raw.githubusercontent.com/ggvle/pushLib/tree/main/'}
        }

## 3.在flutter项目的android/app/build中defaultConfig里面添加如下配置：
    ///vivo官网申请的appkey appid 荣耀官网申请的appid
    manifestPlaceholders += [
        VIVO_APPKEY : "9c29fe5f-ea67-46d3-951f-81da78d2c029",
        VIVO_APPID  : "10000",
        //
        HONOUR_APPID: "11111111",
    ]

## 4.如果应用开启混淆请参考各推送官网混淆配置
### oppo
    -keep public class * extends android.app.Service
    -keep class com.heytap.msp.** { *;}
     
### vivo
    -dontwarn com.vivo.push.**

    -keep class com.vivo.push.**{*; }

    -keep class com.vivo.vms.**{*; }
    
    -keep class   com.official_push.official_push_pulgin.vivo.VivoPushMessageReceiverImpl{*;}

### xiaomi
    -keep class   com.official_push.official_push_pulgin.xiaomi.XiaomiMessageReceiver{*;}

## 5.初始化注册推送(请根据不同的设备设备类型选择调用不同的初始化)

### 5.1 oppo

    ///oppo官网推送平台申请的appSecret、appKey以及needLog是否需要开启推送相关日志
    PushManager.initOppoPush(appSecret: "sK8dkfTwHt11QezBuIO4kjJV", appKey: "67ZtaSY1EyjZZoYqqYVT6e3X",needLog: true);

### 5.2 xiaomi

    ///小米官网推送平台申请的appId、appKey、enableLog是否开启日志可选，默认不开
    PushManager.initXiaomiPush(appId: "1000270", appKey: "670100056270",enableLog:true);
### 5.3 vivo
    ///enableLog是否开启日志可选，默认不开
    PushManager.initVivoPush(enableLog:true);
### 5.4 honour

    ///initToken 是否初始化注册成功后返回推送regId ,enableLog是否开启日志可选，默认不开
    PushManager.initHonourPush(initToken: true,enableLog:true);

## 6.在需要获取推送regId的地方注册监听

    ///返回的model包含推送类型(type)、推送regId(regId)、推送信息json字符串(pushReceiverFunJsonStr) 注意都可为null
    PushListener(
        PushManager.channel,
        listener: (PushModel? model) {
                
            },
        );


## 7.主动获取regId

    ///参数为推送类型  其中小米、vivo会直接返回，oppo、honour回调中获取到
    await PushManager.getRegId(PushType.xiaomi);
