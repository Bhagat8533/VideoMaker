package com.introvd.template.app.p184h;

import android.app.Activity;
import android.os.Bundle;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p184h.p185a.C3888a;
import com.introvd.template.app.p184h.p185a.C3892d;
import com.introvd.template.app.p184h.p185a.C3893e;
import com.introvd.template.app.p184h.p185a.C3894f;
import com.introvd.template.app.p184h.p185a.C3897g;
import com.introvd.template.app.p184h.p185a.C3899h;
import com.introvd.template.app.p184h.p185a.C3900i;
import com.introvd.template.app.p184h.p185a.C3901j;
import com.introvd.template.app.p184h.p185a.C3902k;
import com.introvd.template.app.p184h.p185a.C3904l;
import com.introvd.template.app.p184h.p185a.C3906m;
import com.introvd.template.app.p184h.p185a.C3907n;
import com.introvd.template.app.p184h.p185a.C3913o;
import com.introvd.template.app.p184h.p185a.C3914p;
import com.introvd.template.app.p184h.p185a.C3915q;
import com.introvd.template.app.p184h.p185a.C3917r;
import com.vivavideo.mobile.h5api.api.C9339d;
import com.vivavideo.mobile.h5api.api.C9341f;
import com.vivavideo.mobile.h5api.api.C9353o;
import com.vivavideo.mobile.h5api.api.C9359r;
import com.vivavideo.mobile.h5api.p435d.C9371d;
import com.vivavideo.mobile.h5api.p438f.C9390a;
import com.vivavideo.mobile.h5api.service.HybridService;
import com.vivavideo.mobile.h5core.p441c.C9449l;

/* renamed from: com.introvd.template.app.h.a */
public class C3886a {
    /* renamed from: a */
    public static C9353o m9562a(String str, Activity activity) {
        C9449l lVar = new C9449l();
        C9339d dVar = new C9339d();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putBoolean("st", false);
        dVar.mo36558D(bundle);
        C9341f fVar = new C9341f(activity);
        m9563a(lVar);
        return lVar.createPage(fVar, dVar);
    }

    /* renamed from: a */
    private static void m9563a(HybridService hybridService) {
        C9359r rVar = new C9359r();
        rVar.className = C3900i.class.getName();
        C9359r rVar2 = new C9359r();
        rVar2.className = C3899h.class.getName();
        C9359r rVar3 = new C9359r();
        rVar3.className = C3904l.class.getName();
        C9359r rVar4 = new C9359r();
        rVar4.className = C3913o.class.getName();
        C9359r rVar5 = new C9359r();
        rVar5.className = C3914p.class.getName();
        C9359r rVar6 = new C9359r();
        rVar6.className = C3915q.class.getName();
        C9359r rVar7 = new C9359r();
        rVar7.className = C3917r.class.getName();
        C9359r rVar8 = new C9359r();
        rVar8.className = C3902k.class.getName();
        C9359r rVar9 = new C9359r();
        rVar9.className = C3892d.class.getName();
        C3907n nVar = new C3907n(VivaBaseApplication.m8749FZ());
        C9359r rVar10 = new C9359r();
        rVar10.eKX = nVar;
        C9359r rVar11 = new C9359r();
        rVar11.className = C3894f.class.getName();
        C9359r rVar12 = new C9359r();
        rVar12.className = C3893e.class.getName();
        C9359r rVar13 = new C9359r();
        rVar13.className = C3901j.class.getName();
        C9359r rVar14 = new C9359r();
        rVar14.className = C3897g.class.getName();
        C9359r rVar15 = new C9359r();
        C3907n nVar2 = nVar;
        rVar15.className = C3906m.class.getName();
        C9359r rVar16 = new C9359r();
        C9359r rVar17 = rVar15;
        rVar16.className = C3888a.class.getName();
        hybridService.addPluginConfig(rVar).addPluginConfig(rVar8).addPluginConfig(rVar3).addPluginConfig(rVar4).addPluginConfig(rVar5).addPluginConfig(rVar7).addPluginConfig(rVar6).addPluginConfig(rVar2).addPluginConfig(rVar9).addPluginConfig(rVar10).addPluginConfig(rVar11).addPluginConfig(rVar12).addPluginConfig(rVar13).addPluginConfig(rVar14).addPluginConfig(rVar17).addPluginConfig(rVar16);
        final C3907n nVar3 = nVar2;
        hybridService.getProviderManager().mo36655e(C9371d.class.getName(), new C9371d() {
            /* renamed from: LY */
            public C9390a mo23418LY() {
                return nVar3;
            }
        });
    }

    /* renamed from: dv */
    public static void m9564dv(String str) {
        C9449l lVar = new C9449l();
        C9339d dVar = new C9339d();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        dVar.mo36558D(bundle);
        lVar.startPage(new C9341f(VivaBaseApplication.m8749FZ()), dVar);
        m9563a(lVar);
    }
}
