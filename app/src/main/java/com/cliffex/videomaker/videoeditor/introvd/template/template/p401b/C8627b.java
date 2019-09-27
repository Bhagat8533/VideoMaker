package com.introvd.template.template.p401b;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.View;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.b.b */
public class C8627b {
    private List<Integer> ekj = new ArrayList();
    private List<C8626a> ekk = new ArrayList();
    private List<Integer> ekl = new ArrayList();

    /* renamed from: g */
    private boolean m25161g(View view, View view2) {
        boolean z = false;
        if (view == null || view2 == null) {
            return false;
        }
        int top = view.getTop();
        int bottom = view.getBottom();
        if (top >= 0 && bottom <= view2.getHeight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public List<C8626a> mo34930a(Context context, List<TemplateInfo> list, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        boolean z;
        if (list == null || context == null || recyclerView == null || linearLayoutManager == null) {
            return null;
        }
        this.ekj.clear();
        this.ekk.clear();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int i = 0; i <= findLastVisibleItemPosition - findFirstVisibleItemPosition; i++) {
            int i2 = i + findFirstVisibleItemPosition;
            if (m25161g(recyclerView.getChildAt(i), recyclerView)) {
                this.ekj.add(Integer.valueOf(i2));
                z = true;
            } else {
                z = false;
            }
            if (!this.ekl.contains(Integer.valueOf(i2)) && z && list.size() > i2 && i2 >= 0) {
                TemplateInfo templateInfo = (TemplateInfo) list.get(i2);
                if (templateInfo != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Material_filter_");
                    sb.append(templateInfo.strTitle);
                    String sb2 = sb.toString();
                    if (System.currentTimeMillis() - C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr(sb2, "0")) >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                        AppPreferencesSetting.getInstance().setAppSettingStr(sb2, String.valueOf(System.currentTimeMillis()));
                        this.ekk.add(new C8626a(i2, templateInfo.strTitle, templateInfo.ttid));
                    }
                }
            }
        }
        this.ekl.clear();
        this.ekl.addAll(this.ekj);
        return this.ekk;
    }
}
