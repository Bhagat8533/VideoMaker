package com.introvd.template.template.data.dao;

import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import java.util.List;

/* renamed from: com.introvd.template.template.data.dao.a */
public interface C8682a {
    /* renamed from: O */
    List<DBTemplateAudioInfo> mo35004O(String str, int i);

    @Deprecated
    /* renamed from: ZY */
    List<DBTemplateAudioInfo> mo35005ZY();

    /* renamed from: a */
    void mo35006a(DBTemplateAudioInfo dBTemplateAudioInfo);

    void deleteByKeyInTx(Iterable<String> iterable);

    void insertOrReplaceInTx(Iterable<DBTemplateAudioInfo> iterable);

    /* renamed from: pb */
    void mo35009pb(String str);

    /* renamed from: pc */
    DBTemplateAudioInfo mo35010pc(String str);

    /* renamed from: uF */
    List<DBTemplateAudioInfo> mo35011uF(int i);

    /* renamed from: uG */
    List<TemplateAudioCategory> mo35012uG(int i);
}
