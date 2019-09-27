package com.introvd.template.gallery.storyboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p375r.C8359a;
import com.introvd.template.xygallery.R;
import java.lang.ref.WeakReference;

class ClipDragGridView extends GridView {
    /* access modifiers changed from: private */
    public int dBW;
    private ImageView dIA = null;
    private View dIB = null;
    private int dIC;
    private int dID;
    private int dIE;
    private int dIF;
    private int dIG;
    private int dIH;
    private int dII = 1;
    private int dIJ = 1;
    private int dIK;
    /* access modifiers changed from: private */
    public String dIL;
    /* access modifiers changed from: private */
    public boolean dIM = false;
    private boolean dIN = false;
    private int dIO;
    private int dIP;
    private boolean dIQ = false;
    private boolean dIR = false;
    /* access modifiers changed from: private */
    public boolean dIS = true;
    private boolean dIT = true;
    private int dIU = 0;
    private int dIV = 0;
    private Vibrator dIW;
    private int dIX = 0;
    private int dIY = 0;
    /* access modifiers changed from: private */
    public C8359a dIZ;
    private int dIu;
    /* access modifiers changed from: private */
    public int dIv;
    private int dIw;
    private int dIx;
    private int dIy;
    private int dIz;
    /* access modifiers changed from: private */
    public int dJa = -1;
    /* access modifiers changed from: private */
    public boolean dJb = false;
    boolean dJc = false;

    /* renamed from: jL */
    private int f3545jL;

    /* renamed from: jM */
    private int f3546jM;
    private Context mContext;
    private Handler mHandler = new C7479a(this);
    private WindowManager windowManager = null;
    private LayoutParams windowParams = null;

    /* renamed from: com.introvd.template.gallery.storyboard.ClipDragGridView$a */
    private static class C7479a extends Handler {
        private WeakReference<ClipDragGridView> dJf;

        public C7479a(ClipDragGridView clipDragGridView) {
            this.dJf = new WeakReference<>(clipDragGridView);
        }

        public void handleMessage(Message message) {
            ClipDragGridView clipDragGridView = (ClipDragGridView) this.dJf.get();
            if (clipDragGridView != null) {
                switch (message.what) {
                    case 4097:
                        clipDragGridView.dIM = false;
                        break;
                    case 4098:
                        clipDragGridView.dIM = false;
                        break;
                }
            }
        }
    }

    public ClipDragGridView(Context context) {
        super(context);
        this.mContext = context;
        this.dIW = (Vibrator) this.mContext.getSystemService("vibrator");
        azp();
    }

    public ClipDragGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        if (!isInEditMode()) {
            this.dIW = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        azp();
    }

    private void azn() {
        if (this.dIA != null) {
            this.windowManager.removeView(this.dIA);
            this.dIA = null;
        }
        C7485a aVar = (C7485a) getAdapter();
        if (aVar != null) {
            aVar.azn();
        }
    }

    private void azp() {
        if (!isInEditMode()) {
            this.dIy = ((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - C4583d.m11670O(this.mContext, 13)) / 4) / 2;
            this.dIz = this.dIy;
        }
    }

    private void azq() {
        this.dIQ = true;
        this.dIE = getHeight() / 3;
        this.dIF = (getHeight() * 2) / 3;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.dIx = 4;
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        ViewGroup viewGroup2 = (ViewGroup) getChildAt(1);
        ViewGroup viewGroup3 = (ViewGroup) getChildAt(this.dIx);
        if (viewGroup != null) {
            viewGroup.getLocationOnScreen(iArr);
            this.dIX = iArr[0];
            this.dIY = iArr[1];
            if (viewGroup2 != null) {
                viewGroup2.getLocationOnScreen(iArr2);
                this.dIU = Math.abs(iArr2[0] - iArr[0]);
                if (viewGroup3 != null) {
                    viewGroup3.getLocationOnScreen(iArr3);
                    this.dIV = Math.abs(iArr3[1] - iArr[1]);
                    return;
                }
                return;
            }
            return;
        }
        int[] iArr4 = new int[2];
        getLocationOnScreen(iArr4);
        this.dIX = iArr4[0];
        this.dIY = iArr4[1];
    }

    private void azr() {
        ((C7485a) getAdapter()).mo32209il(false);
    }

    /* renamed from: c */
    private Bitmap m22108c(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) i, (float) i2);
        matrix.postScale(1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: d */
    private void m22111d(Bitmap bitmap, int i, int i2) {
        azn();
        this.windowParams = new LayoutParams();
        this.windowParams.gravity = 51;
        this.windowParams.x = (i - this.dIC) + this.dIG;
        this.windowParams.y = (i2 - this.dID) + this.dIH;
        this.windowParams.height = -2;
        this.windowParams.width = -2;
        this.windowParams.flags = 408;
        this.windowParams.windowAnimations = 0;
        this.windowParams.alpha = 0.8f;
        this.windowParams.format = -3;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(bitmap);
        this.windowManager = (WindowManager) getContext().getSystemService("window");
        this.windowManager.addView(imageView, this.windowParams);
        this.dIA = imageView;
    }

    /* renamed from: dk */
    private boolean m22112dk(int i, int i2) {
        return i / this.dIx == i2 / this.dIx;
    }

    /* renamed from: dl */
    private void m22113dl(int i, int i2) {
        m22114dm(i, i2);
    }

    /* renamed from: dm */
    private void m22114dm(int i, int i2) {
        this.dIB = getChildAt(this.dIu - getFirstVisiblePosition());
        if (this.dIB == null) {
            C7485a aVar = (C7485a) getAdapter();
            aVar.mo32209il(true);
            aVar.notifyDataSetChanged();
            return;
        }
        this.dIB.setVisibility(0);
        int[] iArr = new int[2];
        this.dIB.getLocationOnScreen(iArr);
        Animation dp = mo32148dp(((i - this.dIC) + this.dIG) - iArr[0], ((i2 - this.dID) + this.dIH) - iArr[1]);
        this.dIB.startAnimation(dp);
        this.dIu = this.dIw;
        dp.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                C7485a aVar = (C7485a) ClipDragGridView.this.getAdapter();
                aVar.mo32209il(true);
                aVar.notifyDataSetChanged();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    /* renamed from: dn */
    private void m22115dn(int i, int i2) {
        if (this.dIA != null) {
            this.windowParams.alpha = 0.8f;
            this.windowParams.x = (i - this.dIC) + this.dIG;
            if (i2 - this.dID > 0) {
                this.windowParams.y = (i2 - this.dID) + this.dIH;
            } else {
                this.windowParams.y = this.dIH;
            }
            this.windowManager.updateViewLayout(this.dIA, this.windowParams);
        }
        mo32152rD(i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: rC */
    public Boolean m22118rC(int i) {
        int i2 = this.f3545jL;
        int i3 = this.f3546jM;
        if (!this.dIQ) {
            azq();
        }
        this.dIv = i;
        this.dIu = i;
        this.dBW = i;
        if (this.dIu == -1) {
            return Boolean.valueOf(false);
        }
        ViewGroup viewGroup = (ViewGroup) getChildAt(this.dBW - getFirstVisiblePosition());
        if (viewGroup != null) {
            this.dIC = i2 - viewGroup.getLeft();
            this.dID = i3 - viewGroup.getTop();
            this.dIG = this.dIO - i2;
            this.dIH = this.dIP - i3;
            viewGroup.setFocusable(false);
            this.dIB = viewGroup;
            viewGroup.destroyDrawingCache();
            viewGroup.setDrawingCacheEnabled(true);
            Bitmap drawingCache = viewGroup.getDrawingCache(true);
            if (drawingCache == null) {
                viewGroup.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                viewGroup.layout(0, 0, viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
                viewGroup.buildDrawingCache();
                drawingCache = viewGroup.getDrawingCache();
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
                if (createBitmap == null) {
                    return Boolean.valueOf(false);
                }
                m22111d(m22108c(Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight()), viewGroup.getWidth() / 2, viewGroup.getHeight() / 2), i2, i3);
                azr();
                viewGroup.setVisibility(4);
                this.dIM = false;
                if (this.dIW != null) {
                    this.dIW.vibrate(100);
                }
            } catch (Exception unused) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(false);
    }

    /* renamed from: S */
    public boolean mo32146S(MotionEvent motionEvent) {
        setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!ClipDragGridView.this.dIS || (ClipDragGridView.this.dJb && adapterView.getAdapter().getCount() - 1 == i)) {
                    return false;
                }
                view.findViewById(R.id.img_delete).setVisibility(8);
                ListAdapter adapter = ClipDragGridView.this.getAdapter();
                if (adapter instanceof C7487b) {
                    view.findViewById(R.id.text_num).setVisibility(0);
                    view.findViewById(R.id.img_focus).setVisibility(0);
                    ((C7487b) adapter).mo32225ip(true);
                }
                if (ClipDragGridView.this.dIZ != null) {
                    ClipDragGridView.this.dIZ.mo32055ri(i);
                    ClipDragGridView.this.dJa = i;
                }
                return ClipDragGridView.this.m22118rC(i).booleanValue();
            }
        });
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* renamed from: do */
    public Animation mo32147do(int i, int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 0, (float) i, 1, 0.0f, 0, (float) i2);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    /* renamed from: dp */
    public Animation mo32148dp(int i, int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) i, 1, 0.0f, 0, (float) i2, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.dIR || this.dIS) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0) {
                this.f3545jL = x;
                this.f3546jM = y;
                this.dIO = (int) motionEvent.getRawX();
                this.dIP = (int) motionEvent.getRawY();
                if (this.dIS) {
                    return mo32146S(motionEvent);
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dIA != null && this.dIu != -1 && !this.dIR && this.dIS) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    azn();
                    m22113dl(x, y);
                    if (this.dIZ != null) {
                        this.dIZ.mo32056rj(this.dJa);
                    }
                    ListAdapter adapter = getAdapter();
                    if (adapter instanceof C7487b) {
                        ((C7487b) adapter).mo32225ip(false);
                        break;
                    }
                    break;
                case 2:
                    m22115dn(x, y);
                    if (!this.dIM) {
                        mo32156u(x, y, rawX, rawY);
                    }
                    return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: rD */
    public void mo32152rD(int i) {
        if (i < this.dIE) {
            this.dIK = (-((this.dIE - i) + 1)) / 10;
        } else if (i > this.dIF) {
            this.dIK = ((i - this.dIF) + 1) / 10;
        } else {
            this.dIK = 0;
        }
        getChildAt(this.dIu - getFirstVisiblePosition());
        smoothScrollBy(this.dIK, 0);
    }

    public void setDragEnabled(boolean z) {
        this.dIS = z;
    }

    public void setDragListener(C8359a aVar) {
        this.dIZ = aVar;
    }

    public void setLock(boolean z) {
        this.dIR = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00df A[SYNTHETIC] */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo32156u(int r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            int r6 = r5.pointToPosition(r6, r7)
            boolean r7 = r5.dIT
            r8 = -1
            r0 = 1
            if (r7 != 0) goto L_0x0014
            int r7 = r5.getCount()
            int r7 = r7 - r0
            if (r6 == r7) goto L_0x0013
            if (r6 != r8) goto L_0x0014
        L_0x0013:
            return
        L_0x0014:
            if (r6 == r8) goto L_0x001d
            int r7 = r5.dIu
            if (r6 == r7) goto L_0x001d
            r5.dIv = r6
            goto L_0x0067
        L_0x001d:
            int r6 = r5.getLastVisiblePosition()
            r7 = 2
            if (r6 < r7) goto L_0x0067
            int r6 = r5.getLastVisiblePosition()
            int r8 = r5.getFirstVisiblePosition()
            int r6 = r6 - r8
            android.view.View r6 = r5.getChildAt(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int[] r8 = new int[r7]
            r6.getLocationInWindow(r8)
            int r6 = r5.dBW
            int r1 = r5.dIx
            int r6 = r6 / r1
            int r1 = r5.getLastVisiblePosition()
            int r2 = r5.dIx
            int r1 = r1 / r2
            if (r6 >= r1) goto L_0x004a
            r6 = r8[r0]
            if (r9 > r6) goto L_0x0061
        L_0x004a:
            int r6 = r5.dBW
            int r1 = r5.dIx
            int r6 = r6 / r1
            int r1 = r5.getLastVisiblePosition()
            int r2 = r5.dIx
            int r1 = r1 / r2
            if (r6 != r1) goto L_0x0067
            r6 = r8[r0]
            int r8 = r5.dIy
            int r8 = r8 * 2
            int r6 = r6 + r8
            if (r9 <= r6) goto L_0x0067
        L_0x0061:
            int r6 = r5.getLastVisiblePosition()
            r5.dIv = r6
        L_0x0067:
            int r6 = r5.dIu
            int r7 = r5.dBW
            if (r6 == r7) goto L_0x0071
            int r6 = r5.dBW
            r5.dIu = r6
        L_0x0071:
            int r6 = r5.dIv
            int r7 = r5.dIu
            int r6 = r6 - r7
            int r7 = r5.dIu
            int r8 = r5.dBW
            r9 = 0
            if (r7 == r8) goto L_0x0084
            int r7 = r5.dIu
            int r8 = r5.dIv
            if (r7 != r8) goto L_0x0084
            r6 = 0
        L_0x0084:
            if (r6 == 0) goto L_0x0108
            int r7 = java.lang.Math.abs(r6)
            r8 = 0
        L_0x008b:
            if (r8 >= r7) goto L_0x0108
            if (r6 <= 0) goto L_0x00b1
            int r1 = r5.dIu
            int r1 = r1 + r0
            r5.dIw = r1
            int r1 = r5.dIu
            int r2 = r5.dIw
            boolean r1 = r5.m22112dk(r1, r2)
            if (r1 == 0) goto L_0x00a2
            int r2 = r5.dIU
            int r2 = -r2
            goto L_0x00a9
        L_0x00a2:
            int r2 = r5.dIx
            int r2 = r2 - r0
            int r3 = r5.dIU
            int r2 = r2 * r3
        L_0x00a9:
            if (r1 == 0) goto L_0x00ad
        L_0x00ab:
            r1 = 0
            goto L_0x00d0
        L_0x00ad:
            int r1 = r5.dIV
            int r1 = -r1
            goto L_0x00d0
        L_0x00b1:
            int r1 = r5.dIu
            int r1 = r1 - r0
            r5.dIw = r1
            int r1 = r5.dIu
            int r2 = r5.dIw
            boolean r1 = r5.m22112dk(r1, r2)
            if (r1 == 0) goto L_0x00c3
            int r2 = r5.dIU
            goto L_0x00cb
        L_0x00c3:
            int r2 = r5.dIx
            int r2 = r2 - r0
            int r2 = -r2
            int r3 = r5.dIU
            int r2 = r2 * r3
        L_0x00cb:
            if (r1 == 0) goto L_0x00ce
            goto L_0x00ab
        L_0x00ce:
            int r1 = r5.dIV
        L_0x00d0:
            int r3 = r5.dIw
            int r4 = r5.getFirstVisiblePosition()
            int r3 = r3 - r4
            android.view.View r3 = r5.getChildAt(r3)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x00e0
            return
        L_0x00e0:
            android.view.animation.Animation r1 = r5.mo32147do(r2, r1)
            r3.startAnimation(r1)
            int r2 = r5.dIw
            r5.dIu = r2
            int r2 = r5.dIu
            int r3 = r5.dIv
            if (r2 != r3) goto L_0x00f7
            java.lang.String r2 = r1.toString()
            r5.dIL = r2
        L_0x00f7:
            android.widget.ListAdapter r2 = r5.getAdapter()
            com.introvd.template.gallery.storyboard.a r2 = (com.introvd.template.gallery.storyboard.C7485a) r2
            com.introvd.template.gallery.storyboard.ClipDragGridView$2 r3 = new com.introvd.template.gallery.storyboard.ClipDragGridView$2
            r3.<init>(r2)
            r1.setAnimationListener(r3)
            int r8 = r8 + 1
            goto L_0x008b
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.storyboard.ClipDragGridView.mo32156u(int, int, int, int):void");
    }
}
