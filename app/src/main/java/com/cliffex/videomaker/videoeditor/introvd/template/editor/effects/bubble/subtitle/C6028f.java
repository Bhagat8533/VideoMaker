package com.introvd.template.editor.effects.bubble.subtitle;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.MSize;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.p266h.C6410o;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.f */
public class C6028f extends C5896a {
    private int cGR = -1;
    /* access modifiers changed from: private */
    public int cGS = 0;
    /* access modifiers changed from: private */
    public C8441b cGT;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private Context context;
    private C8533l cxv;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ScaleRotateViewState m17075a(boolean z, String str, ScaleRotateViewState scaleRotateViewState) {
        MSize surfaceSize = getSurfaceSize();
        ScaleRotateViewState c = C8538o.m24868c(adP(), str, new VeMSize(surfaceSize.width, surfaceSize.height));
        if (this.context != null && !c.bNeedTranslate) {
            c.setTextBubbleDftText(this.context.getResources().getString(R.string.viva_subtitle_default_title));
            if (scaleRotateViewState != null) {
                scaleRotateViewState.setTextBubbleDftText(this.context.getResources().getString(R.string.viva_subtitle_default_title));
            }
            c.setTextBubbleText(c.getTextBubbleDftText());
        }
        mo28458a(z, c, scaleRotateViewState);
        return c;
    }

    /* renamed from: a */
    public void mo28724a(ScaleRotateViewState scaleRotateViewState, String str, int i, int i2) {
        this.cGT = new C8441b();
        this.cGT.mo34280r(scaleRotateViewState);
        this.cGT.mo34279nG(str);
        this.cGT.mo34273b(new VeRange(i, i2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28725a(String str, ScaleRotateViewState scaleRotateViewState, boolean z, String str2) {
        if (!TextUtils.isEmpty(str)) {
            final boolean z2 = z;
            final String str3 = str;
            final ScaleRotateViewState scaleRotateViewState2 = scaleRotateViewState;
            final String str4 = str2;
            C60302 r1 = new C1839n<Range>() {
                /* renamed from: a */
                public void mo10177a(C1838m<Range> mVar) throws Exception {
                    ScaleRotateViewState a = C6028f.this.m17075a(z2, str3, scaleRotateViewState2);
                    if (a == null) {
                        mVar.mo9791K(null);
                        return;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        a.setFontPath(str4);
                    }
                    if (C8450a.m24466bk(C8762d.aMt().getTemplateID(str3))) {
                        a.setAnimOn(true);
                    } else {
                        a.setAnimOn(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_anim_style_open", true));
                    }
                    C6028f.this.mo28736g(a);
                    C6028f.this.cGS = C6028f.this.adZ();
                    if (!(C6028f.this.cGT == null || C6028f.this.cGT.aIc() == null)) {
                        C6028f.this.cGS = C6028f.this.cGT.aIc().getmPosition();
                    }
                    Range range = new Range(C6028f.this.cGS, C6028f.this.mo28477cu(C6028f.this.cGS, a.mMinDuration));
                    if (C6028f.this.mo28454a(C6028f.this.mo28455a(a, range)) == null) {
                        mVar.mo9791K(null);
                        return;
                    }
                    C6028f.this.mo28724a(a, str3, range.getmPosition(), range.getmTimeLength());
                    mVar.mo9791K(range);
                }
            };
            C1834l.m5254a((C1839n<T>) r1).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Range>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    C6028f.this.compositeDisposable.mo9785e(bVar);
                }

                /* renamed from: e */
                public void mo9886K(Range range) {
                    if (C6028f.this.cyg != null && range != null) {
                        C6028f.this.cyg.mo29678a(new C6485b(1, C6028f.this.aiA(), 3));
                        C6028f.this.mo27868b(range.getmPosition(), range.getmTimeLength(), true, range.getmPosition());
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28726a(int i, Range range, ArrayList<C8418a> arrayList) {
        if (range == null || this.cyg == null) {
            return false;
        }
        boolean b = mo28473b(i, range);
        boolean a = mo28463a(range, arrayList, this.cGR);
        if (b && a) {
            this.cyg.mo29678a(new C6485b(2, i, 3));
            mo27873h(0, adO().getDuration(), false);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28727a(int i, ScaleRotateViewState scaleRotateViewState, ArrayList<C8418a> arrayList) {
        if (i >= aiz().size() || i < 0) {
            return false;
        }
        C8441b bVar = (C8441b) aiz().get(i);
        if (scaleRotateViewState == null || getSurfaceSize() == null) {
            return false;
        }
        boolean a = mo28461a(i, mo28456a(scaleRotateViewState, bVar));
        boolean b = mo28474b(arrayList, this.cGR);
        if (!a || !b || this.cyg == null) {
            return false;
        }
        this.cyg.mo29678a(new C6485b(2, i, 3));
        this.cyg.mo29678a(new C6485b(4, i, 3));
        return true;
    }

    /* access modifiers changed from: 0000 */
    public int aiR() {
        return this.cGS;
    }

    public void aiS() {
        this.cGT = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo28730b(Point point) {
        return mo28452a(point, adZ());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ScaleRotateViewState mo28731b(boolean z, String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState a = m17075a(z, str, scaleRotateViewState);
        mo28736g(a);
        this.cGS = adZ();
        if (this.cGT != null) {
            this.cGS = this.cGT.aIc().getmPosition();
        }
        mo28724a(a, str, this.cGS, adO().getDuration() - this.cGS);
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo28732b(int i, ScaleRotateViewState scaleRotateViewState, ArrayList<C8418a> arrayList) {
        C8441b mg = mo28483mg(i);
        if (mg == null) {
            return false;
        }
        mo28481me(i);
        mg.mo34280r(scaleRotateViewState);
        mg.mo34279nG(scaleRotateViewState.mStylePath);
        mo28454a(mg);
        boolean cs = i != aiA() ? mo28475cs(aiA(), i) : true;
        mo28474b(arrayList, this.cGR);
        if (this.cyg == null || !cs) {
            return false;
        }
        mg.mo34280r(scaleRotateViewState);
        this.cyg.mo29678a(new C6485b(6, i, 3));
        this.cyg.mo29678a(new C6485b(4, i, 3));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ScaleRotateViewState mo28733c(String str, ScaleRotateViewState scaleRotateViewState) {
        MSize surfaceSize = getSurfaceSize();
        ScaleRotateViewState c = C8538o.m24868c(adP(), str, new VeMSize(surfaceSize.width, surfaceSize.height));
        c.setTextBubbleDftText(this.context.getResources().getString(R.string.viva_subtitle_default_title));
        if (scaleRotateViewState != null) {
            scaleRotateViewState.setTextBubbleDftText(this.context.getResources().getString(R.string.viva_subtitle_default_title));
        }
        mo28458a(false, c, scaleRotateViewState);
        mo28736g(c);
        return c;
    }

    /* renamed from: eE */
    public void mo28734eE(Context context2) {
        this.context = context2;
        this.cxv = new C8533l();
        this.cxv.mo34788b(new C6410o("", context2.getString(R.string.xiaoying_str_ve_prj_info_location_unknow), context2.getString(R.string.xiaoying_str_ve_default_nick_name)));
        this.compositeDisposable = new C1494a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C8441b mo28735f(ScaleRotateViewState scaleRotateViewState) {
        if (getSurfaceSize() == null || scaleRotateViewState == null || this.cyg == null) {
            return null;
        }
        if (C8450a.m24466bk(C8762d.aMt().getTemplateID(scaleRotateViewState.mStylePath))) {
            scaleRotateViewState.setAnimOn(true);
        } else {
            scaleRotateViewState.setAnimOn(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_anim_style_open", true));
        }
        C8441b a = mo28454a(mo28455a(scaleRotateViewState, new Range(aiR(), adO().getDuration() - aiR())));
        if (a == null) {
            return null;
        }
        this.cyg.mo29678a(new C6485b(1, aiA(), 20));
        mo27870ep(false);
        mo27868b(a.aIc().getmPosition(), a.aIc().getmTimeLength(), true, a.aIc().getmPosition());
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo28736g(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            String str = "";
            String textBubbleText = scaleRotateViewState.getTextBubbleText();
            if (this.cxv != null) {
                str = scaleRotateViewState.bNeedTranslate ? this.cxv.mo34790oN(textBubbleText) : textBubbleText;
            }
            scaleRotateViewState.setTextBubbleText(str);
            MSize surfaceSize = getSurfaceSize();
            C8530i.m24755a(scaleRotateViewState, scaleRotateViewState.mStylePath, new VeMSize(surfaceSize.width, surfaceSize.height));
            mo28462a(getCurrentEditEffectIndex(), scaleRotateViewState);
        }
    }

    /* access modifiers changed from: 0000 */
    public int getCurrentEditEffectIndex() {
        return this.cGR;
    }

    public int getGroupId() {
        return 3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mq */
    public void mo28738mq(int i) {
        this.cGR = i;
    }

    /* renamed from: mr */
    public void mo28739mr(int i) {
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(3, i, 3));
            mo28481me(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void release() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }
}
