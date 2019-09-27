package com.introvd.template.explorer.p300e.p301a.p302a;

import com.flurry.android.Constants;
import com.introvd.template.explorer.p300e.p301a.p302a.C7203d.C7204a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

/* renamed from: com.introvd.template.explorer.e.a.a.a */
public class C7196a extends C7203d {
    public static final int[] dEy = {1684631142, 1751411826, 1835296868, 1835297121, 1835626086, 1836019574, 1836476516, 1936549988, 1937007212, 1937011556, 1937011578, 1937011827, 1953196132, 1953653099};
    public static final int[] dEz = {1684631142, 1751411826, 1835296868, 1836476516, 1936549988, 1953196132, 1937011556};
    private int dEA;
    private int[] dEB;
    private int[] dEC;
    private int[] dED;
    private int dEE;
    private HashMap<Integer, C7198a> dEF;
    private int dEG;
    private int dEH;
    private int dEI;
    private int dEJ;
    private int dEK;
    private int dEL;
    private int dEM;
    private int mOffset;
    private int mSampleRate;

    /* renamed from: com.introvd.template.explorer.e.a.a.a$a */
    class C7198a {
        public byte[] data;
        public int len;
        public int start;

        C7198a() {
        }
    }

    /* renamed from: a */
    private void m21260a(InputStream inputStream, int i) throws IOException {
        while (i > 8) {
            int i2 = this.mOffset;
            byte[] bArr = new byte[8];
            inputStream.read(bArr, 0, 8);
            byte b = ((bArr[0] & Constants.UNKNOWN) << 24) | ((bArr[1] & Constants.UNKNOWN) << 16) | ((bArr[2] & Constants.UNKNOWN) << 8) | (bArr[3] & Constants.UNKNOWN);
            if (b > i) {
                b = i;
            }
            byte b2 = (bArr[7] & Constants.UNKNOWN) | ((bArr[4] & Constants.UNKNOWN) << 24) | ((bArr[5] & Constants.UNKNOWN) << 16) | ((bArr[6] & Constants.UNKNOWN) << 8);
            C7198a aVar = new C7198a();
            aVar.start = this.mOffset;
            aVar.len = b;
            this.dEF.put(Integer.valueOf(b2), aVar);
            this.mOffset += 8;
            if (b2 == 1836019574 || b2 == 1953653099 || b2 == 1835297121 || b2 == 1835626086 || b2 == 1937007212) {
                m21260a(inputStream, b);
            } else if (b2 == 1937011578) {
                mo31678c(inputStream, b - 8);
            } else if (b2 == 1937011827) {
                mo31677b(inputStream, b - 8);
            } else if (b2 == 1835295092) {
                this.dEL = this.mOffset;
                this.dEM = b - 8;
            } else {
                for (int i3 : dEz) {
                    if (i3 == b2) {
                        int i4 = b - 8;
                        byte[] bArr2 = new byte[i4];
                        inputStream.read(bArr2, 0, i4);
                        this.mOffset += i4;
                        if (this.dEF.get(Integer.valueOf(b2)) != null) {
                            ((C7198a) this.dEF.get(Integer.valueOf(b2))).data = bArr2;
                        }
                    }
                }
            }
            if (b2 == 1937011556) {
                ayf();
            }
            i -= b;
            int i5 = b - (this.mOffset - i2);
            if (i5 >= 0) {
                inputStream.skip((long) i5);
                this.mOffset += i5;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Went over by ");
                sb.append(-i5);
                sb.append(" bytes");
                throw new IOException(sb.toString());
            }
        }
    }

    public static C7204a ayd() {
        return new C7204a() {
            public C7203d ayg() {
                return new C7196a();
            }

            public String[] ayh() {
                return new String[]{"aac", "m4a"};
            }
        };
    }

    /* renamed from: A */
    public void mo31674A(File file) throws FileNotFoundException, IOException {
        int[] iArr;
        super.mo31674A(file);
        this.dEH = 0;
        this.mSampleRate = 0;
        this.dEG = 0;
        this.dEI = 0;
        this.dEA = 0;
        this.dEJ = 255;
        this.dEK = 0;
        this.mOffset = 0;
        this.dEL = -1;
        this.dEM = -1;
        this.dEF = new HashMap<>();
        this.dEE = (int) this.dFj.length();
        if (this.dEE >= 128) {
            FileInputStream fileInputStream = new FileInputStream(this.dFj);
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr, 0, 8);
            fileInputStream.close();
            if (bArr[0] == 0 && bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112) {
                m21260a(new FileInputStream(this.dFj), this.dEE);
                if (this.dEL <= 0 || this.dEM <= 0) {
                    throw new IOException("Didn't find mdat");
                }
                FileInputStream fileInputStream2 = new FileInputStream(this.dFj);
                fileInputStream2.skip((long) this.dEL);
                this.mOffset = this.dEL;
                mo31679d(fileInputStream2, this.dEM);
                boolean z = false;
                for (int i : dEy) {
                    if (!this.dEF.containsKey(Integer.valueOf(i))) {
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Missing atom: ");
                        sb.append(mo31681rb(i));
                        printStream.println(sb.toString());
                        z = true;
                    }
                }
                if (z) {
                    throw new IOException("Could not parse MP4 file");
                }
                return;
            }
            throw new IOException("Unknown file format");
        }
        throw new IOException("File too small to parse");
    }

    public int[] aye() {
        return this.dED;
    }

    /* access modifiers changed from: 0000 */
    public void ayf() {
        if (this.dEF.get(Integer.valueOf(1937011556)) != null) {
            byte[] bArr = ((C7198a) this.dEF.get(Integer.valueOf(1937011556))).data;
            this.dEH = ((bArr[32] & Constants.UNKNOWN) << 8) | (bArr[33] & Constants.UNKNOWN);
            this.mSampleRate = (bArr[41] & Constants.UNKNOWN) | ((bArr[40] & Constants.UNKNOWN) << 8);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo31677b(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[16];
        inputStream.read(bArr, 0, 16);
        this.mOffset += 16;
        this.dEI = ((bArr[12] & Constants.UNKNOWN) << 24) | ((bArr[13] & Constants.UNKNOWN) << 16) | ((bArr[14] & Constants.UNKNOWN) << 8) | (bArr[15] & Constants.UNKNOWN);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo31678c(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[12];
        inputStream.read(bArr, 0, 12);
        this.mOffset += 12;
        this.dEA = (bArr[11] & Constants.UNKNOWN) | ((bArr[8] & Constants.UNKNOWN) << 24) | ((bArr[9] & Constants.UNKNOWN) << 16) | ((bArr[10] & Constants.UNKNOWN) << 8);
        this.dEB = new int[this.dEA];
        this.dEC = new int[this.dEA];
        this.dED = new int[this.dEA];
        byte[] bArr2 = new byte[(this.dEA * 4)];
        inputStream.read(bArr2, 0, this.dEA * 4);
        this.mOffset += this.dEA * 4;
        for (int i2 = 0; i2 < this.dEA; i2++) {
            int i3 = i2 * 4;
            this.dEC[i2] = (bArr2[i3 + 3] & Constants.UNKNOWN) | ((bArr2[i3 + 0] & Constants.UNKNOWN) << 24) | ((bArr2[i3 + 1] & Constants.UNKNOWN) << 16) | ((bArr2[i3 + 2] & Constants.UNKNOWN) << 8);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo31679d(InputStream inputStream, int i) throws IOException {
        int i2 = this.mOffset;
        int i3 = 0;
        while (i3 < this.dEA) {
            this.dEB[i3] = this.mOffset;
            if ((this.mOffset - i2) + this.dEC[i3] > i - 8) {
                this.dED[i3] = 0;
            } else {
                mo31680e(inputStream, i3);
            }
            if (this.dED[i3] < this.dEJ) {
                this.dEJ = this.dED[i3];
            }
            if (this.dED[i3] > this.dEK) {
                this.dEK = this.dED[i3];
            }
            if (this.dFi == null || this.dFi.mo31690h((((double) this.mOffset) * 1.0d) / ((double) this.dEE))) {
                i3++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo31680e(InputStream inputStream, int i) throws IOException {
        int i2;
        int i3;
        int i4;
        byte b;
        InputStream inputStream2 = inputStream;
        if (this.dEC[i] < 4) {
            this.dED[i] = 0;
            inputStream2.skip((long) this.dEC[i]);
            return;
        }
        int i5 = this.mOffset;
        byte[] bArr = new byte[4];
        inputStream2.read(bArr, 0, 4);
        this.mOffset += 4;
        switch ((bArr[0] & 224) >> 5) {
            case 0:
                this.dED[i] = ((bArr[0] & 1) << 7) | ((bArr[1] & 254) >> 1);
                break;
            case 1:
                int i6 = (bArr[1] & 96) >> 5;
                byte b2 = bArr[1];
                if (i6 == 2) {
                    b = bArr[1] & 15;
                    i4 = (bArr[2] & 254) >> 1;
                    i3 = ((bArr[2] & 1) << 1) | ((bArr[3] & 128) >> 7);
                    i2 = 25;
                } else {
                    b = ((bArr[1] & 15) << 2) | ((bArr[2] & 192) >> 6);
                    i4 = -1;
                    i3 = (bArr[2] & 24) >> 3;
                    i2 = 21;
                }
                if (i3 == 1) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < 7; i8++) {
                        if ((i4 & (1 << i8)) == 0) {
                            i7++;
                        }
                    }
                    i2 += b * (i7 + 1);
                }
                int i9 = ((i2 + 7) / 8) + 1;
                byte[] bArr2 = new byte[i9];
                bArr2[0] = bArr[0];
                bArr2[1] = bArr[1];
                bArr2[2] = bArr[2];
                bArr2[3] = bArr[3];
                int i10 = i9 - 4;
                inputStream2.read(bArr2, 4, i10);
                this.mOffset += i10;
                int i11 = 0;
                for (int i12 = 0; i12 < 8; i12++) {
                    int i13 = i12 + i2;
                    int i14 = i13 / 8;
                    int i15 = 7 - (i13 % 8);
                    i11 += ((bArr2[i14] & (1 << i15)) >> i15) << (7 - i12);
                }
                this.dED[i] = i11;
                break;
            default:
                if (i <= 0) {
                    this.dED[i] = 0;
                    break;
                } else {
                    this.dED[i] = this.dED[i - 1];
                    break;
                }
        }
        int i16 = this.dEC[i] - (this.mOffset - i5);
        inputStream2.skip((long) i16);
        this.mOffset += i16;
    }

    /* renamed from: rb */
    public String mo31681rb(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((char) ((i >> 24) & 255));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append((char) ((i >> 16) & 255));
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append((char) ((i >> 8) & 255));
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append((char) (i & 255));
        return sb7.toString();
    }

    /* renamed from: uj */
    public int mo31682uj() {
        return this.dEA;
    }
}
