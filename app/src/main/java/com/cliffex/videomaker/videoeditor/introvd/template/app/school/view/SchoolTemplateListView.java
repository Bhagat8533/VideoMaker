package com.introvd.template.app.school.view;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.graphics.Rect;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.app.school.C4191j;
import com.introvd.template.app.school.p196b.C4163c;
import com.introvd.template.p203b.C4583d;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolTemplateListView extends RecyclerView implements C0068f {
    private C4272d bAt;

    public SchoolTemplateListView(Context context) {
        super(context);
        init();
    }

    public SchoolTemplateListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SchoolTemplateListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.right = C4583d.m11673ii(12);
            }
        });
        this.bAt = new C4272d();
        setAdapter(this.bAt);
    }

    /* renamed from: Kp */
    public void mo24272Kp() {
        C4191j.m10442Nv().mo24151NA();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4163c cVar) {
        if (cVar != null && !cVar.getDataList().isEmpty()) {
            this.bAt.setDataList(cVar.getDataList());
            this.bAt.notifyDataSetChanged();
        }
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        C10021c.aZH().mo38496az(this);
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
    }

    @C0078n(mo161n = C0062a.ON_START)
    public void onStart() {
        mo24272Kp();
    }
}
