package com.introvd.template.editor.p261g.p262a;

import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ProjectItem;

/* renamed from: com.introvd.template.editor.g.a.b */
public class C6304b extends C6307c {
    C8441b cVR;

    /* renamed from: com.introvd.template.editor.g.a.b$a */
    public static final class C6306a {
        /* access modifiers changed from: private */
        public C6312c cVP;
        /* access modifiers changed from: private */
        public ProjectItem cVQ;
        /* access modifiers changed from: private */
        public C8441b cVR;
        /* access modifiers changed from: private */
        public boolean cVS;
        /* access modifiers changed from: private */
        public int streamType;

        public C6304b ant() {
            return new C6304b(this);
        }

        /* renamed from: c */
        public C6306a mo29268c(C6312c cVar) {
            this.cVP = cVar;
            return this;
        }

        /* renamed from: c */
        public C6306a mo29269c(ProjectItem projectItem) {
            this.cVQ = projectItem;
            return this;
        }
    }

    private C6304b(C6306a aVar) {
        this.cVP = aVar.cVP;
        this.cVQ = aVar.cVQ;
        this.streamType = aVar.streamType;
        this.cVS = aVar.cVS;
        this.cVR = aVar.cVR;
    }
}
