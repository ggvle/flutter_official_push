class PushModel{
  String? type;
  String? regId;
  String? pushReceiverFunJsonStr;
  PushModel();
  PushModel.fromJson(Map<String,dynamic> data){
    regId=data["reg_id"];
    pushReceiverFunJsonStr=data["fun_json"];
  }
  Map<String, dynamic> toJson() => {
    'type': type,
    'reg_id': regId,
    'pushReceiverFunJsonStr': pushReceiverFunJsonStr,
  };
}