package com.introvd.template.p203b.p204a;

import com.introvd.template.p203b.p204a.p205a.C4567a;
import com.introvd.template.p203b.p204a.p205a.C4568b;
import com.introvd.template.p203b.p204a.p205a.C4569c;
import com.introvd.template.p203b.p204a.p205a.C4570d;

/* renamed from: com.introvd.template.b.a.b */
public enum C4571b {
    Standard(C4570d.class),
    SlideIn(C4569c.class),
    BaseEffectForEditor(C4568b.class);
    
    private Class<? extends C4567a> bLp;

    private C4571b(Class<? extends C4567a> cls) {
        this.bLp = cls;
    }

    /* renamed from: SC */
    public C4567a mo24844SC() {
        try {
            return (C4567a) this.bLp.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance", e);
        } catch (InstantiationException e2) {
            throw new Error("Can not init animatorClazz instance", e2);
        } catch (IllegalAccessException e3) {
            throw new Error("Can not init animatorClazz instance", e3);
        }
    }
}
