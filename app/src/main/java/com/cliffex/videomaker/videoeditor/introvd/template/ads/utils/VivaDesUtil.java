package com.introvd.template.ads.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class VivaDesUtil {
    /* access modifiers changed from: private */
    public static final String TAG = "VivaDesUtil";

    /* renamed from: com.introvd.template.ads.utils.VivaDesUtil$a */
    private static class C3611a {
        private static String bfi;
        private static Cipher bfj;

        /* access modifiers changed from: private */
        public static String decrypt(String str, String str2) {
            Cipher cipher;
            try {
                StringBuilder sb = new StringBuilder();
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                sb.append("http:xiaoying.quvideo.tv");
                String substring = sb.toString().substring(0, 24);
                if (bfi == null || !bfi.equals(substring)) {
                    SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(substring.getBytes()));
                    Cipher instance = Cipher.getInstance("desede/CBC/PKCS5Padding");
                    instance.init(2, generateSecret, new IvParameterSpec("20060427".getBytes()));
                    bfj = instance;
                    bfi = substring;
                    cipher = instance;
                } else {
                    cipher = bfj;
                }
                return new String(cipher.doFinal(C3612b.decode(str2)), "utf-8");
            } catch (Throwable th) {
                VivaAdLog.m8847e(VivaDesUtil.TAG, th.getMessage());
                return null;
            }
        }
    }

    /* renamed from: com.introvd.template.ads.utils.VivaDesUtil$b */
    private static class C3612b {
        private static final char[] bfk = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

        /* renamed from: a */
        private static void m8849a(String str, OutputStream outputStream) throws IOException {
            int length = str.length();
            int i = 0;
            while (true) {
                if (i < length && str.charAt(i) <= ' ') {
                    i++;
                } else if (i != length) {
                    int i2 = i + 2;
                    int i3 = i + 3;
                    int s = (m8851s(str.charAt(i)) << 18) + (m8851s(str.charAt(i + 1)) << 12) + (m8851s(str.charAt(i2)) << 6) + m8851s(str.charAt(i3));
                    outputStream.write((s >> 16) & 255);
                    if (str.charAt(i2) != '=') {
                        outputStream.write((s >> 8) & 255);
                        if (str.charAt(i3) != '=') {
                            outputStream.write(s & 255);
                            i += 4;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public static byte[] decode(String str) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                m8849a(str, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    PrintStream printStream = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error while decoding BASE64: ");
                    sb.append(e.toString());
                    printStream.println(sb.toString());
                }
                return byteArray;
            } catch (IOException unused) {
                throw new RuntimeException();
            }
        }

        /* renamed from: s */
        private static int m8851s(char c) {
            if (c >= 'A' && c <= 'Z') {
                return c - 'A';
            }
            if (c >= 'a' && c <= 'z') {
                return (c - 'a') + 26;
            }
            if (c >= '0' && c <= '9') {
                return (c - '0') + 26 + 26;
            }
            if (c == '+') {
                return 62;
            }
            if (c == '/') {
                return 63;
            }
            if (c == '=') {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected code: ");
            sb.append(c);
            throw new RuntimeException(sb.toString());
        }
    }

    public static String decrypt(String str, String str2) {
        return C3611a.decrypt(str, str2);
    }
}
