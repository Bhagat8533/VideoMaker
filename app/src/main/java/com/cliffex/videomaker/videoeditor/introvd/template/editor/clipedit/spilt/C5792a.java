package com.introvd.template.editor.clipedit.spilt;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.clipedit.spilt.a */
public class C5792a extends C5694a {
    private int mClipIndex = 0;

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0182 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0183  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m16114a(com.introvd.template.sdk.editor.cache.C8443d r26, int r27, xiaoying.engine.clip.QClip r28, int r29, int r30) {
        /*
            r25 = this;
            r0 = r28
            r1 = r30
            com.introvd.template.sdk.editor.cache.a r2 = r26.mo34307tX(r27)
            r3 = 12318(0x301e, float:1.7261E-41)
            java.lang.Object r4 = r0.getProperty(r3)
            xiaoying.engine.base.QRange r4 = (xiaoying.engine.base.QRange) r4
            r5 = 0
            int r6 = r4.get(r5)
            r7 = 1
            int r8 = r4.get(r7)
            xiaoying.engine.storyboard.QStoryboard r9 = r25.adO()
            r25.adK()
            if (r8 >= 0) goto L_0x0025
            r11 = -1
            goto L_0x0027
        L_0x0025:
            int r11 = r6 + r8
        L_0x0027:
            r12 = 12340(0x3034, float:1.7292E-41)
            java.lang.Object r13 = r0.getProperty(r12)
            xiaoying.engine.base.QRange r13 = (xiaoying.engine.base.QRange) r13
            int r14 = r13.get(r5)
            int r15 = r13.get(r7)
            boolean r10 = r0 instanceof xiaoying.engine.clip.QSceneClip
            if (r10 == 0) goto L_0x0041
            xiaoying.engine.clip.QSceneClip r10 = new xiaoying.engine.clip.QSceneClip
            r10.<init>()
            goto L_0x0046
        L_0x0041:
            xiaoying.engine.clip.QClip r10 = new xiaoying.engine.clip.QClip
            r10.<init>()
        L_0x0046:
            int r17 = r0.duplicate(r10)
            if (r17 == 0) goto L_0x004d
            return r5
        L_0x004d:
            r12 = 12293(0x3005, float:1.7226E-41)
            java.lang.Object r12 = r0.getProperty(r12)
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            r5 = r29
            int r5 = xiaoying.engine.base.QUtils.convertPosition(r5, r12, r7)
            xiaoying.engine.clip.QEffect r12 = com.introvd.template.sdk.utils.p394b.C8537n.m24832k(r28)
            if (r5 >= r14) goto L_0x00ae
            if (r11 >= 0) goto L_0x0069
            r11 = -1
            goto L_0x006b
        L_0x0069:
            int r11 = r11 - r5
            int r11 = r11 - r6
        L_0x006b:
            xiaoying.engine.base.QRange r7 = new xiaoying.engine.base.QRange
            r7.<init>(r5, r11)
            int r16 = r10.setProperty(r3, r7)
            if (r16 == 0) goto L_0x0078
            r3 = 0
            return r3
        L_0x0078:
            r18 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r18)
            r19 = r7
            r7 = 12339(0x3033, float:1.729E-41)
            int r3 = r10.setProperty(r7, r3)
            if (r3 == 0) goto L_0x008a
            r3 = 0
            return r3
        L_0x008a:
            r3 = 0
            xiaoying.engine.base.QRange r7 = new xiaoying.engine.base.QRange
            r7.<init>()
            r20 = r11
            int r11 = r14 - r5
            r7.set(r3, r11)
            r11 = 1
            int r3 = r13.get(r11)
            r7.set(r11, r3)
            r3 = 12340(0x3034, float:1.7292E-41)
            int r11 = r10.setProperty(r3, r7)
            if (r11 == 0) goto L_0x00a9
            r3 = 0
            return r3
        L_0x00a9:
            r22 = r19
            r11 = r20
            goto L_0x00dc
        L_0x00ae:
            if (r11 >= 0) goto L_0x00b2
            r11 = -1
            goto L_0x00b7
        L_0x00b2:
            int r11 = r11 - r5
            int r11 = r11 - r6
            int r3 = r11 - r15
            r11 = r3
        L_0x00b7:
            xiaoying.engine.base.QRange r7 = new xiaoying.engine.base.QRange
            int r3 = r5 + r15
            r7.<init>(r3, r11)
            r3 = 12318(0x301e, float:1.7261E-41)
            int r16 = r10.setProperty(r3, r7)
            if (r16 == 0) goto L_0x00c8
            r3 = 0
            return r3
        L_0x00c8:
            r21 = r7
            r3 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            r3 = 12339(0x3033, float:1.729E-41)
            int r7 = r10.setProperty(r3, r7)
            if (r7 == 0) goto L_0x00d9
            r3 = 0
            return r3
        L_0x00d9:
            r7 = r13
            r22 = r21
        L_0x00dc:
            r3 = 4112(0x1010, float:5.762E-42)
            if (r12 == 0) goto L_0x0119
            java.lang.Object r16 = r12.getProperty(r3)
            r3 = r16
            xiaoying.engine.base.QRange r3 = (xiaoying.engine.base.QRange) r3
            if (r3 == 0) goto L_0x0119
            r23 = r7
            xiaoying.engine.base.QRange r7 = new xiaoying.engine.base.QRange
            r7.<init>(r3)
            r3 = 0
            int r16 = r7.get(r3)
            r3 = 1
            int r17 = r7.get(r3)
            if (r8 <= r11) goto L_0x0101
            int r16 = r16 + r17
            int r16 = r16 - r11
        L_0x0101:
            r24 = r2
            r8 = r16
            r2 = 0
            r7.set(r2, r8)
            r7.set(r3, r11)
            xiaoying.engine.clip.QEffect r3 = com.introvd.template.sdk.utils.p394b.C8537n.m24832k(r10)
            r8 = 4112(0x1010, float:5.762E-42)
            int r3 = r3.setProperty(r8, r7)
            if (r3 == 0) goto L_0x011e
            return r2
        L_0x0119:
            r24 = r2
            r23 = r7
            r2 = 0
        L_0x011e:
            if (r5 >= r14) goto L_0x013e
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r7 = 12339(0x3033, float:1.729E-41)
            int r3 = r0.setProperty(r7, r3)
            if (r3 == 0) goto L_0x012d
            return r2
        L_0x012d:
            if (r5 <= 0) goto L_0x0134
            r3 = 1
            r4.set(r3, r5)
            goto L_0x0135
        L_0x0134:
            r3 = 1
        L_0x0135:
            r7 = 12318(0x301e, float:1.7261E-41)
            int r0 = r0.setProperty(r7, r4)
            if (r0 == 0) goto L_0x0164
            return r2
        L_0x013e:
            r3 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            r8 = 12339(0x3033, float:1.729E-41)
            int r7 = r0.setProperty(r8, r7)
            if (r7 == 0) goto L_0x014c
            return r2
        L_0x014c:
            if (r5 <= 0) goto L_0x0152
            int r15 = r15 + r5
            r4.set(r3, r15)
        L_0x0152:
            r3 = 12318(0x301e, float:1.7261E-41)
            int r3 = r0.setProperty(r3, r4)
            if (r3 == 0) goto L_0x015b
            return r2
        L_0x015b:
            r3 = 12340(0x3034, float:1.7292E-41)
            int r0 = r0.setProperty(r3, r13)
            if (r0 == 0) goto L_0x0164
            return r2
        L_0x0164:
            if (r12 == 0) goto L_0x017c
            r0 = 4112(0x1010, float:5.762E-42)
            java.lang.Object r3 = r12.getProperty(r0)
            xiaoying.engine.base.QRange r3 = (xiaoying.engine.base.QRange) r3
            if (r3 == 0) goto L_0x017c
            int r6 = r6 + r5
            r4 = 1
            r3.set(r4, r6)
            int r0 = r12.setProperty(r0, r3)
            if (r0 == 0) goto L_0x017c
            return r2
        L_0x017c:
            int r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24923a(r9, r10, r1)
            if (r0 == 0) goto L_0x0183
            return r2
        L_0x0183:
            if (r24 == 0) goto L_0x01c7
            com.introvd.template.sdk.editor.cache.a r0 = new com.introvd.template.sdk.editor.cache.a
            r2 = r24
            r0.<init>(r2)
            r0.mo34253tM(r1)
            if (r5 >= r14) goto L_0x01aa
            r3 = 1
            r0.mo34246jj(r3)
            r13 = r23
            r0.mo34236c(r13)
            r4 = r22
            int r5 = r4.get(r3)
            int r6 = r13.get(r3)
            int r5 = r5 - r6
            r4.set(r3, r5)
            r3 = 0
            goto L_0x01b0
        L_0x01aa:
            r4 = r22
            r3 = 0
            r0.mo34246jj(r3)
        L_0x01b0:
            r0.mo34216a(r4)
            r4 = 0
            r0.mo34264u(r4)
            r4 = r26
            r4.mo34293a(r0, r1)
            r26.aIl()
            r4 = r27
            com.introvd.template.sdk.utils.p394b.C8517b.m24645a(r9, r4, r2, r3)
            com.introvd.template.sdk.utils.p394b.C8517b.m24645a(r9, r1, r0, r3)
        L_0x01c7:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.spilt.C5792a.m16114a(com.introvd.template.sdk.editor.cache.d, int, xiaoying.engine.clip.QClip, int, int):boolean");
    }

    /* renamed from: a */
    private boolean m16115a(C8443d dVar, int i, QClip qClip, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean z;
        int i8;
        QClip qClip2 = qClip;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        QEffect k = C8537n.m24832k(qClip);
        QRange qRange = (QRange) qClip2.getProperty(QClip.PROP_CLIP_SRC_RANGE);
        QStoryboard adO = adO();
        adK();
        if (qRange != null) {
            i7 = qRange.get(0);
            int i12 = qRange.get(1);
            i6 = i12 < 0 ? -1 : i12 + i7;
        } else {
            i7 = 0;
            i6 = 0;
        }
        QClip qSceneClip = qClip2 instanceof QSceneClip ? new QSceneClip() : new QClip();
        if (qClip2.duplicate(qSceneClip) != 0) {
            return false;
        }
        int convertPosition = QUtils.convertPosition(i9, ((Float) qClip2.getProperty(12293)).floatValue(), true);
        int i13 = ((QRange) qClip2.getProperty(12292)).get(0);
        int i14 = i6 < 0 ? -1 : ((i6 - convertPosition) - i7) - i13;
        QRange qRange2 = new QRange(i7 + convertPosition + i13, i14);
        StringBuilder sb = new StringBuilder();
        sb.append("new clip srcRange start: ");
        sb.append(qRange2.get(0));
        sb.append(" length: ");
        sb.append(qRange2.get(1));
        LogUtils.m14221d("dynamic", sb.toString());
        if (qSceneClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange2) != 0) {
            return false;
        }
        QRange qRange3 = new QRange(0, i5 - i9);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("new clip trimRange start: ");
        sb2.append(qRange3.get(0));
        sb2.append(" length: ");
        sb2.append(qRange3.get(1));
        LogUtils.m14221d("dynamic", sb2.toString());
        if (qSceneClip.setProperty(12292, qRange3) != 0) {
            return false;
        }
        if (k != null) {
            QRange qRange4 = (QRange) k.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE);
            if (qRange4 != null) {
                QRange qRange5 = new QRange(qRange4);
                int i15 = qRange5.get(0);
                int i16 = qRange5.get(1);
                if (i16 > i14) {
                    i15 = (i15 + i16) - i14;
                }
                qRange5.set(0, i15);
                qRange5.set(1, i14);
                if (C8537n.m24832k(qSceneClip).setProperty(QEffect.PROP_AUDIO_FRAME_RANGE, qRange5) != 0) {
                    return false;
                }
            }
        }
        if (C8540q.m24923a(adO, qSceneClip, i10) != 0) {
            return false;
        }
        if (qRange != null) {
            if (convertPosition > 0) {
                qRange.set(1, convertPosition + i13);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("source clip srcRange start: ");
            sb3.append(qRange.get(0));
            sb3.append(" length: ");
            sb3.append(qRange.get(1));
            LogUtils.m14221d("dynamic", sb3.toString());
            if (qClip2.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange) != 0) {
                return false;
            }
        }
        QRange qRange6 = (QRange) qClip2.getProperty(12292);
        if (qRange6 != null) {
            int i17 = i11 + i13;
            if (i17 < 0) {
                C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                i8 = 0;
                i17 = 0;
            } else {
                i8 = 0;
            }
            qRange6.set(i8, i17);
            int i18 = i9 - i11;
            qRange6.set(1, i18);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("splitClip firstClip iClipTrimLeft=");
            sb4.append(i11);
            sb4.append(";firstLen=");
            sb4.append(i18);
            LogUtilsV2.m14227d(sb4.toString());
            int property = qClip2.setProperty(12292, qRange6);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("source clip trimRange start: ");
            z = false;
            sb5.append(qRange6.get(0));
            sb5.append(" length: ");
            sb5.append(qRange6.get(1));
            LogUtils.m14221d("dynamic", sb5.toString());
            if (property != 0) {
                return false;
            }
        } else {
            z = false;
        }
        if (k != null) {
            QRange qRange7 = (QRange) k.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE);
            if (qRange7 != null) {
                qRange7.set(1, convertPosition + i13);
                if (k.setProperty(QEffect.PROP_AUDIO_FRAME_RANGE, qRange7) != 0) {
                    return z;
                }
            }
        }
        C8440a tX = dVar.mo34307tX(i);
        if (tX != null) {
            C8440a aVar = new C8440a(tX);
            aVar.mo34253tM(i10);
            aVar.mo34264u(null);
            dVar.mo34293a(aVar, i10);
            dVar.aIl();
            C8517b.m24645a(adO, i, tX, false);
            C8517b.m24645a(adO, i10, aVar, false);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public boolean mo28065A(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("splitClip curTime=");
        sb.append(i3);
        sb.append(";iClipTrimLeft=");
        sb.append(i);
        sb.append(";iClipTrimRight=");
        sb.append(i2);
        LogUtilsV2.m14227d(sb.toString());
        boolean z = false;
        if (i3 < i || i3 >= i2) {
            return false;
        }
        int i4 = i2 - i3;
        if (i3 - i >= 500 && i4 >= 500) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: B */
    public boolean mo28066B(int i, int i2, int i3) {
        int i4 = this.mClipIndex;
        QStoryboard adO = adO();
        ProjectItem ahP = adK().aHf();
        if (ahP == null) {
            return false;
        }
        C8443d dVar = ahP.mClipModelCacheList;
        if (adO == null || dVar == null || !mo28065A(i, i2, i3)) {
            return false;
        }
        int i5 = i4 + 1;
        QClip i6 = C8540q.m24956i(adO, i4);
        if (i6 != null) {
            return ((Boolean) i6.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue() ? m16114a(dVar, i4, i6, i3, i5) : m16115a(dVar, i4, i6, i3, i5, i, i2);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void setClipIndex(int i) {
        this.mClipIndex = i;
    }
}
