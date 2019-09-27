package com.introvd.template.explorer.music.adapter;

import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.View;
import com.introvd.template.explorer.music.item.C7307e;
import java.util.ArrayList;
import java.util.List;

public class MusicTabAdapter extends FragmentPagerAdapter {
    private List<C7307e> dAL = new ArrayList();

    public MusicTabAdapter(Fragment fragment, List<C7307e> list) {
        super(fragment.getChildFragmentManager());
        if (list != null) {
            this.dAL.addAll(list);
        }
    }

    public int getCount() {
        return this.dAL.size();
    }

    public Fragment getItem(int i) {
        return ((C7307e) this.dAL.get(i)).axC();
    }

    public CharSequence getPageTitle(int i) {
        return ((C7307e) this.dAL.get(i)).axD();
    }

    public void onHiddenChanged(boolean z) {
        for (C7307e axC : this.dAL) {
            axC.axC().mo31809ia(z);
        }
    }

    /* renamed from: ox */
    public View mo31849ox(int i) {
        return ((C7307e) this.dAL.get(i)).axE();
    }
}
