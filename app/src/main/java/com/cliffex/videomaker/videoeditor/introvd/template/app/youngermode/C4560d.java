package com.introvd.template.app.youngermode;

import com.introvd.template.VivaBaseApplication;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;

/* renamed from: com.introvd.template.app.youngermode.d */
public class C4560d {
    private static volatile C4560d bKk;
    private long bKl = 2400000;
    private C9324b bqo = C9327e.m27034cR(VivaBaseApplication.m8749FZ(), "younger_pref");

    private C4560d() {
    }

    /* renamed from: RN */
    public static C4560d m11516RN() {
        if (bKk == null) {
            synchronized (C4560d.class) {
                if (bKk == null) {
                    bKk = new C4560d();
                }
            }
        }
        return bKk;
    }

    /* renamed from: O */
    public void mo24802O(long j) {
        this.bKl = j * 1000;
    }

    /* renamed from: P */
    public boolean mo24803P(long j) {
        long j2 = this.bqo.getLong("flag_younger_keep_time", 0) + j;
        if (j2 > this.bKl) {
            this.bqo.setLong("flag_younger_keep_time", this.bKl);
            return false;
        }
        this.bqo.setLong("flag_younger_keep_time", j2);
        return true;
    }

    /* renamed from: Q */
    public void mo24804Q(long j) {
        this.bqo.setLong("flag_younger_open_dialog_time", j);
    }

    /* renamed from: R */
    public void mo24805R(long j) {
        this.bqo.setLong("flag_younger_set_time", j);
    }

    /* renamed from: RO */
    public boolean mo24806RO() {
        return this.bqo.getBoolean("flag_younger_open_dialog_show", true);
    }

    /* renamed from: RP */
    public long mo24807RP() {
        return this.bqo.getLong("flag_younger_open_dialog_time", 0);
    }

    /* renamed from: RQ */
    public long mo24808RQ() {
        return this.bqo.getLong("flag_younger_set_time", 0);
    }

    /* renamed from: RR */
    public void mo24809RR() {
        this.bqo.setLong("flag_younger_keep_time", 0);
    }

    /* renamed from: RS */
    public boolean mo24810RS() {
        return this.bqo.getBoolean("flag_younger_allow_more_time", false);
    }

    /* renamed from: ca */
    public void mo24811ca(boolean z) {
        this.bqo.setBoolean("flag_younger_mode", z);
    }

    /* renamed from: cb */
    public void mo24812cb(boolean z) {
        this.bqo.setBoolean("flag_younger_open_dialog_show", z);
    }

    /* renamed from: cc */
    public void mo24813cc(boolean z) {
        this.bqo.setBoolean("flag_younger_allow_more_time", z);
    }

    public boolean isYoungerMode() {
        return this.bqo.getBoolean("flag_younger_mode", false);
    }
}
