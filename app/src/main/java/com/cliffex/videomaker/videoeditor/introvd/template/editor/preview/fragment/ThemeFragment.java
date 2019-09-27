package com.introvd.template.editor.preview.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.p021v4.util.LongSparseArray;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.preview.fragment.p274a.C6637c;
import com.introvd.template.editor.preview.fragment.p274a.C6638d;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.preview.p271b.C6552c;
import com.introvd.template.editor.preview.p271b.C6553d;
import com.introvd.template.editor.preview.p271b.C6554e;
import com.introvd.template.editor.preview.theme.C6656a;
import com.introvd.template.editor.preview.theme.C6658b;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.editor.preview.theme.p276a.C6657a;
import com.introvd.template.editor.preview.theme.p277b.C6659a;
import com.introvd.template.editor.preview.theme.p277b.C6661b;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout.C7884a;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import com.p131c.p132a.p135c.C2575a;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle;

@LDPProtect
public class ThemeFragment extends BasePreviewFragment implements C6637c {
    private WindowManager bRY;
    /* access modifiers changed from: private */
    public LinearLayoutManager cDe;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public RecyclerView dbU;
    /* access modifiers changed from: private */
    public View dbV;
    /* access modifiers changed from: private */
    public CustomRecyclerViewAdapter dbW;
    private C6659a dbX;
    /* access modifiers changed from: private */
    public volatile List<EngineSubtitleInfoModel> dbY;
    /* access modifiers changed from: private */
    public LongSparseArray<Integer> dbZ = new LongSparseArray<>();
    private RelativeLayout dbo;
    /* access modifiers changed from: private */
    public ImageButton dbp;
    /* access modifiers changed from: private */
    public String dca = "";
    private C6618a dcb = new C6618a(this);
    private View dcc;
    /* access modifiers changed from: private */
    public C6638d dcd;
    /* access modifiers changed from: private */
    public boolean dce = false;
    /* access modifiers changed from: private */
    public C6651b dcf;
    private VipThemeNoticeBottomLayout dcg;
    /* access modifiers changed from: private */
    public C6656a dch = new C6656a() {
        /* renamed from: aF */
        public int mo29970aF(long j) {
            return ((Integer) ThemeFragment.this.dbZ.get(j, Integer.valueOf(0))).intValue();
        }

        public boolean apT() {
            return ThemeFragment.this.dbY != null && ThemeFragment.this.dbY.size() > 0;
        }

        /* renamed from: j */
        public boolean mo29972j(EffectInfoModel effectInfoModel) {
            return ThemeFragment.this.m19194g(effectInfoModel);
        }

        /* renamed from: k */
        public boolean mo29973k(EffectInfoModel effectInfoModel) {
            return ThemeFragment.this.m19199h(effectInfoModel);
        }

        /* renamed from: l */
        public void mo29974l(EffectInfoModel effectInfoModel) {
            ThemeFragment.this.dca = effectInfoModel.strSceneName;
            ThemeFragment.this.m19197gM(true);
        }
    };
    /* access modifiers changed from: private */
    public List<BaseItem> dci = new ArrayList();

    /* renamed from: com.introvd.template.editor.preview.fragment.ThemeFragment$a */
    private static class C6618a extends WeakHandler<ThemeFragment> {
        public C6618a(ThemeFragment themeFragment) {
            super(themeFragment);
        }

        public void handleMessage(Message message) {
            if (message.what == 10010 && ((ThemeFragment) getOwner()).dcf != null && ((ThemeFragment) getOwner()).dbp != null) {
                ((ThemeFragment) getOwner()).dcf.mo30034b(((ThemeFragment) getOwner()).dbp, 5, ((ThemeFragment) getOwner()).getResources().getString(R.string.xiaoying_str_editor_clip_help_tip), C4580b.m11666qi(), C4583d.m11673ii(5), C7689a.m22599ii(5));
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_theme_add_clip_show_flag", true);
            }
        }
    }

    public ThemeFragment() {
        mo29900oy(0);
        this.compositeDisposable = new C1494a();
    }

    /* renamed from: aD */
    private C6661b m19181aD(long j) {
        for (BaseItem baseItem : this.dci) {
            if (baseItem instanceof C6661b) {
                C6661b bVar = (C6661b) baseItem;
                if (((EffectInfoModel) bVar.getItemData()).mTemplateId == j) {
                    return bVar;
                }
            }
        }
        return null;
    }

    /* renamed from: aE */
    private void m19182aE(long j) {
        if (getContext() != null && this.daU != null) {
            if (this.dcg == null) {
                this.dcg = C8049f.aBf().mo33079a(getHostActivity(), Long.valueOf(j), new C7884a() {
                    /* renamed from: UT */
                    public void mo29975UT() {
                        ThemeFragment.this.m19196gL(true);
                    }

                    public void apU() {
                    }
                });
            }
            this.dcg.setTemplateId(j);
            if (this.daU.aoP().indexOfChild(this.dcg) == -1) {
                LayoutParams layoutParams = new LayoutParams(-1, ((int) getContext().getResources().getDimension(R.dimen.editor_ops_board_normal_height)) - C4583d.m11673ii(24));
                layoutParams.addRule(12);
                this.daU.aoP().addView(this.dcg, layoutParams);
            }
            this.dcg.setVisibility(0);
            this.daU.mo29786es(true);
        }
    }

    /* access modifiers changed from: private */
    public void apL() {
        boolean z = this.cyD != null && this.cyD.adW();
        this.dbX = new C6659a(getActivity(), new C6657a(false, z));
        mo29957gO(false);
        this.dcd.mo30016m(this.dcd.mo30015io(this.dcd.aqa()));
        m19186bm(this.dci);
        this.dbW.setData(this.dci);
        apN();
        if (apl() && z) {
            apP();
        }
        apM();
    }

    private void apM() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                ThemeFragment.this.compositeDisposable.mo9785e(bVar);
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(ThemeFragment.this.daU.aoR(), EditorIntentInfo.class);
                if (editorIntentInfo != null) {
                    String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
                    String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
                    if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                        EffectInfoModel effectInfoModel = null;
                        if (!TextUtils.isEmpty(str)) {
                            effectInfoModel = ThemeFragment.this.dcd.mo30002aG(C2575a.m7391rq(str));
                        } else if (!TextUtils.isEmpty(str2)) {
                            effectInfoModel = ThemeFragment.this.dcd.mo30015io(str2);
                        }
                        if (effectInfoModel != null) {
                            ThemeFragment.this.dch.mo29972j(effectInfoModel);
                            return;
                        }
                        String str3 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_EVENT_ID);
                        if (TextUtils.isEmpty(str3) || !TextUtils.isDigitsOnly(str3)) {
                            ToastUtils.shortShow(ThemeFragment.this.getContext(), R.string.xiaoying_str_editor_theme_apply_fail);
                        }
                    }
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    public static ThemeFragment apO() {
        return new ThemeFragment();
    }

    private void apP() {
        if (getActivity() != null) {
            try {
                if (this.bRY == null) {
                    this.bRY = (WindowManager) getActivity().getSystemService("window");
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.type = 2;
                    layoutParams.flags = 65800;
                    layoutParams.format = -3;
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 81;
                    layoutParams.x = 0;
                    layoutParams.y = C4583d.m11671P(232.0f);
                    this.bRY.addView(apR(), layoutParams);
                }
                this.dcc.setVisibility(0);
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public int apQ() {
        if (TextUtils.isEmpty(this.dcd.aqa())) {
            return -1;
        }
        for (int i = 1; i < this.dci.size(); i++) {
            BaseItem baseItem = (BaseItem) this.dci.get(i);
            if (baseItem instanceof C6661b) {
                if (this.dcd.aqa().equals(((EffectInfoModel) ((C6661b) baseItem).getItemData()).mPath)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private View apR() {
        if (this.dcc == null) {
            this.dcc = LayoutInflater.from(getContext().getApplicationContext()).inflate(R.layout.editor_theme_duration_setbtn_view, null);
            ((Button) this.dcc.findViewById(R.id.tvDurateionSetBtn)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ThemeFragment.this.daT.aoi();
                    ThemeFragment.this.daT.mo29675H(0, false);
                    ThemeFragment.this.daU.mo29788h(3003, null);
                    ThemeFragment.this.m19195gK(false);
                }
            });
        }
        return this.dcc;
    }

    /* renamed from: bm */
    private void m19186bm(List<BaseItem> list) {
        if (list != null && list.size() != 0) {
            int i = 0;
            for (BaseItem itemData : list) {
                Object itemData2 = itemData.getItemData();
                if ((itemData2 instanceof EffectInfoModel) && ((EffectInfoModel) itemData2).isDownloaded()) {
                    i++;
                }
            }
            C6664c.m19367ab(getContext(), i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m19194g(EffectInfoModel effectInfoModel) {
        if (effectInfoModel == null) {
            return false;
        }
        String bn = C8450a.m24469bn(effectInfoModel.mTemplateId);
        C6664c.m19372g(getContext(), effectInfoModel.mName, bn, "Preview_SetTheme");
        if (m19199h(effectInfoModel)) {
            if (this.dbY != null && this.dbY.size() > 0) {
                this.daU.mo29788h(3001, null);
                m19195gK(false);
            }
            return false;
        } else if (effectInfoModel.isDownloading()) {
            return false;
        } else {
            boolean v = C8739i.m25530v(Long.valueOf(effectInfoModel.mTemplateId));
            boolean bu = C8739i.m25522bu(effectInfoModel.mTemplateId);
            boolean z = C8049f.aBf().aBr() && C6386d.m18377iL(bn.toLowerCase());
            String str = z ? "vip" : (v || bu) ? SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK : "normal";
            C6664c.m19373h(getContext(), effectInfoModel.mName, str, effectInfoModel.isbNeedDownload() ? "not_downloaded" : "downloaded");
            if (z) {
                if (effectInfoModel.isbNeedDownload()) {
                    TemplateInfo Z = C8735f.aMf().mo35140Z(getContext(), C8399c.ecX, bn);
                    if (Z != null) {
                        effectInfoModel.setmUrl(Z.strUrl);
                    }
                    this.dcd.mo30019p(effectInfoModel);
                } else {
                    this.dcd.mo30001a(effectInfoModel, true);
                    mo29896gB(false);
                    m19182aE(effectInfoModel.mTemplateId);
                }
                return true;
            }
            apS();
            if (bu) {
                this.daT.aoi();
                this.dcd.mo30020q(effectInfoModel);
                C4586g.m11710d(getActivity(), 10106, effectInfoModel.mName);
                return true;
            } else if (v || effectInfoModel.isbNeedDownload()) {
                if (!BaseSocialNotify.isNetworkAvaliable(getContext().getApplicationContext())) {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_com_msg_network_inactive, 0);
                    return false;
                } else if (v) {
                    this.daT.aoi();
                    this.dcd.mo30020q(effectInfoModel);
                    this.dcd.mo30013b(effectInfoModel, false);
                    return true;
                } else {
                    TemplateInfo Z2 = C8735f.aMf().mo35140Z(getContext(), C8399c.ecX, bn);
                    if (Z2 != null) {
                        effectInfoModel.setmUrl(Z2.strUrl);
                    }
                    this.dcd.mo30019p(effectInfoModel);
                    return true;
                }
            } else if (this.dcd.mo30017n(effectInfoModel)) {
                return true;
            } else {
                C6664c.m19372g(getContext(), effectInfoModel.mName, bn, "Preview_SetTheme_Modify");
                this.dcd.mo30001a(effectInfoModel, false);
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gK */
    public void m19195gK(boolean z) {
        if (!(this.dcc == null || this.bRY == null || this.dcc.getVisibility() != 0)) {
            this.dcc.setVisibility(8);
            if (z) {
                this.bRY.removeView(this.dcc);
            }
        }
        if (this.dcd != null) {
            this.dcd.aqj();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gL */
    public void m19196gL(boolean z) {
        if (this.dcg != null) {
            this.dcg.setVisibility(8);
            if (this.daU != null) {
                this.daU.mo29786es(false);
            }
        }
        List aqd = this.dcd.aqd();
        if (!z || aqd == null || aqd.size() <= 1) {
            EffectInfoModel aqe = this.dcd.aqe();
            if (aqe != null) {
                this.dch.mo29972j(aqe);
                return;
            }
            return;
        }
        C6293a.anj().mo29247fZ(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: gM */
    public void m19197gM(boolean z) {
        if (z) {
            if (this.daU != null) {
                if (this.dbV == null) {
                    this.dbV = LayoutInflater.from(getContext()).inflate(R.layout.editor_frag_theme_scene, null);
                }
                ((TextView) this.dbV.findViewById(R.id.theme_scene_name)).setText(this.dca);
                ViewGroup aoP = this.daU.aoP();
                if (aoP.indexOfChild(this.dbV) == -1) {
                    LayoutParams layoutParams = new LayoutParams(-1, C4583d.m11673ii(70));
                    layoutParams.addRule(12);
                    aoP.addView(this.dbV, layoutParams);
                    this.dbV.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            ThemeFragment.this.m19197gM(false);
                        }
                    });
                }
                this.dbV.setVisibility(0);
                C2564c.m7322a(this.dbV, (float) C4583d.m11673ii(70), 0.0f, new C2569a() {
                    public void onFinish() {
                        ThemeFragment.this.dce = true;
                        ThemeFragment.this.mo29957gO(true);
                        ThemeFragment.this.dbW.setData(ThemeFragment.this.dci);
                        ThemeFragment.this.mo29955gJ(true);
                    }
                });
            }
        } else if (this.dbV != null) {
            C2564c.m7324b(this.dbV, 0.0f, (float) C4583d.m11673ii(70), new C2569a() {
                public void onFinish() {
                    ThemeFragment.this.dbV.setVisibility(8);
                    ThemeFragment.this.dce = false;
                    ThemeFragment.this.mo29957gO(false);
                    ThemeFragment.this.dbW.setData(ThemeFragment.this.dci);
                    ThemeFragment.this.apN();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m19199h(EffectInfoModel effectInfoModel) {
        return (TextUtils.isEmpty(this.dcd.aqa()) && effectInfoModel.mTemplateId == QStyle.NONE_THEME_TEMPLATE_ID) || (!TextUtils.isEmpty(this.dcd.aqa()) && this.dcd.aqa().equals(effectInfoModel.mPath));
    }

    private boolean handleBack() {
        if (this.dbV != null && this.dbV.getVisibility() == 0) {
            m19197gM(false);
            return true;
        } else if (this.dcg == null || this.dcg.getVisibility() != 0) {
            return false;
        } else {
            m19196gL(true);
            return true;
        }
    }

    /* renamed from: in */
    private void m19201in(final String str) {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                ThemeFragment.this.mo29957gO(false);
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                ThemeFragment.this.dbW.setData(ThemeFragment.this.dci);
                ThemeFragment.this.dch.mo29972j(ThemeFragment.this.dcd.mo30015io(str));
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29886a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.btV = layoutInflater.inflate(R.layout.editor_theme_fragment_layout, viewGroup, false);
    }

    public void aeU() {
        if (this.dcd == null) {
            this.dcd = new C6638d(getContext());
            this.dcd.attachView((C6637c) this);
            this.dcd.mo29998a(this.cyD, this.daT);
        }
        this.dcf = new C6651b(getActivity());
    }

    public void apN() {
        mo29955gJ(false);
    }

    public void apS() {
        if (this.dcg != null && this.dcg.isShown()) {
            this.dcg.setVisibility(8);
            if (this.daU != null) {
                this.daU.mo29786es(false);
            }
        }
    }

    /* renamed from: g */
    public void mo29954g(long j, int i) {
        C6661b aD = m19181aD(j);
        if (aD != null) {
            if (i >= 0) {
                this.dbZ.put(j, Integer.valueOf(i));
            } else {
                this.dbZ.remove(j);
            }
            aD.mo30049oQ(i);
        }
    }

    /* renamed from: gA */
    public void mo29895gA(boolean z) {
        super.mo29895gA(z);
        if (z) {
            m19195gK(false);
        } else if (this.cyD != null && this.cyD.adW() && apl()) {
            apP();
        }
    }

    /* renamed from: gB */
    public void mo29896gB(boolean z) {
        super.mo29896gB(z);
        if (!z) {
            if (this.dcf != null) {
                this.dcf.hide();
            }
            this.dcb.removeMessages(10010);
        } else if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_theme_add_clip_show_flag", false)) {
            this.dcb.sendEmptyMessageDelayed(10010, 500);
        }
    }

    /* renamed from: gJ */
    public void mo29955gJ(final boolean z) {
        LogUtilsV2.m14230i("locate theme position");
        MSize surfaceSize = this.cyD.getSurfaceSize();
        this.dbY = C8540q.m24926a(this.cyD.adP(), this.cyD.adO(), surfaceSize != null ? new VeMSize(surfaceSize.width, surfaceSize.height) : null);
        this.dbU.post(new Runnable() {
            public void run() {
                if (ThemeFragment.this.dbW != null && ThemeFragment.this.dbU != null) {
                    ThemeFragment.this.dbW.notifyDataSetChanged();
                    final int h = ThemeFragment.this.apQ();
                    if (h > 0) {
                        ThemeFragment.this.dbU.postDelayed(new Runnable() {
                            public void run() {
                                try {
                                    if (ThemeFragment.this.cDe != null) {
                                        int findFirstCompletelyVisibleItemPosition = ThemeFragment.this.cDe.findFirstCompletelyVisibleItemPosition();
                                        int findLastCompletelyVisibleItemPosition = ThemeFragment.this.cDe.findLastCompletelyVisibleItemPosition();
                                        if (h < findFirstCompletelyVisibleItemPosition || h > findLastCompletelyVisibleItemPosition) {
                                            ThemeFragment.this.cDe.scrollToPositionWithOffset(h, 0);
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 60);
                    } else if (z) {
                        ThemeFragment.this.dbU.postDelayed(new Runnable() {
                            public void run() {
                                try {
                                    if (ThemeFragment.this.cDe != null) {
                                        ThemeFragment.this.cDe.scrollToPositionWithOffset(ThemeFragment.this.dbW.getItemCount() - 1, 0);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 60);
                    }
                }
            }
        });
    }

    /* renamed from: gN */
    public void mo29956gN(boolean z) {
        if (z && this.btV != null) {
            this.btV.post(new Runnable() {
                public void run() {
                    ThemeFragment.this.apN();
                }
            });
        }
    }

    /* renamed from: gO */
    public void mo29957gO(boolean z) {
        this.dci.clear();
        List<EffectInfoModel> aqc = this.dcd.aqc();
        if (aqc != null && aqc.size() > 0) {
            for (EffectInfoModel effectInfoModel : aqc) {
                if (!z) {
                    if (effectInfoModel.isNoneTheme()) {
                        this.dci.add(0, new C6661b(getContext(), effectInfoModel, this.dch, false));
                    } else {
                        this.dci.add(new C6661b(getContext(), effectInfoModel, this.dch, false));
                    }
                } else if (effectInfoModel.strSceneName.equals(this.dca)) {
                    this.dci.add(new C6661b(getContext(), effectInfoModel, this.dch, true));
                }
            }
        }
        if (!z) {
            this.dci.add(0, this.dbX);
        }
    }

    public Activity getHostActivity() {
        return getActivity();
    }

    /* renamed from: h */
    public void mo29959h(long j, int i) {
        C6661b aD = m19181aD(j);
        if (aD != null) {
            boolean o = aD.mo30048o(i, "");
            if ((i == 0 || i == 2) && !o && this.dbW != null) {
                this.dbW.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: i */
    public void mo29960i(EffectInfoModel effectInfoModel) {
        this.dch.mo29972j(effectInfoModel);
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        this.dbU = (RecyclerView) this.btV.findViewById(R.id.rv_theme_editor);
        this.dbW = new CustomRecyclerViewAdapter();
        this.cDe = new LinearLayoutManager(getContext());
        this.cDe.setOrientation(0);
        this.dbU.setLayoutManager(this.cDe);
        this.dbU.mo7733a((C1018h) new C6658b(C4583d.m11671P(12.0f)));
        this.dbU.setAdapter(this.dbW);
        this.dbo = (RelativeLayout) this.btV.findViewById(R.id.rl_clip_add);
        if (C5837a.agH().agJ()) {
            this.dbo.setVisibility(0);
            this.dbp = (ImageButton) this.btV.findViewById(R.id.theme_add_btn);
            C2579b.m7399a(new C2582a<View>() {
                public void onClick(View view) {
                    if (ThemeFragment.this.daU != null) {
                        ThemeFragment.this.daU.aoQ();
                    }
                }
            }, this.dbp);
        } else {
            this.dbo.setVisibility(8);
        }
        this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                ThemeFragment.this.apL();
            }
        }, 300, TimeUnit.MILLISECONDS));
    }

    /* renamed from: m */
    public void mo29961m(Long l) {
        if (this.dbW != null) {
            String by = C8759b.m25586by(l.longValue());
            C6661b aD = m19181aD(l.longValue());
            if (aD == null) {
                mo29957gO(this.dce);
                this.dbW.setData(this.dci);
            } else if (!aD.mo30048o(0, by)) {
                this.dbW.notifyDataSetChanged();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24579 && intent != null) {
            String stringExtra = intent.getStringExtra("template_path");
            if (!TextUtils.isEmpty(stringExtra)) {
                m19201in(stringExtra);
            }
        } else if (i == 9527) {
            if (i2 == -1 && this.dcd.aqg()) {
                this.dcd.mo30018oH(3);
                if (this.dbW != null) {
                    this.dbW.notifyDataSetChanged();
                }
            }
        } else if (i == 10106) {
            this.dcd.aqk();
        }
    }

    public boolean onBackPressed() {
        if (handleBack()) {
            return true;
        }
        return super.onBackPressed();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C10021c.aZH().mo38494ax(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        C10021c.aZH().mo38496az(this);
        this.compositeDisposable.clear();
        if (this.dcd != null) {
            this.dcd.release();
        }
        if (this.dcb != null) {
            this.dcb.removeCallbacksAndMessages(null);
        }
        m19195gK(true);
        this.dcc = null;
        this.bRY = null;
    }

    public void onDetach() {
        super.onDetach();
        m19195gK(true);
        this.dcc = null;
        this.bRY = null;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6552c cVar) {
        if (this.cyD != null && this.cyD.adW() && apl()) {
            apP();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6553d dVar) {
        m19195gK(false);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6554e eVar) {
        if (this.dbW != null) {
            this.dbW.notifyDataSetChanged();
        }
    }

    public void onHiddenChanged(boolean z) {
        if (z || this.cyD == null || !this.cyD.adW()) {
            m19195gK(false);
        } else {
            apP();
        }
    }

    public void onPause() {
        super.onPause();
        this.dcd.aqh();
        if (getActivity().isFinishing()) {
            m19195gK(true);
            this.dcc = null;
            this.bRY = null;
        }
    }

    public void onResume() {
        super.onResume();
        this.dcd.aqi();
        long templateID = C8762d.aMt().getTemplateID(this.dcd.aqa());
        boolean z = C8049f.aBf().aBr() && C6386d.m18377iL(C8450a.m24469bn(templateID).toLowerCase());
        if (z) {
            if (this.dcg == null || this.dcg.getVisibility() != 0) {
                mo29896gB(false);
                m19182aE(templateID);
            }
        } else if (this.dcg != null && this.dcg.getVisibility() == 0) {
            m19196gL(false);
        }
        if (this.dcg != null) {
            this.dcg.mo32800c(getHostActivity(), z);
        }
    }
}
