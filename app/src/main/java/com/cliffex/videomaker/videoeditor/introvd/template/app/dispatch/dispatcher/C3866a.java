package com.introvd.template.app.dispatch.dispatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C4681i;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.dispatch.C3863a;
import com.introvd.template.p242d.C5527a;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.net.URI;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.dispatch.dispatcher.a */
public class C3866a implements C3863a {
    /* renamed from: I */
    private static boolean m9523I(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        AppMiscListener Gr = C4681i.m12184Gp().mo25016Gr();
        if (Gr == null) {
            return false;
        }
        String string = extras.getString(C5527a.cnK);
        if (string == null || !string.startsWith(C5527a.cnL)) {
            return false;
        }
        try {
            URI create = URI.create(string);
            String host = create.getHost();
            String path = create.getPath();
            if (!TextUtils.isEmpty(path)) {
                StringBuilder sb = new StringBuilder();
                sb.append(host);
                sb.append(path);
                host = sb.toString();
            }
            HashMap hashMap = new HashMap();
            String query = create.getQuery();
            if (!TextUtils.isEmpty(query)) {
                for (String split : query.replace("/", "").split(RequestParameters.AMPERSAND)) {
                    String[] split2 = split.split(RequestParameters.EQUAL);
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            Gr.onThemeBrowserCall(activity, host, hashMap);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public boolean mo23395e(FragmentActivity fragmentActivity) {
        Intent intent = fragmentActivity.getIntent();
        if (intent == null) {
            return false;
        }
        if (!(!TextUtils.isEmpty(intent.getStringExtra("PushService")))) {
            return m9523I(fragmentActivity);
        }
        String stringExtra = intent.getStringExtra("event");
        String stringExtra2 = intent.getStringExtra("pushMessageId");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("pushMessageId", stringExtra2);
        C4027k.m9994a(fragmentActivity, fragmentActivity.getIntent().getExtras(), C4027k.m9995dj(stringExtra));
        return true;
    }
}
