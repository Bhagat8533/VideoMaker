package com.introvd.template.xyui.p420a;

import android.support.p024v7.p030d.C0884c;
import android.support.p024v7.p030d.C0884c.C0886a;
import android.support.p024v7.p030d.C0884c.C0887b;
import android.support.p024v7.widget.RecyclerView.C1008a;
import com.introvd.template.xyui.p420a.C9155c;
import com.introvd.template.xyui.p420a.C9156d;
import java.util.ArrayList;
import java.util.List;
import p464d.p466b.p467a.C9649c;

/* renamed from: com.introvd.template.xyui.a.a */
public abstract class C9151a<T extends C9155c, VH extends C9156d> extends C1008a<VH> {
    private List<? extends T> dataList;

    /* renamed from: com.introvd.template.xyui.a.a$a */
    public final class C9152a extends C0886a {
        private List<? extends T> eDd;
        final /* synthetic */ C9151a eDe;

        public C9152a(C9151a aVar, List<? extends T> list) {
            C9649c.m27672j(list, "list");
            this.eDe = aVar;
            this.eDd = list;
        }

        /* renamed from: vR */
        private final T m26629vR(int i) {
            if (this.eDe.getDataList() == null) {
                return null;
            }
            List dataList = this.eDe.getDataList();
            if (dataList == null) {
                C9649c.aVp();
            }
            if (i >= dataList.size()) {
                return null;
            }
            List dataList2 = this.eDe.getDataList();
            if (dataList2 == null) {
                C9649c.aVp();
            }
            return (C9155c) dataList2.get(i);
        }

        /* renamed from: vS */
        private final T m26630vS(int i) {
            if (i >= this.eDd.size()) {
                return null;
            }
            return (C9155c) this.eDd.get(i);
        }

        /* renamed from: H */
        public boolean mo6714H(int i, int i2) {
            return this.eDe.mo36113b(m26629vR(i), m26630vS(i2));
        }

        /* renamed from: I */
        public boolean mo6715I(int i, int i2) {
            return this.eDe.mo24004a(m26629vR(i), m26630vS(i2));
        }

        /* renamed from: hh */
        public int mo6717hh() {
            if (this.eDe.getDataList() == null) {
                return 0;
            }
            List dataList = this.eDe.getDataList();
            if (dataList == null) {
                C9649c.aVp();
            }
            return dataList.size();
        }

        /* renamed from: hi */
        public int mo6718hi() {
            return this.eDd.size();
        }
    }

    /* renamed from: a */
    public abstract boolean mo24004a(T t, T t2);

    /* renamed from: b */
    public final boolean mo36113b(T t, T t2) {
        Integer num = null;
        Object valueOf = t != null ? Integer.valueOf(t.getItemKey()) : null;
        if (t2 != null) {
            num = Integer.valueOf(t2.getItemKey());
        }
        return C9649c.areEqual(valueOf, num);
    }

    /* renamed from: dh */
    public final void mo36114dh(List<? extends T> list) {
        C9649c.m27672j(list, "list");
        if (this.dataList != null) {
            List<? extends T> list2 = this.dataList;
            if (list2 == null) {
                C9649c.aVp();
            }
            if (!list2.isEmpty()) {
                C0887b a = C0884c.m2381a(new C9152a(this, list));
                C9649c.m27671i(a, "DiffUtil.calculateDiff(diffCallback)");
                this.dataList = new ArrayList(list);
                a.mo6720a((C1008a) this);
                return;
            }
        }
        this.dataList = new ArrayList(list);
        notifyDataSetChanged();
    }

    public final List<T> getDataList() {
        return this.dataList;
    }
}
