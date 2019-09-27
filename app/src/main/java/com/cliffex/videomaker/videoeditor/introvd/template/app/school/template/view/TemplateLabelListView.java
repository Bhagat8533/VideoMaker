package com.introvd.template.app.school.template.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.HotFixRecyclerView;
import java.util.List;

public class TemplateLabelListView extends HotFixRecyclerView {
    /* access modifiers changed from: private */
    public static final int byJ = C4583d.m11673ii(15);
    private C4236b bzG;

    public TemplateLabelListView(Context context) {
        super(context);
        m10615Oj();
    }

    public TemplateLabelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10615Oj();
    }

    public TemplateLabelListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10615Oj();
    }

    /* renamed from: Oj */
    private void m10615Oj() {
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = TemplateLabelListView.byJ;
                rect.right = TemplateLabelListView.byJ;
            }
        });
        setBackgroundColor(getResources().getColor(R.color.white));
        this.bzG = new C4236b(getContext());
        setAdapter(this.bzG);
    }

    public C4236b getLabelAdapter() {
        return this.bzG;
    }

    public void setData(List<VideoLabelInfo> list) {
        this.bzG.setDataList(list);
        this.bzG.notifyDataSetChanged();
    }

    public void setTemplateLabelListener(C4235a aVar) {
        this.bzG.setTemplateLabelListener(aVar);
    }
}
