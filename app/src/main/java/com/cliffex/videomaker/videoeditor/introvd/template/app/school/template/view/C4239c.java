package com.introvd.template.app.school.template.view;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p176a.C3676a;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.common.Constants;
import com.introvd.template.common.p236ui.LoadingMoreFooterView;
import com.introvd.template.p203b.C4583d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.app.school.template.view.c */
public class C4239c extends C4417b<TemplateInfo> {
    private String byO;
    private boolean byW;
    private int bzI;
    private C4241a bzJ;
    private Context mContext;

    /* renamed from: com.introvd.template.app.school.template.view.c$a */
    public interface C4241a {
        /* renamed from: Om */
        void mo24177Om();
    }

    /* renamed from: com.introvd.template.app.school.template.view.c$b */
    private class C4242b extends C4419b {
        LoadingMoreFooterView bzL;
        TextView bzM;
        C4241a bzN;

        public C4242b(View view) {
            super(view);
            this.bzL = (LoadingMoreFooterView) view.findViewById(R.id.footer_normal_view);
            this.bzM = (TextView) view.findViewById(R.id.footer_feedback_textview);
            m10630OB();
            m10631OC();
            m10632OD();
        }

        /* renamed from: OB */
        private void m10630OB() {
            this.bzL.setStatus(0);
        }

        /* renamed from: OC */
        private void m10631OC() {
            String string = this.bzM.getContext().getResources().getString(R.string.xiaoying_creator_template_feedback_text_a);
            String string2 = this.bzM.getContext().getResources().getString(R.string.xiaoying_creator_template_feedback_text_b);
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(string2);
            String sb2 = sb.toString();
            SpannableString spannableString = new SpannableString(sb2);
            spannableString.setSpan(new ForegroundColorSpan(this.bzM.getContext().getResources().getColor(R.color.color_ff6333)), Math.max(sb2.lastIndexOf(63), sb2.lastIndexOf(65311)) + 1, spannableString.length(), 33);
            this.bzM.setText(spannableString);
        }

        /* renamed from: OD */
        private void m10632OD() {
            this.bzM.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C4242b.this.bzN != null) {
                        C4242b.this.bzN.mo24177Om();
                    }
                }
            });
        }

        /* renamed from: a */
        public void mo24231a(C4241a aVar) {
            this.bzN = aVar;
        }
    }

    /* renamed from: com.introvd.template.app.school.template.view.c$c */
    class C4244c extends C1034u {
        /* access modifiers changed from: private */
        public DynamicLoadingImageView bzP;
        private ImageView bzQ;
        /* access modifiers changed from: private */
        public TextView bzR;
        private TextView bzS;
        /* access modifiers changed from: private */
        public RelativeLayout bzT;

        public C4244c(View view) {
            super(view);
            this.bzP = (DynamicLoadingImageView) view.findViewById(R.id.template_item_img);
            this.bzQ = (ImageView) view.findViewById(R.id.template_item_vip_icon);
            this.bzR = (TextView) view.findViewById(R.id.template_desc);
            this.bzS = (TextView) view.findViewById(R.id.template_item_not_free);
            this.bzT = (RelativeLayout) view.findViewById(R.id.template_item_rl);
        }
    }

    public C4239c(Context context, String str, boolean z) {
        this.mContext = context;
        this.byO = str;
        this.byW = z;
    }

    /* renamed from: bH */
    private int m10625bH(int i, int i2) {
        return (i == 0 || i2 == 0) ? C4583d.m11673ii(300) : (int) (((((float) i2) * 1.0f) / ((float) i)) * ((float) ((Constants.getScreenSize().width - C4583d.m11673ii(30)) / 2)));
    }

    /* renamed from: a */
    public void mo24227a(C4241a aVar) {
        this.bzJ = aVar;
    }

    /* renamed from: hu */
    public void mo24228hu(int i) {
        this.bzI = i;
    }

    /* renamed from: hv */
    public void mo24229hv(int i) {
        mo24228hu(i);
        if (getItemCount() > 0) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public boolean isSupportFooterItem() {
        return true;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
        C4242b bVar = (C4242b) uVar;
        ((LayoutParams) bVar.itemView.getLayoutParams()).mo8370ap(true);
        bVar.bzL.setStatus(this.bzI);
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, final int i) {
        C4244c cVar = (C4244c) uVar;
        TemplateInfo templateInfo = (TemplateInfo) this.mList.get(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.bzT.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cVar.bzP.getLayoutParams();
        int bH = m10625bH(templateInfo.getWidth(), templateInfo.getHeight());
        layoutParams2.height = bH;
        layoutParams.height = bH;
        cVar.bzP.setImageURI(templateInfo.getCoverUrl());
        cVar.bzR.setText(templateInfo.getTitle());
        cVar.bzP.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C4239c.this.mListener != null) {
                    C4239c.this.mListener.onItemClicked(i);
                }
            }
        });
        C3676a.m8968d(this.mContext, this.byO, templateInfo.getTtid());
        C4205m.m10499Q(templateInfo.getTtid(), this.byW ? "创作页" : "更多");
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        C4242b bVar = new C4242b(LayoutInflater.from(this.mContext).inflate(R.layout.app_adapter_template_has_feedback_footer_item, viewGroup, false));
        bVar.mo24231a(this.bzJ);
        return bVar;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C4244c(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_template_list_item, viewGroup, false));
    }
}
