package com.introvd.template.app.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.R;

public class ActivityAttendView extends RelativeLayout implements OnClickListener {
    private RelativeLayout biL;
    private RelativeLayout biM;
    private LinearLayout biN;
    private C3681a biO;
    private Context mContext;
    private Animation mHideAlphaAnim;
    private Animation mHideAnim;
    private ImageView mImgBg;
    private Animation mShowAlphaAnim;
    private Animation mShowAnim;

    /* renamed from: com.introvd.template.app.activity.ActivityAttendView$a */
    public interface C3681a {
        /* renamed from: gj */
        void mo23034gj(int i);
    }

    public ActivityAttendView(Context context) {
        super(context);
        this.mContext = context.getApplicationContext();
        initUI();
    }

    public ActivityAttendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context.getApplicationContext();
        initUI();
    }

    public ActivityAttendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context.getApplicationContext();
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.activity_attend_view, this, true);
        this.biL = (RelativeLayout) findViewById(R.id.btn_start_capture);
        this.biM = (RelativeLayout) findViewById(R.id.btn_select_work);
        this.mImgBg = (ImageView) findViewById(R.id.img_background);
        this.biN = (LinearLayout) findViewById(R.id.btn_layout);
        this.biL.setOnClickListener(this);
        this.biM.setOnClickListener(this);
        this.mImgBg.setOnClickListener(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mShowAnim = translateAnimation;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.mHideAnim = translateAnimation2;
        this.mShowAlphaAnim = new AlphaAnimation(0.0f, 1.0f);
        this.mHideAlphaAnim = new AlphaAnimation(1.0f, 0.0f);
        this.mShowAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mHideAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mShowAlphaAnim.setDuration(100);
        this.mHideAlphaAnim.setDuration(100);
        this.mShowAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mHideAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mShowAnim.setDuration(100);
        this.mHideAnim.setDuration(100);
        this.mHideAnim.setFillAfter(true);
        this.mHideAlphaAnim.setFillAfter(true);
        this.mHideAnim.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                ActivityAttendView.this.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void hide(boolean z) {
        if (z) {
            clearAnimation();
            this.mImgBg.startAnimation(this.mHideAlphaAnim);
            this.biN.startAnimation(this.mHideAnim);
            return;
        }
        setVisibility(4);
    }

    public void onClick(View view) {
        if (view.equals(this.biL)) {
            hide(false);
            if (this.biO != null) {
                this.biO.mo23034gj(0);
            }
        } else if (view.equals(this.biM)) {
            hide(false);
            if (this.biO != null) {
                this.biO.mo23034gj(1);
            }
        } else if (view.equals(this.mImgBg)) {
            hide(true);
        }
    }

    public void setViewItemClickListener(C3681a aVar) {
        this.biO = aVar;
    }
}
