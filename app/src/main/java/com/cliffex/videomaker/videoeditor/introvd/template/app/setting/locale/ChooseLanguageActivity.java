package com.introvd.template.app.setting.locale;

import android.content.Context;
import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV7;
import com.introvd.template.router.setting.LocaleModel;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocaleParams;
import com.introvd.template.xyui.RoundedTextView;
import java.util.List;

@C1942a(mo10417rZ = "/xysetting/IndiaCntLocaleSet/entry")
public class ChooseLanguageActivity extends EventActivity implements OnClickListener {
    private static List<LocaleModel> bCL;
    private RecyclerView bCJ;
    private RoundedTextView bDe;
    private boolean bDf = false;
    private C4333a bDg;
    private ImageView byK;

    /* renamed from: PG */
    private void m10861PG() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr(SettingLocaleParams.PREF_KEY_INDIA_CNT_CHOOSED_LANGUAGE, null);
        if (!TextUtils.isEmpty(appSettingStr)) {
            this.bDg.mo24385hE(bCL.indexOf(new LocaleModel("", appSettingStr)));
        }
        if (this.bDf) {
            ((TextView) findViewById(R.id.choose_language_tip)).setVisibility(4);
        } else {
            this.byK.setVisibility(8);
        }
    }

    /* renamed from: W */
    public static String m10862W(Context context, String str) {
        if (bCL == null) {
            bCL = C4336b.m10869c(context, R.array.arr_setting_india_locale_item_names, R.array.arr_setting_india_locale_item_values);
        }
        if (bCL == null) {
            return null;
        }
        return ((LocaleModel) bCL.get(bCL.indexOf(new LocaleModel("", str)))).name;
    }

    public void onBackPressed() {
        if (this.bDf) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view.equals(this.byK)) {
            finish();
        } else if (view.equals(this.bDe)) {
            int PH = this.bDg.mo24382PH();
            if (PH < 0) {
                ToastUtils.show((Context) this, R.string.xiaoying_community_choose_language_check_hint, 0);
                return;
            }
            LocaleModel localeModel = (LocaleModel) bCL.get(PH);
            String str = localeModel.value;
            String str2 = "";
            if (str.equals(SettingLocaleParams.DEFAULT_INDIA_LOCALE_VALUE)) {
                str2 = "印地语";
            } else if (str.equals("Telugu")) {
                str2 = "泰卢固语";
            } else if (str.equals("Tamil")) {
                str2 = "泰米尔语";
            } else if (str.equals("Bengali")) {
                str2 = "孟加拉语";
            } else if (str.equals("English")) {
                str2 = "英语";
            } else if (str.equals("Marathi")) {
                str2 = "马拉地语";
            }
            AppPreferencesSetting.getInstance().setAppSettingStr(SettingLocaleParams.PREF_KEY_INDIA_CNT_CHOOSED_LANGUAGE, str);
            UserBehaviorUtilsV7.onEventClickLanguageChoose(this, str2);
            if (!this.bDf) {
                String str3 = localeModel.name;
                ToastUtils.show((Context) this, getString(R.string.xiaoying_str_select_india_language_tips, new Object[]{str3}), 0);
            }
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.community_activity_choose_language);
        this.bDf = getIntent().getBooleanExtra(SettingLocaleParams.BUNDLE_DATA_KEY_MODE, false);
        this.byK = (ImageView) findViewById(R.id.choose_language_back);
        this.bDe = (RoundedTextView) findViewById(R.id.choose_language_ok);
        this.bCJ = (RecyclerView) findViewById(R.id.choose_language_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.bCJ.setLayoutManager(linearLayoutManager);
        this.bDg = new C4333a(this);
        this.bCJ.setAdapter(this.bDg);
        if (bCL == null) {
            bCL = C4336b.m10869c(getApplicationContext(), R.array.arr_setting_india_locale_item_names, R.array.arr_setting_india_locale_item_values);
        }
        this.bDg.mo24384af(bCL);
        this.byK.setOnClickListener(this);
        this.bDe.setOnClickListener(this);
        m10861PG();
        UserBehaviorUtilsV7.onEventPageviewLanguageChoose(this);
    }
}
