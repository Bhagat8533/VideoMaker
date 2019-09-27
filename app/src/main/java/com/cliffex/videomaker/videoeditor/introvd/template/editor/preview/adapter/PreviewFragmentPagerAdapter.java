package com.introvd.template.editor.preview.adapter;

import android.content.Context;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentPagerAdapter;
import android.view.View;
import com.introvd.template.editor.preview.fragment.BasePreviewFragment;
import com.introvd.template.editor.preview.view.PreviewTabView;
import java.util.List;

public class PreviewFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BasePreviewFragment> bzA;
    private Context context;

    public PreviewFragmentPagerAdapter(Context context2, FragmentManager fragmentManager, List<BasePreviewFragment> list) {
        super(fragmentManager);
        this.context = context2;
        this.bzA = list;
    }

    public int getCount() {
        return this.bzA.size();
    }

    /* renamed from: ow */
    public BasePreviewFragment getItem(int i) {
        return (BasePreviewFragment) this.bzA.get(i);
    }

    /* renamed from: ox */
    public View mo29799ox(int i) {
        PreviewTabView previewTabView = new PreviewTabView(this.context);
        previewTabView.mo30091oS(i);
        return previewTabView;
    }
}
