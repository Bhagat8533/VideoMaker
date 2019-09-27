package com.introvd.template.camera.p229b;

import android.hardware.Camera.Size;
import java.util.Comparator;

/* renamed from: com.introvd.template.camera.b.l */
public class C5015l implements Comparator<Size> {
    /* renamed from: a */
    public int compare(Size size, Size size2) {
        if (size == null || size2 == null) {
            return 0;
        }
        int i = (((long) (size.width * size.height)) > ((long) (size2.width * size2.height)) ? 1 : (((long) (size.width * size.height)) == ((long) (size2.width * size2.height)) ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }
}
