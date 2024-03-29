package com.aiii.sdk.android.oss.model;

import com.aiii.sdk.android.oss.common.OSSConstants;
import com.aiii.sdk.android.oss.common.OSSHeaders;
import com.aiii.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.aiii.sdk.android.oss.common.utils.DateUtil;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class ObjectMetadata {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = "AES256";
    private Map<String, Object> metadata = new CaseInsensitiveHashMap();
    private Map<String, String> userMetadata = new CaseInsensitiveHashMap();

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public String getCacheControl() {
        return (String) this.metadata.get("Cache-Control");
    }

    public String getContentDisposition() {
        return (String) this.metadata.get("Content-Disposition");
    }

    public String getContentEncoding() {
        return (String) this.metadata.get("Content-Encoding");
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public String getContentMD5() {
        return (String) this.metadata.get("Content-MD5");
    }

    public String getContentType() {
        return (String) this.metadata.get("Content-Type");
    }

    public String getETag() {
        return (String) this.metadata.get("ETag");
    }

    public Date getExpirationTime() throws ParseException {
        return DateUtil.parseRfc822Date((String) this.metadata.get("Expires"));
    }

    public Date getLastModified() {
        return (Date) this.metadata.get("Last-Modified");
    }

    public String getObjectType() {
        return (String) this.metadata.get(OSSHeaders.OSS_OBJECT_TYPE);
    }

    public String getRawExpiresValue() {
        return (String) this.metadata.get("Expires");
    }

    public Map<String, Object> getRawMetadata() {
        return Collections.unmodifiableMap(this.metadata);
    }

    public String getSHA1() {
        return (String) this.metadata.get(OSSHeaders.OSS_HASH_SHA1);
    }

    public String getServerSideEncryption() {
        return (String) this.metadata.get(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION);
    }

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setCacheControl(String str) {
        this.metadata.put("Cache-Control", str);
    }

    public void setContentDisposition(String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public void setContentEncoding(String str) {
        this.metadata.put("Content-Encoding", str);
    }

    public void setContentLength(long j) {
        if (j <= OSSConstants.DEFAULT_FILE_SIZE_LIMIT) {
            this.metadata.put("Content-Length", Long.valueOf(j));
            return;
        }
        throw new IllegalArgumentException("The content length could not be more than 5GB.");
    }

    public void setContentMD5(String str) {
        this.metadata.put("Content-MD5", str);
    }

    public void setContentType(String str) {
        this.metadata.put("Content-Type", str);
    }

    public void setExpirationTime(Date date) {
        this.metadata.put("Expires", DateUtil.formatRfc822Date(date));
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void setLastModified(Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public void setSHA1(String str) {
        this.metadata.put(OSSHeaders.OSS_HASH_SHA1, str);
    }

    public void setServerSideEncryption(String str) {
        this.metadata.put(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, str);
    }

    public void setUserMetadata(Map<String, String> map) {
        this.userMetadata.clear();
        if (map != null && !map.isEmpty()) {
            this.userMetadata.putAll(map);
        }
    }

    public String toString() {
        String str = "";
        try {
            str = getExpirationTime().toString();
        } catch (Exception unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Last-Modified:");
        sb.append(getLastModified());
        sb.append("\n");
        sb.append("Expires");
        sb.append(":");
        sb.append(str);
        sb.append("\nrawExpires:");
        sb.append(getRawExpiresValue());
        sb.append("\n");
        sb.append("Content-MD5");
        sb.append(":");
        sb.append(getContentMD5());
        sb.append("\n");
        sb.append(OSSHeaders.OSS_OBJECT_TYPE);
        sb.append(":");
        sb.append(getObjectType());
        sb.append("\n");
        sb.append(OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION);
        sb.append(":");
        sb.append(getServerSideEncryption());
        sb.append("\n");
        sb.append("Content-Disposition");
        sb.append(":");
        sb.append(getContentDisposition());
        sb.append("\n");
        sb.append("Content-Encoding");
        sb.append(":");
        sb.append(getContentEncoding());
        sb.append("\n");
        sb.append("Cache-Control");
        sb.append(":");
        sb.append(getCacheControl());
        sb.append("\n");
        sb.append("ETag");
        sb.append(":");
        sb.append(getETag());
        sb.append("\n");
        return sb.toString();
    }
}
