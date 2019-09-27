package com.introvd.template.template.info;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.data.C8657a;
import com.introvd.template.template.info.p410a.C8823b;
import com.introvd.template.template.info.p410a.C8823b.C8825b;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8727c;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p408f.C8749c;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@C1942a(mo10417rZ = "/Template/Font")
public class FontListActivity extends EventActivity implements OnClickListener, OnScrollListener {

    /* renamed from: FO */
    private ListView f3600FO;
    private ImageView bvn;
    /* access modifiers changed from: private */
    public C8720b cxF = null;
    private String ekf;
    private List<Integer> ekj = new ArrayList();
    private List<C8771a> ekk = new ArrayList();
    private List<Integer> ekl = new ArrayList();
    /* access modifiers changed from: private */
    public C8823b emB;
    private Button emC;
    private TextView emD;
    /* access modifiers changed from: private */
    public boolean emE = false;
    private RelativeLayout emF;
    private ImageButton emG;
    private RelativeLayout emH;
    private boolean emI = false;
    private C8772b emJ;
    private String emK = "cn";
    private boolean emL = true;
    private final C8727c emM = new C8727c() {
        public boolean adC() {
            C4586g.m11695Sl();
            return false;
        }

        public boolean adD() {
            if (FontListActivity.this.cxF != null) {
                List aLW = FontListActivity.this.cxF.aLW();
                if (aLW != null && aLW.size() > 0) {
                    FontListActivity.this.emB.mo35316cS(aLW);
                    FontListActivity.this.emE = true;
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_activity_have_entered", true);
                }
            }
            C4586g.m11695Sl();
            return false;
        }

        public boolean adE() {
            return false;
        }
    };
    private final C8825b emN = new C8825b() {
        /* renamed from: py */
        public void mo35269py(String str) {
            FontListActivity.this.m25677px(str);
        }

        /* renamed from: r */
        public void mo35270r(TemplateInfo templateInfo) {
            if (C8657a.m25213ct(FontListActivity.this, templateInfo.ttid)) {
                List hb = FontListActivity.this.cxF.mo35108hb(FontListActivity.this);
                FontListActivity.this.emB.mo35316cS(hb);
                FontListActivity.this.m25672d(true, hb);
                FontListActivity.this.emB.notifyDataSetChanged();
            }
        }
    };
    private long emO = 0;

    /* renamed from: com.introvd.template.template.info.FontListActivity$a */
    class C8771a {
        int pos;
        String title;
        String ttid;

        public C8771a(int i, String str, String str2) {
            this.pos = i;
            this.title = str;
            this.ttid = str2;
        }
    }

    /* renamed from: com.introvd.template.template.info.FontListActivity$b */
    class C8772b extends BroadcastReceiver {
        C8772b() {
        }

        public void onReceive(Context context, Intent intent) {
            FontListActivity.this.emB.notifyDataSetInvalidated();
        }
    }

    private void aKL() {
    }

    private void aKM() {
        if (this.emB == null || !this.emB.aLv()) {
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            return;
        }
        this.emG.setVisibility(0);
        m25672d(false, null);
        this.emB.mo35316cS(null);
        this.emB.notifyDataSetChanged();
        this.emD.setText(R.string.xiaoying_str_ve_font_title);
        m25674jE(false);
    }

    private String aKN() {
        Locale locale = getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if ("zh".equals(language)) {
            language = locale.toString();
        }
        String str = (String) C8749c.ety.get(language);
        if (TextUtils.isEmpty(str)) {
            str = AppStateModel.ZONE_EAST_AMERICAN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("lanStr=");
        sb.append(str);
        sb.append(";lanKey=");
        sb.append(language);
        Log.e("yqg", sb.toString());
        return str;
    }

    private void aKO() {
        boolean z;
        if (this.emB != null) {
            List aLw = this.emB.aLw();
            this.ekj.clear();
            this.ekk.clear();
            int firstVisiblePosition = this.f3600FO.getFirstVisiblePosition();
            int lastVisiblePosition = this.f3600FO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition - firstVisiblePosition; i++) {
                int i2 = i + firstVisiblePosition;
                if (m25673g(this.f3600FO.getChildAt(i), this.f3600FO)) {
                    this.ekj.add(Integer.valueOf(i2));
                    z = true;
                } else {
                    z = false;
                }
                if (!this.ekl.contains(Integer.valueOf(i2)) && z && aLw.size() > i2 && i2 >= 0) {
                    TemplateInfo templateInfo = (TemplateInfo) aLw.get(i2);
                    if (templateInfo != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Material_font_");
                        sb.append(templateInfo.strTitle);
                        String sb2 = sb.toString();
                        if (System.currentTimeMillis() - C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr(sb2, "0")) >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                            AppPreferencesSetting.getInstance().setAppSettingStr(sb2, String.valueOf(System.currentTimeMillis()));
                            this.ekk.add(new C8771a(i2, templateInfo.strTitle, templateInfo.ttid));
                        }
                    }
                }
            }
            this.ekl.clear();
            this.ekl.addAll(this.ekj);
            for (C8771a aVar : this.ekk) {
                UserBehaviorUtils.recordTemplateExposureRate(this, "Materials_Font_Show", aVar.title, aVar.pos, aVar.ttid);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25672d(boolean z, List list) {
        String str = "";
        if (z) {
            if (this.emD != null) {
                String string = getString(R.string.xiaoying_str_ve_font_title);
                if (!TextUtils.isEmpty(string)) {
                    str = getResources().getString(R.string.xiaoying_str_template_manage_suffix, new Object[]{string});
                }
                this.emD.setText(str);
            }
            if (list == null || list.size() <= 0) {
                this.emH.setVisibility(0);
            } else {
                this.emH.setVisibility(8);
            }
        } else {
            if (this.emD != null) {
                this.emD.setText(getString(R.string.xiaoying_str_ve_font_title));
            }
            this.emH.setVisibility(8);
        }
        this.emB.mo35321jH(z);
    }

    /* renamed from: g */
    private boolean m25673g(View view, View view2) {
        boolean z = false;
        if (view == null || view2 == null) {
            return false;
        }
        int top = view.getTop();
        int bottom = view.getBottom();
        if (top >= 0 && bottom <= view2.getHeight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: jE */
    private void m25674jE(boolean z) {
        if (this.emE || C4600l.m11739k(this, true)) {
            this.emF.setVisibility(4);
            this.emK = aKN();
            this.emO = System.currentTimeMillis();
            C4586g.m11703a((Context) this, R.string.xiaoying_str_ve_video_import_progressing, (OnCancelListener) null);
            if (z) {
                this.cxF.aLV();
            } else {
                List aLW = this.cxF.aLW();
                if (this.emB != null) {
                    this.emB.mo35316cS(aLW);
                }
                C4586g.m11695Sl();
            }
            return;
        }
        if (C8735f.aMf().mo35152ql(this.ekf) == 0) {
            this.emF.setVisibility(0);
        } else {
            this.emF.setVisibility(4);
        }
    }

    /* renamed from: pv */
    private void m25675pv(String str) {
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
        this.emG = (ImageButton) findViewById(R.id.right_mgr);
        this.emG.setOnClickListener(this);
        this.emC = (Button) findViewById(R.id.try_btn);
        this.emC.setOnClickListener(this);
        this.emD = (TextView) findViewById(R.id.title);
        this.emD.setText(str);
        this.emF = (RelativeLayout) findViewById(R.id.setting_template_layout_error);
        this.emH = (RelativeLayout) findViewById(R.id.layout_empty_fonts_list);
    }

    /* renamed from: pw */
    private void m25676pw(String str) {
        this.emB = new C8823b(this, this.cxF);
        this.emB.mo35313a(this.emN);
        this.f3600FO = (ListView) findViewById(R.id.template_info_listview);
        this.f3600FO.setAdapter(this.emB);
        this.f3600FO.setOnScrollListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: px */
    public void m25677px(String str) {
        if (this.emI) {
            Intent intent = new Intent();
            intent.putExtra("template_path", str);
            setResult(-1, intent);
            finish();
            return;
        }
        C8728c.m25457a(this, this.ekf, Long.valueOf(0), str);
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            aKM();
        } else if (view.equals(this.emC)) {
            m25674jE(true);
        } else if (view.equals(this.emG)) {
            this.emG.setVisibility(4);
            this.emD.setText(R.string.xiaoying_str_ve_font_manage_title);
            List hb = this.cxF.mo35108hb(this);
            if (this.emB != null) {
                m25672d(true, hb);
                this.emB.mo35316cS(hb);
                this.emB.notifyDataSetChanged();
            }
            this.emF.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.m14223i("FontListActivity", "onCreate");
        Bundle extras = getIntent().getExtras();
        this.ekf = extras.getString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID);
        setContentView(R.layout.v4_xiaoying_ve_subtitle_fontlist_layout);
        this.emE = AppPreferencesSetting.getInstance().getAppSettingBoolean("key_activity_have_entered", false);
        if (C8735f.aMf().mo35143aq(this, this.ekf)) {
            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("key_last_template_info_refresh_time_");
            sb.append(this.ekf);
            instance.setAppSettingStr(sb.toString(), "");
        }
        C8735f.aMf().mo35149m(this, this.ekf, true);
        m25675pv(getString(R.string.xiaoying_str_ve_font_title));
        getCallingActivity();
        this.emI = extras.getBoolean(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, false);
        aKL();
        C8735f.aMf().mo35148l(this, this.ekf, 1);
        this.cxF = new C8720b(getApplicationContext());
        m25676pw(this.ekf);
        this.emJ = new C8772b();
        registerReceiver(this.emJ, new IntentFilter("android.intent.action.FONT_DOWNLOAD_SUCCESS_ACTION"));
        this.cxF.mo35102a(this.emM);
        m25674jE(true);
        mo22812FU();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.emJ);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        aKM();
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.emL) {
            aKO();
            this.emL = false;
        }
        if (i == 0) {
            aKO();
        }
    }
}
