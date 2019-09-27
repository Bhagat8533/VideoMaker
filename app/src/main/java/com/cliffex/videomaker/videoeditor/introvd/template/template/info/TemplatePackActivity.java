package com.introvd.template.template.info;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.EventActivity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.datacenter.TaskService;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.info.p410a.C8840f;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8733e.C8734a;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.template.widget.TemplatePackHeader;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.utils.QComUtils;
import xiaoying.utils.QError;

@C1942a(mo10417rZ = "/Template/Package")
public class TemplatePackActivity extends EventActivity implements OnClickListener, C8707b {
    private C8759b bOt;
    private ImageView bvn;
    private Button cub;
    /* access modifiers changed from: private */
    public String dgO;
    /* access modifiers changed from: private */
    public LinearLayout dqs;
    private Button emC;
    /* access modifiers changed from: private */
    public TextView emD;
    /* access modifiers changed from: private */
    public int emU;
    private long emV = 0;
    private int emW = 0;
    private ListView enE;
    /* access modifiers changed from: private */
    public C8840f enN;
    private C8800a enO = null;
    /* access modifiers changed from: private */
    public TemplatePackHeader enP;
    /* access modifiers changed from: private */
    public TemplatePackageInfo enQ;
    /* access modifiers changed from: private */
    public List<TemplatePackageInfo> enR;

    /* renamed from: com.introvd.template.template.info.TemplatePackActivity$a */
    private static class C8800a extends Handler {
        private final WeakReference<TemplatePackActivity> bwg;

        public C8800a(TemplatePackActivity templatePackActivity) {
            this.bwg = new WeakReference<>(templatePackActivity);
        }

        public void handleMessage(Message message) {
            TemplatePackActivity templatePackActivity = (TemplatePackActivity) this.bwg.get();
            if (templatePackActivity != null) {
                switch (message.what) {
                    case 4097:
                        TemplateInfo c = templatePackActivity.m25810uK(message.arg1);
                        if (c != null) {
                            String str = c.strPreviewurl;
                            if (!TextUtils.isEmpty(str)) {
                                templatePackActivity.emU = message.arg1;
                                templatePackActivity.m25786T(str, message.arg1);
                                break;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case 4098:
                        templatePackActivity.emU = message.arg1;
                        templatePackActivity.m25811uL(message.arg1);
                        break;
                    case 4099:
                        if (templatePackActivity.dqs != null) {
                            templatePackActivity.dqs.setVisibility(8);
                        }
                        C8742k.aMi().mo35178cz(templatePackActivity, templatePackActivity.dgO);
                        removeMessages(4099);
                        if (templatePackActivity.enN != null) {
                            templatePackActivity.enN.mo35353cV(C8742k.aMi().mo35183qt(templatePackActivity.dgO));
                            templatePackActivity.m25809jG(templatePackActivity.enP.aMv());
                            break;
                        }
                        break;
                    case 8193:
                        sendEmptyMessage(8198);
                        if (!TextUtils.isEmpty((String) message.obj)) {
                            templatePackActivity.m25786T((String) message.obj, message.arg2);
                            break;
                        } else {
                            ToastUtils.show((Context) templatePackActivity, R.string.xiaoying_str_template_msg_preview_failed, 0);
                            return;
                        }
                    case 8194:
                        String str2 = (String) message.obj;
                        int i = message.arg1;
                        if (!(templatePackActivity.enN == null || str2 == null)) {
                            templatePackActivity.enN.mo35351U(str2, i);
                            templatePackActivity.enN.mo35359pJ(str2);
                            templatePackActivity.m25809jG(templatePackActivity.enP.aMv());
                            break;
                        }
                    case 8195:
                        String str3 = (String) message.obj;
                        if (templatePackActivity.enN != null) {
                            templatePackActivity.enN.mo35351U(str3, 100);
                            templatePackActivity.enN.mo35359pJ(str3);
                            templatePackActivity.m25809jG(templatePackActivity.enP.aMv());
                            break;
                        }
                        break;
                    case 8196:
                        templatePackActivity.aLk();
                        break;
                    case 8198:
                        if (!templatePackActivity.isFinishing()) {
                            C4586g.m11696Sm();
                            break;
                        }
                        break;
                    case 8200:
                        ToastUtils.show((Context) templatePackActivity, R.string.xiaoying_str_template_msg_install_failed, 0);
                        break;
                    case 12289:
                        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL, (C8354a) new C8354a() {
                            /* renamed from: a */
                            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL);
                                if (i == 131072) {
                                    C8739i.m25524ho(context);
                                    C8800a.this.sendEmptyMessageDelayed(4099, 500);
                                }
                                C8800a.this.sendMessage(C8800a.this.obtainMessage(16385, Integer.valueOf(i)));
                            }
                        });
                        C8346e.m24075cq(templatePackActivity.getApplicationContext(), templatePackActivity.dgO);
                        final String a = templatePackActivity.dgO;
                        templatePackActivity.enQ = C8742k.aMi().mo35179e(templatePackActivity.enR, a);
                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("TemplatePackageUpdateTime_");
                        sb.append(a);
                        String appSettingStr = instance.getAppSettingStr(sb.toString(), "0");
                        if (templatePackActivity.enQ != null && Math.abs(C2575a.parseLong(appSettingStr) - System.currentTimeMillis()) <= 3600000) {
                            sendEmptyMessage(16386);
                            break;
                        } else {
                            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES, (C8354a) new C8354a() {
                                /* renamed from: a */
                                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES);
                                    if (i == 131072) {
                                        C8800a.this.sendEmptyMessage(16386);
                                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("TemplatePackageUpdateTime_");
                                        sb.append(a);
                                        instance.setAppSettingStr(sb.toString(), String.valueOf(System.currentTimeMillis()));
                                    }
                                }
                            });
                            C8346e.m24071T(templatePackActivity.getApplicationContext(), templatePackActivity.dgO, "");
                            break;
                        }
                        break;
                    case 16385:
                        if (templatePackActivity.dqs != null) {
                            templatePackActivity.dqs.setVisibility(8);
                            break;
                        }
                        break;
                    case 16386:
                        if (templatePackActivity.dqs != null) {
                            templatePackActivity.dqs.setVisibility(8);
                        }
                        templatePackActivity.enR = C8742k.aMi().mo35182hp(templatePackActivity);
                        templatePackActivity.enQ = C8742k.aMi().mo35179e(templatePackActivity.enR, templatePackActivity.dgO);
                        if (templatePackActivity.enQ != null) {
                            if (!TextUtils.isEmpty(templatePackActivity.enQ.strTitle)) {
                                if (templatePackActivity.emD != null) {
                                    templatePackActivity.emD.setText(templatePackActivity.enQ.strTitle);
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("name", templatePackActivity.enQ.strTitle);
                                UserBehaviorLog.onKVEvent(templatePackActivity.getApplicationContext(), "Template_Pack_Show", hashMap);
                            }
                            templatePackActivity.enP.mo35489b(templatePackActivity.enQ);
                            break;
                        }
                        break;
                    case QError.QERR_DISPLAY_ALREADY_INIT /*20481*/:
                        UserBehaviorUtils.recordXYTPackEvent(templatePackActivity.getApplicationContext(), templatePackActivity.dgO, "download all");
                        Iterator it = ((ArrayList) message.obj).iterator();
                        while (it.hasNext()) {
                            templatePackActivity.m25815w((TemplateInfo) it.next());
                        }
                        break;
                    case 36871:
                        ArrayList arrayList = (ArrayList) message.obj;
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            templatePackActivity.m25815w((TemplateInfo) arrayList.get(i2));
                        }
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m25786T(String str, int i) {
    }

    /* renamed from: a */
    private void m25791a(Context context, TemplateInfo templateInfo, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocialServiceDef.EXTRAS_REQUEST_TYPE, templateInfo.ttid);
            jSONObject.put("version", templateInfo.strVer);
            jSONObject.put("lang", templateInfo.strLang);
            jSONObject.put("social_method", str);
            jSONObject.put(SocialServiceDef.TODO_ACTION, SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            String jSONObject2 = jSONObject.toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SocialConstDef.TASK_MAIN_TYPE, Integer.valueOf(3));
            contentValues.put(SocialConstDef.TASK_SUB_TYPE, Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_SUB_STATE, Integer.valueOf(0));
            contentValues.put("state", Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_USER_DATA, jSONObject2);
            context.getContentResolver().insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK), contentValues);
            TaskService.doPendingTask(this, 0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void aKX() {
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.setUpgradeReceiveMain(this);
        }
        if (this.emV + DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS <= System.currentTimeMillis()) {
            boolean dA = C4580b.m11646dA(VivaBaseApplication.m8749FZ());
            String Si = C4580b.m11635Si();
            String countryCode = AppStateModel.getInstance().getCountryCode();
            C3727b.m9082a(dA ? 1 : 0, DeviceInfo.getSDK(), DeviceInfo.getModule(), Si, countryCode).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<AppVersionInfo>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(AppVersionInfo appVersionInfo) {
                    Intent intent = new Intent(SocialServiceDef.ACTION_APK_VERSION_UPGRADE);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_URL, appVersionInfo.apkUrl);
                    LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_msg_download, 0);
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_new_version_checking_failed, 0);
                }
            });
            this.emV = System.currentTimeMillis();
        }
    }

    private void aLf() {
        if (this.enN == null) {
            this.enN = new C8840f(this, C8734a.PACKAGE, null);
            this.enN.setHandler(this.enO);
        }
        if (this.enE == null) {
            this.enE = (ListView) findViewById(R.id.template_info_listview);
            if (this.enP == null) {
                this.enP = new TemplatePackHeader(this);
            }
            this.enP.setHandler(this.enO);
            this.enE.addHeaderView(this.enP);
            this.enE.setAdapter(this.enN);
        }
        this.enN.mo35352b(this.enE);
    }

    private void aLj() {
        if (!C4600l.m11739k(this, true)) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        if (this.dqs != null) {
            this.dqs.setVisibility(0);
        }
        this.enO.sendMessage(this.enO.obtainMessage(12289, this.emW, 0));
    }

    /* access modifiers changed from: private */
    public void aLk() {
        if (!isFinishing()) {
            C4586g.m11707a(this, false, Integer.valueOf(R.string.xiaoying_str_com_msg_download_failed), Integer.valueOf(-1), Integer.valueOf(R.string.xiaoying_str_com_cancel), Integer.valueOf(-1), Integer.valueOf(R.string.xiaoying_str_template_download_again), Integer.valueOf(R.drawable.xiaoying_com_template_download_failed), new OnClickListener() {
                public void onClick(View view) {
                    C4586g.m11697Sn();
                    if (((Integer) view.getTag()).intValue() == 1) {
                        TemplatePackActivity.this.m25812uM(TemplatePackActivity.this.emU);
                    }
                }
            });
        }
    }

    /* renamed from: bs */
    private boolean m25797bs(long j) {
        return QTemplateIDUtils.getTemplateType(j) == 1 || !QTemplateIDUtils.isThemeSubTemplate(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: jG */
    public void m25809jG(boolean z) {
        this.cub.setEnabled(!z);
        if (z) {
            this.cub.setText(R.string.xiaoying_str_template_state_downloaded2);
            this.cub.setBackgroundResource(R.drawable.v5_xiaoying_template_btn_disable_selector);
            return;
        }
        this.cub.setText(R.string.xiaoying_str_com_quick_download);
        this.cub.setBackgroundResource(R.drawable.v5_xiaoying_template_btn_yellow_selector);
    }

    /* access modifiers changed from: private */
    /* renamed from: uK */
    public TemplateInfo m25810uK(int i) {
        List aMe = C8733e.aMa().aMe();
        if (aMe == null || i >= aMe.size()) {
            return null;
        }
        return (TemplateInfo) aMe.get(i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        return;
     */
    /* renamed from: uL */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m25811uL(final int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r3.m25810uK(r4)     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int r1 = r0.nState     // Catch:{ all -> 0x00a4 }
            r2 = 8
            if (r1 == r2) goto L_0x0089
            switch(r1) {
                case 1: goto L_0x0078;
                case 2: goto L_0x004b;
                case 3: goto L_0x0047;
                case 4: goto L_0x0014;
                case 5: goto L_0x00a2;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x00a4 }
        L_0x0012:
            goto L_0x00a2
        L_0x0014:
            boolean r4 = r3.isFinishing()     // Catch:{ all -> 0x00a4 }
            if (r4 != 0) goto L_0x00a2
            com.afollestad.materialdialogs.f$a r4 = com.introvd.template.p414ui.dialog.C8978m.m26349hs(r3)     // Catch:{ all -> 0x00a4 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_info_title     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10293dl(r0)     // Catch:{ all -> 0x00a4 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_msg_update_app_for_support_template     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10296do(r0)     // Catch:{ all -> 0x00a4 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_cancel     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10303dv(r0)     // Catch:{ all -> 0x00a4 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_state_update_app     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10299dr(r0)     // Catch:{ all -> 0x00a4 }
            com.introvd.template.template.info.TemplatePackActivity$3 r0 = new com.introvd.template.template.info.TemplatePackActivity$3     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10281a(r0)     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f r4 = r4.mo10313qu()     // Catch:{ all -> 0x00a4 }
            r4.show()     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0047:
            r3.m25814uO(r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x004b:
            boolean r0 = r3.isFinishing()     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x00a2
            com.afollestad.materialdialogs.f$a r0 = com.introvd.template.p414ui.dialog.C8978m.m26349hs(r3)     // Catch:{ all -> 0x00a4 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_delete_ask     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10296do(r1)     // Catch:{ all -> 0x00a4 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_no     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10303dv(r1)     // Catch:{ all -> 0x00a4 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_yes     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10299dr(r1)     // Catch:{ all -> 0x00a4 }
            com.introvd.template.template.info.TemplatePackActivity$2 r1 = new com.introvd.template.template.info.TemplatePackActivity$2     // Catch:{ all -> 0x00a4 }
            r1.<init>(r4)     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f$a r4 = r0.mo10281a(r1)     // Catch:{ all -> 0x00a4 }
            com.afollestad.materialdialogs.f r4 = r4.mo10313qu()     // Catch:{ all -> 0x00a4 }
            r4.show()     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0078:
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r3.m25810uK(r4)     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0085
            java.lang.String r1 = r3.dgO     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.strTitle     // Catch:{ all -> 0x00a4 }
            com.introvd.template.common.behavior.UserBehaviorUtils.recordXYTPackEvent(r3, r1, r0)     // Catch:{ all -> 0x00a4 }
        L_0x0085:
            r3.m25812uM(r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0089:
            com.introvd.template.template.e.k r4 = com.introvd.template.template.p407e.C8742k.aMi()     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r4.mo35176cA(r3, r1)     // Catch:{ all -> 0x00a4 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a4 }
            if (r4 != 0) goto L_0x00a2
            com.introvd.template.template.download.e r4 = com.introvd.template.template.download.C8705e.m25369gZ(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.ttid     // Catch:{ all -> 0x00a4 }
            r4.mo35083pi(r0)     // Catch:{ all -> 0x00a4 }
        L_0x00a2:
            monitor-exit(r3)
            return
        L_0x00a4:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.TemplatePackActivity.m25811uL(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: uM */
    public boolean m25812uM(int i) {
        LogUtils.m14223i("TemplatePackActivity", "doDownload <---");
        if (!C4600l.m11739k(this, true)) {
            return false;
        }
        TemplateInfo uK = m25810uK(i);
        if (uK == null) {
            return false;
        }
        m25815w(uK);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: uN */
    public void m25813uN(int i) {
        TemplateInfo uK = m25810uK(i);
        if (uK != null) {
            String str = uK.ttid;
            if (!TextUtils.isEmpty(str)) {
                String bB = C8762d.aMt().mo35225bB(C2575a.m7391rq(str));
                if (!TextUtils.isEmpty(bB)) {
                    long templateID = C8762d.aMt().getTemplateID(bB);
                    if (templateID != -1 && m25797bs(templateID)) {
                        m25791a((Context) this, uK, SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_UNDOWN);
                        ArrayList qG = C8762d.aMt().mo35242qG(bB);
                        boolean isInChina = AppStateModel.getInstance().isInChina();
                        if (qG != null && !qG.isEmpty()) {
                            Iterator it = qG.iterator();
                            while (it.hasNext()) {
                                Long l = (Long) it.next();
                                this.bOt.mo35200a((Context) this, l.longValue(), false, isInChina);
                            }
                        }
                        this.enO.sendEmptyMessage(4099);
                    }
                }
            }
        }
    }

    /* renamed from: uO */
    private void m25814uO(int i) {
        TemplateInfo templateInfo = (TemplateInfo) C8733e.aMa().aMe().get(i);
        if (templateInfo != null) {
            C8728c.m25457a(this, templateInfo.tcid, Long.valueOf(C2575a.m7391rq(templateInfo.ttid)), "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public boolean m25815w(TemplateInfo templateInfo) {
        if (templateInfo == null) {
            return false;
        }
        new Bundle().putString("ttid", templateInfo.ttid);
        C8705e.m25369gZ(this).mo35081b(templateInfo.ttid, templateInfo.strVer, templateInfo.strUrl, templateInfo.nSize);
        C8742k.aMi().mo35174D(templateInfo);
        templateInfo.nState = 8;
        return true;
    }

    public void arB() {
    }

    public void arC() {
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.enO != null) {
            this.enO.sendMessage(this.enO.obtainMessage(8194, 100, 0, str));
        }
        if (this.enO != null) {
            this.enO.sendMessage(this.enO.obtainMessage(8195, 0, 0, str));
            this.enO.sendEmptyMessage(4099);
        }
        if (this.enP != null) {
            m25809jG(this.enP.aMv());
        }
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        if (this.enO != null) {
            this.enO.sendMessage(this.enO.obtainMessage(8194, 0, 0, str));
        }
        if (this.enN != null) {
            this.enN.mo35359pJ(str);
        }
        if (this.enP != null) {
            m25809jG(this.enP.aMv());
        }
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
        if (this.enN != null) {
            this.enN.mo35351U(str, 0);
            this.enN.mo35359pJ(str);
        }
        if (this.enP != null) {
            m25809jG(this.enP.aMv());
        }
    }

    /* renamed from: ix */
    public void mo30340ix(String str) {
    }

    /* renamed from: iy */
    public void mo30341iy(String str) {
    }

    /* renamed from: iz */
    public void mo30342iz(String str) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        LogUtils.m14223i("TemplatePackActivity", "onActivityResult");
        super.onActivityResult(i, i2, intent);
        if (i == 9098 && i2 == 1) {
            this.enO.sendMessageDelayed(this.enO.obtainMessage(4098, this.emU, 0, null), 500);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
        } else if (view.equals(this.emC)) {
            aLj();
        } else if (view.equals(this.cub)) {
            List<TemplateInfo> aMe = C8733e.aMa().aMe();
            ArrayList arrayList = new ArrayList();
            for (TemplateInfo templateInfo : aMe) {
                if (templateInfo.nState == 1) {
                    arrayList.add(templateInfo);
                }
            }
            if (arrayList.size() > 0) {
                this.enO.sendMessage(this.enO.obtainMessage(QError.QERR_DISPLAY_ALREADY_INIT, arrayList));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.m14223i("TemplatePackActivity", "onCreate");
        this.enO = new C8800a(this);
        this.dgO = getIntent().getExtras().getString(TemplateRouter.EXTRA_KEY_TEMPLATE_PACKAGE_GROUPCODE);
        this.bOt = new C8759b(4);
        setContentView(R.layout.v4_xiaoying_template_package_info_list);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
        this.emC = (Button) findViewById(R.id.try_btn);
        this.emC.setOnClickListener(this);
        this.cub = (Button) findViewById(R.id.btn_download);
        this.cub.setOnClickListener(this);
        this.emD = (TextView) findViewById(R.id.title);
        this.dqs = (LinearLayout) findViewById(R.id.loading_layout);
        C8735f.aMf().mo35156ve(0);
        aLf();
        this.enR = C8742k.aMi().mo35182hp(this);
        aLj();
        C8705e.m25369gZ(this).mo35079a((C8707b) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        if (this.enE != null) {
            this.enE.setAdapter(null);
            this.enE = null;
        }
        if (this.enN != null) {
            this.enN = null;
        }
        if (this.bOt != null) {
            this.bOt.unInit();
            this.bOt = null;
        }
        C8742k.aMi().uninit();
        QComUtils.resetInstanceMembers(this);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i("TemplatePackActivity", "onPause");
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LogUtils.m14223i("TemplatePackActivity", "onResume");
        super.onResume();
        UserBehaviorLog.onResume(this);
    }

    /* renamed from: w */
    public void mo30344w(String str, int i) {
        if (this.enO != null) {
            this.enO.sendMessage(this.enO.obtainMessage(8194, i, 0, str));
        }
    }
}
