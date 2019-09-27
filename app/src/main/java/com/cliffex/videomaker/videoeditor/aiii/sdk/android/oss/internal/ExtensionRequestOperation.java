package com.aiii.sdk.android.oss.internal;

import android.os.Environment;
import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.common.OSSConstants;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.utils.BinaryUtil;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.aiii.sdk.android.oss.model.HeadObjectRequest;
import com.aiii.sdk.android.oss.model.MultipartUploadRequest;
import com.aiii.sdk.android.oss.model.OSSRequest;
import com.aiii.sdk.android.oss.model.OSSRequest.CRC64Config;
import com.aiii.sdk.android.oss.model.ResumableUploadRequest;
import com.aiii.sdk.android.oss.model.ResumableUploadResult;
import com.aiii.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExtensionRequestOperation {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-extensionapi-thread");
        }
    });
    private InternalRequestOperation apiOperation;

    public ExtensionRequestOperation(InternalRequestOperation internalRequestOperation) {
        this.apiOperation = internalRequestOperation;
    }

    private void setCRC64(OSSRequest oSSRequest) {
        Enum enumR = oSSRequest.getCRC64() != CRC64Config.NULL ? oSSRequest.getCRC64() : this.apiOperation.getConf().isCheckCRC64() ? CRC64Config.YES : CRC64Config.NO;
        oSSRequest.setCRC64(enumR);
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException {
        setCRC64(resumableUploadRequest);
        String uploadFilePath = resumableUploadRequest.getUploadFilePath();
        if (!OSSUtils.isEmptyString(resumableUploadRequest.getRecordDirectory())) {
            String calculateMd5Str = BinaryUtil.calculateMd5Str(uploadFilePath);
            StringBuilder sb = new StringBuilder();
            sb.append(calculateMd5Str);
            sb.append(resumableUploadRequest.getBucketName());
            sb.append(resumableUploadRequest.getObjectKey());
            sb.append(String.valueOf(resumableUploadRequest.getPartSize()));
            String calculateMd5Str2 = BinaryUtil.calculateMd5Str(sb.toString().getBytes());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(resumableUploadRequest.getRecordDirectory());
            sb2.append("/");
            sb2.append(calculateMd5Str2);
            File file = new File(sb2.toString());
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[initUploadId] - Found record file, uploadid: ");
                sb3.append(readLine);
                OSSLog.logDebug(sb3.toString());
                if (resumableUploadRequest.getCRC64() == CRC64Config.YES) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(Environment.getExternalStorageDirectory().getPath());
                    sb4.append(File.separator);
                    sb4.append(OSSConstants.RESOURCE_NAME_OSS);
                    sb4.append(File.separator);
                    sb4.append(readLine);
                    File file2 = new File(sb4.toString());
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                this.apiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(resumableUploadRequest.getBucketName(), resumableUploadRequest.getObjectKey(), readLine), null);
            }
            file.delete();
        }
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        try {
            this.apiOperation.headObject(new HeadObjectRequest(str, str2), null).getResult();
            return true;
        } catch (ServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> multipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        setCRC64(multipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), multipartUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new MultipartUploadTask(this.apiOperation, multipartUploadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    public OSSAsyncTask<ResumableUploadResult> resumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new ResumableUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }

    public OSSAsyncTask<ResumableUploadResult> sequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new SequenceUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }
}
