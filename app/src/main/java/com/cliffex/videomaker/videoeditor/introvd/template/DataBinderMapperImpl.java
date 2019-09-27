package com.introvd.template;

import android.databinding.C0169d;
import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.introvd.template.p310g.C7355ab;
import com.introvd.template.p310g.C7357ad;
import com.introvd.template.p310g.C7359af;
import com.introvd.template.p310g.C7360b;
import com.introvd.template.p310g.C7362d;
import com.introvd.template.p310g.C7364f;
import com.introvd.template.p310g.C7369h;
import com.introvd.template.p310g.C7371j;
import com.introvd.template.p310g.C7373l;
import com.introvd.template.p310g.C7375n;
import com.introvd.template.p310g.C7377p;
import com.introvd.template.p310g.C7379r;
import com.introvd.template.p310g.C7381t;
import com.introvd.template.p310g.C7383v;
import com.introvd.template.p310g.C7385x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends C0169d {
    private static final SparseIntArray aug = new SparseIntArray(15);

    /* renamed from: com.introvd.template.DataBinderMapperImpl$a */
    private static class C3546a {
        static final SparseArray<String> auh = new SparseArray<>(13);

        static {
            auh.put(0, "_all");
            auh.put(1, "handler");
            auh.put(2, "title");
            auh.put(3, "isChina");
            auh.put(4, "auid");
            auh.put(5, "clickHandler");
            auh.put(6, "showNextArrow");
            auh.put(7, "infoList");
            auh.put(8, "tabLayoutModel");
            auh.put(9, "isHor");
            auh.put(10, "showHint");
            auh.put(11, "info");
        }
    }

    /* renamed from: com.introvd.template.DataBinderMapperImpl$b */
    private static class C3547b {
        static final HashMap<String, Integer> aui = new HashMap<>(15);

        static {
            aui.put("layout/activity_extra_help_0", Integer.valueOf(R.layout.activity_extra_help));
            aui.put("layout/app_act_school_template_detail_0", Integer.valueOf(R.layout.app_act_school_template_detail));
            aui.put("layout/app_activity_freeze_reason_page_0", Integer.valueOf(R.layout.app_activity_freeze_reason_page));
            aui.put("layout/app_include_creation_editor_0", Integer.valueOf(R.layout.app_include_creation_editor));
            aui.put("layout/app_include_creation_editor_main_item_0", Integer.valueOf(R.layout.app_include_creation_editor_main_item));
            aui.put("layout/app_view_school_course_detail_item_0", Integer.valueOf(R.layout.app_view_school_course_detail_item));
            aui.put("layout/app_view_school_course_list_item_0", Integer.valueOf(R.layout.app_view_school_course_list_item));
            aui.put("layout/app_view_school_template_detail_item_0", Integer.valueOf(R.layout.app_view_school_template_detail_item));
            aui.put("layout/app_view_school_template_grid_item_0", Integer.valueOf(R.layout.app_view_school_template_grid_item));
            aui.put("layout/app_view_school_template_list_item_0", Integer.valueOf(R.layout.app_view_school_template_list_item));
            aui.put("layout/app_view_school_video_label_list_item_0", Integer.valueOf(R.layout.app_view_school_video_label_list_item));
            aui.put("layout/app_view_school_video_list_item_0", Integer.valueOf(R.layout.app_view_school_video_list_item));
            aui.put("layout/home_tab_layout_0", Integer.valueOf(R.layout.home_tab_layout));
            aui.put("layout/home_tab_layout_v2_0", Integer.valueOf(R.layout.home_tab_layout_v2));
            aui.put("layout/iap_vip_dialog_recycle_item_function_0", Integer.valueOf(R.layout.iap_vip_dialog_recycle_item_function));
        }
    }

    static {
        aug.put(R.layout.activity_extra_help, 1);
        aug.put(R.layout.app_act_school_template_detail, 2);
        aug.put(R.layout.app_activity_freeze_reason_page, 3);
        aug.put(R.layout.app_include_creation_editor, 4);
        aug.put(R.layout.app_include_creation_editor_main_item, 5);
        aug.put(R.layout.app_view_school_course_detail_item, 6);
        aug.put(R.layout.app_view_school_course_list_item, 7);
        aug.put(R.layout.app_view_school_template_detail_item, 8);
        aug.put(R.layout.app_view_school_template_grid_item, 9);
        aug.put(R.layout.app_view_school_template_list_item, 10);
        aug.put(R.layout.app_view_school_video_label_list_item, 11);
        aug.put(R.layout.app_view_school_video_list_item, 12);
        aug.put(R.layout.home_tab_layout, 13);
        aug.put(R.layout.home_tab_layout_v2, 14);
        aug.put(R.layout.iap_vip_dialog_recycle_item_function, 15);
    }

    public List<C0169d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new com.diii.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new xiaoying.quvideo.com.vivabase.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return (String) C3546a.auh.get(i);
    }

    public ViewDataBinding getDataBinder(C0170e eVar, View view, int i) {
        int i2 = aug.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                switch (i2) {
                    case 1:
                        if ("layout/activity_extra_help_0".equals(tag)) {
                            return new C7360b(eVar, view);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("The tag for activity_extra_help is invalid. Received: ");
                        sb.append(tag);
                        throw new IllegalArgumentException(sb.toString());
                    case 2:
                        if ("layout/app_act_school_template_detail_0".equals(tag)) {
                            return new C7362d(eVar, view);
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("The tag for app_act_school_template_detail is invalid. Received: ");
                        sb2.append(tag);
                        throw new IllegalArgumentException(sb2.toString());
                    case 3:
                        if ("layout/app_activity_freeze_reason_page_0".equals(tag)) {
                            return new C7364f(eVar, view);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("The tag for app_activity_freeze_reason_page is invalid. Received: ");
                        sb3.append(tag);
                        throw new IllegalArgumentException(sb3.toString());
                    case 4:
                        if ("layout/app_include_creation_editor_0".equals(tag)) {
                            return new C7369h(eVar, view);
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("The tag for app_include_creation_editor is invalid. Received: ");
                        sb4.append(tag);
                        throw new IllegalArgumentException(sb4.toString());
                    case 5:
                        if ("layout/app_include_creation_editor_main_item_0".equals(tag)) {
                            return new C7371j(eVar, view);
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("The tag for app_include_creation_editor_main_item is invalid. Received: ");
                        sb5.append(tag);
                        throw new IllegalArgumentException(sb5.toString());
                    case 6:
                        if ("layout/app_view_school_course_detail_item_0".equals(tag)) {
                            return new C7373l(eVar, view);
                        }
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("The tag for app_view_school_course_detail_item is invalid. Received: ");
                        sb6.append(tag);
                        throw new IllegalArgumentException(sb6.toString());
                    case 7:
                        if ("layout/app_view_school_course_list_item_0".equals(tag)) {
                            return new C7375n(eVar, view);
                        }
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("The tag for app_view_school_course_list_item is invalid. Received: ");
                        sb7.append(tag);
                        throw new IllegalArgumentException(sb7.toString());
                    case 8:
                        if ("layout/app_view_school_template_detail_item_0".equals(tag)) {
                            return new C7377p(eVar, view);
                        }
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("The tag for app_view_school_template_detail_item is invalid. Received: ");
                        sb8.append(tag);
                        throw new IllegalArgumentException(sb8.toString());
                    case 9:
                        if ("layout/app_view_school_template_grid_item_0".equals(tag)) {
                            return new C7379r(eVar, view);
                        }
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("The tag for app_view_school_template_grid_item is invalid. Received: ");
                        sb9.append(tag);
                        throw new IllegalArgumentException(sb9.toString());
                    case 10:
                        if ("layout/app_view_school_template_list_item_0".equals(tag)) {
                            return new C7381t(eVar, view);
                        }
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("The tag for app_view_school_template_list_item is invalid. Received: ");
                        sb10.append(tag);
                        throw new IllegalArgumentException(sb10.toString());
                    case 11:
                        if ("layout/app_view_school_video_label_list_item_0".equals(tag)) {
                            return new C7383v(eVar, view);
                        }
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("The tag for app_view_school_video_label_list_item is invalid. Received: ");
                        sb11.append(tag);
                        throw new IllegalArgumentException(sb11.toString());
                    case 12:
                        if ("layout/app_view_school_video_list_item_0".equals(tag)) {
                            return new C7385x(eVar, view);
                        }
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("The tag for app_view_school_video_list_item is invalid. Received: ");
                        sb12.append(tag);
                        throw new IllegalArgumentException(sb12.toString());
                    case 13:
                        if ("layout/home_tab_layout_0".equals(tag)) {
                            return new C7355ab(eVar, view);
                        }
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("The tag for home_tab_layout is invalid. Received: ");
                        sb13.append(tag);
                        throw new IllegalArgumentException(sb13.toString());
                    case 14:
                        if ("layout/home_tab_layout_v2_0".equals(tag)) {
                            return new C7357ad(eVar, view);
                        }
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append("The tag for home_tab_layout_v2 is invalid. Received: ");
                        sb14.append(tag);
                        throw new IllegalArgumentException(sb14.toString());
                    case 15:
                        if ("layout/iap_vip_dialog_recycle_item_function_0".equals(tag)) {
                            return new C7359af(eVar, view);
                        }
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append("The tag for iap_vip_dialog_recycle_item_function is invalid. Received: ");
                        sb15.append(tag);
                        throw new IllegalArgumentException(sb15.toString());
                }
            } else {
                throw new RuntimeException("view must have a tag");
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
        Integer num = (Integer) C3547b.aui.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }
}
