package com.introvd.template.sdk.editor.cache;

import android.graphics.Rect;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.util.ArrayList;
import xiaoying.engine.storyboard.QClipPosition;

/* renamed from: com.introvd.template.sdk.editor.cache.b */
public class C8441b implements Comparable<C8441b> {
    private String cxY = "";
    private VeRange edX = null;
    private VeRange edY = null;
    private VeRange edZ = null;
    private ScaleRotateViewState eea;
    private int eeb = 0;
    private QClipPosition eec = null;
    public boolean eed = false;
    public float eee = 0.0f;
    public int eef = 50;
    public int eeg = 0;
    public Rect eeh = null;
    public ArrayList<C8418a> eei = null;
    public int groupId = 0;

    /* renamed from: a */
    public void mo34265a(VeRange veRange) {
        this.edX = veRange;
    }

    /* renamed from: a */
    public void mo34266a(QClipPosition qClipPosition) {
        this.eec = qClipPosition;
    }

    public VeRange aIb() {
        return this.edX;
    }

    public VeRange aIc() {
        return this.edY;
    }

    public int aId() {
        return this.eeb;
    }

    public QClipPosition aIe() {
        return this.eec;
    }

    public String aIf() {
        return this.cxY;
    }

    public ScaleRotateViewState aIg() {
        return this.eea;
    }

    /* renamed from: b */
    public void mo34273b(VeRange veRange) {
        this.edY = veRange;
    }

    /* renamed from: c */
    public int compareTo(C8441b bVar) {
        VeRange aIc = aIc();
        VeRange aIc2 = bVar.aIc();
        if (!(aIc == null || aIc2 == null)) {
            if (aIc.getmPosition() > aIc2.getmPosition()) {
                return 1;
            }
            if (aIc.getmPosition() < aIc2.getmPosition()) {
                return -1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    public void mo34275c(VeRange veRange) {
        this.edZ = veRange;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8441b)) {
            return false;
        }
        C8441b bVar = (C8441b) obj;
        if (this.groupId != bVar.groupId || this.eed != bVar.eed || Float.compare(bVar.eee, this.eee) != 0 || this.eef != bVar.eef || this.eeg != bVar.eeg) {
            return false;
        }
        if (this.edY == null ? bVar.edY != null : !this.edY.equals(bVar.edY)) {
            return false;
        }
        if (this.edZ == null ? bVar.edZ != null : !this.edZ.equals(bVar.edZ)) {
            return false;
        }
        if (this.eea == null ? bVar.eea == null : this.eea.equals(bVar.eea)) {
            return this.cxY == null ? bVar.cxY == null : this.cxY.equals(bVar.cxY);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.groupId * 31) + (this.edY != null ? this.edY.hashCode() : 0)) * 31) + (this.edZ != null ? this.edZ.hashCode() : 0)) * 31) + (this.eea != null ? this.eea.hashCode() : 0)) * 31) + (this.cxY != null ? this.cxY.hashCode() : 0)) * 31) + (this.eed ? 1 : 0)) * 31;
        if (this.eee != 0.0f) {
            i = Float.floatToIntBits(this.eee);
        }
        return ((((hashCode + i) * 31) + this.eef) * 31) + this.eeg;
    }

    /* renamed from: nG */
    public void mo34279nG(String str) {
        this.cxY = str;
    }

    /* renamed from: r */
    public void mo34280r(ScaleRotateViewState scaleRotateViewState) {
        this.eea = scaleRotateViewState;
    }

    /* renamed from: tW */
    public void mo34281tW(int i) {
        this.eeb = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EffectDataModel{groupId=");
        sb.append(this.groupId);
        sb.append(", mSrcVeRange=");
        sb.append(this.edX);
        sb.append(", mDestVeRange=");
        sb.append(this.edY);
        sb.append(", mRawDestVeRange=");
        sb.append(this.edZ);
        sb.append(", mScaleRotateViewState=");
        sb.append(this.eea);
        sb.append(", mEffectIndex=");
        sb.append(this.eeb);
        sb.append(", mStyle='");
        sb.append(this.cxY);
        sb.append('\'');
        sb.append(", mClipPosition=");
        sb.append(this.eec);
        sb.append(", bAddedByTheme=");
        sb.append(this.eed);
        sb.append(", effectLayerId=");
        sb.append(this.eee);
        sb.append(", audioMixValue=");
        sb.append(this.eef);
        sb.append(", dftEffectDuration=");
        sb.append(this.eeg);
        sb.append(", dftEffectRegion=");
        sb.append(this.eeh);
        sb.append('}');
        return sb.toString();
    }
}
