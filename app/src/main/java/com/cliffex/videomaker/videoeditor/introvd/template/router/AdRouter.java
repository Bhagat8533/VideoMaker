package com.introvd.template.router;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.iap.IapRouter.IapPayResult;
import com.introvd.template.router.iap.IapServiceProxy;

public class AdRouter extends BaseRouter {
    private static final int NO_REQUEST_CODE = -1;
    public static final String VIP_ACTION_FOR_RESULT = "vip_action_for_result";
    public static final String VIP_EXCHANGE_URL = "/XYVIP/VipExchange/entry";
    public static final String VIP_RENEW_URL = "/XYVIP/VipRenew/entry";

    public class ShuffleAdParams {
        public static final String URL = "/XYAD/ShuffleAdActivity/entry";

        public ShuffleAdParams() {
        }
    }

    public class VipHomeParams {
        public static final String URL = "/XYVIP/VipHomeNewActivity/entry";
        public static final String VIP_HOME_INIT_GOODS_ID = "vip_home_init_goods_id";
        public static final String VIP_HOME_PACKAGE_TYPE = "vip_home_package_type";
        public static final String VIP_IS_WAITING_FOR_RESULT = "vip_is_waiting_for_result";
        public static final String VIP_RENEW_DEFAULT_GOODS_ID = "vip_renew_default_goods_id";

        public VipHomeParams() {
        }
    }

    private static class VipRenewResultReceiver extends BroadcastReceiver {
        private final IapPayResult onResult;

        private VipRenewResultReceiver(IapPayResult iapPayResult) {
            this.onResult = iapPayResult;
        }

        public void onReceive(Context context, Intent intent) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            if (!(intent == null || this.onResult == null || !AdRouter.VIP_ACTION_FOR_RESULT.equals(intent.getAction()))) {
                boolean z = false;
                Object execute = IapServiceProxy.execute(IapServiceProxy.isVip, new Object[0]);
                if ((execute instanceof Boolean) && ((Boolean) execute).booleanValue()) {
                    z = true;
                }
                this.onResult.onPayResult(z);
            }
        }
    }

    public static void launchVipExchange(Activity activity) {
        getRouterBuilder(activity.getApplication(), VIP_EXCHANGE_URL).mo10382H(activity);
    }

    public static void launchVipHome(Context context, String str, String str2, int i) {
        if (context != null) {
            boolean z = context instanceof Activity;
            C1941a f = getRouterBuilder((Application) context.getApplicationContext(), VipHomeParams.URL).mo10399f(VipHomeParams.VIP_HOME_PACKAGE_TYPE, str).mo10399f(VipHomeParams.VIP_HOME_INIT_GOODS_ID, str2);
            if (!z) {
                f.mo10398dD(268435456);
            }
            if (i == -1 || !z) {
                f.mo10382H(context);
            } else {
                f.mo10396b((Activity) context, i);
            }
        }
    }

    public static void launchVipRenew(Context context) {
        launchVipRenew(context, null);
    }

    public static void launchVipRenew(Context context, String str) {
        launchVipRenew(context, str, -1);
    }

    public static void launchVipRenew(Context context, String str, int i) {
        if (context != null) {
            boolean z = context instanceof Activity;
            C1941a routerBuilder = getRouterBuilder((Application) context.getApplicationContext(), VIP_RENEW_URL);
            if (!TextUtils.isEmpty(str)) {
                routerBuilder.mo10399f(VipHomeParams.VIP_RENEW_DEFAULT_GOODS_ID, str);
            }
            if (!z) {
                routerBuilder.mo10398dD(268435456);
            }
            if (i == -1 || !z) {
                routerBuilder.mo10382H(context);
            } else {
                routerBuilder.mo10396b((Activity) context, i);
            }
        }
    }

    public static void launchVipRenewForResult(Context context, IapPayResult iapPayResult) {
        if (context != null) {
            boolean z = context instanceof Activity;
            C1941a routerBuilder = getRouterBuilder((Application) context.getApplicationContext(), VIP_RENEW_URL);
            routerBuilder.mo10391a(VipHomeParams.VIP_IS_WAITING_FOR_RESULT, true);
            if (!z) {
                routerBuilder.mo10398dD(268435456);
            }
            routerBuilder.mo10382H(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VIP_ACTION_FOR_RESULT);
            LocalBroadcastManager.getInstance(context).registerReceiver(new VipRenewResultReceiver(iapPayResult), intentFilter);
        }
    }

    public static void sendVipRenewPayResult(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(VIP_ACTION_FOR_RESULT));
    }
}
