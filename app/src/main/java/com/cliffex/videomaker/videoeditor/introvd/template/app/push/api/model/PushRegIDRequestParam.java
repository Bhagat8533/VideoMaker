package com.introvd.template.app.push.api.model;

public class PushRegIDRequestParam {
    public static final int TYPE_FCM = 2;
    public static final int TYPE_GETUI = 4;
    public static final int TYPE_HUAWEI = 7;
    public static final int TYPE_JPUSH = 1;
    public static final int TYPE_MIPUSH = 3;
    public String registerId;
    public int registerType;
}
