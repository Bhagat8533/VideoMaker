package com.introvd.template.editor.videotrim.p292ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.videotrim.p288b.C6966f;
import com.introvd.template.editor.videotrim.p292ui.VePIPGallery.C7002e;
import com.introvd.template.editor.videotrim.p292ui.VePIPGallery.C7003f;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.PIPItemInfo;
import com.introvd.template.sdk.utils.C8572y;
import java.lang.ref.WeakReference;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.videotrim.ui.b */
public class C7010b {
    public static int cuf = C4583d.m11671P(44.0f);
    public static final int dni = C4583d.m11671P(44.0f);
    public static int dnj = 3000;
    /* access modifiers changed from: private */
    public int aaE;
    public int cDU;
    private final C7003f cuQ;
    /* access modifiers changed from: private */
    public volatile boolean cuR;
    /* access modifiers changed from: private */
    public int cuk;
    private C6966f cul;
    protected Config cum;
    /* access modifiers changed from: private */
    public C7015c dnf;
    /* access modifiers changed from: private */
    public VePIPGallery dnk;
    private C7013a dnl;
    private int dnm;
    private boolean dnn;
    private boolean dno;
    /* access modifiers changed from: private */
    public C7016d dnp;
    /* access modifiers changed from: private */
    public C7014b dnq;
    private C7002e dnr;
    /* access modifiers changed from: private */
    public int mBitmapHeight;
    /* access modifiers changed from: private */
    public int mBitmapWidth;
    /* access modifiers changed from: private */
    public QClip mClip;
    public int mDuration;
    private int mItemIndex;

    /* renamed from: com.introvd.template.editor.videotrim.ui.b$a */
    public class C7013a extends BaseAdapter {
        private final Context mContext;

        public C7013a(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            return C7010b.this.aaE;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(this.mContext, R.layout.editor_pip_trim_timeline_item_layout, null);
            if (inflate != null) {
                ImageView imageView = (ImageView) inflate.findViewById(R.id.imgview_thumbnail);
                if (imageView != null) {
                    if (i == C7010b.this.aaE - 1 && C7010b.this.cuk > 0) {
                        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                        layoutParams.width = (C7010b.cuf * C7010b.this.cuk) / C7010b.dnj;
                        layoutParams.height = C7010b.cuf;
                        imageView.setLayoutParams(layoutParams);
                    }
                    C7010b.this.m20537b(imageView, i);
                }
            }
            return inflate;
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.b$b */
    private static class C7014b extends Handler {
        WeakReference<C7010b> cuV;

        public C7014b(C7010b bVar) {
            this.cuV = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C7010b bVar = (C7010b) this.cuV.get();
            if (bVar != null) {
                int i = message.what;
                if (i == 101) {
                    bVar.m20547kG(message.arg1);
                } else if (i != 201) {
                    if (i == 401 && bVar.dnk != null) {
                        bVar.dnk.mo30827hv(false);
                        bVar.dnk.mo30831hz(false);
                    }
                } else if (bVar.dnp != null) {
                    bVar.dnp.start();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.b$c */
    public interface C7015c {
        void anY();

        void anZ();

        /* renamed from: nY */
        void mo29618nY(int i);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.b$d */
    public class C7016d extends Thread {
        private int cuX = 0;
        private boolean cuY = false;

        public C7016d(int i) {
            this.cuX = i;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:6|(6:11|(1:13)|14|(5:16|(1:18)|19|20|21)(3:22|(4:25|26|(1:42)(1:28)|23)|41)|39|7)|29|30|(1:32)|(1:37)|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00ad */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5 A[Catch:{ NullPointerException -> 0x00be }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                xiaoying.utils.QRect r0 = new xiaoying.utils.QRect
                com.introvd.template.editor.videotrim.ui.b r1 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                int r1 = r1.mBitmapWidth
                com.introvd.template.editor.videotrim.ui.b r2 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                int r2 = r2.mBitmapHeight
                r3 = 0
                r0.<init>(r3, r3, r1, r2)
                com.introvd.template.editor.videotrim.ui.b r1 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                int r1 = r1.mBitmapWidth
                com.introvd.template.editor.videotrim.ui.b r2 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                int r2 = r2.mBitmapHeight
                int r4 = xiaoying.utils.QColorSpace.QPAF_RGB32_A8R8G8B8
                xiaoying.utils.QBitmap r1 = xiaoying.utils.QBitmapFactory.createQBitmapBlank(r1, r2, r4)
                if (r1 != 0) goto L_0x0038
                com.introvd.template.editor.videotrim.ui.b r0 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                if (r0 == 0) goto L_0x0037
                com.introvd.template.editor.videotrim.ui.b r0 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                r0.destroyThumbnailManager()
            L_0x0037:
                return
            L_0x0038:
                r2 = 0
            L_0x0039:
                com.introvd.template.editor.videotrim.ui.b r4 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                boolean r4 = r4.cuR
                if (r4 == 0) goto L_0x00ad
                boolean r4 = r9.cuY
                if (r4 == 0) goto L_0x0046
                goto L_0x00ad
            L_0x0046:
                int r4 = r9.cuX
                if (r2 < r4) goto L_0x004d
                r4 = 1
                r9.cuY = r4
            L_0x004d:
                com.introvd.template.editor.videotrim.ui.b r4 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                int r4 = r4.acs()
                java.lang.String r5 = "PIPTrimGalleryDecorator"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "iCurDecodeIdentifier="
                r6.append(r7)
                r6.append(r4)
                java.lang.String r6 = r6.toString()
                com.introvd.template.common.LogUtils.m14223i(r5, r6)
                r5 = -1
                r6 = 100
                if (r4 == r5) goto L_0x0099
                com.introvd.template.editor.videotrim.ui.b r5 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                boolean r5 = r5.mo30905a(r1, r4)
                int r2 = r2 + 1
                if (r5 != 0) goto L_0x007c
                r5 = 0
                r1.fillColor(r3, r0, r5, r3)
            L_0x007c:
                com.introvd.template.editor.videotrim.ui.b r5 = com.introvd.template.editor.videotrim.p292ui.C7010b.this
                r5.mo30903a(r4, r1)
                android.os.Message r5 = new android.os.Message     // Catch:{ Exception | InterruptedException -> 0x00ad }
                r5.<init>()     // Catch:{ Exception | InterruptedException -> 0x00ad }
                r8 = 101(0x65, float:1.42E-43)
                r5.what = r8     // Catch:{ Exception | InterruptedException -> 0x00ad }
                r5.arg1 = r4     // Catch:{ Exception | InterruptedException -> 0x00ad }
                com.introvd.template.editor.videotrim.ui.b r4 = com.introvd.template.editor.videotrim.p292ui.C7010b.this     // Catch:{ Exception | InterruptedException -> 0x00ad }
                com.introvd.template.editor.videotrim.ui.b$b r4 = r4.dnq     // Catch:{ Exception | InterruptedException -> 0x00ad }
                r4.sendMessage(r5)     // Catch:{ Exception | InterruptedException -> 0x00ad }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception | InterruptedException -> 0x00ad }
                goto L_0x0039
            L_0x0099:
                r4 = 0
            L_0x009a:
                r5 = 10
                if (r4 >= r5) goto L_0x0039
                java.lang.Thread.sleep(r6)     // Catch:{  }
                com.introvd.template.editor.videotrim.ui.b r5 = com.introvd.template.editor.videotrim.p292ui.C7010b.this     // Catch:{  }
                boolean r5 = r5.cuR     // Catch:{  }
                if (r5 != 0) goto L_0x00aa
                goto L_0x0039
            L_0x00aa:
                int r4 = r4 + 1
                goto L_0x009a
            L_0x00ad:
                com.introvd.template.editor.videotrim.ui.b r0 = com.introvd.template.editor.videotrim.p292ui.C7010b.this     // Catch:{ NullPointerException -> 0x00be }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ NullPointerException -> 0x00be }
                if (r0 == 0) goto L_0x00be
                com.introvd.template.editor.videotrim.ui.b r0 = com.introvd.template.editor.videotrim.p292ui.C7010b.this     // Catch:{ NullPointerException -> 0x00be }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ NullPointerException -> 0x00be }
                r0.destroyThumbnailManager()     // Catch:{ NullPointerException -> 0x00be }
            L_0x00be:
                if (r1 == 0) goto L_0x00c9
                boolean r0 = r1.isRecycled()
                if (r0 != 0) goto L_0x00c9
                r1.recycle()
            L_0x00c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.videotrim.p292ui.C7010b.C7016d.run():void");
        }

        public synchronized void start() {
            super.start();
        }
    }

    public C7010b(VePIPGallery vePIPGallery) {
        this.mClip = null;
        this.dnk = null;
        this.dnl = null;
        this.mDuration = 0;
        this.cDU = -1;
        this.cuk = 0;
        this.aaE = 0;
        this.dnm = 0;
        this.mItemIndex = -1;
        this.dnn = false;
        this.dno = false;
        this.cum = Config.ARGB_8888;
        this.mBitmapWidth = 0;
        this.mBitmapHeight = 0;
        this.dnq = new C7014b(this);
        this.cuR = true;
        this.dnr = new C7002e() {
            public void acC() {
                LogUtils.m14223i("PIPTrimGalleryDecorator", "onUp isSeekStart:");
                if (C7010b.this.dnk != null) {
                    C7010b.this.dnk.invalidate();
                }
            }

            /* renamed from: cu */
            public void mo27501cu(View view) {
                LogUtils.m14223i("PIPTrimGalleryDecorator", "onMoveStoped isSeekStart:");
                if (C7010b.this.dnf != null) {
                    C7010b.this.dnf.anZ();
                }
            }

            /* renamed from: cv */
            public void mo27502cv(View view) {
                LogUtils.m14223i("PIPTrimGalleryDecorator", "onMoveStart isSeekStart:");
                if (C7010b.this.dnf != null) {
                    C7010b.this.dnf.anY();
                }
            }

            /* renamed from: w */
            public void mo27503w(MotionEvent motionEvent) {
                LogUtils.m14223i("PIPTrimGalleryDecorator", "onDown isSeekStart:");
            }

            /* renamed from: y */
            public void mo27505y(MotionEvent motionEvent) {
            }

            /* renamed from: y */
            public void mo27506y(View view, int i) {
                StringBuilder sb = new StringBuilder();
                sb.append(" onMoving run movedistance=");
                sb.append(i);
                LogUtils.m14223i("PIPTrimGalleryDecorator", sb.toString());
                if (C7010b.this.dnf != null) {
                    C7010b.this.dnf.mo29618nY(i);
                }
            }
        };
        this.cuQ = new C7003f() {
            /* renamed from: cw */
            public void mo27509cw(View view) {
                LogUtils.m14223i("PIPTrimGalleryDecorator", "onLayout run");
                if (C7010b.this.dnk != null) {
                    C7010b.this.dnq.sendEmptyMessageDelayed(401, 100);
                }
            }
        };
        this.dnk = vePIPGallery;
        cuf = this.dnk.getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_ve_framebar_item_show_width_dp);
        this.dnm = m20549lC(cuf);
    }

    public C7010b(PIPItemInfo pIPItemInfo, VePIPGallery vePIPGallery, int i) {
        this(vePIPGallery);
        this.mClip = new QClip();
        if (pIPItemInfo.getmClip().duplicate(this.mClip) != 0) {
            this.mClip.unInit();
            this.mClip = null;
            return;
        }
        this.mClip.setProperty(12292, new QRange(0, -1));
        this.mClip.setProperty(12314, new QRect(0, 0, 10000, 10000));
        this.mDuration = pIPItemInfo.getmSrcDuration();
        this.cDU = i;
        atL();
    }

    public C7010b(QClip qClip, VePIPGallery vePIPGallery, int i) {
        this(vePIPGallery);
        this.cDU = i;
        this.mClip = new QClip();
        if (qClip.duplicate(this.mClip) != 0) {
            this.mClip.unInit();
            this.mClip = null;
            return;
        }
        this.mDuration = this.mClip.getRealVideoDuration();
        atL();
    }

    private void acq() {
        if (this.cul == null && this.aaE > 0) {
            this.cul = new C6966f(this.mBitmapWidth, this.mBitmapHeight, this.cum);
            while (this.cul.getSize() < this.aaE) {
                this.cul.mo30641pY(-1);
            }
            this.cul.mo30640pX(dnj);
            this.cul.mo30636db(0, this.aaE * dnj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m20537b(ImageView imageView, int i) {
        if (imageView == null) {
            return -1;
        }
        Bitmap kH = m20548kH(i);
        if (kH == null) {
            return -1;
        }
        this.dnk.mo30826hu(true);
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), new BitmapDrawable(imageView.getContext().getResources(), kH)});
        imageView.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(200);
        this.dnk.mo30826hu(false);
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: kG */
    public void m20547kG(int i) {
        if (this.dnk != null && dnj > 0) {
            int i2 = i / dnj;
            int firstVisiblePosition = this.dnk.getFirstVisiblePosition();
            if (i >= 0) {
                int lastVisiblePosition = this.dnk.getLastVisiblePosition();
                StringBuilder sb = new StringBuilder();
                sb.append("onBitmapDecoded =");
                sb.append(i2);
                sb.append(";iStartIndex=");
                sb.append(firstVisiblePosition);
                sb.append(";iLastIndex=");
                sb.append(lastVisiblePosition);
                LogUtils.m14223i("PIPTrimGalleryDecorator", sb.toString());
                if (i2 == 0) {
                    for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                        int i4 = i3 - firstVisiblePosition;
                        RelativeLayout relativeLayout = (RelativeLayout) this.dnk.getChildAt(i4);
                        if (relativeLayout != null) {
                            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.imgview_thumbnail);
                            if (imageView != null) {
                                m20537b(imageView, i4);
                            }
                        }
                    }
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) this.dnk.getChildAt(i2 - firstVisiblePosition);
                if (relativeLayout2 != null) {
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(R.id.imgview_thumbnail);
                    if (imageView2 != null) {
                        m20537b(imageView2, i2);
                    }
                }
            }
        }
    }

    /* renamed from: kH */
    private Bitmap m20548kH(int i) {
        if (this.cul == null) {
            return null;
        }
        int auA = (dnj * i) + this.cul.auA();
        Bitmap pZ = this.cul.mo30642pZ(auA);
        if (pZ == null) {
            pZ = this.cul.mo30643qa(auA);
        }
        return pZ;
    }

    /* renamed from: lC */
    private int m20549lC(int i) {
        int i2 = Constants.getScreenSize().width / i;
        return Constants.getScreenSize().width % i < C4583d.m11671P(36.0f) ? i2 - 1 : i2;
    }

    /* renamed from: pJ */
    private void m20550pJ(int i) {
        if (this.dnk != null) {
            this.dnk.setLongClickable(false);
            this.dnk.setmGalleryCenterPosition(i);
            if (this.dnn) {
                int i2 = dnj > 0 ? (this.cDU * cuf) / dnj : 0;
                this.dnk.mo30825hA(true);
                this.dnk.setLimitMoveOffset(0, i2 + atN());
            }
            this.dnk.setOnLayoutListener(this.cuQ);
            this.dnk.setOnGalleryOperationListener(this.dnr);
            this.dnk.setChildWidth(cuf);
            this.dnl = new C7013a(this.dnk.getContext());
            this.dnk.setAdapter((SpinnerAdapter) this.dnl);
        }
    }

    /* renamed from: F */
    public int mo30902F(int i, boolean z) {
        int i2 = 0;
        if (z) {
            if (this.dnk != null && this.dnk.getAdapter() != null) {
                int firstVisiblePosition = this.dnk.getFirstVisiblePosition();
                int lastVisiblePosition = this.dnk.getLastVisiblePosition();
                int count = this.dnk.getAdapter().getCount();
                int i3 = firstVisiblePosition;
                int i4 = 0;
                while (true) {
                    if (i3 > lastVisiblePosition) {
                        i2 = i4;
                        break;
                    }
                    View childAt = this.dnk.getChildAt(i3 - firstVisiblePosition);
                    if (childAt != null) {
                        int left = childAt.getLeft();
                        int width = childAt.getWidth() + left;
                        if (i3 != count - 1) {
                            if (left <= i && width > i) {
                                i2 = (i3 * dnj) + (((i - left) * dnj) / cuf);
                                break;
                            }
                        } else if (this.dnn) {
                            int i5 = this.mDuration % dnj;
                            if (left <= i && width >= i) {
                                i4 = (dnj * i3) + (((i - left) * i5) / cuf);
                            } else if (i > width) {
                                i4 = this.mDuration;
                            }
                        } else {
                            i4 = width > i ? (dnj * i3) + (((i - left) * dnj) / cuf) : this.mDuration;
                        }
                    }
                    i3++;
                }
            }
        } else if (this.dnk != null) {
            int childWidth = this.dnk.getChildWidth();
            int firstVisiblePosition2 = this.dnk.getFirstVisiblePosition();
            View childAt2 = this.dnk.getChildAt(0);
            if (childAt2 != null) {
                i2 = childAt2.getLeft() - (firstVisiblePosition2 * childWidth);
            }
            i2 = ((i - i2) * dnj) / childWidth;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(i2);
        LogUtils.m14223i("PIPTrimGalleryDecorator", sb.toString());
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30903a(int i, QBitmap qBitmap) {
        if (this.cul != null) {
            this.cul.mo30634b(i, qBitmap);
        }
    }

    /* renamed from: a */
    public void mo30904a(C7015c cVar) {
        this.dnf = cVar;
    }

    /* renamed from: a */
    public boolean mo30905a(QBitmap qBitmap, int i) {
        boolean z = false;
        if (this.cul == null || this.mClip == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int b = C8572y.m25076b(this.mClip, qBitmap, i, true);
        StringBuilder sb = new StringBuilder();
        sb.append("importvideo getClipThumbnail time consume:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i("PIPTrimGalleryDecorator", sb.toString());
        if (b == 0) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public int acs() {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.acs();
    }

    public int act() {
        if (this.dnk == null) {
            return 0;
        }
        View childAt = this.dnk.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        if (childAt.getLeft() > 0) {
            return childAt.getLeft();
        }
        return childAt.getLeft() - (childAt.getWidth() * this.dnk.getFirstVisiblePosition());
    }

    public final void atL() {
        if (this.dnm > 0) {
            int i = 1;
            this.dno = this.cDU <= 0 || this.cDU >= this.mDuration;
            if (!this.dno) {
                this.dnn = true;
                dnj = this.cDU / this.dnm;
                if (dnj <= 0) {
                    this.cuk = 0;
                    this.aaE = 0;
                    return;
                }
                this.cuk = this.mDuration % dnj;
                int i2 = this.mDuration / dnj;
                if (this.cuk <= 0) {
                    i = 0;
                }
                this.aaE = i2 + i;
                return;
            }
            dnj = this.mDuration / this.dnm;
            this.cuk = 0;
            this.aaE = this.dnm;
            this.cDU = this.mDuration;
        }
    }

    public int atM() {
        return this.dnm * cuf;
    }

    public int atN() {
        if (atS() || this.cuk == 0) {
            return 0;
        }
        return ((dnj - this.cuk) * cuf) / dnj;
    }

    public int atO() {
        return this.dnk != null ? this.dnk.getCenterOfGallery() : Constants.getScreenSize().width / 2;
    }

    public float atP() {
        if (cuf > 0) {
            return ((float) dnj) / ((float) cuf);
        }
        return 10.0f;
    }

    public int atQ() {
        return this.cDU;
    }

    public int atR() {
        int i = 0;
        if (this.dnk != null) {
            int lastVisiblePosition = this.dnk.getLastVisiblePosition();
            View childAt = this.dnk.getChildAt(lastVisiblePosition - this.dnk.getFirstVisiblePosition());
            if (childAt != null) {
                i = childAt.getRight();
            }
            i += ((this.aaE - lastVisiblePosition) - 1) * this.dnk.getChildWidth();
        }
        return i - atN();
    }

    public boolean atS() {
        return this.dno;
    }

    public void destroy() {
        if (this.mClip != null) {
            this.mClip.unInit();
            this.mClip = null;
        }
        if (this.dnp != null) {
            this.dnp.interrupt();
            this.dnp = null;
        }
        if (this.dnk != null) {
            this.aaE = 0;
            this.dnl.notifyDataSetChanged();
            this.dnl = null;
            this.dnk.setAdapter((SpinnerAdapter) null);
            this.dnk = null;
        }
        if (this.cul != null) {
            this.cul.auz();
            this.cul.mo30638hC(true);
            this.cul = null;
        }
    }

    public int getmItemIndex() {
        return this.mItemIndex;
    }

    /* renamed from: hs */
    public void mo30918hs(boolean z) {
        this.dnn = z;
    }

    /* renamed from: pI */
    public boolean mo30919pI(int i) {
        this.mBitmapWidth = dni;
        this.mBitmapHeight = dni;
        this.mBitmapWidth = C8572y.m25087dI(this.mBitmapWidth, 4);
        this.mBitmapHeight = C8572y.m25087dI(this.mBitmapHeight, 4);
        if (this.mClip == null || this.mClip.createThumbnailManager(this.mBitmapWidth, this.mBitmapHeight, 65538, true, false) != 0) {
            return false;
        }
        acq();
        m20550pJ(i);
        this.dnp = new C7016d(this.aaE);
        this.dnq.sendEmptyMessageDelayed(201, 100);
        return true;
    }

    /* renamed from: pK */
    public int mo30920pK(int i) {
        return dnj <= 0 ? act() : ((i * cuf) / dnj) + act();
    }

    /* renamed from: pL */
    public int mo30921pL(int i) {
        if (dnj > 0) {
            return (i * cuf) / dnj;
        }
        return 0;
    }

    /* renamed from: pM */
    public void mo30922pM(int i) {
        if (this.dnk != null) {
            while (true) {
                if (i <= this.dnk.getWidth() && i >= (-this.dnk.getWidth())) {
                    this.dnk.mo30847pT(i);
                    return;
                } else if (i < 0) {
                    this.dnk.mo30847pT(-this.dnk.getWidth());
                    i += this.dnk.getWidth();
                } else {
                    this.dnk.mo30847pT(this.dnk.getWidth());
                    i -= this.dnk.getWidth();
                }
            }
        }
    }

    /* renamed from: q */
    public void mo30923q(boolean z, int i) {
        if (z) {
            this.dnk.setmLeftLimitMoveOffset(i);
        } else {
            this.dnk.setmRightLimitMoveOffset(i);
        }
    }

    public void setmItemIndex(int i) {
        this.mItemIndex = i;
    }
}
