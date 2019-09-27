package com.introvd.template.app.school;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;
import com.introvd.template.app.school.p196b.C4161a;
import com.introvd.template.app.school.view.SchoolCourseViewPagerAct;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7374m;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolCourseItemListView extends ConstraintLayout {
    private C4170c bwD;

    public SchoolCourseItemListView(Context context) {
        super(context);
        m10281Iu();
    }

    public SchoolCourseItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10281Iu();
    }

    public SchoolCourseItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10281Iu();
    }

    /* renamed from: Iu */
    private void m10281Iu() {
        C7374m b = C7374m.m21735b(LayoutInflater.from(getContext()), this, true);
        b.coP.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        b.coP.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.right = C4583d.m11673ii(12);
            }
        });
        this.bwD = new C4170c();
        b.coP.setAdapter(this.bwD);
        b.cpx.setOnClickListener(new C4160b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bK */
    public /* synthetic */ void m10283bK(View view) {
        UserBehaviorLog.onKVEvent(getContext(), "Click_Course_More", new HashMap());
        getContext().startActivity(new Intent(getContext(), SchoolCourseViewPagerAct.class));
    }

    /* renamed from: Ns */
    public void mo23820Ns() {
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4161a aVar) {
        if (aVar != null && !aVar.getList().isEmpty()) {
            this.bwD.mo36114dh(aVar.getList());
        }
    }

    public void setData(List<SchoolCourseInfo> list) {
        if (list != null) {
            if (!C10021c.aZH().mo38495ay(this)) {
                C10021c.aZH().mo38494ax(this);
            }
            this.bwD.mo36114dh(list);
        }
    }
}
