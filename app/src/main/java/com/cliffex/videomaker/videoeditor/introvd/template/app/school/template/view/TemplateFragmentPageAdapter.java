package com.introvd.template.app.school.template.view;

import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentStatePagerAdapter;
import com.introvd.template.app.school.template.TemplateListFragment;
import java.util.List;

public class TemplateFragmentPageAdapter extends FragmentStatePagerAdapter {
    private List<TemplateListFragment> bzA;

    public TemplateFragmentPageAdapter(FragmentManager fragmentManager, List<TemplateListFragment> list) {
        super(fragmentManager);
        this.bzA = list;
    }

    public int getCount() {
        return this.bzA.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    /* renamed from: hs */
    public TemplateListFragment getItem(int i) {
        return (TemplateListFragment) this.bzA.get(i);
    }
}
