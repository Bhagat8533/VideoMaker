package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.p021v4.app.DialogFragment;
import android.support.p021v4.app.FragmentActivity;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.community.ICommunityService;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;

/* renamed from: com.introvd.template.app.homepage.pop.a */
public class C3979a extends C4892c {
    public C3979a(C4893a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (!(activity instanceof FragmentActivity) || C4560d.m11516RN().isYoungerMode()) {
            return false;
        }
        ICommunityService iCommunityService = (ICommunityService) C1919a.m5529sc().mo10356i(ICommunityService.class);
        if (iCommunityService == null) {
            return false;
        }
        if (!(C3742b.m9111II().isCommunityCloseSoon() && AppStateModel.getInstance().isCommunityCloseSoon()) || AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_close_community_tip_dialog_show", false)) {
            return false;
        }
        DialogFragment createCloseServiceTipDialog = iCommunityService.createCloseServiceTipDialog(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C3979a.this.mo25344EW();
            }
        });
        if (!createCloseServiceTipDialog.isVisible()) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_close_community_tip_dialog_show", true);
            createCloseServiceTipDialog.show(((FragmentActivity) activity).getSupportFragmentManager(), "close_community");
        }
        return true;
    }

    /* renamed from: sb */
    public int mo23397sb() {
        return 95;
    }
}
