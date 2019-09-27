package com.introvd.template.editor.gallery.p264a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.joinevent.JoinEventInfo;
import com.introvd.template.common.joinevent.JoinEventUtil;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8564s;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QPoint;

/* renamed from: com.introvd.template.editor.gallery.a.a */
public class C6332a extends BaseController<C6343b> {
    /* access modifiers changed from: private */
    public static final String TAG = "a";
    /* access modifiers changed from: private */
    public C8522g bMM;
    /* access modifiers changed from: private */
    public C8501a bOK;
    private QStoryboard cFJ;
    /* access modifiers changed from: private */
    public int cTl;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: a */
    private void m18132a(final C5530d dVar) {
        C1834l.m5254a((C1839n<T>) new C1839n<Void>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Void> mVar) {
                if (C6332a.this.bMM == null) {
                    C6332a.this.bMM = C8522g.aJA();
                    if (C6332a.this.bMM == null) {
                        return;
                    }
                }
                C6332a.this.bMM.mo34756b(C6332a.this.mContext, null, dVar.cnX == 2, C5553a.bix, C5553a.cyL);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).aTR();
    }

    /* renamed from: aB */
    private void m18133aB(long j) {
        if (j <= 0) {
            return;
        }
        if (this.cTl == 2) {
            C8446b.aIZ().mo34319b(this.mContext, j, 3);
        } else {
            C8446b.aIZ().mo34319b(this.mContext, j, 4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aX */
    public synchronized int m18134aX(List<TrimedClipItemDataModel> list) {
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
                            if (this.bMM.mo34725a(str, this.bOK, i, 0, ((C6343b) getMvpView()).amA(), trimedClipItemDataModel.mRotate.intValue(), false) == 0) {
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
    /* renamed from: aY */
    public boolean m18135aY(List<TrimedClipItemDataModel> list) {
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) list.get(i);
            if (trimedClipItemDataModel != null && trimedClipItemDataModel.bCrop.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private void amT() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C7589a.m22363h(21, new ViewAdsListener() {
                    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                        if (z && C6332a.this.getMvpView() != null) {
                            View adView = C7589a.getAdView(C6332a.this.mContext, 21);
                            if (!(adView == null || adPositionInfoParam == null || C6332a.this.getMvpView() == null)) {
                                ((C6343b) C6332a.this.getMvpView()).onAdLoaded(adView);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", C7591a.m22370W(Integer.valueOf(adPositionInfoParam.providerOrder)));
                                UserBehaviorLog.onKVEvent(C6332a.this.mContext, "Ad_Gallery_Banner_Show", hashMap);
                                C7592b.m22379F(C6332a.this.mContext, "Ad_Gallery_Banner_Show", C7591a.m22370W(Integer.valueOf(adPositionInfoParam.providerOrder)));
                            }
                        }
                    }
                });
                try {
                    C7589a.m22360aj(C6332a.this.mContext, 21);
                } catch (Exception e) {
                    String access$100 = C6332a.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("gallery request banner ad error :");
                    sb.append(e.getMessage());
                    LogUtils.m14222e(access$100, sb.toString());
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    private void amU() {
        ProjectItem ahP = this.bMM.aHf();
        if (ahP != null) {
            this.cFJ = ahP.mStoryBoard;
            C8420b bVar = new C8420b();
            bVar.mo34144jf(true);
            bVar.mo34145t(this.cFJ);
        }
    }

    /* renamed from: a */
    public void mo29333a(Context context, int i, long j, boolean z) {
        this.mContext = context;
        this.cTl = i;
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            ((C6343b) getMvpView()).finishActivity();
            return;
        }
        if (z) {
            mo29340f(((C6343b) getMvpView()).amo());
        }
        this.bOK = C8501a.aJs();
        C5530d dVar = (C5530d) MagicCode.getMagicParam(j, "AppRunningMode", new C5530d());
        if (!(dVar == null || dVar.cnU == 0 || dVar.cnU == 1 || this.bMM.aHd() != null || this.bMM.ebQ > 0)) {
            m18132a(dVar);
        }
        amU();
        amT();
    }

    /* renamed from: a */
    public void attachView(C6343b bVar) {
        super.attachView(bVar);
    }

    /* renamed from: aW */
    public void mo29335aW(final List<TrimedClipItemDataModel> list) {
        C1834l.m5257ah(list).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<List<TrimedClipItemDataModel>>() {
            /* renamed from: V */
            public void accept(List<TrimedClipItemDataModel> list) {
                boolean z;
                Iterator it = list.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                    String str = trimedClipItemDataModel.mRawFilePath;
                    if ((trimedClipItemDataModel.isExported.booleanValue() || trimedClipItemDataModel.isImage.booleanValue()) && FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        z = true;
                    }
                    if (z) {
                        str = trimedClipItemDataModel.mExportPath;
                    }
                    C8522g.m24676iP(str);
                }
                C6332a.this.m18134aX(list);
                if (C6332a.this.cTl != 2) {
                    z = true;
                }
                if (z) {
                    C8522g.aJA().mo34723F(C6332a.this.m18135aY(list), AppStateModel.getInstance().isCommunitySupport());
                }
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TrimedClipItemDataModel>>() {
            /* renamed from: R */
            public void mo9886K(List<TrimedClipItemDataModel> list) {
                C6343b bVar = (C6343b) C6332a.this.getMvpView();
                if (bVar != null) {
                    C6332a.this.saveCurrProject();
                    DataItemProject aHe = C6332a.this.bMM.aHe();
                    if (aHe != null) {
                        C8446b.aIZ().mo34320b(C6332a.this.mContext, aHe._id, bVar.getEntrance());
                    }
                    bVar.mo29296fW(true);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C6343b bVar = (C6343b) C6332a.this.getMvpView();
                if (bVar != null) {
                    bVar.mo29296fW(false);
                }
            }
        });
    }

    public C8522g adK() {
        return this.bMM;
    }

    public void amV() {
        if (this.bMM != null) {
            this.bMM.mo34723F(false, AppStateModel.getInstance().isCommunitySupport());
        }
    }

    /* renamed from: b */
    public void mo29338b(final TrimedClipItemDataModel trimedClipItemDataModel, int i) {
        if (trimedClipItemDataModel != null) {
            final QEngine aJv = this.bOK.aJv();
            final boolean isFileExisted = FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath);
            final TrimedClipItemDataModel trimedClipItemDataModel2 = trimedClipItemDataModel;
            final int i2 = i;
            C63396 r1 = new C1839n<Bitmap>() {
                /* renamed from: a */
                public void mo10177a(C1838m<Bitmap> mVar) {
                    QClip f = isFileExisted ? C8537n.m24824f(trimedClipItemDataModel2.mExportPath, aJv) : C8537n.m24824f(trimedClipItemDataModel2.mRawFilePath, aJv);
                    Bitmap bitmap = null;
                    if (f != null) {
                        VeRange veRange = trimedClipItemDataModel2.mVeRangeInRawVideo;
                        if (trimedClipItemDataModel2.mRotate.intValue() > 0) {
                            f.setProperty(12315, trimedClipItemDataModel2.mRotate);
                        } else {
                            f.setProperty(12315, Integer.valueOf(0));
                        }
                        if (trimedClipItemDataModel2.bCrop.booleanValue()) {
                            f.setProperty(12295, Integer.valueOf(65538));
                        } else {
                            f.setProperty(12295, Integer.valueOf(1));
                        }
                        int dI = C8572y.m25087dI(i2, 4);
                        bitmap = (Bitmap) C8572y.m25066a(f, isFileExisted ? 0 : veRange.getmPosition(), dI, dI, true, false, 65538, true, false);
                        Long valueOf = Long.valueOf(System.currentTimeMillis());
                        C8564s.aJi().mo34803a(valueOf, bitmap);
                        trimedClipItemDataModel2.mThumbKey = valueOf;
                    }
                    if (isFileExisted && f != null) {
                        f.unInit();
                    }
                    mVar.mo9791K(bitmap);
                }
            };
            C1834l.m5254a((C1839n<T>) r1).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Bitmap>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    if (C6332a.this.getMvpView() != null) {
                        ((C6343b) C6332a.this.getMvpView()).mo29288a(trimedClipItemDataModel);
                    }
                }

                /* renamed from: q */
                public void mo9886K(Bitmap bitmap) {
                    if (C6332a.this.getMvpView() != null) {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            trimedClipItemDataModel.mThumbnail = bitmap;
                        }
                        ((C6343b) C6332a.this.getMvpView()).mo29288a(trimedClipItemDataModel);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public void mo29339c(final List<TrimedClipItemDataModel> list, final boolean z) {
        if (list == null || list.size() == 0) {
            ((C6343b) getMvpView()).mo29295fV(false);
        }
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) {
                boolean z = false;
                if (C6332a.this.bMM != null) {
                    C6332a.this.bMM.aJC();
                    if (C6332a.this.bMM.aHd() != null) {
                        boolean z2 = false;
                        int i = 0;
                        for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                            if (trimedClipItemDataModel == null) {
                                break;
                            }
                            int i2 = i;
                            boolean z3 = z2;
                            int i3 = 0;
                            while (i3 < trimedClipItemDataModel.repeatCount.intValue()) {
                                trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(trimedClipItemDataModel.bCropFeatureEnable.booleanValue() && !z);
                                int i4 = i2 + 1;
                                if (C6332a.this.bMM.mo34724a(trimedClipItemDataModel, C6332a.this.bOK, i2, true) == 0) {
                                    z3 = true;
                                }
                                i3++;
                                i2 = i4;
                            }
                            z2 = z3;
                            i = i2;
                        }
                        z = z2;
                    }
                }
                mVar.mo9791K(Boolean.valueOf(z));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (C6332a.this.getMvpView() != null) {
                    ((C6343b) C6332a.this.getMvpView()).mo29295fV(true);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                if (C6332a.this.getMvpView() != null) {
                    ((C6343b) C6332a.this.getMvpView()).mo29295fV(false);
                }
            }
        });
    }

    public void detachView() {
        super.detachView();
        C7149c.awD();
        DataItemProject aHe = this.bMM.aHe();
        if (aHe != null) {
            m18133aB(aHe._id);
        }
    }

    /* renamed from: f */
    public void mo29340f(TODOParamModel tODOParamModel) {
        if (tODOParamModel != null && !TextUtils.isEmpty(tODOParamModel.mJsonParam)) {
            C8558m.egR = tODOParamModel.mJsonParam;
        }
        this.bMM.ebQ = -1;
        this.bMM.mo34756b(this.mContext, null, false, C5553a.bix, C5553a.cyL);
    }

    /* renamed from: id */
    public void mo29341id(String str) {
        String str2;
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                if (!TextUtils.isEmpty(str)) {
                    aHe.strActivityData = str;
                    JoinEventInfo joinEventInfo = JoinEventUtil.getJoinEventInfo(this.mContext, str);
                    if (joinEventInfo != null) {
                        if (!TextUtils.isEmpty(aHe.strVideoDesc)) {
                            str2 = aHe.strVideoDesc;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("#");
                            sb.append(joinEventInfo.strEventTitle);
                            sb.append("#");
                            str2 = sb.toString();
                        }
                        aHe.strVideoDesc = str2;
                    }
                }
                if (((C6343b) getMvpView()).getTemplateID() > 0) {
                    try {
                        ((C6343b) getMvpView()).mo29300hP("Material_center");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (this.cTl == 2) {
                        ((C6343b) getMvpView()).mo29300hP("PhotoMV");
                    } else {
                        ((C6343b) getMvpView()).mo29300hP("Edit");
                    }
                    m18133aB(aHe._id);
                }
            }
            this.bMM.aHc();
        }
    }

    /* renamed from: n */
    public void mo29342n(String str, boolean z) {
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
            if (z) {
                StoryboardOpService.applyTheme(this.mContext.getApplicationContext(), aHe.strPrjURL, C8762d.aMt().mo35244vk(1));
            }
        }
    }

    public void saveCurrProject() {
        DataItemProject aHe = this.bMM.aHe();
        if (aHe == null) {
            mo29340f(null);
            aHe = C8522g.aJA().aHe();
            if (aHe == null) {
                return;
            }
        }
        StoryboardOpService.savePrj(this.mContext, aHe.strPrjURL);
    }

    /* renamed from: x */
    public void mo29344x(Context context, String str, String str2) {
        C63429 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                StringBuilder sb = new StringBuilder();
                sb.append("action=");
                sb.append(action);
                LogUtilsV2.m14228e(sb.toString());
                ((C6343b) C6332a.this.getMvpView()).mo29289aR(C8540q.m24926a(C6332a.this.bOK.aJv(), C6332a.this.bMM.aHd(), new VeMSize(480, 480)));
                try {
                    LocalBroadcastManager.getInstance(C6332a.this.mContext).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(r0, intentFilter);
        StoryboardOpService.applyTheme(context, str, str2);
    }
}
