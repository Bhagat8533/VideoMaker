package com.introvd.template.app;

import android.databinding.C0169d;
import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.introvd.template.app.p178c.C3753b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import videoeditor.videomaker.slowmotions.starsleap.R;

public class DataBinderMapperImpl extends C0169d {
    private static final SparseIntArray aug = new SparseIntArray(1);

    /* renamed from: com.introvd.template.app.DataBinderMapperImpl$a */
    private static class C3663a {
        static final SparseArray<String> auh = new SparseArray<>(13);

        static {
            auh.put(0, "_all");
            auh.put(1, "isChina");
            auh.put(2, "handler");
            auh.put(3, "auid");
            auh.put(4, "clickHandler");
            auh.put(5, "showNextArrow");
            auh.put(6, "infoList");
            auh.put(7, "tabLayoutModel");
            auh.put(8, "isHor");
            auh.put(9, "showHint");
            auh.put(10, "title");
            auh.put(11, "info");
        }
    }

    /* renamed from: com.introvd.template.app.DataBinderMapperImpl$b */
    private static class C3664b {
        static final HashMap<String, Integer> aui = new HashMap<>(1);

        static {
            aui.put("layout/iap_vip_dialog_recycle_item_function_0", Integer.valueOf(R.layout.iap_vip_dialog_recycle_item_function));
        }
    }

    static {
        aug.put(R.layout.iap_vip_dialog_recycle_item_function, 1);
    }

    public List<C0169d> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new com.diii.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.introvd.template.DataBinderMapperImpl());
        arrayList.add(new com.introvd.template.biz.user.DataBinderMapperImpl());
        arrayList.add(new xiaoying.quvideo.com.vivabase.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return (String) C3663a.auh.get(i);
    }

    public ViewDataBinding getDataBinder(C0170e eVar, View view, int i) {
        int i2 = aug.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            } else if (i2 == 1) {
                if ("layout/iap_vip_dialog_recycle_item_function_0".equals(tag)) {
                    return new C3753b(eVar, view);
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
        Integer num = (Integer) C3664b.aui.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }
}
