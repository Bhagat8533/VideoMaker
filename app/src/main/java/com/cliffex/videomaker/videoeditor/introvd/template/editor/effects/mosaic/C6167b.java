package com.introvd.template.editor.effects.mosaic;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8537n;
import java.util.ArrayList;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QTrajectoryData;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.effects.mosaic.b */
public class C6167b extends C5896a {
    private int cGR = -1;
    private QTrajectoryData cMv;

    /* renamed from: ha */
    private ScaleRotateViewState m17638ha(String str) {
        if (adP() == null || getSurfaceSize() == null) {
            return null;
        }
        try {
            ScaleRotateViewState b = C8530i.m24759b(adP(), str, getSurfaceSize() != null ? new VeMSize(getSurfaceSize().width, getSurfaceSize().height) : null);
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
    public ScaleRotateViewState mo28964a(String str, ScaleRotateViewState scaleRotateViewState, boolean z) {
        ScaleRotateViewState ha = m17638ha(str);
        if (z) {
            mo28459a(true, ha, scaleRotateViewState, false);
        }
        return ha;
    }

    /* renamed from: a */
    public void mo28965a(int i, Rect rect, int i2, float f, boolean z) {
        if (this.cMv == null) {
            this.cMv = new QTrajectoryData();
        }
        if (z) {
            this.cMv.updateMode = 1;
        } else {
            this.cMv.updateMode = 0;
        }
        this.cMv.region = new QRect[1];
        this.cMv.f3724ts = new int[1];
        this.cMv.rotation = new float[1];
        this.cMv.region[0] = new QRect();
        this.cMv.region[0].left = rect.left;
        this.cMv.region[0].right = rect.right;
        this.cMv.region[0].top = rect.top;
        this.cMv.region[0].bottom = rect.bottom;
        this.cMv.f3724ts[0] = i2;
        this.cMv.rotation[0] = f;
        QEffect b = C8537n.m24816b(adO().getDataClip(), getGroupId(), i);
        if (b != null) {
            if (z) {
                b.updateTrajectory(0, this.cMv);
            } else {
                b.insertNewTrajectory(0, this.cMv);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28966a(int i, Range range, ArrayList<C8418a> arrayList) {
        if (range == null || this.cyg == null) {
            return false;
        }
        boolean b = mo28473b(i, range);
        boolean a = mo28463a(range, arrayList, this.cGR);
        if (b && a) {
            this.cyg.mo29678a(new C6485b(2, i, getGroupId()));
            mo27873h(0, adO().getDuration(), false);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28967a(int i, ScaleRotateViewState scaleRotateViewState, ArrayList<C8418a> arrayList) {
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
        bVar.mo34280r(scaleRotateViewState);
        this.cyg.mo29686b(new C6485b());
        return true;
    }

    /* access modifiers changed from: 0000 */
    public C8441b akV() {
        if (this.cGR >= aiz().size() || this.cGR < 0) {
            return null;
        }
        return (C8441b) aiz().get(this.cGR);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo28969b(Point point) {
        return mo28452a(point, adZ());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ScaleRotateViewState mo28970c(String str, ScaleRotateViewState scaleRotateViewState, boolean z) {
        return mo28964a(str, scaleRotateViewState, z);
    }

    /* access modifiers changed from: 0000 */
    public int getCurrentEditEffectIndex() {
        return this.cGR;
    }

    public int getGroupId() {
        return 40;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public C8441b mo28972m(ScaleRotateViewState scaleRotateViewState) {
        if (getSurfaceSize() == null || scaleRotateViewState == null) {
            return null;
        }
        C8441b a = mo28454a(mo28455a(scaleRotateViewState, new Range(adZ(), adO().getDuration() - adZ())));
        if (a == null) {
            return null;
        }
        Rect a2 = C8562q.m25042a(scaleRotateViewState.getRectArea(), getSurfaceSize().width, getSurfaceSize().height);
        this.cGR = adO().getDataClip().getEffectCountByGroup(2, getGroupId()) - 1;
        mo28965a(this.cGR, a2, adZ(), 0.0f, false);
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mq */
    public void mo28973mq(int i) {
        this.cGR = i;
    }

    /* renamed from: mr */
    public void mo28974mr(int i) {
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6485b(3, i, getGroupId()));
            mo28481me(i);
        }
    }
}
