package com.introvd.template.template.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateDownloadInfo;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.C8690c;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.p057e.C1518f;

/* renamed from: com.introvd.template.template.data.b */
public class C8670b {
    /* renamed from: a */
    public static C1848s<List<TemplateResponseInfo>> m25245a(final String str, int i, final int i2, int i3, final int i4, final String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i2);
        sb3.append("");
        String sb4 = sb3.toString();
        String str4 = "327683";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("");
        String sb6 = sb5.toString();
        if (i4 > 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(i4);
            sb7.append("");
            str3 = sb7.toString();
        } else {
            str3 = "";
        }
        return C8659b.m25227a(str, sb2, sb4, str4, sb6, str3, str2, "", "").mo10199i(new C1518f<List<TemplateResponseInfo>, List<TemplateResponseInfo>>() {
            public List<TemplateResponseInfo> apply(List<TemplateResponseInfo> list) {
                if (list.size() > 0) {
                    ContentResolver contentResolver = VivaBaseApplication.m8749FZ().getContentResolver();
                    if (i4 == 2) {
                        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND);
                        C8690c.m25290b(contentResolver, tableUri, str);
                        C8690c.m25292c(contentResolver, tableUri, list);
                    } else {
                        Uri tableUri2 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_INFO);
                        if (i2 <= 1) {
                            if (!TextUtils.equals("1", str)) {
                                C8690c.m25290b(contentResolver, tableUri2, str);
                            } else {
                                C8690c.m25286a(contentResolver, tableUri2, str, str2);
                            }
                        }
                        C8690c.m25292c(contentResolver, tableUri2, list);
                    }
                    C8690c.m25294h(VivaBaseApplication.m8749FZ(), list);
                    C8690c.m25295i(VivaBaseApplication.m8749FZ(), list);
                }
                return list;
            }
        });
    }

    /* renamed from: bc */
    public static C1848s<TemplateDownloadInfo> m25246bc(String str, String str2) {
        return C8659b.m25228bc(str, str2).mo10199i(new C1518f<TemplateDownloadInfo, TemplateDownloadInfo>() {
            /* renamed from: a */
            public TemplateDownloadInfo apply(TemplateDownloadInfo templateDownloadInfo) {
                try {
                    Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ttid", templateDownloadInfo.templateId);
                    contentValues.put("url", templateDownloadInfo.downloadUrl);
                    VivaBaseApplication.m8749FZ().getContentResolver().update(tableUri, contentValues, "ttid = ?", new String[]{contentValues.getAsString("ttid")});
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return templateDownloadInfo;
            }
        });
    }

    /* renamed from: d */
    public static C1848s<List<TemplateResponseRoll>> m25247d(final String str, int i, final int i2, final int i3) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i2);
        sb3.append("");
        String sb4 = sb3.toString();
        String str3 = "327683";
        if (i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("");
            str2 = sb5.toString();
        } else {
            str2 = "";
        }
        return C8659b.m25231e(str, sb2, sb4, str3, str2).mo10199i(new C1518f<List<TemplateResponseRoll>, List<TemplateResponseRoll>>() {
            public List<TemplateResponseRoll> apply(List<TemplateResponseRoll> list) {
                VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
                if (i3 == 2) {
                    C8690c.m25287a(FZ.getContentResolver(), SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_RECOMMEND_ROLL), list);
                    C8690c.m25293g(FZ, list);
                } else {
                    Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL);
                    if (i2 <= 1) {
                        C8690c.m25285a(FZ.getContentResolver(), tableUri, str);
                    }
                    C8690c.m25291b(FZ.getContentResolver(), tableUri, list);
                    C8690c.m25293g(FZ, list);
                }
                return list;
            }
        });
    }

    public static void init(Context context) {
        C8688b.aKs().mo35025cG(context);
    }
}
