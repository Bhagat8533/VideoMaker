package com.introvd.template.camera.p232e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.introvd.template.camera.p233ui.p235b.C5058a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CpuFeatures;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p374q.C8344c;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.vivacamera.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.camera.e.e */
public class C5034e {
    private static int cbn;
    private static C5058a cbo;
    private static C5035a cbp;
    private static int[] cbq = new int[2];

    /* renamed from: com.introvd.template.camera.e.e$a */
    private static class C5035a {
        private SimpleDateFormat cbr;
        private long cbs;
        private int cbt;

        public C5035a(String str) {
            this.cbr = new SimpleDateFormat(str);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ao */
        public String mo25888ao(long j) {
            String format = this.cbr.format(new Date(j));
            if (j / 1000 == this.cbs / 1000) {
                this.cbt++;
                StringBuilder sb = new StringBuilder();
                sb.append(format);
                sb.append("_");
                sb.append(this.cbt);
                return sb.toString();
            }
            this.cbs = j;
            this.cbt = 0;
            return format;
        }
    }

    /* renamed from: R */
    public static String m13235R(Context context, int i) {
        return CameraCodeMgr.isCameraParamDefault(i) ? context.getResources().getString(R.string.xiaoying_str_cam_camera_mode_basic) : CameraCodeMgr.isCameraParamMV(i) ? context.getResources().getString(R.string.xiaoying_str_cam_camera_mode_mv) : CameraCodeMgr.isCameraParamPIP(i) ? context.getResources().getString(R.string.xiaoying_str_cam_camera_mode_pip) : CameraCodeMgr.isCameraParamFB(i) ? context.getResources().getString(R.string.xiaoying_str_cam_camera_mode_face_beauty) : CameraCodeMgr.isCameraParamPerfect(i) ? "Perfect" : context.getResources().getString(R.string.xiaoying_str_cam_camera_mode_basic);
    }

    /* renamed from: S */
    public static String m13236S(Context context, int i) {
        return CameraCodeMgr.isCameraParamDefault(i) ? "Basic" : CameraCodeMgr.isCameraParamMV(i) ? "MusicLens" : CameraCodeMgr.isCameraParamPIP(i) ? "Collage" : CameraCodeMgr.isCameraParamFB(i) ? "Selfie" : CameraCodeMgr.isCameraParamPerfect(i) ? "Perfect" : "";
    }

    /* renamed from: Y */
    private static int m13237Y(float f) {
        int round = Math.round(f);
        if (round < -1000) {
            return -1000;
        }
        if (round > 1000) {
            return 1000;
        }
        return round;
    }

    /* renamed from: YR */
    public static synchronized void m13238YR() {
        synchronized (C5034e.class) {
            if (cbo != null) {
                try {
                    cbo.dismiss();
                } catch (Exception unused) {
                }
                cbo = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: YS */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.common.MSize m13239YS() {
        /*
            r0 = 0
            com.introvd.template.sdk.b.b r1 = com.introvd.template.sdk.p381b.C8392b.aHk()     // Catch:{ all -> 0x006f }
            android.hardware.Camera r2 = android.hardware.Camera.open()     // Catch:{ all -> 0x006f }
            r1.mo33943a(r2)     // Catch:{ all -> 0x006d }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ all -> 0x006d }
            java.util.List r3 = r1.getSupportedPreviewSizes()     // Catch:{ all -> 0x006d }
            java.util.List r1 = r1.getSupportedVideoSizes()     // Catch:{ all -> 0x006d }
            if (r3 == 0) goto L_0x0022
            com.introvd.template.camera.b.l r4 = new com.introvd.template.camera.b.l     // Catch:{ all -> 0x006d }
            r4.<init>()     // Catch:{ all -> 0x006d }
            java.util.Collections.sort(r3, r4)     // Catch:{ all -> 0x006d }
        L_0x0022:
            if (r1 == 0) goto L_0x002c
            com.introvd.template.camera.b.l r4 = new com.introvd.template.camera.b.l     // Catch:{ all -> 0x006d }
            r4.<init>()     // Catch:{ all -> 0x006d }
            java.util.Collections.sort(r1, r4)     // Catch:{ all -> 0x006d }
        L_0x002c:
            r4 = 0
            if (r1 == 0) goto L_0x004a
            int r5 = r1.size()     // Catch:{ all -> 0x006d }
            if (r5 <= 0) goto L_0x004a
            java.lang.Object r0 = r1.get(r4)     // Catch:{ all -> 0x006d }
            android.hardware.Camera$Size r0 = (android.hardware.Camera.Size) r0     // Catch:{ all -> 0x006d }
            com.introvd.template.common.MSize r1 = new com.introvd.template.common.MSize     // Catch:{ all -> 0x006d }
            int r3 = r0.width     // Catch:{ all -> 0x006d }
            int r0 = r0.height     // Catch:{ all -> 0x006d }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x0049
            r2.release()
        L_0x0049:
            return r1
        L_0x004a:
            if (r3 == 0) goto L_0x0067
            int r1 = r3.size()     // Catch:{ all -> 0x006d }
            if (r1 <= 0) goto L_0x0067
            java.lang.Object r0 = r3.get(r4)     // Catch:{ all -> 0x006d }
            android.hardware.Camera$Size r0 = (android.hardware.Camera.Size) r0     // Catch:{ all -> 0x006d }
            com.introvd.template.common.MSize r1 = new com.introvd.template.common.MSize     // Catch:{ all -> 0x006d }
            int r3 = r0.width     // Catch:{ all -> 0x006d }
            int r0 = r0.height     // Catch:{ all -> 0x006d }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x0066
            r2.release()
        L_0x0066:
            return r1
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.release()
        L_0x006c:
            return r0
        L_0x006d:
            r0 = move-exception
            goto L_0x0072
        L_0x006f:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0072:
            if (r2 == 0) goto L_0x0077
            r2.release()
        L_0x0077:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p232e.C5034e.m13239YS():com.introvd.template.common.MSize");
    }

    /* renamed from: YT */
    public static int m13240YT() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("key_device_max_video_resolution", 0);
    }

    /* renamed from: a */
    private static MSize m13241a(int i, MSize mSize) {
        MSize mSize2 = new MSize();
        int i2 = mSize.width;
        int i3 = mSize.height;
        if (i >= 2) {
            if (i2 * i3 >= 307200) {
                i3 = 480;
                i2 = 480;
            }
        } else if (i2 * i3 >= 76800) {
            i3 = 240;
            i2 = 240;
        }
        mSize2.width = i2;
        mSize2.height = i3;
        return mSize2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6 >= 307200) goto L_0x0026;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.introvd.template.common.MSize m13242a(int r6, com.introvd.template.common.MSize r7, boolean r8) {
        /*
            com.introvd.template.common.MSize r0 = new com.introvd.template.common.MSize
            r0.<init>()
            int r1 = r7.width
            int r7 = r7.height
            r2 = 720(0x2d0, float:1.009E-42)
            r3 = 240(0xf0, float:3.36E-43)
            r4 = 480(0x1e0, float:6.73E-43)
            r5 = 2
            if (r6 < r5) goto L_0x002f
            int r6 = r1 * r7
            r3 = 921600(0xe1000, float:1.291437E-39)
            if (r6 < r3) goto L_0x0029
            if (r8 != 0) goto L_0x0026
            boolean r6 = com.introvd.template.sdk.utils.C8549f.aJd()
            if (r6 == 0) goto L_0x0026
            r7 = 720(0x2d0, float:1.009E-42)
            r4 = 720(0x2d0, float:1.009E-42)
            goto L_0x003c
        L_0x0026:
            r7 = 480(0x1e0, float:6.73E-43)
            goto L_0x003c
        L_0x0029:
            r8 = 307200(0x4b000, float:4.30479E-40)
            if (r6 < r8) goto L_0x003b
            goto L_0x0026
        L_0x002f:
            int r6 = r1 * r7
            r8 = 76800(0x12c00, float:1.0762E-40)
            if (r6 < r8) goto L_0x003b
            r7 = 240(0xf0, float:3.36E-43)
            r4 = 240(0xf0, float:3.36E-43)
            goto L_0x003c
        L_0x003b:
            r4 = r1
        L_0x003c:
            r0.width = r4
            r0.height = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p232e.C5034e.m13242a(int, com.introvd.template.common.MSize, boolean):com.introvd.template.common.MSize");
    }

    /* renamed from: a */
    public static MSize m13243a(int i, MSize mSize, boolean z, boolean z2, boolean z3) {
        MSize mSize2 = z3 ? z ? m13241a(i, mSize) : m13253b(i, mSize) : z ? m13242a(i, mSize, z2) : m13254b(i, mSize, z2);
        StringBuilder sb = new StringBuilder();
        sb.append("getXYCameraOutputSize cpuNum=");
        sb.append(i);
        sb.append(";isPortrait=");
        sb.append(z);
        sb.append(";bFrontCam=");
        sb.append(z2);
        sb.append(";1080P_SUPPORT=");
        sb.append(C8549f.aJc());
        sb.append(";HD_IMPORT=");
        sb.append(C8549f.aJd());
        sb.append(";RSize=");
        sb.append(mSize2);
        sb.append(";cameraSupportSize=");
        sb.append(mSize);
        LogUtils.m14222e("CameraUtil", sb.toString());
        return mSize2;
    }

    /* renamed from: a */
    private static MSize m13244a(MSize mSize, boolean z) {
        int i;
        int i2;
        MSize mSize2 = new MSize();
        int aHC = C8398b.aHC();
        if (aHC >= 5) {
            if (C8549f.aJd()) {
                i = QUtils.VIDEO_RES_720P_HEIGHT;
                i2 = QUtils.VIDEO_RES_720P_WIDTH;
            } else {
                i = 544;
                i2 = 960;
            }
        } else if (aHC >= 3) {
            i = 480;
            i2 = QUtils.VIDEO_RES_FWVGA_WIDTH;
        } else {
            i = 360;
            i2 = QUtils.VIDEO_RES_VGA_WIDTH;
        }
        mSize2.width = i;
        mSize2.height = i2;
        return mSize2;
    }

    /* renamed from: a */
    public static MSize m13245a(MSize mSize, boolean z, boolean z2) {
        MSize a = z ? m13244a(mSize, z2) : m13255b(mSize, z2);
        StringBuilder sb = new StringBuilder();
        sb.append("getXYCameraOutputSize GPUcount=");
        sb.append(C8398b.aHC());
        sb.append(";isPortrait=");
        sb.append(z);
        sb.append(";bFrontCam=");
        sb.append(z2);
        sb.append(";1080P_SUPPORT=");
        sb.append(C8549f.aJc());
        sb.append(";HD_IMPORT=");
        sb.append(C8549f.aJd());
        sb.append(";RSize=");
        sb.append(a);
        sb.append(";cameraSupportSize=");
        sb.append(mSize);
        LogUtils.m14222e("CameraUtil", sb.toString());
        return a;
    }

    /* renamed from: a */
    public static synchronized void m13246a(Context context, OnClickListener onClickListener) {
        synchronized (C5034e.class) {
            if (m13261dJ(context)) {
                if (cbo == null) {
                    cbo = new C5058a(context, onClickListener);
                }
                cbo.show();
            }
        }
    }

    /* renamed from: a */
    public static void m13247a(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) i);
        float f = (float) i2;
        float f2 = (float) i3;
        matrix.postScale(f / 2000.0f, f2 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f2 / 2.0f);
    }

    /* renamed from: a */
    public static void m13248a(RectF rectF, Rect rect) {
        rect.left = m13237Y(rectF.left);
        rect.top = m13237Y(rectF.top);
        rect.right = m13237Y(rectF.right);
        rect.bottom = m13237Y(rectF.bottom);
    }

    @TargetApi(17)
    /* renamed from: af */
    public static MSize m13249af(Activity activity) {
        Point point = new Point();
        if (activity == null || VERSION.SDK_INT < 17) {
            return new MSize();
        }
        activity.getWindowManager().getDefaultDisplay().getRealSize(point);
        return new MSize(point.x, point.y);
    }

    /* renamed from: aq */
    public static boolean m13250aq(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int intValue = 1 << Integer.valueOf(str).intValue();
            return (C8344c.m24058k(context, SocialServiceDef.UNION_KEY_TEMPLATE_INFO_NEW_FLAG, 0) & intValue) == intValue;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static int m13251b(C8522g gVar) {
        int i = (C8540q.m24976w(gVar.aHd()) ? 1 : 0) + false + (C8540q.m24892A(gVar.aHd()) ? 1 : 0);
        if (gVar.aJB() != null) {
            return gVar.aJB().getCount() - i;
        }
        return 0;
    }

    /* renamed from: b */
    public static long m13252b(float f, long j) {
        return (long) (((float) j) * f);
    }

    /* renamed from: b */
    private static MSize m13253b(int i, MSize mSize) {
        MSize mSize2 = new MSize();
        int i2 = mSize.width;
        int i3 = mSize.height;
        if (i >= 2) {
            if (i2 * i3 >= 235520) {
                i2 = QUtils.VIDEO_RES_VGA_WIDTH;
                i3 = 368;
            }
        } else if (i2 * i3 >= 76800) {
            i3 = i2 * 9 == i3 * 16 ? QDisplayContext.DISPLAY_ROTATION_180 : 240;
            i2 = 320;
        }
        mSize2.width = i2;
        mSize2.height = i3;
        return mSize2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (com.introvd.template.sdk.utils.C8549f.aJd() != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r8 >= 235520) goto L_0x0043;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.introvd.template.common.MSize m13254b(int r8, com.introvd.template.common.MSize r9, boolean r10) {
        /*
            com.introvd.template.common.MSize r0 = new com.introvd.template.common.MSize
            r0.<init>()
            int r1 = r9.width
            int r9 = r9.height
            r2 = 368(0x170, float:5.16E-43)
            r3 = 640(0x280, float:8.97E-43)
            r4 = 320(0x140, float:4.48E-43)
            r5 = 544(0x220, float:7.62E-43)
            r6 = 960(0x3c0, float:1.345E-42)
            r7 = 2
            if (r8 < r7) goto L_0x004e
            int r8 = r1 * r9
            r4 = 921600(0xe1000, float:1.291437E-39)
            if (r8 < r4) goto L_0x0035
            if (r10 != 0) goto L_0x0030
            boolean r8 = com.introvd.template.sdk.utils.C8549f.aJc()
            if (r8 == 0) goto L_0x0030
            boolean r8 = com.introvd.template.sdk.utils.C8549f.aJd()
            if (r8 == 0) goto L_0x0030
            r1 = 1280(0x500, float:1.794E-42)
            r9 = 720(0x2d0, float:1.009E-42)
            goto L_0x0063
        L_0x0030:
            r9 = 544(0x220, float:7.62E-43)
            r1 = 960(0x3c0, float:1.345E-42)
            goto L_0x0063
        L_0x0035:
            r4 = 522240(0x7f800, float:7.31814E-40)
            if (r8 < r4) goto L_0x0048
            if (r10 != 0) goto L_0x0043
            boolean r8 = com.introvd.template.sdk.utils.C8549f.aJd()
            if (r8 == 0) goto L_0x0043
            goto L_0x0030
        L_0x0043:
            r9 = 368(0x170, float:5.16E-43)
            r1 = 640(0x280, float:8.97E-43)
            goto L_0x0063
        L_0x0048:
            r10 = 235520(0x39800, float:3.30034E-40)
            if (r8 < r10) goto L_0x0063
            goto L_0x0043
        L_0x004e:
            int r8 = r1 * r9
            r10 = 76800(0x12c00, float:1.0762E-40)
            if (r8 < r10) goto L_0x0063
            int r1 = r1 * 9
            int r9 = r9 * 16
            if (r1 != r9) goto L_0x0060
            r9 = 180(0xb4, float:2.52E-43)
        L_0x005d:
            r1 = 320(0x140, float:4.48E-43)
            goto L_0x0063
        L_0x0060:
            r9 = 240(0xf0, float:3.36E-43)
            goto L_0x005d
        L_0x0063:
            r0.width = r1
            r0.height = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p232e.C5034e.m13254b(int, com.introvd.template.common.MSize, boolean):com.introvd.template.common.MSize");
    }

    /* renamed from: b */
    private static MSize m13255b(MSize mSize, boolean z) {
        int i;
        int i2;
        MSize mSize2 = new MSize();
        int aHC = C8398b.aHC();
        if (aHC >= 5) {
            if (C8549f.aJd()) {
                i = QUtils.VIDEO_RES_720P_WIDTH;
                i2 = QUtils.VIDEO_RES_720P_HEIGHT;
            } else {
                i = 960;
                i2 = 544;
            }
        } else if (aHC >= 3) {
            i = QUtils.VIDEO_RES_FWVGA_WIDTH;
            i2 = 480;
        } else {
            i = QUtils.VIDEO_RES_VGA_WIDTH;
            i2 = 360;
        }
        mSize2.width = i;
        mSize2.height = i2;
        return mSize2;
    }

    /* renamed from: c */
    public static int m13256c(ArrayList<Integer> arrayList) {
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Integer) it.next()).intValue();
        }
        return i;
    }

    /* renamed from: c */
    public static ArrayList<Integer> m13257c(C8522g gVar) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        QStoryboard aHd = gVar.aHd();
        if (aHd != null && aHd.getClipCount() > 0) {
            ProjectItem ahP = gVar.aHf();
            if (ahP != null) {
                C8443d dVar = ahP.mClipModelCacheList;
                for (int i = 0; i < dVar.getCount(); i++) {
                    C8440a tX = dVar.mo34307tX(i);
                    if (tX != null && !tX.isCover()) {
                        arrayList.add(Integer.valueOf(tX.aHV()));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: cg */
    public static int m13258cg(int i, int i2) {
        boolean z = true;
        if (i2 != -1) {
            int abs = Math.abs(i - i2);
            if (Math.min(abs, 360 - abs) < 50) {
                z = false;
            }
        }
        return z ? (((i + 45) / 90) * 90) % 360 : i2;
    }

    public static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: d */
    public static int m13259d(C8522g gVar) {
        QStoryboard aHd = gVar.aHd();
        if (aHd != null && aHd.getClipCount() > 0) {
            ProjectItem ahP = gVar.aHf();
            if (ahP != null) {
                C8443d dVar = ahP.mClipModelCacheList;
                int i = 0;
                for (int i2 = 0; i2 < dVar.getCount(); i2++) {
                    C8440a tX = dVar.mo34307tX(i2);
                    if (tX != null && !tX.isCover()) {
                        i += tX.aHV();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("mCurrentTotalTime : ");
                sb.append(i);
                LogUtils.m14223i("CameraUtil", sb.toString());
                return i;
            }
        }
        return 0;
    }

    /* renamed from: d */
    public static String m13260d(Context context, long j) {
        if (cbp == null) {
            cbp = new C5035a(context.getString(R.string.xiaoying_str_cam_video_file_name_format_notrans));
        }
        return cbp.mo25888ao(j);
    }

    /* renamed from: dJ */
    private static boolean m13261dJ(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getWindow() != null && !activity.isFinishing()) {
                return true;
            }
        }
        return false;
    }

    public static int getCpuNumber() {
        if (cbn > 0) {
            return cbn;
        }
        int cpuNumber = CpuFeatures.getCpuNumber();
        cbn = cpuNumber;
        return cpuNumber;
    }

    /* renamed from: jM */
    public static void m13262jM(int i) {
        AppPreferencesSetting.getInstance().setAppSettingInt("key_device_max_video_resolution", i);
    }

    /* renamed from: jN */
    public static String m13263jN(int i) {
        String str;
        String str2 = "";
        if (i < 0) {
            i = 0;
        }
        if (i >= 60000) {
            try {
                str = String.format(Locale.US, "%2d:%02d.%1d", new Object[]{Integer.valueOf(i / SocialServiceDef.SERVICE_TIME_DELAY_CHECKING), Integer.valueOf((i % SocialServiceDef.SERVICE_TIME_DELAY_CHECKING) / 1000), Integer.valueOf((i % 1000) / 100)});
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ex:");
                sb.append(e.getMessage());
                LogUtilsV2.m14227d(sb.toString());
            }
        } else {
            str = String.format(Locale.US, "%2d.%1d", new Object[]{Integer.valueOf(i / 1000), Integer.valueOf((i % 1000) / 100)});
        }
        str2 = str;
        return str2.trim();
    }

    /* renamed from: s */
    public static boolean m13264s(Context context, boolean z) {
        MSize screenSize = DeviceInfo.getScreenSize(context);
        return ((screenSize.height - context.getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height)) - screenSize.width) - context.getResources().getDimensionPixelSize(z ? R.dimen.v4_cam_default_shutter_layout_height : R.dimen.v6_cam_default_shutter_layout_height) < 0;
    }

    /* renamed from: t */
    public static int m13265t(Context context, boolean z) {
        int i = 0;
        if (!z) {
            return 0;
        }
        MSize screenSize = DeviceInfo.getScreenSize(context);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_top_bar_height);
        int i2 = screenSize.width;
        int dimensionPixelSize2 = ((screenSize.height - dimensionPixelSize) - i2) - context.getResources().getDimensionPixelSize(R.dimen.v6_cam_default_shutter_layout_height);
        if (dimensionPixelSize2 > 0) {
            i = dimensionPixelSize2 / 2;
        }
        return i;
    }
}
