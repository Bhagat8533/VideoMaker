package com.introvd.template.app.setting;

import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.setting.locale.C4333a;
import com.introvd.template.app.setting.locale.C4336b;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.router.setting.LocaleModel;
import com.introvd.template.router.setting.VivaSettingRouter;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import java.util.HashMap;
import java.util.List;

@C1942a(mo10417rZ = "/xysetting/LocalLocaleSet/entry")
public class SettingLocaleConfigActivity extends EventActivity implements OnClickListener {
    private static List<LocaleModel> bCL;
    private RecyclerView bCJ;
    private C4333a bCK;
    private int bCM;
    private ImageView bCN;
    private TextView bCO;
    private LocaleModel bCP;

    /* renamed from: a */
    private int m10826a(LocaleModel localeModel) {
        if (localeModel != null) {
            return bCL.indexOf(localeModel);
        }
        return 0;
    }

    /* renamed from: b */
    private static boolean m10827b(LocaleModel localeModel) {
        return SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE.equals(localeModel.value);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* renamed from: cI */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.router.setting.LocaleModel m10828cI(android.content.Context r4) {
        /*
            java.lang.String r0 = "viva_setting"
            r1 = 1
            com.introvd.template.common.prefs.UtilsPrefs r0 = com.introvd.template.common.prefs.UtilsPrefs.with(r4, r0, r1)
            java.lang.String r2 = "pref_local_choose_language_key"
            java.lang.String r0 = r0.read(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0030
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)
            int r2 = r0.length
            r3 = 2
            if (r2 != r3) goto L_0x0030
            r1 = r0[r1]
            java.lang.String r1 = r1.trim()
            r2 = 0
            r0 = r0[r2]
            java.lang.String r0 = r0.trim()
            com.introvd.template.router.setting.LocaleModel r2 = new com.introvd.template.router.setting.LocaleModel
            r2.<init>(r0, r1)
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            android.content.res.Resources r4 = r4.getResources()
            int r0 = com.introvd.template.R.string.setting_locale_change_item_system
            java.lang.String r4 = r4.getString(r0)
            if (r2 != 0) goto L_0x0045
            com.introvd.template.router.setting.LocaleModel r2 = new com.introvd.template.router.setting.LocaleModel
            java.lang.String r0 = "default"
            r2.<init>(r4, r0)
            goto L_0x004d
        L_0x0045:
            boolean r0 = m10827b(r2)
            if (r0 == 0) goto L_0x004d
            r2.name = r4
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.setting.SettingLocaleConfigActivity.m10828cI(android.content.Context):com.introvd.template.router.setting.LocaleModel");
    }

    private void cancel() {
        setResult(0);
        finish();
    }

    public void onBackPressed() {
        cancel();
    }

    public void onClick(View view) {
        if (view.equals(this.bCO)) {
            int PH = this.bCK.mo24382PH();
            if (PH != this.bCM) {
                LocaleModel localeModel = (LocaleModel) bCL.get(PH);
                UtilsPrefs.with(getApplicationContext(), VivaSettingRouter.VIVA_SETTING_PREF_FILENAME, true).write(SettingLocalLocaleParams.PREF_KEY_LOCAL_CHOOSED_LANGUAGE, localeModel.toString());
                HashMap hashMap = new HashMap();
                hashMap.put("language", localeModel.value);
                UserBehaviorLog.onKVEvent(getApplicationContext(), "Setting_Change_Language", hashMap);
                setResult(-1);
                finish();
                return;
            }
            cancel();
        } else if (view.equals(this.bCN)) {
            cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_locale_config);
        this.bCJ = (RecyclerView) findViewById(R.id.choose_language_list);
        this.bCO = (TextView) findViewById(R.id.txtview_save_btn);
        this.bCO.setVisibility(0);
        this.bCO.setOnClickListener(this);
        this.bCN = (ImageView) findViewById(R.id.choose_language_back);
        this.bCN.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.bCJ.setLayoutManager(linearLayoutManager);
        this.bCK = new C4333a(this);
        this.bCJ.setAdapter(this.bCK);
        this.bCP = m10828cI(getApplicationContext());
        if (bCL == null) {
            bCL = C4336b.m10869c(getApplicationContext(), R.array.arr_setting_local_locale_item_names, R.array.arr_setting_local_locale_item_values);
            bCL.add(0, new LocaleModel(getResources().getString(R.string.setting_locale_change_item_system), SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE));
        }
        this.bCK.mo24384af(bCL);
        this.bCM = m10826a(this.bCP);
        if (this.bCM >= 0) {
            this.bCK.mo24385hE(this.bCM);
        }
    }
}
