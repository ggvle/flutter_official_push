//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <official_push_pulgin/official_push_pulgin_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) official_push_pulgin_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "OfficialPushPulginPlugin");
  official_push_pulgin_plugin_register_with_registrar(official_push_pulgin_registrar);
}
