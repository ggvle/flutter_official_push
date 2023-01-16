class PushModel{
  String? type;
  String? regId;
  String? pushReceiverFunJsonStr;
  PushModel();
  PushModel.fromJson(Map<String,dynamic> data){
    type=data["type"];
    regId=data["regId"];
    pushReceiverFunJsonStr=data["pushReceiverFunJsonStr"];
  }
  Map<String, dynamic> toJson() => {
    'type': type,
    'regId': regId,
    'pushReceiverFunJsonStr': pushReceiverFunJsonStr,
  };
}