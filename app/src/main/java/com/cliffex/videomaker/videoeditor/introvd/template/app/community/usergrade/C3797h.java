package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.filecache.FileCacheV2;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.UserGradeInfoDto;
import com.introvd.template.router.user.model.UserGradeInfoResult;
import com.introvd.template.router.user.model.UserGradeTaskInfo;
import com.introvd.template.router.user.model.UserPrivilegeInfo;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.community.usergrade.h */
public class C3797h {
    private static volatile C3797h bkT;
    /* access modifiers changed from: private */
    public FileCacheV2<UserGradeInfoResult> bkU = new Builder((Context) VivaBaseApplication.m8749FZ(), "UserGradeInfoCache", UserGradeInfoResult.class).build();
    private C3800i bkV;
    private List<C3791d> bkW;
    private List<C3794f> bkX;

    /* renamed from: com.introvd.template.app.community.usergrade.h$a */
    public class C3799a {
        public C3799a() {
        }
    }

    private C3797h() {
    }

    /* renamed from: Ix */
    public static C3797h m9288Ix() {
        if (bkT == null) {
            synchronized (C3797h.class) {
                if (bkT == null) {
                    bkT = new C3797h();
                }
            }
        }
        return bkT;
    }

    /* renamed from: M */
    private void m9289M(List<UserPrivilegeInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                UserPrivilegeInfo userPrivilegeInfo = (UserPrivilegeInfo) list.get(i);
                C3791d dVar = new C3791d();
                dVar.type = userPrivilegeInfo.gift;
                dVar.content = userPrivilegeInfo.content;
                dVar.iconUrl = userPrivilegeInfo.iconUrl;
                dVar.bkL = userPrivilegeInfo.disableUrl;
                dVar.bkM = userPrivilegeInfo.applyUrl;
                dVar.bkN = userPrivilegeInfo.useNumber;
                dVar.unlockGrade = userPrivilegeInfo.unlockGrade;
                dVar.title = userPrivilegeInfo.title;
                dVar.minVersion = userPrivilegeInfo.minVersion;
                dVar.maxVersion = userPrivilegeInfo.maxVersion;
                boolean z = true;
                if (userPrivilegeInfo.isForever != 1) {
                    z = false;
                }
                dVar.bkO = z;
                dVar.bkP = C4395c.m11101ei(userPrivilegeInfo.useableTime);
                dVar.giftType = userPrivilegeInfo.giftType;
                arrayList.add(dVar);
            }
            if (this.bkW != null) {
                this.bkW.clear();
            }
            this.bkW = arrayList;
        }
    }

    /* renamed from: N */
    private void m9290N(List<UserGradeTaskInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                UserGradeTaskInfo userGradeTaskInfo = (UserGradeTaskInfo) list.get(i);
                C3794f fVar = new C3794f();
                fVar.content = userGradeTaskInfo.content;
                fVar.iconUrl = userGradeTaskInfo.iconUrl;
                fVar.title = userGradeTaskInfo.title;
                arrayList.add(fVar);
            }
            if (this.bkX != null) {
                this.bkX.clear();
            }
            this.bkX = arrayList;
        }
    }

    /* renamed from: a */
    private void m9293a(UserGradeInfoDto userGradeInfoDto) {
        if (userGradeInfoDto != null) {
            C3800i iVar = new C3800i();
            iVar.grade = userGradeInfoDto.grade;
            iVar.score = userGradeInfoDto.score;
            boolean z = false;
            iVar.bla = userGradeInfoDto.isAchieve == 1;
            if (userGradeInfoDto.isMaxed == 1) {
                z = true;
            }
            iVar.blb = z;
            iVar.nextGradeScore = userGradeInfoDto.nextGradeScore;
            iVar.nextGradeExtendInfo = userGradeInfoDto.nextGradeExtendInfo;
            this.bkV = iVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9294a(UserGradeInfoResult userGradeInfoResult, String str) {
        if (userGradeInfoResult != null) {
            if (!TextUtils.isEmpty(str)) {
                m9293a(userGradeInfoResult.gradeInfoDto);
                if (this.bkV != null && C3801j.m9306q(str, this.bkV.grade)) {
                    C3801j.m9303h(VivaBaseApplication.m8749FZ(), str, this.bkV.grade);
                }
            }
            m9289M(userGradeInfoResult.privilegeInfo);
            m9290N(userGradeInfoResult.taskInfoList);
            C10021c.aZH().mo38492aA(new C3799a());
        }
    }

    /* renamed from: IA */
    public List<C3791d> mo23275IA() {
        return this.bkW;
    }

    /* renamed from: IB */
    public List<C3794f> mo23276IB() {
        return this.bkX;
    }

    /* renamed from: IC */
    public void mo23277IC() {
        this.bkV = null;
        this.bkW = null;
        this.bkX = null;
    }

    /* renamed from: Iy */
    public void mo23278Iy() {
        if (AppStateModel.getInstance().isInChina()) {
            final String userId = UserServiceProxy.getUserId();
            C1848s userGradeInfo = UserServiceProxy.getUserGradeInfo(C4580b.m11635Si(), userId);
            if (userGradeInfo != null) {
                userGradeInfo.mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<UserGradeInfoResult>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    /* renamed from: a */
                    public void onSuccess(UserGradeInfoResult userGradeInfoResult) {
                        C3797h.this.bkU.saveCache(userGradeInfoResult);
                        C3797h.this.m9294a(userGradeInfoResult, userId);
                    }

                    public void onError(Throwable th) {
                        th.printStackTrace();
                        C3797h.this.m9294a((UserGradeInfoResult) C3797h.this.bkU.getCacheSync(), userId);
                    }
                });
            }
        }
    }

    /* renamed from: Iz */
    public C3800i mo23279Iz() {
        return this.bkV;
    }
}
