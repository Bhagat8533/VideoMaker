package com.introvd.template.editor.effects.bubble.sticker;

import android.content.Context;
import android.graphics.Point;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import java.util.ArrayList;

/* renamed from: com.introvd.template.editor.effects.bubble.sticker.b */
public class C5963b extends C5896a {
    private int cGR = -1;
    private int cGS = 0;
    private C8441b cGT;

    /* renamed from: ha */
    private ScaleRotateViewState m16754ha(String str) {
        if (adP() == null || getSurfaceSize() == null) {
            return null;
        }
        try {
            ScaleRotateViewState b = C8530i.m24759b(adP(), str, new VeMSize(getSurfaceSize().width, getSurfaceSize().height));
            if (b == null) {
                ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
            }
            return b;
        } catch (Exception e) {
            C5523b.logException(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ScaleRotateViewState mo28594a(String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState b = mo28600b(str, scaleRotateViewState);
        this.cGS = adZ();
        if (this.cGT != null) {
            this.cGS = this.cGT.aIc().getmPosition();
        }
        this.cGT = new C8441b();
        this.cGT.mo34280r(b);
        this.cGT.mo34279nG(str);
        this.cGT.mo34273b(new VeRange(this.cGS, adO().getDuration() - this.cGS));
        return b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28595a(int i, Range range, ArrayList<C8418a> arrayList) {
        if (range == null || this.cyg == null) {
            return false;
        }
        boolean b = mo28473b(i, range);
        boolean a = mo28463a(range, arrayList, this.cGR);
        if (b && a) {
            this.cyg.mo29678a(new C6485b(2, i, 8));
            mo27873h(0, adO().getDuration(), false);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo28596a(int i, ScaleRotateViewState scaleRotateViewState, C6499a aVar, ArrayList<C8418a> arrayList) {
        if (i >= aiz().size() || i < 0) {
            return false;
        }
        C8441b mg = mo28483mg(i);
        if (scaleRotateViewState == null || getSurfaceSize() == null || mg == null) {
            return false;
        }
        boolean a = mo28461a(i, mo28456a(scaleRotateViewState, mg));
        boolean b = mo28474b(arrayList, this.cGR);
        if (!a || !b) {
            return false;
        }
        aVar.mo29678a(new C6485b(2, i, 8));
        aVar.mo29678a(new C6485b(4, i, 8));
        return true;
    }

    public int aiR() {
        return this.cGS;
    }

    /* access modifiers changed from: 0000 */
    public void aiS() {
        this.cGT = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo28599b(Point point) {
        return mo28452a(point, adZ());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ScaleRotateViewState mo28600b(String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState ha = m16754ha(str);
        if (!(this.cGT == null || this.cGT.aIg() == null)) {
            mo28458a(true, ha, scaleRotateViewState);
        }
        return ha;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ScaleRotateViewState mo28601c(String str, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState ha = m16754ha(str);
        mo28458a(true, ha, scaleRotateViewState);
        return ha;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cy */
    public void mo28602cy(int i, int i2) {
        mo28476ct(i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C8441b mo28603f(ScaleRotateViewState scaleRotateViewState) {
        if (getSurfaceSize() == null || scaleRotateViewState == null) {
            return null;
        }
        int i = scaleRotateViewState.mMinDuration <= 0 ? 3000 : scaleRotateViewState.mMinDuration;
        int duration = adO().getDuration();
        if (aiR() + i >= duration) {
            i = duration - aiR();
        }
        C8441b a = mo28454a(mo28455a(scaleRotateViewState, new Range(aiR(), i)));
        if (a == null) {
            return null;
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gZ */
    public ScaleRotateViewState mo28604gZ(String str) {
        return m16754ha(str);
    }

    public int getCurrentEditEffectIndex() {
        return this.cGR;
    }

    public int getGroupId() {
        return 8;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mq */
    public void mo28606mq(int i) {
        this.cGR = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mr */
    public void mo28607mr(int i) {
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(3, i, 8));
        }
        mo28481me(i);
    }
}
