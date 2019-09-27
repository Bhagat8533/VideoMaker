package com.introvd.template.app.community.usergrade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.introvd.template.EventActivity;
import com.introvd.template.app.community.usergrade.GradeUpHintView.C3769a;
import com.introvd.template.app.community.usergrade.NewPrivilegeView.C3771a;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.router.user.UserServiceProxy;

public class UserGradeUpActivity extends EventActivity {
    /* access modifiers changed from: private */
    public FrameLayout blv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.blv = new FrameLayout(this);
        setContentView(this.blv);
        final String userId = UserServiceProxy.getUserId();
        final C3800i Iz = C3797h.m9288Ix().mo23279Iz();
        final GradeUpHintView gradeUpHintView = new GradeUpHintView(this);
        if (Iz != null) {
            C3801j.m9302g(this, userId, Iz.grade);
            gradeUpHintView.mo23242gs(Iz.grade);
            gradeUpHintView.setOnBtnClickListener(new C3769a() {
                /* renamed from: bD */
                public void mo23246bD(View view) {
                    UserGradeUpActivity.this.finish();
                }

                /* renamed from: bE */
                public void mo23247bE(View view) {
                    NewPrivilegeView newPrivilegeView = new NewPrivilegeView(view.getContext());
                    newPrivilegeView.setOnBtnClickListener(new C3771a() {
                        /* renamed from: bF */
                        public void mo23251bF(View view) {
                            UserGradeUpActivity.this.startActivity(new Intent(UserGradeUpActivity.this, UserGradePage.class));
                            UserBehaviorUtilsV5.onEventLevelPageEnter(UserGradeUpActivity.this, "levelup_pop");
                            UserGradeUpActivity.this.finish();
                        }
                    });
                    UserGradeUpActivity.this.blv.removeView(gradeUpHintView);
                    UserGradeUpActivity.this.blv.addView(newPrivilegeView);
                    newPrivilegeView.mo23248J(C3801j.m9304o(userId, Iz.grade));
                }
            });
        }
        this.blv.addView(gradeUpHintView);
    }
}
