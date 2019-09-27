package com.introvd.template.xyui.ripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.introvd.template.ui.widget.R;

public class MaterialRippleLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public View bsb;
    /* access modifiers changed from: private */
    public int cmQ;
    private Drawable cmR;
    private float cmS;
    private Point cmT;
    private GestureDetector eDA;
    private C9171a eDB;
    private C9172b eDC;
    /* access modifiers changed from: private */
    public boolean eDD;
    private SimpleOnGestureListener eDE;
    private Property<MaterialRippleLayout, Float> eDF;
    private Property<MaterialRippleLayout, Integer> eDG;
    private boolean eDl;
    /* access modifiers changed from: private */
    public boolean eDm;
    private int eDn;
    private int eDo;
    /* access modifiers changed from: private */
    public boolean eDp;
    private int eDq;
    /* access modifiers changed from: private */
    public boolean eDr;
    /* access modifiers changed from: private */
    public boolean eDs;
    private AdapterView eDt;
    private AnimatorSet eDu;
    private ObjectAnimator eDv;
    private Point eDw;
    private boolean eDx;
    /* access modifiers changed from: private */
    public boolean eDy;
    private int eDz;
    private int layerType;

    /* renamed from: mQ */
    private final Rect f3682mQ;

    /* renamed from: oS */
    private float f3683oS;
    private final Paint paint;
    private int rippleColor;

    /* renamed from: com.introvd.template.xyui.ripple.MaterialRippleLayout$a */
    private class C9171a implements Runnable {
        private C9171a() {
        }

        /* renamed from: b */
        private void m26696b(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(MaterialRippleLayout.this);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0;
            if (positionForView != -1) {
                adapterView.performItemClick(MaterialRippleLayout.this, positionForView, itemId);
            }
        }

        public void run() {
            if (!MaterialRippleLayout.this.eDD) {
                if (MaterialRippleLayout.this.getParent() instanceof AdapterView) {
                    if (!MaterialRippleLayout.this.bsb.performClick()) {
                        m26696b((AdapterView) MaterialRippleLayout.this.getParent());
                    }
                } else if (MaterialRippleLayout.this.eDs) {
                    m26696b(MaterialRippleLayout.this.aOb());
                } else {
                    MaterialRippleLayout.this.bsb.performClick();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.xyui.ripple.MaterialRippleLayout$b */
    private final class C9172b implements Runnable {
        private final MotionEvent eDJ;

        public C9172b(MotionEvent motionEvent) {
            this.eDJ = motionEvent;
        }

        public void run() {
            MaterialRippleLayout.this.eDy = false;
            MaterialRippleLayout.this.bsb.setLongClickable(false);
            MaterialRippleLayout.this.bsb.onTouchEvent(this.eDJ);
            MaterialRippleLayout.this.bsb.setPressed(true);
            if (MaterialRippleLayout.this.eDm) {
                MaterialRippleLayout.this.aNZ();
            }
        }
    }

    /* renamed from: com.introvd.template.xyui.ripple.MaterialRippleLayout$c */
    public static class C9173c {
        private final Context context;
        private final View eDK;
        private float eDL = 35.0f;
        private float eDM = 0.2f;
        private int eDN = 0;
        private boolean eDO = false;
        private float eDP = 0.0f;
        private boolean eDl = false;
        private boolean eDm = true;
        private int eDo = 350;
        private boolean eDp = true;
        private int eDq = 75;
        private boolean eDr = false;
        private int rippleColor = -16777216;

        public C9173c(View view) {
            this.eDK = view;
            this.context = view.getContext();
        }

        public MaterialRippleLayout aOe() {
            int i;
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.context);
            materialRippleLayout.setRippleColor(this.rippleColor);
            materialRippleLayout.setDefaultRippleAlpha(this.eDM);
            materialRippleLayout.setRippleDelayClick(this.eDp);
            materialRippleLayout.setRippleDiameter((int) MaterialRippleLayout.m26673a(this.context.getResources(), this.eDL));
            materialRippleLayout.setRippleDuration(this.eDo);
            materialRippleLayout.setRippleFadeDuration(this.eDq);
            materialRippleLayout.setRippleHover(this.eDm);
            materialRippleLayout.setRipplePersistent(this.eDr);
            materialRippleLayout.setRippleOverlay(this.eDl);
            materialRippleLayout.setRippleBackground(this.eDN);
            materialRippleLayout.setRippleInAdapter(this.eDO);
            materialRippleLayout.setRippleRoundedCorners((int) MaterialRippleLayout.m26673a(this.context.getResources(), this.eDP));
            LayoutParams layoutParams = this.eDK.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) this.eDK.getParent();
            if (viewGroup == null || !(viewGroup instanceof MaterialRippleLayout)) {
                if (viewGroup != null) {
                    i = viewGroup.indexOfChild(this.eDK);
                    viewGroup.removeView(this.eDK);
                } else {
                    i = 0;
                }
                materialRippleLayout.addView(this.eDK, new LayoutParams(-1, -1));
                if (viewGroup != null) {
                    viewGroup.addView(materialRippleLayout, i, layoutParams);
                }
                return materialRippleLayout;
            }
            throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
        }

        /* renamed from: aW */
        public C9173c mo36189aW(float f) {
            this.eDM = f;
            return this;
        }

        /* renamed from: jR */
        public C9173c mo36190jR(boolean z) {
            this.eDl = z;
            return this;
        }

        /* renamed from: jS */
        public C9173c mo36191jS(boolean z) {
            this.eDm = z;
            return this;
        }

        /* renamed from: vU */
        public C9173c mo36192vU(int i) {
            this.rippleColor = i;
            return this;
        }
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint(1);
        this.f3682mQ = new Rect();
        this.cmT = new Point();
        this.eDw = new Point();
        this.eDE = new SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                MaterialRippleLayout.this.eDD = false;
                return super.onDown(motionEvent);
            }

            public void onLongPress(MotionEvent motionEvent) {
                MaterialRippleLayout.this.eDD = MaterialRippleLayout.this.bsb.performLongClick();
                if (MaterialRippleLayout.this.eDD) {
                    if (MaterialRippleLayout.this.eDm) {
                        MaterialRippleLayout.this.m26691m(null);
                    }
                    MaterialRippleLayout.this.aNY();
                }
            }
        };
        this.eDF = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
            /* renamed from: a */
            public void set(MaterialRippleLayout materialRippleLayout, Float f) {
                materialRippleLayout.setRadius(f.floatValue());
            }

            /* renamed from: l */
            public Float get(MaterialRippleLayout materialRippleLayout) {
                return Float.valueOf(materialRippleLayout.getRadius());
            }
        };
        this.eDG = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
            /* renamed from: a */
            public void set(MaterialRippleLayout materialRippleLayout, Integer num) {
                materialRippleLayout.setRippleAlpha(num);
            }

            /* renamed from: m */
            public Integer get(MaterialRippleLayout materialRippleLayout) {
                return Integer.valueOf(materialRippleLayout.getRippleAlpha());
            }
        };
        setWillNotDraw(false);
        this.eDA = new GestureDetector(context, this.eDE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialRippleLayout);
        this.rippleColor = obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleColor, -16777216);
        this.eDn = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleDimension, (int) m26673a(getResources(), 35.0f));
        this.eDl = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleOverlay, false);
        this.eDm = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleHover, true);
        this.eDo = obtainStyledAttributes.getInt(R.styleable.MaterialRippleLayout_mrl_rippleDuration, 350);
        this.cmQ = (int) (obtainStyledAttributes.getFloat(R.styleable.MaterialRippleLayout_mrl_rippleAlpha, 0.2f) * 255.0f);
        this.eDp = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleDelayClick, true);
        this.eDq = obtainStyledAttributes.getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, 75);
        this.cmR = new ColorDrawable(obtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0));
        this.eDr = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_ripplePersistent, false);
        this.eDs = obtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleInAdapter, false);
        this.cmS = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleRoundedCorners, 0);
        obtainStyledAttributes.recycle();
        this.paint.setColor(this.rippleColor);
        this.paint.setAlpha(this.cmQ);
        aaH();
    }

    /* renamed from: a */
    static float m26673a(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    /* access modifiers changed from: private */
    public void aNY() {
        if (this.eDC != null) {
            removeCallbacks(this.eDC);
            this.eDy = false;
        }
    }

    /* access modifiers changed from: private */
    public void aNZ() {
        if (!this.eDx) {
            if (this.eDv != null) {
                this.eDv.cancel();
            }
            float sqrt = (float) (Math.sqrt(Math.pow((double) getWidth(), 2.0d) + Math.pow((double) getHeight(), 2.0d)) * 1.2000000476837158d);
            this.eDv = ObjectAnimator.ofFloat(this, this.eDF, new float[]{(float) this.eDn, sqrt}).setDuration(2500);
            this.eDv.setInterpolator(new LinearInterpolator());
            this.eDv.start();
        }
    }

    private boolean aOa() {
        ViewParent parent = getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public AdapterView aOb() {
        if (this.eDt != null) {
            return this.eDt;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        this.eDt = (AdapterView) parent;
        return this.eDt;
    }

    private void aOc() {
        if (this.eDs) {
            this.eDz = aOb().getPositionForView(this);
        }
    }

    private boolean aOd() {
        if (!this.eDs) {
            return false;
        }
        int positionForView = aOb().getPositionForView(this);
        boolean z = positionForView != this.eDz;
        this.eDz = positionForView;
        if (z) {
            aNY();
            m26679bI();
            this.bsb.setPressed(false);
            setRadius(0.0f);
        }
        return z;
    }

    private void aaH() {
        if (VERSION.SDK_INT > 17) {
            return;
        }
        if (this.cmS != 0.0f) {
            this.layerType = getLayerType();
            setLayerType(1, null);
            return;
        }
        setLayerType(this.layerType, null);
    }

    /* renamed from: bI */
    private void m26679bI() {
        if (this.eDu != null) {
            this.eDu.cancel();
            this.eDu.removeAllListeners();
        }
        if (this.eDv != null) {
            this.eDv.cancel();
        }
    }

    /* renamed from: dp */
    public static C9173c m26682dp(View view) {
        return new C9173c(view);
    }

    private float getEndRadius() {
        int width = getWidth();
        int height = getHeight();
        return ((float) Math.sqrt(Math.pow((double) ((float) (width / 2 > this.cmT.x ? width - this.cmT.x : this.cmT.x)), 2.0d) + Math.pow((double) ((float) (height / 2 > this.cmT.y ? height - this.cmT.y : this.cmT.y)), 2.0d))) * 1.2f;
    }

    /* access modifiers changed from: private */
    public float getRadius() {
        return this.f3683oS;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4, types: [int] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int, ?[boolean, int, float, short, byte, char]]
      uses: [boolean, ?[int, byte, short, char], int]
      mth insns count: 35
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m26689j(android.view.View r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof android.view.ViewGroup
            r1 = 0
            if (r0 == 0) goto L_0x002e
            r0 = r6
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x0008:
            int r2 = r0.getChildCount()
            if (r1 >= r2) goto L_0x004c
            android.view.View r2 = r0.getChildAt(r1)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r2.getHitRect(r3)
            boolean r4 = r3.contains(r7, r8)
            if (r4 == 0) goto L_0x002b
            int r6 = r3.left
            int r7 = r7 - r6
            int r6 = r3.top
            int r8 = r8 - r6
            boolean r6 = r5.m26689j(r2, r7, r8)
            return r6
        L_0x002b:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x002e:
            android.view.View r7 = r5.bsb
            if (r6 == r7) goto L_0x004c
            boolean r7 = r6.isEnabled()
            if (r7 == 0) goto L_0x004b
            boolean r7 = r6.isClickable()
            if (r7 != 0) goto L_0x004a
            boolean r7 = r6.isLongClickable()
            if (r7 != 0) goto L_0x004a
            boolean r6 = r6.isFocusableInTouchMode()
            if (r6 == 0) goto L_0x004b
        L_0x004a:
            r1 = 1
        L_0x004b:
            return r1
        L_0x004c:
            boolean r6 = r6.isFocusableInTouchMode()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.xyui.ripple.MaterialRippleLayout.m26689j(android.view.View, int, int):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m26691m(final Runnable runnable) {
        if (!this.eDx) {
            float endRadius = getEndRadius();
            m26679bI();
            this.eDu = new AnimatorSet();
            this.eDu.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (!MaterialRippleLayout.this.eDr) {
                        MaterialRippleLayout.this.setRadius(0.0f);
                        MaterialRippleLayout.this.setRippleAlpha(Integer.valueOf(MaterialRippleLayout.this.cmQ));
                    }
                    if (runnable != null && MaterialRippleLayout.this.eDp) {
                        runnable.run();
                    }
                    MaterialRippleLayout.this.bsb.setPressed(false);
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.eDF, new float[]{this.f3683oS, endRadius});
            ofFloat.setDuration((long) this.eDo);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.eDG, new int[]{this.cmQ, 0});
            ofInt.setDuration((long) this.eDq);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setStartDelay((long) ((this.eDo - this.eDq) - 50));
            if (this.eDr) {
                this.eDu.play(ofFloat);
            } else if (getRadius() > endRadius) {
                ofInt.setStartDelay(0);
                this.eDu.play(ofInt);
            } else {
                this.eDu.playTogether(new Animator[]{ofFloat, ofInt});
            }
            this.eDu.start();
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            this.bsb = view;
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout can host only one child");
    }

    public void draw(Canvas canvas) {
        boolean aOd = aOd();
        if (this.eDl) {
            if (!aOd) {
                this.cmR.draw(canvas);
            }
            super.draw(canvas);
            if (!aOd) {
                if (this.cmS != 0.0f) {
                    Path path = new Path();
                    path.addRoundRect(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.cmS, this.cmS, Direction.CW);
                    canvas.clipPath(path);
                }
                canvas.drawCircle((float) this.cmT.x, (float) this.cmT.y, this.f3683oS, this.paint);
                return;
            }
            return;
        }
        if (!aOd) {
            this.cmR.draw(canvas);
            canvas.drawCircle((float) this.cmT.x, (float) this.cmT.y, this.f3683oS, this.paint);
        }
        super.draw(canvas);
    }

    public <T extends View> T getChildView() {
        return this.bsb;
    }

    public int getRippleAlpha() {
        return this.paint.getAlpha();
    }

    public boolean isInEditMode() {
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !m26689j(this.bsb, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3682mQ.set(0, 0, i, i2);
        this.cmR.setBounds(this.f3682mQ);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || !this.bsb.isEnabled()) {
            return onTouchEvent;
        }
        boolean contains = this.f3682mQ.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (contains) {
            this.eDw.set(this.cmT.x, this.cmT.y);
            this.cmT.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.eDA.onTouchEvent(motionEvent) || this.eDD) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                aOc();
                this.eDx = false;
                this.eDC = new C9172b(motionEvent);
                if (!aOa()) {
                    this.eDC.run();
                    break;
                } else {
                    aNY();
                    this.eDy = true;
                    postDelayed(this.eDC, (long) ViewConfiguration.getTapTimeout());
                    break;
                }
            case 1:
                this.eDB = new C9171a();
                if (this.eDy) {
                    this.bsb.setPressed(true);
                    postDelayed(new Runnable() {
                        public void run() {
                            MaterialRippleLayout.this.bsb.setPressed(false);
                        }
                    }, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (contains) {
                    m26691m(this.eDB);
                } else if (!this.eDm) {
                    setRadius(0.0f);
                }
                if (!this.eDp && contains) {
                    this.eDB.run();
                }
                aNY();
                break;
            case 2:
                if (this.eDm) {
                    if (contains && !this.eDx) {
                        invalidate();
                    } else if (!contains) {
                        m26691m(null);
                    }
                }
                if (!contains) {
                    aNY();
                    if (this.eDv != null) {
                        this.eDv.cancel();
                    }
                    this.bsb.onTouchEvent(motionEvent);
                    this.eDx = true;
                    break;
                }
                break;
            case 3:
                if (this.eDs) {
                    this.cmT.set(this.eDw.x, this.eDw.y);
                    this.eDw = new Point();
                }
                this.bsb.onTouchEvent(motionEvent);
                if (!this.eDm) {
                    this.bsb.setPressed(false);
                } else if (!this.eDy) {
                    m26691m(null);
                }
                aNY();
                break;
        }
        return true;
    }

    public void setDefaultRippleAlpha(float f) {
        this.cmQ = (int) (f * 255.0f);
        this.paint.setAlpha(this.cmQ);
        invalidate();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (this.bsb != null) {
            this.bsb.setOnClickListener(onClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.bsb != null) {
            this.bsb.setOnLongClickListener(onLongClickListener);
            return;
        }
        throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
    }

    public void setRadius(float f) {
        this.f3683oS = f;
        invalidate();
    }

    public void setRippleAlpha(Integer num) {
        this.paint.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleBackground(int i) {
        this.cmR = new ColorDrawable(i);
        this.cmR.setBounds(this.f3682mQ);
        invalidate();
    }

    public void setRippleColor(int i) {
        this.rippleColor = i;
        this.paint.setColor(i);
        this.paint.setAlpha(this.cmQ);
        invalidate();
    }

    public void setRippleDelayClick(boolean z) {
        this.eDp = z;
    }

    public void setRippleDiameter(int i) {
        this.eDn = i;
    }

    public void setRippleDuration(int i) {
        this.eDo = i;
    }

    public void setRippleFadeDuration(int i) {
        this.eDq = i;
    }

    public void setRippleHover(boolean z) {
        this.eDm = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.eDs = z;
    }

    public void setRippleOverlay(boolean z) {
        this.eDl = z;
    }

    public void setRipplePersistent(boolean z) {
        this.eDr = z;
    }

    public void setRippleRoundedCorners(int i) {
        this.cmS = (float) i;
        aaH();
    }
}
