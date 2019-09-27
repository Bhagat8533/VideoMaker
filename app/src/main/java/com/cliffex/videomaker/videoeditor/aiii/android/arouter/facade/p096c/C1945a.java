package com.aiii.android.arouter.facade.p096c;

/* renamed from: com.aiii.android.arouter.facade.c.a */
public enum C1945a {
    ACTIVITY(0, "android.app.Activity"),
    SERVICE(1, "android.app.Service"),
    PROVIDER(2, "com.aiii.android.arouter.facade.template.IProvider"),
    CONTENT_PROVIDER(-1, "android.app.ContentProvider"),
    BOARDCAST(-1, ""),
    METHOD(-1, ""),
    FRAGMENT(-1, "android.app.Fragment"),
    UNKNOWN(-1, "Unknown route type");
    
    String className;

    /* renamed from: id */
    int f3220id;

    private C1945a(int i, String str) {
        this.f3220id = i;
        this.className = str;
    }
}
