package com.introvd.template.template.p408f;

import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.RollIconInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.RollXytInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.f.a */
public class C8746a {
    public static volatile ArrayList<StoryBoardItemInfo> etx;

    /* renamed from: a */
    public static int m25564a(long j, List<StyleCatItemModel> list, Map<String, List<Long>> map) {
        if (map == null || map.isEmpty() || list == null || list.isEmpty()) {
            return -1;
        }
        ArrayList<StyleCatItemModel> arrayList = new ArrayList<>(list);
        for (StyleCatItemModel styleCatItemModel : arrayList) {
            if (styleCatItemModel != null) {
                List list2 = (List) map.get(styleCatItemModel.ttid);
                if (list2 != null && list2.size() > 0 && list2.contains(Long.valueOf(j))) {
                    return arrayList.indexOf(styleCatItemModel);
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String m25565a(List<TemplatePackageInfo> list, String str, String str2) {
        TemplatePackageInfo e = C8742k.aMi().mo35179e(list, str);
        return e != null ? e.strIcon : str2;
    }

    /* renamed from: a */
    public static List<StyleCatItemModel> m25566a(List<TemplateInfo> list, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                TemplateInfo templateInfo = (TemplateInfo) list.get(i);
                if (templateInfo instanceof RollInfo) {
                    RollInfo rollInfo = (RollInfo) templateInfo;
                    if (rollInfo.rollModel != null && !"20171207865423".equals(templateInfo.ttid) && !"20160224184948".equals(templateInfo.ttid) && !"20160224184733".equals(templateInfo.ttid)) {
                        if (z) {
                            if (!rollInfo.rollModel.isAnimSubType()) {
                            }
                        } else if (!rollInfo.rollModel.isAnimSubType()) {
                            if (!z2 && rollInfo.rollModel.isCombineSubType()) {
                            }
                        }
                        String str = rollInfo.rollModel.rollCode;
                        if ((!z3 || rollInfo.isRecommendItem() || C8745n.m25561qv(str)) && (!z4 || !isNeedToPurchase(str))) {
                            StyleCatItemModel styleCatItemModel = new StyleCatItemModel(1, str);
                            if (!arrayList.contains(styleCatItemModel)) {
                                styleCatItemModel.strPath = templateInfo.strIcon;
                                styleCatItemModel.name = rollInfo.strTitle;
                                arrayList.add(styleCatItemModel);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m25567a(ArrayList<StoryBoardItemInfo> arrayList, List<TemplateInfo> list, List<TemplateInfo> list2, String str) {
        TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{list2, list});
        if (a != null && (a instanceof RollInfo)) {
            RollIconInfo rollIconInfo = ((RollInfo) a).rollModel.mRollIconInfo;
            if (rollIconInfo != null && rollIconInfo.mXytList != null) {
                for (RollXytInfo rollXytInfo : rollIconInfo.mXytList) {
                    StoryBoardXytItemInfo storyBoardXytItemInfo = new StoryBoardXytItemInfo();
                    storyBoardXytItemInfo.mThumbPath = rollXytInfo.mXytIconUrl;
                    storyBoardXytItemInfo.isVideo = false;
                    storyBoardXytItemInfo.lDuration = 0;
                    arrayList.add(storyBoardXytItemInfo);
                }
            }
        }
    }

    /* renamed from: b */
    public static List<StyleCatItemModel> m25568b(List<TemplateInfo> list, boolean z, boolean z2) {
        return m25566a(list, false, true, z, z2);
    }

    /* renamed from: c */
    public static List<StyleCatItemModel> m25569c(List<TemplateInfo> list, boolean z, boolean z2) {
        return m25566a(list, true, false, z, z2);
    }

    /* renamed from: c */
    public static void m25570c(Map<String, List<Long>> map, String str) {
        if (map != null && !"20160224184948".equals(str) && !"20160224184733".equals(str) && !"20171207865423".equals(str)) {
            if (C8745n.m25561qv(str)) {
                map.put(str, C8745n.m25562qw(str));
            } else {
                map.put(str, new ArrayList());
            }
        }
    }

    private static boolean isNeedToPurchase(String str) {
        if (!C8739i.isNeedToPurchase(str)) {
            return false;
        }
        return C8745n.isAnimSubtitleRollcode(str) ? !C8072q.aBx().mo33072ku(C7825a.ANIM_TITLE.getId()) : C8049f.aBf().mo33101iL(str);
    }
}
