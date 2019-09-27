package com.introvd.template.editor.gallery.preview;

import com.introvd.template.common.MSize;

/* renamed from: com.introvd.template.editor.gallery.preview.a */
public class C6363a {
    public int action;
    public String cTw;
    public int cTx;
    public MSize cTy;
    public int duration = 0;

    public C6363a() {
    }

    public C6363a(String str, int i) {
        this.cTw = str;
        this.cTx = i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C6363a aVar = (C6363a) obj;
        if (this.cTx != aVar.cTx) {
            return false;
        }
        if (this.cTw != null) {
            z = this.cTw.equals(aVar.cTw);
        } else if (aVar.cTw != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.cTw != null ? this.cTw.hashCode() : 0) * 31) + this.cTx;
    }
}
