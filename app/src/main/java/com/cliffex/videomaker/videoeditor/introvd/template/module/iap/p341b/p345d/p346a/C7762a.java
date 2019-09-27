package com.introvd.template.module.iap.p341b.p345d.p346a;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.dialog.C7893c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.b.d.a.a */
public abstract class C7762a extends C7893c {
    private static int dVP = -1;
    private static DisplayMetrics dVQ;
    private static Paint dVR = new Paint();
    private Map<String, C7764a> dVS = new HashMap();

    /* renamed from: com.introvd.template.module.iap.b.d.a.a$a */
    private static class C7764a {
        int dVT;
        int iconResId;

        private C7764a(int i, int i2) {
            this.iconResId = i;
            this.dVT = i2;
        }
    }

    public C7762a() {
        this.dVS.put("wx", new C7764a(R.drawable.iap_vip_icon_wechat, R.string.xiaoying_str_vip_wechat_pay));
        if (!C8048e.aBe().mo23615MG()) {
            this.dVS.put("alipay", new C7764a(R.drawable.iap_vip_icon_alipay, R.string.xiaoying_str_alipay_pay));
        }
    }

    /* renamed from: a */
    private View m22693a(Context context, ViewGroup viewGroup, String str) {
        C7764a aVar = (C7764a) this.dVS.get(str);
        if (aVar == null) {
            return null;
        }
        int i = 0;
        View inflate = LayoutInflater.from(context).inflate(R.layout.iap_vip_view_dialog_item_pay_chosen, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.iv_item_icon)).setImageResource(aVar.iconResId);
        ((TextView) inflate.findViewById(R.id.tv_item_name)).setText(aVar.dVT);
        int gv = m22697gv(context);
        List<String> lM = mo32636lM(str);
        if (lM != null && !lM.isEmpty()) {
            ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.ll_item_tags);
            for (String str2 : lM) {
                if (!TextUtils.isEmpty(str2)) {
                    i += m22696cd(context, str2);
                    if (gv <= i) {
                        break;
                    }
                    viewGroup2.addView(m22695b(context, viewGroup2, str2));
                }
            }
        }
        inflate.setOnClickListener(mo32637lN(str));
        return inflate;
    }

    /* renamed from: al */
    private int m22694al(Context context, int i) {
        if (dVQ == null) {
            dVQ = m22699gx(context);
        }
        return dVQ == null ? i : (int) ((((float) i) * dVQ.density) + 0.5f);
    }

    /* renamed from: b */
    private View m22695b(Context context, ViewGroup viewGroup, String str) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.iap_vip_view_dialog_pay_tag, viewGroup, false);
        textView.setText(str);
        return textView;
    }

    /* renamed from: cd */
    private int m22696cd(Context context, String str) {
        if (dVR == null) {
            dVR = new Paint();
        }
        dVR.setTextSize((float) m22694al(context, 10));
        return (int) (dVR.measureText(str) + ((float) m22694al(context, 18)));
    }

    /* renamed from: gv */
    private int m22697gv(Context context) {
        if (dVP > 0) {
            return dVP;
        }
        int gw = m22698gw(context);
        if (gw < 0) {
            return -1;
        }
        dVP = gw - m22694al(context, 78);
        return dVP;
    }

    /* renamed from: gw */
    private int m22698gw(Context context) {
        if (dVQ == null) {
            dVQ = m22699gx(context);
        }
        if (dVQ == null) {
            return -1;
        }
        return dVQ.widthPixels;
    }

    /* renamed from: gx */
    private DisplayMetrics m22699gx(Context context) {
        if (context == null || context.getResources() == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    /* renamed from: b */
    public View mo32634b(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.iap_vip_view_dialog_pay_head, viewGroup, false);
    }

    /* renamed from: c */
    public List<View> mo32635c(Context context, ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m22693a(context, viewGroup, "alipay"));
        arrayList.add(m22693a(context, viewGroup, "wx"));
        return arrayList;
    }

    /* renamed from: lM */
    public abstract List<String> mo32636lM(String str);

    /* renamed from: lN */
    public abstract OnClickListener mo32637lN(String str);
}
