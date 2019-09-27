package com.introvd.template.editor.preview.p270a;

import android.content.Context;
import android.graphics.Point;
import com.introvd.template.common.MSize;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.effects.p254b.C5911a;
import com.introvd.template.editor.effects.p254b.C5912b;
import com.introvd.template.editor.effects.p254b.C5915c;
import com.introvd.template.editor.effects.p254b.C5917d;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.p263a.C6301a.C6303a;
import com.introvd.template.editor.preview.C6521a;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.preview.a.b */
public class C6523b extends BaseController<C6522a> implements C5911a {
    private List<BaseItem> cRu = new ArrayList();
    private C5912b cRv;
    private List<C8441b> cRw = new ArrayList();
    private List<C8441b> cRx = new ArrayList();
    private int[] cRy = {20, 8, 6, 40};
    /* access modifiers changed from: private */
    public C6280b cYv;
    private C5686a cyD;
    /* access modifiers changed from: private */
    public C5688b daQ;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.editor.preview.a.b$a */
    class C6528a implements Comparator {
        C6528a() {
        }

        public int compare(Object obj, Object obj2) {
            return Float.compare(((C8441b) obj2).eee, ((C8441b) obj).eee);
        }
    }

    /* renamed from: a */
    private ArrayList<C8441b> m18913a(QStoryboard qStoryboard, MSize mSize, Point point, int i, int i2) {
        ArrayList<C8441b> arrayList = new ArrayList<>();
        if (qStoryboard == null || mSize == null) {
            return arrayList;
        }
        MSize surfaceSize = this.cyD.getSurfaceSize();
        VeMSize veMSize = null;
        if (surfaceSize != null) {
            veMSize = new VeMSize(surfaceSize.width, surfaceSize.height);
        }
        VeMSize veMSize2 = new VeMSize(mSize.width, mSize.height);
        ArrayList a = C8419a.m24325a(this.cyD.adO(), i2, veMSize);
        int size = a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C8441b bVar = (C8441b) a.get(i3);
            if (C8419a.m24326a(qStoryboard, bVar, point, i, veMSize2)) {
                if (i2 == 20 || i2 == 6 || i2 == 8 || i2 == 40) {
                    arrayList.add(bVar);
                } else if (i2 == 3) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void api() {
        if (this.cRu.size() == 1) {
            C6521a.m18905bD(this.mContext, "single");
            if (((C6522a) getMvpView()).getInterListener() != null) {
                int i = 0;
                C8441b bVar = (C8441b) ((BaseItem) this.cRu.get(0)).getItemData();
                int i2 = bVar.groupId;
                if (i2 == 20) {
                    i = 2001;
                } else if (i2 == 8) {
                    i = 2003;
                } else if (i2 == 6) {
                    i = 2004;
                } else if (i2 == 3) {
                    i = 2002;
                } else if (i2 == 40) {
                    i = EditorModes.EFFECT_MOSAIC_MODE;
                }
                ((C6522a) getMvpView()).getInterListener().mo29785cI(i, bVar.aId());
            }
        } else if (this.cRu.size() >= 2) {
            C6521a.m18905bD(this.mContext, "multiple");
            if (this.cRv == null) {
                this.cRv = new C5912b(this.mContext);
            }
            this.cRv.setData(this.cRu);
            this.cRv.showDialog();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        return false;
     */
    /* renamed from: bh */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m18917bh(java.util.List<com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel> r23) {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            com.introvd.template.editor.base.a r0 = r1.cyD     // Catch:{ all -> 0x00e4 }
            com.introvd.template.sdk.utils.b.g r0 = r0.adK()     // Catch:{ all -> 0x00e4 }
            com.introvd.template.editor.base.a r2 = r1.cyD     // Catch:{ all -> 0x00e4 }
            com.introvd.template.sdk.utils.b.a r10 = r2.adL()     // Catch:{ all -> 0x00e4 }
            com.introvd.template.editor.base.a r2 = r1.cyD     // Catch:{ all -> 0x00e4 }
            xiaoying.engine.storyboard.QStoryboard r11 = r2.adO()     // Catch:{ all -> 0x00e4 }
            com.introvd.template.editor.base.a r2 = r1.cyD     // Catch:{ all -> 0x00e4 }
            com.introvd.template.sdk.editor.b r12 = r2.adS()     // Catch:{ all -> 0x00e4 }
            r13 = 0
            if (r23 == 0) goto L_0x00e2
            if (r0 == 0) goto L_0x00e2
            if (r10 == 0) goto L_0x00e2
            if (r11 == 0) goto L_0x00e2
            if (r12 != 0) goto L_0x0028
            goto L_0x00e2
        L_0x0028:
            com.introvd.template.editor.common.c r3 = com.introvd.template.editor.common.C5843c.agO()     // Catch:{ all -> 0x00e4 }
            int r3 = r3.agQ()     // Catch:{ all -> 0x00e4 }
            com.introvd.template.editor.base.a r4 = r1.cyD     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4.adU()     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x003a
            int r3 = r3 + 1
        L_0x003a:
            java.util.Iterator r14 = r23.iterator()     // Catch:{ all -> 0x00e4 }
            r2 = 0
        L_0x003f:
            boolean r4 = r14.hasNext()     // Catch:{ all -> 0x00e4 }
            r15 = 1
            if (r4 == 0) goto L_0x00dd
            java.lang.Object r4 = r14.next()     // Catch:{ all -> 0x00e4 }
            r9 = r4
            com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel r9 = (com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel) r9     // Catch:{ all -> 0x00e4 }
            if (r9 == 0) goto L_0x003f
            java.lang.Boolean r4 = r9.isImage     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x00af
            r16 = r2
            r8 = 0
        L_0x005a:
            java.lang.Integer r2 = r9.repeatCount     // Catch:{ all -> 0x00e4 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00e4 }
            if (r8 >= r2) goto L_0x00ac
            java.lang.String r4 = r9.mExportPath     // Catch:{ all -> 0x00e4 }
            int r17 = r3 + 1
            r6 = -1
            r7 = -1
            java.lang.Integer r2 = r9.mRotate     // Catch:{ all -> 0x00e4 }
            int r18 = r2.intValue()     // Catch:{ all -> 0x00e4 }
            r19 = 1
            r2 = r0
            r3 = r4
            r4 = r10
            r5 = r17
            r20 = r8
            r8 = r18
            r21 = r9
            r9 = r19
            int r2 = r2.mo34725a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e4 }
            if (r2 != 0) goto L_0x009c
            com.introvd.template.sdk.model.editor.DataItemProject r2 = r0.aHe()     // Catch:{ all -> 0x00e4 }
            boolean r2 = r2.isAdvBGMMode()     // Catch:{ all -> 0x00e4 }
            if (r2 != 0) goto L_0x0094
            com.introvd.template.sdk.utils.p394b.C8540q.m24903L(r11)     // Catch:{ all -> 0x00e4 }
            r12.mo34143b(r11, r15)     // Catch:{ all -> 0x00e4 }
            goto L_0x0097
        L_0x0094:
            r12.mo34143b(r11, r13)     // Catch:{ all -> 0x00e4 }
        L_0x0097:
            r3 = r17
            r16 = 1
            goto L_0x00a7
        L_0x009c:
            int r17 = r17 + -1
            android.content.Context r2 = r1.mContext     // Catch:{ all -> 0x00e4 }
            int r3 = com.introvd.template.editor.R.string.xiaoying_str_ve_gallery_some_file_import_error     // Catch:{ all -> 0x00e4 }
            com.introvd.template.common.ToastUtils.show(r2, r3, r13)     // Catch:{ all -> 0x00e4 }
            r3 = r17
        L_0x00a7:
            int r8 = r20 + 1
            r9 = r21
            goto L_0x005a
        L_0x00ac:
            r2 = r16
            goto L_0x003f
        L_0x00af:
            r21 = r9
            int r3 = r3 + 1
            r4 = r21
            int r4 = r0.mo34724a(r4, r10, r3, r15)     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x00d2
            com.introvd.template.sdk.model.editor.DataItemProject r2 = r0.aHe()     // Catch:{ all -> 0x00e4 }
            boolean r2 = r2.isAdvBGMMode()     // Catch:{ all -> 0x00e4 }
            if (r2 != 0) goto L_0x00cc
            com.introvd.template.sdk.utils.p394b.C8540q.m24903L(r11)     // Catch:{ all -> 0x00e4 }
            r12.mo34143b(r11, r15)     // Catch:{ all -> 0x00e4 }
            goto L_0x00cf
        L_0x00cc:
            r12.mo34143b(r11, r13)     // Catch:{ all -> 0x00e4 }
        L_0x00cf:
            r2 = 1
            goto L_0x003f
        L_0x00d2:
            int r3 = r3 + -1
            android.content.Context r4 = r1.mContext     // Catch:{ all -> 0x00e4 }
            int r5 = com.introvd.template.editor.R.string.xiaoying_str_ve_gallery_some_file_import_error     // Catch:{ all -> 0x00e4 }
            com.introvd.template.common.ToastUtils.show(r4, r5, r13)     // Catch:{ all -> 0x00e4 }
            goto L_0x003f
        L_0x00dd:
            r10.mo34669jt(r15)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r22)
            return r2
        L_0x00e2:
            monitor-exit(r22)
            return r13
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r22)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.p270a.C6523b.m18917bh(java.util.List):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18918c(Point point) {
        this.cRu.clear();
        this.cRx.clear();
        this.cRw.clear();
        int agY = C5852d.agW().agY();
        for (int a : this.cRy) {
            this.cRx.addAll(m18913a(this.cyD.adO(), this.cyD.getSurfaceSize(), point, agY, a));
        }
        this.cRw.addAll(m18913a(this.cyD.adO(), this.cyD.getSurfaceSize(), point, agY, 3));
        C6528a aVar = new C6528a();
        Collections.sort(this.cRx, aVar);
        Collections.sort(this.cRw, aVar);
        if (this.cRw.size() > 0) {
            for (int i = 0; i < this.cRw.size(); i++) {
                C5917d dVar = new C5917d(this.mContext, (C8441b) this.cRw.get(i));
                dVar.mo28524a((C5911a) this);
                this.cRu.add(dVar);
            }
        }
        if (this.cRx.size() > 0) {
            for (int i2 = 0; i2 < this.cRx.size(); i2++) {
                C5915c cVar = new C5915c(this.mContext, (C8441b) this.cRx.get(i2));
                cVar.mo28522a((C5911a) this);
                this.cRu.add(cVar);
            }
        }
    }

    /* renamed from: a */
    public void mo29789a(Context context, C5686a aVar) {
        this.mContext = context;
        this.cyD = aVar;
    }

    /* renamed from: a */
    public void attachView(C6522a aVar) {
        super.attachView(aVar);
    }

    /* renamed from: b */
    public void mo29791b(C5688b bVar) {
        this.daQ = bVar;
    }

    /* renamed from: bg */
    public void mo29792bg(final List<TrimedClipItemDataModel> list) {
        if (list != null && list.size() != 0 && this.cyD != null) {
            final C8522g adK = this.cyD.adK();
            if (adK != null && adK.aHe() != null) {
                int agQ = C5843c.agO().agQ();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(agQ));
                C6293a.anj().mo29237a(new C6303a().mo29263f(this.cyD.adK().aHf()).mo29262f(C6312c.CLIP_ADD).mo29264nK(0).mo29261bc(arrayList).anB(), true);
                ((C6522a) getMvpView()).mo29778gu(true);
                C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
                    /* renamed from: a */
                    public void mo10177a(C1838m<Boolean> mVar) {
                        mVar.mo9791K(Boolean.valueOf(C6523b.this.m18917bh(list)));
                    }
                }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                    /* renamed from: a */
                    public void mo9877a(C1495b bVar) {
                    }

                    /* renamed from: b */
                    public void mo9886K(Boolean bool) {
                        C4586g.m11695Sl();
                        if (!bool.booleanValue()) {
                            C6293a.anj().anm();
                            ((C6522a) C6523b.this.getMvpView()).mo29777gt(false);
                            return;
                        }
                        adK.mo34723F(false, AppStateModel.getInstance().isCommunitySupport());
                        StoryboardOpService.savePrj(C6523b.this.mContext, adK.aHe().strPrjURL);
                        C6293a.anj().ann();
                        ((C6522a) C6523b.this.getMvpView()).mo29777gt(true);
                    }

                    public void onComplete() {
                    }

                    public void onError(Throwable th) {
                        C6293a.anj().anm();
                        ((C6522a) C6523b.this.getMvpView()).mo29777gt(false);
                    }
                });
            }
        }
    }

    /* renamed from: cB */
    public void mo28516cB(int i, int i2) {
        if (((C6522a) getMvpView()).getInterListener() != null) {
            this.cRv.dismiss();
            ((C6522a) getMvpView()).getInterListener().mo29785cI(i, i2);
        }
    }

    public void detachView() {
        super.detachView();
        if (this.cRv != null && this.cRv.isShowing()) {
            this.cRv.dismiss();
        }
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (C6523b.this.daQ != null) {
                    C6523b.this.daQ.mo27798a(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                C6523b.this.m18918c(point);
                C6523b.this.api();
                return false;
            }

            public boolean aet() {
                return ((C6522a) C6523b.this.getMvpView()).getCurrTabType() == 2 && C6523b.this.daQ != null && C6523b.this.daQ.aet();
            }

            public void aeu() {
                if (C6523b.this.daQ != null) {
                    C6523b.this.daQ.aeu();
                }
            }

            public int aev() {
                if (C6523b.this.daQ != null) {
                    return C6523b.this.daQ.aev();
                }
                return 0;
            }

            public void aew() {
                if (C6523b.this.daQ != null) {
                    C6523b.this.daQ.aew();
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (C6523b.this.daQ != null) {
                    return C6523b.this.daQ.mo27804hV(i);
                }
                return 0;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                if (C6523b.this.daQ != null) {
                    C6523b.this.daQ.mo27805lb(i);
                }
            }
        };
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                ((C6522a) C6523b.this.getMvpView()).mo29779os(i);
                if (C6523b.this.cYv != null) {
                    C6523b.this.cYv.mo27793J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                ((C6522a) C6523b.this.getMvpView()).mo29779os(i);
                if (C6523b.this.cYv != null) {
                    C6523b.this.cYv.mo27794K(i, z);
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                ((C6522a) C6523b.this.getMvpView()).mo29779os(i);
                if (C6523b.this.cYv != null) {
                    C6523b.this.cYv.mo27795L(i, z);
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                if (C6523b.this.cYv != null) {
                    C6523b.this.cYv.mo27796M(i, z);
                }
            }

            public void aes() {
                ((C6522a) C6523b.this.getMvpView()).aoN();
                if (C6523b.this.cYv != null) {
                    C6523b.this.cYv.aes();
                }
            }
        };
    }

    public void setPlayerStatusListener(C6280b bVar) {
        this.cYv = bVar;
    }
}
