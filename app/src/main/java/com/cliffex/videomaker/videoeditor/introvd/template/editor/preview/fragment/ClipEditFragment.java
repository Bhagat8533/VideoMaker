package com.introvd.template.editor.preview.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.Vibrator;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.p031a.C1072a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.bumptech.glide.C2176e;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.C5695b;
import com.introvd.template.editor.clipedit.transition.C5803c;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.SmoothLayoutManager;
import com.introvd.template.editor.common.model.ClipEditPanelStateModel;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.p263a.C6301a.C6303a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p269b.C6501c;
import com.introvd.template.editor.preview.C6521a;
import com.introvd.template.editor.preview.adapter.C6529a;
import com.introvd.template.editor.preview.adapter.C6532c;
import com.introvd.template.editor.preview.adapter.C6532c.C6543b;
import com.introvd.template.editor.preview.adapter.C6544d;
import com.introvd.template.editor.preview.adapter.C6544d.C6547b;
import com.introvd.template.editor.preview.adapter.C6548e;
import com.introvd.template.editor.preview.clipsort.C6562b;
import com.introvd.template.editor.preview.fragment.p274a.C6619a;
import com.introvd.template.editor.preview.fragment.p274a.C6636b;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.editor.preview.p271b.C6551b;
import com.introvd.template.editor.preview.p272c.C6555a;
import com.introvd.template.editor.preview.view.EditorSelectAllView;
import com.introvd.template.editor.preview.view.EditorSelectAllView.C6685a;
import com.introvd.template.editor.provider.C6707b;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.p415a.C8986a;
import com.introvd.template.p414ui.view.p415a.C8986a.C8989c;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.utils.C8500b;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p408f.C8750d;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QSceneClip;

public class ClipEditFragment extends BasePreviewFragment implements C6636b {
    /* access modifiers changed from: private */
    public C6651b cFW;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private C6548e day = new C6548e() {
        /* renamed from: d */
        public Bitmap mo29861d(ImageView imageView, int i) {
            return ClipEditFragment.this.m19099e(imageView, i);
        }
    };
    /* access modifiers changed from: private */
    public RecyclerView dbm;
    /* access modifiers changed from: private */
    public RecyclerView dbn;
    /* access modifiers changed from: private */
    public RelativeLayout dbo;
    /* access modifiers changed from: private */
    public ImageButton dbp;
    /* access modifiers changed from: private */
    public View dbq;
    /* access modifiers changed from: private */
    public EditorSelectAllView dbr;
    /* access modifiers changed from: private */
    public C6592a dbs = new C6592a(this);
    /* access modifiers changed from: private */
    public C6619a dbt;
    private C6707b dbu;
    private C6544d dbv;
    /* access modifiers changed from: private */
    public C6532c dbw;
    private C8986a dbx;
    private boolean dby = false;
    private boolean dbz = false;

    /* renamed from: com.introvd.template.editor.preview.fragment.ClipEditFragment$a */
    private static class C6592a extends WeakHandler<ClipEditFragment> {
        C6592a(ClipEditFragment clipEditFragment) {
            super(clipEditFragment);
        }

        public void handleMessage(Message message) {
            ClipEditFragment clipEditFragment = (ClipEditFragment) getOwner();
            if (clipEditFragment != null) {
                switch (message.what) {
                    case 4097:
                        if (clipEditFragment.dbw != null) {
                            clipEditFragment.dbw.mo29813W(message.arg1, false);
                            if (!clipEditFragment.dbw.apb()) {
                                clipEditFragment.apE();
                                clipEditFragment.apy();
                                break;
                            }
                        }
                        break;
                    case 4098:
                        if (!(clipEditFragment.cFW == null || clipEditFragment.dbp == null)) {
                            clipEditFragment.cFW.mo30034b(clipEditFragment.dbp, 5, clipEditFragment.getResources().getString(R.string.xiaoying_str_editor_clip_help_tip), C4580b.m11666qi(), C7689a.m22597aR(5.0f), C7689a.m22599ii(5));
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("clip_edit_help_show", true);
                            break;
                        }
                }
            }
        }
    }

    public ClipEditFragment() {
        mo29900oy(1);
        this.compositeDisposable = new C1494a();
    }

    /* renamed from: a */
    private ClipItemInfo m19089a(int i, C8440a aVar) {
        ClipItemInfo clipItemInfo = new ClipItemInfo();
        clipItemInfo.state = 0;
        Bitmap aHM = aVar.aHM();
        if (aHM != null) {
            clipItemInfo.bmpThumbnail = aHM;
        }
        boolean jM = C8750d.m25573jM(aVar.aHU());
        clipItemInfo.isImage = aVar.isImage();
        clipItemInfo.isGif = jM;
        clipItemInfo.lDuration = (long) aVar.aHV();
        clipItemInfo.bAudioEnable = !aVar.isImage();
        clipItemInfo.lTransDuration = (long) aVar.aHO();
        QClip i2 = C8540q.m24956i(this.cyD.adO(), i);
        if (i2 != null) {
            clipItemInfo.bAudioOn = !C8537n.m24837p(i2);
        }
        return clipItemInfo;
    }

    private void afu() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                ClipEditFragment.this.compositeDisposable.mo9785e(bVar);
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (ClipEditFragment.this.daU != null) {
                    EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(ClipEditFragment.this.daU.aoR(), EditorIntentInfo.class);
                    if (editorIntentInfo != null && !TextUtils.isEmpty((String) editorIntentInfo.paramMap.get(EditorRouter.KEY_PARAMS_CLIP_REVERSE)) && ClipEditFragment.this.dbt != null) {
                        ClipEditFragment.this.mo29935nI(1010);
                    }
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void apE() {
        if (this.dbw != null && this.dbv != null) {
            boolean z = false;
            if (this.dbw.apb()) {
                List apd = this.dbw.apd();
                this.dbv.mo29851Z(1011, !apd.contains(Integer.valueOf(this.dbw.getItemCount() - 1)) || apd.size() > 1);
            } else if (this.dbw.getItemCount() <= 1 || this.dbw.getFocusIndex() == this.dbw.getItemCount() - 1) {
                this.dbv.mo29851Z(1011, false);
            } else {
                this.dbv.mo29851Z(1011, true);
            }
            this.dbv.mo29851Z(1012, this.dbw.getItemCount() > 1);
            QClip i = C8540q.m24956i(this.cyD.adO(), agQ());
            if (i != null) {
                boolean isImageClip = C6386d.m18363a(this.cyD.adP(), i).isImageClip();
                boolean z2 = i instanceof QSceneClip;
                this.dbv.mo29851Z(1010, !isImageClip && !z2);
                this.dbv.mo29851Z(1005, !isImageClip);
                this.dbv.mo29851Z(1007, !isImageClip);
                C6544d dVar = this.dbv;
                if (!z2) {
                    z = true;
                }
                dVar.mo29851Z(1006, z);
                this.dbv.mo29851Z(1017, isImageClip);
                this.dbv.mo29851Z(1004, !isImageClip);
                this.dbv.mo29855b(1003, isImageClip ? getString(R.string.xiaoying_str_ve_img_duration_title) : getString(R.string.xiaoying_str_ve_basic_trim_title), isImageClip ? R.drawable.editor_icon_pic_trim : R.drawable.editor_icon_trim_tool);
                this.dbv.mo29851Z(1019, !isImageClip);
            }
        }
    }

    public static ClipEditFragment apF() {
        new Bundle();
        return new ClipEditFragment();
    }

    private ArrayList<Integer> apu() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!C2561a.aON()) {
            return arrayList;
        }
        arrayList.add(Integer.valueOf(1001));
        arrayList.add(Integer.valueOf(1003));
        arrayList.add(Integer.valueOf(1004));
        arrayList.add(Integer.valueOf(1005));
        arrayList.add(Integer.valueOf(1007));
        arrayList.add(Integer.valueOf(1008));
        arrayList.add(Integer.valueOf(1009));
        arrayList.add(Integer.valueOf(1010));
        arrayList.add(Integer.valueOf(1011));
        arrayList.add(Integer.valueOf(1012));
        arrayList.add(Integer.valueOf(1013));
        arrayList.add(Integer.valueOf(1014));
        return arrayList;
    }

    private void apv() {
        if (getContext() != null) {
            this.dbm = (RecyclerView) this.btV.findViewById(R.id.clipedit_tool_rcview);
            this.dbm.setLayoutManager(new SmoothLayoutManager(getContext(), 0, false));
            this.dbv = new C6544d(getContext());
            this.dbv.mo29853a((C6547b) new C6547b() {
                /* renamed from: nI */
                public void mo29860nI(int i) {
                    if (!C4580b.m11632Sf() && ClipEditFragment.this.dbw != null && ClipEditFragment.this.getContext() != null && ClipEditFragment.this.apz() != null && !ClipEditFragment.this.apz().isFinishing()) {
                        ClipEditFragment.this.m19110oC(i);
                    }
                }
            });
            this.dbm.setAdapter(this.dbv);
            this.dbv.mo29858k(this.dbu.mo30176gV(false));
        }
    }

    private void apw() {
        this.dbn = (RecyclerView) this.btV.findViewById(R.id.clipedit_clip_rcview);
        this.dbn.setLayoutManager(new SmoothLayoutManager(getContext(), 0, false));
        this.dbn.mo7733a((C1018h) new C6529a(C8500b.m24591P(15.0f)));
        if (this.dbw == null) {
            this.dbw = new C6532c(getContext());
        }
        this.dbw.mo29818a(this.day);
        this.dbn.setAdapter(this.dbw);
        this.dbn.mo7737a((C1022l) new C1022l() {
            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                super.mo8096d(recyclerView, i);
                if (ClipEditFragment.this.getContext() != null && ClipEditFragment.this.apz() != null && !ClipEditFragment.this.apz().isFinishing()) {
                    if (i == 0) {
                        C2176e.m6137am(ClipEditFragment.this.getContext()).mo12204tO();
                    } else {
                        C2176e.m6137am(ClipEditFragment.this.getContext()).mo12203tN();
                    }
                }
            }
        });
        this.dbx = new C8986a(this.dbw, true);
        this.dbx.mo35758a(new C8989c() {
            /* renamed from: D */
            public void mo29870D(View view, int i) {
                if (ClipEditFragment.this.dbw != null) {
                    ClipEditFragment.this.dbw.mo29827c(true, -1, -1);
                }
                if (ClipEditFragment.this.dbo != null) {
                    C4562a.m11537ca(ClipEditFragment.this.dbo);
                }
                C2564c.m7323a(view, null);
                Vibrator vibrator = (Vibrator) view.getContext().getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(100);
                }
            }

            /* renamed from: cM */
            public void mo29871cM(int i, int i2) {
                if (ClipEditFragment.this.dbw != null) {
                    ClipEditFragment.this.dbw.mo29827c(false, i, i2);
                    if (ClipEditFragment.this.dbw.getFocusIndex() != i2) {
                        ClipEditFragment.this.dbw.mo29813W(i2, false);
                    }
                }
                if (ClipEditFragment.this.dbo != null) {
                    C4562a.m11535bZ(ClipEditFragment.this.dbo);
                }
                if (i != i2 && ClipEditFragment.this.isAdded() && ClipEditFragment.this.apz() != null && !ClipEditFragment.this.apz().isFinishing()) {
                    C5695b.m15719n(ClipEditFragment.this.getContext(), String.valueOf(Math.abs(i - i2)), "list");
                    if (ClipEditFragment.this.dbw != null) {
                        ClipEditFragment.this.dbw.mo29828cJ(i, i2);
                    }
                    boolean cL = ClipEditFragment.this.dbt.mo29988cL(i, i2);
                    ClipEditFragment.this.apE();
                    if (cL && ClipEditFragment.this.daT != null) {
                        final int v = C8540q.m24974v(ClipEditFragment.this.cyD.adO(), ClipEditFragment.this.agQ());
                        ClipEditFragment.this.daT.mo29676a(v, new C6501c() {
                            /* renamed from: op */
                            public void mo29749op(int i) {
                                ClipEditFragment.this.daT.mo29697n(false, v);
                            }
                        }, false);
                    }
                }
            }
        });
        new C1072a(this.dbx).mo8593a(this.dbn);
        this.dbw.mo29817a((C6543b) new C6543b() {
            /* renamed from: X */
            public void mo29844X(int i, boolean z) {
                if (ClipEditFragment.this.daT != null) {
                    ClipEditFragment.this.daT.mo29675H(C8540q.m24974v(ClipEditFragment.this.cyD.adO(), ClipEditFragment.this.m19109ld(i)), false);
                }
                List apd = ClipEditFragment.this.dbw.apd();
                if (ClipEditFragment.this.dbr != null) {
                    if (apd.size() == ClipEditFragment.this.dbw.getItemCount()) {
                        ClipEditFragment.this.dbr.mo30085gU(true);
                    } else {
                        ClipEditFragment.this.dbr.mo30085gU(false);
                    }
                }
                ClipEditFragment.this.m19095bj(apd);
            }

            public void apf() {
                ClipEditFragment.this.m19103gH(true);
            }

            /* renamed from: ot */
            public void mo29846ot(int i) {
                if (ClipEditFragment.this.daT != null) {
                    ClipEditFragment.this.daT.mo29675H(C8540q.m24974v(ClipEditFragment.this.cyD.adO(), ClipEditFragment.this.m19109ld(i)), false);
                }
                if (ClipEditFragment.this.dbw != null && !ClipEditFragment.this.dbw.apb()) {
                    if (i == ClipEditFragment.this.dbw.getItemCount() - 1) {
                        ClipEditFragment.this.apE();
                    }
                    ClipEditFragment.this.apy();
                }
            }

            /* renamed from: ou */
            public void mo29847ou(int i) {
                if (!ClipEditFragment.this.dbn.mo7832lm()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i));
                    ClipEditFragment.this.dbt.mo29986br(arrayList);
                }
            }

            /* renamed from: ov */
            public void mo29848ov(final int i) {
                if (ClipEditFragment.this.daU != null) {
                    if (ClipEditFragment.this.dbs != null) {
                        ClipEditFragment.this.dbs.postDelayed(new Runnable() {
                            public void run() {
                                ClipEditFragment.this.dbw.mo29813W(i, true);
                            }
                        }, 600);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i));
                    ClipEditFragment.this.daU.mo29788h(1011, arrayList);
                    C5803c.m16155a(ClipEditFragment.this.getContext(), 0, "trans_icon");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bj */
    public void m19095bj(List<Integer> list) {
        int i;
        int i2;
        boolean z = true;
        this.dbv.mo29851Z(1011, !list.contains(Integer.valueOf(this.dbw.getItemCount() - 1)) || list.size() > 1);
        if (list.size() > 0) {
            i2 = 0;
            i = 0;
            for (Integer intValue : list) {
                QClip i3 = C8540q.m24956i(this.cyD.adO(), intValue.intValue());
                if (i3 != null) {
                    if (C6386d.m18363a(this.cyD.adP(), i3).isImageClip()) {
                        i++;
                    } else {
                        i2++;
                    }
                }
            }
        } else {
            i2 = 0;
            i = 0;
        }
        boolean z2 = i2 > 0 || (i2 == 0 && i == 0);
        this.dbv.mo29851Z(1005, z2);
        this.dbv.mo29851Z(1007, z2);
        C6544d dVar = this.dbv;
        if (i <= 0 && !(i2 == 0 && i == 0)) {
            z = false;
        }
        dVar.mo29851Z(1017, z);
    }

    /* renamed from: d */
    private void m19098d(ViewGroup viewGroup, boolean z) {
        if (this.dbq == null) {
            this.dbq = LayoutInflater.from(getContext()).inflate(R.layout.editor_clip_edit_multi_bottom_layout, null);
        }
        if (this.dbr == null) {
            this.dbr = new EditorSelectAllView(getContext());
            this.dbr.setListener(new C6685a() {
                /* renamed from: gI */
                public void mo29945gI(boolean z) {
                    if (ClipEditFragment.this.dbw != null) {
                        ClipEditFragment.this.dbw.mo29831gv(z);
                        ArrayList arrayList = new ArrayList();
                        if (z) {
                            int itemCount = ClipEditFragment.this.dbw.getItemCount();
                            if (itemCount > 0) {
                                for (int i = 0; i < itemCount; i++) {
                                    arrayList.add(Integer.valueOf(i));
                                }
                            }
                        }
                        ClipEditFragment.this.m19095bj(arrayList);
                    }
                    C6521a.m18902I(ClipEditFragment.this.getContext(), z);
                }
            });
        }
        this.dbp.setVisibility(z ? 8 : 0);
        if (z) {
            if (viewGroup.indexOfChild(this.dbq) == -1) {
                LayoutParams layoutParams = new LayoutParams(-1, C8500b.m24591P(44.0f));
                layoutParams.addRule(12);
                viewGroup.addView(this.dbq, layoutParams);
                this.dbq.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        ClipEditFragment.this.m19103gH(false);
                    }
                });
            }
            this.dbq.setVisibility(0);
            C2564c.m7322a(this.dbq, (float) C8500b.m24591P(44.0f), 0.0f, new C2569a() {
                public void onFinish() {
                    ClipEditFragment.this.m19095bj(ClipEditFragment.this.dbw.apd());
                }
            });
            if (viewGroup.indexOfChild(this.dbr) == -1) {
                LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                layoutParams2.addRule(11);
                layoutParams2.bottomMargin = C8500b.m24590O(getContext(), 220);
                layoutParams2.rightMargin = C8500b.m24590O(getContext(), 15);
                viewGroup.addView(this.dbr, layoutParams2);
            }
            this.dbr.show();
            return;
        }
        C2564c.m7324b(this.dbq, 0.0f, (float) C8500b.m24591P(44.0f), new C2569a() {
            public void onFinish() {
                ClipEditFragment.this.dbq.setVisibility(8);
                ClipEditFragment.this.dbw.mo29832gw(false);
                ClipEditFragment.this.apE();
                ClipEditFragment.this.apy();
            }
        });
        this.dbr.hide(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Bitmap m19099e(ImageView imageView, int i) {
        int i2;
        if (this.cyD == null || this.cyD.adQ() == null) {
            return null;
        }
        try {
            int ld = m19109ld(i);
            int dimension = (int) getResources().getDimension(R.dimen.xiaoying_glide_clip_thumb_length);
            C8440a tX = this.cyD.adQ().mo34307tX(ld);
            int i3 = tX.aHT().get(0);
            int i4 = tX.edJ.get(0);
            int aHX = tX.aHX();
            int i5 = -1;
            if (!tX.aIa() || tX.aHZ() == null) {
                i2 = -1;
            } else {
                int i6 = tX.aHZ().get(0);
                i5 = i6;
                i2 = tX.aHZ().get(1) + i6;
            }
            C6562b bVar = new C6562b(ld, tX.aHU(), i3, i4, aHX, i5, i2, this.cyD.adO(), tX.isClipReverse());
            if (apz() != null) {
                C2570b.m7336hy(getActivity().getApplicationContext()).mo12209w(bVar).mo12869dX(dimension, dimension).mo12186g(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: gH */
    public void m19103gH(boolean z) {
        C5843c.agO().mo28230eQ(z);
        if (!z) {
            String str = "VE_Mutiple_Mode_Clip_Click_Exit";
            if (this.dby) {
                str = "VE_Mutiple_Mode_Icon_Exit";
            }
            C6521a.m18908i(getContext(), str, this.dbz);
            this.dby = false;
            this.dbz = false;
        }
        if (this.dbv != null) {
            this.dbv.mo29858k(this.dbu.mo30176gV(z));
        }
        if (this.daU != null) {
            this.dbs.postDelayed(new Runnable() {
                public void run() {
                    ClipEditFragment.this.dbm.smoothScrollToPosition(0);
                }
            }, 300);
            m19098d(this.daU.aoP(), z);
        }
        this.dbx.mo35759jL(!z);
        if (this.daT != null) {
            this.daT.aof();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ld */
    public int m19109ld(int i) {
        return (this.cyD == null || !this.cyD.adU()) ? i : i + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: oC */
    public void m19110oC(int i) {
        C5839a.m16328aV(getContext(), EditorModes.getEditorModeName(i));
        if (this.daT != null) {
            this.daT.aoi();
        }
        if (i == 3) {
            mo29894c(this.dbv.apg(), 0);
        } else if (i == 1018) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.dbw.getFocusIndex()));
            C6293a.anj().mo29237a(new C6303a().mo29263f(this.cyD.adK().aHf()).mo29262f(C6312c.CLIP_ORDER).mo29264nK(0).mo29261bc(arrayList).anB(), true);
            EditorRouter.launchClipSortActivity(apz());
        } else {
            if (this.dbw.apb()) {
                C5839a.m16327aU(getContext(), EditorModes.getEditorModeName(i));
            } else {
                C5839a.m16325aS(getContext(), EditorModes.getEditorModeName(i));
            }
            if (i == 1011) {
                C5803c.m16155a(getContext(), 0, "toolbar");
            }
            List apd = this.dbw.apd();
            if (this.dbw.apb() && apd.size() > 0 && i == 1005) {
                apd = this.dbt.mo29987bu(apd);
            }
            this.dbt.mo29989i(i, apd);
            if (1013 == i) {
                this.dbw.notifyItemChanged(this.dbw.getFocusIndex());
                this.dbw.apa();
            }
        }
    }

    /* renamed from: oD */
    private void m19111oD(int i) {
        if (apA()) {
            m19103gH(false);
        }
        if (this.cyD != null) {
            C8443d adQ = this.cyD.adQ();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < adQ.getCount(); i2++) {
                C8440a tX = adQ.mo34307tX(i2);
                if (tX != null && !tX.isCover()) {
                    arrayList.add(m19089a(i2, tX));
                }
            }
            if (i < 0 || i >= arrayList.size()) {
                i = 0;
            }
            if (arrayList.size() > 1) {
                ((ClipItemInfo) arrayList.get(i)).state = 0;
                ((ClipItemInfo) arrayList.get(i)).bFocus = true;
            } else if (arrayList.size() == 1) {
                ((ClipItemInfo) arrayList.get(i)).state = 0;
                ((ClipItemInfo) arrayList.get(i)).bFocus = true;
            }
            this.dbw.mo29825bd(arrayList);
            apE();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29886a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.btV = layoutInflater.inflate(R.layout.editor_clip_edit_fragment_layout, viewGroup, false);
    }

    /* renamed from: a */
    public void mo29888a(C6555a aVar) {
        if (this.dbw != null) {
            this.dbw.mo29824b(aVar);
        }
    }

    public boolean aeL() {
        return this.dbw != null && this.dbw.getItemCount() > 1 && !this.dbw.apb();
    }

    public void aeU() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        if (this.dbt == null) {
            this.dbt = new C6619a(getContext());
            this.dbt.attachView((C6636b) this);
            this.dbt.mo29984a(this.cyD, this.daT);
        }
        if (this.dbw == null && this.daU != null) {
            this.dbw = new C6532c(this.daU.getActivity());
        }
    }

    public int agQ() {
        return m19109ld(this.dbw != null ? this.dbw.getFocusIndex() : 0);
    }

    public boolean apA() {
        return this.dbw != null && this.dbw.apb();
    }

    public boolean apB() {
        if (!apA()) {
            return false;
        }
        m19103gH(false);
        return true;
    }

    public void apC() {
        if (!this.dbw.apb()) {
            this.dby = true;
            C6521a.m18906bE(getContext(), "tool icon click");
            this.dbw.apc();
        }
    }

    public void apD() {
        if (this.dbw != null) {
            this.dbw.notifyItemChanged(agQ());
        }
    }

    public void apk() {
        if (this.dbv != null) {
            this.dbv.mo29858k(this.dbu.mo30176gV(false));
        }
    }

    public void apx() {
        if (this.dbw != null) {
            this.dbw.notifyItemChanged(this.dbw.getFocusIndex());
            this.dbw.apa();
        }
    }

    public void apy() {
        QClip i = C8540q.m24956i(this.cyD.adO(), agQ());
        if (i != null) {
            ClipEditPanelStateModel a = C6386d.m18363a(this.cyD.adP(), i);
            if (!a.isImageClip()) {
                mo29932gF(a.isbAudioEnable());
            } else {
                mo29933gG(a.isbAnimEnable());
            }
        }
    }

    public Activity apz() {
        return getActivity();
    }

    /* renamed from: bi */
    public void mo29893bi(List<Integer> list) {
        if (!this.dbw.apb()) {
            apE();
        }
        int focusIndex = this.dbw.getFocusIndex();
        if (list != null && list.size() != 0 && !list.contains(Integer.valueOf(focusIndex))) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                linkedHashMap.put(Integer.valueOf(intValue2), Integer.valueOf(Math.abs(intValue2 - focusIndex)));
            }
            Object[] array = linkedHashMap.values().toArray();
            Arrays.sort(array);
            int intValue3 = ((Integer) list.get(0)).intValue();
            Iterator it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int intValue4 = ((Integer) it.next()).intValue();
                if (intValue4 == ((Integer) array[0]).intValue()) {
                    intValue3 = intValue4;
                    break;
                }
            }
            this.dbs.removeMessages(4097);
            this.dbs.sendMessageDelayed(this.dbs.obtainMessage(4097, intValue3, 0), 20);
        }
    }

    /* renamed from: bk */
    public void mo29929bk(List<Integer> list) {
        if (list.size() > 1) {
            Collections.sort(list, new Comparator<Integer>() {
                /* renamed from: a */
                public int compare(Integer num, Integer num2) {
                    return num.compareTo(num2);
                }
            });
            this.dbw.mo29826be(list);
        } else if (list.size() == 1) {
            this.dbw.removeItem(((Integer) list.get(0)).intValue());
            apE();
        }
        if (this.daU != null) {
            this.daU.aoS();
        }
    }

    /* renamed from: bl */
    public void mo29930bl(List<Integer> list) {
        if (this.dbw != null && list != null && list.size() != 0) {
            if (list.size() == this.dbw.getItemCount()) {
                mo29901oz(-1);
                return;
            }
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                C8440a tX = this.cyD.adQ().mo34307tX(intValue2);
                if (tX != null && !tX.isCover()) {
                    ClipItemInfo a = m19089a(intValue2, tX);
                    if (this.cyD.adU()) {
                        intValue2--;
                    }
                    this.dbw.mo29823b(intValue2, a);
                }
            }
        }
    }

    /* renamed from: cN */
    public void mo29931cN(final int i, final int i2) {
        if (this.dbw != null) {
            this.dbw.mo28031cp(i, i2);
            this.dbn.postDelayed(new Runnable() {
                public void run() {
                    ClipEditFragment.this.dbw.mo29829cK(i, i2);
                    ClipEditFragment.this.dbw.mo29828cJ(i, i2);
                    ClipEditFragment.this.apE();
                }
            }, 300);
        }
    }

    /* renamed from: gA */
    public void mo29895gA(boolean z) {
        super.mo29895gA(z);
        if (z) {
            if (this.dbr != null) {
                this.dbr.hide(false);
            }
        } else if (C5843c.agO().agT() && this.dbr != null) {
            this.dbr.show();
        }
    }

    /* renamed from: gB */
    public void mo29896gB(boolean z) {
        super.mo29896gB(z);
        if (!z) {
            if (this.cFW != null) {
                this.cFW.hide();
            }
            this.dbs.removeMessages(4098);
        } else if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("clip_edit_help_show", false)) {
            this.dbs.sendEmptyMessageDelayed(4098, 500);
        }
    }

    /* renamed from: gF */
    public void mo29932gF(boolean z) {
        if (this.dbv != null && this.dbw != null && !this.dbw.apb()) {
            this.dbv.mo29856gx(z);
        }
    }

    /* renamed from: gG */
    public void mo29933gG(boolean z) {
        if (this.dbv != null && this.dbw != null && !this.dbw.apb()) {
            this.dbv.mo29857gy(z);
        }
    }

    /* renamed from: h */
    public void mo29934h(int i, List<Integer> list) {
        if (apA()) {
            this.dbz = true;
        }
        if (this.daU != null) {
            this.daU.mo29788h(i, list);
        }
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        this.dbo = (RelativeLayout) this.btV.findViewById(R.id.rl_clip_add);
        this.dbp = (ImageButton) this.btV.findViewById(R.id.clipedit_add_btn);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                if (ClipEditFragment.this.daU != null) {
                    ClipEditFragment.this.daU.aoQ();
                }
            }
        }, this.dbp);
        this.dbu = new C6707b(getContext(), apu());
        apw();
        apv();
        m19111oD(0);
        if (this.dbt != null) {
            QClip i = C8540q.m24956i(this.cyD.adO(), agQ());
            if (i != null) {
                ClipEditPanelStateModel a = C6386d.m18363a(this.cyD.adP(), i);
                if (a.isImageClip()) {
                    this.dbv.mo29851Z(1004, false);
                    mo29933gG(a.isbAnimEnable());
                } else {
                    this.dbv.mo29851Z(1017, false);
                }
                mo29932gF(a.isbAudioEnable());
            }
        }
        this.cFW = new C6651b(apz());
        afu();
    }

    /* renamed from: nI */
    public void mo29935nI(int i) {
        if (i == 1010) {
            if (this.daT != null) {
                this.daT.aoi();
            }
            this.dbt.mo29989i(1010, this.dbw.apd());
        }
    }

    /* renamed from: oE */
    public void mo29936oE(int i) {
        int ld = m19109ld(i);
        C8440a tX = this.cyD.adQ().mo34307tX(ld + 1);
        if (tX != null) {
            ClipItemInfo a = m19089a(ld, tX);
            if (this.cyD.adU()) {
                ld--;
            }
            this.dbw.mo29814a(ld + 1, a);
        }
        apE();
    }

    public boolean onBackPressed() {
        if (!this.dbw.apb()) {
            return super.onBackPressed();
        }
        m19103gH(false);
        return true;
    }

    public void onDetach() {
        super.onDetach();
        C10021c.aZH().mo38496az(this);
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        if (this.dbw != null) {
            this.dbw.release();
        }
        if (this.dbt != null) {
            this.dbt.detachView();
        }
        if (this.dbs != null) {
            this.dbs.removeCallbacksAndMessages(null);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6550a aVar) {
        switch (aVar.getEventType()) {
            case 1:
                mo29930bl(aVar.aox());
                return;
            case 2:
                m19111oD(this.dbw.getFocusIndex());
                return;
            default:
                return;
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6551b bVar) {
        if (this.dbw != null) {
            m19111oD(this.dbw.getFocusIndex());
        }
    }

    public void onPause() {
        super.onPause();
        if (apz() != null && apz().isFinishing() && this.dbt != null) {
            this.dbt.release();
        }
    }

    /* renamed from: oz */
    public void mo29901oz(int i) {
        if (this.dbw != null) {
            if (i < 0) {
                i = this.dbw.getFocusIndex();
            }
            m19111oD(i);
            apE();
        }
    }
}
