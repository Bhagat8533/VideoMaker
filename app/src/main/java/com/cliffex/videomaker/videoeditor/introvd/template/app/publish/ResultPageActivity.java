package com.introvd.template.app.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.bumptech.glide.load.p118b.C2375i;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.base.utlisads.CrashAll;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.creation.C3821d;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4426a;
import com.introvd.template.app.p199v5.common.p200ui.videolist.CreationListView;
import com.introvd.template.app.p199v5.common.p200ui.videolist.CreationListView.C4423a;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.SnsConfigMgr;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.imageloader.ImageLoader.SourceType;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p207c.C4612a;
import com.introvd.template.p414ui.dialog.C8957e;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.AppRouter.ExportResultPageParams;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.editor.EditorRouter.ToolPublishParams;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sns.OnIconClickListener;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.starvlogs.NativeAdmob;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.introvd.template.starvlogs.rate.RateDialog;
import com.p131c.p132a.C2570b;
import com.quvideo.sns.base.p228b.C4979b.C4981a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/ExportResultPage")
public class ResultPageActivity extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: OC */
    public View f3387OC = null;
    /* access modifiers changed from: private */
    public boolean aGM = false;
    private C3821d bot;
    private TextView bvk;
    /* access modifiers changed from: private */
    public ImageView bvl;
    private ImageView bvm;
    private ImageView bvn;
    /* access modifiers changed from: private */
    public ImageView bvo;
    private View bvp;
    private View bvq;
    private CreationListView bvr;
    private List<ModeItemInfo> bvs;
    private C4426a bvt;
    /* access modifiers changed from: private */
    public String bvu = null;
    private String bvv = null;
    private boolean bvw = true;
    private boolean bvx;
    private C4091a bvy = new C4091a(this);
    protected OnIconClickListener bvz = new OnIconClickListener() {
        public void onIconClick(final SnsResItem snsResItem) {
            if (C4596h.m11725Sy() || !(snsResItem.mSnsType == 28 || snsResItem.mSnsType == 26)) {
                ResultPageActivity.this.mo23764a(snsResItem);
            } else {
                C8978m.m26349hs(ResultPageActivity.this).mo10315r(ResultPageActivity.this.getString(R.string.xiaoying_str_com_share_dialog_facebook_content)).mo10303dv(R.string.xiaoying_str_com_got_it).mo10273a(R.string.xiaoying_str_com_user_tip_not_show, false, (OnCheckedChangeListener) null).mo10305dx(R.color.color_ff5e13).mo10291b(new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        if (fVar.mo10262qp()) {
                            C4596h.m11726Sz();
                        }
                        ResultPageActivity.this.mo23764a(snsResItem);
                    }
                }).mo10313qu().show();
            }
            if (snsResItem != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(SocialConstDef.TBL_NAME_SNS, snsResItem.strDes);
                UserBehaviorLog.onKVEvent(ResultPageActivity.this, "Share_Export_Done_Share", hashMap);
            }
        }
    };

    /* renamed from: com.introvd.template.app.publish.ResultPageActivity$a */
    private static class C4091a extends WeakHandler<ResultPageActivity> {
        public C4091a(ResultPageActivity resultPageActivity) {
            super(resultPageActivity);
        }

        public void handleMessage(Message message) {
            ResultPageActivity resultPageActivity = (ResultPageActivity) getOwner();
            if (resultPageActivity != null && message.what == 1002 && !resultPageActivity.isFinishing() && !resultPageActivity.aGM) {
                C2570b.m7337i(resultPageActivity).mo12195aO(resultPageActivity.bvu).aPc().mo12874wp(R.color.color_e1e1e1).mo12868d(C2375i.aDh).mo12186g(resultPageActivity.bvl);
            }
        }
    }

    /* renamed from: Nj */
    private void m10145Nj() {
        if (this.bvw) {
            VivaRouter.getRouterBuilder(ToolPublishParams.URL).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(this);
        } else {
            setResult(0);
        }
        finish();
    }

    /* renamed from: Nl */
    private void m10146Nl() {
        C1848s.m5326ai(Boolean.valueOf(AppStateModel.getInstance().isInChina())).mo10196g(C1487a.aUa()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, List<Integer>>() {
            /* renamed from: i */
            public List<Integer> apply(Boolean bool) throws Exception {
                List<Integer> loadSnsConfigInfos = SnsConfigMgr.loadSnsConfigInfos(ResultPageActivity.this.getApplicationContext(), AppStateModel.getInstance().getCountryCode());
                if (loadSnsConfigInfos == null) {
                    loadSnsConfigInfos = new ArrayList<>();
                    if (bool.booleanValue()) {
                        loadSnsConfigInfos.add(Integer.valueOf(7));
                        loadSnsConfigInfos.add(Integer.valueOf(11));
                        loadSnsConfigInfos.add(Integer.valueOf(1));
                    } else {
                        loadSnsConfigInfos.add(Integer.valueOf(28));
                        loadSnsConfigInfos.add(Integer.valueOf(31));
                        loadSnsConfigInfos.add(Integer.valueOf(32));
                        loadSnsConfigInfos.add(Integer.valueOf(33));
                        loadSnsConfigInfos.add(Integer.valueOf(26));
                        loadSnsConfigInfos.add(Integer.valueOf(29));
                        loadSnsConfigInfos.add(Integer.valueOf(7));
                        loadSnsConfigInfos.add(Integer.valueOf(4));
                    }
                }
                return loadSnsConfigInfos;
            }
        }).mo10199i(new C1518f<List<Integer>, List<SnsResItem>>() {
            public List<SnsResItem> apply(List<Integer> list) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    SnsResItem appSnsResItemBySnstype = SnsShareTypeUtil.getAppSnsResItemBySnstype(((Integer) list.get(i)).intValue());
                    if (appSnsResItemBySnstype.mSnsType == 1001) {
                        appSnsResItemBySnstype.mTitleResId = R.string.xiaoying_str_studio_save_to_local;
                    }
                    arrayList.add(appSnsResItemBySnstype);
                }
                return arrayList;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<SnsResItem>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
            }

            public void onSuccess(List<SnsResItem> list) {
                RecyclerView recyclerView = (RecyclerView) ResultPageActivity.this.f3387OC.findViewById(R.id.result_page_share_list);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ResultPageActivity.this);
                linearLayoutManager.setOrientation(0);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setVisibility(0);
                recyclerView.setAdapter(new C4092a(ResultPageActivity.this, list, ResultPageActivity.this.bvz));
            }
        });
    }

    /* renamed from: Nk */
    public void mo23763Nk() {
        TextView textView = (TextView) this.f3387OC.findViewById(R.id.project_export_path);
        this.bvl = (ImageView) this.f3387OC.findViewById(R.id.project_cover_image_view);
        this.bvm = (ImageView) this.f3387OC.findViewById(R.id.play_video_button);
        if (this.bvx) {
            this.bvm.setVisibility(8);
        } else {
            this.bvm.setOnClickListener(this);
        }
        this.bvp = this.f3387OC.findViewById(R.id.result_find_video_china);
        this.bvq = this.f3387OC.findViewById(R.id.result_find_video_oversea);
        View findViewById = this.f3387OC.findViewById(R.id.result_line);
        if (!TextUtils.isEmpty(this.bvu)) {
            String parent = new File(this.bvu).getParent();
            String str = File.separatorChar == '\\' ? "\\\\" : File.separator;
            String[] split = parent.split(str);
            StringBuilder sb = new StringBuilder(Environment.getExternalStorageDirectory().getPath());
            int length = split.length;
            for (int i = 4; i < length; i++) {
                sb.append(split[i]);
                sb.append(str);
            }
            textView.setText(getString(R.string.xiaoying_str_export_project_path, new Object[]{sb.toString()}));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.bvq.setOnClickListener(this);
        this.bvp.setOnClickListener(this);
        if (this.bvx) {
            this.bvy.sendEmptyMessage(1002);
        } else {
            ImageLoader.loadImage((Context) this, R.color.color_e1e1e1, this.bvv, this.bvl, SourceType.UNKNOWN);
        }
        this.bvq.setVisibility(8);
        this.bvp.setVisibility(8);
        findViewById.setVisibility(8);
        m10146Nl();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23764a(SnsResItem snsResItem) {
        if (!TextUtils.isEmpty(this.bvu)) {
            C4981a cQ = new C4981a().mo25446cQ(this.bvu);
            if (snsResItem.mSnsType == 4) {
                cQ.mo25448cS(getString(R.string.xiaoying_str_studio_intent_chooser_email));
            }
            SnsShareManager.shareVideo(this, snsResItem.mSnsType, cQ.mo25441FJ(), null);
        }
    }

    public void initUI() {
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvk = (TextView) findViewById(R.id.xiaoying_txtview_draft_btn);
        this.bvr = (CreationListView) findViewById(R.id.result_page_item_list);
        this.bvr.setScrollEventId("Result_Video_Scroll");
        this.bvo = (ImageView) findViewById(R.id.result_page_back_top);
        this.bvn.setOnClickListener(this);
        this.bvk.setOnClickListener(this);
        this.bvo.setOnClickListener(this);
        if (this.bvs == null) {
            this.bvs = new ArrayList();
        }
        if (this.bot != null) {
            this.bvs.clear();
            boolean z = false;
            IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
            if (iAppService != null) {
                z = iAppService.isYoungerMode();
            }
            if (!z) {
                this.bvs.addAll(this.bot.mo23309H(this, 70));
            }
        }
        this.bvt = new C4426a(this, this.bvs, 47);
        this.bvt.mo24524hM(12);
        this.f3387OC = LayoutInflater.from(this).inflate(R.layout.publish_result_page_top_layout, null);
        mo23763Nk();
        this.bvr.addHeaderView(this.f3387OC);
        this.bvr.setAdapter((ListAdapter) this.bvt);
        this.bvr.setThresholdPage(2);
        this.bvr.setOnOffsetTopListener(new C4423a() {
            /* renamed from: Nd */
            public void mo23731Nd() {
            }

            /* renamed from: bD */
            public void mo23732bD(boolean z) {
                ResultPageActivity.this.bvo.setVisibility(z ? 0 : 8);
            }
        });
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            m10145Nj();
            HashMap hashMap = new HashMap();
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "back");
            UserBehaviorLog.onKVEvent(this, "Result_Exit", hashMap);
        } else if (view.equals(this.bvk)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "home");
            UserBehaviorLog.onKVEvent(this, "Result_Exit", hashMap2);
            setResult(-1);
            finish();
        } else if (view.equals(this.bvo)) {
            if (this.bvr.getChildCount() > 0) {
                this.bvr.smoothScrollToPosition(0);
            }
        } else if (view.equals(this.bvm) && !TextUtils.isEmpty(this.bvu)) {
            if (!C8957e.m26315a(this, "android.intent.action.VIEW", this.bvu, MimeTypes.VIDEO_MP4, new int[]{R.string.xiaoying_str_com_cancel})) {
                ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_no_sns_client, 0);
            }
        } else if (view.equals(this.bvp) || view.equals(this.bvq)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                C4612a.m11759a(intent, "resource/folder", new File(this.bvu).getParentFile(), true);
                startActivity(intent);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("version", AppStateModel.getInstance().isInChina() ? "domestic" : "inter");
                UserBehaviorLog.onKVEvent(getApplicationContext(), "Result_Video_Loction_Click", hashMap3);
            } catch (Exception e) {
                LogUtils.m14222e("ResultPageActivity", e.getMessage());
                ToastUtils.show((Context) this, R.string.xiaoying_str_studio_msg_app_not_found, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aGM = false;
        setContentView(R.layout.publish_result_page_layout);
        NativeAdmob.refreshAd(this);
        RateDialog.showDialogRate(this);
        ActionFirebaseStarVlogs.actionResultActivity(this);
        CrashAll.loadAndshow(this, "las_result_activity");
        this.bot = new C3821d();
        this.bot.mo23318cg(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.bvw = intent.getBooleanExtra(ExportResultPageParams.ACTIVITY_FROM, true);
            this.bvu = intent.getStringExtra(ExportResultPageParams.PROJECT_ITEM_EXPORT_URL);
            this.bvv = intent.getStringExtra(ExportResultPageParams.PROJECT_ITEM_COVER_URL);
        }
        this.bvx = this.bvu != null && this.bvu.endsWith(".gif");
        initUI();
        UserBehaviorLog.onKVEvent(this, "Home_Export_Result", new HashMap());
        HashMap hashMap = new HashMap();
        hashMap.put("state", UserServiceProxy.isLogin() ? Event.LOGIN : "logout");
        UserBehaviorLog.onKVEvent(this, "Result_Enter", hashMap);
        if (C4580b.m11636Sj()) {
            int readInt = UtilsPrefs.with(getApplicationContext(), AppRouter.VIVA_APP_PREF_FILENAME, true).readInt("Pref_Key_Oppo_Path_Tip_Show_Count", 0);
            if (readInt <= 0) {
                C8978m.m26349hs(this).mo10293dl(R.string.viva_msg_exp_oppo_save_path_dialog_tip_title).mo10296do(R.string.viva_msg_exp_oppo_save_path_dialog_tip).mo10299dr(R.string.xiaoying_str_com_msg_got_it).mo10314qv();
                UtilsPrefs.with(getApplicationContext(), AppRouter.VIVA_APP_PREF_FILENAME, true).writeInt("Pref_Key_Oppo_Path_Tip_Show_Count", readInt + 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.aGM = true;
        C7680l.aAe().releasePosition(12);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "system_back");
        UserBehaviorLog.onKVEvent(this, "Result_Exit", hashMap);
        m10145Nj();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C7680l.aAf().mo32495iu(false);
        super.onPause();
        if (this.bvt != null) {
            this.bvt.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C7680l.aAf().mo32495iu(true);
        super.onResume();
        C7591a.m22377kg("结果页");
        if (this.bvt != null) {
            this.bvt.onResume();
        }
    }
}
