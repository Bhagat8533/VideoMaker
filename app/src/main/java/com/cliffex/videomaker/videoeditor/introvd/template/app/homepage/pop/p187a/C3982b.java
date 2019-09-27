package com.introvd.template.app.homepage.pop.p187a;

import com.introvd.template.app.dispatch.dispatcher.MediaSourceDispatcher.C3865a;
import com.introvd.template.app.dispatch.dispatcher.MediaSourceDispatcher.IntroducePopF;
import com.introvd.template.app.homepage.pop.C3993f;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.iap.C8049f;
import com.quvideo.priority.p217a.C4891b;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import com.quvideo.priority.p217a.C4895e;
import com.quvideo.priority.p217a.C4901h;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.introvd.template.app.homepage.pop.a.b */
public class C3982b extends C4895e {
    private C4893a bsI;

    public C3982b(C4893a aVar) {
        this.bsI = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: EX */
    public C4901h mo23593EX() {
        return new C4891b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: EY */
    public Collection<C4892c> mo23594EY() {
        return Arrays.asList(new C4892c[]{C8049f.aBf().mo33080a(this.bsI), new C3993f(this.bsI), AppStateModel.getInstance().isInChina() ? new C3865a() : new IntroducePopF()});
    }

    /* renamed from: sb */
    public int mo23397sb() {
        return 98;
    }
}
