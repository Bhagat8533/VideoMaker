package com.introvd.template.router.iap;

public class IapRouter {
    public static final String IAP_TODO_INTERCEPTOR = "/mid_iap/todoInterceptor";
    public static final String MID_IAP_SERVICE = "/mid_iap/mid_iap_service";
    private static final String MODULE_GROUP = "/mid_iap/";
    public static final String PROXY_USER_LIFECYCLE = "/mid_iap/user_lifecycle";

    public interface IapPayResult {
        void onPayResult(boolean z);
    }
}
