package com.introvd.template.common;

import java.security.MessageDigest;

public class MD5 {
    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            instance.update(bytes, 0, bytes.length);
            return Utils.toHexString(instance.digest(), null);
        } catch (Exception unused) {
            return null;
        }
    }
}
