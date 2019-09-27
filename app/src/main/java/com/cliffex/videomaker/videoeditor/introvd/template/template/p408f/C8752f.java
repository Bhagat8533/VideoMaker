package com.introvd.template.template.p408f;

import android.text.TextUtils;
import android.util.SparseArray;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.router.community.VivaCommunityRouter.RcVideoListActivityParams;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import xiaoying.engine.base.QI18NItemInfo;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.template.f.f */
public class C8752f {
    private static ArrayList<Integer> etB = new ArrayList<>();
    private static ArrayList<String> etz = new ArrayList<>();
    private SparseArray<C8754a> etA = new SparseArray<>();

    /* renamed from: com.introvd.template.template.f.f$a */
    private static class C8754a {
        short etD;
        short etE;
        short etF;
        short etG;
        short etH;
        short etI;
        String etJ;

        private C8754a() {
        }
    }

    /* renamed from: com.introvd.template.template.f.f$b */
    private static class C8755b {
        short etK;
        short etL;
        short etM;

        private C8755b() {
        }
    }

    /* renamed from: com.introvd.template.template.f.f$c */
    private static class C8756c {
        int etN;
        int length;
        String name;
        int offset;

        private C8756c() {
        }
    }

    public C8752f() {
        m25580d((Locale) null);
    }

    public static String aMl() {
        return m25581e(Locale.getDefault());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        r1 = false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m25579d(java.io.RandomAccessFile r13) throws java.io.IOException {
        /*
            r12 = this;
            short r0 = r13.readShort()
            short r1 = r13.readShort()
            short r2 = r13.readShort()
            r3 = 1
            if (r0 != r3) goto L_0x00f2
            if (r1 == 0) goto L_0x0013
            goto L_0x00f2
        L_0x0013:
            r0 = 12
            r13.seek(r0)
            r0 = 4
            byte[] r1 = new byte[r0]
            com.introvd.template.template.f.f$c r4 = new com.introvd.template.template.f.f$c
            r5 = 0
            r4.<init>()
            r6 = 0
            r7 = 0
        L_0x0023:
            if (r7 >= r2) goto L_0x0063
            r13.read(r1)
            java.lang.String r8 = new java.lang.String
            java.lang.String r9 = "UTF-8"
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)
            r8.<init>(r1, r9)
            r4.name = r8
            int r8 = r13.readInt()
            r4.etN = r8
            int r8 = r13.readInt()
            r4.offset = r8
            int r8 = r13.readInt()
            r4.length = r8
            java.lang.String r8 = "name"
            java.lang.String r9 = r4.name
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x0053
            r1 = 1
            goto L_0x0064
        L_0x0053:
            java.lang.String r8 = r4.name
            if (r8 == 0) goto L_0x0063
            java.lang.String r8 = r4.name
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            int r7 = r7 + 1
            goto L_0x0023
        L_0x0063:
            r1 = 0
        L_0x0064:
            if (r1 != 0) goto L_0x0067
            return
        L_0x0067:
            int r1 = r4.offset
            long r1 = (long) r1
            r13.seek(r1)
            com.introvd.template.template.f.f$b r1 = new com.introvd.template.template.f.f$b
            r1.<init>()
            short r2 = r13.readShort()
            r1.etK = r2
            short r2 = r13.readShort()
            r1.etL = r2
            short r2 = r13.readShort()
            r1.etM = r2
        L_0x0084:
            short r2 = r1.etL
            if (r6 >= r2) goto L_0x00f1
            com.introvd.template.template.f.f$a r2 = new com.introvd.template.template.f.f$a
            r2.<init>()
            short r7 = r13.readShort()
            r2.etD = r7
            short r7 = r13.readShort()
            r2.etE = r7
            short r7 = r13.readShort()
            r2.etF = r7
            short r7 = r13.readShort()
            r2.etG = r7
            short r7 = r13.readShort()
            r2.etH = r7
            short r7 = r13.readShort()
            r2.etI = r7
            short r7 = r2.etG
            if (r0 != r7) goto L_0x00ee
            short r7 = r2.etH
            if (r7 <= 0) goto L_0x00ee
            long r7 = r13.getFilePointer()
            short r9 = r2.etH
            byte[] r9 = new byte[r9]
            int r10 = r4.offset
            short r11 = r2.etI
            int r10 = r10 + r11
            short r11 = r1.etM
            int r10 = r10 + r11
            long r10 = (long) r10
            r13.seek(r10)
            r13.read(r9)
            java.lang.String r10 = new java.lang.String
            short r11 = r2.etD
            if (r11 != r3) goto L_0x00d9
            java.lang.String r11 = "ISO-8859-1"
            goto L_0x00db
        L_0x00d9:
            java.lang.String r11 = "UTF-16BE"
        L_0x00db:
            java.nio.charset.Charset r11 = java.nio.charset.Charset.forName(r11)
            r10.<init>(r9, r11)
            r2.etJ = r10
            android.util.SparseArray<com.introvd.template.template.f.f$a> r9 = r12.etA
            short r10 = r2.etF
            r9.put(r10, r2)
            r13.seek(r7)
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x0084
        L_0x00f1:
            return
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p408f.C8752f.m25579d(java.io.RandomAccessFile):void");
    }

    /* renamed from: d */
    private static void m25580d(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        etz.clear();
        etB.clear();
        String language = locale.getLanguage();
        if ("zh".equals(language)) {
            if (locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                etB.add(Integer.valueOf(2052));
                etB.add(Integer.valueOf(4));
            } else {
                etB.add(Integer.valueOf(3076));
                etB.add(Integer.valueOf(4100));
                etB.add(Integer.valueOf(1028));
            }
        } else if ("ja".equals(language)) {
            etB.add(Integer.valueOf(1041));
        } else if ("ko".equals(language)) {
            etB.add(Integer.valueOf(1042));
            etB.add(Integer.valueOf(2066));
            etz.add("NanumGothic");
        } else if ("ar".equals(language)) {
            etB.add(Integer.valueOf(1025));
            etB.add(Integer.valueOf(5121));
            etB.add(Integer.valueOf(15361));
            etB.add(Integer.valueOf(3073));
            etB.add(Integer.valueOf(1));
            etB.add(Integer.valueOf(2049));
            etB.add(Integer.valueOf(11265));
            etB.add(Integer.valueOf(13313));
            etB.add(Integer.valueOf(12289));
            etB.add(Integer.valueOf(4097));
            etB.add(Integer.valueOf(RcVideoListActivityParams.REQUEST_CODE_VIDEO_PLAY));
            etB.add(Integer.valueOf(8193));
            etB.add(Integer.valueOf(16385));
            etB.add(Integer.valueOf(10241));
            etB.add(Integer.valueOf(7169));
            etB.add(Integer.valueOf(14337));
            etB.add(Integer.valueOf(9217));
            etz.add("Arabic");
        } else if ("be".equals(language)) {
            etB.add(Integer.valueOf(1059));
        } else if ("bg".equals(language)) {
            etB.add(Integer.valueOf(1026));
        } else if (!"ca".equals(language)) {
            if ("cs".equals(language)) {
                etB.add(Integer.valueOf(1029));
            } else if ("da".equals(language)) {
                etB.add(Integer.valueOf(1030));
            } else if ("de".equals(language)) {
                etB.add(Integer.valueOf(1031));
                etB.add(Integer.valueOf(3079));
                etB.add(Integer.valueOf(5127));
                etB.add(Integer.valueOf(4103));
                etB.add(Integer.valueOf(2055));
            } else if ("el".equals(language)) {
                etB.add(Integer.valueOf(1032));
            } else if ("en".equals(language)) {
                etB.add(Integer.valueOf(QI18NItemInfo.LANGUAGE_ID_EN_US));
            } else if ("es".equals(language)) {
                etB.add(Integer.valueOf(11274));
                etB.add(Integer.valueOf(QStoryboard.PROP_THEME_ID));
                etB.add(Integer.valueOf(13322));
                etB.add(Integer.valueOf(9226));
                etB.add(Integer.valueOf(5130));
                etB.add(Integer.valueOf(7178));
                etB.add(Integer.valueOf(12298));
                etB.add(Integer.valueOf(17418));
                etB.add(Integer.valueOf(4106));
                etB.add(Integer.valueOf(18442));
                etB.add(Integer.valueOf(2058));
                etB.add(Integer.valueOf(3082));
                etB.add(Integer.valueOf(19466));
                etB.add(Integer.valueOf(6154));
                etB.add(Integer.valueOf(15370));
                etB.add(Integer.valueOf(10250));
                etB.add(Integer.valueOf(QSlideShowSession.PROP_DEC_USE_TYPE));
                etB.add(Integer.valueOf(1034));
                etB.add(Integer.valueOf(14346));
                etB.add(Integer.valueOf(8202));
            } else if ("et".equals(language)) {
                etB.add(Integer.valueOf(1061));
            } else if ("fi".equals(language)) {
                etB.add(Integer.valueOf(1035));
            } else if ("fr".equals(language)) {
                etB.add(Integer.valueOf(1036));
                etB.add(Integer.valueOf(2060));
                etB.add(Integer.valueOf(11276));
                etB.add(Integer.valueOf(3084));
                etB.add(Integer.valueOf(12300));
                etB.add(Integer.valueOf(5132));
                etB.add(Integer.valueOf(13324));
                etB.add(Integer.valueOf(6156));
                etB.add(Integer.valueOf(8204));
                etB.add(Integer.valueOf(10252));
                etB.add(Integer.valueOf(QEffect.PROP_VIDEO_FRAME_RANGE));
                etB.add(Integer.valueOf(7180));
                etB.add(Integer.valueOf(9228));
            } else if ("hr".equals(language)) {
                etB.add(Integer.valueOf(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS));
            } else if ("hu".equals(language)) {
                etB.add(Integer.valueOf(1038));
            } else if ("is".equals(language)) {
                etB.add(Integer.valueOf(1039));
            } else if ("it".equals(language)) {
                etB.add(Integer.valueOf(1029));
            } else if ("iw".equals(language)) {
                etB.add(Integer.valueOf(1037));
                etz.add("Hebrew");
            } else if ("it".equals(language)) {
                etB.add(Integer.valueOf(2064));
            } else if ("lt".equals(language)) {
                etB.add(Integer.valueOf(1063));
                etB.add(Integer.valueOf(2087));
            } else if (!"lv".equals(language)) {
                if ("mk".equals(language)) {
                    etB.add(Integer.valueOf(1086));
                } else if ("nl".equals(language)) {
                    etB.add(Integer.valueOf(2067));
                    etB.add(Integer.valueOf(1043));
                } else if ("no".equals(language)) {
                    etB.add(Integer.valueOf(1044));
                    etB.add(Integer.valueOf(2068));
                } else if ("pl".equals(language)) {
                    etB.add(Integer.valueOf(1045));
                } else if ("pt".equals(language)) {
                    etB.add(Integer.valueOf(1046));
                    etB.add(Integer.valueOf(2070));
                } else if ("ro".equals(language)) {
                    etB.add(Integer.valueOf(1048));
                    etB.add(Integer.valueOf(2072));
                } else if ("ru".equals(language)) {
                    etB.add(Integer.valueOf(1049));
                    etB.add(Integer.valueOf(2073));
                } else if ("sh".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS));
                } else if ("sk".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_IS_CALL_LOAD_BEFORE_SHOW));
                } else if ("sl".equals(language)) {
                    etB.add(Integer.valueOf(1060));
                } else if ("sq".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT));
                } else if ("sr".equals(language)) {
                    etB.add(Integer.valueOf(3098));
                    etB.add(Integer.valueOf(2074));
                } else if ("sv".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_RV_LOAD_ALREADY_IN_PROGRESS));
                    etB.add(Integer.valueOf(2077));
                } else if ("th".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_RV_CALL_LOAD_BEFORE_SHOW));
                    etz.add("Thai");
                } else if ("tr".equals(language)) {
                    etB.add(Integer.valueOf(IronSourceError.ERROR_DO_RV_LOAD_TIMED_OUT));
                } else if ("uk".equals(language)) {
                    etB.add(Integer.valueOf(1058));
                }
            }
        }
        etB.add(Integer.valueOf(QI18NItemInfo.LANGUAGE_ID_EN_US));
    }

    /* renamed from: e */
    public static String m25581e(Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("fonts/");
        sb.append("DroidSansFallback.ttf");
        String sb2 = sb.toString();
        if (FileUtils.isFileExisted(sb2)) {
            return sb2;
        }
        if (locale == null) {
            return "/system/fonts/DroidSansFallback.ttf";
        }
        m25580d(locale);
        String str = null;
        final String language = locale.getLanguage();
        if ("zh".equals(language) || "ja".equals(language) || "ko".equals(language)) {
            try {
                C8752f fVar = new C8752f();
                File[] listFiles = new File("/system/fonts").listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        boolean z = false;
                        if (!str.toLowerCase(Locale.US).endsWith(".ttf") || str.contains("Clock")) {
                            return false;
                        }
                        if (!"zh".equals(language)) {
                            return true;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(file.getAbsolutePath());
                        sb.append(File.separator);
                        sb.append(str);
                        if (new File(sb.toString()).length() >= 2097152) {
                            z = true;
                        }
                        return z;
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    int length = listFiles.length;
                    long j = 0;
                    String str2 = null;
                    int i = 0;
                    while (i < length) {
                        try {
                            File file = listFiles[i];
                            try {
                                String absolutePath = file.getAbsolutePath();
                                Iterator it = etz.iterator();
                                boolean z = false;
                                while (it.hasNext()) {
                                    if (absolutePath.contains((String) it.next())) {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    fVar.parse(absolutePath);
                                    z = fVar.aMm();
                                }
                                if (z) {
                                    long length2 = file.length();
                                    if (j < length2) {
                                        str2 = absolutePath;
                                        j = length2;
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            i++;
                        } catch (Exception unused) {
                        }
                    }
                    str = str2;
                }
            } catch (Exception unused2) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "/system/fonts/DroidSansFallback.ttf";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Use default fonts:");
            sb3.append(str);
            LogUtils.m14222e("TTFParser", sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Best fonts:");
            sb4.append(str);
            LogUtils.m14222e("TTFParser", sb4.toString());
        }
        return str;
    }

    /* renamed from: a */
    public String mo35186a(short s) {
        C8754a aVar = (C8754a) this.etA.get(s);
        if (aVar == null) {
            return null;
        }
        return aVar.etJ;
    }

    public boolean aMm() {
        if (etB.isEmpty()) {
            return true;
        }
        Iterator it = etB.iterator();
        while (it.hasNext()) {
            if (this.etA.get(((Integer) it.next()).intValue()) != null) {
                return true;
            }
        }
        return false;
    }

    public String aMn() {
        if (etB.isEmpty()) {
            return null;
        }
        Iterator it = etB.iterator();
        while (it.hasNext()) {
            String a = mo35186a((short) ((Integer) it.next()).intValue());
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public boolean aMo() {
        boolean z = false;
        if (etB.isEmpty()) {
            return false;
        }
        Iterator it = etB.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (this.etA != null && this.etA.indexOfKey(intValue) >= 0 && intValue != 1033) {
                return true;
            }
        }
        if (this.etA.size() != 1) {
            return false;
        }
        if (this.etA.indexOfKey(QI18NItemInfo.LANGUAGE_ID_EN_US) >= 0) {
            z = true;
        }
        return z;
    }

    public void parse(String str) throws IOException {
        this.etA.clear();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                m25579d(randomAccessFile2);
                try {
                    randomAccessFile2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                try {
                    randomAccessFile.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile.close();
            throw th;
        }
    }

    public String toString() {
        return this.etA.toString();
    }
}
