package com.introvd.template.module.iap.business;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import com.introvd.template.router.p377ad.AdServiceProxy;

/* renamed from: com.introvd.template.module.iap.business.d */
public class C7870d extends Dialog {
    private TextView bHR;
    private View cOt;
    /* access modifiers changed from: private */
    public String dNM = "close";
    /* access modifiers changed from: private */
    public TextView dPl;
    /* access modifiers changed from: private */
    public TextView dPm;
    /* access modifiers changed from: private */
    public boolean dPn = false;
    /* access modifiers changed from: private */
    public C7873a dPo;
    public String dPp = "-1";

    /* renamed from: po */
    private OnClickListener f3559po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C7870d.this.dPm)) {
                C7870d.this.dNM = "close";
                if (C7870d.this.isShowing()) {
                    C7870d.this.dismiss();
                }
            } else if (view.equals(C7870d.this.dPl)) {
                C7870d.this.dNM = "unlock";
                if (C7870d.this.dPo != null) {
                    C7870d.this.dPo.mo24962cl(C7870d.this.dPn);
                }
                if (C7870d.this.isShowing()) {
                    C7870d.this.dismiss();
                }
            }
        }
    };
    public String templateId = "unknown";

    /* renamed from: com.introvd.template.module.iap.business.d$a */
    public interface C7873a {
        /* renamed from: cl */
        void mo24962cl(boolean z);
    }

    public C7870d(Context context) {
        super(context, R.style.vivavideo_iap_dialog_com_style);
        this.cOt = LayoutInflater.from(context).inflate(R.layout.iap_ad_dialog_reward_com_content_layout, null);
        setContentView(this.cOt);
        this.bHR = (TextView) this.cOt.findViewById(R.id.reward_com_video_ad_description);
        this.dPl = (TextView) this.cOt.findViewById(R.id.reward_com_video_ad_fun_button);
        this.dPm = (TextView) this.cOt.findViewById(R.id.reward_com_video_ad_cancel_button);
        this.dPm.setOnClickListener(this.f3559po);
        this.dPl.setOnClickListener(this.f3559po);
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                AdServiceProxy.execute(AdServiceProxy.recordUnlockDialogClick, C7870d.this.templateId, C7870d.this.dNM, Boolean.valueOf(C7870d.this.dPn));
            }
        });
    }

    /* renamed from: a */
    public void mo32789a(C7873a aVar) {
        this.dPo = aVar;
    }

    /* renamed from: iE */
    public void mo32790iE(boolean z) {
        int i;
        int i2;
        this.dPn = z;
        if (z) {
            i = R.string.xiaoying_str_reward_video_ad_to_unlock_material_title;
            i2 = R.string.xiaoying_str_reward_video_ad_to_watch;
        } else {
            i = R.string.xiaoying_str_reward_video_ad_to_luckily_download_title;
            i2 = R.string.xiaoying_str_template_state_download;
        }
        this.bHR.setText(i);
        this.dPl.setText(i2);
    }
}
