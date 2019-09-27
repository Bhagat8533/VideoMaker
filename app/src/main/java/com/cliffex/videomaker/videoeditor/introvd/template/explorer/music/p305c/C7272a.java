package com.introvd.template.explorer.music.p305c;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.explorer.music.item.C7297b;
import com.introvd.template.explorer.music.item.C7302d;
import com.introvd.template.explorer.music.local.LocalSubFragment;
import com.introvd.template.explorer.music.online.OnlineSubFragment;
import com.introvd.template.explorer.music.p304b.C7262a;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.explorer.music.p304b.C7266e;
import com.introvd.template.explorer.music.p304b.C7268g;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.api.model.TemplateAudioInfo;
import com.introvd.template.template.data.api.model.TemplateAudioInfoList;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;

/* renamed from: com.introvd.template.explorer.music.c.a */
public class C7272a {
    /* renamed from: a */
    public static DBTemplateAudioInfo m21448a(TemplateAudioInfo templateAudioInfo, List<DBTemplateAudioInfo> list, TemplateAudioCategory templateAudioCategory, int i) {
        if (templateAudioInfo == null) {
            return null;
        }
        DBTemplateAudioInfo dBTemplateAudioInfo = new DBTemplateAudioInfo();
        dBTemplateAudioInfo.index = templateAudioInfo.index;
        dBTemplateAudioInfo.categoryId = templateAudioInfo.categoryIndex;
        dBTemplateAudioInfo.coverUrl = templateAudioInfo.coverUrl;
        dBTemplateAudioInfo.audioUrl = templateAudioInfo.audioUrl;
        dBTemplateAudioInfo.name = templateAudioInfo.name;
        dBTemplateAudioInfo.duration = templateAudioInfo.duration;
        dBTemplateAudioInfo.author = templateAudioInfo.author;
        dBTemplateAudioInfo.album = templateAudioInfo.album;
        dBTemplateAudioInfo.newFlag = templateAudioInfo.newFlag;
        dBTemplateAudioInfo.order = (long) templateAudioInfo.order;
        dBTemplateAudioInfo.musicType = i;
        if (templateAudioCategory != null) {
            dBTemplateAudioInfo.categoryId = templateAudioCategory.index;
            dBTemplateAudioInfo.categoryName = templateAudioCategory.name;
            dBTemplateAudioInfo.categoryOrder = templateAudioCategory.order;
        }
        if (list == null || list.size() == 0) {
            dBTemplateAudioInfo.isDownloaded = false;
            dBTemplateAudioInfo.musicFilePath = null;
        } else {
            for (DBTemplateAudioInfo dBTemplateAudioInfo2 : list) {
                if (dBTemplateAudioInfo.index != null && dBTemplateAudioInfo.index.equals(dBTemplateAudioInfo2.index)) {
                    dBTemplateAudioInfo.isDownloaded = true;
                    dBTemplateAudioInfo.musicFilePath = dBTemplateAudioInfo2.musicFilePath;
                }
            }
        }
        dBTemplateAudioInfo.timeStr = C4584e.m11685ij(templateAudioInfo.duration / 1000);
        return dBTemplateAudioInfo;
    }

    /* renamed from: a */
    public static List<BaseItem> m21449a(OnlineSubFragment onlineSubFragment, TemplateAudioInfoList templateAudioInfoList, TemplateAudioCategory templateAudioCategory, int i, int i2) {
        int i3 = 0;
        if (templateAudioInfoList == null || templateAudioInfoList.audioInfoList == null || templateAudioInfoList.audioInfoList.size() == 0) {
            return new ArrayList(0);
        }
        if (i2 == 2) {
            i3 = 1;
        }
        C8682a aKt = C8688b.aKs().aKt();
        List list = null;
        if (aKt != null) {
            list = aKt.mo35011uF(i3);
        }
        ArrayList arrayList = new ArrayList();
        for (TemplateAudioInfo a : templateAudioInfoList.audioInfoList) {
            arrayList.add(new C7302d(onlineSubFragment, m21448a(a, list, templateAudioCategory, i3)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m21450a(int i, DBTemplateAudioInfo dBTemplateAudioInfo, int i2) {
        m21451a(i, dBTemplateAudioInfo, i2, 0, 0);
    }

    /* renamed from: a */
    public static void m21451a(int i, DBTemplateAudioInfo dBTemplateAudioInfo, int i2, int i3, int i4) {
        C7266e eVar = new C7266e();
        if (i2 == 3) {
            LogUtilsV2.m14227d("Jamin MusicPlayerEvent From MusicItem = STOP");
            eVar.setEventType(3);
            C10021c.aZH().mo38492aA(eVar);
        } else if (dBTemplateAudioInfo != null) {
            C7262a aVar = new C7262a();
            aVar.isDownloaded = dBTemplateAudioInfo.isDownloaded;
            aVar.dBm = i;
            aVar.dBn = i3;
            aVar.dBo = i4;
            if (aVar.isDownloaded) {
                aVar.dBl = dBTemplateAudioInfo.musicFilePath;
            } else {
                aVar.dBl = dBTemplateAudioInfo.getAudioUrl();
            }
            aVar.dBj = dBTemplateAudioInfo.getCategoryId();
            aVar.dBk = dBTemplateAudioInfo.getIndex();
            eVar.mo31865b(aVar);
            eVar.setEventType(i2);
            C10021c.aZH().mo38492aA(eVar);
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin MusicPlayerEvent From MusicItem = ");
            sb.append(new Gson().toJson((Object) eVar));
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    /* renamed from: b */
    public static List<BaseItem> m21452b(LocalSubFragment localSubFragment, List<DBTemplateAudioInfo> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (C3742b.m9111II().mo23146JN() && list != null && list.size() >= 20) {
            z = true;
        }
        arrayList.add(new C7297b(localSubFragment, z));
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        for (DBTemplateAudioInfo dBTemplateAudioInfo : list) {
            dBTemplateAudioInfo.timeStr = C4584e.m11685ij(dBTemplateAudioInfo.duration / 1000);
            arrayList.add(new C7302d(localSubFragment, dBTemplateAudioInfo));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m21453b(String str, String str2, int i) {
        C7262a aVar = new C7262a();
        aVar.dBj = str;
        aVar.dBk = str2;
        C10021c.aZH().mo38492aA(new C7263b(aVar, i));
    }

    /* renamed from: jj */
    public static boolean m21454jj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* renamed from: qU */
    public static void m21455qU(int i) {
        C10021c.aZH().mo38492aA(new C7268g(i));
    }
}
