package com.introvd.template.editor.preview.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.ColorfulSeekLayout;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6296a;
import com.introvd.template.editor.p261g.p262a.C6304b;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.preview.adapter.C6544d;
import com.introvd.template.editor.preview.adapter.C6544d.C6547b;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.preview.p271b.C6551b;
import com.introvd.template.editor.preview.p272c.C6555a;
import com.introvd.template.editor.provider.C6709d;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.editor.widget.timeline.C7125c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import xiaoying.engine.storyboard.QStoryboard;

public class EffectFragment extends BasePreviewFragment {
    /* access modifiers changed from: private */
    public ImageView cGi;
    /* access modifiers changed from: private */
    public int currentTime = 0;
    /* access modifiers changed from: private */
    public C5687a cyo = null;
    private C6709d dbH;
    /* access modifiers changed from: private */
    public ColorfulSeekLayout dbI;
    /* access modifiers changed from: private */
    public C6651b dbJ;
    /* access modifiers changed from: private */
    public C6651b dbK;
    private C6602a dbL = new C6602a(this, 0);
    private C6602a dbM = new C6602a(this, 1);
    /* access modifiers changed from: private */
    public boolean dbN = false;
    /* access modifiers changed from: private */
    public boolean dbO = false;
    /* access modifiers changed from: private */
    public boolean dbP = true;
    C7124b dbQ = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            return false;
        }

        public void acd() {
            if (EffectFragment.this.daT != null) {
                EffectFragment.this.daT.aeb();
            }
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            if (EffectFragment.this.daT != null) {
                EffectFragment.this.daT.mo29696kY(i);
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            if (EffectFragment.this.daT != null) {
                EffectFragment.this.daT.aoi();
                EffectFragment.this.daT.aea();
            }
            if (EffectFragment.this.dbK != null) {
                EffectFragment.this.dbK.hide();
            }
        }
    };
    private RecyclerView dbm;
    /* access modifiers changed from: private */
    public C6544d dbv;

    /* renamed from: com.introvd.template.editor.preview.fragment.EffectFragment$a */
    private static class C6602a implements Runnable {
        private WeakReference<EffectFragment> dbT;
        private int type;

        public C6602a(EffectFragment effectFragment, int i) {
            this.dbT = new WeakReference<>(effectFragment);
            this.type = i;
        }

        public void run() {
            EffectFragment effectFragment = (EffectFragment) this.dbT.get();
            if (effectFragment != null && !effectFragment.isDetached() && effectFragment.getContext() != null) {
                switch (this.type) {
                    case 0:
                        if (effectFragment.dbJ != null) {
                            effectFragment.dbJ.mo30034b(effectFragment.cGi, 11, effectFragment.getString(R.string.xiaoying_str_editor_clip_help_tip), false, C4583d.dpFloatToPixel(effectFragment.getActivity(), 0.0f), -C4583d.dpFloatToPixel(effectFragment.getActivity(), 15.0f));
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("clip_edit_help_show", true);
                            break;
                        }
                        break;
                    case 1:
                        if (effectFragment.dbK != null) {
                            effectFragment.dbK.mo30034b(effectFragment.dbI, 4, effectFragment.getString(R.string.xiaoying_str_editor_timeline_help_tip), false, 0, C4583d.dpFloatToPixel(effectFragment.getActivity(), 25.0f));
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("time_line_help_show", true);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public EffectFragment() {
        mo29900oy(2);
    }

    private void aom() {
        this.dbI = (ColorfulSeekLayout) this.btV.findViewById(R.id.effect_tool_ve_seek);
        this.cGi = (ImageView) this.dbI.findViewById(R.id.video_editor_effect_add_clip);
        this.dbI.mo28319a(this.cyD.adO(), this.cyD.getStreamSize());
        this.dbI.aiq();
        this.dbI.setOnOperationCallback(this.daT);
        this.dbI.mo28328b(this.cyo);
        this.dbI.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                if (EffectFragment.this.daT != null) {
                    EffectFragment.this.daT.aoh();
                }
            }

            public void pauseVideo() {
                if (EffectFragment.this.daT != null) {
                    EffectFragment.this.daT.aoi();
                }
            }
        });
        this.dbI.setOnAddClipBtnClickListener(new C2582a<View>() {
            public void onClick(View view) {
                if (EffectFragment.this.daU != null) {
                    EffectFragment.this.daU.aoQ();
                }
            }
        });
        this.dbI.setmOnTimeLineSeekListener(this.dbQ);
    }

    private void apG() {
        if (this.daU != null) {
            this.daU.mo29780a(new C6555a() {
                public void apa() {
                    super.apa();
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }

                /* renamed from: av */
                public void mo8049av(int i, int i2) {
                    super.mo8049av(i, i2);
                }

                /* renamed from: aw */
                public void mo8050aw(int i, int i2) {
                    super.mo8050aw(i, i2);
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }

                /* renamed from: ax */
                public void mo8051ax(int i, int i2) {
                    super.mo8051ax(i, i2);
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }

                /* renamed from: cJ */
                public void mo29866cJ(int i, int i2) {
                    super.mo29866cJ(i, i2);
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }

                /* renamed from: oF */
                public void mo29867oF(int i) {
                    super.mo29867oF(i);
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }

                public void onChanged() {
                    super.onChanged();
                    EffectFragment.this.dbO = true;
                    if (!EffectFragment.this.dbP) {
                        EffectFragment.this.apI();
                    }
                }
            });
        }
        C6293a.anj().mo29234a((C6296a) new C6296a() {
            /* renamed from: a */
            public void mo27778a(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
                if (z) {
                    if (cVar2 instanceof C6304b) {
                        EffectFragment.this.daT.mo29687cH(0, C5852d.agW().agY());
                        if (EffectFragment.this.dbI != null) {
                            EffectFragment.this.dbI.setQStoryboard(EffectFragment.this.cyD.adO());
                            EffectFragment.this.apJ();
                            EffectFragment.this.apH();
                        }
                    }
                } else if (cVar instanceof C6304b) {
                    EffectFragment.this.daT.mo29687cH(0, C5852d.agW().agY());
                    if (EffectFragment.this.dbI != null) {
                        EffectFragment.this.dbI.setQStoryboard(EffectFragment.this.cyD.adO());
                        EffectFragment.this.apJ();
                        EffectFragment.this.apH();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void apH() {
        if (this.dbv != null && this.cyD != null && this.cyD.adO() != null) {
            QStoryboard adO = this.cyD.adO();
            int j = C8540q.m24958j(adO, 3);
            int j2 = C8540q.m24958j(adO, 20);
            int j3 = C8540q.m24958j(adO, 8);
            int j4 = C8540q.m24958j(adO, 6);
            int j5 = C8540q.m24958j(adO, 40);
            boolean z = false;
            this.dbv.mo29850Y(2002, j > 0);
            this.dbv.mo29850Y(2001, j2 > 0);
            this.dbv.mo29850Y(2003, j3 > 0);
            this.dbv.mo29850Y(2004, j4 > 0);
            C6544d dVar = this.dbv;
            if (j5 > 0) {
                z = true;
            }
            dVar.mo29850Y(EditorModes.EFFECT_MOSAIC_MODE, z);
        }
    }

    /* access modifiers changed from: private */
    public void apI() {
        if (this.dbI != null && this.cyD != null && this.dbO) {
            C7125c.m21081r(this.cyD.adO());
            this.dbO = false;
            this.dbI.mo28319a(this.cyD.adO(), this.cyD.getStreamSize());
            this.dbI.aiq();
            this.dbI.air();
        }
    }

    /* access modifiers changed from: private */
    public void apJ() {
        if (this.dbI != null) {
            this.dbI.aiq();
            this.dbI.air();
        }
    }

    public static EffectFragment apK() {
        new Bundle();
        return new EffectFragment();
    }

    private ArrayList<Integer> apu() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!C2561a.aON()) {
            return arrayList;
        }
        arrayList.add(Integer.valueOf(2002));
        arrayList.add(Integer.valueOf(2003));
        arrayList.add(Integer.valueOf(2004));
        arrayList.add(Integer.valueOf(2005));
        arrayList.add(Integer.valueOf(2006));
        return arrayList;
    }

    private void apv() {
        if (this.cyD != null) {
            this.dbH = new C6709d(getContext(), this.cyD.adO(), apu());
            this.dbm = (RecyclerView) this.btV.findViewById(R.id.effect_tool_rcview);
            this.dbm.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.dbv = new C6544d(getContext());
            this.dbv.mo29853a((C6547b) new C6547b() {
                /* renamed from: nI */
                public void mo29860nI(int i) {
                    if (!C4580b.m11632Sf()) {
                        C5839a.m16326aT(EffectFragment.this.getContext(), EditorModes.getEditorModeName(i));
                        if (EffectFragment.this.dbI == null || EffectFragment.this.dbI.getDuration() - EffectFragment.this.dbI.getCurrentTime() >= 500 || i == 2008) {
                            if (i == 2004 && C5837a.agH().agK()) {
                                boolean z = false;
                                if (!(EffectFragment.this.cyD == null || EffectFragment.this.daT == null)) {
                                    z = C8538o.m24877h(EffectFragment.this.cyD.adO(), C5852d.agW().agY());
                                }
                                if (z) {
                                    ToastUtils.shortShow(EffectFragment.this.getContext(), R.string.editor_fx_add_in_same_time_pro);
                                    return;
                                }
                            }
                            if (i == 3) {
                                EffectFragment.this.mo29894c(EffectFragment.this.dbv.apg(), 1);
                            } else {
                                EffectFragment.this.daU.mo29788h(i, null);
                            }
                        } else {
                            ToastUtils.shortShow(EffectFragment.this.getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough);
                        }
                    }
                }
            });
            this.dbm.setAdapter(this.dbv);
            this.dbv.mo29858k(this.dbH.aqA());
            apG();
        }
    }

    /* renamed from: c */
    private boolean m19146c(C6307c cVar) {
        if (cVar == null) {
            return false;
        }
        ProjectItem anv = cVar.anv();
        ProjectItem ahP = this.cyD.adK().aHf();
        if (ahP == null || anv == null) {
            return false;
        }
        int d = m19148d(C6293a.anj().ank());
        MSize surfaceSize = this.cyD.getSurfaceSize();
        VeMSize veMSize = null;
        if (surfaceSize != null) {
            veMSize = new VeMSize(surfaceSize.width, surfaceSize.height);
        }
        ArrayList a = C8419a.m24325a(anv.mStoryBoard, d, veMSize);
        ArrayList a2 = C8419a.m24325a(ahP.mStoryBoard, d, veMSize);
        if (a == null || a2 == null) {
            return false;
        }
        if (a.size() == 0 && a2.size() == 0) {
            return false;
        }
        if (a.size() != a2.size()) {
            return true;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!((C8441b) a.get(i)).equals(a2.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private int m19148d(C6307c cVar) {
        int i = 0;
        if (cVar == null) {
            return 0;
        }
        switch (cVar.anw()) {
            case EFFECT_MUSIC:
                i = 1;
                break;
            case EFFECT_SUBTITLE:
                i = 3;
                break;
            case EFFECT_STICKER:
                i = 8;
                break;
            case EFFECT_PIP:
                i = 20;
                break;
            case EFFECT_FX:
                i = 6;
                break;
            case EFFECT_DUBBING:
                i = 4;
                break;
            case EFFECT_MOSAIC:
                i = 40;
                break;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29886a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.btV = layoutInflater.inflate(R.layout.editor_effect_fragment_layout, viewGroup, false);
    }

    public void apk() {
        if (this.dbv != null) {
            this.dbv.mo29858k(this.dbH.aqA());
        }
    }

    /* renamed from: gA */
    public void mo29895gA(boolean z) {
        super.mo29895gA(z);
        this.dbN = z;
        StringBuilder sb = new StringBuilder();
        sb.append("onSecondOpsViewAction show = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        if (!z) {
            if (m19146c(C6293a.anj().anl())) {
                C6293a.anj().ann();
            } else {
                C6293a.anj().anm();
            }
            apJ();
            apH();
            if (this.dbI != null) {
                this.dbI.mo28317L(this.currentTime, false);
            }
        }
    }

    /* renamed from: gB */
    public void mo29896gB(boolean z) {
        super.mo29896gB(z);
        if (z) {
            if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("clip_edit_help_show", false) && this.cGi != null) {
                this.cGi.postDelayed(this.dbL, 500);
            }
            if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("time_line_help_show", false) && this.dbI != null) {
                this.dbI.postDelayed(this.dbM, 500);
                return;
            }
            return;
        }
        if (this.dbJ != null) {
            this.dbJ.hide();
        }
        if (this.dbK != null) {
            this.dbK.hide();
        }
        if (this.cGi != null) {
            this.cGi.removeCallbacks(this.dbL);
            this.cGi.removeCallbacks(this.dbM);
        }
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                EffectFragment.this.cyo = aVar;
                if (EffectFragment.this.dbI != null) {
                    EffectFragment.this.dbI.mo28328b(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                return false;
            }

            public boolean aet() {
                return !EffectFragment.this.dbN && EffectFragment.this.dbI != null && EffectFragment.this.dbI.ait();
            }

            public void aeu() {
                if (EffectFragment.this.dbI != null && !EffectFragment.this.dbN) {
                    EffectFragment.this.dbI.aeu();
                }
            }

            public int aev() {
                if (EffectFragment.this.dbI == null) {
                    return 0;
                }
                return EffectFragment.this.dbI.aev();
            }

            public void aew() {
                if (EffectFragment.this.dbI != null) {
                    EffectFragment.this.dbI.aew();
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (EffectFragment.this.dbI == null) {
                    return 0;
                }
                return EffectFragment.this.dbI.mo28333hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                if (EffectFragment.this.dbI != null) {
                    EffectFragment.this.dbI.mo28334lb(i);
                }
            }
        };
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                EffectFragment.this.currentTime = i;
                if (EffectFragment.this.dbI != null) {
                    EffectFragment.this.dbI.mo28315J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                EffectFragment.this.currentTime = i;
                if (EffectFragment.this.dbI != null && !EffectFragment.this.dbP) {
                    EffectFragment.this.dbI.mo28316K(i, z);
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                EffectFragment.this.currentTime = i;
                if (EffectFragment.this.dbI != null && !EffectFragment.this.dbP) {
                    EffectFragment.this.dbI.mo28317L(i, z);
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                EffectFragment.this.currentTime = i;
                if (EffectFragment.this.dbI != null && !EffectFragment.this.dbP) {
                    EffectFragment.this.dbI.mo28318M(i, z);
                }
            }

            public void aes() {
            }
        };
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        apv();
        aom();
        this.dbJ = new C6651b(getActivity());
        this.dbK = new C6651b(getActivity());
        C10021c.aZH().mo38494ax(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.dbI != null) {
            this.dbI.destroy();
            this.dbI.mo28328b((C5687a) null);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        C10021c.aZH().mo38496az(this);
    }

    public void onDetach() {
        super.onDetach();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6551b bVar) {
        this.dbO = true;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.dbP = z;
        StringBuilder sb = new StringBuilder();
        sb.append("onHiddenChanged = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        apI();
        apH();
        if (this.dbI != null && !z) {
            this.dbI.mo28317L(this.currentTime, false);
        }
    }

    public void onResume() {
        super.onResume();
    }
}
