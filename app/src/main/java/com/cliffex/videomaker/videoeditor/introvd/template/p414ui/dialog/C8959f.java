package com.introvd.template.p414ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p021v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.exoplayer2.C3119C;
import com.introvd.template.C4681i;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import com.introvd.template.p414ui.dialog.C8966i.C8969b;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.f */
public class C8959f extends Dialog implements OnClickListener, OnItemClickListener {
    public TextView alJ;
    public TextView alY;
    public View amb;
    public MDRootLayout ewM;
    public C8961a ewN;
    public MDButton ewO;
    public MDButton ewP;
    public MDButton ewQ;
    public ListView ewR;
    public C8963c ewS;
    public Context mContext = null;

    /* renamed from: com.introvd.template.ui.dialog.f$1 */
    static /* synthetic */ class C89601 {
        static final /* synthetic */ int[] ewT = new int[C8963c.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            /*
                com.introvd.template.ui.dialog.f$c[] r0 = com.introvd.template.p414ui.dialog.C8959f.C8963c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                ewT = r0
                r0 = 1
                int[] r1 = ewT     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.introvd.template.ui.dialog.f$c r2 = com.introvd.template.p414ui.dialog.C8959f.C8963c.REGULAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = ewT     // Catch:{ NoSuchFieldError -> 0x001f }
                com.introvd.template.ui.dialog.f$c r3 = com.introvd.template.p414ui.dialog.C8959f.C8963c.SINGLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = ewT     // Catch:{ NoSuchFieldError -> 0x002a }
                com.introvd.template.ui.dialog.f$c r3 = com.introvd.template.p414ui.dialog.C8959f.C8963c.MULTI     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.introvd.template.ui.dialog.i$a[] r2 = com.introvd.template.p414ui.dialog.C8966i.C8968a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                cri = r2
                int[] r2 = cri     // Catch:{ NoSuchFieldError -> 0x003d }
                com.introvd.template.ui.dialog.i$a r3 = com.introvd.template.p414ui.dialog.C8966i.C8968a.NEUTRAL     // Catch:{ NoSuchFieldError -> 0x003d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = cri     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.introvd.template.ui.dialog.i$a r2 = com.introvd.template.p414ui.dialog.C8966i.C8968a.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p414ui.dialog.C8959f.C89601.<clinit>():void");
        }
    }

    /* renamed from: com.introvd.template.ui.dialog.f$a */
    public static class C8961a {
        public CharSequence amA;
        public CharSequence amB;
        public int amF;
        public float amX = 1.2f;
        public int amw = -1;
        public int amx = -1;
        public CharSequence amy;
        public CharSequence amz;
        public boolean anG = false;
        public boolean anH = false;
        public boolean anI = false;
        protected int anO;
        protected int anP;
        protected int anQ;
        protected int anR;
        public boolean ana = true;
        public Typeface anb;
        public Typeface anc;
        public boolean anl = true;
        public Context context;
        public C8972k ewU = C8972k.START;
        public C8972k ewV = C8972k.START;
        public int ewW;
        public int ewX;
        public int ewY;
        public int ewZ;
        protected C8972k exa = C8972k.END;
        public C8972k exb = C8972k.START;
        public boolean exc = false;
        protected C8979n exd;
        public CharSequence[] exe;
        public ListAdapter exf;
        public C8972k exg = C8972k.START;
        public C8962b exh;
        public C8962b exi;
        public C8969b exj = C8969b.LIGHT;
        public int selectedIndex = -1;
        public CharSequence title;

        /* renamed from: zd */
        public View f3623zd = this.f3621PM;

        public C8961a(Context context2) {
            this.context = context2;
            this.context = context2;
            this.amF = C8966i.m26326a(context2, C10122R.attr.XY_ColorAccent, context2.getResources().getColor(C10122R.color.color_009688));
            this.ewZ = context2.getResources().getColor(C10122R.color.color_585858);
            this.ewW = this.ewZ;
            this.ewX = this.ewZ;
            this.ewY = this.ewZ;
            this.exj = C8966i.m26332dz(C8966i.m26334r(context2, 16842806)) ? C8969b.LIGHT : C8969b.DARK;
            this.ewU = C8966i.m26328a(context2, C10122R.attr.md_title_gravity, this.ewU);
            this.ewV = C8966i.m26328a(context2, C10122R.attr.md_content_gravity, this.ewV);
            this.exa = C8966i.m26328a(context2, C10122R.attr.md_btnstacked_gravity, this.exa);
            this.exb = C8966i.m26328a(context2, C10122R.attr.md_buttons_gravity, this.exb);
            String t = C8966i.m26335t(context2, C10122R.attr.md_medium_font);
            String t2 = C8966i.m26335t(context2, C10122R.attr.md_regular_font);
            if (!TextUtils.isEmpty(t) && !TextUtils.isEmpty(t2)) {
                mo35612bf(t, t2);
            }
            if (this.anc == null) {
                try {
                    this.anc = Typeface.create("sans-serif-medium", 0);
                } catch (Throwable unused) {
                }
            }
            if (this.anb == null) {
                try {
                    this.anb = Typeface.create(C3119C.SANS_SERIF_NAME, 0);
                } catch (Throwable unused2) {
                }
            }
            if (this.anc == null) {
                this.anc = this.anb;
            }
        }

        /* renamed from: bf */
        public final C8961a mo35612bf(String str, String str2) {
            if (str != null) {
                this.anc = C8980o.m26351d(C4681i.m12184Gp().mo25017Gs().getAssets(), str);
                if (this.anc == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("No font asset found for ");
                    sb.append(str);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (str2 != null) {
                this.anb = C8980o.m26351d(C4681i.m12184Gp().mo25017Gs().getAssets(), str2);
                if (this.anb == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("No font asset found for ");
                    sb2.append(str2);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            return this;
        }
    }

    /* renamed from: com.introvd.template.ui.dialog.f$b */
    public interface C8962b {
        /* renamed from: a */
        void mo35613a(C8959f fVar, View view, int i, CharSequence charSequence);
    }

    /* renamed from: com.introvd.template.ui.dialog.f$c */
    public enum C8963c {
        REGULAR,
        SINGLE,
        MULTI
    }

    public C8959f(Context context, int i) {
        super(context, i);
        this.mContext = context;
        this.ewN = new C8961a(context);
    }

    /* renamed from: a */
    public Drawable mo35608a(C8968a aVar, boolean z) {
        if (!z) {
            switch (aVar) {
                case NEUTRAL:
                    if (this.ewN.anQ != 0) {
                        return ResourcesCompat.getDrawable(this.ewN.context.getResources(), this.ewN.anQ, null);
                    }
                    Drawable u = C8966i.m26336u(this.ewN.context, C10122R.attr.md_btn_neutral_selector);
                    return u != null ? u : C8966i.m26336u(getContext(), C10122R.attr.md_btn_neutral_selector);
                case NEGATIVE:
                    if (this.ewN.anR != 0) {
                        return ResourcesCompat.getDrawable(this.ewN.context.getResources(), this.ewN.anR, null);
                    }
                    Drawable u2 = C8966i.m26336u(this.ewN.context, C10122R.attr.md_btn_negative_selector);
                    return u2 != null ? u2 : C8966i.m26336u(getContext(), C10122R.attr.md_btn_negative_selector);
                default:
                    if (this.ewN.anP != 0) {
                        return ResourcesCompat.getDrawable(this.ewN.context.getResources(), this.ewN.anP, null);
                    }
                    Drawable u3 = C8966i.m26336u(this.ewN.context, C10122R.attr.md_btn_positive_selector);
                    return u3 != null ? u3 : C8966i.m26336u(getContext(), C10122R.attr.md_btn_positive_selector);
            }
        } else if (this.ewN.anO != 0) {
            return ResourcesCompat.getDrawable(this.ewN.context.getResources(), this.ewN.anO, null);
        } else {
            Drawable u4 = C8966i.m26336u(this.ewN.context, C10122R.attr.md_btn_stacked_selector);
            return u4 != null ? u4 : C8966i.m26336u(getContext(), C10122R.attr.md_btn_stacked_selector);
        }
    }

    /* renamed from: a */
    public void mo35609a(MDRootLayout mDRootLayout) {
        this.ewM = mDRootLayout;
        C8964g.m26324a(this);
    }

    /* renamed from: b */
    public final void mo35610b(TextView textView, Typeface typeface) {
        if (typeface != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 128);
            textView.setTypeface(typeface);
        }
    }

    public void onClick(View view) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.ewN.exi != null) {
            CharSequence charSequence = null;
            if (view instanceof TextView) {
                charSequence = ((TextView) view).getText();
            }
            this.ewN.exi.mo35613a(this, view, i, charSequence);
        } else if (this.ewS == null || this.ewS == C8963c.REGULAR) {
            if (this.ewN.ana) {
                dismiss();
            }
            this.ewN.exh.mo35613a(this, view, i, this.ewN.exe[i]);
        } else if (this.ewS != C8963c.MULTI && this.ewS == C8963c.SINGLE) {
            if (this.ewN.ana) {
                dismiss();
            }
            this.ewN.exh.mo35613a(this, view, i, this.ewN.exe[i]);
        }
    }

    /* renamed from: qn */
    public final void mo35611qn() {
        if (this.ewR != null) {
            if ((this.ewN.exe != null && this.ewN.exe.length != 0) || this.ewN.exf != null) {
                this.ewR.setAdapter(this.ewN.exf);
                if (!(this.ewS == null && this.ewN.exi == null)) {
                    this.ewR.setOnItemClickListener(this);
                }
            }
        }
    }
}
