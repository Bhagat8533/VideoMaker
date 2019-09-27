package com.introvd.template.editor.widget.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.RangeUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.p253a.C5900b;
import com.introvd.template.editor.effects.p253a.C5906c;
import com.introvd.template.editor.widget.timeline.VeGallery2.C7105a;
import com.introvd.template.editor.widget.timeline.VePIPGallery.C7112d;
import com.introvd.template.editor.widget.timeline.VePIPGallery.C7114f;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.editor.C8418a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.widget.timeline.a */
public class C7116a {
    public static final int cuf = C4583d.m11671P(45.0f);
    /* access modifiers changed from: private */
    public static int cug = C4583d.m11671P(0.0f);
    /* access modifiers changed from: private */
    public static int cuh = C4583d.m11671P(11.0f);
    private static final int dvd = R.color.color_ff5e13_p50;
    private static final int dve = R.color.color_ff5e13_p30;
    /* access modifiers changed from: private */
    public static int dvw = C4583d.m11671P(3.0f);
    /* access modifiers changed from: private */
    public int aaE = 0;
    private volatile int cmY = 0;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public Context context;
    private volatile boolean cuA = true;
    /* access modifiers changed from: private */
    public volatile Range cuB = new Range();
    /* access modifiers changed from: private */
    public Drawable cuD = null;
    /* access modifiers changed from: private */
    public Drawable cuE = null;
    /* access modifiers changed from: private */
    public Drawable cuI = null;
    /* access modifiers changed from: private */
    public Drawable cuL = null;
    /* access modifiers changed from: private */
    public int cuk = 0;
    /* access modifiers changed from: private */
    public ArrayList<Range> cuo;
    /* access modifiers changed from: private */
    public volatile int cuq = -1;
    /* access modifiers changed from: private */
    public volatile int cur = 0;
    /* access modifiers changed from: private */
    public volatile int cus = 0;
    private volatile int cut = 0;
    private volatile int cuu = 0;
    /* access modifiers changed from: private */
    public boolean cux = false;
    private boolean cuy = false;
    private volatile boolean cuz = false;
    /* access modifiers changed from: private */
    public Paint dnF = new Paint();
    /* access modifiers changed from: private */
    public Drawable dnw = null;
    private final C7114f dvA = new C7114f() {
        /* renamed from: cw */
        public void mo31526cw(View view) {
            LogUtils.m14223i("MultiEffectTimeLineMgr", "VePIPGallery onLayout run");
            C71211 r5 = new C1810c<Boolean>() {
                /* renamed from: e */
                public void onSuccess(Boolean bool) {
                    if (C7116a.this.dvf != null) {
                        C7116a.this.dvf.mo31458hv(false);
                        C7116a.this.dvf.mo31462hz(false);
                    }
                }

                public void onError(Throwable th) {
                }
            };
            C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10200k(100, TimeUnit.MILLISECONDS).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) r5);
            C7116a.this.compositeDisposable.mo9785e(r5);
        }
    };
    /* access modifiers changed from: private */
    public VeGallery2 dvf = null;
    private C7122a dvg = null;
    /* access modifiers changed from: private */
    public HashMap<Integer, ArrayList<C8418a>> dvh;
    /* access modifiers changed from: private */
    public int dvi = -1;
    private volatile int dvj = -1;
    /* access modifiers changed from: private */
    public C7124b dvk;
    /* access modifiers changed from: private */
    public C7131e dvl;
    /* access modifiers changed from: private */
    public Drawable dvm = null;
    /* access modifiers changed from: private */
    public Drawable dvn = null;
    /* access modifiers changed from: private */
    public Drawable dvo = null;
    /* access modifiers changed from: private */
    public Drawable dvp = null;
    /* access modifiers changed from: private */
    public Drawable dvq = null;
    /* access modifiers changed from: private */
    public Drawable dvr = null;
    /* access modifiers changed from: private */
    public Drawable dvs = null;
    /* access modifiers changed from: private */
    public int dvt;
    /* access modifiers changed from: private */
    public int dvu;
    /* access modifiers changed from: private */
    public int dvv = R.color.white;
    /* access modifiers changed from: private */
    public C7132f dvx;
    private C7105a dvy = new C7105a() {
        public void acC() {
            LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onUp run");
            if (C7116a.this.mDragState >= 0 && C7116a.this.cuo != null) {
                int size = C7116a.this.cuo.size();
                Range range = null;
                if (C7116a.this.cuq >= 0 && C7116a.this.cuq < size) {
                    range = (Range) C7116a.this.cuo.get(C7116a.this.cuq);
                }
                if (C7116a.this.dvk != null) {
                    C7116a.this.cux = false;
                    C7116a.this.dvk.acd();
                    if (range != null) {
                        C7116a.this.dvk.mo28344a(C7116a.this.cuq, range);
                    }
                }
                if (!(C7116a.this.dvk == null || range == null)) {
                    int i = range.getmPosition();
                    if (C7116a.this.mDragState == 1) {
                        i = range.getLimitValue();
                    }
                    C7116a.this.m20955E(i, false);
                }
            }
            C7116a.this.mDragState = -1;
            if (C7116a.this.dvf != null) {
                C7116a.this.dvf.setbInDraging(false);
                C7116a.this.dvf.invalidate();
            }
        }

        /* renamed from: cu */
        public void mo31521cu(View view) {
            LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onMoveStoped run");
            if (C7116a.this.dvk != null) {
                C7116a.this.dvk.acd();
            }
            C7116a.this.cux = false;
            C7125c.avE().mo31583eO(false);
            C7125c.avE().mo31585lR(C7116a.this.dvf == null ? -1 : C7116a.this.dvf.getFirstVisiblePosition() - 1);
        }

        /* renamed from: cv */
        public void mo31522cv(View view) {
            LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onMoveStart run");
            C7125c.avE().mo31583eO(true);
            C7116a.this.cux = true;
            C7116a.this.cur = 0;
            if (C7116a.this.dvk != null) {
                int acp = C7116a.this.acp();
                C7116a.this.dvk.acD();
                C7116a.this.dvk.mo28352kz(acp);
                C7116a.this.m20991kL(acp);
            }
        }

        /* renamed from: w */
        public void mo31523w(MotionEvent motionEvent) {
            LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onDown run");
            if (C7116a.this.cuq >= 0 && C7116a.this.cuo != null && C7116a.this.cuq < C7116a.this.cuo.size()) {
                Range range = (Range) C7116a.this.cuo.get(C7116a.this.cuq);
                if (range != null) {
                    int b = C7116a.this.m20956F((int) motionEvent.getX(), false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onDown range=");
                    sb.append(range);
                    sb.append(";time=");
                    sb.append(b);
                    LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
                    int i = b - range.getmPosition();
                    if (i <= -1500 || i >= 0) {
                        int limitValue = range.getLimitValue();
                        if (limitValue < 0 || limitValue == Integer.MAX_VALUE) {
                            limitValue = C7116a.this.mDuration;
                        }
                        int i2 = b - limitValue;
                        if (i2 < 1500 && i2 > 0) {
                            C7116a.this.mDragState = 1;
                            C7116a.this.cur = 2;
                            int kE = C7116a.m20990kE(range.getLimitValue());
                            C7116a.this.mDeltaX = ((int) motionEvent.getX()) - (C7116a.m20963a(C7116a.this.dvf) + kE);
                        }
                    } else {
                        C7116a.this.mDragState = 0;
                        C7116a.this.cur = 1;
                        int kE2 = C7116a.m20990kE(range.getmPosition());
                        C7116a.this.mDeltaX = ((int) motionEvent.getX()) - (C7116a.m20963a(C7116a.this.dvf) + kE2);
                    }
                    if (C7116a.this.mDragState >= 0 && C7116a.this.dvf != null) {
                        C7116a.this.dvf.setbInDraging(true);
                    }
                    if (C7116a.this.mState == 2) {
                        C7116a.this.mo31543b(range);
                    } else {
                        C7116a.this.mo31530a(range);
                    }
                    if (C7116a.this.dvk != null && C7116a.this.mDragState >= 0) {
                        C7116a.this.cux = true;
                        C7116a.this.dvk.mo28347dY(C7116a.this.acx());
                        C7116a.this.dvk.mo28352kz(range.getmPosition());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("test onDown isSeekStart:");
            sb2.append(C7116a.this.cux);
            LogUtils.m14223i("MultiEffectTimeLineMgr", sb2.toString());
        }

        /* renamed from: x */
        public boolean mo31421x(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("test onSingleTap isSeekStart:");
            sb.append(C7116a.this.cux);
            LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
            if (motionEvent == null) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VeGallery onSingleTap e:");
            sb2.append(motionEvent.getX());
            LogUtils.m14222e("MultiEffectTimeLineMgr", sb2.toString());
            int i = -1;
            int x = (int) motionEvent.getX();
            int b = C7116a.this.m20956F(x, false);
            if (C7116a.this.cuo != null && b < C7116a.this.mDuration) {
                i = C7116a.this.mo31557kJ(b);
            }
            if (!(C7116a.this.cuq == i || C7116a.this.dvk == null)) {
                C7116a.this.dvk.mo28350kM(C7116a.this.cuq);
            }
            if (i >= 0 && C7116a.this.cuq >= 0) {
                int a = C7116a.m20963a(C7116a.this.dvf);
                ArrayList arrayList = (ArrayList) C7116a.this.dvh.get(Integer.valueOf(C7116a.this.cuq));
                if (arrayList != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (((C8418a) arrayList.get(i2)).mo34139dy(x - a, C7116a.this.dvt)) {
                            C7116a.this.mo31566qs(0);
                            int i3 = ((C8418a) arrayList.get(i2)).edv;
                            if (C7116a.this.dvl != null) {
                                C7116a.this.dvl.mo28502mW(i3);
                            }
                        } else {
                            i2++;
                        }
                    }
                }
            }
            return true;
        }

        /* renamed from: y */
        public void mo31524y(MotionEvent motionEvent) {
            if (C7116a.this.dvf != null) {
                LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onDrag");
                int x = ((int) motionEvent.getX()) - C7116a.this.mDeltaX;
                if (C7116a.this.cuq >= 0 && C7116a.this.cuo != null && C7116a.this.cuq < C7116a.this.cuo.size()) {
                    Range range = (Range) C7116a.this.cuo.get(C7116a.this.cuq);
                    if (range != null) {
                        boolean z = false;
                        if (C7116a.this.mState == 2) {
                            if (C7116a.this.mDragState == 1) {
                                C7116a.this.m20967a(range, C7116a.this.m20956F(x, true), false);
                                C7116a.this.dvf.invalidate();
                                if (C7116a.this.dvk != null) {
                                    C7116a.this.dvk.mo28349iD(range.getLimitValue());
                                }
                            } else if (C7116a.this.acx()) {
                                int b = C7116a.this.m20956F(x, true);
                                C7116a.this.m20967a(range, b, true);
                                C7116a.this.dvf.invalidate();
                                if (C7116a.this.dvk != null) {
                                    C7116a.this.dvk.mo28349iD(b);
                                }
                            }
                        } else if (C7116a.this.mDragState == 1) {
                            int b2 = C7116a.this.m20956F(x, true);
                            C7116a.this.m20967a(range, b2, false);
                            C7116a.this.dvf.invalidate();
                            if (b2 >= C7116a.this.cus) {
                                z = true;
                            }
                            if (C7116a.this.dvk != null) {
                                C7116a.this.dvk.mo28348dZ(z);
                            }
                            if (C7116a.this.dvk != null) {
                                C7116a.this.dvk.mo28349iD(range.getLimitValue());
                            }
                        } else if (C7116a.this.acx()) {
                            int kF = C7116a.this.mo31555kF(C7116a.this.m20956F(x, true));
                            range.setmPosition(kF);
                            C7116a.this.dvf.invalidate();
                            if (C7116a.this.dvk != null) {
                                C7116a.this.dvk.mo28349iD(kF);
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: y */
        public void mo31525y(View view, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("VeGallery onMoving run, move distance:");
            sb.append(i);
            sb.append(",VeGallery is Seeking:");
            sb.append(C7116a.this.cux);
            LogUtils.m14222e("MultiEffectTimeLineMgr", sb.toString());
            int acp = C7116a.this.acp();
            if (C7116a.this.dvk != null && C7116a.this.cux) {
                C7116a.this.dvk.mo28349iD(acp);
                C7116a.this.m20991kL(acp);
            }
            int c = C7116a.this.m20998qm(C7116a.this.aco());
            if (!(c == -1 || c == C7116a.this.dvi)) {
                LogUtils.m14222e("MultiEffectTimeLineMgr", "VeGallery onMoving run, into keyFrame focus state");
                C7116a.this.dvi = c;
                C7116a.this.dvf.invalidate();
            }
            if (C7116a.this.dvl != null) {
                C7116a.this.dvl.mo28500fA(c != -1);
            }
        }
    };
    private C7112d dvz = new C7112d() {
        /* renamed from: a */
        private void m21035a(Canvas canvas, float f, float f2) {
            if (C7116a.this.context != null) {
                C7116a.this.dnF.setAntiAlias(true);
                C7116a.this.dnF.setColor(C7116a.this.context.getResources().getColor(C7116a.this.dvv));
                canvas.save();
                canvas.translate(f, f2);
                canvas.drawCircle(0.0f, 0.0f, (float) C7116a.dvw, C7116a.this.dnF);
                canvas.restore();
            }
        }

        /* renamed from: a */
        private void m21036a(Canvas canvas, Range range, int i) {
            if (range != null && range.getmTimeLength() > 0) {
                int i2 = range.getmPosition();
                int limitValue = range.getLimitValue();
                if (limitValue > C7116a.this.mDuration) {
                    limitValue = C7116a.this.mDuration;
                }
                int kE = C7116a.m20990kE(i2);
                int kE2 = C7116a.m20990kE(limitValue);
                int i3 = C7116a.cuf;
                int i4 = (i - i3) / 2;
                View childAt = C7116a.this.dvf.getChildAt(0);
                int i5 = childAt != null ? childAt.getLeft() > 0 ? childAt.getLeft() : childAt.getLeft() - (childAt.getWidth() * C7116a.this.dvf.getFirstVisiblePosition()) : 0;
                canvas.save();
                int i6 = i5 + kE;
                canvas.translate((float) i6, (float) i4);
                int i7 = kE2 - kE;
                int count = C7116a.this.dvf.getCount();
                if (C7116a.this.cuk > 0) {
                    count--;
                }
                int childWidth = (count * C7116a.this.dvf.getChildWidth()) + ((C7116a.cuf * C7116a.this.cuk) / 3000);
                if (i7 > childWidth) {
                    i7 = childWidth;
                }
                C7116a.this.dnw.setBounds(0, 0, i7, i3);
                C7116a.this.dnw.draw(canvas);
                canvas.restore();
                Drawable C = C7116a.this.cur == 1 ? C7116a.this.cuL : C7116a.this.dvm;
                if (C7116a.this.mState == 2) {
                    C = C7116a.this.cur == 1 ? C7116a.this.dvp : C7116a.this.dvo;
                }
                int intrinsicWidth = C.getIntrinsicWidth();
                int avC = C7116a.cuf + C7116a.cuh;
                int i8 = (i - avC) / 2;
                int avD = (C7116a.cug + i6) - intrinsicWidth;
                canvas.save();
                float f = (float) i8;
                canvas.translate((float) avD, f);
                C.setBounds(0, 0, intrinsicWidth, avC);
                C.draw(canvas);
                canvas.restore();
                if (C7116a.this.cur == 1) {
                    m21035a(canvas, (float) (avD + (intrinsicWidth / 2)), (float) (i8 - 7));
                }
                if (C7116a.this.mState == 2 && C7116a.this.acx()) {
                    m21037d(canvas, i6);
                }
                Drawable G = C7116a.this.cur == 2 ? C7116a.this.dvq : C7116a.this.dvn;
                int intrinsicWidth2 = G.getIntrinsicWidth();
                int i9 = i7 + i6;
                int avD2 = i9 - C7116a.cug;
                canvas.save();
                canvas.translate((float) avD2, f);
                G.setBounds(0, 0, intrinsicWidth2, avC);
                G.draw(canvas);
                canvas.restore();
                if (C7116a.this.cur == 2) {
                    m21035a(canvas, (float) (avD2 + (intrinsicWidth2 / 2)), (float) (i8 - 7));
                }
                mo31576a(canvas, C7116a.this.dvh, C7116a.this.cuo, C7116a.this.cuq);
                if (C7116a.this.mDragState >= 0) {
                    if (C7116a.this.mDragState == 0) {
                        i9 = i6;
                    }
                    m21037d(canvas, i9);
                }
            }
        }

        /* renamed from: d */
        private void m21037d(Canvas canvas, int i) {
            int intrinsicHeight = C7116a.this.cuD.getIntrinsicHeight();
            int intrinsicWidth = C7116a.this.cuD.getIntrinsicWidth();
            int i2 = i - (intrinsicWidth / 2);
            int height = (C7116a.this.dvf.getHeight() - intrinsicHeight) / 2;
            canvas.save();
            canvas.translate((float) i2, (float) height);
            C7116a.this.cuD.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            C7116a.this.cuD.draw(canvas);
            canvas.restore();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31574a(Canvas canvas, Range range, int i, Drawable drawable) {
            if (range != null && range.getmTimeLength() > 0 && drawable != null) {
                int i2 = range.getmPosition();
                int limitValue = range.getLimitValue();
                if (limitValue > C7116a.this.mDuration) {
                    limitValue = C7116a.this.mDuration;
                }
                int kE = C7116a.m20990kE(i2);
                int kE2 = C7116a.m20990kE(limitValue);
                int i3 = C7116a.cuf;
                int i4 = (i - i3) / 2;
                int a = C7116a.m20963a(C7116a.this.dvf) + kE;
                canvas.save();
                canvas.translate((float) a, (float) i4);
                int i5 = kE2 - kE;
                int count = C7116a.this.dvf.getCount();
                if (C7116a.this.cuk > 0) {
                    count--;
                }
                int childWidth = (count * C7116a.this.dvf.getChildWidth()) + ((C7116a.cuf * C7116a.this.cuk) / 3000);
                if (i5 > childWidth) {
                    i5 = childWidth;
                }
                drawable.setBounds(0, 0, i5, i3);
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31575a(Canvas canvas, ArrayList<C8418a> arrayList) {
            int i;
            if (arrayList != null && arrayList.size() > 0) {
                int kE = C7116a.m20990kE(((C8418a) arrayList.get(0)).edv);
                View childAt = C7116a.this.dvf.getChildAt(0);
                if (childAt == null) {
                    i = 0;
                } else if (childAt.getLeft() > 0) {
                    i = childAt.getLeft();
                } else {
                    i = childAt.getLeft() - (childAt.getWidth() * C7116a.this.dvf.getFirstVisiblePosition());
                }
                int height = (C7116a.this.dvf.getHeight() - C7116a.this.dvu) / 2;
                int c = C7116a.this.m20998qm(C7116a.this.aco());
                canvas.save();
                int i2 = i + kE;
                float f = (float) height;
                canvas.translate((float) (i2 - (C7116a.this.dvt >> 1)), f);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (i3 != c) {
                        int kE2 = C7116a.m20990kE(((C8418a) arrayList.get(i3)).edv) - kE;
                        C7116a.this.dvr.setBounds(kE2, 0, C7116a.this.dvt + kE2, C7116a.this.dvu);
                        C7116a.this.dvr.draw(canvas);
                    }
                }
                canvas.restore();
                if (c > -1) {
                    canvas.save();
                    int kE3 = C7116a.m20990kE(((C8418a) arrayList.get(c)).edv) - kE;
                    canvas.translate((float) (i2 - (C7116a.this.dvt >> 1)), f);
                    C7116a.this.dvs.setBounds(kE3, 0, C7116a.this.dvt + kE3, C7116a.this.dvu);
                    C7116a.this.dvs.draw(canvas);
                    canvas.restore();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31576a(Canvas canvas, HashMap<Integer, ArrayList<C8418a>> hashMap, ArrayList<Range> arrayList, int i) {
            if (hashMap != null && hashMap.size() != 0 && C7116a.this.dvh != null) {
                ArrayList rangesWithoutIntersection = RangeUtils.getRangesWithoutIntersection(arrayList);
                if (rangesWithoutIntersection != null && rangesWithoutIntersection.size() > 0) {
                    mo31575a(canvas, (ArrayList) C7116a.this.dvh.get(Integer.valueOf(i)));
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31577a(ArrayList<Range> arrayList, Canvas canvas, int i, Drawable drawable) {
            if (arrayList != null) {
                ArrayList rangesWithoutIntersection = RangeUtils.getRangesWithoutIntersection(arrayList);
                if (rangesWithoutIntersection != null && rangesWithoutIntersection.size() > 0) {
                    int size = rangesWithoutIntersection.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Range range = (Range) rangesWithoutIntersection.get(i2);
                        if (range != null) {
                            mo31574a(canvas, range, i, drawable);
                        }
                    }
                }
            }
        }

        public void onDraw(Canvas canvas) {
            LogUtils.m14223i("MultiEffectTimeLineMgr", "OnGalleryDrawListener onDraw ");
            if (!C7116a.this.acw() && C7116a.this.dvf != null) {
                int width = C7116a.this.dvf.getWidth();
                int height = C7116a.this.dvf.getHeight();
                if (C7116a.this.dvx != null) {
                    C7116a.this.dvx.mo31591e(canvas, height);
                }
                if (C7116a.this.cuB == null || C7116a.this.cuB.getmPosition() < 0 || C7116a.this.cuB.getmTimeLength() <= 0) {
                    mo31577a(C7116a.this.cuo, canvas, height, C7116a.this.cuI);
                    boolean z = false;
                    if (C7116a.this.cuo != null && C7116a.this.cuq >= 0 && C7116a.this.cuq < C7116a.this.cuo.size()) {
                        Range range = (Range) C7116a.this.cuo.get(C7116a.this.cuq);
                        if (range != null) {
                            mo31574a(canvas, range, height, C7116a.this.cuE);
                            m21036a(canvas, range, height);
                            z = true;
                        }
                    }
                    if (!z) {
                        mo31577a(C7116a.this.cuo, canvas, height, C7116a.this.cuE);
                    }
                    if (C7116a.this.dvl != null) {
                        C7116a.this.dvl.mo28501fB(z);
                    }
                } else {
                    mo31577a(C7116a.this.cuo, canvas, height, C7116a.this.cuI);
                    mo31574a(canvas, C7116a.this.cuB, height, C7116a.this.cuE);
                }
                if (!(C7116a.this.mDragState == 0 || C7116a.this.mDragState == 1)) {
                    m21037d(canvas, width / 2);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public int mDeltaX = 0;
    /* access modifiers changed from: private */
    public volatile int mDragState = -1;
    /* access modifiers changed from: private */
    public int mDuration = 0;
    /* access modifiers changed from: private */
    public volatile int mState = 0;

    /* renamed from: com.introvd.template.editor.widget.timeline.a$a */
    public class C7122a extends BaseAdapter {
        private final Context mContext;

        /* renamed from: com.introvd.template.editor.widget.timeline.a$a$a */
        class C7123a {
            ImageView cuT;

            C7123a() {
            }
        }

        public C7122a(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            return C7116a.this.aaE;
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C7123a aVar;
            if (view == null) {
                aVar = new C7123a();
                view2 = View.inflate(this.mContext, R.layout.editor_timeline_item_layout, null);
                aVar.cuT = (ImageView) view2.findViewById(R.id.imgview_thumbnail);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (C7123a) view.getTag();
            }
            if (aVar.cuT != null) {
                if (i == C7116a.this.aaE - 1 && C7116a.this.cuk > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.cuT.getLayoutParams();
                    layoutParams.width = (C7116a.cuf * C7116a.this.cuk) / 3000;
                    layoutParams.height = C7116a.cuf;
                    aVar.cuT.setLayoutParams(layoutParams);
                }
                C7116a.this.m20971b(aVar.cuT, i);
            }
            return view2;
        }
    }

    public C7116a(VeGallery2 veGallery2, int i, ArrayList<Range> arrayList, HashMap<Integer, ArrayList<C8418a>> hashMap) {
        if (veGallery2 != null) {
            this.compositeDisposable = new C1494a();
            this.dvf = veGallery2;
            this.cuo = arrayList;
            this.dvh = m20977c(hashMap);
            this.mDuration = i;
            this.cuk = this.mDuration % 3000;
            this.aaE = acm();
            initUI();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m20955E(int i, boolean z) {
        if (this.dvf != null) {
            int kE = m20990kE(i);
            int aco = aco();
            int i2 = aco - kE;
            int width = this.dvf.getWidth();
            StringBuilder sb = new StringBuilder();
            sb.append("FocusState:");
            sb.append(this.cur);
            sb.append(",time=");
            sb.append(i);
            sb.append(";destPos=");
            sb.append(kE);
            sb.append(";curPos=");
            sb.append(aco);
            sb.append(";viewWidth");
            sb.append(width);
            sb.append(";scrollLen=");
            sb.append(i2);
            LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
            boolean z2 = i2 > 0;
            while (true) {
                if ((!z2 || i2 <= width) && (z2 || i2 >= (-width))) {
                    this.dvf.mo31478pT(i2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("-----TimelineGallery scroll:");
                    sb2.append(i2);
                    LogUtils.m14222e("MultiEffectTimeLineMgr", sb2.toString());
                } else {
                    int i3 = !z2 ? -width : width;
                    this.dvf.mo31478pT(i3);
                    i2 -= i3;
                }
            }
            this.dvf.mo31478pT(i2);
            StringBuilder sb22 = new StringBuilder();
            sb22.append("-----TimelineGallery scroll:");
            sb22.append(i2);
            LogUtils.m14222e("MultiEffectTimeLineMgr", sb22.toString());
            if (this.cur == 0) {
                m20991kL(i);
            } else if (z && this.cuo != null) {
                int size = this.cuo.size();
                if (this.cuq >= 0 && this.cuq < size) {
                    Range range = (Range) this.cuo.get(this.cuq);
                    if (range == null) {
                        return;
                    }
                    if (this.cur != 1) {
                        m20967a(range, i, false);
                    } else if (this.mState == 2) {
                        m20967a(range, i, true);
                    } else {
                        range.setmPosition(i);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public int m20956F(int i, boolean z) {
        int i2 = 0;
        if (z) {
            if (this.dvf != null) {
                int firstVisiblePosition = this.dvf.getFirstVisiblePosition();
                int lastVisiblePosition = this.dvf.getLastVisiblePosition();
                int count = this.dvf.getAdapter().getCount();
                int i3 = firstVisiblePosition;
                int i4 = 0;
                while (true) {
                    if (i3 > lastVisiblePosition) {
                        i2 = i4;
                        break;
                    }
                    View childAt = this.dvf.getChildAt(i3 - firstVisiblePosition);
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
        } else if (this.dvf != null) {
            int childWidth = this.dvf.getChildWidth();
            int firstVisiblePosition2 = this.dvf.getFirstVisiblePosition();
            View childAt2 = this.dvf.getChildAt(0);
            if (childAt2 != null) {
                i2 = childAt2.getLeft() - (firstVisiblePosition2 * childWidth);
            }
            i2 = ((i - i2) * 3000) / childWidth;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(i2);
        LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
        return i2;
    }

    /* renamed from: a */
    static int m20963a(VeGallery2 veGallery2) {
        if (veGallery2 == null) {
            return 0;
        }
        View childAt = veGallery2.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        if (childAt.getLeft() > 0) {
            return childAt.getLeft();
        }
        return childAt.getLeft() - (childAt.getWidth() * veGallery2.getFirstVisiblePosition());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20967a(Range range, int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateRange range:");
        sb.append(range.toString());
        sb.append(";time=");
        sb.append(i);
        sb.append(";bLeftAdjust=");
        sb.append(z);
        sb.append(";");
        sb.append(this.cut);
        sb.append(";mDragMaxLimitValue=");
        sb.append(this.cus);
        LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
        int kF = mo31555kF(i);
        if (z) {
            int limitValue = range.getLimitValue();
            range.setmPosition(kF);
            range.setmTimeLength(limitValue - kF);
            return;
        }
        range.setmTimeLength(kF - range.getmPosition());
    }

    private int acm() {
        return (this.mDuration / 3000) + (this.cuk > 0 ? 1 : 0);
    }

    private void acn() {
        if (this.cuk > 0) {
            int i = ((3000 - this.cuk) * cuf) / 3000;
            if (i >= 0 && this.dvf != null) {
                this.dvf.setLimitMoveOffset(0, i);
            }
        } else if (this.dvf != null) {
            this.dvf.setLimitMoveOffset(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public int aco() {
        int acp = acp();
        StringBuilder sb = new StringBuilder();
        sb.append("curTime=");
        sb.append(acp);
        LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
        if (this.dvf != null) {
            int firstVisiblePosition = this.dvf.getFirstVisiblePosition();
            int centerOfGallery = this.dvf.getCenterOfGallery();
            View childAt = this.dvf.getChildAt(0);
            if (childAt != null) {
                int left = childAt.getLeft();
                int i = ((firstVisiblePosition * cuf) - left) + centerOfGallery;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("left=");
                sb2.append(left);
                sb2.append(";center=");
                sb2.append(centerOfGallery);
                LogUtils.m14223i("MultiEffectTimeLineMgr", sb2.toString());
                return i;
            }
        }
        return 0;
    }

    private boolean avv() {
        if (this.dvh == null) {
            return true;
        }
        for (Entry entry : this.dvh.entrySet()) {
            ArrayList arrayList = null;
            if (entry.getValue() != null) {
                arrayList = (ArrayList) entry.getValue();
            }
            if (arrayList != null && arrayList.size() != 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m20971b(ImageView imageView, int i) {
        if (imageView == null) {
            return -1;
        }
        Bitmap kH = C7125c.avE().mo31584kH(i);
        if (kH == null) {
            return -1;
        }
        if (this.dvf != null) {
            this.dvf.mo31457hu(true);
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(this.dvf.getContext().getResources().getColor(17170445)), new BitmapDrawable(imageView.getContext().getResources(), kH)});
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
            this.dvf.mo31457hu(false);
        }
        return 0;
    }

    /* renamed from: c */
    private HashMap<Integer, ArrayList<C8418a>> m20977c(HashMap<Integer, ArrayList<C8418a>> hashMap) {
        if (this.dvh == null) {
            this.dvh = new HashMap<>();
        }
        if (hashMap == null || hashMap.size() == 0 || this.cuo == null) {
            return this.dvh;
        }
        for (int i = 0; i < this.cuo.size(); i++) {
            ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(i));
            if (arrayList != null && arrayList.size() > 0) {
                Range range = (Range) this.cuo.get(i);
                if (range != null) {
                    int i2 = range.getmPosition();
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        C8418a aVar = (C8418a) arrayList.get(i3);
                        aVar.edv = aVar.edw + i2;
                        aVar.edu = m20990kE(aVar.edv);
                        arrayList.set(i3, aVar);
                    }
                    Collections.sort(arrayList, new C5906c());
                    this.dvh.put(Integer.valueOf(i), arrayList);
                }
            }
        }
        return this.dvh;
    }

    /* renamed from: h */
    private boolean m20986h(int i, Range range) {
        if (this.cuA) {
            if ((this.mState != 2 || !range.contains2(i)) && ((this.mState == 2 || !range.contains(i)) && !(i == range.getLimitValue() && i == this.mDuration))) {
                return false;
            }
        } else if (!range.contains(i) && !(i == range.getLimitValue() && i == this.mDuration)) {
            return false;
        }
        return true;
    }

    private void initUI() {
        if (this.dvf != null) {
            this.context = this.dvf.getContext();
            Resources resources = this.context.getResources();
            this.cuD = resources.getDrawable(R.drawable.editor_icon_timeline_needle);
            this.dnw = null;
            this.dvm = resources.getDrawable(R.drawable.editor_icon_timeline_move);
            this.cuL = resources.getDrawable(R.drawable.editor_icon_timeline_move);
            this.dvn = resources.getDrawable(R.drawable.editor_icon_timeline_right_normal);
            this.dvq = resources.getDrawable(R.drawable.editor_icon_timeline_right_normal);
            this.dvo = resources.getDrawable(R.drawable.editor_icon_timeline_left_normal);
            this.dvp = resources.getDrawable(R.drawable.editor_icon_timeline_left_normal);
            this.dnw = resources.getDrawable(R.color.transparent);
            this.cuE = resources.getDrawable(dvd);
            this.cuI = resources.getDrawable(dve);
            this.dvr = resources.getDrawable(R.drawable.editor_icon_effect_keyframe_normal);
            this.dvs = resources.getDrawable(R.drawable.editor_icon_effect_keyframe_normal_focus);
            this.dvt = this.dvr.getIntrinsicWidth();
            this.dvu = this.dvr.getIntrinsicHeight();
            this.dvf.setFocusable(true);
            this.dvf.setLongClickable(false);
            this.dvf.mo31462hz(true);
            this.dvf.mo31456hA(true);
            this.dvf.setLeftToCenterOffset(cuf / 2);
            this.dvf.mo31460hx(true);
            this.dvf.setOnLayoutListener(this.dvA);
            this.dvf.setOnGalleryDrawListener(this.dvz);
            this.dvf.setOnGalleryOperationListener(this.dvy);
            this.dvf.setChildWidth(cuf);
            acn();
            this.dvg = new C7122a(this.dvf.getContext());
            this.dvf.setAdapter((SpinnerAdapter) this.dvg);
        }
    }

    /* renamed from: kE */
    static int m20990kE(int i) {
        if (i < 0) {
            return 0;
        }
        return ((i / 3000) * cuf) + (((i % 3000) * cuf) / 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: kL */
    public void m20991kL(int i) {
        if (this.cuz && this.cuB != null) {
            int i2 = i - this.cuB.getmPosition();
            if (i2 < 0) {
                i2 = 0;
            }
            this.cuB.setmTimeLength(i2);
            StringBuilder sb = new StringBuilder();
            sb.append("updateEditRange222 length:");
            sb.append(i2);
            LogUtils.m14222e("MultiEffectTimeLineMgr", sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qm */
    public int m20998qm(int i) {
        if (this.dvh == null) {
            return -1;
        }
        ArrayList arrayList = (ArrayList) this.dvh.get(Integer.valueOf(this.cuq));
        if (arrayList == null || arrayList.size() == 0) {
            return -1;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((C8418a) arrayList.get(i2)).mo34138dx(i, C5900b.cMr)) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo31530a(Range range) {
        if (this.cur == 2) {
            Range adjacentRange = RangeUtils.getAdjacentRange(this.cuo, this.cuq, false);
            if (adjacentRange != null) {
                this.cus = adjacentRange.getmPosition();
            } else {
                this.cus = this.mDuration;
            }
            if (this.dvk != null) {
                int kN = this.dvk.mo28351kN(this.cuq);
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
            if (this.dvf != null) {
                this.dvf.invalidate();
            }
        } else {
            this.cus = 0;
            this.cut = 0;
        }
    }

    public int acp() {
        int i = 0;
        if (this.dvf != null) {
            int centerOfGallery = this.dvf.getCenterOfGallery();
            int firstVisiblePosition = this.dvf.getFirstVisiblePosition();
            int lastVisiblePosition = this.dvf.getLastVisiblePosition();
            int count = this.dvf.getAdapter().getCount();
            int i2 = firstVisiblePosition;
            int i3 = 0;
            while (true) {
                if (i2 > lastVisiblePosition) {
                    i = i3;
                    break;
                }
                View childAt = this.dvf.getChildAt(i2 - firstVisiblePosition);
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
        LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
        return i;
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

    public boolean aeE() {
        return this.dvh != null && !this.dvh.isEmpty() && !avv();
    }

    public boolean avA() {
        return this.cur == 0;
    }

    public int avu() {
        return this.mDuration;
    }

    public Range avw() {
        if (this.cuo != null) {
            int size = this.cuo.size();
            if (this.cuq >= 0 && this.cuq < size) {
                return new Range((Range) this.cuo.get(this.cuq));
            }
        }
        return null;
    }

    public Range avx() {
        return this.cuB;
    }

    public void avy() {
        this.cuB.setmPosition(0);
        this.cuB.setmTimeLength(0);
    }

    public int avz() {
        return this.cur;
    }

    /* renamed from: b */
    public C8418a mo31542b(int i, int i2, int i3, float f, float f2, int i4) {
        if (this.dvh == null) {
            this.dvh = new HashMap<>();
        }
        ArrayList arrayList = (ArrayList) this.dvh.get(Integer.valueOf(this.cuq));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Range avw = avw();
        if (avw == null) {
            return null;
        }
        int i5 = i - avw.getmPosition();
        if (i5 < 0) {
            return null;
        }
        C8418a aVar = new C8418a(i5, i, m20990kE(i), i2, i3, f, f2, i4);
        int qm = m20998qm(m20990kE(i));
        if (qm < 0 || qm >= arrayList.size()) {
            arrayList.add(aVar);
        } else {
            arrayList.set(qm, aVar);
        }
        Collections.sort(arrayList, new C5906c());
        this.dvh.put(Integer.valueOf(this.cuq), arrayList);
        if (this.dvf != null) {
            this.dvf.invalidate();
        }
        return aVar;
    }

    /* renamed from: b */
    public void mo31543b(Range range) {
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

    /* renamed from: c */
    public void mo31544c(final int i, final boolean z, boolean z2) {
        if (z2) {
            m20955E(i, z);
        } else {
            C1487a.aUa().mo10058o(new Runnable() {
                public void run() {
                    C7116a.this.m20955E(i, z);
                }
            });
        }
    }

    /* renamed from: dW */
    public void mo31545dW(boolean z) {
        if (this.dvf == null) {
            return;
        }
        if (z) {
            this.dvf.mo31461hy(true);
        } else {
            this.dvf.mo31461hy(false);
        }
    }

    public synchronized void destroy() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        if (this.dvg != null) {
            this.aaE = 0;
            this.dvg.notifyDataSetChanged();
            this.dvg = null;
        }
        if (this.dvf != null) {
            this.dvf = null;
        }
        if (this.cuo != null) {
            this.cuo.clear();
            this.cuo = null;
        }
    }

    /* renamed from: g */
    public void mo31547g(Range range) {
        if (range != null && this.dvf != null) {
            if (this.cuo == null) {
                this.cuo = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("addRange start = ");
            sb.append(range.getmPosition());
            sb.append(", end = ");
            sb.append(range.getmTimeLength());
            LogUtilsV2.m14227d(sb.toString());
            this.cuo.add(range);
            this.dvf.invalidate();
        }
    }

    public int getTimeLineLeftPos() {
        return m20963a(this.dvf);
    }

    public int getmEditBGMRangeIndex() {
        return this.cuq;
    }

    public ArrayList<C8418a> getmEffectKeyFrameRangeList() {
        if (this.dvh == null) {
            return null;
        }
        return (ArrayList) this.dvh.get(Integer.valueOf(this.cuq));
    }

    /* renamed from: h */
    public void mo31551h(Range range) {
        this.cuB.setmPosition(range.getmPosition());
        this.cuB.setmTimeLength(range.getmTimeLength());
        if (this.dvf != null) {
            this.dvf.invalidate();
        }
    }

    /* renamed from: hO */
    public void mo31552hO(boolean z) {
        this.cuz = z;
        if (this.dvf == null) {
            return;
        }
        if (z) {
            this.dvf.mo31461hy(false);
            int i = this.cuu + HttpStatus.SC_INTERNAL_SERVER_ERROR;
            int i2 = this.cmY;
            if (i > i2) {
                i = i2;
            }
            int childWidth = this.aaE * this.dvf.getChildWidth();
            this.dvf.setLimitMoveOffset(-m20990kE(i), childWidth - m20990kE(i2));
            return;
        }
        this.dvf.mo31461hy(true);
        acn();
    }

    /* renamed from: hP */
    public void mo31553hP(boolean z) {
        this.cuA = z;
    }

    public void invalidate() {
        if (this.dvf != null) {
            this.dvf.invalidate();
        }
    }

    /* renamed from: kF */
    public int mo31555kF(int i) {
        return i < this.cut ? this.cut : i > this.cus ? this.cus : i;
    }

    /* renamed from: kG */
    public void mo31556kG(int i) {
        if (this.dvf != null) {
            int i2 = i / 3000;
            int firstVisiblePosition = this.dvf.getFirstVisiblePosition();
            if (i >= 0) {
                if (i2 == 0) {
                    int lastVisiblePosition = this.dvf.getLastVisiblePosition();
                    for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                        int i4 = i3 - firstVisiblePosition;
                        RelativeLayout relativeLayout = (RelativeLayout) this.dvf.getChildAt(i4);
                        if (relativeLayout != null) {
                            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.imgview_thumbnail);
                            if (imageView != null) {
                                m20971b(imageView, i4);
                            }
                        }
                    }
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) this.dvf.getChildAt(i2 - firstVisiblePosition);
                if (relativeLayout2 != null) {
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(R.id.imgview_thumbnail);
                    if (imageView2 != null) {
                        m20971b(imageView2, i2);
                    }
                }
            }
        }
    }

    /* renamed from: kJ */
    public int mo31557kJ(int i) {
        if (this.dvj >= 0 && acv()) {
            return this.dvj;
        }
        if (this.dvj >= 0 && this.dvj < this.cuo.size()) {
            Range range = (Range) this.cuo.get(this.dvj);
            if (range != null && m20986h(i, range)) {
                return this.dvj;
            }
        }
        this.dvj = -1;
        if (this.cuo != null) {
            int size = this.cuo.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                Range range2 = (Range) this.cuo.get(i2);
                if (range2 != null && m20986h(i, range2)) {
                    this.dvj = i2;
                    break;
                }
                i2++;
            }
        }
        return this.dvj;
    }

    /* renamed from: kK */
    public void mo31558kK(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setmEditBGMRangeIndex editBGMRangeIndex=");
        sb.append(i);
        LogUtils.m14223i("MultiEffectTimeLineMgr", sb.toString());
        this.cuq = i;
        this.cur = 0;
        if (this.dvf != null) {
            if (i >= 0) {
                this.dvf.setbInEditMode(true);
            } else {
                this.dvf.setbInEditMode(false);
            }
            this.dvf.invalidate();
        }
    }

    /* renamed from: mn */
    public void mo31559mn(int i) {
        this.dvh.remove(Integer.valueOf(i));
    }

    /* renamed from: q */
    public void mo31560q(QStoryboard qStoryboard) {
        if (this.dvf != null) {
            this.dvx = new C7132f(this.dvf, qStoryboard);
        }
    }

    /* renamed from: qn */
    public void mo31561qn(int i) {
        if (this.cuo != null && this.dvf != null && this.cuo.size() > i) {
            this.cuo.remove(i);
            this.dvf.invalidate();
        }
    }

    /* renamed from: qo */
    public int mo31562qo(int i) {
        ArrayList arrayList = (ArrayList) this.dvh.get(Integer.valueOf(this.cuq));
        int i2 = -1;
        if (arrayList == null || arrayList.size() == 0) {
            return -1;
        }
        int qm = m20998qm(m20990kE(i));
        if (qm < 0 || qm >= arrayList.size()) {
            return -1;
        }
        C8418a aVar = (C8418a) arrayList.remove(qm);
        this.dvh.put(Integer.valueOf(this.cuq), arrayList);
        if (this.dvf != null) {
            this.dvf.invalidate();
        }
        if (aVar != null) {
            i2 = aVar.edv;
        }
        return i2;
    }

    /* renamed from: qp */
    public void mo31563qp(int i) {
        if (this.mDragState == -1 && this.cur == 0 && this.cuq != i) {
            this.cuq = i;
            if (this.dvf != null) {
                this.dvf.invalidate();
            }
        }
    }

    /* renamed from: qq */
    public void mo31564qq(int i) {
        this.cuu = i;
    }

    /* renamed from: qr */
    public void mo31565qr(int i) {
        this.cmY = i;
    }

    /* renamed from: qs */
    public void mo31566qs(int i) {
        this.cur = i;
    }

    public void setCurrentFocusPos(int i) {
        this.dvj = i;
    }

    public void setKeyFrameListener(C7131e eVar) {
        this.dvl = eVar;
    }

    public void setMaskDrawable(Drawable drawable) {
        if (drawable != null) {
            this.cuI = drawable;
        }
    }

    public void setTrimMaskDrawable(Drawable drawable) {
        if (drawable != null) {
            this.cuE = drawable;
        }
    }

    public void setmOnTimeLineSeekListener(C7124b bVar) {
        this.dvk = bVar;
    }

    public void setmState(int i) {
        this.mState = i;
    }
}
