package com.aiii.sdk.android.oss.network;

import com.aiii.sdk.android.oss.internal.OSSRetryHandler;
import com.aiii.sdk.android.oss.internal.RequestMessage;
import com.aiii.sdk.android.oss.internal.ResponseMessage;
import com.aiii.sdk.android.oss.internal.ResponseParser;
import com.aiii.sdk.android.oss.model.OSSResult;
import java.util.HashMap;
import java.util.concurrent.Callable;
import okhttp3.C9802ac;
import okhttp3.C9941s;
import okhttp3.C9951x;

public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private C9951x client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser2, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser2;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, C9802ac acVar) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(acVar);
        HashMap hashMap = new HashMap();
        C9941s aWY = acVar.aWY();
        for (int i = 0; i < aWY.size(); i++) {
            hashMap.put(aWY.mo38147xn(i), aWY.mo38148xo(i));
        }
        responseMessage.setHeaders(hashMap);
        responseMessage.setStatusCode(acVar.aTm());
        responseMessage.setContentLength(acVar.aXh().contentLength());
        responseMessage.setContent(acVar.aXh().byteStream());
        return responseMessage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0140 A[Catch:{ Exception -> 0x027d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0172 A[Catch:{ Exception -> 0x027d }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02cf A[SYNTHETIC, Splitter:B:83:0x02cf] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T call() throws java.lang.Exception {
        /*
            r13 = this;
            r0 = 1
            r1 = 0
            com.aiii.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x027d }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x027d }
            if (r2 == 0) goto L_0x0017
            com.aiii.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x027d }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x027d }
            java.lang.String r2 = com.aiii.sdk.android.oss.common.utils.OSSUtils.buildBaseLogInfo(r2)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.OSSLog.logInfo(r2)     // Catch:{ Exception -> 0x027d }
        L_0x0017:
            java.lang.String r2 = "[call] - "
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r2)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.model.OSSRequest r2 = r2.getRequest()     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r3 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.utils.OSSUtils.ensureRequestValid(r2, r3)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r3 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.utils.OSSUtils.signRequest(r3)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.network.ExecutionContext r3 = r13.context     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.network.CancellationHandler r3 = r3.getCancellationHandler()     // Catch:{ Exception -> 0x027d }
            boolean r3 = r3.isCancelled()     // Catch:{ Exception -> 0x027d }
            if (r3 != 0) goto L_0x0275
            okhttp3.aa$a r3 = new okhttp3.aa$a     // Catch:{ Exception -> 0x027d }
            r3.<init>()     // Catch:{ Exception -> 0x027d }
            boolean r4 = r2 instanceof com.aiii.sdk.android.oss.model.ListBucketsRequest     // Catch:{ Exception -> 0x027d }
            if (r4 == 0) goto L_0x0048
            com.aiii.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x027d }
            java.lang.String r4 = r4.buildOSSServiceURL()     // Catch:{ Exception -> 0x027d }
            goto L_0x004e
        L_0x0048:
            com.aiii.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x027d }
            java.lang.String r4 = r4.buildCanonicalURL()     // Catch:{ Exception -> 0x027d }
        L_0x004e:
            okhttp3.aa$a r3 = r3.mo37760tu(r4)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x027d }
            java.util.Map r4 = r4.getHeaders()     // Catch:{ Exception -> 0x027d }
            java.util.Set r4 = r4.keySet()     // Catch:{ Exception -> 0x027d }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x027d }
        L_0x0060:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x027d }
            if (r5 == 0) goto L_0x007d
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r6 = r13.message     // Catch:{ Exception -> 0x027d }
            java.util.Map r6 = r6.getHeaders()     // Catch:{ Exception -> 0x027d }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x027d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x027d }
            okhttp3.aa$a r3 = r3.mo37759bR(r5, r6)     // Catch:{ Exception -> 0x027d }
            goto L_0x0060
        L_0x007d:
            com.aiii.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x027d }
            java.util.Map r4 = r4.getHeaders()     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = "Content-Type"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x027d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x027d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027d }
            r5.<init>()     // Catch:{ Exception -> 0x027d }
            java.lang.String r6 = "request method = "
            r5.append(r6)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r6 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.HttpMethod r6 = r6.getMethod()     // Catch:{ Exception -> 0x027d }
            r5.append(r6)     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r5)     // Catch:{ Exception -> 0x027d }
            int[] r5 = com.aiii.sdk.android.oss.network.OSSRequestTask.C19721.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r6 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.HttpMethod r6 = r6.getMethod()     // Catch:{ Exception -> 0x027d }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x027d }
            r5 = r5[r6]     // Catch:{ Exception -> 0x027d }
            r6 = 0
            switch(r5) {
                case 1: goto L_0x00cb;
                case 2: goto L_0x00cb;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00bf;
                case 5: goto L_0x00b9;
                default: goto L_0x00b7;
            }     // Catch:{ Exception -> 0x027d }
        L_0x00b7:
            goto L_0x01a5
        L_0x00b9:
            okhttp3.aa$a r3 = r3.aXe()     // Catch:{ Exception -> 0x027d }
            goto L_0x01a5
        L_0x00bf:
            okhttp3.aa$a r3 = r3.aXd()     // Catch:{ Exception -> 0x027d }
            goto L_0x01a5
        L_0x00c5:
            okhttp3.aa$a r3 = r3.aXc()     // Catch:{ Exception -> 0x027d }
            goto L_0x01a5
        L_0x00cb:
            if (r4 == 0) goto L_0x00cf
            r5 = 1
            goto L_0x00d0
        L_0x00cf:
            r5 = 0
        L_0x00d0:
            java.lang.String r7 = "Content type can't be null when upload!"
            com.aiii.sdk.android.oss.common.utils.OSSUtils.assertTrue(r5, r7)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            byte[] r5 = r5.getUploadData()     // Catch:{ Exception -> 0x027d }
            r7 = 0
            if (r5 == 0) goto L_0x00f5
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            byte[] r7 = r7.getUploadData()     // Catch:{ Exception -> 0x027d }
            r5.<init>(r7)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            byte[] r7 = r7.getUploadData()     // Catch:{ Exception -> 0x027d }
            int r7 = r7.length     // Catch:{ Exception -> 0x027d }
            long r7 = (long) r7     // Catch:{ Exception -> 0x027d }
        L_0x00f2:
            r10 = r7
            r7 = r1
            goto L_0x013e
        L_0x00f5:
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = r5.getUploadFilePath()     // Catch:{ Exception -> 0x027d }
            if (r5 == 0) goto L_0x0120
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r9 = r13.message     // Catch:{ Exception -> 0x027d }
            java.lang.String r9 = r9.getUploadFilePath()     // Catch:{ Exception -> 0x027d }
            r5.<init>(r9)     // Catch:{ Exception -> 0x027d }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x027d }
            r9.<init>(r5)     // Catch:{ Exception -> 0x027d }
            long r10 = r5.length()     // Catch:{ Exception -> 0x027d }
            int r5 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0118
            r7 = r1
            r5 = r9
            goto L_0x013e
        L_0x0118:
            com.aiii.sdk.android.oss.ClientException r2 = new com.aiii.sdk.android.oss.ClientException     // Catch:{ Exception -> 0x027d }
            java.lang.String r3 = "the length of file is 0!"
            r2.<init>(r3)     // Catch:{ Exception -> 0x027d }
            throw r2     // Catch:{ Exception -> 0x027d }
        L_0x0120:
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            java.io.InputStream r5 = r5.getContent()     // Catch:{ Exception -> 0x027d }
            if (r5 == 0) goto L_0x0135
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            java.io.InputStream r5 = r5.getContent()     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            long r7 = r7.getContentLength()     // Catch:{ Exception -> 0x027d }
            goto L_0x00f2
        L_0x0135:
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = r5.getStringBody()     // Catch:{ Exception -> 0x027d }
            r10 = r7
            r7 = r5
            r5 = r1
        L_0x013e:
            if (r5 == 0) goto L_0x0172
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            boolean r7 = r7.isCheckCRC64()     // Catch:{ Exception -> 0x027d }
            if (r7 == 0) goto L_0x0153
            java.util.zip.CheckedInputStream r7 = new java.util.zip.CheckedInputStream     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.utils.CRC64 r8 = new com.aiii.sdk.android.oss.common.utils.CRC64     // Catch:{ Exception -> 0x027d }
            r8.<init>()     // Catch:{ Exception -> 0x027d }
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x027d }
            r5 = r7
        L_0x0153:
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            r7.setContent(r5)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            r7.setContentLength(r10)     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.HttpMethod r7 = r7.getMethod()     // Catch:{ Exception -> 0x027d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.network.ExecutionContext r8 = r13.context     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.network.ProgressTouchableRequestBody r4 = com.aiii.sdk.android.oss.network.NetworkProgressHelper.addProgressRequestBody(r5, r10, r4, r8)     // Catch:{ Exception -> 0x027d }
            okhttp3.aa$a r3 = r3.mo37755b(r7, r4)     // Catch:{ Exception -> 0x027d }
            goto L_0x01a5
        L_0x0172:
            if (r7 == 0) goto L_0x0191
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.HttpMethod r5 = r5.getMethod()     // Catch:{ Exception -> 0x027d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x027d }
            okhttp3.v r4 = okhttp3.C9947v.m28445ts(r4)     // Catch:{ Exception -> 0x027d }
            java.lang.String r8 = "UTF-8"
            byte[] r7 = r7.getBytes(r8)     // Catch:{ Exception -> 0x027d }
            okhttp3.ab r4 = okhttp3.C9798ab.create(r4, r7)     // Catch:{ Exception -> 0x027d }
            okhttp3.aa$a r3 = r3.mo37755b(r5, r4)     // Catch:{ Exception -> 0x027d }
            goto L_0x01a5
        L_0x0191:
            com.aiii.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x027d }
            com.aiii.sdk.android.oss.common.HttpMethod r4 = r4.getMethod()     // Catch:{ Exception -> 0x027d }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x027d }
            byte[] r5 = new byte[r6]     // Catch:{ Exception -> 0x027d }
            okhttp3.ab r5 = okhttp3.C9798ab.create(r1, r5)     // Catch:{ Exception -> 0x027d }
            okhttp3.aa$a r3 = r3.mo37755b(r4, r5)     // Catch:{ Exception -> 0x027d }
        L_0x01a5:
            okhttp3.aa r3 = r3.aXf()     // Catch:{ Exception -> 0x027d }
            boolean r2 = r2 instanceof com.aiii.sdk.android.oss.model.GetObjectRequest     // Catch:{ Exception -> 0x0272 }
            if (r2 == 0) goto L_0x01bc
            okhttp3.x r2 = r13.client     // Catch:{ Exception -> 0x0272 }
            com.aiii.sdk.android.oss.network.ExecutionContext r4 = r13.context     // Catch:{ Exception -> 0x0272 }
            okhttp3.x r2 = com.aiii.sdk.android.oss.network.NetworkProgressHelper.addProgressResponseListener(r2, r4)     // Catch:{ Exception -> 0x0272 }
            r13.client = r2     // Catch:{ Exception -> 0x0272 }
            java.lang.String r2 = "getObject"
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r2)     // Catch:{ Exception -> 0x0272 }
        L_0x01bc:
            okhttp3.x r2 = r13.client     // Catch:{ Exception -> 0x0272 }
            okhttp3.e r2 = r2.mo37831b(r3)     // Catch:{ Exception -> 0x0272 }
            com.aiii.sdk.android.oss.network.ExecutionContext r4 = r13.context     // Catch:{ Exception -> 0x026d }
            com.aiii.sdk.android.oss.network.CancellationHandler r4 = r4.getCancellationHandler()     // Catch:{ Exception -> 0x026d }
            r4.setCall(r2)     // Catch:{ Exception -> 0x026d }
            okhttp3.ac r4 = r2.aVP()     // Catch:{ Exception -> 0x026d }
            boolean r5 = com.aiii.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ Exception -> 0x026d }
            if (r5 == 0) goto L_0x0265
            okhttp3.s r5 = r4.aWY()     // Catch:{ Exception -> 0x026d }
            java.util.Map r5 = r5.aWe()     // Catch:{ Exception -> 0x026d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026d }
            r7.<init>()     // Catch:{ Exception -> 0x026d }
            java.lang.String r8 = "response:---------------------\n"
            r7.append(r8)     // Catch:{ Exception -> 0x026d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026d }
            r8.<init>()     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = "response code: "
            r8.append(r9)     // Catch:{ Exception -> 0x026d }
            int r9 = r4.aTm()     // Catch:{ Exception -> 0x026d }
            r8.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = " for url: "
            r8.append(r9)     // Catch:{ Exception -> 0x026d }
            okhttp3.t r9 = r3.aVr()     // Catch:{ Exception -> 0x026d }
            r8.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = "\n"
            r8.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x026d }
            r7.append(r8)     // Catch:{ Exception -> 0x026d }
            java.util.Set r8 = r5.keySet()     // Catch:{ Exception -> 0x026d }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x026d }
        L_0x0218:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x026d }
            if (r9 == 0) goto L_0x025e
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x026d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026d }
            r10.<init>()     // Catch:{ Exception -> 0x026d }
            java.lang.String r11 = "responseHeader ["
            r10.append(r11)     // Catch:{ Exception -> 0x026d }
            r10.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r11 = "]: "
            r10.append(r11)     // Catch:{ Exception -> 0x026d }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x026d }
            r7.append(r10)     // Catch:{ Exception -> 0x026d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026d }
            r10.<init>()     // Catch:{ Exception -> 0x026d }
            java.lang.Object r9 = r5.get(r9)     // Catch:{ Exception -> 0x026d }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x026d }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x026d }
            r10.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = "\n"
            r10.append(r9)     // Catch:{ Exception -> 0x026d }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x026d }
            r7.append(r9)     // Catch:{ Exception -> 0x026d }
            goto L_0x0218
        L_0x025e:
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x026d }
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r5)     // Catch:{ Exception -> 0x026d }
        L_0x0265:
            com.aiii.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x026d }
            com.aiii.sdk.android.oss.internal.ResponseMessage r4 = r13.buildResponseMessage(r5, r4)     // Catch:{ Exception -> 0x026d }
            r5 = r1
            goto L_0x02ac
        L_0x026d:
            r4 = move-exception
            r12 = r4
            r4 = r2
            r2 = r12
            goto L_0x0280
        L_0x0272:
            r2 = move-exception
            r4 = r1
            goto L_0x0280
        L_0x0275:
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch:{ Exception -> 0x027d }
            java.lang.String r3 = "This task is cancelled!"
            r2.<init>(r3)     // Catch:{ Exception -> 0x027d }
            throw r2     // Catch:{ Exception -> 0x027d }
        L_0x027d:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x0280:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Encounter local execpiton: "
            r5.append(r6)
            java.lang.String r6 = r2.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logError(r5)
            boolean r5 = com.aiii.sdk.android.oss.common.OSSLog.isEnableLog()
            if (r5 == 0) goto L_0x02a1
            r2.printStackTrace()
        L_0x02a1:
            com.aiii.sdk.android.oss.ClientException r5 = new com.aiii.sdk.android.oss.ClientException
            java.lang.String r6 = r2.getMessage()
            r5.<init>(r6, r2)
            r2 = r4
            r4 = r1
        L_0x02ac:
            if (r5 != 0) goto L_0x02cd
            int r6 = r4.getStatusCode()
            r7 = 203(0xcb, float:2.84E-43)
            if (r6 == r7) goto L_0x02be
            int r6 = r4.getStatusCode()
            r7 = 300(0x12c, float:4.2E-43)
            if (r6 < r7) goto L_0x02cd
        L_0x02be:
            java.lang.String r3 = r3.aTz()
            java.lang.String r5 = "HEAD"
            boolean r3 = r3.equals(r5)
            com.aiii.sdk.android.oss.ServiceException r5 = com.aiii.sdk.android.oss.internal.ResponseParsers.parseResponseErrorXML(r4, r3)
            goto L_0x02f7
        L_0x02cd:
            if (r5 != 0) goto L_0x02f7
            com.aiii.sdk.android.oss.internal.ResponseParser<T> r3 = r13.responseParser     // Catch:{ IOException -> 0x02ed }
            com.aiii.sdk.android.oss.model.OSSResult r3 = r3.parse(r4)     // Catch:{ IOException -> 0x02ed }
            com.aiii.sdk.android.oss.network.ExecutionContext r5 = r13.context     // Catch:{ IOException -> 0x02ed }
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r5 = r5.getCompletedCallback()     // Catch:{ IOException -> 0x02ed }
            if (r5 == 0) goto L_0x02ec
            com.aiii.sdk.android.oss.network.ExecutionContext r5 = r13.context     // Catch:{ Exception -> 0x02ec }
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r5 = r5.getCompletedCallback()     // Catch:{ Exception -> 0x02ec }
            com.aiii.sdk.android.oss.network.ExecutionContext r6 = r13.context     // Catch:{ Exception -> 0x02ec }
            com.aiii.sdk.android.oss.model.OSSRequest r6 = r6.getRequest()     // Catch:{ Exception -> 0x02ec }
            r5.onSuccess(r6, r3)     // Catch:{ Exception -> 0x02ec }
        L_0x02ec:
            return r3
        L_0x02ed:
            r3 = move-exception
            com.aiii.sdk.android.oss.ClientException r5 = new com.aiii.sdk.android.oss.ClientException
            java.lang.String r6 = r3.getMessage()
            r5.<init>(r6, r3)
        L_0x02f7:
            if (r2 == 0) goto L_0x02ff
            boolean r2 = r2.isCanceled()
            if (r2 != 0) goto L_0x030b
        L_0x02ff:
            com.aiii.sdk.android.oss.network.ExecutionContext r2 = r13.context
            com.aiii.sdk.android.oss.network.CancellationHandler r2 = r2.getCancellationHandler()
            boolean r2 = r2.isCancelled()
            if (r2 == 0) goto L_0x031b
        L_0x030b:
            com.aiii.sdk.android.oss.ClientException r2 = new com.aiii.sdk.android.oss.ClientException
            java.lang.String r3 = "Task is cancelled!"
            java.lang.Throwable r5 = r5.getCause()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r2.<init>(r3, r5, r6)
            goto L_0x031c
        L_0x031b:
            r2 = r5
        L_0x031c:
            com.aiii.sdk.android.oss.internal.OSSRetryHandler r3 = r13.retryHandler
            int r5 = r13.currentRetryCount
            com.aiii.sdk.android.oss.internal.OSSRetryType r3 = r3.shouldRetry(r2, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[run] - retry, retry type: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logError(r5)
            com.aiii.sdk.android.oss.internal.OSSRetryType r5 = com.aiii.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry
            if (r3 != r5) goto L_0x036e
            int r1 = r13.currentRetryCount
            int r1 = r1 + r0
            r13.currentRetryCount = r1
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            if (r0 == 0) goto L_0x0352
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            r0.onRetryCallback()
        L_0x0352:
            com.aiii.sdk.android.oss.internal.OSSRetryHandler r0 = r13.retryHandler     // Catch:{ InterruptedException -> 0x035e }
            int r1 = r13.currentRetryCount     // Catch:{ InterruptedException -> 0x035e }
            long r0 = r0.timeInterval(r1, r3)     // Catch:{ InterruptedException -> 0x035e }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x035e }
            goto L_0x0369
        L_0x035e:
            r0 = move-exception
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            r0.printStackTrace()
        L_0x0369:
            com.aiii.sdk.android.oss.model.OSSResult r0 = r13.call()
            return r0
        L_0x036e:
            com.aiii.sdk.android.oss.internal.OSSRetryType r5 = com.aiii.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry
            if (r3 != r5) goto L_0x03c6
            if (r4 == 0) goto L_0x03ab
            java.util.Map r1 = r4.getHeaders()
            java.lang.String r2 = "Date"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Date r2 = com.aiii.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(r1)     // Catch:{ Exception -> 0x0397 }
            long r2 = r2.getTime()     // Catch:{ Exception -> 0x0397 }
            com.aiii.sdk.android.oss.common.utils.DateUtil.setCurrentServerTime(r2)     // Catch:{ Exception -> 0x0397 }
            com.aiii.sdk.android.oss.internal.RequestMessage r2 = r13.message     // Catch:{ Exception -> 0x0397 }
            java.util.Map r2 = r2.getHeaders()     // Catch:{ Exception -> 0x0397 }
            java.lang.String r3 = "Date"
            r2.put(r3, r1)     // Catch:{ Exception -> 0x0397 }
            goto L_0x03ab
        L_0x0397:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[error] - synchronize time, reponseDate:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logError(r1)
        L_0x03ab:
            int r1 = r13.currentRetryCount
            int r1 = r1 + r0
            r13.currentRetryCount = r1
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            if (r0 == 0) goto L_0x03c1
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            r0.onRetryCallback()
        L_0x03c1:
            com.aiii.sdk.android.oss.model.OSSResult r0 = r13.call()
            return r0
        L_0x03c6:
            boolean r0 = r2 instanceof com.aiii.sdk.android.oss.ClientException
            if (r0 == 0) goto L_0x03e5
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x03ff
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.aiii.sdk.android.oss.network.ExecutionContext r3 = r13.context
            com.aiii.sdk.android.oss.model.OSSRequest r3 = r3.getRequest()
            r4 = r2
            com.aiii.sdk.android.oss.ClientException r4 = (com.aiii.sdk.android.oss.ClientException) r4
            r0.onFailure(r3, r4, r1)
            goto L_0x03ff
        L_0x03e5:
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x03ff
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.aiii.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.aiii.sdk.android.oss.network.ExecutionContext r3 = r13.context
            com.aiii.sdk.android.oss.model.OSSRequest r3 = r3.getRequest()
            r4 = r2
            com.aiii.sdk.android.oss.ServiceException r4 = (com.aiii.sdk.android.oss.ServiceException) r4
            r0.onFailure(r3, r1, r4)
        L_0x03ff:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.network.OSSRequestTask.call():com.aiii.sdk.android.oss.model.OSSResult");
    }
}
