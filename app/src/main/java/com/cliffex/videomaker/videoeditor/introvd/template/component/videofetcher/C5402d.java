package com.introvd.template.component.videofetcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.introvd.template.component.videofetcher.dao.C5412b;
import com.introvd.template.component.videofetcher.p239c.C5394d;
import com.introvd.template.component.videofetcher.p241ui.MainFetcherActivity;
import java.util.HashMap;
import org.greenrobot.eventbus.C10021c;

/* renamed from: com.introvd.template.component.videofetcher.d */
public class C5402d {
    private static C5402d ciY;
    private C5390c ciZ;

    private C5402d() {
    }

    /* renamed from: ZG */
    public static C5402d m14716ZG() {
        if (ciY == null) {
            ciY = new C5402d();
        }
        return ciY;
    }

    /* renamed from: ZH */
    public C5390c mo27026ZH() {
        return this.ciZ;
    }

    /* renamed from: ZI */
    public void mo27027ZI() {
        C10021c.aZH().mo38492aA(new C5394d(7, 0));
    }

    /* renamed from: a */
    public void mo27028a(Context context, C5390c cVar) {
        C5412b.m14731ZZ().mo27044cG(context);
        this.ciZ = cVar;
    }

    /* renamed from: a */
    public void mo27029a(Context context, String str, HashMap<String, String> hashMap) {
        if (this.ciZ != null) {
            this.ciZ.mo24462a(context, str, hashMap);
        }
    }

    /* renamed from: ai */
    public void mo27030ai(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, MainFetcherActivity.class);
            intent.setFlags(268435456);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.activity_slide_in_from_right, R.anim.activity_slide_out_to_left);
        }
    }
}
