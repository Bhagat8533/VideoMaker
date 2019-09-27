package com.introvd.template.explorer.music.adapter;

import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.introvd.template.explorer.music.item.C7301c;
import com.introvd.template.explorer.music.item.MusicCategoryTabView;
import java.util.ArrayList;
import java.util.List;

public class MusicCategoryTabAdapter extends FragmentPagerAdapter {
    private List<C7301c> dAK = new ArrayList();

    public MusicCategoryTabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /* renamed from: bP */
    public void mo31844bP(List<C7301c> list) {
        this.dAK.clear();
        this.dAK.addAll(list);
        notifyDataSetChanged();
    }

    public void finishUpdate(ViewGroup viewGroup) {
        try {
            super.finishUpdate(viewGroup);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return this.dAK.size();
    }

    public Fragment getItem(int i) {
        return ((C7301c) this.dAK.get(i)).getFragment();
    }

    public long getItemId(int i) {
        return (long) Integer.valueOf(((C7301c) this.dAK.get(i)).getId()).intValue();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public CharSequence getPageTitle(int i) {
        return ((C7301c) this.dAK.get(i)).getTitle();
    }

    public boolean isEmpty() {
        return this.dAK == null || this.dAK.isEmpty();
    }

    /* renamed from: qJ */
    public C7301c mo31846qJ(int i) {
        if (this.dAK != null && this.dAK.size() > i) {
            return (C7301c) this.dAK.get(i);
        }
        return null;
    }

    /* renamed from: qK */
    public MusicCategoryTabView mo31847qK(int i) {
        return ((C7301c) this.dAK.get(i)).axs();
    }
}
