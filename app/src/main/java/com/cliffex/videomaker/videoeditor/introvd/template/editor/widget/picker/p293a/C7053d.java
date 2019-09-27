package com.introvd.template.editor.widget.picker.p293a;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager.LayoutParams;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.imageloader.ImageLoader.SourceType;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.picker.C7047a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.widget.picker.a.d */
public class C7053d extends C1008a<C7057a> {
    private int cUw;
    private int cwZ = -1;
    private boolean drr;
    private boolean drs;
    private String drt = "";
    private boolean dru;
    private List<C7047a> drv = new ArrayList();
    /* access modifiers changed from: private */
    public C7052c drw;
    private Context mContext;

    /* renamed from: com.introvd.template.editor.widget.picker.a.d$a */
    static class C7057a extends C1034u {
        ImageView drA;
        ImageView drB;
        ImageView drC;
        TextView drD;

        C7057a(View view) {
            super(view);
            this.drD = (TextView) view.findViewById(R.id.collage_pic_item_other_album);
            this.drA = (ImageView) view.findViewById(R.id.collage_pic_item_cover);
            this.drB = (ImageView) view.findViewById(R.id.pic_item_focus_bg);
            this.drC = (ImageView) view.findViewById(R.id.pic_item_none);
        }
    }

    public C7053d(Context context, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.drr = z;
        this.drs = z2;
        this.dru = z3;
        this.cUw = DeviceInfo.getScreenSize(context).width - (context.getResources().getDimensionPixelSize(R.dimen.video_editor_collage_pic_space) * 4);
        this.cUw /= 5;
    }

    private void auL() {
        if (this.drs) {
            int i = 0;
            if (!TextUtils.isEmpty(this.drt) || !this.drr) {
                if (this.drv != null && this.drv.size() > 0) {
                    while (true) {
                        if (i >= this.drv.size()) {
                            break;
                        }
                        C7047a aVar = (C7047a) this.drv.get(i);
                        if (aVar != null && this.drt.equals(aVar.path)) {
                            mo30996qe(i);
                            break;
                        }
                        i++;
                    }
                }
                return;
            }
            mo30996qe(0);
        }
    }

    /* renamed from: R */
    public C7057a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C7057a(LayoutInflater.from(this.mContext).inflate(R.layout.editor_gallery_pic_item_layout, viewGroup, false));
    }

    /* renamed from: a */
    public void mo30992a(C7052c cVar) {
        this.drw = cVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C7057a aVar, int i) {
        LayoutParams layoutParams = (LayoutParams) aVar.itemView.getLayoutParams();
        int i2 = this.cUw;
        layoutParams.height = i2;
        layoutParams.width = i2;
        aVar.itemView.setLayoutParams(layoutParams);
        final C7047a aVar2 = (C7047a) this.drv.get(i);
        int i3 = 8;
        switch (aVar2.ckf) {
            case 0:
                aVar.drC.setVisibility(8);
                aVar.drD.setVisibility(8);
                aVar.drA.setVisibility(0);
                if (this.dru) {
                    aVar.drB.setImageResource(R.drawable.editor_icon_gallery_board_item_focus);
                } else {
                    aVar.drB.setImageResource(0);
                }
                ImageView imageView = aVar.drB;
                if (this.drs && aVar2.bFocus) {
                    i3 = 0;
                }
                imageView.setVisibility(i3);
                ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_pic_bg, aVar2.path, aVar.drA, SourceType.IMAGE);
                aVar.itemView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C7053d.this.mo30996qe(aVar.getAdapterPosition());
                        if (C7053d.this.drw != null) {
                            C7053d.this.drw.mo30963iT(aVar2.path);
                        }
                    }
                });
                return;
            case 1:
                aVar.drC.setVisibility(0);
                aVar.drD.setVisibility(8);
                aVar.drA.setVisibility(8);
                aVar.drB.setImageResource(0);
                ImageView imageView2 = aVar.drB;
                if (this.drs && aVar2.bFocus) {
                    i3 = 0;
                }
                imageView2.setVisibility(i3);
                aVar.itemView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C7053d.this.mo30996qe(aVar.getAdapterPosition());
                        if (C7053d.this.drw != null) {
                            C7053d.this.drw.auI();
                        }
                    }
                });
                return;
            case 2:
                aVar.drC.setVisibility(8);
                aVar.drD.setVisibility(0);
                aVar.drA.setVisibility(8);
                aVar.drB.setVisibility(8);
                aVar.itemView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (C7053d.this.drw != null) {
                            C7053d.this.drw.auJ();
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    public int getItemCount() {
        if (this.drv == null) {
            return 0;
        }
        return this.drv.size();
    }

    /* renamed from: hG */
    public void mo30994hG(boolean z) {
        this.dru = z;
        notifyItemChanged(this.cwZ);
    }

    /* renamed from: iW */
    public void mo30995iW(String str) {
        this.drt = str;
        auL();
    }

    /* renamed from: qe */
    public void mo30996qe(int i) {
        if (i >= 0 && i < this.drv.size() && i != this.cwZ && this.drs) {
            if (this.cwZ != -1) {
                ((C7047a) this.drv.get(this.cwZ)).bFocus = false;
                notifyItemChanged(this.cwZ);
            }
            ((C7047a) this.drv.get(i)).bFocus = true;
            notifyItemChanged(i);
            this.cwZ = i;
        }
    }

    public void setData(List<C7047a> list) {
        if (list != null) {
            this.drv.clear();
            if (this.drr) {
                this.drv.add(new C7047a(1, null, false));
            }
            this.drv.add(new C7047a(2, null, false));
            this.drv.addAll(list);
        }
        notifyDataSetChanged();
    }
}
