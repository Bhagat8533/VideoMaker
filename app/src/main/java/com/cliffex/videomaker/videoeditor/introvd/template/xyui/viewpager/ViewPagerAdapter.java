package com.introvd.template.xyui.viewpager;

import android.support.p021v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ViewPagerAdapter<T extends View> extends PagerAdapter {
    private ArrayList<T> eEi;

    public ViewPagerAdapter(ArrayList<T> arrayList) {
        this.eEi = arrayList;
    }

    public ArrayList<T> aOj() {
        return this.eEi;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.eEi.get(i));
    }

    public int getCount() {
        return this.eEi.size();
    }

    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = (View) this.eEi.get(i);
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* renamed from: mN */
    public T mo36228mN(int i) {
        if (this.eEi == null || i >= this.eEi.size() || i < 0) {
            return null;
        }
        return (View) this.eEi.get(i);
    }
}
