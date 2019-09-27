package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.setting.C4317a;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.AppPreferencesSetting;
import com.quvideo.priority.p217a.C4892c;

/* renamed from: com.introvd.template.app.homepage.pop.d */
public class C3989d extends C4892c {
    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (!C4560d.m11516RN().isYoungerMode() && AppPreferencesSetting.getInstance().getAppSettingInt("key_show_rate_dialog_flag", 101) == 102 && C3742b.m9111II().mo23116IJ()) {
            return C4317a.m10838a(activity, new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    C3989d.this.mo25344EW();
                }
            });
        }
        return false;
    }
}
