package com.introvd.template.app.school;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4147b;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.api.model.TemplateListResult;
import com.introvd.template.app.school.api.model.TutorialVideoLabelResult;
import com.introvd.template.app.school.api.model.VideoInfo;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.api.model.VideoListResult;
import com.introvd.template.app.school.p196b.C4161a;
import com.introvd.template.app.school.p196b.C4162b;
import com.introvd.template.app.school.p196b.C4163c;
import com.introvd.template.app.school.p196b.C4166f;
import com.introvd.template.app.school.p196b.C4168h;
import com.introvd.template.app.school.p198db.C4175a;
import com.introvd.template.app.school.p198db.classes.C4179b;
import com.introvd.template.app.school.p198db.classes.DBClassInfo;
import com.introvd.template.common.filecache.FileCacheV2;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.community.svip.ISvipAPI;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.C10021c;
import org.json.JSONObject;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.school.j */
public class C4191j {
    private static volatile C4191j bxb;
    /* access modifiers changed from: private */
    public FileCacheV2<List<VideoLabelInfo>> bxc = new Builder((Context) VivaBaseApplication.m8749FZ(), "SchoolVideoLabel", new TypeToken<List<VideoLabelInfo>>() {
    }.getType()).build();
    /* access modifiers changed from: private */
    public FileCacheV2<TemplateListResult> bxd = new Builder((Context) VivaBaseApplication.m8749FZ(), "SchoolRecTempList", TemplateListResult.class).build();
    /* access modifiers changed from: private */
    public SparseArray<List<VideoInfo>> bxe = new SparseArray<>();
    /* access modifiers changed from: private */
    public String bxf;
    /* access modifiers changed from: private */
    public C4162b bxg = new C4162b();
    /* access modifiers changed from: private */
    public List<SchoolCourseInfo> bxh = new ArrayList();
    private FileCacheV2<List<SchoolCourseInfo>> bxi = new Builder((Context) VivaBaseApplication.m8749FZ(), "SchoolCourseInfo", new TypeToken<List<VideoLabelInfo>>() {
    }.getType()).build();
    private int bxj = -1;
    private String bxk;

    private C4191j() {
    }

    /* access modifiers changed from: private */
    /* renamed from: NB */
    public void m10440NB() {
        this.bxd.getCache().mo10157d(C1820a.aVi()).mo10149b((C1842q<? super T>) new C1842q<TemplateListResult>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: a */
            public void mo9886K(TemplateListResult templateListResult) {
                C4191j.this.bxf = templateListResult.getAllTemUrl();
                C4191j.this.bxg.mo23990bH(true);
                C4191j.this.bxg.mo23991bI(templateListResult.getList().isEmpty());
                C10021c.aZH().mo38492aA(C4191j.this.bxg);
                C10021c.aZH().mo38492aA(new C4163c(templateListResult.getList()));
                C4191j.this.m10456ad(templateListResult.getList());
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C4191j.this.bxg.mo23990bH(true);
                C4191j.this.bxg.mo23991bI(true);
                C10021c.aZH().mo38492aA(C4191j.this.bxg);
            }
        });
    }

    /* renamed from: NF */
    private Map<String, String> m10441NF() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        HashMap hashMap = new HashMap();
        hashMap.put(C5878a.TAG, "0");
        hashMap.put(C7234b.TAG, C4580b.m11635Si());
        hashMap.put("c", AppStateModel.getInstance().getCountryCode());
        hashMap.put("d", String.valueOf(125));
        String dz = C4580b.m11653dz(FZ);
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        String userId = UserServiceProxy.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        return hashMap;
    }

    /* renamed from: Nv */
    public static C4191j m10442Nv() {
        if (bxb == null) {
            synchronized (C4191j.class) {
                if (bxb == null) {
                    bxb = new C4191j();
                }
            }
        }
        return bxb;
    }

    /* access modifiers changed from: private */
    /* renamed from: Nx */
    public void m10443Nx() {
        this.bxc.getCache().mo10157d(C1820a.aVi()).mo10149b((C1842q<? super T>) new C1842q<List<VideoLabelInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<VideoLabelInfo> list) {
                C4191j.this.m10455ac(list);
                C4191j.this.bxg.mo23992bJ(true);
                C4191j.this.bxg.mo23993bK(list.isEmpty());
                C10021c.aZH().mo38492aA(C4191j.this.bxg);
                C10021c.aZH().mo38492aA(new C4168h(list));
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C4191j.this.bxg.mo23992bJ(true);
                C4191j.this.bxg.mo23993bK(true);
                C10021c.aZH().mo38492aA(C4191j.this.bxg);
            }
        });
    }

    /* renamed from: a */
    private JsonElement m10444a(JsonObject jsonObject, String str) {
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.get(str);
    }

    /* renamed from: a */
    private VideoInfo m10445a(DBClassInfo dBClassInfo) {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setItemKey(1);
        videoInfo.setPuid(Long.valueOf(dBClassInfo.puid));
        videoInfo.setVer(Integer.valueOf(dBClassInfo.ver));
        videoInfo.setAuid(Long.valueOf(dBClassInfo.auid));
        videoInfo.setExtend(dBClassInfo.extend);
        videoInfo.setDescrip(dBClassInfo.desc);
        videoInfo.setAyid(Integer.valueOf(dBClassInfo.ayid));
        videoInfo.setUseCount(Integer.valueOf(dBClassInfo.useCount));
        videoInfo.setTitle(dBClassInfo.title);
        videoInfo.setUserName(dBClassInfo.userName);
        videoInfo.setStudiograde(Integer.valueOf(dBClassInfo.studioGrade));
        videoInfo.setCoverUrl(dBClassInfo.coverUrl);
        videoInfo.setVideoUrl(dBClassInfo.videoUrl);
        videoInfo.setLogoUrl(dBClassInfo.logoUrl);
        videoInfo.setWebUrl(dBClassInfo.webUrl);
        if (!TextUtils.isEmpty(dBClassInfo.keywordsJson)) {
            videoInfo.setKeywordList((List) new Gson().fromJson(dBClassInfo.keywordsJson, new TypeToken<List<String>>() {
            }.getType()));
        }
        return videoInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10449a(int i, int i2, int i3, List<VideoInfo> list) {
        if (list != null) {
            C10021c.aZH().mo38492aA(new C4166f(i, list, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10450a(int i, VideoInfo videoInfo) {
        C4179b NX = C4175a.m10395NW().mo24015NX();
        if (NX != null) {
            DBClassInfo dBClassInfo = new DBClassInfo();
            dBClassInfo.labelId = (long) i;
            dBClassInfo.puid = videoInfo.getPuid().longValue();
            dBClassInfo.ver = videoInfo.getVer().intValue();
            dBClassInfo.auid = videoInfo.getAuid().longValue();
            dBClassInfo.extend = videoInfo.getExtend();
            dBClassInfo.desc = videoInfo.getDescrip();
            dBClassInfo.ayid = videoInfo.getAyid().intValue();
            dBClassInfo.useCount = videoInfo.getUseCount().intValue();
            dBClassInfo.title = videoInfo.getTitle();
            dBClassInfo.userName = videoInfo.getUserName();
            dBClassInfo.studioGrade = videoInfo.getStudiograde().intValue();
            dBClassInfo.coverUrl = videoInfo.getCoverUrl();
            dBClassInfo.videoUrl = videoInfo.getVideoUrl();
            dBClassInfo.logoUrl = videoInfo.getLogoUrl();
            dBClassInfo.keywordsJson = new Gson().toJson((Object) videoInfo.getKeywordList());
            dBClassInfo.webUrl = videoInfo.getWebUrl();
            NX.mo24064O(dBClassInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ac */
    public void m10455ac(List<VideoLabelInfo> list) {
        if (this.bxj == -1 && !list.isEmpty()) {
            this.bxj = ((VideoLabelInfo) list.get(0)).getId().intValue();
        }
        for (VideoLabelInfo videoLabelInfo : list) {
            videoLabelInfo.isSelectedField().set(Boolean.valueOf(videoLabelInfo.getId().intValue() == this.bxj));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ad */
    public void m10456ad(List<TemplateInfo> list) {
        if (list != null && !list.isEmpty()) {
            ISvipAPI iSvipAPI = (ISvipAPI) C1919a.m5529sc().mo10356i(ISvipAPI.class);
            if (iSvipAPI != null) {
                for (TemplateInfo templateInfo : list) {
                    iSvipAPI.saveCommodityInfo(templateInfo.getTtid(), templateInfo.getAuiddigest(), new Gson().toJson((Object) templateInfo.getCommodityInfo()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<SchoolCourseInfo> m10465f(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList();
        if (jsonObject == null) {
            return arrayList;
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray(String.valueOf(125));
        if (asJsonArray == null) {
            return arrayList;
        }
        int i = 0;
        while (i < asJsonArray.size()) {
            try {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    JsonElement a = m10444a(asJsonObject, "title");
                    String asString = a != null ? a.getAsString() : "";
                    JsonElement a2 = m10444a(asJsonObject, "desc");
                    String asString2 = a2 != null ? a2.getAsString() : "";
                    JsonElement a3 = m10444a(asJsonObject, "content");
                    String asString3 = a3 != null ? a3.getAsString() : "";
                    JsonElement a4 = m10444a(asJsonObject, SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE);
                    int asInt = a4 != null ? a4.getAsInt() : 0;
                    JsonElement a5 = m10444a(asJsonObject, SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT);
                    String asString4 = a5 != null ? a5.getAsString() : "";
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = asInt;
                    tODOParamModel.mJsonParam = asString4;
                    SchoolCourseInfo schoolCourseInfo = new SchoolCourseInfo();
                    schoolCourseInfo.setCoverUrl(asString3);
                    schoolCourseInfo.setTitle(asString);
                    schoolCourseInfo.setDesc(asString2);
                    schoolCourseInfo.setTodoParamModel(tODOParamModel);
                    if (asInt == 943) {
                        schoolCourseInfo.setAuid(new JSONObject(asString4).optString("auid", ""));
                    }
                    arrayList.add(schoolCourseInfo);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: hl */
    public void m10466hl(int i) {
        C4179b NX = C4175a.m10395NW().mo24015NX();
        if (NX != null) {
            NX.mo24067ho(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hm */
    public List<VideoInfo> m10467hm(int i) {
        C4179b NX = C4175a.m10395NW().mo24015NX();
        if (NX == null) {
            return null;
        }
        List<DBClassInfo> hn = NX.mo24066hn(i);
        if (hn == null || hn.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DBClassInfo a : hn) {
            arrayList.add(m10445a(a));
        }
        return arrayList;
    }

    /* renamed from: NA */
    public void mo24151NA() {
        C4153h.m10354NQ().mo10196g(C1820a.aVi()).mo10192bU(3).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<TemplateListResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<TemplateListResult> commonResponseResult) {
                if (commonResponseResult.success) {
                    C4191j.this.bxf = ((TemplateListResult) commonResponseResult.data).getAllTemUrl();
                    C10021c.aZH().mo38492aA(new C4163c(((TemplateListResult) commonResponseResult.data).getList()));
                    C4191j.this.bxg.mo23990bH(true);
                    C4191j.this.bxg.mo23991bI(((TemplateListResult) commonResponseResult.data).getList().isEmpty());
                    C10021c.aZH().mo38492aA(C4191j.this.bxg);
                    C4191j.this.m10456ad(((TemplateListResult) commonResponseResult.data).getList());
                    C4191j.this.bxd.saveCache(commonResponseResult.data);
                    return;
                }
                C4191j.this.m10440NB();
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C4191j.this.m10440NB();
            }
        });
    }

    /* renamed from: NC */
    public void mo24152NC() {
        this.bxi.getCache().mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<SchoolCourseInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<SchoolCourseInfo> list) {
                C4191j.this.bxh = list;
                C10021c.aZH().mo38492aA(new C4161a(list));
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    /* renamed from: ND */
    public void mo24153ND() {
        C3727b.m9087y(m10441NF()).mo10196g(C1820a.aVi()).mo10199i(new C4202k(this)).mo10188a((C1850u<? super T>) new C1850u<List<SchoolCourseInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }

            public void onSuccess(List<SchoolCourseInfo> list) {
                C4191j.this.bxh = list;
                C10021c.aZH().mo38492aA(new C4161a(list));
            }
        });
    }

    /* renamed from: NE */
    public List<SchoolCourseInfo> mo24154NE() {
        return this.bxh;
    }

    /* renamed from: Nw */
    public void mo24155Nw() {
        C4147b.m10336NO().mo10196g(C1820a.aVi()).mo10192bU(3).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<TutorialVideoLabelResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<TutorialVideoLabelResult> commonResponseResult) {
                if (!commonResponseResult.success || commonResponseResult.data == null) {
                    C4191j.this.m10443Nx();
                    return;
                }
                C4191j.this.m10455ac(((TutorialVideoLabelResult) commonResponseResult.data).getList());
                C10021c.aZH().mo38492aA(new C4168h(((TutorialVideoLabelResult) commonResponseResult.data).getList()));
                C4191j.this.bxg.mo23992bJ(true);
                C4191j.this.bxg.mo23993bK(((TutorialVideoLabelResult) commonResponseResult.data).getList().isEmpty());
                C10021c.aZH().mo38492aA(C4191j.this.bxg);
                C4191j.this.bxc.saveCache(((TutorialVideoLabelResult) commonResponseResult.data).getList());
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C4191j.this.m10443Nx();
            }
        });
    }

    /* renamed from: Ny */
    public int mo24156Ny() {
        return this.bxj;
    }

    /* renamed from: Nz */
    public String mo24157Nz() {
        return this.bxk;
    }

    /* renamed from: bG */
    public void mo24158bG(final int i, final int i2) {
        C4147b.m10338a(Integer.valueOf(i), i2, 10).mo10196g(C1820a.aVi()).mo10192bU(3).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<VideoListResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<VideoListResult> commonResponseResult) {
                List list;
                if (commonResponseResult.success) {
                    if (C4191j.this.bxe.get(i) == null || i2 == 1) {
                        list = new ArrayList();
                        for (VideoInfo videoInfo : ((VideoListResult) commonResponseResult.data).getList()) {
                            videoInfo.setItemKey(i2);
                            list.add(videoInfo);
                        }
                        C4191j.this.bxe.put(i, list);
                    } else {
                        list = (List) C4191j.this.bxe.get(i);
                        for (VideoInfo videoInfo2 : ((VideoListResult) commonResponseResult.data).getList()) {
                            videoInfo2.setItemKey(i2);
                            list.add(videoInfo2);
                        }
                    }
                    C4191j.this.m10449a(i, i2, ((VideoListResult) commonResponseResult.data).getCount().intValue(), list);
                    if (i2 == 1) {
                        C4191j.this.m10466hl(i);
                        for (VideoInfo a : ((VideoListResult) commonResponseResult.data).getList()) {
                            C4191j.this.m10450a(i, a);
                        }
                    }
                } else if (i2 == 1) {
                    List b = C4191j.this.m10467hm(i);
                    if (b != null) {
                        C4191j.this.bxe.put(i, b);
                        C4191j.this.m10449a(i, i2, b.size(), b);
                    }
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                if (i2 == 1) {
                    List b = C4191j.this.m10467hm(i);
                    if (b != null) {
                        C4191j.this.bxe.put(i, b);
                        C4191j.this.m10449a(i, i2, b.size(), b);
                    }
                }
            }
        });
    }

    /* renamed from: g */
    public void mo24159g(int i, String str) {
        this.bxj = i;
        this.bxk = str;
    }
}
