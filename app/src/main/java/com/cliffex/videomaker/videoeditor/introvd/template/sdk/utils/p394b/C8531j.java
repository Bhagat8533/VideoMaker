package com.introvd.template.sdk.utils.p394b;

import android.text.TextUtils;
import com.introvd.template.sdk.model.editor.SymbolStringInfo;
import java.util.ArrayList;

/* renamed from: com.introvd.template.sdk.utils.b.j */
public class C8531j {
    /* renamed from: J */
    public static SymbolStringInfo m24765J(String str, int i) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("%", i);
        if (-1 == indexOf) {
            return null;
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf("%", i2);
        if (-1 == indexOf2 || indexOf2 <= indexOf) {
            return null;
        }
        SymbolStringInfo symbolStringInfo = new SymbolStringInfo();
        symbolStringInfo.setmStartPSPosInOriString(indexOf);
        symbolStringInfo.setmEndPSPosInOriString(indexOf2);
        symbolStringInfo.setmSymbolString(str.substring(i2, indexOf2));
        return symbolStringInfo;
    }

    /* renamed from: oJ */
    public static boolean m24766oJ(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("%", 0);
        int i = 0;
        while (-1 != indexOf) {
            i++;
            indexOf = str.indexOf("%", indexOf + 1);
        }
        if (i % 2 == 0 && i > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: oK */
    public static ArrayList<SymbolStringInfo> m24767oK(String str) {
        ArrayList<SymbolStringInfo> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            SymbolStringInfo J = m24765J(str, i);
            if (J == null) {
                break;
            }
            int i2 = J.getmEndPSPosInOriString() + 1;
            arrayList2.add(J);
            i = i2;
        }
        if (arrayList2.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                SymbolStringInfo symbolStringInfo = (SymbolStringInfo) arrayList2.get(i4);
                if (symbolStringInfo != null) {
                    if (symbolStringInfo.getmStartPSPosInOriString() > i3) {
                        String substring = str.substring(i3, symbolStringInfo.getmStartPSPosInOriString());
                        SymbolStringInfo symbolStringInfo2 = new SymbolStringInfo();
                        symbolStringInfo2.setmStartPSPosInOriString(i3);
                        symbolStringInfo2.setmEndPSPosInOriString(symbolStringInfo.getmStartPSPosInOriString());
                        symbolStringInfo2.setmSymbolString(substring);
                        symbolStringInfo2.setSymbolStr(false);
                        arrayList.add(symbolStringInfo2);
                    }
                    arrayList.add(symbolStringInfo);
                    if (i4 != arrayList2.size() - 1) {
                        i3 = symbolStringInfo.getmEndPSPosInOriString() + 1;
                    } else if (symbolStringInfo.getmEndPSPosInOriString() + 1 < length) {
                        String substring2 = str.substring(symbolStringInfo.getmEndPSPosInOriString() + 1, length);
                        SymbolStringInfo symbolStringInfo3 = new SymbolStringInfo();
                        symbolStringInfo3.setmStartPSPosInOriString(symbolStringInfo.getmEndPSPosInOriString());
                        symbolStringInfo3.setmEndPSPosInOriString(length);
                        symbolStringInfo3.setmSymbolString(substring2);
                        symbolStringInfo3.setSymbolStr(false);
                        arrayList.add(symbolStringInfo3);
                    }
                }
            }
        } else {
            SymbolStringInfo symbolStringInfo4 = new SymbolStringInfo();
            symbolStringInfo4.setmStartPSPosInOriString(0);
            symbolStringInfo4.setmEndPSPosInOriString(length);
            symbolStringInfo4.setmSymbolString(str);
            symbolStringInfo4.setSymbolStr(false);
            arrayList.add(symbolStringInfo4);
        }
        return arrayList;
    }
}
