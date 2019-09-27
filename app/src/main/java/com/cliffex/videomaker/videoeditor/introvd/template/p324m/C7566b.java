package com.introvd.template.p324m;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.p203b.C4580b;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.introvd.template.m.b */
public class C7566b {
    private static volatile Map<String, String> dLl;

    /* renamed from: bX */
    public static String m22321bX(Context context, String str) {
        String str2;
        String str3 = "";
        try {
            Map gg = m22322gg(context);
            if (!TextUtils.isEmpty(str) && gg != null) {
                if (!gg.isEmpty()) {
                    HashSet hashSet = new HashSet(gg.keySet());
                    Uri parse = Uri.parse(str);
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    ArrayList arrayList = new ArrayList();
                    if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                        for (String str4 : queryParameterNames) {
                            String queryParameter = parse.getQueryParameter(str4);
                            Iterator it = hashSet.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String str5 = (String) it.next();
                                if (str4.equals(str5)) {
                                    queryParameter = (String) gg.get(str5);
                                    break;
                                }
                            }
                            arrayList.add(new BasicNameValuePair(str4, queryParameter));
                        }
                    }
                    URI uri = new URI(parse.getScheme(), parse.getUserInfo(), parse.getHost(), parse.getPort(), parse.getPath(), arrayList.isEmpty() ? null : URLEncodedUtils.format(arrayList, "UTF-8"), parse.getFragment());
                    str2 = uri.toString();
                    return str2;
                }
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
    }

    /* renamed from: gg */
    private static Map<String, String> m22322gg(Context context) {
        if (dLl == null) {
            dLl = new HashMap();
            dLl.put("xy_dmodel", DeviceInfo.getModule());
            dLl.put("xy_dbrand", DeviceInfo.getModule());
            dLl.put("xy_from", "XiaoYing");
        }
        dLl.put("xy_lang", C4580b.m11635Si());
        return dLl;
    }
}
