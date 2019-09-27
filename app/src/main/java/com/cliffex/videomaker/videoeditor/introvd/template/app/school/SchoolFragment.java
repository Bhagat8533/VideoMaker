package com.introvd.template.app.school;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p184h.C3886a;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.user.UserRouter.BroadCastConstant;
import com.vivavideo.mobile.h5api.api.C9353o;

public class SchoolFragment extends FragmentBase {
    private FrameLayout bxo;
    private boolean bxp;
    private C9353o bxq;
    private BroadcastReceiver bxr = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            SchoolFragment.this.mo23827NJ();
        }
    };
    private BroadcastReceiver bxs = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            SchoolFragment.this.mo23827NJ();
        }
    };

    /* renamed from: NG */
    private void m10321NG() {
        ((TextView) this.bxo.findViewById(R.id.tvHint)).setVisibility(0);
    }

    /* renamed from: NH */
    private void m10322NH() {
        ((TextView) this.bxo.findViewById(R.id.tvHint)).setVisibility(8);
    }

    /* renamed from: NI */
    private void m10323NI() {
        if (!this.bxp) {
            if (((IAppService) BizServiceManager.getService(IAppService.class)) == null) {
                m10321NG();
            } else if (TextUtils.isEmpty(C3742b.m9111II().mo23147JO())) {
                m10321NG();
            } else {
                this.bxq = C3886a.m9562a(C3742b.m9111II().mo23147JO(), getActivity());
                if (this.bxq == null || this.bxq.getContentView() == null) {
                    m10321NG();
                    return;
                }
                this.bxo.addView(this.bxq.getContentView());
                m10322NH();
                this.bxp = true;
            }
        }
    }

    /* renamed from: eu */
    private void m10324eu() {
        if (this.bxq != null) {
            this.bxq.aPE().mo36554a("webShow", null, null);
            LogUtilsV2.m14227d("send webShow message");
        }
    }

    /* renamed from: NJ */
    public void mo23827NJ() {
        if (this.bxq != null) {
            this.bxq.aPE().mo36554a("webReload", null, null);
            LogUtilsV2.m14227d("send webReload message");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() != null) {
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.bxr, new IntentFilter(BroadCastConstant.ACTION_LOGIN_CB_SUCCESS));
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.bxs, new IntentFilter(BroadCastConstant.ACTION_LOGOUT_SUCCESS));
        }
        this.bxo = (FrameLayout) layoutInflater.inflate(R.layout.comm_frag_school, viewGroup, false);
        m10323NI();
        return this.bxo;
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.bxr);
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.bxs);
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        if (!this.bxp) {
            m10323NI();
        } else {
            m10324eu();
        }
    }
}
