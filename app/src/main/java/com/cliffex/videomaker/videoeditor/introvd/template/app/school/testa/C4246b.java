package com.introvd.template.app.school.testa;

import android.app.Activity;
import android.view.View;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.template.detail.TemplateDetailAct;
import java.util.List;

/* renamed from: com.introvd.template.app.school.testa.b */
public class C4246b {
    private String bzb;

    C4246b(String str) {
        this.bzb = str;
    }

    /* renamed from: a */
    public void mo24239a(View view, List<TemplateInfo> list, int i) {
        if (list != null && i < list.size() && (view.getContext() instanceof Activity)) {
            TemplateDetailAct.m10565a((Activity) view.getContext(), list, i, this.bzb, 0);
        }
    }

    /* renamed from: d */
    public String mo24240d(List<TemplateInfo> list, int i) {
        return (list == null || i >= list.size()) ? "" : ((TemplateInfo) list.get(i)).getCoverUrl();
    }

    /* renamed from: e */
    public String mo24241e(List<TemplateInfo> list, int i) {
        return (list == null || i >= list.size()) ? "" : ((TemplateInfo) list.get(i)).getTitle();
    }

    /* renamed from: f */
    public boolean mo24242f(List<TemplateInfo> list, int i) {
        return list == null || i >= list.size();
    }

    /* renamed from: g */
    public String mo24243g(List<TemplateInfo> list, int i) {
        return (list == null || i >= list.size()) ? "" : ((TemplateInfo) list.get(i)).formatUseCount();
    }
}
