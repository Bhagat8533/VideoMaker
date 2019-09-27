package com.introvd.template.editor.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p246c.C5689c;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p259f.C6282d;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.player.p269b.C6500b;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import java.lang.ref.WeakReference;

public abstract class BaseEditorPlayerView extends LinearLayout implements C0068f, C6499a {
    protected RelativeLayout bMj;
    protected int cFI;
    protected C5689c cUa;
    protected WeakReference<Activity> cYe;
    protected SurfaceView cYf;
    protected RelativeLayout cYg;
    protected SurfaceHolder cYh;
    protected boolean cYi;
    protected int cYj;
    protected volatile int cYk;
    protected int cYl;
    protected volatile boolean cYm;
    protected boolean cYn;
    protected boolean cYo;
    protected boolean cYp;
    protected C5655b cYq;
    protected int cYr;
    protected boolean cYs;
    protected boolean cYt;
    protected C6500b cYu;
    protected C6280b cYv;
    private C5688b cYw;
    private C6282d cYx;
    protected boolean cYy;
    protected int csK;
    protected MSize csP;
    protected volatile C8431d cso;
    protected MSize css;

    public BaseEditorPlayerView(Context context) {
        this(context, null);
    }

    public BaseEditorPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseEditorPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYi = true;
        this.cYj = 0;
        this.cYk = 0;
        this.csK = 0;
        this.cYl = 0;
        this.cYm = false;
        this.cFI = 0;
        this.cYr = 0;
        this.cYs = true;
        this.cYt = true;
        this.cYy = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseEditorPlayerView);
            this.cYj = obtainStyledAttributes.getInteger(R.styleable.BaseEditorPlayerView_display_mode, 0);
            this.cYi = obtainStyledAttributes.getBoolean(R.styleable.BaseEditorPlayerView_seek_enable, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: C */
    private void m18693C(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>stretchY --> valueAnimator value:");
                sb.append(floatValue);
                LogUtils.m14222e("EditorPlayerView", sb.toString());
                LayoutParams layoutParams = (LayoutParams) BaseEditorPlayerView.this.cYg.getLayoutParams();
                layoutParams.topMargin = (int) (((float) C5840b.cEB) * floatValue);
                layoutParams.bottomMargin = C5840b.cEz - ((int) (((float) (C5840b.cEz - C5840b.cEA)) * floatValue));
                BaseEditorPlayerView.this.cYg.requestLayout();
                BaseEditorPlayerView.this.cYg.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                LogUtils.m14222e("EditorPlayerView", ">>>>>stretchY onAnimationEnd ---->:");
                BaseEditorPlayerView.this.cYy = false;
                if (!BaseEditorPlayerView.this.mo29641a(BaseEditorPlayerView.this.cYq.getStreamSize(), BaseEditorPlayerView.this.cYq.adN()).equals(BaseEditorPlayerView.this.csP)) {
                    BaseEditorPlayerView.this.cYr = C5852d.agW().agZ();
                    BaseEditorPlayerView.this.aoe();
                } else if (BaseEditorPlayerView.this.cYr != C5852d.agW().agZ()) {
                    BaseEditorPlayerView.this.cYr = C5852d.agW().agZ();
                    BaseEditorPlayerView.this.mo29687cH(C5852d.agW().agZ(), BaseEditorPlayerView.this.cYl);
                }
                BaseEditorPlayerView.this.mo29649c(BaseEditorPlayerView.this.cYq.getStreamSize(), true);
            }

            public void onAnimationStart(Animator animator) {
                LogUtils.m14222e("EditorPlayerView", ">>>>>stretchY onAnimationStart ---->:");
                BaseEditorPlayerView.this.cYy = true;
            }
        });
        ofFloat.start();
    }

    /* renamed from: U */
    public void mo29640U(int i, boolean z) {
        this.cFI = i;
        if (!z) {
            this.cYs = true;
        }
        aof();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MSize mo29641a(MSize mSize, MSize mSize2) {
        VeMSize veMSize = null;
        VeMSize veMSize2 = mSize != null ? new VeMSize(mSize.width, mSize.height) : null;
        if (mSize2 != null) {
            veMSize = new VeMSize(mSize2.width, mSize2.height);
        }
        VeMSize a = C8572y.m25064a(C8572y.m25090e(veMSize2, veMSize), new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().height), veMSize);
        return new MSize(a.width, a.height);
    }

    /* renamed from: a */
    public void mo29642a(Activity activity, C5655b bVar, int i) {
        this.cFI = i;
        this.cYq = bVar;
        this.cYe = new WeakReference<>(activity);
    }

    public void aex() {
    }

    public void aoe() {
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
            LogUtils.m14222e("EditorPlayerView", "releasePlayer()~!!!!");
        }
    }

    public void aof() {
    }

    public boolean aog() {
        return this.cYk == 2;
    }

    public void aoh() {
        LogUtils.m14222e("EditorPlayerView", "Player onVideoPlay");
    }

    public void aoi() {
        LogUtils.m14222e("EditorPlayerView", "Player onVideoPause");
    }

    /* renamed from: c */
    public boolean mo29649c(MSize mSize, boolean z) {
        return false;
    }

    /* renamed from: ep */
    public void mo29650ep(boolean z) {
        this.cYt = z;
    }

    /* renamed from: fD */
    public void mo29651fD(boolean z) {
        if (this.cso == null) {
            return;
        }
        if (z) {
            this.cso.aIz();
        } else {
            this.cso.aIA();
        }
    }

    public C5688b getFineTuningProxyListener() {
        return this.cYw;
    }

    public ViewGroup getPreviewLayout() {
        return this.cYg;
    }

    public C6282d getVideoControlListener() {
        return this.cYx;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gl */
    public void mo29655gl(boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: nO */
    public int mo29656nO(int i) {
        if (this.cso == null) {
            return i;
        }
        VeRange aIC = this.cso.aIC();
        if (aIC == null) {
            return i;
        }
        int i2 = i - aIC.getmPosition();
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 > aIC.getmTimeLength() ? aIC.getmTimeLength() : i2;
    }

    /* renamed from: oe */
    public void mo29657oe(int i) {
        if (this.cYj != i) {
            this.cYj = i;
            if (i == 1) {
                m18693C(0.0f, 1.0f);
            } else if (i == 0) {
                m18693C(1.0f, 0.0f);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: of */
    public boolean mo29658of(int i) {
        return !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId()) && i >= 300000;
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
        LogUtilsV2.m14227d("onActivityCreate");
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestroy() {
        LogUtilsV2.m14227d("onActivityDestroy");
        if (this.cYe != null) {
            this.cYe.clear();
        }
        if (this.cYu != null) {
            this.cYu = null;
        }
        if (this.cYw != null) {
            this.cYw = null;
        }
        if (this.cYv != null) {
            this.cYv = null;
        }
        if (this.cYx != null) {
            this.cYx = null;
        }
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onActivityPause() {
        LogUtilsV2.m14227d("onActivityPause");
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onActivityResume() {
        LogUtilsV2.m14227d("onActivityResume");
    }

    @C0078n(mo161n = C0062a.ON_STOP)
    public void onActivityStop() {
        LogUtilsV2.m14227d("onActivityStop");
    }

    public void pause() {
        if (this.cso != null && aog()) {
            this.cso.pause();
        }
    }

    public void setAutoPlayWhenReady(boolean z) {
        this.cYn = z;
    }

    public void setFineTuningProxyListener(C5688b bVar) {
        this.cYw = bVar;
        if (bVar != null && this.cUa != null) {
            bVar.mo27798a(this.cUa.aml());
        }
    }

    public void setIPlayerCallback(C6500b bVar) {
        this.cYu = bVar;
    }

    public void setPlayerInitTime(int i) {
        this.cYl = i;
    }

    public void setPlayerStatusListener(C6280b bVar) {
        this.cYv = bVar;
    }

    public void setTouchDownPausable(boolean z) {
        this.cYs = z;
    }

    public void setVideoControlListener(C6282d dVar) {
        this.cYx = dVar;
    }
}
