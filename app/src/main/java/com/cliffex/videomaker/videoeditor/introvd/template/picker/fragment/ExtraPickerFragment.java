package com.introvd.template.picker.fragment;

import android.os.Bundle;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.introvd.template.picker.C8186b;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.adapter.C8180c.C8183a;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p367c.p368a.C8196c;
import com.introvd.template.picker.view.CoordinatorRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ExtraPickerFragment extends AbstractPickerFragment {
    private List<String> dYR = new ArrayList();
    protected C8183a dYS = new C8183a() {
        /* renamed from: e */
        public boolean mo33287e(int i, int i2, String str) {
            if (ExtraPickerFragment.this.dYG != null) {
                ExtraPickerFragment.this.dYG.mo29311c(i, i2, str);
            }
            return true;
        }
    };

    private void aFP() {
        this.dYI.setCoordinatorListener(this.dYF.getCoordinatorRootView());
        this.dYI.setLayoutManager(new GridLayoutManager(getActivity(), C8180c.dYg));
        this.dYI.mo7733a((C1018h) new C8185d(C8180c.dYg, C8180c.dYf, false));
        this.dYJ = new C8180c(getContext());
        this.dYJ.mo33277a(this.dYS);
        this.dYI.setAdapter(this.dYJ);
        if (this.dYH != null) {
            this.dYH.mo33337a(this.dYR, (C8196c) new C8196c() {
                public void onError(Throwable th) {
                }

                public void onSuccess(List<C8215c> list) {
                    if (list != null && list.size() > 0) {
                        ExtraPickerFragment.this.dYJ.setFocusItem(((C8215c) list.get(0)).aFK());
                        if (ExtraPickerFragment.this.dYG != null) {
                            ExtraPickerFragment.this.dYG.mo29311c(((C8215c) list.get(0)).getSourceType(), 1, ((C8215c) list.get(0)).aFK());
                            ExtraPickerFragment.this.dYG.mo29308aS(list);
                        }
                        ExtraPickerFragment.this.dYJ.mo33281cC(list);
                    }
                }
            });
        }
    }

    /* renamed from: r */
    public static ExtraPickerFragment m23749r(ArrayList<String> arrayList) {
        ExtraPickerFragment extraPickerFragment = new ExtraPickerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("extra_file_path_list", arrayList);
        extraPickerFragment.setArguments(bundle);
        return extraPickerFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.picker_extra_fragment_layout, viewGroup, false);
        this.dYI = (CoordinatorRecyclerView) this.bwy.findViewById(R.id.extra_recycler_view);
        if (getArguments() != null) {
            this.dYR = getArguments().getStringArrayList("extra_file_path_list");
        }
        if (this.dYR != null) {
            C8186b.aFr().mo33292cA(this.dYR);
        }
        aFP();
    }
}
