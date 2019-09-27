package com.introvd.template.editor.effects.collage;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import java.util.ArrayList;

/* renamed from: com.introvd.template.editor.effects.collage.a */
public class C6072a extends C5896a {
    private int cGR = -1;
    private int cGS = 0;
    private C8441b cGT;

    /* renamed from: a */
    private ScaleRotateViewState m17289a(String str, ScaleRotateViewState scaleRotateViewState, boolean z) {
        ScaleRotateViewState ha = m17290ha(str);
        if (z) {
            mo28458a(true, ha, scaleRotateViewState);
        }
        return ha;
    }

    /* renamed from: ha */
    private ScaleRotateViewState m17290ha(String str) {
        if (adP() == null || getSurfaceSize() == null) {
            return null;
        }
        try {
            ScaleRotateViewState a = C8530i.m24746a(adP(), str, new VeMSize(getSurfaceSize().width, getSurfaceSize().height));
            if (a == null) {
                ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
            }
            return a;
        } catch (Exception e) {
            C5523b.logException(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28795a(int i, Range range, ArrayList<C8418a> arrayList) {
        if (range == null || this.cyg == null) {
            return false;
        }
        boolean b = mo28473b(i, range);
        boolean a = mo28463a(range, arrayList, this.cGR);
        if (b && a) {
            this.cyg.mo29678a(new C6485b(2, i, 20));
            mo27873h(0, adO().getDuration(), false);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo28796a(int i, ScaleRotateViewState scaleRotateViewState, ArrayList<C8418a> arrayList) {
        C8441b mg = mo28483mg(i);
        if (scaleRotateViewState == null || getSurfaceSize() == null || mg == null || this.cyg == null) {
            return false;
        }
        boolean a = mo28461a(i, mo28456a(scaleRotateViewState, mg));
        boolean b = mo28474b(arrayList, this.cGR);
        if (!a || !b) {
            return false;
        }
        this.cyg.mo29678a(new C6485b(2, i, 20));
        this.cyg.mo29678a(new C6485b(4, i, 20));
        return true;
    }

    /* access modifiers changed from: 0000 */
    public int aiR() {
        return this.cGS;
    }

    /* access modifiers changed from: 0000 */
    public void aiS() {
        this.cGT = null;
    }

    /* renamed from: b */
    public int mo28799b(Point point) {
        return mo28452a(point, adZ());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C8441b mo28800b(String str, ScaleRotateViewState scaleRotateViewState, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ScaleRotateViewState a = m17289a(str, scaleRotateViewState, !(this.cGT == null || this.cGT.aIg() == null) || z);
        if (a == null) {
            return null;
        }
        this.cGS = adZ();
        if (this.cGT != null) {
            this.cGS = this.cGT.aIc().getmPosition();
        }
        C8441b a2 = mo28454a(mo28455a(a, new Range(this.cGS, mo28477cu(this.cGS, a.mMinDuration))));
        if (a2 == null) {
            return null;
        }
        this.cGT = new C8441b();
        this.cGT.mo34280r(a);
        this.cGT.mo34279nG(str);
        this.cGT.mo34273b(new VeRange(this.cGS, a2.aIc().getmTimeLength()));
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(1, aiA(), 20));
            LogUtils.m14222e("CollageSetRangeee", "previewGifEffect()");
            mo27868b(a2.aIc().getmPosition(), a2.aIc().getmTimeLength(), true, a2.aIc().getmPosition());
        }
        return a2;
    }

    /* renamed from: c */
    public ScaleRotateViewState mo28801c(String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState ha = m17290ha(str);
        mo28458a(true, ha, scaleRotateViewState);
        return ha;
    }

    /* renamed from: d */
    public ScaleRotateViewState mo28802d(String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState a = m17289a(str, scaleRotateViewState, (this.cGT == null || this.cGT.aIg() == null) ? false : true);
        this.cGS = adZ();
        if (this.cGT != null) {
            this.cGS = this.cGT.aIc().getmPosition();
        }
        this.cGT = new C8441b();
        this.cGT.mo34280r(a);
        this.cGT.mo34279nG(str);
        this.cGT.mo34273b(new VeRange(this.cGS, adO().getDuration() - this.cGS));
        return a;
    }

    /* renamed from: f */
    public C8441b mo28803f(ScaleRotateViewState scaleRotateViewState) {
        if (getSurfaceSize() == null || scaleRotateViewState == null) {
            return null;
        }
        C8441b a = mo28454a(mo28455a(scaleRotateViewState, new Range(aiR(), adO().getDuration() - aiR())));
        if (a == null) {
            return null;
        }
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(1, aiA(), 20));
            LogUtils.m14222e("CollageSetRangeee", "addEffect()");
            mo27868b(a.aIc().getmPosition(), a.aIc().getmTimeLength(), true, a.aIc().getmPosition());
            mo27870ep(false);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gZ */
    public ScaleRotateViewState mo28804gZ(String str) {
        return m17290ha(str);
    }

    public int getCurrentEditEffectIndex() {
        return this.cGR;
    }

    public int getGroupId() {
        return 20;
    }

    /* renamed from: mq */
    public void mo28806mq(int i) {
        this.cGR = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mr */
    public void mo28807mr(int i) {
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(3, i, 20));
            mo28481me(i);
        }
    }
}
