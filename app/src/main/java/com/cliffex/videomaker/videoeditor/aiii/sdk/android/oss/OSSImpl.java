package com.aiii.sdk.android.oss;

import android.content.Context;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.common.OSSLogToFileUtils;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.internal.ExtensionRequestOperation;
import com.aiii.sdk.android.oss.internal.InternalRequestOperation;
import com.aiii.sdk.android.oss.internal.OSSAsyncTask;
import com.aiii.sdk.android.oss.internal.ObjectURLPresigner;
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
import com.aiii.sdk.android.oss.model.GeneratePresignedUrlRequest;
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
import com.aiii.sdk.android.oss.model.MultipartUploadRequest;
import com.aiii.sdk.android.oss.model.PutObjectRequest;
import com.aiii.sdk.android.oss.model.PutObjectResult;
import com.aiii.sdk.android.oss.model.PutSymlinkRequest;
import com.aiii.sdk.android.oss.model.PutSymlinkResult;
import com.aiii.sdk.android.oss.model.RestoreObjectRequest;
import com.aiii.sdk.android.oss.model.RestoreObjectResult;
import com.aiii.sdk.android.oss.model.ResumableUploadRequest;
import com.aiii.sdk.android.oss.model.ResumableUploadResult;
import com.aiii.sdk.android.oss.model.TriggerCallbackRequest;
import com.aiii.sdk.android.oss.model.TriggerCallbackResult;
import com.aiii.sdk.android.oss.model.UploadPartRequest;
import com.aiii.sdk.android.oss.model.UploadPartResult;
import com.introvd.template.datacenter.SocialService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import p503cz.msebera.android.httpclient.HttpHost;

class OSSImpl implements OSS {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpointURI;
    private ExtensionRequestOperation extensionRequestOperation;
    private InternalRequestOperation internalRequestOperation;

    public OSSImpl(Context context, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.credentialProvider = oSSCredentialProvider;
        if (clientConfiguration == null) {
            clientConfiguration = ClientConfiguration.getDefaultConf();
        }
        this.conf = clientConfiguration;
        this.internalRequestOperation = new InternalRequestOperation(context.getApplicationContext(), oSSCredentialProvider, this.conf);
        this.extensionRequestOperation = new ExtensionRequestOperation(this.internalRequestOperation);
    }

    public OSSImpl(Context context, String str, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        OSSLogToFileUtils.init(context.getApplicationContext(), clientConfiguration);
        try {
            String trim = str.trim();
            if (!trim.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                StringBuilder sb = new StringBuilder();
                sb.append(SocialService.CONST_URL_HTTP_PREFIX);
                sb.append(trim);
                trim = sb.toString();
            }
            this.endpointURI = new URI(trim);
            if (oSSCredentialProvider != null) {
                Boolean valueOf = Boolean.valueOf(false);
                try {
                    valueOf = Boolean.valueOf(OSSUtils.isValidateIP(this.endpointURI.getHost()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!this.endpointURI.getScheme().equals("https") || !valueOf.booleanValue()) {
                    this.credentialProvider = oSSCredentialProvider;
                    if (clientConfiguration == null) {
                        clientConfiguration = ClientConfiguration.getDefaultConf();
                    }
                    this.conf = clientConfiguration;
                    this.internalRequestOperation = new InternalRequestOperation(context.getApplicationContext(), this.endpointURI, oSSCredentialProvider, this.conf);
                    this.extensionRequestOperation = new ExtensionRequestOperation(this.internalRequestOperation);
                    return;
                }
                throw new IllegalArgumentException("endpoint should not be format with https://ip.");
            }
            throw new IllegalArgumentException("CredentialProvider can't be null.");
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws ClientException, ServiceException {
        return (AbortMultipartUploadResult) this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, null).getResult();
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException {
        this.extensionRequestOperation.abortResumableUpload(resumableUploadRequest);
    }

    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncAppendObject(appendObjectRequest);
    }

    public OSSAsyncTask<AbortMultipartUploadResult> asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<AppendObjectResult> asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.appendObject(appendObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.completeMultipartUpload(completeMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CopyObjectResult> asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.copyObject(copyObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CreateBucketResult> asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback) {
        return this.internalRequestOperation.createBucket(createBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteBucketResult> asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback) {
        return this.internalRequestOperation.deleteBucket(deleteBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteMultipleObjectResult> asyncDeleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.deleteMultipleObject(deleteMultipleObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteObjectResult> asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.deleteObject(deleteObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetBucketACLResult> asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketACL(getBucketACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetBucketInfoResult> asyncGetBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback<GetBucketInfoRequest, GetBucketInfoResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketInfo(getBucketInfoRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetObjectResult> asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getObject(getObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetObjectACLResult> asyncGetObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback<GetObjectACLRequest, GetObjectACLResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getObjectACL(getObjectACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetSymlinkResult> asyncGetSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getSymlink(getSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<HeadObjectResult> asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.headObject(headObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ImagePersistResult> asyncImagePersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback<ImagePersistRequest, ImagePersistResult> oSSCompletedCallback) {
        return this.internalRequestOperation.imageActionPersist(imagePersistRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<InitiateMultipartUploadResult> asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListBucketsResult> asyncListBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback<ListBucketsRequest, ListBucketsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listBuckets(listBucketsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListMultipartUploadsResult> asyncListMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback<ListMultipartUploadsRequest, ListMultipartUploadsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listMultipartUploads(listMultipartUploadsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListObjectsResult> asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listObjects(listObjectsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListPartsResult> asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listParts(listPartsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.extensionRequestOperation.multipartUpload(multipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<PutObjectResult> asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.putObject(putObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<PutSymlinkResult> asyncPutSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult> oSSCompletedCallback) {
        return this.internalRequestOperation.putSymlink(putSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<RestoreObjectResult> asyncRestoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.restoreObject(restoreObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ResumableUploadResult> asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        return this.extensionRequestOperation.resumableUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ResumableUploadResult> asyncSequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        return this.extensionRequestOperation.sequenceUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<TriggerCallbackResult> asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult> oSSCompletedCallback) {
        return this.internalRequestOperation.triggerCallback(triggerCallbackRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<UploadPartResult> asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback) {
        return this.internalRequestOperation.uploadPart(uploadPartRequest, oSSCompletedCallback);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws ClientException, ServiceException {
        return (CopyObjectResult) this.internalRequestOperation.copyObject(copyObjectRequest, null).getResult();
    }

    public CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) throws ClientException, ServiceException {
        return (CreateBucketResult) this.internalRequestOperation.createBucket(createBucketRequest, null).getResult();
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws ClientException, ServiceException {
        return (DeleteBucketResult) this.internalRequestOperation.deleteBucket(deleteBucketRequest, null).getResult();
    }

    public DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest) throws ClientException, ServiceException {
        return (DeleteMultipleObjectResult) this.internalRequestOperation.deleteMultipleObject(deleteMultipleObjectRequest, null).getResult();
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws ClientException, ServiceException {
        return (DeleteObjectResult) this.internalRequestOperation.deleteObject(deleteObjectRequest, null).getResult();
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        return this.extensionRequestOperation.doesObjectExist(str, str2);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws ClientException, ServiceException {
        return (GetBucketACLResult) this.internalRequestOperation.getBucketACL(getBucketACLRequest, null).getResult();
    }

    public GetBucketInfoResult getBucketInfo(GetBucketInfoRequest getBucketInfoRequest) throws ClientException, ServiceException {
        return (GetBucketInfoResult) this.internalRequestOperation.getBucketInfo(getBucketInfoRequest, null).getResult();
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws ClientException, ServiceException {
        return (GetObjectResult) this.internalRequestOperation.getObject(getObjectRequest, null).getResult();
    }

    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) throws ClientException, ServiceException {
        return (GetObjectACLResult) this.internalRequestOperation.getObjectACL(getObjectACLRequest, null).getResult();
    }

    public GetSymlinkResult getSymlink(GetSymlinkRequest getSymlinkRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncGetSymlink(getSymlinkRequest);
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws ClientException, ServiceException {
        return (HeadObjectResult) this.internalRequestOperation.headObject(headObjectRequest, null).getResult();
    }

    public ImagePersistResult imagePersist(ImagePersistRequest imagePersistRequest) throws ClientException, ServiceException {
        return (ImagePersistResult) this.internalRequestOperation.imageActionPersist(imagePersistRequest, null).getResult();
    }

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws ClientException, ServiceException {
        return (InitiateMultipartUploadResult) this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult();
    }

    public ListBucketsResult listBuckets(ListBucketsRequest listBucketsRequest) throws ClientException, ServiceException {
        return (ListBucketsResult) this.internalRequestOperation.listBuckets(listBucketsRequest, null).getResult();
    }

    public ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws ClientException, ServiceException {
        return (ListMultipartUploadsResult) this.internalRequestOperation.listMultipartUploads(listMultipartUploadsRequest, null).getResult();
    }

    public ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) throws ClientException, ServiceException {
        return (ListObjectsResult) this.internalRequestOperation.listObjects(listObjectsRequest, null).getResult();
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) throws ClientException, ServiceException {
        return (ListPartsResult) this.internalRequestOperation.listParts(listPartsRequest, null).getResult();
    }

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) throws ClientException, ServiceException {
        return (CompleteMultipartUploadResult) this.extensionRequestOperation.multipartUpload(multipartUploadRequest, null).getResult();
    }

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignConstrainedObjectURL(String str, String str2, long j) throws ClientException {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignConstrainedURL(str, str2, j);
    }

    public String presignPublicObjectURL(String str, String str2) {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignPublicURL(str, str2);
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncPutObject(putObjectRequest);
    }

    public PutSymlinkResult putSymlink(PutSymlinkRequest putSymlinkRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncPutSymlink(putSymlinkRequest);
    }

    public RestoreObjectResult restoreObject(RestoreObjectRequest restoreObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncRestoreObject(restoreObjectRequest);
    }

    public ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException {
        return (ResumableUploadResult) this.extensionRequestOperation.resumableUpload(resumableUploadRequest, null).getResult();
    }

    public ResumableUploadResult sequenceUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException {
        return (ResumableUploadResult) this.extensionRequestOperation.sequenceUpload(resumableUploadRequest, null).getResult();
    }

    public TriggerCallbackResult triggerCallback(TriggerCallbackRequest triggerCallbackRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.asyncTriggerCallback(triggerCallbackRequest);
    }

    public void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
        this.internalRequestOperation.setCredentialProvider(oSSCredentialProvider);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.syncUploadPart(uploadPartRequest);
    }
}
