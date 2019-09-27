package com.introvd.template.explorer.p300e.p301a.p302a;

import com.facebook.ads.AdError;
import com.flurry.android.Constants;
import com.giii.aiii.biii.auth.api.proxy.AuthApiStatusCodes;
import com.google.firebase.FirebaseError;
import com.introvd.template.explorer.p300e.p301a.p302a.C7203d.C7204a;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.todoCode.TodoConstants;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QError;

/* renamed from: com.introvd.template.explorer.e.a.a.b */
public class C7199b extends C7203d {
    private static int[] dEQ = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    private static int[] dER = {28753, 2785, 6594, 7413, 10444, 1269, 4423, 1556, 12820, 2498, 4833, 2498, 7864, 1884, 3153, 1802, 20193, 3031, 5857, 4014, 8970, 1392, 4096, 655, 13926, IronSourceConstants.BN_CALLBACK_CLICK, 4669, 2703, 6553, TodoConstants.TODO_TYPE_PLAY_VIDEO, 2662, 655, 23511, 2457, 5079, 4096, 8560, 737, 4259, 2088, 12288, 1474, 4628, 1433, AdError.INCORRECT_STATE_ERROR, 737, 2252, 1228, 17326, 2334, 5816, 3686, 8601, 778, 3809, IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND, 9256, 1761, 3522, 1966, 5529, 737, 3194, 778};
    private static int[] dES = {17333, -3431, 4235, 5276, 8325, -10422, 683, -8609, 10148, -4398, 1472, -4398, 5802, -6907, -2327, -7303, 14189, -2678, 3181, -180, 6972, -9599, 0, -16305, 10884, -2444, 1165, -3697, 4180, -13468, -3833, -16305, 15543, -4546, 1913, 0, 6556, -15255, 347, -5993, 9771, -9090, 1086, -9341, 4772, -15255, -5321, -10714, 12827, -5002, 3118, -938, 6598, -14774, -646, -16879, 7251, -7508, -1343, -6529, 2668, -15255, -2212, -2454, -14774};
    private static int[] dET = {159, -3776, -22731, HttpStatus.SC_PARTIAL_CONTENT, -3394, -20428, 268, -3005, -18088, 349, -2615, -15739, 419, -2345, -14113, 482, -2138, -12867, 554, -1932, -11629, 637, -1726, -10387, 733, -1518, -9139, 842, -1314, -7906, 969, -1106, -6656, 1114, -900, -5416, 1281, -694, -4173, 1473, -487, -2931, 1694, -281, -1688, 1948, -75, -445, 2241, 133, 801, 2577, 339, 2044, 2963, 545, 3285, 3408, 752, 4530, 3919, 958, 5772, 4507, 1165, 7016, 5183, 1371, 8259, 5960, 1577, 9501, 6855, 1784, 10745, 7883, 1991, 11988, 9065, 2197, 13231, 10425, 2404, 14474, 12510, 2673, 16096, 16263, 3060, 18429, 21142, 3448, 20763, 27485, 3836, 23097};
    private static int[] dEU = {812, 128, 542, IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 2873, 1135, 2266, 3402, 2067, 563, 12677, 647, QEffect.PROP_EFFECT_FRAME_BGSIZE, 1798, 5601, 5285, 7689, 374, 3735, TodoConstants.TODO_TYPE_EDITOR_CUSTOM_WATERMARK, 10912, 2638, 11807, 2494, QSlideShowSession.PROP_DEC_USE_TYPE, 797, 5218, 675, 6724, 8354, 5282, 1696, 1488, TodoConstants.TODO_TYPE_EDITOR_BASIC_FILTER, 5882, 452, 5332, 4072, 3583, 1268, 2469, TodoConstants.TODO_TYPE_PLAY_VIDEO, 15894, 1005, 14982, 3271, 10331, 4858, 3635, 2021, 2596, 835, 12360, 4892, 12206, 1704, 13432, 1604, 9118, 2341, 3968, 1538, 5479, 9936, 3795, 417, 1359, 414, 3640, 1569, 7995, 3541, 11405, 645, 8552, 635, 4056, 1377, 16608, 6124, 11420, 700, EditorModes.EFFECT_MOSAIC_MODE, IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, 12415, 1578, 11119, 4654, 13680, 1708, 11990, 1229, 7996, 7297, 13231, 5715, 2428, 1159, 2073, 1941, 6218, 6121, 3546, 1804, 8925, 1802, 8679, 1580, 13935, 3576, 13313, 6237, 6142, 1130, 5994, 1734, 14141, 4662, 11271, 3321, 12226, 1551, 13931, IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS, 5081, 10464, 9444, 6706, 1689, 683, 1436, 1306, 7212, 3933, 4082, 2713, 7793, 704, 15070, 802, 6299, 5212, 4337, 5357, 6676, 541, 6062, 626, 13651, 3700, 11498, 2408, 16156, 716, 12177, 751, 8065, 11489, 6314, 2256, 4466, 496, 7293, 523, 10213, 3833, 8394, 3037, 8403, 966, 14228, 1880, 8703, 5409, QStoryboard.PROP_OUTPUT_RESOLUTION, 4863, 7420, 1979, 6089, 1230, 9371, 4398, 14558, 3363, 13559, 2873, 13163, 1465, 5534, 1678, 13138, 14771, 7338, 600, 1318, 548, 4252, 3539, 10044, 2364, 10587, 622, 13088, 669, 14126, 3526, 5039, 9784, 15338, 619, IronSourceConstants.BN_CALLBACK_LEAVE_APP, 590, 16442, 3013, 15542, QEffect.PROP_EFFECT_DST_RATIO, 15537, 1611, 15405, 1228, 16023, 9299, 7534, 4976, 1990, 1213, 11447, 1157, 12512, 5519, 9475, 2644, 7716, 2034, 13280, 2239, 16011, 5093, 8066, 6761, 10083, 1413, 5002, 2347, 12523, 5975, 15126, 2899, 18264, 2289, 15827, 2527, 16265, 10254, 14651, 11319, 1797, 337, IronSourceConstants.BN_CALLBACK_LEAVE_APP, 397, 3510, 2928, 4592, 2670, 7519, 628, 11415, 656, 5946, 2435, 6544, 7367, 8238, 829, 4000, 863, 10032, 2492, 16057, 3551, 18204, IronSourceError.ERROR_DO_RV_CALL_LOAD_BEFORE_SHOW, 6103, 1454, 5884, 7900, 18752, 3468, 1864, 544, 9198, 683, 11623, QEffect.PROP_EFFECT_PS_EMITTER_POS_END, 4594, 1644, 3158, 1157, 15953, QUtils.VIDEO_RES_2K_WIDTH, 12349, 3733, 17420, 5260, 6106, 2004, 2917, 1742, 16467, 5257, 16787, 1680, 17205, 1759, 4773, 3231, 7386, 6035, 14342, 10012, 4035, TodoConstants.TODO_TYPE_VIDEO_EXTRACT_MUSIC, 4194, 458, 9214, 2242, 7427, 4217, 12860, 801, 11186, 825, 12648, 2084, 12956, 6554, 9505, 996, 6629, 985, 10537, 2502, 15289, 5006, 12602, 2055, 15484, 1653, 16194, 6921, 14231, 5790, 2626, 828, 5615, 1686, 13663, 5778, 3668, 1554, 11313, 2633, 9770, 1459, 14003, 4733, 15897, 6291, 6278, 1870, 7910, 2285, 16978, 4571, 16576, 3849, 15248, IronSourceConstants.IS_AUCTION_RESPONSE_WATERFALL, 16023, 3244, 14459, 17808, 11847, 2763, 1981, 1407, IronSourceConstants.RV_CAP_PLACEMENT, 876, 4335, 3547, 4391, 4210, 5405, 680, 17461, 781, 6501, 5118, 8091, 7677, 7355, 794, 8333, 1182, 15041, 3160, 14928, 3039, 20421, 880, 14545, 852, QClip.PROP_CLIP_IS_FRAME_MODE, 14708, 6904, QUtils.VIDEO_RES_1080P_WIDTH, 4225, TodoConstants.TODO_TYPE_SLIDE_VIDEO_PLAY, 8218, 1087, 10659, 4084, 10082, 4533, 2735, 840, 20657, 1081, 16711, 5966, 15873, 4578, 10871, 2574, 3773, 1166, 14519, 4044, 20699, 2627, 15219, 2734, 15274, 2186, 6257, 3226, 13125, 19480, 7196, 930, 2462, 1618, 4515, 3092, 13852, 4277, 10460, 833, 17339, 810, 16891, 2289, 15546, 8217, 13603, 1684, 3197, 1834, 15948, 2820, 15812, 5327, FirebaseError.ERROR_OPERATION_NOT_ALLOWED, 2438, 16788, 1326, 15671, 8156, 11726, 8556, 3762, 2053, 9563, 1317, 13561, 6790, 12227, 1936, 8180, 3550, 13287, 1778, 16299, 6599, 16291, 7758, 8521, 2551, 7225, 2645, 18269, 7489, 16885, 2248, 17882, 2884, 17265, 3328, 9417, 20162, 11042, 8320, 1286, 620, 1431, 583, 5993, 2289, 3978, 3626, 5144, 752, 13409, 830, 5553, 2860, 11764, 5908, 10737, 560, 5446, 564, 13321, IronSourceConstants.BN_INSTANCE_CLICK, 11946, 3683, 19887, 798, 9825, 728, 13663, 8748, 7391, 3053, 2515, 778, 6050, 833, 6469, 5074, 8305, 2463, 6141, 1865, 15308, 1262, 14408, 4547, 13663, 4515, 3137, 2983, 2479, 1259, 15088, 4647, 15382, 2607, 14492, 2392, 12462, 2537, 7539, 2949, 12909, 12060, 5468, 684, 3141, 722, 5081, 1274, 12732, 4200, 15302, 681, 7819, 592, 6534, 2021, 16478, 8737, 13364, 882, 5397, 899, 14656, 2178, 14741, 4227, 14270, 1298, 13929, 2029, 15477, 7482, 15815, 4572, 2521, 2013, 5062, 1804, 5159, 6582, 7130, 3597, 10920, 1611, 11729, 1708, 16903, 3455, 16268, 6640, 9306, 1007, 9369, 2106, 19182, 5037, 12441, 4269, 15919, 1332, 15357, 3512, 11898, 14141, 16101, 6854, 2010, 737, 3779, 861, 11454, 2880, 3564, 3540, 9057, 1241, 12391, 896, 8546, 4629, 11561, 5776, 8129, 589, 8218, 588, 18728, 3755, 12973, 3149, 15729, 758, 16634, 754, 15222, 11138, 15871, 2208, 4673, 610, 10218, 678, 15257, QEffect.PROP_EFFECT_POSITION_ALIGNMENT, 5729, 3327, 8377, 1670, 19862, 2321, 15450, 5511, 14054, 5481, 5728, 2888, 7580, 1346, 14384, 5325, 16236, 3950, 15118, 3744, 15306, 1435, 14597, 4070, 12301, 15696, 7617, 1699, 2170, 884, 4459, 4567, 18094, IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, 12742, 815, 14926, TodoConstants.TODO_TYPE_OPEN_APP_STORE, 15016, 4281, 15518, 8368, 17994, 1087, 2358, 865, 16281, 3787, 15679, 4596, 16356, 1534, 16584, IronSourceConstants.IS_INSTANCE_VISIBLE, 16833, 9697, 15929, 4513, 3277, 1085, 9643, 2187, 11973, 6068, 9199, 4462, 8955, 1629, 10289, 3062, 16481, 5155, 15466, 7066, 13678, 2543, 5273, 2277, 16746, 6213, 16655, 3408, 20304, 3363, 18688, 1985, 14172, 12867, 15154, 15703, 4473, 1020, 1681, 886, 4311, 4301, 8952, 3657, 5893, 1147, 11647, 1452, 15886, 2227, 4582, 6644, 6929, IronSourceConstants.RV_INSTANCE_ENDED, 6220, 799, 12415, 3409, 15968, 3877, 19859, 2109, 9689, 2141, 14742, 8830, 14480, 2599, 1817, 1238, 7771, 813, 19079, 4410, 5554, 2064, 3687, 2844, 17435, 2256, 16697, 4486, 16199, 5388, 8028, 2763, 3405, 2119, 17426, 5477, 13698, 2786, 19879, 2720, 9098, 3880, 18172, 4833, 17336, 12207, 5116, 996, 4935, 988, 9888, 3081, 6014, 5371, 15881, 1667, 8405, 1183, 15087, 2366, 19777, AdError.LOAD_CALLED_WHILE_SHOWING_AD, 11963, 1562, 7279, 1128, 16859, 1532, 15762, 5381, 14708, 2065, 20105, 2155, 17158, 8245, 17911, 6318, 5467, 1504, 4100, 2574, 17421, 6810, 5673, 2888, 16636, 3382, 8975, 1831, 20159, 4737, 19550, 7294, 6658, 2781, 11472, 3321, 19397, 5054, 18878, 4722, 16439, 2373, 20430, 4386, 11353, 26526, 11593, 3068, 2866, 1566, 5108, 1070, 9614, 4915, 4939, 3536, 7541, 878, 20717, 851, 6938, 4395, 16799, 7733, 10137, 1019, 9845, 964, 15494, 3955, 15459, 3430, 18863, 982, 20120, 963, 16876, 12887, 14334, 4200, 6599, 1220, 9222, 814, 16942, 5134, 5661, 4898, 5488, 1798, 20258, 3962, FirebaseError.ERROR_USER_DISABLED, 6178, 17929, 5929, 9365, 3420, 7474, 1971, 19537, 5177, 19003, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, 16454, 3788, 16070, 2367, 8664, 2743, 9445, 26358, 10856, 1287, 3555, 1009, 5606, 3622, 19453, 5512, 12453, 797, 20634, TodoConstants.TODO_TYPE_SHOW_FAQ, 15427, 3066, 17037, 10275, 18883, 2633, 3913, 1268, 19519, 3371, 18052, 5230, 19291, 1678, 19508, 3172, 18072, 10754, 16625, 6845, 3134, 2298, 10869, 2437, 15580, 6913, QError.QERR_HTTP_RESPONSE_301, 3381, 11116, 3297, 16762, 2424, 18853, 6715, 17171, 9887, 12743, 2605, 8937, 3140, 19033, 7764, 18347, 3880, 20475, 3682, 19602, 3380, 13044, 19373, 10526, 23124};
    private static int[] dEV = {0, 1, 3, 2, 5, 6, 4, 7};
    private static int[] dEW = {0, 3277, 6556, 8192, 9830, 11469, 12288, 13107, 13926, 14746, 15565, 16384, 17203, 18022, 18842, 19661};
    private int dEA;
    private int[] dEB;
    private int[] dEC;
    private int[] dED;
    private int dEE;
    private int dEJ;
    private int dEK;
    private int dEO;
    private int dEP;
    private int mOffset;

    public static C7204a ayd() {
        return new C7204a() {
            public C7203d ayg() {
                return new C7199b();
            }

            public String[] ayh() {
                return new String[]{"3gpp", "3gp", "amr"};
            }
        };
    }

    /* renamed from: f */
    private void m21268f(InputStream inputStream, int i) throws IOException {
        if (i >= 8) {
            byte[] bArr = new byte[8];
            inputStream.read(bArr, 0, 8);
            this.mOffset += 8;
            byte b = ((bArr[2] & Constants.UNKNOWN) << 8) | ((bArr[0] & Constants.UNKNOWN) << 24) | ((bArr[1] & Constants.UNKNOWN) << 16) | (bArr[3] & Constants.UNKNOWN);
            if (b <= i && b > 0) {
                if (bArr[4] == 109 && bArr[5] == 100 && bArr[6] == 97 && bArr[7] == 116) {
                    mo31688g(inputStream, b);
                    return;
                }
                int i2 = b - 8;
                inputStream.skip((long) i2);
                this.mOffset += i2;
                m21268f(inputStream, i - b);
            }
        }
    }

    /* renamed from: A */
    public void mo31674A(File file) throws FileNotFoundException, IOException {
        super.mo31674A(file);
        this.dEA = 0;
        this.dEP = 64;
        this.dEB = new int[this.dEP];
        this.dEC = new int[this.dEP];
        this.dED = new int[this.dEP];
        this.dEJ = 1000000000;
        this.dEK = 0;
        this.dEO = 10;
        this.mOffset = 0;
        this.dEE = (int) this.dFj.length();
        if (this.dEE >= 128) {
            FileInputStream fileInputStream = new FileInputStream(this.dFj);
            byte[] bArr = new byte[12];
            fileInputStream.read(bArr, 0, 6);
            this.mOffset += 6;
            if (bArr[0] == 35 && bArr[1] == 33 && bArr[2] == 65 && bArr[3] == 77 && bArr[4] == 82 && bArr[5] == 10) {
                mo31688g(fileInputStream, this.dEE - 6);
            }
            fileInputStream.read(bArr, 6, 6);
            this.mOffset += 6;
            if (bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112 && bArr[8] == 51 && bArr[9] == 103 && bArr[10] == 112 && bArr[11] == 52) {
                byte b = ((bArr[0] & Constants.UNKNOWN) << 24) | ((bArr[1] & Constants.UNKNOWN) << 16) | ((bArr[2] & Constants.UNKNOWN) << 8) | (bArr[3] & Constants.UNKNOWN);
                if (b >= 4 && b <= this.dEE - 8) {
                    int i = b - 12;
                    fileInputStream.skip((long) i);
                    this.mOffset += i;
                }
                m21268f(fileInputStream, this.dEE - b);
            }
            fileInputStream.close();
            return;
        }
        throw new IOException("File too small to parse");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: G */
    public void mo31685G(int i, int i2, int i3) {
        this.dEB[this.dEA] = i;
        this.dEC[this.dEA] = i2;
        this.dED[this.dEA] = i3;
        if (i3 < this.dEJ) {
            this.dEJ = i3;
        }
        if (i3 > this.dEK) {
            this.dEK = i3;
        }
        this.dEA++;
        if (this.dEA == this.dEP) {
            int i4 = this.dEP * 2;
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            for (int i5 = 0; i5 < this.dEA; i5++) {
                iArr[i5] = this.dEB[i5];
                iArr2[i5] = this.dEC[i5];
                iArr3[i5] = this.dED[i5];
            }
            this.dEB = iArr;
            this.dEC = iArr2;
            this.dED = iArr3;
            this.dEP = i4;
        }
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [int] */
    /* JADX WARNING: type inference failed for: r5v111, types: [int] */
    /* JADX WARNING: type inference failed for: r5v112 */
    /* JADX WARNING: type inference failed for: r5v114 */
    /* JADX WARNING: type inference failed for: r5v115 */
    /* JADX WARNING: type inference failed for: r5v116 */
    /* JADX WARNING: type inference failed for: r5v117 */
    /* JADX WARNING: type inference failed for: r5v118 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0056, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v112
      assigns: []
      uses: []
      mth insns count: 467
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0315 A[LOOP:7: B:66:0x0313->B:67:0x0315, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x032a A[LOOP:8: B:69:0x0328->B:70:0x032a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03c4  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo31686a(java.io.InputStream r24, int r25, int[] r26) throws java.io.IOException {
        /*
            r23 = this;
            r6 = r23
            r0 = r24
            r1 = r25
            int r7 = r6.mOffset
            r8 = 1
            byte[] r2 = new byte[r8]
            r9 = 0
            r0.read(r2, r9, r8)
            int r3 = r6.mOffset
            int r3 = r3 + r8
            r6.mOffset = r3
            byte r3 = r2[r9]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r10 = 3
            int r3 = r3 >> r10
            int r3 = r3 % 15
            byte r2 = r2[r9]
            int[] r2 = dEQ
            r2 = r2[r3]
            int r11 = r2 + 1
            if (r11 <= r1) goto L_0x0027
            return r1
        L_0x0027:
            if (r2 != 0) goto L_0x002a
            return r8
        L_0x002a:
            byte[] r1 = new byte[r2]
            r0.read(r1, r9, r2)
            int r0 = r6.mOffset
            int r0 = r0 + r2
            r6.mOffset = r0
            int r2 = r2 * 8
            int[] r4 = new int[r2]
            byte r0 = r1[r9]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r5 = r0
            r0 = 0
            r12 = 0
        L_0x003f:
            r13 = 7
            if (r0 >= r2) goto L_0x0059
            r14 = r5 & 128(0x80, float:1.794E-43)
            int r14 = r14 >> r13
            r4[r0] = r14
            int r5 = r5 << r8
            r14 = r0 & 7
            if (r14 != r13) goto L_0x0056
            int r13 = r2 + -1
            if (r0 >= r13) goto L_0x0056
            int r12 = r12 + 1
            byte r5 = r1[r12]
            r5 = r5 & 255(0xff, float:3.57E-43)
        L_0x0056:
            int r0 = r0 + 1
            goto L_0x003f
        L_0x0059:
            r12 = 30
            r14 = 40
            r5 = 5
            r2 = 4
            r1 = 2
            if (r3 == r13) goto L_0x0258
            r0 = 32
            switch(r3) {
                case 0: goto L_0x016f;
                case 1: goto L_0x0083;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported frame type: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            r6.mo31685G(r7, r11, r8)
        L_0x0080:
            r2 = r11
            goto L_0x03e9
        L_0x0083:
            r6.dEO = r5
            int[] r3 = new int[r2]
            r5 = 24
            r5 = r4[r5]
            int r5 = r5 * 1
            r13 = 25
            r13 = r4[r13]
            int r13 = r13 * 2
            int r5 = r5 + r13
            r13 = 26
            r13 = r4[r13]
            int r13 = r13 * 4
            int r5 = r5 + r13
            r13 = 36
            r13 = r4[r13]
            int r13 = r13 * 8
            int r5 = r5 + r13
            r13 = 45
            r13 = r4[r13]
            int r13 = r13 * 16
            int r5 = r5 + r13
            r13 = 55
            r13 = r4[r13]
            int r13 = r13 * 32
            int r5 = r5 + r13
            r3[r9] = r5
            r5 = 27
            r5 = r4[r5]
            int r5 = r5 * 1
            r13 = 28
            r13 = r4[r13]
            int r13 = r13 * 2
            int r5 = r5 + r13
            r13 = 29
            r13 = r4[r13]
            int r13 = r13 * 4
            int r5 = r5 + r13
            r13 = 37
            r13 = r4[r13]
            int r13 = r13 * 8
            int r5 = r5 + r13
            r13 = 46
            r13 = r4[r13]
            int r13 = r13 * 16
            int r5 = r5 + r13
            r13 = 56
            r13 = r4[r13]
            int r13 = r13 * 32
            int r5 = r5 + r13
            r3[r8] = r5
            r5 = r4[r12]
            int r5 = r5 * 1
            r12 = 31
            r12 = r4[r12]
            int r12 = r12 * 2
            int r5 = r5 + r12
            r12 = r4[r0]
            int r12 = r12 * 4
            int r5 = r5 + r12
            r12 = 38
            r12 = r4[r12]
            int r12 = r12 * 8
            int r5 = r5 + r12
            r12 = 47
            r12 = r4[r12]
            int r12 = r12 * 16
            int r5 = r5 + r12
            r12 = 57
            r12 = r4[r12]
            int r12 = r12 * 32
            int r5 = r5 + r12
            r3[r1] = r5
            r5 = 33
            r5 = r4[r5]
            int r5 = r5 * 1
            r12 = 34
            r12 = r4[r12]
            int r12 = r12 * 2
            int r5 = r5 + r12
            r12 = 35
            r12 = r4[r12]
            int r12 = r12 * 4
            int r5 = r5 + r12
            r12 = 39
            r12 = r4[r12]
            int r12 = r12 * 8
            int r5 = r5 + r12
            r12 = 48
            r12 = r4[r12]
            int r12 = r12 * 16
            int r5 = r5 + r12
            r12 = 58
            r4 = r4[r12]
            int r4 = r4 * 32
            int r5 = r5 + r4
            r3[r10] = r5
            r0 = 0
        L_0x0130:
            if (r0 >= r2) goto L_0x0080
            r4 = 385963008(0x17015400, float:4.178817E-25)
            r5 = r26[r9]
            int r5 = r5 * 5571
            int r5 = r5 + r4
            r4 = r26[r8]
            int r4 = r4 * 4751
            int r5 = r5 + r4
            r4 = r26[r1]
            int r4 = r4 * 2785
            int r5 = r5 + r4
            r4 = r26[r10]
            int r4 = r4 * 1556
            int r5 = r5 + r4
            int r4 = r5 >> 15
            int[] r5 = dES
            r12 = r3[r0]
            r5 = r5[r12]
            int[] r12 = dER
            r13 = r3[r0]
            r12 = r12[r13]
            r13 = r26[r1]
            r26[r10] = r13
            r13 = r26[r8]
            r26[r1] = r13
            r13 = r26[r9]
            r26[r8] = r13
            r26[r9] = r5
            int r4 = r4 * r12
            int r4 = r4 >> 24
            r6.mo31685G(r7, r11, r4)
            int r0 = r0 + 1
            goto L_0x0130
        L_0x016f:
            r6.dEO = r5
            int[] r3 = new int[r2]
            r5 = 28
            r5 = r4[r5]
            int r5 = r5 * 1
            r13 = 29
            r13 = r4[r13]
            int r13 = r13 * 2
            int r5 = r5 + r13
            r12 = r4[r12]
            int r12 = r12 * 4
            int r5 = r5 + r12
            r12 = 31
            r12 = r4[r12]
            int r12 = r12 * 8
            int r5 = r5 + r12
            r12 = 46
            r12 = r4[r12]
            int r12 = r12 * 16
            int r5 = r5 + r12
            r12 = 47
            r12 = r4[r12]
            int r12 = r12 * 32
            int r5 = r5 + r12
            r12 = 48
            r12 = r4[r12]
            int r12 = r12 * 64
            int r5 = r5 + r12
            r12 = 49
            r12 = r4[r12]
            int r12 = r12 * 128
            int r5 = r5 + r12
            r3[r9] = r5
            r5 = r3[r9]
            r3[r8] = r5
            r5 = r4[r0]
            int r5 = r5 * 1
            r12 = 33
            r12 = r4[r12]
            int r12 = r12 * 2
            int r5 = r5 + r12
            r12 = 34
            r12 = r4[r12]
            int r12 = r12 * 4
            int r5 = r5 + r12
            r12 = 35
            r12 = r4[r12]
            int r12 = r12 * 8
            int r5 = r5 + r12
            r12 = r4[r14]
            int r12 = r12 * 16
            int r5 = r5 + r12
            r12 = 41
            r12 = r4[r12]
            int r12 = r12 * 32
            int r5 = r5 + r12
            r0 = 42
            r0 = r4[r0]
            int r0 = r0 * 64
            int r5 = r5 + r0
            r0 = 43
            r0 = r4[r0]
            int r0 = r0 * 128
            int r5 = r5 + r0
            r3[r1] = r5
            r0 = r3[r1]
            r3[r10] = r0
            r0 = 0
        L_0x01e8:
            if (r0 >= r2) goto L_0x0080
            r4 = r3[r0]
            int r4 = r4 * 4
            r5 = r0 & 1
            int r5 = r5 * 2
            int r4 = r4 + r5
            int r4 = r4 + r8
            int[] r5 = dEU
            r4 = r5[r4]
            double r12 = (double) r4
            double r12 = java.lang.Math.log(r12)
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r14 = java.lang.Math.log(r14)
            double r12 = r12 / r14
            int r5 = (int) r12
            r17 = r3
            double r2 = (double) r5
            double r12 = r12 - r2
            r2 = 4674736413210574848(0x40e0000000000000, double:32768.0)
            double r12 = r12 * r2
            int r2 = (int) r12
            int r5 = r5 + -12
            r3 = 49320(0xc0a8, float:6.9112E-41)
            int r5 = r5 * r3
            int r2 = r2 * 24660
            int r2 = r2 >> 15
            int r2 = r2 * 2
            int r5 = r5 + r2
            int r5 = r5 * 8192
            r2 = 32768(0x8000, float:4.5918E-41)
            int r5 = r5 + r2
            int r2 = r5 >> 16
            r3 = 385963008(0x17015400, float:4.178817E-25)
            r5 = r26[r9]
            int r5 = r5 * 5571
            int r5 = r5 + r3
            r3 = r26[r8]
            int r3 = r3 * 4751
            int r5 = r5 + r3
            r3 = r26[r1]
            int r3 = r3 * 2785
            int r5 = r5 + r3
            r3 = r26[r10]
            int r3 = r3 * 1556
            int r5 = r5 + r3
            int r3 = r5 >> 15
            r5 = r26[r1]
            r26[r10] = r5
            r5 = r26[r8]
            r26[r1] = r5
            r5 = r26[r9]
            r26[r8] = r5
            r26[r9] = r2
            int r3 = r3 * r4
            int r2 = r3 >> 24
            r6.mo31685G(r7, r11, r2)
            int r0 = r0 + 1
            r3 = r17
            r2 = 4
            goto L_0x01e8
        L_0x0258:
            r0 = 12
            r6.dEO = r0
            r2 = 4
            int[] r3 = new int[r2]
            int[] r0 = new int[r2]
            int[] r12 = new int[r2]
            int[][] r13 = new int[r2][]
            r1 = 0
        L_0x0266:
            if (r1 >= r2) goto L_0x0272
            r2 = 10
            int[] r2 = new int[r2]
            r13[r1] = r2
            int r1 = r1 + 1
            r2 = 4
            goto L_0x0266
        L_0x0272:
            r15 = r0
            r0 = r23
            r2 = 2
            r1 = r4
            r4 = 2
            r8 = 4
            r2 = r3
            r16 = r3
            r3 = r15
            r4 = r12
            r10 = 5
            r5 = r13
            r0.mo31687a(r1, r2, r3, r4, r5)
            r0 = 0
            r1 = 0
        L_0x0285:
            if (r0 >= r8) goto L_0x0080
            int[] r2 = new int[r14]
            r3 = 0
        L_0x028a:
            if (r3 >= r14) goto L_0x0291
            r2[r3] = r9
            int r3 = r3 + 1
            goto L_0x028a
        L_0x0291:
            r3 = 0
        L_0x0292:
            if (r3 >= r10) goto L_0x02d0
            r4 = r13[r0]
            r4 = r4[r3]
            r5 = 3
            int r4 = r4 >> r5
            r5 = 1
            r4 = r4 & r5
            if (r4 != 0) goto L_0x02a1
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x02a3
        L_0x02a1:
            r4 = -4096(0xfffffffffffff000, float:NaN)
        L_0x02a3:
            int[] r5 = dEV
            r17 = r13[r0]
            r17 = r17[r3]
            r19 = 7
            r17 = r17 & 7
            r5 = r5[r17]
            int r5 = r5 * 5
            int r5 = r5 + r3
            int[] r17 = dEV
            r20 = r13[r0]
            int r21 = r3 + 5
            r20 = r20[r21]
            r20 = r20 & 7
            r17 = r17[r20]
            int r17 = r17 * 5
            int r8 = r3 + r17
            r2[r5] = r4
            if (r8 >= r5) goto L_0x02c7
            int r4 = -r4
        L_0x02c7:
            r5 = r2[r8]
            int r5 = r5 + r4
            r2[r8] = r5
            int r3 = r3 + 1
            r8 = 4
            goto L_0x0292
        L_0x02d0:
            r19 = 7
            r3 = r16[r0]
            if (r0 == 0) goto L_0x02f1
            r4 = 2
            if (r0 != r4) goto L_0x02da
            goto L_0x02f2
        L_0x02da:
            r5 = 18
            r8 = 143(0x8f, float:2.0E-43)
            int r1 = r1 - r10
            if (r1 >= r5) goto L_0x02e3
            r1 = 18
        L_0x02e3:
            int r5 = r1 + 9
            if (r5 <= r8) goto L_0x02e9
            r1 = 134(0x86, float:1.88E-43)
        L_0x02e9:
            int r3 = r3 + 5
            int r3 = r3 / 6
            int r1 = r1 + r3
            r3 = 1
            int r1 = r1 - r3
            goto L_0x0301
        L_0x02f1:
            r4 = 2
        L_0x02f2:
            r1 = 463(0x1cf, float:6.49E-43)
            if (r3 >= r1) goto L_0x02fe
            int r3 = r3 + 5
            int r3 = r3 / 6
            int r3 = r3 + 17
        L_0x02fc:
            r1 = r3
            goto L_0x0301
        L_0x02fe:
            int r3 = r3 + -368
            goto L_0x02fc
        L_0x0301:
            int[] r3 = dEW
            r5 = r15[r0]
            r3 = r3[r5]
            int r3 = r3 >> r4
            int r3 = r3 << r4
            r5 = 16383(0x3fff, float:2.2957E-41)
            if (r3 <= r5) goto L_0x0310
            r3 = 32767(0x7fff, float:4.5916E-41)
            goto L_0x0312
        L_0x0310:
            int r3 = r3 * 2
        L_0x0312:
            r5 = r1
        L_0x0313:
            if (r5 >= r14) goto L_0x0326
            r8 = r2[r5]
            int r17 = r5 - r1
            r17 = r2[r17]
            int r17 = r17 * r3
            int r17 = r17 >> 15
            int r8 = r8 + r17
            r2[r5] = r8
            int r5 = r5 + 1
            goto L_0x0313
        L_0x0326:
            r3 = 0
            r5 = 0
        L_0x0328:
            if (r3 >= r14) goto L_0x0334
            r8 = r2[r3]
            r17 = r2[r3]
            int r8 = r8 * r17
            int r5 = r5 + r8
            int r3 = r3 + 1
            goto L_0x0328
        L_0x0334:
            r2 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 <= r5) goto L_0x033f
            if (r5 >= 0) goto L_0x033c
            goto L_0x033f
        L_0x033c:
            int r5 = r5 * 2
            goto L_0x0342
        L_0x033f:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L_0x0342:
            r2 = 32768(0x8000, float:4.5918E-41)
            int r5 = r5 + r2
            int r2 = r5 >> 16
            r3 = 52428(0xcccc, float:7.3467E-41)
            int r2 = r2 * r3
            double r2 = (double) r2
            double r2 = java.lang.Math.log(r2)
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r20 = java.lang.Math.log(r20)
            double r2 = r2 / r20
            int r5 = (int) r2
            r22 = r11
            double r10 = (double) r5
            double r2 = r2 - r10
            r10 = 4674736413210574848(0x40e0000000000000, double:32768.0)
            double r2 = r2 * r10
            int r2 = (int) r2
            r3 = 30
            int r5 = r5 - r3
            int r5 = r5 << 16
            int r2 = r2 * 2
            int r5 = r5 + r2
            r2 = r26[r9]
            int r2 = r2 * 44
            r8 = 1
            r10 = r26[r8]
            int r10 = r10 * 37
            int r2 = r2 + r10
            r8 = r26[r4]
            int r8 = r8 * 22
            int r2 = r2 + r8
            r8 = 3
            r10 = r26[r8]
            int r10 = r10 * 12
            int r2 = r2 + r10
            int r2 = r2 * 2
            r8 = 783741(0xbf57d, float:1.098255E-39)
            int r2 = r2 + r8
            int r2 = r2 - r5
            int r2 = r2 / r4
            int r5 = r2 >> 16
            r8 = 1
            int r2 = r2 >> r8
            int r8 = r5 << 15
            int r2 = r2 - r8
            double r3 = (double) r5
            double r9 = (double) r2
            r17 = 4674736413210574848(0x40e0000000000000, double:32768.0)
            double r9 = r9 / r17
            double r3 = r3 + r9
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r8, r3)
            r4 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r2 = r2 + r4
            int r2 = (int) r2
            r3 = 2047(0x7ff, float:2.868E-42)
            if (r2 > r3) goto L_0x03a8
            int r2 = r2 << 4
            goto L_0x03aa
        L_0x03a8:
            r2 = 32767(0x7fff, float:4.5916E-41)
        L_0x03aa:
            r3 = r12[r0]
            int[] r4 = dET
            r5 = 3
            int r3 = r3 * 3
            r4 = r4[r3]
            int r2 = r2 * r4
            int r2 = r2 >> 15
            r4 = 1
            int r2 = r2 << r4
            r4 = r2 & -32768(0xffffffffffff8000, float:NaN)
            if (r4 == 0) goto L_0x03c4
            r2 = 32767(0x7fff, float:4.5916E-41)
            r2 = r22
            r4 = 32767(0x7fff, float:4.5916E-41)
            goto L_0x03c7
        L_0x03c4:
            r4 = r2
            r2 = r22
        L_0x03c7:
            r6.mo31685G(r7, r2, r4)
            int[] r4 = dET
            int r3 = r3 + 1
            r3 = r4[r3]
            r4 = 2
            r5 = r26[r4]
            r8 = 3
            r26[r8] = r5
            r5 = 1
            r9 = r26[r5]
            r26[r4] = r9
            r9 = 0
            r10 = r26[r9]
            r26[r5] = r10
            r26[r9] = r3
            int r0 = r0 + 1
            r11 = r2
            r8 = 4
            r10 = 5
            goto L_0x0285
        L_0x03e9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p300e.p301a.p302a.C7199b.mo31686a(java.io.InputStream, int, int[]):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31687a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[][] iArr5) {
        iArr2[0] = (iArr[45] * 1) + (iArr[43] * 2) + (iArr[41] * 4) + (iArr[39] * 8) + (iArr[37] * 16) + (iArr[35] * 32) + (iArr[33] * 64) + (iArr[31] * 128) + (iArr[29] * 256);
        iArr2[1] = (iArr[242] * 1) + (iArr[79] * 2) + (iArr[77] * 4) + (iArr[75] * 8) + (iArr[73] * 16) + (iArr[71] * 32);
        iArr2[2] = (iArr[46] * 1) + (iArr[44] * 2) + (iArr[42] * 4) + (iArr[40] * 8) + (iArr[38] * 16) + (iArr[36] * 32) + (iArr[34] * 64) + (iArr[32] * 128) + (iArr[30] * 256);
        iArr2[3] = (iArr[243] * 1) + (iArr[80] * 2) + (iArr[78] * 4) + (iArr[76] * 8) + (iArr[74] * 16) + (iArr[72] * 32);
        iArr3[0] = (iArr[88] * 1) + (iArr[55] * 2) + (iArr[51] * 4) + (iArr[47] * 8);
        iArr3[1] = (iArr[89] * 1) + (iArr[56] * 2) + (iArr[52] * 4) + (iArr[48] * 8);
        iArr3[2] = (iArr[90] * 1) + (iArr[57] * 2) + (iArr[53] * 4) + (iArr[49] * 8);
        iArr3[3] = (iArr[91] * 1) + (iArr[58] * 2) + (iArr[54] * 4) + (iArr[50] * 8);
        iArr4[0] = (iArr[104] * 1) + (iArr[92] * 2) + (iArr[67] * 4) + (iArr[63] * 8) + (iArr[59] * 16);
        iArr4[1] = (iArr[105] * 1) + (iArr[93] * 2) + (iArr[68] * 4) + (iArr[64] * 8) + (iArr[60] * 16);
        iArr4[2] = (iArr[106] * 1) + (iArr[94] * 2) + (iArr[69] * 4) + (iArr[65] * 8) + (iArr[61] * 16);
        iArr4[3] = (iArr[107] * 1) + (iArr[95] * 2) + (iArr[70] * 4) + (iArr[66] * 8) + (iArr[62] * 16);
        iArr5[0][0] = (iArr[122] * 1) + (iArr[123] * 2) + (iArr[124] * 4) + (iArr[96] * 8);
        iArr5[0][1] = (iArr[125] * 1) + (iArr[126] * 2) + (iArr[127] * 4) + (iArr[100] * 8);
        iArr5[0][2] = (iArr[128] * 1) + (iArr[129] * 2) + (iArr[130] * 4) + (iArr[108] * 8);
        iArr5[0][3] = (iArr[131] * 1) + (iArr[132] * 2) + (iArr[133] * 4) + (iArr[112] * 8);
        iArr5[0][4] = (iArr[134] * 1) + (iArr[135] * 2) + (iArr[136] * 4) + (iArr[116] * 8);
        iArr5[0][5] = (iArr[182] * 1) + (iArr[183] * 2) + (iArr[184] * 4);
        iArr5[0][6] = (iArr[185] * 1) + (iArr[186] * 2) + (iArr[187] * 4);
        iArr5[0][7] = (iArr[188] * 1) + (iArr[189] * 2) + (iArr[190] * 4);
        iArr5[0][8] = (iArr[191] * 1) + (iArr[192] * 2) + (iArr[193] * 4);
        iArr5[0][9] = (iArr[194] * 1) + (iArr[195] * 2) + (iArr[196] * 4);
        iArr5[1][0] = (iArr[137] * 1) + (iArr[138] * 2) + (iArr[139] * 4) + (iArr[97] * 8);
        iArr5[1][1] = (iArr[140] * 1) + (iArr[141] * 2) + (iArr[142] * 4) + (iArr[101] * 8);
        iArr5[1][2] = (iArr[143] * 1) + (iArr[144] * 2) + (iArr[145] * 4) + (iArr[109] * 8);
        iArr5[1][3] = (iArr[146] * 1) + (iArr[147] * 2) + (iArr[148] * 4) + (iArr[113] * 8);
        iArr5[1][4] = (iArr[149] * 1) + (iArr[150] * 2) + (iArr[151] * 4) + (iArr[117] * 8);
        iArr5[1][5] = (iArr[197] * 1) + (iArr[198] * 2) + (iArr[199] * 4);
        iArr5[1][6] = (iArr[200] * 1) + (iArr[201] * 2) + (iArr[202] * 4);
        iArr5[1][7] = (iArr[203] * 1) + (iArr[204] * 2) + (iArr[205] * 4);
        iArr5[1][8] = (iArr[206] * 1) + (iArr[207] * 2) + (iArr[208] * 4);
        iArr5[1][9] = (iArr[209] * 1) + (iArr[210] * 2) + (iArr[211] * 4);
        iArr5[2][0] = (iArr[152] * 1) + (iArr[153] * 2) + (iArr[154] * 4) + (iArr[98] * 8);
        iArr5[2][1] = (iArr[155] * 1) + (iArr[156] * 2) + (iArr[157] * 4) + (iArr[102] * 8);
        iArr5[2][2] = (iArr[158] * 1) + (iArr[159] * 2) + (iArr[160] * 4) + (iArr[110] * 8);
        iArr5[2][3] = (iArr[161] * 1) + (iArr[162] * 2) + (iArr[163] * 4) + (iArr[114] * 8);
        iArr5[2][4] = (iArr[164] * 1) + (iArr[165] * 2) + (iArr[166] * 4) + (iArr[118] * 8);
        iArr5[2][5] = (iArr[212] * 1) + (iArr[213] * 2) + (iArr[214] * 4);
        iArr5[2][6] = (iArr[215] * 1) + (iArr[216] * 2) + (iArr[217] * 4);
        iArr5[2][7] = (iArr[218] * 1) + (iArr[219] * 2) + (iArr[220] * 4);
        iArr5[2][8] = (iArr[221] * 1) + (iArr[222] * 2) + (iArr[223] * 4);
        iArr5[2][9] = (iArr[224] * 1) + (iArr[225] * 2) + (iArr[226] * 4);
        iArr5[3][0] = (iArr[167] * 1) + (iArr[168] * 2) + (iArr[169] * 4) + (iArr[99] * 8);
        iArr5[3][1] = (iArr[170] * 1) + (iArr[171] * 2) + (iArr[172] * 4) + (iArr[103] * 8);
        iArr5[3][2] = (iArr[173] * 1) + (iArr[174] * 2) + (iArr[175] * 4) + (iArr[111] * 8);
        iArr5[3][3] = (iArr[176] * 1) + (iArr[177] * 2) + (iArr[178] * 4) + (iArr[115] * 8);
        iArr5[3][4] = (iArr[179] * 1) + (iArr[180] * 2) + (iArr[181] * 4) + (iArr[119] * 8);
        iArr5[3][5] = (iArr[227] * 1) + (iArr[228] * 2) + (iArr[229] * 4);
        iArr5[3][6] = (iArr[230] * 1) + (iArr[231] * 2) + (iArr[232] * 4);
        iArr5[3][7] = (iArr[233] * 1) + (iArr[234] * 2) + (iArr[235] * 4);
        iArr5[3][8] = (iArr[236] * 1) + (iArr[237] * 2) + (iArr[238] * 4);
        iArr5[3][9] = (iArr[239] * 1) + (iArr[240] * 2) + (iArr[241] * 4);
    }

    public int[] aye() {
        return this.dED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo31688g(InputStream inputStream, int i) throws IOException {
        int[] iArr = new int[4];
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = 0;
        }
        int[] iArr2 = new int[4];
        for (int i4 = 0; i4 < 4; i4++) {
            iArr2[i4] = -2381;
        }
        int i5 = i;
        while (i5 > 0) {
            int a = mo31686a(inputStream, i5, iArr);
            i2 += a;
            i5 -= a;
            if (this.dFi != null && !this.dFi.mo31690h((((double) i2) * 1.0d) / ((double) i))) {
                return;
            }
        }
    }

    /* renamed from: uj */
    public int mo31682uj() {
        return this.dEA;
    }
}
