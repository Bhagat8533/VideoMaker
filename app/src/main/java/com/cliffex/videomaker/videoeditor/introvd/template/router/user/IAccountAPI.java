package com.introvd.template.router.user;

import com.aiii.android.arouter.facade.template.C1949c;
import com.google.gson.JsonObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1848s;

public interface IAccountAPI extends C1949c {
    C1834l<JsonObject> bindOpenID(String str, String str2, String str3);

    C1848s<Boolean> changePrivacy();

    C1848s<JsonObject> getFreezeReason(String str);

    void refreshUserToken(boolean z);

    C1848s<Boolean> updateUserPrivilege(String str);
}
