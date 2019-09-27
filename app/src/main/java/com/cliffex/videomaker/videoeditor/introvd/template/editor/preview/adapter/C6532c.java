package com.introvd.template.editor.preview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.preview.adapter.C6530b.C6531a;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.editor.preview.p272c.C6555a;
import com.introvd.template.editor.preview.view.ClipItemView;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.p415a.C8986a.C8987a;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.editor.preview.adapter.c */
public class C6532c extends C1008a<C6542a> implements C8987a {
    private boolean cZX;
    /* access modifiers changed from: private */
    public int cZY = 0;
    /* access modifiers changed from: private */
    public List<ClipItemInfo> cZZ = new ArrayList();
    private int cwZ = 0;
    /* access modifiers changed from: private */
    public C6543b daa;
    private C6548e dab;
    private List<C6555a> dac = new ArrayList();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Context mContext;

    /* renamed from: com.introvd.template.editor.preview.adapter.c$a */
    static class C6542a extends C1034u {
        ClipItemView dan;

        C6542a(ClipItemView clipItemView) {
            super(clipItemView);
            this.dan = clipItemView;
        }
    }

    /* renamed from: com.introvd.template.editor.preview.adapter.c$b */
    public interface C6543b {
        /* renamed from: X */
        void mo29844X(int i, boolean z);

        void apf();

        /* renamed from: ot */
        void mo29846ot(int i);

        /* renamed from: ou */
        void mo29847ou(int i);

        /* renamed from: ov */
        void mo29848ov(int i);
    }

    public C6532c(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    private void m18952a(C6542a aVar, List<C6530b> list) {
        if (list != null && list.size() != 0) {
            Integer num = null;
            Bitmap bitmap = null;
            Boolean bool = null;
            Boolean bool2 = null;
            Boolean bool3 = null;
            Boolean bool4 = null;
            for (C6530b bVar : list) {
                if (bVar.aoU() != null) {
                    num = bVar.aoU();
                }
                if (bVar.aoV() != null) {
                    bitmap = bVar.aoV();
                }
                if (bVar.aoW() != null) {
                    bool = bVar.aoW();
                }
                if (bVar.aoX() != null) {
                    bool2 = bVar.aoX();
                }
                if (bVar.aoY() != null) {
                    bool3 = bVar.aoY();
                }
                if (bVar.aoT() != null) {
                    bool4 = bVar.aoT();
                }
            }
            if (num != null) {
                aVar.dan.mo30082oR(num.intValue());
            }
            if (bitmap != null) {
                aVar.dan.mo30083r(bitmap);
            }
            if (bool != null) {
                aVar.dan.mo30079gS(bool.booleanValue());
            }
            if (bool2 != null) {
                aVar.dan.mo30078gR(bool2.booleanValue());
            }
            boolean z = true;
            if (bool3 != null) {
                aVar.dan.mo30081o(this.cZX, aVar.getAdapterPosition() + 1);
            }
            if (bool4 != null) {
                int adapterPosition = aVar.getAdapterPosition();
                if (adapterPosition >= 0 && adapterPosition < this.cZZ.size()) {
                    aVar.dan.mo30084z(adapterPosition != this.cZZ.size() - 1, ((ClipItemInfo) this.cZZ.get(adapterPosition)).lTransDuration > 0);
                }
                ClipItemView clipItemView = aVar.dan;
                if (this.cZY == 1) {
                    z = false;
                }
                clipItemView.mo30080gT(z);
            }
        }
    }

    private boolean ape() {
        return this.cZZ.size() > 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: hk */
    public void m18956hk(int i) {
        if (this.cZZ != null && i >= 0) {
            ClipItemInfo clipItemInfo = (ClipItemInfo) this.cZZ.get(i);
            if (!ape()) {
                switch (clipItemInfo.state) {
                    case -1:
                    case 0:
                        this.cZY = 0;
                        break;
                }
            } else {
                switch (clipItemInfo.state) {
                    case -1:
                    case 0:
                        this.cZY = 0;
                        break;
                }
                mo29813W(i, false);
            }
            if (this.daa != null) {
                this.daa.mo29846ot(i);
            }
        }
    }

    /* renamed from: I */
    public C6542a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6542a(new ClipItemView(this.mContext));
    }

    /* renamed from: W */
    public void mo29813W(final int i, boolean z) {
        if (this.cZZ != null && this.cZZ.size() != 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.cZZ.size()) {
                i = this.cZZ.size() - 1;
            }
            C5843c.agO().mo28234lS(i);
            if (i != this.cwZ || z) {
                if (this.cZY == 1) {
                    if (this.cwZ >= 0 && this.cwZ != i && this.cZZ.size() > this.cwZ) {
                        final int i2 = this.cwZ;
                        this.handler.post(new Runnable() {
                            public void run() {
                                if (i2 < C6532c.this.cZZ.size()) {
                                    ((ClipItemInfo) C6532c.this.cZZ.get(i2)).bFocus = false;
                                    C6532c.this.notifyItemChanged(i2, new C6531a().mo29809t(Boolean.valueOf(false)).aoZ());
                                }
                            }
                        });
                    }
                    this.handler.post(new Runnable() {
                        public void run() {
                            if (i < C6532c.this.cZZ.size()) {
                                ((ClipItemInfo) C6532c.this.cZZ.get(i)).bFocus = true;
                                C6532c.this.notifyItemChanged(i, new C6531a().mo29809t(Boolean.valueOf(true)).aoZ());
                            }
                        }
                    });
                } else {
                    if (this.cwZ >= 0 && this.cwZ != i && this.cZZ.size() > this.cwZ) {
                        final int i3 = this.cwZ;
                        this.handler.post(new Runnable() {
                            public void run() {
                                if (i3 < C6532c.this.cZZ.size()) {
                                    ((ClipItemInfo) C6532c.this.cZZ.get(i3)).state = 0;
                                    ((ClipItemInfo) C6532c.this.cZZ.get(i3)).bFocus = false;
                                    C6532c.this.notifyItemChanged(i3, new C6531a().mo29807k(Integer.valueOf(0)).mo29809t(Boolean.valueOf(false)).aoZ());
                                }
                            }
                        });
                    }
                    if (this.cZZ.size() == 1) {
                        ((ClipItemInfo) this.cZZ.get(i)).state = 0;
                    } else if (this.cZZ.size() > 1) {
                        ((ClipItemInfo) this.cZZ.get(i)).state = 0;
                    }
                    ((ClipItemInfo) this.cZZ.get(i)).bFocus = true;
                    this.handler.post(new Runnable() {
                        public void run() {
                            if (i < C6532c.this.cZZ.size()) {
                                C6531a t = new C6531a().mo29807k(Integer.valueOf(((ClipItemInfo) C6532c.this.cZZ.get(i)).state)).mo29809t(Boolean.valueOf(true));
                                if (i == C6532c.this.cZZ.size() - 1) {
                                    t.mo29808s(Boolean.valueOf(true));
                                }
                                C6532c.this.notifyItemChanged(i, t.aoZ());
                            }
                        }
                    });
                }
                this.cwZ = i;
            }
        }
    }

    /* renamed from: a */
    public void mo29814a(int i, ClipItemInfo clipItemInfo) {
        this.cZZ.add(i, clipItemInfo);
        if (i == this.cZZ.size() - 1) {
            notifyDataSetChanged();
        } else {
            notifyItemInserted(i);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(final C6542a aVar, int i) {
        final ClipItemInfo clipItemInfo = (ClipItemInfo) this.cZZ.get(i);
        if (clipItemInfo != null) {
            aVar.dan.mo30077b(i, clipItemInfo, this.dab);
            boolean z = false;
            if (i < this.cZZ.size()) {
                aVar.dan.mo30084z(i != this.cZZ.size() - 1, clipItemInfo.lTransDuration > 0);
            }
            ClipItemView clipItemView = aVar.dan;
            if (this.cZY != 1) {
                z = true;
            }
            clipItemView.mo30080gT(z);
            aVar.dan.mo30081o(this.cZX, i + 1);
            aVar.dan.findViewById(R.id.item_delete_btn).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11664ig(300)) {
                        int adapterPosition = aVar.getAdapterPosition();
                        if (!(adapterPosition == -1 || C6532c.this.daa == null)) {
                            C6532c.this.daa.mo29847ou(adapterPosition);
                        }
                    }
                }
            });
            aVar.dan.findViewById(R.id.item_select_btn).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf()) {
                        int adapterPosition = aVar.getAdapterPosition();
                        if (adapterPosition != -1) {
                            aVar.dan.mo30078gR(!clipItemInfo.bSelected);
                            clipItemInfo.bSelected = !clipItemInfo.bSelected;
                            C6532c.this.mo29813W(adapterPosition, false);
                            if (C6532c.this.daa != null) {
                                C6532c.this.daa.mo29844X(adapterPosition, !clipItemInfo.bSelected);
                            }
                        }
                    }
                }
            });
            aVar.dan.findViewById(R.id.item_comtent).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf()) {
                        int adapterPosition = aVar.getAdapterPosition();
                        if (adapterPosition != -1) {
                            C6532c.this.m18956hk(adapterPosition);
                        }
                    }
                }
            });
            aVar.dan.findViewById(R.id.transition_entrance_layout).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf()) {
                        int adapterPosition = aVar.getAdapterPosition();
                        if (adapterPosition != -1 && C6532c.this.cZY != 1) {
                            C2564c.m7327dA(view);
                            if (C6532c.this.daa != null) {
                                C6532c.this.daa.mo29848ov(adapterPosition);
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C6542a aVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C6530b) {
                arrayList.add((C6530b) next);
            }
        }
        m18952a(aVar, (List<C6530b>) arrayList);
    }

    /* renamed from: a */
    public void mo29817a(C6543b bVar) {
        this.daa = bVar;
    }

    /* renamed from: a */
    public void mo29818a(C6548e eVar) {
        this.dab = eVar;
    }

    public void apa() {
        for (C6555a apa : this.dac) {
            apa.apa();
        }
    }

    public boolean apb() {
        return this.cZY == 1;
    }

    public void apc() {
        ((ClipItemInfo) this.cZZ.get(this.cwZ)).bSelected = true;
        mo29832gw(true);
    }

    public List<Integer> apd() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.cZZ.size() > 1) {
            if (this.cZY == 0) {
                while (i < this.cZZ.size()) {
                    if (((ClipItemInfo) this.cZZ.get(i)).bFocus) {
                        arrayList.add(Integer.valueOf(i));
                    }
                    i++;
                }
            } else {
                while (i < this.cZZ.size()) {
                    if (((ClipItemInfo) this.cZZ.get(i)).bSelected) {
                        arrayList.add(Integer.valueOf(i));
                    }
                    i++;
                }
            }
        } else if (this.cZZ.size() == 1) {
            arrayList.add(Integer.valueOf(0));
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo29823b(int i, ClipItemInfo clipItemInfo) {
        if (i < this.cZZ.size() && i >= 0) {
            clipItemInfo.bFocus = ((ClipItemInfo) this.cZZ.get(i)).bFocus;
            clipItemInfo.state = ((ClipItemInfo) this.cZZ.get(i)).state;
            clipItemInfo.bSelected = ((ClipItemInfo) this.cZZ.get(i)).bSelected;
            this.cZZ.set(i, clipItemInfo);
            notifyItemChanged(i);
            for (C6555a aVar : this.dac) {
                if (aVar != null) {
                    aVar.mo29867oF(i);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo29824b(C6555a aVar) {
        if (aVar != null && !this.dac.contains(aVar)) {
            this.dac.add(aVar);
            registerAdapterDataObserver(aVar);
        }
    }

    /* renamed from: bd */
    public void mo29825bd(List<ClipItemInfo> list) {
        this.cZZ.clear();
        this.cZZ.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: be */
    public void mo29826be(List<Integer> list) {
        int i = this.cwZ;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((Integer) list.get(size)).intValue() < this.cwZ) {
                i--;
            } else if (((Integer) list.get(size)).intValue() == this.cwZ && ((Integer) list.get(size)).intValue() == getItemCount() - 1) {
                i = ((Integer) list.get(size)).intValue() - 1;
            }
            this.cZZ.remove(((Integer) list.get(size)).intValue());
        }
        this.cwZ = i;
        if (this.cwZ >= 0 && this.cwZ < this.cZZ.size()) {
            ((ClipItemInfo) this.cZZ.get(this.cwZ)).bFocus = true;
        }
        C5843c.agO().mo28234lS(i);
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public void mo29827c(final boolean z, final int i, final int i2) {
        if (this.cZX != z) {
            this.cZX = z;
            this.handler.post(new Runnable() {
                public void run() {
                    C6531a v = new C6531a().mo29811v(Boolean.valueOf(z));
                    if (i == C6532c.this.cZZ.size() - 1 || i2 == C6532c.this.cZZ.size() - 1) {
                        v.mo29808s(Boolean.valueOf(true));
                    }
                    C6532c.this.notifyItemRangeChanged(0, C6532c.this.getItemCount(), v.aoZ());
                }
            });
        }
    }

    /* renamed from: cJ */
    public void mo29828cJ(int i, int i2) {
        for (C6555a cJ : this.dac) {
            cJ.mo29866cJ(i, i2);
        }
    }

    /* renamed from: cK */
    public void mo29829cK(int i, int i2) {
        if (i == this.cZZ.size() - 1 || i2 == this.cZZ.size() - 1) {
            C6531a aVar = new C6531a();
            aVar.mo29808s(Boolean.valueOf(true));
            notifyItemRangeChanged(0, getItemCount(), aVar.aoZ());
        }
    }

    /* renamed from: cp */
    public void mo28031cp(int i, int i2) {
        if (i < this.cZZ.size() && i2 < this.cZZ.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Adapter Item move: from ");
            sb.append(i);
            sb.append(" to ");
            sb.append(i2);
            LogUtils.m14223i("PreviewClipAdapter", sb.toString());
            if (i < i2) {
                int i3 = i;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    Collections.swap(this.cZZ, i3, i4);
                    i3 = i4;
                }
            } else {
                for (int i5 = i; i5 > i2; i5--) {
                    Collections.swap(this.cZZ, i5, i5 - 1);
                }
            }
            if (i == this.cwZ) {
                this.cwZ = i2;
            } else if (i2 == this.cwZ) {
                this.cwZ = i;
            }
            C5843c.agO().mo28234lS(this.cwZ);
            notifyItemMoved(i, i2);
        }
    }

    public int getFocusIndex() {
        return this.cwZ;
    }

    public int getItemCount() {
        return this.cZZ.size();
    }

    /* renamed from: gv */
    public void mo29831gv(boolean z) {
        if (apb()) {
            if (z) {
                for (int i = 0; i < this.cZZ.size(); i++) {
                    ((ClipItemInfo) this.cZZ.get(i)).state = 3;
                    ((ClipItemInfo) this.cZZ.get(i)).bSelected = true;
                    notifyItemChanged(i, new C6531a().mo29807k(Integer.valueOf(3)).mo29810u(Boolean.valueOf(true)).aoZ());
                }
                return;
            }
            for (int i2 = 0; i2 < this.cZZ.size(); i2++) {
                ((ClipItemInfo) this.cZZ.get(i2)).state = 3;
                ((ClipItemInfo) this.cZZ.get(i2)).bSelected = false;
                notifyItemChanged(i2, new C6531a().mo29807k(Integer.valueOf(3)).mo29810u(Boolean.valueOf(false)).aoZ());
            }
        }
    }

    /* renamed from: gw */
    public void mo29832gw(boolean z) {
        if (z) {
            this.cZY = 1;
            for (int i = 0; i < this.cZZ.size(); i++) {
                ((ClipItemInfo) this.cZZ.get(i)).state = 3;
            }
            notifyDataSetChanged();
            if (this.daa != null) {
                this.daa.apf();
                return;
            }
            return;
        }
        this.cZY = 0;
        for (int i2 = 0; i2 < this.cZZ.size(); i2++) {
            ((ClipItemInfo) this.cZZ.get(i2)).state = 0;
            ((ClipItemInfo) this.cZZ.get(i2)).bSelected = false;
        }
        notifyDataSetChanged();
    }

    /* renamed from: lo */
    public void mo28032lo(int i) {
        this.cZZ.remove(i);
        notifyItemRemoved(i);
    }

    public void release() {
        for (C6555a aVar : this.dac) {
            if (aVar != null) {
                unregisterAdapterDataObserver(aVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeItem(int r7) {
        /*
            r6 = this;
            if (r7 < 0) goto L_0x00af
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r0 = r6.cZZ
            int r0 = r0.size()
            if (r7 >= r0) goto L_0x00af
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r0 = r6.cZZ
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            if (r7 != r0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            int r3 = r6.cwZ
            int r4 = r6.cwZ
            if (r4 != r7) goto L_0x002c
            int r4 = r6.getItemCount()
            int r4 = r4 - r1
            if (r7 != r4) goto L_0x0027
            int r3 = r7 + -1
        L_0x0027:
            r4 = -1
            r6.cwZ = r4
        L_0x002a:
            r4 = 1
            goto L_0x0035
        L_0x002c:
            int r4 = r6.cwZ
            if (r7 >= r4) goto L_0x0034
            int r3 = r6.cwZ
            int r3 = r3 - r1
            goto L_0x002a
        L_0x0034:
            r4 = 0
        L_0x0035:
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r5 = r6.cZZ
            r5.remove(r7)
            r6.notifyItemRemoved(r7)
            int r7 = r6.cwZ
            if (r3 != r7) goto L_0x008f
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r7 = r6.cZZ
            int r7 = r7.size()
            if (r7 != r1) goto L_0x008f
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r7 = r6.cZZ
            int r0 = r6.cwZ
            java.lang.Object r7 = r7.get(r0)
            com.introvd.template.editor.preview.model.ClipItemInfo r7 = (com.introvd.template.editor.preview.model.ClipItemInfo) r7
            r7.state = r2
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r7 = r6.cZZ
            int r0 = r6.cwZ
            java.lang.Object r7 = r7.get(r0)
            com.introvd.template.editor.preview.model.ClipItemInfo r7 = (com.introvd.template.editor.preview.model.ClipItemInfo) r7
            r7.bFocus = r1
            com.introvd.template.editor.common.c r7 = com.introvd.template.editor.common.C5843c.agO()
            r7.mo28234lS(r3)
            com.introvd.template.editor.preview.adapter.b$a r7 = new com.introvd.template.editor.preview.adapter.b$a
            r7.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            com.introvd.template.editor.preview.adapter.b$a r7 = r7.mo29807k(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            com.introvd.template.editor.preview.adapter.b$a r7 = r7.mo29808s(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            com.introvd.template.editor.preview.adapter.b$a r7 = r7.mo29809t(r0)
            int r0 = r6.cwZ
            com.introvd.template.editor.preview.adapter.b r7 = r7.aoZ()
            r6.notifyItemChanged(r0, r7)
            goto L_0x00af
        L_0x008f:
            if (r0 == 0) goto L_0x00ac
            java.util.List<com.introvd.template.editor.preview.model.ClipItemInfo> r7 = r6.cZZ
            int r7 = r7.size()
            int r7 = r7 - r1
            com.introvd.template.editor.preview.adapter.b$a r0 = new com.introvd.template.editor.preview.adapter.b$a
            r0.<init>()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.introvd.template.editor.preview.adapter.b$a r0 = r0.mo29808s(r1)
            com.introvd.template.editor.preview.adapter.b r0 = r0.aoZ()
            r6.notifyItemChanged(r7, r0)
        L_0x00ac:
            r6.mo29813W(r3, r4)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.adapter.C6532c.removeItem(int):void");
    }
}
