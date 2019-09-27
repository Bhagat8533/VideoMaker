package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.app.p192l.C4031a;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.AppPreferencesSetting;
import com.quvideo.priority.p217a.C4892c;

/* renamed from: com.introvd.template.app.homepage.pop.e */
public class C3991e extends C4892c {
    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (C4560d.m11516RN().isYoungerMode()) {
            return false;
        }
        if (!"8888/8888".equals(AppPreferencesSetting.getInstance().getAppSettingStr("key_show_share_dialog_flag", "7777/7777"))) {
            return false;
        }
        AppPreferencesSetting.getInstance().setAppSettingStr("key_show_share_dialog_flag", "9999/9999");
        C4031a.m10013d(activity, new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C3991e.this.mo25344EW();
            }
        });
        return true;
    }
}
