package com.introvd.template.template.data.p406db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.dao.gen.C8684a;
import com.introvd.template.template.data.dao.gen.C8684a.C8685a;
import com.introvd.template.template.data.dao.gen.C8686b;
import com.introvd.template.template.data.dao.p405a.C8683a;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.vivavideo.p428a.p429a.C9274a;
import org.greenrobot.p490a.p492b.C9972a;

/* renamed from: com.introvd.template.template.data.db.b */
public class C8688b {
    private static C8688b eld;
    private Context applicationContext;
    private boolean bxM;
    public C8682a dAS;
    private C8686b ele;
    private C8689a elf;

    /* renamed from: com.introvd.template.template.data.db.b$a */
    class C8689a extends C8685a {
        public C8689a(Context context, String str) {
            super(context, str);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            LogUtilsV2.m14227d("onDowngrade Database SQLiteDatabase");
            C8684a.dropAllTables(wrap(sQLiteDatabase), true);
            onCreate(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            super.onUpgrade(sQLiteDatabase, i, i2);
            LogUtilsV2.m14227d("onUpgrade SQLiteDatabase SQLiteDatabase");
        }

        public void onUpgrade(C9972a aVar, int i, int i2) {
            super.onUpgrade(aVar, i, i2);
            C9274a.m26966a(aVar, DBTemplateAudioInfo.class);
            LogUtilsV2.m14227d("onUpgrade Database SQLiteDatabase");
        }
    }

    /* renamed from: a */
    private void m25283a(C8686b bVar) {
        this.dAS = new C8683a(bVar);
    }

    public static synchronized C8688b aKs() {
        C8688b bVar;
        synchronized (C8688b.class) {
            if (eld == null) {
                synchronized (C8688b.class) {
                    if (eld == null) {
                        eld = new C8688b();
                    }
                }
            }
            bVar = eld;
        }
        return bVar;
    }

    public C8682a aKt() {
        return this.dAS;
    }

    /* renamed from: cG */
    public void mo35025cG(Context context) {
        if (!this.bxM) {
            synchronized (this) {
                this.bxM = true;
                this.applicationContext = context;
                this.elf = new C8689a(context, "xiaoying_template.db");
                this.ele = new C8684a(this.elf.getWritableDb()).newSession();
                m25283a(this.ele);
            }
        }
    }
}
