package com.introvd.template.app.service;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.app.IANRService;
import com.introvd.template.router.app.IANRService.MethodType;

@C1942a(mo10417rZ = "/IAppServiceRouter/ANR")
public class IANRServiceImpl implements IANRService {
    public void init(Context context) {
    }

    public void offerLifeCycleQueue(String str) {
    }

    public void operate(String str, String str2, MethodType methodType) {
        StringBuilder sb = new StringBuilder();
        sb.append("name=");
        sb.append(str);
        sb.append(",fullMsg=");
        sb.append(str2);
        LogUtilsV2.m14227d(sb.toString());
    }
}
