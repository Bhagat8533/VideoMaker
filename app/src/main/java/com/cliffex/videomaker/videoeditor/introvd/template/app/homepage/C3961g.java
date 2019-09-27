package com.introvd.template.app.homepage;

import android.app.Activity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.homepage.pop.C3979a;
import com.introvd.template.app.homepage.pop.C3987c;
import com.introvd.template.app.homepage.pop.HomeInterstitialPopF;
import com.introvd.template.app.homepage.pop.p187a.C3981a;
import com.introvd.template.app.homepage.pop.p187a.C3982b;
import com.introvd.template.app.homepage.pop.p188b.C3985a;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver.C4128c;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4897f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* renamed from: com.introvd.template.app.homepage.g */
public class C3961g {
    private C4897f bdv;
    private boolean bqq;
    private List<C4892c> brA;
    private C3963a brz;

    /* renamed from: com.introvd.template.app.homepage.g$a */
    public interface C3963a {
        /* renamed from: Ly */
        int mo23521Ly();
    }

    /* renamed from: com.introvd.template.app.homepage.g$b */
    private static class C3964b {
        /* access modifiers changed from: private */
        public static final C3961g brC = new C3961g();
    }

    private C3961g() {
        this.bqq = false;
    }

    /* renamed from: LA */
    private List<C4892c> m9768LA() {
        if (this.brz == null) {
            return new ArrayList();
        }
        if (this.brA != null && !this.brA.isEmpty()) {
            return this.brA;
        }
        C3981a aVar = new C3981a(new C3965h(this));
        C3982b bVar = new C3982b(new C3975i(this));
        C3987c cVar = new C3987c();
        UpgradeBroadcastReceiver cA = UpgradeBroadcastReceiver.m10244cA(VivaBaseApplication.m8749FZ());
        cA.getClass();
        this.brA = Arrays.asList(new C4892c[]{aVar, bVar, cVar, new C4128c(), new C3979a(new C3976j(this)), new HomeInterstitialPopF()});
        return this.brA;
    }

    /* access modifiers changed from: private */
    /* renamed from: LB */
    public /* synthetic */ boolean m9769LB() {
        return this.brz != null && this.brz.mo23521Ly() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: LC */
    public /* synthetic */ boolean m9770LC() {
        return this.brz != null && this.brz.mo23521Ly() == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: LD */
    public /* synthetic */ boolean m9771LD() {
        return this.brz != null && this.brz.mo23521Ly() == 0;
    }

    /* renamed from: Lz */
    public static C3961g m9772Lz() {
        return C3964b.brC;
    }

    /* renamed from: a */
    public void mo23524a(Activity activity, C3963a aVar) {
        this.brz = aVar;
        this.bdv = new C4897f(activity, new C3985a());
    }

    /* renamed from: c */
    public void mo23525c(C4892c cVar) {
        if (this.bdv != null) {
            this.bdv.mo25354b(cVar);
        }
    }

    public boolean isShowing() {
        if (this.bdv == null) {
            return false;
        }
        return this.bdv.isShowing();
    }

    public void show() {
        if (this.bdv != null) {
            if (this.bqq) {
                this.bdv.mo25355cH("app_launcher_pop_flag");
            } else {
                this.bdv.mo25353a("app_launcher_pop_flag", (Collection<C4892c>) m9768LA());
                this.bqq = true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void unInit() {
        this.bdv = null;
        this.brz = null;
    }
}
