package com.introvd.template.common.p236ui;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.p021v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.introvd.template.common.ui.a */
class C5314a extends PagerAdapter {
    private final PagerAdapter cfK;
    /* access modifiers changed from: private */
    public final DataSetObservable cfL = new DataSetObservable();

    protected C5314a(PagerAdapter pagerAdapter) {
        this.cfK = pagerAdapter;
    }

    /* renamed from: Zm */
    public void mo26717Zm() {
        this.cfK.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                C5314a.super.notifyDataSetChanged();
                C5314a.this.cfL.notifyChanged();
            }

            public void onInvalidated() {
                C5314a.this.cfL.notifyInvalidated();
            }
        });
    }

    /* renamed from: Zn */
    public PagerAdapter mo26718Zn() {
        return this.cfK;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.cfK.destroyItem(viewGroup, i, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.cfK.finishUpdate(viewGroup);
    }

    public int getCount() {
        return this.cfK.getCount();
    }

    public int getItemPosition(Object obj) {
        return this.cfK.getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i) {
        return this.cfK.getPageTitle(i);
    }

    public float getPageWidth(int i) {
        return this.cfK.getPageWidth(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return this.cfK.instantiateItem(viewGroup, i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return this.cfK.isViewFromObject(view, obj);
    }

    public void notifyDataSetChanged() {
        this.cfK.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.cfL.registerObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.cfK.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.cfK.saveState();
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.cfK.setPrimaryItem(viewGroup, i, obj);
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.cfK.startUpdate(viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.cfL.unregisterObserver(dataSetObserver);
    }
}
