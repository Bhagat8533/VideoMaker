package com.introvd.template.picker.adapter;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.picker.R;
import com.introvd.template.picker.fragment.AbstractPickerFragment;
import java.util.ArrayList;
import java.util.List;

public class PickerPagerAdapter extends FragmentPagerAdapter {
    private List<Integer> dHr = new ArrayList();
    private Context mContext;
    private List<AbstractPickerFragment> mFragments = new ArrayList();

    public PickerPagerAdapter(Context context, List<Integer> list, FragmentManager fragmentManager, List<AbstractPickerFragment> list2) {
        super(fragmentManager);
        this.mContext = context;
        this.dHr = list;
        this.mFragments = list2;
    }

    public int getCount() {
        return this.mFragments.size();
    }

    public Fragment getItem(int i) {
        if (i < this.mFragments.size()) {
            return (AbstractPickerFragment) this.mFragments.get(i);
        }
        return null;
    }

    public CharSequence getPageTitle(int i) {
        return this.mContext.getString(((Integer) this.dHr.get(i)).intValue());
    }

    /* renamed from: ox */
    public View mo33263ox(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.picker_tab_item_layout, null);
        ((TextView) inflate.findViewById(R.id.picker_tab_mode_title)).setText(getPageTitle(i));
        return inflate;
    }
}
