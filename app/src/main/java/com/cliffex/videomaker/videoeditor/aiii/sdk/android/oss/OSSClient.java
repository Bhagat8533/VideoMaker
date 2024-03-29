package com.aiii.sdk.android.oss;

import android.content.Context;
import com.aiii.sdk.android.oss.callback.OSSCompletedCallback;
import com.aiii.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.aiii.sdk.android.oss.internal.OSSAsyncTask;
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
import java.io.IOException;

public class OSSClient implements OSS {
    private OSS mOss;

    public OSSClient(Context context, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.mOss = new OSSImpl(context, oSSCredentialProvider, clientConfiguration);
    }

    public OSSClient(Context context, String str, OSSCredentialProvider oSSCredentialProvider) {
        this(context, str, oSSCredentialProvider, null);
    }

    public OSSClient(Context context, String str, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.mOss = new OSSImpl(context, str, oSSCredentialProvider, clientConfiguration);
    }

    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws ClientException, ServiceException {
        return this.mOss.abortMultipartUpload(abortMultipartUploadRequest);
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException {
        this.mOss.abortResumableUpload(resumableUploadRequest);
    }

    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException {
        return this.mOss.appendObject(appendObjectRequest);
    }

    public OSSAsyncTask<AbortMultipartUploadResult> asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncAbortMultipartUpload(abortMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<AppendObjectResult> asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncAppendObject(appendObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncCompleteMultipartUpload(completeMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CopyObjectResult> asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncCopyObject(copyObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CreateBucketResult> asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback) {
        return this.mOss.asyncCreateBucket(createBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteBucketResult> asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback) {
        return this.mOss.asyncDeleteBucket(deleteBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteMultipleObjectResult> asyncDeleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncDeleteMultipleObject(deleteMultipleObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteObjectResult> asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncDeleteObject(deleteObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetBucketACLResult> asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback) {
        return this.mOss.asyncGetBucketACL(getBucketACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetBucketInfoResult> asyncGetBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback<GetBucketInfoRequest, GetBucketInfoResult> oSSCompletedCallback) {
        return this.mOss.asyncGetBucketInfo(getBucketInfoRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetObjectResult> asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncGetObject(getObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetObjectACLResult> asyncGetObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback<GetObjectACLRequest, GetObjectACLResult> oSSCompletedCallback) {
        return this.mOss.asyncGetObjectACL(getObjectACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetSymlinkResult> asyncGetSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult> oSSCompletedCallback) {
        return this.mOss.asyncGetSymlink(getSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<HeadObjectResult> asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncHeadObject(headObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ImagePersistResult> asyncImagePersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback<ImagePersistRequest, ImagePersistResult> oSSCompletedCallback) {
        return this.mOss.asyncImagePersist(imagePersistRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<InitiateMultipartUploadResult> asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncInitMultipartUpload(initiateMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListBucketsResult> asyncListBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback<ListBucketsRequest, ListBucketsResult> oSSCompletedCallback) {
        return this.mOss.asyncListBuckets(listBucketsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListMultipartUploadsResult> asyncListMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback<ListMultipartUploadsRequest, ListMultipartUploadsResult> oSSCompletedCallback) {
        return this.mOss.asyncListMultipartUploads(listMultipartUploadsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListObjectsResult> asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback) {
        return this.mOss.asyncListObjects(listObjectsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListPartsResult> asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback) {
        return this.mOss.asyncListParts(listPartsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncMultipartUpload(multipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<PutObjectResult> asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncPutObject(putObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<PutSymlinkResult> asyncPutSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult> oSSCompletedCallback) {
        return this.mOss.asyncPutSymlink(putSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<RestoreObjectResult> asyncRestoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult> oSSCompletedCallback) {
        return this.mOss.asyncRestoreObject(restoreObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ResumableUploadResult> asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncResumableUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ResumableUploadResult> asyncSequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        return this.mOss.asyncSequenceUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<TriggerCallbackResult> asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult> oSSCompletedCallback) {
        return this.mOss.asyncTriggerCallback(triggerCallbackRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<UploadPartResult> asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback) {
        return this.mOss.asyncUploadPart(uploadPartRequest, oSSCompletedCallback);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException {
        return this.mOss.completeMultipartUpload(completeMultipartUploadRequest);
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws ClientException, ServiceException {
        return this.mOss.copyObject(copyObjectRequest);
    }

    public CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) throws ClientException, ServiceException {
        return this.mOss.createBucket(createBucketRequest);
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws ClientException, ServiceException {
        return this.mOss.deleteBucket(deleteBucketRequest);
    }

    public DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest) throws ClientException, ServiceException {
        return this.mOss.deleteMultipleObject(deleteMultipleObjectRequest);
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws ClientException, ServiceException {
        return this.mOss.deleteObject(deleteObjectRequest);
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        return this.mOss.doesObjectExist(str, str2);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws ClientException, ServiceException {
        return this.mOss.getBucketACL(getBucketACLRequest);
    }

    public GetBucketInfoResult getBucketInfo(GetBucketInfoRequest getBucketInfoRequest) throws ClientException, ServiceException {
        return this.mOss.getBucketInfo(getBucketInfoRequest);
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws ClientException, ServiceException {
        return this.mOss.getObject(getObjectRequest);
    }

    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) throws ClientException, ServiceException {
        return this.mOss.getObjectACL(getObjectACLRequest);
    }

    public GetSymlinkResult getSymlink(GetSymlinkRequest getSymlinkRequest) throws ClientException, ServiceException {
        return this.mOss.getSymlink(getSymlinkRequest);
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws ClientException, ServiceException {
        return this.mOss.headObject(headObjectRequest);
    }

    public ImagePersistResult imagePersist(ImagePersistRequest imagePersistRequest) throws ClientException, ServiceException {
        return this.mOss.imagePersist(imagePersistRequest);
    }

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws ClientException, ServiceException {
        return this.mOss.initMultipartUpload(initiateMultipartUploadRequest);
    }

    public ListBucketsResult listBuckets(ListBucketsRequest listBucketsRequest) throws ClientException, ServiceException {
        return this.mOss.listBuckets(listBucketsRequest);
    }

    public ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws ClientException, ServiceException {
        return this.mOss.listMultipartUploads(listMultipartUploadsRequest);
    }

    public ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) throws ClientException, ServiceException {
        return this.mOss.listObjects(listObjectsRequest);
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) throws ClientException, ServiceException {
        return this.mOss.listParts(listPartsRequest);
    }

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) throws ClientException, ServiceException {
        return this.mOss.multipartUpload(multipartUploadRequest);
    }

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        return this.mOss.presignConstrainedObjectURL(generatePresignedUrlRequest);
    }

    public String presignConstrainedObjectURL(String str, String str2, long j) throws ClientException {
        return this.mOss.presignConstrainedObjectURL(str, str2, j);
    }

    public String presignPublicObjectURL(String str, String str2) {
        return this.mOss.presignPublicObjectURL(str, str2);
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException {
        return this.mOss.putObject(putObjectRequest);
    }

    public PutSymlinkResult putSymlink(PutSymlinkRequest putSymlinkRequest) throws ClientException, ServiceException {
        return this.mOss.putSymlink(putSymlinkRequest);
    }

    public RestoreObjectResult restoreObject(RestoreObjectRequest restoreObjectRequest) throws ClientException, ServiceException {
        return this.mOss.restoreObject(restoreObjectRequest);
    }

    public ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException {
        return this.mOss.resumableUpload(resumableUploadRequest);
    }

    public ResumableUploadResult sequenceUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException {
        return this.mOss.sequenceUpload(resumableUploadRequest);
    }

    public TriggerCallbackResult triggerCallback(TriggerCallbackRequest triggerCallbackRequest) throws ClientException, ServiceException {
        return this.mOss.triggerCallback(triggerCallbackRequest);
    }

    public void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.mOss.updateCredentialProvider(oSSCredentialProvider);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException {
        return this.mOss.uploadPart(uploadPartRequest);
    }
}
