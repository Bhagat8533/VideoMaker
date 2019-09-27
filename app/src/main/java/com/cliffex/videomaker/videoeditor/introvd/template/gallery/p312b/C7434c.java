package com.introvd.template.gallery.p312b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.joinevent.JoinEventInfo;
import com.introvd.template.common.joinevent.JoinEventUtil;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.FuncExportRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xygallery.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QPoint;

/* renamed from: com.introvd.template.gallery.b.c */
public class C7434c extends BaseController<C7433b> {
    /* access modifiers changed from: private */
    public static final String TAG = "c";
    /* access modifiers changed from: private */
    public C8522g bMM;
    private C8501a bOK;
    private QStoryboard cFJ;
    /* access modifiers changed from: private */
    public String cSn = "";
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private boolean cyM;
    /* access modifiers changed from: private */
    public TODOParamModel cyQ;
    /* access modifiers changed from: private */
    public int dGg;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.gallery.b.c$a */
    private class C7442a implements ViewAdsListener {
        ViewGroup dHA;

        C7442a(ViewGroup viewGroup) {
            this.dHA = viewGroup;
        }

        public void onAdLoaded(final AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            if (z) {
                C1495b o = C1487a.aUa().mo10058o(new Runnable() {
                    public void run() {
                        if (C7442a.this.dHA != null && C7434c.this.getMvpView() != null && !((C7433b) C7434c.this.getMvpView()).getHostActivity().isFinishing()) {
                            View adView = C7680l.aAe().getAdView(((C7433b) C7434c.this.getMvpView()).getHostActivity(), 21);
                            if (!(adView == null || adPositionInfoParam == null)) {
                                C7442a.this.dHA.addView(adView);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", C7591a.m22370W(Integer.valueOf(adPositionInfoParam.providerOrder)));
                                UserBehaviorLog.onKVEvent(C7434c.this.mContext, "Ad_Gallery_Banner_Show", hashMap);
                                C7592b.m22379F(C7434c.this.mContext, "Ad_Gallery_Banner_Show", C7591a.m22370W(Integer.valueOf(adPositionInfoParam.providerOrder)));
                            }
                        }
                    }
                });
                if (C7434c.this.compositeDisposable != null) {
                    C7434c.this.compositeDisposable.mo9785e(o);
                }
            }
        }
    }

    /* renamed from: aB */
    private void m21965aB(long j) {
        if (j <= 0) {
            return;
        }
        if (this.dGg == 2) {
            C8446b.aIZ().mo34319b(this.mContext, j, 3);
        } else {
            C8446b.aIZ().mo34319b(this.mContext, j, 4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aX */
    public synchronized int m21966aX(List<TrimedClipItemDataModel> list) {
        if (list == null) {
            return 0;
        }
        int w = C8540q.m24976w(this.bMM.aHd());
        for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
            if (trimedClipItemDataModel != null) {
                if (trimedClipItemDataModel.isImage.booleanValue()) {
                    String str = trimedClipItemDataModel.mExportPath;
                    if (str != null) {
                        int i = w;
                        for (int i2 = 0; i2 < trimedClipItemDataModel.repeatCount.intValue(); i2++) {
                            if (this.bMM.mo34725a(str, this.bOK, i, 0, ((C7433b) getMvpView()).amA(), trimedClipItemDataModel.mRotate.intValue(), false) == 0) {
                                i++;
                            }
                        }
                        w = i;
                    }
                } else if (this.bMM.mo34724a(trimedClipItemDataModel, this.bOK, w, true) == 0) {
                    w++;
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int abw() {
        ProjectItem ahP = this.bMM.aHf();
        if (ahP == null) {
            return 1;
        }
        this.cFJ = ahP.mStoryBoard;
        return this.cFJ == null ? 1 : 0;
    }

    private void ayZ() {
        this.compositeDisposable.mo9785e(C1848s.m5326ai(Boolean.valueOf(true)).mo10200k(300, TimeUnit.MILLISECONDS).mo10194f(C1820a.aVi()).mo10198h(new C1518f<Boolean, C1852w<Boolean>>() {
            /* renamed from: f */
            public C1852w<Boolean> apply(Boolean bool) throws Exception {
                C7434c.this.prepareEmptyPrj();
                return C1848s.m5326ai(Boolean.valueOf(true));
            }
        }).mo10194f(C1820a.aVi()).mo10195g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (C7434c.this.abw() != 0) {
                    ((C7433b) C7434c.this.getMvpView()).abA();
                    return;
                }
                C7434c.this.aza();
                if (C7434c.this.dGg == 2) {
                    C7434c.this.m21976jL(((C7433b) C7434c.this.getMvpView()).ayy());
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void aza() {
        String str;
        DataItemProject aHe = this.bMM.aHe();
        if (aHe != null) {
            String ayy = ((C7433b) getMvpView()).ayy();
            long j = aHe._id;
            if (!TextUtils.isEmpty(ayy)) {
                aHe.strActivityData = ayy;
                JoinEventInfo joinEventInfo = JoinEventUtil.getJoinEventInfo(this.mContext, ayy);
                if (joinEventInfo != null) {
                    if (!TextUtils.isEmpty(aHe.strVideoDesc)) {
                        str = aHe.strVideoDesc;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("#");
                        sb.append(joinEventInfo.strEventTitle);
                        sb.append("#");
                        str = sb.toString();
                    }
                    aHe.strVideoDesc = str;
                }
            }
            if (((C7433b) getMvpView()).amL() == 3) {
                try {
                    this.cSn = "Material_center";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (this.dGg == 2) {
                    this.cSn = "PhotoMV";
                } else {
                    this.cSn = "Edit";
                }
                m21965aB(j);
            }
        }
    }

    /* access modifiers changed from: private */
    public void azb() {
        C7433b bVar = (C7433b) getMvpView();
        if (bVar != null) {
            Activity hostActivity = ((C7433b) getMvpView()).getHostActivity();
            if (hostActivity != null && !hostActivity.isFinishing()) {
                int amL = bVar.amL();
                View ayH = ((C7433b) getMvpView()).ayH();
                if (ayH != null) {
                    if (this.cyQ != null && this.cyQ.mTODOCode > 0) {
                        int i = this.cyQ.mTODOCode;
                        if (!(i == 422 || i == 440)) {
                            if (i != 612) {
                                switch (i) {
                                    case 411:
                                    case 412:
                                    case 413:
                                    case 414:
                                    case 420:
                                        break;
                                    case 415:
                                    case 416:
                                    case 417:
                                    case TodoConstants.TODO_TYPE_EDITOR_DUB_CHOOSE /*418*/:
                                    case 419:
                                        break;
                                }
                            }
                            C4577f.m11627a((Context) hostActivity, ayH, R.string.xiaoying_str_gallery_todocode_all_tip, 3000);
                        }
                        C4577f.m11627a((Context) hostActivity, ayH, R.string.xiaoying_str_gallery_todocode_video_tip, 3000);
                    } else if (amL == 5) {
                        C4577f.m11628a((Context) hostActivity, ayH, (CharSequence) this.mContext.getResources().getString(R.string.xiaoying_str_slide_choose_clip_limit_tip, new Object[]{Integer.valueOf(bVar.getLimitRangeCount())}), 0, 4000);
                    } else if (amL == 10) {
                        C4577f.m11628a((Context) hostActivity, ayH, (CharSequence) this.mContext.getResources().getString(R.string.xiaoying_str_gallery_asset_pick_range, new Object[]{Integer.valueOf(bVar.getMinRangeCount()), Integer.valueOf(bVar.getLimitRangeCount())}), 0, 4000);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: jL */
    public void m21976jL(String str) {
        VeMSize aJq = C8572y.aJq();
        DataItemProject aHe = this.bMM.aHe();
        if (aHe != null) {
            aHe.streamWidth = aJq.width;
            aHe.streamHeight = aJq.height;
            if (!TextUtils.isEmpty(str)) {
                aHe.strActivityData = str;
            }
            QPoint qPoint = new QPoint(aJq.width, aJq.height);
            if (this.cFJ != null) {
                this.cFJ.setProperty(QStoryboard.PROP_OUTPUT_RESOLUTION, qPoint);
            }
            aHe.setMVPrjFlag(true);
            this.bMM.mo34730a(true, this.bOK, (Handler) null, AppStateModel.getInstance().isCommunitySupport(), this.bMM.mo34778uz(this.bMM.ebQ));
            if (this.cyM) {
                String vk = C8762d.aMt().mo35244vk(1);
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                if (iEditorService != null) {
                    iEditorService.applyTheme(this.mContext.getApplicationContext(), aHe.strPrjURL, vk);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepareEmptyPrj() {
        /*
            r18 = this;
            r0 = r18
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.cyQ
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0022
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.cyQ
            java.lang.String r1 = r1.mJsonParam
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0018
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.cyQ
            java.lang.String r1 = r1.mJsonParam
            com.introvd.template.sdk.utils.C8558m.egR = r1
        L_0x0018:
            com.introvd.template.router.todoCode.TODOParamModel r1 = r0.cyQ
            int r1 = r1.mTODOCode
            r4 = 436(0x1b4, float:6.11E-43)
            if (r1 != r4) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            com.introvd.template.sdk.utils.b.g r4 = r0.bMM
            r5 = -1
            r4.ebQ = r5
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r4 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r4 = com.introvd.template.router.BizServiceManager.getService(r4)
            com.introvd.template.router.editor.IEditorService r4 = (com.introvd.template.router.editor.IEditorService) r4
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}
            if (r4 == 0) goto L_0x003e
            java.lang.String[] r5 = r4.getCommonBehaviorParam()
        L_0x003e:
            if (r1 == 0) goto L_0x004e
            com.introvd.template.sdk.utils.b.g r6 = r0.bMM
            android.content.Context r7 = r0.mContext
            r8 = 0
            r9 = 0
            r10 = r5[r3]
            r11 = r5[r2]
            r6.mo34736a(r7, r8, r9, r10, r11)
            goto L_0x005b
        L_0x004e:
            com.introvd.template.sdk.utils.b.g r12 = r0.bMM
            android.content.Context r13 = r0.mContext
            r14 = 0
            r15 = 0
            r16 = r5[r3]
            r17 = r5[r2]
            r12.mo34756b(r13, r14, r15, r16, r17)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.p312b.C7434c.prepareEmptyPrj():void");
    }

    /* access modifiers changed from: private */
    public void saveCurrProject() {
        DataItemProject aHe = this.bMM.aHe();
        if (aHe == null) {
            prepareEmptyPrj();
            aHe = C8522g.aJA().aHe();
            if (aHe == null) {
                return;
            }
        }
        String str = aHe.strPrjURL;
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.savePrj(this.mContext, str);
        }
    }

    /* renamed from: a */
    public void mo32091a(Context context, int i, boolean z, TODOParamModel tODOParamModel) {
        this.mContext = context;
        this.dGg = i;
        this.cyM = z;
        this.cyQ = tODOParamModel;
        this.bMM = C8522g.aJA();
        this.bOK = C8501a.aJs();
        this.compositeDisposable = new C1494a();
        if (z) {
            ayZ();
        }
        this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                C7434c.this.azb();
            }
        }, 200, TimeUnit.MILLISECONDS));
    }

    /* renamed from: a */
    public void attachView(C7433b bVar) {
        super.attachView(bVar);
    }

    /* renamed from: a */
    public void mo32093a(final List<TrimedClipItemDataModel> list, final C7432a aVar) {
        C1834l.m5257ah(list).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<List<TrimedClipItemDataModel>>() {
            /* renamed from: V */
            public void accept(List<TrimedClipItemDataModel> list) {
                boolean z;
                Iterator it = list.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                    String str = trimedClipItemDataModel.mRawFilePath;
                    if ((!trimedClipItemDataModel.isExported.booleanValue() && !trimedClipItemDataModel.isImage.booleanValue()) || !FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        z = false;
                    }
                    if (z) {
                        str = trimedClipItemDataModel.mExportPath;
                    }
                    C8522g.m24676iP(str);
                }
                C7434c.this.m21966aX(list);
                if (C7434c.this.dGg == 2) {
                    z = false;
                }
                if (z) {
                    C8522g.aJA().mo34723F(false, AppStateModel.getInstance().isCommunitySupport());
                }
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TrimedClipItemDataModel>>() {
            /* renamed from: R */
            public void mo9886K(List<TrimedClipItemDataModel> list) {
                if (((C7433b) C7434c.this.getMvpView()) != null) {
                    C7434c.this.saveCurrProject();
                    DataItemProject aHe = C7434c.this.bMM.aHe();
                    if (aHe != null) {
                        C8446b.aIZ().mo34320b(C7434c.this.mContext, aHe._id, C7434c.this.cSn);
                    }
                    if (aVar != null) {
                        aVar.mo32047fW(true);
                    }
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                if (C7434c.this.compositeDisposable != null) {
                    C7434c.this.compositeDisposable.mo9785e(bVar);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                if (aVar != null) {
                    aVar.mo32047fW(false);
                }
            }
        });
    }

    public void ahV() {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(this.mContext.getContentResolver(), aHe.strPrjURL, 3, true);
            }
        }
    }

    public void applyTheme(Context context, String str, String str2) {
        C74417 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (C7434c.this.getMvpView() != null) {
                    Activity hostActivity = ((C7433b) C7434c.this.getMvpView()).getHostActivity();
                    if (hostActivity != null && !hostActivity.isFinishing()) {
                        boolean z = false;
                        if (C7434c.this.cyQ != null && C7434c.this.cyQ.getActivityFlag() > 0 && C7434c.this.cyQ.isEnterPreview()) {
                            EditorRouter.launchEditorActivity(hostActivity, PassThoughUrlGenerator.getPassThroughUrlFromIntent(hostActivity.getIntent()));
                            z = true;
                        }
                        if (!(z || C7434c.this.bMM == null || C7434c.this.bMM.aHe() == null)) {
                            FuncExportRouter.launchFuncExportActivity(hostActivity, C7434c.this.cyQ);
                        }
                        C4586g.m11696Sm();
                        hostActivity.finish();
                        try {
                            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(r0, intentFilter);
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.applyTheme(context, str, str2);
        }
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: r */
    public void mo32096r(final ViewGroup viewGroup) {
        C1495b g = C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C7680l.aAe().mo32531h(21, new C7442a(viewGroup));
                try {
                    C7680l.aAe().mo32526aj(((C7433b) C7434c.this.getMvpView()).getHostActivity(), 21);
                } catch (Exception e) {
                    String azc = C7434c.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("gallery request banner ad error :");
                    sb.append(e.getMessage());
                    LogUtils.m14222e(azc, sb.toString());
                }
            }
        });
        if (this.compositeDisposable != null) {
            this.compositeDisposable.mo9785e(g);
        }
    }

    public void release() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
            this.compositeDisposable = null;
        }
    }
}
