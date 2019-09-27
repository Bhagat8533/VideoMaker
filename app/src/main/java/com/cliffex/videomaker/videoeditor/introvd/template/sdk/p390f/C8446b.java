package com.introvd.template.sdk.p390f;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.p057e.C1518f;

/* renamed from: com.introvd.template.sdk.f.b */
public class C8446b {
    private static final String TAG = "b";
    private static C8446b egv;
    private List<C8445a> egw = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.introvd.template.sdk.f.b$a */
    class C8449a {
        private final ArrayList<Long> egz = new ArrayList<>();

        public C8449a(long j) {
            while (j != 0) {
                mo34332bj(j);
                j >>= 4;
            }
        }

        public synchronized long aJa() {
            long j;
            j = 0;
            if (this.egz.size() > 0) {
                j = ((Long) this.egz.remove(this.egz.size() - 1)).longValue();
            }
            return j & 15;
        }

        public synchronized long aJb() {
            long j;
            j = 0;
            int size = this.egz.size();
            if (size > 0) {
                j = ((Long) this.egz.get(size - 1)).longValue();
            }
            return j & 15;
        }

        /* renamed from: bj */
        public final synchronized void mo34332bj(long j) {
            this.egz.add(Long.valueOf(j & 15));
        }

        public synchronized String toString() {
            long j;
            j = 0;
            for (int i = 0; i < this.egz.size(); i++) {
                j |= ((Long) this.egz.get(i)).longValue() << (i * 4);
            }
            return String.valueOf(j);
        }

        /* renamed from: um */
        public synchronized long mo34334um(int i) {
            long j;
            j = 0;
            if (this.egz.size() > i && i >= 0) {
                j = ((Long) this.egz.get(i)).longValue();
            }
            return j & 15;
        }
    }

    private C8446b() {
    }

    public static synchronized C8446b aIZ() {
        C8446b bVar;
        synchronized (C8446b.class) {
            if (egv == null) {
                egv = new C8446b();
            }
            bVar = egv;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: cK */
    public void m24443cK(List<C8445a> list) {
        if (list != null) {
            this.egw.clear();
            this.egw.addAll(list);
        }
    }

    /* renamed from: g */
    public static boolean m24444g(C8445a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.strPrjExportURL) && C8548e.isFileExisted(aVar.strPrjExportURL) && aVar.iIsModified != 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public int mo34315a(Context context, DataItemProject dataItemProject) {
        if (dataItemProject != null) {
            if (dataItemProject.isCameraPipMode()) {
                return 2;
            }
            int bh = aIZ().mo34321bh(dataItemProject._id);
            if (bh == 10) {
                return bh;
            }
        }
        return 6;
    }

    /* renamed from: am */
    public void mo34316am(Context context, int i) {
        List ao = C8404c.m24234ao(i, false);
        if (ao != null) {
            synchronized (this.egw) {
                this.egw.clear();
                this.egw.addAll(ao);
            }
        }
    }

    /* renamed from: an */
    public C1834l<List<C8445a>> mo34317an(Context context, final int i) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, List<C8445a>>() {
            /* renamed from: i */
            public List<C8445a> apply(Boolean bool) {
                List<C8445a> ao = C8404c.m24234ao(i, false);
                C8446b.this.m24443cK(ao);
                return ao;
            }
        });
    }

    /* renamed from: ao */
    public C1834l<List<String>> mo34318ao(Context context, final int i) {
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, List<String>>() {
            /* renamed from: i */
            public List<String> apply(Boolean bool) {
                List<C8445a> ao = C8404c.m24234ao(i, false);
                C8446b.this.m24443cK(ao);
                ArrayList arrayList = new ArrayList();
                if (ao != null && ao.size() > 0) {
                    for (C8445a aVar : ao) {
                        arrayList.add(aVar.strPrjThumbnail);
                    }
                }
                return arrayList;
            }
        });
    }

    /* renamed from: b */
    public void mo34319b(Context context, long j, int i) {
        if (mo34321bh(j) != i) {
            int bg = C8404c.m24238bg(j);
            if (bg >= 0) {
                C8449a aVar = new C8449a((long) bg);
                aVar.mo34332bj((long) i);
                try {
                    C8404c.m24240j(j, (int) Long.parseLong(aVar.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo34320b(Context context, long j, String str) {
        if ("unknow".equals(C8404c.m24237bf(j)) && !TextUtils.isEmpty(str)) {
            C8404c.m24241j(j, str);
        }
    }

    /* renamed from: bh */
    public int mo34321bh(long j) {
        int bg = C8404c.m24238bg(j);
        if (bg < 0) {
            return 0;
        }
        long aJb = new C8449a((long) bg).aJb();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("stack info peekPrjTodo prjID=");
        sb.append(j);
        sb.append(";todoId=");
        sb.append(aJb);
        C8554j.m25007e(str, sb.toString());
        return (int) aJb;
    }

    /* renamed from: bi */
    public boolean mo34322bi(long j) {
        int bg = C8404c.m24238bg(j);
        if (bg >= 0) {
            C8449a aVar = new C8449a((long) bg);
            for (int i = 0; i < 4; i++) {
                long um = aVar.mo34334um(i);
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("stack info peekPrjTodo prjID=");
                sb.append(j);
                sb.append(";todoId=");
                sb.append(um);
                C8554j.m25007e(str, sb.toString());
                if (um == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getCount() {
        if (this.egw != null) {
            return this.egw.size();
        }
        return 0;
    }

    public List<C8445a> getList() {
        List<C8445a> list;
        synchronized (this.egw) {
            list = this.egw;
        }
        return list;
    }

    /* renamed from: j */
    public void mo34325j(Context context, long j) {
        C8404c.m24240j(j, 0);
    }

    /* renamed from: k */
    public int mo34326k(Context context, long j) {
        int bg = C8404c.m24238bg(j);
        if (bg < 0) {
            return 0;
        }
        C8449a aVar = new C8449a((long) bg);
        long aJa = aVar.aJa();
        try {
            C8404c.m24240j(j, (int) Long.parseLong(aVar.toString()));
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("stack info popPrjTodo prjID=");
            sb.append(j);
            sb.append(";todoId=");
            sb.append(aJa);
            C8554j.m25007e(str, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) aJa;
    }

    public void remove(int i) {
        synchronized (this.egw) {
            int size = this.egw.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (((C8445a) this.egw.get(size))._id == ((long) i)) {
                    this.egw.remove(size);
                    break;
                } else {
                    size--;
                }
            }
        }
    }
}
