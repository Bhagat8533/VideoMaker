package com.introvd.template.p153p;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtils;

/* renamed from: com.introvd.template.p.a */
public class C3209a {
    private static final String TAG = "a";
    private static volatile C3209a eiX;
    private Boolean eiY;
    private long eiZ;

    /* renamed from: com.introvd.template.p.a$a */
    public static class C3210a {
        public boolean eja;

        public C3210a(boolean z) {
            this.eja = z;
        }
    }

    private C3209a() {
    }

    public static C3209a aJZ() {
        if (eiX == null) {
            synchronized (C3209a.class) {
                if (eiX == null) {
                    eiX = new C3209a();
                }
            }
        }
        return eiX;
    }

    /* renamed from: gN */
    private boolean m8101gN(Context context) {
        AudioManager audioManager = (AudioManager) VivaBaseApplication.m8749FZ().getBaseContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn();
    }

    public void aKa() {
        this.eiZ = System.currentTimeMillis();
    }

    public void aKb() {
        if (System.currentTimeMillis() - this.eiZ > 1800000) {
            this.eiY = null;
        }
    }

    /* renamed from: gM */
    public boolean mo18326gM(Context context) {
        if (this.eiY != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("mIsSilentModeByUser ");
            sb.append(this.eiY);
            LogUtils.m14223i(str, sb.toString());
            return this.eiY.booleanValue();
        } else if (!m8101gN(context)) {
            return C3742b.m9111II().mo23182ca(context);
        } else {
            LogUtils.m14223i(TAG, "isInHeadsetMode ");
            return false;
        }
    }

    /* renamed from: jy */
    public void mo18327jy(boolean z) {
        this.eiY = Boolean.valueOf(z);
    }
}
