package com.introvd.template.xyui.viewpager;

import android.support.p021v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class ListViewPagerAdapter extends PagerAdapter {
    private List<String> dHr;
    private ArrayList<View> eEi;

    public ListViewPagerAdapter(ArrayList<View> arrayList) {
        this.eEi = arrayList;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.eEi.get(i));
    }

    /* renamed from: di */
    public void mo36226di(List<String> list) {
        this.dHr = list;
    }

    public int getCount() {
        return this.eEi.size();
    }

    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i) {
        if (this.dHr != null) {
            return (String) this.dHr.get(i);
        }
        return null;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = (View) this.eEi.get(i);
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
