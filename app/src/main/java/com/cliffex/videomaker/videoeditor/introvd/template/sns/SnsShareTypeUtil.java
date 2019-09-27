package com.introvd.template.sns;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.SnsConfigMgr;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.sns.MyResolveInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import xiaoying.quvideo.com.vivabase.C10122R;

public class SnsShareTypeUtil {
    private static final int[] SUPPORT_GIF_SNS_ARR = {4, 32, 33, 43, 1001, 100};

    private static List<MyResolveInfo> addPublicDefaultSnsInfo(Context context) {
        return getSnsInfoAppList(context, new int[]{7, 6, 11, 10, 1});
    }

    public static boolean checkGifSNS(SnsResItem snsResItem, boolean z) {
        boolean z2 = false;
        if (z) {
            if (snsResItem == null || Arrays.binarySearch(SUPPORT_GIF_SNS_ARR, snsResItem.mSnsType) >= 0) {
                z2 = true;
            }
            return z2;
        }
        if (snsResItem != null && Arrays.binarySearch(SUPPORT_GIF_SNS_ARR, snsResItem.mSnsType) >= 0) {
            z2 = true;
        }
        return z2;
    }

    public static SnsResItem getAppSnsResItemBySnstype(int i) {
        boolean isInChina = AppStateModel.getInstance().isInChina();
        switch (i) {
            case 1:
                SnsResItem snsResItem = new SnsResItem(1, getSnsResId(isInChina, 1), C10122R.C10123drawable.v5_btn_intl_share_weibo_enable_selector, C10122R.string.xiaoying_str_studio_sns_type_sina_weibo);
                snsResItem.mIconCircleResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_sina_weibo_selector;
                snsResItem.strDes = "WeiBo";
                return snsResItem;
            case 4:
                SnsResItem snsResItem2 = new SnsResItem(4, getSnsResId(isInChina, 4), C10122R.C10123drawable.v5_btn_intl_share_email_selector, C10122R.string.xiaoying_str_com_intl_share_email);
                snsResItem2.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_email_selector;
                snsResItem2.strDes = "Email";
                return snsResItem2;
            case 6:
                SnsResItem snsResItem3 = new SnsResItem(6, getSnsResId(isInChina, 6), C10122R.C10123drawable.v5_btn_intl_share_moments_enable_selector, C10122R.string.xiaoying_str_studio_sns_app_weixin_pyq);
                snsResItem3.mIconCircleResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_moments_selector;
                snsResItem3.strDes = "Moments";
                return snsResItem3;
            case 7:
                SnsResItem snsResItem4 = new SnsResItem(7, getSnsResId(true, 7), getSnsResId(isInChina, 7), C10122R.string.xiaoying_str_studio_sns_app_weixin_pengy);
                snsResItem4.mIconCircleResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_wechat_selector;
                snsResItem4.strDes = "WeChat";
                return snsResItem4;
            case 10:
                SnsResItem snsResItem5 = new SnsResItem(10, getSnsResId(isInChina, 10), C10122R.C10123drawable.v5_btn_intl_share_qzone_enable_selector, C10122R.string.xiaoying_str_studio_sns_app_qzone);
                snsResItem5.mIconCircleResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qzone_selector;
                snsResItem5.strDes = "QQSpace";
                return snsResItem5;
            case 11:
                SnsResItem snsResItem6 = new SnsResItem(11, getSnsResId(isInChina, 11), C10122R.C10123drawable.v5_xiaoying_publish_sns_icon_qq_p, C10122R.string.xiaoying_str_studio_sns_app_qq_py);
                snsResItem6.mIconCircleResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qq_selector;
                snsResItem6.strDes = "QQ";
                return snsResItem6;
            case 26:
                SnsResItem snsResItem7 = new SnsResItem(26, getSnsResId(isInChina, 26), C10122R.C10123drawable.v4_btn_intl_share_youtube_selector, C10122R.string.xiaoying_str_com_intl_share_youtube);
                snsResItem7.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_youtube_selector;
                snsResItem7.strDes = "Youtube";
                return snsResItem7;
            case 28:
                SnsResItem snsResItem8 = new SnsResItem(28, getSnsResId(isInChina, 28), C10122R.C10123drawable.v5_btn_intl_share_facebook_selector, C10122R.string.xiaoying_str_com_intl_share_facebook);
                snsResItem8.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_facebook_selector;
                snsResItem8.strDes = "Facebook";
                return snsResItem8;
            case 29:
                SnsResItem snsResItem9 = new SnsResItem(29, getSnsResId(isInChina, 29), C10122R.C10123drawable.v5_btn_intl_share_twitter_selector, C10122R.string.xiaoying_str_com_intl_share_twitter);
                snsResItem9.mIconCircleResId = C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_twitter_selector;
                snsResItem9.strDes = "Twitter";
                return snsResItem9;
            case 31:
                SnsResItem snsResItem10 = new SnsResItem(31, getSnsResId(isInChina, 31), C10122R.C10123drawable.v4_btn_intl_share_instagram_selector, C10122R.string.xiaoying_str_com_intl_share_instagram);
                snsResItem10.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_ins_selector;
                snsResItem10.strDes = "Instagram";
                return snsResItem10;
            case 32:
                SnsResItem snsResItem11 = new SnsResItem(32, getSnsResId(isInChina, 32), C10122R.C10123drawable.v5_btn_intl_share_whatsapp_selector, C10122R.string.xiaoying_str_com_intl_share_whatsapp);
                snsResItem11.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_whatsapp_selector;
                snsResItem11.strDes = "WhatsApp";
                return snsResItem11;
            case 33:
                SnsResItem snsResItem12 = new SnsResItem(33, getSnsResId(isInChina, 33), C10122R.C10123drawable.v5_btn_intl_share_fbmessenger_selector, C10122R.string.xiaoying_str_com_intl_share_messenger);
                snsResItem12.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_messager_selector;
                snsResItem12.strDes = "FBMessenger";
                return snsResItem12;
            case 38:
                SnsResItem snsResItem13 = new SnsResItem(38, getSnsResId(isInChina, 38), C10122R.C10123drawable.v5_btn_intl_share_line_selector, C10122R.string.xiaoying_str_com_intl_share_line);
                snsResItem13.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_line_selector;
                snsResItem13.strDes = "Line";
                return snsResItem13;
            case 40:
                SnsResItem snsResItem14 = new SnsResItem(40, getSnsResId(false, 40), C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_vk, C10122R.string.xiaoying_str_studio_sns_app_vk);
                snsResItem14.mIconCircleResId = C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_vk;
                snsResItem14.strDes = "VK";
                return snsResItem14;
            case 43:
                SnsResItem snsResItem15 = new SnsResItem(43, getSnsResId(isInChina, 43), C10122R.C10123drawable.v4_btn_intl_share_kakaotalk_selector, C10122R.string.xiaoying_str_com_intl_share_kakaotalk);
                snsResItem15.mIconCircleResId = C10122R.C10123drawable.v4_btn_intl_share_kakaotalk_selector;
                snsResItem15.strDes = "KakaoTalk";
                return snsResItem15;
            case 44:
                SnsResItem snsResItem16 = new SnsResItem(44, getSnsResId(isInChina, 44), C10122R.C10123drawable.v5_btn_intl_share_vine_selector, C10122R.string.xiaoying_str_com_intl_share_vine);
                snsResItem16.mIconCircleResId = C10122R.C10123drawable.v5_btn_intl_share_vine_selector;
                snsResItem16.strDes = "Vine";
                return snsResItem16;
            case 45:
                SnsResItem snsResItem17 = new SnsResItem(45, getSnsResId(isInChina, 45), C10122R.C10123drawable.v5_xiaoying_publish_sns_icon_bbm_n, C10122R.string.xiaoying_str_com_intl_share_bbm);
                snsResItem17.mIconCircleResId = C10122R.C10123drawable.v5_xiaoying_publish_sns_icon_bbm;
                snsResItem17.strDes = "BBM";
                return snsResItem17;
            case 100:
                SnsResItem snsResItem18 = new SnsResItem(100, C10122R.C10123drawable.v5_btn_intl_share_more_selector, C10122R.C10123drawable.v5_btn_intl_share_more_selector, C10122R.string.xiaoying_str_com_more);
                snsResItem18.strDes = "more";
                return snsResItem18;
            case 1001:
                SnsResItem snsResItem19 = new SnsResItem(1001, C10122R.C10123drawable.v4_btn_intl_save_gallery_selector, C10122R.C10123drawable.v4_btn_intl_save_gallery_selector, C10122R.string.xiaoying_str_studio_save_to_gallery);
                snsResItem19.strDes = "Gallery";
                return snsResItem19;
            default:
                return null;
        }
    }

    public static List<MyResolveInfo> getForeignSNSInfo(Context context) {
        return getSnsInfoAppList(context, new int[]{32, 31, 28, 38, 33, 29, 6, 7, 4});
    }

    public static MyResolveInfo getMyResolveInfoBySnsType(Context context, int i) {
        MyResolveInfo myResolveInfo = new MyResolveInfo();
        myResolveInfo.snsType = i;
        if (i == 1) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_sina_weibo_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_sina_weibo);
        } else if (i == 6) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_moments_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_weixin_pyq);
        } else if (i == 7) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_wechat_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_weixin_pengy);
        } else if (i == 10) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qzone_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_qzone);
        } else if (i == 11) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qq_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_qq_py);
        } else if (i == 14) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v4_xiaoying_com_sns_icon_tencent_weibo_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_sns_app_tencent_weibo);
        } else if (i == 28) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_facebook_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_facebook);
        } else if (i == 32) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_whatsapp_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_whatsapp);
        } else if (i == 31) {
            myResolveInfo.iconResId = getSnsResId(false, 31);
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_instagram);
        } else if (i == 38) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_line_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_line);
        } else if (i == 33) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_messager_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_messenger);
        } else if (i == 29) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_twitter_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_twitter);
        } else if (i == 4) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_email_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_intl_share_email);
        } else if (i == 100) {
            myResolveInfo.iconResId = C10122R.C10123drawable.community_feed_more_more_icon;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_more);
        } else if (i == 103) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_copylink_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_copy_link);
        } else if (i == 101) {
            myResolveInfo.iconResId = C10122R.C10123drawable.v5_xiaoying_com_sns_icon_report_selector;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_studio_report_illegal_video_title);
        } else if (i == 102) {
            myResolveInfo.iconResId = C10122R.C10123drawable.community_feed_more_download;
            myResolveInfo.label = context.getString(C10122R.string.xiaoying_str_com_download_title);
        }
        return myResolveInfo;
    }

    public static List<MyResolveInfo> getSnsInfoAppList(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList arrayList = new ArrayList();
        if (AppStateModel.getInstance().isInChina()) {
            arrayList.addAll(addPublicDefaultSnsInfo(context));
        } else {
            arrayList.addAll(getForeignSNSInfo(context));
        }
        if (z) {
            arrayList.add(getMyResolveInfoBySnsType(context, 103));
        }
        if (z2) {
            arrayList.add(getMyResolveInfoBySnsType(context, 101));
        }
        if (z3) {
            arrayList.add(getMyResolveInfoBySnsType(context, 102));
        }
        if (z4) {
            arrayList.add(getMyResolveInfoBySnsType(context, 100));
        }
        return arrayList;
    }

    private static List<MyResolveInfo> getSnsInfoAppList(Context context, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (iArr != null) {
            for (int myResolveInfoBySnsType : iArr) {
                MyResolveInfo myResolveInfoBySnsType2 = getMyResolveInfoBySnsType(context, myResolveInfoBySnsType);
                if (myResolveInfoBySnsType2.iconResId != -1) {
                    arrayList.add(myResolveInfoBySnsType2);
                }
            }
        }
        return arrayList;
    }

    private static int getSnsResId(boolean z, int i) {
        switch (i) {
            case 1:
                return z ? C10122R.C10123drawable.v6_xiaoying_pulish_sns_icon_weibo : C10122R.C10123drawable.v4_xiaoying_com_sns_icon_sina_weibo_selector;
            case 4:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_email_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_email_selector;
            case 6:
                return z ? C10122R.C10123drawable.v6_xiaoying_pulish_sns_icon_pyq : C10122R.C10123drawable.v4_xiaoying_com_sns_icon_moments_selector;
            case 7:
                return z ? C10122R.C10123drawable.v6_xiaoying_pulish_sns_icon_wechat : C10122R.C10123drawable.v4_xiaoying_com_sns_icon_wechat_selector;
            case 10:
                return z ? C10122R.C10123drawable.v6_xiaoying_pulish_sns_icon_qzone : C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qzone_selector;
            case 11:
                return z ? C10122R.C10123drawable.v6_xiaoying_pulish_sns_icon_qq : C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qq_selector;
            case 26:
                return z ? C10122R.C10123drawable.v4_btn_intl_share_youtube_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_youtube_selector;
            case 28:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_facebook_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_facebook_selector;
            case 29:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_twitter_selector : C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_twitter_selector;
            case 31:
                return z ? C10122R.C10123drawable.v4_btn_intl_share_instagram_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_ins_selector;
            case 32:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_whatsapp_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_whatsapp_selector;
            case 33:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_fbmessenger_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_messager_selector;
            case 38:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_line_selector : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_line_selector;
            case 40:
                return z ? C10122R.C10123drawable.v6_xiaoying_feed_sns_icon_vk : C10122R.C10123drawable.v5_xiaoying_com_sns_icon_vk_selector;
            case 43:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_kakaotalk_selector : C10122R.C10123drawable.v4_btn_intl_share_kakaotalk_selector;
            case 44:
                return C10122R.C10123drawable.v5_btn_intl_share_vine_selector;
            case 45:
                return z ? C10122R.C10123drawable.v5_btn_intl_share_bbm_selector : C10122R.C10123drawable.v5_xiaoying_publish_sns_icon_bbm;
            default:
                return 0;
        }
    }

    public static List<Integer> initOverSeaSnsList(Context context) {
        List<Integer> loadSnsConfigInfos = SnsConfigMgr.loadSnsConfigInfos(context, AppStateModel.getInstance().getCountryCode());
        if (loadSnsConfigInfos == null || loadSnsConfigInfos.size() <= 0) {
            loadSnsConfigInfos = new ArrayList<>();
            if (AppStateModel.COUNTRY_CODE_Indonesia.equals(AppStateModel.getInstance().getCountryCode())) {
                loadSnsConfigInfos.add(Integer.valueOf(45));
            }
            if (isKoreanLanguage()) {
                loadSnsConfigInfos.add(Integer.valueOf(28));
                loadSnsConfigInfos.add(Integer.valueOf(31));
                loadSnsConfigInfos.add(Integer.valueOf(26));
                loadSnsConfigInfos.add(Integer.valueOf(38));
                loadSnsConfigInfos.add(Integer.valueOf(32));
                loadSnsConfigInfos.add(Integer.valueOf(33));
                loadSnsConfigInfos.add(Integer.valueOf(43));
            } else {
                loadSnsConfigInfos.add(Integer.valueOf(31));
                loadSnsConfigInfos.add(Integer.valueOf(32));
                loadSnsConfigInfos.add(Integer.valueOf(28));
                loadSnsConfigInfos.add(Integer.valueOf(33));
                loadSnsConfigInfos.add(Integer.valueOf(26));
                loadSnsConfigInfos.add(Integer.valueOf(38));
                loadSnsConfigInfos.add(Integer.valueOf(29));
                loadSnsConfigInfos.add(Integer.valueOf(7));
                loadSnsConfigInfos.add(Integer.valueOf(4));
            }
        }
        return loadSnsConfigInfos;
    }

    private static boolean isKoreanLanguage() {
        String lowerCase = Locale.getDefault().toString().toLowerCase(Locale.US);
        return !TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("ko");
    }
}
