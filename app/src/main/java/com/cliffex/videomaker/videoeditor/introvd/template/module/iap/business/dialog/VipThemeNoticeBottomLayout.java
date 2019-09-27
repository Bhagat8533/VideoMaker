package com.introvd.template.module.iap.business.dialog;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.content.ContextCompat;
import android.support.p021v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.yan.rippledrawable.RippleLayout;
import java.util.HashMap;
import java.util.Locale;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;

public class VipThemeNoticeBottomLayout extends FrameLayout implements C0068f {
    /* access modifiers changed from: private */
    public C1495b cTc;
    /* access modifiers changed from: private */
    public C7884a dRi;
    private Long dRj;

    /* renamed from: com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout$a */
    public interface C7884a {
        /* renamed from: UT */
        void mo29975UT();

        void apU();
    }

    private VipThemeNoticeBottomLayout(Activity activity, Long l, C7884a aVar) {
        super(activity);
        this.dRj = l;
        this.dRi = aVar;
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getLifecycle().mo152a(this);
        }
        init();
    }

    /* access modifiers changed from: private */
    public String aCu() {
        try {
            String upperCase = Long.toHexString(this.dRj.longValue()).toUpperCase(Locale.US);
            int length = upperCase.length();
            for (int i = 0; i < 16 - length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0");
                sb.append(upperCase);
                upperCase = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0x");
            sb2.append(upperCase);
            return sb2.toString();
        } catch (Exception unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(this.dRj);
            return sb3.toString();
        }
    }

    /* renamed from: b */
    public static VipThemeNoticeBottomLayout m22958b(Activity activity, Long l, C7884a aVar) {
        return new VipThemeNoticeBottomLayout(activity, l, aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22959d(Activity activity, final boolean z) {
        if (this.cTc != null && !this.cTc.aAy()) {
            this.cTc.dispose();
        }
        ((C1834l) AdServiceProxy.execute(AdServiceProxy.observableShowUnlockTemplate, activity, aCu(), Boolean.valueOf(true))).mo10149b((C1842q<? super T>) new C1842q<Integer>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                VipThemeNoticeBottomLayout.this.cTc = bVar;
            }

            /* renamed from: n */
            public void mo9886K(Integer num) {
                if (num.intValue() == 0 || num.intValue() == 1) {
                    VipThemeNoticeBottomLayout.this.setVisibility(8);
                } else if (VipThemeNoticeBottomLayout.this.dRi != null) {
                    VipThemeNoticeBottomLayout.this.dRi.mo29975UT();
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                if (!z) {
                    VipThemeNoticeBottomLayout.this.setVisibility(8);
                    if (VipThemeNoticeBottomLayout.this.dRi != null) {
                        VipThemeNoticeBottomLayout.this.dRi.mo29975UT();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: iG */
    public void m22960iG(boolean z) {
        HashMap hashMap = new HashMap(2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.dRj);
        sb.append("");
        hashMap.put("Template_ID", sb.toString());
        hashMap.put("Button value", z ? "cancel" : ProductAction.ACTION_PURCHASE);
        C8048e.aBe().mo23653g("VIP_Trial_Button_Click", hashMap);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.iap_vip_theme_notice_bottom, this, true);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = C7689a.m22599ii(187);
        setLayoutParams(layoutParams);
        View findViewById = findViewById(R.id.tv_btn_become_vip);
        ViewCompat.setBackground(findViewById, RippleLayout.m27639C(ContextCompat.getDrawable(getContext(), R.drawable.iap_vip_bg_vip_theme_bottom_btn)));
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Activity activity = (Activity) VipThemeNoticeBottomLayout.this.getContext();
                activity.getIntent().putExtra("TAG_START_FOR_RESULT", "TAG_START_FOR_RESULT");
                C7897a.m23022b(VipThemeNoticeBottomLayout.this.aCu(), "Iap_Purchase_Template_Id", new String[0]);
                C8049f.aBf().mo33097b(activity, "platinum", C7825a.ALL_TEMPLATE.getId(), "VIP Theme", IapRTConstants.REQUEST_CODE_FOR_VIP);
                if (VipThemeNoticeBottomLayout.this.dRi != null) {
                    VipThemeNoticeBottomLayout.this.dRi.apU();
                    VipThemeNoticeBottomLayout.this.m22960iG(false);
                }
            }
        });
        View findViewById2 = findViewById(R.id.tv_btn_cancel);
        ViewCompat.setBackground(findViewById2, RippleLayout.m27639C(ContextCompat.getDrawable(getContext(), R.drawable.iap_vip_bg_vip_theme_bottom_cancel_bg)));
        findViewById2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (VipThemeNoticeBottomLayout.this.dRi != null) {
                    VipThemeNoticeBottomLayout.this.m22960iG(true);
                    if (VipThemeNoticeBottomLayout.this.getContext() instanceof Activity) {
                        VipThemeNoticeBottomLayout.this.m22959d((Activity) VipThemeNoticeBottomLayout.this.getContext(), false);
                        return;
                    }
                    VipThemeNoticeBottomLayout.this.dRi.mo29975UT();
                    VipThemeNoticeBottomLayout.this.setVisibility(8);
                }
            }
        });
        setVisibility(8);
    }

    /* renamed from: c */
    public void mo32800c(Activity activity, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ------ onActivityResume: ");
        sb.append(z);
        LogUtils.m14222e("onActivityResume", sb.toString());
        if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("TAG_START_FOR_RESULT")) && z) {
            activity.getIntent().putExtra("TAG_START_FOR_RESULT", "");
            if (!C8072q.aBx().isVip()) {
                m22959d(activity, true);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        ((FragmentActivity) getContext()).getLifecycle().mo153b(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cTc != null && !this.cTc.aAy()) {
            this.cTc.dispose();
        }
    }

    /* access modifiers changed from: 0000 */
    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        if (this.cTc != null && !this.cTc.aAy()) {
            this.cTc.dispose();
        }
    }

    public void setTemplateId(long j) {
        this.dRj = Long.valueOf(j);
    }
}
