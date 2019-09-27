package com.introvd.template.app.community.freeze;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.introvd.template.C4681i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.IUserService;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LastLoginModel;
import com.introvd.template.router.user.model.LoginUserInfo;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.community.freeze.b */
public class C3763b {
    private static volatile C3763b bkl;
    /* access modifiers changed from: private */
    public boolean bkm = true;
    /* access modifiers changed from: private */
    public C3761a bkn;

    /* renamed from: Is */
    public static C3763b m9231Is() {
        if (bkl == null) {
            synchronized (C3763b.class) {
                if (bkl == null) {
                    bkl = new C3763b();
                }
            }
        }
        return bkl;
    }

    /* renamed from: It */
    public static String m9232It() {
        return AppPreferencesSetting.getInstance().getAppSettingStr("sp_key_freeze_reason", "");
    }

    /* renamed from: bX */
    private void m9235bX(Context context) {
        C4681i.m12184Gp().mo25018Gt();
        long currentTimeMillis = System.currentTimeMillis();
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            LastLoginModel lastLoginUserModel = ((IUserService) BizServiceManager.getService(IUserService.class)).getLastLoginUserModel();
            lastLoginUserModel.avatarUrl = userInfo.avatarUrl;
            lastLoginUserModel.name = userInfo.nickname;
            if (userInfo.snsInfo != null) {
                lastLoginUserModel.snsType = userInfo.snsInfo.snsType;
            }
            lastLoginUserModel.time = currentTimeMillis;
            lastLoginUserModel.isChina = AppStateModel.getInstance().isInChina();
            ((IUserService) BizServiceManager.getService(IUserService.class)).saveLoginState(lastLoginUserModel);
        }
        IUserService iUserService = (IUserService) C4681i.m12184Gp().getService(IUserService.class);
        if (iUserService != null) {
            iUserService.logout(context, currentTimeMillis);
        }
        IMRouter.exitService();
    }

    public static int getFreezeCode() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("sp_key_app_freeze_code", -1);
    }

    /* renamed from: e */
    public void mo23237e(Context context, String str, int i) {
        if (203 == i) {
            C8124b.getFreezeReason(C4580b.m11653dz(context)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(JsonObject jsonObject) {
                    C3763b.this.bkm = true;
                    if (jsonObject != null) {
                        try {
                            String asString = jsonObject.get("reason").getAsString();
                            String asString2 = jsonObject.get("deviceNowState") != null ? jsonObject.get("deviceNowState").getAsString() : null;
                            if (!TextUtils.isEmpty(asString)) {
                                AppPreferencesSetting.getInstance().setAppSettingStr("sp_key_freeze_reason", asString);
                            }
                            if (!TextUtils.isEmpty(asString2) && "1".equals(asString2)) {
                                AppPreferencesSetting.getInstance().setAppSettingInt("sp_key_app_freeze_code", -1);
                            }
                        } catch (JsonParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public void onError(Throwable th) {
                    C3763b.this.bkm = true;
                }
            });
            return;
        }
        IAccountAPI iAccountAPI = (IAccountAPI) BizServiceManager.getService(IAccountAPI.class);
        if (iAccountAPI != null && !TextUtils.isEmpty(str)) {
            iAccountAPI.getFreezeReason(str).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(JsonObject jsonObject) {
                    if (jsonObject != null) {
                        String asString = jsonObject.get("reason").getAsString();
                        if (!TextUtils.isEmpty(asString)) {
                            AppPreferencesSetting.getInstance().setAppSettingStr("sp_key_freeze_reason", asString);
                        }
                    }
                }

                public void onError(Throwable th) {
                    C3763b.this.bkm = true;
                }
            });
        }
    }

    /* renamed from: f */
    public void mo23238f(Context context, String str, int i) {
        AppPreferencesSetting.getInstance().setAppSettingInt("sp_key_app_freeze_code", i);
        if (context != null) {
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                if (this.bkm) {
                    this.bkm = false;
                    mo23237e(context, str, i);
                }
                if (this.bkn == null) {
                    this.bkn = new C3761a(context, str);
                    this.bkn.setOnDismissListener(new OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            C3763b.this.bkn = null;
                        }
                    });
                    this.bkn.show();
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        this.bkn.setUserId(str);
                    }
                    if (!this.bkn.isShowing()) {
                        this.bkn.show();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    m9235bX(context);
                    if (i == 105) {
                        AppPreferencesSetting.getInstance().setAppSettingInt("sp_key_app_freeze_code", -1);
                    }
                }
            }
        }
    }
}
