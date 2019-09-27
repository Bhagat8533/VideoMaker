package com.introvd.template.explorer.p300e.p301a.p302a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.introvd.template.explorer.e.a.a.d */
public class C7203d {
    static C7204a[] dFf = {C7196a.ayd(), C7199b.ayd(), C7201c.ayd(), C7206e.ayd()};
    static ArrayList<String> dFg = new ArrayList<>();
    static HashMap<String, C7204a> dFh = new HashMap<>();
    private static final char[] dFk = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected C7205b dFi = null;
    protected File dFj = null;

    /* renamed from: com.introvd.template.explorer.e.a.a.d$a */
    public interface C7204a {
        C7203d ayg();

        String[] ayh();
    }

    /* renamed from: com.introvd.template.explorer.e.a.a.d$b */
    public interface C7205b {
        /* renamed from: h */
        boolean mo31690h(double d);
    }

    static {
        C7204a[] aVarArr;
        String[] ayh;
        for (C7204a aVar : dFf) {
            for (String str : aVar.ayh()) {
                dFg.add(str);
                dFh.put(str, aVar);
            }
        }
    }

    protected C7203d() {
    }

    /* renamed from: a */
    public static C7203d m21277a(String str, C7205b bVar) throws FileNotFoundException, IOException {
        File file = new File(str);
        if (file.exists()) {
            String[] split = file.getName().toLowerCase().split("\\.");
            if (split.length < 2) {
                return null;
            }
            C7204a aVar = (C7204a) dFh.get(split[split.length - 1]);
            if (aVar == null) {
                return null;
            }
            C7203d ayg = aVar.ayg();
            ayg.mo31689a(bVar);
            ayg.mo31674A(file);
            return ayg;
        }
        throw new FileNotFoundException(str);
    }

    /* renamed from: A */
    public void mo31674A(File file) throws FileNotFoundException, IOException {
        this.dFj = file;
    }

    /* renamed from: a */
    public void mo31689a(C7205b bVar) {
        this.dFi = bVar;
    }

    public int[] aye() {
        return null;
    }

    /* renamed from: uj */
    public int mo31682uj() {
        return 0;
    }
}
