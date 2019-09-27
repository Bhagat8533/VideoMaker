package com.introvd.template.template.info;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.EventActivity;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.model.template.TemplateRollModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.R;
import com.introvd.template.template.info.p410a.C8831d;
import com.introvd.template.template.info.p410a.C8845g;
import com.introvd.template.template.info.p410a.C8848h;
import com.introvd.template.template.p402c.C8628a;
import com.introvd.template.template.p404d.C8645a;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8655f;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8736g;
import com.introvd.template.template.p407e.C8743l;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.utils.QComUtils;

public class TemplateMgrActivity extends EventActivity implements OnClickListener {
    private ImageView bvn;
    private List<C8653d> dLo;
    private String ekf;
    private TextView emD;
    private final String enD = "288230376151711849";
    private ListView enE;
    private C8848h enF;
    private C8845g enG;
    private List<RollInfo> enH;
    /* access modifiers changed from: private */
    public C8831d enI;
    private ArrayList<TemplateItemData> enJ = new ArrayList<>();
    /* access modifiers changed from: private */
    public RelativeLayout enK;
    private Handler mHandler = new C8795a(this);
    private String mTitle;

    /* renamed from: com.introvd.template.template.info.TemplateMgrActivity$a */
    private static class C8795a extends Handler {
        private WeakReference<TemplateMgrActivity> enM;

        public C8795a(TemplateMgrActivity templateMgrActivity) {
            this.enM = new WeakReference<>(templateMgrActivity);
        }

        public void handleMessage(Message message) {
            TemplateMgrActivity templateMgrActivity = (TemplateMgrActivity) this.enM.get();
            if (templateMgrActivity != null) {
                int i = message.what;
                if (i != 36872) {
                    switch (i) {
                        case 8193:
                            templateMgrActivity.finish();
                            templateMgrActivity.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                            break;
                        case 8194:
                            templateMgrActivity.m25782uR(message.arg1);
                            break;
                    }
                } else {
                    templateMgrActivity.m25781uQ(message.arg1);
                }
            }
        }
    }

    /* renamed from: a */
    private TemplateItemData m25773a(TemplateItemData templateItemData, TemplateInfo templateInfo) {
        if (templateInfo != null) {
            templateItemData.strIcon = templateInfo.strIcon;
            templateItemData.strTitle = templateInfo.strTitle;
            templateItemData.strIntro = templateInfo.strIntro;
            templateItemData.strSceneName = templateInfo.strSceneName;
        }
        return templateItemData;
    }

    private List<TemplateItemData> aLe() {
        if (TextUtils.isEmpty(this.ekf) || C8645a.m25200pt(this.ekf)) {
            return null;
        }
        if (this.enJ != null) {
            this.enJ.clear();
        }
        ArrayList h = C8762d.aMt().mo35240h(C2575a.parseInt(this.ekf), 327680);
        if (h != null && !h.isEmpty()) {
            for (int i = 0; i < h.size(); i++) {
                TemplateInfo be = C8735f.aMf().mo35144be(this.ekf, C8450a.m24469bn(((Long) h.get(i)).longValue()));
                if (be == null) {
                    be = C8743l.m25550ae(getApplicationContext(), this.ekf, C8450a.m24469bn(((Long) h.get(i)).longValue()));
                }
                TemplateItemData bD = C8762d.aMt().mo35227bD(((Long) h.get(i)).longValue());
                if (!bD.shouldOnlineDownload()) {
                    TemplateItemData a = m25773a(bD, be);
                    if (this.ekf.equals(C8399c.ecX)) {
                        if (C8451b.m24479up(QTemplateIDUtils.getTemplateSubType(a.lID))) {
                            this.enJ.add(a);
                        }
                    } else if (!"288230376151711849".equals(String.valueOf(a.lID))) {
                        this.enJ.add(a);
                    }
                }
            }
        }
        return this.enJ;
    }

    private void aLf() {
        if (C8735f.m25479qm(this.ekf)) {
            this.enG = new C8845g(getApplicationContext());
            this.enG.setHandler(this.mHandler);
            this.enE.setAdapter(this.enG);
            this.enH = aLh();
            this.enG.mo35361cV(this.enH);
            return;
        }
        C8735f.aMf().mo35157vf(0);
        this.enF = new C8848h(this);
        this.enF.mo35375pK(this.ekf);
        this.enF.setHandler(this.mHandler);
        this.enE.setAdapter(this.enF);
        List aLe = aLe();
        if (aLe != null) {
            this.enF.mo35369cV(aLe);
        }
    }

    private void aLg() {
        if (C8735f.m25479qm(this.ekf)) {
            this.enH = aLh();
            this.enG.mo35361cV(this.enH);
            if (this.enH == null || this.enH.size() <= 0) {
                this.enK.setVisibility(0);
            } else {
                this.enK.setVisibility(8);
            }
        } else {
            List aLe = aLe();
            this.enF.mo35369cV(aLe);
            if (aLe == null || aLe.size() <= 0) {
                this.enK.setVisibility(0);
            } else {
                this.enK.setVisibility(8);
            }
        }
    }

    private List<RollInfo> aLh() {
        ArrayList arrayList = new ArrayList();
        List<TemplateRollModel> a = C8735f.m25476a(getApplicationContext(), SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL), this.ekf, "");
        if (a != null) {
            for (TemplateRollModel templateRollModel : a) {
                if (C8745n.m25561qv(templateRollModel.rollCode)) {
                    RollInfo a2 = C8735f.m25475a(this.ekf, templateRollModel);
                    C8735f.m25477a((TemplateInfo) a2, 0, Utils.getAppVersion(getApplicationContext()), 0);
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private void aLi() {
        this.dLo = C8645a.m25195l(C8655f.aKE().aKG());
        if (this.enI == null) {
            this.enI = new C8831d(this, this.dLo, 1);
            this.enI.mo35334b((C8651b) new C8651b() {
                /* renamed from: a */
                public void mo27626a(C8653d dVar) {
                    if (TemplateMgrActivity.this.enI == null || TemplateMgrActivity.this.enI.getCount() >= 1) {
                        TemplateMgrActivity.this.enK.setVisibility(8);
                    } else {
                        TemplateMgrActivity.this.enK.setVisibility(0);
                    }
                }

                /* renamed from: aG */
                public void mo27627aG(List<C8653d> list) {
                }

                /* renamed from: cm */
                public void mo27628cm(int i, int i2) {
                }
            });
            this.enI.setHandler(this.mHandler);
        }
        this.enE.setAdapter(this.enI);
        this.enI.notifyDataSetChanged();
    }

    private void initUI() {
        if (C8645a.m25200pt(this.ekf)) {
            aLi();
        } else {
            aLf();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: uN */
    public void m25779uN(int i) {
        String str = "";
        if (C8735f.m25479qm(this.ekf)) {
            RollInfo rollInfo = (RollInfo) this.enH.remove(i);
            if (rollInfo != null) {
                C8745n.m25558cM(getApplicationContext(), rollInfo.ttid);
                str = rollInfo.ttid;
            }
            if (this.enH == null || this.enH.size() <= 0) {
                this.enK.setVisibility(0);
            } else {
                this.enK.setVisibility(8);
            }
            this.enG.mo35361cV(this.enH);
        } else {
            LogUtils.m14223i("TemplateMgrActivity", "doDelete");
            StringBuilder sb = new StringBuilder();
            sb.append("position:");
            sb.append(i);
            LogUtils.m14223i("TemplateMgrActivity", sb.toString());
            TemplateItemData uP = m25780uP(i);
            if (uP != null) {
                str = C8450a.m24469bn(uP.lID);
                C8762d.aMt().mo35242qG(uP.strPath);
                aLg();
            } else {
                return;
            }
        }
        C10021c.aZH().mo38492aA(new C8628a(this.ekf, str));
        C8522g.aJA().aJF();
    }

    /* renamed from: uP */
    private TemplateItemData m25780uP(int i) {
        List aMe = C8736g.aMg().aMe();
        if (i < 0 || i >= aMe.size()) {
            return null;
        }
        return (TemplateItemData) aMe.get(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: uQ */
    public void m25781uQ(final int i) {
        if (!isFinishing()) {
            String str = "";
            if (this.ekf.equals(C8399c.ecX)) {
                str = getResources().getString(R.string.xiaoying_str_ve_theme_title_common);
            } else if (this.ekf.equals(C8399c.ecY)) {
                str = getResources().getString(R.string.xiaoying_str_ve_effect_title);
            } else if (this.ekf.equals(C8399c.edb)) {
                str = getResources().getString(R.string.xiaoying_str_ve_subtitle_title);
            } else if (this.ekf.equals(C8399c.ede)) {
                str = getResources().getString(R.string.xiaoying_str_ve_sticker);
            } else if (this.ekf.equals(C8399c.edd)) {
                str = getResources().getString(R.string.xiaoying_str_ve_animate_frame_title);
            } else if (this.ekf.equals(C8399c.ecZ)) {
                str = getResources().getString(R.string.xiaoying_str_ve_transition_title);
            }
            C8978m.m26350ht(this).mo10315r(getResources().getString(R.string.xiaoying_str_template_delete_title, new Object[]{str})).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    TemplateMgrActivity.this.m25779uN(i);
                }
            }).mo10313qu().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: uR */
    public void m25782uR(int i) {
        if (!isFinishing()) {
            C8978m.m26349hs(this).mo10293dl(R.string.xiaoying_str_com_info_title).mo10296do(i).mo10303dv(R.string.xiaoying_str_com_ok).mo10313qu().show();
        }
    }

    public void aLd() {
        List aMe = C8733e.aMa().aMe();
        List aMe2 = C8736g.aMg().aMe();
        for (int i = 0; i < aMe2.size(); i++) {
            long j = ((TemplateItemData) aMe2.get(i)).lID;
            for (int i2 = 0; i2 < aMe.size(); i2++) {
                if (Long.valueOf(C2575a.m7391rq(((TemplateInfo) aMe.get(i2)).ttid)).equals(Long.valueOf(j))) {
                    String str = ((TemplateInfo) aMe.get(i2)).strScene;
                    String str2 = ((TemplateInfo) aMe.get(i2)).strIntro;
                    ((TemplateItemData) C8736g.aMg().aMe().get(i)).strScene = str;
                    ((TemplateItemData) C8736g.aMg().aMe().get(i)).strIntro = str2;
                }
            }
        }
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.m14223i("TemplateMgrActivity", "onCreate");
        Bundle extras = getIntent().getExtras();
        this.ekf = extras.getString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID);
        String string = extras.getString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_TITLE);
        if (!TextUtils.isEmpty(string)) {
            this.mTitle = getResources().getString(R.string.xiaoying_str_template_manage_suffix, new Object[]{string});
        }
        setContentView(R.layout.v4_xiaoying_template_mgr_list);
        this.enE = (ListView) findViewById(R.id.template_info_listview);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
        this.emD = (TextView) findViewById(R.id.title);
        this.emD.setText(this.mTitle);
        this.enK = (RelativeLayout) findViewById(R.id.layout_mt_mgr_empty_tip);
        initUI();
        aLd();
        if (!C8645a.m25200pt(this.ekf)) {
            aLg();
        } else if (C8655f.aKE().aKF()) {
            this.enK.setVisibility(8);
        } else {
            this.enK.setVisibility(0);
        }
        C8522g.aJA().aJF();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        QComUtils.resetInstanceMembers(this);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i("TemplateMgrActivity", "onPause");
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LogUtils.m14223i("TemplateMgrActivity", "onResume");
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (this.enI != null) {
            this.enI.notifyDataSetChanged();
        }
    }
}
