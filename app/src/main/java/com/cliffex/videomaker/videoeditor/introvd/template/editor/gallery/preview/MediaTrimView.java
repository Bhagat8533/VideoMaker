package com.introvd.template.editor.gallery.preview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.p024v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.chrisbanes.photoview.PhotoView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.trim.C5822a;
import com.introvd.template.editor.clipedit.trim.C5822a.C5829c;
import com.introvd.template.editor.clipedit.trim.C5822a.C5830d;
import com.introvd.template.editor.clipedit.trim.C5832c;
import com.introvd.template.editor.gallery.C6344b;
import com.introvd.template.editor.gallery.C6348d;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p246c.C5689c;
import com.introvd.template.editor.p266h.C6414r;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p320j.C7547a;
import com.introvd.template.sdk.editor.cache.C8442c;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.utils.C8500b;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p397d.C8547b;
import com.introvd.template.xyui.ripple.C9175b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.p489b.C9963d;
import p037b.p050b.C1485a;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p037b.p050b.p077k.C1830a;
import p037b.p050b.p077k.C1833c;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

public class MediaTrimView extends RelativeLayout implements Callback {
    /* access modifiers changed from: private */
    public C8501a bOK;
    /* access modifiers changed from: private */
    public C5822a cCF;
    /* access modifiers changed from: private */
    public boolean cDA;
    /* access modifiers changed from: private */
    public C1833c<C6363a> cSJ;
    public boolean cTC;
    private C6651b cTD;
    private C6651b cTE;
    private C6361a cTF;
    /* access modifiers changed from: private */
    public C8442c cTG;
    /* access modifiers changed from: private */
    public Map<String, C6364b> cTH;
    /* access modifiers changed from: private */
    public C6364b cTI;
    public QStoryboard cTJ;
    /* access modifiers changed from: private */
    public boolean cTK;
    /* access modifiers changed from: private */
    public C8421a cTL;
    /* access modifiers changed from: private */
    public C9963d cTM;
    /* access modifiers changed from: private */
    public boolean cTN;
    private LinearLayout cTO;
    private LinearLayoutCompat cTP;
    /* access modifiers changed from: private */
    public ImageButton cTQ;
    /* access modifiers changed from: private */
    public ImageButton cTR;
    private RelativeLayout cTS;
    /* access modifiers changed from: private */
    public ImageButton cTT;
    /* access modifiers changed from: private */
    public ImageButton cTU;
    /* access modifiers changed from: private */
    public VeMSize cTV;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public PhotoView cTX;
    /* access modifiers changed from: private */
    public volatile C6363a cTY;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    private C5689c cUa;
    private RelativeLayout cUb;
    private View cUc;
    private TextView cUd;
    private volatile String cUe;
    /* access modifiers changed from: private */
    public boolean cUf;
    /* access modifiers changed from: private */
    public ImageView cUg;
    private RelativeLayout cUh;
    C5829c cUi;
    C5830d cUj;
    private OnClickListener cUk;
    private volatile boolean csC;
    protected volatile int csD;
    protected int csL;
    protected SurfaceView csN;
    protected SurfaceHolder csO;
    /* access modifiers changed from: private */
    public C8431d cso;
    private boolean isPaused;
    /* access modifiers changed from: private */
    public VeMSize mStreamSizeVe;

    /* renamed from: com.introvd.template.editor.gallery.preview.MediaTrimView$a */
    public interface C6361a {
        boolean amF();
    }

    /* renamed from: com.introvd.template.editor.gallery.preview.MediaTrimView$b */
    private class C6362b implements C8434c {
        public C6362b() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    if (MediaTrimView.this.cso != null) {
                        int aIx = MediaTrimView.this.cso.aIx();
                        StringBuilder sb = new StringBuilder();
                        sb.append("PlaybackModule progress=");
                        sb.append(aIx);
                        LogUtilsV2.m14230i(sb.toString());
                        MediaTrimView.this.cso.mo34191jn(true);
                        MediaTrimView.this.cso.aIB();
                        MediaTrimView.this.m18271nF(aIx);
                        if (MediaTrimView.this.cTI != null && MediaTrimView.this.cTI.cTz != null && MediaTrimView.this.cTI.cTz.action == 0) {
                            MediaTrimView.this.startPreview();
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    C4597i.m11728a(true, (Activity) MediaTrimView.this.getContext());
                    MediaTrimView.this.m18270nE(i2);
                    return;
                case 4:
                    C4597i.m11728a(false, (Activity) MediaTrimView.this.getContext());
                    MediaTrimView.this.m18269nD(i2);
                    return;
                case 5:
                    C4597i.m11728a(false, (Activity) MediaTrimView.this.getContext());
                    if (MediaTrimView.this.cso != null) {
                        MediaTrimView.this.cso.aID();
                    }
                    if (MediaTrimView.this.cCF != null) {
                        MediaTrimView.this.cCF.setPlaying(false);
                    }
                    MediaTrimView.this.m18268nC(i2);
                    return;
                default:
                    return;
            }
        }
    }

    public MediaTrimView(Context context) {
        super(context);
        this.csC = C8549f.aJd() && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        this.csL = 1;
        this.cTC = false;
        this.cTG = new C8442c();
        this.csD = 2;
        this.cTH = new HashMap();
        this.cTK = false;
        this.isPaused = false;
        this.cTN = false;
        this.mStreamSizeVe = null;
        this.cTV = null;
        this.cso = null;
        this.cDA = false;
        this.cUi = new C5829c() {
            public void afS() {
                MediaTrimView.this.adX();
                MediaTrimView.this.cTN = true;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
            }

            /* renamed from: lr */
            public void mo28063lr(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: ls */
            public void mo28064ls(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, true));
                    MediaTrimView.this.cTL.aIp();
                }
            }
        };
        this.cUj = new C5830d() {
            private boolean cUr = false;

            /* renamed from: eH */
            public void mo28118eH(boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimStart isLeft=");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                MediaTrimView.this.adX();
                if (MediaTrimView.this.cCF != null) {
                    MediaTrimView.this.cCF.setPlaying(false);
                }
                this.cUr = z;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
                MediaTrimView.this.cDA = !z;
            }

            /* renamed from: ly */
            public void mo28119ly(int i) {
                LogUtilsV2.m14227d("onTrimPosChange = ");
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: lz */
            public int mo28120lz(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimEnd position=");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                    MediaTrimView.this.cTL.aIp();
                }
                MediaTrimView.this.m18264k(this.cUr, i);
                C6344b.m18174bu(MediaTrimView.this.getContext().getApplicationContext(), this.cUr ? TtmlNode.LEFT : TtmlNode.RIGHT);
                return 0;
            }
        };
        this.cUk = new OnClickListener() {
            public void onClick(View view) {
                if (view.equals(MediaTrimView.this.cTQ)) {
                    if (MediaTrimView.this.cso != null) {
                        if (MediaTrimView.this.cso.isPlaying()) {
                            MediaTrimView.this.adX();
                        } else {
                            MediaTrimView.this.startPreview();
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTR)) {
                    if (!(MediaTrimView.this.cTI == null || MediaTrimView.this.cTI.cTz == null || MediaTrimView.this.cCF == null)) {
                        C5832c agp = MediaTrimView.this.cCF.agp();
                        if (agp != null && MediaTrimView.this.cTG != null) {
                            MediaTrimView.this.cTC = true;
                            MediaTrimView.this.mo29390nH(1);
                            int agB = agp.agB();
                            C6348d.amK().mo29374f(MediaTrimView.this.m18231a(MediaTrimView.this.cTI, new Range(agB, agp.agC() - agB), false, MediaTrimView.this.cTG.getWidth(), MediaTrimView.this.cTG.getHeight(), MediaTrimView.this.cTG.aHX(), MediaTrimView.this.cTG.aIi()));
                            MediaTrimView.this.anb();
                            C6344b.m18184fb(MediaTrimView.this.getContext());
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTT) || view.equals(MediaTrimView.this.cTU)) {
                    MediaTrimView.this.ana();
                }
            }
        };
        m18250c((AttributeSet) null, 0);
    }

    public MediaTrimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csC = C8549f.aJd() && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        this.csL = 1;
        this.cTC = false;
        this.cTG = new C8442c();
        this.csD = 2;
        this.cTH = new HashMap();
        this.cTK = false;
        this.isPaused = false;
        this.cTN = false;
        this.mStreamSizeVe = null;
        this.cTV = null;
        this.cso = null;
        this.cDA = false;
        this.cUi = new C5829c() {
            public void afS() {
                MediaTrimView.this.adX();
                MediaTrimView.this.cTN = true;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
            }

            /* renamed from: lr */
            public void mo28063lr(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: ls */
            public void mo28064ls(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, true));
                    MediaTrimView.this.cTL.aIp();
                }
            }
        };
        this.cUj = new C5830d() {
            private boolean cUr = false;

            /* renamed from: eH */
            public void mo28118eH(boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimStart isLeft=");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                MediaTrimView.this.adX();
                if (MediaTrimView.this.cCF != null) {
                    MediaTrimView.this.cCF.setPlaying(false);
                }
                this.cUr = z;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
                MediaTrimView.this.cDA = !z;
            }

            /* renamed from: ly */
            public void mo28119ly(int i) {
                LogUtilsV2.m14227d("onTrimPosChange = ");
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: lz */
            public int mo28120lz(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimEnd position=");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                    MediaTrimView.this.cTL.aIp();
                }
                MediaTrimView.this.m18264k(this.cUr, i);
                C6344b.m18174bu(MediaTrimView.this.getContext().getApplicationContext(), this.cUr ? TtmlNode.LEFT : TtmlNode.RIGHT);
                return 0;
            }
        };
        this.cUk = new OnClickListener() {
            public void onClick(View view) {
                if (view.equals(MediaTrimView.this.cTQ)) {
                    if (MediaTrimView.this.cso != null) {
                        if (MediaTrimView.this.cso.isPlaying()) {
                            MediaTrimView.this.adX();
                        } else {
                            MediaTrimView.this.startPreview();
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTR)) {
                    if (!(MediaTrimView.this.cTI == null || MediaTrimView.this.cTI.cTz == null || MediaTrimView.this.cCF == null)) {
                        C5832c agp = MediaTrimView.this.cCF.agp();
                        if (agp != null && MediaTrimView.this.cTG != null) {
                            MediaTrimView.this.cTC = true;
                            MediaTrimView.this.mo29390nH(1);
                            int agB = agp.agB();
                            C6348d.amK().mo29374f(MediaTrimView.this.m18231a(MediaTrimView.this.cTI, new Range(agB, agp.agC() - agB), false, MediaTrimView.this.cTG.getWidth(), MediaTrimView.this.cTG.getHeight(), MediaTrimView.this.cTG.aHX(), MediaTrimView.this.cTG.aIi()));
                            MediaTrimView.this.anb();
                            C6344b.m18184fb(MediaTrimView.this.getContext());
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTT) || view.equals(MediaTrimView.this.cTU)) {
                    MediaTrimView.this.ana();
                }
            }
        };
        m18250c(attributeSet, 0);
    }

    public MediaTrimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csC = C8549f.aJd() && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        this.csL = 1;
        this.cTC = false;
        this.cTG = new C8442c();
        this.csD = 2;
        this.cTH = new HashMap();
        this.cTK = false;
        this.isPaused = false;
        this.cTN = false;
        this.mStreamSizeVe = null;
        this.cTV = null;
        this.cso = null;
        this.cDA = false;
        this.cUi = new C5829c() {
            public void afS() {
                MediaTrimView.this.adX();
                MediaTrimView.this.cTN = true;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
            }

            /* renamed from: lr */
            public void mo28063lr(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: ls */
            public void mo28064ls(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, true));
                    MediaTrimView.this.cTL.aIp();
                }
            }
        };
        this.cUj = new C5830d() {
            private boolean cUr = false;

            /* renamed from: eH */
            public void mo28118eH(boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimStart isLeft=");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                MediaTrimView.this.adX();
                if (MediaTrimView.this.cCF != null) {
                    MediaTrimView.this.cCF.setPlaying(false);
                }
                this.cUr = z;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
                MediaTrimView.this.cDA = !z;
            }

            /* renamed from: ly */
            public void mo28119ly(int i) {
                LogUtilsV2.m14227d("onTrimPosChange = ");
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
            }

            /* renamed from: lz */
            public int mo28120lz(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimEnd position=");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                    MediaTrimView.this.cTL.aIp();
                }
                MediaTrimView.this.m18264k(this.cUr, i);
                C6344b.m18174bu(MediaTrimView.this.getContext().getApplicationContext(), this.cUr ? TtmlNode.LEFT : TtmlNode.RIGHT);
                return 0;
            }
        };
        this.cUk = new OnClickListener() {
            public void onClick(View view) {
                if (view.equals(MediaTrimView.this.cTQ)) {
                    if (MediaTrimView.this.cso != null) {
                        if (MediaTrimView.this.cso.isPlaying()) {
                            MediaTrimView.this.adX();
                        } else {
                            MediaTrimView.this.startPreview();
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTR)) {
                    if (!(MediaTrimView.this.cTI == null || MediaTrimView.this.cTI.cTz == null || MediaTrimView.this.cCF == null)) {
                        C5832c agp = MediaTrimView.this.cCF.agp();
                        if (agp != null && MediaTrimView.this.cTG != null) {
                            MediaTrimView.this.cTC = true;
                            MediaTrimView.this.mo29390nH(1);
                            int agB = agp.agB();
                            C6348d.amK().mo29374f(MediaTrimView.this.m18231a(MediaTrimView.this.cTI, new Range(agB, agp.agC() - agB), false, MediaTrimView.this.cTG.getWidth(), MediaTrimView.this.cTG.getHeight(), MediaTrimView.this.cTG.aHX(), MediaTrimView.this.cTG.aIi()));
                            MediaTrimView.this.anb();
                            C6344b.m18184fb(MediaTrimView.this.getContext());
                        }
                    }
                } else if (view.equals(MediaTrimView.this.cTT) || view.equals(MediaTrimView.this.cTU)) {
                    MediaTrimView.this.ana();
                }
            }
        };
        m18250c(attributeSet, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public TrimedClipItemDataModel m18231a(C6364b bVar, Range range, boolean z, int i, int i2, int i3, boolean z2) {
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        if (bVar.cTz == null) {
            return trimedClipItemDataModel;
        }
        String str = bVar.cTz.cTw;
        if (z) {
            trimedClipItemDataModel.isImage = Boolean.valueOf(true);
            trimedClipItemDataModel.mRawFilePath = str;
            trimedClipItemDataModel.mRotate = Integer.valueOf(i3);
        } else {
            trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(range.getmPosition(), range.getmTimeLength());
            trimedClipItemDataModel.mRawFilePath = str;
            trimedClipItemDataModel.mRotate = Integer.valueOf(i3);
            trimedClipItemDataModel.bCrop = Boolean.valueOf(false);
            trimedClipItemDataModel.mStreamSizeVe = C8547b.m24990a(bVar.cTA.eiV, i, i2, z2, AppStateModel.getInstance().isCommunitySupport());
            trimedClipItemDataModel.mEncType = C8541r.m24978a(bVar.cTA.eiV);
            trimedClipItemDataModel.bNeedTranscode = bVar.cTA.bNeedTranscode;
            trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(false);
            if (bVar.cTA.eiW != null) {
                trimedClipItemDataModel.digitalWaterMarkCode = bVar.cTA.eiW.aaW();
            }
        }
        return trimedClipItemDataModel;
    }

    /* renamed from: a */
    private QSessionStream m18236a(VeMSize veMSize, QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return null;
        }
        return C8563r.m25045a(1, qStoryboard, 0, 0, new QRect(0, 0, C8572y.m25087dI(veMSize.width, 2), C8572y.m25087dI(veMSize.height, 2)), 65537, 0, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18241a(VeMSize veMSize, VeMSize veMSize2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaPlayer bSwitchedToPhoto=");
        sb.append(this.cUf);
        LogUtilsV2.m14230i(sb.toString());
        if (this.cUf) {
            if (this.cso != null) {
                this.cso.aIv();
                this.cso = null;
            }
            this.cUf = false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initMediaPlayer  mVideoState=");
        sb2.append(this.cTG);
        sb2.append(";streamSizeVe=");
        sb2.append(veMSize);
        sb2.append(";surfaceSiz=");
        sb2.append(veMSize2);
        sb2.append(";bSwitchedToPhoto=");
        sb2.append(this.cUf);
        LogUtilsV2.m14230i(sb2.toString());
        if (this.cso == null) {
            this.cso = new C8431d();
            this.cso.mo34191jn(false);
            QSessionStream a = m18236a(veMSize, this.cTJ, i);
            QDisplayContext a2 = C8571x.m25059a(new VeMSize(veMSize2.width, veMSize2.height), new VeMSize(veMSize.width, veMSize.height), 1, (Object) this.csO, this.cTG);
            C8540q.m24935a(this.cTJ, veMSize);
            boolean a3 = this.cso.mo34170a(a, getPlayCallback(), veMSize, 0, this.bOK.aJv(), this.csO, a2);
            this.cso.aIB();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("BASIC_EVENT_MSG_INIT_MEDIAPLAYER initResult=");
            sb3.append(a3);
            LogUtilsV2.m14230i(sb3.toString());
            return;
        }
        QDisplayContext a4 = C8571x.m25059a(veMSize2, veMSize, 1, (Object) this.csO, this.cTG);
        C8540q.m24935a(this.cTJ, veMSize);
        this.cso.mo34183b(veMSize);
        this.cso.mo34167a(this.cTJ.getDataClip(), 11, null);
        this.cso.setDisplayContext(a4);
        this.cso.mo34196uf(0);
        this.cso.aIB();
    }

    /* access modifiers changed from: private */
    public void adX() {
        if (this.cso != null) {
            this.cso.pause();
        }
    }

    private void agj() {
        int i;
        int i2 = 0;
        if (this.cCF == null || this.cTO == null || this.cTO.getVisibility() == 4) {
            this.cso.mo34186d(new VeRange(0, -1));
        } else {
            C5832c agp = this.cCF.agp();
            if (agp != null) {
                int agB = agp.agB();
                int agC = agp.agC();
                if (this.cDA) {
                    this.cDA = false;
                    i = agC - 1000;
                } else {
                    i = agB;
                }
                if (i > 0) {
                    i2 = i;
                }
                if (!this.cCF.isPlaying()) {
                    this.cso.mo34188dF(agB, agC - agB);
                    this.cso.mo34196uf(i2);
                }
            }
        }
    }

    private void amW() {
        this.cUa = new C5689c(this.cUc, this.cUb);
        this.cUa.mo27876a((C5688b) new C5688b() {
            private boolean cDE = false;
            private int cUq = 0;
            private boolean isPaused = false;

            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (MediaTrimView.this.cso != null) {
                    if (MediaTrimView.this.cso.isPlaying()) {
                        MediaTrimView.this.adX();
                    } else if (!this.isPaused) {
                        MediaTrimView.this.startPreview();
                    }
                }
                this.isPaused = false;
                return false;
            }

            public boolean aet() {
                return MediaTrimView.this.cso != null && !MediaTrimView.this.cso.isPlaying();
            }

            public void aeu() {
                if (MediaTrimView.this.cso != null && MediaTrimView.this.cso.isPlaying()) {
                    this.isPaused = true;
                    MediaTrimView.this.adX();
                }
            }

            public int aev() {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.setMode(1);
                    MediaTrimView.this.cTL.mo34146a(MediaTrimView.this.cso);
                }
                this.cDE = true;
                if (MediaTrimView.this.cCF == null) {
                    return 0;
                }
                int agB = MediaTrimView.this.cCF.agr() ? MediaTrimView.this.cCF.agp().agB() : MediaTrimView.this.cCF.agp().agC();
                StringBuilder sb = new StringBuilder();
                sb.append("onFineTuningStart startPos = ");
                sb.append(agB);
                LogUtilsV2.m14227d(sb.toString());
                this.cUq = agB;
                return agB;
            }

            public void aew() {
                this.cDE = false;
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.aIp();
                }
                if (MediaTrimView.this.cCF != null) {
                    boolean agr = MediaTrimView.this.cCF.agr();
                    MediaTrimView.this.m18264k(agr, this.cUq);
                    C6344b.m18175bv(MediaTrimView.this.getContext().getApplicationContext(), agr ? TtmlNode.LEFT : TtmlNode.RIGHT);
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (i < 0) {
                    i = 0;
                }
                if (MediaTrimView.this.cCF == null || MediaTrimView.this.cTI == null || MediaTrimView.this.cTI.cTA.cCG == null) {
                    return 0;
                }
                int aHR = MediaTrimView.this.cTI.cTA.cCG.aHR();
                int i2 = aHR - 1;
                if (i > i2) {
                    i = i2;
                }
                if (MediaTrimView.this.cCF.agp() != null) {
                    if (MediaTrimView.this.cCF.agr()) {
                        if (i > aHR - VeAdvanceTrimGallery.dxa) {
                            i = aHR - VeAdvanceTrimGallery.dxa;
                        }
                    } else if (i < VeAdvanceTrimGallery.dxa + 0) {
                        i = VeAdvanceTrimGallery.dxa + 0;
                    }
                }
                this.cUq = i;
                StringBuilder sb = new StringBuilder();
                sb.append("onValidateTime curTime = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                return i;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                if (MediaTrimView.this.cTL != null) {
                    MediaTrimView.this.cTL.mo34149b(new C8424a(i, false));
                }
                if (MediaTrimView.this.cCF != null && this.cDE) {
                    this.cUq = i;
                    MediaTrimView.this.cCF.mo28144lE(i);
                }
            }
        });
        this.cUa.adc();
    }

    /* access modifiers changed from: private */
    public void amY() {
        this.cSJ.mo10131a(C1485a.BUFFER).mo9828b(C1820a.aVi()).mo9814a(C1820a.aVi()).mo9827b((C1518f<? super T, ? extends R>) new C1518f<C6363a, C6364b>() {
            /* renamed from: b */
            public C6364b apply(C6363a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("apply info = ");
                sb.append(aVar);
                LogUtilsV2.m14227d(sb.toString());
                MediaTrimView.this.cTG = new C8442c();
                C8442c hX = C6348d.amK().mo29377hX(aVar.cTw);
                C6364b bVar = (C6364b) MediaTrimView.this.cTH.get(aVar.cTw);
                QEngine aJv = MediaTrimView.this.bOK.aJv();
                if (bVar == null) {
                    if (aVar.cTx == 1) {
                        bVar = MediaTrimView.this.mo29383a(aJv, aVar.cTw, MediaTrimView.this.cTK, true);
                    } else {
                        bVar = new C6364b();
                        bVar.cTz = aVar;
                    }
                    if (bVar != null) {
                        MediaTrimView.this.cTH.put(aVar.cTw, bVar);
                    }
                } else {
                    bVar.cTz.action = aVar.action;
                }
                if (bVar != null && aVar.cTx == 1) {
                    if (MediaTrimView.this.cUf && MediaTrimView.this.cTJ != null) {
                        MediaTrimView.this.cTJ.unInit();
                        MediaTrimView.this.cTJ = null;
                    }
                    if (MediaTrimView.this.cTJ == null) {
                        MediaTrimView.this.cTJ = new QStoryboard();
                        MediaTrimView.this.cTJ.init(aJv, null);
                    }
                    bVar.cTz = aVar;
                    bVar.cTA.mClip = C8537n.m24824f(aVar.cTw, aJv);
                    C8540q.m24963n(MediaTrimView.this.cTJ, 0);
                    C8540q.m24923a(MediaTrimView.this.cTJ, bVar.cTA.mClip, 0);
                    aVar.cTy.width = bVar.cTA.eej.width;
                    aVar.cTy.height = bVar.cTA.eej.height;
                    MediaTrimView.this.cTG.mo34283a(new VeMSize(bVar.cTA.eej.width, bVar.cTA.eej.height));
                    MediaTrimView.this.cTG.mVeRange.setmPosition(0);
                    MediaTrimView.this.cTG.mVeRange.setmTimeLength(bVar.cTA.cDS);
                    MediaTrimView.this.cTV = new VeMSize(MediaTrimView.this.getWidth(), MediaTrimView.this.getHeight());
                    MediaTrimView.this.mStreamSizeVe = C8572y.m25086d(new VeMSize(bVar.cTA.eej.width, bVar.cTA.eej.height), new VeMSize(MediaTrimView.this.getWidth(), MediaTrimView.this.getHeight()));
                }
                MediaTrimView.this.cTI = bVar;
                if (!(bVar == null || hX == null)) {
                    MediaTrimView.this.cTG = hX;
                    if (aVar.cTx == 1) {
                        bVar.cTA.cCG.mo34216a(new QRange(MediaTrimView.this.cTG.mVeRange.getmPosition(), MediaTrimView.this.cTG.mVeRange.getmTimeLength()));
                    }
                }
                return bVar;
            }
        }).mo9814a(C1487a.aUa()).mo9817a((C1807g<? super T>) new C1807g<C6364b>() {
            /* renamed from: a */
            public void mo9888K(C6364b bVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("onNext = ");
                sb.append(bVar);
                LogUtilsV2.m14227d(sb.toString());
                if (!(bVar == null || bVar.cTz == null)) {
                    if (bVar.cTz.action == 1) {
                        C6348d.amK().mo29373e(MediaTrimView.this.m18231a(bVar, new Range(MediaTrimView.this.cTG.mVeRange.getmPosition(), MediaTrimView.this.cTG.mVeRange.getmTimeLength()), bVar.cTz.cTx != 1, MediaTrimView.this.cTG.getWidth(), MediaTrimView.this.cTG.getHeight(), MediaTrimView.this.cTG.aHX(), MediaTrimView.this.cTG.aIi()));
                        if (bVar.cTz.cTx == 1) {
                            MediaTrimView.this.m18261if(bVar.cTz.cTw);
                            MediaTrimView.this.m18260ie(bVar.cTz.cTw);
                        }
                    }
                    if (bVar.cTz.cTx != 1) {
                        MediaTrimView.this.cTX.setRotation((float) MediaTrimView.this.cTG.aHX());
                        ImageLoader.loadImage(MediaTrimView.this.getContext(), bVar.cTz.cTw, (ImageView) MediaTrimView.this.cTX);
                    } else {
                        MediaTrimView.this.m18241a(MediaTrimView.this.mStreamSizeVe, MediaTrimView.this.cTV, MediaTrimView.this.csD);
                    }
                }
                if (MediaTrimView.this.cTY != null) {
                    if (MediaTrimView.this.cSJ != null) {
                        MediaTrimView.this.cSJ.mo9886K(MediaTrimView.this.cTY);
                    }
                    MediaTrimView.this.cTY = null;
                    if (MediaTrimView.this.cTZ != null) {
                        MediaTrimView.this.cTZ.mo9893bV(1);
                    }
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("onSubscribe = ");
                sb.append(dVar);
                LogUtilsV2.m14227d(sb.toString());
                MediaTrimView.this.cTZ = dVar;
                MediaTrimView.this.cTZ.mo9893bV(1);
            }

            public void onComplete() {
                LogUtilsV2.m14227d("onComplete = ");
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14227d("onError = ");
                th.printStackTrace();
                MediaTrimView.this.amY();
            }
        });
    }

    private void amZ() {
        if (this.cso != null) {
            if (this.cso.isPlaying()) {
                this.cTQ.setSelected(true);
            } else {
                this.cTQ.setSelected(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ana() {
        if (this.cTG != null && this.cTI != null && this.cTI.cTz != null) {
            int aIh = this.cTG.aIh();
            C6348d.amK().mo29372b(this.cTI.cTz.cTw, this.cTG);
            boolean z = this.cTI.cTz.cTx == 0;
            C6344b.m18176bw(getContext().getApplicationContext(), z ? "pic" : "video");
            if (z) {
                if (this.cTX != null) {
                    this.cTX.setRotation((float) aIh);
                }
            } else if (this.cTV != null && this.mStreamSizeVe != null) {
                QDisplayContext a = C8571x.m25059a(new VeMSize(this.cTV.width, this.cTV.height), new VeMSize(this.mStreamSizeVe.width, this.mStreamSizeVe.height), 1, (Object) this.csO, this.cTG);
                if (this.cso != null) {
                    this.cso.setDisplayContext(a);
                    this.cso.aIB();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void anb() {
        if (this.cCF != null) {
            Bitmap ags = this.cCF.ags();
            if (ags != null) {
                this.cUg.setImageBitmap(ags);
                Point agt = this.cCF.agt();
                RectF cH = m18252cH(this.cTT);
                final float width = (float) (agt.x - (ags.getWidth() / 2));
                final float height = (this.cTF == null || !this.cTF.amF()) ? (float) ((agt.y - ags.getHeight()) + C8500b.dpFloatToPixel(getContext(), 50.0f)) : (float) (agt.y - ags.getHeight());
                final float centerX = cH.centerX() - ((float) (ags.getWidth() / 2));
                final float centerY = (this.cTF == null || !this.cTF.amF()) ? (cH.centerY() - ((float) (ags.getHeight() / 2))) + ((float) C8500b.dpFloatToPixel(getContext(), 50.0f)) : cH.centerY() - ((float) (ags.getHeight() / 2));
                StringBuilder sb = new StringBuilder();
                sb.append("startX : ");
                sb.append(width);
                LogUtilsV2.m14230i(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startY : ");
                sb2.append(height);
                LogUtilsV2.m14230i(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endX : ");
                sb3.append(centerX);
                LogUtilsV2.m14230i(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("endY : ");
                sb4.append(centerY);
                LogUtilsV2.m14230i(sb4.toString());
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cUg, "scaleX", new float[]{1.0f, 0.2f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cUg, "scaleY", new float[]{1.0f, 0.2f});
                ofFloat.setDuration(250);
                ofFloat2.setDuration(250);
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(250);
                valueAnimator.setObjectValues(new Object[]{new PointF(0.0f, 0.0f)});
                valueAnimator.setInterpolator(new LinearInterpolator());
                C63532 r6 = new TypeEvaluator<PointF>() {
                    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
                        PointF pointF3 = new PointF();
                        pointF3.x = width + ((centerX - width) * f);
                        float f2 = f - 1.0f;
                        pointF3.y = centerY + ((height - centerY) * f2 * f2);
                        return pointF3;
                    }
                };
                valueAnimator.setEvaluator(r6);
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                        MediaTrimView.this.cUg.setX(pointF.x);
                        MediaTrimView.this.cUg.setY(pointF.y);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat).with(ofFloat2);
                animatorSet.play(ofFloat2).with(valueAnimator);
                animatorSet.play(valueAnimator);
                animatorSet.addListener(new AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        MediaTrimView.this.cUg.setVisibility(4);
                        if (MediaTrimView.this.cTI.cTz != null) {
                            MediaTrimView.this.m18261if(MediaTrimView.this.cTI.cTz.cTw);
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        MediaTrimView.this.cUg.setVisibility(0);
                    }
                });
                animatorSet.start();
            }
        }
    }

    /* renamed from: c */
    private void m18250c(AttributeSet attributeSet, int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_gallry_view_trim, this, true);
        this.bOK = C8501a.aJs();
        this.cUb = (RelativeLayout) findViewById(R.id.xiaoying_relativelayout_fine_tunning_tip);
        this.cUc = findViewById(R.id.preview_layout_fake);
        findViewById(R.id.layout_preview_bg).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MediaTrimView.this.cso != null && MediaTrimView.this.cso.isPlaying()) {
                    MediaTrimView.this.adX();
                }
            }
        });
        this.cTO = (LinearLayout) findViewById(R.id.clip_trim_container);
        this.cTP = (LinearLayoutCompat) findViewById(R.id.ll_trim_video_tools_layout);
        this.cTQ = (ImageButton) findViewById(R.id.imgbtn_play);
        this.cTQ.setOnClickListener(this.cUk);
        this.cTS = (RelativeLayout) findViewById(R.id.rl_trim);
        this.cTR = (ImageButton) findViewById(R.id.imgbtn_trim_clip);
        this.cTR.setOnClickListener(this.cUk);
        this.cTT = (ImageButton) findViewById(R.id.imgbtn_rotate_video_clip);
        this.cTU = (ImageButton) findViewById(R.id.imgbtn_rotate_img_clip);
        C6414r.m18458f(this.cTU, 0, 0, 0, C8500b.m24591P(15.0f));
        C6414r.m18458f(this.cTT, 0, 0, 0, C8500b.m24591P(15.0f));
        C6414r.m18458f(this.cTR, 0, 0, 0, C8500b.m24591P(15.0f));
        C6414r.m18458f(this.cTQ, 0, 0, 0, C8500b.m24591P(10.0f));
        this.cTT.setOnClickListener(this.cUk);
        this.cTU.setOnClickListener(this.cUk);
        this.cUg = (ImageView) findViewById(R.id.img_avatar);
        this.cTR.setBackgroundDrawable(C9175b.m26701N(this.cTR.getBackground()));
        this.cTT.setBackgroundDrawable(C9175b.m26701N(this.cTT.getBackground()));
        this.cTU.setBackgroundDrawable(C9175b.m26701N(this.cTU.getBackground()));
        this.cTX = (PhotoView) findViewById(R.id.photo_view);
        this.cUd = (TextView) findViewById(R.id.tv_video_trim_count);
        this.cUd.getBackground();
        amW();
        if (getContext() instanceof Activity) {
            this.cTD = new C6651b((Activity) getContext());
            this.cTE = new C6651b((Activity) getContext());
        }
        this.csN = (SurfaceView) findViewById(R.id.previewview);
        this.csN.setVisibility(0);
        this.csO = this.csN.getHolder();
        if (this.csO != null) {
            this.csO.addCallback(this);
            this.csO.setFormat(this.csL);
        }
        this.cTL = new C8421a();
        this.cTL.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
            /* renamed from: a */
            public void mo9888K(C8424a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("onNext = ");
                sb.append(aVar.position);
                sb.append(",finish = ");
                sb.append(aVar.eev);
                LogUtilsV2.m14227d(sb.toString());
                if (MediaTrimView.this.cTM != null) {
                    MediaTrimView.this.cTM.mo9893bV(1);
                }
                if (MediaTrimView.this.cTN && aVar.eev) {
                    if (MediaTrimView.this.cso != null) {
                        MediaTrimView.this.cso.play();
                    }
                    MediaTrimView.this.cTN = !aVar.eev;
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                MediaTrimView.this.cTM = dVar;
                MediaTrimView.this.cTM.mo9893bV(1);
            }

            public void onComplete() {
                LogUtilsV2.m14227d("onComplete = ");
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14227d("onError = ");
            }
        });
    }

    /* renamed from: cH */
    public static RectF m18252cH(View view) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int left = view.getLeft();
        int top = view.getTop();
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return new RectF((float) left, (float) top, (float) (left + width), (float) (top + height));
            }
            view = (View) parent;
            left += view.getLeft();
            top += view.getTop();
        }
    }

    private C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6362b();
        }
        return this.cTW;
    }

    /* access modifiers changed from: private */
    /* renamed from: ie */
    public void m18260ie(String str) {
        if (!TextUtils.equals(str, this.cUe)) {
            if (this.cCF != null) {
                this.cCF.destroy();
                this.cCF = null;
            }
            this.cUe = str;
            this.cUh = (RelativeLayout) findViewById(R.id.layout_trim_relate);
            this.cCF = new C5822a(this.cUh, C8540q.m24956i(this.cTJ, 0), this.cTI.cTA.cCG, 0);
            this.cCF.mo28125a(this.cUj);
            this.cCF.mo28124a(this.cUi);
            this.cCF.mo28141lA(C8500b.m24590O(this.cUh.getContext(), 36));
            this.cCF.mo28136eI(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: if */
    public void m18261if(String str) {
        int ib = C6348d.amK().mo29379ib(str);
        if (ib > 0) {
            TextView textView = this.cUd;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(ib);
            textView.setText(sb.toString());
            this.cUd.setVisibility(0);
            return;
        }
        this.cUd.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m18264k(boolean z, int i) {
        if (this.cTG != null && this.cTG.mVeRange != null) {
            VeRange veRange = this.cTG.mVeRange;
            if (z) {
                veRange.setmPosition(i);
            } else {
                veRange.setmTimeLength(i - veRange.getmPosition());
            }
            if (this.cTI != null && this.cTI.cTz != null) {
                C6348d.amK().mo29372b(this.cTI.cTz.cTw, this.cTG);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nC */
    public void m18268nC(int i) {
        if (this.cCF != null) {
            this.cCF.setPlaying(false);
            this.cCF.mo28146lG(i);
        }
        if (this.cso != null) {
            this.cso.mo34188dF(0, -1);
        }
        amZ();
    }

    /* access modifiers changed from: private */
    /* renamed from: nD */
    public void m18269nD(int i) {
        if (this.cCF != null && !this.cTN) {
            this.cCF.setPlaying(false);
            this.cCF.mo28146lG(i);
        }
        amZ();
    }

    /* access modifiers changed from: private */
    /* renamed from: nE */
    public void m18270nE(int i) {
        if (this.cCF != null) {
            this.cCF.setPlaying(true);
            this.cCF.mo28146lG(i);
        }
        amZ();
    }

    /* access modifiers changed from: private */
    /* renamed from: nF */
    public void m18271nF(int i) {
        if (this.cCF != null) {
            this.cCF.mo28146lG(i);
        }
        amZ();
    }

    /* access modifiers changed from: private */
    public void startPreview() {
        if (this.cso != null) {
            agj();
            StringBuilder sb = new StringBuilder();
            sb.append("startPreview  ");
            sb.append(this.cTG.mVeRange);
            LogUtilsV2.m14230i(sb.toString());
            this.cso.play();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C6364b mo29383a(QEngine qEngine, String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str) || qEngine == null) {
            return null;
        }
        C6364b bVar = new C6364b();
        if (!z2) {
            return null;
        }
        bVar.cTA = C8547b.m24991b(qEngine, str, z, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        bVar.cTB = C8547b.m24993m(bVar.cTA.eej.width, bVar.cTA.eej.height, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        if (C8400d.edj.booleanValue()) {
            String wMTagFromFile = QUtils.getWMTagFromFile(str);
            bVar.cTA.eiW = C7547a.m22296fU(wMTagFromFile);
        }
        return bVar;
    }

    /* renamed from: a */
    public boolean mo29384a(C6363a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        adX();
        if (aVar.action == 3) {
            C6348d.amK().mo29376hW(aVar.cTw);
            return true;
        } else if (aVar.cTx != 1 || C8572y.m25084d(aVar.cTw, this.bOK.aJv()) == 0) {
            if (this.cTI != null) {
                if (aVar.equals(this.cTI.cTz)) {
                    if (aVar.cTx != 1) {
                        if (aVar.action == 1) {
                            this.cTU.setVisibility(0);
                        } else {
                            this.cTU.setVisibility(4);
                            C6348d.amK().mo29378hY(aVar.cTw);
                        }
                    } else if (aVar.action == 1) {
                        this.cTP.setVisibility(0);
                        this.cTO.setVisibility(0);
                        m18260ie(aVar.cTw);
                    } else {
                        this.cTP.setVisibility(4);
                        this.cTO.setVisibility(4);
                        C6348d.amK().mo29378hY(aVar.cTw);
                    }
                } else if (aVar.action == 2) {
                    C6348d.amK().mo29378hY(aVar.cTw);
                    return true;
                } else {
                    C6348d.amK().mo29363a(this.cTI.cTz.cTw, this.cTG);
                }
            }
            if (aVar.cTx != 1) {
                this.cTX.setVisibility(0);
                this.csN.setVisibility(4);
                this.cTO.setVisibility(4);
                this.cTP.setVisibility(4);
                this.cUc.setVisibility(4);
                this.cTQ.setVisibility(4);
                if (aVar.action == 1) {
                    this.cTU.setVisibility(0);
                } else {
                    this.cTU.setVisibility(4);
                }
            } else {
                this.cTX.setVisibility(4);
                this.csN.setVisibility(0);
                this.cTQ.setVisibility(0);
                this.cTU.setVisibility(4);
                if (aVar.action == 1) {
                    this.cTP.setVisibility(0);
                    this.cTO.setVisibility(0);
                    this.cUc.setVisibility(0);
                } else {
                    this.cTP.setVisibility(4);
                    this.cTO.setVisibility(4);
                    this.cUc.setVisibility(4);
                }
            }
            boolean z2 = this.cUf;
            if (!(this.cTI == null || this.cTI.cTz.cTx == aVar.cTx || aVar.cTx == 1)) {
                z = true;
            }
            this.cUf = z | z2;
            if (this.cTY != null) {
                this.cTY = aVar;
            } else if (this.cSJ != null) {
                this.cSJ.mo9886K(aVar);
                if (this.cTZ != null) {
                    this.cTZ.mo9893bV(1);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("post position = ");
                sb.append(aVar);
                LogUtilsV2.m14227d(sb.toString());
            }
            return true;
        } else {
            ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_import_unsupport_file, 1);
            HashMap hashMap = new HashMap();
            hashMap.put("format", "video");
            UserBehaviorLog.onKVEvent(getContext().getApplicationContext(), "Gallery_File_unsupported", hashMap);
            return false;
        }
    }

    /* renamed from: aZ */
    public boolean mo29385aZ(List<C6363a> list) {
        C6364b bVar;
        int i;
        int i2;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (C6363a aVar : list) {
            if (aVar != null) {
                if (aVar.cTx == 1) {
                    bVar = mo29383a(this.bOK.aJv(), aVar.cTw, this.cTK, true);
                    if (bVar != null) {
                        bVar.cTz = aVar;
                    }
                } else {
                    bVar = new C6364b();
                    bVar.cTz = aVar;
                }
                C6364b bVar2 = bVar;
                if (!this.cTH.containsKey(aVar.cTw)) {
                    this.cTH.put(aVar.cTw, bVar2);
                }
                boolean z = bVar2.cTz.cTx != 1;
                Range range = new Range(0, bVar2.cTA.cDS);
                if (bVar2.cTA.eej != null) {
                    i2 = bVar2.cTA.eej.width;
                    i = bVar2.cTA.eej.height;
                } else {
                    i2 = 0;
                    i = 0;
                }
                C6348d.amK().mo29373e(m18231a(bVar2, range, z, i2, i, 0, false));
            }
        }
        return true;
    }

    public void amX() {
        boolean z = true;
        if (C6348d.amK().amL() != 1) {
            z = false;
        }
        this.cTK = z;
        if (this.cTK && this.cTS != null) {
            this.cTS.setVisibility(8);
        } else if (this.cTS != null) {
            this.cTS.setVisibility(0);
        }
        this.csD = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false) ? 4 : 2;
        if (this.cSJ == null) {
            this.cSJ = C1830a.aVl();
            this.cSJ.aVm();
            amY();
        }
    }

    /* renamed from: fY */
    public void mo29387fY(boolean z) {
        if (this.cso != null) {
            this.cso.pause();
            this.cso.aIv();
            this.cso = null;
        }
        this.isPaused = true;
    }

    public C6364b getPreviewItem() {
        return this.cTI;
    }

    /* renamed from: nG */
    public void mo29389nG(int i) {
        int i2 = i;
        if (getContext() instanceof Activity) {
            boolean qi = C4580b.m11666qi();
            if (i2 == 1 && this.cTQ.getVisibility() == 0) {
                if (this.cTD == null) {
                    return;
                }
                if (qi) {
                    this.cTD.mo30034b(this.cTR, 11, getResources().getString(R.string.xiaoying_str_gallery_trim_help_tip), qi, 0, -C8500b.dpFloatToPixel(getContext(), 10.0f));
                } else {
                    this.cTD.mo30034b(this.cTR, 11, getResources().getString(R.string.xiaoying_str_gallery_trim_help_tip), qi, C8500b.dpFloatToPixel(getContext(), 5.0f), -C8500b.dpFloatToPixel(getContext(), 10.0f));
                }
            } else if (i2 == 0 && this.cTE != null) {
                if (qi) {
                    this.cTE.mo30034b(this.cTQ, 3, getResources().getString(R.string.xiaoying_str_gallery_check_help_tip), C4580b.m11666qi(), -C8500b.dpFloatToPixel(getContext(), 165.0f), C8500b.dpFloatToPixel(getContext(), 55.0f));
                    return;
                }
                this.cTE.mo30034b(this.cTQ, 3, getResources().getString(R.string.xiaoying_str_gallery_check_help_tip), C4580b.m11666qi(), C8500b.dpFloatToPixel(getContext(), 58.0f), C8500b.dpFloatToPixel(getContext(), 55.0f));
            }
        }
    }

    /* renamed from: nH */
    public void mo29390nH(int i) {
        switch (i) {
            case 0:
                if (this.cTE != null) {
                    this.cTE.hide();
                    return;
                }
                return;
            case 1:
                if (this.cTD != null) {
                    this.cTD.hide();
                    return;
                }
                return;
            default:
                if (this.cTD != null) {
                    this.cTD.hide();
                }
                if (this.cTE != null) {
                    this.cTE.hide();
                    return;
                }
                return;
        }
    }

    public void onDestroy() {
        if (this.csO != null) {
            this.csO.removeCallback(this);
        }
        if (this.cTZ != null) {
            this.cTZ.cancel();
            this.cTZ = null;
        }
    }

    public void onResume() {
        if (this.isPaused) {
            this.isPaused = false;
            if (this.cTI != null && this.cTI.cTz.cTx == 1) {
                C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(50, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                    /* renamed from: a */
                    public void mo9877a(C1495b bVar) {
                    }

                    /* renamed from: b */
                    public void mo9886K(Boolean bool) {
                        MediaTrimView.this.m18241a(MediaTrimView.this.mStreamSizeVe, MediaTrimView.this.cTV, MediaTrimView.this.csD);
                    }

                    public void onComplete() {
                    }

                    public void onError(Throwable th) {
                    }
                });
            }
        }
    }

    public void setAdContainerStateCallBack(C6361a aVar) {
        this.cTF = aVar;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("surfaceChanged  ");
        sb.append(surfaceHolder);
        sb.append(";");
        sb.append(i);
        sb.append(";");
        sb.append(i2);
        sb.append(";");
        sb.append(i3);
        LogUtilsV2.m14230i(sb.toString());
        this.csO = surfaceHolder;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        StringBuilder sb = new StringBuilder();
        sb.append("surfaceCreated  ");
        sb.append(surfaceHolder);
        LogUtilsV2.m14230i(sb.toString());
        this.csO = surfaceHolder;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        StringBuilder sb = new StringBuilder();
        sb.append("surfaceDestroyed  ");
        sb.append(surfaceHolder);
        LogUtilsV2.m14230i(sb.toString());
    }
}
