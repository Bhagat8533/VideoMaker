package com.introvd.template.editor.videotrim.p288b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.introvd.template.common.LogUtils;
import com.introvd.template.crash.C5523b;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;

/* renamed from: com.introvd.template.editor.videotrim.b.f */
public class C6966f {
    private C6967a dpG;
    private C6967a dpH;
    private C6967a dpI;
    private int dpJ;
    private int dpK;
    private int dpL;
    private Config dpM;
    private int dpN;
    private int dpO;
    private boolean dpP;
    private boolean dpQ;
    private int dpR;
    public int dpS;
    public int dpT;
    public boolean dpU;
    private boolean dpV;
    private int dpW;

    /* renamed from: com.introvd.template.editor.videotrim.b.f$a */
    public class C6967a {
        C6967a dpX;
        C6967a dpY;
        Bitmap dpZ = null;
        int dqa = -1;
        boolean dqb = false;

        C6967a() {
        }
    }

    public C6966f(int i, int i2, Config config) {
        this.dpQ = false;
        this.dpR = 1;
        this.dpS = -1;
        this.dpT = 2;
        this.dpU = false;
        this.dpV = true;
        this.dpW = 0;
        this.dpN = 0;
        this.dpO = -1;
        this.dpQ = false;
        this.dpG = new C6967a();
        this.dpG.dpY = this.dpG;
        this.dpG.dpX = this.dpG;
        this.dpK = i;
        this.dpL = i2;
        this.dpM = Config.ARGB_8888;
        this.dpJ = 1;
        this.dpH = this.dpG;
        this.dpI = this.dpG;
        this.dpG.dpZ = acr();
    }

    private Bitmap acr() {
        try {
            return Bitmap.createBitmap(this.dpK, this.dpL, this.dpM);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error ");
            sb.append(e.getMessage());
            LogUtils.m14222e("error", sb.toString());
            return null;
        }
    }

    public int acs() {
        C6967a aVar = this.dpH;
        while (aVar != null) {
            if (aVar.dqb) {
                aVar = aVar.dpY;
                if (aVar == this.dpH) {
                    break;
                }
            } else {
                return aVar.dqa;
            }
        }
        return -1;
    }

    public int auA() {
        return this.dpW;
    }

    public Bitmap auy() {
        if (this.dpH == null) {
            return null;
        }
        return this.dpH.dpZ;
    }

    public void auz() {
        C6967a aVar = this.dpG;
        while (aVar != null) {
            if (aVar.dpZ != null) {
                aVar.dpZ = null;
            }
            aVar = aVar.dpY;
            if (aVar == this.dpG) {
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo30634b(int i, QBitmap qBitmap) {
        C6967a aVar = this.dpH;
        while (aVar != null) {
            if (aVar.dqa != i || aVar.dqb) {
                aVar = aVar.dpY;
                if (aVar == this.dpH) {
                    break;
                }
            } else {
                if (aVar.dpZ == null || aVar.dpZ.isRecycled()) {
                    aVar.dpZ = acr();
                }
                QAndroidBitmapFactory.transformQBitmapIntoBitmap(qBitmap, aVar.dpZ);
                aVar.dqb = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo30635c(int i, Bitmap bitmap) {
        C6967a aVar = this.dpH;
        while (aVar != null) {
            if (aVar.dqa != i || aVar.dqb) {
                aVar = aVar.dpY;
                if (aVar == this.dpH) {
                    break;
                }
            } else {
                if (aVar.dpZ == null || aVar.dpZ.isRecycled()) {
                    aVar.dpZ = acr();
                }
                try {
                    if (aVar.dpZ != null && !aVar.dpZ.isRecycled() && bitmap != null && !bitmap.isRecycled()) {
                        Canvas canvas = new Canvas(aVar.dpZ);
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
                        canvas.save();
                        aVar.dqb = true;
                    }
                } catch (NullPointerException e) {
                    C5523b.logException(e);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: db */
    public void mo30636db(int i, int i2) {
        if (i2 > this.dpO) {
            this.dpP = true;
        } else if (i < this.dpN) {
            this.dpP = false;
        }
        if (this.dpQ || this.dpN > i || this.dpO < i2) {
            this.dpQ = false;
            this.dpN = i;
            this.dpO = i2;
            if (this.dpU) {
                this.dpU = false;
                this.dpP = true;
                this.dpH = this.dpI.dpY;
            } else {
                if (this.dpP) {
                    C6967a aVar = this.dpH;
                    while (true) {
                        if (aVar == null) {
                            break;
                        } else if (aVar.dqa == i) {
                            this.dpH = aVar;
                            break;
                        } else {
                            aVar = aVar.dpY;
                            if (aVar == this.dpH) {
                                if (aVar.dqa != -1) {
                                    this.dpH = this.dpI.dpY;
                                }
                            }
                        }
                    }
                }
                if (!this.dpP) {
                    C6967a aVar2 = this.dpI;
                    while (true) {
                        if (aVar2 == null) {
                            break;
                        } else if (aVar2.dqa == i2) {
                            this.dpI = aVar2;
                            break;
                        } else {
                            aVar2 = aVar2.dpX;
                            if (aVar2 == this.dpI) {
                                if (aVar2.dqa != -1) {
                                    this.dpI = this.dpH.dpX;
                                }
                            }
                        }
                    }
                }
            }
            if (!this.dpP) {
                int i3 = this.dpW + i2;
                C6967a aVar3 = this.dpI;
                while (aVar3 != null && i3 >= this.dpW + i) {
                    if (aVar3.dqa != i3) {
                        aVar3.dqb = false;
                        Bitmap pZ = mo30642pZ(i3);
                        if (pZ != null) {
                            Canvas canvas = new Canvas(aVar3.dpZ);
                            canvas.drawBitmap(pZ, 0.0f, 0.0f, null);
                            canvas.save();
                            aVar3.dqb = true;
                        }
                        aVar3.dqa = i3;
                    }
                    if (i3 == this.dpW + i) {
                        this.dpH = aVar3;
                    }
                    i3 -= this.dpR;
                    aVar3 = aVar3.dpX;
                    if (aVar3 == this.dpI) {
                        break;
                    }
                }
            } else {
                int i4 = this.dpW + i;
                C6967a aVar4 = this.dpH;
                while (aVar4 != null && i4 <= this.dpW + i2) {
                    if (aVar4.dqa != i4) {
                        aVar4.dqb = false;
                        Bitmap pZ2 = mo30642pZ(i4);
                        if (pZ2 != null) {
                            Canvas canvas2 = new Canvas(aVar4.dpZ);
                            canvas2.drawBitmap(pZ2, 0.0f, 0.0f, null);
                            canvas2.save();
                            aVar4.dqb = true;
                        }
                        aVar4.dqa = i4;
                        if (i4 == this.dpW + i2) {
                            this.dpI = aVar4;
                        }
                    }
                    i4 += this.dpR;
                    aVar4 = aVar4.dpY;
                    if (aVar4 == this.dpH) {
                        break;
                    }
                }
            }
        }
    }

    public int getSize() {
        return this.dpJ;
    }

    /* renamed from: hC */
    public void mo30638hC(boolean z) {
        this.dpQ = true;
        if (z) {
            C6967a aVar = this.dpH;
            while (aVar != null) {
                aVar.dqb = false;
                if (aVar.dpZ != null && !aVar.dpZ.isRecycled()) {
                    aVar.dpZ.eraseColor(0);
                }
                aVar = aVar.dpY;
                if (aVar == this.dpH) {
                    return;
                }
            }
        }
    }

    /* renamed from: lN */
    public int mo30639lN(int i) {
        C6967a aVar = this.dpH;
        while (aVar != null) {
            if (aVar.dqa <= i || aVar.dqb) {
                aVar = aVar.dpY;
                if (aVar == this.dpH) {
                    break;
                }
            } else {
                return aVar.dqa;
            }
        }
        return -1;
    }

    /* renamed from: pX */
    public void mo30640pX(int i) {
        this.dpR = i;
    }

    /* renamed from: pY */
    public void mo30641pY(int i) {
        C6967a aVar = this.dpG;
        while (aVar.dpY != this.dpG) {
            aVar = aVar.dpY;
        }
        C6967a aVar2 = new C6967a();
        aVar2.dqa = i;
        aVar2.dpY = aVar.dpY;
        this.dpG.dpX = aVar2;
        aVar.dpY = aVar2;
        aVar2.dpX = aVar;
        try {
            if (!this.dpV) {
                aVar2.dpZ = acr();
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("error ");
            sb.append(th.getMessage());
            LogUtils.m14222e("error", sb.toString());
        }
        this.dpJ++;
    }

    /* renamed from: pZ */
    public Bitmap mo30642pZ(int i) {
        C6967a aVar = this.dpG;
        while (aVar != null) {
            if (aVar.dqa < 0 || Math.abs(aVar.dqa - i) > this.dpT || !aVar.dqb || aVar.dpZ.isRecycled()) {
                aVar = aVar.dpY;
                if (aVar == this.dpG) {
                    break;
                }
            } else {
                return aVar.dpZ;
            }
        }
        return null;
    }

    /* renamed from: qa */
    public Bitmap mo30643qa(int i) {
        C6967a aVar = this.dpG;
        while (aVar != null) {
            if (aVar.dqa < 0 || !aVar.dqb || aVar.dpZ.isRecycled()) {
                aVar = aVar.dpY;
                if (aVar == this.dpG) {
                    break;
                }
            } else {
                return aVar.dpZ;
            }
        }
        return null;
    }
}
