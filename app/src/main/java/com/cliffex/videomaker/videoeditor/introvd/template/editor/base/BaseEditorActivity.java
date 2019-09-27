package com.introvd.template.editor.base;

import android.arch.lifecycle.C0069g;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.google.gson.Gson;
import com.introvd.template.EventActivity;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.AdsUtils;
import com.introvd.template.ads.entity.AdPlacementInfo;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.p245b.C5661c;
import com.introvd.template.editor.p245b.C5673d;
import com.introvd.template.editor.p245b.C5674e;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6279a;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6296a;
import com.introvd.template.editor.p261g.C6311b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.p266h.C6396h;
import com.introvd.template.editor.player.BaseEditorPlayerView;
import com.introvd.template.editor.player.p269b.C6500b;
import com.introvd.template.editor.preview.BasePreviewOpsView;
import com.introvd.template.editor.preview.PreviewOpsView;
import com.introvd.template.editor.provider.C6712g;
import com.introvd.template.editor.widget.timeline.C7125c;
import com.introvd.template.editor.widget.timeline.C7129d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.p326ad.p331e.C7618k;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.p394b.C8539p;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class BaseEditorActivity extends EventActivity implements C0069g, C5673d, C5674e {
    /* access modifiers changed from: private */
    public final String TAG = getClass().getSimpleName();
    protected boolean bop = true;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    protected ViewGroup cyh;
    /* access modifiers changed from: protected */
    public BasePreviewOpsView cyi;
    protected BaseOperationView cyj;
    /* access modifiers changed from: protected */
    public BaseEditorPlayerView cyk;
    /* access modifiers changed from: protected */
    public C5655b cyl;
    protected C5661c cym;
    protected EditorIntentInfo cyn;
    protected C5687a cyo;
    protected C5688b cyp;
    protected C5688b cyq;
    protected C6280b cyr;
    protected C6280b cys;
    protected int cyt = 0;
    protected int cyu = -1;
    private C1495b cyv;
    private C1495b cyw;
    public C6279a cyx = new C6279a() {
        /* renamed from: I */
        public void mo27783I(int i, boolean z) {
            if (BaseEditorActivity.this.cyj != null) {
                BaseEditorActivity.this.mo27769a(BaseEditorActivity.this.cyj, z);
            }
        }

        public ViewGroup aeo() {
            return BaseEditorActivity.this.cyh;
        }

        /* renamed from: es */
        public void mo27785es(boolean z) {
            if (BaseEditorActivity.this.cym != null) {
                BaseEditorActivity.this.cym.mo27732es(z);
            }
        }

        /* renamed from: f */
        public void mo27786f(int i, Bundle bundle) {
            if (BaseEditorActivity.this.cyk != null && BaseEditorActivity.this.cyk.aog()) {
                BaseEditorActivity.this.mo27775e(i, bundle);
            }
        }

        /* renamed from: gw */
        public void mo27787gw(String str) {
            if (BaseEditorActivity.this.cym != null) {
                BaseEditorActivity.this.cym.mo27733gW(str);
            }
        }

        /* renamed from: kZ */
        public void mo27788kZ(int i) {
            if (BaseEditorActivity.this.cyk != null && BaseEditorActivity.this.cyk.aog()) {
                BaseEditorActivity.this.mo27775e(i, new Bundle());
            }
        }
    };
    protected C6500b cyy = new C6500b() {
        public int aep() {
            if (BaseEditorActivity.this.cyj == null || !(BaseEditorActivity.this.cyj.getEditor() instanceof C5694a)) {
                return 0;
            }
            return ((C5694a) BaseEditorActivity.this.cyj.getEditor()).getFocusIndex();
        }

        public void aeq() {
            if (BaseEditorActivity.this.cyi != null) {
                BaseEditorActivity.this.cyi.aeq();
            }
        }

        public void aer() {
            if (BaseEditorActivity.this.cyx != null) {
                BaseEditorActivity.this.abj();
                BaseEditorActivity.this.cyx.mo27788kZ(2008);
            }
        }

        /* renamed from: la */
        public void mo27792la(int i) {
            if (BaseEditorActivity.this.cym != null) {
                BaseEditorActivity.this.cym.mo27736mc(i);
            }
        }
    };

    private void aec() {
        this.cyl = new C5655b();
        this.cyl.attachView((C5673d) this);
        this.cyl.init(getApplicationContext());
        int i = Constants.getScreenSize().height;
        if (aei() == 0) {
            i = Constants.getScreenSize().height - C5840b.cEz;
        } else if (aei() == 1) {
            i = (Constants.getScreenSize().height - C5840b.cEB) - C5840b.cEA;
        }
        this.cyl.mo27717b(new MSize(Constants.getScreenSize().width, i));
        this.cym = new C5661c();
        this.cym.attachView((C5674e) this);
        this.cym.init(getApplicationContext());
        C6293a.anj().mo29236a(new C6307c(C6312c.ORIGIN, this.cyl.ahP(), 0));
        C6293a.anj().mo29234a((C6296a) new C6296a() {
            /* renamed from: a */
            public void mo27778a(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
                if (z2) {
                    String fg = z ? cVar2.anw().mo29286fg(BaseEditorActivity.this.getApplicationContext()) : cVar.anw().mo29286fg(BaseEditorActivity.this.getApplicationContext());
                    if (!TextUtils.isEmpty(fg)) {
                        C6311b.m18065b(BaseEditorActivity.this.getApplicationContext(), z, fg);
                    }
                }
                String ac = C6396h.m18391ac(BaseEditorActivity.this, z ? cVar2.anw().getNameResId() : cVar.anw().getNameResId());
                if (ac != null) {
                    if (z) {
                        C5554b.m15022aC(BaseEditorActivity.this.getApplicationContext(), ac);
                    } else {
                        C5554b.m15021aB(BaseEditorActivity.this.getApplicationContext(), ac);
                    }
                }
                if (BaseEditorActivity.this.cyk != null) {
                    BaseEditorActivity.this.cyk.aoi();
                }
                if (BaseEditorActivity.this.cyl != null && cVar2 != null) {
                    BaseEditorActivity.this.cyl.mo27700a(cVar2.anv());
                }
            }
        });
    }

    private void aed() {
        String str = "";
        DataItemProject aHe = this.cyl.adK().aHe();
        if (aHe != null) {
            str = aHe.isMVPrj() ? EditorRouter.ENTRANCE_MV : EditorRouter.ENTRANCE_EDIT;
        }
        C5839a.m16333p(getApplicationContext(), this.cyn.from, str);
    }

    private String aee() {
        AdPlacementInfo placementInfo = new C7618k().getPlacementInfo(43, AdParamMgr.getAdType(43));
        if (placementInfo == null) {
            return null;
        }
        return AdsUtils.getDecryptString(placementInfo.placementId);
    }

    private void aej() {
        if (this.cyv != null) {
            this.cyv.dispose();
        }
        if (this.cyw != null) {
            this.cyw.dispose();
        }
    }

    private boolean aem() {
        EffectInfoModel agV = C5843c.agO().agV();
        if (agV != null) {
            return !C6386d.m18377iL(C8450a.m24469bn(agV.mTemplateId).toLowerCase());
        }
        return true;
    }

    private C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                BaseEditorActivity.this.cyo = aVar;
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (BaseEditorActivity.this.cyp != null) {
                    return BaseEditorActivity.this.cyp.mo27799a(point);
                }
                boolean z = false;
                if (BaseEditorActivity.this.cyu > 0) {
                    return false;
                }
                if (BaseEditorActivity.this.cyq != null && BaseEditorActivity.this.cyq.mo27799a(point)) {
                    z = true;
                }
                return z;
            }

            public boolean aet() {
                if (BaseEditorActivity.this.cyp != null) {
                    return BaseEditorActivity.this.cyp.aet();
                }
                return BaseEditorActivity.this.cyq != null && BaseEditorActivity.this.cyq.aet();
            }

            public void aeu() {
                if (BaseEditorActivity.this.cyp != null) {
                    BaseEditorActivity.this.cyp.aeu();
                }
                if (BaseEditorActivity.this.cyq != null) {
                    BaseEditorActivity.this.cyq.aeu();
                }
            }

            public int aev() {
                if (BaseEditorActivity.this.cyp != null) {
                    return BaseEditorActivity.this.cyp.aev();
                }
                if (BaseEditorActivity.this.cyq != null) {
                    return BaseEditorActivity.this.cyq.aev();
                }
                return 0;
            }

            public void aew() {
                if (BaseEditorActivity.this.cyq != null) {
                    BaseEditorActivity.this.cyq.aew();
                }
                if (BaseEditorActivity.this.cyp != null) {
                    BaseEditorActivity.this.cyp.aew();
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (BaseEditorActivity.this.cyp != null) {
                    return BaseEditorActivity.this.cyp.mo27804hV(i);
                }
                if (BaseEditorActivity.this.cyq != null) {
                    return BaseEditorActivity.this.cyq.mo27804hV(i);
                }
                return 0;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                String b = BaseEditorActivity.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>>>FineTuningChange position:");
                sb.append(i);
                LogUtils.m14223i(b, sb.toString());
                if (BaseEditorActivity.this.cyp != null) {
                    BaseEditorActivity.this.cyp.mo27805lb(i);
                }
                if (BaseEditorActivity.this.cyq != null) {
                    BaseEditorActivity.this.cyq.mo27805lb(i);
                }
            }
        };
    }

    private C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                if (BaseEditorActivity.this.cys != null) {
                    BaseEditorActivity.this.cys.mo27793J(i, z);
                }
                if (BaseEditorActivity.this.cyr != null) {
                    BaseEditorActivity.this.cyr.mo27793J(i, z);
                }
                BaseEditorActivity.this.mo27339kr(2);
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                if (BaseEditorActivity.this.cys != null) {
                    BaseEditorActivity.this.cys.mo27794K(i, z);
                }
                if (BaseEditorActivity.this.cyr != null) {
                    BaseEditorActivity.this.cyr.mo27794K(i, z);
                }
                BaseEditorActivity.this.mo27339kr(3);
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                if (BaseEditorActivity.this.cys != null) {
                    BaseEditorActivity.this.cys.mo27795L(i, z);
                }
                if (BaseEditorActivity.this.cyr != null) {
                    BaseEditorActivity.this.cyr.mo27795L(i, z);
                }
                BaseEditorActivity.this.mo27339kr(4);
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                if (BaseEditorActivity.this.cys != null) {
                    BaseEditorActivity.this.cys.mo27796M(i, z);
                }
                if (BaseEditorActivity.this.cyr != null) {
                    BaseEditorActivity.this.cyr.mo27796M(i, z);
                }
                BaseEditorActivity.this.mo27339kr(5);
            }

            public void aes() {
                if (BaseEditorActivity.this.cys != null) {
                    BaseEditorActivity.this.cys.aes();
                }
                if (BaseEditorActivity.this.cyr != null) {
                    BaseEditorActivity.this.cyr.aes();
                }
                BaseEditorActivity.this.mo27339kr(1);
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public void mo27767C(final Bundle bundle) {
        if (this.cyu != -1) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10164f(600, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    BaseEditorActivity.this.compositeDisposable.mo9785e(bVar);
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    int clipCount = BaseEditorActivity.this.cyl.aia().getClipCount();
                    if (clipCount > 0) {
                        if (!C8399c.ecZ.equals((String) BaseEditorActivity.this.cyn.paramMap.get(EditorRouter.MAP_PARAMS_TCID)) || clipCount != 1) {
                            ArrayList arrayList = new ArrayList();
                            boolean adU = BaseEditorActivity.this.cyl.adU();
                            arrayList.add(Integer.valueOf(adU ? 1 : 0));
                            bundle.putIntegerArrayList("ve_extra_clip_index_list", arrayList);
                            if (BaseEditorActivity.this.cyu == 1016) {
                                if (BaseEditorActivity.this.cyl.mo27721ma(adU)) {
                                    BaseEditorActivity.this.cyu = 1014;
                                } else {
                                    BaseEditorActivity.this.cyu = 1003;
                                }
                            }
                            BaseEditorActivity.this.mo27775e(BaseEditorActivity.this.cyu, bundle);
                        } else {
                            ToastUtils.shortShow(BaseEditorActivity.this.getApplicationContext(), R.string.xiaoying_str_ve_last_clip_cannot_apply_transition_tip);
                        }
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27768a(BaseOperationView baseOperationView, Bundle bundle) {
        LayoutParams layoutParams;
        if (baseOperationView != null) {
            if (baseOperationView.aey()) {
                layoutParams = new LayoutParams(-1, -1);
            } else {
                layoutParams = new LayoutParams(-1, baseOperationView.getViewHeight());
                layoutParams.addRule(12);
            }
            baseOperationView.setLayoutParams(layoutParams);
            this.cyh.addView(baseOperationView);
            baseOperationView.setActivityListener(this.cyx);
            baseOperationView.setVideoOperateHandler(this.cyk);
            if (baseOperationView.getEditor() != null) {
                baseOperationView.getEditor().mo27848a(this.cyl);
                baseOperationView.setBundle(bundle);
                baseOperationView.getEditor().mo27845B(bundle);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27769a(BaseOperationView baseOperationView, boolean z) {
        if (this.cyk != null && !this.cyk.aog() && !z) {
            return false;
        }
        C5843c.agO().mo28236lU(-1);
        C5852d.agW().mo28250lX(0);
        if (this.cyk != null) {
            this.cyk.aoi();
            this.cyk.mo29640U(this.cyt, false);
        }
        this.cym.aid();
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("###HIDE SecondaryOpsView:");
        sb.append(this.cyj);
        LogUtils.m14222e(str, sb.toString());
        aej();
        C2564c.m7324b(baseOperationView, 0.0f, (float) C5840b.cEx, null);
        this.cyw = C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                BaseEditorActivity.this.ael();
            }
        }, 300, TimeUnit.MILLISECONDS);
        return true;
    }

    public void abA() {
        finish();
    }

    public boolean abi() {
        return false;
    }

    public void abj() {
        if (this.cym != null) {
            this.cym.aig();
            this.cym.aif();
        }
    }

    public boolean abk() {
        return false;
    }

    public void abl() {
    }

    public boolean aef() {
        return this.cyk.aog();
    }

    public boolean aeg() {
        return this.cyu != -1;
    }

    /* access modifiers changed from: protected */
    public int aeh() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int aei() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void aek() {
        LogUtils.m14222e(this.TAG, "SecondOpsView SHOW anim end.");
        if (EditorModes.isClipEditMode(this.cyu)) {
            if ((this.cyt == 0 || this.cyt == 1) && this.cyk != null) {
                this.cyk.mo29687cH(this.cyj.getStreamType(), this.cyj.getPlayerInitTime());
            }
        } else if (EditorModes.isEffectMode(this.cyu) && this.cyl != null) {
            this.cyl.ahS();
        }
        if (this.cyi != null) {
            this.cyi.setLock(true);
            this.cyi.mo29751gq(true);
        }
        if (this.cyj != null) {
            this.cyj.aez();
        }
    }

    /* access modifiers changed from: protected */
    public void ael() {
        LogUtils.m14222e(this.TAG, "SecondOpsView HIDE anim end.");
        if (this.cyj != null) {
            this.cyh.removeView(this.cyj);
            if (!EditorModes.isClipEditMode(this.cyu)) {
                this.cym.mo27736mc(this.cyl.aia().getDuration());
            } else if ((this.cyt == 0 || this.cyt == 1) && this.cyk != null) {
                if (this.cyu == 1006) {
                    this.cyk.aoe();
                    this.cyk.mo29688f(this.cyl.getStreamSize());
                }
                this.cyk.mo29687cH(0, C8540q.m24974v(this.cyl.aia(), ((C5694a) this.cyj.getEditor()).getFocusIndex()));
            }
            this.cyj.onActivityPause();
            this.cyj.onActivityStop();
            this.cyj.onActivityDestroy();
            getLifecycle().mo153b(this.cyj);
            this.cyp = null;
            this.cyr = null;
            if (this.cyk != null) {
                this.cyk.setVideoControlListener(null);
                this.cyk.mo29650ep(true);
            }
            this.cyj = null;
            this.cyu = -1;
            if (EditorModes.isEffectMode(this.cyu)) {
                this.cyl.ahT();
            }
            this.cyl.ahQ();
            if (this.cyi != null) {
                this.cyi.setLock(false);
                this.cyi.mo29751gq(false);
                this.cyi.setVideoOperateHandler(this.cyk);
            }
        }
    }

    public String aen() {
        return PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo27774d(final int i, final Bundle bundle) {
        if (this.cyk != null) {
            this.cyk.mo29642a(this, this.cyl, i);
        }
        this.compositeDisposable.mo9785e(C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                BaseEditorActivity.this.cyi = C6712g.m19491a(BaseEditorActivity.this, i);
                if (BaseEditorActivity.this.cyi != null && BaseEditorActivity.this.cyi.getEditor() != null) {
                    BaseEditorActivity.this.mo27768a((BaseOperationView) BaseEditorActivity.this.cyi, bundle);
                    BaseEditorActivity.this.cyi.aex();
                    BaseEditorActivity.this.getLifecycle().mo152a(BaseEditorActivity.this.cyi);
                    BaseEditorActivity.this.cyq = BaseEditorActivity.this.cyi.getFineTuningListener();
                    BaseEditorActivity.this.cys = BaseEditorActivity.this.cyi.getPlayerStatusListener();
                    if (BaseEditorActivity.this.cyq != null) {
                        BaseEditorActivity.this.cyq.mo27798a(BaseEditorActivity.this.cyo);
                    }
                    if (BaseEditorActivity.this.cyk != null) {
                        BaseEditorActivity.this.cyk.bringToFront();
                    }
                    if (BaseEditorActivity.this.cym != null) {
                        BaseEditorActivity.this.cym.mo27735mb(i);
                    }
                }
            }
        }));
    }

    /* renamed from: d */
    public void mo27337d(TODOParamModel tODOParamModel) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo27775e(int i, Bundle bundle) {
        if (this.cyj != null) {
            ael();
        }
        if (i == 1016) {
            int agQ = C5843c.agO().agQ();
            C5655b bVar = this.cyl;
            if (this.cyl.adU()) {
                agQ++;
            }
            i = bVar.mo27721ma(agQ) ? 1014 : 1003;
        }
        this.cyj = C6712g.m19492b(this, i);
        if (this.cyj == null || this.cyj.getEditor() == null) {
            return false;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("###SHOW SecondaryOpsView:");
        sb.append(this.cyj);
        LogUtils.m14222e(str, sb.toString());
        this.cyj.setBundle(bundle);
        this.cyp = this.cyj.getFineTuningListener();
        this.cyu = i;
        C5843c.agO().mo28236lU(i);
        C5852d.agW().mo28250lX(this.cyj.getStreamType());
        if (this.cyk != null) {
            this.cyk.aoi();
            this.cyk.mo29640U(i, true);
        }
        if (i != 3001 || !bundle.getBoolean("bundle_is_only_edit_theme_title", false)) {
            this.cym.aic();
        }
        this.cym.aig();
        if (this.cyi instanceof PreviewOpsView) {
            ((PreviewOpsView) this.cyi).aoO();
        }
        mo27768a(this.cyj, bundle);
        this.cyj.aex();
        getLifecycle().mo152a(this.cyj);
        if (this.cyp != null) {
            this.cyp.mo27798a(this.cyo);
        }
        aej();
        C2564c.m7322a(this.cyj, (float) C5840b.cEx, 0.0f, null);
        this.cyv = C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                BaseEditorActivity.this.aek();
            }
        }, 300, TimeUnit.MILLISECONDS);
        this.cyp = this.cyj.getFineTuningListener();
        this.cyr = this.cyj.getPlayerStatusListener();
        if (!(this.cyj.getVideoControlListener() == null || this.cyk == null)) {
            this.cyk.setVideoControlListener(this.cyj.getVideoControlListener());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: eq */
    public void mo27776eq(boolean z) {
        this.cyk = (BaseEditorPlayerView) findViewById(R.id.editor_player);
        this.cyk.aex();
        this.cyk.setAutoPlayWhenReady(z);
        this.cyk.setPlayerStatusListener(getPlayerStatusListener());
        this.cyk.setIPlayerCallback(this.cyy);
        this.cyk.setFineTuningProxyListener(getFineTuningListener());
        getLifecycle().mo152a(this.cyk);
    }

    /* renamed from: er */
    public void mo27758er(boolean z) {
        if (z) {
            C5839a.m16334q(getApplicationContext(), "Save_Exit", this.cyn.from);
            C5839a.m16335r(getApplicationContext(), "save", this.cyn.from);
            this.cyl.ahU();
            finish();
            return;
        }
        C5839a.m16335r(getApplicationContext(), "cancel", this.cyn.from);
    }

    public FragmentActivity getActivity() {
        return this;
    }

    public ViewGroup getRootView() {
        return this.cyh;
    }

    /* renamed from: kq */
    public void mo27338kq(int i) {
        if (this.cyk != null) {
            this.cyk.pause();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: kr */
    public void mo27339kr(int i) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cyj != null) {
            this.cyj.onActivityResult(i, i2, intent);
        }
        if (this.cyi != null) {
            this.cyi.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.mo22815FX();
        super.onCreate(bundle);
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(23);
        if (!SDCardManager.hasSDCard()) {
            finish();
            return;
        }
        this.compositeDisposable = new C1494a();
        aec();
        C7125c.m21081r(this.cyl.aia());
        C8048e.aBe().mo23649dF(aee());
        String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
        StringBuilder sb = new StringBuilder();
        sb.append("passThroughUrl = ");
        sb.append(new Gson().toJson((Object) passThroughUrlFromIntent));
        LogUtilsV2.m14227d(sb.toString());
        this.cyn = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), EditorIntentInfo.class);
        boolean z = false;
        if (this.cyn != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("EditorIntentInfo = ");
            sb2.append(new Gson().toJson((Object) this.cyn));
            LogUtilsV2.m14227d(sb2.toString());
        } else {
            this.cyn = new EditorIntentInfo();
            this.cyn.baseMode = aeh();
            this.cyn.secondaryMode = -1;
            this.cyn.tabType = 0;
            this.cyn.paramMap = new HashMap<>();
            this.cyn.from = "";
        }
        this.cyt = this.cyn.baseMode;
        this.cyu = this.cyn.secondaryMode;
        C5843c.agO().mo28229eP(true);
        C5843c.agO().mo28235lT(this.cyt);
        C5843c agO = C5843c.agO();
        if (this.cyt == 2) {
            z = true;
        }
        agO.mo28231eR(z);
        aed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.cyi = null;
        this.cyj = null;
        this.cyk = null;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (C4580b.m11632Sf()) {
            return true;
        }
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.cym != null && this.cym.onBackPressed()) {
            return true;
        }
        if (this.cyj != null) {
            if (!this.cyj.onBackPressed()) {
                this.cyj.aeB();
                mo27769a(this.cyj, false);
            }
            return true;
        } else if (this.cyi != null && this.cyi.onBackPressed()) {
            return true;
        } else {
            if (this.cyk != null) {
                this.cyk.pause();
            }
            if (this.cym != null) {
                this.cym.aie();
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("onNewIntent intent passThroughURL= ");
        sb.append(passThroughUrlFromIntent);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("url = ");
        sb2.append(passThroughUrlFromIntent);
        C5523b.logException(new C5526d(sb2.toString()));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (aem()) {
            this.cyl.ahU();
        }
        if (isFinishing()) {
            if (this.compositeDisposable != null) {
                this.compositeDisposable.clear();
            }
            if (this.cyl != null) {
                this.cyl.detachView();
                this.cyl = null;
            }
            if (this.cym != null) {
                this.cym.detachView();
                this.cym = null;
            }
            C6293a.anj().unInit();
            aej();
            C5843c.agO().reset();
            C5843c.agO().mo28229eP(false);
            C7125c.destroy();
            C7129d.destroy();
            C6375c.asF().asG();
            C8539p.aJP();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.cyl != null) {
            this.cyl.adT();
        }
        if (this.bop) {
            mo27776eq(this.cyn != null && this.cyn.autoPlay);
            Bundle bundle = new Bundle();
            bundle.putString(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
            mo27774d(this.cyt, bundle);
            mo27767C(bundle);
            this.bop = false;
        }
    }
}
