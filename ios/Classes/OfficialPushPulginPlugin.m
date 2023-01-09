#import "OfficialPushPulginPlugin.h"
#if __has_include(<official_push_pulgin/official_push_pulgin-Swift.h>)
#import <official_push_pulgin/official_push_pulgin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "official_push_pulgin-Swift.h"
#endif

@implementation OfficialPushPulginPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftOfficialPushPulginPlugin registerWithRegistrar:registrar];
}
@end
