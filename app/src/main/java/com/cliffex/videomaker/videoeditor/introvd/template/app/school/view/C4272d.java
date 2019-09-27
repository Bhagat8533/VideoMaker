package com.introvd.template.app.school.view;

import android.app.Activity;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.C4203l;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.template.detail.TemplateDetailAct;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p310g.C7380s;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.school.view.d */
public class C4272d extends C4417b<TemplateInfo> {

    /* renamed from: com.introvd.template.app.school.view.d$a */
    private class C4273a extends C4419b {
        /* access modifiers changed from: private */
        public C7380s bAr;

        C4273a(C7380s sVar) {
            super(sVar.getRoot());
            this.bAr = sVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m10722b(TemplateInfo templateInfo, View view) {
        if (!C4580b.m11632Sf() && (view.getContext() instanceof Activity)) {
            C4203l.m10495a(templateInfo, (Activity) view.getContext(), 49, "推荐");
            HashMap hashMap = new HashMap();
            hashMap.put("ttid", templateInfo.getTtid());
            hashMap.put("tab", "推荐");
            hashMap.put("position", "创作页");
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Click_Module_Use", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m10724d(int i, View view) {
        if (!C4580b.m11632Sf() && (view.getContext() instanceof Activity)) {
            TemplateDetailAct.m10565a((Activity) view.getContext(), getDataList(), i, "推荐", 0);
        }
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        C7380s a = ((C4273a) uVar).bAr;
        TemplateInfo templateInfo = (TemplateInfo) getListItem(i, false);
        if (templateInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ttid", templateInfo.getTtid());
            UserBehaviorLog.onKVEvent(uVar.itemView.getContext(), "Pageveiw_Module_Cover", hashMap);
            C4205m.m10499Q(templateInfo.getTtid(), "创作页");
            a.mo32013e(templateInfo);
            a.cqq.setOnClickListener(new C4274e(templateInfo));
            a.cpr.setOnClickListener(new C4275f(this, i));
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C4273a(C7380s.m21753a(LayoutInflater.from(viewGroup.getContext())));
    }
}
