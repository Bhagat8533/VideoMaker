package com.introvd.template.p203b;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.b.l */
public class C4600l {
    private static final String TAG = "l";
    private static boolean bLa = true;

    @Deprecated
    /* renamed from: c */
    private static boolean m11737c(Context context, int i, boolean z) {
        switch (BaseSocialNotify.checkNetworkPrefAndState(context, i)) {
            case -2:
                if (bLa) {
                    m11738d(context, -2, z);
                }
                LogUtils.m14222e(TAG, "Network is not allow access");
                break;
            case -1:
                if (bLa) {
                    m11738d(context, -1, z);
                }
                LogUtils.m14222e(TAG, "Network is inactive");
                break;
            case 0:
                bLa = true;
                return true;
        }
        return false;
    }

    /* renamed from: d */
    public static void m11738d(final Context context, int i, boolean z) {
        if (z && context != null) {
            if (i == -1) {
                ToastUtils.show(context, C10122R.string.xiaoying_str_com_msg_network_inactive, 0);
            } else if (i == -2) {
                try {
                    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        return;
                    }
                } catch (Exception unused) {
                }
                if (!(context instanceof Activity)) {
                    ToastUtils.show(context, C10122R.string.xiaoying_str_com_msg_network_3g_not_allow, 0);
                    return;
                }
                C8978m.m26349hs(context).mo10293dl(C10122R.string.xiaoying_str_com_info_title).mo10296do(C10122R.string.xiaoying_str_com_msg_network_3g_not_allow).mo10303dv(C10122R.string.xiaoying_str_com_cancel).mo10299dr(C10122R.string.xiaoying_str_com_setting).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        try {
                            VivaRouter.getRouterBuilder(SettingPrams.URL).mo10382H(context);
                        } catch (Exception unused) {
                        }
                    }
                }).mo10313qu().show();
            }
        }
    }

    /* renamed from: k */
    public static boolean m11739k(Context context, boolean z) {
        return m11737c(context, 0, z);
    }

    /* renamed from: l */
    public static boolean m11740l(Context context, boolean z) {
        return m11737c(context, 2, z);
    }
}
