package com.introvd.template.sdk.utils.p393a;

import android.text.TextUtils;
import com.introvd.template.sdk.utils.p393a.C8498g.C8499a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.sdk.utils.a.e */
public class C8496e {
    private static final Map<String, String> ehw = new HashMap();
    private static final ArrayList<String> ehx = new ArrayList<>();

    static {
        ehx.add("省");
        ehx.add("市");
        ehx.add("县");
        ehx.add("乡");
        ehx.add("村");
    }

    /* renamed from: oz */
    public static String m24586oz(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (ehw.containsKey(str)) {
                return (String) ehw.get(str);
            }
            int length = str.length();
            ArrayList oA = C8498g.aJr().mo34664oA(str);
            if (oA != null) {
                int size = oA.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        C8499a aVar = (C8499a) oA.get(i);
                        if (aVar != null && aVar.type == 2 && (!ehx.contains(aVar.ehD) || length <= 2)) {
                            sb.append(aVar.ehE);
                        }
                    }
                    ehw.put(str, sb.toString());
                }
            }
        }
        return sb.toString();
    }
}
