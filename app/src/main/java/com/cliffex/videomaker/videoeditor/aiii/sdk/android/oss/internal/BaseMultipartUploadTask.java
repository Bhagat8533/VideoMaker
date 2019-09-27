package com.aiii.sdk.android.oss.internal;

import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.TaskCancelException;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.callback.OSSProgressCallback;
import com.aiii.sdk.android.oss.common.OSSConstants;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.aiii.sdk.android.oss.model.MultipartUploadRequest;
import com.aiii.sdk.android.oss.model.OSSRequest.CRC64Config;
import com.aiii.sdk.android.oss.model.PartETag;
import com.aiii.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE = (Runtime.getRuntime().availableProcessors() * 2);
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int i = 5;
        if (this.CPU_SIZE < 5) {
            i = this.CPU_SIZE;
        }
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPoolExecutor = threadPoolExecutor;
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        boolean z = false;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        if (request.getCRC64() == CRC64Config.YES) {
            z = true;
        }
        this.mCheckCRC64 = z;
    }

    /* access modifiers changed from: protected */
    public abstract void abortThisUpload();

    public Result call() throws Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (Exception e2) {
            ClientException clientException = e2 instanceof ClientException ? (ClientException) e2 : new ClientException(e2.toString(), e2);
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    /* access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.valueOf(true));
        }
    }

    /* access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            if (this.mUploadException instanceof IOException) {
                throw ((IOException) this.mUploadException);
            } else if (this.mUploadException instanceof ServiceException) {
                throw ((ServiceException) this.mUploadException);
            } else if (this.mUploadException instanceof ClientException) {
                throw ((ClientException) this.mUploadException);
            } else {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkInitData() throws ClientException {
        this.mUploadFilePath = this.mRequest.getUploadFilePath();
        this.mUploadedLength = 0;
        this.mUploadFile = new File(this.mUploadFilePath);
        this.mFileLength = this.mUploadFile.length();
        if (this.mFileLength != 0) {
            checkPartSize(this.mPartAttr);
            long partSize = this.mRequest.getPartSize();
            int i = this.mPartAttr[1];
            StringBuilder sb = new StringBuilder();
            sb.append("[checkInitData] - partNumber : ");
            sb.append(i);
            OSSLog.logDebug(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[checkInitData] - partSize : ");
            sb2.append(partSize);
            OSSLog.logDebug(sb2.toString());
            if (i > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    /* access modifiers changed from: protected */
    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        StringBuilder sb = new StringBuilder();
        sb.append("[checkPartSize] - mFileLength : ");
        sb.append(this.mFileLength);
        OSSLog.logDebug(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[checkPartSize] - partSize : ");
        sb2.append(partSize);
        OSSLog.logDebug(sb2.toString());
        int i = (int) (this.mFileLength / partSize);
        if (this.mFileLength % partSize != 0) {
            i++;
        }
        if (i == 1) {
            partSize = this.mFileLength;
        } else if (i > 5000) {
            partSize = this.mFileLength / ((long) 5000);
            i = 5000;
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = i;
        this.mRequest.setPartSize((long) i2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[checkPartSize] - partNumber : ");
        sb3.append(i);
        OSSLog.logDebug(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("[checkPartSize] - partSize : ");
        sb4.append(i2);
        OSSLog.logDebug(sb4.toString());
    }

    /* access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    /* access modifiers changed from: protected */
    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: protected */
    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    /* access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    /* access modifiers changed from: protected */
    public void onProgressCallback(Request request, long j, long j2) {
        if (this.mProgressCallback != null) {
            this.mProgressCallback.onProgress(request, j, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    /* access modifiers changed from: protected */
    public abstract void processException(Exception exc);

    /* access modifiers changed from: protected */
    public void releasePool() {
        if (this.mPoolExecutor != null) {
            this.mPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0109 A[SYNTHETIC, Splitter:B:59:0x0109] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            com.aiii.sdk.android.oss.network.ExecutionContext r1 = r9.mContext     // Catch:{ Exception -> 0x00f8 }
            com.aiii.sdk.android.oss.network.CancellationHandler r1 = r1.getCancellationHandler()     // Catch:{ Exception -> 0x00f8 }
            boolean r1 = r1.isCancelled()     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x0017
            java.util.concurrent.ThreadPoolExecutor r10 = r9.mPoolExecutor     // Catch:{ Exception -> 0x00f8 }
            java.util.concurrent.BlockingQueue r10 = r10.getQueue()     // Catch:{ Exception -> 0x00f8 }
            r10.clear()     // Catch:{ Exception -> 0x00f8 }
            return
        L_0x0017:
            java.lang.Object r1 = r9.mLock     // Catch:{ Exception -> 0x00f8 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x00f8 }
            int r2 = r9.mRunPartTaskCount     // Catch:{ all -> 0x00f2 }
            r3 = 1
            int r2 = r2 + r3
            r9.mRunPartTaskCount = r2     // Catch:{ all -> 0x00f2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f2 }
            r9.preUploadPart(r10, r11, r12)     // Catch:{ Exception -> 0x00f8 }
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00f8 }
            java.io.File r2 = r9.mUploadFile     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r4 = "r"
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x00f8 }
            com.aiii.sdk.android.oss.model.UploadPartRequest r0 = new com.aiii.sdk.android.oss.model.UploadPartRequest     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            Request r2 = r9.mRequest     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.String r2 = r2.getBucketName()     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            Request r4 = r9.mRequest     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.String r4 = r4.getObjectKey()     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.String r5 = r9.mUploadId     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            int r6 = r10 + 1
            r0.<init>(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            long r4 = (long) r10     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            Request r10 = r9.mRequest     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            long r6 = r10.getPartSize()     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            long r4 = r4 * r6
            byte[] r10 = new byte[r11]     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            r1.seek(r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            r2 = 0
            r1.readFully(r10, r2, r11)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            r0.setPartContent(r10)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.String r10 = com.aiii.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(r10)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            r0.setMd5Digest(r10)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            Request r10 = r9.mRequest     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.Enum r10 = r10.getCRC64()     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            r0.setCRC64(r10)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r10 = r9.mApiOperation     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            com.aiii.sdk.android.oss.model.UploadPartResult r10 = r10.syncUploadPart(r0)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            java.lang.Object r2 = r9.mLock     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
            com.aiii.sdk.android.oss.model.PartETag r4 = new com.aiii.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x00ea }
            int r0 = r0.getPartNumber()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r10.getETag()     // Catch:{ all -> 0x00ea }
            r4.<init>(r0, r5)     // Catch:{ all -> 0x00ea }
            long r5 = (long) r11     // Catch:{ all -> 0x00ea }
            r4.setPartSize(r5)     // Catch:{ all -> 0x00ea }
            boolean r11 = r9.mCheckCRC64     // Catch:{ all -> 0x00ea }
            if (r11 == 0) goto L_0x0090
            java.lang.Long r10 = r10.getClientCRC()     // Catch:{ all -> 0x00ea }
            long r10 = r10.longValue()     // Catch:{ all -> 0x00ea }
            r4.setCRC64(r10)     // Catch:{ all -> 0x00ea }
        L_0x0090:
            java.util.List<com.aiii.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00ea }
            r10.add(r4)     // Catch:{ all -> 0x00ea }
            long r10 = r9.mUploadedLength     // Catch:{ all -> 0x00ea }
            r0 = 0
            long r10 = r10 + r5
            r9.mUploadedLength = r10     // Catch:{ all -> 0x00ea }
            r9.uploadPartFinish(r4)     // Catch:{ all -> 0x00ea }
            com.aiii.sdk.android.oss.network.ExecutionContext r10 = r9.mContext     // Catch:{ all -> 0x00ea }
            com.aiii.sdk.android.oss.network.CancellationHandler r10 = r10.getCancellationHandler()     // Catch:{ all -> 0x00ea }
            boolean r10 = r10.isCancelled()     // Catch:{ all -> 0x00ea }
            if (r10 == 0) goto L_0x00cd
            java.util.List<com.aiii.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00ea }
            int r10 = r10.size()     // Catch:{ all -> 0x00ea }
            int r11 = r9.mRunPartTaskCount     // Catch:{ all -> 0x00ea }
            int r12 = r9.mPartExceptionCount     // Catch:{ all -> 0x00ea }
            int r11 = r11 - r12
            if (r10 == r11) goto L_0x00b8
            goto L_0x00e5
        L_0x00b8:
            com.aiii.sdk.android.oss.TaskCancelException r10 = new com.aiii.sdk.android.oss.TaskCancelException     // Catch:{ all -> 0x00ea }
            java.lang.String r11 = "multipart cancel"
            r10.<init>(r11)     // Catch:{ all -> 0x00ea }
            com.aiii.sdk.android.oss.ClientException r11 = new com.aiii.sdk.android.oss.ClientException     // Catch:{ all -> 0x00ea }
            java.lang.String r12 = r10.getMessage()     // Catch:{ all -> 0x00ea }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00ea }
            r11.<init>(r12, r10, r0)     // Catch:{ all -> 0x00ea }
            throw r11     // Catch:{ all -> 0x00ea }
        L_0x00cd:
            java.util.List<com.aiii.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00ea }
            int r10 = r10.size()     // Catch:{ all -> 0x00ea }
            int r11 = r9.mPartExceptionCount     // Catch:{ all -> 0x00ea }
            int r12 = r12 - r11
            if (r10 != r12) goto L_0x00db
            r9.notifyMultipartThread()     // Catch:{ all -> 0x00ea }
        L_0x00db:
            Request r4 = r9.mRequest     // Catch:{ all -> 0x00ea }
            long r5 = r9.mUploadedLength     // Catch:{ all -> 0x00ea }
            long r7 = r9.mFileLength     // Catch:{ all -> 0x00ea }
            r3 = r9
            r3.onProgressCallback(r4, r5, r7)     // Catch:{ all -> 0x00ea }
        L_0x00e5:
            monitor-exit(r2)     // Catch:{ all -> 0x00ea }
            r1.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0106
        L_0x00ea:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ea }
            throw r10     // Catch:{ Exception -> 0x00ef, all -> 0x00ed }
        L_0x00ed:
            r10 = move-exception
            goto L_0x0107
        L_0x00ef:
            r10 = move-exception
            r0 = r1
            goto L_0x00f9
        L_0x00f2:
            r10 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f2 }
            throw r10     // Catch:{ Exception -> 0x00f8 }
        L_0x00f5:
            r10 = move-exception
            r1 = r0
            goto L_0x0107
        L_0x00f8:
            r10 = move-exception
        L_0x00f9:
            r9.processException(r10)     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0106
        L_0x0102:
            r10 = move-exception
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r10)
        L_0x0106:
            return
        L_0x0107:
            if (r1 == 0) goto L_0x0111
            r1.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x0111
        L_0x010d:
            r11 = move-exception
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r11)
        L_0x0111:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
    }
}
