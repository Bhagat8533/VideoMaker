package com.introvd.template.camera.p233ui.p234a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p208a.C4666e;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p242d.C5528b;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.vivacamera.R;
import java.util.HashMap;

/* renamed from: com.introvd.template.camera.ui.a.b */
public class C5048b extends C1008a<C5050a> {
    private static final int bSs = C5528b.cnR;
    private C8759b bOt;
    private int bSq = 0;
    private Activity bSr;
    private boolean bSt = false;
    private HashMap<Long, Integer> bSu = new HashMap<>();
    private EffectInfoModel bSv;
    /* access modifiers changed from: private */
    public C4666e bSw;

    /* renamed from: pX */
    private LayoutInflater f3424pX;

    /* renamed from: com.introvd.template.camera.ui.a.b$a */
    public static class C5050a extends C1034u {
        ImageView bSA;
        ImageView bSB;
        ImageView bSC;
        ImageView bSD;
        ImageView bSE;
        ProgressBar bSF;
        ImageView bSG;
        TextView bSp;
        RelativeLayout bSy;
        ImageView bSz;

        public C5050a(View view) {
            super(view);
        }
    }

    public C5048b(Activity activity) {
        this.f3424pX = LayoutInflater.from(activity);
        this.bSr = activity;
    }

    /* renamed from: a */
    public void mo25915a(C4666e eVar) {
        this.bSw = eVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5050a aVar, final int i) {
        int i2 = (this.bSt ? -1 : 0) + i;
        aVar.bSy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5048b.this.bSw != null) {
                    C5048b.this.bSw.mo24980w(view, i);
                }
            }
        });
        if (i2 == -1) {
            if (C5034e.m13250aq(this.bSr, C8399c.ecY)) {
                aVar.bSG.setVisibility(0);
            } else {
                aVar.bSG.setVisibility(4);
            }
            aVar.bSA.setVisibility(0);
            aVar.bSz.setImageDrawable(null);
            aVar.bSC.setVisibility(4);
            aVar.bSD.setVisibility(4);
            aVar.bSE.setVisibility(4);
            aVar.bSF.setVisibility(4);
        } else {
            aVar.bSG.setVisibility(4);
            if (this.bSv == null) {
                this.bSv = this.bOt.aMq();
            }
            if (this.bSv == null || !this.bOt.mo35214vh(i2).mPath.equals(this.bSv.mPath)) {
                aVar.bSy.setVisibility(0);
                EffectInfoModel vh = this.bOt.mo35214vh(i2);
                if (vh == null || !vh.isbNeedDownload()) {
                    aVar.bSE.setVisibility(4);
                } else {
                    aVar.bSE.setVisibility(0);
                }
                aVar.bSC.setVisibility(4);
                if (vh != null && !vh.isbNeedDownload()) {
                    aVar.bSD.setVisibility(4);
                    aVar.bSF.setVisibility(4);
                } else if (vh == null || !this.bSu.containsKey(Long.valueOf(vh.mTemplateId)) || ((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue() <= 0 || ((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue() >= 100) {
                    aVar.bSD.setVisibility(0);
                    aVar.bSF.setVisibility(4);
                } else {
                    aVar.bSD.setVisibility(4);
                    aVar.bSF.setVisibility(0);
                    aVar.bSF.setProgress(((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue());
                }
                aVar.bSA.setVisibility(4);
                EffectInfoModel vh2 = this.bOt.mo35214vh(i2);
                Bitmap vj = this.bOt.mo35216vj(i2);
                if (!(vh2 == null || vj == null)) {
                    aVar.bSz.setImageBitmap(C4580b.m11641a(vj, bSs));
                }
            } else {
                aVar.bSy.setVisibility(8);
                return;
            }
        }
        if (i2 != -1 && i2 == this.bSq && this.bSv == null) {
            aVar.bSB.setVisibility(0);
        } else {
            aVar.bSB.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void mo25917b(Long l, int i) {
        this.bSu.put(l, Integer.valueOf(i));
    }

    /* renamed from: db */
    public void mo25918db(boolean z) {
        this.bSt = z;
    }

    public int getItemCount() {
        return this.bOt.getCount() + (this.bSt ? 1 : 0);
    }

    /* renamed from: jt */
    public void mo25919jt(int i) {
        this.bSq = i;
    }

    /* renamed from: p */
    public C5050a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3424pX.inflate(R.layout.cam_recycler_item_pip_effect, null);
        C5050a aVar = new C5050a(inflate);
        aVar.bSy = (RelativeLayout) inflate.findViewById(R.id.main_view);
        aVar.bSz = (ImageView) inflate.findViewById(R.id.wheel_img_content);
        aVar.bSA = (ImageView) inflate.findViewById(R.id.wheel_more);
        aVar.bSB = (ImageView) inflate.findViewById(R.id.wheel_img_rect_f);
        aVar.bSp = (TextView) inflate.findViewById(R.id.wheel_txt);
        aVar.bSC = (ImageView) inflate.findViewById(R.id.img_mission_flag);
        aVar.bSD = (ImageView) inflate.findViewById(R.id.img_download_flag);
        aVar.bSE = (ImageView) inflate.findViewById(R.id.img_mission_bg_mark);
        aVar.bSF = (ProgressBar) inflate.findViewById(R.id.download_progress);
        aVar.bSG = (ImageView) inflate.findViewById(R.id.img_new_flag);
        return aVar;
    }

    public void setEffectMgr(C8759b bVar) {
        this.bOt = bVar;
        this.bSv = this.bOt.aMq();
    }
}
