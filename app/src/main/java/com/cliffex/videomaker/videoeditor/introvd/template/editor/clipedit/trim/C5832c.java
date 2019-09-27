package com.introvd.template.editor.clipedit.trim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.bitmapfun.util.RecyclingImageView;
import com.introvd.template.editor.videotrim.p288b.C6966f;
import com.introvd.template.editor.widget.timeline.C7129d;
import com.introvd.template.editor.widget.timeline.VeGallery;
import com.introvd.template.editor.widget.timeline.VeGallery.LayoutParams;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import java.util.ArrayList;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.clipedit.trim.c */
public class C5832c {
    private View cEc = null;
    private int cEd = 0;
    private int cEe = 0;
    private int cEf = 0;
    private int cEg = 0;
    /* access modifiers changed from: private */
    public volatile QClip cEh;
    private C5833a cEi;
    private int cEj = 0;
    /* access modifiers changed from: private */
    public volatile boolean cEk = false;
    /* access modifiers changed from: private */
    public int cEl = -1;
    private final Object cEm = new Object();
    /* access modifiers changed from: private */
    public volatile Handler cEn;
    private ArrayList<String> cEo;
    /* access modifiers changed from: private */
    public int cEp = 0;
    /* access modifiers changed from: private */
    public int cEq;
    /* access modifiers changed from: private */
    public volatile boolean cuR = false;
    /* access modifiers changed from: private */
    public volatile boolean cuY = false;
    private C6966f cul;
    /* access modifiers changed from: private */
    public volatile boolean isImageClip = false;
    private Paint mPaint;

    /* renamed from: com.introvd.template.editor.clipedit.trim.c$a */
    protected class C5833a implements Runnable {
        protected C5833a() {
        }

        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread.getName = ");
            sb.append(Thread.currentThread().getName());
            sb.append("<>");
            sb.append(Thread.currentThread().getId());
            LogUtilsV2.m14227d(sb.toString());
            C8572y.m25062a(C5832c.this.cEh, 120, 120, 65538, true, false);
            QRect qRect = new QRect(0, 0, 120, 120);
            QBitmap createQBitmapBlank = QBitmapFactory.createQBitmapBlank(120, 120, QColorSpace.QPAF_RGB32_A8R8G8B8);
            Integer valueOf = Integer.valueOf(C5832c.this.agz());
            int i = 0;
            while (C5832c.this.cuR) {
                if (C5832c.this.cEk) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (C5832c.this.cuY) {
                    break;
                }
                if (i >= valueOf.intValue()) {
                    C5832c.this.cuY = true;
                }
                int a = C5832c.this.m16304lN((C5832c.this.cEl - 1) * C5832c.this.cEq);
                if (a == -1) {
                    a = C5832c.this.acs();
                }
                if (a != -1) {
                    if (!C5832c.this.isImageClip || i <= 0) {
                        if (!C5832c.this.mo28180a(createQBitmapBlank, a)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(">>>>>>>> get thumb fail;iCurDecodeIdentifier=");
                            sb2.append(a);
                            LogUtilsV2.m14227d(sb2.toString());
                            createQBitmapBlank.fillColor(0, qRect, null, 0);
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(">>>>>>>> get thumb suc;iCurDecodeIdentifier=");
                            sb3.append(a);
                            LogUtilsV2.m14227d(sb3.toString());
                        }
                        if (C5832c.this.mo28192b(a, createQBitmapBlank)) {
                            i++;
                        }
                        if (C5832c.this.cEn != null) {
                            Message message = new Message();
                            message.what = 1;
                            message.arg1 = a;
                            message.obj = createQBitmapBlank;
                            C5832c.this.cEn.sendMessage(message);
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                } else {
                    for (int i2 = 0; i2 < 10; i2++) {
                        Thread.sleep(100);
                        if (!C5832c.this.agG()) {
                            break;
                        }
                    }
                }
            }
            if (C5832c.this.cEh != null) {
                C5832c.this.cEh.destroyThumbnailManager();
                C5832c.this.cEh.unInit();
                C5832c.this.cEh = null;
            }
            if (createQBitmapBlank != null && !createQBitmapBlank.isRecycled()) {
                createQBitmapBlank.recycle();
            }
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.trim.c$b */
    public class C5834b extends BaseAdapter {
        int bvC;
        int cEs;
        private final Context mContext;

        public C5834b(Context context, int i, int i2) {
            this.mContext = context;
            this.bvC = i;
            this.cEs = i2;
        }

        public int getCount() {
            return C5832c.this.cEp;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (viewGroup == null) {
                return null;
            }
            VeGallery veGallery = (VeGallery) viewGroup;
            View childAt = veGallery.getChildAt(i - veGallery.getFirstVisiblePosition());
            if (childAt == null) {
                childAt = new RecyclingImageView(this.mContext);
            }
            ImageView imageView = (ImageView) childAt;
            C5832c.this.m16295c(imageView, i);
            imageView.setScaleType(ScaleType.FIT_XY);
            childAt.setLayoutParams(new LayoutParams(this.bvC, this.cEs));
            childAt.setLongClickable(false);
            return childAt;
        }
    }

    public C5832c(Handler handler) {
        this.cEn = handler;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.cEq = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }

    private void acq() {
        int agz = agz();
        if (this.cul == null) {
            this.cul = new C6966f(120, 120, Config.ARGB_8888);
            while (this.cul.getSize() < agz) {
                this.cul.mo30641pY(-1);
            }
        }
    }

    /* access modifiers changed from: private */
    public int agz() {
        return ((this.cEo == null || this.cEo.size() <= 0 || this.cEo.size() <= this.cEj) ? Integer.valueOf(12) : Integer.valueOf((String) this.cEo.get(this.cEj))).intValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m16295c(android.widget.ImageView r9, int r10) {
        /*
            r8 = this;
            r0 = -1
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "true"
            android.graphics.drawable.Drawable r2 = r9.getDrawable()
            boolean r2 = r2 instanceof android.graphics.drawable.BitmapDrawable
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = ">>>>>>>>>>>> 1"
            com.introvd.template.common.LogUtilsV2.m14227d(r2)
            android.graphics.drawable.Drawable r2 = r9.getDrawable()
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            if (r2 == 0) goto L_0x002d
            android.graphics.Bitmap r2 = r2.getBitmap()
            if (r2 == 0) goto L_0x002d
            boolean r5 = r2.isRecycled()
            if (r5 != 0) goto L_0x002d
            r2.eraseColor(r4)
            goto L_0x002e
        L_0x002d:
            r2 = r3
        L_0x002e:
            java.lang.String r5 = ">>>>>>>>>>>> 2"
            com.introvd.template.common.LogUtilsV2.m14227d(r5)
            r5 = 1108711834(0x4215999a, float:37.4)
            int r6 = com.introvd.template.p203b.C4583d.m11671P(r5)
            int r5 = com.introvd.template.p203b.C4583d.m11671P(r5)
            boolean r7 = r8.isImageClip()
            if (r7 != 0) goto L_0x0049
            android.graphics.Bitmap r10 = r8.mo28197kH(r10)
            goto L_0x004d
        L_0x0049:
            android.graphics.Bitmap r10 = r8.mo28197kH(r4)
        L_0x004d:
            java.lang.String r7 = ">>>>>>>>>>>> 3"
            com.introvd.template.common.LogUtilsV2.m14227d(r7)
            if (r10 != 0) goto L_0x005a
            java.lang.String r1 = "false"
            android.graphics.Bitmap r10 = r8.agA()
        L_0x005a:
            r9.setTag(r1)
            if (r2 == 0) goto L_0x0061
            r1 = r2
            goto L_0x006a
        L_0x0061:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r6, r5, r1)
            if (r1 != 0) goto L_0x006a
            return r0
        L_0x006a:
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r1)
            r0.save()
            java.lang.String r5 = ">>>>>>>>>>>> 4"
            com.introvd.template.common.LogUtilsV2.m14227d(r5)
            if (r10 == 0) goto L_0x0099
            boolean r5 = r10.isRecycled()
            if (r5 != 0) goto L_0x0099
            java.lang.String r5 = ">>>>>>>>>>>> 5"
            com.introvd.template.common.LogUtilsV2.m14227d(r5)
            android.graphics.Rect r5 = new android.graphics.Rect
            int r6 = r1.getWidth()
            int r7 = r1.getHeight()
            r5.<init>(r4, r4, r6, r7)
            android.graphics.Paint r6 = new android.graphics.Paint
            r6.<init>()
            r0.drawBitmap(r10, r3, r5, r6)
        L_0x0099:
            r0.restore()
            if (r2 == 0) goto L_0x00a7
            java.lang.String r10 = ">>>>>>>>>>>> 6"
            com.introvd.template.common.LogUtilsV2.m14227d(r10)
            r9.invalidate()
            goto L_0x00b2
        L_0x00a7:
            java.lang.String r10 = ">>>>>>>>>>>> 7"
            com.introvd.template.common.LogUtilsV2.m14227d(r10)
            r9.setImageBitmap(r1)
            r9.invalidate()
        L_0x00b2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.trim.C5832c.m16295c(android.widget.ImageView, int):int");
    }

    /* access modifiers changed from: private */
    /* renamed from: lN */
    public int m16304lN(int i) {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.mo30639lN(i);
    }

    /* renamed from: a */
    public void mo28179a(int i, QClip qClip, boolean z) {
        acq();
        if (qClip != null && this.cul != null) {
            this.cEh = C8537n.m24796a(qClip, C8501a.aJs().aJv(), z);
            if (this.cEh != null) {
                if (this.cEi == null) {
                    this.cEi = new C5833a();
                }
                if (this.cul.dpS != i) {
                    this.cul.dpS = i;
                    this.cul.mo30638hC(true);
                }
                mo28194eN(true);
                C7129d.m21090j(this.cEi);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo28180a(QBitmap qBitmap, int i) {
        boolean z = false;
        if (this.cEh == null) {
            return false;
        }
        if (C8572y.m25076b(this.cEh, qBitmap, i, true) == 0) {
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

    public Bitmap agA() {
        if (this.cul == null) {
            return null;
        }
        return this.cul.auy();
    }

    public int agB() {
        return this.cEe;
    }

    public int agC() {
        return this.cEf;
    }

    public int agD() {
        return this.cEg;
    }

    public int agE() {
        return this.cEq;
    }

    public C6966f agF() {
        return this.cul;
    }

    public boolean agG() {
        return this.cuR;
    }

    public void agx() {
        this.cuR = false;
        synchronized (this.cEm) {
            this.cEn.removeMessages(1);
        }
    }

    public void agy() {
        if (this.cul != null) {
            this.cul.auz();
            this.cul = null;
        }
    }

    /* renamed from: b */
    public int mo28191b(ImageView imageView, int i) {
        if (imageView == null) {
            return -1;
        }
        Bitmap kH = mo28197kH(i);
        if (kH == null) {
            return -1;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), new BitmapDrawable(imageView.getContext().getResources(), kH)});
        imageView.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(200);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo28192b(int i, QBitmap qBitmap) {
        if (this.cul == null) {
            return false;
        }
        return this.cul.mo30634b(i, qBitmap);
    }

    /* renamed from: cr */
    public void mo28193cr(int i, int i2) {
        this.cEj = i;
        String str = this.cEo != null ? (String) this.cEo.get(i) : null;
        if (!TextUtils.isEmpty(str)) {
            this.cEp = Integer.valueOf(str).intValue();
            if (this.cEq == 500 && this.cEp != 0) {
                this.cEq = i2 / this.cEp;
            }
            if (this.cul != null) {
                this.cul.mo30640pX(this.cEq);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>> miIdentifierStep=");
        sb.append(this.cEq);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">>>>>>> mTrimGalleryChildCount=");
        sb2.append(this.cEp);
        LogUtilsV2.m14227d(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(">>>>>>> mCurScaleLevel=");
        sb3.append(this.cEj);
        LogUtilsV2.m14227d(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(">>>>>>> clipDuration=");
        sb4.append(i2);
        LogUtilsV2.m14227d(sb4.toString());
    }

    /* renamed from: eN */
    public void mo28194eN(boolean z) {
        this.cuR = z;
    }

    /* renamed from: eO */
    public void mo28195eO(boolean z) {
        this.cEk = z;
    }

    public boolean isImageClip() {
        return this.isImageClip;
    }

    /* renamed from: kH */
    public Bitmap mo28197kH(int i) {
        if (this.cul == null) {
            return null;
        }
        return this.cul.mo30642pZ((this.cEq * i) + this.cul.auA());
    }

    /* renamed from: lO */
    public void mo28198lO(int i) {
        this.cEd = i;
    }

    /* renamed from: lP */
    public void mo28199lP(int i) {
        this.cEe = i;
    }

    /* renamed from: lQ */
    public void mo28200lQ(int i) {
        this.cEf = i;
    }

    /* renamed from: lR */
    public void mo28201lR(int i) {
        this.cEl = i;
    }

    /* renamed from: s */
    public int mo28202s(int i, int i2, int i3, int i4) {
        if (this.cEo != null) {
            this.cEo.clear();
        } else {
            this.cEo = new ArrayList<>();
        }
        if (i3 > 0) {
            if (i4 > 0 && i4 < i2) {
                int i5 = i4 / i3;
                if (i5 > 0) {
                    this.cEq = i5;
                    int i6 = (i2 / this.cEq) + (i2 % this.cEq > 0 ? 1 : 0);
                    ArrayList<String> arrayList = this.cEo;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(i6);
                    arrayList.add(sb.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(i3);
            this.cEo.add(sb2.toString());
            this.cEq = i2 / i3;
        } else {
            int i7 = i2 / HttpStatus.SC_INTERNAL_SERVER_ERROR;
            int i8 = 3;
            int i9 = 0;
            while (true) {
                if (i8 >= 20) {
                    break;
                }
                int pow = (int) (((double) i3) * Math.pow(2.0d, (double) (i8 - 3)));
                if (pow <= i7) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(pow);
                    this.cEo.add(sb3.toString());
                    i9 = i2 / pow;
                }
                if (pow <= i7) {
                    i8++;
                } else if (i9 >= 250) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(i7);
                    this.cEo.add(sb4.toString());
                }
            }
            if (this.cEo.size() == 0) {
                if (i2 % 100 >= 50) {
                    i7++;
                }
                if (i7 < 1) {
                    i7 = 1;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(i7);
                this.cEo.add(sb5.toString());
                if (i2 >= 500) {
                    this.cEq = HttpStatus.SC_INTERNAL_SERVER_ERROR;
                } else {
                    this.cEq = i2;
                }
            }
        }
        if (i >= this.cEo.size()) {
            i = this.cEo.size() - 1;
        }
        if (i < 0) {
            int i10 = -1;
            for (int i11 = 0; i11 < this.cEo.size(); i11++) {
                int intValue = Integer.valueOf((String) this.cEo.get(i11)).intValue();
                if (intValue != 0) {
                    int i12 = i2 / intValue;
                    if (i10 == -1 || Math.abs(i12 - 1000) < i10) {
                        i10 = Math.abs(i12 - 1000);
                        i = i11;
                    }
                }
            }
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\r");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">>>>>>>>>>> mOldChildView=");
        sb2.append(this.cEc.getId());
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(">>>>>>>>>>> mOldChildViewAbsolutePosition=");
        sb3.append(this.cEd);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(">>>>>>>>>>> mTrimLeftValue=");
        sb4.append(this.cEe);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(">>>>>>>>>>> mTrimRightValue=");
        sb5.append(this.cEf);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(">>>>>>>>>>> mGalleryCenterViewLeft=");
        sb6.append(this.cEg);
        sb.append(sb6.toString());
        return sb.toString();
    }
}
