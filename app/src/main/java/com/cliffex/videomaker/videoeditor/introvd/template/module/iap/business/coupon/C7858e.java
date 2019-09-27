package com.introvd.template.module.iap.business.coupon;

import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.plugin.payclient.common.C4852b;
import com.quvideo.plugin.payclient.common.model.CouponGetWithActivity;
import com.quvideo.plugin.payclient.common.model.CouponResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1850u;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;

/* renamed from: com.introvd.template.module.iap.business.coupon.e */
public final class C7858e {
    private static Map<String, Long> dQI = new HashMap();
    /* access modifiers changed from: private */
    public static Map<String, C7846a> dQJ = new HashMap(4);
    /* access modifiers changed from: private */
    public static Map<String, C7846a> dQK = new HashMap(4);

    /* renamed from: com.introvd.template.module.iap.business.coupon.e$a */
    public interface C7864a {
        /* renamed from: iD */
        void mo32659iD(boolean z);
    }

    /* renamed from: a */
    public static void m22915a(final C7864a aVar) {
        if (!C8048e.aBe().isInChina()) {
            dQJ.clear();
            dQK.clear();
        } else if (System.currentTimeMillis() - m22925lb("query_coupon") >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            m22919h("get_coupon", System.currentTimeMillis());
            C4852b.m12466cE(UserServiceProxy.getUserId()).mo10199i(new C1518f<CouponResult, List<C7846a>>() {
                /* renamed from: a */
                public List<C7846a> apply(CouponResult couponResult) throws Exception {
                    if (couponResult.isSuccessful()) {
                        return (List) new Gson().fromJson(couponResult.data, new TypeToken<List<C7846a>>() {
                        }.getType());
                    }
                    return null;
                }
            }).mo10188a((C1850u<? super T>) new C1810c<List<C7846a>>() {
                public void onError(Throwable th) {
                    C7858e.dQJ.clear();
                    C7858e.dQK.clear();
                    if (aVar != null) {
                        aVar.mo32659iD(false);
                    }
                }

                public void onSuccess(List<C7846a> list) {
                    C7858e.dQJ.clear();
                    C7858e.dQK.clear();
                    C7858e.m22918cj(list);
                    if (aVar != null) {
                        aVar.mo32659iD(!list.isEmpty());
                    }
                }
            });
        }
    }

    public static List<String> aCk() {
        return new ArrayList(dQK.keySet());
    }

    /* renamed from: b */
    static void m22917b(C7846a aVar) {
        if (aVar != null) {
            List<String> aCa = aVar.aCa();
            if (!aCa.isEmpty()) {
                dQK.put(String.valueOf(aVar.dQy), aVar);
                for (String put : aCa) {
                    dQJ.put(put, aVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cj */
    public static void m22918cj(List<C7846a> list) {
        if (list == null || list.isEmpty()) {
            dQJ.clear();
            dQK.clear();
            return;
        }
        for (C7846a b : list) {
            m22917b(b);
        }
    }

    public static void clear() {
        if (dQJ != null) {
            dQJ.clear();
        }
        if (dQK != null) {
            dQK.clear();
        }
    }

    /* renamed from: h */
    private static void m22919h(String str, long j) {
        dQI.put(str, Long.valueOf(j));
    }

    public static boolean isEmpty() {
        return dQJ == null || dQJ.isEmpty();
    }

    /* renamed from: kW */
    public static C7846a m22920kW(String str) {
        C7846a aVar = (C7846a) dQJ.get(str);
        if (aVar == null || !aVar.isValid()) {
            return null;
        }
        return aVar;
    }

    /* renamed from: kX */
    public static C7846a m22921kX(String str) {
        return (C7846a) dQJ.get(str);
    }

    /* renamed from: kY */
    public static C7846a m22922kY(String str) {
        return (C7846a) dQK.get(str);
    }

    /* renamed from: kZ */
    public static void m22923kZ(String str) {
        C4852b.m12458D(UserServiceProxy.getUserId(), str).mo10188a((C1850u<? super T>) new C1810c<CouponResult>() {
            /* renamed from: b */
            public void onSuccess(CouponResult couponResult) {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: la */
    public static void m22924la(final String str) {
        boolean isVip = C8072q.aBx().isVip();
        if (("10".equals(str) && isVip) || C8048e.aBe().mo23628Mt()) {
            return;
        }
        if ((!"11".equals(str) || !isVip) && !C8048e.aBe().mo23628Mt()) {
            m22919h("get_coupon", System.currentTimeMillis());
            CouponGetWithActivity couponGetWithActivity = new CouponGetWithActivity();
            couponGetWithActivity.country = AppStateModel.COUNTRY_CODE_China;
            couponGetWithActivity.activityId = str;
            C4852b.m12462a(UserServiceProxy.getUserId(), couponGetWithActivity).mo10188a((C1850u<? super T>) new C1810c<CouponResult>() {
                /* renamed from: b */
                public void onSuccess(CouponResult couponResult) {
                    if (couponResult.isSuccessful()) {
                        C7846a aVar = (C7846a) new Gson().fromJson(couponResult.data, C7846a.class);
                        C7858e.m22917b(aVar);
                        CouponShowActivity.m22880a(C8048e.aBe().getContext(), str, aVar);
                    }
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* renamed from: lb */
    private static long m22925lb(String str) {
        Long l = (Long) dQI.get(str);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    /* renamed from: sq */
    public static int m22927sq(int i) {
        if (i != 10001) {
            if (i == 10003) {
                return R.string.xiaoying_str_iap_coupon_error_expired;
            }
            switch (i) {
                case 10006:
                case 10007:
                case 10010:
                    break;
                case 10008:
                case 10009:
                    return R.string.xiaoying_str_iap_coupon_can_not_use;
                default:
                    return -1;
            }
        }
        return R.string.xiaoying_str_iap_coupon_invalid;
    }
}
