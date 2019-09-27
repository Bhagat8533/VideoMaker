package com.introvd.template.editor.advance;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.advance.l */
public class C5623l {
    private RelativeLayout bof;
    private int cwZ = 0;
    /* access modifiers changed from: private */
    public TextView cxo;
    /* access modifiers changed from: private */
    public TextView cxp;
    private RelativeLayout cxq;
    private RelativeLayout cxr;
    private C5625a cxs = null;

    /* renamed from: po */
    private OnClickListener f3480po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C5623l.this.cxo)) {
                C5623l.this.m15471kU(0);
            } else if (view.equals(C5623l.this.cxp)) {
                C5623l.this.m15471kU(1);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.advance.l$a */
    public interface C5625a {
        /* renamed from: kV */
        void mo27638kV(int i);
    }

    public C5623l(RelativeLayout relativeLayout) {
        this.bof = relativeLayout;
    }

    /* renamed from: a */
    private void m15468a(boolean z, TextView textView) {
        m15472m(textView, z);
    }

    /* renamed from: cx */
    private void m15470cx(View view) {
        this.cxo = (TextView) view.findViewById(R.id.layout_ve_preview_pop);
        this.cxp = (TextView) view.findViewById(R.id.layout_ve_preview_font);
        this.cxq = (RelativeLayout) view.findViewById(R.id.relativelayout_theme_content);
        this.cxr = (RelativeLayout) view.findViewById(R.id.relativelayout_tool_list_content);
        this.cxo.setOnClickListener(this.f3480po);
        this.cxp.setOnClickListener(this.f3480po);
        mo27635en(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: kU */
    public void m15471kU(int i) {
        if (i != this.cwZ) {
            switch (i) {
                case 0:
                    mo27635en(true);
                    break;
                case 1:
                    m15468a(false, this.cxo);
                    m15468a(true, this.cxp);
                    if (this.cxq != null) {
                        this.cxq.setVisibility(4);
                    }
                    if (this.cxr != null) {
                        this.cxr.setVisibility(0);
                        break;
                    }
                    break;
            }
            this.cwZ = i;
            if (this.cxs != null) {
                this.cxs.mo27638kV(i);
            }
        }
    }

    /* renamed from: m */
    private void m15472m(View view, boolean z) {
        if (view.equals(this.cxo)) {
            if (z) {
                this.cxo.setTextColor(this.cxo.getResources().getColor(R.color.color_ff5e13));
            } else {
                this.cxo.setTextColor(this.cxo.getResources().getColor(R.color.white_p50));
            }
        } else if (!view.equals(this.cxp)) {
        } else {
            if (z) {
                this.cxp.setTextColor(this.cxr.getResources().getColor(R.color.color_ff5e13));
            } else {
                this.cxp.setTextColor(this.cxr.getResources().getColor(R.color.white_p50));
            }
        }
    }

    /* renamed from: a */
    public void mo27633a(C5625a aVar) {
        this.cxs = aVar;
    }

    public void adc() {
        if (this.bof != null) {
            m15470cx(this.bof);
        }
    }

    /* renamed from: en */
    public void mo27635en(boolean z) {
        if (!z) {
            this.cwZ = 0;
        }
        m15468a(true, this.cxo);
        m15468a(false, this.cxp);
        if (this.cxq != null) {
            this.cxq.setVisibility(0);
        }
        if (this.cxr != null) {
            this.cxr.setVisibility(4);
        }
    }

    /* renamed from: kP */
    public void mo27636kP(int i) {
        m15471kU(i);
        this.cwZ = i;
    }
}
