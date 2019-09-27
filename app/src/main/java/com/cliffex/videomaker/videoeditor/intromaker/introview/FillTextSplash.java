package com.cliffex.videomaker.videoeditor.intromaker.introview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FillTextSplash {
    public static void introFill(Activity activity) {
        Log.d("TAG", "introFill: ss");
        AnimatorSet animatorSet = new AnimatorSet();
        TextView textView = (TextView) activity.findViewById(activity.getResources().getIdentifier("tv_splash__intro_maker", "id", activity.getPackageName()));
        TextView textViewShortDes = (TextView) activity.findViewById(activity.getResources().getIdentifier("tv_short_des_splash", "id", activity.getPackageName()));
        ImageView imageView = (ImageView) activity.findViewById(activity.getResources().getIdentifier("img_splash_icon_intro", "id", activity.getPackageName()));
        textViewShortDes.setVisibility(8);
        animatorSet.playSequentially(new Animator[]{alphaView(textView), alphaView(textViewShortDes)});
        animatorSet.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    public static ObjectAnimator alphaView(final View paramView) {
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[]{0.0f, 1.0f});
        localObjectAnimator.setDuration(1500);
        localObjectAnimator.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                paramView.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                paramView.setVisibility(0);
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
        return localObjectAnimator;
    }
}
