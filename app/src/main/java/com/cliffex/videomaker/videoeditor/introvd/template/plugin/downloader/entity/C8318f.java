package com.introvd.template.plugin.downloader.entity;

import com.introvd.template.plugin.downloader.p373d.C8300a;
import com.introvd.template.plugin.downloader.p373d.C8304e;
import com.introvd.template.plugin.downloader.p373d.C8305f;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.C9804ad;
import org.p489b.C9961b;
import org.p489b.C9963d;
import p037b.p050b.C1485a;
import p037b.p050b.C1510d;
import p037b.p050b.C1512e;
import p037b.p050b.C1521f;
import p037b.p050b.C1834l;
import p037b.p050b.p057e.C1513a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;

/* renamed from: com.introvd.template.plugin.downloader.entity.f */
public abstract class C8318f {
    /* access modifiers changed from: private */
    public long eax;
    protected C8339h eay;

    /* renamed from: com.introvd.template.plugin.downloader.entity.f$a */
    public static class C8326a extends C8318f {
        public C8326a(C8339h hVar) {
            super(hVar);
        }

        /* access modifiers changed from: protected */
        public C9961b<DownloadStatus> aGo() {
            return C1510d.m4708ag(new DownloadStatus(this.eay.getContentLength(), this.eay.getContentLength()));
        }

        /* access modifiers changed from: protected */
        public String aGp() {
            return "File already downloaded!";
        }
    }

    /* renamed from: com.introvd.template.plugin.downloader.entity.f$b */
    public static class C8327b extends C8318f {
        public C8327b(C8339h hVar) {
            super(hVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C9961b<DownloadStatus> m24016a(final int i, final C9804ad adVar) {
            C1510d aUe = C1510d.m4705a((C1521f<T>) new C1521f<DownloadStatus>() {
                /* renamed from: a */
                public void mo9850a(C1512e<DownloadStatus> eVar) throws Exception {
                    C8327b.this.eay.mo33562a(eVar, i, adVar);
                }
            }, C1485a.LATEST).mo9835wZ(1).aUe();
            return aUe.mo9824b(100, TimeUnit.MILLISECONDS).mo9829b((C9961b<? extends T>) aUe.mo9836xa(1)).mo9828b(C1820a.aVj());
        }

        /* renamed from: tq */
        private C9961b<DownloadStatus> m24018tq(final int i) {
            return this.eay.mo33593ts(i).mo9828b(C1820a.aVi()).mo9809a((C1518f<? super T, ? extends C9961b<? extends R>>) new C1518f<C9768m<C9804ad>, C9961b<DownloadStatus>>() {
                /* renamed from: g */
                public C9961b<DownloadStatus> apply(C9768m<C9804ad> mVar) throws Exception {
                    return C8327b.this.m24016a(i, (C9804ad) mVar.baI());
                }
            }).mo9813a(C8305f.m23977H(C8300a.m23946c("Range %d", Integer.valueOf(i)), this.eay.aGy()));
        }

        /* access modifiers changed from: protected */
        public C9961b<DownloadStatus> aGo() {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.eay.aGz(); i++) {
                arrayList.add(m24018tq(i));
            }
            return C1510d.m4710c((Iterable<? extends C9961b<? extends T>>) arrayList);
        }

        /* access modifiers changed from: protected */
        public String aGp() {
            return "Continue download prepare...";
        }

        /* access modifiers changed from: protected */
        public String aGq() {
            return "Continue download started...";
        }

        /* access modifiers changed from: protected */
        public String aGr() {
            return "Continue download completed!";
        }

        /* access modifiers changed from: protected */
        public String aGs() {
            return "Continue download failed!";
        }

        /* access modifiers changed from: protected */
        public String aGt() {
            return "Continue download cancel!";
        }

        /* access modifiers changed from: protected */
        public String aGu() {
            return "Continue download finish!";
        }
    }

    /* renamed from: com.introvd.template.plugin.downloader.entity.f$c */
    public static class C8330c extends C8327b {
        public C8330c(C8339h hVar) {
            super(hVar);
        }

        public void aGm() throws IOException, ParseException {
            super.aGm();
            this.eay.aGw();
        }

        /* access modifiers changed from: protected */
        public String aGp() {
            return "Multithreading download prepare...";
        }

        /* access modifiers changed from: protected */
        public String aGq() {
            return "Multithreading download started...";
        }

        /* access modifiers changed from: protected */
        public String aGr() {
            return "Multithreading download completed!";
        }

        /* access modifiers changed from: protected */
        public String aGs() {
            return "Multithreading download failed!";
        }

        /* access modifiers changed from: protected */
        public String aGt() {
            return "Multithreading download cancel!";
        }

        /* access modifiers changed from: protected */
        public String aGu() {
            return "Multithreading download finish!";
        }
    }

    /* renamed from: com.introvd.template.plugin.downloader.entity.f$d */
    public static class C8331d extends C8318f {
        public C8331d(C8339h hVar) {
            super(hVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public C9961b<DownloadStatus> m24022h(final C9768m<C9804ad> mVar) {
            return C1510d.m4705a((C1521f<T>) new C1521f<DownloadStatus>() {
                /* renamed from: a */
                public void mo9850a(C1512e<DownloadStatus> eVar) throws Exception {
                    C8331d.this.eay.mo33563a(eVar, mVar);
                }
            }, C1485a.LATEST);
        }

        public void aGm() throws IOException, ParseException {
            C8318f.super.aGm();
            this.eay.aGv();
        }

        /* access modifiers changed from: protected */
        public C9961b<DownloadStatus> aGo() {
            return this.eay.aGx().mo9828b(C1820a.aVi()).mo9809a((C1518f<? super T, ? extends C9961b<? extends R>>) new C1518f<C9768m<C9804ad>, C9961b<DownloadStatus>>() {
                /* renamed from: g */
                public C9961b<DownloadStatus> apply(C9768m<C9804ad> mVar) throws Exception {
                    return C8331d.this.m24022h(mVar);
                }
            }).mo9813a(C8305f.m23977H("Normal download", this.eay.aGy()));
        }

        /* access modifiers changed from: protected */
        public String aGp() {
            return "Normal download prepare...";
        }

        /* access modifiers changed from: protected */
        public String aGq() {
            return "Normal download started...";
        }

        /* access modifiers changed from: protected */
        public String aGr() {
            return "Normal download completed!";
        }

        /* access modifiers changed from: protected */
        public String aGs() {
            return "Normal download failed!";
        }

        /* access modifiers changed from: protected */
        public String aGt() {
            return "Normal download cancel!";
        }

        /* access modifiers changed from: protected */
        public String aGu() {
            return "Normal download finish!";
        }
    }

    private C8318f(C8339h hVar) {
        this.eax = 0;
        this.eay = hVar;
    }

    public void aGm() throws IOException, ParseException {
        C8304e.log(aGp());
    }

    public C1834l<DownloadStatus> aGn() {
        return C1510d.m4708ag(Boolean.valueOf(true)).mo9833c((C1517e<? super C9963d>) new C1517e<C9963d>() {
            /* renamed from: b */
            public void accept(C9963d dVar) throws Exception {
                C8304e.log(C8318f.this.aGq());
                C8318f.this.eay.start();
            }
        }).mo9809a((C1518f<? super T, ? extends C9961b<? extends R>>) new C1518f<Boolean, C9961b<DownloadStatus>>() {
            /* renamed from: E */
            public C9961b<DownloadStatus> apply(Boolean bool) throws Exception {
                return C8318f.this.aGo();
            }
        }).mo9814a(C1820a.aVi()).mo9827b((C1518f<? super T, ? extends R>) new C1518f<DownloadStatus, DownloadStatus>() {
            /* renamed from: d */
            public DownloadStatus apply(DownloadStatus downloadStatus) throws Exception {
                if (downloadStatus.aGk() - C8318f.this.eax > 100000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Thread: ");
                    sb.append(Thread.currentThread().getName());
                    sb.append(" update DB: ");
                    sb.append(downloadStatus.aGk());
                    C8304e.log(sb.toString());
                    C8318f.this.eax = downloadStatus.aGk();
                }
                C8318f.this.eay.mo33582f(downloadStatus);
                return downloadStatus;
            }
        }).mo9807a((C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C8304e.log(C8318f.this.aGs());
                C8318f.this.eay.error();
            }
        }).mo9832c((C1513a) new C1513a() {
            public void run() throws Exception {
                C8304e.log(C8318f.this.aGr());
                C8318f.this.eay.complete();
            }
        }).mo9825b((C1513a) new C1513a() {
            public void run() throws Exception {
                C8304e.log(C8318f.this.aGt());
                C8318f.this.eay.cancel();
            }
        }).mo9805a((C1513a) new C1513a() {
            public void run() throws Exception {
                C8304e.log(C8318f.this.aGu());
                C8318f.this.eay.finish();
            }
        }).aTS();
    }

    /* access modifiers changed from: protected */
    public abstract C9961b<DownloadStatus> aGo();

    /* access modifiers changed from: protected */
    public String aGp() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String aGq() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String aGr() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String aGs() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String aGt() {
        return "";
    }

    /* access modifiers changed from: protected */
    public String aGu() {
        return "";
    }
}
