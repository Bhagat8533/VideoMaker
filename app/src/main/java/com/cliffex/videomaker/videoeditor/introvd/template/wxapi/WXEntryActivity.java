package com.introvd.template.wxapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import com.biii.aiii.aiii.modelbase.BaseReq;
import com.biii.aiii.aiii.modelbase.BaseResp;
import com.biii.aiii.aiii.modelmsg.SendAuth.Resp;
import com.biii.aiii.aiii.openapi.IWXAPIEventHandler;
import com.introvd.template.app.p189i.C4021e;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.quvideo.auth.C4708b;
import com.quvideo.share.C4953b;
import com.quvideo.share.C4954c;

public class WXEntryActivity extends FragmentActivity implements IWXAPIEventHandler {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4954c.m12661a((Activity) this, (IWXAPIEventHandler) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    public void onReq(BaseReq baseReq) {
        if (C4953b.m12656a(baseReq)) {
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (!C4021e.m9972a(this, bundle)) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReq openId : ");
                sb.append(baseReq.openId);
                LogUtilsV2.m14230i(sb.toString());
                C9083a.m26522i(this, baseReq.openId);
                finish();
            }
        }
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp instanceof Resp) {
            C4708b.m12223a((Context) this, baseResp);
        } else {
            C4954c.m12663a((Context) this, baseResp);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
    }
}
