package com.introvd.template.editor.slideshow.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.base.QTextAnimationInfo;

/* renamed from: com.introvd.template.editor.slideshow.adapter.d */
public class C6749d extends C1008a<C6752c> {
    private Context context;
    /* access modifiers changed from: private */
    public int ddI = -1;
    /* access modifiers changed from: private */
    public List<QTextAnimationInfo> dfQ = new ArrayList();
    /* access modifiers changed from: private */
    public C6751b dfR;

    /* renamed from: com.introvd.template.editor.slideshow.adapter.d$a */
    private class C6750a implements OnClickListener {
        private int position;

        public C6750a(int i) {
            this.position = i;
        }

        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                QTextAnimationInfo qTextAnimationInfo = (QTextAnimationInfo) C6749d.this.dfQ.get(this.position);
                if (C6749d.this.ddI == this.position) {
                    if (C6749d.this.dfR != null) {
                        C6749d.this.dfR.mo30226a(this.position, qTextAnimationInfo);
                    }
                    return;
                }
                if (C6749d.this.dfR != null) {
                    C6749d.this.dfR.mo30227b(this.position, qTextAnimationInfo);
                }
                int b = C6749d.this.ddI;
                C6749d.this.ddI = this.position;
                C6749d.this.notifyItemChanged(b);
                C6749d.this.notifyItemChanged(C6749d.this.ddI);
            }
        }
    }

    /* renamed from: com.introvd.template.editor.slideshow.adapter.d$b */
    public interface C6751b {
        /* renamed from: a */
        void mo30226a(int i, QTextAnimationInfo qTextAnimationInfo);

        /* renamed from: b */
        void mo30227b(int i, QTextAnimationInfo qTextAnimationInfo);
    }

    /* renamed from: com.introvd.template.editor.slideshow.adapter.d$c */
    public static class C6752c extends C1034u {
        RelativeLayout ddK;
        TextView ddL;
        ImageView ddM;

        public C6752c(View view) {
            super(view);
        }
    }

    public C6749d(Context context2) {
        this.context = context2;
    }

    /* renamed from: O */
    public C6752c onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.editor_title_text_edit_item_layout, viewGroup, false);
        C6752c cVar = new C6752c(inflate);
        cVar.ddK = (RelativeLayout) inflate.findViewById(R.id.rl_editor_theme_title);
        cVar.ddL = (TextView) inflate.findViewById(R.id.tv_editor_theme_title);
        cVar.ddM = (ImageView) inflate.findViewById(R.id.iv_editor_theme_title_editflag);
        return cVar;
    }

    /* renamed from: a */
    public void mo30258a(C6751b bVar) {
        this.dfR = bVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C6752c cVar, int i) {
        cVar.ddL.setText(((QTextAnimationInfo) this.dfQ.get(i)).getText());
        if (this.ddI == i) {
            cVar.ddM.setVisibility(0);
            cVar.ddK.setBackgroundResource(R.drawable.editor_shape_theme_title_select_rounded_corner);
        } else {
            cVar.ddM.setVisibility(4);
            cVar.ddK.setBackgroundResource(R.drawable.editor_shape_theme_title_normal_rounded_corner);
        }
        cVar.ddK.setOnClickListener(new C6750a(i));
    }

    /* renamed from: bB */
    public void mo30260bB(List<QTextAnimationInfo> list) {
        this.dfQ = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dfQ.size();
    }

    /* renamed from: p */
    public void mo30261p(int i, String str) {
        if (i < this.dfQ.size()) {
            ((QTextAnimationInfo) this.dfQ.get(i)).setText(str);
            notifyItemChanged(i);
        }
    }
}
