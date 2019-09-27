package com.aiii.sdk.android.oss.callback;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.model.OSSRequest;
import com.aiii.sdk.android.oss.model.OSSResult;

public interface OSSCompletedCallback<T1 extends OSSRequest, T2 extends OSSResult> {
    void onFailure(T1 t1, ClientException clientException, ServiceException serviceException);

    void onSuccess(T1 t1, T2 t2);
}
