package com.introvd.template.app.setting.locale;

import android.content.Context;
import com.introvd.template.router.setting.LocaleModel;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.app.setting.locale.b */
public class C4336b {
    /* renamed from: c */
    public static List<LocaleModel> m10869c(Context context, int i, int i2) {
        if (context == null) {
            return null;
        }
        String[] stringArray = context.getResources().getStringArray(i);
        String[] stringArray2 = context.getResources().getStringArray(i2);
        if (stringArray.length == stringArray2.length) {
            ArrayList arrayList = new ArrayList();
            int length = stringArray.length;
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(new LocaleModel(stringArray[i3], stringArray2[i3]));
            }
            return arrayList;
        }
        throw new IllegalStateException("arrays.xml中配置的名字和值 无法一一对应，请检查xml文件");
    }
}
