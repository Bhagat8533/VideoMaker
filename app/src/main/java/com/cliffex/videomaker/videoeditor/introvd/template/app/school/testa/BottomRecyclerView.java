package com.introvd.template.app.school.testa;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import java.util.ArrayList;
import java.util.List;

public class BottomRecyclerView extends RecyclerView {
    private C4245a bzU;

    public BottomRecyclerView(Context context) {
        super(context);
        init();
    }

    public BottomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BottomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.bzU = new C4245a();
        setAdapter(this.bzU);
    }

    /* renamed from: hx */
    public boolean mo24233hx(int i) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return i >= iArr[1];
    }

    public void setData(List<VideoLabelInfo> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (VideoLabelInfo videoLabelInfo : list) {
            BottomRecyclerDataModel bottomRecyclerDataModel = new BottomRecyclerDataModel();
            bottomRecyclerDataModel.title = videoLabelInfo.getName();
            bottomRecyclerDataModel.type = 1;
            bottomRecyclerDataModel.labelID = videoLabelInfo.getId().longValue();
            bottomRecyclerDataModel.labelName = videoLabelInfo.getName();
            int i2 = i + 1;
            bottomRecyclerDataModel.labelIndexInList = i;
            arrayList.add(bottomRecyclerDataModel);
            i = i2;
        }
        BottomRecyclerDataModel bottomRecyclerDataModel2 = new BottomRecyclerDataModel();
        bottomRecyclerDataModel2.type = 2;
        arrayList.add(arrayList.isEmpty() ^ true ? 1 : 0, bottomRecyclerDataModel2);
        BottomRecyclerDataModel bottomRecyclerDataModel3 = new BottomRecyclerDataModel();
        bottomRecyclerDataModel3.type = 3;
        arrayList.add(bottomRecyclerDataModel3);
        this.bzU.mo36114dh(arrayList);
    }
}
