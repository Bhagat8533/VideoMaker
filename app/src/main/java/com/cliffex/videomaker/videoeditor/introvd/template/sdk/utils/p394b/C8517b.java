package com.introvd.template.sdk.utils.p394b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QTransition;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.utils.b.b */
public class C8517b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a */
    public static void m24643a(C8443d dVar) {
        C8440a tX = dVar.mo34307tX(dVar.getCount() - 1);
        if (tX != null && tX.isCover()) {
            int aHO = tX.aHO();
            if (aHO > 0) {
                C8440a tX2 = dVar.mo34307tX(dVar.getCount() - 2);
                if (tX2 != null && !tX2.isCover()) {
                    tX2.mo34255tO(aHO);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m24644a(C8443d dVar, QStoryboard qStoryboard) {
        if (dVar != null && qStoryboard != null) {
            int D = C8540q.m24895D(qStoryboard);
            int count = dVar.getCount();
            if (Math.abs(D - count) <= 1) {
                C8440a tX = dVar.mo34307tX(count - 1);
                if (tX != null && tX.isCover() && D > 2) {
                    int i = D - 2;
                    QClip i2 = C8540q.m24956i(qStoryboard, i);
                    if (i2 != null) {
                        QTransition qTransition = (QTransition) i2.getProperty(12294);
                        int i3 = 0;
                        if (qTransition != null) {
                            i3 = qTransition.getDuration();
                        }
                        C8440a tX2 = dVar.mo34307tX(i);
                        if (tX2 != null) {
                            tX2.mo34255tO(i3);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m24645a(QStoryboard qStoryboard, int i, C8440a aVar, boolean z) {
        if (aVar != null) {
            aVar.mo34253tM(i);
            QClip i2 = C8540q.m24956i(qStoryboard, i);
            if (i2 != null) {
                C8518c.m24650a(i2, aVar);
                if (z && aVar.aHM() == null) {
                    Bitmap j = C8537n.m24831j(i2);
                    aVar.mo34264u(j);
                    String aHU = aVar.aHU();
                    if (!TextUtils.isEmpty(aHU)) {
                        C8536m.m24782a(aHU, i, j);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m24646a(QStoryboard qStoryboard, C8443d dVar, Context context) throws IllegalStateException {
        if (dVar != null && qStoryboard != null && context != null) {
            dVar.releaseAll();
            int D = C8540q.m24895D(qStoryboard);
            if (D != 0) {
                int count = dVar.getCount();
                if (count < D) {
                    while (count < D) {
                        C8440a c = m24648c(C8540q.m24956i(qStoryboard, count), count);
                        if (c != null) {
                            dVar.mo34292a(c);
                        }
                        count++;
                    }
                    dVar.aIl();
                    m24643a(dVar);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m24647b(QStoryboard qStoryboard, C8443d dVar, Context context) {
        if (dVar != null && qStoryboard != null && context != null) {
            int D = C8540q.m24895D(qStoryboard);
            if (D == 0) {
                dVar.releaseAll();
                return;
            }
            int count = dVar.getCount();
            if (count == D + 2) {
                dVar.mo34297bN(count - 1);
                dVar.mo34297bN(0);
            } else if (count + 2 == D) {
                dVar.mo34293a(new C8440a(), count);
                dVar.mo34293a(new C8440a(), 0);
            }
            if (dVar.getCount() != D) {
                m24646a(qStoryboard, dVar, context);
                m24643a(dVar);
                return;
            }
            for (int i = 0; i < D; i++) {
                C8440a tX = dVar.mo34307tX(i);
                if (tX != null) {
                    m24645a(qStoryboard, i, tX, false);
                }
            }
            m24643a(dVar);
        }
    }

    /* renamed from: c */
    public static C8440a m24648c(QClip qClip, int i) {
        if (qClip == null) {
            return null;
        }
        C8440a aVar = new C8440a();
        aVar.mo34253tM(i);
        C8518c.m24650a(qClip, aVar);
        return aVar;
    }
}
