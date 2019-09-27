package com.introvd.template.app.school.template.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.api.model.VideoLabelInfo;

/* renamed from: com.introvd.template.app.school.template.view.b */
public class C4236b extends C4417b<VideoLabelInfo> {
    /* access modifiers changed from: private */
    public int bzB = 0;
    /* access modifiers changed from: private */
    public C4235a bzC;
    private Context mContext;

    /* renamed from: com.introvd.template.app.school.template.view.b$a */
    private class C4238a extends C4419b {
        /* access modifiers changed from: private */
        public TextView bzE;
        /* access modifiers changed from: private */
        public ImageView bzF;

        C4238a(View view) {
            super(view);
            this.bzE = (TextView) view.findViewById(R.id.tvName);
            this.bzF = (ImageView) view.findViewById(R.id.imgCursor);
        }
    }

    public C4236b(Context context) {
        this.mContext = context;
    }

    /* renamed from: ht */
    public void mo24224ht(int i) {
        this.bzB = i;
        notifyDataSetChanged();
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, final int i) {
        C4238a aVar = (C4238a) uVar;
        VideoLabelInfo videoLabelInfo = (VideoLabelInfo) getListItem(i, false);
        if (videoLabelInfo != null) {
            aVar.bzE.setText(videoLabelInfo.getName());
            aVar.bzF.setVisibility(this.bzB == i ? 0 : 8);
            if (this.bzB == i) {
                aVar.bzE.setTypeface(Typeface.defaultFromStyle(1));
                aVar.bzE.setTextSize(2, 18.0f);
                aVar.bzE.setSelected(true);
            } else {
                aVar.bzE.setTypeface(Typeface.defaultFromStyle(0));
                aVar.bzE.setTextSize(2, 16.0f);
                aVar.bzE.setSelected(false);
            }
            aVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C4236b.this.bzB != i) {
                        C4236b.this.bzB = i;
                        if (C4236b.this.bzC != null) {
                            C4236b.this.bzC.mo23825hk(C4236b.this.bzB);
                        }
                    }
                }
            });
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C4238a(LayoutInflater.from(this.mContext).inflate(R.layout.recy_template_title_item, viewGroup, false));
    }

    public void setTemplateLabelListener(C4235a aVar) {
        this.bzC = aVar;
    }
}
