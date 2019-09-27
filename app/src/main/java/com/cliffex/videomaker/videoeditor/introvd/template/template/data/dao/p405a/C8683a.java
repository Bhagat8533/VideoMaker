package com.introvd.template.template.data.dao.p405a;

import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.dao.gen.C8686b;
import com.introvd.template.template.data.dao.gen.DBTemplateAudioInfoDao;
import com.introvd.template.template.data.dao.gen.DBTemplateAudioInfoDao.Properties;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.p490a.p495e.C10006h;
import org.greenrobot.p490a.p495e.C10008j;
import org.greenrobot.p490a.p495e.C10008j.C10011c;

/* renamed from: com.introvd.template.template.data.dao.a.a */
public class C8683a implements C8682a {
    private DBTemplateAudioInfoDao elc;

    public C8683a(C8686b bVar) {
        if (bVar != null) {
            this.elc = bVar.aKr();
        }
    }

    /* renamed from: O */
    public List<DBTemplateAudioInfo> mo35004O(String str, int i) {
        return this.elc.queryBuilder().mo38464a(Properties.ekV.mo38481aC(str), new C10008j[0]).mo38464a(Properties.ekZ.mo38481aC(Integer.valueOf(i)), new C10008j[0]).mo38466b(Properties.ekT).bas().list();
    }

    /* renamed from: ZY */
    public List<DBTemplateAudioInfo> mo35005ZY() {
        return this.elc.queryBuilder().mo38465a(Properties.ekT).bas().list();
    }

    /* renamed from: a */
    public void mo35006a(DBTemplateAudioInfo dBTemplateAudioInfo) {
        this.elc.insertOrReplace(dBTemplateAudioInfo);
    }

    public void deleteByKeyInTx(Iterable<String> iterable) {
        this.elc.deleteByKeyInTx(iterable);
    }

    public void insertOrReplaceInTx(Iterable<DBTemplateAudioInfo> iterable) {
        this.elc.insertOrReplaceInTx(iterable);
    }

    /* renamed from: pb */
    public void mo35009pb(String str) {
        this.elc.deleteByKey(str);
    }

    /* renamed from: pc */
    public DBTemplateAudioInfo mo35010pc(String str) {
        List list = this.elc.queryBuilder().mo38464a(Properties.ekY.mo38481aC(str), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (DBTemplateAudioInfo) list.get(0);
    }

    /* renamed from: uF */
    public List<DBTemplateAudioInfo> mo35011uF(int i) {
        return this.elc.queryBuilder().mo38464a(Properties.ekZ.mo38481aC(Integer.valueOf(i)), new C10008j[0]).mo38465a(Properties.ekT).bas().list();
    }

    /* renamed from: uG */
    public List<TemplateAudioCategory> mo35012uG(int i) {
        C10006h a = this.elc.queryBuilder().mo38464a(Properties.ekZ.mo38481aC(Integer.valueOf(i)), new C10008j[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("1=1 GROUP BY ");
        sb.append(Properties.ekV.fsc);
        List<DBTemplateAudioInfo> list = a.mo38464a((C10008j) new C10011c(sb.toString()), new C10008j[0]).mo38465a(Properties.ekX).bas().list();
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DBTemplateAudioInfo dBTemplateAudioInfo : list) {
            TemplateAudioCategory templateAudioCategory = new TemplateAudioCategory();
            templateAudioCategory.index = dBTemplateAudioInfo.categoryId;
            templateAudioCategory.name = dBTemplateAudioInfo.categoryName;
            templateAudioCategory.order = dBTemplateAudioInfo.categoryOrder;
            arrayList.add(templateAudioCategory);
        }
        return arrayList;
    }
}
