package com.introvd.template.explorer.music;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter;
import com.introvd.template.explorer.music.p304b.C7271j;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.p054b.C1494a;

public abstract class MusicBaseFragment extends Fragment {
    protected View btV;
    private boolean bxM;
    protected C1494a compositeDisposable;
    protected MusicCategoryTabAdapter dAd;
    protected XYViewPager mViewPager;

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public abstract void mo31805Oj();

    /* access modifiers changed from: protected */
    public void awI() {
        if (this.btV != null && getUserVisibleHint() && !this.bxM) {
            LogUtilsV2.m14227d("Jamin ViewPage LazyLoad  = ");
            initData();
            this.bxM = true;
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    /* renamed from: hZ */
    public void mo31808hZ(boolean z) {
        this.bxM = z;
    }

    /* renamed from: ia */
    public void mo31809ia(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void initData();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.compositeDisposable = new C1494a();
        this.btV = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        mo31805Oj();
        if (this.mViewPager != null) {
            this.mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPageSelected = ");
                    sb.append(i);
                    LogUtilsV2.m14227d(sb.toString());
                    C10021c.aZH().mo38492aA(new C7271j(1, i));
                }
            });
        }
        awI();
        return this.btV;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        awI();
    }
}
