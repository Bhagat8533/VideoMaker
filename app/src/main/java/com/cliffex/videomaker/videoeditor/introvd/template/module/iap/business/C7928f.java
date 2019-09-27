package com.introvd.template.module.iap.business;

import android.app.Activity;
import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.f */
public class C7928f extends C1008a<C7994i> {
    private static final int cLj = R.layout.iap_vip_recycle_item_renew_privilege_info;
    /* access modifiers changed from: private */
    public Context context;
    private List<C7830c> dQc;
    private int dQd = C7689a.aAz().widthPixels;
    private boolean isVip;

    C7928f(Context context2, List<C7830c> list) {
        this.context = context2;
        this.dQc = new ArrayList(list);
        this.isVip = isVip();
    }

    /* access modifiers changed from: private */
    public boolean isVip() {
        return C8072q.aBx().isVip();
    }

    /* renamed from: V */
    public C7994i onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.context).inflate(cLj, viewGroup, false);
        inflate.getLayoutParams().width = (this.dQd * 5) / 22;
        return new C7994i(inflate);
    }

    /* renamed from: a */
    public void onBindViewHolder(C7994i iVar, int i) {
        final C7830c cVar = (C7830c) this.dQc.get(i);
        ((DynamicLoadingImageView) iVar.mo32994n(R.id.iv_privilege_icon)).setImageURI(this.isVip ? cVar.iconUrl : cVar.bkL);
        ((TextView) iVar.mo32994n(R.id.tv_privilege_title)).setText(cVar.title);
        if (cVar.todoCode != 0) {
            iVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("isVIP", C7928f.this.isVip() ? "是" : "否");
                    hashMap.put("privilege", cVar.title);
                    C8048e.aBe().mo23653g("VIP_MembershipPage_Privilege_click", hashMap);
                    ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = cVar.todoCode;
                    tODOParamModel.mJsonParam = cVar.dSh;
                    if (C7928f.this.context instanceof Activity) {
                        iCommonFuncRouter.executeTodo((Activity) C7928f.this.context, tODOParamModel, null);
                    }
                }
            });
        } else {
            iVar.itemView.setOnClickListener(null);
        }
    }

    public void aBS() {
        this.isVip = isVip();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ch */
    public void mo32891ch(List<C7830c> list) {
        this.dQc.clear();
        this.dQc.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.dQc != null) {
            return this.dQc.size();
        }
        return 0;
    }
}
