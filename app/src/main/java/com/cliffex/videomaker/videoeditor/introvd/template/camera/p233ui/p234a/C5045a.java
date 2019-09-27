package com.introvd.template.camera.p233ui.p234a;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.camera.p229b.C4989b.C4990a;
import com.introvd.template.vivacamera.R;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.a.a */
public class C5045a extends C1008a<C5047b> implements OnClickListener {
    private List<C4990a> bSa;
    private C5046a bSo;

    /* renamed from: com.introvd.template.camera.ui.a.a$a */
    public interface C5046a {
        /* renamed from: a */
        void mo25914a(View view, int i, C4990a aVar);
    }

    /* renamed from: com.introvd.template.camera.ui.a.a$b */
    protected static class C5047b extends C1034u {
        public TextView bSp;

        C5047b(View view) {
            super(view);
            this.bSp = (TextView) view.findViewById(R.id.item_tv_title);
        }
    }

    public C5045a(List<C4990a> list) {
        this.bSa = list;
    }

    /* renamed from: a */
    public void mo25910a(C5046a aVar) {
        this.bSo = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5047b bVar, int i) {
        if (i >= 0 && i < getItemCount()) {
            C4990a aVar = (C4990a) this.bSa.get(i);
            if (aVar.bPe > 0) {
                bVar.bSp.setText(aVar.bPe);
            } else {
                bVar.bSp.setText("");
            }
        }
        bVar.itemView.setTag(Integer.valueOf(i));
    }

    public int getItemCount() {
        return this.bSa.size();
    }

    /* renamed from: o */
    public C5047b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cam_recycler_item_modes, viewGroup, false);
        inflate.setOnClickListener(this);
        return new C5047b(inflate);
    }

    public void onClick(View view) {
        if (this.bSo != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < getItemCount()) {
                this.bSo.mo25914a(view, intValue, (C4990a) this.bSa.get(intValue));
            }
        }
    }
}
