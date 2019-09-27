package com.introvd.template.app.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationClickActivity extends Activity {
    /* renamed from: Ni */
    private void m10114Ni() {
        LogUtilsV2.m14227d("用户点击打开了通知");
        if (getIntent().getData() != null) {
            String uri = getIntent().getData().toString();
            StringBuilder sb = new StringBuilder();
            sb.append("msg content is ");
            sb.append(String.valueOf(uri));
            LogUtilsV2.m14233w(sb.toString());
            if (!TextUtils.isEmpty(uri)) {
                try {
                    JSONObject jSONObject = new JSONObject(uri);
                    String optString = jSONObject.optString("msg_id");
                    byte optInt = (byte) jSONObject.optInt("rom_type");
                    jSONObject.optString("n_title");
                    jSONObject.optString("n_content");
                    String optString2 = jSONObject.optString("n_extras");
                    Intent intent = new Intent();
                    intent.putExtra("pushMsgID", optString);
                    intent.putExtra("pushName", m10115b(optInt));
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        intent.putExtra("pushType", jSONObject2.optString("PUSH_TYPE"));
                        intent.putExtra("pushMessageId", jSONObject2.optString("unique_messageid"));
                        intent.putExtra("event", jSONObject2.optString("event"));
                        intent.putExtra("PushService", "PushService");
                    }
                    C4082d.m10137h(this, intent);
                } catch (JSONException unused) {
                    LogUtilsV2.m14233w("parse notification error");
                }
            }
        }
    }

    /* renamed from: b */
    private String m10115b(byte b) {
        if (b == 8) {
            return "FCM";
        }
        switch (b) {
            case 0:
                return "JPUSH";
            case 1:
                return "XIAOMI";
            case 2:
                return "HUAWEI";
            case 3:
                return "MEIZU";
            default:
                return "JPUSH";
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10114Ni();
        finish();
    }
}
