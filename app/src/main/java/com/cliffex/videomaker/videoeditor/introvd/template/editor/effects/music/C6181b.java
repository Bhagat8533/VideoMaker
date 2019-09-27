package com.introvd.template.editor.effects.music;

import com.introvd.template.common.model.Range;
import com.introvd.template.editor.player.p267a.C6483a;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.editor.effects.music.b */
public class C6181b extends C6180a {
    public boolean cNa = false;
    public boolean cNb = false;

    /* renamed from: a */
    public final boolean mo29001a(boolean z, boolean z2, Range range) {
        QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), this.cMM);
        if (d == null) {
            return false;
        }
        if ((z ? C8538o.m24847a(d, !z2, range.getmTimeLength()) : C8538o.m24863b(d, !z2, range.getmTimeLength())) != 0) {
            return false;
        }
        QEffect d2 = C8540q.m24947d(adO().getDataClip(), getGroupId(), this.cMM);
        if (!(this.cyg == null || d2 == null)) {
            this.cyg.mo29678a(new C6483a().mo29719ok(1).mo29718c(d2));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void akZ() {
        super.akZ();
        QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), this.cMM);
        if (d != null) {
            this.cNa = C8538o.m24861a(d, true);
            this.cNb = C8538o.m24861a(d, false);
            return;
        }
        this.cNa = false;
        this.cNb = false;
    }

    /* access modifiers changed from: protected */
    public int akh() {
        return C8540q.m24950e(adO(), getGroupId(), this.cMM);
    }

    public void aki() {
        QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), this.cMM);
        if (d != null) {
            C8538o.m24865b(d, false);
        }
    }

    public int getGroupId() {
        return 1;
    }
}
