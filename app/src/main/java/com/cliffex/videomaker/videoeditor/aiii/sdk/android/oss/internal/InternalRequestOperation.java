package com.aiii.sdk.android.oss.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.aiii.sdk.android.oss.ClientConfiguration;
import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.common.HttpMethod;
import com.aiii.sdk.android.oss.common.OSSHeaders;
import com.aiii.sdk.android.oss.common.RequestParameters;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.common.utils.BinaryUtil;
import com.aiii.sdk.android.oss.common.utils.CRC64;
import com.aiii.sdk.android.oss.common.utils.DateUtil;
import com.aiii.sdk.android.oss.common.utils.HttpUtil;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.common.utils.VersionInfoUtils;
import com.aiii.sdk.android.oss.exception.InconsistentException;
import com.aiii.sdk.android.oss.internal.ResponseParsers.AbortMultipartUploadResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.AppendObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.CompleteMultipartUploadResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.CopyObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.CreateBucketResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.DeleteBucketResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.DeleteMultipleObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.DeleteObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.GetBucketACLResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.GetBucketInfoResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.GetObjectACLResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.GetObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.GetSymlinkResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.HeadObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.ImagePersistResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.InitMultipartResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.ListBucketResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.ListMultipartUploadsResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.ListObjectsResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.ListPartsResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.PutObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.PutSymlinkResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.RestoreObjectResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.TriggerCallbackResponseParser;
import com.aiii.sdk.android.oss.internal.ResponseParsers.UploadPartResponseParser;
import com.aiii.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.AbortMultipartUploadResult;
import com.aiii.sdk.android.oss.model.AppendObjectRequest;
import com.aiii.sdk.android.oss.model.AppendObjectResult;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.aiii.sdk.android.oss.model.CopyObjectRequest;
import com.aiii.sdk.android.oss.model.CopyObjectResult;
import com.aiii.sdk.android.oss.model.CreateBucketRequest;
import com.aiii.sdk.android.oss.model.CreateBucketResult;
import com.aiii.sdk.android.oss.model.DeleteBucketRequest;
import com.aiii.sdk.android.oss.model.DeleteBucketResult;
import com.aiii.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.aiii.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.aiii.sdk.android.oss.model.DeleteObjectRequest;
import com.aiii.sdk.android.oss.model.DeleteObjectResult;
import com.aiii.sdk.android.oss.model.GetBucketACLRequest;
import com.aiii.sdk.android.oss.model.GetBucketACLResult;
import com.aiii.sdk.android.oss.model.GetBucketInfoRequest;
import com.aiii.sdk.android.oss.model.GetBucketInfoResult;
import com.aiii.sdk.android.oss.model.GetObjectACLRequest;
import com.aiii.sdk.android.oss.model.GetObjectACLResult;
import com.aiii.sdk.android.oss.model.GetObjectRequest;
import com.aiii.sdk.android.oss.model.GetObjectResult;
import com.aiii.sdk.android.oss.model.GetSymlinkRequest;
import com.aiii.sdk.android.oss.model.GetSymlinkResult;
import com.aiii.sdk.android.oss.model.HeadObjectRequest;
import com.aiii.sdk.android.oss.model.HeadObjectResult;
import com.aiii.sdk.android.oss.model.ImagePersistRequest;
import com.aiii.sdk.android.oss.model.ImagePersistResult;
import com.aiii.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.aiii.sdk.android.oss.model.ListBucketsRequest;
import com.aiii.sdk.android.oss.model.ListBucketsResult;
import com.aiii.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.aiii.sdk.android.oss.model.ListMultipartUploadsResult;
import com.aiii.sdk.android.oss.model.ListObjectsRequest;
import com.aiii.sdk.android.oss.model.ListObjectsResult;
import com.aiii.sdk.android.oss.model.ListPartsRequest;
import com.aiii.sdk.android.oss.model.ListPartsResult;
import com.aiii.sdk.android.oss.model.OSSRequest;
import com.aiii.sdk.android.oss.model.OSSRequest.CRC64Config;
import com.aiii.sdk.android.oss.model.OSSResult;
import com.aiii.sdk.android.oss.model.PartETag;
import com.aiii.sdk.android.oss.model.PutObjectRequest;
import com.aiii.sdk.android.oss.model.PutObjectResult;
import com.aiii.sdk.android.oss.model.PutSymlinkRequest;
import com.aiii.sdk.android.oss.model.PutSymlinkResult;
import com.aiii.sdk.android.oss.model.RestoreObjectRequest;
import com.aiii.sdk.android.oss.model.RestoreObjectResult;
import com.aiii.sdk.android.oss.model.TriggerCallbackRequest;
import com.aiii.sdk.android.oss.model.TriggerCallbackResult;
import com.aiii.sdk.android.oss.model.UploadPartRequest;
import com.aiii.sdk.android.oss.model.UploadPartResult;
import com.aiii.sdk.android.oss.network.ExecutionContext;
import com.aiii.sdk.android.oss.network.OSSRequestTask;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.C9811c;
import okhttp3.C9931n;
import okhttp3.C9951x;
import okhttp3.C9951x.C9953a;

public class InternalRequestOperation {
    private static final int LIST_PART_MAX_RETURNS = 1000;
    private static final int MAX_PART_NUMBER = 10000;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-api-thread");
        }
    });
    private Context applicationContext;
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private volatile URI endpoint;
    private C9951x innerClient;
    private int maxRetryCount = 2;
    /* access modifiers changed from: private */
    public URI service;

    public InternalRequestOperation(Context context, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        try {
            this.service = new URI("http://oss.aliyuncs.com");
            this.endpoint = new URI("http://127.0.0.1");
            this.applicationContext = context;
            this.credentialProvider = oSSCredentialProvider;
            this.conf = clientConfiguration;
            C9953a a = new C9953a().mo38234ky(false).mo38233kx(false).mo38235kz(false).mo38226a((C9811c) null).mo38225a((HostnameVerifier) new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(InternalRequestOperation.this.service.getHost(), sSLSession);
                }
            });
            if (clientConfiguration != null) {
                C9931n nVar = new C9931n();
                nVar.mo38129xm(clientConfiguration.getMaxConcurrentRequest());
                a.mo38236l((long) clientConfiguration.getConnectionTimeout(), TimeUnit.MILLISECONDS).mo38237m((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).mo38238n((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).mo38227a(nVar);
                if (!(clientConfiguration.getProxyHost() == null || clientConfiguration.getProxyPort() == 0)) {
                    a.mo38224a(new Proxy(Type.HTTP, new InetSocketAddress(clientConfiguration.getProxyHost(), clientConfiguration.getProxyPort())));
                }
                this.maxRetryCount = clientConfiguration.getMaxErrorRetry();
            }
            this.innerClient = a.aWR();
        } catch (Exception unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    public InternalRequestOperation(Context context, final URI uri, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.applicationContext = context;
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
        C9953a a = new C9953a().mo38234ky(false).mo38233kx(false).mo38235kz(false).mo38226a((C9811c) null).mo38225a((HostnameVerifier) new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(uri.getHost(), sSLSession);
            }
        });
        if (clientConfiguration != null) {
            C9931n nVar = new C9931n();
            nVar.mo38129xm(clientConfiguration.getMaxConcurrentRequest());
            a.mo38236l((long) clientConfiguration.getConnectionTimeout(), TimeUnit.MILLISECONDS).mo38237m((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).mo38238n((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).mo38227a(nVar);
            if (!(clientConfiguration.getProxyHost() == null || clientConfiguration.getProxyPort() == 0)) {
                a.mo38224a(new Proxy(Type.HTTP, new InetSocketAddress(clientConfiguration.getProxyHost(), clientConfiguration.getProxyPort())));
            }
            this.maxRetryCount = clientConfiguration.getMaxErrorRetry();
        }
        this.innerClient = a.aWR();
    }

    /* access modifiers changed from: private */
    public long calcObjectCRCFromParts(List<PartETag> list) {
        long j = 0;
        for (PartETag partETag : list) {
            if (partETag.getCRC64() == 0 || partETag.getPartSize() <= 0) {
                return 0;
            }
            j = CRC64.combine(j, partETag.getCRC64(), partETag.getPartSize());
        }
        return j;
    }

    private void canonicalizeRequestMessage(RequestMessage requestMessage, OSSRequest oSSRequest) {
        Map headers = requestMessage.getHeaders();
        if (headers.get("Date") == null) {
            headers.put("Date", DateUtil.currentFixedSkewedTimeInRFC822Format());
        }
        if ((requestMessage.getMethod() == HttpMethod.POST || requestMessage.getMethod() == HttpMethod.PUT) && OSSUtils.isEmptyString((String) headers.get("Content-Type"))) {
            headers.put("Content-Type", OSSUtils.determineContentType(null, requestMessage.getUploadFilePath(), requestMessage.getObjectKey()));
        }
        requestMessage.setHttpDnsEnable(checkIfHttpDnsAvailable(this.conf.isHttpDnsEnable()));
        requestMessage.setCredentialProvider(this.credentialProvider);
        requestMessage.getHeaders().put("User-Agent", VersionInfoUtils.getUserAgent(this.conf.getCustomUserMark()));
        boolean z = false;
        if (requestMessage.getHeaders().containsKey("Range") || requestMessage.getParameters().containsKey(RequestParameters.X_OSS_PROCESS)) {
            requestMessage.setCheckCRC64(false);
        }
        requestMessage.setIsInCustomCnameExcludeList(OSSUtils.isInCustomCnameExcludeList(this.endpoint.getHost(), this.conf.getCustomCnameExcludeList()));
        if (oSSRequest.getCRC64() == CRC64Config.NULL) {
            z = this.conf.isCheckCRC64();
        } else if (oSSRequest.getCRC64() == CRC64Config.YES) {
            z = true;
        }
        requestMessage.setCheckCRC64(z);
        oSSRequest.setCRC64(z ? CRC64Config.YES : CRC64Config.NO);
    }

    private <Request extends OSSRequest, Result extends OSSResult> void checkCRC64(Request request, Result result) throws ClientException {
        if (request.getCRC64() == CRC64Config.YES) {
            try {
                OSSUtils.checkChecksum(result.getClientCRC(), result.getServerCRC(), result.getRequestId());
            } catch (InconsistentException e) {
                throw new ClientException(e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: private */
    public <Request extends OSSRequest, Result extends OSSResult> void checkCRC64(Request request, Result result, OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        try {
            checkCRC64(request, result);
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(request, result);
            }
        } catch (ClientException e) {
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(request, e, null);
            }
        }
    }

    private boolean checkIfHttpDnsAvailable(boolean z) {
        boolean z2 = false;
        if (!z || this.applicationContext == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 14) {
            z2 = true;
        }
        String property = z2 ? System.getProperty("http.proxyHost") : android.net.Proxy.getHost(this.applicationContext);
        String proxyHost = this.conf.getProxyHost();
        if (!TextUtils.isEmpty(proxyHost)) {
            property = proxyHost;
        }
        return TextUtils.isEmpty(property);
    }

    public OSSAsyncTask<AbortMultipartUploadResult> abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(abortMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(abortMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(abortMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, abortMultipartUploadRequest.getUploadId());
        canonicalizeRequestMessage(requestMessage, abortMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), abortMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new AbortMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<AppendObjectResult> appendObject(AppendObjectRequest appendObjectRequest, final OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(appendObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(appendObjectRequest.getBucketName());
        requestMessage.setObjectKey(appendObjectRequest.getObjectKey());
        if (appendObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(appendObjectRequest.getUploadData());
        }
        if (appendObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(appendObjectRequest.getUploadFilePath());
        }
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_APPEND, "");
        requestMessage.getParameters().put("position", String.valueOf(appendObjectRequest.getPosition()));
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), appendObjectRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, appendObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), appendObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<AppendObjectRequest, AppendObjectResult>() {
                public void onFailure(AppendObjectRequest appendObjectRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(appendObjectRequest, clientException, serviceException);
                }

                public void onSuccess(AppendObjectRequest appendObjectRequest, AppendObjectResult appendObjectResult) {
                    boolean z = appendObjectRequest.getCRC64() == CRC64Config.YES;
                    if (appendObjectRequest.getInitCRC64() != null && z) {
                        appendObjectResult.setClientCRC(Long.valueOf(CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), appendObjectResult.getClientCRC().longValue(), appendObjectResult.getNextPosition() - appendObjectRequest.getPosition())));
                    }
                    InternalRequestOperation.this.checkCRC64(appendObjectRequest, appendObjectResult, oSSCompletedCallback);
                }
            });
        }
        executionContext.setProgressCallback(appendObjectRequest.getProgressCallback());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new AppendObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public TriggerCallbackResult asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest) throws ClientException, ServiceException {
        return (TriggerCallbackResult) triggerCallback(triggerCallbackRequest, null).getResult();
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, final OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(completeMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(completeMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(completeMultipartUploadRequest.getObjectKey());
        requestMessage.setStringBody(OSSUtils.buildXMLFromPartEtagList(completeMultipartUploadRequest.getPartETags()));
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, completeMultipartUploadRequest.getUploadId());
        if (completeMultipartUploadRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackParam()));
        }
        if (completeMultipartUploadRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackVars()));
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), completeMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, completeMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), completeMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>() {
                public void onFailure(CompleteMultipartUploadRequest completeMultipartUploadRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(completeMultipartUploadRequest, clientException, serviceException);
                }

                public void onSuccess(CompleteMultipartUploadRequest completeMultipartUploadRequest, CompleteMultipartUploadResult completeMultipartUploadResult) {
                    if (completeMultipartUploadResult.getServerCRC() != null) {
                        completeMultipartUploadResult.setClientCRC(Long.valueOf(InternalRequestOperation.this.calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
                    }
                    InternalRequestOperation.this.checkCRC64(completeMultipartUploadRequest, completeMultipartUploadResult, oSSCompletedCallback);
                }
            });
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new CompleteMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<CopyObjectResult> copyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(copyObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(copyObjectRequest.getDestinationBucketName());
        requestMessage.setObjectKey(copyObjectRequest.getDestinationKey());
        OSSUtils.populateCopyObjectHeaders(copyObjectRequest, requestMessage.getHeaders());
        canonicalizeRequestMessage(requestMessage, copyObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), copyObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new CopyObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<CreateBucketResult> createBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(createBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(createBucketRequest.getBucketName());
        if (createBucketRequest.getBucketACL() != null) {
            requestMessage.getHeaders().put(OSSHeaders.OSS_CANNED_ACL, createBucketRequest.getBucketACL().toString());
        }
        try {
            HashMap hashMap = new HashMap();
            if (createBucketRequest.getLocationConstraint() != null) {
                hashMap.put(CreateBucketRequest.TAB_LOCATIONCONSTRAINT, createBucketRequest.getLocationConstraint());
            }
            hashMap.put(CreateBucketRequest.TAB_STORAGECLASS, createBucketRequest.getBucketStorageClass().toString());
            requestMessage.createBucketRequestBodyMarshall(hashMap);
            canonicalizeRequestMessage(requestMessage, createBucketRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), createBucketRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new CreateBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<DeleteBucketResult> deleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, deleteBucketRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteBucketRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new DeleteBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<DeleteMultipleObjectResult> deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_DELETE, "");
        requestMessage.setIsAuthorizationRequired(deleteMultipleObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(deleteMultipleObjectRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            byte[] deleteMultipleObjectRequestBodyMarshall = requestMessage.deleteMultipleObjectRequestBodyMarshall(deleteMultipleObjectRequest.getObjectKeys(), deleteMultipleObjectRequest.getQuiet().booleanValue());
            if (deleteMultipleObjectRequestBodyMarshall != null && deleteMultipleObjectRequestBodyMarshall.length > 0) {
                requestMessage.getHeaders().put("Content-MD5", BinaryUtil.calculateBase64Md5(deleteMultipleObjectRequestBodyMarshall));
                requestMessage.getHeaders().put("Content-Length", String.valueOf(deleteMultipleObjectRequestBodyMarshall.length));
            }
            canonicalizeRequestMessage(requestMessage, deleteMultipleObjectRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteMultipleObjectRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new DeleteMultipleObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<DeleteObjectResult> deleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteObjectRequest.getBucketName());
        requestMessage.setObjectKey(deleteObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, deleteObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new DeleteObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public OSSAsyncTask<GetBucketACLResult> getBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getBucketACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketACLRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketACLRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new GetBucketACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetBucketInfoResult> getBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback<GetBucketInfoRequest, GetBucketInfoResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_BUCKETINFO, "");
        requestMessage.setIsAuthorizationRequired(getBucketInfoRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketInfoRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketInfoRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketInfoRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new GetBucketInfoResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public ClientConfiguration getConf() {
        return this.conf;
    }

    public C9951x getInnerClient() {
        return this.innerClient;
    }

    public OSSAsyncTask<GetObjectResult> getObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(getObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getObjectRequest.getBucketName());
        requestMessage.setObjectKey(getObjectRequest.getObjectKey());
        if (getObjectRequest.getRange() != null) {
            requestMessage.getHeaders().put("Range", getObjectRequest.getRange().toString());
        }
        if (getObjectRequest.getxOssProcess() != null) {
            requestMessage.getParameters().put(RequestParameters.X_OSS_PROCESS, getObjectRequest.getxOssProcess());
        }
        canonicalizeRequestMessage(requestMessage, getObjectRequest);
        if (getObjectRequest.getRequestHeaders() != null) {
            for (Entry entry : getObjectRequest.getRequestHeaders().entrySet()) {
                requestMessage.getHeaders().put(entry.getKey(), entry.getValue());
            }
        }
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        executionContext.setProgressCallback(getObjectRequest.getProgressListener());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new GetObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetObjectACLResult> getObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback<GetObjectACLRequest, GetObjectACLResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getObjectACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setBucketName(getObjectACLRequest.getBucketName());
        requestMessage.setObjectKey(getObjectACLRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, getObjectACLRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new GetObjectACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetSymlinkResult> getSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(getSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getSymlinkRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new GetSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<HeadObjectResult> headObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(headObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.HEAD);
        requestMessage.setBucketName(headObjectRequest.getBucketName());
        requestMessage.setObjectKey(headObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, headObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), headObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new HeadObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ImagePersistResult> imageActionPersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback<ImagePersistRequest, ImagePersistResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(imagePersistRequest.mFromBucket);
        requestMessage.setObjectKey(imagePersistRequest.mFromObjectkey);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setStringBody(OSSUtils.buildImagePersistentBody(imagePersistRequest.mToBucketName, imagePersistRequest.mToObjectKey, imagePersistRequest.mAction));
        canonicalizeRequestMessage(requestMessage, imagePersistRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), imagePersistRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ImagePersistResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<InitiateMultipartUploadResult> initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(initiateMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(initiateMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(initiateMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_UPLOADS, "");
        if (initiateMultipartUploadRequest.isSequential) {
            requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_SEQUENTIAL, "");
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), initiateMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, initiateMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), initiateMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new InitMultipartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListBucketsResult> listBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback<ListBucketsRequest, ListBucketsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listBucketsRequest.isAuthorizationRequired());
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setService(this.service);
        requestMessage.setEndpoint(this.endpoint);
        canonicalizeRequestMessage(requestMessage, listBucketsRequest);
        OSSUtils.populateListBucketRequestParameters(listBucketsRequest, requestMessage.getParameters());
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listBucketsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ListBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListMultipartUploadsResult> listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback<ListMultipartUploadsRequest, ListMultipartUploadsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listMultipartUploadsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listMultipartUploadsRequest.getBucketName());
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_UPLOADS, "");
        OSSUtils.populateListMultipartUploadsRequestParameters(listMultipartUploadsRequest, requestMessage.getParameters());
        canonicalizeRequestMessage(requestMessage, listMultipartUploadsRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listMultipartUploadsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ListMultipartUploadsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListObjectsResult> listObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listObjectsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listObjectsRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, listObjectsRequest);
        OSSUtils.populateListObjectsRequestParameters(listObjectsRequest, requestMessage.getParameters());
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listObjectsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ListObjectsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListPartsResult> listParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listPartsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listPartsRequest.getBucketName());
        requestMessage.setObjectKey(listPartsRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, listPartsRequest.getUploadId());
        Integer maxParts = listPartsRequest.getMaxParts();
        if (maxParts != null) {
            if (OSSUtils.checkParamRange((long) maxParts.intValue(), 0, true, 1000, true)) {
                requestMessage.getParameters().put(RequestParameters.MAX_PARTS, maxParts.toString());
            } else {
                throw new IllegalArgumentException("MaxPartsOutOfRange: 1000");
            }
        }
        Integer partNumberMarker = listPartsRequest.getPartNumberMarker();
        if (partNumberMarker != null) {
            if (OSSUtils.checkParamRange((long) partNumberMarker.intValue(), 0, false, 10000, true)) {
                requestMessage.getParameters().put(RequestParameters.PART_NUMBER_MARKER, partNumberMarker.toString());
            } else {
                throw new IllegalArgumentException("PartNumberMarkerOutOfRange: 10000");
            }
        }
        canonicalizeRequestMessage(requestMessage, listPartsRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listPartsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ListPartsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<PutObjectResult> putObject(PutObjectRequest putObjectRequest, final OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(putObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putObjectRequest.getBucketName());
        requestMessage.setObjectKey(putObjectRequest.getObjectKey());
        if (putObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(putObjectRequest.getUploadData());
        }
        if (putObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(putObjectRequest.getUploadFilePath());
        }
        if (putObjectRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackParam()));
        }
        if (putObjectRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackVars()));
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putObjectRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, putObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(putObjectRequest, clientException, serviceException);
                }

                public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
                    InternalRequestOperation.this.checkCRC64(putObjectRequest, putObjectResult, oSSCompletedCallback);
                }
            });
        }
        if (putObjectRequest.getRetryCallback() != null) {
            executionContext.setRetryCallback(putObjectRequest.getRetryCallback());
        }
        executionContext.setProgressCallback(putObjectRequest.getProgressCallback());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new PutObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<PutSymlinkResult> putSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(putSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        if (!OSSUtils.isEmptyString(putSymlinkRequest.getTargetObjectName())) {
            requestMessage.getHeaders().put(OSSHeaders.OSS_HEADER_SYMLINK_TARGET, HttpUtil.urlEncode(putSymlinkRequest.getTargetObjectName(), "utf-8"));
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putSymlinkRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, putSymlinkRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new PutSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<RestoreObjectResult> restoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_RESTORE, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(restoreObjectRequest.getBucketName());
        requestMessage.setObjectKey(restoreObjectRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, restoreObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), restoreObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new RestoreObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public AppendObjectResult syncAppendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException {
        AppendObjectResult appendObjectResult = (AppendObjectResult) appendObject(appendObjectRequest, null).getResult();
        boolean z = appendObjectRequest.getCRC64() == CRC64Config.YES;
        if (appendObjectRequest.getInitCRC64() != null && z) {
            appendObjectResult.setClientCRC(Long.valueOf(CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), appendObjectResult.getClientCRC().longValue(), appendObjectResult.getNextPosition() - appendObjectRequest.getPosition())));
        }
        checkCRC64(appendObjectRequest, appendObjectResult);
        return appendObjectResult;
    }

    public CompleteMultipartUploadResult syncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult = (CompleteMultipartUploadResult) completeMultipartUpload(completeMultipartUploadRequest, null).getResult();
        if (completeMultipartUploadResult.getServerCRC() != null) {
            completeMultipartUploadResult.setClientCRC(Long.valueOf(calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
        }
        checkCRC64(completeMultipartUploadRequest, completeMultipartUploadResult);
        return completeMultipartUploadResult;
    }

    public GetSymlinkResult syncGetSymlink(GetSymlinkRequest getSymlinkRequest) throws ClientException, ServiceException {
        return (GetSymlinkResult) getSymlink(getSymlinkRequest, null).getResult();
    }

    public PutObjectResult syncPutObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException {
        PutObjectResult putObjectResult = (PutObjectResult) putObject(putObjectRequest, null).getResult();
        checkCRC64(putObjectRequest, putObjectResult);
        return putObjectResult;
    }

    public PutSymlinkResult syncPutSymlink(PutSymlinkRequest putSymlinkRequest) throws ClientException, ServiceException {
        return (PutSymlinkResult) putSymlink(putSymlinkRequest, null).getResult();
    }

    public RestoreObjectResult syncRestoreObject(RestoreObjectRequest restoreObjectRequest) throws ClientException, ServiceException {
        return (RestoreObjectResult) restoreObject(restoreObjectRequest, null).getResult();
    }

    public UploadPartResult syncUploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException {
        UploadPartResult uploadPartResult = (UploadPartResult) uploadPart(uploadPartRequest, null).getResult();
        checkCRC64(uploadPartRequest, uploadPartResult);
        return uploadPartResult;
    }

    public OSSAsyncTask<TriggerCallbackResult> triggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(triggerCallbackRequest.getBucketName());
        requestMessage.setObjectKey(triggerCallbackRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        String buildTriggerCallbackBody = OSSUtils.buildTriggerCallbackBody(triggerCallbackRequest.getCallbackParam(), triggerCallbackRequest.getCallbackVars());
        requestMessage.setStringBody(buildTriggerCallbackBody);
        requestMessage.getHeaders().put("Content-MD5", BinaryUtil.calculateBase64Md5(buildTriggerCallbackBody.getBytes()));
        canonicalizeRequestMessage(requestMessage, triggerCallbackRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), triggerCallbackRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new TriggerCallbackResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<UploadPartResult> uploadPart(UploadPartRequest uploadPartRequest, final OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(uploadPartRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(uploadPartRequest.getBucketName());
        requestMessage.setObjectKey(uploadPartRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, uploadPartRequest.getUploadId());
        requestMessage.getParameters().put(RequestParameters.PART_NUMBER, String.valueOf(uploadPartRequest.getPartNumber()));
        requestMessage.setUploadData(uploadPartRequest.getPartContent());
        if (uploadPartRequest.getMd5Digest() != null) {
            requestMessage.getHeaders().put("Content-MD5", uploadPartRequest.getMd5Digest());
        }
        canonicalizeRequestMessage(requestMessage, uploadPartRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), uploadPartRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<UploadPartRequest, UploadPartResult>() {
                public void onFailure(UploadPartRequest uploadPartRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(uploadPartRequest, clientException, serviceException);
                }

                public void onSuccess(UploadPartRequest uploadPartRequest, UploadPartResult uploadPartResult) {
                    InternalRequestOperation.this.checkCRC64(uploadPartRequest, uploadPartResult, oSSCompletedCallback);
                }
            });
        }
        executionContext.setProgressCallback(uploadPartRequest.getProgressCallback());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new UploadPartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }
}
