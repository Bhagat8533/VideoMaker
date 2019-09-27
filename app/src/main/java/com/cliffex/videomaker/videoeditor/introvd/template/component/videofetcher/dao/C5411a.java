package com.introvd.template.component.videofetcher.dao;

import android.text.TextUtils;
import com.introvd.template.component.videofetcher.dao.gen.C5417b;
import com.introvd.template.component.videofetcher.dao.gen.DownloadInfoBeanDao;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import java.util.List;

/* renamed from: com.introvd.template.component.videofetcher.dao.a */
class C5411a implements C5414c {
    private DownloadInfoBeanDao cki;

    public C5411a(C5417b bVar) {
        if (bVar != null) {
            this.cki = bVar.aac();
        }
    }

    /* renamed from: ZY */
    public List<C5391a> mo27038ZY() {
        return this.cki.queryBuilder().bas().list();
    }

    /* renamed from: b */
    public void mo27039b(C5391a aVar) {
        if (aVar != null) {
            this.cki.insertOrReplace(aVar);
        }
    }

    /* renamed from: c */
    public void mo27040c(C5391a aVar) {
        if (aVar != null) {
            this.cki.update(aVar);
        }
    }

    public void deleteAll() {
        this.cki.deleteAll();
    }

    /* renamed from: fF */
    public void mo27042fF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cki.deleteByKey(str);
        }
    }
}
