package com.introvd.template.picker.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.adapter.C8180c.C8183a;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p367c.p368a.C8194a;
import com.introvd.template.picker.p367c.p368a.C8196c;
import com.introvd.template.picker.p369d.C8219c;
import com.introvd.template.picker.view.CoordinatorRecyclerView;
import com.introvd.template.router.user.SnsAuthListener;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import java.util.ArrayList;
import java.util.List;

public class InstagramPickerFragment extends AbstractPickerFragment {
    protected C8183a dYS = new C8183a() {
        /* renamed from: e */
        public boolean mo33287e(int i, int i2, String str) {
            InstagramPickerFragment.this.m23776f(i, i2, str);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public LinearLayout dYU;
    private TextView dYV;
    private TextView dYW;
    private RelativeLayout dYX;

    /* renamed from: Oj */
    private void m23772Oj() {
        aFQ();
        ayl();
        if (SnsAuthServiceProxy.isAuthed(31)) {
            this.dYU.setVisibility(8);
            m23777tj(this.mSourceType);
            return;
        }
        this.dYU.setVisibility(0);
    }

    private void aFQ() {
        this.dYU = (LinearLayout) this.bwy.findViewById(R.id.layout_picker_sns_login);
        this.dYV = (TextView) this.bwy.findViewById(R.id.tv_picker_sns_login_desc);
        this.dYX = (RelativeLayout) this.bwy.findViewById(R.id.picker_sns_facebook);
        this.dYW = (TextView) this.bwy.findViewById(R.id.sns_login_text);
        C8219c.m23737dn(this.dYX);
        this.dYV.setText(getContext().getResources().getString(R.string.xiaoying_str_gallery_sns_get_meida_desc, new Object[]{getContext().getResources().getString(R.string.xiaoying_str_com_intl_share_instagram)}));
        this.dYW.setText(getContext().getResources().getString(R.string.xiaoying_str_com_intl_login_continue, new Object[]{getContext().getResources().getString(R.string.xiaoying_str_com_intl_share_instagram)}));
        LayoutParams layoutParams = (LayoutParams) this.dYU.getLayoutParams();
        layoutParams.topMargin = this.dYN;
        this.dYU.setLayoutParams(layoutParams);
        this.dYX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C4600l.m11739k(InstagramPickerFragment.this.getActivity(), false)) {
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_com_msg_network_inactive), 1);
                    return;
                }
                InstagramPickerFragment.this.dYF.mo33254sX(31);
                SnsAuthServiceProxy.auth(InstagramPickerFragment.this.getActivity(), new Builder().snsType(31).snsAuthListener(new SnsAuthListener() {
                    public void onAuthCancel(int i) {
                        LogUtils.m14223i("InstagramPicker", ">>> onAuthCancel...");
                    }

                    public void onAuthComplete(int i, Bundle bundle) {
                        LogUtils.m14223i("InstagramPicker", ">>> onAuthComplete...");
                        InstagramPickerFragment.this.dYU.setVisibility(8);
                        InstagramPickerFragment.this.m23777tj(InstagramPickerFragment.this.mSourceType);
                    }

                    public void onAuthFail(int i, int i2, String str) {
                        LogUtils.m14223i("InstagramPicker", ">>> onAuthFail...");
                    }
                }));
            }
        });
    }

    public static InstagramPickerFragment aFT() {
        InstagramPickerFragment instagramPickerFragment = new InstagramPickerFragment();
        instagramPickerFragment.setArguments(new Bundle());
        return instagramPickerFragment;
    }

    private void ayl() {
        this.dYI = (CoordinatorRecyclerView) this.bwy.findViewById(R.id.media_recycler_view);
        this.dYJ = new C8180c(getContext());
        this.dYI.setCoordinatorListener(this.dYF.getCoordinatorRootView());
        this.dYP = new GridLayoutManager(getActivity(), C8180c.dYg);
        this.dYI.setLayoutManager(this.dYP);
        this.dYI.mo7733a((C1018h) new C8185d(C8180c.dYg, C8180c.dYf, false));
        this.dYJ.mo33277a(this.dYS);
        this.dYI.setAdapter(this.dYJ);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23776f(final int i, final int i2, String str) {
        if (this.dYH != null) {
            this.dYH.mo33336a(str, i, 31, (C8194a) new C8194a() {
                /* renamed from: dV */
                public void mo33325dV(final String str) {
                    if (InstagramPickerFragment.this.getActivity() != null) {
                        InstagramPickerFragment.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                if (InstagramPickerFragment.this.dYG != null) {
                                    boolean c = InstagramPickerFragment.this.dYG.mo29311c(i, i2, str);
                                    if (i2 == 1 && !c) {
                                        InstagramPickerFragment.this.dYJ.mo33282mt(str);
                                    }
                                }
                            }
                        });
                    }
                }

                public void onError() {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tj */
    public void m23777tj(int i) {
        if (this.dYH != null) {
            this.dYH.mo33333a((Activity) getActivity(), i, new MSize(700, 700), (C8196c) new C8196c() {
                public void onError(Throwable th) {
                    InstagramPickerFragment.this.mo33369iV(true);
                    InstagramPickerFragment.this.dYJ.mo33281cC(new ArrayList());
                }

                public void onSuccess(List<C8215c> list) {
                    if (list != null) {
                        for (C8215c iU : list) {
                            iU.mo33354iU(true);
                        }
                        if (list.size() == 0) {
                            InstagramPickerFragment.this.mo33369iV(true);
                        } else {
                            InstagramPickerFragment.this.mo33369iV(false);
                        }
                        InstagramPickerFragment.this.dYJ.mo33281cC(list);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.picker_instagram_fragment_layout, viewGroup, false);
        aFM();
        m23772Oj();
    }

    public void aFO() {
        super.aFO();
    }

    /* renamed from: al */
    public void mo33366al(int i, boolean z) {
        if (this.bwy == null) {
            this.mSourceType = i;
            return;
        }
        if (SnsAuthServiceProxy.isAuthed(31)) {
            if (this.dYU.isShown()) {
                this.dYU.setVisibility(8);
            }
            if (this.mSourceType != i) {
                m23777tj(i);
            } else {
                return;
            }
        }
        this.mSourceType = i;
    }

    /* renamed from: th */
    public void mo33372th(int i) {
        super.mo33372th(i);
        if (this.dYU != null) {
            LayoutParams layoutParams = (LayoutParams) this.dYU.getLayoutParams();
            layoutParams.topMargin += i / 2;
            this.dYU.setLayoutParams(layoutParams);
            this.dYU.invalidate();
        }
    }
}
