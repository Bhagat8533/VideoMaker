package com.introvd.template.editor.export.p258a;

import android.widget.ImageView;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.utils.C8558m;
import p037b.p050b.C1834l;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.export.a.a */
public class C6227a extends BaseController<C6230b> {
    /* access modifiers changed from: private */
    public int cRl = 0;
    /* access modifiers changed from: private */
    public C1495b cRm;

    /* renamed from: a */
    public void attachView(C6230b bVar) {
        super.attachView(bVar);
    }

    /* renamed from: a */
    public void mo29128a(final C8380a aVar, final ImageView imageView) {
        C1834l.m5254a((C1839n<T>) new C1839n<String>() {
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00d0 A[Catch:{ Exception -> 0x0118 }] */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00e3 A[Catch:{ Exception -> 0x0118 }] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee A[Catch:{ Exception -> 0x0118 }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0114 A[Catch:{ Exception -> 0x0118 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo10177a(p037b.p050b.C1838m<java.lang.String> r11) throws java.lang.Exception {
                /*
                    r10 = this;
                    r0 = 0
                    com.introvd.template.sdk.a.a r1 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r1 = r1.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r1 = r1.strCoverURL     // Catch:{ Exception -> 0x0118 }
                    boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0118 }
                    if (r2 == 0) goto L_0x0017
                    com.introvd.template.sdk.a.a r1 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r1 = r1.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r1 = r1.strPrjURL     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r1 = com.introvd.template.editor.export.C6255i.m17930hF(r1)     // Catch:{ Exception -> 0x0118 }
                L_0x0017:
                    com.introvd.template.editor.export.a.a r2 = com.introvd.template.editor.export.p258a.C6227a.this     // Catch:{ Exception -> 0x0118 }
                    r3 = 0
                    r2.cRl = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r2 = r2.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    int r2 = r2.prjThemeType     // Catch:{ Exception -> 0x0118 }
                    boolean r2 = com.introvd.template.sdk.p391g.C8451b.m24477un(r2)     // Catch:{ Exception -> 0x0118 }
                    if (r2 == 0) goto L_0x004c
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.slide.b r2 = (com.introvd.template.sdk.slide.C8467b) r2     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.slideshowsession.QSlideShowSession r2 = r2.dfW     // Catch:{ Exception -> 0x0118 }
                    long r2 = r2.GetTheme()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.template.g.d r4 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r2 = r4.mo35225bB(r2)     // Catch:{ Exception -> 0x0118 }
                    boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0118 }
                    if (r3 == 0) goto L_0x0042
                    r1 = r0
                L_0x0042:
                    int r2 = com.introvd.template.sdk.p391g.C8450a.m24473nW(r2)     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.editor.export.a.a r3 = com.introvd.template.editor.export.p258a.C6227a.this     // Catch:{ Exception -> 0x0118 }
                    r3.cRl = r2     // Catch:{ Exception -> 0x0118 }
                    goto L_0x008b
                L_0x004c:
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.storyboard.QStoryboard r2 = r2.getStoryboard()     // Catch:{ Exception -> 0x0118 }
                    java.lang.Long r2 = com.introvd.template.sdk.utils.p394b.C8540q.m24894C(r2)     // Catch:{ Exception -> 0x0118 }
                    long r2 = r2.longValue()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.template.g.d r4 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r2 = r4.mo35225bB(r2)     // Catch:{ Exception -> 0x0118 }
                    int r2 = com.introvd.template.sdk.p391g.C8450a.m24473nW(r2)     // Catch:{ Exception -> 0x0118 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0118 }
                    r3.<init>()     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r4 = "loadTimePos="
                    r3.append(r4)     // Catch:{ Exception -> 0x0118 }
                    r3.append(r2)     // Catch:{ Exception -> 0x0118 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.common.LogUtilsV2.m14232v(r3)     // Catch:{ Exception -> 0x0118 }
                    if (r2 > 0) goto L_0x0086
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.storyboard.QStoryboard r2 = r2.getStoryboard()     // Catch:{ Exception -> 0x0118 }
                    int r2 = com.introvd.template.sdk.utils.C8572y.m25104x(r2)     // Catch:{ Exception -> 0x0118 }
                L_0x0086:
                    com.introvd.template.editor.export.a.a r3 = com.introvd.template.editor.export.p258a.C6227a.this     // Catch:{ Exception -> 0x0118 }
                    r3.cRl = r2     // Catch:{ Exception -> 0x0118 }
                L_0x008b:
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.storyboard.QStoryboard r2 = r2.getStoryboard()     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.clip.QClip r3 = r2.getDataClip()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r2 = r2.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    int r2 = r2.streamWidth     // Catch:{ Exception -> 0x0118 }
                    if (r2 == 0) goto L_0x00b8
                    com.introvd.template.sdk.a.a r2 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r2 = r2.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    int r2 = r2.streamHeight     // Catch:{ Exception -> 0x0118 }
                    if (r2 != 0) goto L_0x00a6
                    goto L_0x00b8
                L_0x00a6:
                    com.introvd.template.sdk.utils.VeMSize r2 = new com.introvd.template.sdk.utils.VeMSize     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.a.a r4 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r4 = r4.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    int r4 = r4.streamWidth     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.a.a r5 = r3     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.model.editor.DataItemProject r5 = r5.mProjectDataItem     // Catch:{ Exception -> 0x0118 }
                    int r5 = r5.streamHeight     // Catch:{ Exception -> 0x0118 }
                    r2.<init>(r4, r5)     // Catch:{ Exception -> 0x0118 }
                    goto L_0x00ca
                L_0x00b8:
                    com.introvd.template.common.model.AppStateModel r2 = com.introvd.template.common.model.AppStateModel.getInstance()     // Catch:{ Exception -> 0x0118 }
                    boolean r2 = r2.isCommunitySupport()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.a.a r4 = r3     // Catch:{ Exception -> 0x0118 }
                    xiaoying.engine.storyboard.QStoryboard r4 = r4.getStoryboard()     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.utils.VeMSize r2 = com.introvd.template.sdk.utils.p394b.C8540q.m24946d(r4, r2)     // Catch:{ Exception -> 0x0118 }
                L_0x00ca:
                    r4 = 480(0x1e0, float:6.73E-43)
                    r5 = 640(0x280, float:8.97E-43)
                    if (r2 == 0) goto L_0x00d4
                    int r4 = r2.width     // Catch:{ Exception -> 0x0118 }
                    int r5 = r2.height     // Catch:{ Exception -> 0x0118 }
                L_0x00d4:
                    int r2 = r4 >> 2
                    int r2 = r2 << 2
                    int r4 = r5 >> 2
                    int r4 = r4 << 2
                    int r5 = com.introvd.template.common.CpuFeatures.getCpuNumber()     // Catch:{ Exception -> 0x0118 }
                    r6 = 4
                    if (r5 >= r6) goto L_0x00ee
                    com.introvd.template.sdk.utils.VeMSize r2 = com.introvd.template.sdk.utils.C8572y.m25088dJ(r2, r4)     // Catch:{ Exception -> 0x0118 }
                    int r4 = r2.width     // Catch:{ Exception -> 0x0118 }
                    int r2 = r2.height     // Catch:{ Exception -> 0x0118 }
                L_0x00eb:
                    r6 = r2
                    r5 = r4
                    goto L_0x0103
                L_0x00ee:
                    com.introvd.template.sdk.utils.VeMSize r5 = new com.introvd.template.sdk.utils.VeMSize     // Catch:{ Exception -> 0x0118 }
                    r5.<init>(r2, r4)     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.utils.VeMSize r2 = new com.introvd.template.sdk.utils.VeMSize     // Catch:{ Exception -> 0x0118 }
                    r4 = 720(0x2d0, float:1.009E-42)
                    r2.<init>(r4, r4)     // Catch:{ Exception -> 0x0118 }
                    com.introvd.template.sdk.utils.VeMSize r2 = com.introvd.template.sdk.utils.C8572y.m25078b(r5, r2)     // Catch:{ Exception -> 0x0118 }
                    int r4 = r2.width     // Catch:{ Exception -> 0x0118 }
                    int r2 = r2.height     // Catch:{ Exception -> 0x0118 }
                    goto L_0x00eb
                L_0x0103:
                    com.introvd.template.editor.export.a.a r2 = com.introvd.template.editor.export.p258a.C6227a.this     // Catch:{ Exception -> 0x0118 }
                    int r4 = r2.cRl     // Catch:{ Exception -> 0x0118 }
                    r7 = 1
                    r8 = 0
                    r9 = 0
                    java.lang.Object r2 = com.introvd.template.sdk.utils.p394b.C8537n.m24793a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0118 }
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ Exception -> 0x0118 }
                    if (r2 == 0) goto L_0x0117
                    com.introvd.template.common.utils.UtilsBitmap.saveBitmap(r1, r2)     // Catch:{ Exception -> 0x0118 }
                L_0x0117:
                    r0 = r1
                L_0x0118:
                    r11.mo9791K(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.export.p258a.C6227a.C62292.mo10177a(b.b.m):void");
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<String>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C6227a.this.cRm = bVar;
            }

            /* renamed from: dA */
            public void mo9886K(String str) {
                if (aVar != null && FileUtils.isFileExisted(str)) {
                    try {
                        aVar.mProjectDataItem.strCoverURL = str;
                        aVar.mProjectDataItem.strExtra = C8558m.m25023k(aVar.mProjectDataItem.strExtra, (long) C6227a.this.cRl);
                        ((C6230b) C6227a.this.getMvpView()).mo29053a(imageView, str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    public void detachView() {
        super.detachView();
    }

    public void release() {
        if (this.cRm != null) {
            this.cRm.dispose();
        }
    }
}
