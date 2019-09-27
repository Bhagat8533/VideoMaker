package com.introvd.template.app.school;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0373b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.school.p196b.C4164d;
import com.introvd.template.app.school.testa.BottomRecyclerView;
import com.introvd.template.p203b.C4583d;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolCreationFragmentTestA extends BaseSchoolCreationFragment {
    private static final int bwL = C4583d.m11673ii(70);
    private BottomRecyclerView bwS;

    /* renamed from: Iy */
    private void m10298Iy() {
        C4206n.m10505NL().mo24169NM();
        C4191j.m10442Nv().mo24152NC();
        C4191j.m10442Nv().mo24153ND();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m10300e(AppBarLayout appBarLayout, int i) {
        if (getActivity() != null) {
            boolean z = i >= 0;
            this.bwv.setEnabled(z);
            if (z) {
                this.bww.setTitle(R.string.xiaoying_str_com_creation);
            } else if (this.bwS.mo24233hx(bwL)) {
                this.bww.setTitle(R.string.xiaoying_str_creator_recommend_template);
            } else {
                this.bww.setTitle(R.string.xiaoying_str_com_creation);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Kp */
    public void mo23814Kp() {
        m10298Iy();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cD */
    public View mo23816cD(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        View view = new View(context);
        LayoutParams layoutParams = new LayoutParams(-1, C4583d.m11673ii(10));
        view.setBackgroundColor(VivaBaseApplication.m8749FZ().getResources().getColor(R.color.color_f5f6f7));
        frameLayout.addView(view, layoutParams);
        return frameLayout;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cE */
    public View mo23817cE(Context context) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cF */
    public View mo23818cF(Context context) {
        this.bwS = new BottomRecyclerView(context);
        return this.bwS;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.bwx.mo1528a((C0373b) new C4189h(this));
        m10298Iy();
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        return onCreateView;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4164d dVar) {
        this.bwv.setRefreshing(false);
        if (getActivity() != null && !getActivity().isFinishing() && dVar != null) {
            this.bwS.setData(dVar.byH);
        }
    }
}
