package com.introvd.template.module.p326ad.p337i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7595e;
import com.introvd.template.module.p326ad.p328b.C7596f;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.p377ad.AdServiceProxy;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.introvd.template.module.ad.i.c */
public class C7670c extends AlertDialog {
    private ViewAdsListener bFF = new ViewAdsListener() {
        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            C7670c.this.aAI();
        }
    };
    private int bgQ;
    private View bwy;
    private View cOt;
    /* access modifiers changed from: private */
    public Context context;
    private View dNF;
    private ViewGroup dNG;
    private View dNK;
    /* access modifiers changed from: private */
    public String dNM = "close";
    private String dNw;
    /* access modifiers changed from: private */
    public String templateId = "";

    public C7670c(Context context2, final int i, final String str) {
        super(context2, R.style.vivavideo_iap_dialog_com_style);
        this.context = context2;
        this.bgQ = i;
        this.dNw = str;
        initUI();
        AdServiceProxy.execute(AdServiceProxy.setAdListener, Integer.valueOf(i), this.bFF);
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C10021c.aZH().mo38496az(C7670c.this);
                if (i == 37 || i == 36 || i == 34) {
                    if (i == 34) {
                        C7670c.this.templateId = "all_template";
                    } else {
                        C7670c.this.templateId = (String) IapServiceProxy.execute(IapServiceProxy.getTemplateId, str);
                    }
                    C7595e.m22386av(C7670c.this.templateId, C7670c.this.dNM);
                    C7680l.aAe().releasePosition(i, false);
                }
            }
        });
    }

    /* renamed from: V */
    public static Integer m22495V(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf(((String) obj).trim());
            } catch (Exception e) {
                C7678j.aAd().logException(e);
                return null;
            }
        } else if (obj instanceof Integer) {
            return (Integer) obj;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void aAI() {
        if (this.dNK != null) {
            C7591a.m22378kh("Ad_Install_Show");
            aAJ();
            if (this.cOt != this.dNK) {
                this.cOt = this.dNK;
            }
            ViewGroup viewGroup = (ViewGroup) this.dNK.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            if (this.dNG != null) {
                this.dNG.removeAllViews();
                this.dNG.addView(this.dNK);
            }
        }
    }

    private void aAJ() {
        String str;
        String str2;
        View findViewById = this.bwy.findViewById(R.id.encourage_purchase_btn);
        View findViewById2 = this.bwy.findViewById(R.id.ad_parting_line);
        if (C7678j.aAd().mo23619Mk() || C7678j.aAd().isInChina()) {
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C7670c.this.dNM = "vip";
                    if ((C7670c.this.context instanceof Activity) && !((Activity) C7670c.this.context).isFinishing()) {
                        IapServiceProxy.launchVipHome(C7670c.this.context, 14, "encourage", IapRTConstants.REQUEST_CODE_FOR_VIP);
                        C7670c.this.dismiss();
                    }
                }
            });
            findViewById2.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
        Integer V = m22495V(AdParamMgr.getExtraInfoByKey(36, "availabletime"));
        if (this.bgQ == 42) {
            str2 = "3";
            str = getContext().getString(R.string.xiaoying_str_encourage_remove_ad_description, new Object[]{str2});
        } else {
            str2 = (V == null || V.intValue() == 0) ? "7" : V.toString();
            str = getContext().getString(R.string.xiaoying_str_encourage_template_description, new Object[]{str2});
        }
        TextView textView = (TextView) this.bwy.findViewById(R.id.encourage_title);
        if (textView != null) {
            textView.setText(getContext().getString(R.string.xiaoying_str_encourage_template_duration, new Object[]{str2}));
        }
        TextView textView2 = (TextView) this.bwy.findViewById(R.id.encourage_description);
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    private void initUI() {
        this.bwy = LayoutInflater.from(this.context).inflate((this.bgQ == 34 || this.bgQ == 37 || this.bgQ == 36 || this.bgQ == 42) ? R.layout.iap_vip_dialog_encourage_template_layout : 0, null);
        this.dNF = this.bwy.findViewById(R.id.exit_dialog_exit_button);
        this.dNG = (ViewGroup) this.bwy.findViewById(R.id.exit_dialog_content_layout);
        this.dNF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if ((C7670c.this.context instanceof Activity) && !((Activity) C7670c.this.context).isFinishing() && C7670c.this.isShowing()) {
                    C7670c.this.dismiss();
                }
            }
        });
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEvent(C7596f fVar) {
        if (this.dNF != null) {
            this.dNF.performClick();
        }
    }

    public void show() {
        try {
            if (this.context instanceof Activity) {
                if (!((Activity) this.context).isFinishing()) {
                    this.dNK = (View) AdServiceProxy.execute(AdServiceProxy.getAdView, getContext(), Integer.valueOf(this.bgQ));
                    if (this.dNK != null) {
                        C7680l.aAe().mo32531h(this.bgQ, this.bFF);
                        C10021c.aZH().mo38494ax(this);
                        super.show();
                        aAI();
                        setContentView(this.bwy);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
