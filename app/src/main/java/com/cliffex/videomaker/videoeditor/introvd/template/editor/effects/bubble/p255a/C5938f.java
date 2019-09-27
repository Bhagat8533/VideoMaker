package com.introvd.template.editor.effects.bubble.p255a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.bubble.a.f */
public class C5938f extends C1008a<C5941b> {
    private Context bbr;
    private int brU;
    private int cJq = -1;
    /* access modifiers changed from: private */
    public C5940a cJr;
    private boolean cJs;
    private int cvc;
    private int cwZ = -1;
    public List<StyleCatItemModel> mItemInfoList;

    /* renamed from: pX */
    private LayoutInflater f3493pX;

    /* renamed from: com.introvd.template.editor.effects.bubble.a.f$a */
    public interface C5940a {
        /* renamed from: z */
        void mo28568z(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.effects.bubble.a.f$b */
    public static class C5941b extends C1034u {
        RelativeLayout bDs;
        DynamicLoadingImageView cJu;
        ImageView cJv;

        public C5941b(View view) {
            super(view);
        }
    }

    public C5938f(Context context, ArrayList<StyleCatItemModel> arrayList, boolean z) {
        this.f3493pX = LayoutInflater.from(context);
        this.bbr = context;
        this.brU = this.bbr.getResources().getColor(R.color.white_p10);
        this.cvc = this.bbr.getResources().getColor(R.color.transparent);
        this.mItemInfoList = arrayList;
        this.cJs = z;
    }

    /* renamed from: F */
    public C5941b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3493pX.inflate(R.layout.editor_effect_bubble_tab_item_layout, viewGroup, false);
        C5941b bVar = new C5941b(inflate);
        bVar.bDs = (RelativeLayout) inflate.findViewById(R.id.item_layout);
        bVar.cJu = (DynamicLoadingImageView) inflate.findViewById(R.id.item_icon);
        bVar.cJv = (ImageView) inflate.findViewById(R.id.iv_item_vip_flag);
        return bVar;
    }

    /* renamed from: a */
    public void mo28562a(C5940a aVar) {
        this.cJr = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5941b bVar, final int i) {
        bVar.bDs.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5938f.this.cJr != null) {
                    C5938f.this.cJr.mo28568z(view, i);
                }
            }
        });
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.mItemInfoList.get(i);
        if (styleCatItemModel != null) {
            String str = styleCatItemModel.strPath;
            if ("Giphy".equals(styleCatItemModel.ttid)) {
                bVar.cJu.setImageResource(R.drawable.editor_icon_effect_bubble_gif);
            } else if (!TextUtils.isEmpty(str)) {
                ImageLoader.loadImage(str, bVar.cJu);
            } else {
                bVar.cJu.setImageResource(this.cJs ? R.drawable.editor_icon_effect_subtitle_loading : R.drawable.editor_icon_effect_bubble_loading);
                if ("20160224184733".equals(styleCatItemModel.ttid)) {
                    bVar.cJu.setImageResource(R.drawable.editor_effect_bubble_dft_sticker_icon);
                } else if ("20160224184948".equals(styleCatItemModel.ttid)) {
                    bVar.cJu.setImageResource(R.drawable.editor_effect_bubble_dft_subtitle_icon);
                }
            }
            if (ajC() == i) {
                bVar.bDs.setBackgroundColor(this.brU);
            } else {
                bVar.bDs.setBackgroundColor(this.cvc);
            }
            String str2 = styleCatItemModel.ttid;
            boolean qq = "Giphy".equals(str2) ? false : C8739i.m25526qq(str2);
            if (C8739i.isNeedToPurchase(str2)) {
                bVar.cJv.setImageResource(R.drawable.editor_icon_vip_16_n);
                bVar.cJv.setVisibility(0);
            } else if (C8745n.m25561qv(str2) || "20160224184733".equals(str2) || (!C8739i.m25527qr(str2) && !qq)) {
                bVar.cJv.setVisibility(8);
            } else {
                bVar.cJv.setImageResource(R.drawable.editor_icon_lock_15_n);
                bVar.cJv.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C5941b bVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(bVar, i);
        } else if (((StyleCatItemModel) this.mItemInfoList.get(i)) != null) {
            if (ajC() == i) {
                bVar.bDs.setBackgroundColor(this.brU);
            } else {
                bVar.bDs.setBackgroundColor(this.cvc);
            }
        }
    }

    public int ajC() {
        return this.cwZ;
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    /* renamed from: kP */
    public void mo28566kP(int i) {
        this.cJq = this.cwZ;
        this.cwZ = i;
        notifyItemChanged(this.cJq, "");
        notifyItemChanged(this.cwZ, "");
    }
}
