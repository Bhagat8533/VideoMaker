package com.introvd.template.template.p407e;

import android.text.TextUtils;
import com.introvd.template.common.Constants;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

/* renamed from: com.introvd.template.template.e.g */
public class C8736g {
    private static C8736g etd;
    private List<C8737a> esK = Collections.synchronizedList(new ArrayList());
    private List<TemplateItemData> etc = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.introvd.template.template.e.g$a */
    public static class C8737a {
        public ArrayList<TemplateItemData> childList = new ArrayList<>();
        public boolean showGroup = true;
        public boolean showList = false;
        public String strGroupDisplayName;
    }

    private C8736g() {
    }

    public static synchronized C8736g aMg() {
        C8736g gVar;
        synchronized (C8736g.class) {
            if (etd == null) {
                etd = new C8736g();
            }
            gVar = etd;
        }
        return gVar;
    }

    private synchronized void aMh() {
        boolean z;
        this.esK.clear();
        String str = "";
        HashMap hashMap = new HashMap();
        int i = 0;
        if (this.etc == null || this.etc.size() <= 0) {
            z = false;
        } else {
            TemplateItemData templateItemData = (TemplateItemData) this.etc.get(0);
            if (templateItemData != null) {
                str = String.valueOf(QTemplateIDUtils.getTemplateType(templateItemData.lID));
                z = C8733e.m25463qg(str);
            } else {
                z = false;
            }
            int i2 = 0;
            for (TemplateItemData templateItemData2 : this.etc) {
                if (!hashMap.containsValue(templateItemData2.strSceneCode)) {
                    hashMap.put(Integer.valueOf(i2), templateItemData2.strSceneCode);
                    i2++;
                }
            }
        }
        if (hashMap.size() != 0) {
            int c = C8450a.m24471c(Constants.getLocale());
            if (z) {
                while (i < hashMap.size()) {
                    String str2 = "";
                    C8737a aVar = new C8737a();
                    aVar.showGroup = z;
                    aVar.showList = C8733e.m25464qh(str);
                    String str3 = (String) hashMap.get(Integer.valueOf(i));
                    aVar.strGroupDisplayName = str2;
                    for (TemplateItemData templateItemData3 : this.etc) {
                        if (!TextUtils.isEmpty(str3) && str3.equals(templateItemData3.strSceneCode)) {
                            templateItemData3.strSceneName = str2;
                            templateItemData3.strTitle = C8762d.aMt().mo35237d(templateItemData3.strPath, templateItemData3.strTitleJSON, c);
                            aVar.childList.add(templateItemData3);
                            if (TextUtils.isEmpty(aVar.strGroupDisplayName)) {
                                aVar.strGroupDisplayName = templateItemData3.strScene;
                            }
                        } else if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(templateItemData3.strSceneCode)) {
                            templateItemData3.strSceneName = str2;
                            templateItemData3.strTitle = C8762d.aMt().mo35237d(templateItemData3.strPath, templateItemData3.strTitleJSON, c);
                            aVar.childList.add(templateItemData3);
                            if (TextUtils.isEmpty(aVar.strGroupDisplayName)) {
                                aVar.strGroupDisplayName = templateItemData3.strScene;
                            }
                        }
                    }
                    this.esK.add(aVar);
                    i++;
                }
            } else {
                C8737a aVar2 = new C8737a();
                aVar2.showGroup = z;
                aVar2.showList = C8733e.m25464qh(str);
                aVar2.strGroupDisplayName = str;
                while (i < hashMap.size()) {
                    String str4 = "";
                    String str5 = (String) hashMap.get(Integer.valueOf(i));
                    for (TemplateItemData templateItemData4 : this.etc) {
                        if (!TextUtils.isEmpty(str5) && str5.equals(templateItemData4.strSceneCode)) {
                            templateItemData4.strSceneName = str4;
                            templateItemData4.strTitle = C8762d.aMt().mo35237d(templateItemData4.strPath, templateItemData4.strTitleJSON, c);
                            aVar2.childList.add(templateItemData4);
                            if (TextUtils.isEmpty(aVar2.strGroupDisplayName)) {
                                aVar2.strGroupDisplayName = templateItemData4.strScene;
                            }
                        } else if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(templateItemData4.strSceneCode)) {
                            templateItemData4.strSceneName = str4;
                            templateItemData4.strTitle = C8762d.aMt().mo35237d(templateItemData4.strPath, templateItemData4.strTitleJSON, c);
                            aVar2.childList.add(templateItemData4);
                            if (TextUtils.isEmpty(aVar2.strGroupDisplayName)) {
                                aVar2.strGroupDisplayName = templateItemData4.strScene;
                            }
                        }
                    }
                    i++;
                }
                this.esK.add(aVar2);
            }
            this.etc.clear();
            for (C8737a aVar3 : this.esK) {
                this.etc.addAll(aVar3.childList);
            }
        }
    }

    public synchronized List<TemplateItemData> aMe() {
        return this.etc;
    }

    /* renamed from: ay */
    public synchronized void mo35159ay(List<TemplateItemData> list) {
        this.etc.clear();
        for (TemplateItemData templateItemData : list) {
            TemplateItemData bD = C8762d.aMt().mo35227bD(templateItemData.lID);
            if (bD != null && !bD.shouldOnlineDownload()) {
                this.etc.add(templateItemData);
            }
        }
        aMh();
    }

    /* renamed from: dQ */
    public synchronized int mo35160dQ(int i, int i2) {
        int i3;
        i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += mo35162vc(i4);
        }
        return i3 + i2;
    }

    public synchronized int getGroupCount() {
        return this.esK.size();
    }

    /* renamed from: vc */
    public synchronized int mo35162vc(int i) {
        if (i >= 0) {
            if (i < this.esK.size()) {
                return ((C8737a) this.esK.get(i)).childList.size();
            }
        }
        return 0;
    }

    /* renamed from: vg */
    public synchronized C8737a mo35163vg(int i) {
        if (i >= 0) {
            if (i < this.esK.size()) {
                return (C8737a) this.esK.get(i);
            }
        }
        return null;
    }
}
