package com.introvd.template.biz.user.p206b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.introvd.template.biz.user.R;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.user.model.SnsAuthTransData;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import com.quvideo.auth.C4707a;
import com.quvideo.auth.C4708b;
import com.quvideo.sns.base.p227a.C4973b.C4975a;
import com.quvideo.sns.base.p227a.C4976c;

/* renamed from: com.introvd.template.biz.user.b.b */
public class C4608b implements C4976c {
    private static C4608b bLM;
    private C4610a bLK;
    protected C4976c bLL;
    protected Context mContext;

    /* renamed from: com.introvd.template.biz.user.b.b$a */
    public interface C4610a {
        /* renamed from: fZ */
        void mo24878fZ(int i);

        void onAuthComplete(int i, Bundle bundle);
    }

    private C4608b() {
    }

    /* renamed from: ST */
    public static C4608b m11752ST() {
        if (bLM == null) {
            bLM = new C4608b();
        }
        return bLM;
    }

    public static boolean isSnsSDKAndApkInstalled(Context context, int i, boolean z) {
        boolean isSnsSDKAndApkInstalled = C4707a.isSnsSDKAndApkInstalled(context, i);
        if (!isSnsSDKAndApkInstalled && z) {
            ToastUtils.show(context, R.string.xiaoying_str_com_no_sns_client, 1);
        }
        return isSnsSDKAndApkInstalled;
    }

    /* renamed from: C */
    public boolean mo24883C(Context context, int i) {
        return C4708b.m12222Ee().mo25173C(context, i);
    }

    /* renamed from: a */
    public void mo24884a(C4610a aVar) {
        this.bLK = aVar;
    }

    public void auth(Activity activity, Builder builder) {
        if (activity != null) {
            if (this.mContext == null) {
                this.mContext = activity.getApplicationContext();
            }
            final SnsAuthTransData build = builder.build();
            if (build.snsType != 38 || isSnsSDKAndApkInstalled(activity, 38, true)) {
                C4975a a = new C4975a().mo25438fY(build.snsType).mo25437cL(AppStateModel.getInstance().getCountryCode()).mo25436bp(build.isSpecialLogin).mo25435a((C4976c) this);
                this.bLL = new C4976c() {
                    /* renamed from: fZ */
                    public void mo24887fZ(int i) {
                    }

                    public void onAuthCancel(int i) {
                        if (build.snsAuthListener != null) {
                            build.snsAuthListener.onAuthCancel(i);
                        }
                    }

                    public void onAuthComplete(int i, Bundle bundle) {
                        if (build.snsAuthListener != null) {
                            build.snsAuthListener.onAuthComplete(i, bundle);
                        }
                    }

                    public void onAuthFail(int i, int i2, String str) {
                        if (build.snsAuthListener != null) {
                            build.snsAuthListener.onAuthFail(i, i2, str);
                        }
                    }
                };
                C4708b.m12222Ee().mo25174a(activity, a);
            }
        }
    }

    public void authorizeCallBack(Activity activity, int i, int i2, int i3, Intent intent) {
        C4708b.m12222Ee().authorizeCallBack(activity, i, i2, i3, intent);
    }

    /* renamed from: fZ */
    public void mo24887fZ(int i) {
        if (this.bLK != null) {
            this.bLK.mo24878fZ(i);
        }
    }

    public void onAuthCancel(int i) {
        if (this.bLL != null) {
            this.bLL.onAuthCancel(i);
        }
    }

    public void onAuthComplete(int i, Bundle bundle) {
        if (this.bLK != null) {
            this.bLK.onAuthComplete(i, bundle);
        }
        if (this.bLL != null) {
            this.bLL.onAuthComplete(i, bundle);
        }
    }

    public void onAuthFail(int i, int i2, String str) {
        if (this.bLL != null) {
            this.bLL.onAuthFail(i, i2, str);
        }
    }

    public void unAuth(Context context, int i) {
        if (this.mContext == null && context != null) {
            this.mContext = context.getApplicationContext();
        }
        C4708b.m12222Ee().mo25175a(context, i, this);
    }

    public void unregisterAuthListener() {
        this.bLL = null;
    }
}
