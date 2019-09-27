package com.introvd.template.camera.p229b;

import com.mediarecorder.engine.QPIPFrameParam;
import java.util.ArrayList;

/* renamed from: com.introvd.template.camera.b.i */
public class C5008i {
    private static volatile C5008i bQB;
    private int bMt = 0;
    private int bOy;
    private int bOz;
    private int bQC;
    private volatile boolean bQD;
    private int bQE;
    private boolean bQF;
    private ArrayList<Integer> bQG = new ArrayList<>();
    private boolean bQH = false;
    private boolean bQI = false;
    private boolean bQJ = false;
    private boolean bQK = false;
    private boolean bQL = false;
    private boolean bQM = false;
    private boolean bQN = false;
    private boolean bQO = false;
    private int bQP = 0;
    private boolean bQQ = true;
    private int bQR = -1;
    private int bQS = 11;
    private QPIPFrameParam bQT;
    private boolean bQU = false;
    private boolean bQV = false;
    private boolean bQW = false;
    private boolean bQX = false;
    private ArrayList<Integer> bQY = new ArrayList<>();
    private int captureMode;
    private int mClipCount;

    private C5008i() {
    }

    /* renamed from: VU */
    public static C5008i m12937VU() {
        if (bQB == null) {
            bQB = new C5008i();
        }
        return bQB;
    }

    /* renamed from: Ul */
    public boolean mo25608Ul() {
        return this.bQD;
    }

    /* renamed from: VV */
    public int mo25609VV() {
        return this.captureMode;
    }

    /* renamed from: VW */
    public int mo25610VW() {
        return this.bOz;
    }

    /* renamed from: VX */
    public int mo25611VX() {
        return this.bQE;
    }

    /* renamed from: VY */
    public boolean mo25612VY() {
        return this.bQF;
    }

    /* renamed from: VZ */
    public ArrayList<Integer> mo25613VZ() {
        return this.bQG;
    }

    /* renamed from: Wa */
    public boolean mo25614Wa() {
        return this.bQH;
    }

    /* renamed from: Wb */
    public boolean mo25615Wb() {
        return this.bQI;
    }

    /* renamed from: Wc */
    public boolean mo25616Wc() {
        return this.bQJ;
    }

    /* renamed from: Wd */
    public boolean mo25617Wd() {
        return this.bQK;
    }

    /* renamed from: We */
    public boolean mo25618We() {
        return this.bQL;
    }

    /* renamed from: Wf */
    public boolean mo25619Wf() {
        return this.bQM;
    }

    /* renamed from: Wg */
    public boolean mo25620Wg() {
        return this.bQN;
    }

    /* renamed from: Wh */
    public boolean mo25621Wh() {
        return this.bQQ;
    }

    /* renamed from: Wi */
    public int mo25622Wi() {
        return this.bQR;
    }

    /* renamed from: Wj */
    public int mo25623Wj() {
        return this.bQS;
    }

    /* renamed from: Wk */
    public QPIPFrameParam mo25624Wk() {
        return this.bQT;
    }

    /* renamed from: Wl */
    public boolean mo25625Wl() {
        return this.bQU;
    }

    /* renamed from: Wm */
    public boolean mo25626Wm() {
        return this.bQV;
    }

    /* renamed from: Wn */
    public boolean mo25627Wn() {
        return this.bQW;
    }

    /* renamed from: Wo */
    public boolean mo25628Wo() {
        return this.bQX;
    }

    /* renamed from: Wp */
    public boolean mo25629Wp() {
        return this.captureMode == 0;
    }

    /* renamed from: Wq */
    public boolean mo25630Wq() {
        return this.captureMode == 1;
    }

    /* renamed from: a */
    public void mo25631a(QPIPFrameParam qPIPFrameParam) {
        this.bQT = qPIPFrameParam;
    }

    /* renamed from: a */
    public void mo25632a(ArrayList<Integer> arrayList) {
        this.bQG = arrayList;
    }

    /* renamed from: cI */
    public void mo25633cI(boolean z) {
        this.bQD = z;
    }

    /* renamed from: cJ */
    public void mo25634cJ(boolean z) {
        this.bQH = z;
    }

    /* renamed from: cK */
    public void mo25635cK(boolean z) {
        this.bQI = z;
    }

    /* renamed from: cL */
    public void mo25636cL(boolean z) {
        this.bQJ = z;
    }

    /* renamed from: cM */
    public void mo25637cM(boolean z) {
        this.bQK = z;
    }

    /* renamed from: cN */
    public void mo25638cN(boolean z) {
        this.bQL = z;
    }

    /* renamed from: cO */
    public void mo25639cO(boolean z) {
        this.bQM = z;
    }

    /* renamed from: cP */
    public void mo25640cP(boolean z) {
        this.bQN = z;
    }

    /* renamed from: cQ */
    public void mo25641cQ(boolean z) {
        this.bQQ = z;
    }

    /* renamed from: cR */
    public void mo25642cR(boolean z) {
        this.bQO = z;
    }

    /* renamed from: cS */
    public void mo25643cS(boolean z) {
        this.bQU = z;
    }

    /* renamed from: cT */
    public void mo25644cT(boolean z) {
        this.bQV = z;
    }

    /* renamed from: cU */
    public void mo25645cU(boolean z) {
        this.bQW = z;
    }

    /* renamed from: cV */
    public void mo25646cV(boolean z) {
        this.bQX = z;
    }

    public int getCameraMode() {
        return this.bOy;
    }

    public int getClipCount() {
        return this.mClipCount;
    }

    public int getDurationLimit() {
        return this.bMt;
    }

    public int getState() {
        return this.bQC;
    }

    public void init() {
        this.bQG.clear();
        this.bQY.clear();
        mo25653jh(256);
        mo25654ji(1);
        setState(-1);
        mo25655jj(0);
        mo25633cI(false);
        mo25656jk(0);
        setDeleteEnable(false);
        setDurationLimit(0);
        mo25634cJ(false);
        mo25635cK(false);
        mo25636cL(false);
        mo25637cM(false);
        mo25638cN(false);
        mo25639cO(false);
        mo25657jl(0);
        mo25640cP(false);
        mo25641cQ(true);
        mo25658jm(-1);
        mo25659jn(11);
        mo25631a((QPIPFrameParam) null);
        mo25643cS(false);
        mo25644cT(false);
        mo25645cU(false);
        mo25646cV(false);
        mo25652jg(0);
    }

    /* renamed from: jg */
    public void mo25652jg(int i) {
        this.captureMode = i;
    }

    /* renamed from: jh */
    public void mo25653jh(int i) {
        this.bOy = i;
    }

    /* renamed from: ji */
    public void mo25654ji(int i) {
        this.bOz = i;
    }

    /* renamed from: jj */
    public void mo25655jj(int i) {
        this.mClipCount = i;
    }

    /* renamed from: jk */
    public void mo25656jk(int i) {
        this.bQE = i;
    }

    /* renamed from: jl */
    public void mo25657jl(int i) {
        this.bQP = i;
    }

    /* renamed from: jm */
    public void mo25658jm(int i) {
        this.bQR = i;
    }

    /* renamed from: jn */
    public void mo25659jn(int i) {
        this.bQS = i;
    }

    public void setDeleteEnable(boolean z) {
        this.bQF = z;
    }

    public void setDurationLimit(int i) {
        this.bMt = i;
    }

    public void setState(int i) {
        this.bQC = i;
    }
}
