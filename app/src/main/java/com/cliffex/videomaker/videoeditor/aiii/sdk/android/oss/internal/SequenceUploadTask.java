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

public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.SequenceUploadTask.checkException():void");
    }

    /* access modifiers changed from: protected */
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        int i = this.mPartAttr[0];
        int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            } else if (this.mFirstPartSize == ((long) i)) {
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
                throw new ClientException("The part size setting is inconsistent with before");
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("upload part readByte : ");
                sb.append(i);
                OSSLog.logDebug(sb.toString());
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
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
        return resumableUploadResult;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01c8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c9, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ca, code lost:
        r7 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d4, code lost:
        r14.mUploadId = null;
        r3 = r7;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01de, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0157 A[Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c7 A[ExcHandler: ClientException (r0v44 'e' com.aiii.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:35:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01de A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initMultipartUploadId() throws java.io.IOException, com.aiii.sdk.android.oss.ClientException, com.aiii.sdk.android.oss.ServiceException {
        /*
            r14 = this;
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0212
            java.lang.String r0 = r14.mUploadFilePath
            java.lang.String r0 = com.aiii.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(r0)
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
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "-crc64"
            goto L_0x004b
        L_0x0049:
            java.lang.String r0 = ""
        L_0x004b:
            r2.append(r0)
            java.lang.String r0 = "-sequence"
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
            if (r0 == 0) goto L_0x00b5
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.FileReader r2 = new java.io.FileReader
            java.io.File r3 = r14.mRecordFile
            r2.<init>(r3)
            r0.<init>(r2)
            java.lang.String r2 = r0.readLine()
            r14.mUploadId = r2
            r0.close()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "sequence [initUploadId] - Found record file, uploadid: "
            r0.append(r2)
            java.lang.String r2 = r14.mUploadId
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.aiii.sdk.android.oss.common.OSSLog.logDebug(r0)
        L_0x00b5:
            java.lang.String r0 = r14.mUploadId
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 != 0) goto L_0x01df
            boolean r0 = r14.mCheckCRC64
            if (r0 == 0) goto L_0x0115
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
            if (r0 == 0) goto L_0x0115
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r2)
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream
            r3.<init>(r0)
            java.lang.Object r0 = r3.readObject()     // Catch:{ ClassNotFoundException -> 0x0102 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ ClassNotFoundException -> 0x0102 }
            r2.delete()     // Catch:{ ClassNotFoundException -> 0x00fe }
            goto L_0x0107
        L_0x00fe:
            r4 = move-exception
            goto L_0x0104
        L_0x0100:
            r0 = move-exception
            goto L_0x010e
        L_0x0102:
            r4 = move-exception
            r0 = r1
        L_0x0104:
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r4)     // Catch:{ all -> 0x0100 }
        L_0x0107:
            r3.close()
            r2.delete()
            goto L_0x0116
        L_0x010e:
            r3.close()
            r2.delete()
            throw r0
        L_0x0115:
            r0 = r1
        L_0x0116:
            r2 = 0
            r3 = 0
        L_0x0118:
            com.aiii.sdk.android.oss.model.ListPartsRequest r4 = new com.aiii.sdk.android.oss.model.ListPartsRequest
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r5 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r5 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r5
            java.lang.String r5 = r5.getBucketName()
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r6 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r6 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r6
            java.lang.String r6 = r6.getObjectKey()
            java.lang.String r7 = r14.mUploadId
            r4.<init>(r5, r6, r7)
            if (r3 <= 0) goto L_0x0138
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r4.setPartNumberMarker(r5)
        L_0x0138:
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r5 = r14.mApiOperation
            com.aiii.sdk.android.oss.internal.OSSAsyncTask r4 = r5.listParts(r4, r1)
            com.aiii.sdk.android.oss.model.OSSResult r5 = r4.getResult()     // Catch:{ ServiceException -> 0x01c9, ClientException -> 0x01c7 }
            com.aiii.sdk.android.oss.model.ListPartsResult r5 = (com.aiii.sdk.android.oss.model.ListPartsResult) r5     // Catch:{ ServiceException -> 0x01c9, ClientException -> 0x01c7 }
            boolean r6 = r5.isTruncated()     // Catch:{ ServiceException -> 0x01c9, ClientException -> 0x01c7 }
            int r7 = r5.getNextPartNumberMarker()     // Catch:{ ServiceException -> 0x01c9, ClientException -> 0x01c7 }
            java.util.List r3 = r5.getParts()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r5 = 0
        L_0x0151:
            int r8 = r3.size()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            if (r5 >= r8) goto L_0x01c3
            java.lang.Object r8 = r3.get(r5)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            com.aiii.sdk.android.oss.model.PartSummary r8 = (com.aiii.sdk.android.oss.model.PartSummary) r8     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            com.aiii.sdk.android.oss.model.PartETag r9 = new com.aiii.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            int r10 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.String r11 = r8.getETag()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r9.<init>(r10, r11)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            long r10 = r8.getSize()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r9.setPartSize(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            if (r0 == 0) goto L_0x019c
            int r10 = r0.size()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            if (r10 <= 0) goto L_0x019c
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            boolean r10 = r0.containsKey(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            if (r10 == 0) goto L_0x019c
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            long r10 = r10.longValue()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r9.setCRC64(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
        L_0x019c:
            java.util.List r10 = r14.mPartETags     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r10.add(r9)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            long r9 = r14.mUploadedLength     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            long r11 = r8.getSize()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r13 = 0
            long r9 = r9 + r11
            r14.mUploadedLength = r9     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.util.List<java.lang.Integer> r9 = r14.mAlreadyUploadIndex     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            int r10 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r9.add(r10)     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            if (r5 != 0) goto L_0x01c0
            long r8 = r8.getSize()     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
            r14.mFirstPartSize = r8     // Catch:{ ServiceException -> 0x01c5, ClientException -> 0x01c7 }
        L_0x01c0:
            int r5 = r5 + 1
            goto L_0x0151
        L_0x01c3:
            r3 = r7
            goto L_0x01d8
        L_0x01c5:
            r3 = move-exception
            goto L_0x01cc
        L_0x01c7:
            r0 = move-exception
            throw r0
        L_0x01c9:
            r5 = move-exception
            r7 = r3
            r3 = r5
        L_0x01cc:
            int r5 = r3.getStatusCode()
            r6 = 404(0x194, float:5.66E-43)
            if (r5 != r6) goto L_0x01de
            r14.mUploadId = r1
            r3 = r7
            r6 = 0
        L_0x01d8:
            r4.waitUntilFinished()
            if (r6 != 0) goto L_0x0118
            goto L_0x01df
        L_0x01de:
            throw r3
        L_0x01df:
            java.io.File r0 = r14.mRecordFile
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0212
            java.io.File r0 = r14.mRecordFile
            boolean r0 = r0.createNewFile()
            if (r0 == 0) goto L_0x01f0
            goto L_0x0212
        L_0x01f0:
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
        L_0x0212:
            java.lang.String r0 = r14.mUploadId
            boolean r0 = com.aiii.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 == 0) goto L_0x0264
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
            r2 = 1
            r0.isSequential = r2
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r2 = r14.mApiOperation
            com.aiii.sdk.android.oss.internal.OSSAsyncTask r0 = r2.initMultipartUpload(r0, r1)
            com.aiii.sdk.android.oss.model.OSSResult r0 = r0.getResult()
            com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult r0 = (com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult) r0
            java.lang.String r0 = r0.getUploadId()
            r14.mUploadId = r0
            java.io.File r0 = r14.mRecordFile
            if (r0 == 0) goto L_0x0264
            java.io.BufferedWriter r0 = new java.io.BufferedWriter
            java.io.FileWriter r1 = new java.io.FileWriter
            java.io.File r2 = r14.mRecordFile
            r1.<init>(r2)
            r0.<init>(r1)
            java.lang.String r1 = r14.mUploadId
            r0.write(r1)
            r0.close()
        L_0x0264:
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r0 = r14.mRequest
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r0 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r1 = r14.mUploadId
            r0.setUploadId(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
            this.mIsCancel = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c6, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c8, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cb, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cc, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ee, code lost:
        processException(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f2, code lost:
        r12 = new com.aiii.sdk.android.oss.model.PartETag(r1.getPartNumber(), r10.getPartEtag());
        r12.setPartSize((long) r1.getPartContent().length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        if (r9.mCheckCRC64 != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010c, code lost:
        r12.setCRC64(new java.util.zip.CheckedInputStream(new java.io.ByteArrayInputStream(r1.getPartContent()), new com.aiii.sdk.android.oss.common.utils.CRC64()).getChecksum().getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012a, code lost:
        r9.mPartETags.add(r12);
        r9.mUploadedLength += (long) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cb A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:6:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A[SYNTHETIC, Splitter:B:34:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ee A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0137 A[SYNTHETIC, Splitter:B:49:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013d A[SYNTHETIC, Splitter:B:53:0x013d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x00d6=Splitter:B:31:0x00d6, B:40:0x00e6=Splitter:B:40:0x00e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            com.aiii.sdk.android.oss.network.ExecutionContext r1 = r9.mContext     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            com.aiii.sdk.android.oss.network.CancellationHandler r1 = r1.getCancellationHandler()     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            boolean r1 = r1.isCancelled()     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            if (r1 == 0) goto L_0x000e
            return
        L_0x000e:
            int r1 = r9.mRunPartTaskCount     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            r2 = 1
            int r1 = r1 + r2
            r9.mRunPartTaskCount = r1     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            r9.preUploadPart(r10, r11, r12)     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            java.io.File r1 = r9.mUploadFile     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            java.lang.String r3 = "r"
            r12.<init>(r1, r3)     // Catch:{ ServiceException -> 0x00e4, Exception -> 0x00d5 }
            com.aiii.sdk.android.oss.model.UploadPartRequest r1 = new com.aiii.sdk.android.oss.model.UploadPartRequest     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r3 = r9.mRequest     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r3 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r3     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r3 = r3.getBucketName()     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r4 = r9.mRequest     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r4 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r4     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r4 = r4.getObjectKey()     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r5 = r9.mUploadId     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            int r6 = r10 + 1
            r1.<init>(r3, r4, r5, r6)     // Catch:{ ServiceException -> 0x00ce, Exception -> 0x00cb, all -> 0x00c8 }
            long r3 = (long) r10
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r10 = r9.mRequest     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r10 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r10     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r5 = r10.getPartSize()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r3 = r3 * r5
            byte[] r10 = new byte[r11]     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r12.seek(r3)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r0 = 0
            r12.readFully(r10, r0, r11)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r1.setPartContent(r10)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r10 = com.aiii.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(r10)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r1.setMd5Digest(r10)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r10 = r9.mRequest     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.ResumableUploadRequest r10 = (com.aiii.sdk.android.oss.model.ResumableUploadRequest) r10     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.Enum r10 = r10.getCRC64()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r1.setCRC64(r10)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.internal.InternalRequestOperation r10 = r9.mApiOperation     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.UploadPartResult r10 = r10.syncUploadPart(r1)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.model.PartETag r0 = new com.aiii.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            int r3 = r1.getPartNumber()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r4 = r10.getETag()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r0.<init>(r3, r4)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r3 = (long) r11     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r0.setPartSize(r3)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            boolean r5 = r9.mCheckCRC64     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            if (r5 == 0) goto L_0x0088
            java.lang.Long r10 = r10.getClientCRC()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r5 = r10.longValue()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r0.setCRC64(r5)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
        L_0x0088:
            java.util.List r10 = r9.mPartETags     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r10.add(r0)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r5 = r9.mUploadedLength     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r10 = 0
            long r5 = r5 + r3
            r9.mUploadedLength = r5     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r9.uploadPartFinish(r0)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.network.ExecutionContext r10 = r9.mContext     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.network.CancellationHandler r10 = r10.getCancellationHandler()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            boolean r10 = r10.isCancelled()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            if (r10 != 0) goto L_0x00b1
            com.aiii.sdk.android.oss.model.MultipartUploadRequest r4 = r9.mRequest     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r5 = r9.mUploadedLength     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            long r7 = r9.mFileLength     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r3 = r9
            r3.onProgressCallback(r4, r5, r7)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r12.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x013a
        L_0x00b1:
            com.aiii.sdk.android.oss.TaskCancelException r10 = new com.aiii.sdk.android.oss.TaskCancelException     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r0 = "sequence upload task cancel"
            r10.<init>(r0)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            com.aiii.sdk.android.oss.ClientException r0 = new com.aiii.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r3 = r10.getMessage()     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            r0.<init>(r3, r10, r2)     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
            throw r0     // Catch:{ ServiceException -> 0x00c6, Exception -> 0x00cb, all -> 0x00c8 }
        L_0x00c6:
            r10 = move-exception
            goto L_0x00d0
        L_0x00c8:
            r10 = move-exception
            goto L_0x013b
        L_0x00cb:
            r10 = move-exception
            r0 = r12
            goto L_0x00d6
        L_0x00ce:
            r10 = move-exception
            r1 = r0
        L_0x00d0:
            r0 = r12
            goto L_0x00e6
        L_0x00d2:
            r10 = move-exception
            r12 = r0
            goto L_0x013b
        L_0x00d5:
            r10 = move-exception
        L_0x00d6:
            r9.processException(r10)     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x013a
            r0.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x013a
        L_0x00df:
            r10 = move-exception
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r10)
            goto L_0x013a
        L_0x00e4:
            r10 = move-exception
            r1 = r0
        L_0x00e6:
            int r12 = r10.getStatusCode()     // Catch:{ all -> 0x00d2 }
            r2 = 409(0x199, float:5.73E-43)
            if (r12 == r2) goto L_0x00f2
            r9.processException(r10)     // Catch:{ all -> 0x00d2 }
            goto L_0x0135
        L_0x00f2:
            com.aiii.sdk.android.oss.model.PartETag r12 = new com.aiii.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x00d2 }
            int r2 = r1.getPartNumber()     // Catch:{ all -> 0x00d2 }
            java.lang.String r10 = r10.getPartEtag()     // Catch:{ all -> 0x00d2 }
            r12.<init>(r2, r10)     // Catch:{ all -> 0x00d2 }
            byte[] r10 = r1.getPartContent()     // Catch:{ all -> 0x00d2 }
            int r10 = r10.length     // Catch:{ all -> 0x00d2 }
            long r2 = (long) r10     // Catch:{ all -> 0x00d2 }
            r12.setPartSize(r2)     // Catch:{ all -> 0x00d2 }
            boolean r10 = r9.mCheckCRC64     // Catch:{ all -> 0x00d2 }
            if (r10 == 0) goto L_0x012a
            byte[] r10 = r1.getPartContent()     // Catch:{ all -> 0x00d2 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00d2 }
            r1.<init>(r10)     // Catch:{ all -> 0x00d2 }
            java.util.zip.CheckedInputStream r10 = new java.util.zip.CheckedInputStream     // Catch:{ all -> 0x00d2 }
            com.aiii.sdk.android.oss.common.utils.CRC64 r2 = new com.aiii.sdk.android.oss.common.utils.CRC64     // Catch:{ all -> 0x00d2 }
            r2.<init>()     // Catch:{ all -> 0x00d2 }
            r10.<init>(r1, r2)     // Catch:{ all -> 0x00d2 }
            java.util.zip.Checksum r10 = r10.getChecksum()     // Catch:{ all -> 0x00d2 }
            long r1 = r10.getValue()     // Catch:{ all -> 0x00d2 }
            r12.setCRC64(r1)     // Catch:{ all -> 0x00d2 }
        L_0x012a:
            java.util.List r10 = r9.mPartETags     // Catch:{ all -> 0x00d2 }
            r10.add(r12)     // Catch:{ all -> 0x00d2 }
            long r1 = r9.mUploadedLength     // Catch:{ all -> 0x00d2 }
            long r10 = (long) r11     // Catch:{ all -> 0x00d2 }
            long r1 = r1 + r10
            r9.mUploadedLength = r1     // Catch:{ all -> 0x00d2 }
        L_0x0135:
            if (r0 == 0) goto L_0x013a
            r0.close()     // Catch:{ IOException -> 0x00df }
        L_0x013a:
            return
        L_0x013b:
            if (r12 == 0) goto L_0x0145
            r12.close()     // Catch:{ IOException -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            r11 = move-exception
            com.aiii.sdk.android.oss.common.OSSLog.logThrowable2Local(r11)
        L_0x0145:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }
}
