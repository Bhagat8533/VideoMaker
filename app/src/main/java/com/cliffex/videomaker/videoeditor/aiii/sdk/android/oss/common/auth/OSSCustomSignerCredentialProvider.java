package com.aiii.sdk.android.oss.common.auth;

public abstract class OSSCustomSignerCredentialProvider implements OSSCredentialProvider {
    public OSSFederationToken getFederationToken() {
        return null;
    }

    public abstract String signContent(String str);
}
