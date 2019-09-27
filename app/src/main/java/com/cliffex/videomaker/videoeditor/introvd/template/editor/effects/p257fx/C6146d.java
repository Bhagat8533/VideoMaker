package com.introvd.template.editor.effects.p257fx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.fx.d */
public class C6146d implements Comparable<C6146d> {
    private int cLA = 0;
    private LinkedHashMap<Long, C6151i> cLB = new LinkedHashMap<>();
    private String cLz;
    private final String sceneCode;
    private final String sceneName;

    C6146d(String str, String str2) {
        this.sceneCode = str;
        this.sceneName = str2;
    }

    public List<C6151i> akA() {
        return new ArrayList(this.cLB.values());
    }

    public String akw() {
        return this.sceneCode;
    }

    public String akx() {
        return this.sceneName;
    }

    public String aky() {
        return this.cLz;
    }

    public void akz() {
        this.cLA++;
    }

    /* renamed from: b */
    public void mo28923b(C6151i iVar) {
        this.cLB.put(Long.valueOf(iVar.akN().mTemplateId), iVar);
    }

    /* renamed from: c */
    public int compareTo(C6146d dVar) {
        return dVar.cLA - this.cLA;
    }

    /* renamed from: hu */
    public void mo28926hu(String str) {
        this.cLz = str;
    }
}
