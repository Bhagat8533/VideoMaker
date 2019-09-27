package com.introvd.template.app.school;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7372k;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.user.model.UserInfoResponse;
import com.introvd.template.xyui.p420a.C9153b;
import com.introvd.template.xyui.p420a.C9156d;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.school.c */
public class C4170c extends C9153b<SchoolCourseInfo> {

    /* renamed from: com.introvd.template.app.school.c$a */
    private class C4171a extends C9156d {
        private C7372k bwH;

        C4171a(C7372k kVar) {
            super(kVar.getRoot());
            this.bwH = kVar;
        }

        /* renamed from: b */
        private void m10389b(final SchoolCourseInfo schoolCourseInfo) {
            if (!TextUtils.isEmpty(schoolCourseInfo.getAuid())) {
                ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                if (iCommunityAPI != null) {
                    iCommunityAPI.getUserInfo(schoolCourseInfo.getAuid()).mo10196g(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<UserInfoResponse>() {
                        /* renamed from: a */
                        public void mo9883a(C1495b bVar) {
                        }

                        /* renamed from: a */
                        public void onSuccess(UserInfoResponse userInfoResponse) {
                            schoolCourseInfo.getAvatarUrlField().set(userInfoResponse.avatarUrl);
                            schoolCourseInfo.getNameField().set(userInfoResponse.nickName);
                        }

                        public void onError(Throwable th) {
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo24012a(SchoolCourseInfo schoolCourseInfo) {
            this.bwH.mo32003c(schoolCourseInfo);
            m10389b(schoolCourseInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10379a(SchoolCourseInfo schoolCourseInfo, View view) {
        if (view.getContext() instanceof Activity) {
            ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
            if (iCommonFuncRouter != null) {
                iCommonFuncRouter.executeTodo((Activity) view.getContext(), schoolCourseInfo.getTodoParamModel(), null);
            }
        }
    }

    /* renamed from: a */
    public void mo24002a(C9156d dVar, int i) {
    }

    /* renamed from: a */
    public boolean mo24004a(SchoolCourseInfo schoolCourseInfo, SchoolCourseInfo schoolCourseInfo2) {
        return false;
    }

    /* renamed from: b */
    public void mo24005b(C9156d dVar, int i) {
    }

    /* renamed from: c */
    public void mo24006c(C9156d dVar, int i) {
        SchoolCourseInfo schoolCourseInfo = (SchoolCourseInfo) mo36120vT(i);
        if (schoolCourseInfo != null) {
            C4171a aVar = (C4171a) dVar;
            aVar.mo24012a(schoolCourseInfo);
            aVar.itemView.setOnClickListener(new C4174d(schoolCourseInfo));
        }
    }

    public boolean isSupportFooterItem() {
        return false;
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
        return null;
    }

    /* renamed from: l */
    public C9156d mo24011l(ViewGroup viewGroup, int i) {
        C7372k a = C7372k.m21729a(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        a.getRoot().setLayoutParams(new LayoutParams(Constants.getScreenSize().width - C4583d.m11673ii(44), -1));
        return new C4171a(a);
    }
}
