package com.introvd.template.app.crash;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.ICrashFlavour;
import p037b.p038a.p039a.p040a.C1469c;

@C1942a(mo10417rZ = "/VivaBaseRouter/VivaRouterCrash")
public class CrashFlavor implements ICrashFlavour {
    public void init(Context context) {
    }

    public void log(String str) {
        if (C1469c.isInitialized()) {
            StringBuilder sb = new StringBuilder();
            sb.append("log = ");
            sb.append(str);
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    public void logException(Throwable th) {
        if (C1469c.isInitialized()) {
            StringBuilder sb = new StringBuilder();
            sb.append("logException ");
            sb.append(th.getClass().getName());
            LogUtilsV2.m14227d(sb.toString());
        }
    }
}
