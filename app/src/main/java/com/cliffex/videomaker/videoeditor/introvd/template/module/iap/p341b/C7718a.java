package com.introvd.template.module.iap.p341b;

import android.text.TextUtils;
import android.widget.Toast;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.router.user.UserServiceProxy;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.quvideo.plugin.payclient.common.C4859c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.module.iap.b.a */
public class C7718a implements C4859c {
    /* renamed from: f */
    public boolean mo25330f(int i, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        int i2 = -1;
        try {
            i2 = new JSONObject(str2).optInt(IronSourceConstants.EVENTS_ERROR_CODE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        boolean z = i2 == 1006014;
        if (z) {
            C7738c.aEv().aNx().clear();
            UserServiceProxy.clearUserInfo();
            Toast.makeText(C8048e.aBe().getContext(), R.string.xiaoying_str_iap_user_account_canceled, 0).show();
        }
        return z;
    }
}
