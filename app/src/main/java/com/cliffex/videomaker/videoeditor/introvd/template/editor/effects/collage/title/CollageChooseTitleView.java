package com.introvd.template.editor.effects.collage.title;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;

public class CollageChooseTitleView extends RelativeLayout {
    private C6075a cJC;
    /* access modifiers changed from: private */
    public int cJD = 0;
    /* access modifiers changed from: private */
    public TabLayout cJE;

    /* renamed from: com.introvd.template.editor.effects.collage.title.CollageChooseTitleView$a */
    public interface C6075a {
        /* renamed from: js */
        void mo28792js(int i);
    }

    public CollageChooseTitleView(Context context) {
        super(context);
        m17306Oj();
    }

    public CollageChooseTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17306Oj();
    }

    public CollageChooseTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17306Oj();
    }

    /* renamed from: Oj */
    private void m17306Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_operation_collage_title_choose, this, true);
        this.cJE = (TabLayout) findViewById(R.id.tablayout_collage);
        this.cJE.removeTabAt(1);
        this.cJE.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                int position = fVar.getPosition();
                if (CollageChooseTitleView.this.cJE.getTabCount() == 3) {
                    if (position == 0) {
                        CollageChooseTitleView.this.cJD = 0;
                    } else if (position == 1) {
                        CollageChooseTitleView.this.cJD = 1;
                    } else if (position == 2) {
                        CollageChooseTitleView.this.cJD = 2;
                    }
                } else if (CollageChooseTitleView.this.cJE.getTabCount() == 2) {
                    if (position == 0) {
                        CollageChooseTitleView.this.cJD = 0;
                    } else if (position == 1) {
                        CollageChooseTitleView.this.cJD = 2;
                    }
                }
                CollageChooseTitleView.this.m17311mK(CollageChooseTitleView.this.cJD);
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: mK */
    public void m17311mK(int i) {
        if (this.cJC != null) {
            this.cJC.mo28792js(i);
        }
    }

    public int getCurrentChooseMode() {
        return this.cJD;
    }

    public void setOnChooseModeChangeListener(C6075a aVar) {
        this.cJC = aVar;
    }
}
