package com.introvd.template.sdk.editor;

import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.editor.b */
public class C8420b {
    private ArrayList<C8441b> edA;
    private ArrayList<C8441b> edB;
    private ArrayList<C8441b> edC;
    private ArrayList<C8441b> edD;
    private boolean edx = true;
    private ArrayList<C8441b> edy;
    private ArrayList<C8441b> edz;

    /* renamed from: a */
    public boolean mo34140a(QStoryboard qStoryboard, int i, float f, float f2, boolean z) {
        if (qStoryboard == null || i < 0) {
            return false;
        }
        if (!z && this.edy != null && this.edy.size() > 0) {
            C8538o.m24858a(this.edy, qStoryboard, i, f, f2);
        }
        if (this.edz != null && this.edz.size() > 0) {
            C8538o.m24858a(this.edz, qStoryboard, i, f, f2);
        }
        if (this.edA != null && this.edA.size() > 0) {
            C8538o.m24858a(this.edA, qStoryboard, i, f, f2);
        }
        if (this.edB != null && this.edB.size() > 0) {
            C8538o.m24858a(this.edB, qStoryboard, i, f, f2);
        }
        if (this.edC != null && this.edC.size() > 0) {
            C8538o.m24858a(this.edC, qStoryboard, i, f, f2);
        }
        if (this.edD != null && this.edD.size() > 0) {
            C8538o.m24858a(this.edD, qStoryboard, i, f, f2);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo34141a(QStoryboard qStoryboard, int i, int i2, boolean z) {
        if (qStoryboard == null || i < 0 || i2 == 0) {
            return false;
        }
        if (!z && this.edy != null && this.edy.size() > 0) {
            C8538o.m24859a(this.edy, qStoryboard, i, i2);
        }
        if (this.edz != null && this.edz.size() > 0) {
            C8538o.m24859a(this.edz, qStoryboard, i, i2);
        }
        if (this.edA != null && this.edA.size() > 0) {
            C8538o.m24859a(this.edA, qStoryboard, i, i2);
        }
        if (this.edB != null && this.edB.size() > 0) {
            C8538o.m24859a(this.edB, qStoryboard, i, i2);
        }
        if (this.edC != null && this.edC.size() > 0) {
            C8538o.m24859a(this.edC, qStoryboard, i, i2);
        }
        if (this.edD != null && this.edD.size() > 0) {
            C8538o.m24859a(this.edD, qStoryboard, i, i2);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo34142a(QStoryboard qStoryboard, boolean z, int i) {
        boolean z2 = false;
        if (qStoryboard == null) {
            return false;
        }
        if (!z && this.edy != null && this.edy.size() > 0) {
            z2 = C8540q.m24941b(this.edy, qStoryboard, i);
        }
        if (this.edz != null && this.edz.size() > 0) {
            z2 |= C8540q.m24929a(this.edz, qStoryboard, i);
        }
        if (this.edA != null && this.edA.size() > 0) {
            z2 = this.edx ? z2 | C8540q.m24944c(this.edA, qStoryboard, 3, i) : z2 | C8540q.m24942b(this.edA, qStoryboard, 3, i);
        }
        if (this.edB != null && this.edB.size() > 0) {
            z2 |= C8540q.m24942b(this.edB, qStoryboard, 6, i);
        }
        if (this.edC != null && this.edC.size() > 0) {
            z2 = this.edx ? z2 | C8540q.m24944c(this.edC, qStoryboard, 8, i) : z2 | C8540q.m24942b(this.edC, qStoryboard, 8, i);
        }
        if (this.edD != null && this.edD.size() > 0) {
            z2 = this.edx ? z2 | C8540q.m24944c(this.edD, qStoryboard, 20, i) : z2 | C8540q.m24942b(this.edD, qStoryboard, 20, i);
        }
        mo34145t(qStoryboard);
        return z2;
    }

    /* renamed from: b */
    public boolean mo34143b(QStoryboard qStoryboard, boolean z) {
        return mo34142a(qStoryboard, z, Integer.MAX_VALUE);
    }

    /* renamed from: jf */
    public void mo34144jf(boolean z) {
        this.edx = z;
    }

    /* renamed from: t */
    public void mo34145t(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            this.edy = C8540q.m24961l(qStoryboard, 1);
            this.edz = C8540q.m24961l(qStoryboard, 4);
            this.edA = C8538o.m24875g(qStoryboard, 3);
            this.edB = C8538o.m24875g(qStoryboard, 6);
            this.edC = C8538o.m24875g(qStoryboard, 8);
            this.edD = C8538o.m24875g(qStoryboard, 20);
        }
    }
}
