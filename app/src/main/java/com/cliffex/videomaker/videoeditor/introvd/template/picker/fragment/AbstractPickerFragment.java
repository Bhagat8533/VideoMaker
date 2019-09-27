package com.introvd.template.picker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.picker.C8171a;
import com.introvd.template.picker.C8186b;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.item.PickerMediaItemView;
import com.introvd.template.picker.p366b.C8189b;
import com.introvd.template.picker.p366b.C8191d;
import com.introvd.template.picker.p367c.C8197b;
import com.introvd.template.picker.p369d.C8218b;
import com.introvd.template.picker.view.CoordinatorRecyclerView;

public abstract class AbstractPickerFragment extends Fragment {
    protected View bwy;
    protected C8191d dYF;
    protected C8189b dYG;
    protected C8197b dYH;
    protected CoordinatorRecyclerView dYI;
    protected C8180c dYJ;
    protected LinearLayout dYK;
    protected TextView dYL;
    protected boolean dYM;
    protected int dYN;
    protected int dYO;
    protected GridLayoutManager dYP;
    protected int mSourceType = 1;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* renamed from: a */
    public void mo33361a(C8189b bVar) {
        this.dYG = bVar;
    }

    /* renamed from: a */
    public void mo33362a(C8191d dVar) {
        this.dYF = dVar;
    }

    /* access modifiers changed from: protected */
    public void aFM() {
        this.dYK = (LinearLayout) this.bwy.findViewById(R.id.empty_media_layout);
        this.dYL = (TextView) this.bwy.findViewById(R.id.empty_title);
        LayoutParams layoutParams = (LayoutParams) this.dYK.getLayoutParams();
        layoutParams.topMargin = this.dYN;
        this.dYK.setLayoutParams(layoutParams);
    }

    public void aFN() {
        if (this.dYJ != null) {
            this.dYJ.aFz();
        }
    }

    public void aFO() {
        if (this.dYG != null) {
            this.dYG.mo29312i(this.dYM, null);
        }
        if (this.dYJ != null) {
            this.dYJ.setFocusItem(C8186b.aFr().aFt());
            this.dYJ.aFz();
        }
    }

    /* renamed from: al */
    public void mo33366al(int i, boolean z) {
    }

    /* renamed from: c */
    public void mo33367c(C8197b bVar) {
        this.dYH = bVar;
    }

    public View getFirstCompletelyVisibleItemSelectBtn() {
        if (!(this.dYI == null || !this.dYI.isShown() || this.dYP == null)) {
            int findFirstCompletelyVisibleItemPosition = this.dYP.findFirstCompletelyVisibleItemPosition();
            int findFirstVisibleItemPosition = this.dYP.findFirstVisibleItemPosition();
            if (!(findFirstCompletelyVisibleItemPosition == -1 || findFirstVisibleItemPosition == -1)) {
                View childAt = this.dYP.getChildAt(findFirstCompletelyVisibleItemPosition - findFirstVisibleItemPosition);
                if (childAt != null && (childAt instanceof PickerMediaItemView)) {
                    return ((PickerMediaItemView) childAt).getStatusBtn();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: iV */
    public void mo33369iV(boolean z) {
        if (this.dYK != null && this.dYL != null) {
            if (z) {
                this.dYL.setText(this.mSourceType == 1 ? R.string.xiaoying_str_empty_viodeo : R.string.xiaoying_str_empty_photo);
            }
            this.dYK.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: mA */
    public void mo33370mA(String str) {
        if (this.dYJ != null) {
            this.dYJ.mo33283mu(str);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.dYN = (((C8171a.m23615gE(context) - C8218b.m23733gH(context).widthPixels) - C8171a.dXK) / 2) - C8218b.m23732O(context, 24);
        this.dYO = ((C8171a.m23615gE(context) - C8218b.m23733gH(context).widthPixels) - C8171a.dXK) - (C8218b.m23732O(context, 24) * 2);
    }

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if ((this.dYH == null || this.dYF == null || this.dYG == null) && getActivity() != null) {
            getActivity().finish();
            return null;
        }
        if (this.bwy != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.bwy.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.bwy);
            }
        } else {
            mo33360a(layoutInflater, viewGroup);
        }
        if (this.bwy != null) {
            this.bwy.setPadding(0, 0, 0, C8218b.m23733gH(getContext()).widthPixels);
        }
        if (this.dYI != null) {
            this.dYI.mo7737a((C1022l) new C1022l() {
                /* renamed from: d */
                public void mo8096d(RecyclerView recyclerView, int i) {
                    super.mo8096d(recyclerView, i);
                    if (AbstractPickerFragment.this.dYG != null && i == 1) {
                        AbstractPickerFragment.this.dYG.amE();
                    }
                }
            });
        }
        return this.bwy;
    }

    /* renamed from: th */
    public void mo33372th(int i) {
        int i2 = i / 2;
        this.dYN += i2;
        this.dYO += i;
        if (this.dYK != null) {
            LayoutParams layoutParams = (LayoutParams) this.dYK.getLayoutParams();
            layoutParams.topMargin += i2;
            this.dYK.setLayoutParams(layoutParams);
            this.dYK.invalidate();
        }
    }
}
