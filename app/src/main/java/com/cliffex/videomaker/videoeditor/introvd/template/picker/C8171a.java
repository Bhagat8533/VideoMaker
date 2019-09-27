package com.introvd.template.picker;

import android.content.Context;
import com.introvd.template.picker.p369d.C8218b;
import java.util.ArrayList;

/* renamed from: com.introvd.template.picker.a */
public class C8171a {
    private static boolean bIV;
    private static ArrayList<String> cSq;
    public static int dXK;
    private static int dXL;
    private static int dXM;

    public static int aFo() {
        return dXL;
    }

    public static boolean aFp() {
        return bIV;
    }

    public static ArrayList<String> aFq() {
        return cSq;
    }

    /* renamed from: gE */
    public static int m23615gE(Context context) {
        if (context == null) {
            return 0;
        }
        return C8218b.m23733gH(context).heightPixels - dXL;
    }

    /* renamed from: iQ */
    public static void m23616iQ(boolean z) {
        bIV = z;
    }

    /* renamed from: iR */
    public static void m23617iR(boolean z) {
        C8186b.aFr().mo33293iS(z);
    }

    public static void init(Context context) {
        C8218b.init(context);
        dXK = C8218b.m23732O(context, 44);
    }

    /* renamed from: q */
    public static void m23618q(ArrayList<String> arrayList) {
        cSq = arrayList;
    }

    public static void reset() {
        dXM = 0;
        dXL = 0;
        cSq = null;
    }

    /* renamed from: sZ */
    public static void m23619sZ(int i) {
        dXM = i;
    }

    /* renamed from: ta */
    public static void m23620ta(int i) {
        dXL = i;
    }
}
