package com.introvd.template.app.school.testa;

import android.app.Activity;
import android.view.View;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.school.C4206n;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.p196b.C4165e;
import com.introvd.template.p310g.C7378q;
import com.introvd.template.router.AppRouter;
import com.introvd.template.xyui.p420a.C9156d;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.introvd.template.app.school.testa.c */
class C4247c extends C9156d {
    private C7378q bzV;
    private long labelId;

    C4247c(C7378q qVar) {
        super(qVar.getRoot());
        this.bzV = qVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10649a(BottomRecyclerDataModel bottomRecyclerDataModel, View view) {
        if (view.getContext() instanceof Activity) {
            C4205m.m10501dP(bottomRecyclerDataModel.labelName);
            AppRouter.startTemplateList(view.getContext(), bottomRecyclerDataModel.labelIndexInList);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Ns */
    public void mo24244Ns() {
        C10021c.aZH().mo38496az(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo24245a(BottomRecyclerDataModel bottomRecyclerDataModel) {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        this.bzV.setTitle(bottomRecyclerDataModel.title);
        this.bzV.mo32009a(new C4246b(bottomRecyclerDataModel.title));
        this.labelId = bottomRecyclerDataModel.labelID;
        List<TemplateInfo> A = C4206n.m10505NL().mo24168A(this.labelId);
        if (A == null || A.isEmpty()) {
            this.bzV.mo32010aF(new ArrayList());
            C4206n.m10505NL().mo24170b(this.labelId, 1);
        } else {
            this.bzV.mo32010aF(A);
            for (TemplateInfo ttid : A) {
                C4205m.m10499Q(ttid.getTtid(), "创作页");
            }
        }
        this.bzV.cpx.setOnClickListener(new C4248d(bottomRecyclerDataModel));
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4165e eVar) {
        if (eVar != null && eVar.pageNum <= 1 && this.labelId == eVar.labelId) {
            this.bzV.mo32010aF(eVar.byI);
            for (TemplateInfo ttid : eVar.byI) {
                C4205m.m10499Q(ttid.getTtid(), "创作页");
            }
        }
    }
}
