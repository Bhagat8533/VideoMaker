package com.introvd.template.datacenter.social.publish;

import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;
import org.json.JSONObject;

public class PublishTaskInfo {
    public static final int PROGRESS_ALL_SUCC = 100;
    public static final int PROGRESS_APPLY = 0;
    public static final int PROGRESS_EXPROT_SUCC = 20;
    public static final int PROGRESS_PROJECT_SUCC = 25;
    public static final int PROGRESS_THUMB_SUCC = 30;
    public static final int PROGRESS_VIDEO_SUCC = 70;
    public static final int STATE_FAIL = 3;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PAUSE = 1;
    public static final int STATE_PAUSE_MANUAL = 2;
    public static final int STATE_SUCCESS = 4;
    public static final int STEP_UPLOAD_COMPLATE = 3;
    public static final int STEP_UPLOAD_EXPORT = 0;
    public static final int STEP_UPLOAD_OLD_NEW = -1;
    public static final int STEP_UPLOAD_PROJECT = 4;
    public static final int STEP_UPLOAD_THUMBNAIL = 1;
    public static final int STEP_UPLOAD_VIDEO = 2;
    public static final int VIDEO_TYPE_APPLY = 1;
    public static final int VIDEO_TYPE_NORMAL = 0;
    public long _id;
    public String desc;
    public String files_upload;
    public String oldData;
    public String prjUrl;
    public int progress;
    public String puiddigest;
    public long startTime;
    public int state;
    public int step;
    public String strCoverUrl;
    public String strVideoUrl;
    public String thumbUrl;
    public String title;
    public int videoDuration;
    public int videoHeight;
    public String videoLocal;
    public int videoType;
    public int videoWidth;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String desc;
        /* access modifiers changed from: private */
        public String files_upload;
        /* access modifiers changed from: private */
        public String oldData;
        /* access modifiers changed from: private */
        public String prjUrl;
        /* access modifiers changed from: private */
        public int progress;
        /* access modifiers changed from: private */
        public String puiddigest;
        /* access modifiers changed from: private */
        public long startTime;
        /* access modifiers changed from: private */
        public int state;
        /* access modifiers changed from: private */
        public int step;
        /* access modifiers changed from: private */
        public String strCoverUrl;
        /* access modifiers changed from: private */
        public String strVideoUrl;
        /* access modifiers changed from: private */
        public String thumbUrl;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public int videoDuration;
        /* access modifiers changed from: private */
        public int videoHeight;
        /* access modifiers changed from: private */
        public String videoLocal;
        /* access modifiers changed from: private */
        public int videoType;
        /* access modifiers changed from: private */
        public int videoWidth;

        public PublishTaskInfo build() {
            return new PublishTaskInfo(this);
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder files_upload(String str) {
            this.files_upload = str;
            return this;
        }

        public Builder oldData(String str) {
            this.oldData = str;
            return this;
        }

        public Builder prjUrl(String str) {
            this.prjUrl = str;
            return this;
        }

        public Builder progress(int i) {
            this.progress = i;
            return this;
        }

        public Builder puiddigest(String str) {
            this.puiddigest = str;
            return this;
        }

        public Builder startTime(long j) {
            this.startTime = j;
            return this;
        }

        public Builder state(int i) {
            this.state = i;
            return this;
        }

        public Builder step(int i) {
            this.step = i;
            return this;
        }

        public Builder strCoverUrl(String str) {
            this.strCoverUrl = str;
            return this;
        }

        public Builder strVideoUrl(String str) {
            this.strVideoUrl = str;
            return this;
        }

        public Builder thumbUrl(String str) {
            this.thumbUrl = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder videoDuration(int i) {
            this.videoDuration = i;
            return this;
        }

        public Builder videoHeight(int i) {
            this.videoHeight = i;
            return this;
        }

        public Builder videoLocal(String str) {
            this.videoLocal = str;
            return this;
        }

        public Builder videoType(int i) {
            this.videoType = i;
            return this;
        }

        public Builder videoWidth(int i) {
            this.videoWidth = i;
            return this;
        }
    }

    public PublishTaskInfo() {
        this.puiddigest = "";
        this.prjUrl = "";
        this.title = "";
        this.desc = "";
        this.strCoverUrl = "";
        this.strVideoUrl = "";
        this.thumbUrl = "";
        this.videoLocal = "";
        this.files_upload = "";
        this.oldData = "";
    }

    private PublishTaskInfo(Builder builder) {
        this.puiddigest = "";
        this.prjUrl = "";
        this.title = "";
        this.desc = "";
        this.strCoverUrl = "";
        this.strVideoUrl = "";
        this.thumbUrl = "";
        this.videoLocal = "";
        this.files_upload = "";
        this.oldData = "";
        this.puiddigest = builder.puiddigest;
        this.prjUrl = builder.prjUrl;
        this.title = builder.title;
        this.desc = builder.desc;
        this.strCoverUrl = builder.strCoverUrl;
        this.strVideoUrl = builder.strVideoUrl;
        this.thumbUrl = builder.thumbUrl;
        this.videoLocal = builder.videoLocal;
        this.videoType = builder.videoType;
        this.files_upload = builder.files_upload;
        this.progress = builder.progress;
        this.step = builder.step;
        this.state = builder.state;
        this.videoDuration = builder.videoDuration;
        this.startTime = builder.startTime;
        this.oldData = builder.oldData;
        this.videoWidth = builder.videoWidth;
        this.videoHeight = builder.videoHeight;
    }

    public void initOldData(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        String str13;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("language", TextUtils.isEmpty(str) ? "" : str);
            jSONObject.put(SocialConstDef.RECOMMEND_USER_LIST_TAGS, TextUtils.isEmpty(str2) ? "" : str2);
            String str14 = "shoottime";
            if (TextUtils.isEmpty(str3)) {
                str13 = "";
            } else {
                String str15 = str3;
                str13 = str3.replaceAll(":", "").replaceAll("-", "").replaceAll(" ", "");
            }
            jSONObject.put(str14, str13);
            jSONObject.put("coverTitle", TextUtils.isEmpty(str4) ? "" : str4);
            jSONObject.put("videoTitle", TextUtils.isEmpty(str5) ? "" : str5);
            int i2 = i;
            jSONObject.put("permitType", i);
            jSONObject.put("addrName", TextUtils.isEmpty(str6) ? "" : str6);
            jSONObject.put("addrDetail", TextUtils.isEmpty(str7) ? "" : str7);
            jSONObject.put("addrPrecision", TextUtils.isEmpty(str8) ? "" : str8);
            jSONObject.put("longitude", TextUtils.isEmpty(str9) ? "" : str9);
            jSONObject.put("latitude", TextUtils.isEmpty(str10) ? "" : str10);
            jSONObject.put("ayiddigest", TextUtils.isEmpty(str11) ? "" : str11);
            jSONObject.put("activityKeyword", TextUtils.isEmpty(str12) ? "" : str12);
            try {
                this.oldData = jSONObject.toString();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublishTaskInfo{_id=");
        sb.append(this._id);
        sb.append(", puiddigest='");
        sb.append(this.puiddigest);
        sb.append('\'');
        sb.append(", prjUrl='");
        sb.append(this.prjUrl);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", strCoverUrl='");
        sb.append(this.strCoverUrl);
        sb.append('\'');
        sb.append(", strVideoUrl='");
        sb.append(this.strVideoUrl);
        sb.append('\'');
        sb.append(", thumbUrl='");
        sb.append(this.thumbUrl);
        sb.append('\'');
        sb.append(", videoLocal='");
        sb.append(this.videoLocal);
        sb.append('\'');
        sb.append(", videoType=");
        sb.append(this.videoType);
        sb.append(", files_upload='");
        sb.append(this.files_upload);
        sb.append('\'');
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", step=");
        sb.append(this.step);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", videoDuration=");
        sb.append(this.videoDuration);
        sb.append(", startTime=");
        sb.append(this.startTime);
        sb.append(", oldData='");
        sb.append(this.oldData);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.videoWidth);
        sb.append(", height=");
        sb.append(this.videoHeight);
        sb.append('}');
        return sb.toString();
    }
}
