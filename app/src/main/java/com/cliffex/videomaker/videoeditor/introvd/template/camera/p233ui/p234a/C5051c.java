package com.introvd.template.camera.p233ui.p234a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p208a.C4666e;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p242d.C5528b;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.p414ui.view.RotateProgressBar;
import com.introvd.template.p414ui.view.RotateTextView;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.vivacamera.R;
import java.util.HashMap;
import xiaoying.engine.base.QDisplayContext;

/* renamed from: com.introvd.template.camera.ui.a.c */
public class C5051c extends C1008a<C5053a> {
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
    private LayoutInflater f3426pX;

    /* renamed from: com.introvd.template.camera.ui.a.c$a */
    public static class C5053a extends C1034u {
        RotateImageView bSI;
        RotateImageView bSJ;
        RotateImageView bSK;
        RotateTextView bSL;
        RotateImageView bSM;
        RotateImageView bSN;
        RotateImageView bSO;
        RotateProgressBar bSP;
        RotateImageView bSQ;
        RelativeLayout bSy;

        public C5053a(View view) {
            super(view);
        }
    }

    public C5051c(Activity activity) {
        this.f3426pX = LayoutInflater.from(activity);
        this.bSr = activity;
    }

    /* renamed from: b */
    public static Bitmap m13298b(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    /* renamed from: a */
    public void mo25923a(C4666e eVar) {
        this.bSw = eVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5053a aVar, final int i) {
        int i2 = (this.bSt ? -1 : 0) + i;
        aVar.bSy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5051c.this.bSw != null) {
                    C5051c.this.bSw.mo24980w(view, i);
                }
            }
        });
        if (i2 == -1) {
            if (C5034e.m13250aq(this.bSr, C8399c.ecY)) {
                aVar.bSQ.setVisibility(0);
            } else {
                aVar.bSQ.setVisibility(4);
            }
            aVar.bSJ.setVisibility(0);
            aVar.bSI.setImageDrawable(null);
            aVar.bSM.setVisibility(4);
            aVar.bSN.setVisibility(4);
            aVar.bSO.setVisibility(4);
            aVar.bSP.setVisibility(4);
        } else {
            aVar.bSQ.setVisibility(4);
            if (this.bSv == null) {
                this.bSv = this.bOt.aMq();
            }
            if (this.bSv == null || !this.bOt.mo35214vh(i2).mPath.equals(this.bSv.mPath)) {
                aVar.bSy.setVisibility(0);
                EffectInfoModel vh = this.bOt.mo35214vh(i2);
                if (vh == null || !vh.isbNeedDownload()) {
                    aVar.bSO.setVisibility(4);
                } else {
                    aVar.bSO.setVisibility(0);
                }
                aVar.bSM.setVisibility(4);
                if (vh != null && !vh.isbNeedDownload()) {
                    aVar.bSN.setVisibility(4);
                    aVar.bSP.setVisibility(4);
                } else if (vh == null || !this.bSu.containsKey(Long.valueOf(vh.mTemplateId)) || ((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue() <= 0 || ((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue() >= 100) {
                    aVar.bSP.setVisibility(4);
                    aVar.bSN.setVisibility(0);
                } else {
                    aVar.bSN.setVisibility(4);
                    aVar.bSP.setVisibility(0);
                    aVar.bSP.setProgress(((Integer) this.bSu.get(Long.valueOf(vh.mTemplateId))).intValue());
                }
                aVar.bSJ.setVisibility(4);
                EffectInfoModel vh2 = this.bOt.mo35214vh(i2);
                Bitmap b = m13298b(this.bOt.mo35216vj(i2), 90);
                if (!(vh2 == null || b == null)) {
                    aVar.bSI.setImageBitmap(C4580b.m11641a(b, bSs));
                }
            } else {
                aVar.bSy.setVisibility(8);
                return;
            }
        }
        if (i2 != -1 && i2 == this.bSq && this.bSv == null) {
            aVar.bSK.setVisibility(0);
        } else {
            aVar.bSK.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void mo25925b(Long l, int i) {
        this.bSu.put(l, Integer.valueOf(i));
    }

    /* renamed from: db */
    public void mo25926db(boolean z) {
        this.bSt = z;
    }

    public int getItemCount() {
        return this.bOt.getCount() + (this.bSt ? 1 : 0);
    }

    public long getItemId(int i) {
        return 0;
    }

    /* renamed from: jt */
    public void mo25927jt(int i) {
        this.bSq = i;
    }

    /* renamed from: q */
    public C5053a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3426pX.inflate(R.layout.cam_recycler_item_pip_effect_hor, null);
        C5053a aVar = new C5053a(inflate);
        aVar.bSy = (RelativeLayout) inflate.findViewById(R.id.main_view);
        aVar.bSI = (RotateImageView) inflate.findViewById(R.id.wheel_img_content);
        aVar.bSJ = (RotateImageView) inflate.findViewById(R.id.wheel_more);
        aVar.bSK = (RotateImageView) inflate.findViewById(R.id.wheel_img_rect_f);
        aVar.bSL = (RotateTextView) inflate.findViewById(R.id.wheel_txt);
        aVar.bSM = (RotateImageView) inflate.findViewById(R.id.img_mission_flag);
        aVar.bSN = (RotateImageView) inflate.findViewById(R.id.img_download_flag);
        aVar.bSO = (RotateImageView) inflate.findViewById(R.id.img_mission_bg_mark);
        aVar.bSP = (RotateProgressBar) inflate.findViewById(R.id.download_progress);
        aVar.bSP.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
        aVar.bSQ = (RotateImageView) inflate.findViewById(R.id.img_new_flag);
        return aVar;
    }

    public void setEffectMgr(C8759b bVar) {
        this.bOt = bVar;
        this.bSv = this.bOt.aMq();
    }
}
