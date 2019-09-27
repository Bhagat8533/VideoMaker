package com.introvd.template.editor.pip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.pip.C6447a.C6452b;
import com.introvd.template.editor.pip.C6454c.C6458a;
import com.introvd.template.editor.pip.C6459d.C6465a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p324m.C7563a;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.VivaRouter.VideoEditorParams;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p388b.C8425b;
import com.introvd.template.sdk.editor.p388b.C8425b.C8426a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p386e.C8411a.C8415b;
import com.introvd.template.sdk.p386e.C8411a.C8416c;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.download.C8692b;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;

@C1942a(mo10417rZ = "/PipEditor/PIPDesigner")
public class AdvancePIPClipDesigner extends EventActivity {
    /* access modifiers changed from: private */
    public C8522g bMM = null;
    /* access modifiers changed from: private */
    public C8692b bMP = null;
    private RelativeLayout bMj;
    private boolean bMn = false;
    /* access modifiers changed from: private */
    public volatile long bNB = 0;
    /* access modifiers changed from: private */
    public C8501a bOK = null;
    private C8415b bUr = new C8416c() {
        /* renamed from: a */
        public void mo25989a(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPIPControlListener onControlRegionScroll curIndex=");
            sb.append(i);
            sb.append(";regionAfterScroll:");
            sb.append(rect);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
            if (C8537n.m24807a(AdvancePIPClipDesigner.this.cVZ, i, rect) && AdvancePIPClipDesigner.this.cso != null) {
                AdvancePIPClipDesigner.this.cso.aIB();
            }
        }

        public int anK() {
            AdvancePIPClipDesigner.this.m18522eE(false);
            return 0;
        }

        /* renamed from: b */
        public void mo25990b(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPIPControlListener onControlRegionZoom curIndex=");
            sb.append(i);
            sb.append(";regionAfterScroll:");
            sb.append(rect);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
            if (C8537n.m24807a(AdvancePIPClipDesigner.this.cVZ, i, rect) && AdvancePIPClipDesigner.this.cso != null) {
                AdvancePIPClipDesigner.this.cso.aIB();
            }
        }

        /* renamed from: cF */
        public int mo29538cF(int i, int i2) {
            return AdvancePIPClipDesigner.this.m18513cE(i, i2);
        }

        @SuppressLint({"MissingPermission"})
        /* renamed from: d */
        public void mo29539d(Point point) {
            ((Vibrator) AdvancePIPClipDesigner.this.getSystemService("vibrator")).vibrate(new long[]{0, 100, 1000}, -1);
        }

        /* renamed from: e */
        public int mo29540e(Point point) {
            if (AdvancePIPClipDesigner.this.cVZ == null || point == null) {
                return -1;
            }
            int elementIndexByPoint = AdvancePIPClipDesigner.this.cVZ.getElementIndexByPoint(point.x, point.y);
            StringBuilder sb = new StringBuilder();
            sb.append("OnPIPControlListener onControlDown touchItemIndex=");
            sb.append(elementIndexByPoint);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
            return elementIndexByPoint;
        }

        /* renamed from: f */
        public int mo29541f(Point point) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPIPControlListener onControlDown p=");
            sb.append(point);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
            if (AdvancePIPClipDesigner.this.cso != null && AdvancePIPClipDesigner.this.cso.isPlaying()) {
                AdvancePIPClipDesigner.this.cso.pause();
                return -1;
            } else if (AdvancePIPClipDesigner.this.cVZ == null || point == null) {
                return -1;
            } else {
                int elementIndexByPoint = AdvancePIPClipDesigner.this.cVZ.getElementIndexByPoint(point.x, point.y);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("OnPIPControlListener onControlDown touchItemIndex=");
                sb2.append(elementIndexByPoint);
                LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb2.toString());
                return elementIndexByPoint;
            }
        }

        /* renamed from: nR */
        public boolean mo29542nR(int i) {
            return C8537n.m24819c(AdvancePIPClipDesigner.this.cVZ, i);
        }
    };
    /* access modifiers changed from: private */
    public ImageView bVT;
    private SeekBar cAF;
    /* access modifiers changed from: private */
    public volatile boolean cFO = false;
    protected C8434c cTW;
    /* access modifiers changed from: private */
    public ArrayList<TrimedClipItemDataModel> cVY;
    /* access modifiers changed from: private */
    public QSceneClip cVZ = null;
    /* access modifiers changed from: private */
    public volatile boolean cWA = false;
    /* access modifiers changed from: private */
    public volatile boolean cWB = true;
    /* access modifiers changed from: private */
    public volatile int cWC = 0;
    private C6459d cWD;
    /* access modifiers changed from: private */
    public C6453b cWE;
    /* access modifiers changed from: private */
    public C6442b cWF = new C6442b(this);
    private C8426a cWG = new C8426a() {
        public void abL() {
            if (AdvancePIPClipDesigner.this.csy) {
                AdvancePIPClipDesigner.this.csy = false;
                AdvancePIPClipDesigner.this.cWF.obtainMessage(1016, Boolean.FALSE);
            } else if (AdvancePIPClipDesigner.this.cWA) {
                if (AdvancePIPClipDesigner.this.cso != null) {
                    AdvancePIPClipDesigner.this.cso.play();
                }
                AdvancePIPClipDesigner.this.cWA = false;
            }
        }
    };
    private OnSeekBarChangeListener cWH = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "onProgressChanged");
            if (z && AdvancePIPClipDesigner.this.cst != null && AdvancePIPClipDesigner.this.cst.isAlive()) {
                AdvancePIPClipDesigner.this.cst.seekTo(i);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "onStartTrackingTouch");
            if (AdvancePIPClipDesigner.this.cso != null && AdvancePIPClipDesigner.this.cso.isPlaying()) {
                AdvancePIPClipDesigner.this.cso.pause();
            }
            AdvancePIPClipDesigner.this.csy = true;
            AdvancePIPClipDesigner.this.m18518dO(true);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "onStopTrackingTouch");
            AdvancePIPClipDesigner.this.abK();
        }
    };
    private C6465a cWI = new C6465a() {
        /* renamed from: a */
        public void mo29536a(int i, long j, boolean z) {
            if (AdvancePIPClipDesigner.this.cso != null) {
                AdvancePIPClipDesigner.this.cso.pause();
            }
            AdvancePIPClipDesigner.this.bNB = j;
            if (z) {
                AdvancePIPClipDesigner.this.m18530h(j, C8762d.aMt().mo35241l(j, 4));
                return;
            }
            Message obtainMessage = AdvancePIPClipDesigner.this.cWF.obtainMessage(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL);
            obtainMessage.arg1 = i;
            obtainMessage.obj = Long.valueOf(j);
            AdvancePIPClipDesigner.this.cWF.sendMessage(obtainMessage);
        }
    };
    private C6458a cWJ = new C6458a() {
        /* renamed from: S */
        public void mo29544S(int i, boolean z) {
            C8537n.m24809a(AdvancePIPClipDesigner.this.cVZ, i, z);
            AdvancePIPClipDesigner.this.bOK.mo34669jt(true);
        }

        /* renamed from: nS */
        public void mo29545nS(int i) {
            AdvancePIPClipDesigner.this.bOK.mo34669jt(true);
            if (AdvancePIPClipDesigner.this.bMM.aJB() != null) {
                AdvancePIPClipDesigner.this.bMM.aJB().mo34305jl(true);
            }
        }

        /* renamed from: nT */
        public void mo29546nT(int i) {
            AdvancePIPClipDesigner.this.cWb = i;
            GalleryRouter.getInstance().launchPIPVideoPicker(AdvancePIPClipDesigner.this, false, TodoConstants.TODO_TYPE_QA_TEST);
            AdvancePIPClipDesigner.this.cWa = true;
        }

        /* renamed from: nU */
        public void mo29547nU(int i) {
            AdvancePIPClipDesigner.this.bOK.mo34669jt(true);
            if (AdvancePIPClipDesigner.this.bMM.aJB() != null) {
                AdvancePIPClipDesigner.this.bMM.aJB().mo34305jl(true);
            }
        }
    };
    private Callback cWK = new Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AdvancePIPClipDesigner.this.csO = surfaceHolder;
            if (AdvancePIPClipDesigner.this.cso == null) {
                AdvancePIPClipDesigner.this.anG();
            } else if (AdvancePIPClipDesigner.this.cWa) {
            } else {
                if (AdvancePIPClipDesigner.this.cWw != null) {
                    AdvancePIPClipDesigner.this.m18544nQ(-1);
                } else {
                    AdvancePIPClipDesigner.this.m18543nP(-1);
                }
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };
    /* access modifiers changed from: private */
    public C6452b cWL = new C6452b() {
        private boolean cWN = false;

        public void anL() {
            if (AdvancePIPClipDesigner.this.cWw != null) {
                AdvancePIPClipDesigner.this.m18544nQ(0);
            }
        }

        /* renamed from: ge */
        public void mo29527ge(boolean z) {
            this.cWN = z;
            AdvancePIPClipDesigner.this.m18554w(false, z);
        }

        /* renamed from: ky */
        public void mo29528ky(int i) {
            if (AdvancePIPClipDesigner.this.csy && AdvancePIPClipDesigner.this.cst != null && AdvancePIPClipDesigner.this.cst.isAlive()) {
                AdvancePIPClipDesigner.this.cst.seekTo(i);
            }
            AdvancePIPClipDesigner.this.abK();
            AdvancePIPClipDesigner.this.cWC = i;
            AdvancePIPClipDesigner.this.cWB = true;
            if (AdvancePIPClipDesigner.this.cWw != null && AdvancePIPClipDesigner.this.cWw.anU()) {
                AdvancePIPClipDesigner.this.cWF.sendEmptyMessageDelayed(1140, 15);
            }
        }

        /* renamed from: lJ */
        public void mo29529lJ(int i) {
            if (AdvancePIPClipDesigner.this.cso != null && AdvancePIPClipDesigner.this.cso.isPlaying()) {
                AdvancePIPClipDesigner.this.cso.pause();
            }
            AdvancePIPClipDesigner.this.m18518dO(true);
            AdvancePIPClipDesigner.this.cWA = true;
        }

        /* renamed from: ls */
        public void mo29530ls(int i) {
            if (AdvancePIPClipDesigner.this.cst != null && AdvancePIPClipDesigner.this.cst.isAlive()) {
                AdvancePIPClipDesigner.this.cst.seekTo(i);
            }
            AdvancePIPClipDesigner.this.abK();
        }

        /* renamed from: nV */
        public void mo29531nV(int i) {
            if (AdvancePIPClipDesigner.this.cst != null && AdvancePIPClipDesigner.this.cst.isAlive()) {
                AdvancePIPClipDesigner.this.cst.seekTo(i);
            }
            AdvancePIPClipDesigner.this.cWC = i;
        }

        /* renamed from: x */
        public void mo29532x(boolean z, boolean z2) {
            AdvancePIPClipDesigner.this.cWy = true;
            AdvancePIPClipDesigner.this.cWB = false;
            if (AdvancePIPClipDesigner.this.cso != null && AdvancePIPClipDesigner.this.cso.isPlaying()) {
                AdvancePIPClipDesigner.this.cso.pause();
            }
            if (AdvancePIPClipDesigner.this.cWw != null) {
                if (z) {
                    if (AdvancePIPClipDesigner.this.cWw.anP()) {
                        AdvancePIPClipDesigner.this.cls = false;
                        AdvancePIPClipDesigner.this.m18554w(false, z2);
                        AdvancePIPClipDesigner.this.cWw.mo29607gf(false);
                        new C6443c(true, z2).execute((Params[]) new Void[0]);
                    } else if (this.cWN ^ z2) {
                        AdvancePIPClipDesigner.this.m18554w(false, z2);
                    }
                } else if (!AdvancePIPClipDesigner.this.cWw.anP()) {
                    AdvancePIPClipDesigner.this.cls = false;
                    AdvancePIPClipDesigner.this.cWw.mo29607gf(true);
                    AdvancePIPClipDesigner.this.m18554w(true, z2);
                    new C6443c(false, z2).execute((Params[]) new Void[0]);
                } else {
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.mo34188dF(0, -1);
                    }
                    AdvancePIPClipDesigner.this.m18554w(true, z2);
                }
                if (AdvancePIPClipDesigner.this.cls) {
                    AdvancePIPClipDesigner.this.anF();
                }
            }
            this.cWN = z2;
            AdvancePIPClipDesigner.this.bOK.mo34669jt(true);
            if (AdvancePIPClipDesigner.this.bMM.aJB() != null) {
                AdvancePIPClipDesigner.this.bMM.aJB().mo34305jl(true);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean cWa = false;
    /* access modifiers changed from: private */
    public int cWb = -1;
    /* access modifiers changed from: private */
    public boolean cWc = false;
    /* access modifiers changed from: private */
    public volatile boolean cWd = false;
    /* access modifiers changed from: private */
    public int cWe = 1000;
    private VeMSize cWf;
    private VeMSize cWg;
    private VeMSize cWh;
    /* access modifiers changed from: private */
    public ImageButton cWi;
    /* access modifiers changed from: private */
    public ImageButton cWj;
    /* access modifiers changed from: private */
    public RelativeLayout cWk;
    private TextView cWl;
    private TextView cWm;
    /* access modifiers changed from: private */
    public RelativeLayout cWn;
    /* access modifiers changed from: private */
    public RelativeLayout cWo;
    /* access modifiers changed from: private */
    public RelativeLayout cWp;
    /* access modifiers changed from: private */
    public RelativeLayout cWq;
    /* access modifiers changed from: private */
    public RelativeLayout cWr;
    /* access modifiers changed from: private */
    public ImageButton cWs;
    /* access modifiers changed from: private */
    public ImageButton cWt;
    /* access modifiers changed from: private */
    public ImageButton cWu;
    /* access modifiers changed from: private */
    public ImageButton cWv;
    /* access modifiers changed from: private */
    public C6447a cWw;
    /* access modifiers changed from: private */
    public boolean cWx = false;
    /* access modifiers changed from: private */
    public boolean cWy = false;
    /* access modifiers changed from: private */
    public boolean cWz = false;
    /* access modifiers changed from: private */
    public ImageView cau;
    /* access modifiers changed from: private */
    public volatile boolean cls = true;
    protected volatile boolean csC = C8549f.aJd();
    protected volatile int csD = 2;
    protected volatile boolean csE = false;
    protected volatile boolean csF = false;
    private SurfaceView csN;
    /* access modifiers changed from: private */
    public SurfaceHolder csO;
    private RelativeLayout csQ;
    /* access modifiers changed from: private */
    public C8431d cso = null;
    protected C8425b cst = null;
    /* access modifiers changed from: private */
    public volatile boolean csy = false;
    /* access modifiers changed from: private */
    public RelativeLayout ctD;
    /* access modifiers changed from: private */
    public ImageButton cti;
    /* access modifiers changed from: private */
    public int mLayoutMode = 16;
    /* access modifiers changed from: private */
    public VeMSize mStreamSizeVe = new VeMSize(480, 480);
    /* access modifiers changed from: private */
    public long mTemplateID = 864691128455135233L;

    /* renamed from: po */
    private OnClickListener f3507po = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                if (view.equals(AdvancePIPClipDesigner.this.cti)) {
                    if (AdvancePIPClipDesigner.this.cso != null && !AdvancePIPClipDesigner.this.cso.isPlaying()) {
                        if (AdvancePIPClipDesigner.this.cWw != null) {
                            if (!AdvancePIPClipDesigner.this.cWw.anP() || AdvancePIPClipDesigner.this.cWw.anU()) {
                                AdvancePIPClipDesigner.this.cWw.mo29607gf(true);
                                AdvancePIPClipDesigner.this.m18544nQ(-1);
                            }
                            Range anR = AdvancePIPClipDesigner.this.cWw.anR();
                            AdvancePIPClipDesigner.this.cso.mo34186d(new VeRange(anR.getmPosition(), anR.getmTimeLength()));
                            AdvancePIPClipDesigner.this.cso.mo34196uf(anR.getmPosition());
                            C8537n.m24806a(AdvancePIPClipDesigner.this.cVZ, 0, 0, false);
                            C8537n.m24806a(AdvancePIPClipDesigner.this.cVZ, 1, 0, false);
                            AdvancePIPClipDesigner.this.cWw.setPlaying(true);
                        }
                        AdvancePIPClipDesigner.this.cso.play();
                        AdvancePIPClipDesigner.this.m18522eE(true);
                    }
                } else if (view.equals(AdvancePIPClipDesigner.this.ctD) || view.equals(AdvancePIPClipDesigner.this.cWi)) {
                    if (AdvancePIPClipDesigner.this.cWw != null) {
                        AdvancePIPClipDesigner.this.cWw.setPlaying(false);
                    }
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.pause();
                    }
                } else if (view.equals(AdvancePIPClipDesigner.this.bVT)) {
                    if (AdvancePIPClipDesigner.this.cWE == null || !AdvancePIPClipDesigner.this.cWE.aIG()) {
                        ToastUtils.show(AdvancePIPClipDesigner.this.getApplicationContext(), R.string.xiaoying_str_ve_pip_choose_two_file_tip, 0);
                        return;
                    }
                    if (AdvancePIPClipDesigner.this.cWy && AdvancePIPClipDesigner.this.cWw != null) {
                        int gg = AdvancePIPClipDesigner.this.cWw.mo29608gg(true);
                        Range anS = AdvancePIPClipDesigner.this.cWw.anS();
                        if (anS.getmPosition() < 0) {
                            anS.setmPosition(0);
                            C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                        }
                        C8537n.m24808a(AdvancePIPClipDesigner.this.cVZ, gg, new VeRange(anS.getmPosition(), anS.getmTimeLength()));
                        int gg2 = AdvancePIPClipDesigner.this.cWw.mo29608gg(false);
                        Range anT = AdvancePIPClipDesigner.this.cWw.anT();
                        C8537n.m24808a(AdvancePIPClipDesigner.this.cVZ, gg2, new VeRange(anT.getmPosition(), anT.getmTimeLength()));
                    }
                    AdvancePIPClipDesigner.this.cWe = 1002;
                    AdvancePIPClipDesigner.this.cWF.sendEmptyMessage(1110);
                } else if (view.equals(AdvancePIPClipDesigner.this.cWt) || view.equals(AdvancePIPClipDesigner.this.cWv)) {
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.pause();
                    }
                    if (AdvancePIPClipDesigner.this.cWE == null || !AdvancePIPClipDesigner.this.cWE.aIG()) {
                        ToastUtils.show(AdvancePIPClipDesigner.this.getApplicationContext(), R.string.xiaoying_str_ve_pip_choose_two_file_tip, 0);
                        return;
                    }
                    AdvancePIPClipDesigner.this.cWF.sendEmptyMessage(1010);
                } else if (view.equals(AdvancePIPClipDesigner.this.cWs)) {
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.pause();
                    }
                    AdvancePIPClipDesigner.this.cWF.sendEmptyMessage(1015);
                } else if (view.equals(AdvancePIPClipDesigner.this.cau)) {
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.pause();
                    }
                    AdvancePIPClipDesigner.this.anI();
                } else if (view.equals(AdvancePIPClipDesigner.this.cWu)) {
                    if (AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.pause();
                    }
                    AdvancePIPClipDesigner.this.anJ();
                } else if (view.equals(AdvancePIPClipDesigner.this.cWj) && AdvancePIPClipDesigner.this.cWE != null && !AdvancePIPClipDesigner.this.cWE.aIH()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(CameraRouter.KEY_CAMERA_INTENT, Integer.valueOf(4103));
                    hashMap.put(CameraRouter.KEY_CAMERA_MODE, Integer.valueOf(256));
                    hashMap.put(CameraRouter.KEY_CAMERA_MODE_PARAM, Integer.valueOf(9));
                    AdvancePIPClipDesigner.this.anI();
                    C7563a.m22316a(AdvancePIPClipDesigner.this, hashMap);
                }
            }
        }
    };

    /* renamed from: com.introvd.template.editor.pip.AdvancePIPClipDesigner$a */
    private class C6441a implements C8434c {
        public C6441a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "PlaybackModule.MSG_PLAYER_READY");
                    int aIx = AdvancePIPClipDesigner.this.cso.aIx();
                    StringBuilder sb = new StringBuilder();
                    sb.append("PlaybackModule progress=");
                    sb.append(aIx);
                    LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
                    AdvancePIPClipDesigner.this.cso.mo34191jn(true);
                    AdvancePIPClipDesigner.this.cso.aIB();
                    AdvancePIPClipDesigner.this.mo29520ks(aIx);
                    return;
                case 3:
                    LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "PlaybackModule.MSG_PLAYER_RUNNING");
                    C4597i.m11728a(true, AdvancePIPClipDesigner.this);
                    AdvancePIPClipDesigner.this.mo29521kt(i2);
                    return;
                case 4:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("PlaybackModule.MSG_PLAYER_PAUSED progress=");
                    sb2.append(i2);
                    LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb2.toString());
                    C4597i.m11728a(false, AdvancePIPClipDesigner.this);
                    AdvancePIPClipDesigner.this.mo29522ku(i2);
                    return;
                case 5:
                    LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", "PlaybackModule.MSG_PLAYER_STOPPED");
                    C4597i.m11728a(false, AdvancePIPClipDesigner.this);
                    if (AdvancePIPClipDesigner.this.abF() && AdvancePIPClipDesigner.this.cso != null) {
                        AdvancePIPClipDesigner.this.cso.aID();
                    }
                    AdvancePIPClipDesigner.this.mo29523kv(i2);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.editor.pip.AdvancePIPClipDesigner$b */
    private static class C6442b extends WeakHandler<AdvancePIPClipDesigner> {
        public C6442b(AdvancePIPClipDesigner advancePIPClipDesigner) {
            super(advancePIPClipDesigner);
        }

        public void handleMessage(Message message) {
            int i;
            Message message2 = message;
            AdvancePIPClipDesigner advancePIPClipDesigner = (AdvancePIPClipDesigner) getOwner();
            if (advancePIPClipDesigner != null) {
                int i2 = 8;
                switch (message2.what) {
                    case 1001:
                        if (C8537n.m24803a(advancePIPClipDesigner.bOK.aJv(), advancePIPClipDesigner.cVZ, message2.arg1, (TrimedClipItemDataModel) message2.obj)) {
                            C8572y.m25081b(advancePIPClipDesigner.cVZ, new VeMSize(advancePIPClipDesigner.mStreamSizeVe.width, advancePIPClipDesigner.mStreamSizeVe.height));
                            advancePIPClipDesigner.anD();
                            advancePIPClipDesigner.cVY = C8537n.m24814b(advancePIPClipDesigner.cVZ);
                            if (advancePIPClipDesigner.cWx) {
                                if (advancePIPClipDesigner.cWw != null) {
                                    advancePIPClipDesigner.cWw.destroy();
                                    advancePIPClipDesigner.cWw = null;
                                }
                                try {
                                    advancePIPClipDesigner.cWw = new C6447a((View) advancePIPClipDesigner.cWp.getParent(), advancePIPClipDesigner.cVZ);
                                    advancePIPClipDesigner.cWw.mo29596a(advancePIPClipDesigner.cWL);
                                    advancePIPClipDesigner.cWw.load();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                advancePIPClipDesigner.m18544nQ(0);
                                advancePIPClipDesigner.bOK.mo34669jt(true);
                                if (advancePIPClipDesigner.bMM.aJB() != null) {
                                    advancePIPClipDesigner.bMM.aJB().mo34305jl(true);
                                }
                                advancePIPClipDesigner.cWw.mo29607gf(true);
                            } else {
                                if (advancePIPClipDesigner.cWw != null) {
                                    advancePIPClipDesigner.cWw.destroy();
                                    advancePIPClipDesigner.cWw = null;
                                }
                                advancePIPClipDesigner.m18543nP(0);
                            }
                        }
                        advancePIPClipDesigner.cWa = false;
                        break;
                    case 1010:
                        try {
                            advancePIPClipDesigner.cWn.setVisibility(0);
                            advancePIPClipDesigner.cWp.setVisibility(4);
                            advancePIPClipDesigner.cWt.setVisibility(4);
                            advancePIPClipDesigner.cWu.setVisibility(0);
                            advancePIPClipDesigner.cWq.setVisibility(0);
                            advancePIPClipDesigner.cWr.setVisibility(0);
                            advancePIPClipDesigner.cWo.setVisibility(4);
                            boolean z = advancePIPClipDesigner.cWw == null;
                            if (z) {
                                advancePIPClipDesigner.cWw = new C6447a((View) advancePIPClipDesigner.cWp.getParent(), advancePIPClipDesigner.cVZ);
                                advancePIPClipDesigner.cWw.mo29596a(advancePIPClipDesigner.cWL);
                                advancePIPClipDesigner.cWw.load();
                            }
                            advancePIPClipDesigner.cWw.mo29607gf(true);
                            advancePIPClipDesigner.cWw.setPlaying(false);
                            if (!z) {
                                advancePIPClipDesigner.cWw.mo29612nW(advancePIPClipDesigner.cWw.anV());
                                advancePIPClipDesigner.cWw.mo29613nX(advancePIPClipDesigner.cWw.anW());
                            }
                            advancePIPClipDesigner.cWx = true;
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            removeMessages(1015);
                            sendEmptyMessage(1015);
                            break;
                        }
                    case 1015:
                        if (advancePIPClipDesigner.cWw != null) {
                            if (!advancePIPClipDesigner.cWw.anP()) {
                                advancePIPClipDesigner.m18554w(true, false);
                                advancePIPClipDesigner.m18544nQ(0);
                                advancePIPClipDesigner.bOK.mo34669jt(true);
                                if (advancePIPClipDesigner.bMM.aJB() != null) {
                                    advancePIPClipDesigner.bMM.aJB().mo34305jl(true);
                                }
                                advancePIPClipDesigner.cWw.mo29607gf(true);
                            }
                            Range anR = advancePIPClipDesigner.cWw.anR();
                            if (advancePIPClipDesigner.cso != null) {
                                advancePIPClipDesigner.cso.mo34186d(new VeRange(anR.getmPosition(), anR.getmTimeLength()));
                                advancePIPClipDesigner.cso.mo34196uf(0);
                            }
                            advancePIPClipDesigner.mo29514Yt();
                            advancePIPClipDesigner.cWn.setVisibility(4);
                            advancePIPClipDesigner.cWp.setVisibility(0);
                            advancePIPClipDesigner.cWt.setVisibility(0);
                            advancePIPClipDesigner.cWu.setVisibility(0);
                            advancePIPClipDesigner.cWq.setVisibility(4);
                            advancePIPClipDesigner.cWr.setVisibility(8);
                            advancePIPClipDesigner.cWo.setVisibility(0);
                            advancePIPClipDesigner.cWx = false;
                            break;
                        }
                        break;
                    case 1016:
                        advancePIPClipDesigner.m18522eE(((Boolean) message2.obj).booleanValue());
                        break;
                    case 1110:
                        if (advancePIPClipDesigner.bOK.isProjectModified()) {
                            if (!advancePIPClipDesigner.cFO) {
                                if (!advancePIPClipDesigner.cFO) {
                                    advancePIPClipDesigner.cWd = advancePIPClipDesigner.bOK.isProjectModified();
                                    i = advancePIPClipDesigner.m18492a(advancePIPClipDesigner.bMM, advancePIPClipDesigner.bOK);
                                } else {
                                    i = 6;
                                }
                                if (i != 0 && i != 6) {
                                    advancePIPClipDesigner.bOK.mo34669jt(false);
                                    sendEmptyMessage(1111);
                                    break;
                                } else {
                                    sendEmptyMessageDelayed(1110, 50);
                                    break;
                                }
                            } else {
                                sendEmptyMessageDelayed(1110, 100);
                                break;
                            }
                        } else {
                            sendEmptyMessage(1111);
                            break;
                        }
                    case 1111:
                        C4586g.m11695Sl();
                        if (!advancePIPClipDesigner.cWz) {
                            DataItemProject aHe = advancePIPClipDesigner.bMM.aHe();
                            if (aHe != null) {
                                C8446b.aIZ().mo34319b(advancePIPClipDesigner.getApplicationContext(), aHe._id, 10);
                            }
                        }
                        DataItemProject aHe2 = advancePIPClipDesigner.bMM.aHe();
                        if (aHe2 != null) {
                            C8446b.aIZ().mo34319b(advancePIPClipDesigner.getApplicationContext(), aHe2._id, 10);
                            C8446b.aIZ().mo34320b(advancePIPClipDesigner.getApplicationContext(), aHe2._id, EditorRouter.ENTRANCE_PIP);
                        }
                        if (advancePIPClipDesigner.cWe != 1001) {
                            if (advancePIPClipDesigner.cWe != 1002) {
                                if (advancePIPClipDesigner.cWe != 1003) {
                                    advancePIPClipDesigner.finish();
                                    break;
                                } else {
                                    StudioRouter.launchStudioActivity(advancePIPClipDesigner);
                                    advancePIPClipDesigner.finish();
                                    break;
                                }
                            } else {
                                advancePIPClipDesigner.bMM.mo33877a((Handler) null, false);
                                advancePIPClipDesigner.finish();
                                advancePIPClipDesigner.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                                if (advancePIPClipDesigner.bMM.aHe() != null) {
                                    EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                                    editorIntentInfo.from = EditorRouter.ENTRANCE_PIP;
                                    EditorRouter.launchEditorActivity((Activity) advancePIPClipDesigner, editorIntentInfo);
                                    break;
                                }
                            }
                        } else {
                            if (advancePIPClipDesigner.cWd) {
                                ToastUtils.show(advancePIPClipDesigner.getApplicationContext(), R.string.xiaoying_str_com_saved_into_draft_box_tip, 1);
                            }
                            StudioRouter.launchStudioActivity(advancePIPClipDesigner);
                            advancePIPClipDesigner.finish();
                            break;
                        }
                        break;
                    case 1120:
                        if (advancePIPClipDesigner.cso == null) {
                            advancePIPClipDesigner.cso = new C8431d();
                            break;
                        }
                        break;
                    case 1130:
                        if (advancePIPClipDesigner.cWE != null) {
                            if (!advancePIPClipDesigner.cWE.aIH()) {
                                advancePIPClipDesigner.cti.setVisibility(0);
                                C6386d.m18368a(false, (View) advancePIPClipDesigner.bVT);
                                advancePIPClipDesigner.bVT.setVisibility(4);
                                advancePIPClipDesigner.cWk.setVisibility(4);
                                break;
                            } else {
                                advancePIPClipDesigner.cWk.setVisibility(0);
                                advancePIPClipDesigner.cWt.setEnabled(false);
                                advancePIPClipDesigner.bVT.setVisibility(0);
                                C6386d.m18368a(false, (View) advancePIPClipDesigner.bVT);
                                if (advancePIPClipDesigner.cWE.aIG()) {
                                    advancePIPClipDesigner.m18522eE(false);
                                    advancePIPClipDesigner.bVT.setVisibility(0);
                                    C6386d.m18368a(true, (View) advancePIPClipDesigner.bVT);
                                    advancePIPClipDesigner.cWt.setEnabled(true);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1140:
                        advancePIPClipDesigner.cls = false;
                        advancePIPClipDesigner.cWw.mo29607gf(true);
                        advancePIPClipDesigner.m18554w(true, false);
                        advancePIPClipDesigner.getClass();
                        new C6443c(false, false).execute((Params[]) new Void[0]);
                        break;
                    case IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL /*1310*/:
                        int i3 = message2.arg1;
                        long longValue = ((Long) message2.obj).longValue();
                        if (i3 == 16) {
                            VeMSize aJp = C8572y.aJp();
                            advancePIPClipDesigner.mStreamSizeVe.width = aJp.width;
                            advancePIPClipDesigner.mStreamSizeVe.height = aJp.height;
                        } else if (i3 == 8) {
                            VeMSize uw = C8572y.m25103uw(8);
                            advancePIPClipDesigner.mStreamSizeVe.width = uw.width;
                            advancePIPClipDesigner.mStreamSizeVe.height = uw.height;
                        }
                        if (advancePIPClipDesigner.mLayoutMode != i3) {
                            VeMSize veMSize = new VeMSize(advancePIPClipDesigner.mStreamSizeVe.width, advancePIPClipDesigner.mStreamSizeVe.height);
                            C8537n.m24810a(advancePIPClipDesigner.cVZ, longValue, veMSize);
                            C8572y.m25081b(advancePIPClipDesigner.cVZ, veMSize);
                            if (advancePIPClipDesigner.cso != null) {
                                advancePIPClipDesigner.cso.mo34191jn(false);
                            }
                            if (advancePIPClipDesigner.cWc) {
                                advancePIPClipDesigner.abs();
                            }
                            advancePIPClipDesigner.abu();
                            advancePIPClipDesigner.anD();
                        } else if (advancePIPClipDesigner.mTemplateID != longValue) {
                            VeMSize veMSize2 = new VeMSize(advancePIPClipDesigner.mStreamSizeVe.width, advancePIPClipDesigner.mStreamSizeVe.height);
                            C8537n.m24810a(advancePIPClipDesigner.cVZ, longValue, veMSize2);
                            C8572y.m25081b(advancePIPClipDesigner.cVZ, veMSize2);
                            advancePIPClipDesigner.anD();
                            advancePIPClipDesigner.m18543nP(0);
                        }
                        advancePIPClipDesigner.mLayoutMode = i3;
                        advancePIPClipDesigner.mTemplateID = longValue;
                        advancePIPClipDesigner.bOK.mo34669jt(true);
                        if (advancePIPClipDesigner.bMM.aJB() != null) {
                            advancePIPClipDesigner.bMM.aJB().mo34305jl(true);
                            break;
                        }
                        break;
                    case 10403:
                        if (advancePIPClipDesigner.cso != null) {
                            advancePIPClipDesigner.cso.aIt();
                            advancePIPClipDesigner.cso.aIu();
                        }
                        if (advancePIPClipDesigner.bMM != null) {
                            DataItemProject aHe3 = advancePIPClipDesigner.bMM.aHe();
                            if (aHe3 != null) {
                                String str = aHe3.strPrjURL;
                                if (!TextUtils.isEmpty(str)) {
                                    int nt = advancePIPClipDesigner.bMM.mo33889nt(str);
                                    if (nt >= 0) {
                                        if (aHe3.iPrjClipCount > 15) {
                                            C4586g.m11703a((Context) advancePIPClipDesigner, R.string.xiaoying_str_studio_task_state_canceling, (OnCancelListener) null);
                                        }
                                        advancePIPClipDesigner.bMM.mo34764i(advancePIPClipDesigner.bMM.aHf());
                                        advancePIPClipDesigner.bMM.mo34758ba(str, VideoEditorParams.ADVANCE_PRJ_BACKUP_FILE_EXT);
                                        advancePIPClipDesigner.bMM.ebQ = nt;
                                        C8410e.m24270gK(advancePIPClipDesigner.getApplicationContext());
                                        advancePIPClipDesigner.bMM.mo34733a(nt, advancePIPClipDesigner.bOK, (Handler) this);
                                        advancePIPClipDesigner.bOK.mo34669jt(false);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 10411:
                        Bundle data = message.getData();
                        Long valueOf = Long.valueOf(data.getLong("ttid"));
                        StringBuilder sb = new StringBuilder();
                        sb.append("MAIN_EVENT_DOWNLOAD_TEMPLATE action=");
                        sb.append(message2.arg1);
                        LogUtils.m14222e("AdvanceEditorPIPClipDesignerNew", sb.toString());
                        switch (message2.arg1) {
                            case 65282:
                                advancePIPClipDesigner.m18515d(valueOf.longValue(), message2.arg2);
                                break;
                            case 65283:
                                if (message2.arg2 == 131072) {
                                    if (advancePIPClipDesigner.bMP != null) {
                                        advancePIPClipDesigner.bMP.mo35059a((String) message2.obj, 10412, (String) null, data);
                                        break;
                                    }
                                } else {
                                    Message obtainMessage = obtainMessage(11413, data);
                                    obtainMessage.arg1 = -2;
                                    sendMessageDelayed(obtainMessage, 0);
                                    break;
                                }
                                break;
                        }
                    case 10412:
                        Bundle data2 = message.getData();
                        Long valueOf2 = Long.valueOf(data2.getLong("ttid"));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MAIN_EVENT_INSTALL_TEMPLATE action=");
                        sb2.append(message2.arg1);
                        LogUtils.m14222e("AdvanceEditorPIPClipDesignerNew", sb2.toString());
                        switch (message2.arg1) {
                            case 65282:
                                advancePIPClipDesigner.m18515d(valueOf2.longValue(), ((message2.arg2 * 10) / 100) + 90);
                                break;
                            case 65283:
                                if (message2.arg2 != 131072) {
                                    Message obtainMessage2 = obtainMessage(11413, data2);
                                    obtainMessage2.arg1 = -2;
                                    sendMessageDelayed(obtainMessage2, 0);
                                    break;
                                } else {
                                    Message obtainMessage3 = obtainMessage(11413, data2);
                                    obtainMessage3.arg1 = -1;
                                    sendMessageDelayed(obtainMessage3, 50);
                                    break;
                                }
                        }
                    case 11413:
                        Long valueOf3 = Long.valueOf(((Bundle) message2.obj).getLong("ttid"));
                        advancePIPClipDesigner.m18515d(valueOf3.longValue(), message2.arg1);
                        if (message2.arg1 == -1) {
                            UserEventDurationRelaUtils.finishDuraEventSuc(advancePIPClipDesigner.getApplicationContext(), C8450a.m24469bn(valueOf3.longValue()), "Template_Download_Direct", "list", C8762d.aMt().mo35241l(valueOf3.longValue(), 4), "pip");
                        } else {
                            UserEventDurationRelaUtils.finishDummyDuraEventFail(advancePIPClipDesigner.getApplicationContext(), C8450a.m24469bn(valueOf3.longValue()), "Template_Download_Direct", "list", C8762d.aMt().mo35241l(valueOf3.longValue(), 4), "pip", advancePIPClipDesigner.isFinishing());
                        }
                        if (valueOf3.longValue() == advancePIPClipDesigner.bNB) {
                            if (message2.arg1 == -1) {
                                if ((C8762d.aMt().mo35229bF(valueOf3.longValue()) & 8) != 8) {
                                    i2 = 16;
                                }
                                Message obtainMessage4 = obtainMessage(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL);
                                obtainMessage4.arg1 = i2;
                                obtainMessage4.obj = valueOf3;
                                sendMessage(obtainMessage4);
                            }
                            advancePIPClipDesigner.bNB = -1;
                            break;
                        }
                        break;
                    case 268443649:
                        if (advancePIPClipDesigner.bMM != null) {
                            ProjectItem ahP = advancePIPClipDesigner.bMM.aHf();
                            if (ahP != null) {
                                advancePIPClipDesigner.bMM.aJE();
                                if ((ahP.getCacheFlag() & 8) != 0) {
                                    sendEmptyMessage(268443657);
                                    break;
                                } else {
                                    advancePIPClipDesigner.bMM.mo33877a((Handler) this, true);
                                    break;
                                }
                            }
                        }
                        break;
                    case 268443650:
                    case 268443651:
                        C4586g.m11695Sl();
                        if (advancePIPClipDesigner.bMM != null) {
                            advancePIPClipDesigner.bMM.mo34775oH(VideoEditorParams.ADVANCE_PRJ_BACKUP_FILE_EXT);
                        }
                        sendEmptyMessage(1111);
                        break;
                    case 268443657:
                        C4586g.m11695Sl();
                        if (advancePIPClipDesigner.bMM != null) {
                            advancePIPClipDesigner.bMM.mo34775oH(VideoEditorParams.ADVANCE_PRJ_BACKUP_FILE_EXT);
                        }
                        sendEmptyMessage(1111);
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.pip.AdvancePIPClipDesigner$c */
    class C6443c extends ExAsyncTask<Void, Void, Boolean> {
        private boolean cWO = false;
        private boolean cWP = false;

        public C6443c(boolean z, boolean z2) {
            this.cWO = z;
            this.cWP = z2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            if (this.cWO) {
                AdvancePIPClipDesigner.this.m18528gd(this.cWP);
            } else {
                AdvancePIPClipDesigner.this.m18544nQ(-1);
                AdvancePIPClipDesigner.this.bOK.mo34669jt(true);
            }
            return Boolean.valueOf(true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            AdvancePIPClipDesigner.this.cls = true;
            if (AdvancePIPClipDesigner.this.cWB) {
                AdvancePIPClipDesigner.this.cso.mo34196uf(AdvancePIPClipDesigner.this.cWC);
            } else {
                AdvancePIPClipDesigner.this.anF();
            }
        }
    }

    /* renamed from: com.introvd.template.editor.pip.AdvancePIPClipDesigner$d */
    private static class C6444d extends Handler {
        private WeakReference<AdvancePIPClipDesigner> csX = null;

        public C6444d(AdvancePIPClipDesigner advancePIPClipDesigner) {
            this.csX = new WeakReference<>(advancePIPClipDesigner);
        }

        public void handleMessage(Message message) {
            AdvancePIPClipDesigner advancePIPClipDesigner = (AdvancePIPClipDesigner) this.csX.get();
            if (advancePIPClipDesigner != null) {
                if (advancePIPClipDesigner.bOK != null) {
                    advancePIPClipDesigner.bOK.mo34669jt(false);
                }
                advancePIPClipDesigner.cFO = false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m18492a(C8522g gVar, C8501a aVar) {
        if (!aVar.isProjectModified()) {
            return 0;
        }
        int i = 1;
        this.cFO = true;
        if (!this.cWz) {
            if (gVar != null) {
                gVar.mo34761d(this.cVZ, 0);
            }
            this.cWz = true;
        }
        if (gVar != null) {
            gVar.mo34765i(new VeMSize(this.mStreamSizeVe.width, this.mStreamSizeVe.height));
        }
        LogUtils.m14223i(TAG, "defaultSaveProject in");
        if (gVar != null) {
            C8522g gVar2 = gVar;
            C8501a aVar2 = aVar;
            i = gVar2.mo34730a(true, aVar2, (Handler) new C6444d(this), AppStateModel.getInstance().isCommunitySupport(), gVar.mo34778uz(gVar.ebQ));
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("defaultSaveProject out");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
        if (i != 0) {
            this.cFO = false;
        }
        return i;
    }

    /* renamed from: a */
    private QSessionStream m18498a(SurfaceHolder surfaceHolder) {
        QDisplayContext c = C8571x.m25060c(this.mStreamSizeVe.width, this.mStreamSizeVe.height, 1, surfaceHolder);
        C8563r.m25047e(this.cVZ);
        return C8563r.m25046a(this.cVZ, c.getScreenRect(), c.getResampleMode(), c.getRotation(), this.csD);
    }

    /* access modifiers changed from: private */
    public void abK() {
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", ">>>>>>>>>>>> stopTrickPlay.");
        if (this.cst != null) {
            this.cst.aIq();
        }
        this.cst = null;
    }

    private void anC() {
        if ((C8762d.aMt().mo35229bF(this.mTemplateID) & 8) == 8) {
            this.mStreamSizeVe = C8572y.m25103uw(8);
            this.mLayoutMode = 8;
            return;
        }
        this.mStreamSizeVe = C8572y.aJp();
        this.mLayoutMode = 16;
    }

    /* access modifiers changed from: private */
    public void anD() {
        if (this.cWE == null) {
            this.cWE = new C6453b(this.ctD);
        }
        this.cWE.mo34109a(this.bUr);
        this.cWE.mo29620a(this.cWJ);
        this.cWE.mo34112c(this.cWh);
        this.cWE.mo34115ui(R.drawable.editor_pip_add_clip_btn_selector);
        this.cWE.mo34114s(C8572y.m25067a(this.cVZ, this.cWh));
        this.cWE.refreshView();
        this.cWF.sendEmptyMessage(1130);
    }

    private boolean anE() {
        if (this.bMM != null) {
            QStoryboard aHd = this.bMM.aHd();
            if (aHd != null) {
                this.cVZ = C8540q.m24909R(aHd);
                if (this.cVZ != null) {
                    this.mTemplateID = this.cVZ.getSceneTemplate();
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void anF() {
        this.csy = true;
        m18518dO(false);
    }

    /* access modifiers changed from: private */
    public void anG() {
        this.cso = new C8431d();
        this.cso.mo34191jn(true);
        boolean a = this.cso.mo34169a(m18498a(this.csO), getPlayCallback(), this.cWh, 0, this.bOK.aJv(), this.csO);
        StringBuilder sb = new StringBuilder();
        sb.append("BASIC_EVENT_MSG_INIT_MEDIAPLAYER initResult=");
        sb.append(a);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
        this.cso.mo34191jn(true);
        this.cso.aIB();
    }

    private void anH() {
        C8978m.m26349hs(this).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10303dv(R.string.xiaoying_str_com_save_title).mo10299dr(R.string.xiaoying_str_com_discard_title).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                AdvancePIPClipDesigner.this.cWe = 1003;
                AdvancePIPClipDesigner.this.cWF.sendEmptyMessage(1110);
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                if (AdvancePIPClipDesigner.this.cso != null) {
                    AdvancePIPClipDesigner.this.cso.aIt();
                }
                if (AdvancePIPClipDesigner.this.bMM != null) {
                    AdvancePIPClipDesigner.this.bMM.mo34763h(AdvancePIPClipDesigner.this.getContentResolver());
                }
                AdvancePIPClipDesigner.this.bOK.mo34669jt(false);
                AdvancePIPClipDesigner.this.finish();
                AdvancePIPClipDesigner.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void anI() {
        if (this.bMn && (this.cWE == null || !this.cWE.aIG())) {
            if (this.cso != null) {
                this.cso.aIt();
                this.cso.aIv();
                this.cso = null;
            }
            if (this.bMM != null) {
                this.bMM.mo34763h(getContentResolver());
            }
            this.bOK.mo34669jt(false);
            finish();
        } else if (this.bMn) {
            anH();
        } else if (this.bOK.isProjectModified() || this.bMM.mo34772oE(VideoEditorParams.ADVANCE_PRJ_BACKUP_FILE_EXT)) {
            C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    AdvancePIPClipDesigner.this.cWe = 1003;
                    AdvancePIPClipDesigner.this.cWF.sendEmptyMessage(10403);
                }
            }).mo10313qu().show();
        } else {
            this.cWe = 1003;
            this.cWF.sendEmptyMessage(1110);
        }
    }

    /* access modifiers changed from: private */
    public void anJ() {
        if (this.cWw != null) {
            this.cWw.anM();
        }
        m18513cE(0, 1);
        this.bOK.mo34669jt(true);
        if (this.bMM.aJB() != null) {
            this.bMM.aJB().mo34305jl(true);
        }
    }

    /* renamed from: b */
    private boolean m18509b(QEngine qEngine) {
        TrimedClipItemDataModel trimedClipItemDataModel;
        TrimedClipItemDataModel trimedClipItemDataModel2;
        if (this.cVY == null) {
            this.cVY = new ArrayList<>();
            TrimedClipItemDataModel trimedClipItemDataModel3 = new TrimedClipItemDataModel();
            trimedClipItemDataModel3.mRawFilePath = "assets_android://xiaoying/pipdefaultfile/xiaoying_pip_green_item.png";
            TrimedClipItemDataModel trimedClipItemDataModel4 = new TrimedClipItemDataModel();
            trimedClipItemDataModel4.mRawFilePath = "assets_android://xiaoying/pipdefaultfile/xiaoying_pip_yellow_item.png";
            this.cVY.add(trimedClipItemDataModel3);
            this.cVY.add(trimedClipItemDataModel4);
        }
        if (this.cVY == null || this.cVY.size() <= 0) {
            return false;
        }
        if (this.cVY.size() == 1) {
            trimedClipItemDataModel = (TrimedClipItemDataModel) this.cVY.get(0);
            trimedClipItemDataModel2 = (TrimedClipItemDataModel) this.cVY.get(0);
        } else {
            trimedClipItemDataModel = (TrimedClipItemDataModel) this.cVY.get(0);
            trimedClipItemDataModel2 = (TrimedClipItemDataModel) this.cVY.get(1);
        }
        this.cVZ = C8537n.m24798a(qEngine, this.mStreamSizeVe, this.mTemplateID, trimedClipItemDataModel, trimedClipItemDataModel2);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: cE */
    public int m18513cE(int i, int i2) {
        int a = C8537n.m24791a(this.cVZ, i, i2);
        if (a == 0) {
            C8572y.m25081b(this.cVZ, this.mStreamSizeVe);
            anD();
            m18543nP(-1);
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18515d(long j, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress templateId=");
        sb.append(j);
        sb.append(";progress=");
        sb.append(i);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
        if (this.cWD != null) {
            this.cWD.mo29634e(j, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dO */
    public void m18518dO(boolean z) {
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", ">>>>>>>>>>>> startTrickPlay.");
        if (this.cst != null) {
            try {
                this.cst.interrupt();
            } catch (Exception unused) {
            }
            this.cst = null;
        }
        if (this.cst == null) {
            this.cst = new C8425b(this.cso, z, this.cWG);
            this.cst.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eE */
    public void m18522eE(boolean z) {
        if (this.cWE == null || !this.cWE.aIH()) {
            this.cti.setVisibility(0);
            this.cWi.setVisibility(4);
        } else if (z) {
            this.cti.setVisibility(8);
            this.cWi.setVisibility(0);
        } else {
            this.cti.setVisibility(0);
            this.cWi.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gd */
    public void m18528gd(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        C8537n.m24808a(this.cVZ, 0, new VeRange(0, -1));
        C8537n.m24808a(this.cVZ, 1, new VeRange(0, -1));
        StringBuilder sb = new StringBuilder();
        sb.append("buildPlayerInSingleMode time consume:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
        m18543nP(-1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("buildPlayerInSingleMode time consume2:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb2.toString());
    }

    private int getDuration() {
        if (this.cso == null) {
            return 0;
        }
        int agX = this.cso.agX();
        VeRange aIC = this.cso.aIC();
        if (aIC != null) {
            agX = aIC.getmTimeLength();
        }
        return agX;
    }

    private C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6441a();
        }
        return this.cTW;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m18530h(long j, String str) {
        if (!BaseSocialNotify.isNetworkAvaliable(getApplicationContext())) {
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 0);
            return;
        }
        if (this.bMP == null) {
            this.bMP = new C8692b(getApplicationContext(), this.cWF);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("ttid", j);
        int a = this.bMP.mo35058a(j, 10411, bundle);
        String bn = C8450a.m24469bn(j);
        UserEventDurationRelaUtils.startDurationEvent(bn, a, "");
        UserEventDurationRelaUtils.dummyXytDownloadStartEvent(getApplicationContext(), str, "pip", bn);
    }

    private void initUI() {
        this.csN = (SurfaceView) findViewById(R.id.previewview);
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.ctD = (RelativeLayout) findViewById(R.id.preview_layout_fake);
        this.csQ = (RelativeLayout) findViewById(R.id.layout_preview_background);
        this.cWn = (RelativeLayout) findViewById(R.id.btns_layout2);
        this.cWo = (RelativeLayout) findViewById(R.id.btns_layout);
        this.cWp = (RelativeLayout) findViewById(R.id.xiaoying_ve_pip_bottom_hide_view);
        this.cWq = (RelativeLayout) findViewById(R.id.layout_time_show);
        this.cWr = (RelativeLayout) findViewById(R.id.relativelayout_trimgallery_content_area);
        this.cWt = (ImageButton) findViewById(R.id.xiaoying_ve_pip_btn_trim);
        this.cWv = (ImageButton) findViewById(R.id.xiaoying_btn_hide);
        this.cWs = (ImageButton) findViewById(R.id.btn_text_ok);
        this.cau = (ImageView) findViewById(R.id.xiaoying_com_btn_left);
        this.cau.setImageResource(R.drawable.v4_xiaoying_cam_btn_cam_cancel_selector);
        this.bVT = (ImageView) findViewById(R.id.btn_import_finish);
        this.bVT.setImageResource(R.drawable.v4_xiaoying_com_btn_ok_selector);
        this.cAF = (SeekBar) findViewById(R.id.seekbar_simple_edit);
        this.cWk = (RelativeLayout) findViewById(R.id.relativelayout_seekbar);
        this.cWl = (TextView) findViewById(R.id.txtview_cur_time);
        this.cWm = (TextView) findViewById(R.id.txtview_duration);
        mo29514Yt();
        this.cti = (ImageButton) findViewById(R.id.btn_play);
        this.cWi = (ImageButton) findViewById(R.id.btn_pause);
        this.cWj = (ImageButton) findViewById(R.id.xiaoying_ve_preview_layout_captrue);
        this.cWu = (ImageButton) findViewById(R.id.xiaoying_ve_pip_btn_exchagne);
        this.cti.setOnClickListener(this.f3507po);
        this.cWi.setOnClickListener(this.f3507po);
        this.cWj.setOnClickListener(this.f3507po);
        this.cWu.setOnClickListener(this.f3507po);
        this.ctD.setOnClickListener(this.f3507po);
        this.bVT.setOnClickListener(this.f3507po);
        this.cWt.setOnClickListener(this.f3507po);
        this.cWv.setOnClickListener(this.f3507po);
        this.cWs.setOnClickListener(this.f3507po);
        this.cau.setOnClickListener(this.f3507po);
        this.cWD = new C6459d((RelativeLayout) findViewById(R.id.relativelayout_tool_list_content), this.cWF);
        this.cWD.mo29630a(this.cWI);
        this.cWD.mo29631aC(this.mTemplateID);
        this.cWD.aod();
    }

    /* renamed from: nO */
    private int m18542nO(int i) {
        if (this.cso == null) {
            return i;
        }
        VeRange aIC = this.cso.aIC();
        return aIC != null ? i - aIC.getmPosition() : i;
    }

    /* access modifiers changed from: private */
    /* renamed from: nP */
    public void m18543nP(int i) {
        if (this.cso != null) {
            long currentTimeMillis = System.currentTimeMillis();
            QSessionStream a = m18498a(this.csO);
            StringBuilder sb = new StringBuilder();
            sb.append("rebuildPlayer time consume:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
            this.cso.setDisplayContext(C8571x.m25060c(this.cWh.width, this.cWh.height, 1, this.csO));
            this.cso.mo34191jn(true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rebuildPlayer time consume2:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb2.toString());
            this.cso.mo34168a(a, i);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("rebuildPlayer time consume3:");
            sb3.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb3.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nQ */
    public void m18544nQ(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        int gg = this.cWw.mo29608gg(true);
        Range gh = this.cWw.mo29609gh(true);
        int gg2 = this.cWw.mo29608gg(false);
        Range gh2 = this.cWw.mo29609gh(false);
        int i2 = gh2.getmTimeLength();
        int i3 = gh.getmTimeLength();
        if (i2 > i3) {
            i2 = i3;
        }
        gh2.setmTimeLength(i2);
        gh.setmTimeLength(i2);
        VeRange veRange = new VeRange(gh2.getmPosition(), gh2.getmTimeLength());
        VeRange veRange2 = new VeRange(gh.getmPosition(), gh.getmTimeLength());
        C8537n.m24808a(this.cVZ, gg2, veRange);
        C8537n.m24808a(this.cVZ, gg, veRange2);
        StringBuilder sb = new StringBuilder();
        sb.append("buildPlayerInDoubleMode time consume:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
        m18543nP(i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("buildPlayerInDoubleMode time consume2:");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb2.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m18554w(boolean z, boolean z2) {
        int i = 0;
        if (!z) {
            int gi = this.cWw.mo29610gi(!z2);
            int gg = z2 ? this.cWw.mo29608gg(true) : this.cWw.mo29608gg(false);
            C8537n.m24806a(this.cVZ, gg, 0, false);
            QSceneClip qSceneClip = this.cVZ;
            if (gg == 0) {
                i = 1;
            }
            C8537n.m24806a(qSceneClip, i, gi, true);
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekEnd singleFramePosition=");
            sb.append(gi);
            LogUtils.m14222e(str, sb.toString());
            return;
        }
        C8537n.m24806a(this.cVZ, 0, 0, false);
        C8537n.m24806a(this.cVZ, 1, 0, false);
    }

    /* renamed from: Yt */
    public void mo29514Yt() {
        int duration = getDuration();
        int nO = this.cso != null ? m18542nO(this.cso.aIx()) : 0;
        this.cAF.setMax(duration);
        this.cAF.setProgress(nO);
        this.cAF.setOnSeekBarChangeListener(this.cWH);
        this.cWm.setText(C4580b.m11637V((long) duration));
        this.cWl.setText(C4580b.m11637V((long) nO));
    }

    /* access modifiers changed from: protected */
    public boolean abF() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void abs() {
        if (this.csQ != null) {
            if (this.cWc) {
                this.cWg = C8569v.m25057a(this.mStreamSizeVe, this.cWf);
                if (this.cWg != null) {
                    LayoutParams layoutParams = (LayoutParams) this.csQ.getLayoutParams();
                    layoutParams.width = this.cWg.width;
                    layoutParams.height = this.cWg.width;
                    this.csQ.setLayoutParams(layoutParams);
                    this.csQ.invalidate();
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) this.csQ.getLayoutParams();
                layoutParams2.width = this.cWg.width;
                layoutParams2.height = this.cWg.width;
                this.csQ.setLayoutParams(layoutParams2);
                this.csQ.invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void abt() {
        if (this.csN != null) {
            this.csN.setVisibility(0);
            this.csO = this.csN.getHolder();
            if (this.csO != null) {
                this.csO.addCallback(this.cWK);
                this.csO.setType(2);
                this.csO.setFormat(1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void abu() {
        this.cWh = C8572y.m25090e(this.mStreamSizeVe, this.cWg);
        if (this.cWh != null && this.bMj != null && this.csQ != null) {
            LayoutParams layoutParams = new LayoutParams(this.cWh.width, this.cWh.height);
            layoutParams.addRule(13, 1);
            this.bMj.setLayoutParams(layoutParams);
            this.bMj.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void abv() {
        if (this.csy) {
            if (this.cst != null) {
                this.cst.aIr();
            }
            this.csy = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ks */
    public int mo29520ks(int i) {
        mo29514Yt();
        m18522eE(false);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kt */
    public int mo29521kt(int i) {
        m18522eE(true);
        updateProgress(i);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ku */
    public int mo29522ku(int i) {
        m18522eE(this.csy);
        updateProgress(i);
        m18522eE(false);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kv */
    public int mo29523kv(int i) {
        if (this.cWw != null) {
            this.cWw.setPlaying(false);
        }
        updateProgress(i);
        m18522eE(false);
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.cWa = false;
        } else if (i == 10001) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) intent.getExtras().get(GalleryRouter.INTENT_DATA_BACK_KEY);
            if (trimedClipItemDataModel != null) {
                boolean isFileExisted = FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath);
                boolean isFileExisted2 = FileUtils.isFileExisted(trimedClipItemDataModel.mRawFilePath);
                if (isFileExisted || isFileExisted2) {
                    if (this.cso != null) {
                        this.cso.aIt();
                        this.cso.aIu();
                    }
                    Message obtainMessage = this.cWF.obtainMessage(1001);
                    obtainMessage.arg1 = this.cWb;
                    obtainMessage.obj = trimedClipItemDataModel;
                    this.cWF.sendMessageDelayed(obtainMessage, 50);
                    this.bOK.mo34669jt(true);
                    if (this.bMM.aJB() != null) {
                        this.bMM.aJB().mo34305jl(true);
                    }
                    return;
                }
            }
            this.cWa = false;
        } else {
            this.cWa = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(23);
        this.csD = this.csC ? 4 : 2;
        Intent intent = getIntent();
        this.bOK = C8501a.aJs();
        this.bMM = C8522g.aJA();
        if (this.bMM == null || this.bOK == null) {
            finish();
            return;
        }
        this.bMn = intent.getIntExtra("new_prj", 1) == 1;
        this.cWc = true;
        setContentView(R.layout.editor_act_pip_disign_layout);
        VeMSize veMSize = new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().width);
        this.cWg = veMSize;
        this.cWf = veMSize;
        if (this.cWc) {
            VeMSize veMSize2 = new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().height - ((int) (getResources().getDimension(R.dimen.v2_panel_top_height) + getResources().getDimension(R.dimen.xiaoying_ve_pip_design_bottom_view_hvga_height))));
            this.cWg = veMSize2;
            this.cWf = veMSize2;
        }
        String stringExtra = intent.getStringExtra("activityID");
        DataItemProject aHe = this.bMM.aHe();
        if (aHe != null && !TextUtils.isEmpty(stringExtra)) {
            aHe.strActivityData = stringExtra;
        }
        this.cWz = anE();
        if (this.cWz) {
            anC();
            if (this.cVY == null || this.cVY.size() < 1) {
                this.cVY = C8537n.m24814b(this.cVZ);
            } else {
                QEngine aJv = this.bOK.aJv();
                C8537n.m24803a(aJv, this.cVZ, 0, (TrimedClipItemDataModel) this.cVY.get(0));
                C8537n.m24803a(aJv, this.cVZ, 1, (TrimedClipItemDataModel) (this.cVY.size() == 2 ? this.cVY.get(1) : this.cVY.get(0)));
                this.bOK.mo34669jt(true);
                if (this.bMM.aJB() != null) {
                    this.bMM.aJB().mo34305jl(true);
                }
            }
        } else {
            C8759b bVar = new C8759b(12);
            bVar.mo35198a(getApplicationContext(), -1, C8762d.aMt().mo35247vn(16), AppStateModel.getInstance().isInChina());
            EffectInfoModel vh = bVar.mo35214vh(0);
            if (vh == null) {
                finish();
                return;
            }
            this.mTemplateID = vh.mTemplateId;
            anC();
            m18509b(this.bOK.aJv());
            C8572y.m25081b(this.cVZ, this.mStreamSizeVe);
            this.bOK.mo34669jt(true);
            if (this.bMM.aJB() != null) {
                this.bMM.aJB().mo34305jl(true);
            }
        }
        initUI();
        abs();
        abu();
        abt();
        anD();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.cWD != null) {
            this.cWD.aob();
            this.cWD = null;
        }
        if (this.cWE != null) {
            this.cWE.aob();
            this.cWE = null;
        }
        if (this.cWw != null) {
            this.cWw.destroy();
            this.cWw = null;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.cWx) {
            if (this.cso != null) {
                this.cso.pause();
            }
            this.cWF.removeMessages(1015);
            this.cWF.sendEmptyMessage(1015);
            return true;
        }
        if (this.cso != null) {
            this.cso.pause();
        }
        anI();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UserBehaviorLog.onPause(this);
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
        boolean e = C8572y.m25092e(this.bOK.aJv());
        abv();
        if (this.cso != null) {
            this.cso.pause();
            this.cso.mo34191jn(false);
            this.cso.aIt();
            if (e) {
                this.cso.aIv();
                this.cso = null;
            }
        }
        if (!this.cFO) {
            this.cWd = this.bOK.isProjectModified();
            m18492a(this.bMM, this.bOK);
        }
        if (isFinishing() && this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
        this.csE = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(true));
        this.csF = false;
        this.csE = false;
    }

    public void updateProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress progress=");
        sb.append(i);
        LogUtils.m14223i("AdvanceEditorPIPClipDesignerNew", sb.toString());
        if (!this.cWx) {
            int nO = m18542nO(i);
            if (!this.csy) {
                this.cAF.setProgress(nO);
            }
            this.cWl.setText(C4580b.m11637V((long) nO));
        } else if (this.cWw != null && !this.csy) {
            this.cWw.updateProgress(i);
        }
    }
}
