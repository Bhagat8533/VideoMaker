package com.introvd.template.module.iap.business.home;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.p338b.C7686a;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.yan.rippledrawable.RippleLayout;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.iap.business.home.c */
public class C7971c extends Dialog implements OnClickListener {
    private View dTn;
    private TextView dTo;
    private GridView dTp;
    /* access modifiers changed from: private */
    public String dTq = "close";
    private String dTr;
    private C7980e dTs = new C7980e();
    private boolean dTt = C7686a.aAT();

    @SuppressLint({"ClickableViewAccessibility"})
    public C7971c(final Context context) {
        super(context, R.style.vivavideo_iap_dialog_com_style);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
        View inflate = LayoutInflater.from(context).inflate(this.dTt ? R.layout.iap_vip_dialog_home_help_viewv2 : R.layout.iap_vip_dialog_home_help_view, null);
        if (this.dTt) {
            m23154df(inflate);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.relativelayout_home_help);
        this.dTn = inflate.findViewById(R.id.imgbtn_help_exit);
        this.dTo = (TextView) inflate.findViewById(R.id.imgbtn_home_help_continue);
        this.dTp = (GridView) inflate.findViewById(R.id.vip_home_help_list);
        TextView textView = (TextView) inflate.findViewById(R.id.iap_tv_free_trial);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7971c.this.m23157gr(context);
            }
        });
        if (!C8048e.aBe().isInChina()) {
            textView.setVisibility(0);
            this.dTo.setVisibility(8);
            if (C8049f.aBf().mo33077EO()) {
                textView.setText(R.string.xiaoying_str_vip_home_free_trial);
            } else {
                textView.setText(R.string.xiaoying_str_slide_skip);
            }
            if (C8048e.aBe().isInChina() || !C8049f.aBf().aBl()) {
                C7897a.m23022b("Organic", "Iap_Non_Organic_Flag", new String[0]);
            } else {
                C7835b.aCQ();
                C7897a.m23022b("Non_Organic", "Iap_Non_Organic_Flag", new String[0]);
            }
        } else {
            this.dTo.setVisibility(0);
            textView.setVisibility(8);
            C7897a.m23022b("Organic", "Iap_Non_Organic_Flag", new String[0]);
        }
        m23156gq(context);
        this.dTo.setText(R.string.xiaoying_str_iap_dialog_setting_title);
        this.dTo.setOnClickListener(this);
        this.dTn.setOnClickListener(this);
        relativeLayout.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        setContentView(inflate);
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C7835b.m22853ca(C7971c.this.getContext(), C7971c.this.dTq);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: df */
    private void m23154df(View view) {
        view.findViewById(R.id.iap_tv_free_trial).setBackground(RippleLayout.m27639C(view.findViewById(R.id.iap_tv_free_trial).getBackground()));
        view.findViewById(R.id.imgbtn_home_help_continue).setBackground(RippleLayout.m27639C(view.findViewById(R.id.imgbtn_home_help_continue).getBackground()));
    }

    /* access modifiers changed from: private */
    /* renamed from: dg */
    public void m23155dg(View view) {
        C7979a aVar = (C7979a) view.getTag();
        if (aVar.dTA.getVisibility() != 0) {
            aVar.titleView.setGravity(17);
        } else {
            final TextView textView = aVar.titleView;
            textView.setGravity(8388611);
            if (!TextUtils.isEmpty(textView.getText())) {
                textView.post(new Runnable() {
                    public void run() {
                        Layout layout = textView.getLayout();
                        if (layout != null) {
                            String charSequence = textView.getText().subSequence(layout.getLineStart(0), layout.getLineEnd(0)).toString();
                            String replace = textView.getText().toString().replace(charSequence, "");
                            StringBuilder sb = new StringBuilder();
                            sb.append(charSequence.trim());
                            sb.append("\n");
                            sb.append(replace.trim());
                            textView.setText(sb.toString());
                        }
                    }
                });
            }
        }
    }

    /* renamed from: gq */
    private void m23156gq(Context context) {
        boolean z = this.dTt;
        if (!C8048e.aBe().mo23630Mv()) {
            this.dTr = C8070o.aBw();
        } else {
            this.dTr = "platinum";
        }
        C7993k kVar = new C7993k(z ? 1 : 0);
        final boolean z2 = z;
        C79754 r0 = new C7978d(context, kVar.aDm(), z ? R.layout.iap_vip_list_item_home_help_layoutv2 : R.layout.iap_vip_list_item_home_help_layout, z ? R.drawable.iap_vip_icon_function_support : R.drawable.iap_vip_icon_home_help_dialog_gold_flag) {
            public int getCount() {
                int count = super.getCount();
                return z2 ? Math.min(12, count) : count;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (z2) {
                    C7971c.this.m23155dg(view2);
                }
                return view2;
            }
        };
        this.dTp.setAdapter(r0);
        if (z) {
            this.dTp.setNumColumns(3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gr */
    public void m23157gr(Context context) {
        if (!C8049f.aBf().mo33077EO()) {
            cancel();
            return;
        }
        String aCH = this.dTs.aCH();
        if (TextUtils.isEmpty(aCH)) {
            cancel();
            return;
        }
        C7835b.m22861lq("tip");
        C8049f.aBf().mo33081a(context, aCH, null, new C9054a() {
            /* renamed from: a */
            public void mo32328a(PayResult payResult) {
                if (payResult.isSuccess()) {
                    C7971c.this.hide();
                }
            }
        });
    }

    /* renamed from: iK */
    public static void m23158iK(boolean z) {
        C7899c.aDg().setBoolean("home_dialog_shown", !z);
    }

    public void hide() {
        if (isShowing()) {
            try {
                dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void onClick(View view) {
        if (view.equals(this.dTn)) {
            this.dTq = "close";
            cancel();
        } else if (view.equals(this.dTo)) {
            this.dTq = "vip";
            C8049f.aBf().mo33097b(getContext(), this.dTr, null, "tip", -1);
            hide();
        }
    }

    public void show() {
        if (C7899c.aDg().getBoolean("home_dialog_shown", false)) {
            cancel();
            return;
        }
        C7899c.aDg().setBoolean("home_dialog_shown", true);
        if (C8048e.aBe().mo23612MD()) {
            this.dTs.aDo();
            if (!isShowing()) {
                HashMap hashMap = new HashMap();
                hashMap.put("media_source", C8049f.aBf().aBl() ? "non-organic" : "organic");
                C8048e.aBe().mo23653g("IAP_Tips_Show", hashMap);
                try {
                    super.show();
                } catch (BadTokenException e) {
                    C8048e.aBe().logException(e);
                }
            }
        }
    }
}
