package com.introvd.template.editor.slideshow.story.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.story.p285a.C6848a;
import com.introvd.template.editor.slideshow.story.p285a.C6849b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.slide.model.SlideModuleData;

public class SlideMaterialModule extends RelativeLayout {
    TextView bAk;
    LinearLayout cRB;
    TextView cpu;
    View diw;
    /* access modifiers changed from: private */
    public int dix;
    /* access modifiers changed from: private */
    public C6848a diy;
    private C6849b diz;

    public SlideMaterialModule(Context context) {
        this(context, null);
    }

    public SlideMaterialModule(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideMaterialModule(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diz = new C6849b() {
            /* renamed from: pp */
            public void mo30472pp(int i) {
                if (SlideMaterialModule.this.diy != null) {
                    SlideMaterialModule.this.diy.mo30467cU(SlideMaterialModule.this.dix, i);
                }
            }

            /* renamed from: pq */
            public void mo30473pq(int i) {
                if (SlideMaterialModule.this.diy != null) {
                    SlideMaterialModule.this.diy.mo30468cV(SlideMaterialModule.this.dix, i);
                }
            }

            /* renamed from: pr */
            public void mo30474pr(int i) {
                if (SlideMaterialModule.this.diy != null) {
                    SlideMaterialModule.this.diy.mo30469cW(SlideMaterialModule.this.dix, i);
                }
            }
        };
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.slideshow_material_module_layout, this, true);
        this.cRB = (LinearLayout) inflate.findViewById(R.id.material_container);
        this.bAk = (TextView) inflate.findViewById(R.id.tv_title);
        this.cpu = (TextView) inflate.findViewById(R.id.tv_desc);
        this.diw = inflate.findViewById(R.id.module_devider);
    }

    /* renamed from: a */
    public void mo30508a(SlideModuleData slideModuleData, int i) {
        if (slideModuleData != null) {
            this.dix = i;
            if (!TextUtils.isEmpty(slideModuleData.getTitle())) {
                this.bAk.setText(slideModuleData.getTitle());
            }
            if (!TextUtils.isEmpty(slideModuleData.getDesc())) {
                this.cpu.setText(slideModuleData.getDesc());
            }
            int materialNum = slideModuleData.getMaterialNum();
            if (materialNum > 0) {
                int O = materialNum <= 3 ? ((Constants.getScreenSize().width - C4583d.m11670O(getContext(), 15)) - C4583d.m11670O(getContext(), 5)) / 3 : (int) (((double) (Constants.getScreenSize().width - C4583d.m11670O(getContext(), 15))) / 3.5d);
                for (int i2 = 0; i2 < materialNum; i2++) {
                    SlideMaterialView slideMaterialView = new SlideMaterialView(getContext());
                    slideMaterialView.setIndex(i2);
                    slideMaterialView.setInterCallback(this.diz);
                    LayoutParams layoutParams = new LayoutParams(O, O);
                    if (i2 == 0) {
                        layoutParams.leftMargin = C4583d.m11670O(getContext(), 15);
                    }
                    this.cRB.addView(slideMaterialView, layoutParams);
                }
            }
        }
    }

    public void asp() {
        this.diw.setVisibility(8);
    }

    public int getMaterialItemCount() {
        if (this.cRB != null) {
            return this.cRB.getChildCount();
        }
        return 0;
    }

    /* renamed from: ps */
    public SlideMaterialView mo30511ps(int i) {
        if (i >= 0 && i < this.cRB.getChildCount()) {
            View childAt = this.cRB.getChildAt(i);
            if (childAt != null && (childAt instanceof SlideMaterialView)) {
                return (SlideMaterialView) childAt;
            }
        }
        return null;
    }

    public void setExternalCallback(C6848a aVar) {
        this.diy = aVar;
    }
}
