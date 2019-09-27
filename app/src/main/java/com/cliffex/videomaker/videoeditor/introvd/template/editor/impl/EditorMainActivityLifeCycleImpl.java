package com.introvd.template.editor.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.homepage.C3935b.C3941a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.social.PublishTaskTable;
import com.introvd.template.editor.common.p249c.C5845b;
import com.introvd.template.editor.effects.nav.C6184a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p251d.C5874c;
import com.introvd.template.editor.p251d.C5877f;
import com.introvd.template.editor.p252e.C5879b;
import com.introvd.template.editor.p266h.C6371a;
import com.introvd.template.editor.p266h.C6373b;
import com.introvd.template.editor.p266h.C6389f;
import com.introvd.template.editor.p266h.C6391g;
import com.introvd.template.editor.p266h.C6412q;
import com.introvd.template.editor.preview.clipsort.C6562b;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.router.lifecycle.BaseMainActivityLifeCycle;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.data.C8657a;
import com.introvd.template.template.data.C8674c;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2570b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/XYVideoEditor/MainActLifeCycle")
public class EditorMainActivityLifeCycleImpl extends BaseMainActivityLifeCycle {
    private C1494a compositeDisposable;
    private C5845b themeSilentCenter;

    /* access modifiers changed from: private */
    public void createMultilevelDirectory() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("Templates/push");
        FileUtils.createMultilevelDirectory(sb.toString());
    }

    /* access modifiers changed from: private */
    public void deleteFunnyPrjFile(Context context) {
        C8468c aIQ = C8468c.aIQ();
        if (!aIQ.aHb()) {
            aIQ.mo33874S(context, false);
        }
        List aHh = aIQ.aHh();
        if (aHh != null && aHh.size() > 0) {
            Iterator it = new ArrayList(aHh).iterator();
            while (it.hasNext()) {
                C8467b bVar = (C8467b) it.next();
                if (bVar.mProjectDataItem != null && C8451b.m24480uq(bVar.mProjectDataItem.prjThemeType) && PublishTaskTable.getPublishTaskInfoByPrjUrl(context, bVar.mProjectDataItem.strPrjURL) == null) {
                    C8468c.aIQ().mo33875a(context, bVar.mProjectDataItem.strPrjURL, 3, true);
                }
            }
        }
    }

    private void deleteTemplate() {
        C3935b.m9679Lb().mo23482a((Context) getActivity(), (C3941a) new C3941a() {
            /* renamed from: bu */
            public void mo23296bu(boolean z) {
                if (z) {
                    C1820a.aVi().mo10058o(new Runnable() {
                        public void run() {
                            C8745n.m25558cM(EditorMainActivityLifeCycleImpl.this.getActivity(), "18041916205151");
                            List<AppModelConfigInfo> Lh = C3935b.m9679Lb().mo23478Lh();
                            if (Lh != null && Lh.size() > 0) {
                                for (AppModelConfigInfo appModelConfigInfo : Lh) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(appModelConfigInfo.eventContent);
                                        int optInt = jSONObject.optInt("type");
                                        String string = jSONObject.getString("ttid");
                                        if (optInt == 1) {
                                            C8745n.m25558cM(EditorMainActivityLifeCycleImpl.this.getActivity(), string);
                                        } else if (optInt == 2) {
                                            C8762d.aMt().mo35242qG(C8762d.aMt().mo35225bB(Long.decode(string).longValue()));
                                        } else if (optInt == 3) {
                                            C8682a aKt = C8688b.aKs().aKt();
                                            List<DBTemplateAudioInfo> ZY = aKt.mo35005ZY();
                                            if (ZY != null && ZY.size() > 0) {
                                                for (DBTemplateAudioInfo dBTemplateAudioInfo : ZY) {
                                                    if (!(dBTemplateAudioInfo == null || dBTemplateAudioInfo.index == null || !dBTemplateAudioInfo.index.equals(string))) {
                                                        String jv = C7213f.m21302jv(dBTemplateAudioInfo.audioUrl);
                                                        aKt.mo35009pb(dBTemplateAudioInfo.index);
                                                        File file = new File(jv);
                                                        if (file.exists()) {
                                                            file.delete();
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (optInt == 4) {
                                            C8657a.m25213ct(EditorMainActivityLifeCycleImpl.this.getActivity(), string);
                                        }
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("name", string);
                                        UserBehaviorLog.onKVEvent(EditorMainActivityLifeCycleImpl.this.getActivity(), "Temaplate_Delete_downloaded", hashMap);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void onCreate() {
        int i;
        super.onCreate();
        C8501a.aJs().mo34667eg(C4582c.m11667dD(VivaBaseApplication.m8749FZ()));
        C8567u.setContext(getActivity().getApplicationContext());
        C8553i.setContext(getActivity().getApplicationContext());
        C8553i.m25005ut(4);
        LogUtilsV2.m14227d("onCreate");
        this.compositeDisposable = new C1494a();
        C8522g aJA = C8522g.aJA();
        if (aJA != null) {
            aJA.init(getActivity().getApplicationContext());
            i = aJA.getCount();
        } else {
            i = 0;
        }
        try {
            new C6412q().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (C4596h.m11721Su()) {
            C5554b.m15027aH(VivaBaseApplication.m8749FZ(), "HD_Export_Crash");
            C4596h.m11720St();
        }
        C8674c.aKn();
        C6391g.m18384fR(VivaBaseApplication.m8749FZ());
        C8400d.edj = Boolean.valueOf(C3742b.m9111II().mo23127IU());
        C6371a.m18320at(getActivity());
        C6389f.init();
        deleteTemplate();
        C2570b.m7333ai(VivaBaseApplication.m8749FZ()).mo11911tF().mo12164b(C6184a.class, Bitmap.class, (ModelLoaderFactory<Model, Data>) new C5877f<Model,Data>());
        C2570b.m7333ai(VivaBaseApplication.m8749FZ()).mo11911tF().mo12164b(C6562b.class, Bitmap.class, (ModelLoaderFactory<Model, Data>) new C5874c<Model,Data>());
        ProjectScanService.m19507fm(VivaBaseApplication.m8749FZ());
        C5554b.m15010V(VivaBaseApplication.m8749FZ(), i);
        C6373b.m18333fz(VivaBaseApplication.m8749FZ());
        C5554b.m15034eu(VivaBaseApplication.m8749FZ());
        C1495b o = C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                EditorMainActivityLifeCycleImpl.this.createMultilevelDirectory();
            }
        });
        C1495b o2 = C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                EditorMainActivityLifeCycleImpl.this.deleteFunnyPrjFile(EditorMainActivityLifeCycleImpl.this.getActivity());
            }
        });
        this.compositeDisposable.mo9785e(o);
        this.compositeDisposable.mo9785e(o2);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        C5879b.ani();
        C8522g.aJA().uninit();
        C8468c.aIQ().uninit();
        C8501a.aJs().unInit();
        if (this.themeSilentCenter != null) {
            this.themeSilentCenter.release();
        }
    }

    public void onResume() {
        super.onResume();
        if (C3742b.m9111II().mo23140JH()) {
            if (this.themeSilentCenter == null) {
                this.themeSilentCenter = new C5845b(getActivity().getApplicationContext(), C8399c.ecX);
            }
            this.themeSilentCenter.ahv();
        }
    }
}
