package com.introvd.template.app.homepage.hometab;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.R;
import com.introvd.template.app.homepage.p186a.C3932b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4580b;

public abstract class HomeTabLayoutBase extends RelativeLayout {
    protected C3969a bru;
    public C3932b bsm;
    protected HomeTabLayoutModel bsn;

    /* renamed from: com.introvd.template.app.homepage.hometab.HomeTabLayoutBase$a */
    public interface C3969a {
        /* renamed from: gM */
        boolean mo23453gM(int i);

        /* renamed from: q */
        void mo23454q(int i, boolean z);
    }

    public HomeTabLayoutBase(Context context) {
        super(context);
        this.bsm = new C3932b(context, C4580b.m11666qi());
    }

    public HomeTabLayoutBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsm = new C3932b(context, C4580b.m11666qi());
    }

    public HomeTabLayoutBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsm = new C3932b(context, C4580b.m11666qi());
    }

    /* renamed from: LM */
    public abstract void mo23530LM();

    /* access modifiers changed from: 0000 */
    /* renamed from: LN */
    public abstract void mo23531LN();

    /* renamed from: LO */
    public void mo23538LO() {
        if (this.bsm != null) {
            this.bsm.mo23464LI();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo23532a(HomeTabLayoutModel homeTabLayoutModel);

    /* renamed from: gO */
    public abstract RelativeLayout mo23533gO(int i);

    /* renamed from: gP */
    public abstract ImageView mo23534gP(int i);

    /* renamed from: h */
    public void mo23539h(final View view, final boolean z) {
        if (view != null) {
            post(new Runnable() {
                public void run() {
                    if (HomeTabLayoutBase.this.bsm != null && view != null && (HomeTabLayoutBase.this.getContext() instanceof Activity) && !((Activity) HomeTabLayoutBase.this.getContext()).isFinishing()) {
                        String Jv = C3742b.m9111II().mo23175Jv();
                        if (TextUtils.isEmpty(Jv)) {
                            Jv = HomeTabLayoutBase.this.getResources().getString(R.string.xiaoying_str_homeview_creation_tip);
                        }
                        HomeTabLayoutBase.this.bsm.mo23470dt(Jv);
                        int Ju = C3742b.m9111II().mo23174Ju();
                        int i = 3;
                        if (Ju == 2) {
                            i = z ? 2 : 0;
                        } else if (Ju != 3) {
                            i = -1;
                        } else if (!z) {
                            i = 1;
                        }
                        if (i != -1) {
                            HomeTabLayoutBase.this.bsm.mo23466a(i, HomeTabLayoutBase.this.getContext());
                            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.1f);
                            translateAnimation.setDuration(500);
                            translateAnimation.setRepeatCount(-1);
                            translateAnimation.setRepeatMode(2);
                            if (z) {
                                HomeTabLayoutBase.this.bsm.mo23469b(view, (HomeTabLayoutBase.this.mo23533gO(4) == null || HomeTabLayoutBase.this.mo23533gO(4).getVisibility() != 0) ? 0 : (Constants.getScreenSize().width / 4) / 2, 0, translateAnimation);
                            } else {
                                HomeTabLayoutBase.this.bsm.mo23467a(view, C7689a.m22597aR(1.0f), 0, translateAnimation);
                            }
                            UserBehaviorABTestUtils.homeTabCreateTipShow(HomeTabLayoutBase.this.getContext());
                        }
                    }
                }
            });
        }
    }

    /* renamed from: r */
    public abstract boolean mo23536r(int i, boolean z);

    public void setTabOnClickListener(C3969a aVar) {
        this.bru = aVar;
    }
}
