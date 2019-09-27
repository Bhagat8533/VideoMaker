package com.introvd.template.editor.p261g.p262a;

import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.sdk.model.editor.ProjectItem;

/* renamed from: com.introvd.template.editor.g.a.c */
public class C6307c implements Cloneable {
    C6312c cVP;
    ProjectItem cVQ;
    protected boolean cVS;
    int streamType;

    public C6307c() {
    }

    public C6307c(C6312c cVar, ProjectItem projectItem, int i) {
        this.cVP = cVar;
        this.cVQ = projectItem;
        this.streamType = i;
    }

    /* renamed from: anu */
    public C6307c clone() throws CloneNotSupportedException {
        C6307c cVar = (C6307c) super.clone();
        cVar.cVP = this.cVP;
        if (this.cVQ != null) {
            cVar.cVQ = this.cVQ.clone();
        }
        return cVar;
    }

    public ProjectItem anv() {
        return this.cVQ;
    }

    public C6312c anw() {
        return this.cVP;
    }

    /* renamed from: d */
    public void mo29274d(C6312c cVar) {
        this.cVP = cVar;
    }

    /* renamed from: d */
    public void mo29275d(ProjectItem projectItem) {
        this.cVQ = projectItem;
    }

    /* renamed from: gc */
    public void mo29276gc(boolean z) {
        this.cVS = z;
    }

    public boolean isVirtual() {
        return this.cVS;
    }

    public void setStreamType(int i) {
        this.streamType = i;
    }
}
