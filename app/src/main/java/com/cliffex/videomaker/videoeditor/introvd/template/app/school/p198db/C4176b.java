package com.introvd.template.app.school.p198db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.app.school.p198db.classes.C4178a;
import com.introvd.template.app.school.p198db.classes.C4179b;
import com.introvd.template.app.school.p198db.classes.DBClassInfo;
import com.introvd.template.app.school.p198db.dao.gen.C4181a;
import com.introvd.template.app.school.p198db.dao.gen.C4181a.C4182a;
import com.introvd.template.app.school.p198db.dao.gen.C4183b;
import com.introvd.template.app.school.p198db.template.C4184a;
import com.introvd.template.app.school.p198db.template.C4185b;
import com.introvd.template.app.school.p198db.template.TemplateItemInfo;
import com.introvd.template.common.LogUtilsV2;
import com.vivavideo.p428a.p429a.C9274a;
import org.greenrobot.p490a.p492b.C9972a;

/* renamed from: com.introvd.template.app.school.db.b */
class C4176b {
    private C4183b bxK;
    private C4177a bxL;
    private boolean bxM;
    private C4179b bxN;
    private C4184a bxO;

    /* renamed from: com.introvd.template.app.school.db.b$a */
    class C4177a extends C4182a {
        C4177a(Context context, String str) {
            super(context, str);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            LogUtilsV2.m14227d("onDowngrade Database SQLiteDatabase");
            C4181a.dropAllTables(wrap(sQLiteDatabase), true);
            onCreate(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            super.onUpgrade(sQLiteDatabase, i, i2);
            LogUtilsV2.m14227d("onUpgrade SQLiteDatabase SQLiteDatabase");
        }

        public void onUpgrade(C9972a aVar, int i, int i2) {
            super.onUpgrade(aVar, i, i2);
            C4181a.createAllTables(aVar, true);
            C9274a.m26966a(aVar, DBClassInfo.class);
            C9274a.m26966a(aVar, TemplateItemInfo.class);
            LogUtilsV2.m14227d("onUpgrade Database SQLiteDatabase");
        }
    }

    C4176b() {
    }

    /* renamed from: a */
    private void m10400a(C4183b bVar) {
        this.bxN = new C4178a(bVar);
        this.bxO = new C4185b(bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: NX */
    public C4179b mo24019NX() {
        return this.bxN;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: NZ */
    public void mo24020NZ() {
        if (this.bxK != null) {
            this.bxK.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Oa */
    public C4184a mo24021Oa() {
        return this.bxO;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cG */
    public void mo24022cG(Context context) {
        if (!this.bxM) {
            synchronized (this) {
                this.bxM = true;
                this.bxL = new C4177a(context, "xiaoying_school.db");
                this.bxK = new C4181a(this.bxL.getWritableDb()).newSession();
                m10400a(this.bxK);
            }
        }
    }
}
