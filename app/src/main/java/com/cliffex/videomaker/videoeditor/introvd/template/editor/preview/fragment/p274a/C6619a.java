package com.introvd.template.editor.preview.fragment.p274a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1899e;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.threadpool.ThreadPoolWrapper;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.clipedit.C5695b;
import com.introvd.template.editor.common.model.ClipEditPanelStateModel;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6296a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.p261g.p262a.p263a.C6301a;
import com.introvd.template.editor.p261g.p262a.p263a.C6301a.C6303a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6489f;
import com.introvd.template.editor.player.p267a.C6491h;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.player.p269b.C6501c;
import com.introvd.template.editor.preview.view.C6686a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.utils.C8481a;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8518c;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p394b.p395a.C8508c;
import com.introvd.template.sdk.utils.p394b.p395a.C8509d;
import com.introvd.template.sdk.utils.p394b.p395a.C8512f;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.C1843r;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.preview.fragment.a.a */
public class C6619a extends BaseController<C6636b> {
    private static final String TAG = "a";
    /* access modifiers changed from: private */
    public C8509d cQp;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public C5686a cyD;
    /* access modifiers changed from: private */
    public C6499a daT;
    /* access modifiers changed from: private */
    public boolean dcn;
    /* access modifiers changed from: private */
    public C6686a dco;
    private C1890f dcp;
    private C1890f dcq;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dcr;
    private C8512f dcs = new C8512f() {
        public void ama() {
            C4597i.m11729b(false, ((C6636b) C6619a.this.getMvpView()).apz());
            C6619a.this.amI();
            C6619a.this.dcr.mo9791K(Boolean.valueOf(true));
            C6293a.anj().anm();
            C5695b.m15717aN(C6619a.this.context, "cancel");
        }

        public void apX() {
            int agQ = ((C6636b) C6619a.this.getMvpView()).agQ();
            ArrayList arrayList = new ArrayList();
            if (C6619a.this.cyD.adU()) {
                agQ--;
            }
            arrayList.add(Integer.valueOf(agQ));
            C6619a.this.m19230a(C6312c.CLIP_REVERSE, true, (List<Integer>) arrayList);
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            if (C6619a.this.dco != null) {
                C6619a.this.dco.setProgress((int) f);
            }
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            C8481a.m24576av(C6619a.this.context, str);
            C8481a.m24575a(C6619a.this.context, str, C8541r.m24979e(C6619a.this.cyD.adP(), str));
            if (C6619a.this.dco != null) {
                C6619a.this.dco.dismiss();
            }
            C6619a.this.amI();
            if (C6619a.this.cyD.adL() != null) {
                C6619a.this.cyD.adL().mo34669jt(true);
            }
            if (FileUtils.isFileExisted(str)) {
                int agQ = ((C6636b) C6619a.this.getMvpView()).agQ();
                QClip i = C8540q.m24956i(C6619a.this.cyD.adO(), agQ);
                if (i != null) {
                    i.setProperty(QClip.PROP_CLIP_REVERSE_SOURCE, str);
                    i.setProperty(QClip.PROP_CLIP_IS_REVERSE_MODE, Boolean.TRUE);
                    C8440a tX = C6619a.this.cyD.adQ().mo34307tX(agQ);
                    if (tX != null) {
                        C8518c.m24650a(i, tX);
                    }
                    C6619a.this.dcr.mo9791K(Boolean.valueOf(true));
                    ArrayList arrayList = new ArrayList();
                    if (C6619a.this.cyD.adU()) {
                        agQ--;
                    }
                    arrayList.add(Integer.valueOf(agQ));
                    C6619a.this.m19235a((List<Integer>) arrayList, i);
                    ToastUtils.shortShow(C6619a.this.context, R.string.xiaoying_str_ve_basic_reverse_suc_tip);
                    C5695b.m15717aN(C6619a.this.context, "done");
                    C6293a.anj().ann();
                    return;
                }
                return;
            }
            C6293a.anj().anm();
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            C4597i.m11729b(false, ((C6636b) C6619a.this.getMvpView()).apz());
            ToastUtils.shortShow(C6619a.this.context, R.string.xiaoying_str_ve_basic_reverse_fail_tip);
            if (C6619a.this.dco != null) {
                C6619a.this.dco.dismiss();
            }
            C6619a.this.amI();
            C6619a.this.dcr.mo9791K(Boolean.valueOf(true));
            C6293a.anj().anm();
            C5695b.m15717aN(C6619a.this.context, BannerJSAdapter.FAIL);
        }
    };

    public C6619a(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c2, code lost:
        com.introvd.template.common.LogUtils.m14222e(TAG, "onApplyPerformChanged:just rebuild player.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c9, code lost:
        r3.daT.mo29687cH(0, getPlayerInitTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001c, code lost:
        r4 = ((java.lang.Integer) r5.get(0)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
        if (r3.cyD.adU() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        m19235a(r5, com.introvd.template.sdk.utils.p394b.C8540q.m24956i(r3.cyD.adO(), r4));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m19229a(com.introvd.template.editor.p261g.p262a.C6307c r4, java.util.List<java.lang.Integer> r5) {
        /*
            r3 = this;
            int[] r0 = com.introvd.template.editor.preview.fragment.p274a.C6619a.C66295.dbS
            com.introvd.template.editor.g.c r1 = r4.anw()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = -1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x00ae;
                case 2: goto L_0x00a4;
                case 3: goto L_0x009a;
                case 4: goto L_0x009a;
                case 5: goto L_0x0080;
                case 6: goto L_0x0066;
                case 7: goto L_0x0055;
                case 8: goto L_0x004a;
                case 9: goto L_0x004a;
                case 10: goto L_0x004a;
                case 11: goto L_0x004a;
                case 12: goto L_0x003f;
                case 13: goto L_0x003f;
                case 14: goto L_0x0013;
                case 15: goto L_0x001c;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00c2
        L_0x0013:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.apx()
        L_0x001c:
            java.lang.Object r4 = r5.get(r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.introvd.template.editor.base.a r0 = r3.cyD
            boolean r0 = r0.adU()
            if (r0 == 0) goto L_0x0030
            int r4 = r4 + 1
        L_0x0030:
            com.introvd.template.editor.base.a r0 = r3.cyD
            xiaoying.engine.storyboard.QStoryboard r0 = r0.adO()
            xiaoying.engine.clip.QClip r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24956i(r0, r4)
            r3.m19235a(r5, r4)
            goto L_0x00c2
        L_0x003f:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29901oz(r1)
            goto L_0x00c9
        L_0x004a:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29930bl(r5)
            goto L_0x00c9
        L_0x0055:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            r4.aoe()
            com.introvd.template.editor.player.b.a r4 = r3.daT
            com.introvd.template.editor.base.a r5 = r3.cyD
            com.introvd.template.common.MSize r5 = r5.getStreamSize()
            r4.mo29688f(r5)
            goto L_0x00c9
        L_0x0066:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            r4.aoe()
            com.introvd.template.editor.player.b.a r4 = r3.daT
            com.introvd.template.editor.base.a r5 = r3.cyD
            com.introvd.template.common.MSize r5 = r5.getStreamSize()
            r4.mo29688f(r5)
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29901oz(r1)
            goto L_0x00c9
        L_0x0080:
            com.introvd.template.editor.g.a.a.a r4 = (com.introvd.template.editor.p261g.p262a.p263a.C6301a) r4
            int r5 = r4.anz()
            int r4 = r4.anA()
            if (r5 < 0) goto L_0x00c9
            if (r4 < 0) goto L_0x00c9
            if (r5 == r4) goto L_0x00c9
            com.introvd.template.common.controller.MvpView r0 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r0 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r0
            r0.mo29931cN(r5, r4)
            goto L_0x00c9
        L_0x009a:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.apy()
            goto L_0x00c9
        L_0x00a4:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29929bk(r5)
            goto L_0x00c9
        L_0x00ae:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r4.mo29936oE(r5)
            goto L_0x00c9
        L_0x00c2:
            java.lang.String r4 = TAG
            java.lang.String r5 = "onApplyPerformChanged:just rebuild player."
            com.introvd.template.common.LogUtils.m14222e(r4, r5)
        L_0x00c9:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            int r5 = r3.getPlayerInitTime()
            r4.mo29687cH(r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.fragment.p274a.C6619a.m19229a(com.introvd.template.editor.g.a.c, java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19230a(C6312c cVar, boolean z, List<Integer> list) {
        C6293a.anj().mo29237a(new C6303a().mo29263f(this.cyD.adK().aHf()).mo29262f(cVar).mo29264nK(0).mo29261bc(list).anB(), z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19235a(List<Integer> list, QClip qClip) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null && list != null && list.size() != 0) {
            int intValue = ((Integer) list.get(0)).intValue();
            if (this.cyD.adU()) {
                intValue++;
            }
            m19241b(qClip, intValue);
            bVar.apD();
        }
    }

    /* access modifiers changed from: private */
    public void amI() {
        if (this.cQp != null) {
            this.cQp.destroy();
            this.cQp.aJR();
            this.cQp = null;
        }
    }

    private void apV() {
        C6293a.anj().mo29234a((C6296a) new C6296a() {
            /* renamed from: a */
            public void mo27778a(boolean z, final C6307c cVar, final C6307c cVar2, boolean z2) {
                if (C6619a.this.getMvpView() != null) {
                    long j = 300;
                    if (z) {
                        if (cVar2 instanceof C6301a) {
                            final List aeK = ((C6301a) cVar2).aeK();
                            if (aeK != null && aeK.size() != 0) {
                                if (C6619a.this.daT != null) {
                                    C6619a.this.daT.setAutoPlayWhenReady(false);
                                }
                                boolean apB = ((C6636b) C6619a.this.getMvpView()).apB();
                                C1843r aUa = C1487a.aUa();
                                C66321 r4 = new Runnable() {
                                    public void run() {
                                        C6619a.this.m19229a(cVar2, aeK);
                                    }
                                };
                                if (apB) {
                                    j = 50;
                                }
                                C6619a.this.compositeDisposable.mo9785e(aUa.mo9777a(r4, j, TimeUnit.MILLISECONDS));
                            }
                        }
                    } else if (cVar instanceof C6301a) {
                        final List aeK2 = ((C6301a) cVar).aeK();
                        if (aeK2 != null && aeK2.size() != 0) {
                            if (C6619a.this.daT != null) {
                                C6619a.this.daT.setAutoPlayWhenReady(false);
                            }
                            boolean apB2 = ((C6636b) C6619a.this.getMvpView()).apB();
                            C1843r aUa2 = C1487a.aUa();
                            C66332 r42 = new Runnable() {
                                public void run() {
                                    C6619a.this.m19239b(cVar, aeK2);
                                }
                            };
                            if (apB2) {
                                j = 50;
                            }
                            C6619a.this.compositeDisposable.mo9785e(aUa2.mo9777a(r42, j, TimeUnit.MILLISECONDS));
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void apW() {
        C8522g adK = this.cyD.adK();
        C8420b adS = this.cyD.adS();
        QStoryboard adO = this.cyD.adO();
        if (adK != null) {
            DataItemProject aHe = adK.aHe();
            if (aHe != null && !aHe.isAdvBGMMode()) {
                C8540q.m24903L(adO);
                if (adS != null) {
                    adS.mo34145t(adO);
                    adS.mo34143b(adO, true);
                }
            } else if (adS != null) {
                adS.mo34145t(adO);
                adS.mo34143b(adO, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c6, code lost:
        com.introvd.template.common.LogUtils.m14222e(TAG, "onApplyPerformChanged:just rebuild player.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00cd, code lost:
        r3.daT.mo29687cH(0, getPlayerInitTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001c, code lost:
        r4 = ((java.lang.Integer) r5.get(0)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
        if (r3.cyD.adU() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        m19235a(r5, com.introvd.template.sdk.utils.p394b.C8540q.m24956i(r3.cyD.adO(), r4));
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m19239b(com.introvd.template.editor.p261g.p262a.C6307c r4, java.util.List<java.lang.Integer> r5) {
        /*
            r3 = this;
            int[] r0 = com.introvd.template.editor.preview.fragment.p274a.C6619a.C66295.dbS
            com.introvd.template.editor.g.c r1 = r4.anw()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = -1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x00a4;
                case 2: goto L_0x009a;
                case 3: goto L_0x0090;
                case 4: goto L_0x0090;
                case 5: goto L_0x0076;
                case 6: goto L_0x005c;
                case 7: goto L_0x004a;
                case 8: goto L_0x003f;
                case 9: goto L_0x003f;
                case 10: goto L_0x003f;
                case 11: goto L_0x003f;
                case 12: goto L_0x009a;
                case 13: goto L_0x009a;
                case 14: goto L_0x0013;
                case 15: goto L_0x001c;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00c6
        L_0x0013:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.apx()
        L_0x001c:
            java.lang.Object r4 = r5.get(r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.introvd.template.editor.base.a r0 = r3.cyD
            boolean r0 = r0.adU()
            if (r0 == 0) goto L_0x0030
            int r4 = r4 + 1
        L_0x0030:
            com.introvd.template.editor.base.a r0 = r3.cyD
            xiaoying.engine.storyboard.QStoryboard r0 = r0.adO()
            xiaoying.engine.clip.QClip r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24956i(r0, r4)
            r3.m19235a(r5, r4)
            goto L_0x00c6
        L_0x003f:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29930bl(r5)
            goto L_0x00cd
        L_0x004a:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            r4.aoe()
            com.introvd.template.editor.player.b.a r4 = r3.daT
            com.introvd.template.editor.base.a r5 = r3.cyD
            com.introvd.template.common.MSize r5 = r5.getStreamSize()
            r4.mo29688f(r5)
            goto L_0x00cd
        L_0x005c:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            r4.aoe()
            com.introvd.template.editor.player.b.a r4 = r3.daT
            com.introvd.template.editor.base.a r5 = r3.cyD
            com.introvd.template.common.MSize r5 = r5.getStreamSize()
            r4.mo29688f(r5)
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29901oz(r1)
            goto L_0x00cd
        L_0x0076:
            com.introvd.template.editor.g.a.a.a r4 = (com.introvd.template.editor.p261g.p262a.p263a.C6301a) r4
            int r5 = r4.anz()
            int r4 = r4.anA()
            if (r5 < 0) goto L_0x00cd
            if (r4 < 0) goto L_0x00cd
            if (r5 == r4) goto L_0x00cd
            com.introvd.template.common.controller.MvpView r0 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r0 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r0
            r0.mo29931cN(r4, r5)
            goto L_0x00cd
        L_0x0090:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.apy()
            goto L_0x00cd
        L_0x009a:
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29901oz(r1)
            goto L_0x00cd
        L_0x00a4:
            java.lang.Object r4 = r5.get(r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r4 = r4 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5.add(r4)
            com.introvd.template.common.controller.MvpView r4 = r3.getMvpView()
            com.introvd.template.editor.preview.fragment.a.b r4 = (com.introvd.template.editor.preview.fragment.p274a.C6636b) r4
            r4.mo29929bk(r5)
            goto L_0x00cd
        L_0x00c6:
            java.lang.String r4 = TAG
            java.lang.String r5 = "onApplyPerformChanged:just rebuild player."
            com.introvd.template.common.LogUtils.m14222e(r4, r5)
        L_0x00cd:
            com.introvd.template.editor.player.b.a r4 = r3.daT
            int r5 = r3.getPlayerInitTime()
            r4.mo29687cH(r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.fragment.p274a.C6619a.m19239b(com.introvd.template.editor.g.a.c, java.util.List):void");
    }

    /* renamed from: b */
    private void m19241b(QClip qClip, int i) {
        C8443d adQ = this.cyD.adQ();
        if (adQ != null) {
            C8440a tX = adQ.mo34307tX(i);
            if (tX != null) {
                if (!tX.aIa()) {
                    tX.mo34216a((QRange) qClip.getProperty(12292));
                } else {
                    tX.mo34236c((QRange) qClip.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE));
                }
            }
        }
    }

    /* renamed from: bn */
    private void m19242bn(List<Integer> list) {
        m19230a(C6312c.CLIP_ROTATE, false, list);
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            QStoryboard adO = this.cyD.adO();
            if (this.cyD.adU()) {
                intValue2++;
            }
            QClip i = C8540q.m24956i(adO, intValue2);
            if (i != null) {
                int intValue3 = (((Integer) i.getProperty(12315)).intValue() + 90) % 360;
                int property = i.setProperty(12315, Integer.valueOf(intValue3));
                this.cyD.adQ().mo34307tX(intValue2).mo34262tV(intValue3);
                if (property == 0) {
                    this.cyD.adL().mo34669jt(true);
                }
            }
        }
        if (this.cyD.adL().isProjectModified()) {
            this.dcr.mo9791K(Boolean.valueOf(true));
        }
        C5695b.m15718ew(this.context);
    }

    /* renamed from: bo */
    private void m19243bo(List<Integer> list) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null) {
            int intValue = ((Integer) list.get(0)).intValue();
            if (this.cyD.adU()) {
                intValue++;
            }
            QClip i = C8540q.m24956i(this.cyD.adO(), intValue);
            if (i != null) {
                ClipEditPanelStateModel a = C6386d.m18363a(this.cyD.adP(), i);
                if (a.isImageClip() || (i instanceof QSceneClip)) {
                    ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_image_cannot_reverse_tip);
                    return;
                }
                boolean z = !a.isbReversed();
                if (!z) {
                    m19230a(C6312c.CLIP_REVERSE, false, list);
                    if (this.cyD.adL() != null) {
                        this.cyD.adL().mo34669jt(true);
                    }
                    if (i.setProperty(QClip.PROP_CLIP_IS_REVERSE_MODE, Boolean.valueOf(z)) == 0) {
                        this.dcr.mo9791K(Boolean.valueOf(true));
                    }
                    m19235a(list, i);
                } else if (((Boolean) i.getProperty(QClip.PROP_CLIP_IS_REVERSE_CLIP)).booleanValue()) {
                    m19230a(C6312c.CLIP_REVERSE, true, list);
                    if (i.setProperty(QClip.PROP_CLIP_IS_REVERSE_MODE, Boolean.valueOf(!((Boolean) i.getProperty(QClip.PROP_CLIP_IS_REVERSE_MODE)).booleanValue())) == 0) {
                        if (this.cyD.adL() != null) {
                            this.cyD.adL().mo34669jt(true);
                        }
                        this.dcr.mo9791K(Boolean.valueOf(true));
                        ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_basic_reverse_suc_tip);
                        C5695b.m15717aN(this.context, "done");
                        m19235a(list, i);
                        C6293a.anj().ann();
                    } else {
                        C6293a.anj().anm();
                    }
                } else {
                    this.dco = new C6686a(bVar.apz());
                    this.dco.setOnDismissListener(new OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (C6619a.this.getMvpView() != null) {
                                if (C6619a.this.cQp != null) {
                                    C6619a.this.cQp.cancel();
                                }
                                C5695b.m15717aN(C6619a.this.context, "cancel");
                            }
                        }
                    });
                    this.dco.show();
                    QRange qRange = (QRange) i.getProperty(QClip.PROP_CLIP_SRC_RANGE);
                    QMediaSource qMediaSource = (QMediaSource) i.getProperty(12290);
                    if (!(qRange == null || qMediaSource == null || qMediaSource.getSourceType() != 0)) {
                        Object source = qMediaSource.getSource();
                        if (source != null) {
                            C4597i.m11729b(false, bVar.apz());
                            this.cQp = new C8509d(this.cyD.adP());
                            this.cQp.mo34671a((C8508c) this.dcs);
                            if (this.cQp.mo34689a(this.cyD.adK().aHe().strPrjURL, (String) source, qRange, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) != 0) {
                                this.dco.dismiss();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: bp */
    private void m19244bp(List<Integer> list) {
        if (list != null && list.size() != 0) {
            int intValue = ((Integer) list.get(0)).intValue();
            if (this.cyD.adU()) {
                intValue++;
            }
            QClip i = C8540q.m24956i(this.cyD.adO(), intValue);
            if (i != null) {
                ClipEditPanelStateModel a = C6386d.m18363a(this.cyD.adP(), i);
                if (a.isImageClip()) {
                    ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_mute_img_tip);
                } else {
                    m19251c(!a.isbAudioEnable(), list);
                }
            }
        }
    }

    /* renamed from: bq */
    private void m19245bq(List<Integer> list) {
        if (((C6636b) getMvpView()) != null && list != null && list.size() != 0) {
            int intValue = ((Integer) list.get(0)).intValue();
            if (this.cyD.adU()) {
                intValue++;
            }
            QClip i = C8540q.m24956i(this.cyD.adO(), intValue);
            if (i != null) {
                ClipEditPanelStateModel a = C6386d.m18363a(this.cyD.adP(), i);
                if (!a.isImageClip()) {
                    ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_animation_video_tip);
                    return;
                }
                boolean z = !a.isbAnimEnable();
                if (z) {
                    ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_animation_on_tip);
                } else {
                    ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_animation_off_tip);
                }
                C5554b.m15019a(this.context, z, true);
                ((C6636b) getMvpView()).mo29933gG(z);
                m19230a(C6312c.CLIP_PIC_ANIM, false, list);
                C6386d.m18366a(this.cyD.adO(), this.cyD.adU() ? intValue - 1 : intValue, a, z);
                this.cyD.adL().mo34669jt(true);
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(intValue), a);
                this.daT.mo29686b(new C6491h(14, hashMap));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bs */
    public void m19246bs(final List<Integer> list) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null && !this.dcn) {
            C4586g.m11703a((Context) bVar.apz(), R.string.xiaoying_str_com_loading, (OnCancelListener) null);
            C1834l.m5254a((C1839n<T>) new C1839n<List<Integer>>() {
                /* renamed from: a */
                public void mo10177a(C1838m<List<Integer>> mVar) {
                    C6619a.this.dcn = true;
                    mVar.mo9791K(C6619a.this.m19247bt(list));
                }
            }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<Integer>>() {
                /* renamed from: R */
                public void mo9886K(List<Integer> list) {
                    C6619a.this.dcn = false;
                    if (list == null || list.size() == list.size()) {
                        C4586g.m11695Sl();
                        return;
                    }
                    if (C6619a.this.cyD.adL() != null) {
                        C6619a.this.cyD.adL().mo34669jt(true);
                    }
                    if (C6619a.this.cyD.adO() == null || C6619a.this.cyD.adO().getClipCount() > 0) {
                        C6619a.this.apW();
                        if (list.size() > 0) {
                            list.removeAll(list);
                        }
                        ((C6636b) C6619a.this.getMvpView()).mo29929bk(list);
                        C6619a.this.dcr.mo9791K(Boolean.valueOf(true));
                        C4586g.m11695Sl();
                        return;
                    }
                    if (C6619a.this.cyD.adL().isProjectModified()) {
                        C6619a.this.cyD.adT();
                    }
                    C4586g.m11695Sl();
                }

                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    C6619a.this.dcn = false;
                    C4586g.m11695Sl();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bt */
    public List<Integer> m19247bt(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        m19230a(C6312c.CLIP_DELETE, false, list);
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (this.cyD.adU()) {
                intValue++;
            }
            C8443d adQ = this.cyD.adQ();
            if (C8540q.m24963n(this.cyD.adO(), intValue) != 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else {
                C8440a tX = adQ.mo34307tX(intValue);
                if (tX != null) {
                    final String aHU = tX.aHU();
                    final ContentResolver contentResolver = this.context.getContentResolver();
                    ThreadPoolWrapper.getIns().execute(new Runnable() {
                        public void run() {
                            C6619a.this.cyD.adK().mo34740a(aHU, false, contentResolver);
                        }
                    });
                }
                adQ.mo34309tZ(intValue);
                adQ.mo34297bN(intValue);
                C8517b.m24643a(adQ);
                adQ.aIl();
            }
        }
        return arrayList;
    }

    /* renamed from: bv */
    private void m19248bv(final List<Integer> list) {
        if (this.dcp != null && this.dcp.isShowing()) {
            this.dcp.dismiss();
        }
        this.dcp = new C1895a(((C6636b) getMvpView()).apz()).mo10288aA(false).mo10287a((CharSequence[]) new String[]{this.context.getString(R.string.xiaoying_str_ve_basic_clip_video_set_audio_open_op), this.context.getString(R.string.xiaoying_str_ve_basic_clip_video_set_mute_op)}).mo10280a((C1899e) new C1899e() {
            /* renamed from: a */
            public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                boolean z = true;
                if (i == 1) {
                    z = false;
                }
                C6619a.this.m19230a(C6312c.CLIP_MUTE, false, list);
                for (Integer intValue : list) {
                    C8540q.m24932a(C6619a.this.cyD.adO(), intValue.intValue(), Boolean.valueOf(z));
                }
                if (z) {
                    ToastUtils.shortShow(C6619a.this.context, R.string.xiaoying_str_ve_basic_clip_video_state_audio_open_tip);
                } else {
                    ToastUtils.shortShow(C6619a.this.context, R.string.xiaoying_str_ve_basic_clip_video_state_mute_tip);
                }
                C5695b.m15716aM(C6619a.this.context, z ? "mute off" : "mute on");
                C6619a.this.daT.mo29686b(new C6489f(5, z, list));
            }
        }).mo10313qu();
        this.dcp.show();
    }

    /* renamed from: bw */
    private void m19249bw(final List<Integer> list) {
        if (this.dcq != null && this.dcq.isShowing()) {
            this.dcq.dismiss();
        }
        this.dcq = new C1895a(((C6636b) getMvpView()).apz()).mo10288aA(false).mo10287a((CharSequence[]) new String[]{this.context.getString(R.string.xiaoying_str_ve_basic_clip_photo_set_photo_open_op), this.context.getString(R.string.xiaoying_str_ve_basic_clip_photo_set_photo_open_off)}).mo10280a((C1899e) new C1899e() {
            /* renamed from: a */
            public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                boolean z = true;
                if (i == 1) {
                    z = false;
                }
                C6619a.this.m19230a(C6312c.CLIP_PIC_ANIM, false, list);
                HashMap hashMap = new HashMap();
                for (Integer intValue : list) {
                    int intValue2 = intValue.intValue();
                    QStoryboard adO = C6619a.this.cyD.adO();
                    int i2 = C6619a.this.cyD.adU() ? intValue2 + 1 : intValue2;
                    QClip i3 = C8540q.m24956i(adO, i2);
                    if (i3 != null) {
                        ClipEditPanelStateModel a = C6386d.m18363a(C6619a.this.cyD.adP(), i3);
                        C6386d.m18366a(C6619a.this.cyD.adO(), intValue2, a, z);
                        hashMap.put(Integer.valueOf(i2), a);
                    }
                }
                if (z) {
                    ToastUtils.show(C6619a.this.context, R.string.xiaoying_str_ve_msg_basic_animation_on_tip, 0);
                } else {
                    ToastUtils.show(C6619a.this.context, R.string.xiaoying_str_ve_msg_basic_animation_off_tip, 0);
                }
                C5554b.m15019a(C6619a.this.context, z, false);
                C6619a.this.daT.mo29686b(new C6491h(14, hashMap));
            }
        }).mo10313qu();
        this.dcq.show();
    }

    /* renamed from: c */
    private void m19251c(boolean z, List<Integer> list) {
        if (((C6636b) getMvpView()) != null && list != null && list.size() != 0) {
            int intValue = ((Integer) list.get(0)).intValue();
            if (z) {
                ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_basic_clip_video_state_audio_open_tip);
            } else {
                ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_basic_clip_video_state_mute_tip);
            }
            C5695b.m15716aM(this.context, z ? "mute off" : "mute on");
            m19230a(C6312c.CLIP_MUTE, false, list);
            ((C6636b) getMvpView()).mo29932gF(z);
            C8540q.m24932a(this.cyD.adO(), intValue, Boolean.valueOf(z));
            this.cyD.adL().mo34669jt(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(intValue));
            this.daT.mo29686b(new C6489f(5, z, arrayList));
        }
    }

    /* renamed from: d */
    private void m19253d(boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        C6293a.anj().mo29237a(new C6303a().mo29263f(this.cyD.adK().aHf()).mo29262f(C6312c.CLIP_EXCHANGE).mo29264nK(0).mo29265nL(i).mo29266nM(i2).mo29261bc(arrayList).anB(), z);
    }

    /* access modifiers changed from: private */
    public int getPlayerInitTime() {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar == null) {
            return 0;
        }
        return C8540q.m24974v(this.cyD.adO(), bVar.agQ());
    }

    /* renamed from: oG */
    private void m19260oG(int i) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null && i >= 0) {
            this.daT.aoi();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            m19230a(C6312c.CLIP_DUPLICATE, false, (List<Integer>) arrayList);
            if (C8540q.m24967p(this.cyD.adO(), i)) {
                int i2 = this.cyD.adU() ? i + 2 : i + 1;
                C8443d adQ = this.cyD.adQ();
                C8440a tX = adQ.mo34307tX(this.cyD.adU() ? i + 1 : i);
                if (tX != null) {
                    final String aHU = tX.aHU();
                    final ContentResolver contentResolver = this.context.getContentResolver();
                    ThreadPoolWrapper.getIns().execute(new Runnable() {
                        public void run() {
                            C6619a.this.cyD.adK().mo34740a(aHU, true, contentResolver);
                        }
                    });
                    C8440a aVar = new C8440a(tX);
                    aVar.mo34253tM(i2);
                    adQ.mo34293a(aVar, i2);
                    C5695b.m15715aL(this.context, tX.isImage() ? "photo" : "video");
                }
                apW();
                this.cyD.adL().mo34669jt(true);
                this.dcr.mo9791K(Boolean.valueOf(true));
                ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_msg_basic_clip_copy_suc_tip);
                bVar.mo29936oE(i);
            }
        }
    }

    /* renamed from: a */
    public void mo29984a(C5686a aVar, C6499a aVar2) {
        this.cyD = aVar;
        this.daT = aVar2;
        this.compositeDisposable = new C1494a();
        this.compositeDisposable.mo9785e(C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                C6619a.this.dcr = mVar;
            }
        }).mo10157d(C1487a.aUa()).mo10151c(200, TimeUnit.MILLISECONDS, C1487a.aUa()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (C6619a.this.daT != null) {
                    C6619a.this.daT.mo29676a(C6619a.this.getPlayerInitTime(), new C6501c() {
                        /* renamed from: op */
                        public void mo29749op(int i) {
                            C6619a.this.daT.mo29697n(false, C6619a.this.getPlayerInitTime());
                        }
                    }, false);
                }
            }
        }));
        apV();
    }

    /* renamed from: a */
    public void attachView(C6636b bVar) {
        super.attachView(bVar);
    }

    /* renamed from: br */
    public void mo29986br(final List<Integer> list) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null) {
            int i = R.string.xiaoying_str_ve_clip_delete_ask;
            if (bVar.apA()) {
                i = R.string.xiaoying_str_ve_mul_op_del_tip;
            }
            C8978m.m26348af(bVar.apz(), this.context.getString(R.string.xiaoying_str_com_cancel), this.context.getString(R.string.xiaoying_str_com_ok)).mo10296do(i).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C6619a.this.m19246bs(list);
                }
            }).mo10290az(false).mo10313qu().show();
        }
    }

    /* renamed from: bu */
    public List<Integer> mo29987bu(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            QClip i2 = C8540q.m24956i(this.cyD.adO(), ((Integer) list.get(i)).intValue());
            if (i2 != null && !C6386d.m18363a(this.cyD.adP(), i2).isImageClip()) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    /* renamed from: cL */
    public boolean mo29988cL(int i, int i2) {
        if (this.cyD.adO() == null || this.cyD.adQ() == null) {
            return false;
        }
        m19253d(true, i, i2);
        if (this.cyD.adU()) {
            i++;
            i2++;
        }
        QStoryboard adO = this.cyD.adO();
        C8443d adQ = this.cyD.adQ();
        C8420b adS = this.cyD.adS();
        QClip i3 = C8540q.m24956i(adO, i);
        if (i3 == null || C8540q.m24938b(adO, i3, i2) != 0) {
            C6293a.anj().anm();
            return false;
        }
        adQ.mo34300dB(i, i2);
        adQ.mo34301dC(i, i2);
        adQ.aIl();
        DataItemProject aHe = this.cyD.adK().aHe();
        if (aHe == null || !aHe.isAdvBGMMode()) {
            C8540q.m24903L(adO);
            if (adS != null) {
                if (i <= i2) {
                    i = i2;
                }
                adS.mo34142a(adO, true, i);
            }
        } else if (adS != null) {
            if (i <= i2) {
                i = i2;
            }
            adS.mo34142a(adO, false, i);
        }
        this.cyD.adL().mo34669jt(true);
        C6293a.anj().ann();
        return true;
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: i */
    public void mo29989i(int i, List<Integer> list) {
        C6636b bVar = (C6636b) getMvpView();
        if (bVar != null) {
            if (list == null || list.size() == 0) {
                ToastUtils.shortShow(this.context, R.string.xiaoying_str_ve_clip_select_min_count_tip);
                return;
            }
            boolean z = false;
            if (i == 1003) {
                QClip i2 = C8540q.m24956i(this.cyD.adO(), bVar.agQ());
                if (i2 != null && C6386d.m18363a(this.cyD.adP(), i2).isImageClip()) {
                    z = true;
                }
                if (z) {
                    bVar.mo29934h(1014, list);
                } else {
                    bVar.mo29934h(i, list);
                }
            } else if (i != 1017) {
                switch (i) {
                    case 1007:
                        if (!((C6636b) getMvpView()).apA()) {
                            m19244bp(list);
                            break;
                        } else {
                            m19248bv(list);
                            break;
                        }
                    case 1008:
                        mo29986br(list);
                        break;
                    case 1009:
                        m19260oG(((Integer) list.get(0)).intValue());
                        break;
                    case 1010:
                        m19243bo(list);
                        break;
                    default:
                        switch (i) {
                            case 1012:
                                bVar.apC();
                                break;
                            case 1013:
                                m19242bn(list);
                                break;
                            default:
                                bVar.mo29934h(i, list);
                                break;
                        }
                }
            } else if (((C6636b) getMvpView()).apA()) {
                m19249bw(list);
            } else {
                m19245bq(list);
            }
        }
    }

    public void release() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        if (this.dco != null) {
            this.dco.dismiss();
            this.dco = null;
        }
        if (this.dcp != null) {
            this.dcp.dismiss();
            this.dcp = null;
        }
        if (this.dcq != null) {
            this.dcq.dismiss();
            this.dcq = null;
        }
        if (this.cQp != null) {
            amI();
        }
    }
}
