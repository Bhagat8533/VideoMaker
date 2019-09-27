package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.ClientConfiguration;
import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.common.HttpMethod;
import com.aiii.sdk.android.oss.common.RequestParameters;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSFederationToken;
import com.aiii.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.aiii.sdk.android.oss.common.utils.DateUtil;
import com.aiii.sdk.android.oss.common.utils.HttpUtil;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.model.GeneratePresignedUrlRequest;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ObjectURLPresigner {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;

    public ObjectURLPresigner(URI uri, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
    }

    public String presignConstrainedURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        String str;
        String bucketName = generatePresignedUrlRequest.getBucketName();
        String key = generatePresignedUrlRequest.getKey();
        String valueOf = String.valueOf((DateUtil.getFixedSkewedTimeMillis() / 1000) + generatePresignedUrlRequest.getExpiration());
        HttpMethod method = generatePresignedUrlRequest.getMethod() != null ? generatePresignedUrlRequest.getMethod() : HttpMethod.GET;
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(method);
        requestMessage.setBucketName(bucketName);
        requestMessage.setObjectKey(key);
        requestMessage.getHeaders().put("Date", valueOf);
        if (generatePresignedUrlRequest.getContentType() != null && !generatePresignedUrlRequest.getContentType().trim().equals("")) {
            requestMessage.getHeaders().put("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMD5() != null && !generatePresignedUrlRequest.getContentMD5().trim().equals("")) {
            requestMessage.getHeaders().put("Content-MD5", generatePresignedUrlRequest.getContentMD5());
        }
        if (generatePresignedUrlRequest.getQueryParameter() != null && generatePresignedUrlRequest.getQueryParameter().size() > 0) {
            for (Entry entry : generatePresignedUrlRequest.getQueryParameter().entrySet()) {
                requestMessage.getParameters().put(entry.getKey(), entry.getValue());
            }
        }
        if (generatePresignedUrlRequest.getProcess() != null && !generatePresignedUrlRequest.getProcess().trim().equals("")) {
            requestMessage.getParameters().put(RequestParameters.X_OSS_PROCESS, generatePresignedUrlRequest.getProcess());
        }
        OSSFederationToken oSSFederationToken = null;
        if (this.credentialProvider instanceof OSSFederationCredentialProvider) {
            oSSFederationToken = ((OSSFederationCredentialProvider) this.credentialProvider).getValidFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
            if (oSSFederationToken == null) {
                throw new ClientException("Can not get a federation token!");
            }
        } else if (this.credentialProvider instanceof OSSStsTokenCredentialProvider) {
            oSSFederationToken = ((OSSStsTokenCredentialProvider) this.credentialProvider).getFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
        }
        String buildCanonicalString = OSSUtils.buildCanonicalString(requestMessage);
        if ((this.credentialProvider instanceof OSSFederationCredentialProvider) || (this.credentialProvider instanceof OSSStsTokenCredentialProvider)) {
            str = OSSUtils.sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
        } else if (this.credentialProvider instanceof OSSPlainTextAKSKCredentialProvider) {
            str = OSSUtils.sign(((OSSPlainTextAKSKCredentialProvider) this.credentialProvider).getAccessKeyId(), ((OSSPlainTextAKSKCredentialProvider) this.credentialProvider).getAccessKeySecret(), buildCanonicalString);
        } else if (this.credentialProvider instanceof OSSCustomSignerCredentialProvider) {
            str = ((OSSCustomSignerCredentialProvider) this.credentialProvider).signContent(buildCanonicalString);
        } else {
            throw new ClientException("Unknown credentialProvider!");
        }
        String substring = str.split(":")[0].substring(4);
        String str2 = str.split(":")[1];
        String host = this.endpoint.getHost();
        if (!OSSUtils.isCname(host) || OSSUtils.isInCustomCnameExcludeList(host, this.conf.getCustomCnameExcludeList())) {
            StringBuilder sb = new StringBuilder();
            sb.append(bucketName);
            sb.append(".");
            sb.append(host);
            host = sb.toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Expires", valueOf);
        linkedHashMap.put(RequestParameters.OSS_ACCESS_KEY_ID, substring);
        linkedHashMap.put(RequestParameters.SIGNATURE, str2);
        linkedHashMap.putAll(requestMessage.getParameters());
        String paramToQueryString = HttpUtil.paramToQueryString(linkedHashMap, "utf-8");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.endpoint.getScheme());
        sb2.append("://");
        sb2.append(host);
        sb2.append("/");
        sb2.append(HttpUtil.urlEncode(key, "utf-8"));
        sb2.append("?");
        sb2.append(paramToQueryString);
        return sb2.toString();
    }

    public String presignConstrainedURL(String str, String str2, long j) throws ClientException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2);
        generatePresignedUrlRequest.setExpiration(j);
        return presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignPublicURL(String str, String str2) {
        String host = this.endpoint.getHost();
        if (!OSSUtils.isCname(host) || OSSUtils.isInCustomCnameExcludeList(host, this.conf.getCustomCnameExcludeList())) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".");
            sb.append(host);
            host = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.endpoint.getScheme());
        sb2.append("://");
        sb2.append(host);
        sb2.append("/");
        sb2.append(HttpUtil.urlEncode(str2, "utf-8"));
        return sb2.toString();
    }
}
