package com.root.constant;

public enum DeviceRoleEnum {

    IS_VIDEO("视频可浏览"),IS_CONTROL("设备可操作"),IS_ALARM("可管理告警");

    public String message;

    DeviceRoleEnum(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
