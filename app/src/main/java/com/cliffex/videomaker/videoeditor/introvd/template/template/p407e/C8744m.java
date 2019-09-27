package com.introvd.template.template.p407e;

import com.introvd.template.p203b.C4580b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xiaoying.engine.base.QStyle;

/* renamed from: com.introvd.template.template.e.m */
public class C8744m {
    public static final Map<String, String> etr = new HashMap();
    public static List<Long> ets = new ArrayList();
    public static ArrayList<Long> ett = new ArrayList<>();
    public static List<Long> etu = new ArrayList();

    static {
        ett.add(Long.valueOf(648518346341875717L));
        ett.add(Long.valueOf(648518346341875718L));
        ett.add(Long.valueOf(648518346341875719L));
        ett.add(Long.valueOf(648518346341875722L));
        ett.add(Long.valueOf(648518346341875713L));
        ett.add(Long.valueOf(648518346341875714L));
        ett.add(Long.valueOf(648518346341875715L));
        ett.add(Long.valueOf(648518346341875716L));
        ett.add(Long.valueOf(648518346341875720L));
        ett.add(Long.valueOf(648518346341875721L));
        ets.add(Long.valueOf(QStyle.DEFAULT_BUBBLE_TEMPLATE_ID));
        ets.add(Long.valueOf(648518346341351599L));
        ets.add(Long.valueOf(648518346341351600L));
        ets.add(Long.valueOf(648518346341351601L));
        ets.add(Long.valueOf(648518346341351602L));
        ets.add(Long.valueOf(648518346341351603L));
        ets.add(Long.valueOf(648518346341351604L));
        ets.add(Long.valueOf(648518346341351605L));
        ets.add(Long.valueOf(648518346341351606L));
        ets.add(Long.valueOf(648518346341351607L));
        ets.add(Long.valueOf(648518346341351608L));
        ets.add(Long.valueOf(648518346341351609L));
        ets.add(Long.valueOf(648518346341351610L));
        etr.put("20160224184948_en", "Colourful");
        etr.put("20160224184948_zh", "缤纷");
        etu.add(Long.valueOf(360287970189640027L));
        etu.add(Long.valueOf(360287970189640028L));
        etu.add(Long.valueOf(360287970189640029L));
        etu.add(Long.valueOf(360287970189640030L));
        etu.add(Long.valueOf(360287970189640031L));
        etu.add(Long.valueOf(360287970189640032L));
        etu.add(Long.valueOf(360287970189640033L));
        etu.add(Long.valueOf(360287970189640034L));
        etr.put("20160224184733_en", "Vacation");
        etr.put("20160224184733_zh", "完美假日");
    }

    /* renamed from: qu */
    public static String m25555qu(String str) {
        String str2;
        if (C4580b.m11633Sg()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_zh");
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_en");
            str2 = sb2.toString();
        }
        return etr.containsKey(str2) ? (String) etr.get(str2) : "";
    }
}
