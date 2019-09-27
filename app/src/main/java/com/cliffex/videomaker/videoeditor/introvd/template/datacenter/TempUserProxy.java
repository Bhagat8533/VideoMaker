package com.introvd.template.datacenter;

public class TempUserProxy {
    public static IUserOp userOp;

    public static void clearExpireTime() {
        if (userOp != null) {
            userOp.clearExpireTime();
        }
    }

    public static void clearUserInfo() {
        if (userOp != null) {
            userOp.clearUserInfo();
        }
    }

    public static long getExpiredTime() {
        if (userOp == null) {
            return 0;
        }
        return userOp.getExpiredTime();
    }

    public static String getSNSId() {
        if (userOp == null) {
            return null;
        }
        return userOp.getSNSId();
    }

    public static String getSNSToken() {
        if (userOp == null) {
            return null;
        }
        return userOp.getSNSToken();
    }

    public static int getSNSType() {
        if (userOp == null) {
            return 0;
        }
        return userOp.getSNSType();
    }

    public static String getUserId() {
        if (userOp == null) {
            return null;
        }
        return userOp.getUserId();
    }

    public static String getUserToken() {
        if (userOp == null) {
            return null;
        }
        return userOp.getUserToken();
    }

    public static void save(long j, String str, int i) {
        if (userOp != null) {
            userOp.save(j, str, i);
        }
    }

    public static void saveAvatar(String str) {
        if (userOp != null) {
            userOp.saveAvatar(str);
        }
    }

    public static void saveBackground(String str) {
        if (userOp != null) {
            userOp.saveBackground(str);
        }
    }

    public static void saveToken(String str, long j) {
        if (userOp != null) {
            userOp.saveToken(str, j);
        }
    }
}
