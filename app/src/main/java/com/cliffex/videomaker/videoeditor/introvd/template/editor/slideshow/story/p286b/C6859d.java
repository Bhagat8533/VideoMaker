package com.introvd.template.editor.slideshow.story.p286b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.UtilsBitmap;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.p245b.C5675f;
import com.introvd.template.editor.p245b.C5676g;
import com.introvd.template.editor.slideshow.p278a.C6740c;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.editor.widget.timeline.C7125c;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import java.lang.ref.WeakReference;
import org.p489b.C9963d;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;

/* renamed from: com.introvd.template.editor.slideshow.story.b.d */
public class C6859d extends BaseController<C6851b> {
    /* access modifiers changed from: private */
    public static final String TAG = "d";
    private boolean bTs = false;
    /* access modifiers changed from: private */
    public QStoryboard cFJ;
    private C8381b cPm;
    /* access modifiers changed from: private */
    public C1890f cSy;
    /* access modifiers changed from: private */
    public C8421a cTL;
    /* access modifiers changed from: private */
    public boolean cTN = false;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    /* access modifiers changed from: private */
    public SurfaceHolder cYh;
    /* access modifiers changed from: private */
    public volatile int cYk = 0;
    /* access modifiers changed from: private */
    public volatile boolean cYm = false;
    /* access modifiers changed from: private */
    public boolean cYn;
    private Context context;
    private int csD = 2;
    /* access modifiers changed from: private */
    public int csK = 0;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public C8431d cso;
    /* access modifiers changed from: private */
    public MSize css;
    private C5675f csu;
    private C7124b dbQ = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            return false;
        }

        public void acd() {
            if (C6859d.this.cTL != null) {
                C6859d.this.cTL.aIp();
            }
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            if (C6859d.this.cTL != null) {
                C6859d.this.cTL.mo34149b(new C8424a(i, false));
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            C6859d.this.pause();
            C6859d.this.cTN = true;
            if (C6859d.this.cTL != null) {
                C6859d.this.cTL.setMode(1);
                C6859d.this.cTL.mo34146a(C6859d.this.cso);
            }
        }
    };
    /* access modifiers changed from: private */
    public QSlideShowSession dfW;
    /* access modifiers changed from: private */
    public C1495b dgd;
    /* access modifiers changed from: private */
    public C1495b dis;
    /* access modifiers changed from: private */
    public C6868a dit = new C6868a(this);

    /* renamed from: com.introvd.template.editor.slideshow.story.b.d$a */
    public static class C6868a extends Handler {
        private WeakReference<C6859d> dbT;

        C6868a(C6859d dVar) {
            this.dbT = new WeakReference<>(dVar);
        }

        public void handleMessage(Message message) {
            C6859d dVar = (C6859d) this.dbT.get();
            if (dVar != null) {
                int i = message.what;
                if (i == 24576) {
                    removeMessages(24576);
                    if (dVar.cso == null || !dVar.aog()) {
                        sendEmptyMessageDelayed(24576, 40);
                    } else {
                        dVar.cso.play();
                    }
                } else if (i == 24578) {
                    String access$000 = C6859d.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("$$$handleMessage MSG:MAIN_EVENT_REBUILD_PLAYER state==");
                    sb.append(dVar.cYk);
                    LogUtils.m14223i(access$000, sb.toString());
                    if (dVar.csP == null) {
                        if (dVar.cso != null) {
                            dVar.cso.mo34191jn(false);
                        }
                        dVar.dit.removeMessages(24578);
                        dVar.dit.sendMessageDelayed(obtainMessage(24578), 40);
                    } else if (dVar.cso == null) {
                        dVar.arO();
                    } else {
                        if (dVar.cYh.getSurface().isValid() && dVar.cYk != 1) {
                            dVar.cYk = 1;
                            QDisplayContext c = C8571x.m25060c(dVar.csP.width, dVar.csP.height, 1, dVar.cYh);
                            dVar.cso.setDisplayContext(c);
                            dVar.cso.mo34166a(c, dVar.csK);
                            dVar.cso.aIB();
                            LogUtils.m14223i(C6859d.TAG, "$$$Player activeStream done...");
                        }
                        dVar.cYk = 2;
                    }
                } else if (i == 24580) {
                    if (dVar.cso == null || !dVar.aog()) {
                        sendMessageDelayed(obtainMessage(24580, message.arg1, 0), 40);
                    } else {
                        dVar.cso.mo34196uf(message.arg1);
                    }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.story.b.d$b */
    private class C6869b implements C8434c {
        public C6869b() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    C6859d.this.cYm = true;
                    if (C6859d.this.cso != null) {
                        int aIx = C6859d.this.cso.aIx();
                        C6859d.this.cso.mo34191jn(true);
                        C6859d.this.cso.aIB();
                        ((C6851b) C6859d.this.getMvpView()).mo30448J(aIx, C6859d.this.cTN);
                        if (C6859d.this.cYn) {
                            C6859d.this.cYn = false;
                            C6859d.this.dit.sendEmptyMessageDelayed(24576, 40);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    C4597i.m11729b(true, ((C6851b) C6859d.this.getMvpView()).getActivity());
                    ((C6851b) C6859d.this.getMvpView()).mo30449K(i2, C6859d.this.cTN);
                    return;
                case 4:
                    C4597i.m11729b(false, ((C6851b) C6859d.this.getMvpView()).getActivity());
                    ((C6851b) C6859d.this.getMvpView()).mo30450L(i2, C6859d.this.cTN);
                    return;
                case 5:
                    C4597i.m11729b(false, ((C6851b) C6859d.this.getMvpView()).getActivity());
                    ((C6851b) C6859d.this.getMvpView()).mo30451M(i2, C6859d.this.cTN);
                    if (C6859d.this.cso != null) {
                        C6859d.this.cso.mo34197ug(0);
                        return;
                    }
                    return;
                case 6:
                    if (i2 == 268455950) {
                        C5842b.ahd();
                        C5842b.ahf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.story.b.d$c */
    private class C6870c implements Callback {
        private C6870c() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogUtils.m14222e(C6859d.TAG, "Surface --> surfaceChanged");
            C6859d.this.cYh = surfaceHolder;
            if (C6859d.this.dit != null) {
                C6859d.this.dit.removeMessages(24578);
                C6859d.this.dit.sendMessageDelayed(C6859d.this.dit.obtainMessage(24578), 40);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e(C6859d.TAG, "Surface --> surfaceCreated");
            C6859d.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e(C6859d.TAG, "Surface --> surfaceDestroyed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20017a(QClip qClip, MSize mSize, String str) {
        if (qClip == null || mSize == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int dI = C8572y.m25087dI(mSize.width, 4);
        int dI2 = C8572y.m25087dI(mSize.height, 4);
        if (this.cso != null) {
            Bitmap dG = this.cso.mo34189dG(dI, dI2);
            if (dG == null) {
                return false;
            }
            UtilsBitmap.saveBitmap(str, dG, 85);
            return true;
        } else if (qClip.createThumbnailManager(dI, dI2, 65538, false, false) != 0) {
            return false;
        } else {
            int aIx = this.cso != null ? this.cso.aIx() : 0;
            QBitmap createQBitmapBlank = QBitmapFactory.createQBitmapBlank(dI, dI2, QColorSpace.QPAF_RGB32_A8R8G8B8);
            if (C8572y.m25063a(qClip, createQBitmapBlank, aIx, true) != 0) {
                return false;
            }
            Bitmap createBitmap = Bitmap.createBitmap(dI, dI2, Config.ARGB_8888);
            if (QAndroidBitmapFactory.transformQBitmapIntoBitmap(createQBitmapBlank, createBitmap) != 0) {
                return false;
            }
            UtilsBitmap.saveBitmap(str, createBitmap, 85);
            if (createQBitmapBlank != null && !createQBitmapBlank.isRecycled()) {
                createQBitmapBlank.recycle();
            }
            qClip.destroyThumbnailManager();
            qClip.unInit();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public QSessionStream abB() {
        if (this.csu == null || this.css == null || this.cYh == null) {
            return null;
        }
        return this.csu.mo27761a(this.css, 1, this.csD);
    }

    private void aop() {
        this.cTL = new C8421a();
        this.cTL.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
            /* renamed from: a */
            public void mo9888K(C8424a aVar) {
                String access$000 = C6859d.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("PlayerSeekRx-->position = ");
                sb.append(aVar.position);
                sb.append(",finish = ");
                sb.append(aVar.eev);
                LogUtils.m14223i(access$000, sb.toString());
                if (C6859d.this.cTZ != null) {
                    C6859d.this.cTZ.mo9893bV(1);
                }
                if (aVar.eev) {
                    C6859d.this.cTN = false;
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                C6859d.this.cTZ = dVar;
                C6859d.this.cTZ.mo9893bV(1);
            }

            public void onComplete() {
                LogUtils.m14221d(C6859d.TAG, "PlayerSeekRx-->onComplete");
            }

            public void onError(Throwable th) {
                LogUtils.m14221d(C6859d.TAG, "PlayerSeekRx-->onError");
                th.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    public void arO() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("&&&initXYMediaPlayer playerInitState==:");
        sb.append(this.cYk);
        LogUtils.m14223i(str, sb.toString());
        if (this.cYk == 1) {
            LogUtils.m14222e(TAG, "Player init intercept，Player is building...");
            return;
        }
        this.cYk = 1;
        this.cYm = false;
        if (this.cso != null) {
            this.cso.mo34185c(null);
        }
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                LogUtils.m14223i(C6859d.TAG, "&&&InitXYMediaPlayer ---------------------->");
                VeMSize veMSize = null;
                if (C6859d.this.cso != null) {
                    C6859d.this.cso.aIv();
                    C6859d.this.cso = null;
                }
                C6859d.this.cso = new C8431d();
                int i = 0;
                C6859d.this.cso.mo34191jn(false);
                QSessionStream n = C6859d.this.abB();
                if (n == null) {
                    return Boolean.valueOf(false);
                }
                int i2 = 0;
                while (true) {
                    if (C6859d.this.cYh != null && C6859d.this.cYh.getSurface() != null && C6859d.this.cYh.getSurface().isValid() && i2 >= 1) {
                        break;
                    }
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i2++;
                }
                LogUtils.m14223i(C6859d.TAG, "&&&InitXYMediaPlayer init start >>>>");
                if (C6859d.this.csP != null) {
                    veMSize = new VeMSize(C6859d.this.csP.width, C6859d.this.csP.height);
                }
                boolean a = C6859d.this.cso.mo34169a(n, C6859d.this.getPlayCallback(), veMSize, C6859d.this.csK, C8501a.aJs().aJv(), C6859d.this.cYh);
                if (a) {
                    while (!C6859d.this.cYm && i < 3) {
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i++;
                    }
                }
                String access$000 = C6859d.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("&&&InitXYMediaPlayer PlayerInitTask initResult=");
                sb.append(a);
                LogUtils.m14223i(access$000, sb.toString());
                return Boolean.valueOf(a);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                LogUtils.m14223i(C6859d.TAG, "&&&InitXYMediaPlayer onSubscribe");
                C6859d.this.dgd = bVar;
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                LogUtils.m14223i(C6859d.TAG, "&&&InitXYMediaPlayer Success<---------------------");
                C6859d.this.cYk = 2;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                LogUtils.m14223i(C6859d.TAG, "&&&InitXYMediaPlayer  Error<----------------------");
                C6859d.this.cYk = 2;
            }
        });
    }

    /* access modifiers changed from: private */
    public void arq() {
        if (this.cPm != null) {
            DataItemProject aHe = this.cPm.aHe();
            if (aHe != null) {
                this.cPm.mo33875a(((C6851b) getMvpView()).getActivity().getApplicationContext(), aHe.strPrjURL, 3, true);
            }
        }
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6869b();
        }
        return this.cTW;
    }

    /* renamed from: hf */
    private int m20028hf(boolean z) {
        this.cPm = z ? C8468c.aIQ() : C8522g.aJA();
        if (this.cPm == null) {
            return 1;
        }
        C8380a aHf = this.cPm.aHf();
        if (aHf == null) {
            return 1;
        }
        if (z) {
            this.dfW = ((C8467b) aHf).dfW;
        }
        this.cFJ = this.dfW.GetStoryboard();
        this.csu = new C5676g(this.cFJ);
        if (aHf.mProjectDataItem != null) {
            this.css = new MSize(aHf.mProjectDataItem.streamWidth, aHf.mProjectDataItem.streamHeight);
        }
        VeMSize veMSize = null;
        VeMSize veMSize2 = this.css != null ? new VeMSize(this.css.width, this.css.height) : null;
        MSize adN = ((C6851b) getMvpView()).adN();
        if (adN != null) {
            veMSize = new VeMSize(adN.width, adN.height);
        }
        VeMSize e = C8572y.m25090e(veMSize2, veMSize);
        this.csP = new MSize(e.width, e.height);
        VeMSize a = C8572y.m25064a(e, new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().height), veMSize);
        this.csP = new MSize(a.width, a.height);
        if (this.dfW != null) {
            C8540q.m24930a(this.dfW, veMSize2);
        } else {
            C8540q.m24935a(this.cFJ, veMSize2);
        }
        return 0;
    }

    /* renamed from: a */
    public void mo30483a(Context context2, boolean z, int i, boolean z2) {
        this.context = context2;
        this.cYn = z2;
        this.csK = i;
        if (m20028hf(z) != 0) {
            ((C6851b) getMvpView()).abA();
        } else if (this.dfW == null || !TextUtils.isEmpty(C8762d.aMt().mo35225bB(this.dfW.GetTheme()))) {
            this.csD = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false) ? 4 : 2;
            C7125c.m21081r(this.cFJ);
            aop();
        } else {
            ((C6851b) getMvpView()).abA();
        }
    }

    /* renamed from: a */
    public void attachView(C6851b bVar) {
        super.attachView(bVar);
    }

    public void aoe() {
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
    }

    public boolean aog() {
        return this.cYk == 2;
    }

    public long are() {
        if (this.dfW == null) {
            return 0;
        }
        return this.dfW.GetTheme();
    }

    public void arn() {
        if (this.cSy == null) {
            String string = ((C6851b) getMvpView()).getActivity().getString(R.string.xiaoying_str_com_save_title);
            this.cSy = C8978m.m26348af(this.context, ((C6851b) getMvpView()).getActivity().getString(R.string.xiaoying_str_com_discard_title), string).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6859d.this.cSy != null && C6859d.this.cSy.isShowing()) {
                        C6859d.this.cSy.dismiss();
                    }
                    C6859d.this.aoe();
                    C6859d.this.arq();
                    ((C6851b) C6859d.this.getMvpView()).abA();
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6859d.this.cSy != null && C6859d.this.cSy.isShowing()) {
                        C6859d.this.cSy.dismiss();
                    }
                    if (C6859d.this.dfW != null) {
                        C6740c.m19587g(((C6851b) C6859d.this.getMvpView()).getActivity().getApplicationContext(), C6859d.this.dfW.GetTheme());
                    }
                    StudioRouter.launchStudioActivity(((C6851b) C6859d.this.getMvpView()).getActivity());
                    ((C6851b) C6859d.this.getMvpView()).abA();
                }
            }).mo10313qu();
        }
        if (!this.cSy.isShowing()) {
            this.cSy.show();
        }
    }

    public MSize asm() {
        return this.csP;
    }

    public MSize asn() {
        return this.css;
    }

    public C7124b aso() {
        return this.dbQ;
    }

    /* renamed from: b */
    public void mo30492b(SurfaceHolder surfaceHolder) {
        this.cYh = surfaceHolder;
        if (this.cYh != null) {
            this.cYh.addCallback(new C6870c());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
    }

    public void detachView() {
        super.detachView();
    }

    public QStoryboard getStoryboard() {
        return this.cFJ;
    }

    /* renamed from: iH */
    public void mo30494iH(final String str) {
        C4586g.m11703a((Context) ((C6851b) getMvpView()).getActivity(), R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null);
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                QClip qClip = new QClip();
                QClip dataClip = C6859d.this.cFJ.getDataClip();
                MSize mSize = null;
                if (!(dataClip == null || dataClip.duplicate(qClip) == 0)) {
                    qClip.unInit();
                    qClip = null;
                }
                if (C6859d.this.css != null) {
                    mSize = new MSize(C6859d.this.css.width, C6859d.this.css.height);
                }
                mVar.mo9791K(Boolean.valueOf(C6859d.this.m20017a(qClip, mSize, str)));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C6859d.this.dis = bVar;
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                ((C6851b) C6859d.this.getMvpView()).mo30456p(bool.booleanValue(), C6859d.this.cso != null ? C6859d.this.cso.aIx() : 0);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C4586g.m11695Sl();
                ((C6851b) C6859d.this.getMvpView()).mo30456p(false, 0);
            }
        });
    }

    public void onActivityPause() {
        if (this.cso != null) {
            pause();
            this.csK = this.cso.aIx();
            this.cso.aIt();
            this.cYk = 0;
            if (this.csu.aim()) {
                this.cso.aIv();
                this.cso = null;
            }
        }
        this.bTs = true;
    }

    public void onActivityResume() {
        if (this.bTs && this.dit != null) {
            this.dit.removeMessages(24578);
            this.dit.sendMessageDelayed(this.dit.obtainMessage(24578), 40);
        }
        this.bTs = false;
    }

    public void pause() {
        if (this.cso != null && aog()) {
            this.cso.pause();
        }
    }

    public void play() {
        if (this.dit != null) {
            this.dit.sendEmptyMessageDelayed(24576, 40);
        }
    }

    public void release() {
        C7125c.destroy();
        aoe();
        if (this.cSy != null && this.cSy.isShowing()) {
            this.cSy.dismiss();
            this.cSy = null;
        }
        if (this.dgd != null) {
            this.dgd.dispose();
            this.dgd = null;
        }
        if (this.dis != null) {
            this.dis.dispose();
            this.dis = null;
        }
        if (this.dit != null) {
            this.dit.removeCallbacksAndMessages(null);
            this.dit = null;
        }
        if (this.cTZ != null) {
            this.cTZ.cancel();
            this.cTZ = null;
        }
    }
}
