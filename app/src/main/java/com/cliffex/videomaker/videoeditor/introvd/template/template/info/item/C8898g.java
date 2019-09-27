package com.introvd.template.template.info.item;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p408f.C8757g;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.template.info.item.g */
public class C8898g {
    public String cFb;
    private int esg = this.mContext.getResources().getColor(R.color.color_8d8d8d);
    protected Context mContext;
    protected Handler mHandler;

    /* renamed from: com.introvd.template.template.info.item.g$a */
    protected class C8903a {
        RelativeLayout cJe;
        DynamicLoadingImageView cpn;
        ImageView epF;
        Button epI;
        ImageView ero;
        View esi;

        protected C8903a() {
        }
    }

    public C8898g(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    private void m26127a(DynamicLoadingImageView dynamicLoadingImageView, String str) {
        ImageLoader.loadImage(m26128pR(str), dynamicLoadingImageView);
    }

    /* renamed from: pR */
    private static String m26128pR(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(" ", "%20");
    }

    /* renamed from: a */
    public void mo35447a(C8903a aVar) {
        if (C4580b.m11633Sg() || C8757g.aMp() || aVar.ero == null) {
            LayoutParams layoutParams = (LayoutParams) aVar.epI.getLayoutParams();
            layoutParams.width = C4583d.dpFloatToPixel(this.mContext, 40.0f);
            layoutParams.height = C4583d.dpFloatToPixel(this.mContext, 22.0f);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginEnd(0);
            } else {
                layoutParams.rightMargin = 0;
            }
            aVar.epI.setLayoutParams(layoutParams);
            aVar.epI.setVisibility(0);
            if (aVar.ero != null) {
                aVar.ero.setVisibility(4);
            }
            aVar.epI.setText(this.mContext.getResources().getString(R.string.xiaoying_str_template_state_apply));
            aVar.epI.setTextColor(-1);
            aVar.epI.setTextSize(2, 12.0f);
            aVar.epI.setGravity(17);
            aVar.epI.setBackgroundResource(aLN());
            return;
        }
        aVar.epI.setVisibility(4);
        if (aVar.ero != null) {
            aVar.ero.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35425a(C8903a aVar, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        sb.append("%");
        aVar.epI.setText(sb.toString());
        aVar.epI.setTextColor(this.esg);
        aVar.epI.setBackgroundResource(R.drawable.drawable_color_transparent);
    }

    /* renamed from: a */
    public void mo35448a(C8903a aVar, int i, HashMap<String, Integer> hashMap) {
        List aMe = C8733e.aMa().aMe();
        if (i >= 0 && i <= aMe.size() - 1) {
            TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
            if (templateInfo != null) {
                m26127a(aVar.cpn, templateInfo.strIcon);
                mo35449a(aVar, templateInfo, hashMap);
            }
            aVar.cJe.setTag(Integer.valueOf(i));
            aVar.cJe.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8898g.this.mHandler.sendMessage(C8898g.this.mHandler.obtainMessage(4097, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            aVar.cpn.setTag(Integer.valueOf(i));
            aVar.cpn.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8898g.this.mHandler.sendMessage(C8898g.this.mHandler.obtainMessage(4097, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            aVar.epI.setTag(Integer.valueOf(i));
            aVar.epI.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8898g.this.mHandler.sendMessage(C8898g.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            if (aVar.ero != null) {
                aVar.ero.setTag(Integer.valueOf(i));
                aVar.ero.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C8898g.this.mHandler.sendMessage(C8898g.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35426a(C8903a aVar, TemplateInfo templateInfo) {
        switch (templateInfo.nState) {
            case 1:
                aVar.epI.setBackgroundResource(aLL());
                return;
            case 2:
                aVar.epI.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                return;
            case 3:
                aVar.epI.setBackgroundResource(aLN());
                return;
            case 4:
                aVar.epI.setBackgroundResource(R.drawable.v4_xiaoying_com_template_btn_download_selector);
                return;
            case 5:
                aVar.epI.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                aVar.epI.setEnabled(false);
                return;
            case 6:
                aVar.epI.setBackgroundResource(aLO());
                aVar.epI.setEnabled(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo35449a(C8903a aVar, TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        if (aVar.esi != null) {
            if (C8739i.m25528qs(templateInfo.ttid)) {
                aVar.esi.setVisibility(0);
            } else {
                aVar.esi.setVisibility(8);
            }
        }
        if (C8739i.isNeedToPurchase(templateInfo.ttid)) {
            aVar.epF.setVisibility(0);
            aVar.epF.setImageResource(R.drawable.v5_xiaoying_template_iap_flag);
        } else if ((templateInfo.nMark & 1) == 1) {
            aVar.epF.setVisibility(0);
            aVar.epF.setImageResource(aLM());
        } else if ((templateInfo.nMark & 2) == 2) {
            aVar.epF.setVisibility(4);
            aVar.epF.setImageResource(R.drawable.xiaoying_com_template_mark_recommend);
        } else if ((templateInfo.nMark & 4) == 4) {
            aVar.epF.setVisibility(0);
            aVar.epF.setImageResource(R.drawable.v4_xiaoying_template_flag_hot);
        } else {
            aVar.epF.setVisibility(4);
        }
        aVar.epI.setEnabled(true);
        aVar.epI.setText("");
        if (hashMap.containsKey(templateInfo.ttid) && ((Integer) hashMap.get(templateInfo.ttid)).intValue() == 100) {
            if (C8735f.m25479qm(templateInfo.tcid) ? C8745n.m25561qv(templateInfo.ttid) : !TextUtils.isEmpty(C8762d.aMt().mo35225bB(C2575a.m7391rq(templateInfo.ttid)))) {
                templateInfo.nState = 3;
            }
        }
        if (C8735f.m25479qm(templateInfo.tcid) && C8745n.m25561qv(templateInfo.ttid)) {
            templateInfo.nState = 3;
        }
        mo35426a(aVar, templateInfo);
        if (TextUtils.isEmpty(templateInfo.strPreviewurl)) {
            aVar.epI.setFocusable(true);
        } else {
            aVar.epI.setFocusable(false);
        }
        mo35451b(aVar, templateInfo, hashMap);
    }

    /* access modifiers changed from: protected */
    public int aLL() {
        return R.drawable.v4_xiaoying_com_template_btn_download_selector;
    }

    /* access modifiers changed from: protected */
    public int aLM() {
        return R.drawable.v5_xiaoying_template_label_new;
    }

    /* access modifiers changed from: protected */
    public int aLN() {
        return R.drawable.v4_xiaoying_com_template_btn_apply_selector;
    }

    /* access modifiers changed from: protected */
    public int aLO() {
        return R.drawable.xiaoying_com_template_btn_downloaded;
    }

    public boolean aLQ() {
        return C8399c.ecX.equals(this.cFb);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35451b(C8903a aVar, TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        String str = templateInfo.ttid;
        if (templateInfo.nState == 6) {
            hashMap.put(str, Integer.valueOf(100));
        } else if (hashMap.containsKey(str) && ((Integer) hashMap.get(str)).intValue() > 0 && ((Integer) hashMap.get(str)).intValue() < 100) {
            mo35425a(aVar, ((Integer) hashMap.get(str)).intValue());
            templateInfo.nState = 8;
        } else if (templateInfo.nState == 8) {
            C8735f.aMf().mo35135C(templateInfo);
            mo35426a(aVar, templateInfo);
        }
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
