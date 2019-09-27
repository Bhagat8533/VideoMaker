package com.introvd.template.app.p199v5.common;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;

/* renamed from: com.introvd.template.app.v5.common.PopupMoreToolView */
public class PopupMoreToolView extends RelativeLayout implements OnClickListener {
    private static final int[] bEZ = {R.drawable.vivavideo_moretools_collage_n, R.drawable.vivavideo_moretools_selfie_n, R.drawable.vivavideo_moretools_music_n, R.drawable.vivavideo_moretools_funny_n};
    private static final int[] bFa = {R.string.xiaoying_str_cam_camera_mode_pip, R.string.xiaoying_str_cam_camera_mode_face_beauty, R.string.xiaoying_str_cam_camera_mode_mv, R.string.xiaoying_str_cam_camera_mode_funny};
    /* access modifiers changed from: private */
    public static final int[] bFb = {409, TodoConstants.TODO_TYPE_CAMERA_MODE_FB, 207, TodoConstants.TODO_TYPE_CAMERA_MODE_FUNNY};
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < PopupMoreToolView.bFb.length) {
                PopupMoreToolView.this.hide(true);
                UserBehaviorUtilsV5.onEventHomeMore(PopupMoreToolView.this.mContext, BizAppTodoActionManager.getInstance().getTodoCodeName(PopupMoreToolView.bFb[intValue]));
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = PopupMoreToolView.bFb[intValue];
                BizAppTodoActionManager.getInstance().executeTodo((Activity) PopupMoreToolView.this.mContext, tODOParamModel, null);
            }
        }
    };
    private LinearLayout bFc;
    private C4411b bFd;
    private C4410a bFe;
    private LinearLayout mBodyLayout;
    /* access modifiers changed from: private */
    public Context mContext;
    private Animation mHideAlphaAnim;
    private Animation mHideAnim;
    private ImageView mImgBg;
    private Animation mShowAlphaAnim;
    private Animation mShowAnim;
    private TextView mTvCancel;

    /* renamed from: com.introvd.template.app.v5.common.PopupMoreToolView$a */
    public interface C4410a {
        void onChange(boolean z);
    }

    /* renamed from: com.introvd.template.app.v5.common.PopupMoreToolView$b */
    public interface C4411b {
    }

    public PopupMoreToolView(Context context) {
        super(context);
        this.mContext = context;
        if (!isInEditMode()) {
            initUI();
        }
    }

    public PopupMoreToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        if (!isInEditMode()) {
            initUI();
        }
    }

    public PopupMoreToolView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        if (!isInEditMode()) {
            initUI();
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.v5_popup_more_tool, this, true);
        this.mImgBg = (ImageView) findViewById(R.id.img_background);
        this.mBodyLayout = (LinearLayout) findViewById(R.id.body_layout);
        this.bFc = (LinearLayout) findViewById(R.id.layout_item_group);
        this.mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        this.mTvCancel.setTag(Integer.valueOf(99));
        this.mTvCancel.setOnClickListener(this);
        this.mImgBg.setOnClickListener(this);
        this.mShowAnim = C4562a.m11532Se();
        this.mHideAnim = C4562a.m11531Sd();
        this.mHideAnim.setFillAfter(true);
        this.mShowAlphaAnim = new AlphaAnimation(0.0f, 1.0f);
        this.mHideAlphaAnim = new AlphaAnimation(1.0f, 0.0f);
        this.mShowAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mHideAlphaAnim.setInterpolator(new LinearInterpolator());
        this.mShowAlphaAnim.setDuration(100);
        this.mHideAlphaAnim.setDuration(200);
        this.mHideAlphaAnim.setFillAfter(true);
        this.mHideAnim.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                PopupMoreToolView.this.setVisibility(8);
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
            this.mBodyLayout.startAnimation(this.mHideAnim);
        } else {
            setVisibility(8);
        }
        if (this.bFe != null) {
            this.bFe.onChange(false);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.mTvCancel)) {
            hide(true);
            UserBehaviorUtilsV5.onEventHomeMore(this.mContext, "cancel");
        } else if (view.equals(this.mImgBg)) {
            hide(true);
            UserBehaviorUtilsV5.onEventHomeMore(this.mContext, "cancel");
        }
        if (this.bFe != null) {
            this.bFe.onChange(false);
        }
    }

    public void setOnOpenStateChangeListener(C4410a aVar) {
        this.bFe = aVar;
    }

    public void setOnPopupItemClickListener(C4411b bVar) {
        this.bFd = bVar;
    }
}
