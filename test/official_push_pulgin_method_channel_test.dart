import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:official_push_pulgin/official_push_pulgin_method_channel.dart';

void main() {
  MethodChannelOfficialPushPulgin platform = MethodChannelOfficialPushPulgin();
  const MethodChannel channel = MethodChannel('official_push_pulgin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await platform.getPlatformVersion(), '42');
  });
}
