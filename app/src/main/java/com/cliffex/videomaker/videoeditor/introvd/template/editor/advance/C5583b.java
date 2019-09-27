package com.introvd.template.editor.advance;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.RangeUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.videotrim.p288b.C6966f;
import com.introvd.template.editor.videotrim.p292ui.VeGallery2;
import com.introvd.template.editor.videotrim.p292ui.VeGallery2.C6994a;
import com.introvd.template.editor.videotrim.p292ui.VePIPGallery.C7001d;
import com.introvd.template.editor.videotrim.p292ui.VePIPGallery.C7003f;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.ThumbInfo;
import com.introvd.template.sdk.utils.C8572y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;

/* renamed from: com.introvd.template.editor.advance.b */
public class C5583b {
    /* access modifiers changed from: private */
    public static int cuf = C4583d.m11671P(57.0f);
    /* access modifiers changed from: private */
    public static int cug = C4583d.m11671P(3.0f);
    /* access modifiers changed from: private */
    public static int cuh = C4583d.m11671P(1.0f);
    /* access modifiers changed from: private */
    public int aaE = 0;
    private volatile int cmY = 0;
    private MSize css = null;
    private volatile boolean cuA = true;
    /* access modifiers changed from: private */
    public volatile Range cuB = new Range();
    /* access modifiers changed from: private */
    public C5590c cuC;
    /* access modifiers changed from: private */
    public Drawable cuD = null;
    /* access modifiers changed from: private */
    public Drawable cuE = null;
    /* access modifiers changed from: private */
    public Drawable cuF = null;
    /* access modifiers changed from: private */
    public Drawable cuG = null;
    /* access modifiers changed from: private */
    public Drawable cuH = null;
    /* access modifiers changed from: private */
    public Drawable cuI = null;
    /* access modifiers changed from: private */
    public Drawable cuJ = null;
    /* access modifiers changed from: private */
    public Drawable cuK = null;
    /* access modifiers changed from: private */
    public Drawable cuL = null;
    /* access modifiers changed from: private */
    public Drawable cuM = null;
    private Drawable cuN = null;
    private C6994a cuO = new C6994a() {
        public void acC() {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", " onUp run");
            if (C5583b.this.mDragState >= 0 && C5583b.this.cuo != null) {
                int size = C5583b.this.cuo.size();
                Range range = null;
                if (C5583b.this.cuq >= 0 && C5583b.this.cuq < size) {
                    range = (Range) C5583b.this.cuo.get(C5583b.this.cuq);
                }
                if (C5583b.this.cuC != null) {
                    C5583b.this.cux = false;
                    C5583b.this.cuC.acd();
                    if (range != null) {
                        C5583b.this.cuC.mo27515a(C5583b.this.cuq, range);
                    }
                }
                if (!(C5583b.this.cuC == null || range == null)) {
                    int i = range.getmPosition();
                    if (C5583b.this.mDragState == 1) {
                        i = range.getLimitValue();
                    }
                    C5583b.this.updateProgress(i);
                }
            }
            C5583b.this.mDragState = -1;
            if (C5583b.this.cui != null) {
                C5583b.this.cui.setbInDraging(false);
                C5583b.this.cui.invalidate();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("test onUp isSeekStart:");
            sb.append(C5583b.this.cux);
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        }

        /* renamed from: cu */
        public void mo27501cu(View view) {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", " onMoveStoped run");
            if (C5583b.this.cuC != null) {
                C5583b.this.cuC.acd();
            }
            C5583b.this.cux = false;
        }

        /* renamed from: cv */
        public void mo27502cv(View view) {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", " onMoveStart run");
            C5583b.this.cux = true;
            C5583b.this.cur = 0;
            if (C5583b.this.cuC != null) {
                int acp = C5583b.this.acp();
                C5583b.this.cuC.acD();
                C5583b.this.cuC.mo27416kz(acp);
                C5583b.this.mo27497kL(acp);
            }
        }

        /* renamed from: w */
        public void mo27503w(MotionEvent motionEvent) {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", " onDown run");
            if (C5583b.this.cuq >= 0 && C5583b.this.cuo != null && C5583b.this.cuq < C5583b.this.cuo.size()) {
                Range range = (Range) C5583b.this.cuo.get(C5583b.this.cuq);
                if (range != null) {
                    int a = C5583b.this.m15227F((int) motionEvent.getX(), false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onDown range=");
                    sb.append(range);
                    sb.append(";time=");
                    sb.append(a);
                    LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
                    int i = a - range.getmPosition();
                    if (i <= -1500 || i >= 0) {
                        int limitValue = range.getLimitValue();
                        if (limitValue < 0 || limitValue == Integer.MAX_VALUE) {
                            limitValue = C5583b.this.mDuration;
                        }
                        int i2 = a - limitValue;
                        if (i2 < 1500 && i2 > 0) {
                            C5583b.this.mDragState = 1;
                            C5583b.this.cur = 2;
                            int c = C5583b.this.m15258kE(range.getLimitValue());
                            C5583b.this.mDeltaX = ((int) motionEvent.getX()) - (C5583b.this.act() + c);
                        }
                    } else {
                        C5583b.this.mDragState = 0;
                        C5583b.this.cur = 1;
                        int c2 = C5583b.this.m15258kE(range.getmPosition());
                        C5583b.this.mDeltaX = ((int) motionEvent.getX()) - (C5583b.this.act() + c2);
                    }
                    if (C5583b.this.mDragState >= 0 && C5583b.this.cui != null) {
                        C5583b.this.cui.setbInDraging(true);
                    }
                    if (C5583b.this.mState == 2) {
                        C5583b.this.mo27489b(range);
                    } else {
                        C5583b.this.mo27478a(range);
                    }
                    if (C5583b.this.cuC != null && C5583b.this.mDragState >= 0) {
                        C5583b.this.cux = true;
                        C5583b.this.cuC.mo27517dY(C5583b.this.acx());
                        C5583b.this.cuC.mo27416kz(range.getmPosition());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("test onDown isSeekStart:");
            sb2.append(C5583b.this.cux);
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb2.toString());
        }

        /* renamed from: x */
        public boolean mo27504x(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("test onSingleTap isSeekStart:");
            sb.append(C5583b.this.cux);
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
            if (motionEvent == null) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onSingleTap e:");
            sb2.append(motionEvent.getX());
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb2.toString());
            int i = -1;
            int a = C5583b.this.m15227F((int) motionEvent.getX(), false);
            if (C5583b.this.cuo != null && a < C5583b.this.mDuration) {
                i = C5583b.this.mo27495kJ(a);
            }
            if (!(C5583b.this.cuq == i || C5583b.this.cuC == null)) {
                C5583b.this.cuC.mo27519kM(C5583b.this.cuq);
            }
            return true;
        }

        /* renamed from: y */
        public void mo27505y(MotionEvent motionEvent) {
            if (C5583b.this.cui != null) {
                int x = ((int) motionEvent.getX()) - C5583b.this.mDeltaX;
                if (C5583b.this.cuq >= 0 && C5583b.this.cuo != null && C5583b.this.cuq < C5583b.this.cuo.size()) {
                    Range range = (Range) C5583b.this.cuo.get(C5583b.this.cuq);
                    if (range != null) {
                        boolean z = false;
                        if (C5583b.this.mState == 2) {
                            if (C5583b.this.mDragState == 1) {
                                C5583b.this.m15235a(range, C5583b.this.m15227F(x, true), false);
                                C5583b.this.cui.invalidate();
                                if (C5583b.this.cuC != null) {
                                    C5583b.this.cuC.mo27415iD(range.getLimitValue());
                                }
                            } else if (C5583b.this.acx()) {
                                int a = C5583b.this.m15227F(x, true);
                                C5583b.this.m15235a(range, a, true);
                                C5583b.this.cui.invalidate();
                                if (C5583b.this.cuC != null) {
                                    C5583b.this.cuC.mo27415iD(a);
                                }
                            }
                        } else if (C5583b.this.mDragState == 1) {
                            int a2 = C5583b.this.m15227F(x, true);
                            C5583b.this.m15235a(range, a2, false);
                            C5583b.this.cui.invalidate();
                            if (a2 >= C5583b.this.cus) {
                                z = true;
                            }
                            if (C5583b.this.cuC != null) {
                                C5583b.this.cuC.mo27518dZ(z);
                            }
                            if (C5583b.this.cuC != null) {
                                C5583b.this.cuC.mo27415iD(range.getLimitValue());
                            }
                        } else if (C5583b.this.acx()) {
                            int kF = C5583b.this.mo27494kF(C5583b.this.m15227F(x, true));
                            range.setmPosition(kF);
                            C5583b.this.cui.invalidate();
                            if (C5583b.this.cuC != null) {
                                C5583b.this.cuC.mo27415iD(kF);
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: y */
        public void mo27506y(View view, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(" onMoving run; movedistance=");
            sb.append(i);
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
            if (C5583b.this.cuC != null && C5583b.this.cux) {
                int acp = C5583b.this.acp();
                C5583b.this.cuC.mo27415iD(acp);
                C5583b.this.mo27497kL(acp);
            }
        }
    };
    private C7001d cuP = new C7001d() {
        /* renamed from: a */
        private void m15297a(Canvas canvas, Range range, int i, int i2) {
            if (range != null && range.getmTimeLength() > 0) {
                int i3 = range.getmPosition();
                int limitValue = range.getLimitValue();
                if (limitValue > C5583b.this.mDuration) {
                    limitValue = C5583b.this.mDuration;
                }
                int c = C5583b.this.m15258kE(i3);
                int c2 = C5583b.this.m15258kE(limitValue);
                int acz = C5583b.cuf;
                int i4 = (i - acz) / 2;
                View childAt = C5583b.this.cui.getChildAt(0);
                int i5 = childAt != null ? childAt.getLeft() > 0 ? childAt.getLeft() : childAt.getLeft() - (childAt.getWidth() * C5583b.this.cui.getFirstVisiblePosition()) : 0;
                canvas.save();
                int i6 = i5 + c;
                canvas.translate((float) i6, (float) i4);
                int i7 = (c2 - c) - 0;
                int count = C5583b.this.cui.getCount();
                if (C5583b.this.cuk > 0) {
                    count--;
                }
                int childWidth = (count * C5583b.this.cui.getChildWidth()) + ((C5583b.cuf * C5583b.this.cuk) / 3000);
                if (i7 > childWidth) {
                    i7 = childWidth;
                }
                C5583b.this.cuF.setBounds(0, 0, i7, acz);
                C5583b.this.cuF.draw(canvas);
                canvas.restore();
                Drawable t = C5583b.this.cur == 1 ? C5583b.this.cuL : C5583b.this.cuG;
                if (C5583b.this.mState == 2) {
                    t = C5583b.this.cur == 1 ? C5583b.this.cuK : C5583b.this.cuJ;
                }
                int intrinsicWidth = t.getIntrinsicWidth();
                int acz2 = C5583b.cuf + C5583b.cuh;
                int acA = ((i - acz2) - (C5583b.cuh / 2)) / 2;
                canvas.save();
                canvas.translate((float) ((C5583b.cug + i6) - intrinsicWidth), (float) acA);
                t.setBounds(0, 0, intrinsicWidth, acz2);
                t.draw(canvas);
                canvas.restore();
                if (C5583b.this.mState == 2 && C5583b.this.acx()) {
                    m15299d(canvas, i6);
                }
                Drawable x = C5583b.this.cur == 2 ? C5583b.this.cuM : C5583b.this.cuH;
                int intrinsicWidth2 = x.getIntrinsicWidth();
                int acz3 = C5583b.cuf + C5583b.cuh;
                int acA2 = ((i - acz3) - (C5583b.cuh / 2)) / 2;
                canvas.save();
                int i8 = i7 + i6;
                canvas.translate((float) (i8 - C5583b.cug), (float) acA2);
                x.setBounds(0, 0, intrinsicWidth2, acz3);
                x.draw(canvas);
                canvas.restore();
                if (C5583b.this.mDragState >= 0) {
                    if (C5583b.this.mDragState == 0) {
                        i8 = i6;
                    }
                    m15299d(canvas, i8);
                }
            }
        }

        /* renamed from: a */
        private void m15298a(Canvas canvas, Range range, int i, int i2, Drawable drawable) {
            if (range != null && range.getmTimeLength() > 0 && drawable != null) {
                int i3 = range.getmPosition();
                int limitValue = range.getLimitValue();
                int c = C5583b.this.m15258kE(i3);
                int c2 = C5583b.this.m15258kE(limitValue);
                if (c2 > C5583b.this.mDuration) {
                    c2 = C5583b.this.mDuration;
                }
                int acz = C5583b.cuf;
                int i4 = (i - acz) / 2;
                C5583b.this.cuv = C5583b.this.act() + c;
                canvas.save();
                canvas.translate((float) C5583b.this.cuv, (float) i4);
                int i5 = (c2 - c) - 0;
                int count = C5583b.this.cui.getCount();
                if (C5583b.this.cuk > 0) {
                    count--;
                }
                int childWidth = (count * C5583b.this.cui.getChildWidth()) + ((C5583b.cuf * C5583b.this.cuk) / 3000);
                if (i5 > childWidth) {
                    i5 = childWidth;
                }
                drawable.setBounds(0, 0, i5, acz);
                drawable.draw(canvas);
                canvas.restore();
                C5583b.this.cuw = C5583b.this.cuv + i5;
            }
        }

        /* renamed from: d */
        private void m15299d(Canvas canvas, int i) {
            int intrinsicHeight = C5583b.this.cuD.getIntrinsicHeight();
            int intrinsicWidth = C5583b.this.cuD.getIntrinsicWidth();
            int i2 = i - (intrinsicWidth / 2);
            canvas.save();
            canvas.translate((float) i2, 0.0f);
            C5583b.this.cuD.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            C5583b.this.cuD.draw(canvas);
            canvas.restore();
        }

        /* renamed from: a */
        public void mo27507a(ArrayList<Range> arrayList, Canvas canvas, int i, int i2, Drawable drawable) {
            if (arrayList != null) {
                ArrayList rangesWithoutIntersection = RangeUtils.getRangesWithoutIntersection(arrayList);
                if (rangesWithoutIntersection != null && rangesWithoutIntersection.size() > 0) {
                    int size = rangesWithoutIntersection.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Range range = (Range) rangesWithoutIntersection.get(i3);
                        if (range != null) {
                            m15298a(canvas, range, i, i2, drawable);
                        }
                    }
                }
            }
        }

        public void onDraw(Canvas canvas) {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", "onDraw ");
            if (!C5583b.this.acw() && C5583b.this.cui != null) {
                int width = C5583b.this.cui.getWidth();
                int height = C5583b.this.cui.getHeight();
                int intrinsicWidth = C5583b.this.cuD.getIntrinsicWidth();
                if (C5583b.this.cuB == null || C5583b.this.cuB.getmPosition() < 0 || C5583b.this.cuB.getmTimeLength() <= 0) {
                    mo27507a(C5583b.this.cuo, canvas, height, intrinsicWidth, C5583b.this.cuI);
                    boolean z = false;
                    if (C5583b.this.cuo != null && C5583b.this.cuq >= 0 && C5583b.this.cuq < C5583b.this.cuo.size()) {
                        Range range = (Range) C5583b.this.cuo.get(C5583b.this.cuq);
                        if (range != null) {
                            m15298a(canvas, range, height, intrinsicWidth, C5583b.this.cuE);
                            m15297a(canvas, range, height, intrinsicWidth);
                            z = true;
                        }
                    }
                    if (!z) {
                        mo27507a(C5583b.this.cuo, canvas, height, intrinsicWidth, C5583b.this.cuE);
                    }
                } else {
                    int i = height;
                    int i2 = intrinsicWidth;
                    mo27507a(C5583b.this.cuo, canvas, i, i2, C5583b.this.cuI);
                    m15298a(canvas, C5583b.this.cuB, i, i2, C5583b.this.cuE);
                }
                if (!(C5583b.this.mDragState == 0 || C5583b.this.mDragState == 1)) {
                    m15299d(canvas, width / 2);
                }
            }
        }
    };
    private final C7003f cuQ = new C7003f() {
        /* renamed from: cw */
        public void mo27509cw(View view) {
            LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", "onLayout run");
            if (!(C5583b.this.cui == null || C5583b.this.mHandler == null)) {
                C5583b.this.mHandler.sendEmptyMessageDelayed(401, 100);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean cuR = true;
    /* access modifiers changed from: private */
    public VeGallery2 cui = null;
    private C5587a cuj = null;
    /* access modifiers changed from: private */
    public int cuk = 0;
    private C6966f cul;
    protected Config cum = Config.ARGB_8888;
    /* access modifiers changed from: private */
    public C5592e cun;
    /* access modifiers changed from: private */
    public ArrayList<Range> cuo;
    /* access modifiers changed from: private */
    public volatile SparseArray<ArrayList<ThumbInfo>> cup = null;
    /* access modifiers changed from: private */
    public volatile int cuq = -1;
    /* access modifiers changed from: private */
    public volatile int cur = 0;
    /* access modifiers changed from: private */
    public volatile int cus = 0;
    private volatile int cut = 0;
    private volatile int cuu = 0;
    /* access modifiers changed from: private */
    public volatile int cuv = 0;
    /* access modifiers changed from: private */
    public volatile int cuw = 0;
    /* access modifiers changed from: private */
    public boolean cux = false;
    private boolean cuy = false;
    private volatile boolean cuz = false;
    /* access modifiers changed from: private */
    public volatile QClip mClip = null;
    /* access modifiers changed from: private */
    public int mDeltaX = 0;
    /* access modifiers changed from: private */
    public volatile int mDragState = -1;
    /* access modifiers changed from: private */
    public int mDuration = 0;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5589b(this);
    /* access modifiers changed from: private */
    public volatile int mState = 0;

    /* renamed from: com.introvd.template.editor.advance.b$a */
    public class C5587a extends BaseAdapter {
        private final Context mContext;

        /* renamed from: com.introvd.template.editor.advance.b$a$a */
        class C5588a {
            ImageView cuT;

            C5588a() {
            }
        }

        public C5587a(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            return C5583b.this.aaE;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C5588a aVar;
            if (view == null) {
                aVar = new C5588a();
                view2 = View.inflate(this.mContext, R.layout.editor_v4_timeline_item_layout, null);
                aVar.cuT = (ImageView) view2.findViewById(R.id.imgview_thumbnail);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (C5588a) view.getTag();
            }
            if (aVar.cuT != null) {
                if (i == C5583b.this.aaE - 1 && C5583b.this.cuk > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.cuT.getLayoutParams();
                    layoutParams.width = (C5583b.cuf * C5583b.this.cuk) / 3000;
                    layoutParams.height = C5583b.cuf;
                    aVar.cuT.setLayoutParams(layoutParams);
                }
                C5583b.this.m15240b(aVar.cuT, i);
            }
            return view2;
        }
    }

    /* renamed from: com.introvd.template.editor.advance.b$b */
    private static class C5589b extends Handler {
        WeakReference<C5583b> cuV;

        public C5589b(C5583b bVar) {
            this.cuV = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C5583b bVar = (C5583b) this.cuV.get();
            if (bVar != null) {
                int i = message.what;
                if (i == 101) {
                    bVar.m15259kG(message.arg1);
                } else if (i != 201) {
                    if (i != 301) {
                        if (i == 401 && bVar.cui != null) {
                            bVar.cui.mo30827hv(false);
                            bVar.cui.mo30831hz(false);
                        }
                    } else if (bVar.cui != null) {
                        int i2 = message.arg1;
                        boolean z = message.arg2 > 0;
                        int c = bVar.m15258kE(i2);
                        int F = bVar.aco();
                        int i3 = F - c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("time=");
                        sb.append(i2);
                        sb.append(";destPos=");
                        sb.append(c);
                        sb.append(";curPos=");
                        sb.append(F);
                        sb.append(";scrollLen=");
                        sb.append(i3);
                        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
                        int width = bVar.cui.getWidth();
                        boolean z2 = i3 > 0;
                        while (true) {
                            if ((!z2 || i3 <= width) && (z2 || i3 >= (-width))) {
                                bVar.cui.mo30847pT(i3);
                            } else {
                                int i4 = !z2 ? -width : width;
                                bVar.cui.mo30847pT(i4);
                                i3 -= i4;
                            }
                        }
                        bVar.cui.mo30847pT(i3);
                        if (bVar.cur == 0) {
                            bVar.mo27497kL(i2);
                        } else if (z && bVar.cuo != null) {
                            int size = bVar.cuo.size();
                            if (bVar.cuq >= 0 && bVar.cuq < size) {
                                Range range = (Range) bVar.cuo.get(bVar.cuq);
                                if (range != null) {
                                    if (bVar.cur != 1) {
                                        bVar.m15235a(range, i2, false);
                                    } else if (bVar.mState == 2) {
                                        bVar.m15235a(range, i2, true);
                                    } else {
                                        range.setmPosition(i2);
                                    }
                                }
                            }
                        }
                    }
                } else if (bVar.cun != null) {
                    bVar.cun.start();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.advance.b$c */
    public interface C5590c {
        /* renamed from: a */
        boolean mo27515a(int i, Range range);

        void acD();

        void acd();

        /* renamed from: dY */
        void mo27517dY(boolean z);

        /* renamed from: dZ */
        void mo27518dZ(boolean z);

        /* renamed from: iD */
        void mo27415iD(int i);

        /* renamed from: kM */
        void mo27519kM(int i);

        /* renamed from: kN */
        int mo27520kN(int i);

        /* renamed from: kz */
        void mo27416kz(int i);
    }

    /* renamed from: com.introvd.template.editor.advance.b$d */
    public static class C5591d implements C5590c {
        /* renamed from: a */
        public boolean mo27515a(int i, Range range) {
            return false;
        }

        public void acD() {
        }

        public void acd() {
        }

        /* renamed from: dY */
        public void mo27517dY(boolean z) {
        }

        /* renamed from: dZ */
        public void mo27518dZ(boolean z) {
        }

        /* renamed from: iD */
        public void mo27415iD(int i) {
        }

        /* renamed from: kM */
        public void mo27519kM(int i) {
        }

        /* renamed from: kN */
        public int mo27520kN(int i) {
            return 0;
        }

        /* renamed from: kz */
        public void mo27416kz(int i) {
        }
    }

    /* renamed from: com.introvd.template.editor.advance.b$e */
    public class C5592e extends Thread {
        private int cuW = 0;
        private int cuX = 0;
        private boolean cuY = false;

        public C5592e(int i, int i2) {
            this.cuW = i;
            this.cuX = i2;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:6|(6:11|(1:13)|14|(7:16|(2:18|(2:20|(1:24)))(3:25|(1:27)|28)|29|30|(1:32)|33|53)(3:34|(4:37|38|(1:55)(1:40)|35)|54)|52|7)|41|42|(1:44)|(1:50)|51) */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ff, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0100, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00df */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7 A[Catch:{ Exception -> 0x00ff }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                xiaoying.utils.QRect r0 = new xiaoying.utils.QRect
                int r1 = com.introvd.template.editor.advance.C5583b.cuf
                int r2 = com.introvd.template.editor.advance.C5583b.cuf
                r3 = 0
                r0.<init>(r3, r3, r1, r2)
                int r1 = com.introvd.template.editor.advance.C5583b.cuf
                int r2 = com.introvd.template.editor.advance.C5583b.cuf
                int r4 = xiaoying.utils.QColorSpace.QPAF_RGB32_A8R8G8B8
                xiaoying.utils.QBitmap r1 = xiaoying.utils.QBitmapFactory.createQBitmapBlank(r1, r2, r4)
                if (r1 != 0) goto L_0x0030
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                if (r0 == 0) goto L_0x002f
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                r0.destroyThumbnailManager()
            L_0x002f:
                return
            L_0x0030:
                r2 = 0
            L_0x0031:
                com.introvd.template.editor.advance.b r4 = com.introvd.template.editor.advance.C5583b.this
                boolean r4 = r4.cuR
                r5 = 0
                if (r4 == 0) goto L_0x00df
                boolean r4 = r10.cuY
                if (r4 == 0) goto L_0x0040
                goto L_0x00df
            L_0x0040:
                int r4 = r10.cuX
                if (r2 < r4) goto L_0x0047
                r4 = 1
                r10.cuY = r4
            L_0x0047:
                com.introvd.template.editor.advance.b r4 = com.introvd.template.editor.advance.C5583b.this
                int r4 = r4.acs()
                java.lang.String r6 = "AdvanceTimeLineMgr4MultiEffect"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "iCurDecodeIdentifier="
                r7.append(r8)
                r7.append(r4)
                java.lang.String r7 = r7.toString()
                com.introvd.template.common.LogUtils.m14223i(r6, r7)
                r6 = -1
                r7 = 100
                if (r4 == r6) goto L_0x00ca
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this
                android.util.SparseArray r6 = r6.cup
                if (r6 == 0) goto L_0x0094
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this
                android.util.SparseArray r6 = r6.cup
                java.lang.Object r6 = r6.get(r4)
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                if (r6 == 0) goto L_0x00a6
                com.introvd.template.editor.advance.b r9 = com.introvd.template.editor.advance.C5583b.this
                android.graphics.Bitmap r6 = r9.m15252g(r6)
                int r2 = r2 + 1
                if (r6 == 0) goto L_0x00a6
                boolean r9 = r6.isRecycled()
                if (r9 != 0) goto L_0x00a6
                com.introvd.template.editor.advance.b r9 = com.introvd.template.editor.advance.C5583b.this
                r9.mo27487b(r4, r6)
                goto L_0x00a6
            L_0x0094:
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this
                boolean r6 = r6.m15239a(r1, r4)
                int r2 = r2 + 1
                if (r6 != 0) goto L_0x00a1
                r1.fillColor(r3, r0, r5, r3)
            L_0x00a1:
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this
                r6.mo27477a(r4, r1)
            L_0x00a6:
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception | InterruptedException -> 0x00df }
                android.os.Handler r6 = r6.mHandler     // Catch:{ Exception | InterruptedException -> 0x00df }
                if (r6 == 0) goto L_0x00c5
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception | InterruptedException -> 0x00df }
                android.os.Handler r6 = r6.mHandler     // Catch:{ Exception | InterruptedException -> 0x00df }
                r9 = 101(0x65, float:1.42E-43)
                android.os.Message r6 = r6.obtainMessage(r9)     // Catch:{ Exception | InterruptedException -> 0x00df }
                r6.arg1 = r4     // Catch:{ Exception | InterruptedException -> 0x00df }
                com.introvd.template.editor.advance.b r4 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception | InterruptedException -> 0x00df }
                android.os.Handler r4 = r4.mHandler     // Catch:{ Exception | InterruptedException -> 0x00df }
                r4.sendMessage(r6)     // Catch:{ Exception | InterruptedException -> 0x00df }
            L_0x00c5:
                java.lang.Thread.sleep(r7)     // Catch:{ Exception | InterruptedException -> 0x00df }
                goto L_0x0031
            L_0x00ca:
                r4 = 0
            L_0x00cb:
                r6 = 10
                if (r4 >= r6) goto L_0x0031
                java.lang.Thread.sleep(r7)     // Catch:{  }
                com.introvd.template.editor.advance.b r6 = com.introvd.template.editor.advance.C5583b.this     // Catch:{  }
                boolean r6 = r6.cuR     // Catch:{  }
                if (r6 != 0) goto L_0x00dc
                goto L_0x0031
            L_0x00dc:
                int r4 = r4 + 1
                goto L_0x00cb
            L_0x00df:
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception -> 0x00ff }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x00ff }
                if (r0 == 0) goto L_0x0103
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception -> 0x00ff }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x00ff }
                r0.destroyThumbnailManager()     // Catch:{ Exception -> 0x00ff }
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception -> 0x00ff }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x00ff }
                r0.unInit()     // Catch:{ Exception -> 0x00ff }
                com.introvd.template.editor.advance.b r0 = com.introvd.template.editor.advance.C5583b.this     // Catch:{ Exception -> 0x00ff }
                r0.mClip = r5     // Catch:{ Exception -> 0x00ff }
                goto L_0x0103
            L_0x00ff:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0103:
                if (r1 == 0) goto L_0x010e
                boolean r0 = r1.isRecycled()
                if (r0 != 0) goto L_0x010e
                r1.recycle()
            L_0x010e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5583b.C5592e.run():void");
        }

        public synchronized void start() {
            super.start();
        }
    }

    public C5583b(VeGallery2 veGallery2, QClip qClip, int i, ArrayList<Range> arrayList, MSize mSize) {
        if (qClip != null) {
            this.cui = veGallery2;
            this.cuo = arrayList;
            this.mDuration = i;
            cuf = this.cui.getResources().getDimensionPixelSize(R.dimen.v5_xiaoying_timeline_item_width);
            this.mClip = new QClip();
            qClip.duplicate(this.mClip);
            if (this.mClip != null) {
                this.css = mSize;
                this.cuk = this.mDuration % 3000;
                this.aaE = acm();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public int m15227F(int i, boolean z) {
        int i2 = 0;
        if (z) {
            if (this.cui != null) {
                int firstVisiblePosition = this.cui.getFirstVisiblePosition();
                int lastVisiblePosition = this.cui.getLastVisiblePosition();
                int count = this.cui.getAdapter().getCount();
                int i3 = firstVisiblePosition;
                int i4 = 0;
                while (true) {
                    if (i3 > lastVisiblePosition) {
                        i2 = i4;
                        break;
                    }
                    View childAt = this.cui.getChildAt(i3 - firstVisiblePosition);
                    if (childAt != null) {
                        int left = childAt.getLeft();
                        int width = childAt.getWidth() + left;
                        if (i3 != count - 1) {
                            if (left <= i && width > i) {
                                i2 = (i3 * 3000) + (((i - left) * 3000) / cuf);
                                break;
                            }
                        } else {
                            int i5 = this.mDuration % 3000;
                            if (i5 <= 0) {
                                i5 = 3000;
                            }
                            if (left <= i && width >= i) {
                                i4 = (i3 * 3000) + (((i - left) * i5) / cuf);
                            } else if (i > width) {
                                i4 = this.mDuration;
                            }
                        }
                    }
                    i3++;
                }
            }
        } else if (this.cui != null) {
            int childWidth = this.cui.getChildWidth();
            int firstVisiblePosition2 = this.cui.getFirstVisiblePosition();
            View childAt2 = this.cui.getChildAt(0);
            if (childAt2 != null) {
                i2 = childAt2.getLeft() - (firstVisiblePosition2 * childWidth);
            }
            i2 = ((i - i2) * 3000) / childWidth;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(i2);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15235a(Range range, int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateRange range:");
        sb.append(range);
        sb.append(";time=");
        sb.append(i);
        sb.append(";bLeftAdjust=");
        sb.append(z);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateRange mDragMinLimitValue:");
        sb2.append(this.cut);
        sb2.append(";mDragMaxLimitValue=");
        sb2.append(this.cus);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb2.toString());
        int kF = mo27494kF(i);
        if (z) {
            int limitValue = range.getLimitValue();
            range.setmPosition(kF);
            range.setmTimeLength(limitValue - kF);
            return;
        }
        range.setmTimeLength(kF - range.getmPosition());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m15239a(xiaoying.utils.QBitmap r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.introvd.template.editor.videotrim.b.f r0 = r2.cul     // Catch:{ all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x0016
            xiaoying.engine.clip.QClip r0 = r2.mClip     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0016
        L_0x000b:
            xiaoying.engine.clip.QClip r0 = r2.mClip     // Catch:{ all -> 0x0018 }
            int r3 = com.introvd.template.sdk.utils.C8572y.m25063a(r0, r3, r4, r1)     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0014
            r1 = 1
        L_0x0014:
            monitor-exit(r2)
            return r1
        L_0x0016:
            monitor-exit(r2)
            return r1
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5583b.m15239a(xiaoying.utils.QBitmap, int):boolean");
    }

    private void acn() {
        if (this.cuk > 0) {
            int i = ((3000 - this.cuk) * cuf) / 3000;
            if (i >= 0 && this.cui != null) {
                this.cui.setLimitMoveOffset(0, i);
            }
        } else if (this.cui != null) {
            this.cui.setLimitMoveOffset(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public int aco() {
        int acp = acp();
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(acp);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        if (this.cui != null) {
            int firstVisiblePosition = this.cui.getFirstVisiblePosition();
            int centerOfGallery = this.cui.getCenterOfGallery();
            View childAt = this.cui.getChildAt(0);
            if (childAt != null) {
                int left = childAt.getLeft();
                int i = ((firstVisiblePosition * cuf) - left) + centerOfGallery;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("left=");
                sb2.append(left);
                sb2.append(";center=");
                sb2.append(centerOfGallery);
                LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb2.toString());
                return i;
            }
        }
        return 0;
    }

    private void acq() {
        if (this.cul == null && this.aaE > 0) {
            this.cul = new C6966f(cuf, cuf, this.cum);
            while (this.cul.getSize() < this.aaE) {
                this.cul.mo30641pY(-1);
            }
            this.cul.mo30640pX(3000);
            this.cul.mo30636db(0, this.aaE * 3000);
        }
    }

    private Bitmap acr() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(cuf, cuf, this.cum);
            if (createBitmap != null) {
                new Canvas(createBitmap).drawColor(0, Mode.CLEAR);
            }
            return createBitmap;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error ");
            sb.append(e.getMessage());
            LogUtils.m14222e("error", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int act() {
        if (this.cui == null) {
            return 0;
        }
        View childAt = this.cui.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        if (childAt.getLeft() > 0) {
            return childAt.getLeft();
        }
        return childAt.getLeft() - (childAt.getWidth() * this.cui.getFirstVisiblePosition());
    }

    private synchronized void acu() {
        QClip qClip = this.mClip;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m15240b(ImageView imageView, int i) {
        if (imageView == null) {
            return -1;
        }
        Bitmap kH = m15260kH(i);
        if (kH == null) {
            return -1;
        }
        if (this.cui != null) {
            this.cui.mo30826hu(true);
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(this.cui.getContext().getResources().getColor(17170445)), new BitmapDrawable(imageView.getContext().getResources(), kH)});
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
            this.cui.mo30826hu(false);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Bitmap m15252g(ArrayList<ThumbInfo> arrayList) {
        RectF rectF = new RectF();
        Rect rect = new Rect();
        Bitmap bitmap = null;
        if (arrayList != null && arrayList.size() > 1) {
            Bitmap acr = acr();
            if (acr == null) {
                return null;
            }
            Canvas canvas = new Canvas(acr);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ThumbInfo thumbInfo = (ThumbInfo) it.next();
                int duration = (thumbInfo.getDuration() * cuf) / 3000;
                if (duration > cuf) {
                    duration = cuf;
                }
                Bitmap kI = m15261kI(thumbInfo.getPosition());
                if (kI != null) {
                    rectF.left = (float) i;
                    rectF.right = (float) cuf;
                    rectF.top = 0.0f;
                    rectF.bottom = (float) cuf;
                    rect.left = 0;
                    rect.right = cuf - i;
                    rect.top = 0;
                    rect.bottom = cuf;
                    if (rect.width() > 0 && rectF.width() > 0.0f) {
                        canvas.drawBitmap(kI, rect, rectF, null);
                    }
                    i += duration;
                }
            }
            canvas.save();
            bitmap = acr;
        } else if (arrayList != null && arrayList.size() > 0) {
            bitmap = m15261kI(((ThumbInfo) arrayList.get(0)).getPosition());
        }
        return bitmap;
    }

    private void init() {
        if (this.cui != null) {
            Context context = this.cui.getContext();
            Resources resources = context.getResources();
            this.cuD = resources.getDrawable(R.drawable.v5_xiaoying_com_time_line_cur_time);
            this.cuE = null;
            this.cuF = null;
            this.cuG = resources.getDrawable(R.drawable.xiaoying_ve_simple_bgm_adjust);
            this.cuL = resources.getDrawable(R.drawable.xiaoying_ve_simple_bgm_adjust_focus);
            this.cuH = resources.getDrawable(R.drawable.v5_xiaoying_ve_simple_bgm_move_right);
            this.cuM = resources.getDrawable(R.drawable.v5_xiaoying_ve_simple_bgm_move_right_focus);
            this.cuJ = resources.getDrawable(R.drawable.v5_xiaoying_ve_simple_bgm_move_left);
            this.cuK = resources.getDrawable(R.drawable.v5_xiaoying_ve_simple_bgm_move_left_focus);
            this.cuI = resources.getDrawable(R.color.color_ff774e_p80);
            this.cuN = resources.getDrawable(R.drawable.xiaoying_ve_simple_timeline_range_sep_line);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Theme_Common, new int[]{R.attr.bgmeditbgDrawable, R.attr.trimmaskDrawable});
            this.cuF = resources.getDrawable(R.color.transparent);
            this.cuE = obtainStyledAttributes.getDrawable(1);
            obtainStyledAttributes.recycle();
            this.cui.setFocusable(true);
            this.cui.setLongClickable(false);
            this.cui.mo30831hz(true);
            this.cui.mo30825hA(true);
            this.cui.setLeftToCenterOffset(cuf / 2);
            this.cui.mo30829hx(true);
            this.cui.setOnLayoutListener(this.cuQ);
            this.cui.setOnGalleryDrawListener(this.cuP);
            this.cui.setOnGalleryOperationListener(this.cuO);
            this.cui.setChildWidth(cuf);
            acn();
            this.cuj = new C5587a(this.cui.getContext());
            this.cui.setAdapter((SpinnerAdapter) this.cuj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: kE */
    public int m15258kE(int i) {
        if (i < 0) {
            return 0;
        }
        return ((i / 3000) * cuf) + (((i % 3000) * cuf) / 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: kG */
    public void m15259kG(int i) {
        if (this.cui != null) {
            int i2 = i / 3000;
            int firstVisiblePosition = this.cui.getFirstVisiblePosition();
            if (i >= 0) {
                if (i2 == 0) {
                    int lastVisiblePosition = this.cui.getLastVisiblePosition();
                    for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                        int i4 = i3 - firstVisiblePosition;
                        RelativeLayout relativeLayout = (RelativeLayout) this.cui.getChildAt(i4);
                        if (relativeLayout != null) {
                            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.imgview_thumbnail);
                            if (imageView != null) {
                                m15240b(imageView, i4);
                            }
                        }
                    }
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) this.cui.getChildAt(i2 - firstVisiblePosition);
                if (relativeLayout2 != null) {
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(R.id.imgview_thumbnail);
                    if (imageView2 != null) {
                        m15240b(imageView2, i2);
                    }
                }
            }
        }
    }

    /* renamed from: kH */
    private Bitmap m15260kH(int i) {
        if (this.cul == null) {
            return null;
        }
        int auA = (i * 3000) + this.cul.auA();
        Bitmap pZ = this.cul.mo30642pZ(auA);
        if (pZ == null) {
            pZ = this.cul.mo30643qa(auA);
        }
        return pZ;
    }

    /* renamed from: kI */
    private Bitmap m15261kI(int i) {
        Bitmap bitmap = null;
        if (this.mClip == null) {
            return null;
        }
        QBitmap createQBitmapBlank = QBitmapFactory.createQBitmapBlank(cuf, cuf, QColorSpace.QPAF_RGB32_A8R8G8B8);
        if (C8572y.m25063a(this.mClip, createQBitmapBlank, i, false) == 0) {
            bitmap = Bitmap.createBitmap(cuf, cuf, this.cum);
            if (QAndroidBitmapFactory.transformQBitmapIntoBitmap(createQBitmapBlank, bitmap) == 0) {
                createQBitmapBlank.recycle();
            }
        }
        return bitmap;
    }

    /* renamed from: E */
    public void mo27476E(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress time=");
        sb.append(i);
        sb.append(";bFineTunning=");
        sb.append(z);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(HttpStatus.SC_MOVED_PERMANENTLY);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = z ? 1 : 0;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo27477a(int i, QBitmap qBitmap) {
        if (this.cul != null) {
            this.cul.mo30634b(i, qBitmap);
        }
    }

    /* renamed from: a */
    public void mo27478a(Range range) {
        if (this.cur == 2) {
            Range adjacentRange = RangeUtils.getAdjacentRange(this.cuo, this.cuq, false);
            if (adjacentRange != null) {
                this.cus = adjacentRange.getmPosition();
            } else {
                this.cus = this.mDuration;
            }
            if (this.cuC != null) {
                int kN = this.cuC.mo27520kN(this.cuq);
                if (kN > 0) {
                    int i = range.getmPosition() + kN;
                    if (i < this.cus) {
                        this.cus = i;
                    }
                }
            }
            this.cut = range.getmPosition() + HttpStatus.SC_INTERNAL_SERVER_ERROR;
        } else if (this.cur == 1) {
            Range adjacentRange2 = RangeUtils.getAdjacentRange(this.cuo, this.cuq, false);
            if (adjacentRange2 != null) {
                this.cus = adjacentRange2.getmPosition();
            } else {
                this.cus = this.mDuration;
            }
            this.cus -= range.getmTimeLength();
            Range adjacentRange3 = RangeUtils.getAdjacentRange(this.cuo, this.cuq, true);
            if (adjacentRange3 != null) {
                this.cut = adjacentRange3.getLimitValue();
            } else {
                this.cut = 0;
            }
            if (this.cui != null) {
                this.cui.invalidate();
            }
        } else {
            this.cus = 0;
            this.cut = 0;
        }
    }

    /* renamed from: a */
    public void mo27479a(C5590c cVar) {
        this.cuC = cVar;
    }

    public final int acm() {
        return (this.mDuration / 3000) + (this.cuk > 0 ? 1 : 0);
    }

    public int acp() {
        int i = 0;
        if (this.cui != null) {
            int centerOfGallery = this.cui.getCenterOfGallery();
            int firstVisiblePosition = this.cui.getFirstVisiblePosition();
            int lastVisiblePosition = this.cui.getLastVisiblePosition();
            int count = this.cui.getAdapter().getCount();
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (true) {
                if (i2 > lastVisiblePosition) {
                    i = i3;
                    break;
                }
                View childAt = this.cui.getChildAt(i2 - firstVisiblePosition);
                if (childAt != null) {
                    int left = childAt.getLeft();
                    int width = childAt.getWidth() + left;
                    if (i2 != count - 1) {
                        if (left <= centerOfGallery && width > centerOfGallery) {
                            i = (i2 * 3000) + (((centerOfGallery - left) * 3000) / cuf);
                            break;
                        }
                    } else {
                        i3 = (left > centerOfGallery || width < centerOfGallery) ? this.mDuration : (((centerOfGallery - left) * 3000) / cuf) + (i2 * 3000);
                    }
                }
                i2++;
            }
        }
        if (i > this.mDuration) {
            i = this.mDuration;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(i);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        return i;
    }

    /* access modifiers changed from: protected */
    public int acs() {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.acs();
    }

    public boolean acv() {
        return this.mDragState >= 0;
    }

    public boolean acw() {
        return this.cuy;
    }

    public boolean acx() {
        return this.mDragState == 0;
    }

    public int acy() {
        return this.aaE;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo27487b(int r2, android.graphics.Bitmap r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.introvd.template.editor.videotrim.b.f r0 = r1.cul     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            if (r3 == 0) goto L_0x0015
            boolean r0 = r3.isRecycled()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            com.introvd.template.editor.videotrim.b.f r0 = r1.cul     // Catch:{ all -> 0x0017 }
            r0.mo30635c(r2, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5583b.mo27487b(int, android.graphics.Bitmap):void");
    }

    /* renamed from: b */
    public void mo27488b(SparseArray<ArrayList<ThumbInfo>> sparseArray) {
        this.cup = sparseArray;
    }

    /* renamed from: b */
    public void mo27489b(Range range) {
        if (this.cuA) {
            if (this.cur == 2) {
                this.cus = this.mDuration;
                this.cut = range.getmPosition() + HttpStatus.SC_INTERNAL_SERVER_ERROR;
            } else if (this.cur == 1) {
                this.cut = 0;
                this.cus = range.getLimitValue() - 500;
            } else {
                this.cus = 0;
                this.cut = 0;
            }
        } else if (this.cur == 2) {
            Range adjacentRange = RangeUtils.getAdjacentRange(this.cuo, this.cuq, false);
            if (adjacentRange != null) {
                this.cus = adjacentRange.getmPosition();
            } else {
                this.cus = this.mDuration;
            }
            this.cut = range.getmPosition() + HttpStatus.SC_INTERNAL_SERVER_ERROR;
        } else if (this.cur == 1) {
            Range adjacentRange2 = RangeUtils.getAdjacentRange(this.cuo, this.cuq, true);
            if (adjacentRange2 != null) {
                this.cut = adjacentRange2.getLimitValue();
            } else {
                this.cut = 0;
            }
            this.cus = range.getLimitValue() - 500;
        } else {
            this.cus = 0;
            this.cut = 0;
        }
    }

    /* renamed from: dV */
    public void mo27490dV(boolean z) {
        int dI = C8572y.m25087dI(cuf, 4);
        int dI2 = C8572y.m25087dI(cuf, 4);
        if (this.css != null) {
            dI = this.css.width;
            dI2 = this.css.height;
        }
        if (this.mClip != null) {
            this.mClip.createThumbnailManager(C8572y.m25087dI(dI, 4), C8572y.m25087dI(dI2, 4), 65538, true, z);
            acq();
            init();
            this.cun = new C5592e(0, this.aaE);
            this.mHandler.sendEmptyMessageDelayed(201, 100);
        }
    }

    /* renamed from: dW */
    public void mo27491dW(boolean z) {
        if (this.cui == null) {
            return;
        }
        if (z) {
            this.cui.mo30830hy(true);
        } else {
            this.cui.mo30830hy(false);
        }
    }

    /* renamed from: dX */
    public void mo27492dX(boolean z) {
        this.cuy = z;
    }

    public synchronized void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.cuj != null) {
            this.aaE = 0;
            this.cuj.notifyDataSetChanged();
            this.cuj = null;
        }
        if (this.cui != null) {
            this.cui = null;
        }
        if (this.cuo != null) {
            this.cuo.clear();
            this.cuo = null;
        }
        if (this.cun != null) {
            this.cuR = false;
            this.cun = null;
        }
        acu();
        if (this.cul != null) {
            this.cul.auz();
            this.cul.mo30638hC(true);
            this.cul = null;
        }
        if (this.cup != null) {
            this.cup.clear();
            this.cup = null;
        }
    }

    /* renamed from: kF */
    public int mo27494kF(int i) {
        return i < this.cut ? this.cut : i > this.cus ? this.cus : i;
    }

    /* renamed from: kJ */
    public int mo27495kJ(int i) {
        if (this.cuo != null) {
            int size = this.cuo.size();
            for (int i2 = 0; i2 < size; i2++) {
                Range range = (Range) this.cuo.get(i2);
                if (range != null) {
                    if (this.cuA) {
                        if ((this.mState == 2 && range.contains2(i)) || ((this.mState != 2 && range.contains(i)) || (i == range.getLimitValue() && i == this.mDuration))) {
                            return i2;
                        }
                    } else if (range.contains(i) || (i == range.getLimitValue() && i == this.mDuration)) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    /* renamed from: kK */
    public void mo27496kK(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setmEditBGMRangeIndex editBGMRangeIndex=");
        sb.append(i);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        this.cuq = i;
        this.cur = 0;
        if (this.cui != null) {
            if (i >= 0) {
                this.cui.setbInEditMode(true);
            } else {
                this.cui.setbInEditMode(false);
            }
            this.cui.invalidate();
        }
    }

    /* renamed from: kL */
    public void mo27497kL(int i) {
        if (this.cuz && this.cuB != null) {
            int i2 = i - this.cuB.getmPosition();
            if (i2 < 0) {
                i2 = 0;
            }
            this.cuB.setmTimeLength(i2);
        }
    }

    public void setmState(int i) {
        this.mState = i;
    }

    public void updateProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress time=");
        sb.append(i);
        LogUtils.m14223i("AdvanceTimeLineMgr4MultiEffect", sb.toString());
        mo27476E(i, false);
    }
}
