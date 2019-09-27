package com.introvd.template.editor.todo;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1899e;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.joinevent.JoinEventInfo;
import com.introvd.template.common.joinevent.JoinEventUtil;
import com.introvd.template.editor.R;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.todoCode.TodoConstants;
import java.util.ArrayList;
import java.util.Collection;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.todo.a */
public class C6928a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m20185a(Activity activity, JoinEventInfo joinEventInfo) {
        C6933d.asD().mo30582a(activity, null, joinEventInfo.nTodoType, joinEventInfo.strActivityID);
    }

    public static void handleJoinEvent(Activity activity, String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(activity.getApplication().getString(R.string.xiaoying_str_community_activity_select_from_gallery));
        arrayList.add(activity.getApplication().getString(R.string.xiaoying_str_community_activity_start_capture));
        arrayList.add(activity.getApplication().getString(R.string.xiaoying_str_community_activity_select_work));
        C1895a aA = new C1895a(activity).mo10286a((Collection) arrayList).mo10288aA(false);
        final String str5 = str;
        final Activity activity2 = activity;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        C69291 r1 = new C1899e() {
            /* renamed from: a */
            public void mo10328a(C1890f fVar, View view, int i, CharSequence charSequence) {
                String str = str5;
                JoinEventInfo joinEventInfo = JoinEventUtil.getJoinEventInfo(activity2.getApplicationContext(), str5);
                if ((TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) || (joinEventInfo != null && joinEventInfo.nTodoType == 0 && !TextUtils.isEmpty(str6))) {
                    str = str6;
                    C6933d.asD().setTagInfo(str6);
                }
                String str2 = str;
                if (i == 0) {
                    JoinEventInfo joinEventInfo2 = new JoinEventInfo();
                    joinEventInfo2.nTodoType = 401;
                    joinEventInfo2.strActivityID = str2;
                    UserBehaviorUtilsV5.onEventActivityAttend(activity2, "gallery", str7, str8);
                    C6928a.m20185a(activity2, joinEventInfo2);
                } else if (1 == i) {
                    if (joinEventInfo != null && joinEventInfo.nTodoType != 0) {
                        UserBehaviorUtilsV5.onEventActivityAttend(activity2, "create", str7, str8);
                        C6928a.m20185a(activity2, joinEventInfo);
                    } else if (!TextUtils.isEmpty(str2)) {
                        UserBehaviorUtilsV5.onEventActivityAttend(activity2, "create", str7, str8);
                        JoinEventInfo joinEventInfo3 = new JoinEventInfo();
                        joinEventInfo3.nTodoType = TodoConstants.TODO_TYPE_CAMERA_MODE_MV6;
                        joinEventInfo3.strActivityID = str2;
                        C6928a.m20185a(activity2, joinEventInfo3);
                    } else if (!TextUtils.isEmpty(str5)) {
                        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                        if (iCommunityAPI != null) {
                            iCommunityAPI.getActivityJoinInfo(str5).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<String>() {
                                /* renamed from: a */
                                public void mo9883a(C1495b bVar) {
                                }

                                /* renamed from: dV */
                                public void onSuccess(String str) {
                                    JoinEventInfo joinEventInfo = JoinEventUtil.getJoinEventInfo(activity2.getApplicationContext(), str5);
                                    if (joinEventInfo != null) {
                                        C6928a.m20185a(activity2, joinEventInfo);
                                    }
                                }

                                public void onError(Throwable th) {
                                    th.printStackTrace();
                                }
                            });
                        }
                    }
                } else if (2 == i) {
                    UserBehaviorUtilsV5.onEventActivityAttend(activity2, "finished", str7, str8);
                    StudioRouter.launchStudioActivity(activity2, true, activity2.getString(R.string.xiaoying_str_community_activity_select_work_title), str2, R.anim.xiaoying_activity_enter_hold, R.anim.xiaoying_activity_enter_hold);
                }
            }
        };
        aA.mo10280a((C1899e) r1).mo10313qu().show();
    }
}
