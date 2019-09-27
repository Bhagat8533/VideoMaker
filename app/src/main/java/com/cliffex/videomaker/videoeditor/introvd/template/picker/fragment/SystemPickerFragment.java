package com.introvd.template.picker.fragment;

import android.os.Bundle;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.adapter.C8180c.C8183a;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p367c.p368a.C8196c;
import com.introvd.template.picker.view.CoordinatorRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SystemPickerFragment extends AbstractPickerFragment {
    protected C8183a dYS = new C8183a() {
        /* renamed from: e */
        public boolean mo33287e(int i, int i2, String str) {
            if (SystemPickerFragment.this.dYG != null) {
                return SystemPickerFragment.this.dYG.mo29311c(i, i2, str);
            }
            return false;
        }
    };

    private void aFP() {
        this.dYI.setCoordinatorListener(this.dYF.getCoordinatorRootView());
        this.dYJ = new C8180c(getContext());
        this.dYP = new GridLayoutManager(getActivity(), C8180c.dYg);
        this.dYI.setLayoutManager(this.dYP);
        this.dYI.mo7733a((C1018h) new C8185d(C8180c.dYg, C8180c.dYf, false));
        this.dYJ.mo33277a(this.dYS);
        this.dYI.setAdapter(this.dYJ);
        m23795am(this.mSourceType, true);
    }

    public static SystemPickerFragment aFV() {
        SystemPickerFragment systemPickerFragment = new SystemPickerFragment();
        systemPickerFragment.setArguments(new Bundle());
        return systemPickerFragment;
    }

    /* renamed from: am */
    private void m23795am(final int i, final boolean z) {
        if (this.dYH != null) {
            this.dYH.mo33332a(i, (C8196c) new C8196c() {
                public void onError(Throwable th) {
                    SystemPickerFragment.this.mo33369iV(true);
                    SystemPickerFragment.this.dYJ.mo33281cC(new ArrayList());
                }

                public void onSuccess(List<C8215c> list) {
                    if (z && list != null && list.size() > 0) {
                        SystemPickerFragment.this.dYJ.setFocusItem(((C8215c) list.get(0)).aFK());
                        if (SystemPickerFragment.this.dYG != null) {
                            SystemPickerFragment.this.dYG.mo29311c(i, 0, ((C8215c) list.get(0)).aFK());
                        }
                    }
                    if (list == null || list.size() == 0) {
                        SystemPickerFragment.this.mo33369iV(true);
                    } else {
                        SystemPickerFragment.this.mo33369iV(false);
                    }
                    SystemPickerFragment.this.dYJ.mo33281cC(list);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.picker_system_fragment_layout, viewGroup, false);
        this.dYI = (CoordinatorRecyclerView) this.bwy.findViewById(R.id.system_recycler_view);
        aFM();
        aFP();
    }

    public void aFO() {
        super.aFO();
    }

    /* renamed from: al */
    public void mo33366al(int i, boolean z) {
        if (this.bwy == null) {
            this.mSourceType = i;
        } else if (this.mSourceType != i || z) {
            this.mSourceType = i;
            m23795am(i, false);
        }
    }
}
