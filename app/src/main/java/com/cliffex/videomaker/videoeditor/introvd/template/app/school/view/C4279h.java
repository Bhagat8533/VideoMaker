package com.introvd.template.app.school.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.C4191j;
import com.introvd.template.app.school.api.C4147b;
import com.introvd.template.app.school.api.model.VideoInfo;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.p236ui.LoadingMoreFooterView;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p310g.C7384w;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.xyui.p420a.C9153b;
import com.introvd.template.xyui.p420a.C9156d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.school.view.h */
public class C4279h extends C9153b<VideoInfo> {
    private int bAA = 0;
    /* access modifiers changed from: private */
    public boolean byW;

    /* renamed from: com.introvd.template.app.school.view.h$a */
    private class C4282a extends C9156d {
        C7384w bAE;

        C4282a(C7384w wVar) {
            super(wVar.getRoot());
            this.bAE = wVar;
        }
    }

    /* renamed from: a */
    public void mo24002a(C9156d dVar, int i) {
    }

    /* renamed from: a */
    public boolean mo24004a(VideoInfo videoInfo, VideoInfo videoInfo2) {
        return (videoInfo == null || videoInfo2 == null || videoInfo.getPuid().intValue() != videoInfo2.getPuid().intValue()) ? false : true;
    }

    /* renamed from: b */
    public void mo24005b(C9156d dVar, int i) {
        ((LoadingMoreFooterView) dVar.itemView).setStatus(this.bAA);
    }

    /* renamed from: c */
    public void mo24006c(C9156d dVar, int i) {
        C7384w wVar = ((C4282a) dVar).bAE;
        final VideoInfo videoInfo = (VideoInfo) mo36120vT(i);
        if (videoInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tabName", C4191j.m10442Nv().mo24157Nz());
            StringBuilder sb = new StringBuilder();
            sb.append(videoInfo.getPuid().longValue());
            sb.append("");
            hashMap.put("puid", sb.toString());
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C5527a.m14968kj(this.byW ? 49 : 50));
            UserBehaviorLog.onKVEvent(dVar.itemView.getContext(), "Pageview_Course_Tab_Cover", hashMap);
            wVar.mo32015a(videoInfo);
            dVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (view.getContext() instanceof Activity) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tabName", C4191j.m10442Nv().mo24157Nz());
                        StringBuilder sb = new StringBuilder();
                        sb.append(videoInfo.getPuid().longValue());
                        sb.append("");
                        hashMap.put("puid", sb.toString());
                        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C5527a.m14968kj(C4279h.this.byW ? 49 : 50));
                        UserBehaviorLog.onKVEvent(view.getContext(), "Click_Course_Tab_Cover", hashMap);
                        TODOParamModel tODOParamModel = new TODOParamModel();
                        tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_OPEN_URL;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("existParam", 0);
                            jSONObject.put("getAppMode", 0);
                            jSONObject.put("useHybrid", 1);
                            jSONObject.put("url", videoInfo.getWebUrl());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        tODOParamModel.mJsonParam = jSONObject.toString();
                        ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
                        if (iCommonFuncRouter != null) {
                            iCommonFuncRouter.executeTodo((Activity) view.getContext(), tODOParamModel, null);
                            C4147b.m10337a(videoInfo.getPuid()).mo10196g(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<String>>() {
                                /* renamed from: a */
                                public void mo9883a(C1495b bVar) {
                                }

                                /* renamed from: a */
                                public void onSuccess(CommonResponseResult<String> commonResponseResult) {
                                }

                                public void onError(Throwable th) {
                                    th.printStackTrace();
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hy */
    public void mo24301hy(int i) {
        this.bAA = i;
        notifyItemChanged(getItemCount() - 1);
    }

    public boolean isSupportFooterItem() {
        return true;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    /* renamed from: j */
    public C9156d mo24009j(ViewGroup viewGroup, int i) {
        return null;
    }

    /* renamed from: k */
    public C9156d mo24010k(ViewGroup viewGroup, int i) {
        LoadingMoreFooterView loadingMoreFooterView = new LoadingMoreFooterView(viewGroup.getContext());
        loadingMoreFooterView.setStatus(0);
        return new C9156d(loadingMoreFooterView);
    }

    /* renamed from: l */
    public C9156d mo24011l(ViewGroup viewGroup, int i) {
        return new C4282a(C7384w.m21763c(LayoutInflater.from(viewGroup.getContext())));
    }

    public void setIsFromCreatePage(boolean z) {
        this.byW = z;
    }
}
