package com.introvd.template.p203b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.b.a */
public class C4562a {
    /* renamed from: Sd */
    public static Animation m11531Sd() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    /* renamed from: Se */
    public static Animation m11532Se() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    /* renamed from: a */
    public static void m11533a(View view, boolean z, boolean z2, int i) {
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    if (z2) {
                        if (i <= 0) {
                            i = 300;
                        }
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
                        translateAnimation.setDuration((long) i);
                        view.startAnimation(translateAnimation);
                    }
                    view.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                if (z2) {
                    if (i <= 0) {
                        i = 200;
                    }
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
                    translateAnimation2.setDuration((long) i);
                    view.startAnimation(translateAnimation2);
                }
                view.setVisibility(4);
            }
        }
    }

    /* renamed from: b */
    public static void m11534b(View view, boolean z, boolean z2, int i) {
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    if (z2) {
                        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), C10122R.anim.v4_xiaoying_slide_out_down_self));
                    }
                    view.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), C10122R.anim.v4_xiaoying_slide_in_down_self));
                }
                view.setVisibility(4);
            }
        }
    }

    /* renamed from: bZ */
    public static void m11535bZ(View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
            view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), C10122R.anim.xiaoying_ve_alpha_from0to1));
        }
    }

    /* renamed from: c */
    public static void m11536c(View view, boolean z, boolean z2, int i) {
        if (view != null) {
            if (z) {
                if (z2) {
                    if (i <= 0) {
                        i = 300;
                    }
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    translateAnimation.setDuration((long) i);
                    view.startAnimation(translateAnimation);
                }
            } else if (z2) {
                if (i <= 0) {
                    i = 200;
                }
                TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                translateAnimation2.setDuration((long) i);
                view.startAnimation(translateAnimation2);
            }
        }
    }

    /* renamed from: ca */
    public static void m11537ca(View view) {
        if (view != null && view.isShown()) {
            view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), C10122R.anim.xiaoying_ve_alpha_from1to0));
            view.setVisibility(4);
        }
    }

    /* renamed from: cb */
    public static void m11538cb(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);
    }

    /* renamed from: cc */
    public static void m11539cc(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);
    }

    /* renamed from: v */
    public static void m11540v(final View view, int i) {
        if (view != null && i % 90 == 0) {
            view.animate().rotation((float) i).setDuration(300).setListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    float rotation = view.getRotation();
                    if (rotation == 360.0f || rotation == -360.0f) {
                        view.setRotation(0.0f);
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }
}
