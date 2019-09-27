package com.introvd.template.module.iap.business.home;

import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.p359b.C7970a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.module.iap.utils.C8079c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.home.b */
public class C7969b extends C7990j {
    public C7969b(String str) {
        super(str);
    }

    public Map<String, Object> aDj() {
        Map<String, Object> aDj = super.aDj();
        aDj.put("android_domestic_premium_platinum_monthly_id", C8079c.m23444E("vip_normal", 30));
        aDj.put("android_domestic_premium_platinum_yearly_id", C8079c.m23444E("vip_normal", 365));
        return aDj;
    }

    public String aDk() {
        return "android_domestic_premium_platinum_monthly_id";
    }

    public String aDl() {
        return "android_domestic_premium_platinum_yearly_id";
    }

    public List<C7970a> aDm() {
        LogUtils.m14222e("VipNewDataHelper", "getSubFuncList china -------– ");
        C7900d dVar = new C7900d(aDj());
        ArrayList arrayList = new ArrayList();
        if (C7825a.USER_WATER_MARK.getId().equals(this.goodsId)) {
            C7970a aVar = new C7970a(R.drawable.iap_vip_icon_big_custom_watermarking, 0, C7825a.USER_WATER_MARK.getId(), dVar.mo32861lw("user_custom_watermark"));
            aVar.mo32946sG(-1);
            arrayList.add(aVar);
        }
        C7970a aVar2 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_watermark_new, 0, C7825a.WATER_MARK.getId(), dVar.mo32861lw("remove_watermark_title"));
        aVar2.mo32946sG(0);
        arrayList.add(aVar2);
        C7970a aVar3 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_hd_new, C7825a.HD.getId(), dVar.mo32861lw("hd_export_title_android"), dVar.mo32861lw("hd_export_des_android"));
        aVar3.mo32946sG(1);
        if (aDI()) {
            aVar3.mo32948sI(R.drawable.iap_vip_icon_home_item_platinum_4k_new);
        } else if (aDH()) {
            aVar3.mo32948sI(R.drawable.iap_vip_icon_home_item_platinum_2k_new);
        } else if (isHigherHDExport()) {
            aVar3.mo32948sI(R.drawable.iap_vip_icon_home_item_platinum_hd_new);
        } else if (isHDExportBetaTest()) {
            aVar3.mo32948sI(R.drawable.iap_vip_icon_home_item_platinum_hd_new_720);
        }
        arrayList.add(aVar3);
        C7970a aVar4 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_duration_new, 0, C7825a.DURATION_LIMIT.getId(), dVar.mo32861lw("remove_duration_limit_title"));
        aVar4.mo32946sG(2);
        arrayList.add(aVar4);
        C7970a aVar5 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_adjust_new, 0, C7825a.VIDEO_PARAM_ADJUST.getId(), dVar.mo32861lw("video_adjustment_title"));
        aVar5.mo32946sG(3);
        arrayList.add(aVar5);
        C7970a aVar6 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_ad_new, 0, C7825a.AD.getId(), dVar.mo32861lw("remove_ad_title"));
        aVar6.mo32946sG(4);
        arrayList.add(aVar6);
        C7970a aVar7 = new C7970a(R.drawable.iap_vip_bg_home_item_platinum_custom_new, 0, C7825a.CUSTOMIZED_BACKGROUND.getId(), dVar.mo32861lw("custom_bg_title"));
        aVar7.mo32946sG(5);
        arrayList.add(aVar7);
        C7970a aVar8 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_animated_text_new, 0, C7825a.ANIM_TITLE.getId(), dVar.mo32861lw("animated_text_title"));
        aVar8.mo32946sG(6);
        arrayList.add(aVar8);
        C7970a aVar9 = new C7970a(R.drawable.iap_vip_icon_home_item_platinum_mosaic_new, 0, C7825a.MOSAIC.getId(), dVar.mo32861lw("mosaic_title"));
        aVar9.mo32946sG(7);
        arrayList.add(aVar9);
        C7970a aVar10 = new C7970a(R.drawable.iap_vip_icon_home_item_magic_sound_new, 0, C7825a.MAGIC_SOUND.getId(), dVar.mo32861lw("magic_sound_title"));
        aVar10.mo32946sG(8);
        arrayList.add(aVar10);
        C7970a aVar11 = new C7970a(0, C7825a.ALL_TEMPLATE.getId(), dVar.mo32861lw("use_paid_material_title"));
        aVar11.mo32946sG(9);
        arrayList.add(aVar11);
        C7992a aVar12 = new C7992a(0, null, dVar.mo32861lw("android_domestic_welfare_gift"));
        aVar12.mo32946sG(10);
        aVar12.type = 101;
        arrayList.add(aVar12);
        mo32939ck(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ck */
    public void mo32939ck(List<C7970a> list) {
        super.mo32939ck(list);
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            while (true) {
                size--;
                if (size >= list.size()) {
                    break;
                }
                C7970a aVar = (C7970a) list.get(size);
                if ((aVar instanceof C7992a) && ((C7992a) aVar).type == 101) {
                    aVar.mo32947sH(R.drawable.iap_vip_bg_goods_home_item_img3);
                    break;
                }
            }
        }
    }
}
