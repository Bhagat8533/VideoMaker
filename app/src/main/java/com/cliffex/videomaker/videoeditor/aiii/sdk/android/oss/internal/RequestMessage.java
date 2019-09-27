package com.aiii.sdk.android.oss.internal;

import android.text.TextUtils;
import com.aiii.sdk.android.oss.common.HttpMethod;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.common.utils.HttpUtil;
import com.aiii.sdk.android.oss.common.utils.HttpdnsMini;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RequestMessage extends HttpMessage {
    private String bucketName;
    private boolean checkCRC64;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;
    private boolean httpDnsEnable = false;
    private boolean isAuthorizationRequired = true;
    private boolean isInCustomCnameExcludeList = false;
    private HttpMethod method;
    private String objectKey;
    private Map<String, String> parameters = new LinkedHashMap();
    private URI service;
    private byte[] uploadData;
    private String uploadFilePath;

    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public String buildCanonicalURL() throws Exception {
        String str;
        OSSUtils.assertTrue(this.endpoint != null, "Endpoint haven't been set!");
        String scheme = this.endpoint.getScheme();
        String host = this.endpoint.getHost();
        int port = this.endpoint.getPort();
        String str2 = null;
        String valueOf = port != -1 ? String.valueOf(port) : null;
        if (TextUtils.isEmpty(host)) {
            String uri = this.endpoint.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("endpoint url : ");
            sb.append(uri);
            OSSLog.logDebug(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(scheme);
            sb2.append("://");
            host = uri.substring(sb2.toString().length(), uri.length());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" scheme : ");
        sb3.append(scheme);
        OSSLog.logDebug(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" originHost : ");
        sb4.append(host);
        OSSLog.logDebug(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" port : ");
        sb5.append(valueOf);
        OSSLog.logDebug(sb5.toString());
        this.endpoint.toString();
        if (TextUtils.isEmpty(this.bucketName)) {
            str = this.endpoint.toString();
        } else if (OSSUtils.isValidateIP(host)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.endpoint.toString());
            sb6.append("/");
            sb6.append(this.bucketName);
            str = sb6.toString();
        } else if (OSSUtils.isOssOriginHost(host)) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.bucketName);
            sb7.append(".");
            sb7.append(host);
            String sb8 = sb7.toString();
            if (isHttpDnsEnable()) {
                str2 = HttpdnsMini.getInstance().getIpByHostAsync(sb8);
            } else {
                OSSLog.logDebug("[buildCannonicalURL], disable httpdns");
            }
            addHeader("Host", sb8);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(scheme);
                sb9.append("://");
                sb9.append(str2);
                str = sb9.toString();
            } else {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(scheme);
                sb10.append("://");
                sb10.append(sb8);
                str = sb10.toString();
            }
        } else {
            str = this.endpoint.toString();
        }
        if (!TextUtils.isEmpty(this.objectKey)) {
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str);
            sb11.append("/");
            sb11.append(HttpUtil.urlEncode(this.objectKey, "utf-8"));
            str = sb11.toString();
        }
        String paramToQueryString = OSSUtils.paramToQueryString(this.parameters, "utf-8");
        StringBuilder sb12 = new StringBuilder();
        sb12.append("request---------------------\n");
        StringBuilder sb13 = new StringBuilder();
        sb13.append("request url=");
        sb13.append(str);
        sb13.append("\n");
        sb12.append(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("request params=");
        sb14.append(paramToQueryString);
        sb14.append("\n");
        sb12.append(sb14.toString());
        for (String str3 : getHeaders().keySet()) {
            StringBuilder sb15 = new StringBuilder();
            sb15.append("requestHeader [");
            sb15.append(str3);
            sb15.append("]: ");
            sb12.append(sb15.toString());
            StringBuilder sb16 = new StringBuilder();
            sb16.append((String) getHeaders().get(str3));
            sb16.append("\n");
            sb12.append(sb16.toString());
        }
        OSSLog.logDebug(sb12.toString());
        if (OSSUtils.isEmptyString(paramToQueryString)) {
            return str;
        }
        StringBuilder sb17 = new StringBuilder();
        sb17.append(str);
        sb17.append("?");
        sb17.append(paramToQueryString);
        return sb17.toString();
    }

    public String buildOSSServiceURL() {
        OSSUtils.assertTrue(this.service != null, "Service haven't been set!");
        String host = this.service.getHost();
        String scheme = this.service.getScheme();
        String str = null;
        if (isHttpDnsEnable()) {
            str = HttpdnsMini.getInstance().getIpByHostAsync(host);
        } else {
            OSSLog.logDebug("[buildOSSServiceURL], disable httpdns");
        }
        if (str == null) {
            str = host;
        }
        getHeaders().put("Host", host);
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(str);
        String sb2 = sb.toString();
        String paramToQueryString = OSSUtils.paramToQueryString(this.parameters, "utf-8");
        if (OSSUtils.isEmptyString(paramToQueryString)) {
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("?");
        sb3.append(paramToQueryString);
        return sb3.toString();
    }

    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    public void createBucketRequestBodyMarshall(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            stringBuffer.append("<CreateBucketConfiguration>");
            for (Entry entry : map.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("<");
                sb.append((String) entry.getKey());
                sb.append(">");
                sb.append((String) entry.getValue());
                sb.append("</");
                sb.append((String) entry.getKey());
                sb.append(">");
                stringBuffer.append(sb.toString());
            }
            stringBuffer.append("</CreateBucketConfiguration>");
            byte[] bytes = stringBuffer.toString().getBytes("utf-8");
            long length = (long) bytes.length;
            setContent(new ByteArrayInputStream(bytes));
            setContentLength(length);
        }
    }

    public byte[] deleteMultipleObjectRequestBodyMarshall(List<String> list, boolean z) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<Delete>");
        if (z) {
            stringBuffer.append("<Quiet>true</Quiet>");
        } else {
            stringBuffer.append("<Quiet>false</Quiet>");
        }
        for (String str : list) {
            stringBuffer.append("<Object>");
            stringBuffer.append("<Key>");
            stringBuffer.append(str);
            stringBuffer.append("</Key>");
            stringBuffer.append("</Object>");
        }
        stringBuffer.append("</Delete>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = (long) bytes.length;
        setContent(new ByteArrayInputStream(bytes));
        setContentLength(length);
        return bytes;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public /* bridge */ /* synthetic */ InputStream getContent() {
        return super.getContent();
    }

    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    public OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public URI getService() {
        return this.service;
    }

    public /* bridge */ /* synthetic */ String getStringBody() {
        return super.getStringBody();
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isInCustomCnameExcludeList() {
        return this.isInCustomCnameExcludeList;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public /* bridge */ /* synthetic */ void setContent(InputStream inputStream) {
        super.setContent(inputStream);
    }

    public /* bridge */ /* synthetic */ void setContentLength(long j) {
        super.setContentLength(j);
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public /* bridge */ /* synthetic */ void setHeaders(Map map) {
        super.setHeaders(map);
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }

    public void setIsInCustomCnameExcludeList(boolean z) {
        this.isInCustomCnameExcludeList = z;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public void setService(URI uri) {
        this.service = uri;
    }

    public /* bridge */ /* synthetic */ void setStringBody(String str) {
        super.setStringBody(str);
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public void setUploadFilePath(String str) {
        this.uploadFilePath = str;
    }
}
