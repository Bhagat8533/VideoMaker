package com.introvd.template.editor.p261g.p262a;

import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.sdk.model.editor.ProjectItem;

/* renamed from: com.introvd.template.editor.g.a.a */
public class C6298a extends C6307c {
    private boolean cVO;
    private String path;

    /* renamed from: com.introvd.template.editor.g.a.a$a */
    public static final class C6300a {
        /* access modifiers changed from: private */
        public boolean cVO;
        /* access modifiers changed from: private */
        public C6312c cVP;
        /* access modifiers changed from: private */
        public ProjectItem cVQ;
        /* access modifiers changed from: private */
        public String path;
        /* access modifiers changed from: private */
        public int streamType;

        public C6298a ans() {
            return new C6298a(this);
        }

        /* renamed from: b */
        public C6300a mo29253b(C6312c cVar) {
            this.cVP = cVar;
            return this;
        }

        /* renamed from: b */
        public C6300a mo29254b(ProjectItem projectItem) {
            this.cVQ = projectItem;
            return this;
        }

        /* renamed from: gb */
        public C6300a mo29255gb(boolean z) {
            this.cVO = z;
            return this;
        }

        /* renamed from: ii */
        public C6300a mo29256ii(String str) {
            this.path = str;
            return this;
        }
    }

    private C6298a(C6300a aVar) {
        this.cVP = aVar.cVP;
        this.cVQ = aVar.cVQ;
        this.streamType = aVar.streamType;
        this.cVO = aVar.cVO;
        this.path = aVar.path;
    }
}
