package com.introvd.template.editor.slideshow.funny.adapter;

import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.introvd.template.editor.slideshow.funny.view.FunnyTabView;
import java.util.ArrayList;
import java.util.List;

public class FunnyCategoryAdapter extends FragmentPagerAdapter {
    private List<C6819a> dgX = new ArrayList();

    public FunnyCategoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /* renamed from: bG */
    public void mo30384bG(List<C6819a> list) {
        this.dgX.clear();
        this.dgX.addAll(list);
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
        return this.dgX.size();
    }

    public Fragment getItem(int i) {
        return ((C6819a) this.dgX.get(i)).getFragment();
    }

    public long getItemId(int i) {
        return ((C6819a) this.dgX.get(i)).getId();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    /* renamed from: pi */
    public C6819a mo30385pi(int i) {
        if (this.dgX != null && this.dgX.size() > i) {
            return (C6819a) this.dgX.get(i);
        }
        return null;
    }

    /* renamed from: pj */
    public FunnyTabView mo30386pj(int i) {
        return ((C6819a) this.dgX.get(i)).arF();
    }
}
