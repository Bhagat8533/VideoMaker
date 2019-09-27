package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.model.OSSResult;
import java.io.IOException;

public interface ResponseParser<T extends OSSResult> {
    T parse(ResponseMessage responseMessage) throws IOException;
}
