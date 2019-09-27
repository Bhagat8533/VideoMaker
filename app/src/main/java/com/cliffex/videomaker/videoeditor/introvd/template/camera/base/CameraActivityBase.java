package com.introvd.template.camera.base;

import android.app.KeyguardManager;
import android.os.Bundle;
import android.view.KeyEvent;
import com.introvd.template.EventActivity;
import com.introvd.template.camera.p229b.C4996f;
import com.introvd.template.camera.p229b.C5016m;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.p409g.C8759b;

public abstract class CameraActivityBase extends EventActivity {
    public boolean ajR = false;
    public int bOA = 0;
    public int bOB = 0;
    public int bOC = 0;
    public int bOD = 0;
    public int bOE = 0;
    public int bOF = 0;
    public boolean bOG = false;
    public boolean bOH = false;
    public boolean bOI = false;
    public C4996f bOJ;
    public C8501a bOK;
    public boolean bOL = true;
    public int bOM = 0;
    public C5016m bON;
    public String bOO = null;
    public C8759b bOt;
    private boolean bOv;
    public int bOw = 0;
    public float bOx = 1.0f;
    public int bOy = 256;
    public int bOz = 1;
    public int mClipCount = 0;

    private boolean isKeyguardLocked() {
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    /* access modifiers changed from: protected */
    /* renamed from: SZ */
    public abstract void mo24895SZ();

    /* access modifiers changed from: protected */
    /* renamed from: Ur */
    public void mo25824Ur() {
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_view_ae_lock", "unlock");
        if (this.bOJ != null && this.ajR) {
            this.bOJ.mo25544cG(true);
            this.bOJ.mo25514Ur();
            this.ajR = false;
        }
    }

    /* access modifiers changed from: protected */
    public void connect() {
        if (getState() == -1 && !this.ajR) {
            this.bOJ.mo25523Vw();
        }
    }

    /* access modifiers changed from: protected */
    public int getState() {
        if (this.bOJ != null) {
            return this.bOJ.getState();
        }
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setVolumeControlStream(3);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 84 || i == 82) && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.bOv = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (hasWindowFocus() || !isKeyguardLocked()) {
            mo24895SZ();
            this.bOv = false;
            return;
        }
        this.bOv = true;
    }

    public boolean onSearchRequested() {
        return false;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.bOv) {
            mo24895SZ();
            this.bOv = false;
        }
    }
}
