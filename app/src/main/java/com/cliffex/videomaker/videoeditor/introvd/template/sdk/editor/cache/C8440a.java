package com.introvd.template.sdk.editor.cache;

import android.graphics.Bitmap;
import com.introvd.template.router.editor.EditorRouter;
import xiaoying.engine.base.QRange;

/* renamed from: com.introvd.template.sdk.editor.cache.a */
public class C8440a implements Cloneable {
    private int edE;
    private int edF;
    private QRange edG;
    private QRange edH;
    private QRange edI;
    public QRange edJ;
    private int edK;
    private int edL;
    private int edM;
    private int edN;
    private String edO;
    private int edP = 0;
    private boolean edQ;
    private boolean edR = false;
    private int edS = 0;
    private boolean edT = false;
    private boolean edU = false;
    private boolean edV = false;
    private boolean edW = false;
    private int mClipIndex;
    private String mClipReverseFilePath;
    private int mTextCount;
    private volatile Bitmap mThumb;
    private int mType;

    public C8440a() {
    }

    public C8440a(C8440a aVar) {
        if (aVar != null) {
            this.edE = aVar.edE;
            this.edF = aVar.edF;
            this.mType = aVar.mType;
            this.mClipIndex = aVar.mClipIndex;
            this.mThumb = aVar.mThumb != null ? Bitmap.createBitmap(aVar.mThumb) : null;
            if (aVar.edG != null) {
                this.edG = new QRange(aVar.edG);
            }
            if (aVar.edI != null) {
                this.edI = new QRange(aVar.edI);
            }
            this.edW = aVar.edW;
            if (aVar.edH != null) {
                this.edH = aVar.edH;
            }
            this.edK = aVar.edK;
            this.edL = aVar.edL;
            this.mTextCount = aVar.mTextCount;
            this.edM = aVar.edM;
            this.edN = aVar.edN;
            this.edO = aVar.edO;
            this.edP = aVar.edP;
            this.edQ = aVar.edQ;
            this.edJ = new QRange(aVar.edJ);
            this.edS = aVar.edS;
        }
    }

    /* renamed from: a */
    public void mo34216a(QRange qRange) {
        this.edG = qRange;
    }

    /* renamed from: aHJ */
    public C8440a clone() throws CloneNotSupportedException {
        C8440a aVar = (C8440a) super.clone();
        if (this.mThumb != null) {
            aVar.mThumb = this.mThumb.copy(this.mThumb.getConfig(), false);
        }
        if (this.edG != null) {
            aVar.edG = new QRange(this.edG);
        }
        if (this.edH != null) {
            aVar.edH = new QRange(this.edH);
        }
        if (this.edI != null) {
            aVar.edI = new QRange(this.edI);
        }
        if (this.edJ != null) {
            aVar.edJ = new QRange(this.edJ);
        }
        return aVar;
    }

    public int aHK() {
        return this.edP;
    }

    public int aHL() {
        return this.mClipIndex;
    }

    public Bitmap aHM() {
        return this.mThumb;
    }

    public int aHN() {
        return this.edN;
    }

    public int aHO() {
        if (this.edK < 0) {
            return 0;
        }
        return this.edK;
    }

    public int aHP() {
        return this.mType;
    }

    public int aHQ() {
        return this.edE;
    }

    public int aHR() {
        return this.edF;
    }

    public int aHS() {
        return this.edL;
    }

    public QRange aHT() {
        return this.edG;
    }

    public String aHU() {
        return this.edO;
    }

    public int aHV() {
        if (this.edG != null) {
            if (!this.edW) {
                return this.edG.get(1);
            }
            if (this.edH != null) {
                return this.edF != 0 ? this.edF - this.edH.get(1) : this.edG.get(1) - this.edH.get(1);
            }
        }
        return 0;
    }

    public boolean aHW() {
        return this.edR;
    }

    public int aHX() {
        return this.edS;
    }

    public boolean aHY() {
        return this.edT;
    }

    public QRange aHZ() {
        return this.edH;
    }

    public boolean aIa() {
        return this.edW;
    }

    /* renamed from: b */
    public void mo34235b(QRange qRange) {
        this.edI = qRange;
    }

    /* renamed from: c */
    public void mo34236c(QRange qRange) {
        this.edH = qRange;
    }

    public String getmClipReverseFilePath() {
        return this.mClipReverseFilePath;
    }

    public boolean isClipReverse() {
        return this.edV;
    }

    public boolean isCover() {
        return aHP() == 3;
    }

    public boolean isImage() {
        return aHQ() == 2;
    }

    public boolean isbIsReverseMode() {
        return this.edU;
    }

    /* renamed from: jg */
    public void mo34243jg(boolean z) {
        this.edQ = z;
    }

    /* renamed from: jh */
    public void mo34244jh(boolean z) {
        this.edR = z;
    }

    /* renamed from: ji */
    public void mo34245ji(boolean z) {
        this.edT = z;
    }

    /* renamed from: jj */
    public void mo34246jj(boolean z) {
        this.edW = z;
    }

    /* renamed from: nF */
    public void mo34247nF(String str) {
        this.edO = str;
    }

    public void release() {
        if (this.mThumb != null) {
            this.mThumb = null;
        }
    }

    public void setIsClipReverse(boolean z) {
        this.edV = z;
    }

    public void setbIsReverseMode(boolean z) {
        this.edU = z;
    }

    public void setmClipReverseFilePath(String str) {
        this.mClipReverseFilePath = str;
    }

    /* renamed from: tL */
    public int mo34252tL(int i) {
        this.edP = i;
        return i;
    }

    /* renamed from: tM */
    public void mo34253tM(int i) {
        this.mClipIndex = i;
    }

    /* renamed from: tN */
    public void mo34254tN(int i) {
        this.edN = i;
    }

    /* renamed from: tO */
    public void mo34255tO(int i) {
        this.edK = i;
    }

    /* renamed from: tP */
    public void mo34256tP(int i) {
        this.mType = i;
    }

    /* renamed from: tQ */
    public void mo34257tQ(int i) {
        this.edE = i;
    }

    /* renamed from: tR */
    public void mo34258tR(int i) {
        this.edF = i;
    }

    /* renamed from: tS */
    public void mo34259tS(int i) {
        this.edL = i;
    }

    /* renamed from: tT */
    public void mo34260tT(int i) {
        this.mTextCount = i;
    }

    /* renamed from: tU */
    public void mo34261tU(int i) {
        this.edM = i;
    }

    /* renamed from: tV */
    public void mo34262tV(int i) {
        this.edS = i;
    }

    public String toString() {
        if (this.edG == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(mClipRange(");
        sb2.append(this.edG.get(0));
        sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb2.append(this.edG.get(1));
        sb2.append(")");
        sb.append(sb2.toString());
        return sb.toString();
    }

    /* renamed from: u */
    public void mo34264u(Bitmap bitmap) {
        this.mThumb = bitmap;
    }
}
