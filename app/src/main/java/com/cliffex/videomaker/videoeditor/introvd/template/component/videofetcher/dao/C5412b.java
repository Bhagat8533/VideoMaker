package com.introvd.template.component.videofetcher.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.component.videofetcher.dao.gen.C5415a;
import com.introvd.template.component.videofetcher.dao.gen.C5415a.C5416a;
import com.introvd.template.component.videofetcher.dao.gen.C5417b;
import org.greenrobot.p490a.p492b.C9972a;

/* renamed from: com.introvd.template.component.videofetcher.dao.b */
public class C5412b {
    private static C5412b ckj;
    private Context applicationContext;
    public boolean bxM;
    private C5417b ckk;
    private C5413a ckl;
    public C5414c ckm;

    /* renamed from: com.introvd.template.component.videofetcher.dao.b$a */
    class C5413a extends C5416a {
        public C5413a(Context context, String str) {
            super(context, str);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C5415a.dropAllTables(wrap(sQLiteDatabase), true);
            onCreate(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            super.onUpgrade(sQLiteDatabase, i, i2);
        }

        public void onUpgrade(C9972a aVar, int i, int i2) {
            super.onUpgrade(aVar, i, i2);
        }
    }

    /* renamed from: ZZ */
    public static C5412b m14731ZZ() {
        if (ckj == null) {
            synchronized (C5412b.class) {
                if (ckj == null) {
                    ckj = new C5412b();
                }
            }
        }
        return ckj;
    }

    /* renamed from: a */
    private void m14732a(C5417b bVar) {
        this.ckm = new C5411a(bVar);
    }

    public C5414c aaa() {
        return this.ckm;
    }

    /* renamed from: cG */
    public void mo27044cG(Context context) {
        if (!this.bxM) {
            synchronized (this) {
                this.bxM = true;
                this.applicationContext = context;
                this.ckl = new C5413a(context, "video_fetcher_download.db");
                this.ckk = new C5415a(this.ckl.getWritableDb()).newSession();
                m14732a(this.ckk);
            }
        }
    }
}
