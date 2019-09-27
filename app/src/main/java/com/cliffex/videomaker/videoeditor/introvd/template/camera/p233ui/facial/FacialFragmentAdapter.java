package com.introvd.template.camera.p233ui.facial;

import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.facial.FacialFragmentAdapter */
public class FacialFragmentAdapter extends FragmentPagerAdapter {
    private List<CameraFacialFragment> bVF;

    public FacialFragmentAdapter(FragmentManager fragmentManager, List<CameraFacialFragment> list) {
        super(fragmentManager);
        this.bVF = list;
    }

    public int getCount() {
        return this.bVF.size();
    }

    public Fragment getItem(int i) {
        return (Fragment) this.bVF.get(i);
    }
}
