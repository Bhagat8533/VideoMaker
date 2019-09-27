package com.introvd.template.module.p326ad.exit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7678j;

/* renamed from: com.introvd.template.module.ad.exit.c */
abstract class C7637c extends FrameLayout {
    private View dMO;

    public C7637c(Context context) {
        super(context);
        setId(R.id.interstitial_view_id);
        setClickable(true);
        LayoutInflater.from(context).inflate(R.layout.iap_ad_view_interstitial_exit, this, true);
    }

    /* access modifiers changed from: private */
    public void aAq() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) findViewById(R.id.tv_text_animation), "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(800);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C7637c.this.aAp();
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: 0000 */
    public abstract void aAp();

    /* access modifiers changed from: 0000 */
    /* renamed from: ix */
    public void mo32518ix(boolean z) {
        if (!z) {
            if (this.dMO != null) {
                this.dMO.setVisibility(8);
            }
            findViewById(R.id.exit_dialog_animation_view).setVisibility(0);
            postDelayed(new Runnable() {
                public void run() {
                    C7637c.this.aAq();
                }
            }, 200);
        } else if (this.dMO == null) {
            this.dMO = C7678j.aAd().mo23617Mh();
            addView(this.dMO, new LayoutParams(-1, -1));
        }
    }
}
