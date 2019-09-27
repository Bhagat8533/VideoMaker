package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.common.OSSHeaders;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.aiii.sdk.android.oss.model.OSSResult;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.zip.CheckedInputStream;
import okhttp3.C9802ac;
import okhttp3.C9941s;

public abstract class AbstractResponseParser<T extends OSSResult> implements ResponseParser {
    private CaseInsensitiveHashMap<String, String> parseResponseHeader(C9802ac acVar) {
        CaseInsensitiveHashMap<String, String> caseInsensitiveHashMap = new CaseInsensitiveHashMap<>();
        C9941s aWY = acVar.aWY();
        for (int i = 0; i < aWY.size(); i++) {
            caseInsensitiveHashMap.put(aWY.mo38147xn(i), aWY.mo38148xo(i));
        }
        return caseInsensitiveHashMap;
    }

    public static void safeCloseResponse(ResponseMessage responseMessage) {
        try {
            responseMessage.close();
        } catch (Exception unused) {
        }
    }

    public boolean needCloseResponse() {
        return true;
    }

    public T parse(ResponseMessage responseMessage) throws IOException {
        try {
            T t = (OSSResult) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            if (t != null) {
                t.setRequestId((String) responseMessage.getHeaders().get(OSSHeaders.OSS_HEADER_REQUEST_ID));
                t.setStatusCode(responseMessage.getStatusCode());
                t.setResponseHeader(parseResponseHeader(responseMessage.getResponse()));
                setCRC(t, responseMessage);
                t = parseData(responseMessage, t);
            }
            if (needCloseResponse()) {
                safeCloseResponse(responseMessage);
            }
            return t;
        } catch (Exception e) {
            IOException iOException = new IOException(e.getMessage(), e);
            e.printStackTrace();
            OSSLog.logThrowable2Local(e);
            throw iOException;
        } catch (Throwable th) {
            if (needCloseResponse()) {
                safeCloseResponse(responseMessage);
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract T parseData(ResponseMessage responseMessage, T t) throws Exception;

    public <Result extends OSSResult> void setCRC(Result result, ResponseMessage responseMessage) {
        InputStream content = responseMessage.getRequest().getContent();
        if (content != null && (content instanceof CheckedInputStream)) {
            result.setClientCRC(Long.valueOf(((CheckedInputStream) content).getChecksum().getValue()));
        }
        String str = (String) responseMessage.getHeaders().get(OSSHeaders.OSS_HASH_CRC64_ECMA);
        if (str != null) {
            result.setServerCRC(Long.valueOf(new BigInteger(str).longValue()));
        }
    }
}
