package com.introvd.template.sns;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.quvideo.com.vivabase.C10122R;

public class SnsConst {
    public static int[] BIND_IDS = {1, 30};
    private static volatile SnsConst instance;
    private ArrayList<SnsResItem> mItems = new ArrayList<>();

    public SnsConst() {
        this.mItems.add(new SnsResItem(1, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_sina_weibo_selector, C10122R.C10123drawable.xiaoying_com_sns_icon_small_sina_weibo_selector, C10122R.string.xiaoying_str_studio_sns_type_sina_weibo));
        this.mItems.add(new SnsResItem(10, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qzone_selector, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qzone_selector, C10122R.string.xiaoying_str_studio_sns_app_qzone));
        this.mItems.add(new SnsResItem(16, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_tieba_selector, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_tieba_selector, C10122R.string.xiaoying_str_studio_sns_app_baidu_tieba_notrans));
        this.mItems.add(new SnsResItem(6, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_moments_selector, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_moments_selector, C10122R.string.xiaoying_str_studio_sns_app_weixin_pyq));
        this.mItems.add(new SnsResItem(7, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_wechat_selector, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_wechat_selector, C10122R.string.xiaoying_str_studio_sns_app_weixin_pengy));
        this.mItems.add(new SnsResItem(11, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qq_selector, C10122R.C10123drawable.v4_xiaoying_com_sns_icon_qq_selector, C10122R.string.xiaoying_str_studio_sns_app_qq_py));
    }

    public static SnsConst getInstance() {
        if (instance == null) {
            synchronized (SnsConst.class) {
                if (instance == null) {
                    instance = new SnsConst();
                }
            }
        }
        return instance;
    }

    public static String getSnsTitleBySnsId(Context context, int i) {
        String str = "";
        switch (i) {
            case 1:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_type_sina_weibo);
            case 6:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_weixin_pyq);
            case 7:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_weixin_pengy);
            case 10:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_qzone);
            case 11:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_qq_py);
            case 14:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_tencent_weibo);
            case 15:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_renren);
            case 16:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_baidu_tieba_notrans);
            case 30:
                return context.getString(C10122R.string.xiaoying_str_studio_sns_app_tudou);
            default:
                return str;
        }
    }

    public static boolean isCanChooseFriends(int i) {
        return 1 == i || 14 == i || 15 == i;
    }

    public SnsResItem getItemBySnsId(int i) {
        Iterator it = this.mItems.iterator();
        while (it.hasNext()) {
            SnsResItem snsResItem = (SnsResItem) it.next();
            if (snsResItem.mSnsType == i) {
                return snsResItem;
            }
        }
        return null;
    }

    public ArrayList<SnsResItem> getSnsItemList(int[] iArr) {
        ArrayList<SnsResItem> arrayList = new ArrayList<>();
        arrayList.clear();
        for (int itemBySnsId : iArr) {
            SnsResItem itemBySnsId2 = getItemBySnsId(itemBySnsId);
            if (itemBySnsId2 != null) {
                arrayList.add(itemBySnsId2);
            }
        }
        return arrayList;
    }
}
