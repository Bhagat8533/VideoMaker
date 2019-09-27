package com.introvd.template.p362n;

import com.xiaoying.tool.upload.p460e.C9589a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.introvd.template.n.a */
public class C8085a implements C9589a {
    private LinkedBlockingQueue<Integer> dLO;

    public C8085a(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
        this.dLO = linkedBlockingQueue;
    }

    /* renamed from: B */
    public void mo33133B(String str, int i) {
    }

    /* renamed from: a */
    public void mo33134a(String str, String str2, int i, String str3) {
        try {
            this.dLO.put(Integer.valueOf(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: at */
    public void mo33135at(String str, String str2) {
        try {
            this.dLO.put(Integer.valueOf(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: dr */
    public void mo33136dr(int i, int i2) {
    }

    /* renamed from: rO */
    public void mo33137rO(int i) {
    }
}
