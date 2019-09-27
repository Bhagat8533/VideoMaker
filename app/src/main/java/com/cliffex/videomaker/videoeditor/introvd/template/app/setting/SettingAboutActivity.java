package com.introvd.template.app.setting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.SocialServiceBroadcastReceiver;
import com.introvd.template.SocialServiceBroadcastReceiver.C3555a;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.p184h.C3886a;
import com.introvd.template.app.p191k.C4028a;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MD5;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.SpannableTextView;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.origin.device.api.RegisterDeviceResult;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.VivaCommunityRouter.GdprPrivacyPageParams;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import com.p131c.p132a.C2561a;
import java.util.HashMap;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class SettingAboutActivity extends EventActivity implements OnClickListener, OnLongClickListener, C3555a {
    private ImageView aMK;
    private ImageView bAT;
    private ImageView bAU;
    private SpannableTextView bAV;
    private RelativeLayout bAW;
    private RelativeLayout bAX;
    private RelativeLayout bAY;
    private RelativeLayout bAZ;
    private RelativeLayout bBa;
    private RelativeLayout bBb;
    private RelativeLayout bBc;
    private RelativeLayout bBd;
    private RelativeLayout bBe;
    private RelativeLayout bBf;
    private int bBg = -1;
    private Button bBh;
    private RelativeLayout bBi;
    private boolean bBj;
    private int bBk = 0;
    private SocialServiceBroadcastReceiver bgh = null;

    /* renamed from: OM */
    private void m10739OM() {
        if (!AppStateModel.getInstance().isInChina()) {
            this.bAX.setVisibility(8);
            this.bAY.setVisibility(8);
        } else {
            this.bAZ.setVisibility(8);
        }
        this.bBj = AppStateModel.getInstance().isInEurope();
        if (this.bBj) {
            this.bBi.setVisibility(0);
        } else {
            this.bBi.setVisibility(8);
        }
        if (AppStateModel.getInstance().isInIndia()) {
            this.bBa.setVisibility(8);
            this.bBb.setVisibility(0);
            this.bBc.setVisibility(0);
            this.bBd.setVisibility(0);
            if (C2561a.aON()) {
                this.bBd.setVisibility(8);
            }
            this.bBf.setVisibility(0);
        } else {
            this.bBa.setVisibility(0);
            this.bBb.setVisibility(8);
            this.bBc.setVisibility(8);
            this.bBd.setVisibility(8);
            this.bBf.setVisibility(8);
        }
        if (C2561a.aON()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.faq_layout);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            this.bAZ.setVisibility(0);
            this.bBa.setVisibility(0);
        }
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("ket_prefer_show_send_logfile_layout", false)) {
            this.bBe.setVisibility(0);
        }
        if (C2561a.aOS()) {
            this.bBa.setVisibility(8);
            this.bBb.setVisibility(8);
            this.bBc.setVisibility(8);
            this.bBd.setVisibility(8);
            this.bBi.setVisibility(8);
            this.bAX.setVisibility(8);
            this.bAY.setVisibility(8);
            this.bAZ.setVisibility(8);
        }
    }

    /* renamed from: ON */
    private void m10740ON() {
        C3886a.m9564dv(C4395c.getFAQUrl());
    }

    /* renamed from: OO */
    private void m10741OO() {
        C3886a.m9564dv("https://hybrid.xiaoying.tv/web/vivaVideo/in-user-agreement.html");
    }

    /* renamed from: OP */
    private void m10742OP() {
        UserBehaviorLog.onKVEvent(this, "Setting_NewVersion", new HashMap());
        if (C2561a.aOR() == 2) {
            m10743OQ();
            return;
        }
        if (!AppStateModel.getInstance().isInChina() || C4580b.m11649dv(this) || C2561a.aON()) {
            AppTodoInterceptorImpl.lauchMarket4App(this, getApplicationContext().getPackageName());
        } else if (C4600l.m11739k(this, true)) {
            C4586g.m11703a((Context) this, R.string.xiaoying_str_com_check_new_version_dialog, (OnCancelListener) null);
            UpgradeBroadcastReceiver.m10244cA(this).mo23802z(1);
            C4322b.m10843hz(1);
        }
    }

    /* renamed from: OQ */
    private void m10743OQ() {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(getApplicationContext().getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(268435456);
        intent.setPackage("com.huawei.appmarket");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.show((Context) this, R.string.xiaoying_str_studio_msg_app_not_found, 0);
        }
    }

    /* renamed from: OR */
    private void m10744OR() {
        new C1895a(this).mo10315r(getString(R.string.xiaoying_str_community_setting_about_sina_desc)).mo10316s(getString(R.string.xiaoying_str_community_setting_about_sina_btn)).mo10300ds(getResources().getColor(R.color.color_ff5e13)).mo10288aA(false).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SettingAboutActivity.this.m10745OS();
                fVar.dismiss();
            }
        }).mo10317t(getString(R.string.xiaoying_str_com_cancel)).mo10302du(getResources().getColor(R.color.black)).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                fVar.dismiss();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: OS */
    public void m10745OS() {
        if (!SnsAuthServiceProxy.isAuthed(1)) {
            this.bBg = 1;
            if (C4600l.m11739k(this, true)) {
                SnsAuthServiceProxy.auth(this, new Builder().snsType(this.bBg));
            }
        }
    }

    /* renamed from: OT */
    private void m10746OT() {
        new C1895a(this).mo10315r(getString(R.string.xiaoying_str_community_setting_about_wechat_desc)).mo10316s(getString(R.string.xiaoying_str_community_setting_about_wechat_btn)).mo10300ds(getResources().getColor(R.color.color_ff5e13)).mo10288aA(false).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                ((ClipboardManager) SettingAboutActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("video link", "xiaoyingviva"));
                ToastUtils.show((Context) SettingAboutActivity.this, R.string.xiaoying_str_studio_copy_link_toast, 0);
                fVar.dismiss();
            }
        }).mo10317t(getString(R.string.xiaoying_str_com_cancel)).mo10302du(getResources().getColor(R.color.black)).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                fVar.dismiss();
            }
        }).mo10313qu().show();
    }

    /* renamed from: OU */
    private void m10747OU() {
        VivaRouter.getRouterBuilder(GdprPrivacyPageParams.URL).mo10391a(GdprPrivacyPageParams.INTENT_KEY_SETTING_MODE, true).mo10382H(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: dU */
    public void m10750dU(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:DPO@vivavideo.tv"));
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.xiaoying_str_europe_country_delete_data_issue));
        int i = R.string.xiaoying_str_europe_country_delete_data_desc;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("+");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("XiaoYingGDPR");
        sb.append(MD5.md5(sb2.toString()));
        intent.putExtra("android.intent.extra.TEXT", getString(i, new Object[]{sb.toString()}));
        startActivity(intent);
    }

    /* renamed from: hA */
    private void m10751hA(int i) {
        AppRouter.startWebPage(this, C4028a.m9997hi(i), getResources().getString(C4028a.m9996hh(i)));
    }

    /* renamed from: a */
    public void mo22827a(String str, int i, int i2, int i3) {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 84) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        SnsAuthServiceProxy.authorizeCallBack(this, this.bBg, i, i2, intent);
    }

    public void onClick(View view) {
        if (view.equals(this.aMK)) {
            finish();
            overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        } else if (view.equals(this.bBa)) {
            if (this.bBj) {
                m10747OU();
            } else {
                m10751hA(0);
            }
        } else if (view.equals(this.bAW)) {
            m10742OP();
        } else if (view.equals(this.bAY)) {
            m10744OR();
        } else if (view.equals(this.bAX)) {
            m10746OT();
        } else if (view.equals(this.bAZ)) {
            m10740ON();
        } else if (view.equals(this.bBf)) {
            m10741OO();
        } else if (view.equals(this.bBb)) {
            m10751hA(3);
        } else if (view.equals(this.bBc)) {
            m10751hA(4);
        } else if (view.equals(this.bBd)) {
            m10751hA(5);
        } else if (view.equals(this.bBh)) {
            if (this.bBj) {
                m10747OU();
            } else {
                m10751hA(0);
            }
        } else if (view.equals(this.bBi)) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1834l<RegisterDeviceResult>>() {
                /* renamed from: k */
                public C1834l<RegisterDeviceResult> apply(Boolean bool) {
                    String dz = C4580b.m11653dz(SettingAboutActivity.this);
                    if (TextUtils.isEmpty(dz)) {
                        return C8124b.m23525aH(C4585f.m11690dI(SettingAboutActivity.this.getApplicationContext()), C4585f.m11688dG(SettingAboutActivity.this.getApplicationContext()));
                    }
                    RegisterDeviceResult registerDeviceResult = new RegisterDeviceResult();
                    registerDeviceResult.duid = dz;
                    return C1834l.m5257ah(registerDeviceResult);
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<RegisterDeviceResult>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: a */
                public void mo9886K(RegisterDeviceResult registerDeviceResult) {
                    SettingAboutActivity.this.m10750dU(registerDeviceResult.duid);
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        } else if (this.bAT.equals(view)) {
            this.bBk++;
            if (this.bBk == 5) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("ket_prefer_show_send_logfile_layout", true);
                LogUtilsV2.Logable = true;
                this.bBe.setVisibility(0);
                LogUtilsV2.initLoggerWriterAdapter();
                ToastUtils.show(getApplicationContext(), "已开启日志记录\n崩溃操作重现后，回到这个页面，点击UPLOADLOG按钮，将日志文件发送给我们", 1);
            }
        } else if (this.bBe.equals(view)) {
            C4324c.m10850cH(getApplicationContext());
            LogUtilsV2.Logable = false;
            AppPreferencesSetting.getInstance().setAppSettingBoolean("ket_prefer_show_send_logfile_layout", false);
            this.bBe.setVisibility(8);
            ToastUtils.show(getApplicationContext(), "已关闭日志记录\n日志将不再写入文件", 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v4_setting_about);
        this.bAX = (RelativeLayout) findViewById(R.id.layout_wechat);
        this.bAY = (RelativeLayout) findViewById(R.id.layout_sinaweibo);
        this.bAZ = (RelativeLayout) findViewById(R.id.layout_faq);
        this.bBf = (RelativeLayout) findViewById(R.id.layout_user_terms);
        this.bBa = (RelativeLayout) findViewById(R.id.layout_privacy);
        this.bBi = (RelativeLayout) findViewById(R.id.setting_delete_my_info);
        this.aMK = (ImageView) findViewById(R.id.img_back);
        this.aMK.setOnClickListener(this);
        this.bAW = (RelativeLayout) findViewById(R.id.check_version_layout);
        this.bAW.setOnClickListener(this);
        this.bAW.setOnLongClickListener(this);
        this.bBi.setOnClickListener(this);
        this.bAT = (ImageView) findViewById(R.id.setting_about_logo);
        if (C2561a.aON()) {
            this.bAT.setImageResource(R.mipmap.ic_setting_about);
        }
        this.bAT.setOnClickListener(this);
        this.bAT.setOnLongClickListener(this);
        this.bAV = (SpannableTextView) findViewById(R.id.txt_version);
        this.bAU = (ImageView) findViewById(R.id.img_new_flag);
        this.bBh = (Button) findViewById(R.id.btn_setting_about_privacy_terms);
        this.bBb = (RelativeLayout) findViewById(R.id.layout_privacy2);
        this.bBc = (RelativeLayout) findViewById(R.id.layout_privacy3);
        this.bBd = (RelativeLayout) findViewById(R.id.layout_privacy4);
        this.bBe = (RelativeLayout) findViewById(R.id.layout_privacy5);
        this.bAZ.setOnClickListener(this);
        this.bBf.setOnClickListener(this);
        this.bBa.setOnClickListener(this);
        this.bAY.setOnClickListener(this);
        this.bAX.setOnClickListener(this);
        this.bBb.setOnClickListener(this);
        this.bBc.setOnClickListener(this);
        this.bBd.setOnClickListener(this);
        this.bBe.setOnClickListener(this);
        UpgradeBroadcastReceiver.m10244cA(this).mo23797M(this);
        m10739OM();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SnsAuthServiceProxy.unregisterAuthListener();
    }

    public boolean onLongClick(View view) {
        if (view.equals(this.bAT)) {
            UtilsPrefs with = UtilsPrefs.with(getApplicationContext(), EditorRouter.VIVA_EDITOR_PREF_FILENAME, true);
            boolean readBoolean = with.readBoolean(EditorRouter.VIVA_EDITOR_PREF_KEY_TRANSITION_STATIC, false);
            with.writeBoolean(EditorRouter.VIVA_EDITOR_PREF_KEY_TRANSITION_STATIC, !readBoolean);
            ToastUtils.show(getApplicationContext(), readBoolean ? "使用动态转场" : "使用静态转场", 1);
        } else if (view.equals(this.bAW)) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_engineer_mode_key", true);
            ToastUtils.show((Context) this, "debug mode Enabled", 1);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.bgh != null) {
            this.bgh.unregister();
        }
        this.bgh = null;
        overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        String dD = C4582c.m11667dD(this);
        if (!Utils.isNewVersion(AppPreferencesSetting.getInstance().getAppSettingStr("pref_apk_version", dD), dD) || C2561a.aON()) {
            this.bAU.setVisibility(4);
        } else {
            this.bAU.setVisibility(0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("V ");
        sb.append(C4582c.m11667dD(this));
        String sb2 = sb.toString();
        this.bAV.setText(getString(R.string.xiaoying_str_community_setting_about_version, new Object[]{sb2}));
        this.bgh = new SocialServiceBroadcastReceiver(getApplicationContext());
        this.bgh.register();
        this.bgh.mo22823a(this);
    }
}
