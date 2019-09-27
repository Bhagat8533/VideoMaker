package com.introvd.template.gallery.adapter;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.gallery.AbstractGalleryFragment;
import com.introvd.template.xygallery.R;
import java.util.ArrayList;
import java.util.List;

public class GalleryPagerAdapter extends FragmentPagerAdapter {
    private List<Integer> dHr = new ArrayList();
    private Context mContext;
    private List<AbstractGalleryFragment> mFragments = new ArrayList();

    public GalleryPagerAdapter(Context context, List<Integer> list, FragmentManager fragmentManager, List<AbstractGalleryFragment> list2) {
        super(fragmentManager);
        this.mContext = context;
        this.dHr = list;
        this.mFragments = list2;
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int i) {
        if (i < this.mFragments.size()) {
            return (AbstractGalleryFragment) this.mFragments.get(i);
        }
        return null;
    }

    public CharSequence getPageTitle(int i) {
        return this.mContext.getString(((Integer) this.dHr.get(i)).intValue());
    }

    /* renamed from: ox */
    public View mo32059ox(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gallery_item_tab, null);
        ((TextView) inflate.findViewById(R.id.tab_gallery_mode_item)).setText(getPageTitle(i));
        return inflate;
    }
}
