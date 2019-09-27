package com.introvd.template.editor.p261g.p262a;

import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;

/* renamed from: com.introvd.template.editor.g.a.d */
public class C6308d extends C6307c {
    EffectInfoModel cVT;
    EngineSubtitleInfoModel cVU;

    /* renamed from: com.introvd.template.editor.g.a.d$a */
    public static final class C6310a {
        /* access modifiers changed from: private */
        public C6312c cVP;
        /* access modifiers changed from: private */
        public ProjectItem cVQ;
        /* access modifiers changed from: private */
        public EffectInfoModel cVT;
        /* access modifiers changed from: private */
        public EngineSubtitleInfoModel cVU;
        /* access modifiers changed from: private */
        public int streamType;

        /* renamed from: a */
        public C6310a mo29280a(EngineSubtitleInfoModel engineSubtitleInfoModel) {
            this.cVU = engineSubtitleInfoModel;
            return this;
        }

        public C6308d any() {
            return new C6308d(this);
        }

        /* renamed from: e */
        public C6310a mo29282e(C6312c cVar) {
            this.cVP = cVar;
            return this;
        }

        /* renamed from: e */
        public C6310a mo29283e(ProjectItem projectItem) {
            this.cVQ = projectItem;
            return this;
        }

        /* renamed from: f */
        public C6310a mo29284f(EffectInfoModel effectInfoModel) {
            this.cVT = effectInfoModel;
            return this;
        }

        /* renamed from: nJ */
        public C6310a mo29285nJ(int i) {
            this.streamType = i;
            return this;
        }
    }

    private C6308d(C6310a aVar) {
        this.cVP = aVar.cVP;
        this.cVQ = aVar.cVQ;
        this.streamType = aVar.streamType;
        this.cVT = aVar.cVT;
        this.cVU = aVar.cVU;
    }

    public EffectInfoModel anx() {
        return this.cVT;
    }
}
