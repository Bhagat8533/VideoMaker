package com.introvd.template.component.videofetcher.p238b;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5395e;
import com.introvd.template.component.videofetcher.utils.C5485c;
import java.util.List;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.b.c */
public class C5373c extends C1008a<C5375b> {
    /* access modifiers changed from: private */
    public List<C5395e> cjy;
    /* access modifiers changed from: private */
    public C5374a cjz;

    /* renamed from: com.introvd.template.component.videofetcher.b.c$a */
    public interface C5374a {
        /* renamed from: a */
        void mo26953a(int i, C5395e eVar);
    }

    /* renamed from: com.introvd.template.component.videofetcher.b.c$b */
    public class C5375b extends C1034u implements OnClickListener {
        /* access modifiers changed from: private */
        public final TextView cjA;
        /* access modifiers changed from: private */
        public final ImageView cjB;

        public C5375b(View view) {
            super(view);
            this.cjA = (TextView) view.findViewById(R.id.share_item_title);
            this.cjB = (ImageView) view.findViewById(R.id.share_item_iv);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (!C5485c.m14893ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && C5373c.this.cjz != null && C5373c.this.cjy != null && C5373c.this.cjy.size() > getAdapterPosition()) {
                C5373c.this.cjz.mo26953a(getAdapterPosition(), (C5395e) C5373c.this.cjy.get(getAdapterPosition()));
            }
        }
    }

    /* renamed from: a */
    public void mo26949a(C5374a aVar) {
        this.cjz = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5375b bVar, int i) {
        C5395e eVar = (C5395e) this.cjy.get(i);
        bVar.cjB.setImageResource(eVar.mo27000ZS());
        bVar.cjA.setText(eVar.getTitle());
    }

    /* renamed from: aC */
    public void mo26951aC(List<C5395e> list) {
        this.cjy = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.cjy == null) {
            return 0;
        }
        return this.cjy.size();
    }

    /* renamed from: u */
    public C5375b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5375b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_share_item, viewGroup, false));
    }
}
