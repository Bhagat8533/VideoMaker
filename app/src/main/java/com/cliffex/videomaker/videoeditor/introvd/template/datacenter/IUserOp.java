package com.introvd.template.datacenter;

public interface IUserOp {
    void clearExpireTime();

    void clearUserInfo();

    long getExpiredTime();

    String getSNSId();

    String getSNSToken();

    int getSNSType();

    String getUserId();

    String getUserToken();

    void save(long j, String str, int i);

    void saveAvatar(String str);

    void saveBackground(String str);

    void saveToken(String str, long j);
}
