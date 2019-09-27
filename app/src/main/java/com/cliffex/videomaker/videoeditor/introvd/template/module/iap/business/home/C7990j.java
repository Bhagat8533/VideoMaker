package com.introvd.template.module.iap.business.home;

import android.content.Context;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.p359b.C7970a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.home.j */
public class C7990j implements C7984f {
    private int dTW;
    String goodsId;

    /* renamed from: com.introvd.template.module.iap.business.home.j$a */
    class C7992a extends C7970a {
        int type;

        C7992a(int i, String str, String str2) {
            super(i, str, str2);
        }
    }

    public C7990j() {
        this.dTW = 0;
    }

    public C7990j(int i, String str) {
        this(str);
        this.dTW = i;
    }

    public C7990j(String str) {
        this.dTW = 0;
        this.goodsId = str;
        StringBuilder sb = new StringBuilder();
        sb.append("VipNewDataHelper  ");
        sb.append(str);
        LogUtils.m14222e("VipNewDataHelper", sb.toString());
    }

    static boolean aDH() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHD2KSupport();
    }

    static boolean aDI() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHD4KSupport();
    }

    public Map<String, Object> aDj() {
        Context context = C8048e.aBe().getContext();
        HashMap hashMap = new HashMap();
        hashMap.put("remove_watermark_title", context.getString(R.string.xiaoying_str_iap_remove_watermark));
        hashMap.put("remove_watermark_des", context.getString(R.string.xiaoying_str_vip_item_water_mark_desc));
        hashMap.put("hd_export_title_android", context.getString(R.string.xiaoying_str_vip_item_hd_title));
        hashMap.put("hd_export_des_android", context.getString(R.string.xiaoying_str_vip_item_hd_desc));
        hashMap.put("remove_duration_limit_title", context.getString(R.string.xiaoying_str_vip_item_duration_limie_title));
        hashMap.put("remove_duration_limit_des", context.getString(R.string.xiaoying_str_vip_item_duration_limie_desc));
        hashMap.put("remove_ad_title", context.getString(R.string.xiaoying_str_vip_item_ad_title));
        hashMap.put("remove_ad_des", context.getString(R.string.xiaoying_str_vip_item_ad_desc));
        hashMap.put("video_adjustment_title", context.getString(R.string.xiaoying_str_vip_item_adjust_title));
        hashMap.put("video_adjustment_des", context.getString(R.string.xiaoying_str_vip_item_adjust_desc));
        hashMap.put("animated_text_title", context.getString(R.string.xiaoying_str_vip_item_animated_text_title));
        hashMap.put("animated_text_des", context.getString(R.string.xiaoying_str_vip_item_animated_text_desc));
        hashMap.put("mosaic_title", context.getString(R.string.xiaoying_str_ve_mosaic_title));
        hashMap.put("mosaic_des", "");
        hashMap.put("magic_sound_title", context.getString(R.string.xiaoying_str_clip_func_magic_sound));
        hashMap.put("magic_sound_des", "");
        hashMap.put("use_paid_material_title", context.getString(R.string.xiaoying_str_vip_item_template_title));
        hashMap.put("use_paid_material_des", context.getString(R.string.xiaoying_str_vip_item_all_template_desc));
        hashMap.put("more_privilege_title", context.getString(R.string.xiaoying_str_com_more));
        hashMap.put("custom_bg_title", context.getString(R.string.xiaoying_str_vip_item_custom_bg_title));
        hashMap.put("user_custom_watermark", context.getString(R.string.xiaoying_str_editor_custom_watermark));
        hashMap.put("key_frame_title", context.getString(R.string.xiaoying_str_template_key_frame));
        hashMap.put("key_frame_des", "");
        hashMap.put("audio_extract_title", context.getString(R.string.xiaoying_str_template_audio_extract));
        hashMap.put("audio_extract_des", "");
        hashMap.put("btn_bg_platinum_monthly", Integer.valueOf(context.getResources().getColor(R.color.color_232a4f)));
        hashMap.put("btn_bg_platinum_yearly", Integer.valueOf(context.getResources().getColor(R.color.color_4f5472)));
        hashMap.put("platinum_yearly_text_display", Integer.valueOf(0));
        if (C8048e.aBe().mo23630Mv()) {
            hashMap.put("vip_lite_monthly", "vip_lite_monthly_2.99");
            hashMap.put("vip_lite_yearly", "vip_lite_yearly_15.99");
        } else {
            hashMap.put("android_premium_platinum_monthly_id", "premium_platinium_monthly_2.49");
            hashMap.put("android_premium_platinum_yearly_id", "premium_platinium_yearly_12.99");
        }
        hashMap.put("android_domestic_welfare_gift", context.getString(R.string.xiaoying_str_vip_third_welfare));
        return hashMap;
    }

    public String aDk() {
        return C8048e.aBe().mo23630Mv() ? "vip_lite_monthly" : "android_premium_platinum_monthly_id";
    }

    public String aDl() {
        return C8048e.aBe().mo23630Mv() ? "vip_lite_yearly" : "android_premium_platinum_yearly_id";
    }

    public List<C7970a> aDm() {
        LogUtils.m14222e("VipNewDataHelper", "getSubFuncList -------– ");
        C7900d dVar = new C7900d(aDj());
        ArrayList arrayList = new ArrayList();
        C7970a aVar = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_watermark_new : R.drawable.iap_vip_icon_privilege_watermark, 0, C7825a.WATER_MARK.getId(), dVar.mo32861lw("remove_watermark_title"));
        aVar.mo32946sG(0);
        arrayList.add(aVar);
        C7970a aVar2 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_hd_new : R.drawable.iap_vip_icon_privilege_1080hd, C7825a.HD.getId(), dVar.mo32861lw("hd_export_title_android"), dVar.mo32861lw("hd_export_des_android"));
        aVar2.mo32946sG(1);
        if (aDI()) {
            aVar2.mo32948sI(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_4k_new : R.drawable.iap_vip_icon_privilege_4khd);
        } else if (aDH()) {
            aVar2.mo32948sI(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_2k_new : R.drawable.iap_vip_icon_privilege_2khd);
        } else if (isHigherHDExport()) {
            aVar2.mo32948sI(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_hd_new : R.drawable.iap_vip_icon_privilege_1080hd);
        } else if (isHDExportBetaTest()) {
            aVar2.mo32948sI(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_hd_new_720 : R.drawable.iap_vip_icon_privilege_720hd);
        }
        arrayList.add(aVar2);
        C7970a aVar3 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_duration_new : R.drawable.iap_vip_icon_privilege_export, 0, C7825a.DURATION_LIMIT.getId(), dVar.mo32861lw("remove_duration_limit_title"));
        aVar3.mo32946sG(2);
        arrayList.add(aVar3);
        C7970a aVar4 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_ad_new : R.drawable.iap_vip_icon_privilege_noad, 0, C7825a.AD.getId(), dVar.mo32861lw("remove_ad_title"));
        aVar4.mo32946sG(3);
        arrayList.add(aVar4);
        C7970a aVar5 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_mosaic_new : R.drawable.iap_vip_icon_privilege_mosaic, 0, C7825a.MOSAIC.getId(), dVar.mo32861lw("mosaic_title"));
        aVar5.mo32946sG(4);
        arrayList.add(aVar5);
        C7970a aVar6 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_key_frame : R.drawable.iap_vip_icon_privilege_key_frame, 0, C7825a.KEY_FRAME.getId(), dVar.mo32861lw("key_frame_title"));
        aVar6.mo32946sG(5);
        arrayList.add(aVar6);
        C7970a aVar7 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_audio_extract : R.drawable.iap_vip_icon_privilege_audio_extract, 0, C7825a.AUDIO_EXTRA.getId(), dVar.mo32861lw("audio_extract_title"));
        aVar7.mo32946sG(6);
        arrayList.add(aVar7);
        C7970a aVar8 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_big_custom_watermarking : R.drawable.iap_vip_icon_custom_watermarking, 0, C7825a.USER_WATER_MARK.getId(), dVar.mo32861lw("user_custom_watermark"));
        aVar8.mo32946sG(7);
        arrayList.add(aVar8);
        C7970a aVar9 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_adjust_new : R.drawable.iap_vip_icon_adjust_export, 0, C7825a.VIDEO_PARAM_ADJUST.getId(), dVar.mo32861lw("video_adjustment_title"));
        aVar9.mo32946sG(8);
        arrayList.add(aVar9);
        C7970a aVar10 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_bg_home_item_platinum_custom_new : R.drawable.iap_vip_icon_privilege_custom_bg, 0, C7825a.CUSTOMIZED_BACKGROUND.getId(), dVar.mo32861lw("custom_bg_title"));
        aVar10.mo32946sG(9);
        arrayList.add(aVar10);
        C7970a aVar11 = new C7970a(0, C7825a.ALL_TEMPLATE.getId(), dVar.mo32861lw("use_paid_material_title"));
        if (this.dTW != 0) {
            aVar11.mo32948sI(R.drawable.iap_vip_icon_privilege_material);
        }
        aVar11.mo32946sG(10);
        arrayList.add(aVar11);
        C7970a aVar12 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_magic_sound_new : R.drawable.iap_vip_icon_privilege_changevoice, 0, C7825a.MAGIC_SOUND.getId(), dVar.mo32861lw("magic_sound_title"));
        aVar12.mo32946sG(11);
        arrayList.add(aVar12);
        C7970a aVar13 = new C7970a(this.dTW == 0 ? R.drawable.iap_vip_icon_home_item_platinum_animated_text_new : R.drawable.iap_vip_icon_privilege_dynamic_caption, 0, C7825a.ANIM_TITLE.getId(), dVar.mo32861lw("animated_text_title"));
        aVar13.mo32946sG(12);
        arrayList.add(aVar13);
        C7970a aVar14 = new C7970a(R.drawable.iap_vip_icon_privilege_function_more, (String) null, dVar.mo32861lw("more_privilege_title"), (String) null);
        aVar14.mo32946sG(13);
        arrayList.add(aVar14);
        mo32939ck(arrayList);
        return arrayList;
    }

    public String aDr() {
        return "subscription_new_page_monthly_discount";
    }

    public String aDs() {
        return "subscription_new_page_yearly_discount";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ck */
    public void mo32939ck(List<C7970a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (C7970a aVar : list) {
            if (this.goodsId != null && this.goodsId.equals(aVar.aCH())) {
                aVar.mo32946sG(-1);
            }
        }
        Collections.sort(list, new Comparator<C7970a>() {
            /* renamed from: a */
            public int compare(C7970a aVar, C7970a aVar2) {
                return aVar.aDM() - aVar2.aDM();
            }
        });
        C7970a aVar2 = null;
        if (!list.isEmpty()) {
            aVar2 = (C7970a) list.get(list.size() - 1);
        }
        if (list.size() >= 7) {
            list = list.subList(0, 7);
        }
        if (aVar2 != null) {
            list.add(aVar2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isHDExportBetaTest() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHDExportBetaTest();
    }

    /* access modifiers changed from: protected */
    public boolean isHigherHDExport() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHigherHDExport();
    }
}
