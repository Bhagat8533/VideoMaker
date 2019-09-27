package com.introvd.template.explorer.p300e;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.MD5;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.videoeditor.model.MediaItem;

/* renamed from: com.introvd.template.explorer.e.f */
public class C7213f {
    /* renamed from: D */
    public static String m21300D(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = "";
        if (TextUtils.indexOf(str, CommonConfigure.APP_DATA_PATH_RELATIVE) >= 0) {
            C7191a aVar = new C7191a(context);
            String jr = aVar.mo31671jr(str);
            aVar.release();
            str3 = jr;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = m21303jw(str);
        }
        if (TextUtils.isEmpty(str3)) {
            MediaItem mediaItem = new MediaItem();
            mediaItem.path = str;
            C7208b.m21287c(context, mediaItem, 2);
            str3 = mediaItem.title;
        }
        return str3;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Collection, code=java.util.Collection<java.lang.Object>, for r5v0, types: [java.util.Collection] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Collection m21301a(java.util.Collection<java.lang.Object> r5, java.util.Collection r6) {
        /*
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            int r1 = r5.size()
            int r2 = r6.size()
            if (r1 >= r2) goto L_0x0012
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0012:
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r5.size()
            r1.<init>(r2)
            java.util.Iterator r5 = r5.iterator()
        L_0x001f:
            boolean r2 = r5.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r5.next()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.put(r2, r3)
            goto L_0x001f
        L_0x0032:
            java.util.Iterator r5 = r6.iterator()
        L_0x0036:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0053
            java.lang.Object r6 = r5.next()
            java.lang.Object r2 = r1.get(r6)
            if (r2 != 0) goto L_0x004a
            r0.add(r6)
            goto L_0x0036
        L_0x004a:
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r6, r2)
            goto L_0x0036
        L_0x0053:
            java.util.Set r5 = r1.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x005b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x007b
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r1 = r6.getValue()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r3) goto L_0x005b
            java.lang.Object r6 = r6.getKey()
            r0.add(r6)
            goto L_0x005b
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p300e.C7213f.m21301a(java.util.Collection, java.util.Collection):java.util.Collection");
    }

    /* renamed from: jv */
    public static String m21302jv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (substring.startsWith("\"")) {
            substring = substring.substring(1);
        }
        if (substring.endsWith("\"")) {
            substring = substring.substring(0, substring.length() - 1);
        }
        String[] split = substring.split("\\.");
        String md5 = MD5.md5(str);
        if (split.length <= 1) {
            return substring;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(md5);
        sb.append(".");
        sb.append(split[1]);
        return sb.toString();
    }

    /* renamed from: jw */
    public static String m21303jw(String str) {
        C8682a aKt = C8688b.aKs().aKt();
        String str2 = null;
        if (aKt == null) {
            return null;
        }
        DBTemplateAudioInfo pc = aKt.mo35010pc(str);
        if (pc != null) {
            str2 = pc.name;
        }
        return str2;
    }

    /* renamed from: jx */
    public static String m21304jx(String str) {
        C8682a aKt = C8688b.aKs().aKt();
        if (aKt == null) {
            return null;
        }
        DBTemplateAudioInfo pc = aKt.mo35010pc(str);
        return pc == null ? "0" : pc.index;
    }
}
