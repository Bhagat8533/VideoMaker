package com.introvd.template.editor.slideshow.p280c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener;
import com.introvd.template.common.bitmapfun.util.ImageWorkerFactory;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.ratioadjust.C5741c;
import com.introvd.template.editor.clipedit.ratioadjust.C5741c.C5745b;
import com.introvd.template.editor.clipedit.ratioadjust.C5741c.C5746c;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.common.p250d.C5853a;
import com.introvd.template.editor.common.p250d.C5853a.C5855a;
import com.introvd.template.editor.p245b.C5675f;
import com.introvd.template.editor.p245b.C5676g;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.slideshow.model.SlidEditorVariedParamInfo;
import com.introvd.template.editor.slideshow.model.SlideNodeModel;
import com.introvd.template.editor.slideshow.model.SlideNodeModel.Builder;
import com.introvd.template.editor.slideshow.p278a.C6739b;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.editor.slideshow.p282e.C6782a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.C4602m;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.community.svip.ISvipAPI;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8564s;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.template.p409g.C8762d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.p489b.C9963d;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QTextAnimationInfo;
import xiaoying.engine.player.QPlayer;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.slideshowsession.QSlideShowSession.QVirtualSourceInfoNode;
import xiaoying.engine.storyboard.QClipPosition;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QSize;
import xiaoying.utils.QTransformPara;

/* renamed from: com.introvd.template.editor.slideshow.c.b */
public class C6757b extends BaseController<C6756a> {
    /* access modifiers changed from: private */
    public static final String TAG = "b";
    public static String dfU;
    private boolean bTs = false;
    /* access modifiers changed from: private */
    public C1494a cBh;
    private C5746c cBt = new C5745b() {
        int dgj = 0;

        /* renamed from: A */
        public void mo28005A(float f, float f2) {
            if (C6757b.this.csP != null && C6757b.this.ari() != null && !TextUtils.isEmpty(C6757b.this.ari().mstrSourceFile)) {
                HashMap r = C6757b.this.dga;
                StringBuilder sb = new StringBuilder();
                sb.append(C6757b.this.ari().mstrSourceFile);
                sb.append(C6757b.this.dfY);
                SlidEditorVariedParamInfo slidEditorVariedParamInfo = (SlidEditorVariedParamInfo) r.get(sb.toString());
                if (slidEditorVariedParamInfo != null) {
                    slidEditorVariedParamInfo.mShiftX -= f / ((float) C6757b.this.csP.width);
                    slidEditorVariedParamInfo.mShiftY -= f2 / ((float) C6757b.this.csP.height);
                    if (slidEditorVariedParamInfo.mShiftX > 1.0f) {
                        slidEditorVariedParamInfo.mShiftX = 1.0f;
                    }
                    if (slidEditorVariedParamInfo.mShiftY > 1.0f) {
                        slidEditorVariedParamInfo.mShiftY = 1.0f;
                    }
                    if (slidEditorVariedParamInfo.mShiftX < -1.0f) {
                        slidEditorVariedParamInfo.mShiftX = -1.0f;
                    }
                    if (slidEditorVariedParamInfo.mShiftY < -1.0f) {
                        slidEditorVariedParamInfo.mShiftY = -1.0f;
                    }
                    String ars = C6757b.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VariedListener onShift--> shiftX:");
                    sb2.append(slidEditorVariedParamInfo.mShiftX);
                    sb2.append(",shiftY:");
                    sb2.append(slidEditorVariedParamInfo.mShiftY);
                    LogUtils.m14223i(ars, sb2.toString());
                    C6757b.this.m19657a(C6757b.this.ari(), slidEditorVariedParamInfo);
                }
            }
        }

        public void afq() {
            LogUtils.m14223i(C6757b.TAG, "VariedListener onDown------");
            C6757b.this.pause();
        }

        public boolean afr() {
            LogUtils.m14223i(C6757b.TAG, "VariedListener onSingleTapUp------");
            return true;
        }

        /* renamed from: an */
        public void mo28008an(float f) {
            String ars = C6757b.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("VariedListener onScale--> scaleX:");
            sb.append(f);
            LogUtils.m14223i(ars, sb.toString());
            if (C6757b.this.ari() != null && !TextUtils.isEmpty(C6757b.this.ari().mstrSourceFile)) {
                HashMap r = C6757b.this.dga;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C6757b.this.ari().mstrSourceFile);
                sb2.append(C6757b.this.dfY);
                SlidEditorVariedParamInfo slidEditorVariedParamInfo = (SlidEditorVariedParamInfo) r.get(sb2.toString());
                if (slidEditorVariedParamInfo != null) {
                    float f2 = f * slidEditorVariedParamInfo.mScaleX;
                    if (Math.abs(f2) >= slidEditorVariedParamInfo.mMaxScaleX) {
                        f2 = f2 > 0.0f ? slidEditorVariedParamInfo.mMaxScaleX : -slidEditorVariedParamInfo.mMaxScaleX;
                    }
                    if (Math.abs(f2) <= slidEditorVariedParamInfo.mMinScaleX) {
                        f2 = f2 > 0.0f ? slidEditorVariedParamInfo.mMinScaleX : -slidEditorVariedParamInfo.mMinScaleX;
                    }
                    slidEditorVariedParamInfo.mScaleX = f2;
                    slidEditorVariedParamInfo.mScaleY = f2;
                    C6757b.this.m19657a(C6757b.this.ari(), slidEditorVariedParamInfo);
                }
            }
        }

        /* renamed from: co */
        public boolean mo28009co(int i, int i2) {
            return super.mo28009co(i, i2);
        }

        /* renamed from: lm */
        public void mo28010lm(int i) {
            int i2 = i - this.dgj;
            this.dgj = i;
            if (C6757b.this.ari() != null && !TextUtils.isEmpty(C6757b.this.ari().mstrSourceFile)) {
                HashMap r = C6757b.this.dga;
                StringBuilder sb = new StringBuilder();
                sb.append(C6757b.this.ari().mstrSourceFile);
                sb.append(C6757b.this.dfY);
                SlidEditorVariedParamInfo slidEditorVariedParamInfo = (SlidEditorVariedParamInfo) r.get(sb.toString());
                if (slidEditorVariedParamInfo != null) {
                    int i3 = slidEditorVariedParamInfo.mAngle - i2;
                    if (i3 < 0) {
                        i3 += 360;
                    } else if (i3 > 360) {
                        i3 -= 360;
                    }
                    if (i3 != slidEditorVariedParamInfo.mAngle) {
                        String ars = C6757b.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("VariedListener onAngle--> Angle:");
                        sb2.append(i3);
                        LogUtils.m14223i(ars, sb2.toString());
                        slidEditorVariedParamInfo.mAngle = i3;
                        C6757b.this.m19657a(C6757b.this.ari(), slidEditorVariedParamInfo);
                    }
                }
            }
        }

        /* renamed from: ln */
        public void mo28011ln(int i) {
            this.dgj = 0;
        }
    };
    private boolean cFy;
    /* access modifiers changed from: private */
    public C1890f cSy;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    /* access modifiers changed from: private */
    public C8421a cYE;
    private C1495b cYL;
    /* access modifiers changed from: private */
    public C1838m<Integer> cYM;
    private OnSeekBarChangeListener cYN = new OnSeekBarChangeListener() {
        private Range dgg = null;

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && C6757b.this.cYE != null) {
                if (this.dgg != null) {
                    i += this.dgg.getmPosition();
                }
                C6757b.this.cYE.mo34149b(new C8424a(i, false));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (C6757b.this.cso != null && C6757b.this.cso.isPlaying()) {
                C6757b.this.cYp = true;
            }
            C6757b.this.pause();
            if (C6757b.this.cso != null) {
                VeRange aIC = C6757b.this.cso.aIC();
                if (aIC != null) {
                    this.dgg = new Range(aIC.getmPosition(), aIC.getmTimeLength());
                }
                if (C6757b.this.cYE != null) {
                    C6757b.this.cYE.setMode(2);
                    C6757b.this.cYE.mo34146a(C6757b.this.cso);
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (C6757b.this.cYE != null) {
                C6757b.this.cYE.aIp();
            }
        }
    };
    /* access modifiers changed from: private */
    public SurfaceHolder cYh;
    /* access modifiers changed from: private */
    public volatile int cYk = 0;
    /* access modifiers changed from: private */
    public volatile boolean cYm = false;
    /* access modifiers changed from: private */
    public boolean cYn;
    /* access modifiers changed from: private */
    public boolean cYp;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public int csK = 0;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public C8431d cso;
    /* access modifiers changed from: private */
    public MSize css;
    /* access modifiers changed from: private */
    public C5675f csu;
    private boolean dfT;
    /* access modifiers changed from: private */
    public C8468c dfV;
    /* access modifiers changed from: private */
    public QSlideShowSession dfW;
    /* access modifiers changed from: private */
    public BroadcastReceiver dfX;
    /* access modifiers changed from: private */
    public int dfY = -1;
    /* access modifiers changed from: private */
    public QVirtualSourceInfoNode[] dfZ;
    /* access modifiers changed from: private */
    public HashMap<String, SlidEditorVariedParamInfo> dga = new HashMap<>();
    private ImageFetcherWithListener dgb;
    private C1890f dgc;
    /* access modifiers changed from: private */
    public C1495b dgd;
    /* access modifiers changed from: private */
    public C6778a dge = new C6778a(this);
    private int mFrom = -1;

    /* renamed from: com.introvd.template.editor.slideshow.c.b$a */
    public static class C6778a extends Handler {
        private WeakReference<C6757b> dbT;

        public C6778a(C6757b bVar) {
            this.dbT = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C6757b bVar = (C6757b) this.dbT.get();
            if (bVar != null) {
                switch (message.what) {
                    case 32768:
                        removeMessages(32768);
                        if (bVar.cso != null && bVar.aog()) {
                            bVar.cso.play();
                            break;
                        } else {
                            sendEmptyMessageDelayed(32768, 40);
                            break;
                        }
                        break;
                    case QPlayer.PROP_PLAYER_SEEK_DIR /*32770*/:
                        bVar.arg();
                        break;
                    case 32771:
                        if (bVar.cso == null) {
                            sendMessageDelayed(obtainMessage(32771, message.arg1, 0), 40);
                            break;
                        } else {
                            bVar.cso.mo34196uf(message.arg1);
                            break;
                        }
                    case QPlayer.PROP_PLAYER_PREVIEW_FPS /*32772*/:
                        if (message.obj instanceof TrimedClipItemDataModel) {
                            bVar.m19685i((TrimedClipItemDataModel) message.obj);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.c.b$b */
    private class C6779b implements C8434c {
        C6779b() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            ((C6756a) C6757b.this.getMvpView()).mo30207cQ(i, i2);
            switch (i) {
                case 2:
                    C6757b.this.cYm = true;
                    if (C6757b.this.cso != null) {
                        int aIx = C6757b.this.cso.aIx();
                        C6757b.this.cso.mo34191jn(true);
                        C6757b.this.cso.aIB();
                        if (C6757b.this.cYn) {
                            C6757b.this.cYn = false;
                            C6757b.this.dge.sendEmptyMessageDelayed(32768, 40);
                        }
                        ((C6756a) C6757b.this.getMvpView()).mo30206cP(C6757b.this.cso.aIy(), C6757b.this.m19694nO(aIx));
                        C6757b.this.m19662ac(aIx, false);
                        C6757b.this.m19632E(aIx, true);
                        return;
                    }
                    return;
                case 3:
                    C6757b.this.m19662ac(i2, true);
                    C6757b.this.m19632E(i2, false);
                    C4597i.m11729b(true, ((C6756a) C6757b.this.getMvpView()).getActivity());
                    return;
                case 4:
                    C6757b.this.m19662ac(i2, false);
                    C6757b.this.m19632E(i2, true);
                    C4597i.m11729b(false, ((C6756a) C6757b.this.getMvpView()).getActivity());
                    return;
                case 5:
                    C6757b.this.m19662ac(i2, false);
                    C6757b.this.m19632E(i2, true);
                    C4597i.m11729b(false, ((C6756a) C6757b.this.getMvpView()).getActivity());
                    if (C6757b.this.cso != null) {
                        C6757b.this.cso.mo34197ug(0);
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

    /* renamed from: com.introvd.template.editor.slideshow.c.b$c */
    private class C6780c implements Callback {
        private C6780c() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            C6757b.this.cYh = surfaceHolder;
            if (C6757b.this.dge != null) {
                C6757b.this.dge.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                C6757b.this.dge.sendMessageDelayed(C6757b.this.dge.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C6757b.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m19632E(final int i, boolean z) {
        C5852d.agW().mo28249lW(i);
        if (!z) {
            if (this.cYL == null) {
                this.cYL = C1834l.m5254a((C1839n<T>) new C1839n<Integer>() {
                    /* renamed from: a */
                    public void mo10177a(C1838m<Integer> mVar) throws Exception {
                        C6757b.this.cYM = mVar;
                        mVar.mo9791K(Integer.valueOf(i));
                    }
                }).mo10157d(C1487a.aUa()).mo10171h(100, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Integer>() {
                    /* renamed from: j */
                    public void accept(Integer num) throws Exception {
                        C6757b.this.m19696oh(num.intValue());
                    }
                });
                this.cBh.mo9785e(this.cYL);
            }
            if (this.cYM != null) {
                this.cYM.mo9791K(Integer.valueOf(i));
                return;
            }
            return;
        }
        m19696oh(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1834l<Boolean> m19639a(boolean z, long j) {
        return C1834l.m5257ah(Boolean.valueOf(z)).mo10157d(C1820a.aVi()).mo10164f(j, TimeUnit.MILLISECONDS).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                C8467b aIS = C6757b.this.dfV.aHf();
                if (aIS == null) {
                    return Boolean.valueOf(false);
                }
                C6757b.this.dfW = aIS.dfW;
                if (C6757b.this.dfW == null) {
                    return Boolean.valueOf(false);
                }
                C6757b.this.dfW.setProperty(QSlideShowSession.PROP_MUSIC_MIX_PERCENT, Integer.valueOf(50));
                QStoryboard GetStoryboard = C6757b.this.dfW.GetStoryboard();
                if (GetStoryboard == null) {
                    return Boolean.valueOf(false);
                }
                DataItemProject dataItemProject = aIS.mProjectDataItem;
                if (dataItemProject == null) {
                    return Boolean.valueOf(false);
                }
                C6757b.this.m19673c(GetStoryboard);
                C6757b.this.m19668b(dataItemProject);
                if (C6757b.this.dfW != null) {
                    C6757b.this.dfZ = C6757b.this.dfW.getVirtualSourceInfoNodeList();
                }
                if (C6757b.this.dfZ != null && C6757b.this.dfZ.length > 0) {
                    C6757b.this.csK = C6757b.this.m19664b(C6757b.this.dfZ[0]);
                }
                C6757b.this.csu = new C5676g(GetStoryboard);
                C6757b.this.css = new MSize(dataItemProject.streamWidth, dataItemProject.streamHeight);
                int ii = Constants.getScreenSize().height - C4583d.m11673ii(202);
                VeMSize veMSize = null;
                if (C6757b.this.css != null) {
                    veMSize = new VeMSize(C6757b.this.css.width, C6757b.this.css.height);
                }
                VeMSize e = C8572y.m25090e(veMSize, new VeMSize(Constants.getScreenSize().width, ii));
                C6757b.this.csP = new MSize(e.width, e.height);
                C8540q.m24930a(C6757b.this.dfW, veMSize);
                C6757b.this.m19684ha(bool.booleanValue());
                return Boolean.valueOf(true);
            }
        }).mo10152c(C1487a.aUa()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    C6757b.this.arf();
                    C6757b.this.arb();
                }
            }
        });
    }

    /* renamed from: a */
    private SlideNodeModel m19643a(QVirtualSourceInfoNode qVirtualSourceInfoNode) {
        if (qVirtualSourceInfoNode == null) {
            return null;
        }
        int b = m19664b(qVirtualSourceInfoNode);
        boolean iu = mo30280iu(qVirtualSourceInfoNode.mstrSourceFile);
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mRawFilePath = qVirtualSourceInfoNode.mstrSourceFile;
        if (qVirtualSourceInfoNode.mSourceType == 1) {
            trimedClipItemDataModel.isImage = Boolean.valueOf(true);
        }
        m19683h(trimedClipItemDataModel);
        return new Builder().index(qVirtualSourceInfoNode.mSceneIndex).previewPos(b).hasSetSource(iu).dataModel(trimedClipItemDataModel).durationLimit(qVirtualSourceInfoNode.mSceneDuration).textAnimInfoArray(m19698pb(qVirtualSourceInfoNode.mSceneIndex)).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19647a(long j, ArrayList<TrimedClipItemDataModel> arrayList) {
        QSize qSize = new QSize();
        String bB = C8762d.aMt().mo35225bB(j);
        boolean z = true;
        if (!TextUtils.isEmpty(bB)) {
            QStyle qStyle = new QStyle();
            if (qStyle.create(bB, null, 1) == 0) {
                qStyle.getThemeExportSize(qSize);
                qStyle.getSlideShowSceCfgInfo();
            }
            qStyle.destroy();
        }
        C6781a asc = C6781a.asc();
        Context applicationContext = this.context.getApplicationContext();
        if (qSize.mWidth >= qSize.mHeight) {
            z = false;
        }
        asc.mo30312a(applicationContext, z, arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19657a(QVirtualSourceInfoNode qVirtualSourceInfoNode, SlidEditorVariedParamInfo slidEditorVariedParamInfo) {
        QTransformPara qTransformPara;
        if (qVirtualSourceInfoNode != null) {
            if (qVirtualSourceInfoNode.mTransformPara == null) {
                qTransformPara = new QTransformPara();
                qTransformPara.mTransformType = 8;
                qTransformPara.mBlurLenH = 20;
                qTransformPara.mBlurLenV = 20;
            } else {
                qTransformPara = qVirtualSourceInfoNode.mTransformPara;
            }
            qTransformPara.mScaleX = slidEditorVariedParamInfo.mScaleX;
            qTransformPara.mScaleY = slidEditorVariedParamInfo.mScaleY;
            qTransformPara.mAngleZ = slidEditorVariedParamInfo.mAngle;
            qTransformPara.mShiftX = slidEditorVariedParamInfo.mShiftX;
            qTransformPara.mShiftY = slidEditorVariedParamInfo.mShiftY;
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

    /* renamed from: a */
    private void m19658a(QVirtualSourceInfoNode qVirtualSourceInfoNode, SlidEditorVariedParamInfo slidEditorVariedParamInfo, float f) {
        if (slidEditorVariedParamInfo != null && qVirtualSourceInfoNode != null && qVirtualSourceInfoNode.mTransformPara != null) {
            slidEditorVariedParamInfo.mScaleX = qVirtualSourceInfoNode.mTransformPara.mScaleX;
            slidEditorVariedParamInfo.mScaleY = qVirtualSourceInfoNode.mTransformPara.mScaleY;
            slidEditorVariedParamInfo.mAngle = qVirtualSourceInfoNode.mTransformPara.mAngleZ;
            slidEditorVariedParamInfo.mShiftX = qVirtualSourceInfoNode.mTransformPara.mShiftX;
            slidEditorVariedParamInfo.mShiftY = qVirtualSourceInfoNode.mTransformPara.mShiftY;
            slidEditorVariedParamInfo.mMinScaleX = f;
            slidEditorVariedParamInfo.mMinScaleY = f;
            float f2 = f * 4.0f;
            slidEditorVariedParamInfo.mMaxScaleX = f2;
            slidEditorVariedParamInfo.mMaxScaleY = f2;
        }
    }

    /* renamed from: a */
    private void m19659a(QVirtualSourceInfoNode qVirtualSourceInfoNode, SlidEditorVariedParamInfo slidEditorVariedParamInfo, float f, float f2, float f3) {
        if (f > f2) {
            QTransformPara qTransformPara = new QTransformPara();
            qTransformPara.mTransformType = 8;
            qTransformPara.mBlurLenH = 20;
            qTransformPara.mBlurLenV = 20;
            qTransformPara.mAngleZ = slidEditorVariedParamInfo.mAngle;
            qTransformPara.mScaleX = f3;
            qTransformPara.mScaleY = f3;
            qTransformPara.mShiftX = slidEditorVariedParamInfo.mShiftX;
            qTransformPara.mShiftY = slidEditorVariedParamInfo.mShiftY;
            qTransformPara.mRectL = 0.0f;
            qTransformPara.mRectT = 0.0f;
            qTransformPara.mRectR = 1.0f;
            qTransformPara.mRectB = 1.0f;
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("|||========>Angle:");
            sb.append(slidEditorVariedParamInfo.mAngle);
            sb.append(",ScaleX:");
            sb.append(f3);
            sb.append(",ScaleY:");
            sb.append(f3);
            sb.append(",ShiftX:");
            sb.append(slidEditorVariedParamInfo.mShiftX);
            sb.append(",ShiftY:");
            sb.append(slidEditorVariedParamInfo.mShiftY);
            LogUtils.m14222e(str, sb.toString());
            this.dfW.setVirtualSourceTransformPara(qVirtualSourceInfoNode, qTransformPara);
        } else {
            this.dfW.SetVirtualSourceTransformFlag(qVirtualSourceInfoNode, false);
            f3 = this.dfW.getVirtualNodeOrgScaleValue(this.dfY);
        }
        slidEditorVariedParamInfo.mScaleX = f3;
        slidEditorVariedParamInfo.mScaleY = f3;
        slidEditorVariedParamInfo.mMinScaleX = f3;
        slidEditorVariedParamInfo.mMinScaleY = f3;
        float f4 = f3 * 4.0f;
        slidEditorVariedParamInfo.mMaxScaleX = f4;
        slidEditorVariedParamInfo.mMaxScaleY = f4;
    }

    /* renamed from: a */
    private void m19660a(QVirtualSourceInfoNode qVirtualSourceInfoNode, String str, String str2, boolean z) {
        int i;
        SlidEditorVariedParamInfo slidEditorVariedParamInfo = new SlidEditorVariedParamInfo();
        if (!TextUtils.isEmpty(str) && this.dga != null) {
            this.dga.put(str2, slidEditorVariedParamInfo);
            int GetFileMediaType = MediaFileUtils.GetFileMediaType(str);
            int i2 = 0;
            if (MediaFileUtils.IsImageFileType(GetFileMediaType)) {
                MSize dJ = m19678dJ(str);
                i2 = dJ.width;
                i = dJ.height;
            } else if (MediaFileUtils.IsVideoFileType(GetFileMediaType)) {
                VeMSize f = C8541r.m24980f(C8501a.aJs().aJv(), str);
                i2 = f.width;
                i = f.height;
            } else {
                i = 0;
            }
            if (i2 != 0 && i != 0) {
                float f2 = (float) i;
                float f3 = ((float) i2) / f2;
                float f4 = 16.0f / f2;
                float f5 = f3 > qVirtualSourceInfoNode.mAspectRatio ? qVirtualSourceInfoNode.mAspectRatio / f3 : f3 / qVirtualSourceInfoNode.mAspectRatio;
                float abs = Math.abs(f3 - qVirtualSourceInfoNode.mAspectRatio);
                if (z) {
                    m19659a(qVirtualSourceInfoNode, slidEditorVariedParamInfo, abs, f4, f5);
                } else {
                    m19658a(qVirtualSourceInfoNode, slidEditorVariedParamInfo, f5);
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

    /* access modifiers changed from: private */
    /* renamed from: ac */
    public void m19662ac(int i, boolean z) {
        if (this.dfW != null && this.dfZ != null && this.dfZ.length != 0) {
            QStoryboard GetStoryboard = this.dfW.GetStoryboard();
            if (GetStoryboard != null) {
                QClipPosition GetClipPositionByTime = GetStoryboard.GetClipPositionByTime(i);
                if (GetClipPositionByTime != null) {
                    int GetIndexByClipPosition = GetStoryboard.GetIndexByClipPosition(GetClipPositionByTime);
                    QVirtualSourceInfoNode ari = ari();
                    int i2 = 0;
                    if (!z) {
                        boolean z2 = ari != null && ari.mSceneIndex == GetIndexByClipPosition;
                        if (GetIndexByClipPosition >= 0 && !z2) {
                            int focusIndex = ((C6756a) getMvpView()).getFocusIndex();
                            if (focusIndex >= 0 && focusIndex < this.dfZ.length && this.dfZ[focusIndex].mSceneIndex == GetIndexByClipPosition) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    while (true) {
                        if (i2 >= this.dfZ.length) {
                            break;
                        } else if (this.dfZ[i2].mSceneIndex == GetIndexByClipPosition) {
                            this.dfY = i2;
                            ((C6756a) getMvpView()).mo30211oZ(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void anG() {
        if (this.cYk != 1) {
            this.cYk = 1;
            this.cYm = false;
            if (this.cso != null) {
                this.cso.mo34185c(null);
            }
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVk()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
                /* renamed from: c */
                public Boolean apply(Boolean bool) {
                    VeMSize veMSize = null;
                    if (C6757b.this.cso != null) {
                        C6757b.this.cso.aIv();
                        C6757b.this.cso = null;
                    }
                    C6757b.this.cso = new C8431d();
                    int i = 0;
                    C6757b.this.cso.mo34191jn(false);
                    QSessionStream v = C6757b.this.abB();
                    if (v == null) {
                        return Boolean.valueOf(false);
                    }
                    int i2 = 0;
                    while (true) {
                        if (C6757b.this.cYh != null && C6757b.this.cYh.getSurface() != null && C6757b.this.cYh.getSurface().isValid() && i2 >= 1) {
                            break;
                        }
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i2++;
                    }
                    if (C6757b.this.csP != null) {
                        veMSize = new VeMSize(C6757b.this.csP.width, C6757b.this.csP.height);
                    }
                    boolean a = C6757b.this.cso.mo34169a(v, C6757b.this.getPlayCallback(), veMSize, C6757b.this.csK, C8501a.aJs().aJv(), C6757b.this.cYh);
                    if (a) {
                        while (!C6757b.this.cYm && i < 3) {
                            try {
                                Thread.sleep(80);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            i++;
                        }
                    }
                    return Boolean.valueOf(a);
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    C6757b.this.dgd = bVar;
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    C6757b.this.cYk = 2;
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    C6757b.this.cYk = 2;
                }
            });
        }
    }

    private void aop() {
        this.cYE = new C8421a();
        this.cYE.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
            /* renamed from: a */
            public void mo9888K(C8424a aVar) {
                long j = (long) aVar.position;
                if (C6757b.this.cTZ != null) {
                    C6757b.this.cTZ.mo9893bV(1);
                }
                int i = (int) j;
                C5852d.agW().mo28249lW(i);
                if (aVar.eev) {
                    C6757b.this.m19632E(i, true);
                    if (C6757b.this.cYp) {
                        C6757b.this.play();
                        C6757b.this.cYp = false;
                    }
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                C6757b.this.cTZ = dVar;
                C6757b.this.cTZ.mo9893bV(1);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    private void ara() {
        final long aqO = ((C6756a) getMvpView()).aqO();
        if (aqO == 0) {
            ((C6756a) getMvpView()).abA();
            return;
        }
        TODOParamModel aqQ = ((C6756a) getMvpView()).aqQ();
        if (aqQ != null && !TextUtils.isEmpty(aqQ.mJsonParam)) {
            C8558m.egR = aqQ.mJsonParam;
        }
        C6781a.asc().mo30313a(C8451b.STORY_THEME, aqO, C8558m.m25021d(C8558m.m25017aU(C8558m.aJh(), ((C6756a) getMvpView()).aqP()), Long.valueOf(((C6756a) getMvpView()).aqO())));
        ard();
        this.dge.postDelayed(new Runnable() {
            public void run() {
                ArrayList aqN = ((C6756a) C6757b.this.getMvpView()).aqN();
                if (aqN == null || aqN.isEmpty()) {
                    String str = C6757b.dfU;
                    ArrayList arrayList = new ArrayList();
                    TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
                    trimedClipItemDataModel.mRawFilePath = str;
                    arrayList.add(trimedClipItemDataModel);
                    C6757b.this.m19647a(aqO, arrayList);
                    return;
                }
                C6757b.this.m19691l(aqN);
                C6757b.this.m19647a(aqO, aqN);
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public void arb() {
        C5741c cVar = new C5741c(((C6756a) getMvpView()).aqS());
        cVar.mo27995a(this.cBt);
        cVar.adc();
    }

    private void arc() {
        if (this.dgb == null) {
            int ii = C4583d.m11673ii(100);
            int ii2 = C4583d.m11673ii(100);
            this.dgb = ImageWorkerFactory.CreateImageWorker(this.context, ii, ii2, "slideshow_thumbnails", Utils.calculateBitmapCacheSize(20, ii, ii2), 100);
            this.dgb.setGlobalImageWorker(null);
            this.dgb.setImageFadeIn(2);
            this.dgb.setErrorImage(R.drawable.xiaoying_com_gallery_failed_icon);
            this.dgb.setLoadMode(65538);
        }
    }

    private void ard() {
        C4586g.m11712dK(this.context);
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
        this.dfX = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("slideshow.intent.action.prj.save.finish".equals(intent.getAction())) {
                    if (intent.getBooleanExtra("result_key", false)) {
                        C6757b.this.cBh.mo9785e(C6757b.this.m19639a(true, 100).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
                            /* renamed from: d */
                            public void accept(Boolean bool) throws Exception {
                                C4586g.m11696Sm();
                                if (bool.booleanValue()) {
                                    ((C6756a) C6757b.this.getMvpView()).mo30208gY(true);
                                } else {
                                    ((C6756a) C6757b.this.getMvpView()).abA();
                                }
                            }
                        }));
                    } else {
                        C4586g.m11696Sm();
                        ((C6756a) C6757b.this.getMvpView()).mo30208gY(false);
                    }
                    if (C6757b.this.dfX != null) {
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(C6757b.this.dfX);
                        C6757b.this.dfX = null;
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("slideshow.intent.action.prj.save.finish");
        intentFilter.addAction("slideshow.intent.action.prj.save.progress");
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.dfX, intentFilter);
    }

    /* access modifiers changed from: private */
    public void arf() {
        if (this.dfW != null) {
            this.dfZ = this.dfW.getVirtualSourceInfoNodeList();
        }
        if (this.dfZ == null || this.dfZ.length == 0) {
            ((C6756a) getMvpView()).mo30205bx(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (QVirtualSourceInfoNode a : this.dfZ) {
            SlideNodeModel a2 = m19643a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        m19670bC(arrayList);
        ((C6756a) getMvpView()).mo30205bx(arrayList);
    }

    /* access modifiers changed from: private */
    public void arg() {
        this.cBh.mo9785e(C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<Boolean>>() {
            /* renamed from: h */
            public C1840o<Boolean> apply(Boolean bool) throws Exception {
                if (C6757b.this.csP == null) {
                    if (C6757b.this.cso != null) {
                        C6757b.this.cso.mo34191jn(false);
                    }
                    return C1834l.m5263w(new RuntimeException("status error,please retry!"));
                }
                if (C6757b.this.cso == null) {
                    C6757b.this.anG();
                } else {
                    C6757b.this.arh();
                }
                return C1834l.m5257ah(Boolean.valueOf(true));
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C4602m<Object,Object>(20, 20)).mo10152c(C1487a.aUa()).aTR());
    }

    /* access modifiers changed from: private */
    public void arh() {
        if (this.cYh.getSurface().isValid() && this.cYk != 1) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVk()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
                /* renamed from: c */
                public Boolean apply(Boolean bool) throws Exception {
                    C6757b.this.cYk = 1;
                    QDisplayContext c = C8571x.m25060c(C6757b.this.csP.width, C6757b.this.csP.height, 1, C6757b.this.cYh);
                    C6757b.this.cso.setDisplayContext(c);
                    C6757b.this.cso.mo34166a(c, C6757b.this.csK);
                    C6757b.this.cso.aIB();
                    return Boolean.valueOf(true);
                }
            }).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    C6757b.this.cYk = 2;
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    C6757b.this.cYk = 2;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public QVirtualSourceInfoNode ari() {
        if (this.dfY < 0 || this.dfZ == null || this.dfY >= this.dfZ.length) {
            return null;
        }
        return this.dfZ[this.dfY];
    }

    private boolean ark() {
        if (arl()) {
            return true;
        }
        ToastUtils.shortShow(this.context, R.string.xiaoying_str_slide_edit_file_incomplete_title);
        return false;
    }

    private int arm() {
        if (this.dfZ == null) {
            return 0;
        }
        int i = 0;
        for (QVirtualSourceInfoNode qVirtualSourceInfoNode : this.dfZ) {
            if (!dfU.equals(qVirtualSourceInfoNode.mstrSourceFile)) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public void arq() {
        if (this.dfV != null) {
            DataItemProject aHe = this.dfV.aHe();
            if (aHe != null) {
                this.dfV.mo33875a(((C6756a) getMvpView()).getActivity().getApplicationContext(), aHe.strPrjURL, 3, true);
            }
        }
    }

    private void arr() {
        Iterator it = ((C6756a) getMvpView()).aqT().iterator();
        while (it.hasNext()) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
            if (trimedClipItemDataModel != null && mo30280iu(trimedClipItemDataModel.mRawFilePath)) {
                C6739b.m19574bN(this.context, trimedClipItemDataModel.isImage.booleanValue() ? "Image" : "Video");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m19664b(QVirtualSourceInfoNode qVirtualSourceInfoNode) {
        if (qVirtualSourceInfoNode != null) {
            return qVirtualSourceInfoNode.mPreviewPos;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19668b(DataItemProject dataItemProject) {
        if (dataItemProject != null && -1 != this.mFrom && !TextUtils.isEmpty(C5527a.m14968kj(this.mFrom))) {
            this.mFrom = TODOParamModel.getPageFromParam(dataItemProject.getPrjTodoContent());
        }
    }

    /* renamed from: bC */
    private void m19670bC(List<SlideNodeModel> list) {
        boolean z = true;
        int i = 0;
        while (z) {
            ArrayList arrayList = new ArrayList();
            for (SlideNodeModel slideNodeModel : list) {
                if (slideNodeModel.getIndex() == i) {
                    arrayList.add(slideNodeModel);
                }
            }
            if (arrayList.size() == 0) {
                z = false;
            } else {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    SlideNodeModel slideNodeModel2 = (SlideNodeModel) arrayList.get(i2);
                    if (i2 > 0) {
                        slideNodeModel2.setTextAnimInfoArray(null);
                    }
                }
                i++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19673c(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            TODOParamModel aqQ = ((C6756a) getMvpView()).aqQ();
            if (aqQ != null) {
                this.cFy = C8460a.m24502n(aqQ.getJsonObj());
                C6386d.m18367a(qStoryboard, new C5855a().mo28254fa(this.cFy).ahJ());
            } else {
                C5853a d = C6386d.m18375d(qStoryboard);
                if (d != null) {
                    this.cFy = d.ahI();
                }
            }
        }
    }

    /* renamed from: dJ */
    private MSize m19678dJ(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new MSize(options.outWidth, options.outHeight);
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6779b();
        }
        return this.cTW;
    }

    /* renamed from: h */
    private void m19683h(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (trimedClipItemDataModel != null) {
            Bitmap Y = !trimedClipItemDataModel.isImage.booleanValue() ? C8564s.aJi().mo34802Y(trimedClipItemDataModel.mThumbKey) : null;
            if (Y == null) {
                String str = trimedClipItemDataModel.mRawFilePath;
                if (!TextUtils.isEmpty(trimedClipItemDataModel.mExportPath)) {
                    str = trimedClipItemDataModel.mExportPath;
                }
                if (!TextUtils.isEmpty(str)) {
                    Y = this.dgb.syncLoadImage(str, null);
                }
            }
            if (Y != null) {
                trimedClipItemDataModel.mThumbnail = Y;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ha */
    public void m19684ha(boolean z) {
        if (this.dfZ != null) {
            for (int i = 0; i < this.dfZ.length; i++) {
                QVirtualSourceInfoNode qVirtualSourceInfoNode = this.dfZ[i];
                String str = qVirtualSourceInfoNode.mstrSourceFile;
                StringBuilder sb = new StringBuilder();
                sb.append(qVirtualSourceInfoNode.mstrSourceFile);
                sb.append(i);
                m19660a(qVirtualSourceInfoNode, str, sb.toString(), z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m19685i(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (ari() != null) {
            this.dfZ = this.dfW.getVirtualSourceInfoNodeList();
            ((C6756a) getMvpView()).mo30196a(this.dfY, trimedClipItemDataModel);
        }
    }

    /* renamed from: it */
    private boolean m19687it(String str) {
        return MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m19691l(ArrayList<TrimedClipItemDataModel> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            C6739b.m19573b(this.context, C8450a.m24469bn(are()), mo30263BB(), arrayList.size());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nO */
    public int m19694nO(int i) {
        if (this.cso == null) {
            return i;
        }
        VeRange aIC = this.cso.aIC();
        Range range = null;
        if (aIC != null) {
            range = new Range(aIC.getmPosition(), aIC.getmTimeLength());
        }
        if (range == null) {
            return i;
        }
        int i2 = i - range.getmPosition();
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 > range.getmTimeLength() ? range.getmTimeLength() : i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: oh */
    public void m19696oh(int i) {
        ((C6756a) getMvpView()).updateProgress(m19694nO(i));
    }

    /* renamed from: pb */
    private QTextAnimationInfo[] m19698pb(int i) {
        if (this.dfW != null) {
            return this.dfW.getClipTextAnimationInfoArray(i);
        }
        return null;
    }

    private void saveCurrProject() {
        C8501a.aJs().mo34669jt(true);
        this.dfV.mo34599a(this.context, true, C8501a.aJs(), null, false, false);
    }

    /* renamed from: BB */
    public String mo30263BB() {
        if (-1 == this.mFrom) {
            return null;
        }
        return C5527a.m14968kj(this.mFrom);
    }

    /* renamed from: a */
    public void mo30264a(Context context2, TrimedClipItemDataModel trimedClipItemDataModel) {
        if (context2 != null && this.dfW != null && trimedClipItemDataModel != null && FileUtils.isFileExisted(trimedClipItemDataModel.mRawFilePath)) {
            QVirtualSourceInfoNode ari = ari();
            if (ari != null) {
                if (!m19687it(trimedClipItemDataModel.mRawFilePath) || this.dfW.canInsretVideoSource(this.dfY)) {
                    m19683h(trimedClipItemDataModel);
                    boolean a = C6782a.m19746a(this.dfW, ari, trimedClipItemDataModel);
                    String str = trimedClipItemDataModel.mRawFilePath;
                    StringBuilder sb = new StringBuilder();
                    sb.append(trimedClipItemDataModel.mRawFilePath);
                    sb.append(this.dfY);
                    m19660a(ari, str, sb.toString(), true);
                    if (a && this.dge != null) {
                        this.cYn = true;
                        this.dge.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                        this.dge.sendMessageDelayed(this.dge.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
                        this.dge.sendMessageDelayed(this.dge.obtainMessage(QPlayer.PROP_PLAYER_PREVIEW_FPS, trimedClipItemDataModel), 120);
                    }
                    return;
                }
                ToastUtils.show(context2, context2.getResources().getString(R.string.xiaoying_str_ve_sdk_can_not_add_more_video_text), 0);
            }
        }
    }

    /* renamed from: a */
    public void attachView(C6756a aVar) {
        super.attachView(aVar);
    }

    /* renamed from: a */
    public void mo30266a(QTextAnimationInfo qTextAnimationInfo) {
        if (qTextAnimationInfo != null && this.dfW != null) {
            this.dfW.setTextAnimationInfo(qTextAnimationInfo);
            if (this.cso != null) {
                this.csK = this.cso.aIx();
                this.cso.aIt();
                this.cYk = 0;
            }
            if (this.dge != null) {
                this.cYn = true;
                this.dge.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
                this.dge.sendMessageDelayed(this.dge.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
                this.dge.sendMessageDelayed(this.dge.obtainMessage(32773), 120);
            }
        }
    }

    public boolean ahI() {
        return this.cFy;
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

    public long are() {
        if (this.dfW != null) {
            return this.dfW.GetTheme();
        }
        return 0;
    }

    public OnSeekBarChangeListener arj() {
        return this.cYN;
    }

    public boolean arl() {
        if (this.dfZ != null) {
            for (QVirtualSourceInfoNode qVirtualSourceInfoNode : this.dfZ) {
                if (dfU.equals(qVirtualSourceInfoNode.mstrSourceFile)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void arn() {
        pause();
        if (!this.dfT || arm() != 0) {
            if (this.cSy == null) {
                String string = this.context.getString(R.string.xiaoying_str_com_save_title);
                this.cSy = C8978m.m26348af(this.context, this.context.getString(R.string.xiaoying_str_com_discard_title), string).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10291b(new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        if (C6757b.this.cSy != null && C6757b.this.cSy.isShowing()) {
                            C6757b.this.cSy.dismiss();
                        }
                        C6757b.this.aoe();
                        C6757b.this.arq();
                        ((C6756a) C6757b.this.getMvpView()).abA();
                    }
                }).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        if (C6757b.this.cSy != null && C6757b.this.cSy.isShowing()) {
                            C6757b.this.cSy.dismiss();
                        }
                        if (!TextUtils.isEmpty(C6757b.this.mo30263BB())) {
                            C6739b.m19581j(C6757b.this.context, C8450a.m24469bn(C6757b.this.are()), C6757b.this.mo30263BB(), "推出时选择保存草稿");
                        }
                        C6757b.this.arp();
                    }
                }).mo10313qu();
            }
            if (!this.cSy.isShowing()) {
                this.cSy.show();
            }
            return;
        }
        aoe();
        arq();
        ((C6756a) getMvpView()).abA();
    }

    public void aro() {
        if (!TextUtils.isEmpty(mo30263BB())) {
            C6739b.m19569B(this.context, C8450a.m24469bn(are()), C5527a.m14968kj(this.mFrom));
        }
        pause();
        boolean ark = ark();
        C6739b.m19576f(this.context, ark, ((C6756a) getMvpView()).aqR());
        if (ark) {
            C4586g.m11714j(((C6756a) getMvpView()).getActivity(), false);
            arr();
            saveCurrProject();
            aoe();
            this.dge.postDelayed(new Runnable() {
                public void run() {
                    C4586g.m11696Sm();
                    String bn = C8450a.m24469bn(C6757b.this.are());
                    ISvipAPI iSvipAPI = (ISvipAPI) BizServiceManager.getService(ISvipAPI.class);
                    if (iSvipAPI == null || !iSvipAPI.checkCommodityNeedLogin(bn)) {
                        VivaRouter.getRouterBuilder(DomeSocialPublishParams.URL).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, false).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_SLIDE_SHOW_VIDEO, true).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(((C6756a) C6757b.this.getMvpView()).getActivity());
                        ((C6756a) C6757b.this.getMvpView()).abA();
                    }
                }
            }, 500);
        }
    }

    public void arp() {
        pause();
        C6739b.m19575bO(this.context, C8450a.m24469bn(are()));
        C4586g.m11714j(((C6756a) getMvpView()).getActivity(), false);
        arr();
        saveCurrProject();
        aoe();
        this.dge.postDelayed(new Runnable() {
            public void run() {
                C4586g.m11696Sm();
                StudioRouter.launchStudioActivity(((C6756a) C6757b.this.getMvpView()).getActivity());
                ((C6756a) C6757b.this.getMvpView()).abA();
            }
        }, 500);
    }

    /* renamed from: b */
    public void mo30276b(SurfaceHolder surfaceHolder) {
        this.cYh = surfaceHolder;
        if (this.cYh != null) {
            this.cYh.addCallback(new C6780c());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
    }

    /* renamed from: cR */
    public void mo30277cR(int i, int i2) {
    }

    public void detachView() {
        super.detachView();
    }

    public MSize getSurfaceSize() {
        return this.csP;
    }

    public void init(Context context2, boolean z) {
        this.context = context2;
        this.dfT = z;
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("ini/vivavideo_default_slide_source_img.jpg");
        dfU = sb.toString();
        this.cBh = new C1494a();
        this.dfV = C8468c.aIQ();
        this.dfV.init();
        if (z) {
            ara();
        } else {
            C4586g.m11712dK(context2);
            this.cBh.mo9785e(m19639a(false, 300).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    C4586g.m11696Sm();
                    if (bool.booleanValue()) {
                        ((C6756a) C6757b.this.getMvpView()).mo30208gY(true);
                    } else {
                        ((C6756a) C6757b.this.getMvpView()).abA();
                    }
                }
            }));
        }
        aop();
        arc();
    }

    /* renamed from: iu */
    public boolean mo30280iu(String str) {
        return !dfU.equals(str);
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
        if (this.bTs && this.dge != null) {
            this.dge.removeMessages(QPlayer.PROP_PLAYER_SEEK_DIR);
            this.dge.sendMessageDelayed(this.dge.obtainMessage(QPlayer.PROP_PLAYER_SEEK_DIR), 40);
        }
        this.bTs = false;
    }

    public void pause() {
        if (this.cso != null && aog()) {
            this.cso.pause();
        }
    }

    /* renamed from: pc */
    public void mo30284pc(int i) {
        this.mFrom = i;
    }

    /* renamed from: pd */
    public void mo30285pd(int i) {
        if (this.cso != null && aog()) {
            pause();
            if (i < 0) {
                i = 0;
            }
            if (i > this.cso.agX()) {
                i = this.cso.agX();
            }
            if (this.dge != null) {
                this.dge.removeMessages(32771);
                this.dge.sendMessageDelayed(this.dge.obtainMessage(32771, i, 0), 0);
            }
        }
    }

    /* renamed from: pe */
    public void mo30286pe(int i) {
        this.dfY = i;
    }

    public void play() {
        if (this.dge != null) {
            this.dge.sendEmptyMessageDelayed(32768, 40);
        }
    }

    public void release() {
        aoe();
        if (this.dge != null) {
            this.dge.removeCallbacksAndMessages(null);
            this.dge = null;
        }
        if (this.cSy != null && this.cSy.isShowing()) {
            this.cSy.dismiss();
            this.cSy = null;
        }
        if (this.dgc != null && this.dgc.isShowing()) {
            this.dgc.dismiss();
            this.dgc = null;
        }
        if (this.dgd != null) {
            this.dgd.dispose();
            this.dgd = null;
        }
        if (this.cYL != null) {
            this.cYL.dispose();
            this.cYL = null;
        }
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
    }

    public void setAutoPlayWhenReady(boolean z) {
        this.cYn = z;
    }
}
