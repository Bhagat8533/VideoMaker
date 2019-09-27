package com.introvd.template.explorer.p300e.p301a.p302a;

import com.google.android.exoplayer2.extractor.p151ts.PsExtractor;
import com.introvd.template.explorer.p300e.p301a.p302a.C7203d.C7204a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.introvd.template.explorer.e.a.a.c */
public class C7201c extends C7203d {
    private static int[] dFb = {0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 0};
    private static int[] dFc = {0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160, 0};
    private static int[] dFd = {44100, 48000, 32000, 0};
    private static int[] dFe = {22050, 24000, 16000, 0};
    private int dEA;
    private int[] dEB;
    private int[] dEC;
    private int[] dED;
    private int dEE;
    private int dEJ;
    private int dEK;
    private int dEP;
    private int dEX;
    private int dEY;
    private int dEZ;
    private int dFa;

    public static C7204a ayd() {
        return new C7204a() {
            public C7203d ayg() {
                return new C7201c();
            }

            public String[] ayh() {
                return new String[]{"mp3"};
            }
        };
    }

    /* renamed from: A */
    public void mo31674A(File file) throws FileNotFoundException, IOException {
        int i;
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        super.mo31674A(file);
        this.dEA = 0;
        this.dEP = 64;
        this.dEB = new int[this.dEP];
        this.dEC = new int[this.dEP];
        this.dED = new int[this.dEP];
        this.dFa = 0;
        this.dEJ = 255;
        this.dEK = 0;
        this.dEE = (int) this.dFj.length();
        FileInputStream fileInputStream = new FileInputStream(this.dFj);
        byte b = 12;
        byte[] bArr = new byte[12];
        int i6 = 0;
        loop0:
        while (true) {
            int i7 = 0;
            while (i < this.dEE - b) {
                while (i7 < b) {
                    i7 += fileInputStream.read(bArr, i7, 12 - i7);
                }
                int i8 = 0;
                while (i8 < b && bArr[i8] != -1) {
                    i8++;
                }
                if (this.dFi != null && !this.dFi.mo31690h((((double) i) * 1.0d) / ((double) this.dEE))) {
                    break loop0;
                } else if (i8 > 0) {
                    int i9 = 0;
                    while (true) {
                        i5 = 12 - i8;
                        if (i9 >= i5) {
                            break;
                        }
                        bArr[i9] = bArr[i8 + i9];
                        i9++;
                    }
                    i += i8;
                    i7 = i5;
                } else {
                    if (bArr[1] == -6 || bArr[1] == -5) {
                        c = 1;
                    } else if (bArr[1] == -14 || bArr[1] == -13) {
                        c = 2;
                    } else {
                        int i10 = 0;
                        while (i10 < 11) {
                            int i11 = 1 + i10;
                            bArr[i10] = bArr[i11];
                            i10 = i11;
                        }
                        i++;
                        i7 = 11;
                    }
                    if (c == 1) {
                        i3 = dFb[(bArr[2] & 240) >> 4];
                        i2 = dFd[(bArr[2] & b) >> 2];
                    } else {
                        i3 = dFc[(bArr[2] & 240) >> 4];
                        i2 = dFe[(bArr[2] & b) >> 2];
                    }
                    if (i3 == 0 || i2 == 0) {
                        for (int i12 = 0; i12 < 10; i12++) {
                            bArr[i12] = bArr[2 + i12];
                        }
                        i += 2;
                        b = 12;
                        i7 = 10;
                    } else {
                        this.dEY = i2;
                        int i13 = (((i3 * 144) * 1000) / i2) + ((bArr[2] & 2) >> 1);
                        if ((bArr[3] & 192) == 192) {
                            this.dEZ = 1;
                            i4 = c == 1 ? ((bArr[10] & 1) << 7) + ((bArr[11] & 254) >> 1) : ((bArr[9] & 3) << 6) + ((bArr[10] & 252) >> 2);
                        } else {
                            this.dEZ = 2;
                            i4 = c == 1 ? ((bArr[9] & Byte.MAX_VALUE) << 1) + ((bArr[10] & 128) >> 7) : 0;
                        }
                        this.dFa += i3;
                        this.dEB[this.dEA] = i;
                        this.dEC[this.dEA] = i13;
                        this.dED[this.dEA] = i4;
                        if (i4 < this.dEJ) {
                            this.dEJ = i4;
                        }
                        if (i4 > this.dEK) {
                            this.dEK = i4;
                        }
                        this.dEA++;
                        if (this.dEA == this.dEP) {
                            this.dEX = this.dFa / this.dEA;
                            int i14 = ((((this.dEE / this.dEX) * i2) / 144000) * 11) / 10;
                            if (i14 < this.dEP * 2) {
                                i14 = this.dEP * 2;
                            }
                            int[] iArr = new int[i14];
                            int[] iArr2 = new int[i14];
                            int[] iArr3 = new int[i14];
                            for (int i15 = 0; i15 < this.dEA; i15++) {
                                iArr[i15] = this.dEB[i15];
                                iArr2[i15] = this.dEC[i15];
                                iArr3[i15] = this.dED[i15];
                            }
                            this.dEB = iArr;
                            this.dEC = iArr2;
                            this.dED = iArr3;
                            this.dEP = i14;
                        }
                        fileInputStream.skip((long) (i13 - 12));
                        i6 = i + i13;
                        b = 12;
                    }
                }
            }
            break loop0;
        }
        if (this.dEA > 0) {
            this.dEX = this.dFa / this.dEA;
        } else {
            this.dEX = 0;
        }
        fileInputStream.close();
    }

    public int[] aye() {
        return this.dED;
    }

    /* renamed from: uj */
    public int mo31682uj() {
        return this.dEA;
    }
}
