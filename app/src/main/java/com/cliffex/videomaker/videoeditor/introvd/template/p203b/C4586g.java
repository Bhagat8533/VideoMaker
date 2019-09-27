package com.introvd.template.p203b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.app.utils.C4402e;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.p414ui.dialog.C8944b;
import com.introvd.template.p414ui.dialog.C8978m;
import com.p131c.p132a.C2561a;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.b.g */
public final class C4586g {
    private static C8944b bKQ;
    /* access modifiers changed from: private */
    public static TextView bKR;
    private static Handler bKS = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 6 && C4586g.bKR != null) {
                C4586g.bKR.setText(message.obj.toString());
            }
        }
    };
    public static boolean bKT = false;
    private static ProgressDialog bjf;

    /* renamed from: com.introvd.template.b.g$a */
    public interface C4595a {
        /* renamed from: cd */
        void mo24875cd(boolean z);
    }

    /* renamed from: B */
    public static void m11693B(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            bjf = new ProgressDialog(activity);
            bjf.setMessage(activity.getResources().getString(C10122R.string.xiaoying_str_com_loading));
            bjf.setProgressStyle(0);
            bjf.setIndeterminate(false);
            bjf.setCancelable(true);
            bjf.setCanceledOnTouchOutside(false);
            bjf.show();
        }
    }

    /* renamed from: Sk */
    public static boolean m11694Sk() {
        return bjf != null;
    }

    /* renamed from: Sl */
    public static synchronized void m11695Sl() {
        synchronized (C4586g.class) {
            if (bjf != null) {
                try {
                    bjf.cancel();
                } catch (Exception unused) {
                }
                bjf = null;
            }
        }
    }

    /* renamed from: Sm */
    public static synchronized void m11696Sm() {
        synchronized (C4586g.class) {
            if (bjf != null) {
                try {
                    bjf.dismiss();
                } catch (Exception unused) {
                }
                bjf = null;
            }
        }
    }

    /* renamed from: Sn */
    public static synchronized void m11697Sn() {
        synchronized (C4586g.class) {
            if (bKQ != null) {
                try {
                    bKQ.cancel();
                } catch (Exception unused) {
                }
                bKQ = null;
            }
        }
    }

    /* renamed from: W */
    public static void m11699W(final Activity activity) {
        if (activity != null && !activity.isFinishing() && C2561a.aOR() == 1) {
            if (VERSION.SDK_INT >= 26) {
                m11700X(activity);
            } else {
                C8978m.m26348af(activity, activity.getString(C10122R.string.xiaoying_str_com_cancel), activity.getString(C10122R.string.xiaoying_str_com_invite_community_ok)).mo10293dl(C10122R.string.xiaoying_str_shortcut_create_tip_title).mo10296do(C10122R.string.xiaoying_str_shortcut_create_mv_tip_msg).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C4586g.m11700X(activity);
                    }
                }).mo10290az(false).mo10313qu().show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public static void m11700X(Activity activity) {
        if (activity != null) {
            C4402e.m11115a((Context) activity, "action_launch_xiaoying_intenthome_mv", "", C10122R.C10123drawable.editor_launch_edit_mv_icon, activity.getString(C10122R.string.xiaoying_str_com_home_edit_photo));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m11701a(Activity activity, Intent intent, int i) {
        m11702a(activity, intent, i, true, null);
    }

    /* renamed from: a */
    private static void m11702a(final Activity activity, Intent intent, int i, final boolean z, final C4595a aVar) {
        if (C4600l.m11739k(activity, true)) {
            List queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities.size() > 1) {
                String[] strArr = new String[queryIntentActivities.size()];
                final String[] strArr2 = new String[queryIntentActivities.size()];
                for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                    ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i2);
                    strArr[i2] = resolveInfo.activityInfo.applicationInfo.loadLabel(activity.getPackageManager()).toString();
                    strArr2[i2] = resolveInfo.activityInfo.packageName;
                }
                Builder builder = new Builder(activity);
                final Intent intent2 = intent;
                final Activity activity2 = activity;
                final int i3 = i;
                final C4595a aVar2 = aVar;
                final boolean z2 = z;
                C45937 r4 = new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            intent2.setPackage(strArr2[i]);
                            activity2.startActivityForResult(intent2, i3);
                            if (aVar2 != null) {
                                aVar2.mo24875cd(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (aVar2 != null) {
                                aVar2.mo24875cd(false);
                            }
                        }
                        if (z2) {
                            UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity2, null, "unlocked");
                        }
                    }
                };
                builder.setItems(strArr, r4).setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (z) {
                            UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, null, "cancel");
                        }
                        if (aVar != null) {
                            aVar.mo24875cd(false);
                        }
                    }
                }).setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return i == 84;
                    }
                }).show();
            } else {
                try {
                    activity.startActivityForResult(intent, i);
                    if (z) {
                        UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, null, "unlocked");
                    } else if (aVar != null) {
                        aVar.mo24875cd(true);
                    }
                } catch (ActivityNotFoundException unused) {
                    ToastUtils.show((Context) activity, C10122R.string.xiaoying_str_studio_msg_app_not_found, 0);
                    if (z) {
                        UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, null, "cancel");
                    } else if (aVar != null) {
                        aVar.mo24875cd(false);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11703a(Context context, int i, OnCancelListener onCancelListener) {
        synchronized (C4586g.class) {
            if (bjf != null) {
                m11696Sm();
            }
            if (m11711dJ(context)) {
                bjf = new ProgressDialog(context, C10122R.style.MyAlertDialogStyle);
                bjf.requestWindowFeature(1);
                try {
                    bjf.show();
                    try {
                        bjf.setContentView(C10122R.C10126layout.xiaoying_com_simple_dialogue_content);
                        TextView textView = (TextView) bjf.findViewById(C10122R.C10124id.check_update_dialog_txt);
                        if (i == -1) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            textView.setText(i);
                        }
                        textView.setVisibility(8);
                        if (i == C10122R.string.xiaoying_str_com_check_new_version_dialog || i == C10122R.string.xiaoying_str_ve_msg_download_engine_patch_requesting_server || i == -1) {
                            bjf.setCancelable(true);
                            if (onCancelListener != null) {
                                bjf.setOnCancelListener(onCancelListener);
                            }
                        } else {
                            bjf.setCancelable(false);
                        }
                    } catch (Exception unused) {
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11704a(Context context, int i, OnCancelListener onCancelListener, boolean z) {
        synchronized (C4586g.class) {
            if (bjf != null) {
                m11696Sm();
            }
            if (m11711dJ(context)) {
                bjf = new ProgressDialog(context, C10122R.style.MyAlertDialogStyle);
                bjf.requestWindowFeature(1);
                try {
                    bjf.show();
                    try {
                        bjf.setContentView(C10122R.C10126layout.xiaoying_com_simple_dialogue_content);
                        TextView textView = (TextView) bjf.findViewById(C10122R.C10124id.check_update_dialog_txt);
                        if (i == -1) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            textView.setText(i);
                        }
                        textView.setVisibility(8);
                        bjf.setCancelable(z);
                        bjf.setCanceledOnTouchOutside(false);
                        if (onCancelListener != null && z) {
                            bjf.setOnCancelListener(onCancelListener);
                        }
                    } catch (Exception unused) {
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m11705a(Context context, String str, OnCancelListener onCancelListener, boolean z) {
        synchronized (C4586g.class) {
            if (bjf != null) {
                m11696Sm();
            }
            if (m11711dJ(context)) {
                bjf = new ProgressDialog(context, C10122R.style.MyAlertDialogStyle);
                bjf.requestWindowFeature(1);
                try {
                    bjf.show();
                    try {
                        bjf.setContentView(C10122R.C10126layout.xiaoying_com_simple_dialogue_content);
                        bKR = (TextView) bjf.findViewById(C10122R.C10124id.progress_percent);
                        if (TextUtils.isEmpty(str)) {
                            bKR.setVisibility(8);
                        } else {
                            bKR.setVisibility(0);
                            bKR.setText(str);
                        }
                        bjf.setCancelable(z);
                        bjf.setCanceledOnTouchOutside(false);
                        if (onCancelListener != null && z) {
                            bjf.setOnCancelListener(onCancelListener);
                        }
                    } catch (Exception unused) {
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static void m11706a(Context context, boolean z, Object obj, Object obj2, Object obj3, Object obj4, View.OnClickListener onClickListener) {
        m11708a(context, z, obj, Integer.valueOf(-1), obj2, obj3, Integer.valueOf(-1), Integer.valueOf(-1), obj4, Integer.valueOf(-1), false, Integer.valueOf(-1), onClickListener, Integer.valueOf(-1));
    }

    /* renamed from: a */
    public static void m11707a(Context context, boolean z, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, View.OnClickListener onClickListener) {
        m11708a(context, z, obj, Integer.valueOf(-1), obj2, obj3, Integer.valueOf(-1), Integer.valueOf(-1), obj5, Integer.valueOf(-1), false, obj6, onClickListener, Integer.valueOf(-1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m11708a(android.content.Context r17, boolean r18, java.lang.Object r19, java.lang.Object r20, java.lang.Object r21, java.lang.Object r22, java.lang.Object r23, java.lang.Object r24, java.lang.Object r25, java.lang.Object r26, boolean r27, java.lang.Object r28, android.view.View.OnClickListener r29, java.lang.Object r30) {
        /*
            java.lang.Class<com.introvd.template.b.g> r1 = com.introvd.template.p203b.C4586g.class
            monitor-enter(r1)
            boolean r0 = m11711dJ(r17)     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r1)
            return
        L_0x000b:
            com.introvd.template.ui.dialog.b r0 = bKQ     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0012
            m11697Sn()     // Catch:{ all -> 0x0041 }
        L_0x0012:
            com.introvd.template.ui.dialog.b r0 = bKQ     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x003f
            com.introvd.template.ui.dialog.b r0 = new com.introvd.template.ui.dialog.b     // Catch:{ all -> 0x0041 }
            r2 = r0
            r3 = r17
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r29
            r14 = r18
            r15 = r28
            r16 = r30
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0041 }
            bKQ = r0     // Catch:{ all -> 0x0041 }
            com.introvd.template.ui.dialog.b r0 = bKQ     // Catch:{ all -> 0x0041 }
            r0.show()     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p203b.C4586g.m11708a(android.content.Context, boolean, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, boolean, java.lang.Object, android.view.View$OnClickListener, java.lang.Object):void");
    }

    /* renamed from: d */
    public static void m11710d(final Activity activity, final int i, final String str) {
        if (activity != null) {
            C8978m.m26349hs(activity).mo10296do(C10122R.string.xiaoying_str_template_rate_unlock_dialog_content).mo10277a(Typeface.defaultFromStyle(1), (Typeface) null).mo10303dv(C10122R.string.xiaoying_str_com_cancel).mo10299dr(C10122R.string.xiaoying_str_template_rate_unlock_dialog_confirm).mo10300ds(activity.getResources().getColor(C10122R.color.color_ff5e13)).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    Activity activity = activity;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("+cancel");
                    UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, sb.toString(), null);
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(activity.getPackageName());
                    intent.setData(Uri.parse(sb.toString()));
                    C4586g.m11701a(activity, intent, i);
                    Activity activity = activity;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("+rate");
                    UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, sb2.toString(), null);
                }
            }).mo10275a((OnCancelListener) new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    Activity activity = activity;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("+cancel");
                    UserBehaviorUtilsV5.onEventUnlockMaterialRate(activity, sb.toString(), null);
                }
            }).mo10313qu().show();
        }
    }

    /* renamed from: dJ */
    private static boolean m11711dJ(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getWindow() != null && !activity.isFinishing()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: dK */
    public static synchronized void m11712dK(Context context) {
        synchronized (C4586g.class) {
            m11705a(context, "", (OnCancelListener) null, false);
        }
    }

    /* renamed from: eJ */
    public static void m11713eJ(String str) {
        bKS.sendMessage(bKS.obtainMessage(6, str));
    }

    /* renamed from: j */
    public static synchronized void m11714j(Context context, boolean z) {
        synchronized (C4586g.class) {
            m11704a(context, C10122R.string.xiaoying_str_com_loading, (OnCancelListener) null, z);
        }
    }
}
