package com.introvd.template.app.service;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.app.community.freeze.C3763b;
import com.introvd.template.router.app.IFreezeService;

@C1942a(mo10417rZ = "/IAppServiceRouter/IFreezeService")
public class IFreezeServiceImpl implements IFreezeService {
    public int getFreezeCode() {
        return C3763b.getFreezeCode();
    }

    public void init(Context context) {
    }

    public void showFreezeDialog(Context context, String str, int i) {
        C3763b.m9231Is().mo23238f(context, str, i);
    }
}
