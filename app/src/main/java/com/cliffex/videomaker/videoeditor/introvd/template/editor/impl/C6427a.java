package com.introvd.template.editor.impl;

import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.router.app.config.AppConfigObserver;

/* renamed from: com.introvd.template.editor.impl.a */
public class C6427a extends AppConfigObserver {
    public void onChange(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            C5837a.agH().mo28216dH(str);
            StringBuilder sb = new StringBuilder();
            sb.append("Type = ");
            sb.append(i);
            sb.append(",AppConfig = ");
            sb.append(str);
            LogUtilsV2.m14227d(sb.toString());
        }
    }
}
