package com.introvd.template.app.school.view;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.C4191j;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.p196b.C4167g;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p310g.C7382u;
import java.util.HashMap;
import org.greenrobot.eventbus.C10021c;

/* renamed from: com.introvd.template.app.school.view.g */
public class C4276g extends C4417b<VideoLabelInfo> {

    /* renamed from: com.introvd.template.app.school.view.g$a */
    private class C4278a extends C4419b {
        C7382u bAx;

        C4278a(C7382u uVar) {
            super(uVar.getRoot());
            this.bAx = uVar;
        }
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, final int i) {
        C7382u uVar2 = ((C4278a) uVar).bAx;
        final VideoLabelInfo videoLabelInfo = (VideoLabelInfo) getListItem(i, false);
        if (videoLabelInfo != null) {
            uVar2.mo32014a(videoLabelInfo);
            uVar2.getRoot().setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int Ny = C4191j.m10442Nv().mo24156Ny();
                    if (Ny != videoLabelInfo.getId().intValue()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tabName", videoLabelInfo.getName());
                        UserBehaviorLog.onKVEvent(view.getContext(), "Click_Course_Tab", hashMap);
                        for (VideoLabelInfo videoLabelInfo : C4276g.this.getDataList()) {
                            if (videoLabelInfo.getId().intValue() == Ny) {
                                videoLabelInfo.isSelectedField().set(Boolean.valueOf(false));
                            }
                        }
                        videoLabelInfo.isSelectedField().set(Boolean.valueOf(true));
                        C4191j.m10442Nv().mo24159g(videoLabelInfo.getId().intValue(), videoLabelInfo.getName());
                        C10021c.aZH().mo38492aA(new C4167g(i));
                    }
                }
            });
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C4278a(C7382u.m21757b(LayoutInflater.from(viewGroup.getContext())));
    }
}
