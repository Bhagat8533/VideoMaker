package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.common.OSSLog;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class OSSRetryHandler {
    private int maxRetryCount = 2;

    /* renamed from: com.aiii.sdk.android.oss.internal.OSSRetryHandler$1 */
    static /* synthetic */ class C19691 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType = new int[OSSRetryType.values().length];

        static {
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType[OSSRetryType.OSSRetryTypeShouldRetry.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public OSSRetryHandler(int i) {
        setMaxRetryCount(i);
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public OSSRetryType shouldRetry(Exception exc, int i) {
        if (i >= this.maxRetryCount) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        if (exc instanceof ClientException) {
            if (((ClientException) exc).isCanceledException().booleanValue()) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            Exception exc2 = (Exception) exc.getCause();
            if ((exc2 instanceof InterruptedIOException) && !(exc2 instanceof SocketTimeoutException)) {
                OSSLog.logError("[shouldRetry] - is interrupted!");
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            } else if (exc2 instanceof IllegalArgumentException) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("shouldRetry - ");
                sb.append(exc.toString());
                OSSLog.logDebug(sb.toString());
                exc.getCause().printStackTrace();
                return OSSRetryType.OSSRetryTypeShouldRetry;
            }
        } else if (!(exc instanceof ServiceException)) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        } else {
            ServiceException serviceException = (ServiceException) exc;
            return (serviceException.getErrorCode() == null || !serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) ? serviceException.getStatusCode() >= 500 ? OSSRetryType.OSSRetryTypeShouldRetry : OSSRetryType.OSSRetryTypeShouldNotRetry : OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
        }
    }

    public long timeInterval(int i, OSSRetryType oSSRetryType) {
        if (C19691.$SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType[oSSRetryType.ordinal()] != 1) {
            return 0;
        }
        return ((long) Math.pow(2.0d, (double) i)) * 200;
    }
}
