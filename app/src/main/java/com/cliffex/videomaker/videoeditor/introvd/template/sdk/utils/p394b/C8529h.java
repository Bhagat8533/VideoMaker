package com.introvd.template.sdk.utils.p394b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.sdk.utils.C8554j;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.utils.b.h */
public class C8529h implements IQSessionStateListener {
    private String efY;
    private boolean efZ = false;
    private boolean ega = false;
    private boolean egb = false;
    private int egc = 0;
    private Boolean egd = Boolean.valueOf(false);
    private int ege = 0;
    private Context mContext;
    private Handler mHandler;
    private QStoryboard mStoryBoard;

    /* renamed from: Fp */
    private boolean m24736Fp() {
        return this.mStoryBoard != null;
    }

    private boolean isBusy() {
        return this.ega || this.egb;
    }

    /* renamed from: a */
    public int mo34784a(Context context, Handler handler, QStoryboard qStoryboard) {
        if (handler == null || qStoryboard == null) {
            return 2;
        }
        this.mContext = context;
        this.mHandler = handler;
        this.mStoryBoard = qStoryboard;
        return 0;
    }

    /* renamed from: nP */
    public int mo34785nP(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("strProjectFile:");
        sb.append(str);
        C8554j.m25008i("ProjectModule_LOG", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        if (!m24736Fp()) {
            return 5;
        }
        if (isBusy()) {
            return 6;
        }
        this.ega = true;
        if (this.mStoryBoard.loadProject(str, this) == 0) {
            return 0;
        }
        this.ega = false;
        return 1;
    }

    /* renamed from: nQ */
    public int mo34786nQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        if (!m24736Fp()) {
            return 5;
        }
        if (isBusy()) {
            return 6;
        }
        this.egb = true;
        this.efY = str;
        int saveProject = this.mStoryBoard.saveProject(str, this);
        if (saveProject == 0) {
            return 0;
        }
        this.egb = false;
        return saveProject;
    }

    public int onSessionStatus(QSessionState qSessionState) {
        boolean Fp = m24736Fp();
        int i = QVEError.QERR_COMMON_CANCEL;
        if (!Fp) {
            return QVEError.QERR_COMMON_CANCEL;
        }
        if (qSessionState == null) {
            return QVEError.QERR_APP_INVALID_PARAM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onSessionStatus: State = ");
        sb.append(qSessionState.getStatus());
        sb.append(" ErrCode = ");
        sb.append(qSessionState.getErrorCode());
        sb.append(" Duration = ");
        sb.append(qSessionState.getDuration());
        sb.append(" CurrTime = ");
        sb.append(qSessionState.getCurrentTime());
        sb.append(" ShouldCancel = ");
        sb.append(this.efZ);
        C8554j.m25007e("ProjectModule_LOG", sb.toString());
        boolean z = true;
        if (9428997 == qSessionState.getErrorCode()) {
            this.egc = 1;
        }
        if (9428999 == qSessionState.getErrorCode()) {
            this.egd = Boolean.valueOf(true);
        }
        if (qSessionState.getErrorCode() == 0 || 9428997 == qSessionState.getErrorCode() || 9428999 == qSessionState.getErrorCode()) {
            int i2 = 100;
            if (4 == qSessionState.getStatus()) {
                if (qSessionState.getDuration() > 0) {
                    i2 = (qSessionState.getCurrentTime() * 100) / qSessionState.getDuration();
                }
                this.ege = i2;
                if (this.ega && this.mHandler != null) {
                    Message obtainMessage = this.mHandler.obtainMessage(268443649, i2, 0);
                    obtainMessage.arg1 = this.egc;
                    obtainMessage.obj = this.egd;
                    this.mHandler.sendMessage(obtainMessage);
                }
                if (this.egb && this.mHandler != null) {
                    Message obtainMessage2 = this.mHandler.obtainMessage(268443653, i2, 0, this.efY);
                    obtainMessage2.getData().putString("path", this.efY);
                    this.mHandler.sendMessage(obtainMessage2);
                }
                return 0;
            }
            if (2 == qSessionState.getStatus()) {
                int currentTime = qSessionState.getDuration() > 0 ? (qSessionState.getCurrentTime() * 100) / qSessionState.getDuration() : 0;
                if (currentTime != this.ege) {
                    this.ege = currentTime;
                    if (this.ega && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(268443652, currentTime, 0, this.efY));
                    }
                    if (this.egb && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(268443656, currentTime, 0, this.efY));
                    }
                }
            }
            if (!this.efZ) {
                i = 0;
            }
            return i;
        }
        if (!this.efZ || 9428996 != qSessionState.getErrorCode()) {
            z = false;
        }
        if (!z && this.egb) {
            Context context = this.mContext;
        }
        if (this.ega && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(z ? 268443651 : 268443650, qSessionState.getErrorCode(), 0, this.efY));
            this.ega = false;
        }
        if (this.egb && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(z ? 268443655 : 268443654, qSessionState.getErrorCode(), 0, this.efY));
            this.egb = false;
        }
        return QVEError.QERR_COMMON_CANCEL;
    }

    public void unInit() {
        this.mHandler = null;
        this.mStoryBoard = null;
        this.mContext = null;
        this.ega = false;
        this.egb = false;
    }
}
