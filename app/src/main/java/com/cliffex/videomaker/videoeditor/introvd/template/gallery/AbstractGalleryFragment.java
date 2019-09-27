package com.introvd.template.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.common.FragmentBase;
import xiaoying.quvideo.com.vivabase.C10122R;

public abstract class AbstractGalleryFragment extends FragmentBase {
    protected Handler bLS;
    protected View bwy;
    protected RecyclerView dFm;
    protected RecyclerView dFn;
    protected View dFo;
    protected ViewGroup dFp;

    /* access modifiers changed from: private */
    /* renamed from: cQ */
    public static int[] m21773cQ(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo32016a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* renamed from: ai */
    public abstract void mo32017ai(int i, boolean z);

    public abstract void ayi();

    public abstract boolean ayj();

    public abstract boolean ayk();

    /* access modifiers changed from: protected */
    public void ayl() {
        this.dFn.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.dFp = (ViewGroup) this.bwy.findViewById(C10122R.C10124id.layout_header_title);
        final TextView textView = (TextView) this.dFp.findViewById(C10122R.C10124id.header_title);
        this.dFn.mo7737a((C1022l) new C1022l() {
            private boolean dFq;
            private int startY;

            /* renamed from: a */
            public void mo8095a(RecyclerView recyclerView, int i, int i2) {
                super.mo8095a(recyclerView, i, i2);
                LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() != 0) {
                    this.dFq = false;
                } else {
                    this.dFq = true;
                    textView.setBackgroundResource(0);
                }
                View l = recyclerView.mo7818l((float) (AbstractGalleryFragment.this.dFp.getMeasuredWidth() / 2), 5.0f);
                if (!(l == null || l.getContentDescription() == null || i2 == 0 || !AbstractGalleryFragment.this.dFn.isShown())) {
                    View view = null;
                    boolean z = l instanceof ViewGroup;
                    if (z) {
                        view = ((ViewGroup) l).getChildAt(0);
                    }
                    if (AbstractGalleryFragment.this.dFp.getVisibility() != 0) {
                        AbstractGalleryFragment.this.dFp.setVisibility(0);
                        textView.setBackgroundResource(0);
                        if (z) {
                            this.startY = AbstractGalleryFragment.m21773cQ(view)[1];
                        }
                    }
                    if (view != null && Math.abs(AbstractGalleryFragment.m21773cQ(view)[1] - this.startY) > (AbstractGalleryFragment.this.dFp.getMeasuredHeight() * 2) / 3 && !this.dFq) {
                        textView.setBackgroundResource(C10122R.C10123drawable.xiaoying_gallery_item_title_bg);
                    }
                    textView.setText(String.valueOf(l.getContentDescription()));
                }
                View l2 = recyclerView.mo7818l((float) (AbstractGalleryFragment.this.dFp.getMeasuredWidth() / 2), (float) (AbstractGalleryFragment.this.dFp.getMeasuredHeight() + 1));
                if (l2 != null && l2.getTag() != null) {
                    int intValue = ((Integer) l2.getTag()).intValue();
                    int top = l2.getTop() - AbstractGalleryFragment.this.dFp.getMeasuredHeight();
                    if (intValue == 2) {
                        if (l2.getTop() > 0) {
                            AbstractGalleryFragment.this.dFp.setTranslationY((float) top);
                        } else {
                            AbstractGalleryFragment.this.dFp.setTranslationY(0.0f);
                        }
                    } else if (intValue == 3) {
                        AbstractGalleryFragment.this.dFp.setTranslationY(0.0f);
                    }
                }
            }
        });
    }

    /* renamed from: cR */
    public abstract void mo32022cR(View view);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.bwy != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.bwy.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.bwy);
            }
        } else {
            mo32016a(layoutInflater, viewGroup);
        }
        return this.bwy;
    }

    public abstract void setCallbackHandler(Handler handler);
}
