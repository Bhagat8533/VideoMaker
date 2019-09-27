package com.aiii.sdk.android.oss.internal;

import android.text.TextUtils;
import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.aiii.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.aiii.sdk.android.oss.model.PartETag;
import com.aiii.sdk.android.oss.model.ResumableUploadRequest;
import com.aiii.sdk.android.oss.model.ResumableUploadResult;
import com.aiii.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* access modifiers changed from: protected */
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkException() throws java.io.IOException, com.aiii.sdk.android.oss.ServiceException, com.aiii.sdk.android.oss.ClientException {
        /*
            r6 = this;
            com.aiii.sdk.android.oss.network.ExecutionContext r0 = r6.mContext
            com.aiii.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()
            boolean r0 = r0.isCancelled()
            if (r0 == 0) goto L_0x00cb
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.Boolean r0 = r0.deleteUploadOnCancelling()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0028
            r6.abortThisUpload()
            java.io.File r0 = r6.mRecordFile
            if (r0 == 0) goto L_0x00cb
            java.io.File r0 = r6.mRecordFile
            r0.delete()
            goto L_0x00cb
        L_0x0028:
            java.util.List r0 = r6.mPartETags
            if (r0 == 0) goto L_0x00cb
            java.util.List r0 = r6.mPartETags
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00cb
            boolean r0 = r6.mCheckCRC64
            if (r0 == 0) goto L_0x00cb
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            if (r0 == 0) goto L_0x00cb
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.List r1 = r6.mPartETags
            java.util.Iterator r1 = r1.iterator()
        L_0x004d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x006d
            java.lang.Object r2 = r1.next()
            com.aiii.sdk.android.oss.model.PartETag r2 = (com.aiii.sdk.android.oss.model.PartETag) r2
            int r3 = r2.getPartNumber()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            long r4 = r2.getCRC64()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.put(r3, r2)
            goto L_0x004d
        L_0x006d:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb }
            r2.<init>()     // Catch:{ IOException -> 0x00bb }
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r3 = r6.mRequest     // Catch:{ IOException -> 0x00bb }
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r3 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r3     // Catch:{ IOException -> 0x00bb }
            java.lang.String r3 = r3.getRecordDirectory()     // Catch:{ IOException -> 0x00bb }
            r2.append(r3)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r3 = java.io.File.separator     // Catch:{ IOException -> 0x00bb }
            r2.append(r3)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r3 = r6.mUploadId     // Catch:{ IOException -> 0x00bb }
            r2.append(r3)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00bb }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00bb }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00bb }
            r6.mCRC64RecordFile = r3     // Catch:{ IOException -> 0x00bb }
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00bb }
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x00bb }
            if (r2 != 0) goto L_0x00a0
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00bb }
            r2.createNewFile()     // Catch:{ IOException -> 0x00bb }
        L_0x00a0:
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x00bb }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00bb }
            java.io.File r4 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00bb }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00bb }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00bb }
            r2.writeObject(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
            r2.close()
            goto L_0x00cb
        L_0x00b3:
            r0 = move-exception
            r1 = r2
            goto L_0x00c5
        L_0x00b6:
            r0 = move-exception
            r1 = r2
            goto L_0x00bc
        L_0x00b9:
            r0 = move-exception
            goto L_0x00c5
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x00cb
            r1.close()
            goto L_0x00cb
        L_0x00c5:
            if (r1 == 0) goto L_0x00ca
            r1.close()
        L_0x00ca:
            throw r0
        L_0x00cb:
            super.checkException()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.ResumableUploadTask.checkException():void");
    }

    /* access modifiers changed from: protected */
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        final int i = this.mPartAttr[0];
        final int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength <= this.mFileLength) {
                long partSize = ((PartETag) this.mPartETags.get(0)).getPartSize();
                StringBuilder sb = new StringBuilder();
                sb.append("[initUploadId] - firstPartSize : ");
                sb.append(partSize);
                OSSLog.logDebug(sb.toString());
                if (partSize <= 0 || partSize == ((long) i) || partSize >= this.mFileLength) {
                    long j2 = this.mUploadedLength;
                    if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                        j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                    }
                    long j3 = j2;
                    if (this.mProgressCallback != null) {
                        this.mProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
                    }
                    this.mSp.removeKey(this.mUploadId);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("current part size ");
                    sb2.append(i);
                    sb2.append(" setting is inconsistent with before ");
                    sb2.append(partSize);
                    throw new ClientException(sb2.toString());
                }
            } else {
                throw new ClientException("The uploading file is inconsistent with before");
            }
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (final int i3 = 0; i3 < i2; i3++) {
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) && this.mPoolExecutor != null) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                j += (long) i;
                this.mPoolExecutor.execute(new Runnable() {
                    public void run() {
                        ResumableUploadTask.this.uploadPart(i3, i, i2);
                    }
                });
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = null;
        if (completeMultipartUploadResult != null) {
            resumableUploadResult = new ResumableUploadResult(completeMultipartUploadResult);
        }
        if (this.mRecordFile != null) {
            this.mRecordFile.delete();
        }
        if (this.mCRC64RecordFile != null) {
            this.mCRC64RecordFile.delete();
        }
        releasePool();
        return resumableUploadResult;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x022d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x022e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x022f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0230, code lost:
        r7 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x023a, code lost:
        r14.mUploadId = null;
        r3 = r7;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0244, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0184 A[Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x022d A[ExcHandler: ClientException (r0v47 'e' com.aiii.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:35:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0244 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initMultipartUploadId() throws java.io.IOException, com.aiii.sdk.android.oss.ClientException, com.aiii.sdk.android.oss.ServiceException {
        /*
            r14 = this;
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0278
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[initUploadId] - mUploadFilePath : "
            r0.append(r2)
            java.lang.String r2 = r14.mUploadFilePath
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r14.mUploadFilePath
            java.lang.String r0 = com.aiii.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[initUploadId] - mRequest.getPartSize() : "
            r2.append(r3)
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r3 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r3 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r3
            long r3 = r3.getPartSize()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getBucketName()
            r2.append(r0)
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getObjectKey()
            r2.append(r0)
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            long r3 = r0.getPartSize()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r2.append(r0)
            boolean r0 = r14.mCheckCRC64
            if (r0 == 0) goto L_0x007b
            java.lang.String r0 = "-crc64"
            goto L_0x007d
        L_0x007b:
            java.lang.String r0 = ""
        L_0x007d:
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            byte[] r0 = r0.getBytes()
            java.lang.String r0 = com.aiii.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r3 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r3 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getRecordDirectory()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            r14.mRecordFile = r2
            java.io.File r0 = r14.mRecordFile
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x00cc
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.FileReader r2 = new java.io.FileReader
            java.io.File r3 = r14.mRecordFile
            r2.<init>(r3)
            r0.<init>(r2)
            java.lang.String r2 = r0.readLine()
            r14.mUploadId = r2
            r0.close()
        L_0x00cc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[initUploadId] - mUploadId : "
            r0.append(r2)
            java.lang.String r2 = r14.mUploadId
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r14.mUploadId
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 != 0) goto L_0x0245
            boolean r0 = r14.mCheckCRC64
            if (r0 == 0) goto L_0x0142
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r2 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r2 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getRecordDirectory()
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r2 = r14.mUploadId
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x0142
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r2)
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream
            r3.<init>(r0)
            java.lang.Object r0 = r3.readObject()     // Catch:{ ClassNotFoundException -> 0x012f }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ ClassNotFoundException -> 0x012f }
            r2.delete()     // Catch:{ ClassNotFoundException -> 0x012b }
            goto L_0x0134
        L_0x012b:
            r4 = move-exception
            goto L_0x0131
        L_0x012d:
            r0 = move-exception
            goto L_0x013b
        L_0x012f:
            r4 = move-exception
            r0 = r1
        L_0x0131:
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r4)     // Catch:{ all -> 0x012d }
        L_0x0134:
            r3.close()
            r2.delete()
            goto L_0x0143
        L_0x013b:
            r3.close()
            r2.delete()
            throw r0
        L_0x0142:
            r0 = r1
        L_0x0143:
            r2 = 0
            r3 = 0
        L_0x0145:
            com.aiii.sdk.android.oss.model.ListPartsRequest r4 = new com.aiii.sdk.android.oss.model.ListPartsRequest
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r5 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r5 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r5
            java.lang.String r5 = r5.getBucketName()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r6 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r6 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r6
            java.lang.String r6 = r6.getObjectKey()
            java.lang.String r7 = r14.mUploadId
            r4.<init>(r5, r6, r7)
            if (r3 <= 0) goto L_0x0165
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r4.setPartNumberMarker(r5)
        L_0x0165:
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r5 = r14.mApiOperation
            com.aiii.sdk.android.oss.internal.OSSAsyncTask r4 = r5.listParts(r4, r1)
            com.aiii.sdk.android.oss.model.OSSResult r5 = r4.getResult()     // Catch:{ ServiceException -> 0x022f, ClientException -> 0x022d }
            com.aiii.sdk.android.oss.model.ListPartsResult r5 = (com.aiii.sdk.android.oss.model.ListPartsResult) r5     // Catch:{ ServiceException -> 0x022f, ClientException -> 0x022d }
            boolean r6 = r5.isTruncated()     // Catch:{ ServiceException -> 0x022f, ClientException -> 0x022d }
            int r7 = r5.getNextPartNumberMarker()     // Catch:{ ServiceException -> 0x022f, ClientException -> 0x022d }
            java.util.List r3 = r5.getParts()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r5 = 0
        L_0x017e:
            int r8 = r3.size()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            if (r5 >= r8) goto L_0x0229
            java.lang.Object r8 = r3.get(r5)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            com.aiii.sdk.android.oss.model.PartSummary r8 = (com.aiii.sdk.android.oss.model.PartSummary) r8     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            com.aiii.sdk.android.oss.model.PartETag r9 = new com.aiii.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            int r10 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r11 = r8.getETag()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r9.<init>(r10, r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            long r10 = r8.getSize()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r9.setPartSize(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            if (r0 == 0) goto L_0x01c9
            int r10 = r0.size()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            if (r10 <= 0) goto L_0x01c9
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            boolean r10 = r0.containsKey(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            if (r10 == 0) goto L_0x01c9
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            long r10 = r10.longValue()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r9.setCRC64(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
        L_0x01c9:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.<init>()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r11 = "[initUploadId] -  "
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.append(r5)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r11 = " part.getPartNumber() : "
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            int r11 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r10 = r10.toString()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.<init>()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r11 = "[initUploadId] -  "
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.append(r5)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r11 = " part.getSize() : "
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            long r11 = r8.getSize()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.append(r11)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.String r10 = r10.toString()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r10)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.util.List r10 = r14.mPartETags     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r10.add(r9)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            long r9 = r14.mUploadedLength     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            long r11 = r8.getSize()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r13 = 0
            long r9 = r9 + r11
            r14.mUploadedLength = r9     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.util.List<java.lang.Integer> r9 = r14.mAlreadyUploadIndex     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            int r8 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            r9.add(r8)     // Catch:{ ServiceException -> 0x022b, ClientException -> 0x022d }
            int r5 = r5 + 1
            goto L_0x017e
        L_0x0229:
            r3 = r7
            goto L_0x023e
        L_0x022b:
            r3 = move-exception
            goto L_0x0232
        L_0x022d:
            r0 = move-exception
            throw r0
        L_0x022f:
            r5 = move-exception
            r7 = r3
            r3 = r5
        L_0x0232:
            int r5 = r3.getStatusCode()
            r6 = 404(0x194, float:5.66E-43)
            if (r5 != r6) goto L_0x0244
            r14.mUploadId = r1
            r3 = r7
            r6 = 0
        L_0x023e:
            r4.waitUntilFinished()
            if (r6 != 0) goto L_0x0145
            goto L_0x0245
        L_0x0244:
            throw r3
        L_0x0245:
            java.io.File r0 = r14.mRecordFile
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0278
            java.io.File r0 = r14.mRecordFile
            boolean r0 = r0.createNewFile()
            if (r0 == 0) goto L_0x0256
            goto L_0x0278
        L_0x0256:
            com.aiii.sdk.android.oss.ClientException r0 = new com.aiii.sdk.android.oss.ClientException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can't create file at path: "
            r1.append(r2)
            java.io.File r2 = r14.mRecordFile
            java.lang.String r2 = r2.getAbsolutePath()
            r1.append(r2)
            java.lang.String r2 = "\nPlease make sure the directory exist!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0278:
            java.lang.String r0 = r14.mUploadId
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 == 0) goto L_0x02c7
            com.aiii.sdk.android.oss.model.InitiateMultipartUploadRequest r0 = new com.aiii.sdk.android.oss.model.InitiateMultipartUploadRequest
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r2 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r2 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getBucketName()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r3 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r3 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getObjectKey()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r4 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r4 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r4
            com.aiii.sdk.android.oss.model.ObjectMetadata r4 = r4.getMetadata()
            r0.<init>(r2, r3, r4)
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r2 = r14.mApiOperation
            com.aiii.sdk.android.oss.internal.OSSAsyncTask r0 = r2.initMultipartUpload(r0, r1)
            com.aiii.sdk.android.oss.model.OSSResult r0 = r0.getResult()
            com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult r0 = (com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult) r0
            java.lang.String r0 = r0.getUploadId()
            r14.mUploadId = r0
            java.io.File r0 = r14.mRecordFile
            if (r0 == 0) goto L_0x02c7
            java.io.BufferedWriter r0 = new java.io.BufferedWriter
            java.io.FileWriter r1 = new java.io.FileWriter
            java.io.File r2 = r14.mRecordFile
            r1.<init>(r2)
            r0.<init>(r1)
            java.lang.String r1 = r14.mUploadId
            r0.write(r1)
            r0.close()
        L_0x02c7:
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r1 = r14.mUploadId
            r0.setUploadId(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.ResumableUploadTask.initMultipartUploadId():void");
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            this.mUploadException = exc;
            OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
            if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                notifyMultipartThread();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }
}
