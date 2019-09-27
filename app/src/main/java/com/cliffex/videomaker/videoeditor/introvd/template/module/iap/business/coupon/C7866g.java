package com.introvd.template.module.iap.business.coupon;

import android.content.Context;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.introvd.template.module.iap.business.coupon.g */
class C7866g extends C7857d {
    C7866g(C7846a aVar) {
        super(aVar);
    }

    private String aCl() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Context context = C8048e.aBe().getContext();
        String format = simpleDateFormat.format(Long.valueOf(this.dQE.endTime));
        return context.getString(R.string.xiaoying_str_iap_valid_until_time, new Object[]{format});
    }

    public String aCg() {
        return aCl();
    }
}
