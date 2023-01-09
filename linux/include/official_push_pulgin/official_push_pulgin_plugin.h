#ifndef FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_
#define FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_

#include <flutter_linux/flutter_linux.h>

G_BEGIN_DECLS

#ifdef FLUTTER_PLUGIN_IMPL
#define FLUTTER_PLUGIN_EXPORT __attribute__((visibility("default")))
#else
#define FLUTTER_PLUGIN_EXPORT
#endif

typedef struct _OfficialPushPulginPlugin OfficialPushPulginPlugin;
typedef struct {
  GObjectClass parent_class;
} OfficialPushPulginPluginClass;

FLUTTER_PLUGIN_EXPORT GType official_push_pulgin_plugin_get_type();

FLUTTER_PLUGIN_EXPORT void official_push_pulgin_plugin_register_with_registrar(
    FlPluginRegistrar* registrar);

G_END_DECLS

#endif  // FLUTTER_PLUGIN_OFFICIAL_PUSH_PULGIN_PLUGIN_H_
