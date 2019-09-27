package com.introvd.template.p363o;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.p414ui.dialog.C8978m;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.o.c */
public class C8093c {
    /* renamed from: a */
    public static C1890f m23475a(int i, Context context, final OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if (context == null) {
            return null;
        }
        C1890f qu = C8978m.m26348af(context, context.getString(C10122R.string.xiaoying_permission_not_now), context.getString(C10122R.string.xiaoying_permission_app_settings)).mo10312q(m23480f(i, context)).mo10315r(m23478d(i, context)).mo10290az(false).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(fVar.mo10252a(bVar));
                }
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                if (onClickListener != null) {
                    onClickListener.onClick(fVar.mo10252a(bVar));
                }
            }
        }).mo10313qu();
        qu.show();
        return qu;
    }

    /* renamed from: a */
    public static C1890f m23476a(int i, Context context, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return m23477a(i, context, z, onClickListener, onClickListener2, null);
    }

    /* renamed from: a */
    public static C1890f m23477a(int i, Context context, boolean z, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        C1890f qu = C8978m.m26348af(context, context.getString(C10122R.string.xiaoying_permission_deny), context.getString(C10122R.string.xiaoying_permission_allow)).mo10312q(m23480f(i, context)).mo10315r(m23479e(i, context)).mo10277a(Typeface.defaultFromStyle(1), (Typeface) null).mo10290az(z).mo10289aB(false).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                fVar.dismiss();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(fVar.mo10252a(bVar));
                }
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                fVar.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(fVar.mo10252a(bVar));
                }
            }
        }).mo10275a((OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        }).mo10313qu();
        qu.show();
        return qu;
    }

    /* renamed from: d */
    private static String m23478d(int i, Context context) {
        String sS = m23481sS(i);
        StringBuilder sb = new StringBuilder();
        if (context == null) {
            return sb.toString();
        }
        sb.append(m23479e(i, context));
        sb.append("\n");
        sb.append("\n");
        sb.append(VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_setting_msg, new Object[]{sS}));
        return sb.toString();
    }

    /* renamed from: e */
    private static String m23479e(int i, Context context) {
        if (context == null) {
            return "";
        }
        String sS = m23481sS(i);
        switch (i) {
            case 0:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_sdcard_msg, new Object[]{sS, sS});
            case 1:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_location_msg, new Object[]{sS});
            case 2:
            case 3:
            case 4:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_mic_camera_msg, new Object[]{sS, sS});
            case 5:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_record_msg, new Object[]{sS, sS});
            case 6:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_title, new Object[]{sS});
            case 7:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_title, new Object[]{sS});
            default:
                return "";
        }
    }

    /* renamed from: f */
    private static String m23480f(int i, Context context) {
        if (context == null) {
            return "";
        }
        return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_rationale_allow_title, new Object[]{m23481sS(i)});
    }

    /* renamed from: sS */
    private static String m23481sS(int i) {
        String str = "";
        switch (i) {
            case 0:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_storage);
            case 1:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_location);
            case 2:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_camera_and_mic);
            case 3:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_camera);
            case 4:
            case 5:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_mic);
            case 6:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_phone);
            case 7:
                return VivaBaseApplication.m8749FZ().getString(C10122R.string.xiaoying_permission_camera);
            default:
                return str;
        }
    }
}
