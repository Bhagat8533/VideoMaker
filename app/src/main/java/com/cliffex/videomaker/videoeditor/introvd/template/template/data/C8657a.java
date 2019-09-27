package com.introvd.template.template.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.common.FileUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll.ImageInfo;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.template.data.a */
public class C8657a {
    /* renamed from: c */
    public static ImageInfo m25212c(Context context, Uri uri, String str) {
        String str2;
        Uri uri2 = uri;
        Cursor query = context.getContentResolver().query(uri2, new String[]{"code", SocialConstDef.TEMPLATE_ROLL_XYTINFO}, "code=?", new String[]{str}, null);
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                str2 = query.getString(query.getColumnIndex(SocialConstDef.TEMPLATE_ROLL_XYTINFO));
            } else {
                str2 = null;
            }
            query.close();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return (ImageInfo) new Gson().fromJson(str2, ImageInfo.class);
    }

    /* renamed from: ct */
    public static boolean m25213ct(Context context, String str) {
        TemplateInfo cu = m25214cu(context, str);
        boolean z = false;
        if (cu == null) {
            return false;
        }
        FileUtils.deleteFile(cu.strUrl);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(C2575a.m7391rq(str));
        if (context.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO), "ttid=?", new String[]{sb.toString()}) > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: cu */
    public static TemplateInfo m25214cu(Context context, String str) {
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO);
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {"ttid", "iconurl", SocialConstDef.TEMPLATEFONTINFO_ITEM_LOCALPATH};
        Long valueOf = Long.valueOf(0);
        try {
            valueOf = Long.decode(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(valueOf);
        Cursor query = contentResolver.query(tableUri, strArr, "ttid=?", new String[]{sb.toString()}, null);
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                TemplateInfo n = m25216n(query);
                query.close();
                return n;
            }
            query.close();
        }
        return null;
    }

    /* renamed from: cv */
    public static ImageInfo m25215cv(Context context, String str) {
        ImageInfo c = m25212c(context, SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL), str);
        return c == null ? m25212c(context, SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_RECOMMEND_ROLL), str) : c;
    }

    /* renamed from: n */
    public static TemplateInfo m25216n(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        sb.append(Long.toHexString(cursor.getLong(cursor.getColumnIndex("ttid"))));
        String sb2 = sb.toString();
        String string = cursor.getString(cursor.getColumnIndex("iconurl"));
        String string2 = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATEFONTINFO_ITEM_LOCALPATH));
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.ttid = sb2;
        templateInfo.strIcon = string;
        templateInfo.strUrl = string2;
        return templateInfo;
    }
}
