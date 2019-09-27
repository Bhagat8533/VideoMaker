package com.introvd.template.template.p407e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.introvd.template.C4561b;
import com.introvd.template.common.FileUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.editor.TemplateItemData.Builder;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p391g.C8450a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.e.h */
public class C8738h {
    /* renamed from: a */
    private TemplateItemData m25507a(Cursor cursor, Long l, String str) {
        Cursor cursor2 = cursor;
        int i = cursor2.getInt(2);
        int i2 = cursor2.getInt(3);
        int i3 = cursor2.getInt(4);
        long j = (long) cursor2.getInt(5);
        int i4 = cursor2.getInt(6);
        int i5 = cursor2.getInt(7);
        int i6 = cursor2.getInt(8);
        String string = cursor2.getString(9);
        String string2 = cursor2.getString(10);
        int i7 = cursor2.getInt(11);
        int i8 = cursor2.getInt(12);
        int i9 = cursor2.getInt(15);
        String string3 = cursor2.getString(16);
        Builder builder = r3;
        int i10 = i8;
        int i11 = i9;
        Builder builder2 = new Builder(str, l.longValue(), i3, i2, j);
        return builder.nOrder(i).nOriOrder(i).nFavorite(i4).nSubOrder(i5).nLayoutFlag(i6).strExtInfo(string).strTitleJSON(string2).nConfigureCount(i7).nNeedDownloadFlag(i10).strSceneCode(string3).nDelFlag(i11).build();
    }

    /* renamed from: ab */
    private int m25508ab(Context context, String str, String str2) {
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE), new String[]{"url"}, null, null, "orderno DESC, updatetime");
        int i = 0;
        if (query == null) {
            return 0;
        }
        if (query.getCount() == 0) {
            query.close();
            return 0;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        query.close();
        for (String eA : arrayList) {
            String eA2 = C4580b.m11655eA(eA);
            if (FileUtils.isFileExisted(eA2) && TextUtils.indexOf(eA2, str) > 0 && TextUtils.indexOf(eA2, str2) > 0) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: ac */
    private List<TemplateItemData> m25509ac(Context context, String str, String str2) {
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE), new String[]{SocialConstDef.TEMPLATE_ID, "url", "orderno", "from_type", "ver", "updatetime", SocialConstDef.TEMPLATE_FAVORITE, SocialConstDef.TEMPLATE_SUB_ORDERNO, "layout", SocialConstDef.TEMPLATE_EXT_INFO, "title", SocialConstDef.TEMPLATE_CONFIGURE_COUNT, "downFlag", "mission", "mresult", SocialConstDef.TEMPLATE_DELETE_FLAG, "scene_code"}, null, null, "orderno DESC, updatetime");
        if (query == null) {
            return null;
        }
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            Long valueOf = Long.valueOf(query.getLong(0));
            String eA = C4580b.m11655eA(query.getString(1));
            if (!FileUtils.isFileExisted(eA)) {
                String str3 = str;
            } else if (TextUtils.indexOf(eA, str) > 0) {
                if (TextUtils.indexOf(eA, str2) > 0) {
                    arrayList.add(m25507a(query, valueOf, eA));
                }
            }
            String str4 = str2;
        }
        query.close();
        return arrayList;
    }

    /* renamed from: da */
    private List<TemplateInfo> m25510da(List<TemplateItemData> list) {
        ArrayList arrayList = new ArrayList();
        for (TemplateItemData templateItemData : list) {
            TemplateInfo templateInfo = new TemplateInfo();
            templateInfo.ttid = C8450a.m24469bn(templateItemData.lID);
            templateInfo.nState = 6;
            arrayList.add(templateInfo);
        }
        return arrayList;
    }

    /* renamed from: he */
    public int mo35164he(Context context) {
        if (!C4561b.m11530bm(context)) {
            return 0;
        }
        return m25508ab(context, "filter_test/", "0x04");
    }

    /* renamed from: hf */
    public int mo35165hf(Context context) {
        if (!C4561b.m11530bm(context)) {
            return 0;
        }
        return m25508ab(context, "facial_test/", "0x11");
    }

    /* renamed from: hg */
    public int mo35166hg(Context context) {
        if (!C4561b.m11530bm(context)) {
            return 0;
        }
        return m25508ab(context, "title_test/", "0x09");
    }

    /* renamed from: hh */
    public int mo35167hh(Context context) {
        if (!C4561b.m11530bm(context)) {
            return 0;
        }
        return m25508ab(context, "sticker_test/", "0x05");
    }

    /* renamed from: hi */
    public int mo35168hi(Context context) {
        if (!C4561b.m11530bm(context)) {
            return 0;
        }
        return m25508ab(context, "fx_test/", "0x06");
    }

    /* renamed from: hj */
    public List<TemplateInfo> mo35169hj(Context context) {
        return m25510da(m25509ac(context, "facial_test/", "0x11"));
    }

    /* renamed from: hk */
    public List<TemplateItemData> mo35170hk(Context context) {
        return m25509ac(context, "filter_test/", "0x04");
    }

    /* renamed from: hl */
    public List<Long> mo35171hl(Context context) {
        List<TemplateItemData> ac = m25509ac(context, "title_test/", "0x09");
        ArrayList arrayList = new ArrayList();
        if (ac != null) {
            for (TemplateItemData templateItemData : ac) {
                arrayList.add(Long.valueOf(templateItemData.lID));
            }
        }
        return arrayList;
    }

    /* renamed from: hm */
    public List<Long> mo35172hm(Context context) {
        List<TemplateItemData> ac = m25509ac(context, "sticker_test/", "0x05");
        ArrayList arrayList = new ArrayList();
        if (ac != null) {
            for (TemplateItemData templateItemData : ac) {
                arrayList.add(Long.valueOf(templateItemData.lID));
            }
        }
        return arrayList;
    }

    /* renamed from: hn */
    public List<TemplateInfo> mo35173hn(Context context) {
        return m25510da(m25509ac(context, "fx_test/", "0x06"));
    }
}
