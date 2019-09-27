package com.aiii.sdk.android.oss.common.auth;

import com.aiii.sdk.android.oss.ClientException;

public interface OSSCredentialProvider {
    OSSFederationToken getFederationToken() throws ClientException;
}
