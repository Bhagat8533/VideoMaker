package com.introvd.template.xyui.p420a;

import android.view.ViewGroup;
import com.introvd.template.xyui.p420a.C9155c;
import java.util.List;
import p464d.p466b.p467a.C9649c;

/* renamed from: com.introvd.template.xyui.a.b */
public abstract class C9153b<T extends C9155c> extends C9151a<T, C9156d> {
    public static final C9154a eDf = new C9154a(null);

    /* renamed from: com.introvd.template.xyui.a.b$a */
    public static final class C9154a {
        private C9154a() {
        }

        public /* synthetic */ C9154a(C9648b bVar) {
            this();
        }
    }

    private final boolean isFooterItem(int i) {
        return isSupportFooterItem() && i == getItemCount() - 1;
    }

    private final boolean isHeaderItem(int i) {
        return isSupportHeaderItem() && i == 0;
    }

    /* renamed from: a */
    public abstract void mo24002a(C9156d dVar, int i);

    /* renamed from: b */
    public abstract void mo24005b(C9156d dVar, int i);

    /* renamed from: c */
    public abstract void mo24006c(C9156d dVar, int i);

    /* renamed from: d */
    public void onBindViewHolder(C9156d dVar, int i) {
        C9649c.m27672j(dVar, "holder");
        if (isSupportHeaderItem() && i == 0) {
            mo24002a(dVar, i);
        } else if (!isSupportFooterItem() || i != getItemCount() - 1) {
            mo24006c(dVar, i);
        } else {
            mo24005b(dVar, i);
        }
    }

    public final int getDataItemCount() {
        if (getDataList() == null) {
            return 0;
        }
        List dataList = getDataList();
        if (dataList == null) {
            C9649c.aVp();
        }
        return dataList.size();
    }

    public int getItemCount() {
        int i;
        int i2 = (isSupportHeaderItem() ? 1 : 0) + (isSupportFooterItem() ? 1 : 0);
        if (getDataList() == null) {
            i = 0;
        } else {
            List dataList = getDataList();
            if (dataList == null) {
                C9649c.aVp();
            }
            i = dataList.size();
        }
        return i + i2;
    }

    public int getItemViewType(int i) {
        if (isHeaderItem(i)) {
            return 1;
        }
        return isFooterItem(i) ? 3 : 2;
    }

    public final int getRealItemPosition(int i) {
        return i - (isSupportHeaderItem() ? 1 : 0);
    }

    public abstract boolean isSupportFooterItem();

    public abstract boolean isSupportHeaderItem();

    /* renamed from: j */
    public abstract C9156d mo24009j(ViewGroup viewGroup, int i);

    /* renamed from: k */
    public abstract C9156d mo24010k(ViewGroup viewGroup, int i);

    /* renamed from: l */
    public abstract C9156d mo24011l(ViewGroup viewGroup, int i);

    /* renamed from: m */
    public C9156d onCreateViewHolder(ViewGroup viewGroup, int i) {
        C9649c.m27672j(viewGroup, "parent");
        return (!isSupportHeaderItem() || i != 1) ? (!isSupportFooterItem() || i != 3) ? mo24011l(viewGroup, i) : mo24010k(viewGroup, i) : mo24009j(viewGroup, i);
    }

    /* renamed from: vT */
    public final T mo36120vT(int i) {
        T t = null;
        if (getDataList() == null) {
            return null;
        }
        int realItemPosition = getRealItemPosition(i);
        if (realItemPosition >= 0) {
            List dataList = getDataList();
            if (dataList == null) {
                C9649c.aVp();
            }
            if (realItemPosition < dataList.size()) {
                List dataList2 = getDataList();
                if (dataList2 == null) {
                    C9649c.aVp();
                }
                t = (C9155c) dataList2.get(realItemPosition);
            }
        }
        return t;
    }
}
