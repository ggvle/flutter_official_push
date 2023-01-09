#ifndef FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_
#define FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace official_push_pulgin {

class OfficialPushPulginPlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  OfficialPushPulginPlugin();

  virtual ~OfficialPushPulginPlugin();

  // Disallow copy and assign.
  OfficialPushPulginPlugin(const OfficialPushPulginPlugin&) = delete;
  OfficialPushPulginPlugin& operator=(const OfficialPushPulginPlugin&) = delete;

 private:
  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace official_push_pulgin

#endif  // FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_
