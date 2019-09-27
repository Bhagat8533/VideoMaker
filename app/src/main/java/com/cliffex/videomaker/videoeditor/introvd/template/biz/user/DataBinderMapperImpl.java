package com.introvd.template.biz.user;

import android.databinding.C0169d;
import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.introvd.template.biz.user.p152a.C3208b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends C0169d {
    private static final SparseIntArray aug = new SparseIntArray(1);

    /* renamed from: com.introvd.template.biz.user.DataBinderMapperImpl$a */
    private static class C3200a {
        static final SparseArray<String> auh = new SparseArray<>(4);

        static {
            auh.put(0, "_all");
            auh.put(1, "handler");
            auh.put(2, "title");
        }
    }

    /* renamed from: com.introvd.template.biz.user.DataBinderMapperImpl$b */
    private static class C3201b {
        static final HashMap<String, Integer> aui = new HashMap<>(1);

        static {
            aui.put("layout/iap_vip_dialog_recycle_item_function_0", Integer.valueOf(R.layout.iap_vip_dialog_recycle_item_function));
        }
    }

    static {
        aug.put(R.layout.iap_vip_dialog_recycle_item_function, 1);
    }

    public List<C0169d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new com.diii.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new xiaoying.quvideo.com.vivabase.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return (String) C3200a.auh.get(i);
    }

    public ViewDataBinding getDataBinder(C0170e eVar, View view, int i) {
        int i2 = aug.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            } else if (i2 == 1) {
                if ("layout/iap_vip_dialog_recycle_item_function_0".equals(tag)) {
                    return new C3208b(eVar, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for iap_vip_dialog_recycle_item_function is invalid. Received: ");
                sb.append(tag);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return null;
    }

    public ViewDataBinding getDataBinder(C0170e eVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || aug.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        Integer num = (Integer) C3201b.aui.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }
}
