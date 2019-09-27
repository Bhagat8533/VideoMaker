package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.youngermode.C4545a;
import com.introvd.template.app.youngermode.C4553b;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.app.youngermode.p202b.C4556a;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4584e;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import java.util.Date;

/* renamed from: com.introvd.template.app.homepage.pop.g */
public class C3996g extends C4892c {
    public C3996g(C4893a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (C2561a.aON() || !AppStateModel.getInstance().isInChina() || !C3742b.m9111II().mo23151JS()) {
            return false;
        }
        if (C4560d.m11516RN().isYoungerMode()) {
            C4553b.m11491RJ().mo24788bY(true);
            C4553b.m11491RJ().init(activity);
        } else if (C4560d.m11516RN().mo24806RO() || !C4584e.m11678b(new Date(C4560d.m11516RN().mo24807RP()))) {
            C4556a.m11511du(activity);
            C4545a.m11480e(activity, new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    C4560d.m11516RN().mo24804Q(System.currentTimeMillis());
                    C3996g.this.mo25344EW();
                }
            });
            C3998h.m9883du("青少年模式");
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: sb */
    public int mo23397sb() {
        return 100;
    }
}
