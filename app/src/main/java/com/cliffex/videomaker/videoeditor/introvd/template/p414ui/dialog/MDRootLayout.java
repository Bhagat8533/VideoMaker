package com.introvd.template.p414ui.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.MDRootLayout */
public class MDRootLayout extends ViewGroup {

    /* renamed from: PK */
    private boolean f3618PK = false;

    /* renamed from: WE */
    private int f3619WE;
    private boolean aor;
    private View exI;
    /* access modifiers changed from: private */
    public boolean exJ = false;
    /* access modifiers changed from: private */
    public boolean exK = false;
    /* access modifiers changed from: private */
    public final MDButton[] exL = new MDButton[3];
    private C8979n exM = C8979n.ADAPTIVE;
    private boolean exN = true;
    private boolean exO;
    private int exP;
    private int exQ;
    private int exR;
    private C8972k exS = C8972k.START;
    private int exT;
    private Paint exU;
    private OnScrollChangedListener exV;
    private OnScrollChangedListener exW;

    /* renamed from: gr */
    private View f3620gr;
    private int maxHeight;

    public MDRootLayout(Context context) {
        super(context);
        m26282a(context, (AttributeSet) null, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26282a(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26282a(context, attributeSet, i);
    }

    @TargetApi(21)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m26282a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m26282a(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.MDRootLayout, i, 0);
        this.exO = obtainStyledAttributes.getBoolean(C10122R.styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        obtainStyledAttributes.recycle();
        this.exP = resources.getDimensionPixelSize(C10122R.dimen.md_notitle_vertical_padding);
        this.exQ = resources.getDimensionPixelSize(C10122R.dimen.md_button_frame_vertical_padding);
        this.exT = resources.getDimensionPixelSize(C10122R.dimen.md_button_padding_frame_side);
        this.exR = resources.getDimensionPixelSize(C10122R.dimen.md_button_height);
        this.exU = new Paint();
        this.f3619WE = resources.getDimensionPixelSize(C10122R.dimen.md_divider_height);
        this.exU.setColor(C8966i.m26334r(context, C10122R.attr.md_divider_color));
        setWillNotDraw(false);
    }

    /* renamed from: a */
    private void m26283a(final View view, final boolean z, final boolean z2) {
        if (view != null) {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                if (m26292a(scrollView)) {
                    m26284a((ViewGroup) scrollView, z, z2);
                } else {
                    if (z) {
                        this.exJ = false;
                    }
                    if (z2) {
                        this.exK = false;
                    }
                }
            } else if (view instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) view;
                if (m26291a(adapterView)) {
                    m26284a((ViewGroup) adapterView, z, z2);
                } else {
                    if (z) {
                        this.exJ = false;
                    }
                    if (z2) {
                        this.exK = false;
                    }
                }
            } else if (view instanceof WebView) {
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public boolean onPreDraw() {
                        if (view.getMeasuredHeight() != 0) {
                            if (!MDRootLayout.m26290a((WebView) view)) {
                                if (z) {
                                    MDRootLayout.this.exJ = false;
                                }
                                if (z2) {
                                    MDRootLayout.this.exK = false;
                                }
                            } else {
                                MDRootLayout.this.m26284a((ViewGroup) view, z, z2);
                            }
                            view.getViewTreeObserver().removeOnPreDrawListener(this);
                        }
                        return true;
                    }
                });
            } else if (view instanceof RecyclerView) {
                boolean j = m26298j((RecyclerView) view);
                if (z) {
                    this.exJ = j;
                }
                if (z2) {
                    this.exK = j;
                }
                if (j) {
                    m26284a((ViewGroup) view, z, z2);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                View q = m26300q(viewGroup);
                m26283a(q, z, z2);
                View p = m26299p(viewGroup);
                if (p != q) {
                    m26283a(p, false, true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26284a(final ViewGroup viewGroup, final boolean z, final boolean z2) {
        if ((!z2 && this.exV == null) || (z2 && this.exW == null)) {
            if (viewGroup instanceof RecyclerView) {
                C89402 r0 = new C1022l() {
                    /* renamed from: a */
                    public void mo8095a(RecyclerView recyclerView, int i, int i2) {
                        super.mo8095a(recyclerView, i, i2);
                        MDButton[] b = MDRootLayout.this.exL;
                        int length = b.length;
                        boolean z = false;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            MDButton mDButton = b[i3];
                            if (mDButton != null && mDButton.getVisibility() != 8) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        MDRootLayout.this.m26285a(viewGroup, z, z2, z);
                        MDRootLayout.this.invalidate();
                    }
                };
                RecyclerView recyclerView = (RecyclerView) viewGroup;
                recyclerView.mo7737a((C1022l) r0);
                r0.mo8095a(recyclerView, 0, 0);
                return;
            }
            C89413 r02 = new OnScrollChangedListener() {
                public void onScrollChanged() {
                    MDButton[] b = MDRootLayout.this.exL;
                    int length = b.length;
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        MDButton mDButton = b[i];
                        if (mDButton != null && mDButton.getVisibility() != 8) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (viewGroup instanceof WebView) {
                        MDRootLayout.this.m26286a((WebView) viewGroup, z, z2, z);
                    } else {
                        MDRootLayout.this.m26285a(viewGroup, z, z2, z);
                    }
                    MDRootLayout.this.invalidate();
                }
            };
            if (!z2) {
                this.exV = r02;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.exV);
            } else {
                this.exW = r02;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.exW);
            }
            r02.onScrollChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26285a(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z && viewGroup.getChildCount() > 0) {
            this.exJ = (this.exI == null || this.exI.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (z2 && viewGroup.getChildCount() > 0) {
            if (!z3 || (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() >= viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) {
                z4 = false;
            }
            this.exK = z4;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26286a(WebView webView, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z) {
            this.exJ = (this.exI == null || this.exI.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            if (!z3 || ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) >= ((float) webView.getContentHeight()) * webView.getScale()) {
                z4 = false;
            }
            this.exK = z4;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m26290a(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    /* renamed from: a */
    private static boolean m26291a(AdapterView adapterView) {
        boolean z = false;
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        boolean z2 = adapterView.getFirstVisiblePosition() == 0;
        boolean z3 = adapterView.getLastVisiblePosition() == adapterView.getCount() - 1;
        if (!z2 || !z3 || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop()) {
            return true;
        }
        if (adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m26292a(ScrollView scrollView) {
        boolean z = false;
        if (scrollView.getChildCount() == 0) {
            return false;
        }
        if ((scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: bu */
    private static boolean m26297bu(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        return (!z || !(view instanceof MDButton)) ? z : ((MDButton) view).getText().toString().trim().length() > 0;
    }

    /* renamed from: j */
    public static boolean m26298j(RecyclerView recyclerView) {
        return (recyclerView == null || recyclerView.getLayoutManager() == null || !recyclerView.getLayoutManager().canScrollVertically()) ? false : true;
    }

    /* renamed from: p */
    private static View m26299p(ViewGroup viewGroup) {
        View view = null;
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                view = childAt;
                break;
            }
            childCount--;
        }
        return view;
    }

    /* renamed from: q */
    private static View m26300q(ViewGroup viewGroup) {
        View view = null;
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                view = childAt;
                break;
            }
            childCount--;
        }
        return view;
    }

    /* renamed from: qx */
    private void m26301qx() {
        if (VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            switch (this.exS) {
                case START:
                    this.exS = C8972k.END;
                    break;
                case END:
                    this.exS = C8972k.START;
                    break;
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3620gr != null) {
            if (this.exJ) {
                int top = this.f3620gr.getTop();
                canvas.drawRect(0.0f, (float) (top - this.f3619WE), (float) getMeasuredWidth(), (float) top, this.exU);
            }
            if (this.exK) {
                int bottom = this.f3620gr.getBottom();
                canvas.drawRect(0.0f, (float) bottom, (float) getMeasuredWidth(), (float) (bottom + this.f3619WE), this.exU);
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == C10122R.C10124id.titleFrame) {
                this.exI = childAt;
            } else if (childAt.getId() == C10122R.C10124id.buttonDefaultNeutral) {
                this.exL[0] = (MDButton) childAt;
            } else if (childAt.getId() == C10122R.C10124id.buttonDefaultNegative) {
                this.exL[1] = (MDButton) childAt;
            } else if (childAt.getId() == C10122R.C10124id.buttonDefaultPositive) {
                this.exL[2] = (MDButton) childAt;
            } else {
                this.f3620gr = childAt;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        MDButton[] mDButtonArr;
        if (m26297bu(this.exI)) {
            int measuredHeight = this.exI.getMeasuredHeight() + i2;
            this.exI.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.aor && this.exN) {
            i2 += this.exP;
        }
        if (m26297bu(this.f3620gr)) {
            this.f3620gr.layout(i, i2, i3, this.f3620gr.getMeasuredHeight() + i2);
        }
        if (this.f3618PK) {
            int i13 = i4 - this.exQ;
            for (MDButton mDButton : this.exL) {
                if (m26297bu(mDButton)) {
                    mDButton.layout(i, i13 - mDButton.getMeasuredHeight(), i3, i13);
                    i13 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.exN) {
                i4 -= this.exQ;
            }
            int i14 = i4 - this.exR;
            int i15 = this.exT;
            if (m26297bu(this.exL[2])) {
                if (this.exS == C8972k.END) {
                    i12 = i + i15;
                    i11 = this.exL[2].getMeasuredWidth() + i12;
                    i5 = -1;
                } else {
                    i11 = i3 - i15;
                    i12 = i11 - this.exL[2].getMeasuredWidth();
                    i5 = i12;
                }
                this.exL[2].layout(i12, i14, i11, i4);
                i15 += this.exL[2].getMeasuredWidth();
            } else {
                i5 = -1;
            }
            if (m26297bu(this.exL[1])) {
                if (this.exS == C8972k.END) {
                    i10 = i15 + i;
                    i9 = this.exL[1].getMeasuredWidth() + i10;
                } else if (this.exS == C8972k.START) {
                    i9 = i3 - i15;
                    i10 = i9 - this.exL[1].getMeasuredWidth();
                } else {
                    i10 = this.exT + i;
                    i9 = this.exL[1].getMeasuredWidth() + i10;
                    i6 = i9;
                    this.exL[1].layout(i10, i14, i9, i4);
                }
                i6 = -1;
                this.exL[1].layout(i10, i14, i9, i4);
            } else {
                i6 = -1;
            }
            if (m26297bu(this.exL[0])) {
                if (this.exS == C8972k.END) {
                    i7 = i3 - this.exT;
                    i8 = i7 - this.exL[0].getMeasuredWidth();
                } else if (this.exS == C8972k.START) {
                    i8 = i + this.exT;
                    i7 = this.exL[0].getMeasuredWidth() + i8;
                } else {
                    if (i6 == -1 && i5 != -1) {
                        i6 = i5 - this.exL[0].getMeasuredWidth();
                    } else if (i5 == -1 && i6 != -1) {
                        i5 = i6 + this.exL[0].getMeasuredWidth();
                    } else if (i5 == -1) {
                        i6 = ((i3 - i) / 2) - (this.exL[0].getMeasuredWidth() / 2);
                        i5 = i6 + this.exL[0].getMeasuredWidth();
                    }
                    i8 = i6;
                    i7 = i5;
                }
                this.exL[0].layout(i8, i14, i7, i4);
            }
        }
        m26283a(this.f3620gr, true, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r12)
            int r1 = android.view.View.MeasureSpec.getSize(r13)
            r2 = 1
            r11.exN = r2
            com.introvd.template.ui.dialog.n r3 = r11.exM
            com.introvd.template.ui.dialog.n r4 = com.introvd.template.p414ui.dialog.C8979n.ALWAYS
            r5 = 0
            if (r3 != r4) goto L_0x0015
            r3 = 1
        L_0x0013:
            r8 = 0
            goto L_0x0055
        L_0x0015:
            com.introvd.template.ui.dialog.n r3 = r11.exM
            com.introvd.template.ui.dialog.n r4 = com.introvd.template.p414ui.dialog.C8979n.NEVER
            if (r3 != r4) goto L_0x001d
            r3 = 0
            goto L_0x0013
        L_0x001d:
            com.introvd.template.ui.dialog.MDButton[] r3 = r11.exL
            int r4 = r3.length
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0023:
            if (r6 >= r4) goto L_0x003e
            r9 = r3[r6]
            if (r9 == 0) goto L_0x003b
            boolean r10 = m26297bu(r9)
            if (r10 == 0) goto L_0x003b
            r9.mo35578f(r5, r5)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredWidth()
            int r7 = r7 + r8
            r8 = 1
        L_0x003b:
            int r6 = r6 + 1
            goto L_0x0023
        L_0x003e:
            android.content.Context r3 = r11.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = xiaoying.quvideo.com.vivabase.C10122R.dimen.md_neutral_button_margin
            int r3 = r3.getDimensionPixelSize(r4)
            int r3 = r3 * 2
            int r3 = r0 - r3
            if (r7 <= r3) goto L_0x0054
            r3 = 1
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            r11.f3618PK = r3
            if (r3 == 0) goto L_0x0079
            com.introvd.template.ui.dialog.MDButton[] r3 = r11.exL
            int r4 = r3.length
            r6 = 0
            r7 = 0
        L_0x005e:
            if (r6 >= r4) goto L_0x007a
            r9 = r3[r6]
            if (r9 == 0) goto L_0x0076
            boolean r10 = m26297bu(r9)
            if (r10 == 0) goto L_0x0076
            r9.mo35578f(r2, r5)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredHeight()
            int r7 = r7 + r8
            r8 = 1
        L_0x0076:
            int r6 = r6 + 1
            goto L_0x005e
        L_0x0079:
            r7 = 0
        L_0x007a:
            if (r8 == 0) goto L_0x0097
            boolean r12 = r11.f3618PK
            if (r12 == 0) goto L_0x008d
            int r12 = r1 - r7
            int r13 = r11.exQ
            int r13 = r13 * 2
            int r13 = r13 + r5
            int r3 = r11.exQ
            int r3 = r3 * 2
            int r3 = r3 + r5
            goto L_0x009f
        L_0x008d:
            int r12 = r11.exR
            int r12 = r1 - r12
            int r13 = r11.exQ
            int r13 = r13 * 2
            int r13 = r13 + r5
            goto L_0x009e
        L_0x0097:
            int r12 = r11.exQ
            int r12 = r12 * 2
            int r13 = r12 + 0
            r12 = r1
        L_0x009e:
            r3 = 0
        L_0x009f:
            android.view.View r4 = r11.exI
            boolean r4 = m26297bu(r4)
            r6 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L_0x00ba
            android.view.View r4 = r11.exI
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            r4.measure(r7, r5)
            android.view.View r4 = r11.exI
            int r4 = r4.getMeasuredHeight()
            int r12 = r12 - r4
            goto L_0x00c1
        L_0x00ba:
            boolean r4 = r11.aor
            if (r4 != 0) goto L_0x00c1
            int r4 = r11.exP
            int r13 = r13 + r4
        L_0x00c1:
            android.view.View r4 = r11.f3620gr
            boolean r4 = m26297bu(r4)
            if (r4 == 0) goto L_0x010e
            android.view.View r4 = r11.f3620gr
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            int r7 = r12 - r3
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            r4.measure(r6, r7)
            android.view.View r4 = r11.f3620gr
            int r4 = r4.getMeasuredHeight()
            int r6 = r12 - r13
            if (r4 > r6) goto L_0x010b
            boolean r4 = r11.exO
            if (r4 == 0) goto L_0x00ff
            android.view.View r4 = r11.exI
            boolean r4 = m26297bu(r4)
            if (r4 != 0) goto L_0x00ff
            if (r8 == 0) goto L_0x00f3
            goto L_0x00ff
        L_0x00f3:
            r11.exN = r5
            android.view.View r13 = r11.f3620gr
            int r13 = r13.getMeasuredHeight()
            int r13 = r13 + r3
            int r5 = r12 - r13
            goto L_0x010f
        L_0x00ff:
            r11.exN = r2
            android.view.View r2 = r11.f3620gr
            int r2 = r2.getMeasuredHeight()
            int r2 = r2 + r13
            int r5 = r12 - r2
            goto L_0x010f
        L_0x010b:
            r11.exN = r5
            goto L_0x010f
        L_0x010e:
            r5 = r12
        L_0x010f:
            int r1 = r1 - r5
            r11.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p414ui.dialog.MDRootLayout.onMeasure(int, int):void");
    }

    public void setButtonGravity(C8972k kVar) {
        this.exS = kVar;
        m26301qx();
    }

    public void setButtonStackedGravity(C8972k kVar) {
        MDButton[] mDButtonArr;
        for (MDButton mDButton : this.exL) {
            if (mDButton != null) {
                mDButton.setStackedGravity(kVar);
            }
        }
    }

    public void setDividerColor(int i) {
        this.exU.setColor(i);
        invalidate();
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setStackingBehavior(C8979n nVar) {
        this.exM = nVar;
        invalidate();
    }
}
