#include "include/official_push_pulgin/official_push_pulgin_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "official_push_pulgin_plugin.h"

void OfficialPushPulginPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  official_push_pulgin::OfficialPushPulginPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
