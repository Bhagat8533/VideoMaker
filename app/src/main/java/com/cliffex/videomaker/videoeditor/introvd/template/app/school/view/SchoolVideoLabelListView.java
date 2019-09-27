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
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.p196b.C4168h;
import com.introvd.template.app.school.p196b.C4169i;
import com.introvd.template.p203b.C4583d;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolVideoLabelListView extends RecyclerView implements C0068f {
    /* access modifiers changed from: private */
    public static final int byJ = C4583d.m11673ii(15);
    private C4276g bAy;

    public SchoolVideoLabelListView(Context context) {
        super(context);
        init();
    }

    public SchoolVideoLabelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SchoolVideoLabelListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setBackgroundColor(-1);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = SchoolVideoLabelListView.byJ;
                rect.right = SchoolVideoLabelListView.byJ;
            }
        });
        this.bAy = new C4276g();
        setAdapter(this.bAy);
    }

    /* renamed from: Kp */
    public void mo24277Kp() {
        C4191j.m10442Nv().mo24155Nw();
    }

    /* renamed from: hx */
    public boolean mo24278hx(int i) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return i >= iArr[1];
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onCreate() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        mo24277Kp();
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4168h hVar) {
        if (hVar != null && !hVar.getDataList().isEmpty()) {
            this.bAy.setDataList(hVar.getDataList());
            this.bAy.notifyDataSetChanged();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4169i iVar) {
        if (iVar != null) {
            VideoLabelInfo videoLabelInfo = (VideoLabelInfo) this.bAy.getListItem(iVar.getIndex(), false);
            int Ny = C4191j.m10442Nv().mo24156Ny();
            if (Ny != videoLabelInfo.getId().intValue()) {
                for (VideoLabelInfo videoLabelInfo2 : this.bAy.getDataList()) {
                    if (videoLabelInfo2.getId().intValue() == Ny) {
                        videoLabelInfo2.isSelectedField().set(Boolean.valueOf(false));
                    }
                }
                videoLabelInfo.isSelectedField().set(Boolean.valueOf(true));
                C4191j.m10442Nv().mo24159g(videoLabelInfo.getId().intValue(), videoLabelInfo.getName());
            }
        }
    }
}
