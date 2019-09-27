package com.introvd.template.editor.preview.theme.themetitle;

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
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import java.util.List;

/* renamed from: com.introvd.template.editor.preview.theme.themetitle.a */
public class C6680a extends C1008a<C6683c> {
    /* access modifiers changed from: private */
    public List<EngineSubtitleInfoModel> dbY;
    /* access modifiers changed from: private */
    public C6682b ddH;
    /* access modifiers changed from: private */
    public int ddI = -1;

    /* renamed from: pX */
    private LayoutInflater f3513pX;

    /* renamed from: com.introvd.template.editor.preview.theme.themetitle.a$a */
    private class C6681a implements OnClickListener {
        private int position;

        public C6681a(int i) {
            this.position = i;
        }

        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                EngineSubtitleInfoModel engineSubtitleInfoModel = (EngineSubtitleInfoModel) C6680a.this.dbY.get(this.position);
                if (C6680a.this.ddI == this.position) {
                    if (C6680a.this.ddH != null) {
                        C6680a.this.ddH.mo30071a(this.position, engineSubtitleInfoModel);
                    }
                    return;
                }
                if (C6680a.this.ddH != null) {
                    C6680a.this.ddH.mo30072b(engineSubtitleInfoModel);
                }
                int b = C6680a.this.ddI;
                C6680a.this.ddI = this.position;
                C6680a.this.notifyItemChanged(b);
                C6680a.this.notifyItemChanged(C6680a.this.ddI);
            }
        }
    }

    /* renamed from: com.introvd.template.editor.preview.theme.themetitle.a$b */
    public interface C6682b {
        /* renamed from: a */
        void mo30071a(int i, EngineSubtitleInfoModel engineSubtitleInfoModel);

        /* renamed from: b */
        void mo30072b(EngineSubtitleInfoModel engineSubtitleInfoModel);
    }

    /* renamed from: com.introvd.template.editor.preview.theme.themetitle.a$c */
    public static class C6683c extends C1034u {
        RelativeLayout ddK;
        TextView ddL;
        ImageView ddM;

        public C6683c(View view) {
            super(view);
        }
    }

    public C6680a(Context context, List<EngineSubtitleInfoModel> list, C6682b bVar) {
        this.f3513pX = LayoutInflater.from(context);
        this.dbY = list;
        this.ddH = bVar;
    }

    /* renamed from: L */
    public C6683c onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3513pX.inflate(R.layout.editor_title_text_edit_item_layout, viewGroup, false);
        C6683c cVar = new C6683c(inflate);
        cVar.ddK = (RelativeLayout) inflate.findViewById(R.id.rl_editor_theme_title);
        cVar.ddL = (TextView) inflate.findViewById(R.id.tv_editor_theme_title);
        cVar.ddM = (ImageView) inflate.findViewById(R.id.iv_editor_theme_title_editflag);
        return cVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C6683c cVar, int i) {
        cVar.ddL.setText(((EngineSubtitleInfoModel) this.dbY.get(i)).mText);
        if (this.ddI == i) {
            cVar.ddM.setVisibility(0);
            cVar.ddK.setBackgroundResource(R.drawable.editor_shape_theme_title_select_rounded_corner);
        } else {
            cVar.ddM.setVisibility(4);
            cVar.ddK.setBackgroundResource(R.drawable.editor_shape_theme_title_normal_rounded_corner);
        }
        cVar.ddK.setOnClickListener(new C6681a(i));
    }

    public int getItemCount() {
        return this.dbY.size();
    }

    /* renamed from: p */
    public void mo30075p(int i, String str) {
        if (i < this.dbY.size()) {
            ((EngineSubtitleInfoModel) this.dbY.get(i)).mText = str;
            notifyItemChanged(i);
        }
    }
}
