package com.introvd.template.editor.impl;

import android.content.Context;
import android.os.Bundle;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.C3569a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.service.C6721a;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;
import com.introvd.template.sdk.C8379a;
import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8396c;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.p393a.C8492c;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;

@C1942a(mo10417rZ = "/XYVideoEditor/EditorAppLifeCycle")
public class EditorApplicationLifeCycleImpl extends BaseApplicationLifeCycle {
    public void initServiceNotifObser(Context context) {
        C8347f.aKf().init(context);
        C8347f.aKf().mo33600a(1, (C8354a) C6721a.aqC());
        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_PASSTHROUGH_METHOD_CALLBACK, (C8354a) new C8354a() {
            /* renamed from: a */
            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                StringBuilder sb = new StringBuilder();
                sb.append("SOCIAL_PASSTHROUGH_METHOD_CALLBACK TODO:");
                sb.append(bundle);
                LogUtilsV2.m14227d(sb.toString());
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        C8346e.m24079uB(QEngine.VERSION_NUMBER);
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C8670b.init(VivaBaseApplication.m8749FZ());
            }
        });
        if (C3569a.m8773FL()) {
            C5842b.ahc();
        }
        C8410e.aGX().mo34094a(VivaBaseApplication.m8749FZ(), new C8396c() {
            public String and() {
                return CommonConfigure.APP_DATA_PATH;
            }

            public String ane() {
                return CommonConfigure.APP_PROJECT_PATH;
            }

            public String anf() {
                return CommonConfigure.APP_CACHE_PATH;
            }

            public String ang() {
                return CommonConfigure.APP_PRIVATE_ROOT_PATH;
            }

            public String anh() {
                return CommonConfigure.APP_DEFAULT_EXPORT_PATH;
            }

            public String getAudioSavePath() {
                return CommonConfigure.getAudioSavePath();
            }

            public String getMediaSavePath() {
                return CommonConfigure.getMediaSavePath();
            }

            public String getMediaStorageRelativePath() {
                return CommonConfigure.getMediaStorageRelativePath();
            }
        }, new C8379a() {
            public boolean getBoolean(String str, boolean z) {
                return AppPreferencesSetting.getInstance().getAppSettingBoolean(str, z);
            }

            public int getInt(String str, int i) {
                return AppPreferencesSetting.getInstance().getAppSettingInt(str, i);
            }

            public String getString(String str, String str2) {
                return AppPreferencesSetting.getInstance().getAppSettingStr(str, str2);
            }

            public void setBoolean(String str, boolean z) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean(str, z);
            }

            public void setInt(String str, int i) {
                AppPreferencesSetting.getInstance().setAppSettingInt(str, i);
            }

            public void setString(String str, String str2) {
                AppPreferencesSetting.getInstance().setAppSettingStr(str, str2);
            }
        }, new C8382b() {
            public String getTemplateExternalFile(long j, int i, int i2) {
                return C8762d.aMt().getTemplateExternalFile(j, i, i2);
            }

            /* renamed from: ig */
            public Long mo29495ig(String str) {
                return Long.valueOf(C8762d.aMt().getTemplateID(str));
            }

            /* renamed from: q */
            public String mo29496q(Long l) {
                return C8762d.aMt().mo35225bB(l.longValue());
            }

            /* renamed from: r */
            public Long mo29497r(Long l) {
                return Long.valueOf(C8762d.aMt().mo35233bJ(l.longValue()));
            }

            /* renamed from: s */
            public boolean mo29498s(Long l) {
                TemplateItemData bD = C8762d.aMt().mo35227bD(l.longValue());
                if (bD == null) {
                    return true;
                }
                return bD.shouldOnlineDownload();
            }
        }).mo34103ja(AppStateModel.getInstance().isCommunitySupport()).mo34104jb(C2561a.aOR() == 3 || C2561a.aOS()).mo34107ty(R.string.xiaoying_str_com_sdcard_full_tip).mo34105tw(R.string.xiaoying_str_ve_project_load_fail).mo34106tx(R.string.xiaoying_str_ve_msg_project_save_failed);
        initServiceNotifObser(VivaBaseApplication.m8749FZ());
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.registerAppConfigObserver(new C6427a());
        }
        C8567u.m25052a(new C8492c() {
            public void onError(Throwable th) {
                if (th != null) {
                    C5523b.logException(th);
                }
            }
        });
        C8567u.setDebugMode(false);
    }
}
