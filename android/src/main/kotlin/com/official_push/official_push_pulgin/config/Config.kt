package com.official_push.official_push_pulgin.config

class Config {
    companion object{
        var logEnable=false;
    }
    internal object Fun {
        const val METHOD_INIT = "method_init"
        const val METHOD_GET_REG_ID = "method_get_reg_id"
        const val METHOD_CLEAR_ALL_NOTIFICATION = "method_clear_all_notification"
        const val METHOD_ON_LISTENER = "method_on_listener"
        const val METHOD_ENABLE_LOG = "method_enable_log"
    }
    internal object Type {
        const val XIAO_MI = "xiaomi"
        const val OPPO = "oppo"
    }
}