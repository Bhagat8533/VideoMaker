package com.introvd.template.camera.p229b;

import com.introvd.template.vivacamera.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.camera.b.b */
public class C4989b {
    private static List<C4990a> bOX = new ArrayList();
    private static List<C4990a> bOY = new ArrayList();
    private static List<C4990a> bOZ = new ArrayList();
    private static List<C4990a> bPa = new ArrayList();

    /* renamed from: com.introvd.template.camera.b.b$a */
    public static class C4990a {
        public int bPb = 0;
        public int bPc = 0;
        public int bPd = 0;
        public int bPe = 0;

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C4990a)) {
                return false;
            }
            C4990a aVar = (C4990a) obj;
            if (this.bPb != aVar.bPb) {
                return false;
            }
            if (this.bPc != aVar.bPc) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.bPb * 31) + this.bPc;
        }
    }

    static {
        C4990a aVar = new C4990a();
        aVar.bPb = 0;
        aVar.bPc = 1;
        aVar.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_normal;
        aVar.bPe = R.string.xiaoying_str_cam_camera_mode_basic;
        bOX.add(aVar);
        C4990a aVar2 = new C4990a();
        aVar2.bPb = 1;
        aVar2.bPc = 10;
        aVar2.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_fb;
        aVar2.bPe = R.string.xiaoying_str_cam_camera_mode_face_beauty;
        bOX.add(aVar2);
        C4990a aVar3 = new C4990a();
        aVar3.bPb = 3;
        aVar3.bPc = 6;
        aVar3.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_mv;
        aVar3.bPe = R.string.xiaoying_str_cam_camera_mode_mv;
        bOX.add(aVar3);
        C4990a aVar4 = new C4990a();
        aVar4.bPb = 4;
        aVar4.bPc = 9;
        aVar4.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_pip;
        aVar4.bPe = R.string.xiaoying_str_cam_camera_mode_pip;
        bOX.add(aVar4);
        C4990a aVar5 = new C4990a();
        aVar5.bPb = 4;
        aVar5.bPc = 9;
        aVar5.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_pip;
        aVar5.bPe = R.string.xiaoying_str_cam_camera_mode_pip;
        bOY.add(aVar5);
        C4990a aVar6 = new C4990a();
        aVar6.bPb = 3;
        aVar6.bPc = 6;
        aVar6.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_mv;
        aVar6.bPe = R.string.xiaoying_str_cam_camera_mode_mv;
        bOY.add(aVar6);
        C4990a aVar7 = new C4990a();
        aVar7.bPb = 1;
        aVar7.bPc = 10;
        aVar7.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_fb;
        aVar7.bPe = R.string.xiaoying_str_cam_camera_mode_face_beauty;
        bOY.add(aVar7);
        C4990a aVar8 = new C4990a();
        aVar8.bPb = 0;
        aVar8.bPc = 1;
        aVar8.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_normal;
        aVar8.bPe = R.string.xiaoying_str_cam_camera_mode_basic;
        bOY.add(aVar8);
        Collections.reverse(bOY);
        C4990a aVar9 = new C4990a();
        aVar9.bPb = 1;
        aVar9.bPc = 10;
        aVar9.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_fb;
        aVar9.bPe = R.string.xiaoying_str_cam_camera_mode_face_beauty;
        C4990a aVar10 = new C4990a();
        aVar10.bPb = 0;
        aVar10.bPc = 1;
        aVar10.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_normal;
        aVar10.bPe = R.string.xiaoying_str_cam_camera_mode_basic;
        C4990a aVar11 = new C4990a();
        aVar11.bPb = 3;
        aVar11.bPc = 6;
        aVar11.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_mv;
        aVar11.bPe = R.string.xiaoying_str_cam_camera_mode_mv;
        bOZ.add(aVar9);
        bOZ.add(aVar10);
        bOZ.add(aVar11);
        C4990a aVar12 = new C4990a();
        aVar12.bPb = 6;
        aVar12.bPc = 12;
        aVar12.bPd = R.drawable.v4_xiaoying_cam_btn_cam_mode_funny;
        bPa.add(aVar12);
    }

    /* renamed from: A */
    public static int[] m12745A(int i, boolean z) {
        int i2;
        int i3 = z ? 256 : 512;
        switch (i) {
            case 0:
                if (!z) {
                    i3 = 512;
                    break;
                } else {
                    i3 = 256;
                    break;
                }
            case 1:
                i2 = 10;
                break;
            case 2:
                i2 = 7;
                break;
            case 3:
                i2 = 6;
                break;
            case 4:
                i2 = 9;
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 12;
                break;
        }
        i2 = 1;
        return new int[]{i3, i2};
    }

    /* renamed from: iP */
    public static List<C4990a> m12746iP(int i) {
        return i == 0 ? bOZ : i == 1 ? bPa : bOZ;
    }

    /* renamed from: z */
    public static int[] m12747z(int i, boolean z) {
        C4990a aVar = (C4990a) bOX.get(i);
        if (!z) {
            aVar = (C4990a) bOY.get(i);
        }
        return m12745A(aVar.bPb, z);
    }
}
