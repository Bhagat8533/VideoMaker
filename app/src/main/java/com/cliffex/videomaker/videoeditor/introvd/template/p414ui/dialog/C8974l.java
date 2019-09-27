package com.introvd.template.p414ui.dialog;

import android.graphics.Typeface;
import android.support.p021v4.content.ContextCompat;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.exoplayer2.C3119C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.l */
public class C8974l extends C1008a<C8976b> {
    /* access modifiers changed from: private */
    public C8975a exY;
    /* access modifiers changed from: private */
    public List<CharSequence> mList;
    private int selectedIndex;

    /* renamed from: com.introvd.template.ui.dialog.l$a */
    public interface C8975a {
        /* renamed from: a */
        void mo24341a(View view, int i, CharSequence charSequence);
    }

    /* renamed from: com.introvd.template.ui.dialog.l$b */
    protected class C8976b extends C1034u {
        /* access modifiers changed from: private */
        public final RadioButton exZ;
        /* access modifiers changed from: private */
        public final TextView eya;

        public C8976b(View view) {
            super(view);
            this.exZ = (RadioButton) view.findViewById(C10122R.C10124id.control);
            this.eya = (TextView) view.findViewById(C10122R.C10124id.title);
            this.eya.setTextColor(ContextCompat.getColor(view.getContext(), C10122R.color.color_585858));
            try {
                this.eya.setTypeface(Typeface.create(C3119C.SANS_SERIF_NAME, 0));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            view.setOnClickListener(new OnClickListener(C8974l.this) {
                public void onClick(View view) {
                    if (!(C8974l.this.exY == null || C8974l.this.mList == null || C8974l.this.mList.size() <= C8976b.this.getAdapterPosition())) {
                        C8974l.this.exY.mo24341a(view, C8976b.this.getAdapterPosition(), (CharSequence) C8974l.this.mList.get(C8976b.this.getAdapterPosition()));
                    }
                    C8976b.this.exZ.setChecked(true);
                }
            });
        }
    }

    public C8974l(int i, CharSequence[] charSequenceArr) {
        this.selectedIndex = i;
        this.mList = new ArrayList(charSequenceArr.length);
        Collections.addAll(this.mList, charSequenceArr);
    }

    /* renamed from: vC */
    private CharSequence m26341vC(int i) {
        if (this.mList == null || this.mList.isEmpty()) {
            return null;
        }
        return (CharSequence) this.mList.get(i);
    }

    /* renamed from: a */
    public void mo35621a(C8975a aVar) {
        this.exY = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C8976b bVar, int i) {
        CharSequence vC = m26341vC(i);
        if (vC != null) {
            if (i == this.selectedIndex) {
                bVar.itemView.setSelected(true);
                bVar.exZ.setChecked(true);
            }
            bVar.eya.setText(vC);
        }
    }

    /* renamed from: ac */
    public C8976b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C8976b(LayoutInflater.from(viewGroup.getContext()).inflate(C10122R.C10126layout.xiaoying_com_dialog_listitem_singlechoice, viewGroup, false));
    }

    public int getItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }
}
