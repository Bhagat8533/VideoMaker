package com.introvd.template.module.iap.business.coupon;

import com.introvd.template.module.iap.R;
import java.util.Calendar;

/* renamed from: com.introvd.template.module.iap.business.coupon.d */
public class C7857d extends C7867h {
    C7857d(C7846a aVar) {
        super(aVar);
    }

    private String aCj() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.dQE.endTime);
        int i = instance.get(6);
        int i2 = instance.get(1);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        int i3 = (i - instance2.get(6)) + ((i2 - instance2.get(1)) * 365);
        if (i3 <= 0) {
            return this.context.getString(R.string.xiaoying_str_iap_coupon_invalid_soon);
        }
        return this.context.getString(R.string.xiaoying_str_iap_coupon_valid_count_down, new Object[]{String.valueOf(i3)});
    }

    public String aCg() {
        return aCj();
    }

    public String aCh() {
        return this.context.getString(R.string.xiaoying_str_iap_to_be_vip_right_now);
    }

    public String getDesc() {
        return this.context.getString(R.string.xiaoying_str_iap_coupon_achieve_desc_not_pay);
    }
}
