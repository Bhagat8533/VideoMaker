package com.introvd.template.template.info.p410a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8726b;
import com.introvd.template.template.p408f.C8757g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.b */
public class C8823b extends BaseAdapter {
    /* access modifiers changed from: private */
    public C8720b cvg;
    /* access modifiers changed from: private */
    public C8825b emN;
    /* access modifiers changed from: private */
    public Activity eoV;
    private ArrayList<TemplateInfo> eoW = new ArrayList<>();
    private boolean eoX = false;

    /* renamed from: com.introvd.template.template.info.a.b$a */
    class C8824a implements OnClickListener {
        C8826c eoY;
        TemplateInfo eoZ;

        public C8824a(C8826c cVar, TemplateInfo templateInfo) {
            this.eoY = cVar;
            this.eoZ = templateInfo;
        }

        public void onClick(View view) {
            if (view == this.eoY.epe) {
                if (C4600l.m11739k(C8823b.this.eoV, true)) {
                    C8823b.this.m25898a(this.eoY, this.eoZ);
                } else {
                    ToastUtils.show((Context) C8823b.this.eoV, R.string.xiaoying_str_com_msg_network_inactive, 1);
                }
            } else if (view == this.eoY.epf) {
                if (C8823b.this.emN != null && this.eoZ != null) {
                    C8823b.this.emN.mo35270r(this.eoZ);
                }
            } else if ((view == this.eoY.cpz || view.equals(this.eoY.eph)) && C8823b.this.emN != null && this.eoZ != null) {
                C8823b.this.emN.mo35269py(C8823b.this.cvg.mo35113qf(this.eoZ.ttid));
            }
        }
    }

    /* renamed from: com.introvd.template.template.info.a.b$b */
    public interface C8825b {
        /* renamed from: py */
        void mo35269py(String str);

        /* renamed from: r */
        void mo35270r(TemplateInfo templateInfo);
    }

    /* renamed from: com.introvd.template.template.info.a.b$c */
    class C8826c implements C8726b {
        TextView cpz;
        TextView epb;
        ProgressWheel epc;
        ImageView epd;
        ImageView epe;
        ImageView epf;
        ImageView epg;
        ImageView eph;
        TemplateInfo epi;

        C8826c() {
        }

        /* renamed from: gi */
        public boolean mo27537gi(String str) {
            if (str.equals(this.epi.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventSuc(C8823b.this.eoV, this.epi.ttid, "Template_Download_Font", "mc_list", this.epi.strTitle);
                this.epi.nState = 6;
                this.epe.setVisibility(8);
                this.epf.setVisibility(8);
                if (C4580b.m11633Sg() || C8757g.aMp()) {
                    this.cpz.setVisibility(0);
                    this.eph.setVisibility(4);
                } else {
                    this.eph.setVisibility(0);
                    this.cpz.setVisibility(4);
                }
                this.epc.setVisibility(8);
                this.epc.setProgress(0);
            }
            return false;
        }

        /* renamed from: gj */
        public boolean mo27538gj(String str) {
            if (str.equals(this.epi.ttid)) {
                UserEventDurationRelaUtils.finishDuraEventFail(C8823b.this.eoV, this.epi.ttid, "Template_Download_Font", "mc_list", this.epi.strTitle);
                this.epi.nState = 1;
                this.epe.setVisibility(0);
                this.epf.setVisibility(8);
                this.cpz.setVisibility(8);
                this.eph.setVisibility(8);
                this.epc.setVisibility(4);
                this.epc.setProgress(0);
                this.epc.setText("");
            }
            return false;
        }

        /* renamed from: u */
        public boolean mo27539u(String str, int i) {
            if (str.equals(this.epi.ttid)) {
                this.epi.nState = 8;
                this.epe.setVisibility(8);
                this.epc.setVisibility(0);
                this.epc.setProgress(i);
                ProgressWheel progressWheel = this.epc;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("%");
                progressWheel.setText(sb.toString());
            }
            return false;
        }

        /* renamed from: x */
        public void mo35323x(TemplateInfo templateInfo) {
            this.epi = templateInfo;
        }
    }

    public C8823b(Activity activity, C8720b bVar) {
        this.eoV = activity;
        this.cvg = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25898a(C8826c cVar, TemplateInfo templateInfo) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "font");
            hashMap.put("name", templateInfo.ttid);
            UserBehaviorLog.onKVEvent(this.eoV, "Template_Download_New", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.cvg != null) {
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(templateInfo.strUrl));
            this.cvg.mo35103a(templateInfo.ttid, (C8726b) cVar);
            this.cvg.mo35111qd(templateInfo.ttid);
        }
    }

    /* renamed from: a */
    public void mo35313a(C8825b bVar) {
        this.emN = bVar;
    }

    public boolean aLv() {
        return this.eoX;
    }

    public List<TemplateInfo> aLw() {
        return new ArrayList(this.eoW);
    }

    /* renamed from: cS */
    public void mo35316cS(List<TemplateInfo> list) {
        this.eoW.clear();
        if (list != null) {
            this.eoW.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.eoW.size();
    }

    public Object getItem(int i) {
        return this.eoW.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8826c cVar;
        View view2;
        TemplateInfo templateInfo = (TemplateInfo) this.eoW.get(i);
        if (view == null) {
            cVar = new C8826c();
            view2 = View.inflate(this.eoV, R.layout.v4_xiaoying_ve_subtitle_fontlistitem_layout, null);
            cVar.epd = (ImageView) view2.findViewById(R.id.font_name_img);
            cVar.epg = (ImageView) view2.findViewById(R.id.imgview_template_item_sep);
            cVar.epb = (TextView) view2.findViewById(R.id.layout_top_padding);
            cVar.epc = (ProgressWheel) view2.findViewById(R.id.template_pack_download_progress);
            cVar.epe = (ImageView) view2.findViewById(R.id.btn_download);
            cVar.epf = (ImageView) view2.findViewById(R.id.img_delete);
            cVar.cpz = (TextView) view2.findViewById(R.id.btn_apply);
            cVar.eph = (ImageView) view2.findViewById(R.id.template_imgview_apply);
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (C8826c) view.getTag();
        }
        if (i > 0) {
            cVar.epb.setVisibility(8);
        } else {
            cVar.epb.setVisibility(0);
        }
        int i2 = templateInfo.nState;
        cVar.mo35323x(templateInfo);
        if (this.eoX) {
            cVar.epe.setVisibility(8);
            cVar.epf.setVisibility(0);
            cVar.cpz.setVisibility(8);
            cVar.eph.setVisibility(8);
            cVar.epc.setVisibility(8);
            ImageLoader.loadImage((Context) this.eoV, templateInfo.strIcon, cVar.epd);
        } else if (i2 == 1) {
            cVar.epe.setVisibility(0);
            cVar.epf.setVisibility(8);
            cVar.cpz.setVisibility(8);
            cVar.eph.setVisibility(8);
            cVar.epc.setVisibility(0);
            cVar.epc.setProgress(0);
            cVar.epc.setText("");
        } else if (i2 == 6) {
            cVar.epe.setVisibility(8);
            cVar.epf.setVisibility(8);
            if (C4580b.m11633Sg() || C8757g.aMp()) {
                cVar.cpz.setVisibility(0);
                cVar.eph.setVisibility(4);
            } else {
                cVar.eph.setVisibility(0);
                cVar.cpz.setVisibility(4);
            }
            cVar.epc.setVisibility(8);
        } else if (i2 == 8) {
            int qa = this.cvg.mo35110qa(templateInfo.ttid);
            cVar.epe.setVisibility(8);
            cVar.epf.setVisibility(8);
            cVar.cpz.setVisibility(8);
            cVar.eph.setVisibility(8);
            cVar.epc.setVisibility(0);
            cVar.epc.setProgress(qa);
            ProgressWheel progressWheel = cVar.epc;
            StringBuilder sb = new StringBuilder();
            sb.append(qa);
            sb.append("%");
            progressWheel.setText(sb.toString());
        }
        C8824a aVar = new C8824a(cVar, templateInfo);
        cVar.cpz.setOnClickListener(aVar);
        cVar.eph.setOnClickListener(aVar);
        cVar.epe.setOnClickListener(aVar);
        cVar.epf.setOnClickListener(aVar);
        ImageLoader.loadImage((Context) this.eoV, templateInfo.strIcon, cVar.epd);
        return view2;
    }

    /* renamed from: jH */
    public void mo35321jH(boolean z) {
        this.eoX = z;
    }
}
