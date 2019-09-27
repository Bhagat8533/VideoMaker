package com.introvd.template.editor.effects.nav;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.editor.cache.C8441b;
import java.util.ArrayList;
import java.util.List;

public class NavEffectTitleLayout extends LinearLayout {

    /* renamed from: Vu */
    private RecyclerView f3500Vu;
    private CustomRecyclerViewAdapter cNl;
    private List<BaseItem> cNm = new ArrayList();

    public NavEffectTitleLayout(Context context) {
        super(context);
        m17714Oj();
    }

    public NavEffectTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17714Oj();
    }

    public NavEffectTitleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17714Oj();
    }

    /* renamed from: Oj */
    private void m17714Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_collage_title_category_layout, this, true);
        this.f3500Vu = (RecyclerView) findViewById(R.id.video_editor_collage_category_recycler);
        this.cNl = new CustomRecyclerViewAdapter(null);
        this.f3500Vu.setAdapter(this.cNl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f3500Vu.setLayoutManager(linearLayoutManager);
    }

    /* renamed from: nk */
    public void mo29002nk(int i) {
        for (int i2 = 0; i2 < this.cNm.size(); i2++) {
            C6186c cVar = (C6186c) this.cNm.get(i2);
            if (i2 == i) {
                cVar.mo29006fG(true);
            } else {
                cVar.mo29006fG(false);
            }
        }
    }

    public void setData(List<C8441b> list, int i) {
        if (list != null) {
            this.cNm.clear();
            for (C8441b cVar : list) {
                this.cNm.add(new C6186c(getContext(), cVar, i));
            }
            this.cNl.setData(this.cNm);
        }
    }
}
