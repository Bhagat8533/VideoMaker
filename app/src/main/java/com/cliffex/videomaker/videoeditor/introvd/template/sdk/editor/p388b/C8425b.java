package com.introvd.template.sdk.editor.p388b;

import com.introvd.template.sdk.utils.C8554j;

/* renamed from: com.introvd.template.sdk.editor.b.b */
public class C8425b extends Thread {
    private volatile int eeA = -1;
    private Object eeB = new Object();
    private C8426a eeC;
    private boolean eep = false;
    private volatile C8431d eeq;
    private volatile boolean eew = false;
    private volatile boolean eex = false;
    private volatile boolean eey = false;
    private volatile boolean eez = false;

    /* renamed from: com.introvd.template.sdk.editor.b.b$a */
    public interface C8426a {
        void abL();
    }

    public C8425b(C8431d dVar, boolean z, C8426a aVar) {
        this.eeq = dVar;
        this.eep = z;
        this.eeC = aVar;
    }

    public void aIq() {
        this.eex = true;
    }

    public void aIr() {
        synchronized (this.eeB) {
            this.eex = true;
            this.eeq = null;
        }
    }

    public boolean aIs() {
        return this.eeq != null && this.eeq.aIE();
    }

    /* renamed from: jm */
    public void mo34156jm(boolean z) {
        this.eez = false;
        this.eey = z;
    }

    public void run() {
        int i;
        int i2;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            if (!this.eew) {
                break;
            }
            long j = 50;
            synchronized (this.eeB) {
                i = this.eeA;
            }
            if (this.eeq != null) {
                if (Math.abs(i4 - i) >= 100 || (i4 == i3 && i >= 0)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append(" nTrickPlaySeekTime:");
                    sb.append(i);
                    C8554j.m25008i("PlayerSeekThread", sb.toString());
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!this.eep) {
                        synchronized (this.eeB) {
                            if (this.eeq != null) {
                                boolean uf = this.eeq.mo34196uf(i);
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("seekResult1:");
                                sb2.append(uf);
                                sb2.append(";time consume:");
                                sb2.append(currentTimeMillis3);
                                C8554j.m25008i("PlayerSeekThread", sb2.toString());
                            }
                        }
                    } else {
                        synchronized (this.eeB) {
                            if (this.eeq != null) {
                                boolean dE = this.eeq.mo34187dE(i, i4);
                                int aIx = this.eeq.aIx();
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("seekResult3:");
                                sb3.append(dE);
                                sb3.append(";seekResultTime=");
                                sb3.append(aIx);
                                sb3.append(";time consume:");
                                sb3.append(currentTimeMillis4);
                                C8554j.m25008i("PlayerSeekThread", sb3.toString());
                            }
                        }
                    }
                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                    j = currentTimeMillis5 >= 50 ? 20 : 50 - currentTimeMillis5;
                    i2 = i;
                } else {
                    i2 = i4;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("onSeekFinish mbStopTrickPlay =");
                sb4.append(this.eex);
                sb4.append(";mTrickPlaySeekTime=");
                sb4.append(this.eeA);
                C8554j.m25008i("PlayerSeekThread", sb4.toString());
                if (this.eey && !this.eez && i == this.eeA) {
                    this.eez = true;
                    if (this.eeC != null) {
                        this.eeC.abL();
                    }
                } else if (this.eex && i == this.eeA) {
                    this.eew = false;
                    if (this.eeC != null) {
                        this.eeC.abL();
                    }
                }
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i4 = i2;
                i3 = -1;
            } else {
                return;
            }
        }
    }

    public void seekTo(int i) {
        this.eeA = i;
    }

    public synchronized void start() {
        super.start();
        synchronized (this.eeB) {
            this.eew = true;
            this.eex = false;
            this.eeA = -1;
        }
    }
}
