package com.aiii.sdk.android.oss.common.auth;

@Deprecated
public class OSSPlainTextAKSKCredentialProvider implements OSSCredentialProvider {
    private String accessKeyId;
    private String accessKeySecret;

    public OSSPlainTextAKSKCredentialProvider(String str, String str2) {
        setAccessKeyId(str.trim());
        setAccessKeySecret(str2.trim());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public OSSFederationToken getFederationToken() {
        return null;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }
}
