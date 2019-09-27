package com.aiii.sdk.android.oss.common.auth;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.utils.DateUtil;

public abstract class OSSFederationCredentialProvider implements OSSCredentialProvider {
    private volatile OSSFederationToken cachedToken;

    public OSSFederationToken getCachedToken() {
        return this.cachedToken;
    }

    public abstract OSSFederationToken getFederationToken() throws ClientException;

    public synchronized OSSFederationToken getValidFederationToken() throws ClientException {
        if (this.cachedToken == null || DateUtil.getFixedSkewedTimeMillis() / 1000 > this.cachedToken.getExpiration() - 300) {
            if (this.cachedToken != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("token expired! current time: ");
                sb.append(DateUtil.getFixedSkewedTimeMillis() / 1000);
                sb.append(" token expired: ");
                sb.append(this.cachedToken.getExpiration());
                OSSLog.logDebug(sb.toString());
            }
            this.cachedToken = getFederationToken();
        }
        return this.cachedToken;
    }
}
