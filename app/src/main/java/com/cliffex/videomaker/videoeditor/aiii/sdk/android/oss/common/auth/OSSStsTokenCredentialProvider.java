package com.aiii.sdk.android.oss.common.auth;

public class OSSStsTokenCredentialProvider implements OSSCredentialProvider {
    private String accessKeyId;
    private String secretKeyId;
    private String securityToken;

    public OSSStsTokenCredentialProvider(OSSFederationToken oSSFederationToken) {
        setAccessKeyId(oSSFederationToken.getTempAK().trim());
        setSecretKeyId(oSSFederationToken.getTempSK().trim());
        setSecurityToken(oSSFederationToken.getSecurityToken().trim());
    }

    public OSSStsTokenCredentialProvider(String str, String str2, String str3) {
        setAccessKeyId(str.trim());
        setSecretKeyId(str2.trim());
        setSecurityToken(str3.trim());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public OSSFederationToken getFederationToken() {
        OSSFederationToken oSSFederationToken = new OSSFederationToken(this.accessKeyId, this.secretKeyId, this.securityToken, Long.MAX_VALUE);
        return oSSFederationToken;
    }

    public String getSecretKeyId() {
        return this.secretKeyId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setSecretKeyId(String str) {
        this.secretKeyId = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }
}
