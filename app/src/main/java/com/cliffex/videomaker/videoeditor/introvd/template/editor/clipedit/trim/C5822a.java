package com.introvd.template.editor.clipedit.trim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.facebook.accountkit.internal.InternalLogger;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.trim.C5832c.C5834b;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery.C7093b;
import com.introvd.template.editor.widget.timeline.VeGallery;
import com.introvd.template.editor.widget.timeline.VeGallery.C7101e;
import com.introvd.template.editor.widget.timeline.VeGallery.C7102f;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.editor.cache.C8440a;
import java.lang.ref.WeakReference;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QBitmap;

/* renamed from: com.introvd.template.editor.clipedit.trim.a */
public class C5822a {
    /* access modifiers changed from: private */
    public C5830d cDB;
    private int cDF;
    /* access modifiers changed from: private */
    public C5832c cDG;
    /* access modifiers changed from: private */
    public VeAdvanceTrimGallery cDH;
    private C8440a cDI;
    /* access modifiers changed from: private */
    public volatile boolean cDJ;
    private volatile boolean cDK = true;
    /* access modifiers changed from: private */
    public boolean cDL;
    /* access modifiers changed from: private */
    public C5829c cDM;
    /* access modifiers changed from: private */
    public C5828b cDN;
    private int cDO = 0;
    /* access modifiers changed from: private */
    public ViewGroup cDP;
    private TextView cDQ;
    private TextView cDR;
    private int cDS = 0;
    public int cDT = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private int cDU = 0;
    private C7102f cDV = new C7102f() {
        /* renamed from: cw */
        public void mo28150cw(View view) {
            if (view != null && C5822a.this.cDG != null && C5822a.this.cDG.agF() != null) {
                VeGallery veGallery = (VeGallery) view;
                int firstVisiblePosition = veGallery.getFirstVisiblePosition();
                int lastVisiblePosition = veGallery.getLastVisiblePosition();
                if (C5822a.this.agu()) {
                    C5822a.this.cDG.agF().mo30636db(0, C5822a.this.cDG.agE() * C5822a.this.cDH.getCount());
                } else {
                    C5822a.this.cDG.agF().mo30636db(C5822a.this.cDG.agE() * firstVisiblePosition, C5822a.this.cDG.agE() * lastVisiblePosition);
                }
                if (!C5822a.this.cDJ) {
                    C5822a.this.m16237eK(false);
                    return;
                }
                int agD = C5822a.this.cDG.agD();
                C5822a.this.cDJ = false;
                for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                    View childAt = veGallery.getChildAt(i - firstVisiblePosition);
                    if (childAt != null) {
                        TranslateAnimation translateAnimation = new TranslateAnimation((float) (agD - childAt.getLeft()), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(500);
                        childAt.startAnimation(translateAnimation);
                        if (i == firstVisiblePosition) {
                            translateAnimation.setAnimationListener(C5822a.this.cDX);
                        }
                    }
                }
            }
        }
    };
    private final C7093b cDW = new C7093b() {
        /* renamed from: a */
        public void mo28151a(int i, boolean z, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTrimEnd;trimPosition=");
            sb.append(i2);
            LogUtilsV2.m14227d(sb.toString());
            if (z) {
                C5822a.this.cDG.mo28199lP(i2);
            } else {
                C5822a.this.cDG.mo28200lQ(i2);
            }
            if (z) {
                C5822a.this.cDH.setTrimLeftValue(i2);
            } else {
                C5822a.this.cDH.setTrimRightValue(i2);
            }
            C5822a.this.ago();
            if (C5822a.this.cDB != null) {
                C5822a.this.cDB.mo28120lz(i2);
            }
        }

        public boolean agv() {
            if (C5822a.this.cDL) {
                ToastUtils.show(C5822a.this.cDP.getContext(), R.string.xiaoying_str_ve_trim_attain_limit_msg, 0);
            }
            return false;
        }

        /* renamed from: b */
        public void mo28153b(int i, boolean z, int i2) {
            if (C5822a.this.cDB != null) {
                C5822a.this.cDB.mo28119ly(i2);
            }
            if (z) {
                C5822a.this.cDG.mo28199lP(i2);
            } else {
                C5822a.this.cDG.mo28200lQ(i2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>>>>>>>>>> TrickPlayRunnable;trimPosition=");
            sb.append(i2);
            LogUtilsV2.m14227d(sb.toString());
            C5822a.this.ago();
            C5822a.this.setCurPlayPos(i2);
        }

        /* renamed from: c */
        public void mo28154c(int i, boolean z, int i2) {
            if (C5822a.this.cDB != null) {
                C5822a.this.cDB.mo28118eH(z);
            }
        }

        /* renamed from: e */
        public boolean mo28155e(int i, KeyEvent keyEvent) {
            return false;
        }

        /* renamed from: eL */
        public void mo28156eL(boolean z) {
        }

        /* renamed from: f */
        public boolean mo28157f(int i, KeyEvent keyEvent) {
            return false;
        }

        /* renamed from: lJ */
        public void mo28158lJ(int i) {
            if (C5822a.this.cDM != null) {
                C5822a.this.cDM.afS();
            }
            if (C5822a.this.cDH != null && C5822a.this.cDH.avL()) {
                C5822a.this.m16245lH(i);
            }
        }

        /* renamed from: lr */
        public void mo28159lr(int i) {
            if (C5822a.this.cDM != null) {
                C5822a.this.cDM.mo28063lr(i);
            }
            C5822a.this.mo28146lG(i);
            if (C5822a.this.cDH != null && C5822a.this.cDH.avL()) {
                C5822a.this.m16245lH(i);
            }
        }

        /* renamed from: ls */
        public void mo28160ls(int i) {
            if (C5822a.this.cDM != null) {
                C5822a.this.cDM.mo28064ls(i);
            }
            if (C5822a.this.cDH != null && C5822a.this.cDH.avL()) {
                C5822a.this.m16245lH(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public AnimationListener cDX = new AnimationListener() {
        public void onAnimationEnd(Animation animation) {
            if (C5822a.this.cDH != null) {
                C5822a.this.cDH.mo31258B(true, true);
                C5822a.this.cDH.mo31363hy(true);
                C5822a.this.m16237eK(false);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    };
    private final C7101e cDY = new C7101e() {
        public void acC() {
        }

        public void afq() {
        }

        public void agw() {
        }

        /* renamed from: b */
        public void mo28167b(View view, int i, int i2, int i3) {
        }

        /* renamed from: cu */
        public void mo28168cu(View view) {
            if (C5822a.this.agp() != null) {
                C5822a.this.agp().mo28195eO(false);
                C5822a.this.agp().mo28201lR(C5822a.this.cDH == null ? -1 : C5822a.this.cDH.getFirstVisiblePosition() - 1);
            }
            if (C5822a.this.cDH != null && C5822a.this.cDG != null) {
                int dd = C5822a.this.cDH.mo31269dd(C5822a.this.cDH.getmTrimLeftPos(), C5822a.this.cDH.getCount());
                int dd2 = C5822a.this.cDH.mo31269dd(C5822a.this.cDH.getmTrimRightPos(), C5822a.this.cDH.getCount());
                C5822a.this.cDH.setTrimLeftValueWithoutLimitDetect(dd);
                C5822a.this.cDH.setTrimRightValueWithoutLimitDetect(dd2);
                C5822a.this.cDG.mo28199lP(dd);
                C5822a.this.cDG.mo28200lQ(dd2);
                if (C5822a.this.cDN == null) {
                    return;
                }
                if (C5822a.this.cDH.avM()) {
                    C5822a.this.cDN.mo28174lL(C5822a.this.cDH.getTrimLeftValue());
                } else {
                    C5822a.this.cDN.mo28174lL(C5822a.this.cDH.getTrimRightValue());
                }
            }
        }

        /* renamed from: cv */
        public void mo28169cv(View view) {
            if (C5822a.this.agp() != null) {
                C5822a.this.agp().mo28195eO(true);
            }
            if (C5822a.this.cDN != null) {
                C5822a.this.cDN.mo28172eM(C5822a.this.cDH.avM());
            }
        }

        /* renamed from: y */
        public void mo28170y(View view, int i) {
            if (C5822a.this.cDN != null) {
                C5822a.this.cDN.mo28173lK(C5822a.this.mo28145lF(i));
            }
        }
    };
    private Handler cDZ = new C5827a(this);
    private boolean cDz = true;
    private QClip mClip;

    /* renamed from: com.introvd.template.editor.clipedit.trim.a$a */
    static class C5827a extends Handler {
        private WeakReference<C5822a> cEb;

        public C5827a(C5822a aVar) {
            this.cEb = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C5822a aVar = (C5822a) this.cEb.get();
            if (aVar != null) {
                int i = message.what;
                if (i != 1) {
                    if (i == 222) {
                        int i2 = message.arg1;
                        if (aVar.cDH != null) {
                            aVar.cDH.mo31376pT(i2);
                        }
                    }
                } else if (aVar.cDG != null && aVar.cDG.agG()) {
                    aVar.m16239f(message.arg1, message.obj);
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.trim.a$b */
    public interface C5828b {
        /* renamed from: eM */
        void mo28172eM(boolean z);

        /* renamed from: lK */
        void mo28173lK(int i);

        /* renamed from: lL */
        void mo28174lL(int i);
    }

    /* renamed from: com.introvd.template.editor.clipedit.trim.a$c */
    public interface C5829c {
        void afS();

        /* renamed from: lr */
        void mo28063lr(int i);

        /* renamed from: ls */
        void mo28064ls(int i);
    }

    /* renamed from: com.introvd.template.editor.clipedit.trim.a$d */
    public interface C5830d {
        /* renamed from: eH */
        void mo28118eH(boolean z);

        /* renamed from: ly */
        void mo28119ly(int i);

        /* renamed from: lz */
        int mo28120lz(int i);
    }

    public C5822a(ViewGroup viewGroup, QClip qClip, C8440a aVar, int i) {
        this.cDP = viewGroup;
        this.cDI = aVar;
        this.mClip = qClip;
        this.cDF = i;
        this.cDL = false;
    }

    private int agn() {
        return Constants.getScreenSize().width - this.cDO;
    }

    /* access modifiers changed from: private */
    public void ago() {
        if (this.cDH != null) {
            int trimLeftValue = this.cDH.getTrimLeftValue();
            int trimRightValue = this.cDH.getTrimRightValue() + 1;
            String ih = C4580b.m11665ih(trimLeftValue);
            String ih2 = C4580b.m11665ih(trimRightValue);
            this.cDH.setLeftMessage(ih);
            this.cDH.setRightMessage(ih2);
            if (this.cDz) {
                this.cDR.setText(C4580b.m11665ih(trimRightValue - trimLeftValue));
            } else {
                int i = this.cDS - (trimRightValue - trimLeftValue);
                if (i % 100 > 50) {
                    i += 100;
                }
                this.cDR.setText(C4580b.m11665ih(i));
            }
            this.cDQ.setVisibility(8);
            this.cDR.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eK */
    public void m16237eK(boolean z) {
        this.cDH.mo31361hv(z);
        this.cDH.mo31360hu(!z);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m16239f(int i, Object obj) {
        if (this.cDH != null && this.cDG.agE() != 0) {
            QBitmap qBitmap = (QBitmap) obj;
            int agE = i / this.cDG.agE();
            int firstVisiblePosition = this.cDH.getFirstVisiblePosition();
            this.cDH.getClipIndex();
            if (i >= 0 && qBitmap != null && !qBitmap.isRecycled()) {
                if (this.cDG.isImageClip() || this.cDK) {
                    this.cDK = false;
                    if (agE == 0) {
                        int lastVisiblePosition = this.cDH.getLastVisiblePosition();
                        for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                            ImageView imageView = (ImageView) this.cDH.getChildAt(i2 - firstVisiblePosition);
                            if (imageView != null) {
                                this.cDG.mo28191b(imageView, 0);
                            }
                        }
                    }
                } else {
                    ImageView imageView2 = (ImageView) this.cDH.getChildAt(agE - firstVisiblePosition);
                    if (imageView2 != null) {
                        if (InternalLogger.EVENT_PARAM_EXTRAS_FALSE.equals((String) imageView2.getTag())) {
                            this.cDG.mo28191b(imageView2, agE);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: lC */
    private int m16244lC(int i) {
        int agn = agn();
        int i2 = agn / i;
        return agn % i < C4583d.m11671P(36.0f) ? i2 - 1 : i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: lH */
    public void m16245lH(int i) {
        if (this.cDH != null && this.cDH.avL()) {
            int agB = i - this.cDG.agB();
            if (agB < 0) {
                agB = 0;
            }
            this.cDH.setSplitMessage(C4580b.m11637V((long) agB));
        }
    }

    /* access modifiers changed from: private */
    public void setCurPlayPos(int i) {
        if (this.cDH != null) {
            this.cDH.setCurPlayPos(i);
        }
    }

    /* renamed from: a */
    public void mo28123a(C5828b bVar) {
        this.cDN = bVar;
    }

    /* renamed from: a */
    public void mo28124a(C5829c cVar) {
        this.cDM = cVar;
    }

    /* renamed from: a */
    public void mo28125a(C5830d dVar) {
        this.cDB = dVar;
    }

    public VeAdvanceTrimGallery agm() {
        return this.cDH;
    }

    public C5832c agp() {
        return this.cDG;
    }

    public int agq() {
        return this.cDS;
    }

    public boolean agr() {
        return this.cDH != null && this.cDH.avK();
    }

    public Bitmap ags() {
        if (this.cDG == null) {
            return null;
        }
        int agB = this.cDG.agB();
        int agE = this.cDG.agE();
        int i = 0;
        if (agE > 0) {
            i = agB / agE;
        }
        return this.cDG.mo28197kH(i);
    }

    public Point agt() {
        if (this.cDP == null) {
            return null;
        }
        int width = this.cDP.getWidth();
        return new Point(this.cDO + ((((this.cDG.agB() * width) / this.cDS) + ((this.cDG.agC() * width) / this.cDS)) / 2), C6386d.m18374cJ(this.cDP));
    }

    public boolean agu() {
        return this.cDU > 0;
    }

    /* renamed from: b */
    public void mo28133b(Context context, boolean z, boolean z2) {
        if (this.cDH != null) {
            this.cDz = z;
            this.cDH.setIsPositiveTrim(z);
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.editor_icon_timeline_left_normal);
            Drawable drawable2 = resources.getDrawable(R.drawable.editor_icon_timeline_right_normal);
            Drawable drawable3 = resources.getDrawable(R.drawable.editor_icon_timeline_reverse_left);
            Drawable drawable4 = resources.getDrawable(R.drawable.editor_icon_timeline_reverse_right);
            if (z) {
                this.cDH.setmDrawableLeftTrimBarDis(drawable);
                this.cDH.setLeftTrimBarDrawable(drawable, drawable);
                this.cDH.setmDrawableRightTrimBarDis(drawable2);
                this.cDH.setRightTrimBarDrawable(drawable2, drawable2);
            } else {
                this.cDH.setmDrawableLeftTrimBarDis(drawable3);
                this.cDH.setLeftTrimBarDrawable(drawable3, drawable3);
                this.cDH.setmDrawableRightTrimBarDis(drawable4);
                this.cDH.setRightTrimBarDrawable(drawable4, drawable4);
            }
            if (!z2) {
                int aHR = this.cDI.aHR();
                if (z) {
                    this.cDG.mo28199lP(0);
                    this.cDH.setTrimLeftValueWithoutLimitDetect(0);
                    int i = aHR - 1;
                    this.cDG.mo28200lQ(i);
                    this.cDH.setTrimRightValueWithoutLimitDetect(i);
                } else {
                    int i2 = aHR / 4;
                    this.cDG.mo28199lP(i2);
                    this.cDH.setTrimLeftValueWithoutLimitDetect(i2);
                    int i3 = (i2 * 3) - 1;
                    this.cDG.mo28200lQ(i3);
                    this.cDH.setTrimRightValueWithoutLimitDetect(i3);
                }
            }
            this.cDH.invalidate();
            ago();
        }
    }

    public void destroy() {
        LogUtilsV2.m14227d("destroy");
        if (this.cDH != null) {
            this.cDH.clearDisappearingChildren();
            this.cDH.setOnTrimGalleryListener(null);
            this.cDH.mo31361hv(false);
            this.cDH.setAdapter((SpinnerAdapter) null);
            this.cDH.setVisibility(4);
            this.cDH.invalidate();
        }
        if (this.cDG != null) {
            this.cDG.agx();
            this.cDG.agy();
        }
        mo28124a((C5829c) null);
        mo28125a((C5830d) null);
    }

    /* renamed from: e */
    public void mo28135e(Context context, int i, int i2) {
        C5832c cVar = this.cDG;
        cVar.getClass();
        C5834b bVar = new C5834b(this.cDH.getContext(), i, i2);
        this.cDJ = true;
        Resources resources = context.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.editor_icon_timeline_left_normal);
        Drawable drawable2 = resources.getDrawable(R.drawable.editor_icon_timeline_right_normal);
        Drawable drawable3 = resources.getDrawable(R.drawable.v5_xiaoying_com_time_line_cur_time);
        Drawable drawable4 = resources.getDrawable(R.color.transparent);
        Drawable drawable5 = resources.getDrawable(R.color.transparent);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.cDH.setGravity(16);
        this.cDH.setSpacing(0);
        this.cDH.setClipDuration(this.cDS);
        this.cDH.setPerChildDuration(this.cDG.agE());
        this.cDH.setmDrawableLeftTrimBarDis(drawable);
        this.cDH.setmDrawableRightTrimBarDis(drawable2);
        this.cDH.setmDrawableTrimContentDis(drawable5);
        this.cDH.setLeftTrimBarDrawable(drawable, drawable);
        this.cDH.setRightTrimBarDrawable(drawable2, drawable2);
        this.cDH.setChildWidth(i);
        this.cDH.setmDrawableTrimContent(drawable4);
        this.cDH.setDrawableCurTimeNeedle(drawable3);
        this.cDH.setCenterAlign(false);
        this.cDH.setParentViewOffset(intrinsicWidth / 2);
        this.cDH.mo31358hA(false);
        this.cDH.setAdapter((SpinnerAdapter) bVar);
        if (agu()) {
            this.cDH.setLimitMoveOffset(drawable.getIntrinsicWidth(), -drawable.getIntrinsicWidth());
            this.cDH.setSelectionInfoOnLayout(0, drawable.getIntrinsicWidth());
            this.cDH.setMinLeftPos(drawable.getIntrinsicWidth());
            this.cDH.setMaxRightPos(Constants.getScreenSize().width - drawable.getIntrinsicWidth());
        } else {
            this.cDH.setLimitMoveOffset(30, -20);
        }
        this.cDH.setTrimLeftValue(this.cDG.agB());
        this.cDH.setTrimRightValue(this.cDG.agC());
        this.cDH.setOnLayoutListener(this.cDV);
        this.cDH.setOnGalleryOperationListener(this.cDY);
        this.cDH.setOnTrimGalleryListener(this.cDW);
        this.cDH.mo31363hy(false);
    }

    /* renamed from: eI */
    public boolean mo28136eI(boolean z) {
        initUI();
        if (this.cDI == null) {
            return false;
        }
        Context context = this.cDP.getContext();
        this.cDG = new C5832c(this.cDZ);
        int aHV = this.cDI.aHV();
        QRange aHT = this.cDI.aHT();
        boolean aIa = this.cDI.aIa();
        if (aIa || aHT == null) {
            if (aIa) {
                QRange aHZ = this.cDI.aHZ();
                if (aHZ != null) {
                    int i = aHZ.get(0);
                    int i2 = aHZ.get(1);
                    if (z) {
                        this.cDG.mo28199lP(0);
                        this.cDG.mo28200lQ(aHV - 1);
                        this.cDS = aHV;
                    } else {
                        this.cDG.mo28199lP(i);
                        this.cDG.mo28200lQ((i + i2) - 1);
                        this.cDS = this.cDI.aHR();
                    }
                }
            }
        } else if (z) {
            this.cDG.mo28199lP(0);
            this.cDG.mo28200lQ(aHV - 1);
            this.cDS = aHV;
        } else {
            int i3 = aHT.get(0);
            this.cDG.mo28199lP(i3);
            if (agu()) {
                this.cDG.mo28200lQ(i3 + this.cDU);
            } else {
                this.cDG.mo28200lQ((i3 + aHV) - 1);
            }
            this.cDS = this.cDI.aHR();
        }
        this.cDG.mo28198lO(this.cDF);
        int aHN = this.cDI.aHN();
        Resources resources = this.cDH.getResources();
        int dimension = (int) resources.getDimension(R.dimen.d_45dp);
        int dimension2 = (int) resources.getDimension(R.dimen.d_45dp);
        int s = this.cDG.mo28202s(aHN, this.cDS, m16244lC(dimension), this.cDU);
        this.cDG.mo28179a(this.cDF, this.mClip, z);
        this.cDI.mo34254tN(s);
        this.cDG.mo28193cr(s, this.cDS);
        this.cDH.setClipIndex(this.cDF);
        this.cDH.setMbDragSatus(0);
        this.cDH.setLeftDraging(true);
        VeAdvanceTrimGallery.dxa = this.cDT;
        mo28135e(context, dimension, dimension2);
        ago();
        this.cDL = true;
        return true;
    }

    /* renamed from: eJ */
    public boolean mo28137eJ(boolean z) {
        if (this.cDH == null) {
            return false;
        }
        int agB = this.cDG.agB();
        int agC = this.cDG.agC();
        int agq = agq();
        if (z) {
            int i = agC - agB;
            if (i >= VeAdvanceTrimGallery.dxa) {
                return false;
            }
            int i2 = VeAdvanceTrimGallery.dxa - i;
            int i3 = i2 / 2;
            if (agB < i3) {
                this.cDG.mo28199lP(0);
                int i4 = agC + (i2 - (agB - 0));
                this.cDG.mo28200lQ(i4);
                this.cDH.setTrimRightValue(i4);
                this.cDH.invalidate();
                ago();
                return true;
            }
            int i5 = agq - agC;
            if (i5 < i3) {
                this.cDG.mo28200lQ(agq);
                int i6 = agB - (i2 - i5);
                this.cDG.mo28199lP(i6);
                this.cDH.setTrimLeftValue(i6);
                this.cDH.invalidate();
                ago();
                return true;
            }
            int i7 = agB - i3;
            this.cDG.mo28199lP(i7);
            int i8 = agC + i3;
            this.cDG.mo28200lQ(i8);
            this.cDH.setTrimLeftValue(i7);
            this.cDH.setTrimRightValue(i8);
            this.cDH.invalidate();
            ago();
            return true;
        }
        int i9 = (agq + agB) - agC;
        if (i9 >= VeAdvanceTrimGallery.dxa) {
            return false;
        }
        int i10 = (VeAdvanceTrimGallery.dxa - i9) / 2;
        int i11 = agB + i10;
        this.cDG.mo28199lP(i11);
        int i12 = agC - i10;
        this.cDG.mo28200lQ(i12);
        this.cDH.setTrimLeftValue(i11);
        this.cDH.setTrimRightValue(i12);
        this.cDH.invalidate();
        ago();
        return true;
    }

    public int getCurrentTime() {
        if (this.cDH == null) {
            return 0;
        }
        return this.cDH.getCurPlayPos();
    }

    public void initUI() {
        if (this.cDP != null) {
            this.cDH = (VeAdvanceTrimGallery) this.cDP.findViewById(R.id.ve_gallery);
            this.cDH.setVisibility(0);
            m16237eK(true);
            this.cDJ = true;
            this.cDQ = (TextView) this.cDP.findViewById(R.id.ve_split_left_time);
            this.cDR = (TextView) this.cDP.findViewById(R.id.ve_split_right_time);
        }
    }

    public boolean isPlaying() {
        return this.cDH != null && this.cDH.isPlaying();
    }

    /* renamed from: lA */
    public void mo28141lA(int i) {
        this.cDO = i;
    }

    /* renamed from: lB */
    public void mo28142lB(int i) {
        if (this.cDI != null && i > this.cDI.aHR()) {
            i = 0;
        }
        this.cDU = i;
    }

    /* renamed from: lD */
    public boolean mo28143lD(int i) {
        if (this.cDH == null) {
            return false;
        }
        this.cDH.setDrawableCurTimeNeedle(this.cDH.getResources().getDrawable(R.drawable.editor_icon_timeline_split_cursor));
        this.cDH.setSplitMode(true);
        m16245lH(this.cDH.getCurPlayPos());
        this.cDQ.setVisibility(8);
        this.cDR.setVisibility(0);
        int trimRightValue = this.cDH.getTrimRightValue() + 1;
        this.cDR.setText(C4580b.m11665ih(trimRightValue - this.cDH.getTrimLeftValue()));
        this.cDH.invalidate();
        return true;
    }

    /* renamed from: lE */
    public void mo28144lE(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("notifyCurPositionChanged time:");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        if (this.cDH != null) {
            this.cDH.setCurPlayPos(i);
            boolean avK = this.cDH.avK();
            if (this.cDz) {
                if (avK) {
                    int agC = this.cDG.agC();
                    if (VeAdvanceTrimGallery.dxa + i > agC) {
                        i = agC - VeAdvanceTrimGallery.dxa;
                    }
                    this.cDG.mo28199lP(i);
                    this.cDH.setTrimLeftValue(i);
                } else {
                    int agB = this.cDG.agB();
                    if (VeAdvanceTrimGallery.dxa + agB > i) {
                        i = VeAdvanceTrimGallery.dxa + agB;
                    }
                    this.cDG.mo28200lQ(i);
                    this.cDH.setTrimRightValue(i);
                }
            } else if (avK) {
                int agC2 = this.cDG.agC();
                if ((this.cDS + i) - agC2 < VeAdvanceTrimGallery.dxa) {
                    i = (agC2 + VeAdvanceTrimGallery.dxa) - this.cDS;
                }
                this.cDG.mo28199lP(i);
                this.cDH.setTrimLeftValue(i);
            } else {
                int agB2 = this.cDG.agB();
                if ((this.cDS - i) + agB2 < VeAdvanceTrimGallery.dxa) {
                    i = (this.cDS + agB2) - VeAdvanceTrimGallery.dxa;
                }
                this.cDG.mo28200lQ(i);
                this.cDH.setTrimRightValue(i);
            }
            ago();
        }
    }

    /* renamed from: lF */
    public int mo28145lF(int i) {
        if (this.cDH == null) {
            return 0;
        }
        return this.cDH.mo31288qu(i);
    }

    /* renamed from: lG */
    public void mo28146lG(int i) {
        setCurPlayPos(i);
        m16245lH(i);
    }

    /* renamed from: lI */
    public void mo28147lI(int i) {
        this.cDT = i;
    }

    public void setMinMaxEqualLimitEnable() {
        if (this.cDH != null) {
            this.cDH.setMinMaxEqualLimitEnable();
        }
    }

    public void setPlaying(boolean z) {
        if (this.cDH != null) {
            this.cDH.setPlaying(z);
        }
    }
}
