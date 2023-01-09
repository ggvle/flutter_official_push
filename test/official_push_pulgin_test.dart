import 'package:flutter_test/flutter_test.dart';
import 'package:official_push_pulgin/official_push_pulgin.dart';
import 'package:official_push_pulgin/official_push_pulgin_platform_interface.dart';
import 'package:official_push_pulgin/official_push_pulgin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockOfficialPushPulginPlatform
    with MockPlatformInterfaceMixin
    implements OfficialPushPulginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final OfficialPushPulginPlatform initialPlatform = OfficialPushPulginPlatform.instance;

  test('$MethodChannelOfficialPushPulgin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelOfficialPushPulgin>());
  });

  test('getPlatformVersion', () async {
    OfficialPushPulgin officialPushPulginPlugin = OfficialPushPulgin();
    MockOfficialPushPulginPlatform fakePlatform = MockOfficialPushPulginPlatform();
    OfficialPushPulginPlatform.instance = fakePlatform;

    expect(await officialPushPulginPlugin.getPlatformVersion(), '42');
  });
}
