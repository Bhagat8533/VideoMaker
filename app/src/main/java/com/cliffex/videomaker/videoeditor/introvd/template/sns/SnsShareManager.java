package com.introvd.template.sns;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ResolveInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.sns.PopupVideoShareInfo;
import com.introvd.template.sns.biz.C8582R;
import com.introvd.template.sns.p398ui.PopupVideoShareDialog;
import com.quvideo.share.C4953b;
import com.quvideo.share.C4954c;
import com.quvideo.sns.base.C4987e;
import com.quvideo.sns.base.p228b.C4979b;
import com.quvideo.sns.base.p228b.C4979b.C4981a;
import com.quvideo.sns.base.p228b.C4982c;

public class SnsShareManager {
    static final int SHARE_TYPE_IMAGE = 0;
    static final int SHARE_TYPE_LINK = 2;
    static final int SHARE_TYPE_TEXT = 3;
    static final int SHARE_TYPE_VIDEO = 1;

    public static ResolveInfo getResolveInfoBySnsType(Context context, int i) {
        return C4987e.m12737F(context, i);
    }

    /* access modifiers changed from: private */
    public static int handleShare(final Context context, int i, int i2, C4979b bVar, final C4982c cVar) {
        bVar.akF = context.getString(C8582R.string.xiaoying_str_com_app_name);
        C85794 r0 = new C4982c() {
            public void onHandleIntentShare(int i) {
                if (cVar != null) {
                    cVar.onHandleIntentShare(i);
                }
            }

            public void onShareCanceled(int i) {
                if (cVar != null) {
                    cVar.onShareCanceled(i);
                }
            }

            public void onShareFailed(int i, int i2, String str) {
                SnsShareManager.toastShareError(context, i, i2);
                if (cVar != null) {
                    cVar.onShareFailed(i, i2, str);
                }
            }

            public void onShareSuccess(int i) {
                SnsShareManager.toastShareSuccess(context);
                if (cVar != null) {
                    cVar.onShareSuccess(i);
                }
            }
        };
        int i3 = i2 == 2 ? C4954c.m12657a((Activity) context, i, bVar, (C4982c) r0) : i2 == 0 ? C4954c.m12664b((Activity) context, i, bVar, (C4982c) r0) : i2 == 1 ? C4954c.m12669c((Activity) context, i, bVar, (C4982c) r0) : i2 == 3 ? C4954c.m12659a(context, i, bVar, (C4982c) r0) : -2;
        if (i3 == -1) {
            ToastUtils.show(context.getApplicationContext(), C8582R.string.xiaoying_str_com_no_sns_client, 1);
        } else if (i == 1 && i3 == -110) {
            ToastUtils.show(context.getApplicationContext(), C8582R.string.xiaoying_str_share_weibo_client_not_support, 1);
        } else if (i3 == -2) {
            ToastUtils.show(context.getApplicationContext(), C8582R.string.xiaoying_str_studio_msg_share_fail, 1);
        }
        return i3;
    }

    public static boolean isSnsSDKAndApkInstalled(Context context, int i, boolean z) {
        boolean isSnsSDKAndApkInstalled = C4953b.isSnsSDKAndApkInstalled(context, i);
        if (!isSnsSDKAndApkInstalled && z) {
            ToastUtils.show(context, C8582R.string.xiaoying_str_com_no_sns_client, 1);
        }
        return isSnsSDKAndApkInstalled;
    }

    public static void shareImage(final Activity activity, final int i, final SnsShareInfo snsShareInfo) {
        final C4979b FJ = new C4981a().mo25442cM(snsShareInfo.strTitle).mo25443cN(snsShareInfo.strDesc).mo25448cS(snsShareInfo.strChooserTitle).mo25445cP(snsShareInfo.strImgUrl).mo25447cR(snsShareInfo.strLinkUrl).mo25441FJ();
        if (i == 100 || i == 4 || i == 103) {
            shareText(activity, i, FJ, snsShareInfo.snsShareListener);
        } else {
            SnsShareUtils.startLoadImage(activity, i, FJ, new ILoadImageCallback() {
                public void loadImageOver(String str) {
                    FJ.strImgUrl = str;
                    SnsShareManager.handleShare(activity, i, 0, FJ, snsShareInfo.snsShareListener);
                }
            });
        }
    }

    public static void shareLink(final Activity activity, final int i, int i2, final SnsShareInfo snsShareInfo, String str) {
        snsShareInfo.strLinkUrl = SnsShareUtils.addToAppParams(i, snsShareInfo.strLinkUrl, str);
        final C4979b FJ = new C4981a().mo25442cM(snsShareInfo.strTitle).mo25444cO(snsShareInfo.strQuote).mo25443cN(snsShareInfo.strDesc).mo25448cS(snsShareInfo.strChooserTitle).mo25445cP(snsShareInfo.strImgUrl).mo25447cR(snsShareInfo.strLinkUrl).mo25441FJ();
        if (i == 100 || i == 4 || i == 103) {
            shareText(activity, i, FJ, snsShareInfo.snsShareListener);
            return;
        }
        if (snsShareInfo.isNeedWXProgram) {
            FJ.bfp = WeiXinProgramShareUtils.getShareToWXProPageUrl(i, i2, snsShareInfo);
        }
        SnsShareUtils.startLoadImage(activity, i, FJ, new ILoadImageCallback() {
            public void loadImageOver(String str) {
                FJ.strImgUrl = str;
                SnsShareManager.handleShare(activity, i, 2, FJ, snsShareInfo.snsShareListener);
            }
        });
    }

    public static void shareLink(Activity activity, int i, SnsShareInfo snsShareInfo, String str) {
        shareLink(activity, i, 1, snsShareInfo, str);
    }

    public static boolean shareText(Context context, int i, C4979b bVar, C4982c cVar) {
        return handleShare(context, i, 3, bVar, cVar) == 0;
    }

    public static void shareVideo(final Activity activity, final int i, final C4979b bVar, final C4982c cVar) {
        if (i == 103) {
            shareText(activity, i, bVar, cVar);
            return;
        }
        if (bVar.strDesc == null) {
            bVar.strDesc = "#vivavideo ";
        }
        if (i == 28) {
            String countryCode = AppStateModel.getInstance().getCountryCode();
            StringBuilder sb = new StringBuilder(bVar.strDesc);
            if (countryCode.equals(AppStateModel.COUNTRY_CODE_Korea)) {
                sb.append("#비바비디오");
            } else if (countryCode.equals(AppStateModel.COUNTRY_CODE_Japan)) {
                sb.append("#ビバビデオ");
            } else if (countryCode.equals(AppStateModel.COUNTRY_CODE_RUSSIA)) {
                sb.append("#ВиваВидео");
            } else if (countryCode.equals(AppStateModel.COUNTRY_CODE_Taiwan)) {
                sb.append("#小影 ");
            }
        }
        SnsShareUtils.startLoadImage(activity, i, bVar, new ILoadImageCallback() {
            public void loadImageOver(String str) {
                bVar.strImgUrl = str;
                SnsShareManager.handleShare(activity, i, 1, bVar, cVar);
            }
        });
    }

    public static void shareVideo(Activity activity, ResolveInfo resolveInfo, C4979b bVar) {
        if (C4954c.m12658a(activity, resolveInfo, bVar) == -2) {
            ToastUtils.show(activity.getApplicationContext(), C8582R.string.xiaoying_str_studio_msg_share_fail, 1);
        }
    }

    public static void showVideoShareDialog(Context context, PopupVideoShareInfo popupVideoShareInfo) {
        PopupVideoShareDialog popupVideoShareDialog = new PopupVideoShareDialog(context);
        popupVideoShareDialog.setPopupVideoShareInfo(popupVideoShareInfo);
        popupVideoShareDialog.show(true);
    }

    /* access modifiers changed from: private */
    public static void toastShareError(Context context, int i, int i2) {
        if (context != null) {
            int i3 = C8582R.string.xiaoying_str_studio_msg_share_fail;
            if (i == 1 && i2 == -110) {
                i3 = C8582R.string.xiaoying_str_share_weibo_client_not_support;
            }
            ToastUtils.show(context, i3, 0);
        }
    }

    /* access modifiers changed from: private */
    public static void toastShareSuccess(Context context) {
        if (context != null) {
            ToastUtils.show(context, C8582R.string.xiaoying_str_studio_share_success, 0);
        }
    }
}
