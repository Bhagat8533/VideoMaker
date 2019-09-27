package com.introvd.template.xyui.feedrecycler;

import android.content.Context;
import android.support.p024v7.widget.C1100ah;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1019i;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.View;

public class FeedRecylayoutManager extends LinearLayoutManager {

    /* renamed from: Vu */
    private RecyclerView f3681Vu;
    private C1100ah eDg;
    /* access modifiers changed from: private */
    public int eDh;
    /* access modifiers changed from: private */
    public C9165a eDi;
    private C1019i eDj = new C1019i() {
        /* renamed from: aX */
        public void mo8089aX(View view) {
            if (FeedRecylayoutManager.this.eDi != null && FeedRecylayoutManager.this.getChildCount() == 1) {
                FeedRecylayoutManager.this.eDi.mo24183Op();
            }
        }

        /* renamed from: aY */
        public void mo8090aY(View view) {
            if (FeedRecylayoutManager.this.eDh >= 0) {
                if (FeedRecylayoutManager.this.getChildCount() <= 2 && FeedRecylayoutManager.this.eDi != null) {
                    FeedRecylayoutManager.this.eDi.mo24184f(true, FeedRecylayoutManager.this.getPosition(view));
                }
            } else if (FeedRecylayoutManager.this.eDi != null) {
                FeedRecylayoutManager.this.eDi.mo24184f(false, FeedRecylayoutManager.this.getPosition(view));
            }
        }
    };

    public FeedRecylayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        init();
    }

    public FeedRecylayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    /* renamed from: a */
    public void mo36147a(C9165a aVar) {
        this.eDi = aVar;
    }

    public int aco() {
        return this.eDg.mo8673a((LayoutManager) this, 0, 0);
    }

    public void init() {
        this.eDg = new C1100ah();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.eDg.mo8807a(recyclerView);
        this.f3681Vu = recyclerView;
        this.f3681Vu.mo7735a(this.eDj);
    }

    public void onLayoutChildren(C1025n nVar, C1031r rVar) {
        try {
            super.onLayoutChildren(nVar, rVar);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void onScrollStateChanged(int i) {
        switch (i) {
            case 0:
                View a = this.eDg.mo8674a(this);
                if (a != null) {
                    int position = getPosition(a);
                    if (this.eDi != null) {
                        boolean z = true;
                        if (getChildCount() == 1) {
                            C9165a aVar = this.eDi;
                            if (position != getItemCount() - 1) {
                                z = false;
                            }
                            aVar.mo24185u(position, z);
                            break;
                        }
                    }
                } else {
                    return;
                }
                break;
        }
    }

    public int scrollHorizontallyBy(int i, C1025n nVar, C1031r rVar) {
        this.eDh = i;
        return super.scrollHorizontallyBy(i, nVar, rVar);
    }

    public int scrollVerticallyBy(int i, C1025n nVar, C1031r rVar) {
        this.eDh = i;
        return super.scrollVerticallyBy(i, nVar, rVar);
    }
}
