package com.introvd.template.template;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.router.template.ITemplateService;
import com.introvd.template.router.template.TemplateAPICallback;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.template.p407e.C8715a;
import com.introvd.template.template.p407e.C8715a.C8719d;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONObject;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/TemplateH/ITemplateAPI")
public class TemplateServiceImpl implements ITemplateService {
    private boolean checkXytExist(Context context, List<EffectInfoModel> list) {
        C8762d.aMt().mo35219Q(context, true);
        if (list != null && list.size() > 0) {
            for (EffectInfoModel effectInfoModel : list) {
                if (C8762d.aMt().mo35228bE(effectInfoModel.mTemplateId)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void invalidTemplateRollData(Context context, int i) {
        try {
            C8762d.aMt().mo35240h(-1, (long) i);
            ArrayList<String> arrayList = new ArrayList<>();
            for (Entry entry : C8745n.aMj().entrySet()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (C8762d.aMt().mo35228bE(((Long) it.next()).longValue())) {
                        arrayList.add(entry.getKey());
                        break;
                    }
                }
            }
            for (String cM : arrayList) {
                C8745n.m25558cM(context, cM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkTodoParamXytExist(Context context, TODOParamModel tODOParamModel) {
        boolean z = true;
        if (tODOParamModel == null) {
            return true;
        }
        JSONObject jsonObj = tODOParamModel.getJsonObj();
        int activityFlag = tODOParamModel.getActivityFlag();
        if (tODOParamModel.mTODOCode == 423) {
            Long k = C8460a.m24499k(jsonObj);
            EffectInfoModel effectInfoModel = new EffectInfoModel();
            effectInfoModel.mTemplateId = k.longValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(effectInfoModel);
            z = checkXytExist(context, (List<EffectInfoModel>) arrayList);
        } else if (activityFlag != 0 && C8555k.m25013s(jsonObj) > 0) {
            z = checkXytExist(context, C8555k.m25012r(jsonObj));
        }
        return z;
    }

    public boolean checkXytExist(Context context, long j) {
        EffectInfoModel effectInfoModel = new EffectInfoModel();
        effectInfoModel.mTemplateId = j;
        ArrayList arrayList = new ArrayList();
        arrayList.add(effectInfoModel);
        return checkXytExist(context, (List<EffectInfoModel>) arrayList);
    }

    public void downloadXyt(Context context, long j, String str, final TemplateAPICallback templateAPICallback) {
        new C8715a(context, new C8719d() {
            public void onXytDownloadProgress(long j, int i) {
                if (templateAPICallback != null) {
                    templateAPICallback.onXytDownloadProgress(j, i);
                }
            }

            public void onXytDownloadResult(Long l, boolean z) {
                if (templateAPICallback != null) {
                    templateAPICallback.onXytDownloadResult(l, z);
                }
            }
        }).mo35096k(j, str);
    }

    public void init(Context context) {
    }

    public boolean isAnimSubtitleRollcode(String str) {
        return C8745n.isAnimSubtitleRollcode(str);
    }

    public boolean isNeedToPurchase(String str) {
        return C8739i.isNeedToPurchase(str);
    }

    public void updateRollTemplateMapInfo(final Context context) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C8745n.updateRollTemplateMapInfo(context);
                C8762d.aMt().mo35219Q(context, true);
                TemplateServiceImpl.this.invalidTemplateRollData(context, 9);
                TemplateServiceImpl.this.invalidTemplateRollData(context, 5);
                TemplateServiceImpl.this.invalidTemplateRollData(context, 4);
            }
        });
    }
}
