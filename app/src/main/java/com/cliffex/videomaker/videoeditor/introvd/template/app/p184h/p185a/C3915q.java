package com.introvd.template.app.p184h.p185a;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.LoginRouter;
import com.introvd.template.router.LoginRouter.OnLoginListener;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"isUserLogin", "userLogin", "userInfo", "refreshUserInfo"})
/* renamed from: com.introvd.template.app.h.a.q */
public class C3915q implements C9358q {
    /* access modifiers changed from: private */
    /* renamed from: Md */
    public JSONObject m9620Md() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isUserLogin", UserServiceProxy.isLogin());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: Me */
    private JSONObject m9621Me() {
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        JSONObject jSONObject = new JSONObject();
        if (userInfo == null) {
            try {
                jSONObject.put("status", "null");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        try {
            jSONObject.put("nickName", userInfo.nickname);
            jSONObject.put("userlogo", userInfo.avatarUrl);
            jSONObject.put("auid", userInfo.auid);
            jSONObject.put(AccountKitGraphConstants.TOKEN_RESPONSE_TYPE, userInfo.token);
            jSONObject.put("gender", userInfo.gender);
            jSONObject.put("like_count_all", userInfo.totalLikeCount);
            jSONObject.put("fans_count", userInfo.fans);
            jSONObject.put("follow_count", userInfo.follows);
            jSONObject.put(SocialConstDef.USER_GRADE, userInfo.grade);
            jSONObject.put("publish_count", userInfo.publicVideoCount);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event response = ");
        sb.append(jSONObject);
        LogUtilsV2.m14227d(sb.toString());
        return jSONObject;
    }

    /* renamed from: c */
    private void m9623c(final C9345j jVar) {
        LoginRouter.startSettingBindAccountActivity(1003, (OnLoginListener) new OnLoginListener() {
            public void onLoginCancel() {
                if (jVar != null) {
                    jVar.mo36588x(C3915q.this.m9620Md());
                }
            }

            public void onLoginFail() {
                if (jVar != null) {
                    jVar.mo36588x(C3915q.this.m9620Md());
                }
            }

            public void onLoginSuccess() {
                if (jVar != null) {
                    jVar.mo36588x(C3915q.this.m9620Md());
                }
            }
        });
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(jVar.aPD());
        LogUtilsV2.m14227d(sb2.toString());
        if ("isUserLogin".equalsIgnoreCase(action)) {
            jVar.mo36588x(m9620Md());
            return true;
        }
        if ("userLogin".equalsIgnoreCase(action)) {
            if (UserServiceProxy.isLogin()) {
                jVar.mo36588x(m9620Md());
                return true;
            }
            m9623c(jVar);
        } else if ("userInfo".equalsIgnoreCase(action)) {
            jVar.mo36588x(m9621Me());
            return true;
        } else if ("refreshUserInfo".equalsIgnoreCase(action)) {
            UserServiceProxy.refreshAccountInfo();
            return true;
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
