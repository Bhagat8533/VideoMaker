package com.aiii.sdk.android.oss.network;

import java.io.IOException;
import java.io.InputStream;
import okhttp3.C9802ac;
import okhttp3.C9804ad;
import okhttp3.C9945u;
import okhttp3.C9945u.C9946a;
import okhttp3.C9951x;

public class NetworkProgressHelper {
    public static ProgressTouchableRequestBody addProgressRequestBody(InputStream inputStream, long j, String str, ExecutionContext executionContext) {
        ProgressTouchableRequestBody progressTouchableRequestBody = new ProgressTouchableRequestBody(inputStream, j, str, executionContext);
        return progressTouchableRequestBody;
    }

    public static C9951x addProgressResponseListener(C9951x xVar, final ExecutionContext executionContext) {
        return xVar.aWQ().mo38232b((C9945u) new C9945u() {
            public C9802ac intercept(C9946a aVar) throws IOException {
                C9802ac c = aVar.mo37939c(aVar.aVO());
                return c.aXi().mo37792f((C9804ad) new ProgressTouchableResponseBody(c.aXh(), executionContext)).aXm();
            }
        }).aWR();
    }
}
