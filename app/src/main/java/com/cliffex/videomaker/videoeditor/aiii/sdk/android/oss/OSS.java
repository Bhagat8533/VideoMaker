package com.aiii.sdk.android.oss;

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

public interface OSS {
    AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws ClientException, ServiceException;

    void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException;

    AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException;

    OSSAsyncTask<AbortMultipartUploadResult> asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback);

    OSSAsyncTask<AppendObjectResult> asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback);

    OSSAsyncTask<CompleteMultipartUploadResult> asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback);

    OSSAsyncTask<CopyObjectResult> asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback);

    OSSAsyncTask<CreateBucketResult> asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback);

    OSSAsyncTask<DeleteBucketResult> asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback);

    OSSAsyncTask<DeleteMultipleObjectResult> asyncDeleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult> oSSCompletedCallback);

    OSSAsyncTask<DeleteObjectResult> asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback);

    OSSAsyncTask<GetBucketACLResult> asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback);

    OSSAsyncTask<GetBucketInfoResult> asyncGetBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback<GetBucketInfoRequest, GetBucketInfoResult> oSSCompletedCallback);

    OSSAsyncTask<GetObjectResult> asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback);

    OSSAsyncTask<GetObjectACLResult> asyncGetObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback<GetObjectACLRequest, GetObjectACLResult> oSSCompletedCallback);

    OSSAsyncTask<GetSymlinkResult> asyncGetSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult> oSSCompletedCallback);

    OSSAsyncTask<HeadObjectResult> asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback);

    OSSAsyncTask<ImagePersistResult> asyncImagePersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback<ImagePersistRequest, ImagePersistResult> oSSCompletedCallback);

    OSSAsyncTask<InitiateMultipartUploadResult> asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback);

    OSSAsyncTask<ListBucketsResult> asyncListBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback<ListBucketsRequest, ListBucketsResult> oSSCompletedCallback);

    OSSAsyncTask<ListMultipartUploadsResult> asyncListMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback<ListMultipartUploadsRequest, ListMultipartUploadsResult> oSSCompletedCallback);

    OSSAsyncTask<ListObjectsResult> asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback);

    OSSAsyncTask<ListPartsResult> asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback);

    OSSAsyncTask<CompleteMultipartUploadResult> asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback);

    OSSAsyncTask<PutObjectResult> asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback);

    OSSAsyncTask<PutSymlinkResult> asyncPutSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult> oSSCompletedCallback);

    OSSAsyncTask<RestoreObjectResult> asyncRestoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult> oSSCompletedCallback);

    OSSAsyncTask<ResumableUploadResult> asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback);

    OSSAsyncTask<ResumableUploadResult> asyncSequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback);

    OSSAsyncTask<TriggerCallbackResult> asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult> oSSCompletedCallback);

    OSSAsyncTask<UploadPartResult> asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback);

    CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException;

    CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws ClientException, ServiceException;

    CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) throws ClientException, ServiceException;

    DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws ClientException, ServiceException;

    DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest) throws ClientException, ServiceException;

    DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws ClientException, ServiceException;

    boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException;

    GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws ClientException, ServiceException;

    GetBucketInfoResult getBucketInfo(GetBucketInfoRequest getBucketInfoRequest) throws ClientException, ServiceException;

    GetObjectResult getObject(GetObjectRequest getObjectRequest) throws ClientException, ServiceException;

    GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) throws ClientException, ServiceException;

    GetSymlinkResult getSymlink(GetSymlinkRequest getSymlinkRequest) throws ClientException, ServiceException;

    HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws ClientException, ServiceException;

    ImagePersistResult imagePersist(ImagePersistRequest imagePersistRequest) throws ClientException, ServiceException;

    InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws ClientException, ServiceException;

    ListBucketsResult listBuckets(ListBucketsRequest listBucketsRequest) throws ClientException, ServiceException;

    ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws ClientException, ServiceException;

    ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) throws ClientException, ServiceException;

    ListPartsResult listParts(ListPartsRequest listPartsRequest) throws ClientException, ServiceException;

    CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) throws ClientException, ServiceException;

    String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException;

    String presignConstrainedObjectURL(String str, String str2, long j) throws ClientException;

    String presignPublicObjectURL(String str, String str2);

    PutObjectResult putObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException;

    PutSymlinkResult putSymlink(PutSymlinkRequest putSymlinkRequest) throws ClientException, ServiceException;

    RestoreObjectResult restoreObject(RestoreObjectRequest restoreObjectRequest) throws ClientException, ServiceException;

    ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException;

    ResumableUploadResult sequenceUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException;

    TriggerCallbackResult triggerCallback(TriggerCallbackRequest triggerCallbackRequest) throws ClientException, ServiceException;

    void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider);

    UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException;
}
