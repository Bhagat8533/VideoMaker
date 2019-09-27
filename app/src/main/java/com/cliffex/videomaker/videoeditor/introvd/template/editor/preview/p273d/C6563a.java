package com.introvd.template.editor.preview.p273d;

import android.app.Activity;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C4681i;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.permission.AccessParam;
import com.introvd.template.editor.permission.C6429a;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.editor.preview.d.a */
public class C6563a {
    private C8522g bMM;
    private WeakReference<Activity> bwg;
    private C6564a deA;

    /* renamed from: com.introvd.template.editor.preview.d.a$a */
    public interface C6564a {
        /* renamed from: gr */
        void mo29755gr(boolean z);
    }

    public C6563a(Activity activity, C8522g gVar) {
        this.bwg = new WeakReference<>(activity);
        this.bMM = gVar;
    }

    /* renamed from: a */
    public void mo29882a(C6564a aVar) {
        this.deA = aVar;
    }

    public void aeq() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            C8049f.aBf().mo33097b(activity, C8070o.aBw(), C7825a.WATER_MARK.getId(), "watermark", -1);
        }
    }

    public void aqy() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            if (!AppStateModel.getInstance().isInChina()) {
                boolean a = C6429a.m18467a(activity, new AccessParam(SocialServiceDef.USER_PRIVILEGE_TYPE_REMOVE_WATERMARK));
                if (this.deA != null) {
                    this.deA.mo29755gr(!a);
                }
            } else {
                boolean z = false;
                if (AppStateModel.getInstance().isInChina()) {
                    AccessParam accessParam = new AccessParam(SocialServiceDef.USER_PRIVILEGE_TYPE_REMOVE_WATERMARK);
                    if (this.bMM != null) {
                        accessParam.cVX = this.bMM.aJI();
                    }
                    AppMiscListener Gr = C4681i.m12184Gp().mo25016Gr();
                    if (this.deA != null) {
                        C6564a aVar = this.deA;
                        if (Gr == null || !C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId())) {
                            z = true;
                        }
                        aVar.mo29755gr(z);
                    }
                } else if (this.deA != null) {
                    this.deA.mo29755gr(false);
                }
            }
        }
    }

    public void onDestroy() {
        this.deA = null;
        this.bMM = null;
        this.bwg = null;
    }
}
