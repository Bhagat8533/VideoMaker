package com.introvd.template.module.iap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;

/* renamed from: com.introvd.template.module.iap.c */
public final class C8035c {
    /* access modifiers changed from: private */
    public static int bgQ = 0;
    /* access modifiers changed from: private */
    public static Dialog dOa = null;
    private static boolean dOb = true;
    /* access modifiers changed from: private */
    public static C8039b dOc;

    /* renamed from: com.introvd.template.module.iap.c$a */
    public static class C8038a {
        int bgQ = -1;
        int dOg;
        int dOh;
        int dOi = R.drawable.iap_vip_selector_btn_bg;
        int dOj = R.string.xiaoying_str_vip;
        int dOk = R.string.xiaoying_str_reward_video_ad_to_watch;
        View[] dOl;
        View dOm;
        View dOn;
        int iconRes;

        /* renamed from: a */
        public C8038a mo33053a(View... viewArr) {
            this.dOl = viewArr;
            return this;
        }

        /* renamed from: cY */
        public C8038a mo33054cY(View view) {
            this.dOm = view;
            return this;
        }

        /* renamed from: cZ */
        public C8038a mo33055cZ(View view) {
            this.dOn = view;
            return this;
        }

        /* renamed from: rY */
        public C8038a mo33056rY(int i) {
            this.bgQ = i;
            return this;
        }

        /* renamed from: rZ */
        public C8038a mo33057rZ(int i) {
            this.dOg = i;
            return this;
        }

        /* renamed from: sa */
        public C8038a mo33058sa(int i) {
            this.dOh = i;
            return this;
        }

        /* renamed from: sb */
        public C8038a mo33059sb(int i) {
            this.dOi = i;
            return this;
        }

        /* renamed from: sc */
        public C8038a mo33060sc(int i) {
            this.dOj = i;
            return this;
        }

        /* renamed from: sd */
        public C8038a mo33061sd(int i) {
            this.dOk = i;
            return this;
        }

        /* renamed from: se */
        public C8038a mo33062se(int i) {
            this.iconRes = i;
            return this;
        }
    }

    /* renamed from: com.introvd.template.module.iap.c$b */
    public interface C8039b {
        /* renamed from: a */
        void mo30119a(Context context, String str, String str2, String str3, int i);
    }

    /* renamed from: a */
    public static void m23245a(Activity activity, String str, TextView textView, C8038a aVar) {
        View[] viewArr;
        if (aVar != null && m23249iL(str)) {
            if (aVar.dOl != null) {
                for (View view : aVar.dOl) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            }
            if (aVar.dOm != null) {
                aVar.dOm.setVisibility(0);
                aVar.dOm.setOnClickListener(null);
            }
            boolean z = dOa != null && dOa.isShowing();
            if (!z && aVar.bgQ > 0) {
                z = AdServiceProxy.execute(AdServiceProxy.getAdView, activity, Integer.valueOf(aVar.bgQ)) != null && !C8048e.aBe().isInChina();
            }
            if (dOb) {
                C8064m.aBv().mo33117b(textView, str);
                if (z) {
                    m23247b(activity, str, textView, aVar);
                } else {
                    m23248c(activity, str, textView, aVar);
                }
            } else if (z) {
                m23247b(activity, str, textView, aVar);
            } else {
                if (aVar.dOn == null) {
                    aVar.dOn = textView;
                }
                if (aVar.iconRes > 0) {
                    textView.setVisibility(8);
                    aVar.dOn.setVisibility(0);
                    aVar.dOn.setBackgroundResource(aVar.iconRes);
                    aVar.dOn.setEnabled(false);
                } else {
                    aVar.dOn.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(aVar.dOk);
                    textView.setBackgroundResource(aVar.dOi);
                    textView.setEnabled(false);
                }
            }
            AdServiceProxy.execute(AdServiceProxy.setEncourageAdFromPrefix, activity.getLocalClassName().contains("Simple") ? EditorRouter.ENTRANCE_EDIT : "single");
        }
    }

    /* renamed from: a */
    public static void m23246a(C8039b bVar) {
        dOc = bVar;
    }

    /* renamed from: b */
    private static void m23247b(final Activity activity, final String str, TextView textView, final C8038a aVar) {
        C80361 r0 = new OnClickListener() {
            public void onClick(View view) {
                if (C8035c.dOa != null && C8035c.dOa.isShowing() && !activity.isFinishing()) {
                    try {
                        C8035c.dOa.dismiss();
                    } catch (IllegalArgumentException e) {
                        C8048e.aBe().logException(e);
                    }
                }
                C7897a.m23022b(str, "Iap_Purchase_Template_Id", new String[0]);
                C8035c.dOa = C8049f.aBf().mo33100g(activity, aVar.bgQ, str);
                C8035c.bgQ = aVar.bgQ;
            }
        };
        if (aVar.dOn == null) {
            aVar.dOn = textView;
        }
        if (aVar.iconRes > 0) {
            textView.setVisibility(8);
            aVar.dOn.setVisibility(0);
            aVar.dOn.setBackgroundResource(aVar.iconRes);
            aVar.dOn.setOnClickListener(r0);
            return;
        }
        aVar.dOn.setVisibility(8);
        textView.setVisibility(0);
        textView.setText(aVar.dOk);
        textView.setBackgroundResource(aVar.dOi);
        textView.setOnClickListener(r0);
    }

    /* renamed from: c */
    private static void m23248c(final Activity activity, final String str, TextView textView, C8038a aVar) {
        textView.setVisibility(0);
        textView.setText(aVar.dOj);
        textView.setBackgroundResource(aVar.dOi);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7897a.m23022b(str, "Iap_Purchase_Template_Id", new String[0]);
                AdServiceProxy.execute(AdServiceProxy.recordAdTemplateClick, str, InAppPurchaseMetaData.IAP_KEY);
                String id = (C8048e.aBe().mo23650dG(str) ? C7825a.ANIM_TITLE : C7825a.ALL_TEMPLATE).getId();
                if (C8035c.dOc != null) {
                    C8035c.dOc.mo30119a(activity, "platinum", id, "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                } else {
                    C8049f.aBf().mo33097b(activity, "platinum", id, "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                }
            }
        });
        if (!C8049f.aBf().mo33077EO()) {
            textView.setBackgroundResource(aVar.dOg);
            textView.setTextColor(aVar.dOh);
        }
    }

    /* renamed from: iL */
    private static boolean m23249iL(String str) {
        if (!C8049f.aBf().isNeedToPurchase(str)) {
            return false;
        }
        return C8048e.aBe().mo23650dG(str) ? !C8072q.aBx().mo33072ku(C7825a.ANIM_TITLE.getId()) : C8049f.aBf().mo33101iL(str);
    }

    public static boolean isNeedToPurchase(String str) {
        return m23249iL(str);
    }

    public static void release() {
        if (dOa != null && dOa.isShowing()) {
            try {
                dOa.dismiss();
            } catch (IllegalArgumentException e) {
                C8048e.aBe().logException(e);
            }
        }
        dOa = null;
        AdServiceProxy.execute(AdServiceProxy.releasePosition, Integer.valueOf(bgQ));
    }
}
