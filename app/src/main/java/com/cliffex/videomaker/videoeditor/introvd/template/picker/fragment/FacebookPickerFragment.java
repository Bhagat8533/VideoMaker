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
import android.widget.ImageView;
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
import com.introvd.template.picker.adapter.C8173a;
import com.introvd.template.picker.adapter.C8180c;
import com.introvd.template.picker.adapter.C8180c.C8183a;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.picker.p366b.C8190c;
import com.introvd.template.picker.p367c.C8192a;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p367c.p368a.C8194a;
import com.introvd.template.picker.p367c.p368a.C8195b;
import com.introvd.template.picker.p367c.p368a.C8196c;
import com.introvd.template.picker.p369d.C8219c;
import com.introvd.template.picker.view.CoordinatorRecyclerView;
import com.introvd.template.router.user.SnsAuthListener;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import java.util.ArrayList;
import java.util.List;

public class FacebookPickerFragment extends AbstractPickerFragment {
    protected C8183a dYS = new C8183a() {
        /* renamed from: e */
        public boolean mo33287e(int i, int i2, String str) {
            FacebookPickerFragment.this.m23763f(i, i2, str);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public LinearLayout dYU;
    private TextView dYV;
    private TextView dYW;
    private RelativeLayout dYX;
    /* access modifiers changed from: private */
    public RelativeLayout dYY;
    /* access modifiers changed from: private */
    public ImageView dYZ;
    /* access modifiers changed from: private */
    public CoordinatorRecyclerView dZa;
    /* access modifiers changed from: private */
    public C8173a dZb;

    /* renamed from: Oj */
    private void m23752Oj() {
        aFQ();
        aFR();
        ayl();
        this.dYY = (RelativeLayout) this.bwy.findViewById(R.id.layout_media);
        this.dYZ = (ImageView) this.bwy.findViewById(R.id.folder_back_icon);
        LayoutParams layoutParams = (LayoutParams) this.dYZ.getLayoutParams();
        layoutParams.topMargin = this.dYO;
        this.dYZ.setLayoutParams(layoutParams);
        if (SnsAuthServiceProxy.isAuthed(28)) {
            this.dYU.setVisibility(8);
            m23765ti(this.mSourceType);
        } else {
            this.dYU.setVisibility(0);
        }
        this.dYZ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FacebookPickerFragment.this.ayi();
            }
        });
    }

    private void aFQ() {
        this.dYU = (LinearLayout) this.bwy.findViewById(R.id.layout_picker_sns_login);
        this.dYV = (TextView) this.bwy.findViewById(R.id.tv_picker_sns_login_desc);
        this.dYX = (RelativeLayout) this.bwy.findViewById(R.id.picker_sns_facebook);
        this.dYW = (TextView) this.bwy.findViewById(R.id.sns_login_text);
        C8219c.m23737dn(this.dYX);
        this.dYV.setText(getContext().getResources().getString(R.string.xiaoying_str_gallery_sns_get_meida_desc, new Object[]{getContext().getResources().getString(R.string.xiaoying_str_com_intl_share_facebook)}));
        this.dYW.setText(getContext().getResources().getString(R.string.xiaoying_str_com_intl_login_continue, new Object[]{getContext().getResources().getString(R.string.xiaoying_str_com_intl_share_facebook)}));
        LayoutParams layoutParams = (LayoutParams) this.dYU.getLayoutParams();
        layoutParams.topMargin = this.dYN;
        this.dYU.setLayoutParams(layoutParams);
        this.dYX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C4600l.m11739k(FacebookPickerFragment.this.getActivity(), false)) {
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), VivaBaseApplication.m8749FZ().getResources().getString(R.string.xiaoying_str_com_msg_network_inactive), 1);
                    return;
                }
                FacebookPickerFragment.this.dYF.mo33254sX(28);
                SnsAuthServiceProxy.auth(FacebookPickerFragment.this.getActivity(), new Builder().snsType(28).snsAuthListener(new SnsAuthListener() {
                    public void onAuthCancel(int i) {
                        LogUtils.m14223i("FacebookPicker", ">>> onAuthCancel...");
                    }

                    public void onAuthComplete(int i, Bundle bundle) {
                        LogUtils.m14223i("FacebookPicker", ">>> onAuthComplete...");
                        FacebookPickerFragment.this.dYU.setVisibility(8);
                        FacebookPickerFragment.this.m23765ti(FacebookPickerFragment.this.mSourceType);
                    }

                    public void onAuthFail(int i, int i2, String str) {
                        LogUtils.m14223i("FacebookPicker", ">>> onAuthFail...");
                    }
                }));
            }
        });
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
                FacebookPickerFragment.this.m23758b(aVar);
            }

            public void aFC() {
            }
        });
        this.dZa.setAdapter(this.dZb);
    }

    public static FacebookPickerFragment aFS() {
        FacebookPickerFragment facebookPickerFragment = new FacebookPickerFragment();
        facebookPickerFragment.setArguments(new Bundle());
        return facebookPickerFragment;
    }

    /* access modifiers changed from: private */
    public void ayi() {
        if (this.mSourceType == 0) {
            this.dYM = false;
            this.dYY.setVisibility(8);
            this.dZa.setVisibility(0);
            if (this.dYG != null) {
                this.dYG.amE();
                this.dYG.mo29312i(false, null);
            }
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
    public void m23758b(C8192a aVar) {
        if (this.mSourceType == 0) {
            this.dYM = true;
            this.dZa.setVisibility(8);
            this.dYJ.mo33281cC(new ArrayList());
            this.dYZ.setVisibility(0);
            this.dYY.setVisibility(0);
            if (this.dYG != null) {
                this.dYG.mo29312i(true, aVar.getTitle());
            }
            m23764mB(aVar.getAlbumId());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23763f(final int i, final int i2, String str) {
        if (this.dYH != null) {
            this.dYH.mo33336a(str, i, 28, (C8194a) new C8194a() {
                /* renamed from: dV */
                public void mo33325dV(final String str) {
                    if (FacebookPickerFragment.this.getActivity() != null) {
                        FacebookPickerFragment.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                if (FacebookPickerFragment.this.dYG != null) {
                                    boolean c = FacebookPickerFragment.this.dYG.mo29311c(i, i2, str);
                                    if (i2 == 1 && !c) {
                                        FacebookPickerFragment.this.dYJ.mo33282mt(str);
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

    /* renamed from: mB */
    private void m23764mB(String str) {
        if (this.dYH != null) {
            this.dYH.mo33335a((Activity) getActivity(), str, new MSize(700, 700), (C8196c) new C8196c() {
                public void onError(Throwable th) {
                    FacebookPickerFragment.this.mo33369iV(true);
                }

                public void onSuccess(List<C8215c> list) {
                    if (list != null && FacebookPickerFragment.this.mSourceType == 0 && FacebookPickerFragment.this.dYM) {
                        for (C8215c iU : list) {
                            iU.mo33354iU(true);
                        }
                        if (list.size() == 0) {
                            FacebookPickerFragment.this.mo33369iV(true);
                        } else {
                            FacebookPickerFragment.this.mo33369iV(false);
                        }
                        FacebookPickerFragment.this.dYJ.mo33281cC(list);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ti */
    public void m23765ti(final int i) {
        if (this.dYH != null) {
            this.dYH.mo33334a((Activity) getActivity(), new MSize(700, 700), i, (C8195b) new C8195b() {
                public void onError(Throwable th) {
                    FacebookPickerFragment.this.dZa.setVisibility(0);
                    FacebookPickerFragment.this.dYY.setVisibility(8);
                    FacebookPickerFragment.this.dZb.mo33265cB(new ArrayList());
                    FacebookPickerFragment.this.mo33369iV(true);
                }

                public void onSuccess(List<C8192a> list) {
                    if (list == null || list.size() == 0) {
                        FacebookPickerFragment.this.dZa.setVisibility(0);
                        FacebookPickerFragment.this.dYY.setVisibility(8);
                        FacebookPickerFragment.this.dZb.mo33265cB(new ArrayList());
                        FacebookPickerFragment.this.mo33369iV(true);
                        return;
                    }
                    FacebookPickerFragment.this.mo33369iV(false);
                    if (i == 1) {
                        FacebookPickerFragment.this.dZa.setVisibility(8);
                        FacebookPickerFragment.this.dYZ.setVisibility(8);
                        FacebookPickerFragment.this.dYY.setVisibility(0);
                        List<C8215c> aFE = ((C8192a) list.get(0)).aFE();
                        for (C8215c iU : aFE) {
                            iU.mo33354iU(true);
                        }
                        FacebookPickerFragment.this.dYJ.mo33281cC(aFE);
                    } else if (i == 0) {
                        FacebookPickerFragment.this.dZa.setVisibility(0);
                        FacebookPickerFragment.this.dYY.setVisibility(8);
                        FacebookPickerFragment.this.dZb.mo33265cB(list);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33360a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.picker_facebook_fragment_layout, viewGroup, false);
        aFM();
        m23752Oj();
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
        if (SnsAuthServiceProxy.isAuthed(28)) {
            if (this.dYU.isShown()) {
                this.dYU.setVisibility(8);
            }
            if (this.mSourceType != i) {
                if (this.dYM) {
                    ayi();
                }
                m23765ti(i);
            } else {
                return;
            }
        }
        this.mSourceType = i;
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
        if (this.dYU != null) {
            LayoutParams layoutParams2 = (LayoutParams) this.dYU.getLayoutParams();
            layoutParams2.topMargin += i / 2;
            this.dYU.setLayoutParams(layoutParams2);
            this.dYU.invalidate();
        }
    }
}
