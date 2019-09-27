package com.introvd.template.editor.clipedit.trim;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.clipedit.trim.b */
public class C5831b extends C5694a {
    /* renamed from: a */
    private void m16282a(int i, int i2, QClip qClip) {
        QEffect k = C8537n.m24832k(qClip);
        if (k != null) {
            QRange qRange = (QRange) k.getProperty(4098);
            if (qRange != null) {
                int i3 = qRange.get(0);
                if (i3 < i) {
                    qRange.set(0, i);
                }
                if (qRange.get(1) + i3 > i2) {
                    qRange.set(1, i2 - i3);
                }
            }
        }
    }

    /* renamed from: a */
    private void m16283a(C8522g gVar, QStoryboard qStoryboard, int i, int i2) {
        if (gVar != null && qStoryboard != null) {
            DataItemProject aHe = gVar.aHe();
            if (aHe != null) {
                if (!aHe.isAdvBGMMode()) {
                    C8540q.m24903L(qStoryboard);
                    if (adS() != null) {
                        adS().mo34141a(qStoryboard, i, i2, true);
                        adS().mo34143b(qStoryboard, true);
                    }
                } else if (adS() != null) {
                    adS().mo34141a(qStoryboard, i, i2, false);
                    adS().mo34143b(qStoryboard, false);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m16284a(C8522g gVar, QStoryboard qStoryboard, QClip qClip, int i, int i2, C8443d dVar) {
        QRange qRange = (QRange) qClip.getProperty(12292);
        if (qRange == null || i == qRange.get(1)) {
            return false;
        }
        qRange.set(1, i);
        if (qRange.get(0) < 0) {
            qRange.set(0, 0);
            C5839a.m16330eA(VivaBaseApplication.m8749FZ());
        }
        qClip.setProperty(12292, qRange);
        m16283a(gVar, qStoryboard, i2, 0);
        if (dVar == null) {
            return false;
        }
        QRange qRange2 = (QRange) qClip.getProperty(12292);
        C8440a tX = dVar.mo34307tX(i2);
        if (tX == null) {
            return false;
        }
        tX.mo34216a(qRange2);
        dVar.mo34311ua(mo27891ld(i2));
        return true;
    }

    /* renamed from: a */
    public boolean mo28175a(int i, int i2, boolean z, int i3, int i4, int i5) {
        C8522g adK = adK();
        QStoryboard adO = adO();
        if (adK == null || adO == null) {
            return false;
        }
        C8443d aJB = adK.aJB();
        if (z && i == i3 && i2 == i4) {
            return false;
        }
        QClip lM = mo28178lM(i5);
        if (lM == null) {
            return false;
        }
        lM.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE, Boolean.valueOf(true));
        QRange qRange = (QRange) lM.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE);
        if (qRange == null) {
            qRange = new QRange();
        }
        qRange.set(0, i3);
        qRange.set(1, i4 - i3);
        lM.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE, qRange);
        m16283a(adK, adO, i5, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("PROP_CLIP_IS_REVERSE_MODE: ");
        sb.append(lM.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE));
        sb.append("  TrimReverseRange :");
        sb.append(lM.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE).toString());
        LogUtilsV2.m14227d(sb.toString());
        if (aJB != null) {
            QRange qRange2 = (QRange) lM.getProperty(QClip.PROP_CLIP_SRC_RANGE);
            C8440a tX = aJB.mo34307tX(i5);
            tX.mo34246jj(true);
            tX.mo34236c(qRange);
            tX.mo34216a(qRange2);
            aJB.mo34311ua(i5);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo28176b(int i, int i2, boolean z, int i3, int i4, int i5) {
        C8522g adK = adK();
        QStoryboard adO = adO();
        if (adK == null || adO == null) {
            return false;
        }
        C8443d aJB = adK.aJB();
        if (!z && i == i3 && i2 == i4) {
            return false;
        }
        QClip lM = mo28178lM(i5);
        if (lM == null) {
            return false;
        }
        lM.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE, Boolean.valueOf(false));
        QRange qRange = (QRange) lM.getProperty(12292);
        if (qRange == null) {
            return false;
        }
        if (i != i3) {
            if (i3 < 0) {
                C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                i3 = 0;
            }
            qRange.set(0, i3);
            qRange.set(1, i2 - i3);
            lM.setProperty(12292, qRange);
            m16283a(adK, adO, i5, i3 - i);
        }
        if (i2 != i4) {
            qRange.set(1, i4 - i3);
            lM.setProperty(12292, qRange);
            m16283a(adK, adO, i5, 0);
        }
        if (aJB != null) {
            QRange qRange2 = (QRange) lM.getProperty(12292);
            C8440a tX = aJB.mo34307tX(i5);
            tX.mo34216a(qRange2);
            tX.mo34246jj(false);
            aJB.mo34311ua(i5);
        }
        m16282a(i3, i4, lM);
        return true;
    }

    /* renamed from: i */
    public boolean mo28177i(int i, int i2, boolean z) {
        C8522g adK = adK();
        QStoryboard adO = adO();
        if (adK == null || adO == null) {
            return false;
        }
        QClip lM = mo28178lM(i);
        if (lM == null) {
            return false;
        }
        C8443d aJB = adK.aJB();
        m16284a(adK, adO, lM, i2, i, aJB);
        if (z) {
            int clipCount = aJB.getClipCount();
            for (int i3 = 0; i3 < clipCount; i3++) {
                int ld = mo27891ld(i3);
                if (ld != this.cwZ) {
                    QClip i4 = C8540q.m24956i(adO, ld);
                    if (i4 != null) {
                        C8440a tX = aJB.mo34307tX(ld);
                        if (tX != null && tX.isImage() && tX.aHR() >= i2 && !m16284a(adK, adO, i4, i2, ld, aJB)) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: lM */
    public QClip mo28178lM(int i) {
        return C8540q.m24956i(adO(), i);
    }
}
