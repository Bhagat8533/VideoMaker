package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p208a.C4663b;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p233ui.view.seekbar.C5201a;
import com.introvd.template.camera.p233ui.view.seekbar.C5201a.C5203a;
import com.introvd.template.camera.p233ui.view.seekbar.DraggableSeekBar;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.BeautyLevelBar */
public class BeautyLevelBar extends RelativeLayout {
    /* access modifiers changed from: private */
    public static final String TAG = "BeautyLevelBar";
    private static String[] bWQ = {"0", "1", "2", "3", "4"};
    private static String[] bWR = {"0", "0.2", "0.4", "0.6", "0.8", "1.0", "1.2", "1.4", "1.6", "1.8", "2.0", "2.2", "2.4", "2.6", "2.8", "3.0", "3.2", "3.4", "3.6", "3.8", "4.0"};
    private static Float[] bWS = {Float.valueOf(0.0f), Float.valueOf(0.2f), Float.valueOf(0.4f), Float.valueOf(0.6f), Float.valueOf(0.8f), Float.valueOf(1.0f), Float.valueOf(1.2f), Float.valueOf(1.4f), Float.valueOf(1.6f), Float.valueOf(1.8f), Float.valueOf(2.0f), Float.valueOf(2.2f), Float.valueOf(2.4f), Float.valueOf(2.6f), Float.valueOf(2.8f), Float.valueOf(3.0f), Float.valueOf(3.2f), Float.valueOf(3.4f), Float.valueOf(3.6f), Float.valueOf(3.8f), Float.valueOf(4.0f)};
    /* access modifiers changed from: private */
    public TextView bCG;
    /* access modifiers changed from: private */
    public C4663b bWT;
    /* access modifiers changed from: private */
    public DraggableSeekBar bWU;
    private C5201a bWV;
    private boolean bWy = true;
    private Context mContext;
    private Animation mHideAnim;
    private Animation mShowAnim;

    public BeautyLevelBar(Context context) throws Exception {
        super(context);
        this.mContext = context;
        init();
    }

    public BeautyLevelBar(Context context, AttributeSet attributeSet) throws Exception {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateView);
        this.bWy = obtainStyledAttributes.getBoolean(R.styleable.RotateView_isPortrait, true);
        obtainStyledAttributes.recycle();
        this.mContext = context;
        init();
    }

    public BeautyLevelBar(Context context, AttributeSet attributeSet, int i) throws Exception {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateView);
        this.bWy = obtainStyledAttributes.getBoolean(R.styleable.RotateView_isPortrait, true);
        obtainStyledAttributes.recycle();
        this.mContext = context;
        init();
    }

    /* renamed from: WV */
    private void m14000WV() {
        if (this.bWy) {
            this.mShowAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.v4_xiaoying_slide_out_down_self);
            this.mHideAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.xiaoying_slide_in_down_self);
            return;
        }
        this.mShowAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.v4_xiaoying_slide_out_up_self);
        this.mHideAnim = AnimationUtils.loadAnimation(this.mContext, R.anim.v4_xiaoying_slide_in_up_self);
    }

    /* renamed from: Yb */
    private void m14001Yb() {
        float f = (AppStateModel.getInstance().isInChina() || AppStateModel.getInstance().isSoutheastAsia()) ? 2.0f : 0.0f;
        this.bWV = new C5201a(this.bWU, false);
        this.bWV.mo26350a(bWQ, bWR, bWS, f, -2130706433, false, false);
        this.bWV.mo26349a((C5203a) new C5203a() {
            /* renamed from: R */
            public void mo26133R(float f) {
                BeautyLevelBar.this.m14003a(BeautyLevelBar.this.bCG, 1.0f, 0.0f, 200, 300);
                int position = BeautyLevelBar.this.bWU.getPosition();
                int i = position + 1;
                if (BeautyLevelBar.this.bWT != null) {
                    String access$400 = BeautyLevelBar.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onStopTrackingTouch=");
                    sb.append(position);
                    sb.append(";speedValue=");
                    sb.append(i);
                    LogUtils.m14222e(access$400, sb.toString());
                    BeautyLevelBar.this.bWT.mo24977iI(i);
                }
                C5008i.m12937VU().mo25659jn(i);
                BeautyLevelBar.this.update();
            }

            /* renamed from: Yc */
            public void mo26134Yc() {
                BeautyLevelBar.this.m14003a(BeautyLevelBar.this.bCG, 0.0f, 1.0f, 200, 300);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14003a(View view, float f, float f2, long j, long j2) {
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(false);
        alphaAnimation.setStartOffset(j);
        view.startAnimation(alphaAnimation);
    }

    private void init() {
        initUI();
    }

    private void initUI() {
        if (this.bWy) {
            LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_fb_level_choose_por_new, this, true);
        } else {
            LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_fb_level_choose_lan_new, this, true);
        }
        this.bCG = (TextView) findViewById(R.id.txt_title);
        this.bCG.setText(R.string.xiaoying_str_cam_fb_title);
        this.bWU = (DraggableSeekBar) findViewById(R.id.txtseekbar_fb_level);
        m14001Yb();
        m14000WV();
    }

    /* renamed from: ds */
    public void mo26129ds(boolean z) {
        if (getVisibility() == 0) {
            setVisibility(8);
            if (z) {
                startAnimation(this.mHideAnim);
            }
        }
        C5008i.m12937VU().mo25638cN(false);
    }

    /* renamed from: o */
    public void mo26130o(boolean z, boolean z2) {
        if (getVisibility() != 0) {
            setVisibility(0);
            if (z) {
                startAnimation(this.mShowAnim);
            }
        }
        if (!z2) {
            m14003a(this.bCG, 1.0f, 0.0f, 800, 300);
        }
        C5008i.m12937VU().mo25638cN(true);
    }

    public void setFBLevelItemClickListener(C4663b bVar) {
        this.bWT = bVar;
    }

    public void update() {
        this.bWU.setPostion(C5008i.m12937VU().mo25623Wj() - 1);
        this.bWU.invalidate();
    }
}
