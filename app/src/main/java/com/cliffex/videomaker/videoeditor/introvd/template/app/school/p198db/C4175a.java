package com.introvd.template.app.school.p198db;

import android.content.Context;
import com.introvd.template.app.school.p198db.classes.C4179b;
import com.introvd.template.app.school.p198db.template.C4184a;

/* renamed from: com.introvd.template.app.school.db.a */
public class C4175a {
    private static volatile C4175a bxI;
    private C4176b bxJ = new C4176b();

    private C4175a() {
    }

    /* renamed from: NW */
    public static C4175a m10395NW() {
        if (bxI == null) {
            synchronized (C4175a.class) {
                if (bxI == null) {
                    bxI = new C4175a();
                }
            }
        }
        return bxI;
    }

    /* renamed from: NX */
    public C4179b mo24015NX() {
        return this.bxJ.mo24019NX();
    }

    /* renamed from: NY */
    public C4184a mo24016NY() {
        return this.bxJ.mo24021Oa();
    }

    /* renamed from: NZ */
    public void mo24017NZ() {
        this.bxJ.mo24020NZ();
    }

    /* renamed from: cG */
    public void mo24018cG(Context context) {
        this.bxJ.mo24022cG(context);
    }
}
