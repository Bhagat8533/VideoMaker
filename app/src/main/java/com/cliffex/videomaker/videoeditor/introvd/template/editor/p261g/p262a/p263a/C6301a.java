package com.introvd.template.editor.p261g.p262a.p263a;

import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.sdk.model.editor.ProjectItem;
import java.util.List;

/* renamed from: com.introvd.template.editor.g.a.a.a */
public class C6301a extends C6307c {
    List<Integer> cCf;
    int cVV;
    int startPos;

    /* renamed from: com.introvd.template.editor.g.a.a.a$a */
    public static final class C6303a {
        /* access modifiers changed from: private */
        public List<Integer> cCf;
        /* access modifiers changed from: private */
        public C6312c cVP;
        /* access modifiers changed from: private */
        public ProjectItem cVQ;
        /* access modifiers changed from: private */
        public boolean cVS;
        /* access modifiers changed from: private */
        public int cVV = -1;
        /* access modifiers changed from: private */
        public int startPos = -1;
        /* access modifiers changed from: private */
        public int streamType;

        public C6301a anB() {
            return new C6301a(this);
        }

        /* renamed from: bc */
        public C6303a mo29261bc(List<Integer> list) {
            this.cCf = list;
            return this;
        }

        /* renamed from: f */
        public C6303a mo29262f(C6312c cVar) {
            this.cVP = cVar;
            return this;
        }

        /* renamed from: f */
        public C6303a mo29263f(ProjectItem projectItem) {
            this.cVQ = projectItem;
            return this;
        }

        /* renamed from: nK */
        public C6303a mo29264nK(int i) {
            this.streamType = i;
            return this;
        }

        /* renamed from: nL */
        public C6303a mo29265nL(int i) {
            this.startPos = i;
            return this;
        }

        /* renamed from: nM */
        public C6303a mo29266nM(int i) {
            this.cVV = i;
            return this;
        }
    }

    private C6301a(C6303a aVar) {
        this.startPos = -1;
        this.cVV = -1;
        mo29274d(aVar.cVP);
        mo29275d(aVar.cVQ);
        setStreamType(aVar.streamType);
        mo29276gc(aVar.cVS);
        this.cCf = aVar.cCf;
        this.startPos = aVar.startPos;
        this.cVV = aVar.cVV;
    }

    public List<Integer> aeK() {
        return this.cCf;
    }

    public int anA() {
        return this.cVV;
    }

    public int anz() {
        return this.startPos;
    }
}
