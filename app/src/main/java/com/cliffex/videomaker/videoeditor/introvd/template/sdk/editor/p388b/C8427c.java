package com.introvd.template.sdk.editor.p388b;

import android.text.TextUtils;
import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p394b.C8533l.C8535b;
import com.introvd.template.sdk.utils.p394b.C8538o;
import java.lang.ref.WeakReference;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QBubbleTemplateInfo;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.storyboard.IQThemeOperationListener;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.engine.storyboard.QThemeAddCoverData;
import xiaoying.engine.storyboard.QThemeAddTextData;
import xiaoying.engine.storyboard.QThemeOperation;
import xiaoying.engine.storyboard.QThemeText;

/* renamed from: com.introvd.template.sdk.editor.b.c */
public class C8427c {
    private WeakReference<QStoryboard> daM;
    /* access modifiers changed from: private */
    public C8430a deX;
    /* access modifiers changed from: private */
    public volatile boolean eeD = false;
    /* access modifiers changed from: private */
    public WeakReference<VeMSize> eeE;
    /* access modifiers changed from: private */
    public C8533l eeF;
    protected boolean eeG = false;
    /* access modifiers changed from: private */
    public String eeH = "";
    /* access modifiers changed from: private */
    public String eeI = "";
    IQSessionStateListener eeJ = new IQSessionStateListener() {
        public int onSessionStatus(QSessionState qSessionState) {
            if (qSessionState == null) {
                return QVEError.QERR_APP_INVALID_PARAM;
            }
            int errorCode = qSessionState.getErrorCode();
            int status = qSessionState.getStatus();
            StringBuilder sb = new StringBuilder();
            sb.append("sessionState=");
            sb.append(errorCode);
            sb.append(";status=");
            sb.append(status);
            C8554j.m25008i("ThemeEditor", sb.toString());
            if (9428997 == errorCode) {
                C8427c.this.eeG = true;
                return errorCode;
            }
            if (errorCode != 0) {
                if (4 == status) {
                    C8427c.this.eeD = false;
                    if (C8427c.this.deX != null) {
                        C8427c.this.deX.mo30194oY(errorCode);
                    }
                    return errorCode;
                }
            } else if (4 == qSessionState.getStatus()) {
                C8427c.this.eeD = false;
                if (C8427c.this.deX != null) {
                    C8427c.this.deX.mo30193gX(C8427c.this.eeG);
                }
            } else if (1 == qSessionState.getStatus()) {
                C8427c.this.eeD = true;
            } else if (2 == qSessionState.getStatus()) {
                C8427c.this.eeD = true;
            }
            return 0;
        }
    };
    private IQThemeOperationListener eeK = new IQThemeOperationListener() {
        /* renamed from: a */
        private int m24362a(QThemeAddCoverData qThemeAddCoverData) {
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
                QMediaSource b = m24365b(str, templateID, qThemeAddCoverData.isCover());
                if (b == null) {
                    return i;
                }
                i = textInfo[i2].setTextSource(b);
            }
            return 0;
        }

        /* renamed from: a */
        private int m24363a(QThemeAddTextData qThemeAddTextData) {
            if (qThemeAddTextData == null) {
                return 1;
            }
            QThemeText[] textInfo = qThemeAddTextData.getTextInfo();
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
                QMediaSource b = m24365b(str, templateID, false);
                if (b == null) {
                    return i;
                }
                i = textInfo[i2].setTextSource(b);
            }
            return i;
        }

        /* renamed from: a */
        private String m24364a(QBubbleTemplateInfo qBubbleTemplateInfo, boolean z) {
            String str = qBubbleTemplateInfo.mTextDefaultString;
            String str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            boolean oM = C8427c.this.eeF.mo34789oM(str);
            boolean oL = C8533l.m24772oL(str);
            if (oM && !oL) {
                str = C8427c.this.eeF.mo34790oN(str);
            } else if (oM && oL) {
                str = C8427c.this.eeI;
            } else if (!z) {
                str = C8427c.this.eeF.mo34790oN(str);
            } else if (TextUtils.isEmpty(str)) {
                str = C8427c.this.eeI;
            }
            if (TextUtils.isEmpty(str)) {
                str = C8427c.this.eeH;
            }
            return str;
        }

        /* renamed from: b */
        private QMediaSource m24365b(String str, long j, boolean z) {
            if (C8427c.this.eeE != null) {
                VeMSize veMSize = (VeMSize) C8427c.this.eeE.get();
                if (veMSize != null) {
                    QEngine aJv = C8501a.aJs().aJv();
                    QBubbleTemplateInfo a = C8450a.m24460a(aJv, str, C8450a.m24471c(C8398b.mLocale), veMSize.width, veMSize.height);
                    if (a != null) {
                        String a2 = m24364a(a, z);
                        int i = a.mTextColor;
                        int i2 = a.mTextAlignment;
                        float f = a.mBubbleRotation;
                        ScaleRotateViewState c = C8538o.m24868c(aJv, str, veMSize);
                        if (c != null) {
                            c.setTextBubbleText(a2);
                            c.mStylePath = str;
                            QBubbleTextSource a3 = C8530i.m24749a(c, i, i2, (int) f, a2, veMSize, j);
                            if (a3 == null) {
                                return null;
                            }
                            return new QMediaSource(2, true, a3);
                        }
                    }
                }
            }
            return null;
        }

        public int onThemeOperation(QThemeOperation qThemeOperation) {
            if (qThemeOperation == null) {
                return 0;
            }
            C8554j.m25008i("ThemeEditor", "onThemeOperation");
            if (!C8427c.this.eeD) {
                return 0;
            }
            if (QThemeOperation.TYPE_ADD_COVER == qThemeOperation.getType()) {
                if (qThemeOperation.operatorFinish()) {
                    return 0;
                }
                int a = m24362a((QThemeAddCoverData) qThemeOperation.getOperatorData());
                StringBuilder sb = new StringBuilder();
                sb.append("onThemeOperation ires=");
                sb.append(a);
                C8554j.m25008i("ThemeEditor", sb.toString());
            } else if (QThemeOperation.TYPE_ADD_TEXT == qThemeOperation.getType() && !qThemeOperation.operatorFinish()) {
                m24363a((QThemeAddTextData) qThemeOperation.getOperatorData());
                qThemeOperation.setEffectGroupID(5);
                qThemeOperation.setEffectTrackType(2);
            }
            return 0;
        }
    };

    /* renamed from: com.introvd.template.sdk.editor.b.c$a */
    public interface C8430a {
        void aqK();

        /* renamed from: gX */
        void mo30193gX(boolean z);

        /* renamed from: oY */
        void mo30194oY(int i);
    }

    public C8427c(QStoryboard qStoryboard, VeMSize veMSize) {
        if (qStoryboard != null) {
            this.daM = new WeakReference<>(qStoryboard);
            this.eeE = new WeakReference<>(veMSize);
            qStoryboard.setThemeOperationListener(this.eeK);
            this.eeF = new C8533l();
        }
    }

    /* renamed from: a */
    public void mo34160a(C8430a aVar) {
        this.deX = aVar;
    }

    /* renamed from: a */
    public void mo34161a(C8535b bVar) {
        if (this.eeF != null) {
            this.eeF.mo34788b(bVar);
        }
    }

    /* renamed from: aS */
    public void mo34162aS(String str, String str2) {
        this.eeI = str;
        this.eeH = str2;
    }

    /* renamed from: nI */
    public boolean mo34163nI(String str) {
        boolean z = false;
        if (this.daM == null) {
            return false;
        }
        QStoryboard qStoryboard = (QStoryboard) this.daM.get();
        if (qStoryboard == null || this.eeD) {
            return false;
        }
        if (this.deX != null) {
            this.deX.aqK();
        }
        Long valueOf = Long.valueOf(0);
        C8382b aHa = C8410e.aGX().aHa();
        if (aHa != null) {
            valueOf = aHa.mo29495ig(str);
        }
        boolean z2 = QStyle.NONE_THEME_TEMPLATE_ID == valueOf.longValue();
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>> applyTheme strTheme = ");
        sb.append(str);
        C8554j.m25008i("ThemeEditor", sb.toString());
        qStoryboard.setProperty(16387, Boolean.valueOf(!z2));
        if (qStoryboard.applyTheme(str, this.eeJ) == 0) {
            z = true;
        }
        return z;
    }
}
