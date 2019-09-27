package com.introvd.template.explorer.p300e.p301a.p302a;

import com.flurry.android.Constants;
import com.introvd.template.explorer.p300e.p301a.p302a.C7203d.C7204a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.introvd.template.explorer.e.a.a.e */
public class C7206e extends C7203d {
    private int dEA;
    private int[] dEB;
    private int[] dEC;
    private int[] dED;
    private int dEE;
    private int dEH;
    private int dFl;
    private int mOffset;
    private int mSampleRate;

    public static C7204a ayd() {
        return new C7204a() {
            public C7203d ayg() {
                return new C7206e();
            }

            public String[] ayh() {
                return new String[]{"wav"};
            }
        };
    }

    /* renamed from: A */
    public void mo31674A(File file) throws FileNotFoundException, IOException {
        byte[] bArr;
        super.mo31674A(file);
        this.dEE = (int) this.dFj.length();
        if (this.dEE >= 128) {
            FileInputStream fileInputStream = new FileInputStream(this.dFj);
            byte[] bArr2 = new byte[12];
            fileInputStream.read(bArr2, 0, 12);
            this.mOffset += 12;
            if (bArr2[0] == 82) {
                byte b = 1;
                if (bArr2[1] == 73 && bArr2[2] == 70 && bArr2[3] == 70 && bArr2[8] == 87 && bArr2[9] == 65 && bArr2[10] == 86 && bArr2[11] == 69) {
                    this.dEH = 0;
                    this.mSampleRate = 0;
                    while (this.mOffset + 8 <= this.dEE) {
                        byte[] bArr3 = new byte[8];
                        fileInputStream.read(bArr3, 0, 8);
                        this.mOffset += 8;
                        byte b2 = ((bArr3[7] & Constants.UNKNOWN) << 24) | ((bArr3[6] & Constants.UNKNOWN) << 16) | ((bArr3[5] & Constants.UNKNOWN) << 8) | (bArr3[4] & Constants.UNKNOWN);
                        if (bArr3[0] == 102 && bArr3[b] == 109 && bArr3[2] == 116 && bArr3[3] == 32) {
                            if (b2 < 16 || b2 > 1024) {
                                fileInputStream.close();
                                throw new IOException("WAV file has bad fmt chunk");
                            }
                            byte[] bArr4 = new byte[b2];
                            fileInputStream.read(bArr4, 0, b2);
                            this.mOffset += b2;
                            byte b3 = ((bArr4[b] & Constants.UNKNOWN) << 8) | (bArr4[0] & Constants.UNKNOWN);
                            this.dEH = ((bArr4[3] & Constants.UNKNOWN) << 8) | (bArr4[2] & Constants.UNKNOWN);
                            this.mSampleRate = (bArr4[4] & Constants.UNKNOWN) | ((bArr4[7] & Constants.UNKNOWN) << 24) | ((bArr4[6] & Constants.UNKNOWN) << 16) | ((bArr4[5] & Constants.UNKNOWN) << 8);
                            if (b3 != b) {
                                fileInputStream.close();
                                throw new IOException("Unsupported WAV file encoding");
                            }
                        } else if (bArr3[0] != 100 || bArr3[b] != 97 || bArr3[2] != 116 || bArr3[3] != 97) {
                            fileInputStream.skip((long) b2);
                            this.mOffset += b2;
                        } else if (this.dEH == 0 || this.mSampleRate == 0) {
                            fileInputStream.close();
                            throw new IOException("Bad WAV file: data chunk before fmt chunk");
                        } else {
                            this.dFl = ((this.mSampleRate * this.dEH) / 50) * 2;
                            this.dEA = ((this.dFl - b) + b2) / this.dFl;
                            this.dEB = new int[this.dEA];
                            this.dEC = new int[this.dEA];
                            this.dED = new int[this.dEA];
                            byte[] bArr5 = new byte[this.dFl];
                            int i = 0;
                            int i2 = 0;
                            while (i < b2) {
                                int i3 = this.dFl;
                                if (i + i3 > b2) {
                                    i = b2 - i3;
                                }
                                fileInputStream.read(bArr5, 0, i3);
                                int i4 = 0;
                                for (int i5 = 1; i5 < i3; i5 += this.dEH * 4) {
                                    int abs = Math.abs(bArr5[i5]);
                                    if (abs > i4) {
                                        i4 = abs;
                                    }
                                }
                                this.dEB[i2] = this.mOffset;
                                this.dEC[i2] = i3;
                                this.dED[i2] = i4;
                                i2 += b;
                                this.mOffset += i3;
                                i += i3;
                                if (this.dFi != null) {
                                    bArr = bArr5;
                                    if (!this.dFi.mo31690h((((double) i) * 1.0d) / ((double) b2))) {
                                        break;
                                    }
                                } else {
                                    bArr = bArr5;
                                }
                                bArr5 = bArr;
                                b = 1;
                            }
                        }
                        b = 1;
                    }
                    fileInputStream.close();
                    return;
                }
            }
            fileInputStream.close();
            throw new IOException("Not a WAV file");
        }
        throw new IOException("File too small to parse");
    }

    public int[] aye() {
        return this.dED;
    }

    /* renamed from: uj */
    public int mo31682uj() {
        return this.dEA;
    }
}
