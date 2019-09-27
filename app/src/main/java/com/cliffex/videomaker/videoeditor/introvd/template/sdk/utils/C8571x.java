package com.introvd.template.sdk.utils;

import com.introvd.template.sdk.editor.cache.C8442c;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.sdk.utils.x */
public class C8571x {
    /* renamed from: a */
    public static QDisplayContext m25058a(int i, int i2, int i3, Object obj, boolean z) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        QRect qRect = new QRect(0, 0, i, i2);
        QDisplayContext qDisplayContext = new QDisplayContext(qRect, qRect, 0, 0, 0, z ? 65537 : 65538, i3);
        qDisplayContext.setSurfaceHolder(obj);
        return qDisplayContext;
    }

    /* renamed from: a */
    public static QDisplayContext m25059a(VeMSize veMSize, VeMSize veMSize2, int i, Object obj, C8442c cVar) {
        int i2;
        int i3;
        VeMSize veMSize3 = new VeMSize(veMSize2.width, veMSize2.height);
        if (veMSize.width <= 0 || veMSize.height <= 0 || veMSize3.width <= 0 || veMSize3.height <= 0) {
            return null;
        }
        if (cVar.aIi()) {
            veMSize3.width ^= veMSize3.height;
            veMSize3.height ^= veMSize3.width;
            veMSize3.width ^= veMSize3.height;
        }
        if (veMSize.width == veMSize3.width || veMSize.width == veMSize3.height || veMSize.height == veMSize3.width || veMSize.height == veMSize3.height) {
            i3 = (veMSize.width - veMSize3.width) / 2;
            i2 = (veMSize.height - veMSize3.height) / 2;
        } else {
            VeMSize d = C8572y.m25086d(new VeMSize(veMSize3.width, veMSize3.height), veMSize);
            i3 = (veMSize.width - d.width) / 2;
            i2 = (veMSize.height - d.height) / 2;
        }
        QRect qRect = new QRect(i3, i2, veMSize3.width + i3, veMSize3.height + i2);
        QDisplayContext qDisplayContext = new QDisplayContext(qRect, qRect, 0, cVar.aHX(), 0, 3, i);
        qDisplayContext.setSurfaceHolder(obj);
        return qDisplayContext;
    }

    /* renamed from: c */
    public static QDisplayContext m25060c(int i, int i2, int i3, Object obj) {
        return m25058a(i, i2, i3, obj, true);
    }
}
