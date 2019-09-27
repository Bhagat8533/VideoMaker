package com.introvd.template.editor.slideshow.funny.p283a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.ratioadjust.C5747d;
import com.introvd.template.editor.clipedit.ratioadjust.C5747d.C5751b;
import com.introvd.template.editor.clipedit.ratioadjust.C5747d.C5752c;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.p245b.C5675f;
import com.introvd.template.editor.p245b.C5676g;
import com.introvd.template.editor.p266h.C6408m;
import com.introvd.template.editor.slideshow.funny.p284b.C6825a;
import com.introvd.template.editor.slideshow.model.SlideSceneModel;
import com.introvd.template.editor.slideshow.model.SlideSceneModel.Builder;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.editor.slideshow.p282e.C6782a;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.explorer.p300e.C7191a;
import com.introvd.template.explorer.p300e.C7208b;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p414ui.dialog.C8950d;
import com.introvd.template.p414ui.dialog.C8950d.C8955b;
import com.introvd.template.p414ui.dialog.C8950d.C8956c;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.videoeditor.model.MediaItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QStyle.QSlideShowSceCfgItem;
import xiaoying.engine.base.QTextAnimationInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.player.QPlayer;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.slideshowsession.QSlideShowSession.QVirtualSourceInfoNode;
import xiaoying.engine.storyboard.QClipPosition;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;
import xiaoying.utils.QTransformPara;

/* renamed from: com.introvd.template.editor.slideshow.funny.a.a */
public class C6803a extends BaseController<C6818b> {
    /* access modifiers changed from: private */
    public static final String TAG = "a";
    /* access modifiers changed from: private */
    public static String dfU = null;
    private static int dhj = 160;
    private boolean bTs = false;
    private C5747d cAJ;
    private C5752c cAV = new C5751b() {
        int dgj = 0;

        /* renamed from: A */
        public void mo27988A(float f, float f2) {
            if (C6803a.this.csP != null) {
                C6803a.this.mShiftX = f / ((float) C6803a.this.csP.width);
                C6803a.this.mShiftY = f2 / ((float) C6803a.this.csP.height);
                if (C6803a.this.mShiftX > 1.0f) {
                    C6803a.this.mShiftX = 1.0f;
                }
                if (C6803a.this.mShiftY > 1.0f) {
                    C6803a.this.mShiftY = 1.0f;
                }
                if (C6803a.this.mShiftX < -1.0f) {
                    C6803a.this.mShiftX = -1.0f;
                }
                if (C6803a.this.mShiftY < -1.0f) {
                    C6803a.this.mShiftY = -1.0f;
                }
                String Ua = C6803a.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("VariedListener onShift--> shiftX:");
                sb.append(C6803a.this.mShiftX);
                sb.append(",shiftY:");
                sb.append(C6803a.this.mShiftY);
                LogUtils.m14223i(Ua, sb.toString());
                C6803a.this.m19841c(C6803a.this.dho);
            }
        }

        public void afq() {
            LogUtils.m14223i(C6803a.TAG, "VariedListener onDown------");
            C6803a.this.pause();
        }

        public boolean afr() {
            LogUtils.m14223i(C6803a.TAG, "VariedListener onSingleTapUp------");
            if (C6803a.this.dho != null) {
                EditorRouter.launchLocalFileAlbumActivity(((C6818b) C6803a.this.getMvpView()).getActivity(), 2);
            } else if (C6803a.this.dhq != null) {
                C6803a.this.m19852iF(C6803a.this.dhq.getText());
            }
            return true;
        }

        /* renamed from: co */
        public boolean mo28023co(int i, int i2) {
            return C6803a.this.m19842cS(i, i2);
        }

        /* renamed from: lm */
        public void mo28024lm(int i) {
            int i2 = i - this.dgj;
            this.dgj = i;
            int t = C6803a.this.mAngle - i2;
            if (t < 0) {
                t += 360;
            } else if (t > 360) {
                t -= 360;
            }
            if (t != C6803a.this.mAngle) {
                String Ua = C6803a.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("VariedListener onAngle--> Angle:");
                sb.append(t);
                LogUtils.m14223i(Ua, sb.toString());
                C6803a.this.mAngle = t;
                C6803a.this.m19841c(C6803a.this.dho);
            }
        }

        /* renamed from: ln */
        public void mo28025ln(int i) {
            this.dgj = 0;
        }

        /* renamed from: z */
        public void mo27991z(float f, float f2) {
            String Ua = C6803a.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("VariedListener onScale--> scaleX:");
            sb.append(f);
            sb.append(",scaleY:");
            sb.append(f2);
            LogUtils.m14223i(Ua, sb.toString());
            C6803a.this.mScaleX = f;
            C6803a.this.mScaleY = f2;
            C6803a.this.m19841c(C6803a.this.dho);
        }
    };
    private C8950d cIV;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public SurfaceHolder cYh;
    /* access modifiers changed from: private */
    public volatile int cYk = 0;
    /* access modifiers changed from: private */
    public volatile boolean cYm = false;
    /* access modifiers changed from: private */
    public boolean cYn;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public int csK = 0;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public C8431d cso;
    private MSize css;
    private C5675f csu;
    private C8955b cxK = new C8955b() {
        /* renamed from: gv */
        public boolean mo27669gv(String str) {
            if (C6408m.m18454iO(str)) {
                return true;
            }
            ToastUtils.shortShow(C6803a.this.context.getApplicationContext(), R.string.xiaoying_str_ve_msg_no_valid_char);
            return false;
        }
    };
    private C8468c dfV;
    /* access modifiers changed from: private */
    public QSlideShowSession dfW;
    /* access modifiers changed from: private */
    public BroadcastReceiver dfX;
    /* access modifiers changed from: private */
    public C1495b dgd;
    /* access modifiers changed from: private */
    public C1890f dhk;
    /* access modifiers changed from: private */
    public C1890f dhl;
    private int dhm = -1;
    private QVirtualSourceInfoNode[] dhn;
    /* access modifiers changed from: private */
    public QVirtualSourceInfoNode dho;
    private QTextAnimationInfo[] dhp;
    /* access modifiers changed from: private */
    public QTextAnimationInfo dhq;
    private long dhr = 0;
    /* access modifiers changed from: private */
    public String dhs;
    private C7191a dht;
    /* access modifiers changed from: private */
    public C6817c dhu = new C6817c(this);
    private C6825a dhv = new C6825a() {
        public void arT() {
            ((C6818b) C6803a.this.getMvpView()).arv();
        }

        public void arU() {
            C6803a.this.dfW.SetMusic(C6803a.this.dhs, new QRange(0, -1));
            C6803a.this.dfW.setProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT, Integer.valueOf(100));
            if (C6803a.this.dhu != null) {
                if (C6803a.this.cso != null) {
                    C6803a.this.cso.aIt();
                    C6803a.this.cYk = 0;
                }
                C6803a.this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                C6803a.this.dhu.sendMessageDelayed(C6803a.this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
            }
        }

        public void arV() {
            C6803a.this.dfW.SetMusic(null, null);
            if (C6803a.this.dhu != null) {
                if (C6803a.this.cso != null) {
                    C6803a.this.cso.aIt();
                    C6803a.this.cYk = 0;
                }
                C6803a.this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                C6803a.this.dhu.sendMessageDelayed(C6803a.this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
            }
        }

        /* renamed from: e */
        public void mo30373e(String str, int i, int i2) {
            C6803a.this.dfW.SetMusic(str, new QRange(i, i2));
            if (C6803a.this.dhu != null) {
                if (C6803a.this.cso != null) {
                    C6803a.this.cso.aIt();
                    C6803a.this.cYk = 0;
                }
                C6803a.this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                C6803a.this.dhu.sendMessageDelayed(C6803a.this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
            }
        }

        public Activity getHostActivity() {
            return ((C6818b) C6803a.this.getMvpView()).getActivity();
        }

        /* renamed from: pn */
        public void mo30375pn(int i) {
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            C6803a.this.dfW.setProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT, Integer.valueOf(i));
        }
    };
    /* access modifiers changed from: private */
    public int mAngle = 0;
    /* access modifiers changed from: private */
    public float mScaleX = 1.0f;
    /* access modifiers changed from: private */
    public float mScaleY = 1.0f;
    /* access modifiers changed from: private */
    public float mShiftX = 0.0f;
    /* access modifiers changed from: private */
    public float mShiftY = 0.0f;

    /* renamed from: com.introvd.template.editor.slideshow.funny.a.a$a */
    private class C6815a implements C8434c {
        public C6815a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    C6803a.this.cYm = true;
                    if (C6803a.this.cso != null) {
                        int aIx = C6803a.this.cso.aIx();
                        C6803a.this.cso.mo34191jn(true);
                        C6803a.this.cso.aIB();
                        if (C6803a.this.cYn) {
                            C6803a.this.cYn = false;
                            C6803a.this.dhu.sendEmptyMessageDelayed(32768, 40);
                        }
                        C6803a.this.m19862pm(aIx);
                    }
                    ((C6818b) C6803a.this.getMvpView()).mo30330hd(false);
                    return;
                case 3:
                    C6803a.this.m19862pm(i2);
                    C4597i.m11729b(true, ((C6818b) C6803a.this.getMvpView()).getActivity());
                    ((C6818b) C6803a.this.getMvpView()).mo30330hd(true);
                    return;
                case 4:
                    C6803a.this.m19862pm(i2);
                    C4597i.m11729b(false, ((C6818b) C6803a.this.getMvpView()).getActivity());
                    ((C6818b) C6803a.this.getMvpView()).mo30330hd(false);
                    return;
                case 5:
                    C6803a.this.m19862pm(i2);
                    C4597i.m11729b(false, ((C6818b) C6803a.this.getMvpView()).getActivity());
                    if (C6803a.this.cso != null) {
                        C6803a.this.cso.mo34197ug(0);
                    }
                    ((C6818b) C6803a.this.getMvpView()).mo30330hd(false);
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

    /* renamed from: com.introvd.template.editor.slideshow.funny.a.a$b */
    private class C6816b implements Callback {
        private C6816b() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogUtils.m14222e(C6803a.TAG, "Surface --> surfaceChanged");
            C6803a.this.cYh = surfaceHolder;
            if (C6803a.this.dhu != null) {
                C6803a.this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                C6803a.this.dhu.sendMessageDelayed(C6803a.this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e(C6803a.TAG, "Surface --> surfaceCreated");
            C6803a.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e(C6803a.TAG, "Surface --> surfaceDestroyed");
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.funny.a.a$c */
    public static class C6817c extends Handler {
        private WeakReference<C6803a> dbT;

        public C6817c(C6803a aVar) {
            this.dbT = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C6803a aVar = (C6803a) this.dbT.get();
            if (aVar != null) {
                switch (message.what) {
                    case 32768:
                        removeMessages(32768);
                        if (aVar.cso != null && aVar.aog()) {
                            aVar.cso.play();
                            break;
                        } else {
                            sendEmptyMessageDelayed(32768, 40);
                            break;
                        }
                        break;
                    case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                        if (aVar.csP != null) {
                            if (aVar.cso != null) {
                                if (aVar.cYh.getSurface().isValid() && aVar.cYk != 1) {
                                    aVar.cYk = 1;
                                    QDisplayContext c = C8571x.m25060c(aVar.csP.width, aVar.csP.height, 1, aVar.cYh);
                                    aVar.cso.setDisplayContext(c);
                                    aVar.cso.mo34166a(c, aVar.csK);
                                    aVar.cso.aIB();
                                }
                                aVar.cYk = 2;
                                break;
                            } else {
                                aVar.arO();
                                break;
                            }
                        } else {
                            if (aVar.cso != null) {
                                aVar.cso.mo34191jn(false);
                            }
                            aVar.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                            aVar.dhu.sendMessageDelayed(obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
                            return;
                        }
                    case 32771:
                        if (aVar.cso != null && aVar.aog()) {
                            aVar.cso.mo34196uf(message.arg1);
                            break;
                        } else {
                            sendMessageDelayed(obtainMessage(32771, message.arg1, 0), 40);
                            break;
                        }
                        break;
                    case QPlayer.PROP_PLAYER_PREVIEW_FPS /*32772*/:
                        removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                        sendMessage(obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR));
                        aVar.arP();
                        break;
                    case 32773:
                        aVar.arQ();
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public QSessionStream abB() {
        if (this.csu == null || this.css == null || this.cYh == null) {
            return null;
        }
        return this.csu.mo27761a(this.css, 1, 2);
    }

    private void arJ() {
        if (this.dfW != null) {
            this.dhn = this.dfW.getVirtualSourceInfoNodeList();
            if (this.dhn != null) {
                for (QVirtualSourceInfoNode c : this.dhn) {
                    m19841c(c);
                }
            }
        }
        QSlideShowSceCfgItem[] iI = C6782a.m19747iI(C8762d.aMt().mo35225bB(this.dhr));
        if (iI == null) {
            ((C6818b) getMvpView()).mo30327bE(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iI.length; i++) {
            if (this.dfW != null) {
                arrayList.add(m19861pl(i));
            }
        }
        this.csK = m19860pk(0);
        ((C6818b) getMvpView()).mo30327bE(arrayList);
    }

    /* access modifiers changed from: private */
    public int arK() {
        C8467b aIS = this.dfV.aHf();
        if (aIS == null) {
            return 1;
        }
        this.dfW = aIS.dfW;
        if (this.dfW == null) {
            return 1;
        }
        this.dfW.setProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT, Integer.valueOf(50));
        this.dhs = this.dfW.GetDefaultMusic();
        arJ();
        arb();
        this.csu = new C5676g(this.dfW.GetStoryboard());
        if (aIS.mProjectDataItem != null) {
            this.css = new MSize(aIS.mProjectDataItem.streamWidth, aIS.mProjectDataItem.streamHeight);
        }
        VeMSize veMSize = new VeMSize(Constants.getScreenSize().width, ((Constants.getScreenSize().height - C4583d.m11670O(this.context.getApplicationContext(), 80)) - C4583d.m11670O(this.context.getApplicationContext(), 44)) - C4583d.m11670O(this.context.getApplicationContext(), 32));
        VeMSize veMSize2 = null;
        if (this.css != null) {
            veMSize2 = new VeMSize(this.css.width, this.css.height);
        }
        VeMSize e = C8572y.m25090e(veMSize2, veMSize);
        this.csP = new MSize(e.width, e.height);
        C8540q.m24930a(this.dfW, veMSize2);
        return 0;
    }

    private void arN() {
        if (this.dhl == null) {
            this.dhl = C8978m.m26348af(this.context, null, this.context.getString(R.string.xiaoying_str_com_invite_community_ok)).mo10296do(R.string.xiaoying_str_select_photo_tip).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6803a.this.dhl != null && C6803a.this.dhl.isShowing()) {
                        C6803a.this.dhl.dismiss();
                    }
                }
            }).mo10313qu();
        }
        if (!this.dhl.isShowing()) {
            this.dhl.show();
        }
    }

    /* access modifiers changed from: private */
    public void arO() {
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
                VeMSize veMSize = null;
                if (C6803a.this.cso != null) {
                    C6803a.this.cso.aIv();
                    C6803a.this.cso = null;
                }
                C6803a.this.cso = new C8431d();
                int i = 0;
                C6803a.this.cso.mo34191jn(false);
                QSessionStream p = C6803a.this.abB();
                if (p == null) {
                    return Boolean.valueOf(false);
                }
                int i2 = 0;
                while (true) {
                    if (C6803a.this.cYh != null && C6803a.this.cYh.getSurface() != null && C6803a.this.cYh.getSurface().isValid() && i2 >= 1) {
                        break;
                    }
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i2++;
                }
                if (C6803a.this.csP != null) {
                    veMSize = new VeMSize(C6803a.this.csP.width, C6803a.this.csP.height);
                }
                boolean a = C6803a.this.cso.mo34169a(p, C6803a.this.getPlayCallback(), veMSize, C6803a.this.csK, C8501a.aJs().aJv(), C6803a.this.cYh);
                if (a) {
                    while (!C6803a.this.cYm && i < 3) {
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i++;
                    }
                }
                String Ua = C6803a.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("&&&InitXYMediaPlayer PlayerInitTask initResult=");
                sb.append(a);
                LogUtils.m14223i(Ua, sb.toString());
                return Boolean.valueOf(a);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C6803a.this.dgd = bVar;
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C6803a.this.cYk = 2;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C6803a.this.cYk = 2;
            }
        });
    }

    /* access modifiers changed from: private */
    public void arP() {
        if (this.dho != null) {
            int i = this.dho.mSceneIndex;
            ((C6818b) getMvpView()).mo30323a(i, m19861pl(i));
            this.dhn = this.dfW.getVirtualSourceInfoNodeList();
            this.dho = null;
        }
    }

    /* access modifiers changed from: private */
    public void arQ() {
        this.dhp = this.dfW.getClipTextAnimationInfoArray(this.dhm);
        ((C6818b) getMvpView()).mo30330hd(false);
        this.dhq = null;
    }

    private void ara() {
        C6781a.asc().mo30313a(C8451b.FUNNY_THEME, this.dhr, "");
        ard();
        this.dhu.postDelayed(new Runnable() {
            public void run() {
                C4586g.m11705a(C6803a.this.context, "", (OnCancelListener) null, false);
                String arS = C6803a.dfU;
                ArrayList arrayList = new ArrayList();
                TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
                trimedClipItemDataModel.mRawFilePath = arS;
                arrayList.add(trimedClipItemDataModel);
                C6781a.asc().mo30312a(C6803a.this.context.getApplicationContext(), true, arrayList);
            }
        }, 200);
    }

    private void arb() {
        this.cAJ = new C5747d(((C6818b) getMvpView()).arw());
        this.cAJ.mo28012a(this.cAV);
        this.cAJ.adc();
    }

    private void ard() {
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
        this.dfX = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("slideshow.intent.action.prj.save.finish".equals(intent.getAction())) {
                    C4586g.m11696Sm();
                    if (!intent.getBooleanExtra("result_key", false)) {
                        ((C6818b) C6803a.this.getMvpView()).mo30329hc(false);
                    } else if (C6803a.this.arK() == 0) {
                        ((C6818b) C6803a.this.getMvpView()).mo30329hc(true);
                    } else {
                        ((C6818b) C6803a.this.getMvpView()).abA();
                    }
                    if (C6803a.this.dfX != null) {
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(C6803a.this.dfX);
                        C6803a.this.dfX = null;
                    }
                } else if ("slideshow.intent.action.prj.save.progress".equals(intent.getAction()) && C4586g.m11694Sk()) {
                    int intExtra = intent.getIntExtra("intent_task_progress_key", 0);
                    int intExtra2 = intent.getIntExtra("intent_task_total", 0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getString(R.string.xiaoying_str_com_loading));
                    sb.append(intExtra);
                    sb.append("/");
                    sb.append(intExtra2);
                    C4586g.m11713eJ(sb.toString());
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("slideshow.intent.action.prj.save.finish");
        intentFilter.addAction("slideshow.intent.action.prj.save.progress");
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.dfX, intentFilter);
    }

    private boolean arl() {
        if (this.dhn != null) {
            for (QVirtualSourceInfoNode qVirtualSourceInfoNode : this.dhn) {
                if (dfU.equals(qVirtualSourceInfoNode.mstrSourceFile)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19841c(QVirtualSourceInfoNode qVirtualSourceInfoNode) {
        if (qVirtualSourceInfoNode != null) {
            QTransformPara qTransformPara = new QTransformPara();
            qTransformPara.mTransformType = 9;
            qTransformPara.mClearR = 0;
            qTransformPara.mClearG = 0;
            qTransformPara.mClearB = 0;
            qTransformPara.mClearA = 255;
            qTransformPara.mScaleX = this.mScaleX;
            qTransformPara.mScaleY = this.mScaleY;
            qTransformPara.mScaleZ = 0.0f;
            qTransformPara.mAngleX = 0;
            qTransformPara.mAngleY = 0;
            qTransformPara.mAngleZ = this.mAngle;
            qTransformPara.mShiftX = this.mShiftX;
            qTransformPara.mShiftY = this.mShiftY;
            qTransformPara.mShiftZ = 0.0f;
            qTransformPara.mRectL = 0.0f;
            qTransformPara.mRectT = 0.0f;
            qTransformPara.mRectR = 1.0f;
            qTransformPara.mRectB = 1.0f;
            if (this.dfW != null) {
                int virtualSourceTransformPara = this.dfW.setVirtualSourceTransformPara(qVirtualSourceInfoNode, qTransformPara);
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("SlideShowSession.setVirtualSourceTransformPara---Code=");
                sb.append(virtualSourceTransformPara);
                LogUtils.m14223i(str, sb.toString());
            }
            if (this.cso != null) {
                this.cso.aIB();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cS */
    public boolean m19842cS(int i, int i2) {
        boolean z;
        QVirtualSourceInfoNode[] qVirtualSourceInfoNodeArr;
        if (this.dhp != null && this.dhp.length > 0) {
            QTextAnimationInfo[] qTextAnimationInfoArr = this.dhp;
            int length = qTextAnimationInfoArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                QTextAnimationInfo qTextAnimationInfo = qTextAnimationInfoArr[i3];
                QRect qRect = qTextAnimationInfo.mrcRegionRatio;
                if (qRect != null) {
                    Rect rect = new Rect();
                    rect.left = (this.csP.width * qRect.left) / 10000;
                    rect.right = (this.csP.width * qRect.right) / 10000;
                    rect.top = (this.csP.height * qRect.top) / 10000;
                    rect.bottom = (this.csP.height * qRect.bottom) / 10000;
                    if (rect.contains(i, i2)) {
                        this.dhq = qTextAnimationInfo;
                        this.dho = null;
                        z = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z || this.dhn == null || this.dhn.length <= 0) {
                return z;
            }
            for (QVirtualSourceInfoNode qVirtualSourceInfoNode : this.dhn) {
                if (qVirtualSourceInfoNode.mSceneIndex == this.dhm) {
                    QRect qRect2 = qVirtualSourceInfoNode.mRegion;
                    if (qRect2 != null) {
                        Rect rect2 = new Rect();
                        rect2.left = (this.csP.width * qRect2.left) / 10000;
                        rect2.right = (this.csP.width * qRect2.right) / 10000;
                        rect2.top = (this.csP.height * qRect2.top) / 10000;
                        rect2.bottom = (this.csP.height * qRect2.bottom) / 10000;
                        if (rect2.contains(i, i2)) {
                            this.dho = qVirtualSourceInfoNode;
                            this.dhq = null;
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return z;
        }
        z = false;
        return !z ? z : z;
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6815a();
        }
        return this.cTW;
    }

    /* renamed from: iD */
    private void m19850iD(String str) {
        if (this.dfW != null && this.dho != null && FileUtils.isFileExisted(str)) {
            C6738a.m19561c(this.context, dfU.equals(this.dho.mstrSourceFile), C8450a.m24469bn(this.dhr));
            TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
            trimedClipItemDataModel.mRawFilePath = str;
            if (C6782a.m19746a(this.dfW, this.dho, trimedClipItemDataModel) && this.dhu != null) {
                this.dhu.sendMessageDelayed(this.dhu.obtainMessage(QPlayer.PROP_PLAYER_PREVIEW_FPS), 80);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iE */
    public void m19851iE(String str) {
        if (this.dhq != null && str != null) {
            C6738a.m19562d(this.context, this.dhq.getText() != null && this.dhq.getText().equals(this.dhq.getDefText()), C8450a.m24469bn(this.dhr));
            this.dhq.setText(str);
            if (this.dfW != null) {
                this.dfW.setTextAnimationInfo(this.dhq);
                if (this.cso != null) {
                    this.cso.aIt();
                    this.cYk = 0;
                }
                if (this.dhu != null) {
                    this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                    this.dhu.sendMessageDelayed(this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
                    this.dhu.sendMessageDelayed(this.dhu.obtainMessage(32773), 120);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iF */
    public void m19852iF(String str) {
        Activity activity = ((C6818b) getMvpView()).getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (this.cIV == null) {
                this.cIV = new C8950d(activity, str, new C8956c() {
                    /* renamed from: a */
                    public void mo27683a(int i, CharSequence charSequence) {
                        if (i == 1) {
                            C6803a.this.m19851iE(charSequence.toString());
                        }
                    }
                }, false);
                this.cIV.mo35604a(this.cxK);
                this.cIV.mo35594dR(R.string.xiaoying_str_com_cancel, R.string.xiaoying_str_com_ok);
            }
            if (!this.cIV.isShowing()) {
                this.cIV.show();
            }
        }
    }

    /* renamed from: pk */
    private int m19860pk(int i) {
        QVirtualSourceInfoNode[] qVirtualSourceInfoNodeArr;
        if (this.dhn == null || this.dhn.length <= 0) {
            return 0;
        }
        for (QVirtualSourceInfoNode qVirtualSourceInfoNode : this.dhn) {
            if (i == qVirtualSourceInfoNode.mSceneIndex) {
                return qVirtualSourceInfoNode.mPreviewPos;
            }
        }
        return 0;
    }

    /* renamed from: pl */
    private SlideSceneModel m19861pl(int i) {
        Bitmap bitmap;
        int pk = m19860pk(i);
        QClip dataClip = this.dfW.GetStoryboard().getDataClip();
        if (dataClip != null) {
            bitmap = (Bitmap) C8537n.m24793a(dataClip, pk, dhj, dhj, false, false, false);
        } else {
            bitmap = null;
        }
        return new Builder().index(i + 1).previewPos(pk).thumbnail(bitmap).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: pm */
    public void m19862pm(int i) {
        if (this.dfW != null) {
            QStoryboard GetStoryboard = this.dfW.GetStoryboard();
            if (GetStoryboard != null) {
                QClipPosition GetClipPositionByTime = GetStoryboard.GetClipPositionByTime(i);
                if (GetClipPositionByTime != null) {
                    int GetIndexByClipPosition = GetStoryboard.GetIndexByClipPosition(GetClipPositionByTime);
                    if (GetIndexByClipPosition >= 0 && GetIndexByClipPosition != this.dhm) {
                        this.dhm = GetIndexByClipPosition;
                        this.dhp = this.dfW.getClipTextAnimationInfoArray(GetIndexByClipPosition);
                        ((C6818b) getMvpView()).mo30332pg(GetIndexByClipPosition);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void attachView(C6818b bVar) {
        super.attachView(bVar);
    }

    public void aoe() {
        if (this.cso != null) {
            this.cso.stop();
            this.cso.aIv();
            this.cso = null;
        }
    }

    public boolean aog() {
        return this.cYk == 2;
    }

    public C6825a arH() {
        return this.dhv;
    }

    public String arI() {
        String str = "";
        if (!TextUtils.isEmpty(this.dhs) && TextUtils.indexOf(this.dhs, CommonConfigure.APP_DATA_PATH_RELATIVE) >= 0) {
            if (this.dht != null) {
                this.dht.release();
                this.dht = null;
            }
            this.dht = new C7191a(this.context.getApplicationContext());
            str = this.dht.mo31671jr(this.dhs);
        }
        if (TextUtils.isEmpty(str)) {
            str = C7213f.m21303jw(this.dhs);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        MediaItem mediaItem = new MediaItem();
        mediaItem.path = this.dhs;
        C7208b.m21287c(this.context.getApplicationContext(), mediaItem, 2);
        return mediaItem.title;
    }

    public List<ScaleRotateViewState> arL() {
        ArrayList arrayList = new ArrayList();
        if (this.dhp != null && this.dhp.length > 0) {
            for (QTextAnimationInfo qTextAnimationInfo : this.dhp) {
                QRect qRect = qTextAnimationInfo.mrcRegionRatio;
                if (qRect != null) {
                    RectF rectF = new RectF();
                    rectF.left = (float) ((this.csP.width * qRect.left) / 10000);
                    rectF.right = (float) ((this.csP.width * qRect.right) / 10000);
                    rectF.top = (float) ((this.csP.height * qRect.top) / 10000);
                    rectF.bottom = (float) ((this.csP.height * qRect.bottom) / 10000);
                    StylePositionModel stylePositionModel = new StylePositionModel();
                    stylePositionModel.setmWidth(rectF.right - rectF.left);
                    stylePositionModel.setmHeight(rectF.bottom - rectF.top);
                    stylePositionModel.setmCenterPosX((rectF.right + rectF.left) / 2.0f);
                    stylePositionModel.setmCenterPosY((rectF.top + rectF.bottom) / 2.0f);
                    ScaleRotateViewState scaleRotateViewState = new ScaleRotateViewState();
                    scaleRotateViewState.mPosInfo = stylePositionModel;
                    arrayList.add(scaleRotateViewState);
                }
            }
        }
        return arrayList;
    }

    public boolean arM() {
        if (arl()) {
            return true;
        }
        arN();
        return false;
    }

    public void arR() {
        if (this.dhk == null) {
            this.dhk = C8978m.m26348af(this.context, this.context.getString(R.string.xiaoying_str_com_no), this.context.getString(R.string.xiaoying_str_com_yes)).mo10296do(R.string.xiaoying_str_exit_no_save_msg).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6803a.this.dhk != null && C6803a.this.dhk.isShowing()) {
                        C6803a.this.dhk.dismiss();
                    }
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6803a.this.dhk != null && C6803a.this.dhk.isShowing()) {
                        C6803a.this.dhk.dismiss();
                    }
                    C6803a.this.aoe();
                    C6781a.asc().mo30315fv(C6803a.this.context.getApplicationContext());
                    ((C6818b) C6803a.this.getMvpView()).abA();
                }
            }).mo10313qu();
        }
        pause();
        if (!this.dhk.isShowing()) {
            this.dhk.show();
        }
    }

    /* renamed from: b */
    public void mo30360b(SurfaceHolder surfaceHolder) {
        this.cYh = surfaceHolder;
        if (this.cYh != null) {
            this.cYh.addCallback(new C6816b());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
    }

    public void detachView() {
        super.detachView();
    }

    public MSize getSurfaceSize() {
        return this.csP;
    }

    /* renamed from: h */
    public void mo30362h(Context context2, long j) {
        this.context = context2;
        this.dhr = j;
        dhj = C4583d.m11670O(context2, 60);
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("ini/vivavideo_default_funny_source_img.jpg");
        dfU = sb.toString();
        this.dht = new C7191a(context2.getApplicationContext());
        C10021c.aZH().mo38494ax(this);
        this.dfV = C8468c.aIQ();
        this.dfV.init();
        ara();
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
        if (this.bTs && this.dhu != null) {
            this.dhu.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
            this.dhu.sendMessageDelayed(this.dhu.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
        }
        this.bTs = false;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onFileChooseEvent(C7134a aVar) {
        m19850iD(aVar.getFilePath());
    }

    public void pause() {
        if (this.cso != null && aog()) {
            this.cso.pause();
        }
    }

    /* renamed from: pd */
    public void mo30367pd(int i) {
        if (this.cso != null) {
            pause();
            if (i < 0) {
                i = 0;
            }
            if (i > this.cso.agX()) {
                i = this.cso.agX();
            }
            if (this.dhu != null) {
                this.dhu.removeMessages(32771);
                this.dhu.sendMessageDelayed(this.dhu.obtainMessage(32771, i, 0), 0);
            }
        }
    }

    public void play() {
        if (this.dhu != null) {
            this.dhu.sendEmptyMessageDelayed(32768, 40);
        }
        C6738a.m19563e(this.context, arl(), C8450a.m24469bn(this.dhr));
    }

    public void release() {
        aoe();
        C10021c.aZH().mo38496az(this);
        if (this.dgd != null) {
            this.dgd.dispose();
            this.dgd = null;
        }
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
        if (this.cIV != null && this.cIV.isShowing()) {
            this.cIV.dismiss();
            this.cIV = null;
        }
        if (this.dhk != null && this.dhk.isShowing()) {
            this.dhk.dismiss();
            this.dhk = null;
        }
        if (this.dhl != null && this.dhl.isShowing()) {
            this.dhl.dismiss();
            this.dhl = null;
        }
    }
}
