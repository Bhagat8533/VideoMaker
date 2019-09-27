package com.introvd.template.module.iap.p341b.p342a;

import android.content.Context;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.p341b.C7794g;

/* renamed from: com.introvd.template.module.iap.b.a.d */
public class C7729d implements C7794g {
    /* renamed from: cc */
    public boolean mo32596cc(Context context, String str) {
        if (C8048e.aBe().mo23627Ms()) {
            return false;
        }
        ToastUtils.show(context, context.getString(R.string.xiaoying_str_sns_wechat_not_installed), 0);
        return true;
    }

    public String getId() {
        return "DomesticWeChatInstallCheck";
    }
}
