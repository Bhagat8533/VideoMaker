package com.introvd.template.module.iap.business.home;

import android.content.Context;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.p359b.C7970a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.home.k */
public class C7993k implements C7984f {
    private int type;

    public C7993k(int i) {
        this.type = i;
    }

    private List<C7970a> aDJ() {
        C7900d dVar = new C7900d(aDj());
        ArrayList arrayList = new ArrayList();
        C7970a aVar = new C7970a(R.drawable.iap_vip_icon_privilege_watermark, C7825a.WATER_MARK.getId(), dVar.mo32861lw("remove_watermark_title"), dVar.mo32861lw("remove_watermark_des"));
        aVar.mo32946sG(0);
        arrayList.add(aVar);
        if (isHigherHDExport()) {
            C7970a aVar2 = new C7970a(R.drawable.iap_vip_icon_privilege_1080hd, C7825a.HD.getId(), dVar.mo32861lw("hd_export_title_android"), dVar.mo32861lw("hd_export_des_android"));
            aVar2.mo32946sG(1);
            arrayList.add(aVar2);
        } else if (isHDExportBetaTest()) {
            C7970a aVar3 = new C7970a(R.drawable.iap_vip_icon_privilege_720hd, C7825a.HD.getId(), dVar.mo32861lw("hd_export_title_android"), dVar.mo32861lw("hd_export_des_android"));
            aVar3.mo32946sG(1);
            arrayList.add(aVar3);
        }
        C7970a aVar4 = new C7970a(R.drawable.iap_vip_icon_privilege_export, C7825a.DURATION_LIMIT.getId(), dVar.mo32861lw("remove_duration_limit_title"), dVar.mo32861lw("remove_duration_limit_des"));
        aVar4.mo32946sG(2);
        arrayList.add(aVar4);
        if (C7990j.aDI()) {
            C7970a aVar5 = new C7970a(R.drawable.iap_vip_icon_privilege_4khd, C7825a.HD_4k.getId(), dVar.mo32861lw("key_4k_title"), "");
            aVar5.mo32946sG(3);
            arrayList.add(aVar5);
        } else if (C7990j.aDH()) {
            C7970a aVar6 = new C7970a(R.drawable.iap_vip_icon_privilege_2khd, C7825a.HD_2k.getId(), dVar.mo32861lw("key_2k_title"), "");
            aVar6.mo32946sG(3);
            arrayList.add(aVar6);
        }
        C7970a aVar7 = new C7970a(R.drawable.iap_vip_icon_privilege_noad, C7825a.AD.getId(), dVar.mo32861lw("remove_ad_title"), dVar.mo32861lw("remove_ad_des"));
        aVar7.mo32946sG(4);
        arrayList.add(aVar7);
        C7970a aVar8 = new C7970a(R.drawable.iap_vip_icon_privilege_mosaic, C7825a.MOSAIC.getId(), dVar.mo32861lw("mosaic_title"), dVar.mo32861lw("mosaic_des"));
        aVar8.mo32946sG(5);
        aVar8.mo32945iM(true);
        arrayList.add(aVar8);
        C7970a aVar9 = new C7970a(R.drawable.iap_vip_icon_privilege_key_frame, C7825a.KEY_FRAME.getId(), dVar.mo32861lw("key_frame_title"), dVar.mo32861lw("key_frame_des"));
        aVar9.mo32946sG(6);
        aVar9.mo32945iM(true);
        arrayList.add(aVar9);
        C7970a aVar10 = new C7970a(R.drawable.iap_vip_icon_privilege_audio_extract, C7825a.AUDIO_EXTRA.getId(), dVar.mo32861lw("audio_extract_title"), dVar.mo32861lw("audio_extract_des"));
        aVar10.mo32946sG(7);
        aVar10.mo32945iM(true);
        arrayList.add(aVar10);
        C7970a aVar11 = new C7970a(R.drawable.iap_vip_icon_custom_watermarking, C7825a.USER_WATER_MARK.getId(), dVar.mo32861lw("user_custom_watermark"), (String) null);
        aVar11.mo32946sG(8);
        aVar11.mo32945iM(true);
        arrayList.add(aVar11);
        C7970a aVar12 = new C7970a(R.drawable.iap_vip_icon_adjust_export, C7825a.VIDEO_PARAM_ADJUST.getId(), dVar.mo32861lw("video_adjustment_title"), dVar.mo32861lw("video_adjustment_des"));
        aVar12.mo32946sG(9);
        arrayList.add(aVar12);
        C7970a aVar13 = new C7970a(R.drawable.iap_vip_icon_privilege_custom_bg, 0, C7825a.CUSTOMIZED_BACKGROUND.getId(), dVar.mo32861lw("custom_bg_title"));
        aVar13.mo32946sG(10);
        arrayList.add(aVar13);
        C7970a aVar14 = new C7970a(R.drawable.iap_vip_icon_privilege_material, C7825a.ALL_TEMPLATE.getId(), dVar.mo32861lw("use_paid_material_title"), dVar.mo32861lw("use_paid_material_des"));
        aVar14.mo32946sG(11);
        arrayList.add(aVar14);
        C7970a aVar15 = new C7970a(R.drawable.iap_vip_icon_privilege_changevoice, C7825a.MAGIC_SOUND.getId(), dVar.mo32861lw("magic_sound_title"), dVar.mo32861lw("magic_sound_des"));
        aVar15.mo32946sG(12);
        arrayList.add(aVar15);
        String str = "more_privilege_title";
        if (C8048e.aBe().isInChina()) {
            C7970a aVar16 = new C7970a(R.drawable.iap_vip_icon_privilege_sever, (String) null, dVar.mo32861lw("vip_server_title"), (String) null);
            aVar16.mo32946sG(13);
            arrayList.add(aVar16);
            str = "android_domestic_welfare_gift";
        }
        C7970a aVar17 = new C7970a(R.drawable.iap_vip_icon_privilege_dynamic_caption, C7825a.ANIM_TITLE.getId(), dVar.mo32861lw("animated_text_title"), dVar.mo32861lw("animated_text_des"));
        aVar17.mo32946sG(14);
        arrayList.add(aVar17);
        C7970a aVar18 = new C7970a(R.drawable.iap_vip_icon_privilege_function_more, (String) null, dVar.mo32861lw(str), C8048e.aBe().isInChina() ? dVar.mo32861lw("android_domestic_welfare_gift") : dVar.mo32861lw("more_privilege_title"));
        aVar18.mo32946sG(15);
        arrayList.add(aVar18);
        return arrayList;
    }

    private boolean isHDExportBetaTest() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHDExportBetaTest();
    }

    private boolean isHigherHDExport() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHigherHDExport();
    }

    public Map<String, Object> aDj() {
        Context context = C8048e.aBe().getContext();
        HashMap hashMap = new HashMap();
        hashMap.put("remove_watermark_title", context.getString(R.string.xiaoying_str_vip_item_water_mark_title));
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
        hashMap.put("user_custom_watermark", context.getString(R.string.xiaoying_str_editor_custom_watermark));
        hashMap.put("use_paid_material_title", context.getString(R.string.xiaoying_str_vip_item_all_template_title));
        hashMap.put("use_paid_material_des", context.getString(R.string.xiaoying_str_vip_item_all_template_desc));
        hashMap.put("key_frame_title", context.getString(R.string.xiaoying_str_template_key_frame));
        hashMap.put("key_frame_des", "");
        hashMap.put("audio_extract_title", context.getString(R.string.xiaoying_str_template_audio_extract));
        hashMap.put("audio_extract_des", "");
        hashMap.put("vip_server_title", context.getString(R.string.xiaoying_str_exclusive_vip_customer_service));
        hashMap.put("key_2k_title", context.getString(R.string.viva_publish_2k_item_title));
        hashMap.put("key_4k_title", context.getString(R.string.viva_publish_4k_item_title));
        hashMap.put("more_privilege_title", context.getString(R.string.xiaoying_str_com_more));
        hashMap.put("android_domestic_welfare_gift", context.getString(R.string.xiaoying_str_vip_third_welfare));
        hashMap.put("custom_bg_title", context.getString(R.string.xiaoying_str_vip_item_custom_bg_title));
        hashMap.put("btn_bg_platinum_monthly", Integer.valueOf(context.getResources().getColor(R.color.color_232a4f)));
        hashMap.put("btn_bg_platinum_yearly", Integer.valueOf(context.getResources().getColor(R.color.color_4f5472)));
        hashMap.put("platinum_yearly_text_display", Boolean.valueOf(false));
        hashMap.put("android_premium_platinum_monthly_id", "premium_platinium_monthly_2.49");
        hashMap.put("android_premium_platinum_yearly_id", "premium_platinium_yearly_12.99");
        return hashMap;
    }

    public String aDk() {
        return "android_premium_platinum_monthly_id";
    }

    public String aDl() {
        return "android_premium_platinum_yearly_id";
    }

    public List<C7970a> aDm() {
        List<C7970a> aDJ = aDJ();
        if (this.type == 0) {
            return aDJ;
        }
        C7970a aVar = null;
        if (!aDJ.isEmpty()) {
            aVar = (C7970a) aDJ.get(aDJ.size() - 1);
        }
        if (aDJ.size() >= 11) {
            aDJ = aDJ.subList(0, 11);
        }
        if (aVar != null) {
            aDJ.add(aVar);
        }
        return aDJ;
    }

    public String aDr() {
        return "subscription_new_page_monthly_discount";
    }

    public String aDs() {
        return "subscription_new_page_yearly_discount";
    }
}
