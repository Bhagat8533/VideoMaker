package com.introvd.template.p203b.p204a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.introvd.template.p203b.p204a.C4564a.C4566a;

/* renamed from: com.introvd.template.b.a.e */
public class C4576e {
    private C4564a bLA;
    private C4572c bLB;
    private ViewGroup bLC;
    private View bLD;
    private View bLE;
    private CharSequence bLF;
    private Context context;

    private C4576e(Context context2, View view, C4564a aVar, C4572c cVar, CharSequence charSequence) {
        this.context = context2;
        this.bLE = view;
        if (aVar == null) {
            aVar = new C4566a().mo24819SB();
        }
        this.bLA = aVar;
        this.bLB = cVar;
        this.bLF = charSequence;
        init();
    }

    /* renamed from: PJ */
    private void m11608PJ() {
        this.bLC = new FrameLayout(this.context);
        if (this.bLD != null) {
            this.bLC.addView(this.bLD);
            return;
        }
        throw new IllegalStateException("msgView state is null");
    }

    /* renamed from: SG */
    private void m11609SG() {
        if (this.bLA == null || this.bLA.f3410zd == null) {
            TextView textView = new TextView(this.context);
            textView.setText(this.bLF);
            textView.setTextSize((float) this.bLA.bLg);
            textView.setTextColor(this.bLA.bLf);
            textView.setGravity(this.bLA.bLh);
            int i = this.bLA.bLj;
            int i2 = i * 2;
            textView.setPadding(i2, i, i2, i);
            textView.setBackgroundColor(this.bLA.backgroundColor);
            textView.setMinHeight(this.bLA.minHeight);
            textView.setMaxLines(this.bLA.bLi);
            this.bLD = textView;
            return;
        }
        this.bLD = this.bLA.f3410zd;
    }

    /* renamed from: a */
    public static C4576e m11610a(Context context2, View view, C4564a aVar) {
        C4576e eVar = new C4576e(context2, view, aVar, new C4572c(aVar.f3408x, aVar.f3409y), null);
        return eVar;
    }

    /* renamed from: a */
    public static C4576e m11611a(Context context2, View view, CharSequence charSequence, int i, int i2, C4564a aVar) {
        if (context2 != null) {
            C4576e eVar = new C4576e(context2, view, aVar, new C4572c(view, i, i2), charSequence);
            return eVar;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    private void init() {
        m11609SG();
        m11608PJ();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SH */
    public void mo24851SH() {
        if (this.bLD != null) {
            this.bLA.bLk.mo24844SC().mo24837ac(this.bLA.bLc).mo24840ch(this.bLD);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SI */
    public void mo24852SI() {
        if (this.bLD != null) {
            this.bLA.bLk.mo24844SC().mo24837ac(this.bLA.bLd).mo24841ci(this.bLD);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SJ */
    public long mo24853SJ() {
        return this.bLA.bLc;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SK */
    public long mo24854SK() {
        return this.bLA.bLd;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SL */
    public long mo24855SL() {
        return this.bLA.bLk.mo24844SC().getDuration();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SM */
    public long mo24856SM() {
        return this.bLA.bLe;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SN */
    public C4572c mo24857SN() {
        return this.bLB;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SO */
    public boolean mo24858SO() {
        return this.bLA != null && this.bLA.sticky;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: SP */
    public int mo24859SP() {
        if (this.bLA == null || this.bLA.bLl <= 0) {
            return 152;
        }
        return this.bLA.bLl;
    }

    /* access modifiers changed from: 0000 */
    public void destroy() {
        this.bLC.removeAllViews();
        this.bLC = null;
        this.bLD = null;
        this.bLE = null;
    }

    /* access modifiers changed from: 0000 */
    public View getAnchorView() {
        return this.bLE;
    }

    /* access modifiers changed from: 0000 */
    public View getContentView() {
        return this.bLC;
    }

    /* access modifiers changed from: 0000 */
    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: 0000 */
    public boolean isShowing() {
        return (this.bLC == null || this.bLC.getParent() == null) ? false : true;
    }

    public void remove() {
        C4573d.m11591SD().mo24848e(this);
    }

    public void show() {
        C4573d.m11591SD().mo24847a(this, true);
    }
}
