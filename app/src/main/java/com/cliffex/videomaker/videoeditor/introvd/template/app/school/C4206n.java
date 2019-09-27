package com.introvd.template.app.school;

import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.CommodityInfo;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.api.model.TemplateListResult;
import com.introvd.template.app.school.api.model.UserInfo;
import com.introvd.template.app.school.api.model.VideoLabelInfoResult;
import com.introvd.template.app.school.p196b.C4164d;
import com.introvd.template.app.school.p196b.C4165e;
import com.introvd.template.app.school.p198db.C4175a;
import com.introvd.template.app.school.p198db.template.C4184a;
import com.introvd.template.app.school.p198db.template.TemplateItemInfo;
import com.introvd.template.common.filecache.FileCacheV2;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.school.n */
public class C4206n {
    private static C4206n bxu;
    /* access modifiers changed from: private */
    public FileCacheV2<VideoLabelInfoResult> bxv = new Builder((Context) VivaBaseApplication.m8749FZ(), "TemplateVideoLabel", VideoLabelInfoResult.class).build();
    /* access modifiers changed from: private */
    public LongSparseArray<List<TemplateInfo>> bxw = new LongSparseArray<>();

    private C4206n() {
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m10503B(long j) {
        C4184a NY = C4175a.m10395NW().mo24016NY();
        if (NY != null) {
            NY.mo24148E(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public List<TemplateInfo> m10504C(long j) {
        C4184a NY = C4175a.m10395NW().mo24016NY();
        if (NY == null) {
            return null;
        }
        List<TemplateItemInfo> D = NY.mo24147D(j);
        if (D == null || D.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TemplateItemInfo a : D) {
            arrayList.add(m10507a(a));
        }
        return arrayList;
    }

    /* renamed from: NL */
    public static C4206n m10505NL() {
        if (bxu == null) {
            synchronized (C4206n.class) {
                if (bxu == null) {
                    bxu = new C4206n();
                }
            }
        }
        return bxu;
    }

    /* access modifiers changed from: private */
    /* renamed from: NN */
    public void m10506NN() {
        this.bxv.getCache().mo10149b((C1842q<? super T>) new C1842q<VideoLabelInfoResult>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: a */
            public void mo9886K(VideoLabelInfoResult videoLabelInfoResult) {
                C10021c.aZH().mo38492aA(new C4164d(videoLabelInfoResult.list));
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: a */
    private TemplateInfo m10507a(TemplateItemInfo templateItemInfo) {
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.setId(Long.valueOf(templateItemInfo.getId()));
        templateInfo.setTtid(templateItemInfo.getTtid());
        templateInfo.setVer(Long.valueOf(templateItemInfo.getVer()));
        templateInfo.setUseCount(Long.valueOf(templateItemInfo.getUseCount()));
        templateInfo.setTitle(templateItemInfo.getTitle());
        templateInfo.setDescription(templateItemInfo.getDescription());
        templateInfo.setCoverUrl(templateItemInfo.getCoverUrl());
        templateInfo.setVideoUrl(templateItemInfo.getVideoUrl());
        templateInfo.setWidth(templateItemInfo.getWidth());
        templateInfo.setHeight(templateItemInfo.getHeight());
        templateInfo.setState(Integer.valueOf(templateItemInfo.getState()));
        templateInfo.setTemplateUrl(templateItemInfo.getTemplateUrl());
        templateInfo.setEventCode(templateItemInfo.getEventCode());
        templateInfo.setEventContent(templateItemInfo.getEventContent());
        templateInfo.setAuiddigest(templateItemInfo.getAuiddigest());
        templateInfo.setVip(templateItemInfo.getIsVip());
        templateInfo.setCountry(templateItemInfo.getCountry());
        templateInfo.setPlatform(Integer.valueOf(templateItemInfo.getPlatform()));
        templateInfo.setChannel(templateItemInfo.getChannel());
        templateInfo.setFlag(Integer.valueOf(templateItemInfo.getFlag()));
        if (!TextUtils.isEmpty(templateItemInfo.getCommodityInfo())) {
            templateInfo.setCommodityInfo((CommodityInfo) new Gson().fromJson(templateItemInfo.getCommodityInfo(), CommodityInfo.class));
        }
        if (!TextUtils.isEmpty(templateItemInfo.getUserInfo())) {
            templateInfo.setUserInfo((UserInfo) new Gson().fromJson(templateItemInfo.getUserInfo(), UserInfo.class));
        }
        return templateInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10509a(long j, TemplateInfo templateInfo) {
        C4184a NY = C4175a.m10395NW().mo24016NY();
        if (NY != null) {
            TemplateItemInfo templateItemInfo = new TemplateItemInfo();
            templateItemInfo.labelId = j;
            templateItemInfo.f3391id = templateInfo.getId().longValue();
            templateItemInfo.ttid = templateInfo.getTtid();
            templateItemInfo.ver = templateInfo.getVer().longValue();
            templateItemInfo.useCount = templateInfo.getUseCount().longValue();
            templateItemInfo.title = templateInfo.getTitle();
            templateItemInfo.description = templateInfo.getDescription();
            templateItemInfo.coverUrl = templateInfo.getCoverUrl();
            templateItemInfo.videoUrl = templateInfo.getVideoUrl();
            templateItemInfo.width = templateInfo.getWidth();
            templateItemInfo.height = templateInfo.getHeight();
            templateItemInfo.state = templateInfo.getState().intValue();
            templateItemInfo.templateUrl = templateInfo.getTemplateUrl();
            templateItemInfo.eventCode = templateInfo.getEventCode();
            templateItemInfo.eventContent = templateInfo.getEventContent();
            templateItemInfo.auiddigest = templateInfo.getAuiddigest();
            templateItemInfo.isVip = templateInfo.isVip();
            templateItemInfo.country = templateInfo.getCountry();
            templateItemInfo.platform = templateInfo.getPlatform().intValue();
            templateItemInfo.channel = templateInfo.getChannel();
            templateItemInfo.flag = templateInfo.getFlag().intValue();
            templateItemInfo.commodityInfo = new Gson().toJson((Object) templateInfo.getCommodityInfo());
            templateItemInfo.userInfo = new Gson().toJson((Object) templateInfo.getUserInfo());
            NY.mo24064O(templateItemInfo);
        }
    }

    /* renamed from: A */
    public List<TemplateInfo> mo24168A(long j) {
        return (List) this.bxw.get(j);
    }

    /* renamed from: NM */
    public void mo24169NM() {
        C4153h.m10353NP().mo10196g(C1820a.aVi()).mo10192bU(2).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<VideoLabelInfoResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<VideoLabelInfoResult> commonResponseResult) {
                C10021c.aZH().mo38492aA(new C4164d(((VideoLabelInfoResult) commonResponseResult.data).list));
                C4206n.this.bxv.saveCache(commonResponseResult.data);
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C4206n.this.m10506NN();
            }
        });
    }

    /* renamed from: b */
    public void mo24170b(final long j, final int i) {
        C4153h.m10355a(j, 20, i).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<TemplateListResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<TemplateListResult> commonResponseResult) {
                List list;
                if (commonResponseResult.success) {
                    if (C4206n.this.bxw.get(j) == null || i == 1) {
                        list = ((TemplateListResult) commonResponseResult.data).getList();
                        C4206n.this.bxw.put(j, list);
                    } else {
                        list = (List) C4206n.this.bxw.get(j);
                    }
                    C10021c.aZH().mo38492aA(new C4165e(j, i, list));
                    if (i == 1) {
                        C4206n.this.m10503B(j);
                        for (TemplateInfo a : ((TemplateListResult) commonResponseResult.data).getList()) {
                            C4206n.this.m10509a(j, a);
                        }
                    }
                } else if (i == 1) {
                    List b = C4206n.this.m10504C(j);
                    if (b != null) {
                        C4206n.this.bxw.put(j, b);
                        C10021c.aZH().mo38492aA(new C4165e(j, i, b));
                    }
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                if (i == 1) {
                    List b = C4206n.this.m10504C(j);
                    if (b != null) {
                        C4206n.this.bxw.put(j, b);
                        C10021c.aZH().mo38492aA(new C4165e(j, i, b));
                    }
                }
            }
        });
    }
}
