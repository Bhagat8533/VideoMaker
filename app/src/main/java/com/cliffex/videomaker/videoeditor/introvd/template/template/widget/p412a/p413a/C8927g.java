package com.introvd.template.template.widget.p412a.p413a;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.introvd.template.template.widget.p412a.C8938d;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.introvd.template.template.widget.a.a.g */
public class C8927g implements Parent<C8924d>, Serializable {
    private boolean evI;
    private List<C8924d> evN;
    private String evO;
    private String evP;
    private int evQ;
    private boolean evR;
    private int evS;
    private int evT;
    private int evU;
    private boolean evV;
    private boolean evW;
    private C8938d evr;
    private String rollCode;

    /* renamed from: a */
    public void mo35525a(C8938d dVar) {
        this.evr = dVar;
    }

    public int aMQ() {
        return this.evQ;
    }

    public String aMR() {
        return this.rollCode;
    }

    public String aMS() {
        return this.evO;
    }

    public String aMT() {
        return this.evP;
    }

    public C8938d aMU() {
        return this.evr;
    }

    public boolean aMV() {
        return this.evR;
    }

    public int aMW() {
        return this.evU;
    }

    public int aMX() {
        return this.evS;
    }

    public int aMY() {
        return this.evT;
    }

    /* renamed from: de */
    public void mo35535de(List<C8924d> list) {
        this.evN = list;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8927g gVar = (C8927g) obj;
        if (this.rollCode != null) {
            z = this.rollCode.equals(gVar.rollCode);
        } else if (gVar.rollCode != null) {
            z = false;
        }
        return z;
    }

    public List<C8924d> getChildList() {
        return this.evN;
    }

    public int hashCode() {
        if (this.rollCode != null) {
            return this.rollCode.hashCode();
        }
        return 0;
    }

    public boolean isExpanded() {
        return this.evV;
    }

    public boolean isInitiallyExpanded() {
        return this.evW;
    }

    public boolean isSelected() {
        return this.evI;
    }

    /* renamed from: jI */
    public void mo35540jI(boolean z) {
        this.evR = z;
    }

    /* renamed from: qU */
    public void mo35541qU(String str) {
        this.rollCode = str;
    }

    /* renamed from: qV */
    public void mo35542qV(String str) {
        this.evO = str;
    }

    /* renamed from: qW */
    public void mo35543qW(String str) {
        this.evP = str;
    }

    public void setExpanded(boolean z) {
        this.evV = z;
    }

    public void setSelected(boolean z) {
        this.evI = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FilterParent{mChildItemList=");
        sb.append(this.evN);
        sb.append(", mFilterType=");
        sb.append(this.evr);
        sb.append(", mParentText='");
        sb.append(this.evO);
        sb.append('\'');
        sb.append(", mParentCover='");
        sb.append(this.evP);
        sb.append('\'');
        sb.append(", isNewFilter=");
        sb.append(this.evR);
        sb.append(", lockStatus=");
        sb.append(this.evS);
        sb.append(", downloadStatus=");
        sb.append(this.evT);
        sb.append(", downloadProgress=");
        sb.append(this.evU);
        sb.append(", isSelected=");
        sb.append(this.evI);
        sb.append(", mInitiallyExpanded=");
        sb.append(this.evW);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: vA */
    public void mo35547vA(int i) {
        this.evS = i;
    }

    /* renamed from: vB */
    public void mo35548vB(int i) {
        this.evT = i;
    }

    /* renamed from: vy */
    public void mo35549vy(int i) {
        this.evQ = i;
    }

    /* renamed from: vz */
    public void mo35550vz(int i) {
        this.evU = i;
    }
}
