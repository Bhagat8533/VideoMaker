package com.introvd.template.editor.fast.p260a;

import android.content.Context;
import android.graphics.Point;
import com.introvd.template.common.MSize;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.effects.p254b.C5911a;
import com.introvd.template.editor.effects.p254b.C5912b;
import com.introvd.template.editor.effects.p254b.C5915c;
import com.introvd.template.editor.effects.p254b.C5917d;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p246c.C5693d;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.utils.VeMSize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.fast.a.a */
public class C6284a extends BaseController<C6287b> implements C5911a {
    private List<BaseItem> cRu = new ArrayList();
    private C5912b cRv;
    private List<C8441b> cRw = new ArrayList();
    private List<C8441b> cRx = new ArrayList();
    private int[] cRy = {20, 8, 6};
    private C5686a cyD;
    private Context mContext;

    /* renamed from: com.introvd.template.editor.fast.a.a$a */
    class C6286a implements Comparator {
        C6286a() {
        }

        public int compare(Object obj, Object obj2) {
            return Float.compare(((C8441b) obj2).eee, ((C8441b) obj).eee);
        }
    }

    /* renamed from: a */
    private ArrayList<C8441b> m17991a(QStoryboard qStoryboard, MSize mSize, Point point, int i, int i2) {
        ArrayList<C8441b> arrayList = new ArrayList<>();
        if (qStoryboard == null || mSize == null) {
            return arrayList;
        }
        VeMSize veMSize = null;
        if (this.cyD.getSurfaceSize() != null) {
            veMSize = new VeMSize(this.cyD.getSurfaceSize().width, this.cyD.getSurfaceSize().height);
        }
        VeMSize veMSize2 = new VeMSize(mSize.width, mSize.height);
        ArrayList a = C8419a.m24325a(this.cyD.adO(), i2, veMSize);
        int size = a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C8441b bVar = (C8441b) a.get(i3);
            if (C8419a.m24326a(qStoryboard, bVar, point, i, veMSize2)) {
                if (i2 == 20 || i2 == 6 || i2 == 8) {
                    arrayList.add(bVar);
                } else if (i2 == 3) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void amj() {
        if (getMvpView() != null && !((C6287b) getMvpView()).getHostActivity().isFinishing()) {
            if (this.cRu.size() == 1) {
                int i = 0;
                C8441b bVar = (C8441b) ((BaseItem) this.cRu.get(0)).getItemData();
                int i2 = bVar.groupId;
                if (i2 == 20) {
                    i = 2001;
                } else if (i2 == 8) {
                    i = 2003;
                } else if (i2 == 6) {
                    i = 2004;
                } else if (i2 == 3) {
                    i = 2002;
                }
                ((C6287b) getMvpView()).mo29219cC(i, bVar.aId());
            } else if (this.cRu.size() > 1) {
                if (this.cRv == null) {
                    this.cRv = new C5912b(((C6287b) getMvpView()).getHostActivity());
                }
                this.cRv.setData(this.cRu);
                this.cRv.showDialog();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17994c(Point point) {
        this.cRu.clear();
        this.cRx.clear();
        this.cRw.clear();
        int agY = C5852d.agW().agY();
        for (int a : this.cRy) {
            this.cRx.addAll(m17991a(this.cyD.adO(), this.cyD.getSurfaceSize(), point, agY, a));
        }
        this.cRw.addAll(m17991a(this.cyD.adO(), this.cyD.getSurfaceSize(), point, agY, 3));
        C6286a aVar = new C6286a();
        Collections.sort(this.cRx, aVar);
        Collections.sort(this.cRw, aVar);
        if (this.cRw.size() > 0) {
            for (int i = 0; i < this.cRw.size(); i++) {
                C5917d dVar = new C5917d(this.mContext, (C8441b) this.cRw.get(i));
                dVar.mo28524a((C5911a) this);
                this.cRu.add(dVar);
            }
        }
        if (this.cRx.size() > 0) {
            for (int i2 = 0; i2 < this.cRx.size(); i2++) {
                C5915c cVar = new C5915c(this.mContext, (C8441b) this.cRx.get(i2));
                cVar.mo28522a((C5911a) this);
                this.cRu.add(cVar);
            }
        }
    }

    /* renamed from: a */
    public void mo29222a(Context context, C5686a aVar) {
        this.mContext = context;
        this.cyD = aVar;
    }

    /* renamed from: a */
    public void attachView(C6287b bVar) {
        super.attachView(bVar);
    }

    /* renamed from: cB */
    public void mo28516cB(int i, int i2) {
        if (getMvpView() != null) {
            ((C6287b) getMvpView()).mo29219cC(i, i2);
            this.cRv.dismiss();
        }
    }

    public void detachView() {
        super.detachView();
    }

    public C5688b getFineTuningListener() {
        return new C5693d() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                C6284a.this.m17994c(point);
                C6284a.this.amj();
                return false;
            }

            public boolean aet() {
                return false;
            }

            public void aeu() {
            }

            public int aev() {
                return 0;
            }

            public void aew() {
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return 0;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
            }
        };
    }
}
