class PushModel{
  String? type;
  String? regId;
  int? code;
  String? methodType;
  String? pushReceiverFunJsonStr;
  PushModel();
  PushModel.fromJson(Map<String,dynamic> data){
    type=data["type"];
    regId=data["regId"];
    methodType=data["methodType"];
    code=data["code"];
    pushReceiverFunJsonStr=data["pushReceiverFunJsonStr"];
  }
  Map<String, dynamic> toJson() => {
    'type': type,
    'regId': regId,
    'pushReceiverFunJsonStr': pushReceiverFunJsonStr,
  };
}