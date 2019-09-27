package com.introvd.template.picker.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.introvd.template.explorer.p299d.C7157a;
import com.introvd.template.picker.C8186b;
import com.introvd.template.picker.adapter.C8178b.C8179a;
import com.introvd.template.picker.item.PickerMediaItemView;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p369d.C8218b;
import com.introvd.template.picker.p369d.C8219c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.introvd.template.picker.adapter.c */
public class C8180c extends C1008a<C8184b> {
    public static int dYf = 0;
    public static int dYg = 4;
    private int cUw;
    private List<C8215c> dYh = new ArrayList();
    /* access modifiers changed from: private */
    public C8183a dYi;
    /* access modifiers changed from: private */
    public String dYj;
    /* access modifiers changed from: private */
    public LinkedList<String> dYk = new LinkedList<>();
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.picker.adapter.c$a */
    public interface C8183a {
        /* renamed from: e */
        boolean mo33287e(int i, int i2, String str);
    }

    /* renamed from: com.introvd.template.picker.adapter.c$b */
    static class C8184b extends C1034u {
        PickerMediaItemView dYo;

        C8184b(PickerMediaItemView pickerMediaItemView) {
            super(pickerMediaItemView);
            this.dYo = pickerMediaItemView;
        }
    }

    public C8180c(Context context) {
        this.mContext = context;
        dYf = C8218b.m23732O(context, 2);
        this.cUw = (C8218b.m23733gH(context).widthPixels - (dYf * 3)) / dYg;
    }

    /* renamed from: a */
    private void m23637a(C8184b bVar, List<C8178b> list) {
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        for (C8178b bVar2 : list) {
            if (bVar2.aFw() != null) {
                bool = bVar2.aFw();
            }
            if (bVar2.aFx() != null) {
                bool2 = bVar2.aFx();
            }
            if (bVar2.aFv() != null) {
                bool3 = bVar2.aFv();
            }
        }
        int adapterPosition = bVar.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < this.dYh.size()) {
            String aFK = ((C8215c) this.dYh.get(adapterPosition)).aFK();
            if (bool != null) {
                bVar.dYo.mo33385mD(aFK);
            }
            if (bool2 != null) {
                bVar.dYo.mo33384mC(aFK);
            }
            if (bool3 != null) {
                bVar.dYo.mo33382an(C8186b.aFr().mo33300mr(aFK), false);
            }
        }
    }

    /* renamed from: cD */
    private void m23640cD(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.dYh.size(); i++) {
                C8215c cVar = (C8215c) this.dYh.get(i);
                if (list.contains(cVar.aFK())) {
                    if (!C8186b.aFr().mo33298mp(cVar.aFK())) {
                        if (this.dYi != null) {
                            this.dYi.mo33287e(cVar.getSourceType(), 2, cVar.aFK());
                        }
                        this.dYk.remove(cVar.aFK());
                    } else if (!this.dYk.contains(cVar.aFK())) {
                        this.dYk.add(cVar.aFK());
                    }
                    notifyItemChanged(i, new C8179a().mo33274D(Boolean.valueOf(true)).aFy());
                }
            }
        }
    }

    /* renamed from: ms */
    private void m23642ms(String str) {
        for (int i = 0; i < this.dYh.size(); i++) {
            if (str.equals(((C8215c) this.dYh.get(i)).aFK())) {
                notifyItemChanged(i, new C8179a().mo33273C(Boolean.valueOf(true)).mo33274D(Boolean.valueOf(true)).aFy());
                return;
            }
        }
    }

    /* renamed from: X */
    public C8184b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C8184b(new PickerMediaItemView(this.mContext));
    }

    /* renamed from: a */
    public void mo33277a(C8183a aVar) {
        this.dYi = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C8184b bVar, int i) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.width = this.cUw;
        layoutParams.height = this.cUw;
        bVar.dYo.setLayoutParams(layoutParams);
        final C8215c cVar = (C8215c) this.dYh.get(i);
        bVar.dYo.mo33381a(cVar);
        bVar.dYo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String aFK = cVar.aFK();
                int sourceType = cVar.getSourceType();
                boolean mp = C8186b.aFr().mo33298mp(aFK);
                if (TextUtils.isEmpty(aFK) || sourceType != 0 || !aFK.equals(C8180c.this.dYj) || !mp) {
                    if (!C8219c.m23735Sf() && C8180c.this.dYi != null && C8180c.this.dYi.mo33287e(sourceType, mp ? 1 : 0, aFK)) {
                        C8180c.this.setFocusItem(aFK);
                    }
                } else if (C8180c.this.dYi != null) {
                    bVar.dYo.mo33382an(C8186b.aFr().mo33294ml(aFK), true);
                    C8180c.this.dYi.mo33287e(sourceType, 3, aFK);
                }
            }
        });
        bVar.dYo.setStatusBtnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C8219c.m23735Sf()) {
                    String aFK = cVar.aFK();
                    int sourceType = cVar.getSourceType();
                    if (cVar.aFJ() && !C7157a.m21184fY(C8180c.this.mContext).mo31635z(aFK, sourceType)) {
                        C8180c.this.setFocusItem(aFK);
                        if (C8180c.this.dYi != null) {
                            C8180c.this.dYi.mo33287e(sourceType, 0, aFK);
                        }
                    } else if (C8180c.this.dYi != null) {
                        boolean y = bVar.dYo.mo33387y(sourceType, aFK);
                        if (!C8180c.this.dYi.mo33287e(sourceType, y ? 1 : 2, aFK)) {
                            bVar.dYo.mo33387y(sourceType, aFK);
                            C8180c.this.dYk.remove(aFK);
                        } else if (y) {
                            if (!C8180c.this.dYk.contains(aFK)) {
                                C8180c.this.dYk.add(aFK);
                            }
                            C8180c.this.setFocusItem(cVar.aFK());
                        } else {
                            C8180c.this.dYk.remove(aFK);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void onBindViewHolder(C8184b bVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(bVar, i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C8178b) {
                arrayList.add((C8178b) next);
            }
        }
        m23637a(bVar, (List<C8178b>) arrayList);
    }

    public void aFz() {
        m23640cD(C8219c.m23736c(C8186b.aFr().aFs(), this.dYk));
    }

    /* renamed from: cC */
    public void mo33281cC(List<C8215c> list) {
        if (list != null) {
            this.dYh.clear();
            this.dYh.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.dYh.size();
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    /* renamed from: mt */
    public void mo33282mt(String str) {
        C8186b.aFr().mo33296mn(str);
        this.dYk.remove(str);
        m23642ms(str);
    }

    /* renamed from: mu */
    public void mo33283mu(String str) {
        int i = 0;
        while (i < this.dYh.size()) {
            C8215c cVar = (C8215c) this.dYh.get(i);
            if (cVar.getSourceType() != 0 || !str.equals(cVar.aFK())) {
                i++;
            } else {
                notifyItemChanged(i, new C8179a().mo33272B(Boolean.valueOf(true)).aFy());
                return;
            }
        }
    }

    public void setFocusItem(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.dYj)) {
            C8186b.aFr().mo33297mo(str);
            if (!TextUtils.isEmpty(this.dYj)) {
                m23642ms(this.dYj);
            }
            m23642ms(str);
            this.dYj = str;
        }
    }
}
