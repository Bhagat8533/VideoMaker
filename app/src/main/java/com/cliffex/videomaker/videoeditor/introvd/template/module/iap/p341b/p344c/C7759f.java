package com.introvd.template.module.iap.p341b.p344c;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.introvd.template.module.iap.b.c.f */
public class C7759f {
    /* renamed from: a */
    public static boolean m22687a(PublicKey publicKey, String str, String str2) {
        try {
            byte[] decode = Base64.decode(str2, 0);
            try {
                Signature instance = Signature.getInstance("SHA1withRSA");
                instance.initVerify(publicKey);
                instance.update(str.getBytes());
                instance.verify(decode);
                if (1 != 0) {
                    return true;
                }
                Log.e("IABUtil/Security", "Signature verification failed.");
                return false;
            } catch (NoSuchAlgorithmException unused) {
                Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
                return false;
            } catch (InvalidKeyException unused2) {
                Log.e("IABUtil/Security", "Invalid key specification.");
                return false;
            } catch (SignatureException unused3) {
                Log.e("IABUtil/Security", "Signature exception.");
                return false;
            }
        } catch (IllegalArgumentException unused4) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            return false;
        }
    }

    /* renamed from: bs */
    private static PublicKey m22688bs(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    /* renamed from: r */
    static boolean m22689r(String str, String str2, String str3) {
        boolean z;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
            return false;
        }
        try {
            z = m22687a(m22688bs(str), str2, str3);
        } catch (IllegalArgumentException unused) {
            Log.e("IABUtil/Security", "base 64 public key from google is changed.");
            z = false;
        }
        return z;
    }
}
