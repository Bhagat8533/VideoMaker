package com.introvd.template.editor.preview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.EventActivity;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.p262a.C6304b.C6306a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.preview.adapter.PreviewFragmentPagerAdapter;
import com.introvd.template.editor.preview.fragment.BasePreviewFragment;
import com.introvd.template.editor.preview.fragment.p275b.C6650a;
import com.introvd.template.editor.preview.p270a.C6522a;
import com.introvd.template.editor.preview.p270a.C6523b;
import com.introvd.template.editor.preview.p272c.C6555a;
import com.introvd.template.editor.preview.p272c.C6556b;
import com.introvd.template.editor.preview.view.PreviewTabView;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.starvlogs.ActionMain;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.storyboard.QStoryboard;

@SuppressLint({"ViewConstructor"})
public class PreviewOpsView extends BasePreviewOpsView implements C6522a {
    private TabLayout cZH;
    /* access modifiers changed from: private */
    public EditorViewPager cZI;
    /* access modifiers changed from: private */
    public int cZJ = 0;
    private boolean cZK;
    private C6556b cZL = new C6556b() {
        /* renamed from: a */
        public void mo29780a(C6555a aVar) {
            if (PreviewOpsView.this.cZM != null) {
                PreviewOpsView.this.cZN.aqn().mo29888a(aVar);
            }
        }

        public ViewGroup aoP() {
            return PreviewOpsView.this.cyC != null ? PreviewOpsView.this.cyC.aeo() : (ViewGroup) PreviewOpsView.this.findViewById(R.id.root);
        }

        public void aoQ() {
            C6499a d = PreviewOpsView.this.getVideoOperator();
            if (d != null) {
                d.aoi();
            }
            PreviewOpsView.this.aoO();
            PreviewOpsView.this.aoM();
            String str = "";
            int oJ = PreviewOpsView.this.cZN.mo30033oJ(PreviewOpsView.this.cZJ);
            if (oJ == 0) {
                str = "theme";
            } else if (oJ == 1) {
                str = EditorRouter.ENTRANCE_EDIT;
            } else if (oJ == 2) {
                str = "effect";
            }
            C6521a.m18907bF(PreviewOpsView.this.getContext(), str);
        }

        public Bundle aoR() {
            return PreviewOpsView.this.getBundle();
        }

        public void aoS() {
            if (PreviewOpsView.this.cZN.aqp() != null) {
                PreviewOpsView.this.cZN.aqp().apn();
            }
        }

        /* renamed from: cI */
        public void mo29785cI(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt("ve_extra_effect_id", i2);
            PreviewOpsView.this.m18880f(i, bundle);
        }

        /* renamed from: es */
        public void mo29786es(boolean z) {
            if (PreviewOpsView.this.cyC != null) {
                PreviewOpsView.this.cyC.mo27785es(z);
            }
        }

        public Activity getActivity() {
            return (Activity) PreviewOpsView.this.bwg.get();
        }

        /* renamed from: h */
        public void mo29788h(int i, List<Integer> list) {
            PreviewOpsView.this.aoO();
            PreviewOpsView.this.m18882g(i, list);
        }
    };
    /* access modifiers changed from: private */
    public PreviewFragmentPagerAdapter cZM;
    /* access modifiers changed from: private */
    public C6650a cZN;
    private C6523b cZO;

    public PreviewOpsView(Activity activity) {
        super(activity);
    }

    private void aoL() {
        this.cZH = (TabLayout) findViewById(R.id.editor_tab);
        for (int i = 0; i < this.cZM.getCount(); i++) {
            this.cZH.mo2004a(this.cZH.mo2018fg().mo2088E(this.cZM.mo29799ox(this.cZN.mo30033oJ(i))));
        }
        this.cZH.setSelectedTabIndicatorHeight(0);
        if (this.cZH.mo2008aI(this.cZJ) != null) {
            this.cZH.mo2008aI(this.cZJ).select();
            View customView = this.cZH.mo2008aI(this.cZJ).getCustomView();
            if (customView instanceof PreviewTabView) {
                ((PreviewTabView) customView).setStatus(true);
            }
        }
        if (this.cZJ >= 0) {
            BasePreviewFragment ow = this.cZM.getItem(this.cZJ);
            if (ow != null) {
                ow.mo29896gB(true);
                ow.onHiddenChanged(false);
            }
        }
        this.cZH.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                int position = fVar.getPosition();
                int oJ = PreviewOpsView.this.cZN.mo30033oJ(position);
                C5843c.agO().setTabMode(oJ);
                C6521a.m18904bC(PreviewOpsView.this.getContext(), EditorModes.getEditorTabName(oJ));
                View customView = fVar.getCustomView();
                if (customView instanceof PreviewTabView) {
                    PreviewTabView previewTabView = (PreviewTabView) customView;
                    previewTabView.setStatus(true);
                    if (previewTabView.getShownIcon() != null) {
                        C2564c.m7329dx(previewTabView.getShownIcon());
                    }
                }
                if (Math.abs(PreviewOpsView.this.cZJ - position) > 1) {
                    PreviewOpsView.this.cZI.setCurrentItem(position, false);
                } else {
                    PreviewOpsView.this.cZI.setCurrentItem(position);
                }
                boolean z = PreviewOpsView.this.cZN.mo30033oJ(PreviewOpsView.this.cZJ) == 1 || oJ == 1;
                PreviewOpsView.this.cZJ = position;
                if (z) {
                    PreviewOpsView.this.aoN();
                }
                PreviewOpsView.this.cZM.getItem(PreviewOpsView.this.cZJ).mo29896gB(true);
                int i = 0;
                while (i < PreviewOpsView.this.cZM.getCount()) {
                    PreviewOpsView.this.cZM.getItem(i).onHiddenChanged(PreviewOpsView.this.cZJ != i);
                    i++;
                }
                if (PreviewOpsView.this.getVideoOperator() != null) {
                    PreviewOpsView.this.getVideoOperator().aof();
                }
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof PreviewTabView) {
                    ((PreviewTabView) customView).setStatus(false);
                }
                PreviewOpsView.this.cZM.getItem(fVar.getPosition()).mo29896gB(false);
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void aoM() {
        Builder newPrj = new Builder().setSourceMode(0).setAction(2).setNewPrj(false);
        newPrj.setFocusPhotoTab(C8522g.aJA().aHe() != null ? C8522g.aJA().aHe().isMVPrj() : false);
        GalleryRouter.getInstance().launchActivity((Activity) this.bwg.get(), PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, newPrj.build()), 24581);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m18880f(int i, Bundle bundle) {
        getVideoOperator().aoi();
        if (EditorModes.isEffectMode(i)) {
            C6293a.anj().mo29237a(new C6306a().mo29269c(this.cyD.adK().aHf()).mo29268c(C6386d.m18378pA(i)).ant(), true);
        }
        if (this.cyC != null) {
            this.cyC.mo27786f(i, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m18882g(int i, List<Integer> list) {
        if (EditorModes.isClipEditMode(i)) {
            if (list != null) {
                if (this.cyD.adU()) {
                    List<Integer> arrayList = new ArrayList<>();
                    for (Integer intValue : list) {
                        arrayList.add(Integer.valueOf(intValue.intValue() + 1));
                    }
                    list = arrayList;
                }
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("ve_extra_clip_index_list", (ArrayList) list);
                bundle.putBoolean("ve_extra_clip_applyall_enable", this.cZN.aqn().aeL());
                m18880f(i, bundle);
            }
        } else if (EditorModes.isEffectMode(i)) {
            m18880f(i, new Bundle());
        } else if (EditorModes.isThemeMode(i)) {
            m18880f(i, new Bundle());
        }
    }

    private void initViewPager() {
        this.cZI = (EditorViewPager) findViewById(R.id.vp_preview);
        ActionMain.actionButtonAds(getActivity());
        if (getActivity() != null && (getActivity() instanceof EventActivity)) {
            List<BasePreviewFragment> aql = this.cZN.aql();
            EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
            for (BasePreviewFragment a : aql) {
                a.mo29887a(getEditor(), getVideoOperator(), this.cZL, editorIntentInfo);
            }
            if (this.cZN.aqo() != null) {
                this.cZO.mo29791b(this.cZN.aqo().getFineTuningListener());
                this.cZO.setPlayerStatusListener(this.cZN.aqo().getPlayerStatusListener());
            }
            this.cZM = new PreviewFragmentPagerAdapter(getActivity().getApplicationContext(), ((EventActivity) getActivity()).getSupportFragmentManager(), aql);
            this.cZI.setAdapter(this.cZM);
            this.cZI.setOffscreenPageLimit(aql.size() - 1);
            this.cZI.setCurrentItem(this.cZJ);
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void aex() {
        super.aex();
        this.cZO = new C6523b();
        this.cZO.attachView((C6522a) this);
        this.cZO.mo29789a(getContext(), this.cyD);
        this.cZN = new C6650a(getEditor().adW());
        this.cZJ = this.cZN.mo30032oI(C5843c.agO().getTabMode());
        initViewPager();
        aoL();
    }

    public void aoN() {
        if (C8540q.m24976w(this.cyD.adO()) || C8540q.m24892A(this.cyD.adO())) {
            int agQ = C5843c.agO().agQ();
            int i = 0;
            boolean z = true;
            if (this.cZN.mo30033oJ(this.cZJ) == 1) {
                z = false;
            }
            if (!z || agQ != 0) {
                QStoryboard adO = this.cyD.adO();
                if (this.cyD.adU()) {
                    agQ++;
                }
                i = C8540q.m24974v(adO, agQ);
            }
            getVideoOperator().mo29697n(z, i);
        }
    }

    public void aoO() {
        if (this.cZM != null && this.cZM.getItem(this.cZJ) != null) {
            this.cZM.getItem(this.cZJ).mo29896gB(false);
        }
    }

    public int getCurrTabType() {
        return this.cZN.mo30033oJ(this.cZJ);
    }

    public C5688b getFineTuningListener() {
        return this.cZO.getFineTuningListener();
    }

    public C6556b getInterListener() {
        return this.cZL;
    }

    public int getLayoutId() {
        return R.layout.editor_preview_ops;
    }

    public C6280b getPlayerStatusListener() {
        return this.cZO.getPlayerStatusListener();
    }

    /* renamed from: gq */
    public void mo29751gq(boolean z) {
        super.mo29751gq(z);
        this.cZK = z;
        for (int i = 0; i < this.cZM.getCount(); i++) {
            this.cZM.getItem(i).mo29895gA(z);
        }
    }

    /* renamed from: gt */
    public void mo29777gt(boolean z) {
        if (z) {
            getVideoOperator().mo29688f(getEditor().getStreamSize());
            int agQ = C5843c.agO().agQ();
            QStoryboard adO = this.cyD.adO();
            if (this.cyD.adU()) {
                agQ++;
            }
            getVideoOperator().mo29687cH(0, C8540q.m24974v(adO, agQ));
            this.cZN.aqn().mo29901oz(-1);
            if (this.cZN.aqp() != null) {
                this.cZN.aqp().apn();
            }
        }
    }

    /* renamed from: gu */
    public void mo29778gu(boolean z) {
        if (z) {
            C4586g.m11703a(getContext(), R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null);
            return;
        }
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && !activity.isFinishing()) {
            C4586g.m11696Sm();
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.cZO != null) {
            this.cZO.detachView();
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 24581) {
            if (i == 24583) {
                if (i2 == -1) {
                    for (int i3 = 0; i3 < this.cZM.getCount(); i3++) {
                        this.cZM.getItem(i3).apk();
                    }
                }
            } else if (i != 24584) {
                this.cZN.aqm().onActivityResult(i, i2, intent);
            } else if (i2 != -1) {
                C6293a.anj().anm();
            } else {
                C6293a.anj().ann();
                int agQ = C5843c.agO().agQ();
                getVideoOperator().mo29687cH(0, C8540q.m24974v(this.cyD.adO(), this.cyD.adU() ? agQ + 1 : agQ));
                this.cZN.aqn().mo29901oz(agQ);
            }
        } else if (!(i2 != -1 || intent == null || intent.getExtras() == null)) {
            this.cZO.mo29792bg(intent.getParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY));
        }
    }

    public boolean onBackPressed() {
        return this.cZM.getItem(this.cZJ).onBackPressed();
    }

    /* renamed from: oq */
    public void mo29752oq(int i) {
        if (EditorModes.isClipEditMode(i)) {
            this.cZN.aqn().mo29935nI(i);
        }
    }

    /* renamed from: or */
    public boolean mo29753or(int i) {
        if (EditorModes.isClipEditMode(i)) {
            return this.cZN.aqn().aeL();
        }
        return false;
    }

    /* renamed from: os */
    public void mo29779os(int i) {
        if (!this.cZK) {
            List<Integer> r = C8540q.m24969r(getEditor().adO(), i);
            if (getEditor().adU() && r.size() > 0) {
                List arrayList = new ArrayList();
                for (Integer intValue : r) {
                    arrayList.add(Integer.valueOf(intValue.intValue() - 1));
                }
                r = arrayList;
            }
            this.cZN.aqn().mo29893bi(r);
        }
    }

    public void setFocusTab(int i) {
        this.cZJ = this.cZN.mo30032oI(i);
        if (this.cZI != null && this.cZH != null && this.cZH.mo2008aI(this.cZJ) != null && this.cZI.getCurrentItem() != this.cZJ && this.cZI.getChildCount() > 0) {
            this.cZH.mo2008aI(this.cZJ).select();
        }
    }
}
