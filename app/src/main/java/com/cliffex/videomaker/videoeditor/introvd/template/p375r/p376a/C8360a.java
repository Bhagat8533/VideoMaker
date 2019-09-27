package com.introvd.template.p375r.p376a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.introvd.template.r.a.a */
public abstract class C8360a<T> extends C1008a<C8363b> {
    private int cwZ = -1;
    /* access modifiers changed from: private */
    public C8362a ejQ;
    private int ejR;
    private Context mContext;
    public List<T> mItemInfoList;

    /* renamed from: com.introvd.template.r.a.a$a */
    public interface C8362a {
        /* renamed from: z */
        void mo27631z(View view, int i);
    }

    /* renamed from: com.introvd.template.r.a.a$b */
    public static class C8363b extends C1034u {
        private SparseArray<View> bvE = new SparseArray<>();
        View bvF;
        public int flag;

        public C8363b(View view) {
            super(view);
            this.bvF = view;
        }

        public View akM() {
            return this.bvF;
        }

        /* renamed from: n */
        public View mo33625n(int i) {
            View view = (View) this.bvE.get(i);
            if (view != null) {
                return view;
            }
            View findViewById = this.bvF.findViewById(i);
            this.bvE.put(i, findViewById);
            return findViewById;
        }
    }

    public C8360a(Context context) {
        this.mContext = context;
    }

    public C8360a(Context context, List<T> list) {
        this.mContext = context;
        this.mItemInfoList = list;
    }

    /* renamed from: Y */
    public C8363b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(this.ejR, null);
        if (inflate != null) {
            return new C8363b(inflate);
        }
        return null;
    }

    /* renamed from: a */
    public void mo33617a(C8362a aVar) {
        this.ejQ = aVar;
    }

    /* renamed from: a */
    public abstract void mo27530a(C8363b bVar, int i);

    public int ajC() {
        return this.cwZ;
    }

    /* renamed from: b */
    public void onBindViewHolder(C8363b bVar, final int i) {
        View akM = bVar.akM();
        if (!(this.ejQ == null || akM == null)) {
            akM.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8360a.this.ejQ.mo27631z(view, i);
                }
            });
        }
        mo27530a(bVar, i);
    }

    public Context getContext() {
        return this.mContext;
    }

    public T getItem(int i) {
        if (this.mItemInfoList == null || i >= this.mItemInfoList.size()) {
            return null;
        }
        return this.mItemInfoList.get(i);
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    /* renamed from: kP */
    public void mo27533kP(int i) {
        this.cwZ = i;
    }

    /* renamed from: uD */
    public void mo33622uD(int i) {
        this.ejR = i;
    }
}
