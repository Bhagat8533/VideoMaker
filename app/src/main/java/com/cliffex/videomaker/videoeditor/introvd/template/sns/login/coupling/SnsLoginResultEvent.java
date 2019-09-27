package com.introvd.template.sns.login.coupling;

import android.os.Bundle;

public class SnsLoginResultEvent {
    public static final int SNS_LOGIN_RESULT_CANCEL = 2;
    public static final int SNS_LOGIN_RESULT_FAIL = 1;
    public static final int SNS_LOGIN_RESULT_SUCCESS = 0;
    public static final int SNS_REGISTER_AND_LOGIN_INIT_OVER = 10;
    public Bundle bundle;
    public boolean needModifyProfile;
    public long requestPageCode;
    public int state;
    public long uniqueRequestId;

    public SnsLoginResultEvent(long j, long j2, int i, boolean z, Bundle bundle2) {
        this.needModifyProfile = z;
        this.bundle = bundle2;
        this.state = i;
        this.uniqueRequestId = j;
        this.requestPageCode = j2;
    }

    public SnsLoginResultEvent(Bundle bundle2) {
        this.bundle = bundle2;
        this.state = 10;
    }
}
