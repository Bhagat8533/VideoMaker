package com.introvd.template.sdk.slide;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.slide.p392a.C8466c;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p394b.C8533l.C8534a;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p396c.C8544b;
import java.util.Date;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QBubbleTemplateInfo;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.IQThemeOperationListener;
import xiaoying.engine.storyboard.QThemeAddCoverData;
import xiaoying.engine.storyboard.QThemeAddTextData;
import xiaoying.engine.storyboard.QThemeOperation;
import xiaoying.engine.storyboard.QThemeText;
import xiaoying.utils.QPoint;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.slide.e */
public class C8476e implements IQSessionStateListener {
    private QSlideShowSession dfW;
    /* access modifiers changed from: private */
    public C8533l eeF;
    /* access modifiers changed from: private */
    public String eeH = "";
    private IQThemeOperationListener eeK = new IQThemeOperationListener() {
        /* renamed from: a */
        private int m24568a(QThemeAddCoverData qThemeAddCoverData) {
            if (qThemeAddCoverData == null) {
                return 1;
            }
            QThemeText[] textInfo = qThemeAddCoverData.getTextInfo();
            if (textInfo == null || textInfo.length == 0) {
                return 1;
            }
            int i = 1;
            for (int i2 = 0; i2 < textInfo.length; i2++) {
                long templateID = textInfo[i2].getTemplateID();
                String str = "";
                C8382b aHa = C8410e.aGX().aHa();
                if (aHa != null) {
                    str = aHa.mo29496q(Long.valueOf(templateID));
                }
                QMediaSource a = m24570a(str, templateID, i2, qThemeAddCoverData.isCover());
                if (a == null) {
                    return i;
                }
                i = textInfo[i2].setTextSource(a);
            }
            return 0;
        }

        /* renamed from: a */
        private int m24569a(QThemeAddTextData qThemeAddTextData) {
            int i = 1;
            if (qThemeAddTextData == null) {
                return 1;
            }
            QThemeText[] textInfo = qThemeAddTextData.getTextInfo();
            if (textInfo == null || textInfo.length == 0) {
                return 1;
            }
            for (int i2 = 0; i2 < textInfo.length; i2++) {
                long templateID = textInfo[i2].getTemplateID();
                String str = "";
                C8382b aHa = C8410e.aGX().aHa();
                if (aHa != null) {
                    str = aHa.mo29496q(Long.valueOf(templateID));
                }
                QMediaSource a = m24570a(str, templateID, i2, false);
                if (a == null) {
                    return i;
                }
                i = textInfo[i2].setTextSource(a);
            }
            return i;
        }

        /* renamed from: a */
        private QMediaSource m24570a(String str, long j, int i, boolean z) {
            if (C8476e.this.egg != null) {
                QBubbleTemplateInfo a = C8450a.m24460a(C8476e.this.egh, str, C8450a.m24471c(C8398b.mLocale), C8476e.this.egg.width, C8476e.this.egg.height);
                if (a != null) {
                    String a2 = mo34629a(a, j, z);
                    int i2 = a.mTextColor;
                    int i3 = a.mTextAlignment;
                    float f = a.mBubbleRotation;
                    ScaleRotateViewState c = C8538o.m24868c(C8476e.this.egh, str, C8476e.this.egg);
                    if (c == null) {
                        return null;
                    }
                    c.setTextBubbleText(a2);
                    c.mStylePath = str;
                    QBubbleTextSource a3 = C8530i.m24749a(c, i2, i3, (int) f, a2, C8476e.this.egg, j);
                    if (a3 == null) {
                        return null;
                    }
                    return new QMediaSource(2, true, a3);
                }
            }
            return null;
        }

        /* renamed from: a */
        public String mo34629a(QBubbleTemplateInfo qBubbleTemplateInfo, long j, boolean z) {
            String str = qBubbleTemplateInfo.mTextDefaultString;
            boolean oM = C8476e.this.eeF.mo34789oM(str);
            boolean oL = C8533l.m24772oL(str);
            if (oM && !oL) {
                str = C8476e.this.eeF.mo34790oN(str);
            } else if (oM && oL) {
                str = C8572y.m25101oy(C8476e.this.efY);
            } else if (!z) {
                str = C8476e.this.eeF.mo34790oN(str);
            } else if (TextUtils.isEmpty(str)) {
                str = C8572y.m25101oy(C8476e.this.efY);
            }
            return TextUtils.isEmpty(str) ? C8476e.this.eeH : str;
        }

        public int onThemeOperation(QThemeOperation qThemeOperation) {
            if (qThemeOperation == null) {
                return 0;
            }
            C8554j.m25008i("SSStoryboardMaker_LOG", "onThemeOperation");
            if (QThemeOperation.TYPE_ADD_COVER == qThemeOperation.getType()) {
                if (qThemeOperation.operatorFinish()) {
                    return 0;
                }
                int a = m24568a((QThemeAddCoverData) qThemeOperation.getOperatorData());
                StringBuilder sb = new StringBuilder();
                sb.append("onThemeOperation ires=");
                sb.append(a);
                C8554j.m25008i("SSStoryboardMaker_LOG", sb.toString());
            } else if (QThemeOperation.TYPE_ADD_TEXT == qThemeOperation.getType() && !qThemeOperation.operatorFinish()) {
                m24569a((QThemeAddTextData) qThemeOperation.getOperatorData());
                qThemeOperation.setEffectGroupID(5);
                qThemeOperation.setEffectTrackType(1);
            }
            return 0;
        }
    };
    /* access modifiers changed from: private */
    public String efY;
    private boolean efZ = false;
    private boolean ega = false;
    private int egc = 0;
    private Boolean egd = Boolean.valueOf(false);
    public String egf = "";
    /* access modifiers changed from: private */
    public VeMSize egg;
    /* access modifiers changed from: private */
    public QEngine egh = null;
    private Handler mHandler;

    /* renamed from: com.introvd.template.sdk.slide.e$a */
    public static class C8478a extends C8534a {
        private String egj = "";
        private String egk = "";

        public C8478a(String str, String str2) {
            this.egj = str;
            this.egk = str2;
        }

        public String ata() {
            return this.egj;
        }

        /* renamed from: nR */
        public String mo34630nR(String str) {
            if (!TextUtils.isEmpty(this.egk)) {
                Date nU = C8466c.m24518nU(this.egk);
                if (nU != null) {
                    try {
                        return new C8544b(str, null).format(nU);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return super.mo34630nR(str);
        }
    }

    /* renamed from: Fp */
    private boolean m24560Fp() {
        return this.dfW != null;
    }

    private boolean isBusy() {
        return this.ega;
    }

    /* renamed from: a */
    public int mo34627a(C8501a aVar, Handler handler, QSlideShowSession qSlideShowSession, String str, String str2, String str3) {
        if (handler == null || qSlideShowSession == null) {
            return 2;
        }
        this.mHandler = handler;
        this.dfW = qSlideShowSession;
        this.dfW.setProperty(QSlideShowSession.PROP_DEC_USE_TYPE, Integer.valueOf(4));
        this.efY = str;
        this.eeF = new C8533l();
        this.eeF.mo34788b(new C8478a(str2, this.egf));
        this.eeH = str3;
        this.egh = aVar.aJv();
        aVar.mo34665a(new C8479f(this.eeF));
        return 0;
    }

    /* renamed from: f */
    public int mo34628f(VeMSize veMSize) {
        if (veMSize == null) {
            return 2;
        }
        if (!m24560Fp()) {
            return 5;
        }
        if (isBusy()) {
            return 6;
        }
        this.ega = true;
        this.egg = veMSize;
        if (this.dfW.getProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT) == null) {
            this.dfW.setProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT, Integer.valueOf(50));
        }
        this.dfW.setProperty(20484, new QPoint(veMSize.width, veMSize.height));
        int MakeStoryboard = this.dfW.MakeStoryboard(new QSize(veMSize.width, veMSize.height), this, this.eeK);
        if (MakeStoryboard == 0) {
            return 0;
        }
        this.ega = false;
        return MakeStoryboard;
    }

    public int onSessionStatus(QSessionState qSessionState) {
        if (qSessionState == null) {
            return QVEError.QERR_APP_INVALID_PARAM;
        }
        int errorCode = qSessionState.getErrorCode();
        StringBuilder sb = new StringBuilder();
        sb.append("onSessionStatus: State = ");
        sb.append(qSessionState.getStatus());
        sb.append(" ErrCode = ");
        sb.append(errorCode);
        sb.append(" Duration = ");
        sb.append(qSessionState.getDuration());
        sb.append(" CurrTime = ");
        sb.append(qSessionState.getCurrentTime());
        sb.append(" ShouldCancel = ");
        sb.append(this.efZ);
        C8554j.m25007e("SSStoryboardMaker_LOG", sb.toString());
        if (!m24560Fp()) {
            return QVEError.QERR_COMMON_CANCEL;
        }
        boolean z = true;
        if (9428997 == errorCode) {
            this.egc = 1;
        }
        if (9428999 == errorCode) {
            this.egd = Boolean.valueOf(true);
        }
        int i = 0;
        if (errorCode != 0) {
            if (!this.efZ || 9428996 != errorCode) {
                z = false;
            }
            if (this.ega) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(z ? 268443661 : 268443660, errorCode, 0, this.efY));
                }
                this.ega = false;
            }
            return QVEError.QERR_COMMON_CANCEL;
        } else if (8 == qSessionState.getStatus()) {
            if (this.ega) {
                if (this.mHandler != null) {
                    Message obtainMessage = this.mHandler.obtainMessage(268443659, 100, 0);
                    obtainMessage.arg1 = this.egc;
                    obtainMessage.obj = this.egd;
                    this.mHandler.sendMessage(obtainMessage);
                }
                this.ega = false;
            }
            return 0;
        } else {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(268443662, qSessionState.currentTime, qSessionState.duration));
            }
            if (this.efZ) {
                i = QVEError.QERR_COMMON_CANCEL;
            }
            return i;
        }
    }
}
