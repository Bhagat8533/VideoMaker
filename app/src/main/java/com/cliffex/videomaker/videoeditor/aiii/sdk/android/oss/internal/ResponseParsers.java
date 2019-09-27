package com.aiii.sdk.android.oss.internal;

import android.text.TextUtils;
import android.util.Xml;
import com.aiii.sdk.android.oss.ClientException;
import com.aiii.sdk.android.oss.ServiceException;
import com.aiii.sdk.android.oss.common.OSSHeaders;
import com.aiii.sdk.android.oss.common.OSSLog;
import com.aiii.sdk.android.oss.common.utils.CRC64;
import com.aiii.sdk.android.oss.common.utils.DateUtil;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.model.AbortMultipartUploadResult;
import com.aiii.sdk.android.oss.model.AppendObjectResult;
import com.aiii.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.aiii.sdk.android.oss.model.CopyObjectResult;
import com.aiii.sdk.android.oss.model.CreateBucketRequest;
import com.aiii.sdk.android.oss.model.CreateBucketResult;
import com.aiii.sdk.android.oss.model.DeleteBucketResult;
import com.aiii.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.aiii.sdk.android.oss.model.DeleteObjectResult;
import com.aiii.sdk.android.oss.model.GetBucketACLResult;
import com.aiii.sdk.android.oss.model.GetBucketInfoResult;
import com.aiii.sdk.android.oss.model.GetObjectACLResult;
import com.aiii.sdk.android.oss.model.GetObjectResult;
import com.aiii.sdk.android.oss.model.GetSymlinkResult;
import com.aiii.sdk.android.oss.model.HeadObjectResult;
import com.aiii.sdk.android.oss.model.ImagePersistResult;
import com.aiii.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.aiii.sdk.android.oss.model.ListBucketsResult;
import com.aiii.sdk.android.oss.model.ListMultipartUploadsResult;
import com.aiii.sdk.android.oss.model.ListObjectsResult;
import com.aiii.sdk.android.oss.model.ListPartsResult;
import com.aiii.sdk.android.oss.model.OSSBucketSummary;
import com.aiii.sdk.android.oss.model.OSSObjectSummary;
import com.aiii.sdk.android.oss.model.ObjectMetadata;
import com.aiii.sdk.android.oss.model.Owner;
import com.aiii.sdk.android.oss.model.PartSummary;
import com.aiii.sdk.android.oss.model.PutObjectResult;
import com.aiii.sdk.android.oss.model.PutSymlinkResult;
import com.aiii.sdk.android.oss.model.RestoreObjectResult;
import com.aiii.sdk.android.oss.model.TriggerCallbackResult;
import com.aiii.sdk.android.oss.model.UploadPartResult;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResponseParsers {

    public static final class AbortMultipartUploadResponseParser extends AbstractResponseParser<AbortMultipartUploadResult> {
        public AbortMultipartUploadResult parseData(ResponseMessage responseMessage, AbortMultipartUploadResult abortMultipartUploadResult) throws Exception {
            return abortMultipartUploadResult;
        }
    }

    public static final class AppendObjectResponseParser extends AbstractResponseParser<AppendObjectResult> {
        public AppendObjectResult parseData(ResponseMessage responseMessage, AppendObjectResult appendObjectResult) throws IOException {
            String str = (String) responseMessage.getHeaders().get(OSSHeaders.OSS_NEXT_APPEND_POSITION);
            if (str != null) {
                appendObjectResult.setNextPosition(Long.valueOf(str));
            }
            appendObjectResult.setObjectCRC64((String) responseMessage.getHeaders().get(OSSHeaders.OSS_HASH_CRC64_ECMA));
            return appendObjectResult;
        }
    }

    public static final class CompleteMultipartUploadResponseParser extends AbstractResponseParser<CompleteMultipartUploadResult> {
        public CompleteMultipartUploadResult parseData(ResponseMessage responseMessage, CompleteMultipartUploadResult completeMultipartUploadResult) throws Exception {
            if (((String) responseMessage.getHeaders().get("Content-Type")).equals("application/xml")) {
                return ResponseParsers.parseCompleteMultipartUploadResponseXML(responseMessage.getContent(), completeMultipartUploadResult);
            }
            String string = responseMessage.getResponse().aXh().string();
            if (TextUtils.isEmpty(string)) {
                return completeMultipartUploadResult;
            }
            completeMultipartUploadResult.setServerCallbackReturnBody(string);
            return completeMultipartUploadResult;
        }
    }

    public static final class CopyObjectResponseParser extends AbstractResponseParser<CopyObjectResult> {
        public CopyObjectResult parseData(ResponseMessage responseMessage, CopyObjectResult copyObjectResult) throws Exception {
            return ResponseParsers.parseCopyObjectResponseXML(responseMessage.getContent(), copyObjectResult);
        }
    }

    public static final class CreateBucketResponseParser extends AbstractResponseParser<CreateBucketResult> {
        public CreateBucketResult parseData(ResponseMessage responseMessage, CreateBucketResult createBucketResult) throws Exception {
            if (createBucketResult.getResponseHeader().containsKey("Location")) {
                createBucketResult.bucketLocation = (String) createBucketResult.getResponseHeader().get("Location");
            }
            return createBucketResult;
        }
    }

    public static final class DeleteBucketResponseParser extends AbstractResponseParser<DeleteBucketResult> {
        public DeleteBucketResult parseData(ResponseMessage responseMessage, DeleteBucketResult deleteBucketResult) throws Exception {
            return deleteBucketResult;
        }
    }

    public static final class DeleteMultipleObjectResponseParser extends AbstractResponseParser<DeleteMultipleObjectResult> {
        /* access modifiers changed from: 0000 */
        public DeleteMultipleObjectResult parseData(ResponseMessage responseMessage, DeleteMultipleObjectResult deleteMultipleObjectResult) throws Exception {
            return ResponseParsers.parseDeleteMultipleObjectResponse(responseMessage.getContent(), deleteMultipleObjectResult);
        }
    }

    public static final class DeleteObjectResponseParser extends AbstractResponseParser<DeleteObjectResult> {
        public DeleteObjectResult parseData(ResponseMessage responseMessage, DeleteObjectResult deleteObjectResult) throws Exception {
            return deleteObjectResult;
        }
    }

    public static final class GetBucketACLResponseParser extends AbstractResponseParser<GetBucketACLResult> {
        public GetBucketACLResult parseData(ResponseMessage responseMessage, GetBucketACLResult getBucketACLResult) throws Exception {
            return ResponseParsers.parseGetBucketACLResponse(responseMessage.getContent(), getBucketACLResult);
        }
    }

    public static final class GetBucketInfoResponseParser extends AbstractResponseParser<GetBucketInfoResult> {
        public GetBucketInfoResult parseData(ResponseMessage responseMessage, GetBucketInfoResult getBucketInfoResult) throws Exception {
            return ResponseParsers.parseGetBucketInfoResponse(responseMessage.getContent(), getBucketInfoResult);
        }
    }

    public static final class GetObjectACLResponseParser extends AbstractResponseParser<GetObjectACLResult> {
        /* access modifiers changed from: 0000 */
        public GetObjectACLResult parseData(ResponseMessage responseMessage, GetObjectACLResult getObjectACLResult) throws Exception {
            return ResponseParsers.parseGetObjectACLResponse(responseMessage.getContent(), getObjectACLResult);
        }
    }

    public static final class GetObjectResponseParser extends AbstractResponseParser<GetObjectResult> {
        public boolean needCloseResponse() {
            return false;
        }

        public GetObjectResult parseData(ResponseMessage responseMessage, GetObjectResult getObjectResult) throws Exception {
            getObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(getObjectResult.getResponseHeader()));
            getObjectResult.setContentLength(responseMessage.getContentLength());
            if (responseMessage.getRequest().isCheckCRC64()) {
                CheckCRC64DownloadInputStream checkCRC64DownloadInputStream = new CheckCRC64DownloadInputStream(responseMessage.getContent(), new CRC64(), responseMessage.getContentLength(), getObjectResult.getServerCRC().longValue(), getObjectResult.getRequestId());
                getObjectResult.setObjectContent(checkCRC64DownloadInputStream);
            } else {
                getObjectResult.setObjectContent(responseMessage.getContent());
            }
            return getObjectResult;
        }
    }

    public static final class GetSymlinkResponseParser extends AbstractResponseParser<GetSymlinkResult> {
        /* access modifiers changed from: 0000 */
        public GetSymlinkResult parseData(ResponseMessage responseMessage, GetSymlinkResult getSymlinkResult) throws Exception {
            getSymlinkResult.setTargetObjectName((String) responseMessage.getHeaders().get(OSSHeaders.OSS_HEADER_SYMLINK_TARGET));
            return getSymlinkResult;
        }
    }

    public static final class HeadObjectResponseParser extends AbstractResponseParser<HeadObjectResult> {
        public HeadObjectResult parseData(ResponseMessage responseMessage, HeadObjectResult headObjectResult) throws Exception {
            headObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(headObjectResult.getResponseHeader()));
            return headObjectResult;
        }
    }

    public static final class ImagePersistResponseParser extends AbstractResponseParser<ImagePersistResult> {
        public ImagePersistResult parseData(ResponseMessage responseMessage, ImagePersistResult imagePersistResult) throws Exception {
            return imagePersistResult;
        }
    }

    public static final class InitMultipartResponseParser extends AbstractResponseParser<InitiateMultipartUploadResult> {
        public InitiateMultipartUploadResult parseData(ResponseMessage responseMessage, InitiateMultipartUploadResult initiateMultipartUploadResult) throws Exception {
            return ResponseParsers.parseInitMultipartResponseXML(responseMessage.getContent(), initiateMultipartUploadResult);
        }
    }

    public static final class ListBucketResponseParser extends AbstractResponseParser<ListBucketsResult> {
        /* access modifiers changed from: 0000 */
        public ListBucketsResult parseData(ResponseMessage responseMessage, ListBucketsResult listBucketsResult) throws Exception {
            return ResponseParsers.parseBucketListResponse(responseMessage.getContent(), listBucketsResult);
        }
    }

    public static final class ListMultipartUploadsResponseParser extends AbstractResponseParser<ListMultipartUploadsResult> {
        public ListMultipartUploadsResult parseData(ResponseMessage responseMessage, ListMultipartUploadsResult listMultipartUploadsResult) throws Exception {
            return listMultipartUploadsResult.parseData(responseMessage);
        }
    }

    public static final class ListObjectsResponseParser extends AbstractResponseParser<ListObjectsResult> {
        public ListObjectsResult parseData(ResponseMessage responseMessage, ListObjectsResult listObjectsResult) throws Exception {
            return ResponseParsers.parseObjectListResponse(responseMessage.getContent(), listObjectsResult);
        }
    }

    public static final class ListPartsResponseParser extends AbstractResponseParser<ListPartsResult> {
        public ListPartsResult parseData(ResponseMessage responseMessage, ListPartsResult listPartsResult) throws Exception {
            return ResponseParsers.parseListPartsResponseXML(responseMessage.getContent(), listPartsResult);
        }
    }

    public static final class PutObjectResponseParser extends AbstractResponseParser<PutObjectResult> {
        public PutObjectResult parseData(ResponseMessage responseMessage, PutObjectResult putObjectResult) throws IOException {
            putObjectResult.setETag(ResponseParsers.trimQuotes((String) responseMessage.getHeaders().get("ETag")));
            String string = responseMessage.getResponse().aXh().string();
            if (!TextUtils.isEmpty(string)) {
                putObjectResult.setServerCallbackReturnBody(string);
            }
            return putObjectResult;
        }
    }

    public static final class PutSymlinkResponseParser extends AbstractResponseParser<PutSymlinkResult> {
        /* access modifiers changed from: 0000 */
        public PutSymlinkResult parseData(ResponseMessage responseMessage, PutSymlinkResult putSymlinkResult) throws Exception {
            return putSymlinkResult;
        }
    }

    public static final class RestoreObjectResponseParser extends AbstractResponseParser<RestoreObjectResult> {
        /* access modifiers changed from: 0000 */
        public RestoreObjectResult parseData(ResponseMessage responseMessage, RestoreObjectResult restoreObjectResult) throws Exception {
            return restoreObjectResult;
        }
    }

    public static final class TriggerCallbackResponseParser extends AbstractResponseParser<TriggerCallbackResult> {
        public TriggerCallbackResult parseData(ResponseMessage responseMessage, TriggerCallbackResult triggerCallbackResult) throws Exception {
            String string = responseMessage.getResponse().aXh().string();
            if (!TextUtils.isEmpty(string)) {
                triggerCallbackResult.setServerCallbackReturnBody(string);
            }
            return triggerCallbackResult;
        }
    }

    public static final class UploadPartResponseParser extends AbstractResponseParser<UploadPartResult> {
        public UploadPartResult parseData(ResponseMessage responseMessage, UploadPartResult uploadPartResult) throws Exception {
            uploadPartResult.setETag(ResponseParsers.trimQuotes((String) responseMessage.getHeaders().get("ETag")));
            return uploadPartResult;
        }
    }

    /* access modifiers changed from: private */
    public static ListBucketsResult parseBucketListResponse(InputStream inputStream, ListBucketsResult listBucketsResult) throws Exception {
        listBucketsResult.clearBucketList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        OSSBucketSummary oSSBucketSummary = null;
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (name != null) {
                        if (!"Prefix".equals(name)) {
                            if (!"Marker".equals(name)) {
                                if (!"MaxKeys".equals(name)) {
                                    if (!"IsTruncated".equals(name)) {
                                        if (!"NextMarker".equals(name)) {
                                            if (!AppStateModel.COUNTRY_CODE_Indonesia.equals(name)) {
                                                if (!"DisplayName".equals(name)) {
                                                    if (!"Bucket".equals(name)) {
                                                        if (!"CreationDate".equals(name)) {
                                                            if (!"ExtranetEndpoint".equals(name)) {
                                                                if (!"IntranetEndpoint".equals(name)) {
                                                                    if (!"Location".equals(name)) {
                                                                        if (!"Name".equals(name)) {
                                                                            if (CreateBucketRequest.TAB_STORAGECLASS.equals(name) && oSSBucketSummary != null) {
                                                                                oSSBucketSummary.storageClass = newPullParser.nextText();
                                                                                break;
                                                                            }
                                                                        } else if (oSSBucketSummary != null) {
                                                                            oSSBucketSummary.name = newPullParser.nextText();
                                                                            break;
                                                                        }
                                                                    } else if (oSSBucketSummary != null) {
                                                                        oSSBucketSummary.location = newPullParser.nextText();
                                                                        break;
                                                                    }
                                                                } else if (oSSBucketSummary != null) {
                                                                    oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                                                                    break;
                                                                }
                                                            } else if (oSSBucketSummary != null) {
                                                                oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                                                                break;
                                                            }
                                                        } else if (oSSBucketSummary != null) {
                                                            oSSBucketSummary.createDate = DateUtil.parseIso8601Date(newPullParser.nextText());
                                                            break;
                                                        }
                                                    } else {
                                                        oSSBucketSummary = new OSSBucketSummary();
                                                        break;
                                                    }
                                                } else {
                                                    listBucketsResult.setOwnerDisplayName(newPullParser.nextText());
                                                    break;
                                                }
                                            } else {
                                                listBucketsResult.setOwnerId(newPullParser.nextText());
                                                break;
                                            }
                                        } else {
                                            listBucketsResult.setNextMarker(newPullParser.nextText());
                                            break;
                                        }
                                    } else {
                                        String nextText = newPullParser.nextText();
                                        if (nextText != null) {
                                            listBucketsResult.setTruncated(Boolean.valueOf(nextText).booleanValue());
                                            break;
                                        }
                                    }
                                } else {
                                    String nextText2 = newPullParser.nextText();
                                    if (nextText2 != null) {
                                        listBucketsResult.setMaxKeys(Integer.valueOf(nextText2).intValue());
                                        break;
                                    }
                                }
                            } else {
                                listBucketsResult.setMarker(newPullParser.nextText());
                                break;
                            }
                        } else {
                            listBucketsResult.setPrefix(newPullParser.nextText());
                            break;
                        }
                    }
                    break;
                case 3:
                    if ("Bucket".equals(newPullParser.getName()) && oSSBucketSummary != null) {
                        listBucketsResult.addBucket(oSSBucketSummary);
                        break;
                    }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listBucketsResult;
    }

    /* access modifiers changed from: private */
    public static CompleteMultipartUploadResult parseCompleteMultipartUploadResponseXML(InputStream inputStream, CompleteMultipartUploadResult completeMultipartUploadResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Location".equals(name)) {
                    completeMultipartUploadResult.setLocation(newPullParser.nextText());
                } else if ("Bucket".equals(name)) {
                    completeMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    completeMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    completeMultipartUploadResult.setETag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static CopyObjectResult parseCopyObjectResponseXML(InputStream inputStream, CopyObjectResult copyObjectResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LastModified".equals(name)) {
                    copyObjectResult.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if ("ETag".equals(name)) {
                    copyObjectResult.setEtag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return copyObjectResult;
    }

    /* access modifiers changed from: private */
    public static DeleteMultipleObjectResult parseDeleteMultipleObjectResponse(InputStream inputStream, DeleteMultipleObjectResult deleteMultipleObjectResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if ("Key".equals(newPullParser.getName())) {
                    deleteMultipleObjectResult.addDeletedObject(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return deleteMultipleObjectResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketACLResult parseGetBucketACLResponse(InputStream inputStream, GetBucketACLResult getBucketACLResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getBucketACLResult.setBucketACL(newPullParser.nextText());
                } else if (AppStateModel.COUNTRY_CODE_Indonesia.equals(name)) {
                    getBucketACLResult.setBucketOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getBucketACLResult.setBucketOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketACLResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketInfoResult parseGetBucketInfoResponse(InputStream inputStream, GetBucketInfoResult getBucketInfoResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        OSSBucketSummary oSSBucketSummary = null;
        Owner owner = null;
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (name != null) {
                        if (!"Owner".equals(name)) {
                            if (!AppStateModel.COUNTRY_CODE_Indonesia.equals(name)) {
                                if (!"DisplayName".equals(name)) {
                                    if (!"Bucket".equals(name)) {
                                        if (!"CreationDate".equals(name)) {
                                            if (!"ExtranetEndpoint".equals(name)) {
                                                if (!"IntranetEndpoint".equals(name)) {
                                                    if (!"Location".equals(name)) {
                                                        if (!"Name".equals(name)) {
                                                            if (!CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                                                                if ("Grant".equals(name) && oSSBucketSummary != null) {
                                                                    oSSBucketSummary.setAcl(newPullParser.nextText());
                                                                    break;
                                                                }
                                                            } else if (oSSBucketSummary != null) {
                                                                oSSBucketSummary.storageClass = newPullParser.nextText();
                                                                break;
                                                            }
                                                        } else if (oSSBucketSummary != null) {
                                                            oSSBucketSummary.name = newPullParser.nextText();
                                                            break;
                                                        }
                                                    } else if (oSSBucketSummary != null) {
                                                        oSSBucketSummary.location = newPullParser.nextText();
                                                        break;
                                                    }
                                                } else if (oSSBucketSummary != null) {
                                                    oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                                                    break;
                                                }
                                            } else if (oSSBucketSummary != null) {
                                                oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                                                break;
                                            }
                                        } else if (oSSBucketSummary != null) {
                                            oSSBucketSummary.createDate = DateUtil.parseIso8601Date(newPullParser.nextText());
                                            break;
                                        }
                                    } else {
                                        oSSBucketSummary = new OSSBucketSummary();
                                        break;
                                    }
                                } else if (owner != null) {
                                    owner.setDisplayName(newPullParser.nextText());
                                    break;
                                }
                            } else if (owner != null) {
                                owner.setId(newPullParser.nextText());
                                break;
                            }
                        } else {
                            owner = new Owner();
                            break;
                        }
                    }
                    break;
                case 3:
                    String name2 = newPullParser.getName();
                    if (name2 != null) {
                        if (!"Bucket".equals(name2)) {
                            if ("Owner".equals(name2) && oSSBucketSummary != null) {
                                oSSBucketSummary.owner = owner;
                                break;
                            }
                        } else if (oSSBucketSummary != null) {
                            getBucketInfoResult.setBucket(oSSBucketSummary);
                            break;
                        }
                    }
                    break;
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketInfoResult;
    }

    /* access modifiers changed from: private */
    public static GetObjectACLResult parseGetObjectACLResponse(InputStream inputStream, GetObjectACLResult getObjectACLResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getObjectACLResult.setObjectACL(newPullParser.nextText());
                } else if (AppStateModel.COUNTRY_CODE_Indonesia.equals(name)) {
                    getObjectACLResult.setObjectOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getObjectACLResult.setObjectOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getObjectACLResult;
    }

    /* access modifiers changed from: private */
    public static InitiateMultipartUploadResult parseInitMultipartResponseXML(InputStream inputStream, InitiateMultipartUploadResult initiateMultipartUploadResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    initiateMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    initiateMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    initiateMultipartUploadResult.setUploadId(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return initiateMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static ListPartsResult parseListPartsResponseXML(InputStream inputStream, ListPartsResult listPartsResult) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        PartSummary partSummary = null;
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"Bucket".equals(name)) {
                        if (!"Key".equals(name)) {
                            if (!"UploadId".equals(name)) {
                                if (!"PartNumberMarker".equals(name)) {
                                    if (!"NextPartNumberMarker".equals(name)) {
                                        if (!"MaxParts".equals(name)) {
                                            if (!"IsTruncated".equals(name)) {
                                                if (!CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                                                    if (!"Part".equals(name)) {
                                                        if (!"PartNumber".equals(name)) {
                                                            if (!"LastModified".equals(name)) {
                                                                if (!"ETag".equals(name)) {
                                                                    if (SocialServiceDef.EXTRAS_UPGRADE_SIZE.equals(name)) {
                                                                        String nextText = newPullParser.nextText();
                                                                        if (!OSSUtils.isEmptyString(nextText)) {
                                                                            partSummary.setSize(Long.valueOf(nextText).longValue());
                                                                            break;
                                                                        }
                                                                    }
                                                                } else {
                                                                    partSummary.setETag(newPullParser.nextText());
                                                                    break;
                                                                }
                                                            } else {
                                                                partSummary.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                                                                break;
                                                            }
                                                        } else {
                                                            String nextText2 = newPullParser.nextText();
                                                            if (!OSSUtils.isEmptyString(nextText2)) {
                                                                partSummary.setPartNumber(Integer.valueOf(nextText2).intValue());
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        partSummary = new PartSummary();
                                                        break;
                                                    }
                                                } else {
                                                    listPartsResult.setStorageClass(newPullParser.nextText());
                                                    break;
                                                }
                                            } else {
                                                String nextText3 = newPullParser.nextText();
                                                if (!OSSUtils.isEmptyString(nextText3)) {
                                                    listPartsResult.setTruncated(Boolean.valueOf(nextText3).booleanValue());
                                                    break;
                                                }
                                            }
                                        } else {
                                            String nextText4 = newPullParser.nextText();
                                            if (!OSSUtils.isEmptyString(nextText4)) {
                                                listPartsResult.setMaxParts(Integer.parseInt(nextText4));
                                                break;
                                            }
                                        }
                                    } else {
                                        String nextText5 = newPullParser.nextText();
                                        if (!OSSUtils.isEmptyString(nextText5)) {
                                            listPartsResult.setNextPartNumberMarker(Integer.parseInt(nextText5));
                                            break;
                                        }
                                    }
                                } else {
                                    String nextText6 = newPullParser.nextText();
                                    if (!OSSUtils.isEmptyString(nextText6)) {
                                        listPartsResult.setPartNumberMarker(Integer.parseInt(nextText6));
                                        break;
                                    }
                                }
                            } else {
                                listPartsResult.setUploadId(newPullParser.nextText());
                                break;
                            }
                        } else {
                            listPartsResult.setKey(newPullParser.nextText());
                            break;
                        }
                    } else {
                        listPartsResult.setBucketName(newPullParser.nextText());
                        break;
                    }
                    break;
                case 3:
                    if ("Part".equals(newPullParser.getName())) {
                        arrayList.add(partSummary);
                        break;
                    }
                    break;
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            listPartsResult.setParts(arrayList);
        }
        return listPartsResult;
    }

    /* access modifiers changed from: private */
    public static ListObjectsResult parseObjectListResponse(InputStream inputStream, ListObjectsResult listObjectsResult) throws Exception {
        listObjectsResult.clearCommonPrefixes();
        listObjectsResult.clearObjectSummaries();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        Owner owner = null;
        OSSObjectSummary oSSObjectSummary = null;
        boolean z = false;
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"Name".equals(name)) {
                        if (!"Prefix".equals(name)) {
                            if (!"Marker".equals(name)) {
                                if (!"Delimiter".equals(name)) {
                                    if (!"EncodingType".equals(name)) {
                                        if (!"MaxKeys".equals(name)) {
                                            if (!"NextMarker".equals(name)) {
                                                if (!"IsTruncated".equals(name)) {
                                                    if (!"Contents".equals(name)) {
                                                        if (!"Key".equals(name)) {
                                                            if (!"LastModified".equals(name)) {
                                                                if (!SocialServiceDef.EXTRAS_UPGRADE_SIZE.equals(name)) {
                                                                    if (!"ETag".equals(name)) {
                                                                        if (!"Type".equals(name)) {
                                                                            if (!CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                                                                                if (!"Owner".equals(name)) {
                                                                                    if (!AppStateModel.COUNTRY_CODE_Indonesia.equals(name)) {
                                                                                        if (!"DisplayName".equals(name)) {
                                                                                            if ("CommonPrefixes".equals(name)) {
                                                                                                z = true;
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            owner.setDisplayName(newPullParser.nextText());
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        owner.setId(newPullParser.nextText());
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    owner = new Owner();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                oSSObjectSummary.setStorageClass(newPullParser.nextText());
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            oSSObjectSummary.setType(newPullParser.nextText());
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        oSSObjectSummary.setETag(newPullParser.nextText());
                                                                        break;
                                                                    }
                                                                } else {
                                                                    String nextText = newPullParser.nextText();
                                                                    if (!OSSUtils.isEmptyString(nextText)) {
                                                                        oSSObjectSummary.setSize(Long.valueOf(nextText).longValue());
                                                                        break;
                                                                    }
                                                                }
                                                            } else {
                                                                oSSObjectSummary.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                                                                break;
                                                            }
                                                        } else {
                                                            oSSObjectSummary.setKey(newPullParser.nextText());
                                                            break;
                                                        }
                                                    } else {
                                                        oSSObjectSummary = new OSSObjectSummary();
                                                        break;
                                                    }
                                                } else {
                                                    String nextText2 = newPullParser.nextText();
                                                    if (!OSSUtils.isEmptyString(nextText2)) {
                                                        listObjectsResult.setTruncated(Boolean.valueOf(nextText2).booleanValue());
                                                        break;
                                                    }
                                                }
                                            } else {
                                                listObjectsResult.setNextMarker(newPullParser.nextText());
                                                break;
                                            }
                                        } else {
                                            String nextText3 = newPullParser.nextText();
                                            if (!OSSUtils.isEmptyString(nextText3)) {
                                                listObjectsResult.setMaxKeys(Integer.valueOf(nextText3).intValue());
                                                break;
                                            }
                                        }
                                    } else {
                                        listObjectsResult.setEncodingType(newPullParser.nextText());
                                        break;
                                    }
                                } else {
                                    listObjectsResult.setDelimiter(newPullParser.nextText());
                                    break;
                                }
                            } else {
                                listObjectsResult.setMarker(newPullParser.nextText());
                                break;
                            }
                        } else if (!z) {
                            listObjectsResult.setPrefix(newPullParser.nextText());
                            break;
                        } else {
                            String nextText4 = newPullParser.nextText();
                            if (!OSSUtils.isEmptyString(nextText4)) {
                                listObjectsResult.addCommonPrefix(nextText4);
                                break;
                            }
                        }
                    } else {
                        listObjectsResult.setBucketName(newPullParser.nextText());
                        break;
                    }
                    break;
                case 3:
                    String name2 = newPullParser.getName();
                    if (!"Owner".equals(newPullParser.getName())) {
                        if (!"Contents".equals(name2)) {
                            if ("CommonPrefixes".equals(name2)) {
                                z = false;
                                break;
                            }
                        } else if (oSSObjectSummary != null) {
                            oSSObjectSummary.setBucketName(listObjectsResult.getBucketName());
                            listObjectsResult.addObjectSummary(oSSObjectSummary);
                            break;
                        }
                    } else if (owner != null) {
                        oSSObjectSummary.setOwner(owner);
                        break;
                    }
                    break;
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listObjectsResult;
    }

    public static ObjectMetadata parseObjectMetadata(Map<String, String> map) throws Exception {
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            for (String str : map.keySet()) {
                if (str.indexOf(OSSHeaders.OSS_USER_METADATA_PREFIX) >= 0) {
                    objectMetadata.addUserMetadata(str, (String) map.get(str));
                } else {
                    if (!str.equalsIgnoreCase("Last-Modified")) {
                        if (!str.equalsIgnoreCase("Date")) {
                            if (str.equalsIgnoreCase("Content-Length")) {
                                objectMetadata.setHeader(str, Long.valueOf((String) map.get(str)));
                            } else if (str.equalsIgnoreCase("ETag")) {
                                objectMetadata.setHeader(str, trimQuotes((String) map.get(str)));
                            } else {
                                objectMetadata.setHeader(str, map.get(str));
                            }
                        }
                    }
                    objectMetadata.setHeader(str, DateUtil.parseRfc822Date((String) map.get(str)));
                }
            }
            return objectMetadata;
        } catch (ParseException e) {
            throw new IOException(e.getMessage(), e);
        } catch (Exception e2) {
            throw new IOException(e2.getMessage(), e2);
        }
    }

    public static ServiceException parseResponseErrorXML(ResponseMessage responseMessage, boolean z) throws ClientException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int statusCode = responseMessage.getStatusCode();
        String sM = responseMessage.getResponse().mo37778sM(OSSHeaders.OSS_HEADER_REQUEST_ID);
        String str7 = null;
        if (!z) {
            try {
                String string = responseMessage.getResponse().aXh().string();
                StringBuilder sb = new StringBuilder();
                sb.append("errorMessage  ：  \n ");
                sb.append(string);
                OSSLog.logDebug(sb.toString());
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                int eventType = newPullParser.getEventType();
                String str8 = null;
                str4 = null;
                String str9 = null;
                str2 = null;
                while (eventType != 1) {
                    if (eventType == 2) {
                        if ("Code".equals(newPullParser.getName())) {
                            str7 = newPullParser.nextText();
                        } else if (SocialConstDef.TBL_NAME_MESSAGE.equals(newPullParser.getName())) {
                            str8 = newPullParser.nextText();
                        } else if ("RequestId".equals(newPullParser.getName())) {
                            sM = newPullParser.nextText();
                        } else if ("HostId".equals(newPullParser.getName())) {
                            str4 = newPullParser.nextText();
                        } else if ("PartNumber".equals(newPullParser.getName())) {
                            str9 = newPullParser.nextText();
                        } else if ("PartEtag".equals(newPullParser.getName())) {
                            str2 = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
                str6 = str7;
                str7 = str8;
                str5 = sM;
                String str10 = str9;
                str3 = string;
                str = str10;
            } catch (IOException e) {
                throw new ClientException((Throwable) e);
            } catch (XmlPullParserException e2) {
                throw new ClientException((Throwable) e2);
            }
        } else {
            str5 = sM;
            str = null;
            str6 = null;
            str4 = null;
            str3 = null;
            str2 = null;
        }
        ServiceException serviceException = new ServiceException(statusCode, str7, str6, str5, str4, str3);
        if (!TextUtils.isEmpty(str2)) {
            serviceException.setPartEtag(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            serviceException.setPartNumber(str);
        }
        return serviceException;
    }

    public static String trimQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        if (trim.endsWith("\"")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        return trim;
    }
}
