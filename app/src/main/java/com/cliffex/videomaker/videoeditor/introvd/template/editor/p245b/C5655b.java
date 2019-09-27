package com.introvd.template.editor.p245b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.VivaRouter.VideoEditorParams;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.b.b */
public class C5655b extends BaseController<C5673d> {
    private MSize bLU = new MSize(Constants.getScreenSize().width, Constants.getScreenSize().height);
    /* access modifiers changed from: private */
    public C8522g bMM;
    private C8501a bOK;
    private int cFI = 0;
    private QStoryboard cFJ;
    private QStoryboard cFK;
    private ProjectItem cFL;
    private C5675f cFM;
    private C8420b cFN;
    /* access modifiers changed from: private */
    public boolean cFO = false;
    /* access modifiers changed from: private */
    public C1495b cFP;
    private C5660a cFQ = new C5660a(this);
    private Context context;
    private C8443d mClipModelCacheList;

    /* renamed from: com.introvd.template.editor.b.b$a */
    private static class C5660a extends WeakHandler<C5655b> {
        C5660a(C5655b bVar) {
            super(bVar);
        }

        public void handleMessage(Message message) {
            C5655b bVar = (C5655b) getOwner();
            if (bVar != null) {
                switch (message.what) {
                    case 268443649:
                        if (bVar.bMM != null) {
                            ProjectItem ahP = bVar.bMM.aHf();
                            if (ahP != null) {
                                bVar.bMM.aJE();
                                if ((ahP.getCacheFlag() & 8) != 0) {
                                    sendEmptyMessage(268443657);
                                    break;
                                } else {
                                    bVar.bMM.mo33877a((Handler) this, true);
                                    break;
                                }
                            }
                        }
                        break;
                    case 268443650:
                    case 268443651:
                    case 268443657:
                        C4586g.m11695Sl();
                        if (bVar.getMvpView() != null) {
                            ((C5673d) bVar.getMvpView()).abA();
                            break;
                        }
                        break;
                    case 268443653:
                    case 268443654:
                        bVar.cFO = false;
                        break;
                }
            }
        }
    }

    private int abw() {
        if (abx() != 0) {
            return 1;
        }
        aby();
        return 0;
    }

    private int abx() {
        if (this.bMM == null) {
            return 1;
        }
        this.cFL = this.bMM.aHf();
        if (this.cFL == null) {
            return 1;
        }
        this.cFJ = this.cFL.mStoryBoard;
        if (this.cFJ == null) {
            return 1;
        }
        this.cFM = new C5676g(this.cFJ);
        this.mClipModelCacheList = this.cFL.mClipModelCacheList;
        if (this.mClipModelCacheList == null) {
            return 1;
        }
        MSize mSize = new MSize();
        if (this.cFL.mProjectDataItem != null) {
            mSize = new MSize(this.cFL.mProjectDataItem.streamWidth, this.cFL.mProjectDataItem.streamHeight);
        }
        this.cFM.mo27765c(mSize);
        C8540q.m24907P(this.cFJ);
        return 0;
    }

    private void aby() {
        this.cFN = new C8420b();
        this.cFN.mo34145t(this.cFJ);
    }

    /* access modifiers changed from: private */
    public void ahR() {
        if (this.bMM.aHf() != null && this.bMM.aHf().isClipSourceFileLosted) {
            int i = R.string.xiaoying_str_ve_clip_file_lost_tip;
            if (i > 0) {
                C8978m.m26349hs(((C5673d) getMvpView()).getActivity()).mo10293dl(R.string.xiaoying_str_ve_clip_file_lost_tip2).mo10296do(i).mo10303dv(R.string.xiaoying_str_com_msg_got_it).mo10313qu().show();
            }
        }
    }

    private void ahW() {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                String str = aHe.strPrjURL;
                if (!TextUtils.isEmpty(str)) {
                    this.bMM.mo34759bb(str, VideoEditorParams.ADVANCE_PRJ_BACKUP_FILE_EXT);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void ahX() {
        if (this.cFI == 1) {
            ahV();
        } else if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(this.context.getContentResolver(), aHe.strPrjURL, 1, true);
            }
        }
        if (getMvpView() != null) {
            ((C5673d) getMvpView()).abA();
        }
    }

    /* access modifiers changed from: private */
    public void restart() {
        if (getMvpView() != null && this.bMM != null) {
            String aen = ((C5673d) getMvpView()).aen();
            if (this.cFI == 1) {
                ahV();
                GalleryRouter.getInstance().launchActivity(((C5673d) getMvpView()).getActivity(), aen, -1);
                ((C5673d) getMvpView()).abA();
            } else {
                ahV();
                GalleryIntentInfo galleryIntentInfo = (GalleryIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(aen, GalleryIntentInfo.class);
                if (galleryIntentInfo == null) {
                    galleryIntentInfo = new Builder().setSourceMode(0).setAction(0).build();
                }
                galleryIntentInfo.setNewPrj(true);
                GalleryRouter.getInstance().launchActivity(((C5673d) getMvpView()).getActivity(), PassThoughUrlGenerator.replaceParams(aen, galleryIntentInfo), -1);
                ((C5673d) getMvpView()).abA();
            }
        }
    }

    /* renamed from: a */
    public MSize mo27698a(MSize mSize) {
        VeMSize veMSize = null;
        VeMSize veMSize2 = mSize != null ? new VeMSize(mSize.width, mSize.height) : null;
        if (adN() != null) {
            veMSize = new VeMSize(adN().width, adN().height);
        }
        VeMSize a = C8572y.m25064a(C8572y.m25090e(veMSize2, veMSize), new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().height), veMSize);
        return new MSize(a.width, a.height);
    }

    /* renamed from: a */
    public void attachView(C5673d dVar) {
        super.attachView(dVar);
    }

    /* renamed from: a */
    public void mo27700a(ProjectItem projectItem) {
        this.bOK.mo34669jt(true);
        this.bMM.mo34737a(projectItem);
        abw();
    }

    public C8522g adK() {
        return this.bMM;
    }

    public C8501a adL() {
        return this.bOK;
    }

    public MSize adN() {
        return this.bLU;
    }

    public C8420b adS() {
        return this.cFN;
    }

    public void adT() {
        if (getMvpView() != null) {
            if (this.cFJ == null || this.cFJ.getClipCount() <= 0) {
                FragmentActivity activity = ((C5673d) getMvpView()).getActivity();
                if (activity != null && !activity.isFinishing()) {
                    C8978m.m26348af(activity, activity.getString(R.string.xiaoying_str_ve_simpleedit_dialog_restart), activity.getString(R.string.xiaoying_str_ve_simpleedit_dialog_cancel)).mo10293dl(R.string.xiaoying_str_com_prompt_title).mo10296do(R.string.xiaoying_str_ve_simpleedit_no_clip_tip).mo10291b(new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            C5655b.this.restart();
                        }
                    }).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            C5655b.this.ahX();
                        }
                    }).mo10290az(false).mo10313qu().show();
                }
            }
        }
    }

    public boolean adU() {
        return this.cFM != null && this.cFM.adU();
    }

    public ProjectItem ahP() {
        return this.bMM.aHf();
    }

    public void ahQ() {
        if (this.cFN != null) {
            this.cFN.mo34145t(this.cFJ);
        }
    }

    public void ahS() {
        if (this.cFP == null) {
            C1834l.m5252a(10000, 10000, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10149b((C1842q<? super T>) new C1842q<Long>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    LogUtilsV2.m14228e("AutoSave onSubscribe");
                    C5655b.this.cFP = bVar;
                }

                /* renamed from: h */
                public void mo9886K(Long l) {
                    LogUtilsV2.m14228e("AutoSave onNext autosave run");
                    C8522g.aJA().mo34755b(C8501a.aJs());
                }

                public void onComplete() {
                    LogUtilsV2.m14228e("AutoSave onComplete autosave run");
                }

                public void onError(Throwable th) {
                    LogUtilsV2.m14228e("AutoSave onError autosave run");
                }
            });
        }
    }

    public void ahT() {
        if (this.cFP != null) {
            this.cFP.dispose();
            this.cFP = null;
        }
    }

    public void ahU() {
        if (this.bOK.isProjectModified()) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                StoryboardOpService.savePrj(this.context, aHe.strPrjURL);
            }
        }
    }

    public void ahV() {
        if (this.bMM != null) {
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                this.bMM.mo34734a(this.context.getContentResolver(), aHe.strPrjURL, 3, true);
            }
        }
    }

    public C8443d ahY() {
        return this.mClipModelCacheList;
    }

    public C5675f ahZ() {
        return this.cFM;
    }

    public QStoryboard aia() {
        return this.cFJ;
    }

    public QStoryboard aib() {
        return this.cFK != null ? this.cFK : this.cFJ;
    }

    /* renamed from: b */
    public void mo27717b(MSize mSize) {
        this.bLU = mSize;
    }

    public void detachView() {
        super.detachView();
        if (this.cFQ != null) {
            this.cFQ.removeCallbacksAndMessages(null);
            this.cFQ = null;
        }
        if (this.cFK != null) {
            this.cFK.unInit();
            this.cFK = null;
        }
        ahT();
        ahW();
    }

    public QEngine getEngine() {
        if (this.bOK != null) {
            return this.bOK.aJv();
        }
        return null;
    }

    public MSize getStreamSize() {
        if (this.cFL == null) {
            return null;
        }
        DataItemProject dataItemProject = this.cFL.mProjectDataItem;
        return new MSize(dataItemProject.streamWidth, dataItemProject.streamHeight);
    }

    public void init(Context context2) {
        this.context = context2;
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            ((C5673d) getMvpView()).abA();
            return;
        }
        this.bOK = C8501a.aJs();
        if (this.bOK == null) {
            ((C5673d) getMvpView()).abA();
        } else if (abw() != 0) {
            ((C5673d) getMvpView()).abA();
        } else {
            this.cFQ.postDelayed(new Runnable() {
                public void run() {
                    C5655b.this.ahR();
                }
            }, 900);
        }
    }

    /* renamed from: ma */
    public boolean mo27721ma(int i) {
        QClip i2 = C8540q.m24956i(this.cFJ, i);
        boolean z = false;
        if (i2 == null) {
            return false;
        }
        if (((Integer) i2.getProperty(12289)).intValue() == 2) {
            z = true;
        }
        return z;
    }
}
