package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p352b.C7835b;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.vip.a.b */
class C8015b implements C8022e {
    C8015b() {
    }

    public int aDW() {
        return R.drawable.iap_vip_bg_home_dialog_restore_fail;
    }

    public float aDX() {
        return 3.18f;
    }

    public List<String> aDY() {
        return null;
    }

    public int aDZ() {
        return 0;
    }

    public boolean aEa() {
        return true;
    }

    public void aEb() {
    }

    /* renamed from: aN */
    public void mo33022aN(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.SYNC_SETTINGS"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C7835b.m22848aB("Restore_Failed_Dialog_Click", "tap reblind");
    }

    /* renamed from: aO */
    public void mo33023aO(Activity activity) {
        C8048e.aBe().mo23645d(activity, -1);
        C7835b.m22848aB("Restore_Failed_Dialog_Click", "contact us");
    }

    /* renamed from: d */
    public void mo33024d(TextView textView) {
    }

    /* renamed from: e */
    public void mo33025e(TextView textView) {
    }

    /* renamed from: f */
    public boolean mo33026f(TextView textView) {
        textView.setVisibility(0);
        textView.setText(R.string.xiaoying_str_vip_popup_relogin);
        return true;
    }

    /* renamed from: g */
    public boolean mo33027g(TextView textView) {
        textView.setVisibility(0);
        textView.setText(R.string.xiaoying_str_com_invite_community_contact_us);
        return true;
    }

    public String getDescription() {
        return C8048e.aBe().getContext().getString(R.string.xiaoying_str_vip_popup_restore_fail_desc_android);
    }

    public String getTitle() {
        return C8048e.aBe().getContext().getString(R.string.xiaoying_str_vip_popup_restore_fail_title);
    }
}
