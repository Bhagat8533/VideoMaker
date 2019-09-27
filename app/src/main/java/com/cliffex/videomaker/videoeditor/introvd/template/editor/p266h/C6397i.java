package com.introvd.template.editor.p266h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.effects.customwatermark.C6091d;
import com.introvd.template.editor.effects.customwatermark.C6092e;
import com.introvd.template.editor.effects.customwatermark.C6096h;
import com.introvd.template.editor.export.C6244e;
import com.introvd.template.editor.export.C6271n;
import com.introvd.template.editor.export.ExportAnimationView.C6195a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p244a.C5555c;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.dialog.C8970j;
import com.introvd.template.p414ui.dialog.C8970j.C8971a;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.AppRouter.IntentHomeParams;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.sdk.editor.p389c.C8438d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.utils.C8481a;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8559n;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p394b.p395a.C8508c;
import com.introvd.template.sdk.utils.p394b.p395a.C8510e;
import com.introvd.template.sdk.utils.p394b.p395a.C8512f;
import com.introvd.template.sdk.utils.p394b.p395a.C8516i;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Locale;
import xiaoying.engine.QEngine;
import xiaoying.engine.storyboard.QStoryboard;

@LDPProtect
/* renamed from: com.introvd.template.editor.h.i */
public class C6397i implements C6244e, C8508c {
    public boolean bOL = false;
    public boolean cPt = false;
    /* access modifiers changed from: private */
    public boolean dkK = false;
    /* access modifiers changed from: private */
    public boolean dkL = false;
    /* access modifiers changed from: private */
    public C6271n dkM = null;
    /* access modifiers changed from: private */
    public C8970j dkN = null;
    /* access modifiers changed from: private */
    public String dkO;
    /* access modifiers changed from: private */
    public String dkP = "";
    /* access modifiers changed from: private */
    public boolean dkQ = false;
    /* access modifiers changed from: private */
    public int dkR = 0;
    private C8512f dkS = null;
    private boolean dkT = false;
    private C8510e dkU = null;
    /* access modifiers changed from: private */
    public String dkV;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.editor.h.i$a */
    public interface C6403a {
        void abW();

        void abX();

        /* renamed from: dT */
        void mo27398dT(boolean z);

        /* renamed from: fY */
        void mo27399fY(String str);

        /* renamed from: fZ */
        void mo27400fZ(String str);

        /* renamed from: kw */
        void mo27401kw(int i);

        /* renamed from: kx */
        void mo27402kx(int i);
    }

    public C6397i(Context context, String str) {
        this.mContext = context;
        this.dkP = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18398a(Activity activity, final C6403a aVar) {
        if (activity != null && !activity.isFinishing() && this.dkM != null) {
            if (this.dkN == null) {
                this.dkN = new C8970j(activity, new C8971a() {
                    public void buttonClick(int i) {
                        if (i == 0) {
                            if (C6397i.this.dkN != null && C6397i.this.dkN.isShowing()) {
                                C6397i.this.dkN.dismiss();
                            }
                        } else if (i == 1) {
                            C6397i.this.alr();
                            if (C6397i.this.dkM != null) {
                                C6397i.this.dkM.dismiss();
                            }
                            if (aVar != null) {
                                aVar.abX();
                            }
                        }
                        C6397i.this.dkN = null;
                    }
                });
                this.dkN.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        C6397i.this.dkN = null;
                    }
                });
                this.dkN.setDialogTitle("   ");
                this.dkN.setDialogIcon(R.drawable.xiaoying_com_export_wait_icon);
                this.dkN.setDialogContent(this.mContext.getString(R.string.xiaoying_str_com_export_cancel_tip, new Object[]{this.dkM.cRf}));
                this.dkN.mo35614bg(this.mContext.getString(R.string.xiaoying_str_com_export_wait_btn), this.mContext.getString(R.string.xiaoying_str_com_export_cancel_btn));
                this.dkN.show();
                return;
            }
            if (this.dkN.isShowing()) {
                this.dkN.cancel();
            }
            this.dkN = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18399a(Activity activity, VideoExportParamsModel videoExportParamsModel, String str) {
        if (videoExportParamsModel.is2k4kExp() && videoExportParamsModel.isForceSWExp) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", str);
            UserBehaviorLog.onKVEvent(activity, "Share_Export_Failed_4k_Retry_Soft_Result", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m18402a(Activity activity, DataItemProject dataItemProject, QStoryboard qStoryboard, C6403a aVar, C8501a aVar2, VideoExportParamsModel videoExportParamsModel) {
        Activity activity2 = activity;
        DataItemProject dataItemProject2 = dataItemProject;
        QStoryboard qStoryboard2 = qStoryboard;
        VideoExportParamsModel videoExportParamsModel2 = videoExportParamsModel;
        this.dkR++;
        if (dataItemProject2 == null) {
            return true;
        }
        this.dkL = false;
        final String str = dataItemProject2.strPrjURL;
        Context applicationContext = activity.getApplicationContext();
        if (m18416zt()) {
            ToastUtils.show(applicationContext, activity.getResources().getString(R.string.xiaoying_str_com_msg_low_diskspace_warning), 2000);
        }
        int duration = qStoryboard2 != null ? qStoryboard.getDuration() : 0;
        this.dkO = null;
        this.dkM = new C6271n(activity2);
        this.dkM.setOwnerActivity(activity2);
        final Activity activity3 = activity;
        final C6403a aVar3 = aVar;
        final VideoExportParamsModel videoExportParamsModel3 = videoExportParamsModel;
        final DataItemProject dataItemProject3 = dataItemProject;
        C63992 r10 = r0;
        final QStoryboard qStoryboard3 = qStoryboard;
        Context context = applicationContext;
        final C8501a aVar4 = aVar2;
        C63992 r0 = new C6195a() {
            public void alk() {
                C6397i.this.m18398a(activity3, aVar3);
            }

            public void all() {
                if (C6397i.this.dkM != null) {
                    C6397i.this.dkM.dismiss();
                    C6397i.this.dkM = null;
                }
                C6397i.this.dkK = false;
                if (aVar3 != null) {
                    aVar3.mo27399fY(C6397i.this.dkO);
                }
            }

            public void alm() {
                if (!(C6397i.this.dkM == null || !C4600l.m11739k(C6397i.this.dkM.getOwnerActivity(), true) || aVar3 == null)) {
                    aVar3.mo27400fZ(C6397i.this.dkO);
                }
            }

            /* renamed from: fH */
            public void mo29022fH(boolean z) {
                if (C6397i.this.dkM != null) {
                    C6397i.this.dkM.dismiss();
                    C6397i.this.dkM = null;
                }
                videoExportParamsModel3.isForceSWExp = z;
                if (!z) {
                    String str = "Share_Export_Retry_Modify";
                    if (C6397i.this.dkQ) {
                        str = "Share_Export_Retry_Modify_HD";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("choose", "retry");
                    UserBehaviorLog.onKVEvent(activity3, str, hashMap);
                    C6397i.this.dkK = false;
                    if (C6397i.this.dkR >= 3) {
                        videoExportParamsModel3.encodeType = C8572y.aJn();
                        videoExportParamsModel3.decodeType = C8572y.aJo();
                    } else {
                        videoExportParamsModel3.isSingleHW = C5842b.ahg();
                    }
                } else {
                    videoExportParamsModel3.encodeType = C8572y.aJn();
                }
                if (videoExportParamsModel3.is2k4kExp()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Which", z ? "Soft_Export" : "Hard-Export");
                    UserBehaviorLog.onKVEvent(activity3, "Share_Export_Failed_4k_Retry", hashMap2);
                }
                C6397i.this.m18402a(activity3, dataItemProject3, qStoryboard3, aVar3, aVar4, videoExportParamsModel3);
            }
        };
        final long currentTimeMillis = System.currentTimeMillis();
        this.dkM.setListener(r10);
        final Context context2 = context;
        final VideoExportParamsModel videoExportParamsModel4 = videoExportParamsModel;
        final int i = duration;
        String str2 = str;
        final DataItemProject dataItemProject4 = dataItemProject;
        C64003 r15 = r0;
        final C6403a aVar5 = aVar;
        C64003 r02 = new C8512f() {

            /* renamed from: Lb */
            private float f3506Lb = 0.0f;
            private boolean dld = false;
            private long dle = 0;
            private String dlf;

            /* renamed from: pD */
            private String m18424pD(int i) {
                return i >= 90 ? "90-100%" : i >= 80 ? "80-90%" : i >= 70 ? "70-80%" : i >= 60 ? "60-70%" : i >= 50 ? "50-60%" : i >= 40 ? "40-50%" : i >= 30 ? "30-40%" : i >= 20 ? "20-30%" : i >= 10 ? "10-20%" : "<10";
            }

            public void ama() {
                C4597i.m11728a(false, activity3);
                String pD = m18424pD((int) this.f3506Lb);
                if (this.dld) {
                    pD = "freezed";
                }
                String str = pD;
                boolean z = C6271n.cRb;
                C5554b.m15015a(context2, C8501a.aJs().aJv(), dataItemProject4, currentTimeMillis > 0 ? System.currentTimeMillis() - currentTimeMillis : 0, str, C6397i.this.dkP, C6397i.this.dkQ ? "Share_Export_Cancel_Modify_HD" : "Share_Export_Cancel_Modify", videoExportParamsModel4, z, C6397i.this.dkV, C6397i.this.cPt);
                C6397i.this.dkK = false;
                C6397i.this.dkM = null;
                if (aVar5 != null) {
                    aVar5.abX();
                }
                C6397i.this.m18399a(activity3, videoExportParamsModel4, "cancel");
            }

            public void amb() {
            }

            /* renamed from: av */
            public void mo29115av(float f) {
                if (Float.compare(this.f3506Lb, f) != 0) {
                    this.dle = System.currentTimeMillis();
                    this.dld = false;
                } else if (System.currentTimeMillis() - this.dle > 30000) {
                    this.dld = true;
                }
                int i = (int) f;
                this.f3506Lb = f;
                if (aVar5 != null) {
                    aVar5.mo27402kx(i);
                }
            }

            /* renamed from: hM */
            public void mo29116hM(String str) {
                String str2 = str;
                C4597i.m11728a(false, activity3);
                StringBuilder sb = new StringBuilder();
                sb.append("onExportSuccess video_fullPath=");
                sb.append(str2);
                LogUtilsV2.m14230i(sb.toString());
                if (!TextUtils.isEmpty(str)) {
                    this.dlf = str2;
                    C8481a.m24576av(context2, str2);
                    QEngine aJv = C8501a.aJs().aJv();
                    C8481a.m24575a(context2, str2, C8541r.m24979e(aJv, str2));
                    VeMSize f = C8541r.m24980f(aJv, str2);
                    if (f.width == 0 || f.height == 0) {
                        mo29117n(9999, "Error during export,exported video with width or height is zero.");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    String str3 = C6397i.this.dkQ ? "Share_Export_Done_Modify_HD" : "Share_Export_Done_modify";
                    int d = C8572y.m25085d(aJv, str2);
                    int i = d;
                    C5554b.m15018a(activity3, aJv, str, currentTimeMillis, C6397i.this.dkP, str3, d, C6271n.cRb, C6397i.this.dkV, C6397i.this.dkR, C6397i.this.cPt, C6397i.this.m18415pC(videoExportParamsModel4.expType.intValue()));
                    if (Math.abs(i - i) > 2000) {
                        HashMap hashMap = new HashMap();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(i);
                        hashMap.put("destDuration", sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(i);
                        hashMap.put("actualDuration", sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("");
                        sb4.append(i);
                        sb4.append("_");
                        sb4.append(i);
                        hashMap.put("dest_actual", sb4.toString());
                        hashMap.put("exp_params", videoExportParamsModel4.toString());
                        UserBehaviorLog.onAliEvent("Dev_Event_Exp_Video_Duration_Error", hashMap);
                        ProjectScanService.m19493a(activity3, str, this.dlf);
                    }
                    if (videoExportParamsModel4.isGifExp() && videoExportParamsModel4.gifParam != null) {
                        C5555c.m15037a(activity3, videoExportParamsModel4, "Share_Export_Gif_Done");
                    }
                    ToastUtils.show(C6397i.this.mContext, R.string.xiaoying_str_ve_msg_video_or_prj_export_success, 1);
                    C4580b.m11643a(context2, new String[]{str2}, null, null);
                    if (videoExportParamsModel4.bNeedUpdatePathToPrj) {
                        dataItemProject4.strPrjExportURL = str2;
                        dataItemProject4.iIsModified = 2;
                    }
                    C6397i.this.dkO = str2;
                    if (C6397i.this.dkM != null) {
                        try {
                            C6397i.this.dkM.mo29208fR(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    ISettingRouter iSettingRouter = (ISettingRouter) C1919a.m5529sc().mo10356i(ISettingRouter.class);
                    if (iSettingRouter != null) {
                        Long a = C8559n.m25038a(videoExportParamsModel4, C4580b.m11644b(C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(context2.getApplicationContext()).value)));
                        UtilsPrefs with = UtilsPrefs.with(context2, AppRouter.VIVA_APP_PREF_FILENAME, true);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(IntentHomeParams.WATER_MARK_PREF);
                        sb5.append(str);
                        with.writeLong(sb5.toString(), a.longValue());
                    }
                    C6397i.this.m18399a(activity3, videoExportParamsModel4, "success");
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:55:0x0238  */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x023b  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0256  */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0299  */
            /* renamed from: n */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo29117n(int r22, java.lang.String r23) {
                /*
                    r21 = this;
                    r1 = r21
                    r15 = r22
                    android.app.Activity r0 = r2
                    r13 = 0
                    com.introvd.template.p203b.C4597i.m11728a(r13, r0)
                    r14 = 11
                    r12 = 1
                    r0 = 9428996(0x8fe004, float:1.3212838E-38)
                    if (r15 == r0) goto L_0x0111
                    com.introvd.template.sdk.utils.b.a.b r0 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    if (r0 == 0) goto L_0x0051
                    com.quvideo.rescue.model.LogModel r0 = new com.quvideo.rescue.model.LogModel
                    r0.<init>()
                    com.introvd.template.sdk.utils.b.a.b r2 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    java.lang.String r2 = r2.toString()
                    com.quvideo.rescue.model.LogModel r0 = r0.withMessage(r2)
                    java.lang.String r2 = "WTF"
                    com.quvideo.rescue.model.LogModel r0 = r0.withLogLevel(r2)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Video_Export_Err_"
                    r2.append(r3)
                    r2.append(r15)
                    java.lang.String r2 = r2.toString()
                    com.quvideo.rescue.model.LogModel r0 = r0.withTag(r2)
                    android.app.Activity r2 = r2
                    java.lang.Class r2 = r2.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    com.quvideo.rescue.model.LogModel r0 = r0.withPageName(r2)
                    com.quvideo.rescue.C4905b.m12541a(r0)
                L_0x0051:
                    android.app.Activity r0 = r2
                    java.lang.String r2 = r8
                    java.lang.String[] r3 = new java.lang.String[r12]
                    java.lang.String r4 = r1.dlf
                    r3[r13] = r4
                    com.introvd.template.editor.service.ProjectScanService.m19493a(r0, r2, r3)
                    r0 = 9999(0x270f, float:1.4012E-41)
                    if (r15 != r0) goto L_0x00de
                    java.util.HashMap r0 = new java.util.HashMap
                    r0.<init>()
                    android.app.Activity r2 = r2
                    android.content.Context r2 = r2.getApplicationContext()
                    java.lang.String r2 = com.introvd.template.p203b.C4580b.m11653dz(r2)
                    java.lang.String r3 = "DUID"
                    r0.put(r3, r2)
                    java.lang.String r3 = "userinfo"
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    com.introvd.template.common.model.AppStateModel r5 = com.introvd.template.common.model.AppStateModel.getInstance()
                    java.lang.String r5 = r5.getCountryCode()
                    r4.append(r5)
                    java.lang.String r5 = "_"
                    r4.append(r5)
                    com.introvd.template.common.model.AppStateModel r5 = com.introvd.template.common.model.AppStateModel.getInstance()
                    java.lang.String r5 = r5.getZoneCode()
                    r4.append(r5)
                    java.lang.String r5 = "_"
                    r4.append(r5)
                    r4.append(r2)
                    java.lang.String r2 = r4.toString()
                    r0.put(r3, r2)
                    com.introvd.template.sdk.utils.b.a.b r2 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    if (r2 == 0) goto L_0x00b6
                    java.lang.String r2 = "EngineInfo"
                    com.introvd.template.sdk.utils.b.a.b r3 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    java.lang.String r3 = r3.toString()
                    r0.put(r2, r3)
                L_0x00b6:
                    java.lang.String r2 = "FSize"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = ""
                    r3.append(r4)
                    java.lang.String r4 = r1.dlf
                    long r4 = com.introvd.template.common.FileUtils.fileSize(r4)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r0.put(r2, r3)
                    android.app.Activity r2 = r2
                    android.content.Context r2 = r2.getApplicationContext()
                    java.lang.String r3 = "Dev_Export_Width_Zero"
                    com.introvd.template.common.UserBehaviorLog.onKVEvent(r2, r3, r0)
                    goto L_0x0111
                L_0x00de:
                    if (r15 != r14) goto L_0x0111
                    java.util.HashMap r0 = new java.util.HashMap
                    r0.<init>()
                    java.lang.String r2 = "error"
                    com.introvd.template.sdk.utils.b.a.b r3 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    if (r3 != 0) goto L_0x00ee
                    java.lang.String r3 = ""
                    goto L_0x0103
                L_0x00ee:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = ""
                    r3.append(r4)
                    com.introvd.template.sdk.utils.b.a.b r4 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    java.lang.String r4 = r4.eiF
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                L_0x0103:
                    r0.put(r2, r3)
                    android.app.Activity r2 = r2
                    android.content.Context r2 = r2.getApplicationContext()
                    java.lang.String r3 = "Dev_Export_Width_Space_Not_Enough"
                    com.introvd.template.common.UserBehaviorLog.onKVEvent(r2, r3, r0)
                L_0x0111:
                    long r2 = r4
                    r4 = 0
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0123
                    long r2 = java.lang.System.currentTimeMillis()
                    long r4 = r4
                    long r2 = r2 - r4
                    r16 = r2
                    goto L_0x0125
                L_0x0123:
                    r16 = r4
                L_0x0125:
                    boolean r0 = com.introvd.template.editor.export.C6271n.cRb
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "nErrCode:"
                    r2.append(r3)
                    r2.append(r15)
                    java.lang.String r3 = ";expType:"
                    r2.append(r3)
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r3 = r6
                    java.lang.Integer r3 = r3.expType
                    r2.append(r3)
                    java.lang.String r3 = ";errMsg:"
                    r2.append(r3)
                    r3 = r23
                    r2.append(r3)
                    java.lang.String r5 = r2.toString()
                    com.introvd.template.common.LogUtilsV2.m14228e(r5)
                    r2 = 9429004(0x8fe00c, float:1.3212849E-38)
                    if (r15 != r2) goto L_0x016b
                    android.app.Activity r0 = r2
                    android.content.res.Resources r0 = r0.getResources()
                    int r2 = com.introvd.template.editor.R.string.xiaoying_str_com_msg_low_diskspace_warning
                    java.lang.String r0 = r0.getString(r2)
                    android.content.Context r2 = r3
                    r3 = 2000(0x7d0, float:2.803E-42)
                    com.introvd.template.common.ToastUtils.show(r2, r0, r3)
                    r1 = r15
                    goto L_0x01c8
                L_0x016b:
                    com.introvd.template.sdk.utils.b.a r2 = com.introvd.template.sdk.utils.p394b.C8501a.aJs()
                    xiaoying.engine.QEngine r3 = r2.aJv()
                    com.introvd.template.editor.h.i r2 = com.introvd.template.editor.p266h.C6397i.this
                    boolean r2 = r2.dkQ
                    if (r2 == 0) goto L_0x017f
                    java.lang.String r2 = "Share_Export_Fail_Modify_HD"
                L_0x017d:
                    r7 = r2
                    goto L_0x0182
                L_0x017f:
                    java.lang.String r2 = "Share_Export_Fail_Modify"
                    goto L_0x017d
                L_0x0182:
                    com.introvd.template.editor.h.i r2 = com.introvd.template.editor.p266h.C6397i.this
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r4 = r6
                    java.lang.Integer r4 = r4.expType
                    int r4 = r4.intValue()
                    java.lang.String r18 = r2.m18415pC(r4)
                    android.content.Context r2 = r3
                    com.introvd.template.sdk.model.editor.DataItemProject r4 = r9
                    com.introvd.template.editor.h.i r6 = com.introvd.template.editor.p266h.C6397i.this
                    java.lang.String r6 = r6.dkP
                    com.introvd.template.editor.h.i r8 = com.introvd.template.editor.p266h.C6397i.this
                    boolean r8 = r8.bOL
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r10 = r6
                    com.introvd.template.sdk.utils.b.a.b r9 = com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw
                    java.lang.String r11 = r9.toString()
                    com.introvd.template.editor.h.i r9 = com.introvd.template.editor.p266h.C6397i.this
                    java.lang.String r19 = r9.dkV
                    com.introvd.template.editor.h.i r9 = com.introvd.template.editor.p266h.C6397i.this
                    boolean r9 = r9.cPt
                    r20 = r9
                    r9 = r22
                    r12 = r0
                    r13 = r16
                    r1 = r15
                    r15 = r19
                    r16 = r20
                    r17 = r18
                    com.introvd.template.editor.p244a.C5554b.m15016a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17)
                    com.introvd.template.sdk.utils.b.a.b r0 = new com.introvd.template.sdk.utils.b.a.b
                    r0.<init>()
                    com.introvd.template.sdk.utils.p394b.p395a.C8510e.eiw = r0
                L_0x01c8:
                    r0 = 9429005(0x8fe00d, float:1.321285E-38)
                    if (r1 != r0) goto L_0x0210
                    r2 = r1
                    r1 = r21
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r0 = r6
                    java.lang.Integer r0 = r0.expType
                    int r0 = r0.intValue()
                    r3 = 1
                    if (r0 == r3) goto L_0x020c
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r0 = r6
                    java.lang.Integer r0 = r0.expType
                    int r0 = r0.intValue()
                    r4 = 2
                    if (r0 == r4) goto L_0x020c
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r0 = r6
                    boolean r0 = r0.isGifExp()
                    if (r0 == 0) goto L_0x01ef
                    goto L_0x020c
                L_0x01ef:
                    android.app.Activity r0 = r2
                    int r4 = com.introvd.template.editor.R.string.xiaoying_str_com_got_it
                    java.lang.String r0 = r0.getString(r4)
                    android.app.Activity r4 = r2
                    r5 = 0
                    com.afollestad.materialdialogs.f$a r0 = com.introvd.template.p414ui.dialog.C8978m.m26348af(r4, r5, r0)
                    int r4 = com.introvd.template.editor.R.string.xiaoying_str_ve_msg_go_open_hw_setting
                    com.afollestad.materialdialogs.f$a r0 = r0.mo10296do(r4)
                    com.afollestad.materialdialogs.f r0 = r0.mo10313qu()
                    r0.show()
                    goto L_0x0214
                L_0x020c:
                    com.introvd.template.editor.common.p248b.C5842b.ahf()
                    goto L_0x0214
                L_0x0210:
                    r2 = r1
                    r1 = r21
                    r3 = 1
                L_0x0214:
                    com.introvd.template.editor.h.i r0 = com.introvd.template.editor.p266h.C6397i.this
                    com.introvd.template.editor.export.n r0 = r0.dkM
                    if (r0 == 0) goto L_0x022f
                    com.introvd.template.editor.h.i r0 = com.introvd.template.editor.p266h.C6397i.this     // Catch:{ Exception -> 0x0229 }
                    com.introvd.template.editor.export.n r0 = r0.dkM     // Catch:{ Exception -> 0x0229 }
                    r4 = 0
                    r0.mo29208fR(r4)     // Catch:{ Exception -> 0x0227 }
                    goto L_0x0230
                L_0x0227:
                    r0 = move-exception
                    goto L_0x022b
                L_0x0229:
                    r0 = move-exception
                    r4 = 0
                L_0x022b:
                    r0.printStackTrace()
                    goto L_0x0230
                L_0x022f:
                    r4 = 0
                L_0x0230:
                    com.introvd.template.editor.h.i r0 = com.introvd.template.editor.p266h.C6397i.this
                    boolean r0 = r0.dkQ
                    if (r0 == 0) goto L_0x023b
                    java.lang.String r0 = "Share_Export_Retry_Modify_HD"
                    goto L_0x023d
                L_0x023b:
                    java.lang.String r0 = "Share_Export_Retry_Modify"
                L_0x023d:
                    java.util.HashMap r5 = new java.util.HashMap
                    r5.<init>()
                    java.lang.String r6 = "choose"
                    java.lang.String r7 = "failshow"
                    r5.put(r6, r7)
                    android.app.Activity r6 = r2
                    com.introvd.template.common.UserBehaviorLog.onKVEvent(r6, r0, r5)
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r0 = r6
                    boolean r0 = r0.isGifExp()
                    if (r0 == 0) goto L_0x0263
                    android.app.Activity r0 = r2
                    android.content.Context r0 = r0.getApplicationContext()
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r5 = r6
                    java.lang.String r6 = "Share_Export_Gif_Fail"
                    com.introvd.template.editor.p244a.C5555c.m15037a(r0, r5, r6)
                L_0x0263:
                    com.introvd.template.editor.h.i r0 = com.introvd.template.editor.p266h.C6397i.this
                    r0.dkL = r3
                    r5 = 11
                    if (r2 == r5) goto L_0x0288
                    r0 = 3
                    if (r2 != r0) goto L_0x0270
                    goto L_0x0288
                L_0x0270:
                    if (r2 != r3) goto L_0x0280
                    android.app.Activity r0 = r2
                    android.app.Activity r3 = r2
                    int r5 = com.introvd.template.editor.R.string.xiaoying_str_ve_msg_video_or_prj_export_failed_and_reboot_app
                    java.lang.String r3 = r3.getString(r5)
                    com.introvd.template.common.ToastUtils.show(r0, r3, r4)
                    goto L_0x0295
                L_0x0280:
                    android.app.Activity r0 = r2
                    int r4 = com.introvd.template.editor.R.string.xiaoying_str_ve_msg_video_or_prj_export_failed
                    com.introvd.template.common.ToastUtils.show(r0, r4, r3)
                    goto L_0x0295
                L_0x0288:
                    android.app.Activity r0 = r2
                    android.app.Activity r3 = r2
                    int r5 = com.introvd.template.editor.R.string.xiaoying_str_com_msg_low_memory_warning
                    java.lang.String r3 = r3.getString(r5)
                    com.introvd.template.common.ToastUtils.show(r0, r3, r4)
                L_0x0295:
                    com.introvd.template.editor.h.i$a r0 = r10
                    if (r0 == 0) goto L_0x029e
                    com.introvd.template.editor.h.i$a r0 = r10
                    r0.mo27401kw(r2)
                L_0x029e:
                    com.introvd.template.editor.h.i r0 = com.introvd.template.editor.p266h.C6397i.this
                    android.app.Activity r2 = r2
                    com.introvd.template.sdk.model.editor.VideoExportParamsModel r3 = r6
                    java.lang.String r4 = "failed"
                    r0.m18399a(r2, r3, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p266h.C6397i.C64003.mo29117n(int, java.lang.String):void");
            }
        };
        this.dkS = r15;
        this.dkM.mo29202a((C6244e) this);
        videoExportParamsModel2.mPrjPath = str2;
        this.dkK = true;
        this.dkT = false;
        C4597i.m11728a(true, activity2);
        mo29449a(aVar2, qStoryboard, videoExportParamsModel2, (C8508c) this);
        this.dkM.mo29214v(videoExportParamsModel.is2k4kExp(), videoExportParamsModel2.isForceSWExp);
        return true;
    }

    /* renamed from: a */
    private boolean m18405a(QStoryboard qStoryboard, VideoExportParamsModel videoExportParamsModel) {
        boolean z = qStoryboard != null && qStoryboard.getDuration() > 300000;
        boolean z2 = videoExportParamsModel.bHDExport && videoExportParamsModel.expType.intValue() != 1;
        boolean z3 = !videoExportParamsModel.bShowWaterMark;
        if ((z || z2 || z3) && C7738c.aEv().aNx().isEmpty()) {
            return false;
        }
        if (z2 && !C8072q.aBx().mo33072ku(C7825a.HD.getId())) {
            return false;
        }
        if (!z || C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
            return !z3 || C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId());
        }
        return false;
    }

    private void asY() {
        if (this.dkN != null && this.dkN.isShowing()) {
            this.dkN.dismiss();
        }
    }

    /* renamed from: pB */
    private void m18414pB(int i) {
        if (i == 11 && this.mContext != null) {
            ToastUtils.show(this.mContext, R.string.xiaoying_str_com_msg_low_diskspace_warning, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pC */
    public String m18415pC(int i) {
        switch (i) {
            case 1:
                return "720";
            case 2:
                return "1080";
            case 4:
                return "2k";
            case 5:
                return "4k";
            default:
                return "other";
        }
    }

    /* renamed from: zt */
    private static boolean m18416zt() {
        boolean z = false;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        if (Utils.getUsableSpace(Environment.getExternalStorageDirectory()) < 52428800) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo29447a(Activity activity, C8381b bVar, C8501a aVar, VideoExportParamsModel videoExportParamsModel, C6403a aVar2) {
        VideoExportParamsModel videoExportParamsModel2;
        C6403a aVar3;
        Activity activity2 = activity;
        C8381b bVar2 = bVar;
        VideoExportParamsModel videoExportParamsModel3 = videoExportParamsModel;
        C6403a aVar4 = aVar2;
        if (aVar4 != null) {
            aVar2.abW();
        }
        DataItemProject aHe = bVar.aHe();
        if (aHe != null) {
            boolean z = bVar2 instanceof C8522g;
            if (z) {
                C5554b.m15014a((Context) activity2, aHe, ((C8522g) bVar2).aHd());
            }
            QStoryboard aHd = bVar.aHd();
            if (aHd != null) {
                String bf = C8404c.m24237bf(bVar.aHe()._id);
                if (z) {
                    if (aHd.getClipCount() <= 0) {
                        UserBehaviorUtils.recordExportEmptyPrj(activity.getApplicationContext());
                    }
                    C8522g gVar = (C8522g) bVar2;
                    UserBehaviorUtils.recordShareTool(activity2, bf, "Share_Export_Tool");
                    C5555c.m15039aI(activity2, gVar.aJL());
                }
                int duration = aHd.getDuration();
                C8380a aHf = bVar.aHf();
                if (mo29448a(activity, aHf, aVar2, aVar, videoExportParamsModel)) {
                    this.dkV = C8762d.aMt().mo35241l(C8540q.m24894C(aHf.getStoryboard()).longValue(), 4);
                    int om = C8558m.m25030om(aHe.strExtra);
                    long j = 0;
                    try {
                        j = (System.currentTimeMillis() - Timestamp.valueOf(aHe.strCreateTime).getTime()) / 1000;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (videoExportParamsModel3.bHDExport) {
                        VeMSize b = C8438d.m24393b(videoExportParamsModel);
                        String pC = m18415pC(videoExportParamsModel3.expType.intValue());
                        MSize mSize = null;
                        if (b != null) {
                            mSize = new MSize(b.width, b.height);
                        }
                        String str = this.dkV;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(aHe.iPrjClipCount);
                        MSize mSize2 = mSize;
                        aVar3 = aVar4;
                        VideoExportParamsModel videoExportParamsModel4 = videoExportParamsModel3;
                        videoExportParamsModel2 = videoExportParamsModel4;
                        C5554b.m15013a(activity, duration, mSize2, bf, str, sb.toString(), this.cPt, om, j, pC);
                    } else {
                        aVar3 = aVar4;
                        videoExportParamsModel2 = videoExportParamsModel3;
                        int i = om;
                        Activity activity3 = activity2;
                        C5554b.m15017a(activity, aVar.aJv(), aHe, bf, this.dkV, this.cPt, i, j);
                        if (videoExportParamsModel.isGifExp() && videoExportParamsModel2.gifParam != null) {
                            C5555c.m15037a(activity3, videoExportParamsModel2, "Share_Export_Gif_Start");
                        }
                    }
                    if (aVar3 != null) {
                        aVar3.mo27398dT(true);
                    }
                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) {
                        C4596h.m11716Sp();
                    }
                    if (videoExportParamsModel2.bHDExport) {
                        C4596h.m11718Sr();
                    }
                } else if (aVar4 != null) {
                    aVar4.mo27398dT(false);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo29448a(Activity activity, C8380a aVar, C6403a aVar2, C8501a aVar3, VideoExportParamsModel videoExportParamsModel) {
        QStoryboard qStoryboard;
        C8380a aVar4 = aVar;
        if (aVar4 == null || aVar4.mProjectDataItem == null) {
            return false;
        }
        this.dkQ = videoExportParamsModel.bHDExport;
        this.dkR = 0;
        if (aVar.getStoryboard() != null) {
            if (aVar4 instanceof C8467b) {
                C8467b bVar = (C8467b) aVar4;
                VeMSize b = C8438d.m24393b(videoExportParamsModel);
                C8540q.m24935a(bVar.dfW.GetStoryboard(), b);
                C8540q.m24930a(bVar.dfW, b);
                qStoryboard = bVar.dfW.DuplicateStoryboard();
            } else {
                qStoryboard = new QStoryboard();
                aVar.getStoryboard().duplicate(qStoryboard);
            }
            QStoryboard qStoryboard2 = qStoryboard;
            return m18402a(activity, aVar4.mProjectDataItem, qStoryboard2, aVar2, aVar3, videoExportParamsModel);
        } else if (!(aVar4 instanceof ProjectItem)) {
            return false;
        } else {
            QEngine aJv = aVar3.aJv();
            String str = aVar4.mProjectDataItem.strPrjURL;
            final C8380a aVar5 = aVar;
            final Activity activity2 = activity;
            final C6403a aVar6 = aVar2;
            final C8501a aVar7 = aVar3;
            final VideoExportParamsModel videoExportParamsModel2 = videoExportParamsModel;
            C63981 r0 = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    if (message.what == 268443649 && (message.obj instanceof QStoryboard)) {
                        aVar5.setStoryboard((QStoryboard) message.obj);
                        if (activity2 != null && !activity2.isFinishing()) {
                            C6397i.this.m18402a(activity2, aVar5.mProjectDataItem, aVar5.getStoryboard(), aVar6, aVar7, videoExportParamsModel2);
                        }
                    }
                }
            };
            C8438d.m24391a(aJv, str, (Handler) r0);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo29449a(C8501a aVar, QStoryboard qStoryboard, VideoExportParamsModel videoExportParamsModel, C8508c cVar) {
        String locale = Locale.getDefault().toString();
        ISettingRouter iSettingRouter = (ISettingRouter) C1919a.m5529sc().mo10356i(ISettingRouter.class);
        if (iSettingRouter != null) {
            locale = C4580b.m11644b(C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(this.mContext.getApplicationContext()).value));
        }
        C8516i iVar = new C8516i(C8559n.m25038a(videoExportParamsModel, locale));
        C6096h ajX = C6091d.ajW().ajX();
        if (ajX != null) {
            iVar.eiQ = true;
            iVar.mStreamSizeVe = new VeMSize(ajX.cKz, ajX.cKA);
            iVar.eiR = new VeMSize(ajX.cKB, ajX.cKC);
            iVar.cVR = C6092e.m17356a(ajX.cKy, qStoryboard.getDuration());
        }
        this.dkU = new C8510e(aVar.aJv(), iVar);
        if (!C2561a.aON() && (C8072q.aBx().mo33072ku(getClass().getSimpleName()) || !m18405a(qStoryboard, videoExportParamsModel))) {
            return false;
        }
        this.dkU.mo34671a(cVar);
        if (qStoryboard == null || qStoryboard.getDataClip() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", qStoryboard == null ? "storyboardNone" : "DataClipNone");
            hashMap.put("prjUrl", videoExportParamsModel.mPrjPath);
            UserBehaviorLog.onKVEvent(this.mContext, "Dev_Event_Export_Video_Reload", hashMap);
            this.dkU.mo34691a(videoExportParamsModel.mPrjPath, videoExportParamsModel);
        } else {
            this.dkU.mo34693a(videoExportParamsModel.mPrjPath, qStoryboard, videoExportParamsModel);
        }
        return true;
    }

    public void alo() {
        this.dkU.aJU();
    }

    public void alp() {
        if (this.dkU != null) {
            this.dkU.aJS();
        }
    }

    public void alq() {
        this.dkU.aJU();
    }

    public void alr() {
        this.dkT = true;
    }

    public void ama() {
        LogUtils.m14222e("ProjectExportManager", "onExportCancel");
        if (!this.dkT) {
            this.dkM.dismiss();
        }
        if (this.dkS != null) {
            this.dkS.ama();
        }
    }

    public void amb() {
    }

    public void apX() {
    }

    public void asU() {
        if (this.dkK && this.dkM != null) {
            this.dkU.aJS();
        }
    }

    public void asV() {
        if (this.dkK && this.dkM != null) {
            this.dkU.aJT();
        }
    }

    public void asW() {
        if (this.dkK && this.dkM != null) {
            try {
                this.dkM.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtils.m14222e("ProjectExportManager", "mSaveDialog.dismiss()");
        }
    }

    public void asX() {
        if (this.dkU != null) {
            this.dkU.aJU();
        }
    }

    /* renamed from: av */
    public void mo29115av(float f) {
        if (!this.dkL && !this.dkT && !this.dkM.amg()) {
            this.dkM.setProgress(f);
            if (f > 1.0f) {
                this.dkM.mo29207fQ(true);
            }
            if (this.dkS != null) {
                this.dkS.mo29115av(f);
            }
        }
    }

    /* renamed from: hM */
    public void mo29116hM(String str) {
        LogUtils.m14222e("ProjectExportManager", "onExportSuccess");
        this.dkM.setProgress(100.0f);
        asY();
        if (!TextUtils.isEmpty(str)) {
            this.dkM.mo29207fQ(false);
            if (this.dkS != null) {
                this.dkS.mo29116hM(str);
            }
        }
    }

    /* renamed from: n */
    public void mo29117n(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onExportFailed nErrCode=");
        sb.append(i);
        sb.append(";errMsg=");
        sb.append(str);
        LogUtils.m14222e("ProjectExportManager", sb.toString());
        asY();
        m18414pB(i);
        if (this.dkS != null) {
            this.dkS.mo29117n(i, str);
        }
    }
}
