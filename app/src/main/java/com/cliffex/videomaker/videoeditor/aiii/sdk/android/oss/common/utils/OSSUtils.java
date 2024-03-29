package com.aiii.sdk.android.oss.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.aiii.sdk.android.oss.common.OSSConstants;
import com.aiii.sdk.android.oss.common.OSSHeaders;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.RequestParameters;
import com.aiii.sdk.android.oss.common.auth.HmacSHA1Signature;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSFederationToken;
import com.aiii.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.aiii.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.aiii.sdk.android.oss.exception.InconsistentException;
import com.aiii.sdk.android.oss.internal.RequestMessage;
import com.aiii.sdk.android.oss.model.CopyObjectRequest;
import com.aiii.sdk.android.oss.model.CreateBucketRequest;
import com.aiii.sdk.android.oss.model.DeleteBucketRequest;
import com.aiii.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.aiii.sdk.android.oss.model.GetBucketACLRequest;
import com.aiii.sdk.android.oss.model.GetBucketInfoRequest;
import com.aiii.sdk.android.oss.model.ListBucketsRequest;
import com.aiii.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.aiii.sdk.android.oss.model.ListObjectsRequest;
import com.aiii.sdk.android.oss.model.OSSRequest;
import com.aiii.sdk.android.oss.model.ObjectMetadata;
import com.aiii.sdk.android.oss.model.PartETag;
import com.ironsource.sdk.constants.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONObject;

public class OSSUtils {
    private static final String NEW_LINE = "\n";
    private static final List<String> SIGNED_PARAMTERS = Arrays.asList(new String[]{RequestParameters.SUBRESOURCE_BUCKETINFO, RequestParameters.SUBRESOURCE_ACL, RequestParameters.SUBRESOURCE_UPLOADS, "location", RequestParameters.SUBRESOURCE_CORS, RequestParameters.SUBRESOURCE_LOGGING, "website", RequestParameters.SUBRESOURCE_REFERER, RequestParameters.SUBRESOURCE_LIFECYCLE, RequestParameters.SUBRESOURCE_DELETE, RequestParameters.SUBRESOURCE_APPEND, RequestParameters.UPLOAD_ID, RequestParameters.PART_NUMBER, RequestParameters.SECURITY_TOKEN, "position", RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES, RequestParameters.X_OSS_PROCESS, RequestParameters.SUBRESOURCE_SEQUENTIAL, RequestParameters.X_OSS_SYMLINK, RequestParameters.X_OSS_RESTORE});

    private enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");
        
        private final String directiveAsString;

        private MetadataDirective(String str) {
            this.directiveAsString = str;
        }

        public String toString() {
            return this.directiveAsString;
        }
    }

    public static void addDateHeader(Map<String, String> map, String str, Date date) {
        if (date != null) {
            map.put(str, DateUtil.formatRfc822Date(date));
        }
    }

    public static void addHeader(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static void addStringListHeader(Map<String, String> map, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            map.put(str, join(list));
        }
    }

    public static void assertTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String buildBaseLogInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("=====[device info]=====\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[INFO]: android_version：");
        sb2.append(VERSION.RELEASE);
        sb2.append(NEW_LINE);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[INFO]: mobile_model：");
        sb3.append(Build.MODEL);
        sb3.append(NEW_LINE);
        sb.append(sb3.toString());
        String operatorName = getOperatorName(context);
        if (!TextUtils.isEmpty(operatorName)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[INFO]: operator_name：");
            sb4.append(operatorName);
            sb4.append(NEW_LINE);
            sb.append(sb4.toString());
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        String str = "unconnected";
        String str2 = "unknown";
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.CONNECTED) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(activeNetworkInfo.getTypeName());
            sb5.append(" ");
            str2 = sb5.toString();
            str = "connected";
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[INFO]: network_state：");
        sb6.append(str);
        sb6.append(NEW_LINE);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("[INFO]: network_type：");
        sb7.append(str2);
        sb.append(sb7.toString());
        return sb.toString();
    }

    public static String buildCanonicalString(RequestMessage requestMessage) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(requestMessage.getMethod().toString());
        sb2.append(NEW_LINE);
        sb.append(sb2.toString());
        Map headers = requestMessage.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null) {
            for (Entry entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals("Content-Type".toLowerCase()) || lowerCase.equals("Content-MD5".toLowerCase()) || lowerCase.equals("Date".toLowerCase()) || lowerCase.startsWith(OSSHeaders.OSS_PREFIX)) {
                        treeMap.put(lowerCase, ((String) entry.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey("Content-Type".toLowerCase())) {
            treeMap.put("Content-Type".toLowerCase(), "");
        }
        if (!treeMap.containsKey("Content-MD5".toLowerCase())) {
            treeMap.put("Content-MD5".toLowerCase(), "");
        }
        for (Entry entry2 : treeMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (str.startsWith(OSSHeaders.OSS_PREFIX)) {
                sb.append(str);
                sb.append(':');
                sb.append(value);
            } else {
                sb.append(value);
            }
            sb.append(NEW_LINE);
        }
        sb.append(buildCanonicalizedResource(requestMessage.getBucketName(), requestMessage.getObjectKey(), requestMessage.getParameters()));
        return sb.toString();
    }

    public static String buildCanonicalizedResource(String str, String str2, Map<String, String> map) {
        String str3;
        if (str == null && str2 == null) {
            str3 = "/";
        } else if (str2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(str);
            sb.append("/");
            str3 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/");
            sb2.append(str);
            sb2.append("/");
            sb2.append(str2);
            str3 = sb2.toString();
        }
        return buildCanonicalizedResource(str3, map);
    }

    public static String buildCanonicalizedResource(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map != null) {
            String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
            Arrays.sort(strArr);
            char c = '?';
            for (String str2 : strArr) {
                if (SIGNED_PARAMTERS.contains(str2)) {
                    sb.append(c);
                    sb.append(str2);
                    String str3 = (String) map.get(str2);
                    if (!isEmptyString(str3)) {
                        sb.append(Constants.RequestParameters.EQUAL);
                        sb.append(str3);
                    }
                    c = '&';
                }
            }
        }
        return sb.toString();
    }

    public static String buildImagePersistentBody(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("x-oss-process=");
        if (str3.startsWith("image/")) {
            sb.append(str3);
        } else {
            sb.append("image/");
            sb.append(str3);
        }
        sb.append("|sys/");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
            sb.append("saveas,o_");
            sb.append(encodeToString2);
            sb.append(",b_");
            sb.append(encodeToString);
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ImagePersistent body : ");
        sb3.append(sb2);
        OSSLog.logDebug(sb3.toString());
        return sb2;
    }

    public static String buildTriggerCallbackBody(Map<String, String> map, Map<String, String> map2) {
        StringBuilder sb = new StringBuilder();
        sb.append("x-oss-process=trigger/callback,callback_");
        if (map != null && map.size() > 0) {
            sb.append(Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2));
        }
        sb.append(",callback-var_");
        if (map2 != null && map2.size() > 0) {
            sb.append(Base64.encodeToString(new JSONObject(map2).toString().getBytes(), 2));
        }
        return sb.toString();
    }

    public static String buildXMLFromPartEtagList(List<PartETag> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<CompleteMultipartUpload>\n");
        for (PartETag partETag : list) {
            sb.append("<Part>\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<PartNumber>");
            sb2.append(partETag.getPartNumber());
            sb2.append("</PartNumber>\n");
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<ETag>");
            sb3.append(partETag.getETag());
            sb3.append("</ETag>\n");
            sb.append(sb3.toString());
            sb.append("</Part>\n");
        }
        sb.append("</CompleteMultipartUpload>\n");
        return sb.toString();
    }

    public static void checkChecksum(Long l, Long l2, String str) throws InconsistentException {
        if (l != null && l2 != null && !l.equals(l2)) {
            throw new InconsistentException(l, l2, str);
        }
    }

    public static boolean checkParamRange(long j, long j2, boolean z, long j3, boolean z2) {
        return (!z || !z2) ? (!z || z2) ? (z || z2) ? j2 < j && j <= j3 : j2 < j && j < j3 : j2 <= j && j < j3 : j2 <= j && j <= j3;
    }

    public static String determineContentType(String str, String str2, String str3) {
        if (str != null) {
            return str;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (str2 != null) {
            String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        if (str3 != null) {
            String mimeTypeFromExtension2 = singleton.getMimeTypeFromExtension(str3.substring(str3.lastIndexOf(46) + 1));
            if (mimeTypeFromExtension2 != null) {
                return mimeTypeFromExtension2;
            }
        }
        return "application/octet-stream";
    }

    public static boolean doesBucketNameValid(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof ListBucketsRequest);
    }

    public static boolean doesRequestNeedObjectKey(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof ListObjectsRequest) && !(oSSRequest instanceof ListBucketsRequest) && !(oSSRequest instanceof CreateBucketRequest) && !(oSSRequest instanceof DeleteBucketRequest) && !(oSSRequest instanceof GetBucketInfoRequest) && !(oSSRequest instanceof GetBucketACLRequest) && !(oSSRequest instanceof DeleteMultipleObjectRequest) && !(oSSRequest instanceof ListMultipartUploadsRequest);
    }

    public static void ensureBucketNameValid(String str) {
        if (!validateBucketName(str)) {
            throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    public static void ensureObjectKeyValid(String str) {
        if (!validateObjectKey(str)) {
            throw new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    public static void ensureRequestValid(OSSRequest oSSRequest, RequestMessage requestMessage) {
        if (doesBucketNameValid(oSSRequest)) {
            ensureBucketNameValid(requestMessage.getBucketName());
        }
        if (doesRequestNeedObjectKey(oSSRequest)) {
            ensureObjectKeyValid(requestMessage.getObjectKey());
        }
        if (oSSRequest instanceof CopyObjectRequest) {
            ensureObjectKeyValid(((CopyObjectRequest) oSSRequest).getDestinationKey());
        }
    }

    private static String getOperatorName(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        return simOperator != null ? (simOperator.equals("46000") || simOperator.equals("46002")) ? "CMCC" : simOperator.equals("46001") ? "CUCC" : simOperator.equals("46003") ? "CTCC" : simOperator : "";
    }

    public static boolean isCname(String str) {
        for (String endsWith : OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyString(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isInCustomCnameExcludeList(String str, List<String> list) {
        for (String lowerCase : list) {
            if (str.endsWith(lowerCase.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOssOriginHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String endsWith : OSSConstants.OSS_ORIGN_HOST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidateIP(String str) throws Exception {
        if (str != null) {
            try {
                return str.equals(InetAddress.getByName(str).getHostAddress());
            } catch (UnknownHostException unused) {
                return false;
            }
        } else {
            throw new Exception("host is null");
        }
    }

    public static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!z) {
                sb.append(Constants.RequestParameters.AMPERSAND);
            }
            sb.append(HttpUtil.urlEncode(str2, str));
            if (!isEmptyString(str3)) {
                sb.append(Constants.RequestParameters.EQUAL);
                sb.append(HttpUtil.urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static void populateCopyObjectHeaders(CopyObjectRequest copyObjectRequest, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(copyObjectRequest.getSourceBucketName());
        sb.append("/");
        sb.append(HttpUtil.urlEncode(copyObjectRequest.getSourceKey(), "utf-8"));
        map.put(OSSHeaders.COPY_OBJECT_SOURCE, sb.toString());
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH, copyObjectRequest.getNonmatchingEtagConstraints());
        addHeader(map, OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, copyObjectRequest.getServerSideEncryption());
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            map.put(OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE, MetadataDirective.REPLACE.toString());
            populateRequestMetadata(map, newObjectMetadata);
        }
        removeHeader(map, "Content-Length");
    }

    public static void populateListBucketRequestParameters(ListBucketsRequest listBucketsRequest, Map<String, String> map) {
        if (listBucketsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listBucketsRequest.getPrefix());
        }
        if (listBucketsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listBucketsRequest.getMarker());
        }
        if (listBucketsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listBucketsRequest.getMaxKeys().intValue()));
        }
    }

    public static void populateListMultipartUploadsRequestParameters(ListMultipartUploadsRequest listMultipartUploadsRequest, Map<String, String> map) {
        if (listMultipartUploadsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listMultipartUploadsRequest.getDelimiter());
        }
        if (listMultipartUploadsRequest.getMaxUploads() != null) {
            map.put(RequestParameters.MAX_UPLOADS, Integer.toString(listMultipartUploadsRequest.getMaxUploads().intValue()));
        }
        if (listMultipartUploadsRequest.getKeyMarker() != null) {
            map.put(RequestParameters.KEY_MARKER, listMultipartUploadsRequest.getKeyMarker());
        }
        if (listMultipartUploadsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listMultipartUploadsRequest.getPrefix());
        }
        if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
            map.put(RequestParameters.UPLOAD_ID_MARKER, listMultipartUploadsRequest.getUploadIdMarker());
        }
        if (listMultipartUploadsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listMultipartUploadsRequest.getEncodingType());
        }
    }

    public static void populateListObjectsRequestParameters(ListObjectsRequest listObjectsRequest, Map<String, String> map) {
        if (listObjectsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        }
    }

    public static String populateMapToBase64JsonString(Map<String, String> map) {
        return Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2);
    }

    public static void populateRequestMetadata(Map<String, String> map, ObjectMetadata objectMetadata) {
        if (objectMetadata != null) {
            Map rawMetadata = objectMetadata.getRawMetadata();
            if (rawMetadata != null) {
                for (Entry entry : rawMetadata.entrySet()) {
                    map.put(entry.getKey(), entry.getValue().toString());
                }
            }
            Map userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Entry entry2 : userMetadata.entrySet()) {
                    String str = (String) entry2.getKey();
                    String str2 = (String) entry2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    map.put(str, str2);
                }
            }
        }
    }

    public static void removeHeader(Map<String, String> map, String str) {
        if (str != null && map.containsKey(str)) {
            map.remove(str);
        }
    }

    public static String sign(String str, String str2, String str3) {
        try {
            String trim = new HmacSHA1Signature().computeSignature(str2, str3).trim();
            StringBuilder sb = new StringBuilder();
            sb.append("OSS ");
            sb.append(str);
            sb.append(":");
            sb.append(trim);
            return sb.toString();
        } catch (Exception e) {
            throw new IllegalStateException("Compute signature failed!", e);
        }
    }

    public static void signRequest(RequestMessage requestMessage) throws Exception {
        if (requestMessage.isAuthorizationRequired()) {
            if (requestMessage.getCredentialProvider() != null) {
                OSSCredentialProvider credentialProvider = requestMessage.getCredentialProvider();
                OSSFederationToken oSSFederationToken = null;
                boolean z = credentialProvider instanceof OSSFederationCredentialProvider;
                if (z) {
                    oSSFederationToken = ((OSSFederationCredentialProvider) credentialProvider).getValidFederationToken();
                    if (oSSFederationToken != null) {
                        requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                    } else {
                        OSSLog.logError("Can't get a federation token");
                        throw new IOException("Can't get a federation token");
                    }
                } else if (credentialProvider instanceof OSSStsTokenCredentialProvider) {
                    oSSFederationToken = credentialProvider.getFederationToken();
                    requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                }
                String buildCanonicalString = buildCanonicalString(requestMessage);
                String str = "---initValue---";
                if (z || (credentialProvider instanceof OSSStsTokenCredentialProvider)) {
                    str = sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
                } else if (credentialProvider instanceof OSSPlainTextAKSKCredentialProvider) {
                    OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = (OSSPlainTextAKSKCredentialProvider) credentialProvider;
                    str = sign(oSSPlainTextAKSKCredentialProvider.getAccessKeyId(), oSSPlainTextAKSKCredentialProvider.getAccessKeySecret(), buildCanonicalString);
                } else if (credentialProvider instanceof OSSCustomSignerCredentialProvider) {
                    str = ((OSSCustomSignerCredentialProvider) credentialProvider).signContent(buildCanonicalString);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("signed content: ");
                sb.append(buildCanonicalString);
                sb.append("   \n ---------   signature: ");
                sb.append(str);
                OSSLog.logDebug(sb.toString(), false);
                requestMessage.getHeaders().put("Authorization", str);
                return;
            }
            throw new IllegalStateException("当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;");
        }
    }

    public static boolean validateBucketName(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$");
    }

    public static boolean validateObjectKey(String str) {
        if (str == null || str.length() <= 0 || str.length() > 1023) {
            return false;
        }
        try {
            str.getBytes("utf-8");
            char[] charArray = str.toCharArray();
            char c = charArray[0];
            if (c == '/' || c == '\\') {
                return false;
            }
            for (char c2 : charArray) {
                if (c2 != 9 && c2 < ' ') {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }
}
