package com.introvd.template.module.iap.business.home;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p355d.C7874a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.router.AdRouter.VipHomeParams;
import xiaoying.engine.base.QUtils;

@C1942a(mo10417rZ = "/XYVIP/VipHomeNewActivity/entry")
public class VipHomeNewActivity extends AdapterActivity {
    private C7874a dPH = new C7874a();
    private boolean isNew = true;

    public int aDi() {
        if (this.isNew) {
            return QUtils.VIDEO_RES_VGA_WIDTH;
        }
        return -1;
    }

    public void onBackPressed() {
        if (!this.dPH.mo32794aM(this)) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("购买页");
        sb.append(this.isNew ? "(new)" : "");
        C7897a.m23022b(sb.toString(), C7898b.dSX, new String[0]);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(16908308);
        setContentView(frameLayout);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        String name = VipHomeNewFragment.class.getName();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(name);
        if (findFragmentByTag == null) {
            findFragmentByTag = new VipHomeNewFragment();
            beginTransaction.add(16908308, findFragmentByTag, name);
        }
        String stringExtra = getIntent().getStringExtra(VipHomeParams.VIP_HOME_INIT_GOODS_ID);
        String stringExtra2 = getIntent().getStringExtra(VipHomeParams.VIP_HOME_PACKAGE_TYPE);
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "gold";
        }
        String str = null;
        if (!C7825a.ALL_TEMPLATE.getId().equals(stringExtra)) {
            C7897a.m23026f("Iap_Purchase_Template_Id", new String[0]);
        } else {
            str = C7897a.m23024c("Iap_Purchase_Template_Id", new String[0]);
        }
        C7835b.m22847aA(stringExtra2, str);
        if (findFragmentByTag.getArguments() == null) {
            findFragmentByTag.setArguments(new Bundle());
        }
        findFragmentByTag.getArguments().putString(VipHomeParams.VIP_HOME_INIT_GOODS_ID, stringExtra);
        findFragmentByTag.getArguments().putString(VipHomeParams.VIP_HOME_PACKAGE_TYPE, stringExtra2);
        beginTransaction.commit();
        this.dPH.aDe();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C7897a.m23026f("Iap_Domestic_Todo_Code", new String[0]);
        this.dPH.destroy();
    }

    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
