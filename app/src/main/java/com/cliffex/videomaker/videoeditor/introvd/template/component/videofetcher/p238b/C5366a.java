package com.introvd.template.component.videofetcher.p238b;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p240d.C5409f;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.view.FetcherRoundView;
import java.util.List;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.b.a */
public class C5366a extends C1008a<C5368a> {
    /* access modifiers changed from: private */
    public List<C5391a> cjh;
    private final long cji = 100;
    private final long cjj = -1;
    /* access modifiers changed from: private */
    public C5409f cjk;
    private Context mContext;

    /* renamed from: com.introvd.template.component.videofetcher.b.a$a */
    public class C5368a extends C1034u {
        /* access modifiers changed from: private */
        public final FetcherRoundView cjm;
        /* access modifiers changed from: private */
        public final TextView cjn;
        /* access modifiers changed from: private */
        public final TextView cjo;

        public C5368a(View view) {
            super(view);
            this.cjm = (FetcherRoundView) view.findViewById(R.id.download_bt);
            this.cjn = (TextView) view.findViewById(R.id.download_name);
            this.cjo = (TextView) view.findViewById(R.id.download_size);
        }
    }

    public C5366a(Context context) {
        this.mContext = context;
    }

    /* renamed from: jU */
    private C5391a m14609jU(int i) {
        if (this.cjh == null || this.cjh.isEmpty() || this.cjh.size() <= i) {
            return null;
        }
        return (C5391a) this.cjh.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(C5368a aVar, final int i) {
        C5391a jU = m14609jU(i);
        if (jU != null) {
            if (!TextUtils.isEmpty(jU.getName())) {
                aVar.cjn.setText(jU.getName());
            }
            if (!TextUtils.isEmpty(jU.mo26976ZN())) {
                aVar.cjo.setText(jU.mo26976ZN());
            }
            if (jU.ckb == -1 || jU.ckb == 100) {
                aVar.cjm.setText(this.mContext.getString(R.string.video_fetcher_str_download));
            } else {
                FetcherRoundView c = aVar.cjm;
                StringBuilder sb = new StringBuilder();
                sb.append(jU.ckb);
                sb.append("%");
                c.setText(sb.toString());
            }
            aVar.cjm.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C5485c.m14891bM(HttpStatus.SC_INTERNAL_SERVER_ERROR, view.hashCode()) && C5366a.this.cjk != null && C5366a.this.cjh != null && !C5366a.this.cjh.isEmpty() && C5366a.this.cjh.size() > i) {
                        C5366a.this.cjk.mo27036a(i, (FetcherRoundView) view, (C5391a) C5366a.this.cjh.get(i));
                    }
                }
            });
        }
    }

    /* renamed from: aC */
    public void mo26937aC(List<C5391a> list) {
        this.cjh = list;
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void mo26938b(String str, Long l) {
        if (this.cjh != null && !this.cjh.isEmpty()) {
            if (this.cjh.size() == 1) {
                C5391a aVar = (C5391a) this.cjh.get(0);
                if (str.equals(aVar.getName())) {
                    aVar.ckb = l.longValue();
                    notifyItemChanged(0);
                    return;
                }
                return;
            }
            for (C5391a aVar2 : this.cjh) {
                if (str.equals(aVar2.getName())) {
                    aVar2.ckb = l.longValue();
                    int indexOf = this.cjh.indexOf(aVar2);
                    if (indexOf > -1 && indexOf < this.cjh.size()) {
                        notifyItemChanged(indexOf);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public int getItemCount() {
        if (this.cjh == null) {
            return 0;
        }
        return this.cjh.size();
    }

    /* renamed from: s */
    public C5368a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5368a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_ppw_download_item, viewGroup, false));
    }

    public void setItemClickListener(C5409f fVar) {
        this.cjk = fVar;
    }
}
