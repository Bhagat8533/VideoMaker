package com.introvd.template.app.school.testa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.introvd.template.app.school.C4191j;
import com.introvd.template.app.school.SchoolCourseItemListView;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7378q;
import com.introvd.template.xyui.p420a.C9151a;
import com.introvd.template.xyui.p420a.C9156d;

/* renamed from: com.introvd.template.app.school.testa.a */
public class C4245a extends C9151a<BottomRecyclerDataModel, C9156d> {
    /* renamed from: hw */
    private BottomRecyclerDataModel m10638hw(int i) {
        if (getDataList() == null || getDataList().size() <= i) {
            return null;
        }
        return (BottomRecyclerDataModel) getDataList().get(i);
    }

    /* renamed from: a */
    public void onViewRecycled(C9156d dVar) {
        super.onViewRecycled(dVar);
        if (dVar instanceof C4247c) {
            ((C4247c) dVar).mo24244Ns();
        } else if (dVar.itemView instanceof SchoolCourseItemListView) {
            ((SchoolCourseItemListView) dVar.itemView).mo23820Ns();
        }
    }

    /* renamed from: a */
    public boolean mo24004a(BottomRecyclerDataModel bottomRecyclerDataModel, BottomRecyclerDataModel bottomRecyclerDataModel2) {
        return true;
    }

    /* renamed from: d */
    public void onBindViewHolder(C9156d dVar, int i) {
        BottomRecyclerDataModel hw = m10638hw(i);
        if (hw != null) {
            if ((dVar instanceof C4247c) && hw.type == 1) {
                ((C4247c) dVar).mo24245a(hw);
            } else if ((dVar.itemView instanceof SchoolCourseItemListView) && hw.type == 2) {
                ((SchoolCourseItemListView) dVar.itemView).setData(C4191j.m10442Nv().mo24154NE());
            }
        }
    }

    public int getItemCount() {
        if (getDataList() != null) {
            return getDataList().size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        BottomRecyclerDataModel hw = m10638hw(i);
        return hw == null ? super.getItemViewType(i) : hw.type;
    }

    /* renamed from: m */
    public C9156d onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new C4247c(C7378q.m21747d(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        }
        if (i == 3) {
            View view = new View(viewGroup.getContext());
            view.setLayoutParams(new LayoutParams(-1, C4583d.m11673ii(24)));
            return new C9156d(view);
        }
        SchoolCourseItemListView schoolCourseItemListView = new SchoolCourseItemListView(viewGroup.getContext());
        schoolCourseItemListView.setLayoutParams(new LayoutParams(-1, -2));
        return new C9156d(schoolCourseItemListView);
    }
}
