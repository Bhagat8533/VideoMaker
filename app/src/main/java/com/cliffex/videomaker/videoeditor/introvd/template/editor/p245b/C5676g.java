package com.introvd.template.editor.p245b;

import com.introvd.template.common.MSize;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.b.g */
public class C5676g implements C5675f {
    private QStoryboard cFJ;

    public C5676g(QStoryboard qStoryboard) {
        this.cFJ = qStoryboard;
        if (this.cFJ == null) {
            return;
        }
        if (C5842b.ahe()) {
            this.cFJ.setProperty(QStoryboard.PROP_SINGLE_HW_INSTANCE, Boolean.valueOf(true));
        } else if (C5842b.ahg()) {
            this.cFJ.setProperty(QStoryboard.PROP_FORCE_STATIC_TRANS, Boolean.valueOf(true));
        }
    }

    /* renamed from: a */
    public QSessionStream mo27761a(MSize mSize, int i, int i2) {
        if (this.cFJ == null || mSize == null) {
            return null;
        }
        return C8563r.m25045a(i, this.cFJ, 0, 0, new QRect(0, 0, C8572y.m25087dI(mSize.width, 2), C8572y.m25087dI(mSize.height, 2)), 65537, 0, i2);
    }

    public boolean adU() {
        if (ain()) {
            return C8540q.m24976w(this.cFJ);
        }
        return false;
    }

    public String ail() {
        return (String) this.cFJ.getProperty(16391);
    }

    public boolean aim() {
        if (this.cFJ != null) {
            QEngine engine = this.cFJ.getEngine();
            if (engine != null) {
                return C8572y.m25092e(engine);
            }
        }
        return false;
    }

    public boolean ain() {
        if (this.cFJ != null) {
            return C8540q.m24893B(this.cFJ);
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo27765c(MSize mSize) {
        return C8540q.m24935a(this.cFJ, mSize != null ? new VeMSize(mSize.width, mSize.height) : null);
    }
}
