package com.introvd.template.camera.p229b;

import com.introvd.template.camera.model.PipSourceItem;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.camera.b.h */
public class C5006h {
    public static List<PipSourceItem> bQs;
    private int bQt = 2;
    private List<Integer> bQu = new ArrayList();
    private PipSourceItem bQv;

    /* renamed from: com.introvd.template.camera.b.h$a */
    public enum C5007a {
        UNKNOW,
        REAL_CAMERA,
        UN_REAL_CAMERA,
        STORYBOARD
    }

    public C5006h() {
        init();
    }

    /* renamed from: VO */
    public static int m12925VO() {
        int size = bQs.size();
        for (int i = 0; i < size; i++) {
            if (((PipSourceItem) bQs.get(i)).dataType == C5007a.REAL_CAMERA) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: jf */
    public static int m12926jf(int i) {
        return ((PipSourceItem) bQs.get(i)).mClipCount;
    }

    /* renamed from: VP */
    public int mo25596VP() {
        int size = bQs.size();
        for (int i = 0; i < size; i++) {
            if (((PipSourceItem) bQs.get(i)).dataType == C5007a.STORYBOARD) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: VQ */
    public List<Integer> mo25597VQ() {
        return this.bQu;
    }

    /* renamed from: VR */
    public boolean mo25598VR() {
        return -1 == mo25596VP();
    }

    /* renamed from: VS */
    public boolean mo25599VS() {
        return mo25606jd(0).mClipCount == 0 && mo25606jd(1).mClipCount == 0;
    }

    /* renamed from: VT */
    public boolean mo25600VT() {
        return (mo25606jd(0).mClipCount == 0 || mo25606jd(1).mClipCount == 0) ? false : true;
    }

    /* renamed from: Ve */
    public void mo25601Ve() {
        PipSourceItem jd = mo25606jd(0);
        PipSourceItem jd2 = mo25606jd(1);
        PipSourceItem pipSourceItem = new PipSourceItem();
        pipSourceItem.dataType = jd.dataType;
        pipSourceItem.mClipCount = jd.mClipCount;
        pipSourceItem.mQpipSourceMode = jd.mQpipSourceMode;
        jd.dataType = jd2.dataType;
        jd.mClipCount = jd2.mClipCount;
        jd.mQpipSourceMode = jd2.mQpipSourceMode;
        jd2.dataType = pipSourceItem.dataType;
        jd2.mClipCount = pipSourceItem.mClipCount;
        jd2.mQpipSourceMode = pipSourceItem.mQpipSourceMode;
    }

    /* renamed from: a */
    public void mo25602a(int i, C5007a aVar) {
        this.bQv = (PipSourceItem) bQs.get(i);
        this.bQv.dataType = aVar;
    }

    /* renamed from: bY */
    public void mo25603bY(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        ((PipSourceItem) bQs.get(i)).mClipCount = i2;
    }

    public int getElementCount() {
        return bQs.size();
    }

    public void init() {
        if (bQs == null) {
            bQs = new ArrayList();
        }
        bQs.clear();
        for (int i = 0; i < this.bQt; i++) {
            PipSourceItem pipSourceItem = new PipSourceItem();
            if (i == 0) {
                pipSourceItem.dataType = C5007a.REAL_CAMERA;
            } else {
                pipSourceItem.dataType = C5007a.UN_REAL_CAMERA;
            }
            bQs.add(pipSourceItem);
        }
        this.bQu.clear();
    }

    /* renamed from: jd */
    public PipSourceItem mo25606jd(int i) {
        return (PipSourceItem) bQs.get(i);
    }

    /* renamed from: je */
    public void mo25607je(int i) {
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.bQu.size()) {
                break;
            } else if (((Integer) this.bQu.get(i2)).intValue() == i) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            this.bQu.add(Integer.valueOf(i));
        }
    }
}
