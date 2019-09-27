package com.introvd.template.app.manager;

import com.fiii.aiii.iid.FirebaseInstanceId;
import com.fiii.aiii.iid.FirebaseInstanceIdService;

public class MyInstanceIdService extends FirebaseInstanceIdService {
    /* renamed from: sR */
    public void mo18748sR() {
        super.mo18748sR();
        FirebaseInstanceId AQ = FirebaseInstanceId.m8179AQ();
        if (AQ != null) {
            C4041a.m10050o(getApplicationContext(), AQ.getToken());
        }
    }
}
