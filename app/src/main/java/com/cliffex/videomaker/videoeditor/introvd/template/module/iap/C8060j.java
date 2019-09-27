package com.introvd.template.module.iap;

import com.introvd.template.module.iap.business.p349a.C7825a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.j */
public class C8060j {
    private static final Map<String, List<String>> dOP = new HashMap(5);

    static {
        dOP.put(C7825a.GOLD_MONTHLY.getId(), Arrays.asList(new String[]{"premium_gold_monthly_0.99", "premium_gold_monthly_1.49", "premium_gold_monthly_1.99", "premium_gold_monthly_2.49", "premium_gold_monthly_2.99", "premium_gold_monthly_3.49", "premium_gold_monthly_3.99"}));
        dOP.put(C7825a.GOLD_YEARLY.getId(), Arrays.asList(new String[]{"premium_gold_yearly_6.99", "premium_gold_yearly_7.99", "premium_gold_yearly_8.99", "premium_gold_yearly_9.99", "premium_gold_yearly_10.99", "premium_gold_yearly_12.99", "premium_gold_yearly_14.99_new", "premium_gold_yearly_15.99", "premium_gold_yearly_17.99_new", "premium_gold_yearly_19.99", "premium_gold_yearly_23.99"}));
        dOP.put(C7825a.PLATINUM_WEEKLY.getId(), Arrays.asList(new String[]{"premium_platinium_weekly_0.99", "premium_platinium_weekly_1.49", "premium_platinium_weekly_1.99", "premium_platinium_weekly_2.49", "premium_platinium_weekly_2.99", "premium_platinium_weekly_3.49", "premium_platinium_weekly_3.99", "premium_platinium_weekly_4.49"}));
        dOP.put(C7825a.PLATINUM_MONTHLY.getId(), Arrays.asList(new String[]{"premium_platinium_monthly_1.49", "premium_platinium_monthly_1.99", "premium_platinium_monthly_2.49", "premium_platinium_monthly_2.99", "premium_platinium_monthly_3.49", "premium_platinium_monthly_3.99", "premium_platinium_monthly_4.49", "premium_platinium_monthly_4.99", "premium_platinium_monthly_3.99_us", "premium_platinium_promosi_monthly_1.49", "premium_platinium_promosi_monthly_2.49", "Monthly_VIP_Membership_New", "Half_Yearly_VIP_Membership_New", "vip_lite_monthly_1.99", "vip_lite_monthly_2.49", "vip_lite_monthly_2.99", "vip_month", "vip_normal", "vip_subscription"}));
        dOP.put(C7825a.PLATINUM_YEARLY.getId(), Arrays.asList(new String[]{"premium_platinium_yearly_10.99", "premium_platinium_yearly_11.99", "premium_platinium_yearly_12.99", "premium_platinium_yearly_15.99", "premium_platinium_yearly_17.99", "premium_platinium_yearly_19.99", "premium_platinium_yearly_23.99", "premium_platinium_yearly_29.99", "premium_platinium_yearly_35.99", "Yearly_VIP_Membership_New", "vip_lite_yearly_10.99", "vip_lite_yearly_12.99", "vip_lite_yearly_15.99", "premium_vip_yearly_nonorganic_12.99", "vip_year"}));
    }

    /* renamed from: kB */
    static List<String> m23407kB(String str) {
        return (List) dOP.get(str);
    }
}
