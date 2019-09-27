package com.introvd.template.editor.effects.dub.title;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6409n;

public class DubChooseTitleView extends RelativeLayout {
    /* access modifiers changed from: private */
    public int cJD = 0;
    private TabLayout cJE;
    private C6106a cLg;
    private View cLh;

    /* renamed from: com.introvd.template.editor.effects.dub.title.DubChooseTitleView$a */
    public interface C6106a {
        /* renamed from: js */
        void mo28853js(int i);
    }

    public DubChooseTitleView(Context context) {
        super(context);
        m17411Oj();
    }

    public DubChooseTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17411Oj();
    }

    public DubChooseTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17411Oj();
    }

    /* renamed from: Oj */
    private void m17411Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_operation_dub_title_choose, this, true);
        this.cLh = findViewById(R.id.cover_view);
        this.cJE = (TabLayout) findViewById(R.id.tablayout_dub);
        this.cLh.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.cJE.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                int position = fVar.getPosition();
                if (position == 0) {
                    DubChooseTitleView.this.cJD = 0;
                } else if (position == 1) {
                    DubChooseTitleView.this.cJD = 1;
                }
                DubChooseTitleView.this.m17415mK(DubChooseTitleView.this.cJD);
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
                if (fVar.getPosition() == 1) {
                    DubChooseTitleView.this.cJD = 1;
                    DubChooseTitleView.this.m17415mK(DubChooseTitleView.this.cJD);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mK */
    public void m17415mK(int i) {
        if (this.cLg != null) {
            this.cLg.mo28853js(i);
        }
    }

    public void akt() {
        C0427f aI = this.cJE.mo2008aI(1);
        if (aI != null) {
            aI.select();
        }
    }

    /* renamed from: fu */
    public void mo28867fu(boolean z) {
        C6409n.m18455a(this.cJE, Boolean.valueOf(z));
        if (z) {
            this.cLh.setVisibility(8);
        } else {
            this.cLh.setVisibility(0);
        }
    }

    public int getCurrentChooseMode() {
        return this.cJD;
    }

    public void setOnChooseModeChangeListener(C6106a aVar) {
        this.cLg = aVar;
    }
}
