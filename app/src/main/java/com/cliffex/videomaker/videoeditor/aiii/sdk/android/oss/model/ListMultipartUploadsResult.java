package com.aiii.sdk.android.oss.model;

import android.util.Xml;
import com.aiii.sdk.android.oss.common.utils.DateUtil;
import com.aiii.sdk.android.oss.common.utils.OSSUtils;
import com.aiii.sdk.android.oss.internal.ResponseMessage;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class ListMultipartUploadsResult extends OSSResult {
    private String bucketName;
    private List<String> commonPrefixes = new ArrayList();
    private String delimiter;
    private boolean isTruncated;
    private String keyMarker;
    private int maxUploads;
    private List<MultipartUpload> multipartUploads = new ArrayList();
    private String nextKeyMarker;
    private String nextUploadIdMarker;
    private String prefix;
    private String uploadIdMarker;

    public void addCommonPrefix(String str) {
        this.commonPrefixes.add(str);
    }

    public void addMultipartUpload(MultipartUpload multipartUpload) {
        this.multipartUploads.add(multipartUpload);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public List<MultipartUpload> getMultipartUploads() {
        return this.multipartUploads;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListMultipartUploadsResult parseData(ResponseMessage responseMessage) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(responseMessage.getContent(), "utf-8");
        int eventType = newPullParser.getEventType();
        MultipartUpload multipartUpload = null;
        boolean z = false;
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (!"Bucket".equals(name)) {
                        if (!"Delimiter".equals(name)) {
                            if (!"Prefix".equals(name)) {
                                if (!"MaxUploads".equals(name)) {
                                    if (!"IsTruncated".equals(name)) {
                                        if (!"KeyMarker".equals(name)) {
                                            if (!"UploadIdMarker".equals(name)) {
                                                if (!"NextKeyMarker".equals(name)) {
                                                    if (!"NextUploadIdMarker".equals(name)) {
                                                        if (!"Upload".equals(name)) {
                                                            if (!"Key".equals(name)) {
                                                                if (!"UploadId".equals(name)) {
                                                                    if (!"Initiated".equals(name)) {
                                                                        if (!CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                                                                            if ("CommonPrefixes".equals(name)) {
                                                                                z = true;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            multipartUpload.setStorageClass(newPullParser.nextText());
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        multipartUpload.setInitiated(DateUtil.parseIso8601Date(newPullParser.nextText()));
                                                                        break;
                                                                    }
                                                                } else {
                                                                    multipartUpload.setUploadId(newPullParser.nextText());
                                                                    break;
                                                                }
                                                            } else {
                                                                multipartUpload.setKey(newPullParser.nextText());
                                                                break;
                                                            }
                                                        } else {
                                                            multipartUpload = new MultipartUpload();
                                                            break;
                                                        }
                                                    } else {
                                                        setNextUploadIdMarker(newPullParser.nextText());
                                                        break;
                                                    }
                                                } else {
                                                    setNextKeyMarker(newPullParser.nextText());
                                                    break;
                                                }
                                            } else {
                                                setUploadIdMarker(newPullParser.nextText());
                                                break;
                                            }
                                        } else {
                                            setKeyMarker(newPullParser.nextText());
                                            break;
                                        }
                                    } else {
                                        String nextText = newPullParser.nextText();
                                        if (!OSSUtils.isEmptyString(nextText)) {
                                            setTruncated(Boolean.valueOf(nextText).booleanValue());
                                            break;
                                        }
                                    }
                                } else {
                                    String nextText2 = newPullParser.nextText();
                                    if (!OSSUtils.isEmptyString(nextText2)) {
                                        setMaxUploads(Integer.valueOf(nextText2).intValue());
                                        break;
                                    }
                                }
                            } else if (!z) {
                                setPrefix(newPullParser.nextText());
                                break;
                            } else {
                                String nextText3 = newPullParser.nextText();
                                if (!OSSUtils.isEmptyString(nextText3)) {
                                    addCommonPrefix(nextText3);
                                    break;
                                }
                            }
                        } else {
                            setDelimiter(newPullParser.nextText());
                            break;
                        }
                    } else {
                        setBucketName(newPullParser.nextText());
                        break;
                    }
                    break;
                case 3:
                    if (!"Upload".equals(newPullParser.getName())) {
                        if ("CommonPrefixes".equals(newPullParser.getName())) {
                            z = false;
                            break;
                        }
                    } else {
                        arrayList.add(multipartUpload);
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
            setMultipartUploads(arrayList);
        }
        return this;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes.clear();
        if (list != null && !list.isEmpty()) {
            this.commonPrefixes.addAll(list);
        }
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(int i) {
        this.maxUploads = i;
    }

    public void setMultipartUploads(List<MultipartUpload> list) {
        this.multipartUploads.clear();
        if (list != null && !list.isEmpty()) {
            this.multipartUploads.addAll(list);
        }
    }

    public void setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
    }

    public void setNextUploadIdMarker(String str) {
        this.nextUploadIdMarker = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadIdMarker(String str) {
        this.uploadIdMarker = str;
    }
}
