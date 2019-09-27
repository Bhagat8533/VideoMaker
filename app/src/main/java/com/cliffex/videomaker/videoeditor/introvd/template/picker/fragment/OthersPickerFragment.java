package com.introvd.template.picker.fragment;

import android.os.Bundle;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.explorer.p298c.C7149c.C7155b;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8173a;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.adapter.C8180c.C8183a;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.picker.p365a.C8172a;
import com.introvd.template.picker.p366b.C8190c;
import com.introvd.template.picker.p367c.C8192a;
import com.introvd.template.picker.p367c.C8192a.C8193a;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p367c.p368a.C8195b;
import com.introvd.template.picker.p369d.C8219c;
import com.introvd.template.picker.view.CoordinatorRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class OthersPickerFragment extends AbstractPickerFragment {
    protected C8183a dYS = new C8183a() {
        /* renamed from: e */
        public boolean mo33287e(int i, int i2, String str) {
            if (OthersPickerFragment.this.dYG != null) {
                return OthersPickerFragment.this.dYG.mo29311c(i, i2, str);
            }
            return false;
        }
    };
    private RelativeLayout dYY;
    private ImageView dYZ;
    private CoordinatorRecyclerView dZa;
    /* access modifiers changed from: private */
    public C8173a dZb;

    /* renamed from: Oj */
    private void m23783Oj() {
        aFR();
        ayl();
        this.dYY = (RelativeLayout) this.bwy.findViewById(R.id.layout_media);
        this.dYZ = (ImageView) this.bwy.findViewById(R.id.folder_back_icon);
        LayoutParams layoutParams = (LayoutParams) this.dYZ.getLayoutParams();
        layoutParams.topMargin = this.dYO;
        this.dYZ.setLayoutParams(layoutParams);
        m23789tk(this.mSourceType);
    }

    private void aFR() {
        this.dZa = (CoordinatorRecyclerView) this.bwy.findViewById(R.id.folder_recycler_view);
        this.dZb = new C8173a(getContext());
        this.dZa.setCoordinatorListener(this.dYF.getCoordinatorRootView());
        this.dZa.setLayoutManager(new GridLayoutManager(getActivity(), C8173a.dXT));
        this.dZa.mo7733a((C1018h) new C8185d(C8173a.dXT, C8173a.dXS, true));
        this.dZb.mo33264a((C8190c) new C8190c() {
            /* renamed from: a */
            public void mo33305a(C8192a aVar) {
                if (aVar.aFE() != null && aVar.aFE().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (C8215c aFK : aVar.aFE()) {
                        arrayList.add(aFK.aFK());
                    }
                    C8219c.m23738f(OthersPickerFragment.this.getContext(), arrayList);
                }
                OthersPickerFragment.this.m23788b(aVar);
            }

            public void aFC() {
                C8172a.m23624gG(OthersPickerFragment.this.getContext());
                if (OthersPickerFragment.this.dYF != null) {
                    OthersPickerFragment.this.dYF.aFm();
                }
            }
        });
        this.dZa.setAdapter(this.dZb);
    }

    public static OthersPickerFragment aFU() {
        OthersPickerFragment othersPickerFragment = new OthersPickerFragment();
        othersPickerFragment.setArguments(new Bundle());
        return othersPickerFragment;
    }

    private void ams() {
        this.dYZ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                OthersPickerFragment.this.ayi();
            }
        });
        C7149c.m21131a((C7155b) new C7155b() {
            public void awF() {
                OthersPickerFragment.this.m23789tk(OthersPickerFragment.this.mSourceType);
            }
        });
    }

    /* access modifiers changed from: private */
    public void ayi() {
        C8172a.m23623gF(getContext());
        this.dYM = false;
        this.dYY.setVisibility(8);
        this.dZa.setVisibility(0);
        if (this.dYG != null) {
            this.dYG.amE();
            this.dYG.mo29312i(false, null);
        }
    }

    private void ayl() {
        this.dYI = (CoordinatorRecyclerView) this.bwy.findViewById(R.id.media_recycler_view);
        this.dYI.setCoordinatorListener(this.dYF.getCoordinatorRootView());
        this.dYP = new GridLayoutManager(getActivity(), C8180c.dYg);
        this.dYI.setLayoutManager(this.dYP);
        this.dYI.mo7733a((C1018h) new C8185d(C8180c.dYg, C8180c.dYf, false));
        this.dYJ = new C8180c(getContext());
        this.dYJ.mo33277a(this.dYS);
        this.dYI.setAdapter(this.dYJ);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23788b(C8192a aVar) {
        this.dYM = true;
        this.dZa.setVisibility(8);
        this.dYY.setVisibility(0);
        if (aVar == null || aVar.getChildCount() == 0) {
            mo33369iV(true);
            this.dYJ.mo33281cC(new ArrayList());
        } else {
            mo33369iV(false);
            this.dYJ.mo33281cC(aVar.aFE());
        }
        if (this.dYG != null) {
            this.dYG.mo29312i(true, aVar == null ? "" : aVar.getTitle());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tk */
    public void m23789tk(final int i) {
        if (this.dYH != null) {
            this.dYH.mo33331a(i, (C8195b) new C8195b() {
                public void onError(Throwable th) {
                }

                public void onSuccess(List<C8192a> list) {
                    C8192a aFI = new C8193a().mo33324te(1).aFI();
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(aFI);
                    OthersPickerFragment.this.dZb.mo33266m(list, i);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.picker_others_fragment_layout, viewGroup, false);
        aFM();
        m23783Oj();
        ams();
    }

    public void aFO() {
        super.aFO();
    }

    /* renamed from: al */
    public void mo33366al(int i, boolean z) {
        if (this.bwy == null) {
            this.mSourceType = i;
        } else if (this.mSourceType != i || z) {
            if (this.dYM) {
                ayi();
            }
            this.mSourceType = i;
            m23789tk(i);
        }
    }

    public boolean onBackPressed() {
        if (!this.dYM) {
            return super.onBackPressed();
        }
        ayi();
        return true;
    }

    /* renamed from: th */
    public void mo33372th(int i) {
        super.mo33372th(i);
        if (this.dYZ != null) {
            LayoutParams layoutParams = (LayoutParams) this.dYZ.getLayoutParams();
            layoutParams.topMargin += i;
            this.dYZ.setLayoutParams(layoutParams);
            this.dYZ.invalidate();
        }
    }
}
