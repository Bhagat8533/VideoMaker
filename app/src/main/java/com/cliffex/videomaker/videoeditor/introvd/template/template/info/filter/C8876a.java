package com.introvd.template.template.info.filter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.MSize;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8069n;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p408f.C8757g;
import java.util.HashMap;
import java.util.List;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.template.info.filter.a */
public class C8876a extends C1008a<C8877a> {
    public static int erb = 8;
    public static int erc = 3;
    public static int erd = 9;
    public static int ere = 6;
    MSize bVK;
    private boolean eoX = false;
    private HashMap<String, Integer> epk = new HashMap<>();
    private LayoutInflater erf;
    /* access modifiers changed from: private */
    public List<TemplateInfo> erg;
    /* access modifiers changed from: private */
    public HashMap<String, Integer> erh = new HashMap<>();
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.template.info.filter.a$a */
    class C8877a extends C1034u implements OnClickListener {
        TextView cpz;
        RelativeLayout eoC;
        TextView eoD;
        View eoE;
        RelativeLayout eri;
        ImageView erj;
        TextView erk;
        TextView erl;
        TextView erm;
        TextView ern;
        ImageView ero;
        TextView erp;
        ImageView erq;
        ProgressWheel err;
        View ers;

        public C8877a(View view) {
            super(view);
            this.eri = (RelativeLayout) view.findViewById(R.id.template_item);
            this.erj = (ImageView) view.findViewById(R.id.img_filter_itme_src);
            this.erk = (TextView) view.findViewById(R.id.tv_filter_item_title);
            this.erl = (TextView) view.findViewById(R.id.tv_filter_item_intro);
            this.erm = (TextView) view.findViewById(R.id.tv_filter_item_nums);
            this.ern = (TextView) view.findViewById(R.id.tv_filter_item_tag_new);
            this.cpz = (TextView) view.findViewById(R.id.template_filter_apply);
            this.ero = (ImageView) view.findViewById(R.id.template_imgview_apply);
            this.erp = (TextView) view.findViewById(R.id.template_filter_download);
            this.erq = (ImageView) view.findViewById(R.id.img_delete);
            this.err = (ProgressWheel) view.findViewById(R.id.template_pack_download_progress);
            this.eoC = (RelativeLayout) view.findViewById(R.id.template_iap_button_layout);
            this.eoE = view.findViewById(R.id.template_iap_icon);
            this.eoD = (TextView) view.findViewById(R.id.template_iap_present_price);
            this.ers = view.findViewById(R.id.filter_vip_flag);
            this.eoC.setOnClickListener(this);
            this.eri.setOnClickListener(this);
            this.erp.setOnClickListener(this);
            this.cpz.setOnClickListener(this);
            this.ero.setOnClickListener(this);
            this.erq.setOnClickListener(this);
        }

        public void onClick(View view) {
            Integer num = (Integer) view.getTag();
            if (view.getId() == R.id.template_item) {
                C8876a.this.mHandler.sendMessage(C8876a.this.mHandler.obtainMessage(4100, num.intValue(), 4101, null));
            } else if (view.getId() == R.id.template_filter_download) {
                C8876a.this.mHandler.sendMessage(C8876a.this.mHandler.obtainMessage(4100, num.intValue(), 4102, null));
                C8876a.this.erh.put(((TemplateInfo) C8876a.this.erg.get(num.intValue())).ttid, num);
            } else if (view.getId() == R.id.template_filter_apply || view.getId() == R.id.template_imgview_apply) {
                C8876a.this.mHandler.sendMessage(C8876a.this.mHandler.obtainMessage(4100, num.intValue(), 4103, null));
            } else if (view.getId() == R.id.img_delete) {
                C8876a.this.mHandler.sendMessage(C8876a.this.mHandler.obtainMessage(4100, num.intValue(), 4105, null));
            } else if (view.getId() == R.id.template_iap_button_layout) {
                C8876a.this.mHandler.sendMessage(C8876a.this.mHandler.obtainMessage(4100, num.intValue(), QEffect.PROP_AUDIO_FRAME_RANGE, null));
                C8876a.this.erh.put(((TemplateInfo) C8876a.this.erg.get(num.intValue())).ttid, num);
            }
        }
    }

    public C8876a(Context context, Handler handler) {
        this.mContext = context;
        this.erf = LayoutInflater.from(this.mContext);
        this.bVK = DeviceInfo.getScreenSize(this.mContext);
        this.mHandler = handler;
    }

    /* renamed from: a */
    private void m26092a(C8877a aVar, int i, String str) {
        aVar.eoC.setVisibility(8);
        if (i == 1) {
            aVar.erp.setVisibility(0);
            aVar.erp.setBackgroundResource(R.drawable.v5_xiaoying_template_filter_download);
            aVar.cpz.setVisibility(4);
            aVar.ero.setVisibility(4);
            aVar.err.setVisibility(4);
            if (C8739i.m25526qq(str)) {
                aVar.eoC.setVisibility(0);
                C8069n.m23424a(aVar.eoD, aVar.erp);
            } else if (C8739i.m25527qr(str)) {
                aVar.erp.setBackgroundResource(R.drawable.vivavideo_rate_lock3);
            }
        } else if (i == 3) {
            if (C4580b.m11633Sg() || C8757g.aMp()) {
                aVar.ero.setVisibility(4);
                aVar.cpz.setVisibility(0);
            } else {
                aVar.ero.setVisibility(0);
                aVar.cpz.setVisibility(4);
            }
            aVar.erp.setVisibility(4);
            aVar.err.setVisibility(4);
        } else if (i == 6) {
            if (C4580b.m11633Sg() || C8757g.aMp()) {
                aVar.ero.setVisibility(4);
                aVar.cpz.setVisibility(0);
            } else {
                aVar.ero.setVisibility(0);
                aVar.cpz.setVisibility(4);
            }
            aVar.erp.setVisibility(4);
            aVar.err.setVisibility(4);
        } else if (i == 8) {
            aVar.cpz.setVisibility(4);
            aVar.erp.setVisibility(4);
            aVar.err.setVisibility(0);
        }
        if (this.mContext instanceof Activity) {
            C8038a aVar2 = new C8038a();
            aVar2.mo33056rY(37).mo33054cY(aVar.eoC).mo33053a(aVar.erp, aVar.cpz).mo33055cZ(aVar.eoE).mo33062se(R.drawable.v5_xiaoying_template_filter_download).mo33059sb(R.drawable.v5_xiaoying_iap_filter_button_bg).mo33058sa(this.mContext.getResources().getColor(R.color.white_p40)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_filter_disable_bg);
            C8035c.m23245a((Activity) this.mContext, str, aVar.eoD, aVar2);
        }
    }

    /* renamed from: e */
    private int m26095e(RollInfo rollInfo) {
        if (rollInfo == null || rollInfo.rollModel == null || rollInfo.rollModel.mRollIconInfo == null || rollInfo.rollModel.mRollIconInfo.mXytList == null) {
            return 0;
        }
        return rollInfo.rollModel.mRollIconInfo.mXytList.size();
    }

    /* renamed from: Z */
    public C8877a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C8877a(this.erf.inflate(R.layout.v5_xiaoying_template_filter_item, null));
    }

    /* renamed from: a */
    public void onBindViewHolder(C8877a aVar, int i) {
        RollInfo rollInfo = (RollInfo) this.erg.get(i);
        LayoutParams layoutParams = (LayoutParams) aVar.eri.getLayoutParams();
        layoutParams.height = this.bVK.width / 2;
        aVar.eri.setLayoutParams(layoutParams);
        aVar.erk.setText(rollInfo.strTitle);
        if (rollInfo.rollModel.getRollScriptInfo() != null) {
            aVar.erl.setText(rollInfo.rollModel.getRollScriptInfo().rollSimpleIntro);
        }
        aVar.erq.setTag(Integer.valueOf(i));
        aVar.cpz.setTag(Integer.valueOf(i));
        aVar.ero.setTag(Integer.valueOf(i));
        aVar.erp.setTag(Integer.valueOf(i));
        aVar.eri.setTag(Integer.valueOf(i));
        aVar.eoC.setTag(Integer.valueOf(i));
        int e = m26095e(rollInfo);
        aVar.erm.setText(this.mContext.getResources().getQuantityString(R.plurals.xiaoying_str_meterial_filter_countdesc_plurals, e, new Object[]{Integer.valueOf(e)}));
        ImageLoader.loadImage(this.mContext, R.color.color_f0f2f5, rollInfo.strIcon, aVar.erj);
        aVar.ern.setVisibility(4);
        int i2 = rollInfo.nState;
        if (this.eoX) {
            aVar.erp.setVisibility(4);
            aVar.erq.setVisibility(0);
            aVar.cpz.setVisibility(4);
            aVar.ero.setVisibility(4);
            aVar.eoC.setVisibility(8);
            aVar.err.setVisibility(4);
        } else {
            if (rollInfo.rollModel.mNewFlag == 1) {
                aVar.ern.setVisibility(0);
            }
            aVar.erq.setVisibility(4);
            mo35408a(rollInfo.ttid, aVar);
            m26092a(aVar, i2, rollInfo.ttid);
        }
        if (C8739i.isNeedToPurchase(rollInfo.ttid)) {
            aVar.ers.setVisibility(0);
        } else {
            aVar.ers.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo35408a(String str, C8877a aVar) {
        if (aVar.err != null && this.epk.containsKey(str)) {
            aVar.err.setProgress(((Integer) this.epk.get(str)).intValue());
        }
    }

    /* renamed from: a */
    public void mo35409a(List<TemplateInfo> list, boolean z, boolean z2) {
        this.eoX = z2;
        this.erg = list;
        notifyDataSetChanged();
    }

    public boolean aLv() {
        return this.eoX;
    }

    public int getItemCount() {
        if (this.erg == null) {
            return 0;
        }
        return this.erg.size();
    }

    /* renamed from: h */
    public void mo35411h(String str, int i, int i2) {
        this.epk.put(str, Integer.valueOf(i));
        if (!(this.erh == null || this.erg == null)) {
            if (!this.erh.containsKey(str)) {
                int pP = mo35413pP(str);
                if (pP >= 0 && pP < this.erg.size()) {
                    this.erh.put(str, Integer.valueOf(pP));
                }
            }
            if (this.erh.containsKey(str)) {
                Integer num = (Integer) this.erh.get(str);
                if (num.intValue() < this.erg.size()) {
                    TemplateInfo templateInfo = (TemplateInfo) this.erg.get(num.intValue());
                    if (templateInfo != null) {
                        if (i2 == erb) {
                            templateInfo.nState = 8;
                        } else if (i2 == erc) {
                            templateInfo.nState = 3;
                        } else if (i2 == erd) {
                            templateInfo.nState = 1;
                        } else if (i2 == ere) {
                            templateInfo.nState = 1;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: pJ */
    public void mo35412pJ(String str) {
        int pP = mo35413pP(str);
        if (pP >= 0) {
            notifyItemChanged(pP);
        }
    }

    /* renamed from: pP */
    public int mo35413pP(String str) {
        if (this.erg != null && this.erg.size() > 0) {
            int i = -1;
            for (TemplateInfo templateInfo : this.erg) {
                if (TextUtils.equals(str, templateInfo.ttid)) {
                    return i + 1;
                }
                i++;
            }
        }
        return -1;
    }
}
