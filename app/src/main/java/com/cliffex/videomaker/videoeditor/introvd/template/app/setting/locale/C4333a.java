package com.introvd.template.app.setting.locale;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.router.setting.LocaleModel;
import java.util.List;

/* renamed from: com.introvd.template.app.setting.locale.a */
public class C4333a extends C1008a<C4335a> {
    /* access modifiers changed from: private */
    public int bDh = -1;
    private Context mContext;
    private List<LocaleModel> mList;

    /* renamed from: com.introvd.template.app.setting.locale.a$a */
    class C4335a extends C1034u {
        public ImageView bDj;
        public TextView bzE;

        public C4335a(View view) {
            super(view);
            this.bzE = (TextView) view.findViewById(R.id.choose_name);
            this.bDj = (ImageView) view.findViewById(R.id.choose_icon);
        }
    }

    public C4333a(Context context) {
        this.mContext = context;
    }

    /* renamed from: PH */
    public int mo24382PH() {
        return this.bDh;
    }

    /* renamed from: a */
    public void onBindViewHolder(C4335a aVar, final int i) {
        if (this.mList != null && i < this.mList.size()) {
            aVar.bzE.setText(((LocaleModel) this.mList.get(i)).name);
            if (this.bDh == i) {
                aVar.bDj.setVisibility(0);
            } else {
                aVar.bDj.setVisibility(8);
            }
            aVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4333a.this.bDh = i;
                    C4333a.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: af */
    public void mo24384af(List<LocaleModel> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    /* renamed from: hE */
    public void mo24385hE(int i) {
        this.bDh = i;
        notifyDataSetChanged();
    }

    /* renamed from: n */
    public C4335a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C4335a(LayoutInflater.from(this.mContext).inflate(R.layout.community_recy_choose_language, viewGroup, false));
    }
}
