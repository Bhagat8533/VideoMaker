package com.introvd.template.app.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1899e;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.C4677g;
import com.introvd.template.C4681i;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.SocialServiceBroadcastReceiver;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.activity.ExtraHelpActivity;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p177b.C3748e;
import com.introvd.template.app.p184h.C3886a;
import com.introvd.template.app.p192l.C4031a;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver;
import com.introvd.template.app.setting.feedback.FeedbackTypeChooseDialog;
import com.introvd.template.app.setting.feedback.FeedbackTypeChooseDialog.C4332a;
import com.introvd.template.app.setting.locale.ChooseLanguageActivity;
import com.introvd.template.app.setting.sns.SettingBindInternationalSnsActivity;
import com.introvd.template.app.setting.sns.SettingBindSNSActivity;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.app.youngermode.p202b.C4556a;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FeedbackRefreshEvent;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.consent.gdpr.C5521b;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.p341b.p343b.C7734b;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p324m.C7563a;
import com.introvd.template.p414ui.dialog.C8974l;
import com.introvd.template.p414ui.dialog.C8974l.C8975a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.IMRouter.IMSettingActivityParams;
import com.introvd.template.router.LoginRouter;
import com.introvd.template.router.LoginRouter.OnLoginListener;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.community.VivaCommunityRouter.BlackListActivityParams;
import com.introvd.template.router.community.svip.CommSvipRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocaleParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.IUserService;
import com.introvd.template.router.user.LoginListenerWrapper;
import com.introvd.template.router.user.LoginListenerWrapper.OnLogoutCallbackListener;
import com.introvd.template.router.user.UserRouter;
import com.introvd.template.router.user.UserRouter.BroadCastConstant;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LastLoginModel;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.xyui.BadgeHelper;
import com.ironsource.sdk.precache.DownloadManager;
import com.p131c.p132a.C2561a;
import com.xiaoying.p448a.C9537b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpHeaders;
import xiaoying.engine.clip.QEffect;

@C1942a(mo10417rZ = "/xysetting/SettingActivityV6/entry")
public class SettingActivityV6 extends EventActivity implements OnClickListener {
    private static final String[] bBw = {"01", "03", "08", "09"};
    private BroadcastReceiver akb;
    private int bBk = 0;
    /* access modifiers changed from: private */
    public C4312a bBm = null;
    private long bBn;
    private CharSequence[] bBo = new CharSequence[1];
    private CharSequence[] bBp = new CharSequence[2];
    private CharSequence[] bBq = new CharSequence[1];
    private CharSequence[] bBr = new CharSequence[2];
    private ProgressDialog bBs;
    private volatile boolean bBt = false;
    private boolean bBu;
    private boolean bBv = false;
    /* access modifiers changed from: private */
    public C4328d bBx = new C4328d();
    private SocialServiceBroadcastReceiver bgh = null;
    /* access modifiers changed from: private */
    public BadgeHelper bou;
    private boolean isVip = false;
    private long uniqueRequestId;

    /* renamed from: com.introvd.template.app.setting.SettingActivityV6$a */
    private static class C4312a extends Handler {
        final WeakReference<SettingActivityV6> bwg;

        public C4312a(SettingActivityV6 settingActivityV6) {
            this.bwg = new WeakReference<>(settingActivityV6);
        }

        public void handleMessage(Message message) {
            SettingActivityV6 settingActivityV6 = (SettingActivityV6) this.bwg.get();
            if (settingActivityV6 != null) {
                int i = message.what;
                if (i == 4100) {
                    String string = settingActivityV6.getResources().getString(R.string.xiaoying_str_studio_share_title);
                    String string2 = ((Boolean) message.obj).booleanValue() ? settingActivityV6.getResources().getString(R.string.xiaoying_str_com_task_state_success) : settingActivityV6.getResources().getString(R.string.xiaoying_str_com_task_state_fail);
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(string2);
                    ToastUtils.show((Context) settingActivityV6, sb.toString(), 1);
                } else if (i != 4112) {
                    switch (i) {
                        case 4097:
                            settingActivityV6.m10789Pu();
                            break;
                        case 4098:
                            if (message.obj != null && ((Boolean) message.obj).booleanValue()) {
                                ToastUtils.show((Context) settingActivityV6, R.string.xiaoying_str_community_unregister, 1);
                            }
                            settingActivityV6.m10763OX();
                            settingActivityV6.finish();
                            break;
                    }
                } else {
                    boolean z = false;
                    ToastUtils.show((Context) settingActivityV6, settingActivityV6.getString(R.string.xiaoying_str_community_set_privacy_too_fast), 0);
                    if ((message.obj instanceof Boolean) && ((Boolean) message.obj).booleanValue()) {
                        z = true;
                    }
                    settingActivityV6.bBx.bCu.setChecked(z);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m10757G(long j) {
        C8049f.aBf().mo33103kA("alipay").mo10197h(j, TimeUnit.SECONDS, C1487a.aUa()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                SettingActivityV6.this.bBx.bCb.setVisibility(bool.booleanValue() ? 0 : 8);
            }

            public void onError(Throwable th) {
                SettingActivityV6.this.bBx.bCb.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: HA */
    public void m10758HA() {
        for (WeakReference weakReference : C3740b.m9101He().mo23112Hh()) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                if (activity instanceof XiaoYingActivity) {
                    ((XiaoYingActivity) activity).mo22834Go();
                } else {
                    activity.finish();
                }
            }
        }
    }

    /* renamed from: Kl */
    private void m10759Kl() {
        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
        if (iCommunityAPI != null) {
            this.bBx.bCt.setChecked(iCommunityAPI.isHideLocation());
        }
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        this.bBx.bCv.setChecked(iEditorService != null ? iEditorService.userWaterMarkShowNickName() : false);
        this.bBx.bCw.setChecked(AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        this.bBx.bCm.setText(m10782Pm());
        this.bBx.bCn.setText(SettingLocaleConfigActivity.m10828cI(getApplicationContext()).name);
        if (!C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId())) {
            this.bBx.bCq.setText(getString(R.string.xiaoying_str_setting_nickname_watermark_isshow_save_to_gallery));
        }
        if (!AppStateModel.getInstance().isInChina() || !C2561a.aOO()) {
            this.bBx.bBO.setVisibility(8);
            this.bBx.bBL.setVisibility(0);
        } else {
            this.bBx.bBL.setVisibility(0);
            this.bBx.bBO.setVisibility(0);
        }
        if (AppStateModel.getInstance().isInEurope()) {
            this.bBx.bCC.setVisibility(0);
            if (C5521b.aaL()) {
                this.bBx.bCo.setText(getResources().getString(R.string.xiaoying_str_remove_data_collection_permission));
                this.bBx.bCp.setVisibility(0);
            } else {
                this.bBx.bCo.setText(getResources().getString(R.string.xiaoying_str_allow_data_collection));
                this.bBx.bCp.setVisibility(8);
            }
        } else {
            this.bBx.bCC.setVisibility(8);
        }
        if (this.bBx.bCg.getVisibility() == 0 && AppStateModel.getInstance().isInChina() && C2561a.aOO()) {
            this.bBx.bCg.setText(getResources().getString(R.string.xiaoying_setting_template_course_feedback_text));
        } else if (C4395c.m11096dc(getApplicationContext())) {
            this.bBx.bCg.setText(getResources().getString(R.string.xiaoying_str_viva_feedback_abroad_text));
        } else {
            this.bBx.bCg.setText(getResources().getString(R.string.xiaoying_str_com_pref_setting_feed_back));
        }
    }

    /* renamed from: Kn */
    private void m10760Kn() {
        this.bBx.bCg.post(new Runnable() {
            public void run() {
                if (SettingActivityV6.this.bou == null) {
                    SettingActivityV6.this.bou = new BadgeHelper(SettingActivityV6.this).mo36037vM(0).aNQ().mo36031jP(true).mo36036v(C4583d.m11671P(8.0f), 0, 0, 0).mo36030jO(false);
                    SettingActivityV6.this.bou.mo36029do(SettingActivityV6.this.bBx.bCg);
                }
                SettingActivityV6.this.bou.setBadgeEnable(C5349b.m14582ek(SettingActivityV6.this.getApplicationContext()));
            }
        });
    }

    /* renamed from: OV */
    private void m10761OV() {
        if (!AppStateModel.getInstance().isInChina()) {
            m10803bO(false);
            return;
        }
        FeedbackTypeChooseDialog feedbackTypeChooseDialog = new FeedbackTypeChooseDialog();
        feedbackTypeChooseDialog.mo24377a((C4332a) new C4332a() {
            /* renamed from: hk */
            public void mo24344hk(int i) {
                HashMap hashMap = new HashMap();
                if (i == 0) {
                    hashMap.put("which", "在线客服");
                    SettingActivityV6.this.m10803bO(false);
                } else if (i == 1) {
                    hashMap.put("which", "电话客服");
                    try {
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setData(Uri.parse("tel:4000581869"));
                        SettingActivityV6.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                UserBehaviorLog.onKVEvent(SettingActivityV6.this.getApplicationContext(), "Service_System_Popup_Click", hashMap);
            }
        });
        feedbackTypeChooseDialog.show(getSupportFragmentManager(), "feedbackDialog");
    }

    /* renamed from: OW */
    private void m10762OW() {
        try {
            if (this.bBs == null || !this.bBs.isShowing()) {
                this.bBs = new ProgressDialog(this, R.style.MyAlertDialogStyle);
                this.bBs.requestWindowFeature(1);
                this.bBs.show();
                this.bBs.setContentView(R.layout.xiaoying_com_simple_dialogue_content);
                this.bBs.setCanceledOnTouchOutside(false);
                this.bBs.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: OX */
    public void m10763OX() {
        try {
            if (this.bBs != null && this.bBs.isShowing()) {
                this.bBs.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: OY */
    private void m10764OY() {
        C1890f qu = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_cancel), getString(R.string.xiaoying_permission_allow)).mo10296do(R.string.xiaoying_str_allow_data_collection_tip).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                C5521b.aaN();
                ToastUtils.shortShow(SettingActivityV6.this.getApplicationContext(), R.string.xiaoying_str_allow_data_collection_permission_succ);
                SettingActivityV6.this.bBm.postDelayed(new Runnable() {
                    public void run() {
                        SettingActivityV6.this.m10758HA();
                    }
                }, 300);
            }
        }).mo10313qu();
        if (!isFinishing()) {
            qu.show();
        }
    }

    /* renamed from: OZ */
    private void m10765OZ() {
        C1890f qu = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_cancel), getString(R.string.xiaoying_str_com_delete_title)).mo10296do(R.string.xiaoying_str_msg_delete_usage_data).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SettingActivityV6.this.m10770Pa();
            }
        }).mo10313qu();
        if (!isFinishing()) {
            qu.show();
        }
    }

    /* renamed from: Oj */
    private void m10766Oj() {
        this.bBx.mo24376bS(getWindow().getDecorView().findViewById(16908290));
        this.bBx.mo24375b(this);
        if (!C5349b.enable()) {
            this.bBx.bBL.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: PA */
    public void m10767PA() {
        this.bBv = !TextUtils.isEmpty(UserServiceProxy.getUserId());
        this.isVip = C8072q.aBx().isVip();
        C7897a.aDf();
        C8049f.aBf().restoreGoodsAndPurchaseInfo();
    }

    /* renamed from: PB */
    private void m10768PB() {
        final int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras > 0) {
            new C1895a(this).mo10288aA(false).mo10287a((CharSequence[]) numberOfCameras >= 2 ? new String[]{getString(R.string.xiaoying_str_cam_adjust_front_camera), getString(R.string.xiaoying_str_cam_adjust_back_camera)} : new String[]{getString(R.string.xiaoying_str_cam_adjust_back_camera)}).mo10280a((C1899e) new C1899e() {
                /* renamed from: a */
                public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(CameraRouter.KEY_CAMERA_INTENT, Integer.valueOf(4102));
                    if (numberOfCameras >= 2) {
                        if (i == 0) {
                            hashMap.put(CameraRouter.KEY_CAMERA_ADJUST_MODE, Integer.valueOf(1));
                            C7563a.m22316a(SettingActivityV6.this, hashMap);
                        } else if (1 == i) {
                            hashMap.put(CameraRouter.KEY_CAMERA_ADJUST_MODE, Integer.valueOf(0));
                            C7563a.m22316a(SettingActivityV6.this, hashMap);
                        }
                    } else if (i == 0) {
                        hashMap.put(CameraRouter.KEY_CAMERA_ADJUST_MODE, Integer.valueOf(0));
                        C7563a.m22316a(SettingActivityV6.this, hashMap);
                    }
                }
            }).mo10313qu().show();
        }
    }

    /* renamed from: PC */
    private void m10769PC() {
        C8974l lVar = new C8974l(0, (CharSequence[]) this.bBx.bBU.getTag());
        final C1890f qu = new C1895a(this).mo10278a((C1008a<?>) lVar, (LayoutManager) new LinearLayoutManager(this)).mo10313qu();
        lVar.mo35621a((C8975a) new C8975a() {
            /* renamed from: a */
            public void mo24341a(View view, int i, CharSequence charSequence) {
                qu.dismiss();
                SettingActivityV6.this.m10811hD(i);
            }
        });
        qu.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: Pa */
    public void m10770Pa() {
        C1890f qu = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_cancel), getString(R.string.xiaoying_str_com_delete_ask_again)).mo10296do(R.string.xiaoying_str_msg_delete_usage_data_tip).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                C8124b.aFa().mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).aTR();
                SettingActivityV6.this.bBm.postDelayed(new Runnable() {
                    public void run() {
                        SettingActivityV6.this.m10758HA();
                    }
                }, 300);
            }
        }).mo10313qu();
        if (!isFinishing()) {
            qu.show();
        }
    }

    /* renamed from: Pb */
    private void m10771Pb() {
        C1890f qu = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_cancel), getString(R.string.xiaoying_str_publish_export_hw_enable_continue_op)).mo10296do(R.string.xiaoying_str_msg_remove_data_collection_permission).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SettingActivityV6.this.m10772Pc();
            }
        }).mo10313qu();
        if (!isFinishing()) {
            qu.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Pc */
    public void m10772Pc() {
        C1890f qu = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_cancel), getString(R.string.xiaoying_str_publish_export_hw_enable_continue_op)).mo10296do(R.string.xiaoying_str_remove_data_collection_permission_tip).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                C5521b.m14958dG(false);
                C5521b.aaM();
                ToastUtils.shortShow(SettingActivityV6.this.getApplicationContext(), R.string.xiaoying_str_remove_data_collection_permission_succ);
                SettingActivityV6.this.bBm.postDelayed(new Runnable() {
                    public void run() {
                        SettingActivityV6.this.m10758HA();
                    }
                }, 300);
            }
        }).mo10313qu();
        if (!isFinishing()) {
            qu.show();
        }
    }

    /* renamed from: Pd */
    private void m10773Pd() {
        if (this.bBk == 5) {
            C9537b.setParameter("debug", Boolean.valueOf(true));
            ToastUtils.show((Context) this, "Log Enabled", 1);
            startActivity(new Intent(this, ExtraHelpActivity.class));
            return;
        }
        Intent intent = new Intent(this, SettingAboutActivity.class);
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0));
        startActivity(intent);
        overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
    }

    /* renamed from: Pe */
    private void m10774Pe() {
        boolean z = !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        HashMap hashMap = new HashMap();
        hashMap.put("type", z ? "hw" : "sw");
        UserBehaviorLog.onKVEvent(this, "Setting_Hardware", hashMap);
        if (!z) {
            this.bBx.bCw.setChecked(z);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_encode", false);
        } else if (!ApiHelper.JELLY_BEAN_AND_HIGHER) {
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_hw_enable_fail_msg, 0);
            this.bBx.bCw.setChecked(false);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_encode", false);
        } else {
            this.bBx.bCw.setChecked(z);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_encode", true);
        }
    }

    /* renamed from: Pf */
    private void m10775Pf() {
        boolean isYoungerMode = C4560d.m11516RN().isYoungerMode();
        C4556a.m11505ac(this, isYoungerMode ? "on" : "off");
        this.bBx.bCx.setChecked(isYoungerMode);
        AppRouter.startYoungerModeSetting(this, isYoungerMode ? 5 : 1);
    }

    /* renamed from: Pg */
    private void m10776Pg() {
        boolean z;
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            z = !iEditorService.userWaterMarkShowNickName();
            iEditorService.setUserWaterMarkShowNickName(z);
        } else {
            z = false;
        }
        this.bBx.bCv.setChecked(z);
    }

    /* renamed from: Ph */
    private void m10777Ph() {
        if (UserServiceProxy.isLogin() && UserServiceProxy.getUserInfo() != null) {
            final boolean z = !(UserServiceProxy.getUserInfo().privacyFlag == 1);
            this.bBx.bCu.setChecked(z);
            IAccountAPI iAccountAPI = (IAccountAPI) C1919a.m5529sc().mo10356i(IAccountAPI.class);
            if (iAccountAPI != null) {
                iAccountAPI.changePrivacy().mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<Boolean>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        if (bool.booleanValue()) {
                            UserBehaviorUtilsV5.onEventPrivateAccountSwitch(VivaBaseApplication.m8749FZ(), String.valueOf(z ? 1 : 0));
                            SettingActivityV6.this.mo24334hB(z ? 1 : 0);
                            return;
                        }
                        SettingActivityV6.this.bBm.sendMessage(SettingActivityV6.this.bBm.obtainMessage(QEffect.PROP_AUDIO_FRAME_RANGE, Boolean.valueOf(!z)));
                    }

                    public void onError(Throwable th) {
                        th.printStackTrace();
                    }
                });
                this.bBn = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: Pi */
    private void m10778Pi() {
        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
        if (iCommunityAPI != null) {
            boolean z = !iCommunityAPI.isHideLocation();
            iCommunityAPI.enableHideLocation(z);
            this.bBx.bCt.setChecked(z);
        }
    }

    /* renamed from: Pj */
    private void m10779Pj() {
        if (!UserServiceProxy.isLogin()) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_community_account_register, 1);
            LoginRouter.startSettingBindAccountActivity(this);
            UserBehaviorUtils.recordUserLoginPosition(getApplicationContext(), "setting");
            return;
        }
        Intent intent = new Intent(this, SettingBindSNSActivity.class);
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0));
        startActivity(intent);
        overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
    }

    /* renamed from: Pk */
    private void m10780Pk() {
        if (!UserServiceProxy.isLogin()) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_community_account_register, 1);
            LoginRouter.startSettingBindAccountActivity(this);
            UserBehaviorUtils.recordUserLoginPosition(getApplicationContext(), "setting");
            return;
        }
        Intent intent = new Intent(this, SettingNotificationActivity.class);
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0));
        startActivity(intent);
        overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
    }

    /* renamed from: Pl */
    private void m10781Pl() {
        m10760Kn();
        String Pm = m10782Pm();
        if (!TextUtils.isEmpty(Pm)) {
            this.bBx.bCm.setText(Pm);
        }
        this.bBx.bCx.setChecked(C4560d.m11516RN().isYoungerMode());
    }

    /* renamed from: Pm */
    private String m10782Pm() {
        return ChooseLanguageActivity.m10862W(getApplicationContext(), AppPreferencesSetting.getInstance().getAppSettingStr(SettingLocaleParams.PREF_KEY_INDIA_CNT_CHOOSED_LANGUAGE, SettingLocaleParams.DEFAULT_INDIA_LOCALE_VALUE));
    }

    /* renamed from: Pn */
    private void m10783Pn() {
        if (Camera.getNumberOfCameras() <= 0) {
            this.bBx.bBW.setVisibility(8);
        }
    }

    /* renamed from: Po */
    private void m10784Po() {
        if (!mo24333Pt()) {
            this.bBx.bCd.setVisibility(8);
        }
    }

    /* renamed from: Pp */
    private void m10785Pp() {
        if (!UpgradeBroadcastReceiver.m10245cB(this) || !C2561a.aON()) {
            this.bBx.bCl.setVisibility(8);
        } else {
            this.bBx.bCl.setVisibility(0);
        }
    }

    /* renamed from: Pq */
    private void m10786Pq() {
        if (AppStateModel.getInstance().isInIndia()) {
            this.bBx.bCA.setVisibility(0);
        }
    }

    /* renamed from: Pr */
    private void m10787Pr() {
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            this.bBx.bCz.setVisibility(8);
            this.bBx.bBR.setVisibility(8);
            this.bBx.bBQ.setVisibility(8);
            this.bBx.bCh.setVisibility(8);
            this.bBx.bCy.setVisibility(8);
            if (C4580b.m11647dB(getApplicationContext())) {
                this.bBx.bBY.setVisibility(8);
                this.bBx.bBZ.setVisibility(8);
                this.bBx.bCa.setVisibility(8);
                this.bBx.bCc.setVisibility(8);
            }
            if (C2561a.aOS()) {
                this.bBx.bBX.setVisibility(8);
                this.bBx.bCc.setVisibility(8);
                this.bBx.bBK.setVisibility(8);
                this.bBx.bCf.setVisibility(8);
                this.bBx.bCk.setVisibility(8);
                this.bBx.bCi.setVisibility(8);
                this.bBx.bCj.setVisibility(8);
                this.bBx.bBY.setVisibility(8);
            }
        } else {
            if (!UserServiceProxy.isLogin()) {
                this.bBx.bCz.setVisibility(8);
                if (!AppStateModel.getInstance().isInChina() || !C3742b.m9111II().mo23151JS()) {
                    this.bBx.bCy.setVisibility(8);
                } else {
                    C4556a.m11509ds(this);
                    this.bBx.bBG.setVisibility(8);
                    if (C3742b.m9111II().mo23151JS()) {
                        this.bBx.bBP.setVisibility(0);
                        this.bBx.bCy.setVisibility(0);
                    } else {
                        this.bBx.bBP.setVisibility(8);
                    }
                    this.bBx.bBI.setVisibility(8);
                    this.bBx.bCr.setVisibility(8);
                    this.bBx.bBS.setVisibility(8);
                    this.bBx.bBT.setVisibility(8);
                    this.bBx.bBH.setVisibility(8);
                }
            } else {
                this.bBx.bCy.setVisibility(0);
                this.bBx.bCz.setVisibility(0);
                if (AppStateModel.getInstance().isHotVideoEnable()) {
                    this.bBx.bBG.setVisibility(8);
                }
            }
            if (AppStateModel.getInstance().isInChina() || C2561a.aOS()) {
                this.bBx.bBX.setVisibility(8);
                this.bBx.bBK.setVisibility(8);
                this.bBx.bCf.setVisibility(8);
                this.bBx.bCk.setVisibility(8);
                this.bBx.bCi.setVisibility(8);
                this.bBx.bCj.setVisibility(8);
                if (C3742b.m9111II().mo23151JS()) {
                    this.bBx.bBP.setVisibility(0);
                    C4556a.m11509ds(this);
                } else {
                    this.bBx.bBP.setVisibility(8);
                }
            } else {
                this.bBx.bBR.setVisibility(8);
                this.bBx.bBP.setVisibility(8);
            }
        }
        if (TextUtils.equals(AppStateModel.COUNTRY_CODE_Thailand, AppStateModel.getInstance().getCountryCode())) {
            this.bBx.bCj.setVisibility(0);
            this.bBx.bCk.setVisibility(8);
        }
        if (C2561a.aON() && AppStateModel.getInstance().isInChina()) {
            this.bBx.bBX.setVisibility(8);
        }
        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
        if (iCommunityAPI == null) {
            return;
        }
        if (iCommunityAPI.getShowPurseEntrance()) {
            this.bBx.bCs.setVisibility(0);
        } else {
            this.bBx.bCs.setVisibility(8);
        }
    }

    /* renamed from: Ps */
    private void m10788Ps() {
        String str;
        this.bBo[0] = getResources().getString(R.string.xiaoying_str_com_internal_storage);
        this.bBp[0] = this.bBo[0];
        char c = 1;
        this.bBp[1] = getResources().getString(R.string.xiaoying_str_com_external_storage);
        this.bBq[0] = String.valueOf(0);
        this.bBr[0] = this.bBq[0];
        this.bBr[1] = String.valueOf(1);
        if (VERSION.SDK_INT < 19) {
            StorageInfo.clear();
            StorageInfo.setApplicationContext(getApplicationContext());
            str = StorageInfo.getExtStorage();
        } else {
            str = null;
        }
        String mediaSavePath = CommonConfigure.getMediaSavePath();
        if (TextUtils.isEmpty(str) || !CommonConfigure.getMediaStoragePath(str).equals(mediaSavePath)) {
            c = 0;
        }
        if (TextUtils.isEmpty(str)) {
            this.bBx.bBU.setText(this.bBo[0]);
            this.bBx.bBU.setTag(this.bBo);
        } else {
            this.bBx.bBU.setText(this.bBp[c]);
            this.bBx.bBU.setTag(this.bBp);
        }
        this.bBx.bBV.setText(CommonConfigure.APP_DEFAULT_EXPORT_PATH);
    }

    /* access modifiers changed from: private */
    /* renamed from: Pu */
    public void m10789Pu() {
        this.uniqueRequestId = System.currentTimeMillis();
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            LastLoginModel lastLoginUserModel = ((IUserService) BizServiceManager.getService(IUserService.class)).getLastLoginUserModel();
            lastLoginUserModel.avatarUrl = userInfo.avatarUrl;
            lastLoginUserModel.name = userInfo.nickname;
            if (userInfo.snsInfo != null) {
                lastLoginUserModel.snsType = userInfo.snsInfo.snsType;
            }
            lastLoginUserModel.time = this.uniqueRequestId;
            lastLoginUserModel.isChina = AppStateModel.getInstance().isInChina();
            ((IUserService) BizServiceManager.getService(IUserService.class)).saveLoginState(lastLoginUserModel);
        }
        IUserService iUserService = (IUserService) C4681i.m12184Gp().getService(IUserService.class);
        if (iUserService != null) {
            iUserService.logout(this, this.uniqueRequestId);
        }
        IMRouter.exitService();
    }

    /* renamed from: Pv */
    private void m10790Pv() {
        this.akb = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent != null ? intent.getStringExtra("url") : null;
                if (!TextUtils.isEmpty(stringExtra)) {
                    C3886a.m9564dv(stringExtra);
                }
            }
        };
    }

    /* renamed from: Pw */
    private void m10791Pw() {
        LocalBroadcastManager.getInstance(this).registerReceiver(this.akb, new IntentFilter("com.introvd.template.SHOW_URL"));
    }

    /* renamed from: Px */
    private void m10792Px() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.akb);
    }

    /* renamed from: Py */
    private void m10793Py() {
        HashMap hashMap = new HashMap();
        hashMap.put("lang", C4395c.m11098de(getApplicationContext()));
        UserBehaviorLog.onKVEvent(getApplicationContext(), "smart_customer_service", hashMap);
    }

    /* renamed from: Pz */
    private void m10794Pz() {
        if (!C4600l.m11739k(this, true)) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        if (C8048e.aBe().isInChina()) {
            if (!UserServiceProxy.isLogin()) {
                LoginRouter.startSettingBindAccountActivity(1002, (OnLoginListener) new OnLoginListener() {
                    public void onLoginCancel() {
                    }

                    public void onLoginFail() {
                    }

                    public void onLoginSuccess() {
                        SettingActivityV6.this.m10767PA();
                    }
                });
            }
            m10767PA();
        } else {
            C1895a hs = C8978m.m26349hs(this);
            hs.mo10296do(R.string.xiaoying_str_iap_restore_desc_android);
            if (C2561a.aOR() == 2) {
                hs.mo10296do(R.string.xiaoying_str_iap_restore_desc_android_huawei);
            } else {
                hs.mo10296do(R.string.xiaoying_str_iap_restore_desc_android);
            }
            hs.mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_iap_restore).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    SettingActivityV6.this.m10767PA();
                }
            }).mo10313qu().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10796a(Intent intent, long j) {
        if (intent == null || this.uniqueRequestId != j) {
            this.bBm.sendEmptyMessageDelayed(4098, 1000);
            return;
        }
        this.bBm.sendMessageDelayed(this.bBm.obtainMessage(4098, Boolean.valueOf(BroadCastConstant.ACTION_LOGOUT_SUCCESS.equals(intent.getAction()))), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* access modifiers changed from: private */
    /* renamed from: bO */
    public void m10803bO(boolean z) {
        if (C4395c.m11095db(getApplicationContext())) {
            m10793Py();
        }
        if (!z || !AppStateModel.getInstance().isInChina() || !C2561a.aOO()) {
            C4395c.m11088a(this, -1);
        } else {
            C4395c.m11093b(this, 3, null);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doAppFollowUs(android.app.Activity r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0030 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0030 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0030 }
            if (r4 != 0) goto L_0x0014
            r0.setPackage(r3)     // Catch:{ Exception -> 0x0030 }
        L_0x0014:
            android.content.Context r3 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0030 }
            boolean r3 = isIntentAvailable(r3, r0)     // Catch:{ Exception -> 0x0030 }
            if (r3 == 0) goto L_0x0022
            r2.startActivity(r0)     // Catch:{ Exception -> 0x0022 }
            return
        L_0x0022:
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0030 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0030 }
            java.lang.String r5 = "android.intent.action.VIEW"
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x0030 }
            r2.startActivity(r4)     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.setting.SettingActivityV6.doAppFollowUs(android.app.Activity, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void doInstagramClick(Activity activity, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://instagram.com/_u/");
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("http://instagram.com/");
        sb3.append(str);
        doAppFollowUs(activity, "com.instagram.android", sb2, sb3.toString());
    }

    /* renamed from: hC */
    private void m10810hC(int i) {
        HashMap hashMap = new HashMap();
        switch (i) {
            case 5:
                hashMap.put("setting_sns_click", "facebook");
                doAppFollowUs(this, "", "fb://page/485094498277364", "http://www.facebook.com/vivavideoapp");
                break;
            case 6:
                hashMap.put("setting_sns_click", "instagram");
                String str = "vivavideoapp";
                if (AppStateModel.getInstance().isInIndia()) {
                    str = "vivavideoindia2018";
                } else if (AppStateModel.getInstance().isMiddleEast()) {
                    str = "vivavideo_arab";
                }
                doInstagramClick(this, str);
                break;
            case 7:
                hashMap.put("setting_sns_click", "twitter");
                doAppFollowUs(this, "", "twitter://user?user_id=2264568804", "https://twitter.com/vivavideoapp");
                break;
            case 8:
                hashMap.put("setting_sns_click", "Line");
                doAppFollowUs(this, "", "", "http://line.me/ti/p/%40eww1814d");
                break;
        }
        UserBehaviorLog.onKVEvent(this, "Setting_SNS_Follow", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: hD */
    public void m10811hD(int i) {
        String mainStorage = StorageInfo.getMainStorage();
        String extStorage = StorageInfo.getExtStorage();
        if (extStorage == null || !FileUtils.isDirectoryExisted(extStorage)) {
            i = 0;
        }
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_media_storage", String.valueOf(i));
        HashMap hashMap = new HashMap();
        if (i == 0) {
            CommonConfigure.setMediaStoragePath(mainStorage, true);
            CommonConfigure.setExportStoragePath(mainStorage);
            hashMap.put("where", "phone");
        } else {
            CommonConfigure.setMediaStoragePath(extStorage, true);
            CommonConfigure.setExportStoragePath(extStorage);
            hashMap.put("where", "sdcard");
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_project_ignore_prompt", "0");
        }
        FileUtils.createMultilevelDirectory(CommonConfigure.getAudioSavePath());
        C4677g.m12179cT(CommonConfigure.getAudioSavePath());
        FileUtils.createMultilevelDirectory(CommonConfigure.getMediaSavePath());
        C4677g.m12179cT(CommonConfigure.getMediaSavePath());
        this.bBx.bBU.setText(this.bBp[i]);
        this.bBx.bBV.setText(CommonConfigure.APP_DEFAULT_EXPORT_PATH);
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: Pt */
    public boolean mo24333Pt() {
        boolean z = false;
        if (!AppStateModel.getInstance().isInChina()) {
            return false;
        }
        String dx = C4580b.m11651dx(getApplicationContext());
        if (dx == null) {
            return true;
        }
        String[] strArr = bBw;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else if (dx.endsWith(strArr[i])) {
                break;
            } else {
                i++;
            }
        }
        return z;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 84) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: hB */
    public void mo24334hB(int i) {
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            userInfo.privacyFlag = i;
            UserServiceProxy.saveLoginUserInfo(userInfo);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("com.introvd.template.restart"));
            finish();
        }
    }

    public void onClick(View view) {
        if (view.equals(this.bBx.bCE)) {
            this.bBk++;
        } else if (!C4580b.m11632Sf()) {
            if (view.equals(this.bBx.bCD)) {
                finish();
                overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
            } else if (view.equals(this.bBx.bBQ)) {
                m10780Pk();
            } else if (view.equals(this.bBx.bBR)) {
                m10779Pj();
            } else if (view.equals(this.bBx.bBG)) {
                m10778Pi();
            } else if (view.equals(this.bBx.bBS)) {
                VivaRouter.getRouterBuilder(IMSettingActivityParams.URL).mo10394aZ(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left).mo10382H(this);
            } else if (view.equals(this.bBx.bBT)) {
                VivaRouter.getRouterBuilder(BlackListActivityParams.URL).mo10394aZ(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left).mo10382H(this);
            } else if (view.equals(this.bBx.bBH)) {
                if (System.currentTimeMillis() - this.bBn < 300000) {
                    ToastUtils.show((Context) this, getString(R.string.xiaoying_str_community_set_privacy_too_fast), 0);
                    return;
                }
                m10777Ph();
            } else if (view.equals(this.bBx.bBP)) {
                m10775Pf();
            } else if (view.equals(this.bBx.bBM)) {
                m10769PC();
            } else if (view.equals(this.bBx.bBI)) {
                m10776Pg();
            } else if (view.equals(this.bBx.bBJ)) {
                m10774Pe();
            } else if (view.equals(this.bBx.bBW)) {
                m10768PB();
            } else if (view.equals(this.bBx.bBX)) {
                Intent intent = new Intent(this, SettingBindInternationalSnsActivity.class);
                intent.putExtra(CommonParams.INTENT_MAGIC_CODE, getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0));
                startActivity(intent);
                overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
            } else if (view.equals(this.bBx.bBN)) {
                m10773Pd();
            } else if (view.equals(this.bBx.bBY)) {
                if (AppStateModel.getInstance().isInIndia()) {
                    C4681i.m12184Gp().mo25016Gr().showRatingBarDialog(this);
                } else {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(getApplicationContext().getPackageName());
                    intent2.setData(Uri.parse(sb.toString()));
                    intent2.addFlags(268435456);
                    if (C2561a.aOR() == 2) {
                        intent2.setPackage("com.huawei.appmarket");
                    }
                    try {
                        startActivity(intent2);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtils.show((Context) this, R.string.xiaoying_str_studio_msg_app_not_found, 0);
                    }
                }
            } else if (view.equals(this.bBx.bBZ)) {
                C8049f.aBf().mo33097b(this, "platinum", null, "setting", -1);
            } else if (view.equals(this.bBx.bCa)) {
                m10794Pz();
                HashMap hashMap = new HashMap();
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, DownloadManager.SETTINGS);
                UserBehaviorLog.onKVEvent(this, "IAP_Restore_Click", hashMap);
            } else if (view.equals(this.bBx.bCb)) {
                new C1895a(this).mo10293dl(R.string.xiaoying_str_iap_unsign_dialog_title).mo10296do(R.string.xiaoying_str_iap_unsign_dialog_desc).mo10303dv(R.string.xiaoying_str_iap_unsign_dialog_negative).mo10291b(new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C7834a.m22837lp("Not now");
                    }
                }).mo10299dr(R.string.xiaoying_str_iap_unsign_dialog_positive).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C7834a.m22837lp("Confirm");
                        C8049f.aBf().aBp().mo10188a((C1850u<? super T>) new C1810c<String>() {
                            /* renamed from: dV */
                            public void onSuccess(String str) {
                                if ("alipay".equals(str)) {
                                    SettingActivityV6.this.m10757G(2);
                                } else {
                                    SettingActivityV6.this.bBx.bCb.setVisibility(8);
                                }
                            }

                            public void onError(Throwable th) {
                                SettingActivityV6.this.bBx.bCb.setVisibility(8);
                            }
                        });
                    }
                }).mo10314qv();
            } else if (view.equals(this.bBx.bCc)) {
                AppRouter.startWebPage(this, AppTodoInterceptorImpl.formatVivaUrl(VivaBaseApplication.m8749FZ(), "https://hybrid.xiaoying.tv/web/vivaVideo/TermsPrivacy.html"), "");
            } else if (view.equals(this.bBx.bBL)) {
                m10803bO(true);
            } else if (view.equals(this.bBx.bBO)) {
                m10761OV();
            } else if (view.equals(this.bBx.bCd)) {
                if (!C4600l.m11739k(this, true)) {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                    return;
                }
                C4031a.m10003N(this);
            } else if (view.equals(this.bBx.bCe)) {
                m10762OW();
                C4681i.m12184Gp().mo25018Gt();
                if (this.bBm != null) {
                    this.bBm.sendEmptyMessageDelayed(4097, 500);
                }
            } else if (view.equals(this.bBx.bCf)) {
                m10810hC(6);
            } else if (view.equals(this.bBx.bCi)) {
                m10810hC(5);
            } else if (view.equals(this.bBx.bCk)) {
                m10810hC(7);
            } else if (view.equals(this.bBx.bCj)) {
                m10810hC(8);
            } else if (view.equals(this.bBx.bCA)) {
                VivaRouter.getRouterBuilder(SettingLocaleParams.LOCALE_4CNT_INDIA_SETTING_URL).mo10391a(SettingLocaleParams.BUNDLE_DATA_KEY_MODE, true).mo10382H(this);
            } else if (view.equals(this.bBx.bCB)) {
                VivaRouter.getRouterBuilder(SettingLocalLocaleParams.LOCALE_LOCAL_SETTING_URL).mo10396b((Activity) this, 1000);
            } else if (view.equals(this.bBx.bCo)) {
                if (C5521b.aaL()) {
                    m10771Pb();
                } else {
                    m10764OY();
                }
            } else if (view.equals(this.bBx.bCp)) {
                m10765OZ();
            } else if (view.equals(this.bBx.bCr)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(HttpHeaders.FROM, "我的tab");
                UserBehaviorLog.onKVEvent(this, "Pageview_PhonePage", hashMap2);
                if (C3742b.m9111II().mo23178Jy()) {
                    UserRouter.launchAccountBindSettingActivity(this);
                    UserBehaviorLog.onKVEvent(this, "Click_Set_BoundTab", new HashMap());
                } else {
                    UserRouter.launchPhoneVerifyActivity(this, 2, 2, -1, -1);
                }
            } else if (view.equals(this.bBx.bCh)) {
                Intent intent3 = new Intent();
                intent3.setClass(this, SettingNetWorkActivity.class);
                startActivity(intent3);
                UserBehaviorLog.onKVEvent(this, "Click_Set_NetworkSet", new HashMap());
            } else if (view.equals(this.bBx.bCs)) {
                if (UserServiceProxy.isLogin()) {
                    CommSvipRouter.launchUserWalletActivity(this);
                } else {
                    LoginRouter.startSettingBindAccountActivity(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(!C2561a.aON() ? R.layout.xyappv5_activity_setting : R.layout.xyappv5_activity_setting_pro);
        m10766Oj();
        m10757G(0);
        m10759Kl();
        m10790Pv();
        m10791Pw();
        this.bBm = new C4312a(this);
        UpgradeBroadcastReceiver.m10244cA(this).mo23797M(this);
        this.bBt = getIntent().getBooleanExtra(SettingPrams.BUNDLE_DATA_KEY_GO_FEEDBACK, false);
        m10788Ps();
        if (this.bBt) {
            m10803bO(false);
        }
        if (UserServiceProxy.isLogin() && UserServiceProxy.getUserInfo() != null) {
            boolean z = true;
            if (UserServiceProxy.getUserInfo().privacyFlag != 1) {
                z = false;
            }
            this.bBu = z;
            this.bBx.bCu.setChecked(this.bBu);
            if (AppStateModel.getInstance().isCommunitySupport() && AppStateModel.getInstance().isInChina()) {
                if (C3742b.m9111II().mo23178Jy()) {
                    this.bBx.bCr.setVisibility(0);
                } else {
                    C1834l checkUserBindPhone = UserServiceProxy.checkUserBindPhone(false);
                    if (checkUserBindPhone != null) {
                        checkUserBindPhone.mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                            /* renamed from: a */
                            public void mo9877a(C1495b bVar) {
                            }

                            /* renamed from: b */
                            public void mo9886K(Boolean bool) {
                                if (bool != null && !bool.booleanValue()) {
                                    SettingActivityV6.this.bBx.bCr.setText(R.string.xiaoying_str_bind_phone_num);
                                    SettingActivityV6.this.bBx.bCr.setVisibility(0);
                                }
                            }

                            public void onComplete() {
                            }

                            public void onError(Throwable th) {
                            }
                        });
                    }
                }
            }
        }
        LoginListenerWrapper.with(this).setOnLogoutSuccessListener(new OnLogoutCallbackListener() {
            public void onLogoutSuccess(Intent intent, long j) {
                SettingActivityV6.this.m10796a(intent, j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.bBm != null) {
            this.bBm.removeCallbacksAndMessages(null);
        }
        LoginRouter.releaseResource(1002);
        m10792Px();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(FeedbackRefreshEvent feedbackRefreshEvent) {
        m10760Kn();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onGoogleConnection(C7734b bVar) {
        if (bVar != null) {
            if (bVar.isConnecting()) {
                C8048e.aBe().mo23642b(this, false);
            } else {
                C8048e.aBe().mo23623Mo();
                if (!bVar.isSuccess() && !C8049f.aBf().mo33077EO()) {
                    C8049f.aBf().mo33094aF(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C10021c.aZH().mo38496az(this);
        if (this.bgh != null) {
            this.bgh.unregister();
        }
        if (this.bBs != null) {
            this.bBs.dismiss();
            this.bBs = null;
        }
        if (isFinishing()) {
            HashMap hashMap = new HashMap();
            hashMap.put("Status", C3748e.m9193JX().mo23195Kb() ? "打开" : "关闭");
            UserBehaviorLog.onAliEvent("Status_Set_AutoPlay", hashMap);
        }
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseReload(C7735c cVar) {
        if (cVar != null) {
            int responseCode = cVar.getResponseCode();
            C8049f.aBf().mo33099e(this, responseCode, "setting");
            C7835b.m22844a("setting", this.isVip, responseCode);
            if (this.bBv) {
                C7835b.m22852b("setting", this.isVip, responseCode);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C10021c.aZH().mo38494ax(this);
        UserBehaviorLog.onResume(this);
        this.bgh = new SocialServiceBroadcastReceiver(getApplicationContext());
        this.bgh.register();
        m10787Pr();
        m10785Pp();
        if (AppStateModel.getInstance().isInChina()) {
            m10784Po();
        }
        m10783Pn();
        m10781Pl();
        m10786Pq();
    }
}
