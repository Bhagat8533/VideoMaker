package com.introvd.template.router.iap;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.iap.IapRouter.IapPayResult;

public interface IIapService extends C1949c {
    Object execute(String str, Object... objArr);

    void launchVipHome(Context context, int i, String str, int i2);

    void payForH5(IapPayResult iapPayResult);
}
